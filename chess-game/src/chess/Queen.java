package chess;

/**
 * This class implements Queen piece in chess game.
 */

public class Queen extends AbstractChessPiece {

  /**
   * The constructor of Queen class.
   *
   * @param row    row of Queen
   * @param column column of Queen
   * @param color  color of Queen
   */
  public Queen(int row, int column, Color color) {
    super(row, column, color);
  }

  /**
   * Determine if a Queen class can move to the given cell.
   *
   * @param row the row where the piece might be moved to
   * @param col the column where the piece might be moved to
   * @return true if a Queen class can move to the given cell
   */
  @Override
  public boolean canMove(int row, int col) {
    // Check if the given cell is valid move position
    if (!isValidMovePosition(row, col)) {
      return false;
    }
    // A queen can move horizontally, vertically and diagonally
    return this.getRow() == row || this.getColumn() == col
        || Math.abs(this.getRow() - row) == Math.abs(this.getColumn() - col);
  }
}
