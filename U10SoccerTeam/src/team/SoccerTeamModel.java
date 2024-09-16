package team;

import java.time.LocalDate;

/**
 * Interface representing the model for building a U10 soccer team.
 * This interface defines methods to add players, create a team with assigned jersey numbers,
 * and retrieve information about the team players and the starting lineup.
 */
public interface SoccerTeamModel {
  /**
   * Adds a player to the list of players using the information provided by the user.
   *
   * @param firstName         the first name of the player
   * @param lastName          the last name of the player
   * @param dateOfBirth       the date of birth of the player
   * @param preferredPosition the preferred position of the player on the field
   * @param skillLevel        the skill level of the player
   */
  void addPlayer(String firstName, String lastName, LocalDate dateOfBirth,
                 Position preferredPosition, int skillLevel);

  /**
   * Creates the team of players with jersey number, and then choose starting lineup automatically.
   *
   * @throws IllegalArgumentException if not enough players in the list
   */
  void createTeamWithStartingLineup() throws IllegalArgumentException;

  /**
   * Gets a string representation of all team players.
   *
   * @return a string listing all team players
   */
  String getTeamPlayers();

  /**
   * Gets a string representation of the starting lineup.
   *
   * @return a string listing the starting lineup players
   */
  String getStartingLineup();
}
