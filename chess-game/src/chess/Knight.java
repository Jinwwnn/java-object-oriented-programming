package chess;

/**
 * This class implements knight piece in chess game.
 */

public class Knight extends AbstractChessPiece {

  /**
   * The constructor of a Knight piece.
   *
   * @param row    the row of the Knight piece
   * @param column the column of the Knight piece
   * @param color  the color of the Knight piece
   */
  public Knight(int row, int column, Color color) {
    super(row, column, color);
  }

  /**
   * Determine if a Knight can move to the given cell.
   *
   * @param row the row of given cell
   * @param col the column of given cell
   * @return true if a Knight can move to the given cell
   */
  @Override
  public boolean canMove(int row, int col) {
    // Check if the given cell is valid move position
    if (!isValidMovePosition(row, col)) {
      return false;
    }
    // A knight can move only in an L pattern
    return (Math.abs(row - this.getRow()) == 2 && Math.abs(col - this.getColumn()) == 1)
        || (Math.abs(row - this.getRow()) == 1 && Math.abs(col - this.getColumn()) == 2);
  }
}
