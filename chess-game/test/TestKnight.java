import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Bishop;
import chess.Color;
import chess.Knight;
import org.junit.Before;
import org.junit.Test;

/**
 * Units tests for Knight class.
 */

public class TestKnight {

  private Knight knight1;
  private Knight knight2;

  /**
   * Create two knights knight1, knight2 for all tests.
   */
  @Before
  public void setUp() {
    knight1 = new Knight(2, 3, Color.WHITE);
    knight2 = new Knight(1, 1, Color.BLACK);
  }

  /**
   * Test for exception when constructing a Knight piece.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionException() {
    new Knight(-2, 5, Color.BLACK);
  }

  /**
   * Test for getRow() of Knight.
   */
  @Test
  public void testGetRow() {
    assertEquals(2, knight1.getRow());
    assertEquals(1, knight2.getRow());
  }

  /**
   * Test for getColumn() of Knight.
   */
  @Test
  public void testGetColumn() {
    assertEquals(3, knight1.getColumn());
    assertEquals(1, knight2.getColumn());
  }

  /**
   * Test for getColor() of Knight.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, knight1.getColor());
    assertEquals(Color.BLACK, knight2.getColor());
  }

  /**
   * Test for canMove() of Knight.
   */
  @Test
  public void testCanMove() {
    assertTrue(knight1.canMove(4, 4));
    assertTrue(knight2.canMove(2, 3));
    assertFalse(knight1.canMove(7, 2));
  }

  /**
   * Test for canKill() of Knight.
   */
  @Test
  public void testCanKill() {
    assertTrue(knight1.canKill(knight2));
    Bishop bishop1 = new Bishop(5, 2, Color.BLACK);
    assertFalse(knight1.canKill(bishop1));
  }
}

