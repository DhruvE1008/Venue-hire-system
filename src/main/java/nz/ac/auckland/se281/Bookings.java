package nz.ac.auckland.se281;

public class Bookings {
  private String venueCode;
  private String date;
  private String email;
  private String attendance;
  private String bookingCode;
  
  public Bookings(String venueCode, String date, String email, String attendance, String bookingCode) {
    this.venueCode = venueCode;
    this.date = date;
    this.email = email;
    this.attendance = attendance;
    this.bookingCode = bookingCode;
  }

  public String getVenueCode() {
    return venueCode;
  }
  
  public String getDate() {
    return date;
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
}
