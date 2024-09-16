package chess;

/**
 * This class implements Rook piece in chess game.
 */

public class Rook extends AbstractChessPiece {

  /**
   * The constructor of Rook class.
   *
   * @param row    row of Rook class
   * @param column column of Rook class
   * @param color  color of Rook class
   */
  public Rook(int row, int column, Color color) {
    super(row, column, color);
  }

  /**
   * Determine if a Rook can move to the given cell.
   *
   * @param row the row where the piece might be moved to.
   * @param col the column where the piece might be moved to.
   * @return true if a Rook can move to the given cell.
   */
  @Override
  public boolean canMove(int row, int col) {
    // Check if the given cell is valid move position
    if (!isValidMovePosition(row, col)) {
      return false;
    }
    // A rook can move horizontally or vertically
    return this.getRow() == row || this.getColumn() == col;
  }
}
