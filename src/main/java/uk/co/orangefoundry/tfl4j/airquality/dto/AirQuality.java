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
