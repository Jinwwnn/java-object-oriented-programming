# Children's Soccer Team Builder

## About/Overview

The program is a soccer team builder application that helps coaches build a U10 soccer team. It allows coaches to add
information of players. It will help in automatically build teams, assign jersey numbers, and select starting lineups
based on players' skill levels and preferred positions. This program ensures fair team and starting lineup creation and
provides a straightforward way to manage team. <br />It uses the MVC (Model-View-Controller) design pattern and has a
graphical user interface (GUI) built using Swing.

## List of Features

- **Player Information Input**: Coaches can enter player details including first name, last name, date of birth, and
  choose from a drop-down menu for preferred position and skill level. Only players under 10 years old can be added to
  the team.

- **Team Creation**: Automatically builds a team with assigned jersey numbers, ensuring the team has between 10 and 20
  players. If the number of players is less than 10, the coach will be notified of insufficient players. If the team
  exceeds 20 players, the players with the lowest skill levels will be ignored so that the team has at most 20 players.

- **Starting Lineup Selection and Listings**: Chooses the most skilled players for the starting lineup automatically,
  following a 2-3-1 formation. Assign positions to these skilled players according to their skill level and preferred
  position. Displays the starting lineup list.

- **Player Listings**: Displays lists of all team players and the starting lineup.

## How To Run

### Running the JAR File

Require Java installed before running.<br />
Double click to open the U10SoccerTeam.jar file in res folder, or use the following command to run at the command line:

```
java -jar U10SoccerTeam.jar
```

### Required Arguments

No additional arguments are required to run the JAR file. The program is designed to be interactive and prompts the user
for input as needed.

## How to Use the Program

When the program is running ,a window will show up. The left area of the window is for user input and the right area is
for displaying the listings. The user can input players information and then press the button "Add Player". After adding
all players, the user can press "Create team" button to create team. Details are shown as following:

### Add Player

For each player, the coach will:

- Enter: First Name
- Enter: Last Name
- Enter: Date of Birth (must be in YYYY-MM-DD format)
- Choose from a drop-down menu: Preferred Position (Goalie, Defender, Midfielder, Forward)
- Choose from a drop-down menu: Skill Level (1 to 5, with 1 being the lowest and 5 the highest)

After completing all necessary information for a player, the coach can add the player to the team by clicking the **"Add
Player"** button. The coach will be notified that the player has been added to the team successfully, and the
information area for the player will be clear into default.

The coach will be notified and cannot add the player under the following conditions:

- Some required information is missing
- The input format is invalid
- The player is not under 10 years old

### Create Team

The coach can create the team by clicking the **"Create Team"** button at the bottom-left of the view. This will
automatically build the team. If the number of players is less than 10, the coach will be notified of insufficient
players. If the team has more than 20 players, the players with the lowest skill levels will be ignored to ensure the
team has at most 20 players.

When the team is created successfully, it will display the player list and the starting lineup in the right area of the
view.

## Design/Model Changes

An additional interface class named `PlayWithJerseyNumberInterface` has been added based on feedback from Part 1 grades.

## Assumptions

This program assumes:

- The coach will enter correct and reasonable information for players.
- The coach will not enter duplicate information for the same player. If a player's information matches another's
  exactly, they are considered separate players.
- The age limitation is calculated roughly by determining the number of years in the period.

## Limitations

The program does not draw the formation of the starting lineup on the field, as might be visualized before a real soccer
match.

## Citations

Youth Soccer 101. (n.d.). *7v7 Formations*. Retrieved August 7, 2024, from https://youthsoccer101.net/7v7-formations/