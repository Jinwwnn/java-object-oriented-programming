package solitaire;

/**
 * Represents a solitaire game model. The model keeps track of the game state and allows moves to be
 * made on the board. The board can be cross-shaped (English style), Diamond-shaped, etc.
 */
public interface SolitaireModel {

  /**
   * Makes a move in the game. A move consists of jumping a marble over an adjacent marble into an
   * empty slot. The jumped-over marble is removed.
   *
   * @param fromRow the row number of the marble to be moved (0-indexed)
   * @param fromCol the column number of the marble to be moved (0-indexed)
   * @param toRow   the row number of the destination slot (0-indexed)
   * @param toCol   the column number of the destination slot (0-indexed)
   * @throws IllegalArgumentException if the move is illegal
   */
  void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException;

  /**
   * Returns the current state of the game board as a 2D array of characters. Each position can be
   * 'O' for a marble, '_' for an empty slot, or ' ' for an invalid position.
   *
   * @return the current state of the game board
   */
  Slot[][] getBoardState();

  /**
   * Checks if the game is over. The game is over if no more valid moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  boolean isGameOver();

  /**
   * Returns the number of marbles remaining on the board.
   *
   * @return the number of marbles remaining
   */
  int getMarbleCount();

  /**
   * Resets the game to its initial state.
   */
  void reset();
}

