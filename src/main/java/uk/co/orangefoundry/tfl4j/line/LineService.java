package uk.co.orangefoundry.tfl4j.line;

import uk.co.orangefoundry.tfl4j.AbstractService;
import uk.co.orangefoundry.tfl4j.ClientWrapper;

import java.io.IOException;
import java.util.List;

/**
 * /Line/Mode/{modes}/Disruption
 * /Line/Mode/{modes}
 */
public class LineService extends AbstractService {

  public LineService(ClientWrapper clientWrapper) {
    super(clientWrapper);
  }

  /**
   * /Line/Mode/{modes}
   *
   * @return
   * @throws IOException
   */
  public List<Line> getTubeLines() throws IOException {
    return mapList(Line.class, getData("https://api.tfl.gov.uk/Line/Mode/tube"));
  }

  /**
   * /Line/Mode/{modes}
   *
   * @return
   * @throws IOException
   */
  public List<Line> getBusLines() throws IOException {
    return mapList(Line.class, getData("https://api.tfl.gov.uk/Line/Mode/bus"));
  }

  /**
   * /Line/Mode/{modes}
   *
   * @param mode
   * @return
   * @throws IOException
   */
  public List<Line> getLines(Mode mode) throws IOException {
    return mapList(Line.class, getData("https://api.tfl.gov.uk/Line/Mode/" + mode.getName()));
  }

  /**
   * /Line/Mode/{modes}/Disruption
   *
   * @return
   * @throws IOException
   */
  public List<Disruption> getTubeDistruptions() throws IOException {
    return mapList(Disruption.class, getData("https://api.tfl.gov.uk/Line/Mode/tube/Disruption"));
  }

  /**
   * /Line/Mode/{modes}/Disruption
   *
   * @return
   * @throws IOException
   */
  public List<Disruption> getBusDisruptions() throws IOException {
    return mapList(Disruption.class, getData("https://api.tfl.gov.uk/Line/Mode/bus/Disruption"));
  }

  /**
   * /Line/Mode/{modes}/Disruption
   *
   * @param mode
   * @return
   * @throws IOException
   */
  public List<Disruption> getDisruptions(Mode mode) throws IOException {
    return mapList(Disruption.class, getData("https://api.tfl.gov.uk/Line/Mode/" + mode.getName() + "/Disruption"));
  }

  /**
   * Get all valid routes for all lines, including the name and id of the originating and terminating stops for each route.
   * <p>
   * /Line/Route
   *
   * @return
   */
  public List<Line> getLineRoute() throws IOException {
    return mapList(Line.class,getData("https://api.tfl.gov.uk/Line/Route"));
  }

  /**
   * Get all valid routes for given line ids, including the name and id of the originating and terminating stops for each route.
   *
   * /Line/{ids}/Route
   * @param id
   * @return
   * @throws IOException
   */
  public Line getLineRoute(String id) throws IOException {
    return map(Line.class,getData("https://api.tfl.gov.uk/Line/"+id+"/Route"));
  }
}
