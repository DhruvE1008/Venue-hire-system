package nz.ac.auckland.se281;

public abstract class Services {
  private String serviceType;
  private String bookingReference;

  public Services(String serviceType, String bookingReference) {
    this.serviceType = serviceType;
    this.bookingReference = bookingReference;
  }

  public String getServiceType() {
    return this.serviceType;
  }

  public String getbookingReference() {
    return this.bookingReference;
  }

  public abstract String getServiceName();

  public abstract int getPrice();
}
