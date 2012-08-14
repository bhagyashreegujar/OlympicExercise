package configure;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import entities.*;


// Configure a sport
public class SportConfigurer {

	Map<String,Sport>  sportData = new TreeMap<String, Sport>();
	IDGenerator idGenerator = new IDGenerator();

	// add a new sport to sportData if does not exist
	public Map<String, Sport> addSport(String sportName,String sportLocation){

		if (sportData.containsKey(sportName)) {
			System.out.println("Sport already exists.");

		} else {
			Integer sportID=idGenerator.generateSportID(sportData);
			Sport sport = new Sport(sportID,sportName,sportLocation);
			sportData.put(sportName,sport);
		}

		return sportData;
	}
	
	
	public void displayAllSports() {
	
		for (Entry<String, Sport> entry : sportData.entrySet()) {
			entry.getValue().displaySport();
		}
		System.out.println();
	}
	
	
	public Map<String, Sport> getSportData() {
		return sportData;
	}

	public void setSportData(Map<String, Sport> sportData) {
		this.sportData = sportData;
	}

}
