import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import team.Player;
import team.PlayerWithJerseyNumber;
import team.Position;


/**
 * Unit tests for the TeamPlayer class.
 */
public class PlayerWithJerseyNumberTest {

  private PlayerWithJerseyNumber playerWithJerseyNumber;

  /**
   * Set up a TeamPlayer instance before each test.
   */
  @Before
  public void setUp() {
    Player player = new Player("John", "Doe", LocalDate.of(2015,
        6, 15), Position.FORWARD, 4);
    playerWithJerseyNumber = new PlayerWithJerseyNumber(player, 10);
  }

  /**
   * Test the getJerseyNumber method.
   */
  @Test
  public void testGetJerseyNumber() {
    assertEquals(10, playerWithJerseyNumber.getJerseyNumber());
  }

  /**
   * Test the firstName method inherited from Player.
   */
  @Test
  public void testGetFirstName() {
    assertEquals("John", playerWithJerseyNumber.getFirstName());
  }

  /**
   * Test the lastName method inherited from Player.
   */
  @Test
  public void testGetLastName() {
    assertEquals("Doe", playerWithJerseyNumber.getLastName());
  }

  /**
   * Test the preferredPosition method inherited from Player.
   */
  @Test
  public void testGetPreferredPosition() {
    assertEquals(Position.FORWARD, playerWithJerseyNumber.getPreferredPosition());
  }

  /**
   * Test the skillLevel method inherited from Player.
   */
  @Test
  public void testGetSkillLevel() {
    assertEquals(4, playerWithJerseyNumber.getPlayerSkillLevel());
  }
}
