package com.paytm.network;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.Request;
import com.android.volley.toolbox.HttpResponse;
import com.android.volley.toolbox.HurlStack;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.paytm.network.b.j;
import com.paytm.network.b.k;
import com.paytm.network.listener.a;
import com.paytm.utility.q;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;
import okhttp3.CertificatePinner;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class l extends HurlStack {

    /* renamed from: a  reason: collision with root package name */
    OkHttpClient f42959a;

    public l(X509TrustManager x509TrustManager, CertificatePinner certificatePinner) throws Exception {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (x509TrustManager != null) {
            builder.sslSocketFactory(new j(x509TrustManager), x509TrustManager);
        }
        if (certificatePinner != null) {
            q.d("DONE");
            builder.certificatePinner(certificatePinner);
        }
        this.f42959a = builder.build();
    }

    public final HttpResponse executeRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        OkHttpClient okHttpClient;
        int timeoutMs = request.getTimeoutMs();
        List<Header> list = null;
        if (k.b(request.getUrl())) {
            a aVar = request instanceof c ? ((c) request).getmMatricesEventListener() : null;
            if (aVar != null) {
                long j = (long) timeoutMs;
                okHttpClient = this.f42959a.newBuilder().connectTimeout(j, TimeUnit.MILLISECONDS).readTimeout(j, TimeUnit.MILLISECONDS).writeTimeout(j, TimeUnit.MILLISECONDS).connectionPool(o.a().b()).eventListener(aVar).build();
                aVar.f42962c = System.currentTimeMillis();
            } else {
                long j2 = (long) timeoutMs;
                okHttpClient = this.f42959a.newBuilder().connectTimeout(j2, TimeUnit.MILLISECONDS).readTimeout(j2, TimeUnit.MILLISECONDS).writeTimeout(j2, TimeUnit.MILLISECONDS).connectionPool(o.a().b()).build();
            }
        } else {
            a aVar2 = request instanceof c ? ((c) request).getmMatricesEventListener() : null;
            if (aVar2 != null) {
                long j3 = (long) timeoutMs;
                okHttpClient = this.f42959a.newBuilder().connectTimeout(j3, TimeUnit.MILLISECONDS).readTimeout(j3, TimeUnit.MILLISECONDS).writeTimeout(j3, TimeUnit.MILLISECONDS).eventListener(aVar2).build();
                aVar2.f42962c = System.currentTimeMillis();
            } else {
                long j4 = (long) timeoutMs;
                okHttpClient = this.f42959a.newBuilder().connectTimeout(j4, TimeUnit.MILLISECONDS).readTimeout(j4, TimeUnit.MILLISECONDS).writeTimeout(j4, TimeUnit.MILLISECONDS).build();
            }
        }
        Request.Builder url = new Request.Builder().url(request.getUrl());
        Map<String, String> headers = request.getHeaders();
        q.d("OkHttpStack :: adding headers");
        for (String next : headers.keySet()) {
            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(headers.get(next))) {
                q.d("OkHttpStack ::  header key " + next + " value " + headers.get(next));
                url.addHeader(next, headers.get(next));
            }
        }
        q.d("OkHttpStack :: adding additional headers");
        for (String next2 : map.keySet()) {
            if (!TextUtils.isEmpty(next2) && !TextUtils.isEmpty(map.get(next2))) {
                q.d("OkHttpStack ::  header key " + next2 + " value " + headers.get(next2));
                url.addHeader(next2, map.get(next2));
            }
        }
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    url.post(RequestBody.create(MediaType.parse(request.getPostBodyContentType()), postBody));
                    break;
                }
                break;
            case 0:
                url.get();
                break;
            case 1:
                q.d("OkHttpStack :: Post api call");
                url.post(a((com.android.volley.Request) request));
                break;
            case 2:
                url.put(a((com.android.volley.Request) request));
                break;
            case 3:
                url.delete();
                break;
            case 4:
                url.head();
                break;
            case 5:
                url.method("OPTIONS", (RequestBody) null);
                break;
            case 6:
                url.method("TRACE", (RequestBody) null);
                break;
            case 7:
                url.patch(a((com.android.volley.Request) request));
                break;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
        Response execute = FirebasePerfOkHttpClient.execute(okHttpClient.newCall(url.build()));
        int code = execute.code();
        q.d("responseCode: ".concat(String.valueOf(code)));
        if (code != -1) {
            if (execute.body() != null) {
                if ((request.getMethod() == 4 || (100 <= code && code < 200) || code == 204 || code == 304) ? false : true) {
                    InputStream byteStream = execute.body().byteStream();
                    int contentLength = (int) execute.body().contentLength();
                    if (execute.headers() != null) {
                        list = a(execute.headers().toMultimap());
                    }
                    return new HttpResponse(code, list, contentLength, byteStream);
                }
            }
            if (execute.headers() != null) {
                list = a(execute.headers().toMultimap());
            }
            return new HttpResponse(code, list);
        }
        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
    }

    private static List<Header> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            if (next.getKey() != null) {
                for (String str : (List) next.getValue()) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new Header((String) next.getKey(), str));
                    }
                }
            }
        }
        return arrayList;
    }

    private static RequestBody a(com.android.volley.Request request) throws AuthFailureError {
        String str;
        q.d("OkHttpStack :: createRequestBody enter");
        if (request != null) {
            byte[] body = request.getBody();
            boolean z = false;
            if (body == null) {
                body = new byte[0];
            }
            MediaType mediaType = null;
            Map<String, String> headers = request.getHeaders();
            if (headers != null && request.getHeaders().size() > 0) {
                q.d("OkHttpStack :: content type is present in header");
                Iterator<Map.Entry<String, String>> it2 = headers.entrySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        str = "";
                        break;
                    }
                    Map.Entry next = it2.next();
                    String str2 = (String) next.getKey();
                    q.d("OkHttpStack ::  header key is ".concat(String.valueOf(str2)));
                    if (str2.equalsIgnoreCase("Content-Type")) {
                        q.d("OkHttpStack ::  key.equalsIgnoreCase(HEADER_CONTENT_TYPE) ");
                        str = (String) next.getValue();
                        z = true;
                        break;
                    }
                }
                if (z) {
                    mediaType = MediaType.parse(str);
                }
            }
            if (mediaType == null) {
                mediaType = MediaType.parse(request.getBodyContentType());
            }
            q.d("OkHttpStack :: mediaType is ".concat(String.valueOf(mediaType)));
            q.d("OkHttpStack :: createRequestBody exit");
            return RequestBody.create(mediaType, body);
        }
        throw new IllegalArgumentException("Request Cannot be null");
    }
}
