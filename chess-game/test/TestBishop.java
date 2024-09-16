import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Bishop;
import chess.Color;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for Bishop class.
 */

public class TestBishop {
  private Bishop bishop1;
  private Bishop bishop2;

  /**
   * Create two chess pieces bishop1 and bishop2 for all test.
   */
  @Before
  public void setUp() {
    bishop1 = new Bishop(4, 3, Color.WHITE);
    bishop2 = new Bishop(1, 1, Color.BLACK);
  }

  /**
   * Test for exception when constructing a Bishop piece.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionException() {
    new Bishop(2, 8, Color.BLACK);
  }

  /**
   * Test for getRow() of Bishop.
   */
  @Test
  public void testGetRow() {
    assertEquals(4, bishop1.getRow());
    assertEquals(1, bishop2.getRow());
  }

  /**
   * Test for getColumn() of Bishop.
   */
  @Test
  public void testGetColumn() {
    assertEquals(3, bishop1.getColumn());
    assertEquals(1, bishop2.getColumn());
  }

  /**
   * Test for getColor() of Bishop.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, bishop1.getColor());
    assertEquals(Color.BLACK, bishop2.getColor());
  }

  /**
   * Test for canMove() of Bishop.
   */
  @Test
  public void testCanMove() {
    assertTrue(bishop1.canMove(5, 4));
    assertTrue(bishop1.canMove(2, 1));
    assertFalse(bishop2.canMove(7, 5));
  }

  /**
   * Test for canKill() of Bishop.
   */
  @Test
  public void testCanKill() {
    assertFalse(bishop1.canKill(bishop2));
    Bishop bishop3 = new Bishop(2, 2, Color.WHITE);
    Bishop bishop4 = new Bishop(2, 2, Color.BLACK);
    assertTrue(bishop2.canKill(bishop3));
    assertFalse(bishop2.canKill(bishop4));
  }
}
