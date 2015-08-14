package android.me.feiras.feirasme.rest;

import android.content.Context;
import android.me.feiras.feirasme.MainApplication;

import android.me.feiras.feirasme.model.NearMarkets;
import android.util.Log;

import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by danielideriba on 8/10/15.
 */
public class GetJsonConnection {

    private static final String TAG = GetJsonConnection.class.getSimpleName();
    private static NearMarkets mNearMarkets;


    public static void getJsonData(final Context context, String baseUrl) {
        JsonObjectRequest request = new JsonObjectRequest(
                baseUrl,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // TODO: Parse the JSON


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(context, "Unable to fetch data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        MainApplication.getInstance().getRequestQueue().add(request);
    }
}
