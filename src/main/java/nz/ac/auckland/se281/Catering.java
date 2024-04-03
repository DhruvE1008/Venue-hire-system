package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class Catering extends Services {
  private CateringType cateringType;

  public Catering(String serviceType, String bookingReference, CateringType cateringType) {
    super(serviceType, bookingReference);
    this.cateringType = cateringType;
  }

  public String getServiceName() {
    return cateringType.getName();
  }

  public int getPrice() {
    return cateringType.getCostPerPerson();
  }
}
