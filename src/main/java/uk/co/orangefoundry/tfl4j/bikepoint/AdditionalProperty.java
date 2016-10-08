package uk.co.orangefoundry.tfl4j.bikepoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalProperty {
  String category;
  String key;
  String sourceSystemKey;
  String value;
  Date modified;

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getSourceSystemKey() {
    return sourceSystemKey;
  }

  public void setSourceSystemKey(String sourceSystemKey) {
    this.sourceSystemKey = sourceSystemKey;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Date getModified() {
    return modified;
  }

  public void setModified(Date modified) {
    this.modified = modified;
  }
}
