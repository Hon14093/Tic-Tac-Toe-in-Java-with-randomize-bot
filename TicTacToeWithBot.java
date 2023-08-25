import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe_2{
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> botPositions = new ArrayList<Integer>();
	
    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                              {'-', '+', '-', '+', '-'},
                              {' ', '|', ' ', '|', ' '},
                              {'-', '+', '-', '+', '-'},
                              {' ', '|', ' ', '|', ' '}};
        
        printGameBoard(gameBoard);
        checkPlacement(gameBoard);
        
    }
    
    public static void checkPlacement(char[][] gameBoard) {
    	while (true) {
        	Scanner sc = new Scanner(System.in);
        	
        	// check player's placement
        	System.out.println("Enter your position (1-9): ");
            int playerPos = sc.nextInt();
            System.out.println(playerPos);
            
            while (playerPositions.contains(playerPos) || botPositions.contains(playerPos)) {
            	System.out.println("Position taken! Enter a correct position: ");
            	playerPos = sc.nextInt();
            }
            placePiece(gameBoard, playerPos, "player");
            
            String winner = checkWinner();
            if (winner.length() > 0) {
            	System.out.println(winner);
            	break;
            }
            
            
            // check bot's placement
            Random random = new Random();
            int botPos = random.nextInt(9)+1;
            while (playerPositions.contains(botPos) || botPositions.contains(botPos)) {
            	//System.out.println("bot bot");
            	botPos = random.nextInt(9)+1;
            }
            placePiece(gameBoard, botPos, "bot");
            
            printGameBoard(gameBoard);
            
            winner = checkWinner();
            if (winner.length() > 0) {
            	System.out.println(winner);
            	break;
            }
            
        }
    }
    
    public static void printGameBoard(char[][] gameBoard) {
    	for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    
    public static void placePiece(char[][] gameBoard, int pos, String user) {
    	char symbol = ' ';
    	
    	if (user.equals("player")) {
    		symbol = 'X';
    		playerPositions.add(pos);
    	} else if (user.equals("bot")) {
    		symbol = 'O';
    		botPositions.add(pos);
    	}
    	
    	switch (pos) {
	    	case 1:
	    		gameBoard[0][0] = symbol;
	    		break;
	    	case 2:
	    		gameBoard[0][2] = symbol;
	    		break;
	    	case 3:
	    		gameBoard[0][4] = symbol;
	    		break;
	    	case 4:
	    		gameBoard[2][0] = symbol;
	    		break;
	    	case 5:
	    		gameBoard[2][2] = symbol;
	    		break;
	    	case 6:
	    		gameBoard[2][4] = symbol;
	    		break;
	    	case 7:
	    		gameBoard[4][0] = symbol;
	    		break;
	    	case 8:
	    		gameBoard[4][2] = symbol;
	    		break;
	    	case 9:
	    		gameBoard[4][4] = symbol;
	    		break;
	    	default:
	    		break;
    	}
    	
    }
    
    public static String checkWinner() {
    	
    	List topRow = Arrays.asList(1,2,3);
    	List middleRow = Arrays.asList(4,5,6);
    	List bottomRpw = Arrays.asList(7,8,9);
    	
    	List leftCol = Arrays.asList(1,4,7);
    	List middleCol = Arrays.asList(2,5,8);
    	List rightCol = Arrays.asList(3,6,9);
    	
    	List cross1 = Arrays.asList(1,5,9);
    	List cross2 = Arrays.asList(3,5,7);
    	
    	List<List> winConditions = new ArrayList<List>();
    	winConditions.add(topRow);
    	winConditions.add(middleRow);
    	winConditions.add(bottomRpw);
    	winConditions.add(leftCol);
    	winConditions.add(middleCol);
    	winConditions.add(rightCol);
    	winConditions.add(cross2);
    	winConditions.add(cross1);
    	
    	for (List l : winConditions) {
    		if (playerPositions.containsAll(l)) {
    			return "Congrats! You won!";
    		} else if (botPositions.containsAll(l)) {
    			return "Bot won";
    		} else if (playerPositions.size() + botPositions.size() == 9) {
    			return "Draw";
    		}
    	}
    	
    	return "";
    }
}
