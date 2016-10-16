package uk.co.orangefoundry.tfl4j.airquality;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

public abstract class DataBasedTest {

  protected String getFile(String fileName){

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
