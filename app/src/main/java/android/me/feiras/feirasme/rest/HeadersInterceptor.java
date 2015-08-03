package android.me.feiras.feirasme.rest;

import android.os.Build;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by danielideriba on 8/3/15.
 */
 public class HeadersInterceptor implements Interceptor {

        private static final String KAUFDA_HTTP_USER_AGENT = "kaufDA Navigator/Android";

        private final String mUserAgent;

        public HeadersInterceptor() {
            mUserAgent = getUserAgent();
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request requestWithUserAgent;
            requestWithUserAgent = originalRequest.newBuilder()
                    .removeHeader("User-Agent")
                    .addHeader("User-Agent", mUserAgent)
                    .build();
            return chain.proceed(requestWithUserAgent);
        }

        private String getUserAgent() {
            StringBuilder userAgent = new StringBuilder(KAUFDA_HTTP_USER_AGENT);
            userAgent.append("(");

            if (Build.MODEL != null) {
                userAgent.append(";model/").append(Build.MODEL);
            }
            if (Build.VERSION.SDK != null) {
                userAgent.append(";sdk/").append(Build.VERSION.SDK);
            }
            userAgent.append(";lang/").append(Locale.getDefault().getDisplayLanguage());
            userAgent.append(")");

            return userAgent.toString();
        }
 }
