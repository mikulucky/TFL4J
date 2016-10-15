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

import uk.co.orangefoundry.tfl4j.AbstractService;
import uk.co.orangefoundry.tfl4j.ClientWrapper;

import java.io.IOException;
import java.util.List;

import static uk.co.orangefoundry.tfl4j.cyclesuperhighway.CycleSuperHighwayConstants.CYCLE;
import static uk.co.orangefoundry.tfl4j.cyclesuperhighway.CycleSuperHighwayConstants.CYCLE_SEARCH;

public class CycleSuperHighwayService extends AbstractService {

  public CycleSuperHighwayService(ClientWrapper clientWrapper) {
    super(clientWrapper);
  }

  public List<CycleSuperhighway> getAll() throws IOException {
    return mapList(CycleSuperhighway.class, getData(CYCLE));
  }

  public CycleSuperhighway getOne(final String id) throws IOException {
    String url = String.format(CYCLE_SEARCH,id);
    return map(CycleSuperhighway.class,getData(url));
  }
}
