package uk.co.orangefoundry.tfl4j;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public abstract class AbstractService {

  private OkHttpClient client = new OkHttpClient();
  private ObjectMapper mapper = new ObjectMapper();
  protected static final String TFL = "https://api.tfl.gov.uk/";

  protected OkHttpClient getClient() {
    return client;
  }

  protected ObjectMapper getMapper() {
    return mapper;
  }

  protected <T> T map(Class<T> clazz, String json) throws IOException {
    return mapper.readValue(json, clazz);
  }

  protected <T> List<T> mapList(Class<T> clazz, String json) throws IOException {
    return getMapper().readValue(json, new TypeReference<List<T>>() {
    });
  }

  protected String getData(final String url) throws IOException {
    Request request = new Request.Builder()
        .url(url)
        .build();

    Response response = getClient().newCall(request).execute();
    return response.body().string();
  }
}
