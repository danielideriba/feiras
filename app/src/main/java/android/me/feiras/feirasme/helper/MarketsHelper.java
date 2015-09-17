package android.me.feiras.feirasme.helper;

import android.content.Context;
import android.me.feiras.feirasme.common.network.WebHelper;
import android.me.feiras.feirasme.model.NearMarkets;
import android.me.feiras.feirasme.rest.GetJsonConnection;

import com.android.volley.toolbox.JsonObjectRequest;

import org.apache.http.HttpException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by danielideriba on 8/5/15.
 */
public class MarketsHelper {
    private static final String TAG = MarketsHelper.class.getSimpleName();

    public static JsonObjectRequest getRemoteStores(Context context, String sourceUrl)
            throws HttpException {

        JsonObjectRequest storesJSON;
        storesJSON =  GetJsonConnection.getJsonData(context, sourceUrl);

        return storesJSON;
    }
}
