package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  // class variable that stores the number of venues
  private int venueCount = 0;

  public VenueHireSystem() {}

  public void printVenues() {
    if (venueCount == 0) {
      MessageCli.NO_VENUES.printMessage();
    } else if (venueCount == 1) {
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    String createVenueMessage;
    try {
      int capacityNum = Integer.parseInt(capacityInput);
      // converting the capacity from type String to type int
      if (capacityNum < 0) {
        createVenueMessage =
            MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.getMessage("capacity", " positive");
        System.out.println(createVenueMessage);
        return;
      }
    } catch (Exception e) {
      // if an error occurs the catch statement prevents the code from crashing
      createVenueMessage = MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.getMessage("capacity", "");
      System.out.println(createVenueMessage);
      return;
    }
    try {
      int hireFeeNum = Integer.parseInt(hireFeeInput);
      // converts the hireFeeInput from type String to type int
    } catch (Exception e) {
      // if there is an error when converting data types an error message will be output
      createVenueMessage = MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.getMessage("hire fee", "");
      System.out.println(createVenueMessage);
      return;
    }

    if (venueName.isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
    } else {
      // if venueName is not empty, capacityInput is positive and hireFeeInput is an integer in type
      // String
      // the venue will be created
      createVenueMessage = MessageCli.VENUE_SUCCESSFULLY_CREATED.getMessage(venueName, venueCode);
      System.out.println(createVenueMessage);
      venueCount++;
    }
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
