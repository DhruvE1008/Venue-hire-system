package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.FloralType;

public class FloralList extends Services {
  private FloralType floralType;
  
  public FloralList(String serviceType, String bookingReference, FloralType floralType) {
    super(serviceType, bookingReference);
    this.floralType = floralType;
  }

  @Override
  public String getServiceName() {
    return floralType.getName();
  }

  @Override
  public int getPrice() {
    return floralType.getCost();
  }
}
