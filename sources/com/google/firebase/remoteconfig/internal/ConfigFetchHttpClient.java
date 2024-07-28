package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.google.android.gms.common.util.a;
import com.google.android.gms.common.util.j;
import com.google.firebase.remoteconfig.h;
import com.google.firebase.remoteconfig.i;
import com.google.firebase.remoteconfig.internal.f;
import com.google.firebase.remoteconfig.internal.g;
import com.google.firebase.remoteconfig.m;
import easypay.manager.Constants;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigFetchHttpClient {

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f39346h = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");

    /* renamed from: a  reason: collision with root package name */
    private final Context f39347a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39348b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39349c;

    /* renamed from: d  reason: collision with root package name */
    private final String f39350d;

    /* renamed from: e  reason: collision with root package name */
    private final String f39351e;

    /* renamed from: f  reason: collision with root package name */
    private final long f39352f;

    /* renamed from: g  reason: collision with root package name */
    private final long f39353g;

    public ConfigFetchHttpClient(Context context, String str, String str2, String str3, long j, long j2) {
        this.f39347a = context;
        this.f39348b = str;
        this.f39349c = str2;
        Matcher matcher = f39346h.matcher(str);
        this.f39350d = matcher.matches() ? matcher.group(1) : null;
        this.f39351e = str3;
        this.f39352f = j;
        this.f39353g = j2;
    }

    /* access modifiers changed from: package-private */
    public final HttpURLConnection a() throws i {
        try {
            return (HttpURLConnection) new URL(String.format("https://firebaseremoteconfig.googleapis.com/v1/projects/%s/namespaces/%s:fetch", new Object[]{this.f39350d, this.f39351e})).openConnection();
        } catch (IOException e2) {
            throw new i(e2.getMessage());
        }
    }

    private String b() {
        try {
            byte[] a2 = a.a(this.f39347a, this.f39347a.getPackageName());
            if (a2 != null) {
                return j.a(a2);
            }
            new StringBuilder("Could not get fingerprint hash for package: ").append(this.f39347a.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            new StringBuilder("No such package: ").append(this.f39347a.getPackageName());
            return null;
        }
    }

    private JSONObject a(String str, String str2, Map<String, String> map) throws h {
        String str3;
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put("appInstanceId", str);
            hashMap.put("appInstanceIdToken", str2);
            hashMap.put("appId", this.f39348b);
            Locale locale = this.f39347a.getResources().getConfiguration().locale;
            hashMap.put("countryCode", locale.getCountry());
            if (Build.VERSION.SDK_INT >= 21) {
                str3 = locale.toLanguageTag();
            } else {
                str3 = locale.toString();
            }
            hashMap.put("languageCode", str3);
            hashMap.put("platformVersion", Integer.toString(Build.VERSION.SDK_INT));
            hashMap.put("timeZone", TimeZone.getDefault().getID());
            try {
                PackageInfo packageInfo = this.f39347a.getPackageManager().getPackageInfo(this.f39347a.getPackageName(), 0);
                if (packageInfo != null) {
                    hashMap.put("appVersion", packageInfo.versionName);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            hashMap.put("packageName", this.f39347a.getPackageName());
            hashMap.put(Constants.RISK_SDK_VERSION, "19.2.0");
            hashMap.put("analyticsUserProperties", new JSONObject(map));
            return new JSONObject(hashMap);
        }
        throw new h("Fetch failed: Firebase installation id is null.");
    }

    private static JSONObject a(URLConnection uRLConnection) throws IOException, JSONException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRLConnection.getInputStream(), "utf-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = bufferedReader.read();
            if (read == -1) {
                return new JSONObject(sb.toString());
            }
            sb.append((char) read);
        }
    }

    private static boolean a(JSONObject jSONObject) {
        try {
            return !jSONObject.get("state").equals("NO_CHANGE");
        } catch (JSONException unused) {
            return true;
        }
    }

    private static f a(JSONObject jSONObject, Date date) throws h {
        JSONObject jSONObject2;
        try {
            f.a a2 = f.a();
            a2.f39372a = date;
            JSONArray jSONArray = null;
            try {
                jSONObject2 = jSONObject.getJSONObject("entries");
            } catch (JSONException unused) {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                a2.a(jSONObject2);
            }
            try {
                jSONArray = jSONObject.getJSONArray("experimentDescriptions");
            } catch (JSONException unused2) {
            }
            if (jSONArray != null) {
                a2.a(jSONArray);
            }
            return a2.a();
        } catch (JSONException e2) {
            throw new h("Fetch failed: fetch response could not be parsed.", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public g.a fetch(HttpURLConnection httpURLConnection, String str, String str2, Map<String, String> map, String str3, Map<String, String> map2, Date date) throws i {
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout((int) TimeUnit.SECONDS.toMillis(this.f39352f));
        httpURLConnection.setReadTimeout((int) TimeUnit.SECONDS.toMillis(this.f39353g));
        httpURLConnection.setRequestProperty("If-None-Match", str3);
        httpURLConnection.setRequestProperty("X-Goog-Api-Key", this.f39349c);
        httpURLConnection.setRequestProperty("X-Android-Package", this.f39347a.getPackageName());
        httpURLConnection.setRequestProperty("X-Android-Cert", b());
        httpURLConnection.setRequestProperty("X-Google-GFE-Can-Retry", H5AppHandler.CHECK_VALUE);
        httpURLConnection.setRequestProperty("X-Goog-Firebase-Installations-Auth", str2);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        for (Map.Entry next : map2.entrySet()) {
            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        try {
            byte[] bytes = a(str, str2, map).toString().getBytes("utf-8");
            httpURLConnection.setFixedLengthStreamingMode(bytes.length);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                String headerField = httpURLConnection.getHeaderField("ETag");
                JSONObject a2 = a((URLConnection) httpURLConnection);
                httpURLConnection.disconnect();
                try {
                    httpURLConnection.getInputStream().close();
                } catch (IOException unused) {
                }
                if (!a(a2)) {
                    return new g.a(date, 1, (f) null, (String) null);
                }
                f a3 = a(a2, date);
                return new g.a(a3.f39369b, 0, a3, headerField);
            }
            throw new m(responseCode, httpURLConnection.getResponseMessage());
        } catch (IOException | JSONException e2) {
            throw new h("The client had an error while calling the backend!", e2);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            try {
                httpURLConnection.getInputStream().close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }
}
