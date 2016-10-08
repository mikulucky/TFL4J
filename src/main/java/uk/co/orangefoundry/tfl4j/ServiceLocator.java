package uk.co.orangefoundry.tfl4j;

import uk.co.orangefoundry.tfl4j.airquality.AirQualityService;

public class ServiceLocator {

  public AirQualityService getAirQualityService(){
    return new AirQualityService();
  }
}
