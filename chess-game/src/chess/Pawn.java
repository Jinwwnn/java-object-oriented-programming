package chess;

/**
 * This class implements King piece in chess game.
 */

public class Pawn extends AbstractChessPiece {

  /**
   * The constructor of Pawn class.
   *
   * @param row    row of Pawn piece
   * @param column column of Pawn piece
   * @param color  color of Pawn piece
   */
  public Pawn(int row, int column, Color color) throws IllegalArgumentException {
    super(row, column, color);
    if (color == Color.WHITE) {
      // White Pawn piece should cannot below row 1
      if (row < 1) {
        throw new IllegalArgumentException("row cannot be less than 1");
      }
    }
    if (color == Color.BLACK) {
      // Black Pawn piece should cannot beyond row 6
      if (row > 6) {
        throw new IllegalArgumentException("row cannot be greater than 6");
      }
    }
  }

  @Override
  public boolean canMove(int row, int col) {
    // Check if the given cell is valid move position
    if (!isValidMovePosition(row, col)) {
      return false;
    }
    // Check if the given cell is in the same column of the piece
    if (this.getColumn() != col) {
      return false;
    }
    // White Pawn piece begin at row 1, black pawn piece begin at row 6
    if (this.getColor() == Color.WHITE) {
      if (this.getRow() == 1) {
        return (row - this.getRow() == 1) || (row - this.getRow() == 2);
      } else {
        return row - this.getRow() == 1;
      }
    }
    if (this.color == Color.BLACK) {
      if (this.getRow() == 6) {
        return (this.getRow() - row == 1) || (this.getRow() - row == 2);
      } else {
        return this.getRow() - row == 1;
      }
    }
    return false;
  }

  /**
   * Determine of a Pawn can kill another piece starting from its current location.
   *
   * @param piece the piece that might be killed.
   * @return True if the new piece can be killed.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    // If the piece is null, it will return false
    if (piece == null) {
      return false;
    }
    // Cannot kill the same color piece
    if (this.getColor() == piece.getColor()) {
      return false;
    }

    // A Pawn can kill one place forward diagonally
    int rowDiff = piece.getRow() - this.getRow();
    int colDiff = Math.abs(piece.getColumn() - this.getColumn());

    if (this.getColor() == Color.WHITE) {
      return rowDiff == 1 && colDiff == 1;
    }
    if (this.getColor() == Color.BLACK) {
      return rowDiff == -1 && colDiff == 1;
    }
    return false;
  }
}
