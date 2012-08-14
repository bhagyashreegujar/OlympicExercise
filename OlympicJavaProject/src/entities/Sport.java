package entities;

//defines a Sport
public class Sport {
	
	private Integer sportID;
	private String sportName,sportLocation;

	//getters and setters
	public String getSportLocation() {
		return sportLocation;
	}
	public void setSportLocation(String sportLocation) {
		this.sportLocation = sportLocation;
	}
	
	public Sport(Integer sportID,String sportName,String sportLocation) {
		setSportID(sportID);
		setSportName(sportName);
		setSportLocation(sportLocation);
	}
	public Sport(){
		this.sportID=null;
		this.sportName=null;
	}

	public Integer getSportID() {
		return sportID;
	}

	public void setSportID(Integer sportID){
		this.sportID=sportID; 
	}

	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public void displaySport(){
		System.out.println("Sport ID : "+this.getSportID());
		System.out.println("Sport Name : "+this.getSportName());
		System.out.println("Sport Location : "+this.getSportLocation());
	}

}
