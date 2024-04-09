package nz.ac.auckland.se281;

public class Music extends Services {
  public Music(String serviceType, String bookingReference) {
    super(serviceType, bookingReference);
  }

  @Override
  public String getServiceName() {
    return null;
  }

  @Override
  public int getPrice() {
    return 500;
  }
}
