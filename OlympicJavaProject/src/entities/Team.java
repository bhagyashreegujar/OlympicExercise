package entities;
import java.util.ArrayList;

//defines a Team with all Players
public class Team {

	//teamPlayers: all Players in a Team.
	//teamEvents : all the Events that Team participates in.
	private Integer teamID;
	private String teamCountryName;
	private ArrayList<Player> teamPlayers=new ArrayList<Player>();
	private ArrayList<Event> teamEvents = new ArrayList<Event>();

	//getters and setters
	
	public Team(Integer teamID,String teamCountryName) {
		setTeamID(teamID);
		setTeamCountryName(teamCountryName);
	}

	public String getTeamCountryName() {
		return teamCountryName;
	}

	public void setTeamCountryName(String teamCountryName) {
		this.teamCountryName = teamCountryName;
	}

	public ArrayList<Player> getTeamPlayers() {
		return teamPlayers;
	}

	public void setTeamPlayers(ArrayList<Player> teamPlayers) {
		this.teamPlayers = teamPlayers;
	}

	public ArrayList<Event> getTeamEvents() {
		return teamEvents;
	}

	public void setTeamEvents(ArrayList<Event> teamEvents) {
		this.teamEvents = teamEvents;
	}

	public Integer getTeamID() {
		return teamID;
	}

	public void setTeamID(Integer teamID) {
		this.teamID = teamID;
	}

	//adds Player to teamPlayers
	public ArrayList<Player> addPlayerToTeam(Player player)	{
		teamPlayers.add(player);
		return teamPlayers;
	}
	
	//adds Event to teamEvents
	public ArrayList<Event> addEventToTeam(Event event){
		teamEvents.add(event);
		return teamEvents;
	}
	
	public void displayTeam() {
		System.out.println("Team ID : "+this.teamID);
		for (Player teamPlayer : teamPlayers) {
			teamPlayer.displayPlayer();
		}
		System.out.println("Events participated in :");

		for (Event event:teamEvents) {
			System.out.print(event.getEventName()+" ");
		}
	}
	
	public boolean participatedInEvent(Event event) {
		Boolean result=false;
		
		if(teamEvents.contains(event)){
			result=true;
		}
		return result;
	}
}
