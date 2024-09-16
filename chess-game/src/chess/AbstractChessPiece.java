package chess;

/**
 * Abstract class for every piece of a chess game. Implements ChessPiece interface.
 */
public abstract class AbstractChessPiece implements ChessPiece {
  protected int row;
  protected int column;
  protected Color color;

  /**
   * The constructor for AbstractChessPiece class.
   *
   * @param row    row of chess piece
   * @param column column of chess piece
   * @param color  color if chess piece
   */
  public AbstractChessPiece(int row, int column, Color color)
      throws IllegalArgumentException {
    if (row < 0 || row > 7 || column < 0 || column > 7) {
      throw new IllegalArgumentException("Row and column must be between 0 and 7");
    }
    this.row = row;
    this.column = column;
    this.color = color;
  }

  /**
   * Get the row of chess piece.
   *
   * @return row of chess piece
   */
  @Override
  public int getRow() {
    return this.row;
  }

  /**
   * Get the column of chess piece.
   *
   * @return column of chess piece
   */
  @Override
  public int getColumn() {
    return this.column;
  }

  /**
   * Get the color of chess piece.
   *
   * @return color of chess piece
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  protected boolean isValidMovePosition(int row, int column) {
    // Check if the target position is the same as the current position
    if (this.row == row && this.column == column) {
      return false;
    }
    // Check if the target position is within the board limits
    if (row < 0 || row > 7 || column < 0 || column > 7) {
      return false;
    }
    return true;
  }

  /**
   * Determine of the piece can kill another piece starting from its current location.
   *
   * @param piece the piece that might be killed.
   * @return True if the new piece can be killed.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    // If the piece is null or the piece is as same color as our chess piece,
    // it will return false
    if (piece == null || piece.getColor() == this.color) {
      return false;
    }
    return this.canMove(piece.getRow(), piece.getColumn());
  }
}
