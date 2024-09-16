import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import team.Position;
import team.SoccerTeamModelImpl;


/**
 * Unit tests for the SoccerTeamModelImpl class.
 */
public class SoccerTeamModelImplTest {

  private SoccerTeamModelImpl model;

  /**
   * Set up the model for tests.
   */
  @Before
  public void setUp() {
    model = new SoccerTeamModelImpl();
  }

  /**
   * Test addPlayer().
   */
  @Test
  public void testAddPlayer() {
    // Add 10 players' record to the model
    model.addPlayer("John", "Doe",
        LocalDate.of(2016, 7, 20), Position.MIDFIELDER, 5);
    model.addPlayer("Jane", "Smith",
        LocalDate.of(2017, 8, 10), Position.DEFENDER, 4);
    model.addPlayer("Alex", "Brown",
        LocalDate.of(2016, 1, 15), Position.GOALIE, 3);
    model.addPlayer("Chris", "Davis",
        LocalDate.of(2015, 3, 30), Position.FORWARD, 5);
    model.addPlayer("Pat", "Taylor",
        LocalDate.of(2015, 6, 22), Position.MIDFIELDER, 4);
    model.addPlayer("Jordan", "White",
        LocalDate.of(2015, 5, 18), Position.DEFENDER, 3);
    model.addPlayer("Taylor", "Lee",
        LocalDate.of(2015, 2, 25), Position.FORWARD, 2);
    model.addPlayer("Morgan", "Clark",
        LocalDate.of(2015, 11, 5), Position.GOALIE, 3);
    model.addPlayer("Casey", "Martinez",
        LocalDate.of(2014, 10, 19), Position.MIDFIELDER, 4);
    model.addPlayer("Drew", "Garcia",
        LocalDate.of(2015, 4, 1), Position.DEFENDER, 5);

    // 10 players can make up a team without exception
    model.createTeamWithStartingLineup();
    assertEquals(10, model.getTeamPlayers().split("\n").length);
  }

  /**
   * Test createTeamWithStartingLineup() with not enough players.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCreateTeamWithStartingLineupNotEnoughPlayers() {
    // Add only 9 players record to the model before create team
    model.addPlayer("John", "Doe",
        LocalDate.of(2016, 7, 20), Position.MIDFIELDER, 5);
    model.addPlayer("Jane", "Smith",
        LocalDate.of(2017, 8, 10), Position.DEFENDER, 4);
    model.addPlayer("Alex", "Brown",
        LocalDate.of(2016, 1, 15), Position.GOALIE, 3);
    model.addPlayer("Chris", "Davis",
        LocalDate.of(2015, 3, 30), Position.FORWARD, 5);
    model.addPlayer("Pat", "Taylor",
        LocalDate.of(2015, 6, 22), Position.MIDFIELDER, 4);
    model.addPlayer("Jordan", "White",
        LocalDate.of(2015, 5, 18), Position.DEFENDER, 3);
    model.addPlayer("Taylor", "Lee",
        LocalDate.of(2015, 2, 25), Position.FORWARD, 2);
    model.addPlayer("Morgan", "Clark",
        LocalDate.of(2015, 11, 5), Position.GOALIE, 3);
    model.addPlayer("Casey", "Martinez",
        LocalDate.of(2014, 10, 19), Position.MIDFIELDER, 4);
    model.createTeamWithStartingLineup();
  }

  /**
   * Test createTeamWithStartingLineup() with enough players.
   */
  @Test
  public void testCreateTeamWithStartingLineupWithEnoughPlayers() {
    // Attempt to create a team with the size between 10-20 players
    // Add 10 players in this test
    model.addPlayer("John", "Smith",
        LocalDate.of(2015, 1, 1), Position.FORWARD, 5);
    model.addPlayer("Michael", "Johnson",
        LocalDate.of(2015, 2, 2), Position.DEFENDER, 4);
    model.addPlayer("William", "Williams",
        LocalDate.of(2016, 3, 3), Position.MIDFIELDER, 3);
    model.addPlayer("David", "Brown",
        LocalDate.of(2016, 4, 4), Position.GOALIE, 2);
    model.addPlayer("Richard", "Jones",
        LocalDate.of(2015, 5, 5), Position.FORWARD, 5);
    model.addPlayer("Joseph", "Garcia",
        LocalDate.of(2015, 6, 6), Position.DEFENDER, 3);
    model.addPlayer("Charles", "Miller",
        LocalDate.of(2016, 7, 7), Position.MIDFIELDER, 4);
    model.addPlayer("Thomas", "Davis",
        LocalDate.of(2017, 8, 8), Position.GOALIE, 2);
    model.addPlayer("Christopher", "Martinez",
        LocalDate.of(2015, 9, 9), Position.FORWARD, 5);
    model.addPlayer("Daniel", "Hernandez",
        LocalDate.of(2016, 10, 10), Position.DEFENDER, 4);

    model.createTeamWithStartingLineup();

    assertEquals(10, model.getTeamPlayers().split("\n").length);
    assertEquals(7, model.getStartingLineup().split("\n").length);
  }

  /**
   * Test createTeamWithStartingLineup() with players more than 20 players.
   */
  @Test
  public void testCreateTeamWithStartingLineupWithMoreThanMaxPlayers() {
    // Set up a players list with 21 players before tests.
    model.addPlayer("John", "Smith",
        LocalDate.of(2015, 1, 1), Position.FORWARD, 5);
    model.addPlayer("Michael", "Johnson",
        LocalDate.of(2015, 2, 2), Position.DEFENDER, 4);
    model.addPlayer("William", "Williams",
        LocalDate.of(2016, 3, 3), Position.MIDFIELDER, 3);
    model.addPlayer("David", "Brown",
        LocalDate.of(2016, 4, 4), Position.GOALIE, 2);
    model.addPlayer("Richard", "Jones",
        LocalDate.of(2015, 5, 5), Position.FORWARD, 5);
    model.addPlayer("Joseph", "Garcia",
        LocalDate.of(2015, 6, 6), Position.DEFENDER, 3);
    model.addPlayer("Charles", "Miller",
        LocalDate.of(2016, 7, 7), Position.MIDFIELDER, 4);
    model.addPlayer("Thomas", "Davis",
        LocalDate.of(2017, 8, 8), Position.GOALIE, 2);
    model.addPlayer("Christopher", "Martinez",
        LocalDate.of(2015, 9, 9), Position.FORWARD, 5);
    model.addPlayer("Daniel", "Hernandez",
        LocalDate.of(2016, 10, 10), Position.DEFENDER, 4);
    model.addPlayer("Paul", "Lopez",
        LocalDate.of(2016, 11, 11), Position.MIDFIELDER, 3);
    model.addPlayer("Mark", "Gonzalez",
        LocalDate.of(2015, 12, 12), Position.GOALIE, 4);
    model.addPlayer("Donald", "Wilson",
        LocalDate.of(2015, 1, 13), Position.FORWARD, 5);
    model.addPlayer("George", "Anderson",
        LocalDate.of(2015, 2, 14), Position.DEFENDER, 3);
    model.addPlayer("Kenneth", "Thomas",
        LocalDate.of(2015, 3, 15), Position.MIDFIELDER, 4);
    model.addPlayer("Steven", "Taylor",
        LocalDate.of(2016, 4, 16), Position.GOALIE, 3);
    model.addPlayer("Edward", "Moore",
        LocalDate.of(2016, 5, 17), Position.FORWARD, 5);
    model.addPlayer("Brian", "Jackson",
        LocalDate.of(2018, 6, 18), Position.DEFENDER, 1);
    model.addPlayer("Ronald", "Martin",
        LocalDate.of(2017, 7, 19), Position.MIDFIELDER, 3);
    model.addPlayer("Anthony", "Lee",
        LocalDate.of(2016, 8, 20), Position.GOALIE, 2);
    model.addPlayer("Kevin", "Perez",
        LocalDate.of(2015, 9, 21), Position.FORWARD, 5);

    model.createTeamWithStartingLineup();
    assertEquals(20, model.getTeamPlayers().split("\n").length);
    assertEquals(7, model.getStartingLineup().split("\n").length);

    // Check the player with the lowest skill level not in the team
    assertFalse(model.getTeamPlayers().contains("Brian Jackson"));
    // The 2nd lowest player is in team
    assertTrue(model.getTeamPlayers().contains("Anthony Lee"));

    // Add another player in team with skill level > 2
    model.addPlayer("Dan", "Hazed",
        LocalDate.of(2015, 4, 2), Position.FORWARD, 5);
    // create team again
    model.createTeamWithStartingLineup();
    assertEquals(20, model.getTeamPlayers().split("\n").length);
    assertEquals(7, model.getStartingLineup().split("\n").length);
    assertTrue(model.getTeamPlayers().contains("Dan Hazed"));
    // The 2nd lowest player is out of team
    assertFalse(model.getTeamPlayers().contains("Anthony Lee"));
  }

  /**
   * Test for getTeamPlayers().
   */
  @Test
  public void testGetTeamPlayers() {
    // Add 10 players in this test
    model.addPlayer("John", "Smith",
        LocalDate.of(2015, 1, 1), Position.FORWARD, 5);
    model.addPlayer("Michael", "Johnson",
        LocalDate.of(2015, 2, 2), Position.DEFENDER, 4);
    model.addPlayer("William", "Williams",
        LocalDate.of(2016, 3, 3), Position.MIDFIELDER, 3);
    model.addPlayer("David", "Brown",
        LocalDate.of(2016, 4, 4), Position.GOALIE, 2);
    model.addPlayer("Richard", "Jones",
        LocalDate.of(2015, 5, 5), Position.FORWARD, 5);
    model.addPlayer("Joseph", "Garcia",
        LocalDate.of(2015, 6, 6), Position.DEFENDER, 3);
    model.addPlayer("Charles", "Miller",
        LocalDate.of(2016, 7, 7), Position.MIDFIELDER, 4);
    model.addPlayer("Thomas", "Davis",
        LocalDate.of(2017, 8, 8), Position.GOALIE, 2);
    model.addPlayer("Christopher", "Martinez",
        LocalDate.of(2015, 9, 9), Position.FORWARD, 5);
    model.addPlayer("Daniel", "Hernandez",
        LocalDate.of(2016, 10, 10), Position.DEFENDER, 4);

    model.createTeamWithStartingLineup();

    assertEquals(10, model.getTeamPlayers().split("\n").length);

    // Check contain some players' name
    assertTrue(model.getTeamPlayers().contains("David Brown"));
    assertTrue(model.getTeamPlayers().contains("Thomas Davis"));
    assertTrue(model.getTeamPlayers().contains("Joseph Garcia"));
    assertTrue(model.getTeamPlayers().contains("John Smith"));

    // Check all jersey numbers are used
    assertTrue(model.getTeamPlayers().contains("1"));
    assertTrue(model.getTeamPlayers().contains("2"));
    assertTrue(model.getTeamPlayers().contains("3"));
    assertTrue(model.getTeamPlayers().contains("4"));
    assertTrue(model.getTeamPlayers().contains("5"));
    assertTrue(model.getTeamPlayers().contains("6"));
    assertTrue(model.getTeamPlayers().contains("7"));
    assertTrue(model.getTeamPlayers().contains("8"));
    assertTrue(model.getTeamPlayers().contains("9"));
    assertTrue(model.getTeamPlayers().contains("10"));

    // Check the team players list is sorted correctly by alphabetical order (last name)
    String teamPlayers = model.getTeamPlayers();
    String[] lines = teamPlayers.split("\n");
    String previousLastName = "";
    for (String line : lines) {
      String currentLastName = line.split(" ")[1];
      assertTrue(previousLastName.compareTo(currentLastName) <= 0);
      previousLastName = currentLastName;
    }

    // If we create team again with the same players, we'll get different jersey number order
    model.createTeamWithStartingLineup();
    String newTeamPlayers = model.getTeamPlayers();
    assertFalse(newTeamPlayers.equalsIgnoreCase(teamPlayers));
  }

  /**
   * Test for getStartingLineup().
   */
  @Test
  public void testGetStartingLineup() {
    // Add 10 players in this test
    model.addPlayer("John", "Smith",
        LocalDate.of(2015, 1, 1), Position.FORWARD, 5);
    model.addPlayer("Michael", "Johnson",
        LocalDate.of(2015, 2, 2), Position.DEFENDER, 4);
    model.addPlayer("William", "Williams",
        LocalDate.of(2016, 3, 3), Position.MIDFIELDER, 3);
    model.addPlayer("David", "Brown",
        LocalDate.of(2016, 4, 4), Position.GOALIE, 2);
    model.addPlayer("Richard", "Jones",
        LocalDate.of(2015, 5, 5), Position.FORWARD, 5);
    model.addPlayer("Joseph", "Garcia",
        LocalDate.of(2015, 6, 6), Position.DEFENDER, 3);
    model.addPlayer("Charles", "Miller",
        LocalDate.of(2016, 7, 7), Position.MIDFIELDER, 4);
    model.addPlayer("Thomas", "Davis",
        LocalDate.of(2017, 8, 8), Position.GOALIE, 2);
    model.addPlayer("Christopher", "Martinez",
        LocalDate.of(2015, 9, 9), Position.FORWARD, 5);
    model.addPlayer("Daniel", "Hernandez",
        LocalDate.of(2016, 10, 10), Position.DEFENDER, 4);
    model.createTeamWithStartingLineup();

    // Check the starting lineup list contains player with top skill level
    assertTrue(model.getTeamPlayers().contains("John Smith"));
    assertTrue(model.getTeamPlayers().contains("Michael Johnson"));
    assertTrue(model.getTeamPlayers().contains("Daniel Hernandez"));
    assertTrue(model.getTeamPlayers().contains("Christopher Martinez"));

    // Check the number of players and for each position
    assertEquals(7, model.getStartingLineup().split("\n").length);
    String startingLineup = model.getStartingLineup();
    String[] lines = startingLineup.split("\n");
    assertEquals("FORWARD", lines[0].split(" - ")[2]);
    assertEquals("GOALIE", lines[1].split(" - ")[2]);
    assertEquals("DEFENDER", lines[2].split(" - ")[2]);
    assertEquals("DEFENDER", lines[3].split(" - ")[2]);
    assertEquals("MIDFIELDER", lines[4].split(" - ")[2]);
    assertEquals("MIDFIELDER", lines[5].split(" - ")[2]);
    assertEquals("MIDFIELDER", lines[6].split(" - ")[2]);

    // Check the starting lineup list is sorted correctly by position and then by last name
    Position previousPosition = null;
    String previousLastName = "";

    for (String line : lines) {
      String[] parts = line.split(" - ");
      Position currentPosition = Position.valueOf(parts[2]);
      String currentLastName = parts[0].split(" ")[1];
      if (previousPosition != null) {
        if (previousPosition == currentPosition) {
          assertTrue(previousLastName.compareTo(currentLastName) <= 0);
        } else {
          assertTrue(previousPosition.ordinal() < currentPosition.ordinal());
        }
      }
      previousPosition = currentPosition;
      previousLastName = currentLastName;
    }
  }
}
