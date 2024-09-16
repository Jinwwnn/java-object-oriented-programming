import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Color;
import chess.Queen;
import chess.Rook;
import org.junit.Before;
import org.junit.Test;

/**
 * Units tests for Queen class.
 */

public class TestQueen {
  private Queen queen;

  /**
   * Create a Queen for all tests.
   */
  @Before
  public void setUp() {
    queen = new Queen(2, 2, Color.WHITE);
  }

  /**
   * Test for exception when constructing a Queen piece.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionException() {
    new Queen(-4, -3, Color.BLACK);
  }

  /**
   * Test for getRow() of Queen.
   */
  @Test
  public void testGetRow() {
    assertEquals(2, queen.getRow());
  }

  /**
   * Test for getColumn() of Queen.
   */
  @Test
  public void testGetColumn() {
    assertEquals(2, queen.getColumn());
  }

  /**
   * Test for getColor() of Queen.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, queen.getColor());
  }

  /**
   * Test for canMove() of Queen.
   */
  @Test
  public void testCanMove() {
    assertTrue(queen.canMove(2, 4));
    assertTrue(queen.canMove(0, 2));
    assertTrue(queen.canMove(4, 4));
    assertFalse(queen.canMove(7, 4));
  }

  /**
   * Test for canKill() of Queen.
   */
  @Test
  public void testCanKill() {
    Rook rook = new Rook(4, 4, Color.BLACK);
    assertTrue(queen.canKill(rook));
  }
}
