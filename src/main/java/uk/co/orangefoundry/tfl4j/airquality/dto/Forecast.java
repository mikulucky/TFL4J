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

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {

  String forecastType;
  String forecastID;
  Date publishedDate;
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

  public Date getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(Date publishedDate) {
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
