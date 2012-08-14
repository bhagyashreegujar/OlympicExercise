package configure;

import java.util.Map;

import entities.*;

//generates unique id for Sport / Event / Player
public class IDGenerator {

	//serially generates next ID for a new Sport
	public Integer generateSportID(Map<String, Sport> sportData){
		return sportData.size()+1;
	}

	//serially generates next ID for a new Event
	public Integer generateEventID(Map<Integer, Event> eventData){
		return eventData.size()+1;
	}

	//serially generates next ID for a new Player
	public Integer generatePlayerID(Map<Integer, Player> playerData){
		return playerData.size()+1;
	}

	//serially generates next ID for a new Team
	public Integer generateTeamID(Map<Integer, Team> teamData){
		return teamData.size()+1;
	}

}
