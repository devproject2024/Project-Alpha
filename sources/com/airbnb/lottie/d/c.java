package com.airbnb.lottie.d;

import android.content.Context;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e;
import com.airbnb.lottie.l;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.utility.StringUtility;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipInputStream;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f5984a;

    /* renamed from: b  reason: collision with root package name */
    public final b f5985b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f5986c;

    public c(Context context, String str, String str2) {
        this.f5986c = context.getApplicationContext();
        this.f5984a = str;
        if (str2 == null) {
            this.f5985b = null;
        } else {
            this.f5985b = new b(this.f5986c);
        }
    }

    public final l<d> a() {
        try {
            return b();
        } catch (IOException e2) {
            return new l<>((Throwable) e2);
        }
    }

    private l<d> b() throws IOException {
        l<d> lVar;
        a aVar;
        new StringBuilder("Fetching ").append(this.f5984a);
        com.airbnb.lottie.f.d.a();
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.f5984a).openConnection()));
        httpURLConnection.setRequestMethod(H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD);
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null) {
                if (httpURLConnection.getResponseCode() == 200) {
                    String contentType = httpURLConnection.getContentType();
                    if (contentType == null) {
                        contentType = "application/json";
                    }
                    if (contentType.contains("application/zip")) {
                        com.airbnb.lottie.f.d.a();
                        aVar = a.ZIP;
                        if (this.f5985b == null) {
                            lVar = e.a(new ZipInputStream(httpURLConnection.getInputStream()), (String) null);
                        } else {
                            lVar = e.a(new ZipInputStream(new FileInputStream(this.f5985b.a(this.f5984a, httpURLConnection.getInputStream(), aVar))), this.f5984a);
                        }
                    } else {
                        com.airbnb.lottie.f.d.a();
                        aVar = a.JSON;
                        if (this.f5985b == null) {
                            lVar = e.b(httpURLConnection.getInputStream(), (String) null);
                        } else {
                            lVar = e.b((InputStream) new FileInputStream(new File(this.f5985b.a(this.f5984a, httpURLConnection.getInputStream(), aVar).getAbsolutePath())), this.f5984a);
                        }
                    }
                    boolean z = true;
                    if (!(this.f5985b == null || lVar.f6164a == null)) {
                        b bVar = this.f5985b;
                        File file = new File(bVar.a(), b.a(this.f5984a, aVar, true));
                        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
                        boolean renameTo = file.renameTo(file2);
                        StringBuilder sb = new StringBuilder("Copying temp file to real file (");
                        sb.append(file2);
                        sb.append(")");
                        com.airbnb.lottie.f.d.a();
                        if (!renameTo) {
                            com.airbnb.lottie.f.d.a("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + AppUtility.CENTER_DOT);
                        }
                    }
                    StringBuilder sb2 = new StringBuilder("Completed fetch from network. Success: ");
                    if (lVar.f6164a == null) {
                        z = false;
                    }
                    sb2.append(z);
                    com.airbnb.lottie.f.d.a();
                    httpURLConnection.disconnect();
                    return lVar;
                }
            }
            String a2 = a(httpURLConnection);
            return new l<>((Throwable) new IllegalArgumentException("Unable to fetch " + this.f5984a + ". Failed with " + httpURLConnection.getResponseCode() + StringUtility.NEW_LINE + a2));
        } catch (Exception e2) {
            return new l<>((Throwable) e2);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    private static String a(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append(10);
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e2) {
                throw e2;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }
}
