package uk.co.orangefoundry.tfl4j.line;

import uk.co.orangefoundry.tfl4j.AbstractService;
import uk.co.orangefoundry.tfl4j.ClientWrapper;

import java.io.IOException;
import java.util.List;

public class LineService extends AbstractService{

  public LineService(ClientWrapper clientWrapper) {
    super(clientWrapper);
  }

  public List<Line> getTubeLines() throws IOException {
    return mapList(Line.class,getData("https://api.tfl.gov.uk/Line/Mode/tube"));
  }

  public List<Line> getBusLines() throws IOException {
    return mapList(Line.class,getData("https://api.tfl.gov.uk/Line/Mode/bus"));
  }

  public List<Line> getLines(Mode mode) throws IOException {
    return mapList(Line.class,getData("https://api.tfl.gov.uk/Line/Mode/"+mode.getName()));
  }
}
