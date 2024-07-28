package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class e extends b implements Handler.Callback {

    /* renamed from: g  reason: collision with root package name */
    private final b f32647g;

    /* renamed from: h  reason: collision with root package name */
    private final d f32648h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f32649i;
    private final o j;
    private final c k;
    private final Metadata[] l;
    private final long[] m;
    private int n;
    private int o;
    private a p;
    private boolean q;
    private long r;

    public final boolean t() {
        return true;
    }

    public e(d dVar, Looper looper) {
        this(dVar, looper, b.f32645a);
    }

    private e(d dVar, Looper looper, b bVar) {
        super(4);
        Handler handler;
        this.f32648h = (d) a.a(dVar);
        if (looper == null) {
            handler = null;
        } else {
            handler = ae.a(looper, (Handler.Callback) this);
        }
        this.f32649i = handler;
        this.f32647g = (b) a.a(bVar);
        this.j = new o();
        this.k = new c();
        this.l = new Metadata[5];
        this.m = new long[5];
    }

    public final int a(Format format) {
        if (this.f32647g.a(format)) {
            return a((com.google.android.exoplayer2.drm.e<?>) null, format.l) ? 4 : 2;
        }
        return 0;
    }

    public final void a(Format[] formatArr, long j2) throws i {
        this.p = this.f32647g.b(formatArr[0]);
    }

    public final void a(long j2, boolean z) {
        v();
        this.q = false;
    }

    public final void a(long j2, long j3) throws i {
        if (!this.q && this.o < 5) {
            this.k.a();
            int a2 = a(this.j, (com.google.android.exoplayer2.c.e) this.k, false);
            if (a2 == -4) {
                if (this.k.c()) {
                    this.q = true;
                } else if (!this.k.j_()) {
                    c cVar = this.k;
                    cVar.f32646e = this.r;
                    cVar.g();
                    Metadata a3 = this.p.a(this.k);
                    if (a3 != null) {
                        ArrayList arrayList = new ArrayList(a3.f32644a.length);
                        a(a3, (List<Metadata.Entry>) arrayList);
                        if (!arrayList.isEmpty()) {
                            Metadata metadata = new Metadata((List<? extends Metadata.Entry>) arrayList);
                            int i2 = (this.n + this.o) % 5;
                            this.l[i2] = metadata;
                            this.m[i2] = this.k.f31312d;
                            this.o++;
                        }
                    }
                }
            } else if (a2 == -5) {
                this.r = this.j.f32757a.m;
            }
        }
        if (this.o > 0) {
            long[] jArr = this.m;
            int i3 = this.n;
            if (jArr[i3] <= j2) {
                Metadata metadata2 = this.l[i3];
                Handler handler = this.f32649i;
                if (handler != null) {
                    handler.obtainMessage(0, metadata2).sendToTarget();
                } else {
                    a(metadata2);
                }
                Metadata[] metadataArr = this.l;
                int i4 = this.n;
                metadataArr[i4] = null;
                this.n = (i4 + 1) % 5;
                this.o--;
            }
        }
    }

    public final void r() {
        v();
        this.p = null;
    }

    public final boolean u() {
        return this.q;
    }

    private void v() {
        Arrays.fill(this.l, (Object) null);
        this.n = 0;
        this.o = 0;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            a((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    private void a(Metadata metadata) {
        this.f32648h.a(metadata);
    }

    private void a(Metadata metadata, List<Metadata.Entry> list) {
        for (int i2 = 0; i2 < metadata.f32644a.length; i2++) {
            Format a2 = metadata.f32644a[i2].a();
            if (a2 == null || !this.f32647g.a(a2)) {
                list.add(metadata.f32644a[i2]);
            } else {
                a b2 = this.f32647g.b(a2);
                byte[] bArr = (byte[]) a.a(metadata.f32644a[i2].b());
                this.k.a();
                this.k.c(bArr.length);
                this.k.f31311c.put(bArr);
                this.k.g();
                Metadata a3 = b2.a(this.k);
                if (a3 != null) {
                    a(a3, list);
                }
            }
        }
    }
}
