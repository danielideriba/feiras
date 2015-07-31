package android.me.feiras.feirasme.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by danielideriba on 7/31/15.
 */
public class RestClient {

        public static final String BASE_URL = "https://api.github.com";
        private AppConnector AppConnector;

        public RestClient() {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                    .create();

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(BASE_URL)
                    .setConverter(new GsonConverter(gson))
                    .build();

            AppConnector = restAdapter.create(AppConnector.class);

        }

        public AppConnector getApiService() {
            return AppConnector;
        }

}
