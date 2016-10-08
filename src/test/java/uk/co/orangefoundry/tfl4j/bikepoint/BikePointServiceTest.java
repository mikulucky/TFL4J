package uk.co.orangefoundry.tfl4j.bikepoint;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;

public class BikePointServiceTest {

  BikePointService bikePointService = new BikePointService();
  @Test
  public void testGetAllBikePoints() throws Exception {
    List<BikePoint> bikePointList = bikePointService.getBikePointList();
    assertNotNull(bikePointList);
    assertFalse(bikePointList.isEmpty());
  }

  @Test
  public void testGetBikePoint() throws Exception {
    BikePoint bikePoint = bikePointService.getBikePoint("BikePoints_455");
    assertNotNull(bikePoint);
  }
}