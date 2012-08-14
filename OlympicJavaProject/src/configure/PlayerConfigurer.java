package configure;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import entities.*;


//Configures Player details
public class PlayerConfigurer {
	
	Map<Integer,Player> playerData= new TreeMap<Integer, Player>();
	IDGenerator idGenerator = new IDGenerator();
	
	public Map<Integer, Player> addPlayer(String playerName,String playerCountry,String playerGender,String playerCoach,String playerOccupation,double playerHeight,double playerWeight
			) {
		
		
		Integer playerID=idGenerator.generatePlayerID(playerData);
		Player player=new Player(playerID,playerName, playerCountry, playerGender, playerCoach, playerOccupation, playerHeight, playerWeight);	
		playerData.put(playerID, player);
		return playerData;
	}

	public Map<Integer, Player> addPlayerEvent(Map<Integer, Event> eventData, Integer playerID, Integer eventID) {
		
		Player player = playerData.get(playerID);
		Event event = eventData.get(eventID);
		player.addEventToPlayer(event);
		return playerData;
		
	}
	
	public void displayAllPlayers() {
		
		for (Entry<Integer, Player> entry : playerData.entrySet()) {
			entry.getValue().displayPlayer();
			System.out.println();
		}
	}
	
	public void displayCountryPlayers(String country) {
		
		for (Entry<Integer, Player> entry : playerData.entrySet()) {
			if (entry.getValue().getPlayerCountry().equals(country)) {
				
				entry.getValue().displayPlayer();
				System.out.println();
				
			}
		}
	}
	
	public void displayEventPlayer(Event event) {
		
		for(Entry<Integer, Player> entry : playerData.entrySet()){
			if(entry.getValue().participatedInEvent(event)){
				entry.getValue().displayPlayer();
				System.out.println();
			}
		}
		
	}

	public Map<Integer, Player> getPlayerData() {
		return playerData;
	}

	public void setPlayerData(Map<Integer, Player> playerData) {
		this.playerData = playerData;
	}
	
	
}
