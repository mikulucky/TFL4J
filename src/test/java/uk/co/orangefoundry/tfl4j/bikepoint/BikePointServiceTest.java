package uk.co.orangefoundry.tfl4j.bikepoint;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import uk.co.orangefoundry.tfl4j.bikepoint.dto.BikePoint;
import uk.co.orangefoundry.tfl4j.data.result.AdditionalProperty;
import uk.co.orangefoundry.tfl4j.data.result.Place;
import uk.co.orangefoundry.tfl4j.data.result.PlacesResponse;
import uk.co.orangefoundry.tfl4j.data.Location;
import uk.co.orangefoundry.tfl4j.data.RadialLocation;

import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

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

  @Test
  public void testPOJO() throws Exception {
    BikePoint bikePoint = bikePointService.getBikePoint("BikePoints_455");
    assertNotNull(bikePoint);

    assertTrue(StringUtils.isNoneEmpty(bikePoint.getCommonName()));
    assertTrue(StringUtils.isNoneEmpty(bikePoint.getId()));
    assertTrue(StringUtils.isNoneEmpty(bikePoint.getLat()));
    assertTrue(StringUtils.isNoneEmpty(bikePoint.getLon()));
    assertTrue(StringUtils.isNoneEmpty(bikePoint.getPlaceType()));
    assertTrue(StringUtils.isNoneEmpty(bikePoint.getUrl()));

    assertNotNull(bikePoint.getAdditionalProperties());
    assertFalse(bikePoint.getAdditionalProperties().isEmpty());

  }

  @Test
  public void testPlaceResponse() throws Exception {
    RadialLocation location = new RadialLocation(51.508447,-0.055167,500);
    PlacesResponse results = bikePointService.searchByLocationWithRadius(location);

    assertNotNull(results);
    assertNotNull(results.getPlaces());
    assertFalse(results.getPlaces().isEmpty());

    Place place = results.getPlaces().get(0);

    assertTrue(StringUtils.isNotEmpty(place.getUrl()));
    assertTrue(StringUtils.isNotEmpty(place.getPlaceType()));
    assertTrue(StringUtils.isNotEmpty(place.getLon()));
    assertTrue(StringUtils.isNotEmpty(place.getCommonName()));
    assertTrue(StringUtils.isNotEmpty(place.getLat()));
    assertTrue(StringUtils.isNotEmpty(place.getId()));
    assertNotNull(place.getDistance());

    assertNotNull(place.getAdditionalProperties());
    assertFalse(place.getAdditionalProperties().isEmpty());

    AdditionalProperty additionalProperty = place.getAdditionalProperties().get(0);

    assertNotNull(additionalProperty);

    assertTrue(StringUtils.isNotEmpty(additionalProperty.getCategory()));
    assertTrue(StringUtils.isNotEmpty(additionalProperty.getKey()));
    assertTrue(StringUtils.isNotEmpty(additionalProperty.getSourceSystemKey()));
    assertTrue(StringUtils.isNotEmpty(additionalProperty.getValue()));

    assertNotNull(additionalProperty.getModified());


  }
}