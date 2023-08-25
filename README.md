# Tic-Tac-Toe-in-Java-with-randomize-bot

## Functions Explanations
- ArrayList playerPositions
- ArrayList botPositions
- `printGameBoard()`
- `placePiece()`
  - First check if placement is made by player or bot.
  - Assign `char symbol` = 'X' for player or 'O' for bot.
  - Using `switch() case` to place the appropriate position on game board.
- `checkWinner()`
  - Create 8 predetermined Lists for wining positions.
  - Create another List containing 8 Lists above.
  - Using a `for()` loop to check if player or bot wins or draw.
- `checkPlacement()`
  - Using a `while(true)` loop until there is a winner or a draw.
    - Check input from player in a `while` loop: if playerPositions already contains player's input or botPositions already contains player's input.
    - If true: ask player to input a different position.
    - If false: continue to `placePiece()`.
    - Then execute `checkWinner()`: if true, break out of `while(true)` loop and stop.
    - Do the same with input from bot.
