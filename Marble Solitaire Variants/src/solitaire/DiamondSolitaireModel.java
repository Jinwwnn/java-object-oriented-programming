package solitaire;

/**
 * This class implements the SolitaireModel interface for the diamond-shaped variant
 * of the Marble Solitaire game. The board has 41 slots (40 marbles and one empty spot).
 */
public class DiamondSolitaireModel extends AbstractSolitaireModel {

  /**
   * Default constructor creates a standard diamond-shaped board with the center slot empty.
   */
  public DiamondSolitaireModel() {
    this(4, 4); // center position of 9x9 board
  }

  /**
   * Constructor to create a diamond-shaped board with a specified empty slot.
   *
   * @param emptyRow the row index of the empty slot
   * @param emptyCol the column index of the empty slot
   * @throws IllegalArgumentException if the specified position is invalid
   */
  public DiamondSolitaireModel(int emptyRow, int emptyCol) {
    super(9, emptyRow, emptyCol);
  }

  @Override
  protected boolean isValidShape(int row, int col) {
    int center = 4;
    return Math.abs(row - center) + Math.abs(col - center) <= center;
  }

  @Override
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    if (!isValidPosition(fromRow, fromCol, toRow, toCol)) {
      return false;
    }

    return canMoveHorizontallyOrVertically(fromRow, fromCol, toRow, toCol)
        || (Math.abs(fromRow - toRow) == 2 && Math.abs(fromCol - toCol) == 2
        && board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] == Slot.MARBLE);
  }

  @Override
  public boolean isGameOver() {
    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        if (board[row][col] == Slot.MARBLE) {
          if (isValidMove(row, col, row - 2, col)
              || isValidMove(row, col, row + 2, col)
              || isValidMove(row, col, row, col - 2)
              || isValidMove(row, col, row, col + 2)
              || isValidMove(row, col, row - 2, col - 2)
              || isValidMove(row, col, row - 2, col + 2)
              || isValidMove(row, col, row + 2, col - 2)
              || isValidMove(row, col, row + 2, col + 2)) {
            return false;
          }
        }
      }
    }
    return true;
  }
}