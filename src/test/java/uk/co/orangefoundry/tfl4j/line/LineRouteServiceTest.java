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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.orangefoundry.tfl4j.DataBasedTest;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class LineRouteServiceTest extends DataBasedTest {

  private LineService lineService = new LineService(mockServer);

  @Test
  public void testGetRoutes() throws Exception {
    setMockResponse("https://api.tfl.gov.uk/Line/Route","data/line/route/all.json");
    List<Line> results = lineService.getLineRoute();
    assertNotNull(results);
    assertFalse(results.isEmpty());
    assertEquals(717,results.size());

    Line line = results.get(0);
    assertEquals("1",line.getId());
    assertEquals("1",line.getName());
    assertEquals("bus",line.getModeName());
    assertNotNull(line.getCreated());
    assertNotNull(line.getModified());

    assertNotNull(line.getRouteSections());
    assertFalse(line.getRouteSections().isEmpty());
    assertEquals(2,line.getRouteSections().size());

    RouteSection routeSection = line.getRouteSections().get(0);
    assertNotNull(routeSection);
    assertEquals("Canada Water Bus Station - Tottenham Court Road",routeSection.getName());
    assertEquals("inbound",routeSection.getDirection());
    assertEquals("Canada Water Bus Station",routeSection.getOriginationName());
    assertEquals("Tottenham Court Road",routeSection.getDestinationName());
    assertEquals("490004733C",routeSection.getOriginator());
    assertEquals("490000235N",routeSection.getDestination());
    assertEquals("Regular",routeSection.getServiceType());
  }

  @Test
  public void testGetLineRoute() throws Exception {
    setMockResponse("https://api.tfl.gov.uk/Line/1/Route","data/line/route/single.json");
    Line line = lineService.getLineRoute("1");
    assertNotNull(line);

    assertEquals("1",line.getId());
    assertEquals("1",line.getName());
    assertEquals("bus",line.getModeName());
    assertNotNull(line.getCreated());
    assertNotNull(line.getModified());

    assertNotNull(line.getRouteSections());
    assertFalse(line.getRouteSections().isEmpty());
    assertEquals(2,line.getRouteSections().size());

    RouteSection routeSection = line.getRouteSections().get(0);
    assertNotNull(routeSection);
    assertEquals("Canada Water Bus Station - Tottenham Court Road",routeSection.getName());
    assertEquals("inbound",routeSection.getDirection());
    assertEquals("Canada Water Bus Station",routeSection.getOriginationName());
    assertEquals("Tottenham Court Road",routeSection.getDestinationName());
    assertEquals("490004733C",routeSection.getOriginator());
    assertEquals("490000235N",routeSection.getDestination());
    assertEquals("Regular",routeSection.getServiceType());
  }
}
