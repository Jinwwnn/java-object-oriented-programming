package team;

/**
 * Interface for the Soccer Team View.
 * Defines methods to update and display the team players and the starting lineup.
 */

public interface SoccerTeamView {
  /**
   * Sets the controller for the view.
   *
   * @param controller the controller to set
   */
  void setController(SoccerTeamController controller);

  /**
   * Updates the list of players in the team.
   *
   * @param players the string list of players
   */
  void updatePlayerList(String players);

  /**
   * Updates the starting lineup display.
   *
   * @param startingLineup the string list of starting lineup
   */
  void updateStartingLineup(String startingLineup);

  /**
   * Notifies the user to fill in all fields.
   */
  void notifyFillAllFields();

  /**
   * Notifies the user of invalid input.
   */
  void notifyInvalidInput();

  /**
   * Notifies the user when a player has been successfully added.
   */
  void notifyPlayerAdded();

  /**
   * Notifies the user that there are not enough players to create a team.
   */
  void notifyNotEnoughPlayers();

  /**
   * Notifies the user that the player is not allowed due to age limit.
   */
  void notifyAgeLimit();
}