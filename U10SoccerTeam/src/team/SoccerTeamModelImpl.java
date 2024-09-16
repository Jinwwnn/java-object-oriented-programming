package team;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of the SoccerTeamModel interface.
 * Users can get the team player list and start lineup list from functions in this class.
 */
public class SoccerTeamModelImpl implements SoccerTeamModel {
  private final List<PlayerWithJerseyNumberInterface> teamPlayers = new ArrayList<>();
  private final Map<Position, List<PlayerWithJerseyNumberInterface>> startingLineup
      = new HashMap<>();
  private List<Player> players = new ArrayList<>();

  @Override
  public void addPlayer(String firstName, String lastName, LocalDate dateOfBirth,
                        Position preferredPosition, int skillLevel) {
    players.add(new Player(firstName, lastName, dateOfBirth, preferredPosition, skillLevel));
  }

  @Override
  public void createTeamWithStartingLineup() {
    int minTeamSize = 10;
    if (players.size() < minTeamSize) {
      throw new IllegalArgumentException("Not enough players to create a team. Add more players.");
    }

    int maxTeamSize = 20;
    if (players.size() > maxTeamSize) {
      players.sort(Comparator.comparingInt(Player::skillLevel).reversed());
      players = players.subList(0, maxTeamSize);
    }

    assignJerseyNumbers();
    selectStartingLineup();
  }

  @Override
  public String getTeamPlayers() {
    // Set a copy list before sorting
    List<PlayerWithJerseyNumberInterface> teamCopy = new ArrayList<>(teamPlayers);
    teamCopy.sort(Comparator.comparing(PlayerWithJerseyNumberInterface::getLastName));

    StringBuilder sb = new StringBuilder();
    for (PlayerWithJerseyNumberInterface teamPlayer : teamCopy) {
      sb.append(teamPlayer.getFirstName())
          .append(" ")
          .append(teamPlayer.getLastName())
          .append(" - ")
          .append(teamPlayer.getJerseyNumber())
          .append("\n");
    }
    return sb.toString();
  }

  @Override
  public String getStartingLineup() {
    // Create a copy of the startingLineup map before sorting
    Map<Position, List<PlayerWithJerseyNumberInterface>> startingLineupCopy = new HashMap<>();
    for (Map.Entry<Position, List<PlayerWithJerseyNumberInterface>> entry :
        startingLineup.entrySet()) {
      List<PlayerWithJerseyNumberInterface> playersCopy = new ArrayList<>(entry.getValue());
      startingLineupCopy.put(entry.getKey(), playersCopy);
    }

    List<Map.Entry<Position, List<PlayerWithJerseyNumberInterface>>> startingLineupList =
        new ArrayList<>(startingLineupCopy.entrySet());

    // Sort the list by position
    startingLineupList.sort(Map.Entry.comparingByKey());

    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Position, List<PlayerWithJerseyNumberInterface>> entry : startingLineupList) {
      Position position = entry.getKey();
      List<PlayerWithJerseyNumberInterface> players = entry.getValue();
      // Sort players within each position by last name
      players.sort(Comparator.comparing(PlayerWithJerseyNumberInterface::getLastName));
      for (PlayerWithJerseyNumberInterface playerWithJerseyNumber : players) {
        sb.append(playerWithJerseyNumber.getFirstName())
            .append(" ")
            .append(playerWithJerseyNumber.getLastName())
            .append(" - ")
            .append(playerWithJerseyNumber.getJerseyNumber())
            .append(" - ")
            .append(position)
            .append("\n");
      }
    }

    return sb.toString();
  }

  /**
   * Assigns unique jersey numbers to the players randomly.
   */
  private void assignJerseyNumbers() {
    List<Integer> availableNumbers = new ArrayList<>();
    for (int i = 1; i <= players.size(); i++) {
      availableNumbers.add(i);
    }
    Collections.shuffle(availableNumbers);

    teamPlayers.clear();

    for (int i = 0; i < players.size(); i++) {
      PlayerWithJerseyNumberInterface playerWithJerseyNumber =
          new PlayerWithJerseyNumber(players.get(i), availableNumbers.get(i));
      teamPlayers.add(playerWithJerseyNumber);
    }
  }

  /**
   * Chooses the Starting Lineup in the team.
   */
  private void selectStartingLineup() {
    List<PlayerWithJerseyNumberInterface> teamCopy = new ArrayList<>(teamPlayers);
    teamCopy.sort(
        Comparator.comparingInt(PlayerWithJerseyNumberInterface::getPlayerSkillLevel).reversed());
    List<PlayerWithJerseyNumberInterface> topPlayers = new ArrayList<>(teamCopy.subList(0, 7));
    int index = 7;
    while (index < teamCopy.size()
        && teamCopy.get(index).getPlayerSkillLevel() == teamCopy.get(6).getPlayerSkillLevel()) {
      topPlayers.add(teamCopy.get(index));
      index++;
    }

    assignPositions(topPlayers);
  }

  /**
   * Assigns positions to the top team players to form the starting lineup.
   *
   * @param topPlayers the list of top team players
   */
  private void assignPositions(List<PlayerWithJerseyNumberInterface> topPlayers) {
    startingLineup.clear();

    Map<Position, Integer> positionCounts = new HashMap<>();
    positionCounts.put(Position.GOALIE, 1);
    positionCounts.put(Position.DEFENDER, 2);
    positionCounts.put(Position.MIDFIELDER, 3);
    positionCounts.put(Position.FORWARD, 1);

    for (PlayerWithJerseyNumberInterface topPlayer : topPlayers) {
      Position preferredPosition = topPlayer.getPreferredPosition();
      if (positionCounts.containsKey(preferredPosition)
          && positionCounts.get(preferredPosition) > 0) {
        startingLineup.computeIfAbsent(preferredPosition, k -> new ArrayList<>()).add(topPlayer);
        positionCounts.put(preferredPosition, positionCounts.get(preferredPosition) - 1);
      }
    }

    for (PlayerWithJerseyNumberInterface topPlayer : topPlayers) {
      if (startingLineup.values().stream().noneMatch(list -> list.contains(topPlayer))) {
        for (Map.Entry<Position, Integer> entry : positionCounts.entrySet()) {
          if (entry.getValue() > 0) {
            startingLineup.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).add(topPlayer);
            positionCounts.put(entry.getKey(), entry.getValue() - 1);
            break;
          }
        }
      }
    }
  }
}