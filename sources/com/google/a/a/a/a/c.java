package com.google.a.a.a.a;

import com.alipay.mobile.h5container.api.H5Param;
import com.google.a.a.a.p;
import com.google.a.a.a.r;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class c extends p {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f7468b;

    /* renamed from: c  reason: collision with root package name */
    private final Proxy f7469c;

    /* renamed from: d  reason: collision with root package name */
    private final SSLSocketFactory f7470d;

    /* renamed from: e  reason: collision with root package name */
    private final HostnameVerifier f7471e;

    static {
        String[] strArr = {"DELETE", H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD, "HEAD", "OPTIONS", "POST", "PUT", "TRACE"};
        f7468b = strArr;
        Arrays.sort(strArr);
    }

    public c() {
        this((byte) 0);
    }

    private c(byte b2) {
        this.f7469c = null;
        this.f7470d = null;
        this.f7471e = null;
    }

    public final /* synthetic */ r a(String str, String str2) throws IOException {
        com.google.a.a.b.a.a.a.a.c.a(Arrays.binarySearch(f7468b, str) >= 0, "HTTP method %s not supported", str);
        URL url = new URL(str2);
        Proxy proxy = this.f7469c;
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(proxy == null ? url.openConnection() : url.openConnection(proxy)));
        httpURLConnection.setRequestMethod(str);
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            HostnameVerifier hostnameVerifier = this.f7471e;
            if (hostnameVerifier != null) {
                httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            }
            SSLSocketFactory sSLSocketFactory = this.f7470d;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
            }
        }
        return new a(httpURLConnection);
    }
}
