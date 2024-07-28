package com.google.firebase.perf.network;

import com.google.android.gms.internal.p001firebaseperf.t;
import com.google.android.gms.internal.p001firebaseperf.zzbg;
import com.google.firebase.perf.internal.g;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

public class FirebasePerfHttpClient {
    private FirebasePerfHttpClient() {
    }

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException {
        return a(httpClient, httpUriRequest, new zzbg(), g.a());
    }

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        return a(httpClient, httpUriRequest, httpContext, new zzbg(), g.a());
    }

    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler) throws IOException {
        return a(httpClient, httpUriRequest, responseHandler, new zzbg(), g.a());
    }

    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext) throws IOException {
        return a(httpClient, httpUriRequest, responseHandler, httpContext, new zzbg(), g.a());
    }

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return a(httpClient, httpHost, httpRequest, new zzbg(), g.a());
    }

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        return a(httpClient, httpHost, httpRequest, httpContext, new zzbg(), g.a());
    }

    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return a(httpClient, httpHost, httpRequest, responseHandler, new zzbg(), g.a());
    }

    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return a(httpClient, httpHost, httpRequest, responseHandler, httpContext, new zzbg(), g.a());
    }

    private static HttpResponse a(HttpClient httpClient, HttpUriRequest httpUriRequest, zzbg zzbg, g gVar) throws IOException {
        t a2 = t.a(gVar);
        try {
            a2.a(httpUriRequest.getURI().toString()).b(httpUriRequest.getMethod());
            Long a3 = g.a((HttpMessage) httpUriRequest);
            if (a3 != null) {
                a2.a(a3.longValue());
            }
            zzbg.a();
            a2.b(zzbg.f9736a);
            HttpResponse execute = httpClient.execute(httpUriRequest);
            a2.d(zzbg.b());
            a2.a(execute.getStatusLine().getStatusCode());
            Long a4 = g.a((HttpMessage) execute);
            if (a4 != null) {
                a2.e(a4.longValue());
            }
            String a5 = g.a(execute);
            if (a5 != null) {
                a2.c(a5);
            }
            a2.b();
            return execute;
        } catch (IOException e2) {
            a2.d(zzbg.b());
            g.a(a2);
            throw e2;
        }
    }

    private static HttpResponse a(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext, zzbg zzbg, g gVar) throws IOException {
        t a2 = t.a(gVar);
        try {
            a2.a(httpUriRequest.getURI().toString()).b(httpUriRequest.getMethod());
            Long a3 = g.a((HttpMessage) httpUriRequest);
            if (a3 != null) {
                a2.a(a3.longValue());
            }
            zzbg.a();
            a2.b(zzbg.f9736a);
            HttpResponse execute = httpClient.execute(httpUriRequest, httpContext);
            a2.d(zzbg.b());
            a2.a(execute.getStatusLine().getStatusCode());
            Long a4 = g.a((HttpMessage) execute);
            if (a4 != null) {
                a2.e(a4.longValue());
            }
            String a5 = g.a(execute);
            if (a5 != null) {
                a2.c(a5);
            }
            a2.b();
            return execute;
        } catch (IOException e2) {
            a2.d(zzbg.b());
            g.a(a2);
            throw e2;
        }
    }

    private static <T> T a(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, zzbg zzbg, g gVar) throws IOException {
        t a2 = t.a(gVar);
        try {
            a2.a(httpUriRequest.getURI().toString()).b(httpUriRequest.getMethod());
            Long a3 = g.a((HttpMessage) httpUriRequest);
            if (a3 != null) {
                a2.a(a3.longValue());
            }
            zzbg.a();
            a2.b(zzbg.f9736a);
            return httpClient.execute(httpUriRequest, new e(responseHandler, zzbg, a2));
        } catch (IOException e2) {
            a2.d(zzbg.b());
            g.a(a2);
            throw e2;
        }
    }

    private static <T> T a(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext, zzbg zzbg, g gVar) throws IOException {
        t a2 = t.a(gVar);
        try {
            a2.a(httpUriRequest.getURI().toString()).b(httpUriRequest.getMethod());
            Long a3 = g.a((HttpMessage) httpUriRequest);
            if (a3 != null) {
                a2.a(a3.longValue());
            }
            zzbg.a();
            a2.b(zzbg.f9736a);
            return httpClient.execute(httpUriRequest, new e(responseHandler, zzbg, a2), httpContext);
        } catch (IOException e2) {
            a2.d(zzbg.b());
            g.a(a2);
            throw e2;
        }
    }

    private static HttpResponse a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, zzbg zzbg, g gVar) throws IOException {
        t a2 = t.a(gVar);
        try {
            String valueOf = String.valueOf(httpHost.toURI());
            String valueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            a2.a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).b(httpRequest.getRequestLine().getMethod());
            Long a3 = g.a((HttpMessage) httpRequest);
            if (a3 != null) {
                a2.a(a3.longValue());
            }
            zzbg.a();
            a2.b(zzbg.f9736a);
            HttpResponse execute = httpClient.execute(httpHost, httpRequest);
            a2.d(zzbg.b());
            a2.a(execute.getStatusLine().getStatusCode());
            Long a4 = g.a((HttpMessage) execute);
            if (a4 != null) {
                a2.e(a4.longValue());
            }
            String a5 = g.a(execute);
            if (a5 != null) {
                a2.c(a5);
            }
            a2.b();
            return execute;
        } catch (IOException e2) {
            a2.d(zzbg.b());
            g.a(a2);
            throw e2;
        }
    }

    private static HttpResponse a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, zzbg zzbg, g gVar) throws IOException {
        t a2 = t.a(gVar);
        try {
            String valueOf = String.valueOf(httpHost.toURI());
            String valueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            a2.a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).b(httpRequest.getRequestLine().getMethod());
            Long a3 = g.a((HttpMessage) httpRequest);
            if (a3 != null) {
                a2.a(a3.longValue());
            }
            zzbg.a();
            a2.b(zzbg.f9736a);
            HttpResponse execute = httpClient.execute(httpHost, httpRequest, httpContext);
            a2.d(zzbg.b());
            a2.a(execute.getStatusLine().getStatusCode());
            Long a4 = g.a((HttpMessage) execute);
            if (a4 != null) {
                a2.e(a4.longValue());
            }
            String a5 = g.a(execute);
            if (a5 != null) {
                a2.c(a5);
            }
            a2.b();
            return execute;
        } catch (IOException e2) {
            a2.d(zzbg.b());
            g.a(a2);
            throw e2;
        }
    }

    private static <T> T a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, zzbg zzbg, g gVar) throws IOException {
        t a2 = t.a(gVar);
        try {
            String valueOf = String.valueOf(httpHost.toURI());
            String valueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            a2.a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).b(httpRequest.getRequestLine().getMethod());
            Long a3 = g.a((HttpMessage) httpRequest);
            if (a3 != null) {
                a2.a(a3.longValue());
            }
            zzbg.a();
            a2.b(zzbg.f9736a);
            return httpClient.execute(httpHost, httpRequest, new e(responseHandler, zzbg, a2));
        } catch (IOException e2) {
            a2.d(zzbg.b());
            g.a(a2);
            throw e2;
        }
    }

    private static <T> T a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext, zzbg zzbg, g gVar) throws IOException {
        t a2 = t.a(gVar);
        try {
            String valueOf = String.valueOf(httpHost.toURI());
            String valueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            a2.a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).b(httpRequest.getRequestLine().getMethod());
            Long a3 = g.a((HttpMessage) httpRequest);
            if (a3 != null) {
                a2.a(a3.longValue());
            }
            zzbg.a();
            a2.b(zzbg.f9736a);
            return httpClient.execute(httpHost, httpRequest, new e(responseHandler, zzbg, a2), httpContext);
        } catch (IOException e2) {
            a2.d(zzbg.b());
            g.a(a2);
            throw e2;
        }
    }
}
