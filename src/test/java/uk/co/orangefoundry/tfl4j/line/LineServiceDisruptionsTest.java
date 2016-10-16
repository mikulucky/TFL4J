package uk.co.orangefoundry.tfl4j.line;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.orangefoundry.tfl4j.DataBasedTest;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class LineServiceDisruptionsTest extends DataBasedTest {

  private LineService lineService = new LineService(mockServer);

  @Test
  public void testGetDisruptionsByTube() throws Exception {
    setMockResponse("https://api.tfl.gov.uk/Line/Mode/tube/Disruption","data/line/disruptions/tube.json");

    List<Disruption> disruptionList = lineService.getTubeDistruptions();
    assertNotNull(disruptionList);
    assertEquals(1, disruptionList.size());

    Disruption disruption = disruptionList.get(0);

    assertEquals("RealTime", disruption.getCategory());
    assertEquals("lineInfo", disruption.getType());
    assertEquals("RealTime", disruption.getCategoryDescription());
    assertEquals("Waterloo and City Line: Train service will resume at 06:15 on Monday. ", disruption.getDescription());
    assertEquals("serviceClosed", disruption.getClosureText());
  }

  @Test
  public void testGetDisruptionsByBus() throws Exception {

    setMockResponse("https://api.tfl.gov.uk/Line/Mode/bus/Disruption","data/line/disruptions/bus.json");

    List<Disruption> disruptionList = lineService.getBusDisruptions();
    assertNotNull(disruptionList);
    assertEquals(7, disruptionList.size());

    Disruption disruption = disruptionList.get(0);

    assertEquals("RealTime", disruption.getCategory());
    assertEquals("stopBlocking", disruption.getType());
    assertEquals("RealTime", disruption.getCategoryDescription());
    assertEquals("Routes 170 211 not serving this stop", disruption.getDescription());

  }
}
