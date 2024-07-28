package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.ab;
import com.squareup.picasso.w;
import i.v;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

final class u extends ab {

    /* renamed from: a  reason: collision with root package name */
    private final j f45439a;

    /* renamed from: b  reason: collision with root package name */
    private final ad f45440b;

    /* access modifiers changed from: package-private */
    public final int a() {
        return 2;
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return true;
    }

    u(j jVar, ad adVar) {
        this.f45439a = jVar;
        this.f45440b = adVar;
    }

    public final boolean a(z zVar) {
        String scheme = zVar.f45479d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    static class a extends IOException {
        a(String str) {
            super(str);
        }
    }

    static final class b extends IOException {
        final int code;
        final int networkPolicy;

        b(int i2, int i3) {
            super("HTTP ".concat(String.valueOf(i2)));
            this.code = i2;
            this.networkPolicy = i3;
        }
    }

    public final ab.a a(z zVar, int i2) throws IOException {
        CacheControl cacheControl;
        if (i2 == 0) {
            cacheControl = null;
        } else if (t.isOfflineOnly(i2)) {
            cacheControl = CacheControl.FORCE_CACHE;
        } else {
            CacheControl.Builder builder = new CacheControl.Builder();
            if (!t.shouldReadFromDiskCache(i2)) {
                builder.noCache();
            }
            if (!t.shouldWriteToDiskCache(i2)) {
                builder.noStore();
            }
            cacheControl = builder.build();
        }
        Request.Builder url = new Request.Builder().url(zVar.f45479d.toString());
        if (cacheControl != null) {
            url.cacheControl(cacheControl);
        }
        Response a2 = this.f45439a.a(url.build());
        ResponseBody body = a2.body();
        if (a2.isSuccessful()) {
            w.d dVar = a2.cacheResponse() == null ? w.d.NETWORK : w.d.DISK;
            if (dVar == w.d.DISK && body.contentLength() == 0) {
                body.close();
                throw new a("Received response with 0 content-length header.");
            }
            if (dVar == w.d.NETWORK && body.contentLength() > 0) {
                ad adVar = this.f45440b;
                adVar.f45367c.sendMessage(adVar.f45367c.obtainMessage(4, Long.valueOf(body.contentLength())));
            }
            return new ab.a((v) body.source(), dVar);
        }
        body.close();
        throw new b(a2.code(), zVar.f45478c);
    }
}
