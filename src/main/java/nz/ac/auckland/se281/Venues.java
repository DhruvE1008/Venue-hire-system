package nz.ac.auckland.se281;

public class Venues {

  private String venueName;
  private String venueCode;
  private String capacity;
  private String hireFee;

  public Venues(String venueName, String venueCode, String capacity, String hireFee) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacity = capacity;
    this.hireFee = hireFee;
  }

  public String getVenueName() {
    return venueName;
  }
  
  public String getVenueCode() {
    return venueCode;
  } 

  public String getCapacity() {
    return capacity;
  } 
  
  public String getHireFee() {
    return hireFee;
  } 
}
