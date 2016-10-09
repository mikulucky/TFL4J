package uk.co.orangefoundry.tfl4j.bikepoint;

import org.junit.Test;
import uk.co.orangefoundry.tfl4j.bikepoint.result.PlacesResponse;

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

  @Test
  public void getBikePointByName() throws Exception {
    final String searchTerm = "Napier Avenue";
    List<BikePoint> results = bikePointService.searchByName(searchTerm);
    assertNotNull(results);
    assertFalse(results.isEmpty());
  }

  @Test
  public void getBikePointsFromLocationAndRaduis() throws Exception {
    RadialLocation location = new RadialLocation(51.508447,-0.055167,500);
    PlacesResponse results = bikePointService.searchByLocationWithRadius(location);
    assertNotNull(results);
    assertFalse(results.getPlaces().isEmpty());
  }

  @Test
  public void searchByBoundingBox() throws Exception {
    Location sw = new Location(51.508447,-0.055167);
    Location ne = new Location(51.708447,-0.035167);
    List<BikePoint> placesResponse = bikePointService.searchByBoundingBox(sw, ne);
    assertNotNull(placesResponse);
    assertFalse(placesResponse.isEmpty());

  }
}