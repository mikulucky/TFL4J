package uk.co.orangefoundry.tfl4j.bikepoint;

import uk.co.orangefoundry.tfl4j.AbstractService;
import uk.co.orangefoundry.tfl4j.bikepoint.dto.BikePoint;
import uk.co.orangefoundry.tfl4j.data.result.PlacesResponse;
import uk.co.orangefoundry.tfl4j.data.Location;
import uk.co.orangefoundry.tfl4j.data.RadialLocation;

import java.io.IOException;
import java.util.List;

public class BikePointService extends AbstractService{

  private static final String BIKE_POINT = TFL + "BikePoint/";

  public List<BikePoint> getBikePointList() throws IOException {
    return mapList(BikePoint.class,getData(BIKE_POINT));
  }

  public BikePoint getBikePoint(String id) throws IOException {
    String url = BIKE_POINT + id;
    return map(BikePoint.class,getData(url));
  }

  public List<BikePoint> searchByName(String searchTerm) throws IOException {
    String url = BIKE_POINT + "Search?query=" + searchTerm;
    return mapList(BikePoint.class,getData(url));
  }

  public PlacesResponse searchByLocationWithRadius(RadialLocation location) throws IOException {
    String url = BIKE_POINT+"?lat=" + location.getLatitude()
        + "&lon=" + location.getLongitude() + "&radius=" + location.getRadius();
    return map(PlacesResponse.class,getData(url));
  }

  public List<BikePoint> searchByBoundingBox(Location sw, Location ne) throws IOException {
    //todo validate coordinates before passing to service
    String url = BIKE_POINT + "?swLat=" +sw.getLatitude()+
        "&swLon="+sw.getLongitude()+"&neLat="+ne.getLatitude()+"&neLon="+ne.getLongitude();
    return mapList(BikePoint.class,getData(url));
  }
}
