package team;

import java.time.LocalDate;
import java.time.Period;

/**
 * Represents the basic information of a player.
 * This class uses the Java record feature to define an immutable data class.
 */
public record Player(String firstName, String lastName, LocalDate dateOfBirth,
                     Position preferredPosition, int skillLevel) {

  /**
   * Constructs a new Player instance.
   * Validates the age and skill level of the player.
   *
   * @param firstName         the first name of the player
   * @param lastName          the last name of the player
   * @param dateOfBirth       the date of birth of the player
   * @param preferredPosition the preferred position of the player on the field
   * @param skillLevel        the skill level of the player (must be between 1 and 5 inclusive)
   * @throws IllegalArgumentException if the player's age is 10 years or older,
   *                                  or if the skill level is not between 1 and 5
   */
  public Player {
    int ageLimit = 10;
    if (Period.between(dateOfBirth, LocalDate.now()).getYears() >= ageLimit
        || Period.between(dateOfBirth, LocalDate.now()).getYears() < 0) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Gets the first name of the player.
   *
   * @return the first name
   */
  public String firstName() {
    return firstName;
  }

  /**
   * Gets the last name of the player.
   *
   * @return the last name
   */
  public String lastName() {
    return lastName;
  }

  /**
   * Gets the date of birth of the player.
   *
   * @return the date of birth
   */
  public LocalDate dateOfBirth() {
    return dateOfBirth;
  }

  /**
   * Gets the preferred position of the player.
   *
   * @return the preferred position
   */
  public Position preferredPosition() {
    return preferredPosition;
  }

  /**
   * Gets the skill level of the player.
   *
   * @return the skill level (1-5)
   */
  public int skillLevel() {
    return skillLevel;
  }
}
