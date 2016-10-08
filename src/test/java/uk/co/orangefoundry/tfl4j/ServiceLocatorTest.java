package uk.co.orangefoundry.tfl4j;

import org.junit.Test;
import uk.co.orangefoundry.tfl4j.airquality.AirQualityService;
import uk.co.orangefoundry.tfl4j.airquality.dto.AirQuality;

import static org.junit.Assert.assertNotNull;

public class ServiceLocatorTest {

  ServiceLocator serviceLocator = new ServiceLocator();

  @Test
  public void testGetAirQaulityService() throws Exception {
    AirQualityService airQualityService = serviceLocator.getAirQualityService();
    assertNotNull(airQualityService);
    AirQuality forecast = airQualityService.getAirQualityForecast();
    assertNotNull(forecast);
  }
}