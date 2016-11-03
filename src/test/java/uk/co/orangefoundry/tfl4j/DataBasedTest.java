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

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.mockito.Mockito;

import java.io.IOException;

import static junit.framework.TestCase.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public abstract class DataBasedTest {

  protected ClientWrapper mockServer;

  public DataBasedTest() {
    mockServer = Mockito.mock(ClientWrapper.class);
  }

  protected void setMockResponse(String url, String expectedJson) {
    try {
      if (StringUtils.isNotEmpty(url)) {
        when(mockServer.getData(url)).thenReturn(getFile(expectedJson));
      } else {
        when(mockServer.getData(anyString())).thenReturn(getFile(expectedJson));
      }
    } catch (IOException e) {
      fail("IO Exception Thrown");
    }
  }

  protected void setMockResponse(String expectedJson) {
    setMockResponse(null,expectedJson);
  }
  protected String getFile(String fileName) {

    String result = "";

    ClassLoader classLoader = getClass().getClassLoader();
    try {
      result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;

  }
}
