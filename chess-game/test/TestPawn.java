import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Color;
import chess.King;
import chess.Pawn;
import org.junit.Before;
import org.junit.Test;

/**
 * Units tests for Pawn class.
 */

public class TestPawn {
  private Pawn pawn1;
  private Pawn pawn2;

  /**
   * Create two pawn for tests.
   * Pawn1 is going to take its first step, but pawn2 is in the middle of chess game.
   */
  @Before
  public void setUp() {
    pawn1 = new Pawn(1, 3, Color.WHITE);
    pawn2 = new Pawn(6, 4, Color.BLACK);
  }

  /**
   * Test1 for exception when constructing a Pawn piece.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionException1() {
    new Pawn(-4, -3, Color.BLACK);
  }

  /**
   * Test2 for exception when constructing a Pawn piece.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionException2() {
    new Pawn(7, 3, Color.BLACK);
  }

  /**
   * Test3 for exception when constructing a Pawn piece.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionException3() {
    new Pawn(0, 3, Color.WHITE);
  }

  /**
   * Test for getRow() of Pawn.
   */
  @Test
  public void testGetRow() {
    assertEquals(1, pawn1.getRow());
  }

  /**
   * Test for getColumn() of Pawn.
   */
  @Test
  public void testGetColumn() {
    assertEquals(3, pawn1.getColumn());
  }

  /**
   * Test for getColor() of Pawn.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, pawn1.getColor());
  }

  /**
   * Test for canMove() of Pawn.
   */
  @Test
  public void testCanMove() {
    assertTrue(pawn1.canMove(3, 3));
    assertTrue(pawn1.canMove(2, 3));
    assertTrue(pawn2.canMove(4, 4));
    assertTrue(pawn2.canMove(5, 4));
    assertFalse(pawn2.canMove(3, 4));
  }

  /**
   * Test for canKill() of Pawn.
   */
  @Test
  public void testCanKill() {
    King king1 = new King(2, 2, Color.BLACK);
    King king2 = new King(5, 3, Color.WHITE);
    assertTrue(pawn1.canKill(king1));
    assertTrue(pawn2.canKill(king2));
    assertFalse(pawn1.canKill(pawn2));
  }
}

