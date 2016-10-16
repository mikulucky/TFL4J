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
package uk.co.orangefoundry.tfl4j.bikepoint;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import uk.co.orangefoundry.tfl4j.DataBasedTest;
import uk.co.orangefoundry.tfl4j.bikepoint.dto.BikePoint;
import uk.co.orangefoundry.tfl4j.data.Location;
import uk.co.orangefoundry.tfl4j.data.RadialLocation;
import uk.co.orangefoundry.tfl4j.data.result.AdditionalProperty;
import uk.co.orangefoundry.tfl4j.data.result.Place;
import uk.co.orangefoundry.tfl4j.data.result.PlacesResponse;

import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;
import static uk.co.orangefoundry.tfl4j.bikepoint.BikeServiceConstants.BOX_SEARCH;

public class BikePointServiceTest  extends DataBasedTest {

  BikePointService bikePointService = new BikePointService(mockServer);

  @Test
  public void testGetAllBikePoints() throws Exception {
    setMockResponse(BikeServiceConstants.BIKE_POINT,"data/bike/bikepoint.json");

    List<BikePoint> bikePointList = bikePointService.getBikePointList();
    assertNotNull(bikePointList);
    assertFalse(bikePointList.isEmpty());
  }

  @Test
  public void testGetBikePoint() throws Exception {
    String id = "BikePoints_455";

    setMockResponse(BikeServiceConstants.BIKE_POINT + id,"data/bike/single.json");

    BikePoint bikePoint = bikePointService.getBikePoint(id);
    assertNotNull(bikePoint);
  }

  @Test
  public void getBikePointByName() throws Exception {
    when(mockServer.getData("https://api.tfl.gov.uk/BikePoint/Search?query=Napier Avenue")).thenReturn(getFile("data/bike/bikename.json"));
    final String searchTerm = "Napier Avenue";
    List<BikePoint> results = bikePointService.searchByName(searchTerm);
    assertNotNull(results);
    assertFalse(results.isEmpty());
  }

  @Test
  public void getBikePointsFromLocationAndRaduis() throws Exception {
    setMockResponse("https://api.tfl.gov.uk/BikePoint/?lat=51.508447&lon=-0.055167&radius=500", "data/bike/bikeRadius.json");

    RadialLocation location = new RadialLocation(51.508447,-0.055167,500);
    PlacesResponse results = bikePointService.searchByLocationWithRadius(location);
    assertNotNull(results);
    assertFalse(results.getPlaces().isEmpty());
  }

  @Test
  public void searchByBoundingBox() throws Exception {
    Location sw = new Location(51.508447,-0.055167);
    Location ne = new Location(51.708447,-0.035167);

    setMockResponse(String.format(BOX_SEARCH,sw.getLatitude(),sw.getLongitude(),ne.getLatitude(),ne.getLongitude()),"data/bike/bikebox.json");

    List<BikePoint> placesResponse = bikePointService.searchByBoundingBox(sw, ne);
    assertNotNull(placesResponse);
    assertFalse(placesResponse.isEmpty());

  }

  @Test
  public void testPOJO() throws Exception {
    setMockResponse("https://api.tfl.gov.uk/BikePoint/BikePoints_455","data/bike/single.json");

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
    setMockResponse("https://api.tfl.gov.uk/BikePoint/?lat=51.508447&lon=-0.055167&radius=500","data/bike/bikeRadius.json");
    
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