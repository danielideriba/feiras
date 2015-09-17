package android.me.feiras.feirasme;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.me.feiras.feirasme.helper.MarketsHelper;
import android.me.feiras.feirasme.helper.SearchHelper;
import android.widget.Toast;

import org.apache.http.HttpException;

/**
 * Created by danielideriba on 8/7/15.
 */

public class MainApplication extends Application {
    private static MainApplication sInstance;

    private RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        mRequestQueue = Volley.newRequestQueue(this);
        sInstance = this;

        try {
            SearchHelper.getSearchMarkets(getApplicationContext(), getString(R.string.api_live_server));
        } catch (HttpException e) {
            e.printStackTrace();
        }
    }

    public synchronized static MainApplication getInstance() {
        return sInstance;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }
}