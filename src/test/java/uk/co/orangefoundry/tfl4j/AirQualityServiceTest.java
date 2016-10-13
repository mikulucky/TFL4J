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

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.orangefoundry.tfl4j.airquality.AirQualityService;
import uk.co.orangefoundry.tfl4j.airquality.dto.AirQuality;
import uk.co.orangefoundry.tfl4j.airquality.dto.Forecast;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AirQualityServiceTest {

  private AirQualityService airQualityService = new AirQualityService();

  @Test
  public void testGetAirQuality() throws Exception {
    AirQuality airQualityForecast = airQualityService.getAirQualityForecast();
    assertNotNull(airQualityForecast);
    assertFalse(airQualityForecast.getCurrentForecast().isEmpty());
  }

  @Test
  public void testPoJo() throws Exception {
    AirQuality airQualityForecast = airQualityService.getAirQualityForecast();
    assertNotNull(airQualityForecast);
    assertTrue(StringUtils.isNoneEmpty(airQualityForecast.getDisclaimerText()));
    assertTrue(StringUtils.isNoneEmpty(airQualityForecast.getForecastURL()));
    assertTrue(StringUtils.isNoneEmpty(airQualityForecast.toString()));
    assertTrue(StringUtils.isNoneEmpty(airQualityForecast.getUpdatePeriod()));
    assertEquals(1, airQualityForecast.getUpdateFrequency());

    assertNotNull(airQualityForecast.getCurrentForecast());
    assertFalse(airQualityForecast.getCurrentForecast().isEmpty());

    Forecast forecast = airQualityForecast.getCurrentForecast().get(0);

    assertTrue(StringUtils.isNoneEmpty(forecast.getForecastBand()));
    assertTrue(StringUtils.isNoneEmpty(forecast.getForecastID()));
    assertTrue(StringUtils.isNoneEmpty(forecast.getForecastSummary()));
    assertTrue(StringUtils.isNoneEmpty(forecast.getForecastText()));
    assertTrue(StringUtils.isNoneEmpty(forecast.getForecastType()));
    assertTrue(StringUtils.isNoneEmpty(forecast.getnO2Band()));
    assertTrue(StringUtils.isNoneEmpty(forecast.getO3Band()));
    assertTrue(StringUtils.isNoneEmpty(forecast.getpM10Band()));
    assertTrue(StringUtils.isNoneEmpty(forecast.getsO2Band()));
    assertTrue(StringUtils.isNoneEmpty(forecast.getpM25Band()));
    assertNotNull(forecast.getPublishedDate());

  }
}