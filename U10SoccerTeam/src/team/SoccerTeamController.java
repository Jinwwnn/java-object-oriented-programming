package team;

/**
 * Interface for the Soccer Team Controller in the MVC architecture.
 * Handles user input and updates the model and view accordingly.
 */
public interface SoccerTeamController {

  /**
   * Adds a player to the model.
   *
   * @param firstName  the first name of the player
   * @param lastName   the last name of the player
   * @param dob        the date of birth of the player
   * @param position   the preferred position of the player
   * @param skillLevel the skill level of the player
   */
  void addPlayer(String firstName, String lastName, String dob, String position, int skillLevel);

  /**
   * Creates a team and updates the view with the players and starting lineup.
   */
  void createTeam();
}