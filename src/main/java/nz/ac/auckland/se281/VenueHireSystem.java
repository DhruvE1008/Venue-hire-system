package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  // class variable that stores the number of venues
  private int venueCount = 0;
  // variable that stores the date set
  private String date = "";
  // array list that stores the venue info
  private ArrayList<Venues> venueList = new ArrayList<Venues>();
  // storing the String version of the numbers under 10 for the venue output message
  private String[] nums = {"two", "three", "four", "five", "six", "seven", "eight", "nine"};
  // array list that stores the booking info
  private ArrayList<Bookings> bookingList = new ArrayList<Bookings>();

  public VenueHireSystem() {}

  public void printVenues() {
    String[] dateStrings;
    String newDate;
    int bookingCount;
    String day;

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
    dateStrings = date.split("/");
    newDate = date;
    for (Venues venue : venueList) {
      day = dateStrings[0];
      bookingCount = 0;
      while (bookingCount < bookingList.size()) {
        if (venue.getVenueCode().equals(bookingList.get(bookingCount).getVenueCode())
            && bookingList.get(bookingCount).getDate().equals(newDate)) {
          try {
            int dayInt = Integer.parseInt(day) + 1;
            // if the day of the month is less than 10 a 0 is added to front
            if (dayInt < 10) {
              StringBuilder sb = new StringBuilder();
              sb.append(0);
              sb.append(dayInt);
              day = sb.toString();
            } else {
              day = String.valueOf(dayInt);
            }
          } catch (Exception e) {

          }
          newDate = String.valueOf(day) + "/" + dateStrings[1] + "/" + dateStrings[2];
          bookingCount = 0;
        }
        bookingCount++;
      }
      // creates the next available date for booking
      newDate = String.valueOf(day) + "/" + dateStrings[1] + "/" + dateStrings[2];
      MessageCli.VENUE_ENTRY.printMessage(
          venue.getVenueName(),
          venue.getVenueCode(),
          venue.getCapacity(),
          venue.getHireFee(),
          newDate);
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    String newName = venueName.trim();
    int hireFeeNum;

    try {
      int capacityNum = Integer.parseInt(capacityInput);
      // converting the capacity from type String to type int
      if (capacityNum < 1) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
        return;
      }
    } catch (Exception e) {
      // if an error occurs the catch statement prevents the code from crashing
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
      return;
    }
    try {
      hireFeeNum = Integer.parseInt(hireFeeInput);
      // converts the hireFeeInput from type String to type int
      if (hireFeeNum < 1) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
        return;
      }
    } catch (Exception e) {
      // if there is an error when converting data types an error message will be output
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return;
    }

    if (newName.isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
    } else {
      // checks if the venue code is unique
      for (Venues venue : venueList) {
        if (venue.getVenueCode().equals(venueCode)) {
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(
              venue.getVenueCode(), venue.getVenueName());
          return;
        }
      }
      // if venueName is not empty, the venue code is unique, capacityInput is positive and
      // hireFeeInput is an integer in type String the venue will be created
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
      venueCount++;
      // adding values to the venue info array lists
      venueList.add(new Venues(venueName, venueCode, capacityInput, hireFeeInput));
    }
  }

  public void setSystemDate(String dateInput) {
    date = dateInput;
    MessageCli.DATE_SET.printMessage(dateInput);
  }

  public void printSystemDate() {
    if (date.isEmpty()) {
      MessageCli.CURRENT_DATE.printMessage("not set");
    } else {
      MessageCli.CURRENT_DATE.printMessage(date);
    }
  }

  public void makeBooking(String[] options) {
    int capacityNum;
    int attendees;
    String bookingCode;
    String[] currentDate = date.split("/");
    String[] bookingDate = options[1].split("/");

    // checks if date has been set
    if (date.isEmpty()) {
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
      return;
    }
    // checks if there are 0 venues
    if (venueCount == 0) {
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
      return;
    }
    // checks if the booking date is today or in the future
    try {
      if (Integer.parseInt(bookingDate[2]) < Integer.parseInt(currentDate[2])) {
        MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], date);
        return;
      } else if (Integer.parseInt(bookingDate[2]) == Integer.parseInt(currentDate[2])) {
        if (Integer.parseInt(bookingDate[1]) < Integer.parseInt(currentDate[1])) {
          MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], date);
          return;
        } else if (Integer.parseInt(bookingDate[1]) == Integer.parseInt(currentDate[1])) {
          if (Integer.parseInt(bookingDate[0]) < Integer.parseInt(currentDate[0])) {
            MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], date);
            return;
          }
        }
      }
    } catch (Exception e) {

    }
    // checks if there has been a booking on the date
    for (Bookings booking : bookingList) {
      if (options[1].equals(booking.getDate())) {
        for (Venues venue : venueList) {
          if (options[0].equals(venue.getVenueCode())) {
            MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(
                venue.getVenueName(), options[1]);
            return;
          }
        }
      }
    }
    // checks if the venue code given as input has a venue associated with it
    for (Venues venue : venueList) {
      if (options[0].equals(venue.getVenueCode())) {
        bookingCode = BookingReferenceGenerator.generateBookingReference();
        bookingList.add(new Bookings(options[0], options[1], options[2], options[3], bookingCode));
        // checks if the number of attendees are less than 25% of the capacity of the venue or the
        // number of attendees are more than the capacity of the venue
        try {
          capacityNum = Integer.parseInt(venue.getCapacity());
          attendees = Integer.parseInt(options[3]);
          if (attendees < (capacityNum / 4)) {
            MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
                options[3], String.valueOf(capacityNum / 4), venue.getCapacity());
            options[3] = String.valueOf(attendees);
          } else if (attendees > capacityNum) {
            MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
                options[3], String.valueOf(capacityNum), venue.getCapacity());
            options[3] = venue.getCapacity();
          }
        } catch (Exception e) {

        }
        MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(
            bookingCode, venue.getVenueName(), options[1], options[3]);
        return;
      }
    }
    MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(options[0]);
  }

  public void printBookings(String venueCode) {
    int venueFound = -1;
    boolean bookingFound = false;
    for (int i = 0; i < venueList.size(); i++) {
      if (venueList.get(i).getVenueCode().equals(venueCode)) {
        MessageCli.PRINT_BOOKINGS_HEADER.printMessage(venueList.get(i).getVenueName());
        venueFound = i;
      }
    }
    for (Bookings booking : bookingList) {
      if (booking.getVenueCode().equals(venueCode)) {
        MessageCli.PRINT_BOOKINGS_ENTRY.printMessage(booking.getBookingCode(), booking.getDate());
        bookingFound = true;
      }
    }
    if (bookingFound == true) {
      return;
    }
    if (venueFound == -1) {
      MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
    } else {
      MessageCli.PRINT_BOOKINGS_NONE.printMessage(venueList.get(venueFound).getVenueName());
    }
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
