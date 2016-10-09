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
