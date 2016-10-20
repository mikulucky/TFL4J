package uk.co.orangefoundry.tfl4j.line;

public enum Mode {

  BUS("bus"),TUBE("tube"),NATIONAL_RAIL("national-rail");

  private String name;

  Mode(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
