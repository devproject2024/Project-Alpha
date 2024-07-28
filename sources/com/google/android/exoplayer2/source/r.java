package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.extractor.e;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.s;
import com.google.android.exoplayer2.f.w;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.q;
import java.io.IOException;

public final class r extends b implements q.c {

    /* renamed from: b  reason: collision with root package name */
    private final Uri f33277b;

    /* renamed from: c  reason: collision with root package name */
    private final i.a f33278c;

    /* renamed from: d  reason: collision with root package name */
    private final j f33279d;

    /* renamed from: e  reason: collision with root package name */
    private final w f33280e;

    /* renamed from: f  reason: collision with root package name */
    private final String f33281f;

    /* renamed from: g  reason: collision with root package name */
    private final int f33282g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f33283h;

    /* renamed from: i  reason: collision with root package name */
    private long f33284i = -9223372036854775807L;
    private boolean j;
    private ad k;

    public final void a() {
    }

    public final void b() throws IOException {
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final i.a f33285a;

        /* renamed from: b  reason: collision with root package name */
        private j f33286b;

        /* renamed from: c  reason: collision with root package name */
        private String f33287c;

        /* renamed from: d  reason: collision with root package name */
        private Object f33288d;

        /* renamed from: e  reason: collision with root package name */
        private w f33289e;

        /* renamed from: f  reason: collision with root package name */
        private int f33290f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f33291g;

        public a(i.a aVar) {
            this(aVar, new e());
        }

        private a(i.a aVar, j jVar) {
            this.f33285a = aVar;
            this.f33286b = jVar;
            this.f33289e = new s();
            this.f33290f = 1048576;
        }

        public final r a(Uri uri) {
            this.f33291g = true;
            return new r(uri, this.f33285a, this.f33286b, this.f33289e, this.f33287c, this.f33290f, this.f33288d);
        }
    }

    r(Uri uri, i.a aVar, j jVar, w wVar, String str, int i2, Object obj) {
        this.f33277b = uri;
        this.f33278c = aVar;
        this.f33279d = jVar;
        this.f33280e = wVar;
        this.f33281f = str;
        this.f33282g = i2;
        this.f33283h = obj;
    }

    public final void a(ad adVar) {
        this.k = adVar;
        b(this.f33284i, this.j);
    }

    public final n a(o.a aVar, b bVar, long j2) {
        i a2 = this.f33278c.a();
        ad adVar = this.k;
        if (adVar != null) {
            a2.a(adVar);
        }
        return new q(this.f33277b, a2, this.f33279d.createExtractors(), this.f33280e, a(aVar), this, bVar, this.f33281f, this.f33282g);
    }

    public final void a(n nVar) {
        ((q) nVar).f();
    }

    public final void a(long j2, boolean z) {
        if (j2 == -9223372036854775807L) {
            j2 = this.f33284i;
        }
        if (this.f33284i != j2 || this.j != z) {
            b(j2, z);
        }
    }

    private void b(long j2, boolean z) {
        this.f33284i = j2;
        this.j = z;
        a((ah) new x(this.f33284i, this.j, this.f33283h), (Object) null);
    }
}
