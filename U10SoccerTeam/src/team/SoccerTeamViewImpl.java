package team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * Implementation of the SoccerTeamView interface.
 * Provides the graphical user interface for the Soccer Team application.
 */
public class SoccerTeamViewImpl extends JFrame implements SoccerTeamView {
  private final JTextField firstNameField;
  private final JTextField lastNameField;
  private final JTextField dobField;
  private final JComboBox<String> positionComboBox;
  private final JComboBox<String> skillLevelComboBox;
  private final JTextArea playerListArea;
  private final JTextArea startingLineupArea;
  private SoccerTeamController controller;

  /**
   * Constructor of the View.
   */
  public SoccerTeamViewImpl() {
    setTitle("Soccer Team Builder");
    setSize(800, 800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // Main panel with padding
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
    mainPanel.setBackground(new Color(210, 238, 255));

    // Welcome panel
    Font customFont = new Font("SansSerif", Font.PLAIN, 16);
    JPanel infoPanel;
    infoPanel = getInfoPanel(customFont);

    // Input panel
    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new BorderLayout());
    inputPanel.setPreferredSize(new Dimension(400, 400));
    inputPanel.setOpaque(false);

    JPanel formPanel = new JPanel();
    formPanel.setLayout(new GridLayout(6, 2, 10, 10));
    formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    formPanel.setBackground(Color.WHITE);

    formPanel.add(new JLabel("First Name:"));
    firstNameField = new JTextField();
    formPanel.add(firstNameField);
    formPanel.add(new JLabel("Last Name:"));
    lastNameField = new JTextField();
    formPanel.add(lastNameField);
    formPanel.add(new JLabel("Date of Birth (YYYY-MM-DD):"));
    dobField = new JTextField();
    formPanel.add(dobField);
    formPanel.add(new JLabel("Preferred Position:"));
    positionComboBox =
        new JComboBox<>(new String[] {"", "GOALIE", "DEFENDER", "MIDFIELDER", "FORWARD"});
    formPanel.add(positionComboBox);
    formPanel.add(new JLabel("Skill Level (1-5):"));
    skillLevelComboBox = new JComboBox<>(new String[] {"0", "1", "2", "3", "4", "5"});
    formPanel.add(skillLevelComboBox);

    inputPanel.add(formPanel, BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BorderLayout());
    buttonPanel.setOpaque(false);

    JButton addButton = getAddButton(customFont);
    buttonPanel.add(addButton, BorderLayout.NORTH);

    JButton createTeamButton = getCreateTeamButton(customFont);
    buttonPanel.add(createTeamButton, BorderLayout.SOUTH);

    inputPanel.add(buttonPanel, BorderLayout.SOUTH);

    // Text listing areas
    Font textFont = new Font("SansSerif", Font.PLAIN, 12);
    playerListArea = new JTextArea();
    playerListArea.setFont(textFont);
    playerListArea.setForeground(Color.BLACK);
    playerListArea.setBackground(new Color(224, 223, 255));
    playerListArea.setBorder(BorderFactory.createCompoundBorder(
        new LineBorder(Color.GRAY, 1, true),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)
    ));
    playerListArea.setPreferredSize(new Dimension(300, 480));
    playerListArea.setEditable(false);

    startingLineupArea = new JTextArea();
    startingLineupArea.setFont(customFont);
    startingLineupArea.setForeground(Color.BLACK);
    startingLineupArea.setBackground(new Color(224, 210, 255));
    startingLineupArea.setBorder(BorderFactory.createCompoundBorder(
        new LineBorder(Color.GRAY, 1, true),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)
    ));
    startingLineupArea.setPreferredSize(new Dimension(300, 280));
    startingLineupArea.setEditable(false);

    JPanel textAreaPanel = new JPanel();
    textAreaPanel.setLayout(new BorderLayout(10, 10));
    textAreaPanel.setOpaque(false);
    textAreaPanel.add(playerListArea, BorderLayout.NORTH);
    textAreaPanel.add(startingLineupArea, BorderLayout.SOUTH);


    mainPanel.add(infoPanel, BorderLayout.NORTH);
    mainPanel.add(inputPanel, BorderLayout.WEST);
    mainPanel.add(textAreaPanel, BorderLayout.CENTER);

    add(mainPanel);
  }

  /**
   * Get the info panel of the view.
   *
   * @param customFont the font in custom style
   * @return the info panel
   */
  private static JPanel getInfoPanel(Font customFont) {
    JPanel infoPanel = new JPanel();
    infoPanel.setLayout(new BorderLayout());
    JLabel welcomeLabel = new JLabel("Welcome to Soccer Team Management", JLabel.CENTER);
    welcomeLabel.setFont(customFont.deriveFont(Font.BOLD, 20));
    welcomeLabel.setForeground(Color.BLACK);
    JLabel instructionsLabel = new JLabel(
        "<html>Fill in the player details and click 'Add Player' to add them to the list. "
            + "Then click 'Create Team' to generate the team.</html>",
        JLabel.CENTER);
    instructionsLabel.setFont(customFont.deriveFont(Font.PLAIN, 14));
    instructionsLabel.setForeground(Color.DARK_GRAY);

    infoPanel.add(welcomeLabel, BorderLayout.NORTH);
    infoPanel.add(instructionsLabel, BorderLayout.CENTER);
    return infoPanel;
  }

  /**
   * Get the add player button.
   *
   * @param customFont the font in custom style
   * @return the add player button
   */
  private JButton getAddButton(Font customFont) {
    JButton addButton = new JButton("Add Player");
    addButton.setFont(customFont);
    addButton.setMargin(new Insets(10, 20, 10, 20));
    addButton.setBackground(new Color(155, 225, 255)); // MediumSeaGreen background
    addButton.setForeground(new Color(0, 110, 255));
    addButton.setFocusPainted(false);
    addButton.setOpaque(true);
    addButton.addActionListener(e -> controller.addPlayer(
        firstNameField.getText(),
        lastNameField.getText(),
        dobField.getText(),
        (String) positionComboBox.getSelectedItem(),
        Integer.parseInt((String) Objects.requireNonNull(skillLevelComboBox.getSelectedItem()))
    ));
    return addButton;
  }

  /**
   * Get the create team button.
   *
   * @param customFont the font in custom style
   * @return the create team button
   */
  private JButton getCreateTeamButton(Font customFont) {
    JButton createTeamButton = new JButton("Create Team");
    createTeamButton.setFont(customFont);
    createTeamButton.setMargin(new Insets(10, 20, 10, 20));
    createTeamButton.setBackground(new Color(150, 206, 250));
    createTeamButton.setForeground(new Color(0, 110, 255));
    createTeamButton.setOpaque(true);
    createTeamButton.setContentAreaFilled(
        true); // Ensure the content area is filled with the background color
    createTeamButton.addActionListener(e -> controller.createTeam());
    return createTeamButton;
  }

  @Override
  public void setController(SoccerTeamController controller) {
    this.controller = controller;
  }

  @Override
  public void updatePlayerList(String players) {
    playerListArea.setText("Team Players: \n\"NAME - JERSEY NUMBER\"\n\n" + players);
  }

  @Override
  public void updateStartingLineup(String lineup) {
    startingLineupArea.setText(
        "Starting Lineup: \n\"NAME - JERSEY NUMBER - POSITION\"\n\n" + lineup);
  }

  @Override
  public void notifyFillAllFields() {
    JOptionPane.showMessageDialog(this, "Please fill in all information of the player.", "Error",
        JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void notifyInvalidInput() {
    JOptionPane.showMessageDialog(this,
        "Invalid information provided. The format of Date of Birth should be: \"YYYY-MM-DD\"",
        "Error", JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void notifyPlayerAdded() {
    JOptionPane.showMessageDialog(this, "Player successfully added.", "Success",
        JOptionPane.INFORMATION_MESSAGE);
    firstNameField.setText("");
    lastNameField.setText("");
    dobField.setText("");
    positionComboBox.setSelectedIndex(0);
    skillLevelComboBox.setSelectedIndex(0);
  }

  @Override
  public void notifyNotEnoughPlayers() {
    JOptionPane.showMessageDialog(this, "Not enough players to create a team. Add more players.",
        "Error", JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void notifyAgeLimit() {
    JOptionPane.showMessageDialog(this, "Player is not under 10, and cannot be added to the team.",
        "Error", JOptionPane.ERROR_MESSAGE);
  }
}