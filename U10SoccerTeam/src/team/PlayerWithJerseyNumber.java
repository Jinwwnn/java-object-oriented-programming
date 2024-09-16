package team;

import java.util.Objects;

/**
 * Represents a player with a jersey number in the soccer team.
 */
public class PlayerWithJerseyNumber implements PlayerWithJerseyNumberInterface {
  private final int jerseyNumber;
  private final Player player;

  /**
   * Constructs a new PlayerWithJerseyNumber instance.
   *
   * @param player       the player
   * @param jerseyNumber the jersey number assigned to the player
   */
  public PlayerWithJerseyNumber(Player player, int jerseyNumber) {
    this.jerseyNumber = jerseyNumber;
    this.player = player;
  }

  @Override
  public int getJerseyNumber() {
    return jerseyNumber;
  }

  @Override
  public String getFirstName() {
    return player.firstName();
  }

  @Override
  public String getLastName() {
    return player.lastName();
  }

  @Override
  public int getPlayerSkillLevel() {
    return player.skillLevel();
  }

  @Override
  public Position getPreferredPosition() {
    return player.preferredPosition();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlayerWithJerseyNumber that = (PlayerWithJerseyNumber) o;
    return jerseyNumber == that.jerseyNumber
        && player.equals(that.player);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jerseyNumber, player);
  }
}