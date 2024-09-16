import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import team.Player;
import team.Position;

/**
 * Unit tests for the Player class.
 */
public class PlayerTest {

  private Player validPlayer;

  @Before
  public void setUp() {
    validPlayer = new Player("John", "Doe",
        LocalDate.of(2015, 6, 15), Position.FORWARD, 4);
  }

  /**
   * Test the constructor with a player who is too old (age >= 10).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorPlayerTooOld() {
    new Player("Jane", "Doe", LocalDate.of(2012, 1, 1),
        Position.DEFENDER, 3);

  }

  /**
   * Test getting the first name of the player.
   */
  @Test
  public void testGetFirstName() {
    assertEquals("John", validPlayer.firstName());
  }

  /**
   * Test getting the last name of the player.
   */
  @Test
  public void testGetLastName() {
    assertEquals("Doe", validPlayer.lastName());
  }

  /**
   * Test getting the date of birth of the player.
   */
  @Test
  public void testGetDateOfBirth() {
    assertEquals(LocalDate.of(2015, 6, 15), validPlayer.dateOfBirth());
  }

  /**
   * Test getting the preferred position of the player.
   */
  @Test
  public void testGetPreferredPosition() {
    assertEquals(Position.FORWARD, validPlayer.preferredPosition());
  }

  /**
   * Test getting the skill level of the player.
   */
  @Test
  public void testGetSkillLevel() {
    assertEquals(4, validPlayer.skillLevel());
  }
}