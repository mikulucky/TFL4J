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
package uk.co.orangefoundry.tfl4j.airquality.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AirQuality {

  private String updatePeriod;
  private String forecastURL;
  private String disclaimerText;
  private int updateFrequency;

  List<Forecast> currentForecast = new ArrayList<Forecast>();

  public String getUpdatePeriod() {
    return updatePeriod;
  }

  public void setUpdatePeriod(String updatePeriod) {
    this.updatePeriod = updatePeriod;
  }

  public String getForecastURL() {
    return forecastURL;
  }

  public void setForecastURL(String forecastURL) {
    this.forecastURL = forecastURL;
  }

  public String getDisclaimerText() {
    return disclaimerText;
  }

  public void setDisclaimerText(String disclaimerText) {
    this.disclaimerText = disclaimerText;
  }

  public int getUpdateFrequency() {
    return updateFrequency;
  }

  public void setUpdateFrequency(int updateFrequency) {
    this.updateFrequency = updateFrequency;
  }

  public List<Forecast> getCurrentForecast() {
    return currentForecast;
  }

  public void setCurrentForecast(List<Forecast> currentForecast) {
    this.currentForecast = currentForecast;
  }

  @Override
  public String toString() {
    return "AirQuality{" +
        "updatePeriod='" + updatePeriod + '\'' +
        ", forecastURL='" + forecastURL + '\'' +
        ", disclaimerText='" + disclaimerText + '\'' +
        ", updateFrequency=" + updateFrequency +
        ", currentForecast=" + currentForecast +
        '}';
  }
}
