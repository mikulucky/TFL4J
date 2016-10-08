package uk.co.orangefoundry.tfl4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.orangefoundry.tfl4j.airquality.AirQualityService;
import uk.co.orangefoundry.tfl4j.airquality.dto.AirQuality;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class AirQualityServiceTest {

  private AirQualityService airQualityService = new AirQualityService();

  @Test
  public void testGetAirQuality() throws Exception {
    AirQuality airQualityForecast = airQualityService.getAirQualityForecast();
    assertNotNull(airQualityForecast);
    assertFalse(airQualityForecast.getCurrentForecast().isEmpty());
  }
}