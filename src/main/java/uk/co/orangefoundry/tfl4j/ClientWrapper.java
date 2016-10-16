package uk.co.orangefoundry.tfl4j;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ClientWrapper {

  private OkHttpClient okHttpClient = new OkHttpClient();

  public String getData(String url) throws IOException {
    Request request = new Request.Builder()
        .url(url)
        .build();

    Response response = okHttpClient.newCall(request).execute();
    return response.body().string();
  }
}
