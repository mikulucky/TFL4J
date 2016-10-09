package uk.co.orangefoundry.tfl4j.airquality;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirQualityServiceConstantsTest {

  @Test
  public void testConstants() throws Exception {
    assertEquals("https://api.tfl.gov.uk/airquality", AirQualityServiceConstants.AIR_QUALITY_SERVICE);
  }
}