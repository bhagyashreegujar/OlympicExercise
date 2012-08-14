package configure;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import entities.*;

public class TeamConfigurer {


	Map<Integer,Team> teamData= new TreeMap<Integer, Team>();
	IDGenerator idGenerator = new IDGenerator();

	public Map<Integer, Team> addTeam(ArrayList<Player> players,String teamCountryName) {

		Integer teamID=idGenerator.generateTeamID(teamData);
		Team team=new Team(teamID, teamCountryName);

		for (Player player : players) {
			team.addPlayerToTeam(player);
		}

		teamData.put(teamID, team);
		return teamData;
	}

	public Map<Integer, Team> addTeamEvent(Map<Integer, Team> teamData, Map<Integer, Event> eventData, Integer eventID, Integer teamID) {

		Team team = teamData.get(teamID);
		Event event = eventData.get(eventID);
		team.addEventToTeam(event);
		
		//add event to each player of the team
		for (Player player : team.getTeamPlayers()) {
			player.addEventToPlayer(event);
		}
		return teamData;

	}

	public Map<Integer, Team> getTeamData() {
		return teamData;
	}

	public void setTeamData(Map<Integer, Team> teamData) {
		this.teamData = teamData;
	}

	public void displayEventTeam(Event event) {
		
		for(Entry<Integer, Team> entry : teamData.entrySet()){
			if(entry.getValue().participatedInEvent(event)){
				entry.getValue().displayTeam();
				System.out.println();
			}
		}
		
	}
	
	public void displayAllTeams() {
		
		for ( Entry<Integer,Team> entry : teamData.entrySet()) {
			
			entry.getValue().displayTeam();
			System.out.println();
			
			
		}
		
	}


}
