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

  @Test
  public void testGetDisruptionsByBusMode() throws Exception {

    setMockResponse("https://api.tfl.gov.uk/Line/Mode/bus/Disruption","data/line/disruptions/bus.json");

    List<Disruption> disruptionList = lineService.getDisruptions(Mode.BUS);
    assertNotNull(disruptionList);
    assertEquals(7, disruptionList.size());

    Disruption disruption = disruptionList.get(0);

    assertEquals("RealTime", disruption.getCategory());
    assertEquals("stopBlocking", disruption.getType());
    assertEquals("RealTime", disruption.getCategoryDescription());
    assertEquals("Routes 170 211 not serving this stop", disruption.getDescription());

  }

  @Test
  public void testGetDisruptionsByTubeMode() throws Exception {
    setMockResponse("https://api.tfl.gov.uk/Line/Mode/tube/Disruption","data/line/disruptions/tube.json");

    List<Disruption> disruptionList = lineService.getDisruptions(Mode.TUBE);
    assertNotNull(disruptionList);
    assertEquals(1, disruptionList.size());

    Disruption disruption = disruptionList.get(0);

    assertEquals("RealTime", disruption.getCategory());
    assertEquals("lineInfo", disruption.getType());
    assertEquals("RealTime", disruption.getCategoryDescription());
    assertEquals("Waterloo and City Line: Train service will resume at 06:15 on Monday. ", disruption.getDescription());
    assertEquals("serviceClosed", disruption.getClosureText());
  }
}
