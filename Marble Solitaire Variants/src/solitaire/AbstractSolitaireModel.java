package solitaire;

/**
 * This abstract class provides a skeletal implementation of the SolitaireModel interface
 * to minimize the effort required to implement different variants of the Marble Solitaire game.
 */
public abstract class AbstractSolitaireModel implements SolitaireModel {
  protected Slot[][] board;
  protected int marbleCount;

  /**
   * Constructs an AbstractSolitaireModel with a given board size and an empty slot position.
   *
   * @param boardSize the size of the board
   * @param emptyRow  the row index of the initial empty slot
   * @param emptyCol  the column index of the initial empty slot
   * @throws IllegalArgumentException if the initial position is invalid
   */
  public AbstractSolitaireModel(int boardSize, int emptyRow, int emptyCol) {
    board = new Slot[boardSize][boardSize];
    initializeBoard(emptyRow, emptyCol);
  }

  /**
   * Checks if a position is part of the valid shape for the specific solitaire variant.
   *
   * @param row the row index
   * @param col the column index
   * @return true if the position is part of the valid shape, false otherwise
   */
  protected abstract boolean isValidShape(int row, int col);

  /**
   * Initializes the board with marbles and an empty slot at the specified position.
   *
   * @param emptyRow the row index of the empty slot
   * @param emptyCol the column index of the empty slot
   * @throws IllegalArgumentException if the specified position is out of bounds or invalid
   */
  private void initializeBoard(int emptyRow, int emptyCol) {
    int boardSize = board.length;
    if (emptyRow < 0 || emptyRow >= boardSize || emptyCol < 0 || emptyCol >= boardSize
        || !isValidShape(emptyRow, emptyCol)) {
      throw new IllegalArgumentException("Invalid empty slot position");
    }

    marbleCount = 0;

    for (int row = 0; row < boardSize; row++) {
      for (int col = 0; col < boardSize; col++) {
        if (isValidShape(row, col)) {
          board[row][col] = Slot.MARBLE;
          marbleCount++;
        } else {
          board[row][col] = Slot.FORBIDDEN;
        }
      }
    }
    board[emptyRow][emptyCol] = Slot.EMPTY;
    marbleCount -= 1;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (!isValidMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("Invalid move");
    }
    board[toRow][toCol] = Slot.MARBLE;
    board[fromRow][fromCol] = Slot.EMPTY;
    board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = Slot.EMPTY;
    marbleCount--;
  }

  /**
   * Validates the move according to the game rules.
   *
   * @param fromRow the row number of the marble to be moved
   * @param fromCol the column number of the marble to be moved
   * @param toRow   the row number of the destination slot
   * @param toCol   the column number of the destination slot
   * @return true if the move is valid, false otherwise
   */
  protected abstract boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol);

  /**
   * Check if the move from and to positions is valid before the move.
   *
   * @param fromRow the row number of the marble to be moved
   * @param fromCol the column number of the marble to be moved
   * @param toRow   the row number of the destination slot
   * @param toCol   the column number of the destination slot
   * @return true if the positions is valid, false otherwise
   */
  protected boolean isValidPosition(int fromRow, int fromCol, int toRow, int toCol) {
    if (toRow < 0 || toRow >= board.length || toCol < 0 || toCol >= board.length
        || fromRow < 0 || fromRow >= board.length || fromCol < 0 || fromCol >= board.length) {
      return false;
    }
    if (board[fromRow][fromCol] != Slot.MARBLE || board[toRow][toCol] != Slot.EMPTY) {
      return false;
    }
    return true;
  }

  /**
   * Checks if a move is valid either horizontally or vertically.
   *
   * @param fromRow the row number of the marble to be moved
   * @param fromCol the column number of the marble to be moved
   * @param toRow   the row number of the destination slot
   * @param toCol   the column number of the destination slot
   * @return true if the move is valid, false otherwise
   */
  protected boolean canMoveHorizontallyOrVertically(int fromRow, int fromCol, int toRow,
                                                    int toCol) {
    if (Math.abs(fromRow - toRow) == 2 && fromCol == toCol
        && board[(fromRow + toRow) / 2][fromCol] == Slot.MARBLE) {
      return true;
    }
    if (Math.abs(fromCol - toCol) == 2 && fromRow == toRow
        && board[fromRow][(fromCol + toCol) / 2] == Slot.MARBLE) {
      return true;
    }
    return false;
  }

  @Override
  public Slot[][] getBoardState() {
    int boardSize = board.length;
    Slot[][] boardCopy = new Slot[boardSize][boardSize];
    for (int row = 0; row < boardSize; row++) {
      System.arraycopy(board[row], 0, boardCopy[row], 0, boardSize);
    }
    return boardCopy;
  }

  @Override
  public abstract boolean isGameOver();

  @Override
  public int getMarbleCount() {
    return marbleCount;
  }

  @Override
  public void reset() {
    initializeBoard(board.length / 2, board.length / 2);
  }
}