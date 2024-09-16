import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Color;
import chess.King;
import chess.Queen;
import org.junit.Before;
import org.junit.Test;

/**
 * Units tests for King class.
 */

public class TestKing {
  private King king;

  /**
   * Create a King for all tests.
   */
  @Before
  public void setUp() {
    king = new King(0, 3, Color.WHITE);
  }

  /**
   * Test for exception when constructing a King piece.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionException() {
    new King(-4, 3, Color.BLACK);
  }

  /**
   * Test for getRow() of King.
   */
  @Test
  public void testGetRow() {
    assertEquals(0, king.getRow());
  }

  /**
   * Test for getColumn() of King.
   */
  @Test
  public void testGetColumn() {
    assertEquals(3, king.getColumn());
  }

  /**
   * Test for getColor() of King.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, king.getColor());
  }

  /**
   * Test for canMove() of King.
   */
  @Test
  public void testCanMove() {
    assertTrue(king.canMove(0, 4));
    assertTrue(king.canMove(1, 3));
    assertTrue(king.canMove(1, 4));
    assertFalse(king.canMove(2, 4));
  }

  /**
   * Test for canKill() of King.
   */
  @Test
  public void testCanKill() {
    Queen queen = new Queen(1, 4, Color.BLACK);
    assertTrue(king.canKill(queen));
  }
}
