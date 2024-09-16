package solitaire;

/**
 * This class implements the SolitaireModel interface for the cross-shaped (English style) variant
 * of the Marble Solitaire game. The board has 33 slots (32 marbles and one empty spot).
 */
public class CrossSolitaireModel extends AbstractSolitaireModel {

  /**
   * Default constructor creates a standard cross-shaped board with the center slot empty.
   */
  public CrossSolitaireModel() {
    this(3, 3); // center position of 7x7 board
  }

  /**
   * Constructor to create a cross-shaped board with a specified empty slot.
   *
   * @param emptyRow the row index of the empty slot
   * @param emptyCol the column index of the empty slot
   * @throws IllegalArgumentException if the specified position is invalid
   */
  public CrossSolitaireModel(int emptyRow, int emptyCol) {
    super(7, emptyRow, emptyCol);
  }

  @Override
  protected boolean isValidShape(int row, int col) {
    return (row >= 2 && row <= 4) || (col >= 2 && col <= 4);
  }

  @Override
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    if (!isValidPosition(fromRow, fromCol, toRow, toCol)) {
      return false;
    }

    return canMoveHorizontallyOrVertically(fromRow, fromCol, toRow, toCol);
  }

  @Override
  public boolean isGameOver() {
    for (int row = 0; row < 7; row++) {
      for (int col = 0; col < 7; col++) {
        if (board[row][col] == Slot.MARBLE) {
          if (isValidMove(row, col, row - 2, col)
              || isValidMove(row, col, row + 2, col)
              || isValidMove(row, col, row, col - 2)
              || isValidMove(row, col, row, col + 2)) {
            return false;
          }
        }
      }
    }
    return true;
  }
}