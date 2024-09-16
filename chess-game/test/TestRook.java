import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Color;
import chess.Knight;
import chess.Rook;
import org.junit.Before;
import org.junit.Test;

/**
 * Units tests for Rook class.
 */

public class TestRook {
  private Rook rook;

  /**
   * Create a Rook for all tests.
   */
  @Before
  public void setUp() {
    rook = new Rook(2, 2, Color.WHITE);
  }

  /**
   * Test for exception when constructing a Rook piece.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionException() {
    new Rook(-4, 0, Color.BLACK);
  }

  /**
   * Test for getRow() of Rook.
   */
  @Test
  public void testGetRow() {
    assertEquals(2, rook.getRow());
  }

  /**
   * Test for getColumn() of Rook.
   */
  @Test
  public void testGetColumn() {
    assertEquals(2, rook.getColumn());
  }

  /**
   * Test for getColor() of Rook.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, rook.getColor());
  }

  /**
   * Test for canMove() of Rook.
   */
  @Test
  public void testCanMove() {
    assertTrue(rook.canMove(2, 4));
    assertTrue(rook.canMove(0, 2));
    assertFalse(rook.canMove(7, 4));
  }

  /**
   * Test for canKill() of Rook.
   */
  @Test
  public void testCanKill() {
    Knight knight = new Knight(4, 2, Color.BLACK);
    assertTrue(rook.canKill(knight));
  }
}
