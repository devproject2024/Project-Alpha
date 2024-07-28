package a.a.a;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static Headers a(JSONObject jSONObject) {
        Headers.Builder builder = new Headers.Builder();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                builder.add(next, (String) jSONObject.get(next));
            }
            return builder.build();
        } catch (JSONException e2) {
            new StringBuilder("jsonToH ").append(e2.getLocalizedMessage());
            return null;
        }
    }

    private static Request a(String str, JSONObject jSONObject) {
        try {
            FormBody.Builder builder = new FormBody.Builder();
            JSONObject jSONObject2 = jSONObject.getJSONObject("formBody");
            Headers a2 = a(jSONObject.getJSONObject("headers"));
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                builder.add(next, (String) jSONObject2.get(next));
            }
            return new Request.Builder().url(str).headers(a2).post(builder.build()).build();
        } catch (JSONException e2) {
            new StringBuilder("Json Load Exception: ").append(e2.getLocalizedMessage());
            return null;
        }
    }

    private static JSONObject a(Headers headers) {
        JSONObject jSONObject = new JSONObject();
        try {
            Map<String, List<String>> multimap = headers.toMultimap();
            for (String next : headers.names()) {
                jSONObject.put(next, TextUtils.join("|", multimap.get(next)));
            }
            return jSONObject;
        } catch (JSONException e2) {
            new StringBuilder("Json exception: ").append(e2.getLocalizedMessage());
            return null;
        }
    }

    private static JSONObject a(Response response) {
        StringBuilder sb;
        String localizedMessage;
        try {
            new JSONObject();
            String str = new String(Base64.encode(response.body().bytes(), 2));
            JSONObject a2 = a(response.headers());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("body", str);
            jSONObject.put("headers", a2);
            return jSONObject;
        } catch (IOException e2) {
            sb = new StringBuilder("Response exception: ");
            localizedMessage = e2.getLocalizedMessage();
            sb.append(localizedMessage);
            return null;
        } catch (JSONException e3) {
            sb = new StringBuilder("Response exception: ");
            localizedMessage = e3.getLocalizedMessage();
            sb.append(localizedMessage);
            return null;
        }
    }

    private static Request b(String str, JSONObject jSONObject) {
        try {
            return new Request.Builder().url(str).headers(a(jSONObject.getJSONObject("headers"))).build();
        } catch (JSONException e2) {
            new StringBuilder("Json Load Exception: ").append(e2.getLocalizedMessage());
            return null;
        }
    }

    @JavascriptInterface
    public final int androidVersion() {
        return Build.VERSION.SDK_INT;
    }

    @JavascriptInterface
    public final void customAjax(String str, String str2) {
        throw null;
    }

    @JavascriptInterface
    public final String get(String str, String str2) {
        StringBuilder sb;
        String str3;
        try {
            return a(new OkHttpClient().newCall(b(str, new JSONObject(str2))).execute()).toString();
        } catch (JSONException e2) {
            sb = new StringBuilder("Json Load Exception: ");
            str3 = e2.getLocalizedMessage();
            sb.append(str3);
            return "{}";
        } catch (IOException e3) {
            sb = new StringBuilder("Request exception: ");
            str3 = e3.getLocalizedMessage();
            sb.append(str3);
            return "{}";
        }
    }

    @JavascriptInterface
    public final String post(String str, String str2) {
        StringBuilder sb;
        String str3;
        new Throwable().getStackTrace()[0].getMethodName();
        try {
            return a(new OkHttpClient().newCall(a(str, new JSONObject(str2))).execute()).toString();
        } catch (JSONException e2) {
            sb = new StringBuilder("Json Load Exception: ");
            str3 = e2.getLocalizedMessage();
            sb.append(str3);
            return null;
        } catch (IOException e3) {
            sb = new StringBuilder("Request exception: ");
            str3 = e3.getLocalizedMessage();
            sb.append(str3);
            return null;
        }
    }
}
