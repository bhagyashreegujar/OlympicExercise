package entities;
import java.util.*;

//defines a Player with all details
public class Player {

	//playerSports: all Sports that Player plays.
	//playerEvent : all the Events that Player participates in.
	private Integer playerID;
	private String playerName,playerCountry,playerGender,playerCoach,playerOccupation;
	private double playerHeight,playerWeight;
	private ArrayList<Sport> playerSports = new ArrayList<Sport>();
	private ArrayList<Event> playerEvents = new ArrayList<Event>();

	//getters and setters
	public String getPlayerName() { 
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Integer getPlayerID() {
		return playerID;
	}

	public void setPlayerID(Integer playerID) {
		this.playerID = playerID;
	}

	public String getPlayerCountry() {
		return playerCountry;
	}

	public void setPlayerCountry(String playerCountry) {
		this.playerCountry = playerCountry;
	}

	public String getPlayerGender() {
		return playerGender;
	}

	public void setPlayerGender(String playerGender) {
		this.playerGender = playerGender;
	}

	public String getPlayerCoach() {
		return playerCoach;
	}

	public void setPlayerCoach(String playerCoach) {
		this.playerCoach = playerCoach;
	}

	public String getPlayerOccupation() {
		return playerOccupation;
	}

	public void setPlayerOccupation(String playerOccupation) {
		this.playerOccupation = playerOccupation;
	}

	public double getPlayerHeight() {
		return playerHeight;
	}

	public void setPlayerHeight(double playerHeight) {
		this.playerHeight = playerHeight;
	}

	public double getPlayerWeight() {
		return playerWeight;
	}

	public void setPlayerWeight(double playerWeight) {
		this.playerWeight = playerWeight;
	}

	public ArrayList<Sport> getPlayerSports() {
		return playerSports;
	}

	public void setPlayerSports(ArrayList<Sport> playerSports) {
		this.playerSports = playerSports;
	}

	public ArrayList<Event> getPlayerEvents() {
		return playerEvents;
	}

	public void setPlayerEvents(ArrayList<Event> playerEvents) {
		this.playerEvents = playerEvents;
	}

	public Player(Integer playerID,String playerName,String playerCountry , String playerGender,String playerCoach ,String playerOccupation ,double playerHeight,double playerWeight 
			) {
		
		setPlayerID(playerID);
		setPlayerName(playerName);
		setPlayerCountry(playerCountry);
		setPlayerGender(playerGender);
		setPlayerCoach(playerCoach);
		setPlayerOccupation(playerOccupation);
		setPlayerHeight(playerHeight);
		setPlayerWeight(playerWeight);
	}

	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	//adds the Event to playerEvent
	public ArrayList<Event> addEventToPlayer(Event event){		
		playerEvents.add(event);
		playerSports.add(event.getEventSport());
		return playerEvents;
	}

	public void displayPlayer() {
		
		System.out.println("Player ID :" + this.getPlayerID());
		System.out.println("Player Name :"+ this.getPlayerName());
		System.out.println("Country :"+ this.getPlayerCountry());
		System.out.println("Gender :"+ this.getPlayerGender());
		System.out.println("Coach :"+ this.getPlayerCoach());
		System.out.println("Occupation :" + this.getPlayerOccupation());
		System.out.println("Height :"+ this.getPlayerHeight());
		System.out.println("Weight :"+ this.getPlayerWeight());
		System.out.println("Participated in: ");
		if (playerEvents.size()==0) {
			System.out.println("No Events added so far.");
		} else {
			for (Event event:playerEvents) {
				System.out.print(event.getEventName()+"-"+event.getEventSport().getSportName());
			}

		}
		
	}
	
	public boolean participatedInEvent(Event event) {
		Boolean result=false;
		
		if(playerEvents.contains(event)){
			result=true;
		}
		return result;
	}
}
