package uk.co.orangefoundry.tfl4j.line;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.orangefoundry.tfl4j.DataBasedTest;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class LineServiceModeTest extends DataBasedTest{

  private LineService lineService = new LineService(mockServer);

  @Test
  public void testGetTubeMode() throws Exception {
    setMockResponse("https://api.tfl.gov.uk/Line/Mode/tube","data/line/mode/tube.json");
    List<Line> lineList = lineService.getTubeLines();
    assertNotNull(lineList);
    assertEquals(11,lineList.size());

    Line line = lineList.get(0);
    assertNotNull(line);
    assertEquals("bakerloo",line.getId());
    assertEquals("Bakerloo",line.getName());
    assertEquals("tube",line.getModeName());
    assertNotNull(line.getCreated());
    assertNotNull(line.getModified());
  }

  @Test
  public void testGetBusMode() throws Exception {
    setMockResponse("https://api.tfl.gov.uk/Line/Mode/bus","data/line/mode/bus.json");
    List<Line> lineList = lineService.getBusLines();
    assertNotNull(lineList);
    assertEquals(665,lineList.size());

    Line line = lineList.get(0);
    assertNotNull(line);
    assertEquals("1",line.getId());
    assertEquals("1",line.getName());
    assertEquals("bus",line.getModeName());
    assertNotNull(line.getCreated());
    assertNotNull(line.getModified());
  }

  @Test
  public void testGetBusWithEnum() throws Exception {
    setMockResponse("https://api.tfl.gov.uk/Line/Mode/bus","data/line/mode/bus.json");
    List<Line> lineList = lineService.getLines(Mode.BUS);
    assertNotNull(lineList);
    assertEquals(665,lineList.size());

    Line line = lineList.get(0);
    assertNotNull(line);
    assertEquals("1",line.getId());
    assertEquals("1",line.getName());
    assertEquals("bus",line.getModeName());
    assertNotNull(line.getCreated());
    assertNotNull(line.getModified());
  }

  @Test
  public void testGetTubeWithEnum() throws Exception {
    setMockResponse("https://api.tfl.gov.uk/Line/Mode/tube","data/line/mode/tube.json");
    List<Line> lineList = lineService.getLines(Mode.TUBE);
    assertNotNull(lineList);
    assertEquals(11,lineList.size());

    Line line = lineList.get(0);
    assertNotNull(line);
    assertEquals("bakerloo",line.getId());
    assertEquals("Bakerloo",line.getName());
    assertEquals("tube",line.getModeName());
    assertNotNull(line.getCreated());
    assertNotNull(line.getModified());
  }
}