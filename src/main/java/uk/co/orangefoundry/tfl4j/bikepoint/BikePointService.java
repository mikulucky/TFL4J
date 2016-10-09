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

import uk.co.orangefoundry.tfl4j.AbstractService;
import uk.co.orangefoundry.tfl4j.bikepoint.dto.BikePoint;
import uk.co.orangefoundry.tfl4j.data.Location;
import uk.co.orangefoundry.tfl4j.data.RadialLocation;
import uk.co.orangefoundry.tfl4j.data.result.PlacesResponse;

import java.io.IOException;
import java.util.List;

import static uk.co.orangefoundry.tfl4j.bikepoint.BikeServiceConstants.BIKE_POINT;
import static uk.co.orangefoundry.tfl4j.bikepoint.BikeServiceConstants.BOX_SEARCH;
import static uk.co.orangefoundry.tfl4j.bikepoint.BikeServiceConstants.RADIUS_SEARCH;
import static uk.co.orangefoundry.tfl4j.bikepoint.BikeServiceConstants.SEARCH;

public class BikePointService extends AbstractService{


  public List<BikePoint> getBikePointList() throws IOException {
    return mapList(BikePoint.class,getData(BIKE_POINT));
  }

  public BikePoint getBikePoint(String id) throws IOException {
    String url = BIKE_POINT + id;
    return map(BikePoint.class,getData(url));
  }

  public List<BikePoint> searchByName(String searchTerm) throws IOException {
    String url = String.format(SEARCH,searchTerm);
    return mapList(BikePoint.class,getData(url));
  }

  public PlacesResponse searchByLocationWithRadius(RadialLocation location) throws IOException {
    String url = String.format(RADIUS_SEARCH,location.getLatitude(),location.getLongitude(),location.getRadius());
    return map(PlacesResponse.class,getData(url));
  }

  public List<BikePoint> searchByBoundingBox(Location sw, Location ne) throws IOException {
    //todo validate coordinates before passing to service
    String url = String.format(BOX_SEARCH,sw.getLatitude(),sw.getLongitude(),ne.getLatitude(),ne.getLongitude());
    return mapList(BikePoint.class,getData(url));
  }
}
