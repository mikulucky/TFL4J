package uk.co.orangefoundry.tfl4j.line;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Line {

  private String id;
  private String name;
  private String modeName;
  private Date created;
  private Date modified;
  private List<RouteSection> routeSections = new ArrayList<RouteSection>();

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getModeName() {
    return modeName;
  }

  public void setModeName(String modeName) {
    this.modeName = modeName;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getModified() {
    return modified;
  }

  public void setModified(Date modified) {
    this.modified = modified;
  }

  public List<RouteSection> getRouteSections() {
    return routeSections;
  }

  public void setRouteSections(List<RouteSection> routeSections) {
    this.routeSections = routeSections;
  }
}
