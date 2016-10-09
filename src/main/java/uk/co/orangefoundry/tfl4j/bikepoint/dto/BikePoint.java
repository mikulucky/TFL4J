package uk.co.orangefoundry.tfl4j.bikepoint.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import uk.co.orangefoundry.tfl4j.DTO;
import uk.co.orangefoundry.tfl4j.data.result.AdditionalProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BikePoint implements DTO {
  String id;
  String url;
  String commonName;
  String placeType;
  List<AdditionalProperty> additionalProperties = new ArrayList<AdditionalProperty>();
  String lat;
  String lon;

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
}
