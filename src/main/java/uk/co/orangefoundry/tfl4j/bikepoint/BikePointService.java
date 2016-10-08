package uk.co.orangefoundry.tfl4j.bikepoint;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
    return mapper.readValue(data, new TypeReference<List<BikePoint>>(){});
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
}
