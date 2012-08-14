package configure;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import entities.*;


// Configure an Event 
public class EventConfigurer {

	Map<Integer,Event> eventData = new TreeMap<Integer,Event>();
	Map<String,ArrayList<Integer>> medalTally=new TreeMap<String, ArrayList<Integer>>();

	IDGenerator idGenerator = new IDGenerator();

	//Add Event to eventData,gets object of Sport by sportName specified 
	public Map<Integer, Event> addEvent(Map<String,Sport> sportData,String eventName,String eventGenderType,String eventCategory,String sportName) {

		Sport eventSport=sportData.get(sportName);

		if (eventSport != null) {

			Integer eventID=idGenerator.generateEventID(eventData);
			Event event=new Event(eventSport, eventID, eventName, eventGenderType, eventCategory);
			eventData.put(eventID, event);

		} else {

			System.out.println("Sport does not exists.");

		}

		return eventData;

	}

	// add gold / silver / bronze medal record 
	public Map<Integer, Event> addMedals(Map<Integer, Event> eventData, String medalType, Integer eventID ,Integer winnerID,Medals medal) {

		Event event = eventData.get(eventID);
		switch (medal) {

		case Gold:
			event.setGoldWinnerID(winnerID);
			break;

		case Silver:
			event.setSilverWinnerID(winnerID);
			break;

		case Bronze:
			event.setBronzeWinnerID(winnerID);
			break;

		default:
			break;
		}
		return eventData;
	}

	public void displayAllEvents() {

		for ( Entry<Integer, Event> entry : eventData.entrySet()) {

			entry.getValue().displayEvent();
			System.out.println();

		}

	}

	//Medal Tally (gold, silver, bronze) by country	
	public void calculateMedalTallyByCountry(Map<Integer, Player> playerData, Map<Integer, Team> teamData) {

		Integer goldWinnerID,silverWinnerID,bronzeWinnerID;
		String country;

		medalTally.clear();
		for (Entry<Integer, Event> entry : eventData.entrySet()) {


			if(entry.getValue().getEventCategory().equals("INDIVIDUAL")){

				goldWinnerID=entry.getValue().getGoldWinnerID();
				silverWinnerID=entry.getValue().getSilverWinnerID();
				bronzeWinnerID=entry.getValue().getBronzeWinnerID();

				//adding gold medal to tally
				country=playerData.get(goldWinnerID).getPlayerCountry();
				if(medalTally.containsKey(country)){
					medalTally.get(country).set(0, medalTally.get(country).get(0)+1);
				}
				else{
					ArrayList<Integer> medals = new ArrayList<Integer>();
					medals.add(1);
					medals.add(0);
					medals.add(0);
					medalTally.put(country, medals);
				}

				//adding silver medal to tally
				country=playerData.get(silverWinnerID).getPlayerCountry();
				if(medalTally.containsKey(country)){
					medalTally.get(country).set(1, medalTally.get(country).get(1)+1);
				}
				else{
					ArrayList<Integer> medals = new ArrayList<Integer>();
					medals.add(0);
					medals.add(1);
					medals.add(0);
					medalTally.put(country, medals);
				}


				//adding bronze medal to tally
				country=playerData.get(bronzeWinnerID).getPlayerCountry();
				if(medalTally.containsKey(country)){
					medalTally.get(country).set(2, medalTally.get(country).get(2)+1);
				}
				else{
					ArrayList<Integer> medals = new ArrayList<Integer>();
					medals.add(0);
					medals.add(0);
					medals.add(1);

					medalTally.put(country, medals);
				}

			}
			else{ // for team

				goldWinnerID=entry.getValue().getGoldWinnerID();
				silverWinnerID=entry.getValue().getSilverWinnerID();
				bronzeWinnerID=entry.getValue().getBronzeWinnerID();

				//adding gold medal to tally
				country=teamData.get(goldWinnerID).getTeamCountryName();
				if(medalTally.containsKey(country)){
					medalTally.get(country).set(0, medalTally.get(country).get(0)+1);
				}
				else{
					ArrayList<Integer> medals = new ArrayList<Integer>();
					medals.add(1);
					medals.add(0);
					medals.add(0);
					medalTally.put(country, medals);
				}

				//adding silver medal to tally
				country=teamData.get(silverWinnerID).getTeamCountryName();
				if(medalTally.containsKey(country)){
					medalTally.get(country).set(1, medalTally.get(country).get(1)+1);
				}
				else{
					ArrayList<Integer> medals = new ArrayList<Integer>();
					medals.add(0);
					medals.add(1);
					medals.add(0);
					medalTally.put(country, medals);
				}


				//adding bronze medal to tally
				country=teamData.get(bronzeWinnerID).getTeamCountryName();
				if(medalTally.containsKey(country)){
					medalTally.get(country).set(2, medalTally.get(country).get(2)+1);
				}
				else{
					ArrayList<Integer> medals = new ArrayList<Integer>();
					medals.add(0);
					medals.add(0);
					medals.add(1);

					medalTally.put(country, medals);
				}

			}
		}//for

		System.out.println("Country | Gold | Silver | Bronze");
		//display on console
		for (Entry<String, ArrayList<Integer>> entry:medalTally.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue().get(0)+""+entry.getValue().get(1)+""+entry.getValue().get(2));

		}

	}

	//Medal winners (players) and their countries for each game played
	public void calculateMedalWinnersByEvent(Map<Integer, Player> playerData, Map<Integer, Team> teamData,Map<String,Sport> sportData) {

		for (Entry<String,Sport> sportEntry:sportData.entrySet()) {

			System.out.println("Sport : "+sportEntry.getValue().getSportName());
			System.out.println();
			for (Entry<Integer, Event> entry : eventData.entrySet()) {

				if(entry.getValue().getEventSport().getSportName().equals(sportEntry.getValue().getSportName())){


					if (entry.getValue().getEventCategory().equals("INDIVIDUAL")) {
						System.out.print(entry.getValue().getEventName());

						Player player=playerData.get(entry.getValue().getGoldWinnerID());
						System.out.print("Gold Winner : ");
						System.out.print(player.getPlayerName());
						System.out.print(player.getPlayerCountry());
						System.out.println();

						player=playerData.get(entry.getValue().getSilverWinnerID());
						System.out.print("Silver Winner : ");
						System.out.print(player.getPlayerName());
						System.out.println(player.getPlayerCountry());
						System.out.println();

						player=playerData.get(entry.getValue().getBronzeWinnerID());
						System.out.print("Bronze Winner : ");
						System.out.println(player.getPlayerName());
						System.out.println(player.getPlayerCountry());
						System.out.println();

					} else {//team

						System.out.print(entry.getValue().getEventName());

						Team team=teamData.get(entry.getValue().getGoldWinnerID());
						System.out.print("Gold Winner : ");
						System.out.print(team.getTeamID());
						System.out.print(team.getTeamCountryName());
						System.out.println();

						team=teamData.get(entry.getValue().getSilverWinnerID());
						System.out.print("Silver Winner : ");
						System.out.print(team.getTeamID());
						System.out.print(team.getTeamCountryName());
						System.out.println();

						team=teamData.get(entry.getValue().getBronzeWinnerID());
						System.out.print("Bronze Winner : ");
						System.out.print(team.getTeamID());
						System.out.print(team.getTeamCountryName());
						System.out.println();
					}

				}
			}
		}

	}

	//Medal winners (players) and their games for each country
	public void medalWinnersByCountry(Map<String,Sport> sportData,Map<Integer,Player> playerData,Map<Integer, Team> teamData) {

//	
//		Map<String,Map<Player,Map<Sport,ArrayList<Event>>>> medalWinnerByCountry=new TreeMap<String,Map<Player,Map<Sport,ArrayList<Event>>>>(); 
//
//		for (Entry<Integer, Player> playerEntry : playerData.entrySet()){
//			
//			String country=playerEntry.getValue().getPlayerCountry();
//
//			if (medalWinnerByCountry.containsKey(country)) {
//				
//			} else {
//				
//				Map<Player,Map<Sport,ArrayList<Event>>> countryMedal = new TreeMap<Player,Map<Sport,ArrayList<Event>>>();
//				
//				for(Sport sports : playerEntry.getValue().getPlayerSports()){
//					
//					Map<Sport,ArrayList<Event>> sportEvents= new TreeMap<Sport,ArrayList<Event>>();
//					ArrayList<Event> eventEntry = new ArrayList<Event>();
//					
//					for(Event events : playerEntry.getValue().getPlayerEvents()){
//
//						if(events.getEventSport().getSportName().equals(sports.getSportName())){
//						
//							if(events.getGoldWinnerID()==playerEntry.getValue().getPlayerID()||events.getSilverWinnerID()==playerEntry.getValue().getPlayerID()||events.getBronzeWinnerID()==playerEntry.getValue().getPlayerID()){
//								
//							
//							}
//						}
//						
//					}
//					
//				}
//
//			}
//		}
		
	}


	//getter and setters
	public Map<Integer, Event> getEventData() {
		return eventData;
	}

	public void setEventData(Map<Integer, Event> eventData) {
		this.eventData = eventData;
	}

}
