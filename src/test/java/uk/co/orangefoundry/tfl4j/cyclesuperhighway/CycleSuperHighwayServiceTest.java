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
package uk.co.orangefoundry.tfl4j.cyclesuperhighway;

import org.junit.Test;
import uk.co.orangefoundry.tfl4j.DataBasedTest;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class CycleSuperHighwayServiceTest extends DataBasedTest {

  CycleSuperHighwayService cycleSuperHighwayService = new CycleSuperHighwayService(mockServer);

  @Test
  public void getAllHighways() throws Exception {
    setMockResponse("data/cycle/all.json");

    List<CycleSuperhighway> results = cycleSuperHighwayService.getAll();
    assertNotNull(results);
    assertFalse(results.isEmpty());
  }

  @Test
  public void getOne() throws Exception {
    setMockResponse("data/cycle/single.json");
    CycleSuperhighway result = cycleSuperHighwayService.getOne("RMP-006");
    assertNotNull(result);
  }
}