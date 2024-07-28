package com.google.android.exoplayer2.b;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.h;
import com.google.android.exoplayer2.b.i;
import com.google.android.exoplayer2.d.b;
import com.google.android.exoplayer2.d.c;
import com.google.android.exoplayer2.d.d;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.e;
import com.google.android.exoplayer2.drm.i;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.n;
import com.google.android.exoplayer2.g.o;
import com.google.android.exoplayer2.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class r extends b implements n {
    private int A;
    private final Context j;
    /* access modifiers changed from: private */
    public final h.a k;
    private final i l;
    private final long[] m = new long[10];
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private MediaFormat r;
    private int s;
    private int t;
    private int u;
    private int v;
    private long w;
    private boolean x;
    /* access modifiers changed from: private */
    public boolean y;
    private long z = -9223372036854775807L;

    public final n c() {
        return this;
    }

    public r(Context context, c cVar, e<i> eVar, boolean z2, boolean z3, Handler handler, h hVar, i iVar) {
        super(1, cVar, eVar, z2, z3, 44100.0f);
        this.j = context.getApplicationContext();
        this.l = iVar;
        this.k = new h.a(handler, hVar);
        iVar.a((i.c) new a(this, (byte) 0));
    }

    public final int a(c cVar, e<com.google.android.exoplayer2.drm.i> eVar, Format format) throws d.b {
        boolean z2;
        String str = format.f31069i;
        if (!o.a(str)) {
            return 0;
        }
        int i2 = ae.f32499a >= 21 ? 32 : 0;
        boolean a2 = a((e<?>) eVar, format.l);
        int i3 = 4;
        int i4 = 8;
        if (a2 && a(format.v, str) && cVar.a() != null) {
            return i2 | 8 | 4;
        }
        if (("audio/raw".equals(str) && !this.l.a(format.v, format.x)) || !this.l.a(format.v, 2)) {
            return 1;
        }
        DrmInitData drmInitData = format.l;
        if (drmInitData != null) {
            z2 = false;
            for (int i5 = 0; i5 < drmInitData.f31355c; i5++) {
                z2 |= drmInitData.f31353a[i5].f31361e;
            }
        } else {
            z2 = false;
        }
        List<com.google.android.exoplayer2.d.a> a3 = cVar.a(format.f31069i, z2, false);
        if (a3.isEmpty()) {
            if (!z2 || cVar.a(format.f31069i, false, false).isEmpty()) {
                return 1;
            }
            return 2;
        } else if (!a2) {
            return 2;
        } else {
            com.google.android.exoplayer2.d.a aVar = a3.get(0);
            boolean a4 = aVar.a(format);
            if (a4 && aVar.b(format)) {
                i4 = 16;
            }
            if (!a4) {
                i3 = 3;
            }
            return i4 | i2 | i3;
        }
    }

    public final List<com.google.android.exoplayer2.d.a> a(c cVar, Format format, boolean z2) throws d.b {
        List<com.google.android.exoplayer2.d.a> list;
        com.google.android.exoplayer2.d.a a2;
        if (a(format.v, format.f31069i) && (a2 = cVar.a()) != null) {
            return Collections.singletonList(a2);
        }
        List<com.google.android.exoplayer2.d.a> a3 = cVar.a(format.f31069i, z2, false);
        if ("audio/eac3-joc".equals(format.f31069i)) {
            list = new ArrayList<>(a3);
            list.addAll(cVar.a("audio/eac3", z2, false));
        } else {
            list = a3;
        }
        return Collections.unmodifiableList(list);
    }

    private boolean a(int i2, String str) {
        return b(i2, str) != 0;
    }

    public final int a(com.google.android.exoplayer2.d.a aVar, Format format, Format format2) {
        if (a(aVar, format2) <= this.n && format.y == 0 && format.z == 0 && format2.y == 0 && format2.z == 0) {
            if (aVar.a(format, format2, true)) {
                return 3;
            }
            if (ae.a((Object) format.f31069i, (Object) format2.f31069i) && format.v == format2.v && format.w == format2.w && format.b(format2)) {
                return 1;
            }
        }
        return 0;
    }

    public final float a(float f2, Format[] formatArr) {
        int i2 = -1;
        for (Format format : formatArr) {
            int i3 = format.w;
            if (i3 != -1) {
                i2 = Math.max(i2, i3);
            }
        }
        if (i2 == -1) {
            return -1.0f;
        }
        return ((float) i2) * f2;
    }

    public final void a(String str, long j2, long j3) {
        this.k.a(str, j2, j3);
    }

    public final void b(Format format) throws com.google.android.exoplayer2.i {
        super.b(format);
        this.k.a(format);
        this.s = "audio/raw".equals(format.f31069i) ? format.x : 2;
        this.t = format.v;
        this.u = format.y;
        this.v = format.z;
    }

    public final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws com.google.android.exoplayer2.i {
        int i2;
        int[] iArr;
        int i3;
        MediaFormat mediaFormat2 = this.r;
        if (mediaFormat2 != null) {
            i2 = b(mediaFormat2.getInteger("channel-count"), mediaFormat2.getString("mime"));
        } else {
            i2 = this.s;
            mediaFormat2 = mediaFormat;
        }
        int integer = mediaFormat2.getInteger("channel-count");
        int integer2 = mediaFormat2.getInteger("sample-rate");
        if (!this.p || integer != 6 || (i3 = this.t) >= 6) {
            iArr = null;
        } else {
            iArr = new int[i3];
            for (int i4 = 0; i4 < this.t; i4++) {
                iArr[i4] = i4;
            }
        }
        try {
            this.l.a(i2, integer, integer2, iArr, this.u, this.v);
        } catch (i.a e2) {
            throw com.google.android.exoplayer2.i.createForRenderer(e2, this.f31139b);
        }
    }

    private int b(int i2, String str) {
        if ("audio/eac3-joc".equals(str)) {
            if (this.l.a(i2, 18)) {
                return o.h("audio/eac3-joc");
            }
            str = "audio/eac3";
        }
        int h2 = o.h(str);
        if (this.l.a(i2, h2)) {
            return h2;
        }
        return 0;
    }

    public final void a(boolean z2) throws com.google.android.exoplayer2.i {
        super.a(z2);
        this.k.a(this.f31337i);
        int i2 = this.f31138a.f31105b;
        if (i2 != 0) {
            this.l.a(i2);
        } else {
            this.l.g();
        }
    }

    public final void a(Format[] formatArr, long j2) throws com.google.android.exoplayer2.i {
        super.a(formatArr, j2);
        if (this.z != -9223372036854775807L) {
            int i2 = this.A;
            if (i2 == this.m.length) {
                new StringBuilder("Too many stream changes, so dropping change at ").append(this.m[this.A - 1]);
                l.c();
            } else {
                this.A = i2 + 1;
            }
            this.m[this.A - 1] = this.z;
        }
    }

    public final void a(long j2, boolean z2) throws com.google.android.exoplayer2.i {
        super.a(j2, z2);
        this.l.i();
        this.w = j2;
        this.x = true;
        this.y = true;
        this.z = -9223372036854775807L;
        this.A = 0;
    }

    public final void p() {
        super.p();
        this.l.a();
    }

    public final void q() {
        B();
        this.l.h();
        super.q();
    }

    public final void r() {
        try {
            this.z = -9223372036854775807L;
            this.A = 0;
            this.l.i();
            try {
                super.r();
            } finally {
                this.k.b(this.f31337i);
            }
        } catch (Throwable th) {
            super.r();
            throw th;
        } finally {
            this.k.b(this.f31337i);
        }
    }

    public final void s() {
        try {
            super.s();
        } finally {
            this.l.j();
        }
    }

    public final boolean u() {
        return super.u() && this.l.d();
    }

    public final boolean t() {
        return this.l.e() || super.t();
    }

    public final x a(x xVar) {
        return this.l.a(xVar);
    }

    public final x e() {
        return this.l.f();
    }

    public final void a(com.google.android.exoplayer2.c.e eVar) {
        if (this.x && !eVar.j_()) {
            if (Math.abs(eVar.f31312d - this.w) > 500000) {
                this.w = eVar.f31312d;
            }
            this.x = false;
        }
        this.z = Math.max(eVar.f31312d, this.z);
    }

    public final void c(long j2) {
        while (this.A != 0 && j2 >= this.m[0]) {
            this.l.b();
            this.A--;
            long[] jArr = this.m;
            System.arraycopy(jArr, 1, jArr, 0, this.A);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r1 != -9223372036854775807L) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(long r1, long r3, android.media.MediaCodec r5, java.nio.ByteBuffer r6, int r7, int r8, long r9, boolean r11, boolean r12, com.google.android.exoplayer2.Format r13) throws com.google.android.exoplayer2.i {
        /*
            r0 = this;
            boolean r1 = r0.q
            if (r1 == 0) goto L_0x001a
            r1 = 0
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x001a
            r1 = r8 & 4
            if (r1 == 0) goto L_0x001a
            long r1 = r0.z
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r12 == 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r1 = r9
        L_0x001b:
            boolean r3 = r0.o
            r4 = 0
            r9 = 1
            if (r3 == 0) goto L_0x0029
            r3 = r8 & 2
            if (r3 == 0) goto L_0x0029
            r5.releaseOutputBuffer(r7, r4)
            return r9
        L_0x0029:
            if (r11 == 0) goto L_0x003b
            r5.releaseOutputBuffer(r7, r4)
            com.google.android.exoplayer2.c.d r1 = r0.f31337i
            int r2 = r1.f31306f
            int r2 = r2 + r9
            r1.f31306f = r2
            com.google.android.exoplayer2.b.i r1 = r0.l
            r1.b()
            return r9
        L_0x003b:
            com.google.android.exoplayer2.b.i r3 = r0.l     // Catch:{ b -> 0x0051, d -> 0x004f }
            boolean r1 = r3.a((java.nio.ByteBuffer) r6, (long) r1)     // Catch:{ b -> 0x0051, d -> 0x004f }
            if (r1 == 0) goto L_0x004e
            r5.releaseOutputBuffer(r7, r4)     // Catch:{ b -> 0x0051, d -> 0x004f }
            com.google.android.exoplayer2.c.d r1 = r0.f31337i     // Catch:{ b -> 0x0051, d -> 0x004f }
            int r2 = r1.f31305e     // Catch:{ b -> 0x0051, d -> 0x004f }
            int r2 = r2 + r9
            r1.f31305e = r2     // Catch:{ b -> 0x0051, d -> 0x004f }
            return r9
        L_0x004e:
            return r4
        L_0x004f:
            r1 = move-exception
            goto L_0x0052
        L_0x0051:
            r1 = move-exception
        L_0x0052:
            int r2 = r0.f31139b
            com.google.android.exoplayer2.i r1 = com.google.android.exoplayer2.i.createForRenderer(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.b.r.a(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean, boolean, com.google.android.exoplayer2.Format):boolean");
    }

    public final void v() throws com.google.android.exoplayer2.i {
        try {
            this.l.c();
        } catch (i.d e2) {
            throw com.google.android.exoplayer2.i.createForRenderer(e2, this.f31139b);
        }
    }

    public final void a(int i2, Object obj) throws com.google.android.exoplayer2.i {
        if (i2 == 2) {
            this.l.a(((Float) obj).floatValue());
        } else if (i2 == 3) {
            this.l.a((c) obj);
        } else if (i2 != 5) {
            super.a(i2, obj);
        } else {
            this.l.a((l) obj);
        }
    }

    private int a(com.google.android.exoplayer2.d.a aVar, Format format) {
        if (!"OMX.google.raw.decoder".equals(aVar.f31326a) || ae.f32499a >= 24 || (ae.f32499a == 23 && ae.c(this.j))) {
            return format.j;
        }
        return -1;
    }

    private void B() {
        long a2 = this.l.a(u());
        if (a2 != Long.MIN_VALUE) {
            if (!this.y) {
                a2 = Math.max(this.w, a2);
            }
            this.w = a2;
            this.y = false;
        }
    }

    final class a implements i.c {
        private a() {
        }

        /* synthetic */ a(r rVar, byte b2) {
            this();
        }

        public final void a(int i2) {
            r.this.k.a(i2);
        }

        public final void a() {
            boolean unused = r.this.y = true;
        }

        public final void a(int i2, long j, long j2) {
            r.this.k.a(i2, j, j2);
        }
    }

    public final void a(com.google.android.exoplayer2.d.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto, float f2) {
        Format[] formatArr = this.f31142e;
        int a2 = a(aVar, format);
        if (formatArr.length != 1) {
            int i2 = a2;
            for (Format format2 : formatArr) {
                if (aVar.a(format, format2, false)) {
                    i2 = Math.max(i2, a(aVar, format2));
                }
            }
            a2 = i2;
        }
        this.n = a2;
        this.p = ae.f32499a < 24 && "OMX.SEC.aac.dec".equals(aVar.f31326a) && "samsung".equals(ae.f32501c) && (ae.f32500b.startsWith("zeroflte") || ae.f32500b.startsWith("herolte") || ae.f32500b.startsWith("heroqlte"));
        this.q = ae.f32499a < 21 && "OMX.SEC.mp3.dec".equals(aVar.f31326a) && "samsung".equals(ae.f32501c) && (ae.f32500b.startsWith("baffin") || ae.f32500b.startsWith("grand") || ae.f32500b.startsWith("fortuna") || ae.f32500b.startsWith("gprimelte") || ae.f32500b.startsWith("j2y18lte") || ae.f32500b.startsWith("ms01"));
        this.o = aVar.f31333h;
        String str = this.o ? "audio/raw" : aVar.f31328c;
        int i3 = this.n;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", format.v);
        mediaFormat.setInteger("sample-rate", format.w);
        com.google.android.exoplayer2.d.e.a(mediaFormat, format.k);
        com.google.android.exoplayer2.d.e.a(mediaFormat, "max-input-size", i3);
        if (ae.f32499a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f2 != -1.0f) {
                if (!(ae.f32499a == 23 && ("ZTE B2017G".equals(ae.f32502d) || "AXON 7 mini".equals(ae.f32502d)))) {
                    mediaFormat.setFloat("operating-rate", f2);
                }
            }
        }
        if (ae.f32499a <= 28 && "audio/ac4".equals(format.f31069i)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        mediaCodec.configure(mediaFormat, (Surface) null, mediaCrypto, 0);
        if (this.o) {
            this.r = mediaFormat;
            this.r.setString("mime", format.f31069i);
            return;
        }
        this.r = null;
    }

    public final long d() {
        if (this.f31140c == 2) {
            B();
        }
        return this.w;
    }
}
