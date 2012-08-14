import java.util.*;
import java.util.Map.Entry;

import configure.*;
import entities.*;

public class OlympicExercise {


	public static void main(String[] args) {


		Map<String,Sport>  sportData = new TreeMap<String, Sport>();
		Map<Integer,Event> eventData = new TreeMap<Integer,Event>();
		Map<Integer,Player> playerData= new TreeMap<Integer, Player>();
		Map<Integer,Team> teamData= new TreeMap<Integer, Team>();
		
		IDGenerator idGenerator=new IDGenerator();
		
		SportConfigurer c= new SportConfigurer();
		EventConfigurer e= new EventConfigurer();
		PlayerConfigurer p = new PlayerConfigurer();
		TeamConfigurer t= new TeamConfigurer();

		c.addSport(sportData, "Atheletics","London",idGenerator);

		e.addEvent(eventData, sportData, "100 m hurdle", "Womens", "I", "Atheletics",idGenerator);

		String [] languages=new String[2];
		languages[0]="English";
		languages[1]="Marathi";


		p.addPlayer(playerData, "Vidhi", "India", "F", "Bhagyashree", "SE", 100, 500,languages, idGenerator);
	
		Player [] newplayers=new Player[2];
		newplayers[0]=playerData.get(1);
		newplayers[1]=playerData.get(1);
		
		t.addTeam(teamData, newplayers, "India", idGenerator);

		
		for (Entry<String, Sport> entry : sportData.entrySet()) {
			entry.getValue().displaySport();
		}

		for (Entry<Integer, Event> entry : eventData.entrySet()) {
			entry.getValue().displayEvent();
		}
				
		for (Entry<Integer, Player> entry : playerData.entrySet()) {
			entry.getValue().displayPlayer();
		}
				
		teamData.get(1).displayTeam();
		
		t.addTeamEvent(teamData, eventData, 1, 1);
		
		teamData.get(1).displayTeam();
		
		p.addPlayerEvent(playerData, eventData, 1, 1);
		
		playerData.get(1).displayPlayer();
		
	}

}
