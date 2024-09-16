import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import solitaire.CrossSolitaireModel;
import solitaire.Slot;

/**
 * Unit test for CrossSolitaireModel class.
 */
public class CrossSolitaireModelTest {
  private CrossSolitaireModel crossModel;

  /**
   * Sets up a new CrossSolitaireModel instance before each test.
   */
  @Before
  public void setUp() {
    crossModel = new CrossSolitaireModel();
  }

  /**
   * Tests the default constructor.
   */
  @Test
  public void testDefaultConstructor() {
    Slot[][] board = crossModel.getBoardState();
    assertEquals(Slot.EMPTY, board[3][3]);
    assertEquals(Slot.MARBLE, board[4][4]);
    assertEquals(Slot.MARBLE, board[0][2]);
    assertEquals(Slot.MARBLE, board[0][4]);
    assertEquals(Slot.MARBLE, board[2][0]);
    assertEquals(Slot.MARBLE, board[4][6]);
    assertEquals(Slot.FORBIDDEN, board[0][1]);
    assertEquals(Slot.FORBIDDEN, board[5][5]);
    assertEquals(Slot.FORBIDDEN, board[1][5]);
    assertEquals(Slot.FORBIDDEN, board[6][6]);
    assertEquals(32, crossModel.getMarbleCount());
  }

  /**
   * Tests the custom constructor with a valid empty slot.
   */
  @Test
  public void testCustomConstructor() {
    crossModel = new CrossSolitaireModel(2, 2);
    Slot[][] board = crossModel.getBoardState();
    assertEquals(Slot.EMPTY, board[2][2]);
    assertEquals(32, crossModel.getMarbleCount());
  }

  /**
   * Tests the custom constructor with an invalid empty slot.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCustomConstructor() {
    new CrossSolitaireModel(0, 0);
  }

  /**
   * Tests a valid horizontal move.
   */
  @Test
  public void testValidHorizontalMove() {
    crossModel.move(3, 1, 3, 3);
    Slot[][] board = crossModel.getBoardState();
    assertEquals(Slot.EMPTY, board[3][1]);
    assertEquals(Slot.EMPTY, board[3][2]);
    assertEquals(Slot.MARBLE, board[3][3]);
  }

  /**
   * Tests a valid vertical move.
   */
  @Test
  public void testValidVerticalMove() {
    crossModel.move(1, 3, 3, 3);
    Slot[][] board = crossModel.getBoardState();
    assertEquals(Slot.EMPTY, board[2][3]);
    assertEquals(Slot.EMPTY, board[1][3]);
    assertEquals(Slot.MARBLE, board[3][3]);
  }

  /**
   * Tests an invalid move when the original slot is forbidden.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove1() {
    crossModel.move(0, 0, 0, 2);
  }

  /**
   * Tests an invalid move when the move didn't follow the rule.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove2() {
    crossModel.move(4, 2, 3, 3);
  }

  /**
   * Tests an invalid move when the slot will be moved to is occupied.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove3() {
    crossModel.move(4, 0, 4, 2);
  }

  /**
   * Tests the game over and marble count by implementing the moves in game.
   */
  @Test
  public void testRun() {
    assertFalse(crossModel.isGameOver());
    assertEquals(32, crossModel.getMarbleCount());
    int count = 32;
    crossModel.move(3, 5, 3, 3);
    assertFalse(crossModel.isGameOver());
    count -= 1;
    assertEquals(count, crossModel.getMarbleCount());

    // Perform the series of more moves that end the game with only one marble left
    int[][] moves = {{1, 4, 3, 4}, {2, 6, 2, 4}, {4, 6, 2, 6},
        {2, 3, 2, 5}, {2, 6, 2, 4}, {2, 1, 2, 3}, {0, 2, 2, 2},
        {0, 4, 0, 2}, {3, 2, 1, 2}, {0, 2, 2, 2}, {5, 2, 3, 2},
        {4, 0, 4, 2}, {2, 0, 4, 0}, {4, 3, 4, 1}, {2, 3, 4, 3},
        {5, 4, 5, 2}, {6, 2, 4, 2}, {6, 4, 6, 2}, {3, 2, 5, 2},
        {6, 2, 4, 2}, {4, 4, 4, 6}, {4, 2, 4, 4}, {4, 0, 4, 2},
    };

    for (int[] move : moves) {
      crossModel.move(move[0], move[1], move[2], move[3]);
      assertFalse(crossModel.isGameOver());
      count -= 1;
      assertEquals(count, crossModel.getMarbleCount());
    }

    crossModel.move(3, 4, 5, 4);
    assertTrue(crossModel.isGameOver());

    // There are 7 marbles left in board.
    assertEquals(7, crossModel.getMarbleCount());
  }

  /**
   * Tests the reset functionality.
   */
  @Test
  public void testReset() {
    Slot[][] board = crossModel.getBoardState();
    crossModel.move(3, 1, 3, 3);
    crossModel.reset();
    assertEquals(Slot.EMPTY, board[3][3]);
    Arrays.deepEquals(board, crossModel.getBoardState());
    assertEquals(32, crossModel.getMarbleCount());
  }

  /**
   * Tests the getBoardState functionality.
   */
  @Test
  public void testGetBoardState() {
    Slot[][] board = crossModel.getBoardState();
    Arrays.deepEquals(board, crossModel.getBoardState());

    assertEquals(crossModel.getBoardState()[3][3], Slot.EMPTY);
    assertEquals(board[3][3], Slot.EMPTY);
    // Change slot in board
    board[3][3] = Slot.MARBLE;
    // the model not change
    assertEquals(crossModel.getBoardState()[3][3], Slot.EMPTY);
  }
}
