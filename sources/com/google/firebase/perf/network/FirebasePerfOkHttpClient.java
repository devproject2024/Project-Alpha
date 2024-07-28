package com.google.firebase.perf.network;

import com.google.android.gms.internal.p001firebaseperf.t;
import com.google.android.gms.internal.p001firebaseperf.zzbg;
import com.google.firebase.perf.internal.g;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class FirebasePerfOkHttpClient {
    private FirebasePerfOkHttpClient() {
    }

    public static Response execute(Call call) throws IOException {
        t a2 = t.a(g.a());
        zzbg zzbg = new zzbg();
        long j = zzbg.f9736a;
        try {
            Response execute = call.execute();
            a(execute, a2, j, zzbg.b());
            return execute;
        } catch (IOException e2) {
            Request request = call.request();
            if (request != null) {
                HttpUrl url = request.url();
                if (url != null) {
                    a2.a(url.url().toString());
                }
                if (request.method() != null) {
                    a2.b(request.method());
                }
            }
            a2.b(j);
            a2.d(zzbg.b());
            g.a(a2);
            throw e2;
        }
    }

    public static void enqueue(Call call, Callback callback) {
        zzbg zzbg = new zzbg();
        Callback callback2 = callback;
        call.enqueue(new h(callback2, g.a(), zzbg, zzbg.f9736a));
    }

    static void a(Response response, t tVar, long j, long j2) throws IOException {
        Request request = response.request();
        if (request != null) {
            tVar.a(request.url().url().toString());
            tVar.b(request.method());
            if (request.body() != null) {
                long contentLength = request.body().contentLength();
                if (contentLength != -1) {
                    tVar.a(contentLength);
                }
            }
            ResponseBody body = response.body();
            if (body != null) {
                long contentLength2 = body.contentLength();
                if (contentLength2 != -1) {
                    tVar.e(contentLength2);
                }
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    tVar.c(contentType.toString());
                }
            }
            tVar.a(response.code());
            tVar.b(j);
            tVar.d(j2);
            tVar.b();
        }
    }
}
