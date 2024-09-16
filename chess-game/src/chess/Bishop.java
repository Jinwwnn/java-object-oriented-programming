package chess;

/**
 * This class implements Bishop of chess game.
 */

public class Bishop extends AbstractChessPiece {

  /**
   * The constructor of Bishop class.
   *
   * @param row    row of a bishop piece
   * @param column column of a bishop piece
   * @param color  color of a bishop piece
   */
  public Bishop(int row, int column, Color color) {
    super(row, column, color);
  }

  /**
   * Determine if a Bishop can move to a given cell.
   *
   * @param row the column of the given cell
   * @param col the column of the given cell
   * @return true if a Bishop can move to a given cell
   */
  @Override
  public boolean canMove(int row, int col) {
    // Check if the given cell is valid move position
    if (!isValidMovePosition(row, col)) {
      return false;
    }
    // A bishop can only move diagonally
    return Math.abs(this.getRow() - row) == Math.abs(this.getColumn() - col);
  }

}
