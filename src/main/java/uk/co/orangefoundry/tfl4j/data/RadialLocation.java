package uk.co.orangefoundry.tfl4j.data;

public class RadialLocation extends Location {

  private int radius;

  public RadialLocation(double latitude, double longitude, int radius) {
    super(latitude, longitude);
    this.radius = radius;
  }

  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }
}
