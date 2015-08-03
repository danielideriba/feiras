package android.me.feiras.feirasme.rest;

import android.me.feiras.feirasme.model.Messages;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.apache.http.HttpException;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class JsonParser {

    private static String TAG = "JsonParser";

    public static JSONObject getHttpJson(String url) throws HttpException {
        JSONObject json = null;
        Request request = new Request.Builder()
                .url(url)
                .build();
        String result = executeHttp(request);
        if (result == null) {
            return null;
        }
        try {
            json = new JSONObject(result);
        } catch (JSONException e) {
            Log.e(TAG, Messages.JSON_PARSING_ERROR);
        }

        if (json == null) {
            throw new HttpException(Messages.JSON_ERROR);
        }
        return json;
    }

    public static JSONArray deleteHttpJsonArrayRequest(String url)
            throws HttpException {
        JSONArray json = null;
        Request request = new Request.Builder()
                .url(url.trim())
                .delete()
                .build();
        String result = executeHttp(request);
        if (result == null)
            return json;

        try {
            json = new JSONArray(result);
        } catch (JSONException e) {
            Log.e(TAG, Messages.JSON_PARSING_ERROR);
        }

        if (json == null) {
            throw new HttpException(Messages.JSON_ERROR);
        }

        return json;
    }

    public static String executeHttp(Request request) throws HttpException {
        String result = "";
        try {
            OkHttpClient httpClient = createHttpClient();
            final Response response = httpClient.newCall(request).execute();

            final int status = response.code();

            if (status != HttpStatus.SC_OK) {
                throw new HttpException("Status code: " + status + " for: " + request.url());
            }
            //Log.d("Response code " + response.code() + " for: " + request.url());
            try {
                result = response.body().string();
            } catch (ArrayIndexOutOfBoundsException e) {
                Throwable throwable =
                        new Throwable("Caught exception for request: " + request.toString(), e);
                return result;
            }
        } catch (ClientProtocolException e) {
            throw new HttpException(Messages.PROTOCOL_ERROR, e);
        } catch (IOException e) {
            throw new HttpException(Messages.IO_ERROR, e);
        } catch (IllegalArgumentException e) {
            throw new HttpException(Messages.INVALID_URI, e);
        }
        return result;
    }

    public static JSONArray getHttpJsonArray(String url) throws HttpException {
        JSONArray json = null;
        Request request = new Request.Builder()
                .url(url)
                .build();
        String result = executeHttp(request);
        try {
            json = new JSONArray(result);
            return json;
        } catch (JSONException e) {
            throw new HttpException(Messages.JSON_PARSING_ERROR, e);
        }
    }

    public static JSONArray postHttpJsonArray(String url) throws HttpException {
        JSONArray json = null;
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(null, ""))
                .build();
        String result = executeHttp(request);
        try {
            json = new JSONArray(result);
            return json;
        } catch (JSONException e) {
            throw new HttpException(Messages.JSON_PARSING_ERROR, e);
        }
    }

    public static JSONArray putHttpJsonArray(String url) throws HttpException {
        JSONArray json = null;
        Request request = new Request.Builder()
                .url(url.trim())
                .put(RequestBody.create(null,""))
                .build();
        String result = executeHttp(request);
        try {
            json = new JSONArray(result);
            return json;
        } catch (JSONException e) {
            throw new HttpException(Messages.JSON_PARSING_ERROR, e);
        }
    }

    public static boolean sendRequest(String url) throws HttpException {
        Log.d("Request: %s", url);
        try {
            Request request = new Request.Builder()
                    .url(url.trim())
                    .build();

            OkHttpClient httpClient = createHttpClient();
            final Response response = httpClient.newCall(request).execute();
            final int status = response.code();

            if (status == HttpStatus.SC_OK || status == HttpStatus.SC_CREATED) {
                return true;
            } else {
                return false;
            }

        } catch (ClientProtocolException e) {
            throw new HttpException(Messages.PROTOCOL_ERROR, e);
        } catch (IOException e) {
            throw new HttpException(Messages.IO_ERROR, e);
        } catch (IllegalArgumentException e) {
            throw new HttpException(Messages.INVALID_URI, e);
        }
    }

    public static String encode(String string) {
        try {
            return URLEncoder.encode(string, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "Unsupported encoding for url param");
        }

        return "";
    }

    private static OkHttpClient createHttpClient() {
        OkHttpClient client = new OkHttpClient();
        //client.networkInterceptors().add(new HeadersInterceptor());
        return client;
    }
}