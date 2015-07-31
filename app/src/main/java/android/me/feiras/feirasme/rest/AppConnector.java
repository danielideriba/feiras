package android.me.feiras.feirasme.rest;

import com.google.android.gms.drive.Contents;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Created by danielideriba on 7/31/15.
 */
public interface AppConnector {

        @Headers("Cache-Control: max-age=14400")
        @GET("/users/{user}/repos")
        Contents getContents(@Path("app-id") String appId);
}
