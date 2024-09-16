package team;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;


/**
 * Implementation of the SoccerTeamController interface.
 * Handles user input and updates the model and view accordingly.
 */
public class SoccerTeamControllerImpl implements SoccerTeamController {
  private final SoccerTeamModel model;
  private final SoccerTeamView view;

  /**
   * Constructs a new SoccerTeamControllerImpl with the given model and view.
   *
   * @param model the model to use
   * @param view  the view to use
   */
  public SoccerTeamControllerImpl(SoccerTeamModel model, SoccerTeamView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void addPlayer(String firstName, String lastName, String dob, String position,
                        int skillLevel) {
    if (firstName.isEmpty() || lastName.isEmpty() || dob.isEmpty() || position.isEmpty()
        || skillLevel < 1) {
      view.notifyFillAllFields();
      return;
    }

    LocalDate dateOfBirth;
    Position preferredPosition;

    try {
      dateOfBirth = LocalDate.parse(dob);
      preferredPosition = Position.valueOf(position.toUpperCase());
    } catch (DateTimeParseException | IllegalArgumentException e) {
      view.notifyInvalidInput();
      return;
    }

    try {
      model.addPlayer(firstName, lastName, dateOfBirth, preferredPosition, skillLevel);
      view.notifyPlayerAdded();
    } catch (IllegalArgumentException e) {
      view.notifyAgeLimit();
    }
  }

  @Override
  public void createTeam() {
    try {
      model.createTeamWithStartingLineup();
      String players = model.getTeamPlayers();
      String lineup = model.getStartingLineup();
      view.updatePlayerList(players);
      view.updateStartingLineup(lineup);
    } catch (IllegalArgumentException e) {
      view.notifyNotEnoughPlayers();
    }
  }
}
