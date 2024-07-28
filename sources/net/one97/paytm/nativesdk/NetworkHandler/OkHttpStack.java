package net.one97.paytm.nativesdk.NetworkHandler;

import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.HttpResponse;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpStack extends BaseHttpStack {
    private final List<Interceptor> mInterceptors;

    public OkHttpStack(List<Interceptor> list) {
        this.mInterceptors = list;
    }

    private static void setConnectionParametersForRequest(Request.Builder builder, com.android.volley.Request<?> request) throws AuthFailureError {
        switch (request.getMethod()) {
            case -1:
                byte[] body = request.getBody();
                if (body != null) {
                    builder.post(RequestBody.create(MediaType.parse(request.getBodyContentType()), body));
                    return;
                }
                return;
            case 0:
                builder.get();
                return;
            case 1:
                builder.post(createRequestBody(request));
                return;
            case 2:
                builder.put(createRequestBody(request));
                return;
            case 3:
                builder.delete(createRequestBody(request));
                return;
            case 4:
                builder.head();
                return;
            case 5:
                builder.method("OPTIONS", (RequestBody) null);
                return;
            case 6:
                builder.method("TRACE", (RequestBody) null);
                return;
            case 7:
                builder.patch(createRequestBody(request));
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static RequestBody createRequestBody(com.android.volley.Request request) throws AuthFailureError {
        byte[] body = request.getBody();
        if (body == null) {
            return null;
        }
        return RequestBody.create(MediaType.parse(request.getBodyContentType()), body);
    }

    public HttpResponse executeRequest(com.android.volley.Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        InputStream inputStream;
        int i2;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        long timeoutMs = (long) request.getTimeoutMs();
        builder.connectTimeout(timeoutMs, TimeUnit.MILLISECONDS);
        builder.readTimeout(timeoutMs, TimeUnit.MILLISECONDS);
        builder.writeTimeout(timeoutMs, TimeUnit.MILLISECONDS);
        Request.Builder builder2 = new Request.Builder();
        builder2.url(request.getUrl());
        Map<String, String> headers = request.getHeaders();
        for (String next : headers.keySet()) {
            builder2.addHeader(next, headers.get(next));
        }
        for (String next2 : map.keySet()) {
            builder2.addHeader(next2, map.get(next2));
        }
        setConnectionParametersForRequest(builder2, request);
        for (Interceptor addNetworkInterceptor : this.mInterceptors) {
            builder.addNetworkInterceptor(addNetworkInterceptor);
        }
        Response execute = FirebasePerfOkHttpClient.execute(builder.build().newCall(builder2.build()));
        int code = execute.code();
        ResponseBody body = execute.body();
        if (body == null) {
            inputStream = null;
        } else {
            inputStream = body.byteStream();
        }
        if (body == null) {
            i2 = 0;
        } else {
            i2 = (int) body.contentLength();
        }
        return new HttpResponse(code, mapHeaders(execute.headers()), i2, inputStream);
    }

    private List<Header> mapHeaders(Headers headers) {
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            String name = headers.name(i2);
            String value = headers.value(i2);
            if (name != null) {
                arrayList.add(new Header(name, value));
            }
        }
        return arrayList;
    }
}
