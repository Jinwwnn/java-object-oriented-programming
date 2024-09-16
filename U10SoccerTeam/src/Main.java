import team.SoccerTeamController;
import team.SoccerTeamControllerImpl;
import team.SoccerTeamModelImpl;
import team.SoccerTeamViewImpl;

/**
 * Main class for the Soccer Team MVC application.
 * Initializes the model, view, and controller.
 */
public class Main {
  /**
   * The main method to run the Soccer Team MVC application.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    SoccerTeamModelImpl model = new SoccerTeamModelImpl();
    SoccerTeamViewImpl view = new SoccerTeamViewImpl();
    SoccerTeamController controller = new SoccerTeamControllerImpl(model, view);

    view.setController(controller);
    view.setVisible(true);
  }
}
