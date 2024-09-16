package team;

/**
 * Interface representing a player with a jersey number.
 */
public interface PlayerWithJerseyNumberInterface {
  /**
   * Gets the jersey number of the player.
   *
   * @return the jersey number
   */
  int getJerseyNumber();

  /**
   * Gets the first name of the player.
   *
   * @return the first name
   */
  String getFirstName();

  /**
   * Gets the last name of the player.
   *
   * @return the last name
   */
  String getLastName();

  /**
   * Gets the skill level of the player.
   *
   * @return the skill level
   */
  int getPlayerSkillLevel();

  /**
   * Gets the preferred position of the player.
   *
   * @return the preferred position
   */
  Position getPreferredPosition();
}
