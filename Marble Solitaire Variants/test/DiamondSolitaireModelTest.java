import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import solitaire.DiamondSolitaireModel;
import solitaire.Slot;


/**
 * Unit test for DiamondSolitaireModel class.
 */
public class DiamondSolitaireModelTest {
  private DiamondSolitaireModel diamondModel;

  /**
   * Sets up a new DiamondSolitaireModel instance before each test.
   */
  @Before
  public void setUp() {
    diamondModel = new DiamondSolitaireModel();
  }

  /**
   * Tests the default constructor.
   */
  @Test
  public void testDefaultConstructor() {
    Slot[][] board = diamondModel.getBoardState();
    assertEquals(Slot.EMPTY, board[4][4]);
    assertEquals(Slot.MARBLE, board[4][0]);
    assertEquals(Slot.MARBLE, board[4][5]);
    assertEquals(Slot.MARBLE, board[4][8]);
    assertEquals(Slot.MARBLE, board[0][4]);
    assertEquals(Slot.MARBLE, board[8][4]);
    assertEquals(Slot.FORBIDDEN, board[0][0]);
    assertEquals(Slot.FORBIDDEN, board[5][8]);
    assertEquals(Slot.FORBIDDEN, board[0][3]);
    assertEquals(Slot.FORBIDDEN, board[8][5]);
    assertEquals(40, diamondModel.getMarbleCount());
  }

  /**
   * Tests the custom constructor with a valid empty slot.
   */
  @Test
  public void testCustomConstructor() {
    diamondModel = new DiamondSolitaireModel(2, 2);
    Slot[][] board = diamondModel.getBoardState();
    assertEquals(Slot.EMPTY, board[2][2]);
    assertEquals(40, diamondModel.getMarbleCount());
  }

  /**
   * Tests the custom constructor with an invalid empty slot.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCustomConstructor() {
    new DiamondSolitaireModel(0, 0);
  }

  /**
   * Tests a valid horizontal move.
   */
  @Test
  public void testHorizontalMove() {
    diamondModel.move(4, 2, 4, 4);
    Slot[][] board = diamondModel.getBoardState();
    assertEquals(Slot.EMPTY, board[4][2]);
    assertEquals(Slot.EMPTY, board[4][3]);
    assertEquals(Slot.MARBLE, board[4][4]);
  }

  /**
   * Tests a valid vertical move.
   */
  @Test
  public void testVerticalMove() {
    diamondModel.move(2, 4, 4, 4);
    Slot[][] board = diamondModel.getBoardState();
    assertEquals(Slot.EMPTY, board[2][4]);
    assertEquals(Slot.EMPTY, board[3][4]);
    assertEquals(Slot.MARBLE, board[4][4]);
  }

  /**
   * Tests a valid diagonal move.
   */
  @Test
  public void testDiagonalMove() {
    diamondModel.move(2, 2, 4, 4);
    Slot[][] board = diamondModel.getBoardState();
    assertEquals(Slot.EMPTY, board[2][2]);
    assertEquals(Slot.EMPTY, board[3][3]);
    assertEquals(Slot.MARBLE, board[4][4]);
  }

  /**
   * Tests an invalid move when the original slot is forbidden.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove1() {
    diamondModel.move(0, 0, 0, 2);
  }

  /**
   * Tests an invalid move when the move didn't follow the rule.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove2() {
    diamondModel.move(4, 7, 4, 4);
  }

  /**
   * Tests an invalid move when the slot will be moved to is occupied.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove3() {
    diamondModel.move(4, 0, 4, 2);
  }
  

  /**
   * Tests the game over and marble count by implementing the moves in game.
   */
  @Test
  public void testRun() {
    assertFalse(diamondModel.isGameOver());
    assertEquals(40, diamondModel.getMarbleCount());
    int count = 40;

    // Perform the series of  moves that end the game with only one marble left
    int[][] moves = {{2, 4, 4, 4}, {0, 4, 2, 4}, {5, 4, 3, 4},
        {7, 4, 5, 4}, {2, 4, 4, 4}, {3, 2, 3, 4}, {3, 5, 3, 3},
        {1, 5, 3, 5}, {3, 6, 3, 4}, {3, 3, 3, 5}, {1, 3, 3, 3},
        {5, 4, 3, 4}, {4, 2, 4, 4}, {4, 0, 4, 2}, {4, 5, 4, 3},
        {4, 7, 4, 5}, {4, 2, 4, 4}, {5, 2, 5, 4}, {4, 5, 4, 3},
        {3, 4, 3, 2}, {2, 6, 4, 4}, {3, 1, 3, 3}, {4, 3, 4, 5},
        {2, 2, 4, 4}, {5, 5, 3, 5}, {5, 4, 3, 4}, {3, 4, 3, 6},
        {5, 7, 5, 5}, {6, 6, 4, 4}, {8, 4, 6, 6}, {3, 7, 3, 5},
        {7, 3, 5, 3}, {6, 2, 4, 0}, {6, 6, 6, 4}, {5, 3, 7, 5},
    };

    for (int[] move : moves) {
      diamondModel.move(move[0], move[1], move[2], move[3]);
      assertFalse(diamondModel.isGameOver());
      count -= 1;
      assertEquals(count, diamondModel.getMarbleCount());
    }

    diamondModel.move(3, 5, 5, 3);
    assertTrue(diamondModel.isGameOver());
    assertEquals(4, diamondModel.getMarbleCount());
  }

  /**
   * Tests the reset functionality.
   */
  @Test
  public void testReset() {
    Slot[][] board = diamondModel.getBoardState();
    diamondModel.move(4, 2, 4, 4);
    diamondModel.reset();
    assertEquals(Slot.EMPTY, board[4][4]);
    assertEquals(40, diamondModel.getMarbleCount());
    Arrays.deepEquals(board, diamondModel.getBoardState());
  }

  /**
   * Tests the getBoardState functionality.
   */
  @Test
  public void testGetBoardState() {
    Slot[][] board = diamondModel.getBoardState();
    Arrays.deepEquals(board, diamondModel.getBoardState());

    assertEquals(diamondModel.getBoardState()[4][4], Slot.EMPTY);
    assertEquals(board[4][4], Slot.EMPTY);
    // Change slot in board
    board[4][4] = Slot.MARBLE;
    // the model not change
    assertEquals(diamondModel.getBoardState()[4][4], Slot.EMPTY);
  }
}