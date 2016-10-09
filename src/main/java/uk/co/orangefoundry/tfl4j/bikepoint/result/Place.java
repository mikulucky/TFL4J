package uk.co.orangefoundry.tfl4j.bikepoint.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import uk.co.orangefoundry.tfl4j.bikepoint.AdditionalProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Place {

  String id;
  String url;
  String commonName;
  double distance;
  String placeType;
  List<AdditionalProperty> additionalProperties = new ArrayList<AdditionalProperty>();
  String lat;
  String lon;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getCommonName() {
    return commonName;
  }

  public void setCommonName(String commonName) {
    this.commonName = commonName;
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }

  public String getPlaceType() {
    return placeType;
  }

  public void setPlaceType(String placeType) {
    this.placeType = placeType;
  }

  public List<AdditionalProperty> getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(List<AdditionalProperty> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public String getLon() {
    return lon;
  }

  public void setLon(String lon) {
    this.lon = lon;
  }
}
