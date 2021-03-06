/**
 * The MIT License
 * Copyright (c) 2016 Joseph McCarthy
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package uk.co.orangefoundry.tfl4j;

import org.junit.Test;
import uk.co.orangefoundry.tfl4j.airquality.AirQualityService;
import uk.co.orangefoundry.tfl4j.airquality.dto.AirQuality;
import uk.co.orangefoundry.tfl4j.bikepoint.BikePointService;
import uk.co.orangefoundry.tfl4j.cyclesuperhighway.CycleSuperHighwayService;
import uk.co.orangefoundry.tfl4j.line.LineService;

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

  @Test
  public void getBikePointService() throws Exception {
    BikePointService bikePointService = serviceLocator.getBikePointService();
    assertNotNull(bikePointService);
  }

  @Test
  public void getCycleSuperHighwayService() throws Exception {
    CycleSuperHighwayService cycleSuperHighwayService = serviceLocator.getCycleSuperHighwayService();
    assertNotNull(cycleSuperHighwayService);
  }

  @Test
  public void getLineService() throws Exception {
    LineService lineService = serviceLocator.getLineService();
    assertNotNull(lineService);
  }
}