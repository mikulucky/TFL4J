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
import uk.co.orangefoundry.tfl4j.ClientWrapper;
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

  BikePointService bikePointService = new BikePointService(new ClientWrapper());
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