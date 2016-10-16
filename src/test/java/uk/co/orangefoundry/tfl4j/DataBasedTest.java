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
