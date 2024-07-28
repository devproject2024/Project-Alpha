package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.s;
import com.google.android.exoplayer2.f.w;
import com.google.android.exoplayer2.source.o;
import java.io.IOException;

@Deprecated
public final class j extends b implements o.b {

    /* renamed from: b  reason: collision with root package name */
    private final r f33202b;

    public final void b() throws IOException {
    }

    public /* synthetic */ j(Uri uri, i.a aVar, com.google.android.exoplayer2.extractor.j jVar, w wVar, String str, int i2, Object obj, byte b2) {
        this(uri, aVar, jVar, wVar, str, i2, obj);
    }

    @Deprecated
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final i.a f33203a;

        /* renamed from: b  reason: collision with root package name */
        public com.google.android.exoplayer2.extractor.j f33204b;

        /* renamed from: c  reason: collision with root package name */
        public String f33205c;

        /* renamed from: d  reason: collision with root package name */
        public Object f33206d;

        /* renamed from: e  reason: collision with root package name */
        public w f33207e = new s();

        /* renamed from: f  reason: collision with root package name */
        public int f33208f = 1048576;

        /* renamed from: g  reason: collision with root package name */
        public boolean f33209g;

        public a(i.a aVar) {
            this.f33203a = aVar;
        }
    }

    private j(Uri uri, i.a aVar, com.google.android.exoplayer2.extractor.j jVar, w wVar, String str, int i2, Object obj) {
        this.f33202b = new r(uri, aVar, jVar, wVar, str, i2, obj);
    }

    public final void a(ad adVar) {
        this.f33202b.a((o.b) this, adVar);
    }

    public final n a(o.a aVar, b bVar, long j) {
        return this.f33202b.a(aVar, bVar, j);
    }

    public final void a() {
        this.f33202b.a((o.b) this);
    }

    public final void onSourceInfoRefreshed(o oVar, ah ahVar, Object obj) {
        a(ahVar, obj);
    }

    public final void a(n nVar) {
        ((q) nVar).f();
    }
}
