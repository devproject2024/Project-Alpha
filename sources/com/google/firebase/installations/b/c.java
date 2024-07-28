package com.google.firebase.installations.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.JsonReader;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.j;
import com.google.firebase.b.c;
import com.google.firebase.e.h;
import com.google.firebase.installations.b.a;
import com.google.firebase.installations.b.d;
import com.google.firebase.installations.b.e;
import com.google.firebase.installations.h;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.manager.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f38957a = Pattern.compile("[0-9]+s");

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f38958b = Charset.forName(AppConstants.UTF_8);

    /* renamed from: c  reason: collision with root package name */
    private final Context f38959c;

    /* renamed from: d  reason: collision with root package name */
    private final h f38960d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.firebase.b.c f38961e;

    public c(Context context, h hVar, com.google.firebase.b.c cVar) {
        this.f38959c = context;
        this.f38960d = hVar;
        this.f38961e = cVar;
    }

    public final d a(String str, String str2, String str3, String str4, String str5) throws com.google.firebase.installations.h {
        int i2 = 0;
        URL a2 = a(String.format("projects/%s/installations", new Object[]{str3}));
        while (i2 <= 1) {
            HttpURLConnection a3 = a(a2, str);
            try {
                a3.setRequestMethod("POST");
                a3.setDoOutput(true);
                if (str5 != null) {
                    a3.addRequestProperty("x-goog-fis-android-iid-migration-auth", str5);
                }
                a((URLConnection) a3, a(a(str2, str4)));
                int responseCode = a3.getResponseCode();
                if (responseCode == 200) {
                    InputStream inputStream = a3.getInputStream();
                    JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f38958b));
                    e.a d2 = e.d();
                    a.C0650a aVar = new a.C0650a();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName = jsonReader.nextName();
                        if (nextName.equals("name")) {
                            aVar.a(jsonReader.nextString());
                        } else if (nextName.equals("fid")) {
                            aVar.b(jsonReader.nextString());
                        } else if (nextName.equals("refreshToken")) {
                            aVar.c(jsonReader.nextString());
                        } else if (nextName.equals("authToken")) {
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                String nextName2 = jsonReader.nextName();
                                if (nextName2.equals(StringSet.token)) {
                                    d2.a(jsonReader.nextString());
                                } else if (nextName2.equals("expiresIn")) {
                                    d2.a(b(jsonReader.nextString()));
                                } else {
                                    jsonReader.skipValue();
                                }
                            }
                            aVar.a(d2.a());
                            jsonReader.endObject();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    jsonReader.close();
                    inputStream.close();
                    d a4 = aVar.a(d.b.OK).a();
                    a3.disconnect();
                    return a4;
                }
                a(a3, str4, str, str3);
                if (responseCode == 429) {
                    continue;
                } else if (responseCode < 500 || responseCode >= 600) {
                    d a5 = new a.C0650a().a(d.b.BAD_CONFIG).a();
                    a3.disconnect();
                    return a5;
                }
                i2++;
                a3.disconnect();
            } catch (IOException unused) {
            } catch (Throwable th) {
                a3.disconnect();
                throw th;
            }
        }
        throw new com.google.firebase.installations.h("Firebase Installations Service is unavailable. Please try again later.", h.a.UNAVAILABLE);
    }

    private static byte[] a(JSONObject jSONObject) throws IOException {
        return jSONObject.toString().getBytes(AppConstants.UTF_8);
    }

    private static void a(URLConnection uRLConnection, byte[] bArr) throws IOException {
        OutputStream outputStream = uRLConnection.getOutputStream();
        if (outputStream != null) {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream.write(bArr);
            } finally {
                try {
                    gZIPOutputStream.close();
                    outputStream.close();
                } catch (IOException unused) {
                }
            }
        } else {
            throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
        }
    }

    private static JSONObject a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put(Constants.RISK_SDK_VERSION, "a:16.3.3");
            return jSONObject;
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.RISK_SDK_VERSION, "a:16.3.3");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            return jSONObject2;
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static URL a(String str) throws com.google.firebase.installations.h {
        try {
            return new URL(String.format("https://%s/%s/%s", new Object[]{"firebaseinstallations.googleapis.com", "v1", str}));
        } catch (MalformedURLException e2) {
            throw new com.google.firebase.installations.h(e2.getMessage(), h.a.UNAVAILABLE);
        }
    }

    public final e a(String str, String str2, String str3, String str4) throws com.google.firebase.installations.h {
        int i2 = 0;
        URL a2 = a(String.format("projects/%s/installations/%s/authTokens:generate", new Object[]{str3, str2}));
        while (i2 <= 1) {
            HttpURLConnection a3 = a(a2, str);
            try {
                a3.setRequestMethod("POST");
                a3.addRequestProperty("Authorization", "FIS_v2 ".concat(String.valueOf(str4)));
                a((URLConnection) a3, a(a()));
                int responseCode = a3.getResponseCode();
                if (responseCode == 200) {
                    InputStream inputStream = a3.getInputStream();
                    JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f38958b));
                    e.a d2 = e.d();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName = jsonReader.nextName();
                        if (nextName.equals(StringSet.token)) {
                            d2.a(jsonReader.nextString());
                        } else if (nextName.equals("expiresIn")) {
                            d2.a(b(jsonReader.nextString()));
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    jsonReader.close();
                    inputStream.close();
                    e a4 = d2.a(e.b.OK).a();
                    a3.disconnect();
                    return a4;
                }
                a(a3, (String) null, str, str3);
                if (responseCode != 401) {
                    if (responseCode != 404) {
                        if (responseCode == 429) {
                            continue;
                        } else if (responseCode < 500 || responseCode >= 600) {
                            e a5 = e.d().a(e.b.BAD_CONFIG).a();
                            a3.disconnect();
                            return a5;
                        }
                        i2++;
                        a3.disconnect();
                    }
                }
                e a6 = e.d().a(e.b.AUTH_ERROR).a();
                a3.disconnect();
                return a6;
            } catch (IOException unused) {
            } catch (Throwable th) {
                a3.disconnect();
                throw th;
            }
        }
        throw new com.google.firebase.installations.h("Firebase Installations Service is unavailable. Please try again later.", h.a.UNAVAILABLE);
    }

    private HttpURLConnection a(URL url, String str) throws com.google.firebase.installations.h {
        c.a a2;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(com.paytm.business.merchantprofile.common.utility.AppConstants.START_OTP_FLOW);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(com.paytm.business.merchantprofile.common.utility.AppConstants.START_OTP_FLOW);
            httpURLConnection.addRequestProperty("Content-Type", "application/json");
            httpURLConnection.addRequestProperty("Accept", "application/json");
            httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
            httpURLConnection.addRequestProperty("Cache-Control", "no-cache");
            httpURLConnection.addRequestProperty("X-Android-Package", this.f38959c.getPackageName());
            com.google.firebase.b.c cVar = this.f38961e;
            if (!(cVar == null || this.f38960d == null || (a2 = cVar.a("fire-installations-id")) == c.a.NONE)) {
                httpURLConnection.addRequestProperty("x-firebase-client", this.f38960d.a());
                httpURLConnection.addRequestProperty("x-firebase-client-log-type", Integer.toString(a2.getCode()));
            }
            httpURLConnection.addRequestProperty("X-Android-Cert", b());
            httpURLConnection.addRequestProperty("x-goog-api-key", str);
            return httpURLConnection;
        } catch (IOException unused) {
            throw new com.google.firebase.installations.h("Firebase Installations Service is unavailable. Please try again later.", h.a.UNAVAILABLE);
        }
    }

    private String b() {
        try {
            byte[] a2 = com.google.android.gms.common.util.a.a(this.f38959c, this.f38959c.getPackageName());
            if (a2 != null) {
                return j.a(a2);
            }
            new StringBuilder("Could not get fingerprint hash for package: ").append(this.f38959c.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            new StringBuilder("No such package: ").append(this.f38959c.getPackageName());
            return null;
        }
    }

    private static long b(String str) {
        s.b(f38957a.matcher(str).matches(), "Invalid Expiration Timestamp.");
        if (str == null || str.length() == 0) {
            return 0;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    private static void a(HttpURLConnection httpURLConnection, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(a(httpURLConnection))) {
            a(str, str2, str3);
        }
    }

    private static String a(String str, String str2, String str3) {
        Object[] objArr = new Object[3];
        objArr[0] = str2;
        objArr[1] = str3;
        objArr[2] = TextUtils.isEmpty(str) ? "" : ", ".concat(String.valueOf(str));
        return String.format("Firebase options used while communicating with Firebase server APIs: %s, %s%s", objArr);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.net.HttpURLConnection r7) {
        /*
            java.io.InputStream r0 = r7.getErrorStream()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.BufferedReader r2 = new java.io.BufferedReader
            java.io.InputStreamReader r3 = new java.io.InputStreamReader
            java.nio.charset.Charset r4 = f38958b
            r3.<init>(r0, r4)
            r2.<init>(r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r0.<init>()     // Catch:{ IOException -> 0x004f, all -> 0x004a }
        L_0x0019:
            java.lang.String r3 = r2.readLine()     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            if (r3 == 0) goto L_0x0028
            r0.append(r3)     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r3 = 10
            r0.append(r3)     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            goto L_0x0019
        L_0x0028:
            java.lang.String r3 = "Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]"
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r5 = 0
            int r6 = r7.getResponseCode()     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r4[r5] = r6     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r5 = 1
            java.lang.String r7 = r7.getResponseMessage()     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r4[r5] = r7     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r7 = 2
            r4[r7] = r0     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            java.lang.String r7 = java.lang.String.format(r3, r4)     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r2.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0049:
            return r7
        L_0x004a:
            r7 = move-exception
            r2.close()     // Catch:{ IOException -> 0x004e }
        L_0x004e:
            throw r7
        L_0x004f:
            r2.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.b.c.a(java.net.HttpURLConnection):java.lang.String");
    }
}
