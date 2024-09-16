import solitaire.CrossSolitaireModel;
import solitaire.DiamondSolitaireModel;
import solitaire.Slot;
import solitaire.SolitaireModel;

/**
 * The driver class that illustrates how the user can interact with both game variants.
 */
public class Main {

  /**
   * Main method to run the game.
   *
   * @param args String args
   */
  public static void main(String[] args) {
    // Cross Solitaire Model
    System.out.println("Cross Solitaire Model: ");
    System.out.println("Initial board state: ");
    CrossSolitaireModel crossModel = new CrossSolitaireModel();
    printBoardState(crossModel);
    playGame(crossModel, 3, 1, 3, 3);
    playGame(crossModel, 1, 2, 3, 2);

    // Cross Solitaire Model with specified starting position
    System.out.println("\n--------------------------------------------------");
    System.out.println("Cross Solitaire Model with empty slot at (2, 2):");
    CrossSolitaireModel customCrossModel = new CrossSolitaireModel(2, 2);
    printBoardState(customCrossModel);
    playGame(customCrossModel, 2, 0, 2, 2);
    playGame(customCrossModel, 4, 0, 2, 0);

    // Diamond Solitaire Model
    System.out.println("\n--------------------------------------------------\n"
        + "--------------------------------------------------\n");
    System.out.println("Diamond Solitaire Model:");
    DiamondSolitaireModel diamondModel = new DiamondSolitaireModel();
    printBoardState(diamondModel);
    playGame(diamondModel, 4, 2, 4, 4);
    playGame(diamondModel, 2, 2, 4, 2);

    // Diamond Solitaire Model with specified starting position
    System.out.println("\n--------------------------------------------------");
    System.out.println("Diamond Solitaire Model with empty slot at (3, 3):");
    DiamondSolitaireModel customDiamondModel = new DiamondSolitaireModel(3, 3);
    printBoardState(customDiamondModel);
    playGame(customDiamondModel, 1, 5, 3, 3);
    playGame(customDiamondModel, 1, 3, 1, 5);
  }

  /**
   * Plays the game by making moves and displaying the board state after each move.
   *
   * @param model   the game model
   * @param fromRow the row move from
   * @param fromCol the column move from
   * @param toRow   the row move to
   * @param toCol   the column move to
   */
  private static void playGame(SolitaireModel model, int fromRow, int fromCol, int toRow,
                               int toCol) {
    model.move(fromRow, fromCol, toRow, toCol);
    System.out.printf("Board state after moving the marble at (%d, %d) to (%d, %d):\n",
        fromRow, fromCol, toRow, toCol);
    printBoardState(model);
  }

  /**
   * Prints the current state of the board.
   *
   * @param model the solitaire model
   */
  private static void printBoardState(SolitaireModel model) {
    Slot[][] board = model.getBoardState();
    for (Slot[] row : board) {
      for (Slot slot : row) {
        System.out.print(slot + " ");
      }
      System.out.println();
    }
    System.out.println("Marbles remaining: " + model.getMarbleCount() + "\n");
  }
}
