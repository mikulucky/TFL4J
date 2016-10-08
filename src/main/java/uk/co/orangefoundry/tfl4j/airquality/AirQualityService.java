package uk.co.orangefoundry.tfl4j.airquality;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import uk.co.orangefoundry.tfl4j.airquality.dto.AirQuality;

import java.io.IOException;

public class AirQualityService {

  private static final String URL = "https://api.tfl.gov.uk/AirQuality";

  private OkHttpClient client = new OkHttpClient();
  private ObjectMapper mapper = new ObjectMapper();



  public AirQuality getAirQualityForecast() throws IOException {
    Request request = new Request.Builder()
        .url(URL)
        .build();

    Response response = client.newCall(request).execute();
    String data = response.body().string();
    return mapper.readValue(data, AirQuality.class);
  }
}
