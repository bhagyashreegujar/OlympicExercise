package entities;

//defines an event in a particular sport
public class Event {

	//eventgendertype can be either mens / womens / mixed
	//event category can be individual / team (any event played by more than one player together is included in team event)
	//an event can be of a sport whcich exists in the list of added sports ie sportsData
	private Integer eventID,goldWinnerID,silverWinnerID,bronzeWinnerID;
	private String eventName,eventGenderType,eventCategory;
	private Sport eventSport=null;

	// getters and setters
	public Integer getEventID() {
		return eventID;
	}
	public void setEventID(Integer eventID) {
		this.eventID = eventID;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getEventGenderType() {
		return eventGenderType;
	}
	public void setEventGenderType(String eventGenderType) {
		this.eventGenderType = eventGenderType;
	}
	public String getEventCategory() {
		return eventCategory;
	}
	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}
	public Integer getGoldWinnerID() {
		return goldWinnerID;
	}
	public void setGoldWinnerID(Integer goldWinnerID) {
		this.goldWinnerID = goldWinnerID;
	}
	public Integer getSilverWinnerID() {
		return silverWinnerID;
	}
	public void setSilverWinnerID(Integer silverWinnerID) {
		this.silverWinnerID = silverWinnerID;
	}
	public Integer getBronzeWinnerID() {
		return bronzeWinnerID;
	}
	public void setBronzeWinnerID(Integer bronzeWinnerID) {
		this.bronzeWinnerID = bronzeWinnerID;
	}
	public Sport getEventSport() {
		return eventSport;
	}
	public void setEventSport(Sport eventSport) {
		this.eventSport = eventSport;
	}
	
    //parametrised event constructer defined
	public Event(Sport eventSport,Integer eventID,String eventName,String eventGenderType,String eventCategory){
		setEventID(eventID);
		setEventName(eventName);
		setEventGenderType(eventGenderType);
		setEventCategory(eventCategory);
		setEventSport(eventSport);
	}
	
	public void displayEvent() {
		System.out.println("Event id : "+this.getEventID());
		System.out.println("Event Name : "+this.getEventName());
		System.out.println("Event category : "+this.getEventCategory());
		System.out.println("Event sport : "+this.getEventSport().getSportName());
		System.out.println("Event Gender type : "+this.getEventGenderType());
		
	}

}
