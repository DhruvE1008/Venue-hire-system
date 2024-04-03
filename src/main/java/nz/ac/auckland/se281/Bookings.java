package nz.ac.auckland.se281;

public class Bookings {
  private String venueCode;
  private String partyDate;
  private String email;
  private String attendance;
  private String bookingCode;
  private String dateOfBooking;
  
  public Bookings(
      String venueCode, 
      String date, 
      String email, 
      String attendance, 
      String bookingCode, 
      String dateOfBooking) {
    this.venueCode = venueCode;
    this.partyDate = date;
    this.email = email;
    this.attendance = attendance;
    this.bookingCode = bookingCode;
    this.dateOfBooking = dateOfBooking;
  }

  public String getVenueCode() {
    return venueCode;
  }
  
  public String getPartyDate() {
    return partyDate;
  } 

  public String getEmail() {
    return email;
  } 
  
  public String getAttendance() {
    return attendance;
  } 
  
  public String getBookingCode() {
    return bookingCode; 
  }
  
  public String getBookingDate() {
    return dateOfBooking;
  }
}
