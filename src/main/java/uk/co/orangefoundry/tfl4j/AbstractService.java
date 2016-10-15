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
package uk.co.orangefoundry.tfl4j;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public abstract class AbstractService {

  private ObjectMapper mapper = new ObjectMapper();
  ClientWrapper clientWrapper;

  public AbstractService(ClientWrapper clientWrapper) {
    this.clientWrapper = clientWrapper;
  }

  protected ObjectMapper getMapper() {
    return mapper;
  }

  protected <T> T map(Class<T> clazz, String json) throws IOException {
    return mapper.readValue(json, clazz);
  }

  protected <T> List<T> mapList(Class<T> clazz, String json) throws IOException {
    return getMapper().readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
  }

  protected String getData(final String url) throws IOException {
    return clientWrapper.getData(url);
  }
}
