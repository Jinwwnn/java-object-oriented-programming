package chess;

/**
 * This class implements King piece in chess game.
 */

public class King extends AbstractChessPiece {

  /**
   * The constructor of King class.
   *
   * @param row    row of King piece
   * @param column column of King piece
   * @param color  color of King piece
   */
  public King(int row, int column, Color color) {
    super(row, column, color);
  }

  /**
   * Determine if a King can move to the given cell.
   *
   * @param row the row where the piece might be moved to.
   * @param col the column where the piece might be moved to.
   * @return true if a King can move to the given cell.
   */
  @Override
  public boolean canMove(int row, int col) {
    // Check if the given cell is valid move position
    if (!isValidMovePosition(row, col)) {
      return false;
    }
    // A king can move one square in any direction (horizontally, vertically, or diagonally)
    int rowDiff = Math.abs(this.getRow() - row);
    int colDiff = Math.abs(this.getColumn() - col);
    return rowDiff <= 1 && colDiff <= 1;
  }
}
