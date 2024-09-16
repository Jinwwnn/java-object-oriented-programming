package solitaire;

/**
 * This enum offers three options for each slot on the board: empty, forbidden and marble. Forbidden
 * means that there is no board in that region.
 */
public enum Slot {
  EMPTY('.'), FORBIDDEN(' '), MARBLE('O');

  private final String symbol;

  Slot(char symbol) {
    this.symbol = String.valueOf(symbol);
  }

  @Override public String toString() {
    return symbol;
  }

}
