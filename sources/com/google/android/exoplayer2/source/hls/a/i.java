package com.google.android.exoplayer2.source.hls.a;

import android.net.Uri;
import com.google.android.exoplayer2.f.w;
import com.google.android.exoplayer2.source.p;
import java.io.IOException;

public interface i {

    public interface a {
        i createTracker(com.google.android.exoplayer2.source.hls.e eVar, w wVar, h hVar);
    }

    public interface b {
        boolean a(Uri uri, long j);

        void g();
    }

    public interface e {
        void a(e eVar);
    }

    e a(Uri uri, boolean z);

    void a();

    void a(Uri uri, p.a aVar, e eVar);

    void a(b bVar);

    boolean a(Uri uri);

    d b();

    void b(Uri uri) throws IOException;

    void b(b bVar);

    long c();

    void c(Uri uri);

    void d() throws IOException;

    boolean e();

    public static final class d extends IOException {
        public final Uri url;

        public d(Uri uri) {
            this.url = uri;
        }
    }

    public static final class c extends IOException {
        public final Uri url;

        public c(Uri uri) {
            this.url = uri;
        }
    }
}
