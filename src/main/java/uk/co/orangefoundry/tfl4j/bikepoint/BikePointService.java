package uk.co.orangefoundry.tfl4j.bikepoint;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import uk.co.orangefoundry.tfl4j.bikepoint.result.PlacesResponse;

import java.io.IOException;
import java.util.List;

public class BikePointService {

  private OkHttpClient client = new OkHttpClient();
  private ObjectMapper mapper = new ObjectMapper();

  public List<BikePoint> getBikePointList() throws IOException {
    Request request = new Request.Builder()
        .url("https://api.tfl.gov.uk/BikePoint")
        .build();

    Response response = client.newCall(request).execute();
    String data = response.body().string();
    return mapper.readValue(data, new TypeReference<List<BikePoint>>() {
    });
  }

  public BikePoint getBikePoint(String id) throws IOException {
    String url = "https://api.tfl.gov.uk/BikePoint/" + id;
    Request request = new Request.Builder()
        .url(url)
        .build();

    Response response = client.newCall(request).execute();
    String data = response.body().string();
    return mapper.readValue(data, BikePoint.class);
  }

  public List<BikePoint> searchByName(String searchTerm) throws IOException {
    String url = "https://api.tfl.gov.uk/BikePoint/Search?query=" + searchTerm;
    Request request = new Request.Builder()
        .url(url)
        .build();

    Response response = client.newCall(request).execute();
    String data = response.body().string();
    return mapper.readValue(data, new TypeReference<List<BikePoint>>() {
    });
  }

  public PlacesResponse searchByLocationWithRadius(RadialLocation location) throws IOException {
    String url = "https://api.tfl.gov.uk/BikePoint?lat=" + location.getLatitude()
        + "&lon=" + location.getLongitude() + "&radius=" + location.getRadius();
    Request request = new Request.Builder()
        .url(url)
        .build();

    Response response = client.newCall(request).execute();
    String data = response.body().string();
    return mapper.readValue(data, PlacesResponse.class);
  }

  public List<BikePoint> searchByBoundingBox(Location sw, Location ne) throws IOException {
    //todo validate coordinates before passing to service
    String url = "https://api.tfl.gov.uk/BikePoint?swLat="+sw.getLatitude()+
        "&swLon="+sw.getLongitude()+"&neLat="+ne.getLatitude()+"&neLon="+ne.getLongitude();
    Request request = new Request.Builder()
        .url(url)
        .build();

    Response response = client.newCall(request).execute();
    String data = response.body().string();
    return mapper.readValue(data, new TypeReference<List<BikePoint>>() {
    });
  }
}
