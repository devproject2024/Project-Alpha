package com.alipay.iap.android.webapp.sdk.network.toolbox;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.iap.android.common.b.c;
import com.alipay.iap.android.webapp.sdk.utils.KitUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.util.H5Utils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class UrlTransport implements HttpTransport {
    private static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final int DEFAULT_TIME_OUT = 30000;
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String TAG = UrlTransport.class.getName();
    private boolean enableCache;

    private boolean hasResponseBody(int i2) {
        return (i2 < 200 || i2 == 204 || i2 == 304) ? false : true;
    }

    public UrlTransport() {
        this(false);
    }

    public UrlTransport(boolean z) {
        this.enableCache = z;
    }

    public HttpResponse performRequest(HttpRequest httpRequest) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        int i2;
        HttpResponse httpResponse;
        "performRequest request=".concat(String.valueOf(httpRequest));
        c.e();
        HttpURLConnection openConnection = openConnection(new URL(httpRequest.url), httpRequest);
        addHeader(httpRequest.headersArray, openConnection);
        addHeader(httpRequest.headerJsonOb, openConnection);
        addHeader(httpRequest.headersMap, openConnection);
        addHeaderCookie(httpRequest.url, openConnection);
        addHeaderAcceptLanguage(openConnection);
        setConnectionParametersForRequest(openConnection, httpRequest.method, httpRequest.data);
        try {
            i2 = openConnection.getResponseCode();
        } catch (IOException e2) {
            e2.getMessage();
            c.e();
            i2 = openConnection.getResponseCode();
        }
        if (i2 != -1) {
            String responseMessage = openConnection.getResponseMessage();
            if (hasResponseBody(i2)) {
                httpResponse = new HttpResponse(i2, responseMessage, getContent(openConnection), openConnection.getHeaderFields());
            } else {
                httpResponse = new HttpResponse(i2, responseMessage, (byte[]) null, openConnection.getHeaderFields());
            }
            setCookie(openConnection);
            "performRequest response=".concat(String.valueOf(httpResponse));
            c.e();
            return httpResponse;
        }
        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
    }

    private HttpURLConnection createConnection(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    private HttpURLConnection openConnection(URL url, HttpRequest httpRequest) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        HttpURLConnection createConnection = createConnection(url);
        if (httpRequest.timeoutMs < 0) {
            httpRequest.timeoutMs = 30000;
        }
        createConnection.setConnectTimeout(httpRequest.timeoutMs);
        createConnection.setReadTimeout(httpRequest.timeoutMs);
        createConnection.setUseCaches(this.enableCache);
        createConnection.setDefaultUseCaches(this.enableCache);
        createConnection.setDoInput(true);
        createConnection.setInstanceFollowRedirects(!httpRequest.notFollowRedirects);
        if ("https".equals(url.getProtocol())) {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
            ((HttpsURLConnection) createConnection).setSSLSocketFactory(instance.getSocketFactory());
        }
        return createConnection;
    }

    private void setConnectionParametersForRequest(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD)) {
            httpURLConnection.setRequestMethod(H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD);
        } else if (TextUtils.equals(str, "POST")) {
            httpURLConnection.setRequestMethod("POST");
            if (!TextUtils.isEmpty(str2)) {
                addBody(httpURLConnection, str2.getBytes(AppConstants.UTF_8));
            }
        }
    }

    private void addBody(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        httpURLConnection.setDoOutput(true);
        if (TextUtils.isEmpty(httpURLConnection.getRequestProperty("Content-Type"))) {
            httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    private byte[] getContent(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            inputStream = httpURLConnection.getErrorStream();
        }
        byte[] readBytes = H5Utils.readBytes(inputStream);
        inputStream.close();
        return readBytes;
    }

    private static void setCookie(HttpURLConnection httpURLConnection) {
        try {
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            Map headerFields = httpURLConnection.getHeaderFields();
            for (String str : headerFields.keySet()) {
                if (str != null && ("Set-Cookie2".equalsIgnoreCase(str) || "Set-Cookie".equalsIgnoreCase(str))) {
                    for (String cookie : (List) headerFields.get(str)) {
                        instance.setCookie(httpURLConnection.getURL().toString(), cookie);
                    }
                }
            }
        } catch (Exception unused) {
            c.j();
        }
    }

    private static void addHeaderCookie(String str, HttpURLConnection httpURLConnection) {
        String cookie = CookieManager.getInstance().getCookie(str);
        if (!TextUtils.isEmpty(cookie)) {
            httpURLConnection.addRequestProperty("Cookie", cookie);
        }
    }

    private static void addHeaderAcceptLanguage(HttpURLConnection httpURLConnection) {
        if (TextUtils.isEmpty(httpURLConnection.getRequestProperty("Accept-Language"))) {
            httpURLConnection.addRequestProperty("Accept-Language", KitUtils.getLanguage());
        }
    }

    private static void addHeader(b bVar, HttpURLConnection httpURLConnection) {
        if (bVar != null && !bVar.isEmpty()) {
            for (int i2 = 0; i2 < bVar.size(); i2++) {
                addHeader(bVar.getJSONObject(i2), httpURLConnection);
            }
        }
    }

    private static void addHeader(e eVar, HttpURLConnection httpURLConnection) {
        if (eVar != null && !eVar.isEmpty()) {
            for (String next : eVar.keySet()) {
                httpURLConnection.addRequestProperty(next, eVar.get(next).toString());
            }
        }
    }

    private static void addHeader(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null && !map.isEmpty()) {
            for (String next : map.keySet()) {
                if (TextUtils.isEmpty(httpURLConnection.getRequestProperty(next))) {
                    httpURLConnection.addRequestProperty(next, map.get(next));
                }
            }
        }
    }
}
