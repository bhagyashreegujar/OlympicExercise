package consolehandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import configure.*;
import entities.*;

public class Main {

	SportConfigurer sportconfig=new SportConfigurer();
	EventConfigurer eventconfig=new EventConfigurer();
	PlayerConfigurer playerconfig = new PlayerConfigurer();
	TeamConfigurer teamconfig=new TeamConfigurer();

	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String inputLine;

	public static void main(String[] args) throws IOException {
		new Main().showMenu();
	}


	//some more menu options to bve added for displayind records and some options need to be coded.
	public void showMenu() throws IOException{

		MenuOption[] menuOption = MenuOption.values();
		int option = 0;

		do {

			System.out.println("----------Olympic Exercise------------");
			System.out.println("Menu");
			System.out.println("1.Add a new Sport");
			System.out.println("2.Add a new Event");
			System.out.println("3.Add a new Player");
			System.out.println("4.Add a new Team");
			System.out.println("5.Add an Event to a Player");
			System.out.println("6.Add an Event to a Team");
			System.out.println("7.Enter Medal Winners");
			System.out.println("8.Display Reports ");
			inputLine=br.readLine();
			option =Integer.parseInt(inputLine) -1 ;

			switch (menuOption[option]) {

			case ADD_SPORT:
				System.out.println("Enter Sport Name : ");
				String sportName=br.readLine().toUpperCase();
				System.out.println("Enter Sport Location : ");
				String sportLocation=br.readLine();
				sportconfig.addSport(sportName, sportLocation);
				break;

			case ADD_EVENT:
				System.out.println("Enter Event Name : ");
				String eventName=br.readLine().toUpperCase();
				System.out.println("Enter Event gender type(mens,womens,mixed) : ");
				String eventGenderType=br.readLine().toUpperCase();
				System.out.println("Enter event category(Individual /Team) :");
				String eventCategory=br.readLine().toUpperCase();
				System.out.println("Enter Sport Name : ");
				sportName=br.readLine().toUpperCase();

				eventconfig.addEvent(sportconfig.getSportData(), eventName, eventGenderType, eventCategory, sportName);
				break;

			case ADD_PLAYER:
				System.out.println("Enter the following details of the player : ");
				System.out.println("Name : ");
				String playerName = br.readLine().toUpperCase();
				System.out.println("Country : ");
				String playerCountry = br.readLine().toUpperCase();
				System.out.println("Gender :");
				String playerGender = br.readLine().toUpperCase();
				System.out.println("Coach : ");
				String playerCoach = br.readLine().toUpperCase();
				System.out.println("Occupation : ");
				String playerOccupation = br.readLine().toUpperCase();
				System.out.println("Height : ");
				double playerHeight = Double.parseDouble(br.readLine());
				System.out.println("Weight : ");
				double playerWeight = Double.parseDouble(br.readLine());

				playerconfig.addPlayer(playerName, playerCountry, playerGender, playerCoach, playerOccupation, playerHeight, playerWeight);

				playerconfig.displayAllPlayers();
				break;

			case ADD_TEAM:
				System.out.println("Enter the Country : ");
				String teamCountryName= br.readLine().toUpperCase();
				playerconfig.displayCountryPlayers(teamCountryName);

				if (playerconfig.getPlayerData().size()==0) {
					System.out.println("No player Exists of given Country");
				} else {


					System.out.println("Enter the count of players in the team : ");
					Integer playerCount = Integer.parseInt(br.readLine());
					ArrayList<Player> players=new ArrayList<Player>();

					for (int i = 0; i < playerCount; i++) {
						System.out.println("Enter player"+(i+1)+" ID");
						Integer playerId=Integer.parseInt(br.readLine());
						Player newTeamPlayer=playerconfig.getPlayerData().get(playerId);

						if (newTeamPlayer != null && !players.contains(newTeamPlayer)) {
							players.add(newTeamPlayer);
						} else {
							if (newTeamPlayer == null) {
								System.out.println("Player with given Id does not exists.");

							} else {
								System.out.println("Player already added to team");
							}
						}
					}
					teamconfig.addTeam(players, teamCountryName);

				}
				teamconfig.displayAllTeams();
				break;

			case ADD_EVENT_TO_PLAYER:
				System.out.println("Choose a player ID from Player list : ");
				playerconfig.displayAllPlayers();
				Integer playerID=Integer.parseInt(br.readLine());
				System.out.println("Choose an event ID from Event list");
				eventconfig.displayAllEvents();
				Integer eventID=Integer.parseInt(br.readLine());

				Player player=playerconfig.getPlayerData().get(playerID);
				Event event=eventconfig.getEventData().get(eventID);

				player.addEventToPlayer(event);
				break;

			case ADD_EVENT_TO_TEAM:
				System.out.println("Choose a Team ID from Team list : ");
				teamconfig.displayAllTeams();
				Integer teamID=Integer.parseInt(br.readLine().toUpperCase());
				System.out.println("Choose an event ID from Event list");
				eventconfig.displayAllEvents();
				eventID=Integer.parseInt(br.readLine());

				Team team=teamconfig.getTeamData().get(teamID);
				event=eventconfig.getEventData().get(eventID);
				team.addEventToTeam(event);
				break;

			case ADD_MEDALS:
				System.out.println("Enter event from Event List");
				eventconfig.displayAllEvents();

				eventID=Integer.parseInt(br.readLine());
				event=eventconfig.getEventData().get(eventID);

				if (event.getEventCategory().equals("INDIVIDUAL")) {
					playerconfig.displayEventPlayer(event);

					System.out.println("Enter player ID for Gold Medal : ");
					Integer goldWinnerID=Integer.parseInt(br.readLine());
					event.setGoldWinnerID(goldWinnerID);

					System.out.println("Enter player ID for Silver Medal : ");
					Integer silverWinnerID=Integer.parseInt(br.readLine());
					event.setSilverWinnerID(silverWinnerID);

					System.out.println("Enter player ID for Bronze Medal : ");
					Integer bronzeWinnerID=Integer.parseInt(br.readLine());
					event.setBronzeWinnerID(bronzeWinnerID);

				} else {
					teamconfig.displayEventTeam(event);

					System.out.println("Enter Team ID for Gold Medal : ");
					Integer goldWinnerID=Integer.parseInt(br.readLine());
					event.setGoldWinnerID(goldWinnerID);

					System.out.println("Enter Team ID for Silver Medal : ");
					Integer silverWinnerID=Integer.parseInt(br.readLine());
					event.setSilverWinnerID(silverWinnerID);

					System.out.println("Enter Team ID for Bronze Medal : ");
					Integer bronzeWinnerID=Integer.parseInt(br.readLine());
					event.setBronzeWinnerID(bronzeWinnerID);	

				}
				break;

			case DISPLAY_REPORTS:
				//Medal Tally (gold, silver, bronze) by country	
				eventconfig.calculateMedalTallyByCountry(playerconfig.getPlayerData(),teamconfig.getTeamData());
				
				//Medal winners (players) and their countries for each game played //DONE FOR EVENT AS A GAME
				eventconfig.calculateMedalWinnersByEvent(playerconfig.getPlayerData(),teamconfig.getTeamData(),sportconfig.getSportData());
				
				//Medal winners (players) and their games for each country
				
				break;

			case EXIT:
				break;

			default:
				break;
			}

		} while (menuOption[option]!=MenuOption.EXIT);

	}

}
