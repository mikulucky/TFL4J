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
