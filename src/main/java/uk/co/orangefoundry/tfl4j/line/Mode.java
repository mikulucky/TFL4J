package uk.co.orangefoundry.tfl4j.line;

public enum Mode {

  BUS("bus"),TUBE("tube");

  private String name;

  Mode(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
