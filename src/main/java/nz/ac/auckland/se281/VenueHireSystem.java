package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  // class variable that stores the number of venues
  private int venueCount = 0;
  // array lists with info about venues
  //private ArrayList<String> venueNames = new ArrayList<String>();
  //private ArrayList<String> venueCodes = new ArrayList<String>();
  //private ArrayList<String> venueCapacities = new ArrayList<String>();
  //private ArrayList<String> venueHireFees = new ArrayList<String>();
  // storing the String version of the numbers under 10 for the venue output message
  private ArrayList<Venues> venueList = new ArrayList<Venues>();
  private String[] nums = {"two", "three", "four", "five", "six", "seven", "eight", "nine"};

  public VenueHireSystem() {}

  public void printVenues() {
    // prints message based on number of venues
    if (venueCount == 0) {
      MessageCli.NO_VENUES.printMessage();
    } else if (venueCount == 1) {
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
    } else if (venueCount < 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", nums[venueCount - 2], "s");
    } else if (venueCount >= 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", Integer.toString(venueCount), "s");
    }
    // lists venues with their info
    for (Venues venue: venueList) {
      MessageCli.VENUE_ENTRY.printMessage(
          venue.getVenueName(), venue.getVenueCode(), venue.getCapacity(), venue.getHireFee());
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    String createVenueMessage;
    String newName = venueName.trim();
    try {
      int capacityNum = Integer.parseInt(capacityInput);
      // converting the capacity from type String to type int
      if (capacityNum < 1) {
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
      if (hireFeeNum < 1) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
        return;
      }
    } catch (Exception e) {
      // if there is an error when converting data types an error message will be output
      createVenueMessage = MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.getMessage("hire fee", "");
      System.out.println(createVenueMessage);
      return;
    }

    if (newName.isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
    } else {
      // checks if the venue code is unique
      for (Venues venue:  venueList) {
        if (venue.getVenueCode().equals(venueCode)) {
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(
              venue.getVenueCode(), venue.getVenueName());
          return;
        }
      }
      // if venueName is not empty, the venue code is unique, capacityInput is positive and
      // hireFeeInput
      // is an integer in type String the venue will be created
      createVenueMessage = MessageCli.VENUE_SUCCESSFULLY_CREATED.getMessage(venueName, venueCode);
      System.out.println(createVenueMessage);
      venueCount++;
      // adding values to the venue info array lists
      venueList.add(new Venues(venueName, venueCode, capacityInput, hireFeeInput));
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
