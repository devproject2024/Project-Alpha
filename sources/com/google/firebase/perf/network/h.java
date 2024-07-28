package com.google.firebase.perf.network;

import com.google.android.gms.internal.p001firebaseperf.t;
import com.google.android.gms.internal.p001firebaseperf.zzbg;
import com.google.firebase.perf.internal.g;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public final class h implements Callback {

    /* renamed from: a  reason: collision with root package name */
    private final Callback f39301a;

    /* renamed from: b  reason: collision with root package name */
    private final t f39302b;

    /* renamed from: c  reason: collision with root package name */
    private final long f39303c;

    /* renamed from: d  reason: collision with root package name */
    private final zzbg f39304d;

    public h(Callback callback, g gVar, zzbg zzbg, long j) {
        this.f39301a = callback;
        this.f39302b = t.a(gVar);
        this.f39303c = j;
        this.f39304d = zzbg;
    }

    public final void onFailure(Call call, IOException iOException) {
        Request request = call.request();
        if (request != null) {
            HttpUrl url = request.url();
            if (url != null) {
                this.f39302b.a(url.url().toString());
            }
            if (request.method() != null) {
                this.f39302b.b(request.method());
            }
        }
        this.f39302b.b(this.f39303c);
        this.f39302b.d(this.f39304d.b());
        g.a(this.f39302b);
        this.f39301a.onFailure(call, iOException);
    }

    public final void onResponse(Call call, Response response) throws IOException {
        Response response2 = response;
        FirebasePerfOkHttpClient.a(response2, this.f39302b, this.f39303c, this.f39304d.b());
        this.f39301a.onResponse(call, response);
    }
}
