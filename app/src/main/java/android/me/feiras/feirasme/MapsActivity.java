package android.me.feiras.feirasme;


import android.app.ProgressDialog;

import android.me.feiras.feirasme.rest.GetJsonConnection;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONObject;



public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    @SuppressWarnings("unused")
    public static final String BASE_URL = "http://54.94.227.41:8080/feiras-me/v1/search/near/-23.571203699999998/-46.640024399999994";
    private JSONObject mUrl;
    private static final String TAG = "MapsActivity";
    private String jsonResponse;
    // Progress dialog
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //connect API rest
        GetJsonConnection.getJsonData(getApplicationContext(), BASE_URL);

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
