package android.me.feiras.feirasme;


import android.me.feiras.feirasme.rest.AppConnector;
import android.me.feiras.feirasme.rest.RestClient;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import retrofit.RestAdapter;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    public static final String BASE_URL = "https://api.github.com";
    TextView textView;
    private static final String TAG = "MapsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //connect API rest
        RestClient


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
