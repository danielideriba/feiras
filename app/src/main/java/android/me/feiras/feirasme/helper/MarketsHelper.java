package android.me.feiras.feirasme.helper;

import android.content.Context;
import android.me.feiras.feirasme.common.network.WebHelper;
import android.me.feiras.feirasme.model.NearMarkets;

import org.apache.http.HttpException;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by danielideriba on 8/5/15.
 */
public class MarketsHelper {
    private static final String TAG = MarketsHelper.class.getSimpleName();

    public void static NearMarkets getRemoteStores(Context context, String sourceUrl)
            throws HttpException {

        JSONArray storesJSON;
        try {
            storesJSON = ;



        } catch (JSONException e) {
            throw new HttpException(e.getMessage());
        }

        return null;
    }
}
