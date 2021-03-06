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
  public List<Line> getRailLines() throws IOException {
    return mapList(Line.class, getData("https://api.tfl.gov.uk/Line/Mode/national-rail"));
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
