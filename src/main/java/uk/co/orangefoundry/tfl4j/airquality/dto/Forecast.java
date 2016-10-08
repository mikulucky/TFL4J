package uk.co.orangefoundry.tfl4j.airquality.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {

  String forecastType;
  String forecastID;
  String publishedDate;
  Date fromDate;
  Date toDate;
  String forecastBand;
  String forecastSummary;
  String nO2Band;
  String o3Band;
  String pM10Band;
  String pM25Band;
  String sO2Band;
  String forecastText;

  public String getForecastType() {
    return forecastType;
  }

  public void setForecastType(String forecastType) {
    this.forecastType = forecastType;
  }

  public String getForecastID() {
    return forecastID;
  }

  public void setForecastID(String forecastID) {
    this.forecastID = forecastID;
  }

  public String getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(String publishedDate) {
    this.publishedDate = publishedDate;
  }

  public Date getFromDate() {
    return fromDate;
  }

  public void setFromDate(Date fromDate) {
    this.fromDate = fromDate;
  }

  public Date getToDate() {
    return toDate;
  }

  public void setToDate(Date toDate) {
    this.toDate = toDate;
  }

  public String getForecastBand() {
    return forecastBand;
  }

  public void setForecastBand(String forecastBand) {
    this.forecastBand = forecastBand;
  }

  public String getForecastSummary() {
    return forecastSummary;
  }

  public void setForecastSummary(String forecastSummary) {
    this.forecastSummary = forecastSummary;
  }

  public String getnO2Band() {
    return nO2Band;
  }

  public void setnO2Band(String nO2Band) {
    this.nO2Band = nO2Band;
  }

  public String getO3Band() {
    return o3Band;
  }

  public void setO3Band(String o3Band) {
    this.o3Band = o3Band;
  }

  public String getpM10Band() {
    return pM10Band;
  }

  public void setpM10Band(String pM10Band) {
    this.pM10Band = pM10Band;
  }

  public String getpM25Band() {
    return pM25Band;
  }

  public void setpM25Band(String pM25Band) {
    this.pM25Band = pM25Band;
  }

  public String getsO2Band() {
    return sO2Band;
  }

  public void setsO2Band(String sO2Band) {
    this.sO2Band = sO2Band;
  }

  public String getForecastText() {
    return forecastText;
  }

  public void setForecastText(String forecastText) {
    this.forecastText = forecastText;
  }

  @Override
  public String toString() {
    return "Forecast{" +
        "forecastType='" + forecastType + '\'' +
        ", forecastID='" + forecastID + '\'' +
        ", publishedDate='" + publishedDate + '\'' +
        ", fromDate=" + fromDate +
        ", toDate=" + toDate +
        ", forecastBand='" + forecastBand + '\'' +
        ", forecastSummary='" + forecastSummary + '\'' +
        ", nO2Band='" + nO2Band + '\'' +
        ", o3Band='" + o3Band + '\'' +
        ", pM10Band='" + pM10Band + '\'' +
        ", pM25Band='" + pM25Band + '\'' +
        ", sO2Band='" + sO2Band + '\'' +
        ", forecastText='" + forecastText + '\'' +
        '}';
  }
}
