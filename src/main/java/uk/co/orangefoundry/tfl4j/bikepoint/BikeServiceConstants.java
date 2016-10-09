package uk.co.orangefoundry.tfl4j.bikepoint;

import uk.co.orangefoundry.tfl4j.ServiceConstants;

public class BikeServiceConstants extends ServiceConstants {

  public static final String BIKE_POINT = TFL + "BikePoint/";
  public static final String SEARCH = BIKE_POINT + "Search?query=%s";
  public static final String RADIUS_SEARCH = BIKE_POINT + "?lat=%f&lon=%f&radius=%d";
  public static final String BOX_SEARCH = BIKE_POINT + "?swLat=%f&swLon=%f&neLat=%f&neLon=%f";

}
