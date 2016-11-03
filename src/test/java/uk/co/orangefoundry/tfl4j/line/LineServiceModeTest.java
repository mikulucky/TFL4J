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
  public void testGetRailMode() throws Exception {
    setMockResponse("https://api.tfl.gov.uk/Line/Mode/national-rail","data/line/mode/rail.json");
    List<Line> lineList = lineService.getRailLines();
    assertNotNull(lineList);
    assertEquals(27,lineList.size());

    Line line = lineList.get(0);
    assertNotNull(line);
    assertEquals("abellio-greater-anglia",line.getId());
    assertEquals("Abellio Greater Anglia",line.getName());
    assertEquals("national-rail",line.getModeName());
    assertNotNull(line.getCreated());
    assertNotNull(line.getModified());
  }

  @Test
  public void testGetRailWithEnum() throws Exception {
    setMockResponse("https://api.tfl.gov.uk/Line/Mode/national-rail","data/line/mode/rail.json");
    List<Line> lineList = lineService.getLines(Mode.NATIONAL_RAIL);
    assertNotNull(lineList);
    assertEquals(27,lineList.size());

    Line line = lineList.get(0);
    assertNotNull(line);
    assertEquals("abellio-greater-anglia",line.getId());
    assertEquals("Abellio Greater Anglia",line.getName());
    assertEquals("national-rail",line.getModeName());
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