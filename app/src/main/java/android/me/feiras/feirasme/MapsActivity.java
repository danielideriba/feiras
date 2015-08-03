package android.me.feiras.feirasme;


import android.me.feiras.feirasme.rest.JsonParser;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.HttpException;
import org.json.JSONException;
import org.json.JSONObject;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    @SuppressWarnings("unused")
    public static final String BASE_URL = "http://api.guiato.com.br/iphone/api/v1/basicConfiguration?device=android";
    TextView textView;
    private JSONObject mUrl;
    private static final String TAG = "MapsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //connect API rest
        try {
            mUrl = JsonParser.getHttpJson(BASE_URL).getJSONObject("config");
            Log.i(TAG, "DEBUG " + mUrl);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onMapReady(GoogleMap map) {

        //map.setMyLocationEnabled(true);
        LatLng currentPosition = new LatLng(-23.5642369, -46.6946825);

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentPosition, 13));

        map.addMarker(new MarkerOptions()
                .title("São Paulo")
                .position(currentPosition));
    }

}
