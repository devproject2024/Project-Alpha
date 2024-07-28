package com.google.firebase.perf.network;

import com.google.android.gms.internal.p001firebaseperf.t;
import com.google.android.gms.internal.p001firebaseperf.zzbg;
import java.io.IOException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

public final class e<T> implements ResponseHandler<T> {

    /* renamed from: a  reason: collision with root package name */
    private final ResponseHandler<? extends T> f39293a;

    /* renamed from: b  reason: collision with root package name */
    private final zzbg f39294b;

    /* renamed from: c  reason: collision with root package name */
    private final t f39295c;

    public e(ResponseHandler<? extends T> responseHandler, zzbg zzbg, t tVar) {
        this.f39293a = responseHandler;
        this.f39294b = zzbg;
        this.f39295c = tVar;
    }

    public final T handleResponse(HttpResponse httpResponse) throws IOException {
        this.f39295c.d(this.f39294b.b());
        this.f39295c.a(httpResponse.getStatusLine().getStatusCode());
        Long a2 = g.a((HttpMessage) httpResponse);
        if (a2 != null) {
            this.f39295c.e(a2.longValue());
        }
        String a3 = g.a(httpResponse);
        if (a3 != null) {
            this.f39295c.c(a3);
        }
        this.f39295c.b();
        return this.f39293a.handleResponse(httpResponse);
    }
}
