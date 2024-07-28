package com.paytm.pai.network;

import i.d;
import i.n;
import i.u;
import java.io.IOException;
import kotlin.g.b.k;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class a implements Interceptor {
    public final Response intercept(Interceptor.Chain chain) throws IOException {
        k.c(chain, "chain");
        Request request = chain.request();
        if (request.body() == null || request.header("Content-Encoding") != null) {
            return chain.proceed(request);
        }
        Request.Builder header = request.newBuilder().header("Content-Encoding", "gzip");
        String method = request.method();
        RequestBody body = request.body();
        if (body == null) {
            k.a();
        }
        k.a((Object) body, "originalRequest.body()!!");
        return chain.proceed(header.method(method, new C0733a(body)).build());
    }

    /* renamed from: com.paytm.pai.network.a$a  reason: collision with other inner class name */
    public static final class C0733a extends RequestBody {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RequestBody f43384a;

        public final long contentLength() {
            return -1;
        }

        C0733a(RequestBody requestBody) {
            this.f43384a = requestBody;
        }

        public final MediaType contentType() {
            return this.f43384a.contentType();
        }

        public final void writeTo(d dVar) throws IOException {
            k.c(dVar, "sink");
            d a2 = n.a((u) new i.k(dVar));
            this.f43384a.writeTo(a2);
            a2.close();
        }
    }
}
