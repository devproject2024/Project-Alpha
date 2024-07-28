package com.google.android.exoplayer2.d;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.d.d;
import com.google.android.exoplayer2.drm.e;
import com.google.android.exoplayer2.drm.i;
import com.google.android.exoplayer2.g.aa;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.o;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public abstract class b extends com.google.android.exoplayer2.b {
    private static final byte[] j = ae.i("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private boolean A;
    private long B = -9223372036854775807L;
    private float C = 1.0f;
    private Format D;
    private float E = -1.0f;
    private ArrayDeque<a> F;
    private a G;
    private int H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private ByteBuffer[] R;
    private ByteBuffer[] S;
    private long T;
    private int U;
    private int V;
    private ByteBuffer W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    private int aa = 0;
    private int ab = 0;
    private int ac = 0;
    private boolean ad;
    private boolean ae;
    private long af;
    private long ag;
    private boolean ah;
    private boolean ai;
    private boolean aj;
    private boolean ak;
    private boolean al;

    /* renamed from: g  reason: collision with root package name */
    protected MediaCodec f31335g;

    /* renamed from: h  reason: collision with root package name */
    protected a f31336h;

    /* renamed from: i  reason: collision with root package name */
    protected d f31337i;
    private final c k;
    private final e<i> l;
    private final boolean m;
    private final boolean n;
    private final float o;
    private final com.google.android.exoplayer2.c.e p = new com.google.android.exoplayer2.c.e(0);
    private final com.google.android.exoplayer2.c.e q = new com.google.android.exoplayer2.c.e(0);
    private final o r = new o();
    private final aa<Format> s = new aa<>();
    private final ArrayList<Long> t = new ArrayList<>();
    private final MediaCodec.BufferInfo u = new MediaCodec.BufferInfo();
    private Format v;
    private Format w;
    private com.google.android.exoplayer2.drm.d<i> x;
    private com.google.android.exoplayer2.drm.d<i> y;
    private MediaCrypto z;

    /* access modifiers changed from: protected */
    public float a(float f2, Format[] formatArr) {
        return -1.0f;
    }

    /* access modifiers changed from: protected */
    public int a(a aVar, Format format, Format format2) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract int a(c cVar, e<i> eVar, Format format) throws d.b;

    /* access modifiers changed from: protected */
    public abstract List<a> a(c cVar, Format format, boolean z2) throws d.b;

    /* access modifiers changed from: protected */
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws com.google.android.exoplayer2.i {
    }

    /* access modifiers changed from: protected */
    public void a(com.google.android.exoplayer2.c.e eVar) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto, float f2);

    /* access modifiers changed from: protected */
    public void a(String str, long j2, long j3) {
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z2, boolean z3, Format format) throws com.google.android.exoplayer2.i;

    /* access modifiers changed from: protected */
    public boolean a(a aVar) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void c(long j2) {
    }

    public final int o() {
        return 8;
    }

    public void p() {
    }

    public void q() {
    }

    /* access modifiers changed from: protected */
    public void v() throws com.google.android.exoplayer2.i {
    }

    /* access modifiers changed from: protected */
    public boolean x() {
        return false;
    }

    public static class a extends Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;
        public final String decoderName;
        public final String diagnosticInfo;
        public final a fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public a(Format format, Throwable th, boolean z, int i2) {
            this("Decoder init failed: [" + i2 + "], " + format, th, format.f31069i, z, (String) null, buildCustomDiagnosticInfo(i2), (a) null);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(com.google.android.exoplayer2.Format r11, java.lang.Throwable r12, boolean r13, java.lang.String r14) {
            /*
                r10 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "Decoder init failed: "
                r0.<init>(r1)
                r0.append(r14)
                java.lang.String r1 = ", "
                r0.append(r1)
                r0.append(r11)
                java.lang.String r3 = r0.toString()
                java.lang.String r5 = r11.f31069i
                int r11 = com.google.android.exoplayer2.g.ae.f32499a
                r0 = 21
                if (r11 < r0) goto L_0x0023
                java.lang.String r11 = getDiagnosticInfoV21(r12)
                goto L_0x0024
            L_0x0023:
                r11 = 0
            L_0x0024:
                r8 = r11
                r9 = 0
                r2 = r10
                r4 = r12
                r6 = r13
                r7 = r14
                r2.<init>(r3, r4, r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.d.b.a.<init>(com.google.android.exoplayer2.Format, java.lang.Throwable, boolean, java.lang.String):void");
        }

        private a(String str, Throwable th, String str2, boolean z, String str3, String str4, a aVar) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z;
            this.decoderName = str3;
            this.diagnosticInfo = str4;
            this.fallbackDecoderInitializationException = aVar;
        }

        /* access modifiers changed from: private */
        public a copyWithFallbackException(a aVar) {
            return new a(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.decoderName, this.diagnosticInfo, aVar);
        }

        private static String getDiagnosticInfoV21(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        private static String buildCustomDiagnosticInfo(int i2) {
            String str = i2 < 0 ? "neg_" : "";
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + str + Math.abs(i2);
        }
    }

    public b(int i2, c cVar, e<i> eVar, boolean z2, boolean z3, float f2) {
        super(i2);
        this.k = (c) com.google.android.exoplayer2.g.a.a(cVar);
        this.l = eVar;
        this.m = z2;
        this.n = z3;
        this.o = f2;
    }

    public final int a(Format format) throws com.google.android.exoplayer2.i {
        try {
            return a(this.k, this.l, format);
        } catch (d.b e2) {
            throw com.google.android.exoplayer2.i.createForRenderer(e2, this.f31139b);
        }
    }

    /* access modifiers changed from: protected */
    public final void w() throws com.google.android.exoplayer2.i {
        if (this.f31335g == null && this.v != null) {
            b(this.y);
            String str = this.v.f31069i;
            com.google.android.exoplayer2.drm.d<i> dVar = this.x;
            if (dVar != null) {
                boolean z2 = false;
                if (this.z == null) {
                    i g2 = dVar.g();
                    if (g2 != null) {
                        try {
                            this.z = new MediaCrypto(g2.f31385a, g2.f31386b);
                            this.A = !g2.f31387c && this.z.requiresSecureDecoderComponent(str);
                        } catch (MediaCryptoException e2) {
                            throw com.google.android.exoplayer2.i.createForRenderer(e2, this.f31139b);
                        }
                    } else if (this.x.f() == null) {
                        return;
                    }
                }
                if ("Amazon".equals(ae.f32501c) && ("AFTM".equals(ae.f32502d) || "AFTB".equals(ae.f32502d))) {
                    z2 = true;
                }
                if (z2) {
                    int e3 = this.x.e();
                    if (e3 == 1) {
                        throw com.google.android.exoplayer2.i.createForRenderer(this.x.f(), this.f31139b);
                    } else if (e3 != 4) {
                        return;
                    }
                }
            }
            try {
                a(this.z, this.A);
            } catch (a e4) {
                throw com.google.android.exoplayer2.i.createForRenderer(e4, this.f31139b);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Format d(long j2) {
        Format a2 = this.s.a(j2);
        if (a2 != null) {
            this.w = a2;
        }
        return a2;
    }

    public void a(boolean z2) throws com.google.android.exoplayer2.i {
        this.f31337i = new com.google.android.exoplayer2.c.d();
    }

    public void a(long j2, boolean z2) throws com.google.android.exoplayer2.i {
        this.ah = false;
        this.ai = false;
        z();
        this.s.a();
    }

    public final void a(float f2) throws com.google.android.exoplayer2.i {
        this.C = f2;
        if (this.f31335g != null && this.ac != 3 && this.f31140c != 0) {
            G();
        }
    }

    public void r() {
        this.v = null;
        if (this.y == null && this.x == null) {
            A();
        } else {
            s();
        }
    }

    public void s() {
        try {
            y();
        } finally {
            a((com.google.android.exoplayer2.drm.d<i>) null);
        }
    }

    /* access modifiers changed from: protected */
    public void y() {
        this.F = null;
        this.f31336h = null;
        this.D = null;
        D();
        E();
        B();
        this.aj = false;
        this.T = -9223372036854775807L;
        this.t.clear();
        this.ag = -9223372036854775807L;
        this.af = -9223372036854775807L;
        try {
            if (this.f31335g != null) {
                this.f31337i.f31302b++;
                this.f31335g.stop();
                this.f31335g.release();
            }
            this.f31335g = null;
            try {
                if (this.z != null) {
                    this.z.release();
                }
            } finally {
                this.z = null;
                this.A = false;
                b((com.google.android.exoplayer2.drm.d<i>) null);
            }
        } catch (Throwable th) {
            this.f31335g = null;
            try {
                if (this.z != null) {
                    this.z.release();
                }
                throw th;
            } finally {
                this.z = null;
                this.A = false;
                b((com.google.android.exoplayer2.drm.d<i>) null);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(long r6, long r8) throws com.google.android.exoplayer2.i {
        /*
            r5 = this;
            boolean r0 = r5.ai
            if (r0 == 0) goto L_0x0008
            r5.v()
            return
        L_0x0008:
            com.google.android.exoplayer2.Format r0 = r5.v
            r1 = 1
            if (r0 != 0) goto L_0x0014
            boolean r0 = r5.b((boolean) r1)
            if (r0 != 0) goto L_0x0014
            return
        L_0x0014:
            r5.w()
            android.media.MediaCodec r0 = r5.f31335g
            r2 = 0
            if (r0 == 0) goto L_0x0051
            long r3 = android.os.SystemClock.elapsedRealtime()
            java.lang.String r0 = "drainAndFeed"
            com.google.android.exoplayer2.g.ac.a(r0)
        L_0x0025:
            boolean r0 = r5.b(r6, r8)
            if (r0 != 0) goto L_0x0025
        L_0x002b:
            boolean r6 = r5.F()
            if (r6 == 0) goto L_0x004d
            long r6 = r5.B
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x004a
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r6 = r6 - r3
            long r8 = r5.B
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r6 = 0
            goto L_0x004b
        L_0x004a:
            r6 = 1
        L_0x004b:
            if (r6 != 0) goto L_0x002b
        L_0x004d:
            com.google.android.exoplayer2.g.ac.a()
            return
        L_0x0051:
            com.google.android.exoplayer2.c.d r8 = r5.f31337i
            int r9 = r8.f31304d
            int r6 = r5.b(r6)
            int r9 = r9 + r6
            r8.f31304d = r9
            r5.b((boolean) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.d.b.a(long, long):void");
    }

    /* access modifiers changed from: protected */
    public final boolean z() throws com.google.android.exoplayer2.i {
        boolean A2 = A();
        if (A2) {
            w();
        }
        return A2;
    }

    /* access modifiers changed from: protected */
    public boolean A() {
        if (this.f31335g == null) {
            return false;
        }
        if (this.ac == 3 || this.K || (this.L && this.ae)) {
            y();
            return true;
        }
        this.f31335g.flush();
        D();
        E();
        this.T = -9223372036854775807L;
        this.ae = false;
        this.ad = false;
        this.ak = true;
        this.O = false;
        this.P = false;
        this.X = false;
        this.Y = false;
        this.aj = false;
        this.t.clear();
        this.ag = -9223372036854775807L;
        this.af = -9223372036854775807L;
        this.ab = 0;
        this.ac = 0;
        this.aa = this.Z ? 1 : 0;
        return false;
    }

    private boolean b(boolean z2) throws com.google.android.exoplayer2.i {
        this.q.a();
        int a2 = a(this.r, this.q, z2);
        if (a2 == -5) {
            b(this.r.f32757a);
            return true;
        } else if (a2 != -4 || !this.q.c()) {
            return false;
        } else {
            this.ah = true;
            J();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x01eb A[Catch:{ Exception -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x022b A[Catch:{ Exception -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x022d A[Catch:{ Exception -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x023c A[Catch:{ Exception -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x023e A[Catch:{ Exception -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0253 A[Catch:{ Exception -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0255 A[Catch:{ Exception -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x028e A[Catch:{ Exception -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0290 A[Catch:{ Exception -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0293 A[Catch:{ Exception -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02aa A[Catch:{ Exception -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x02b2 A[Catch:{ Exception -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x02ee A[Catch:{ Exception -> 0x02f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0329 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0326 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0199 A[Catch:{ Exception -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x019b A[Catch:{ Exception -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01b4 A[Catch:{ Exception -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01b6 A[Catch:{ Exception -> 0x02e0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.media.MediaCrypto r18, boolean r19) throws com.google.android.exoplayer2.d.b.a {
        /*
            r17 = this;
            r7 = r17
            r8 = r19
            java.util.ArrayDeque<com.google.android.exoplayer2.d.a> r0 = r7.F
            r9 = 0
            r10 = 0
            if (r0 != 0) goto L_0x0075
            com.google.android.exoplayer2.d.c r0 = r7.k     // Catch:{ b -> 0x0069 }
            com.google.android.exoplayer2.Format r1 = r7.v     // Catch:{ b -> 0x0069 }
            java.util.List r0 = r7.a((com.google.android.exoplayer2.d.c) r0, (com.google.android.exoplayer2.Format) r1, (boolean) r8)     // Catch:{ b -> 0x0069 }
            boolean r1 = r0.isEmpty()     // Catch:{ b -> 0x0069 }
            if (r1 == 0) goto L_0x0046
            if (r8 == 0) goto L_0x0046
            com.google.android.exoplayer2.d.c r0 = r7.k     // Catch:{ b -> 0x0069 }
            com.google.android.exoplayer2.Format r1 = r7.v     // Catch:{ b -> 0x0069 }
            java.util.List r0 = r7.a((com.google.android.exoplayer2.d.c) r0, (com.google.android.exoplayer2.Format) r1, (boolean) r10)     // Catch:{ b -> 0x0069 }
            boolean r1 = r0.isEmpty()     // Catch:{ b -> 0x0069 }
            if (r1 != 0) goto L_0x0046
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ b -> 0x0069 }
            java.lang.String r2 = "Drm session requires secure decoder for "
            r1.<init>(r2)     // Catch:{ b -> 0x0069 }
            com.google.android.exoplayer2.Format r2 = r7.v     // Catch:{ b -> 0x0069 }
            java.lang.String r2 = r2.f31069i     // Catch:{ b -> 0x0069 }
            r1.append(r2)     // Catch:{ b -> 0x0069 }
            java.lang.String r2 = ", but no secure decoder available. Trying to proceed with "
            r1.append(r2)     // Catch:{ b -> 0x0069 }
            r1.append(r0)     // Catch:{ b -> 0x0069 }
            java.lang.String r2 = "."
            r1.append(r2)     // Catch:{ b -> 0x0069 }
            com.google.android.exoplayer2.g.l.c()     // Catch:{ b -> 0x0069 }
        L_0x0046:
            java.util.ArrayDeque r1 = new java.util.ArrayDeque     // Catch:{ b -> 0x0069 }
            r1.<init>()     // Catch:{ b -> 0x0069 }
            r7.F = r1     // Catch:{ b -> 0x0069 }
            boolean r1 = r7.n     // Catch:{ b -> 0x0069 }
            if (r1 == 0) goto L_0x0057
            java.util.ArrayDeque<com.google.android.exoplayer2.d.a> r1 = r7.F     // Catch:{ b -> 0x0069 }
            r1.addAll(r0)     // Catch:{ b -> 0x0069 }
            goto L_0x0066
        L_0x0057:
            boolean r1 = r0.isEmpty()     // Catch:{ b -> 0x0069 }
            if (r1 != 0) goto L_0x0066
            java.util.ArrayDeque<com.google.android.exoplayer2.d.a> r1 = r7.F     // Catch:{ b -> 0x0069 }
            java.lang.Object r0 = r0.get(r10)     // Catch:{ b -> 0x0069 }
            r1.add(r0)     // Catch:{ b -> 0x0069 }
        L_0x0066:
            r7.G = r9     // Catch:{ b -> 0x0069 }
            goto L_0x0075
        L_0x0069:
            r0 = move-exception
            com.google.android.exoplayer2.d.b$a r1 = new com.google.android.exoplayer2.d.b$a
            com.google.android.exoplayer2.Format r2 = r7.v
            r3 = -49998(0xffffffffffff3cb2, float:NaN)
            r1.<init>((com.google.android.exoplayer2.Format) r2, (java.lang.Throwable) r0, (boolean) r8, (int) r3)
            throw r1
        L_0x0075:
            java.util.ArrayDeque<com.google.android.exoplayer2.d.a> r0 = r7.F
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0330
        L_0x007d:
            android.media.MediaCodec r0 = r7.f31335g
            if (r0 != 0) goto L_0x032c
            java.util.ArrayDeque<com.google.android.exoplayer2.d.a> r0 = r7.F
            java.lang.Object r0 = r0.peekFirst()
            r11 = r0
            com.google.android.exoplayer2.d.a r11 = (com.google.android.exoplayer2.d.a) r11
            boolean r0 = r7.a((com.google.android.exoplayer2.d.a) r11)
            if (r0 != 0) goto L_0x0091
            return
        L_0x0091:
            java.lang.String r0 = r11.f31326a     // Catch:{ Exception -> 0x02f5 }
            int r1 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ Exception -> 0x02f5 }
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            r12 = 23
            if (r1 >= r12) goto L_0x009e
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x00a6
        L_0x009e:
            float r1 = r7.C     // Catch:{ Exception -> 0x02f5 }
            com.google.android.exoplayer2.Format[] r3 = r7.f31142e     // Catch:{ Exception -> 0x02f5 }
            float r1 = r7.a((float) r1, (com.google.android.exoplayer2.Format[]) r3)     // Catch:{ Exception -> 0x02f5 }
        L_0x00a6:
            float r3 = r7.o     // Catch:{ Exception -> 0x02f5 }
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x00af
            r13 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x00b0
        L_0x00af:
            r13 = r1
        L_0x00b0:
            long r14 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x02ea }
            java.lang.String r1 = "createCodec:"
            java.lang.String r2 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x02ea }
            java.lang.String r1 = r1.concat(r2)     // Catch:{ Exception -> 0x02ea }
            com.google.android.exoplayer2.g.ac.a(r1)     // Catch:{ Exception -> 0x02ea }
            android.media.MediaCodec r6 = android.media.MediaCodec.createByCodecName(r0)     // Catch:{ Exception -> 0x02ea }
            com.google.android.exoplayer2.g.ac.a()     // Catch:{ Exception -> 0x02e7 }
            java.lang.String r1 = "configureCodec"
            com.google.android.exoplayer2.g.ac.a(r1)     // Catch:{ Exception -> 0x02e7 }
            com.google.android.exoplayer2.Format r4 = r7.v     // Catch:{ Exception -> 0x02e7 }
            r1 = r17
            r2 = r11
            r3 = r6
            r5 = r18
            r16 = r6
            r6 = r13
            r1.a(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x02e3 }
            com.google.android.exoplayer2.g.ac.a()     // Catch:{ Exception -> 0x02e3 }
            java.lang.String r1 = "startCodec"
            com.google.android.exoplayer2.g.ac.a(r1)     // Catch:{ Exception -> 0x02e3 }
            r16.start()     // Catch:{ Exception -> 0x02e3 }
            com.google.android.exoplayer2.g.ac.a()     // Catch:{ Exception -> 0x02e3 }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x02e3 }
            int r1 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ Exception -> 0x02e3 }
            r2 = 21
            if (r1 >= r2) goto L_0x00ff
            java.nio.ByteBuffer[] r1 = r16.getInputBuffers()     // Catch:{ Exception -> 0x02e3 }
            r7.R = r1     // Catch:{ Exception -> 0x02e3 }
            java.nio.ByteBuffer[] r1 = r16.getOutputBuffers()     // Catch:{ Exception -> 0x02e3 }
            r7.S = r1     // Catch:{ Exception -> 0x02e3 }
        L_0x00ff:
            r1 = r16
            r7.f31335g = r1     // Catch:{ Exception -> 0x02f5 }
            r7.f31336h = r11     // Catch:{ Exception -> 0x02f5 }
            r7.E = r13     // Catch:{ Exception -> 0x02f5 }
            com.google.android.exoplayer2.Format r1 = r7.v     // Catch:{ Exception -> 0x02f5 }
            r7.D = r1     // Catch:{ Exception -> 0x02f5 }
            int r1 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r6 = "OMX.Exynos.avc.dec.secure"
            r13 = 25
            r9 = 1
            if (r1 > r13) goto L_0x0144
            boolean r1 = r6.equals(r0)     // Catch:{ Exception -> 0x02f5 }
            if (r1 == 0) goto L_0x0144
            java.lang.String r1 = com.google.android.exoplayer2.g.ae.f32502d     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r10 = "SM-T585"
            boolean r1 = r1.startsWith(r10)     // Catch:{ Exception -> 0x02e0 }
            if (r1 != 0) goto L_0x0142
            java.lang.String r1 = com.google.android.exoplayer2.g.ae.f32502d     // Catch:{ Exception -> 0x02e0 }
            java.lang.String r10 = "SM-A510"
            boolean r1 = r1.startsWith(r10)     // Catch:{ Exception -> 0x02e0 }
            if (r1 != 0) goto L_0x0142
            java.lang.String r1 = com.google.android.exoplayer2.g.ae.f32502d     // Catch:{ Exception -> 0x02e0 }
            java.lang.String r10 = "SM-A520"
            boolean r1 = r1.startsWith(r10)     // Catch:{ Exception -> 0x02e0 }
            if (r1 != 0) goto L_0x0142
            java.lang.String r1 = com.google.android.exoplayer2.g.ae.f32502d     // Catch:{ Exception -> 0x02e0 }
            java.lang.String r10 = "SM-J700"
            boolean r1 = r1.startsWith(r10)     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x0144
        L_0x0142:
            r1 = 2
            goto L_0x0185
        L_0x0144:
            int r1 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ Exception -> 0x02e0 }
            r10 = 24
            if (r1 >= r10) goto L_0x0184
            java.lang.String r1 = "OMX.Nvidia.h264.decode"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x02e0 }
            if (r1 != 0) goto L_0x015a
            java.lang.String r1 = "OMX.Nvidia.h264.decode.secure"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x0184
        L_0x015a:
            java.lang.String r1 = "flounder"
            java.lang.String r10 = com.google.android.exoplayer2.g.ae.f32500b     // Catch:{ Exception -> 0x02e0 }
            boolean r1 = r1.equals(r10)     // Catch:{ Exception -> 0x02e0 }
            if (r1 != 0) goto L_0x0182
            java.lang.String r1 = "flounder_lte"
            java.lang.String r10 = com.google.android.exoplayer2.g.ae.f32500b     // Catch:{ Exception -> 0x02e0 }
            boolean r1 = r1.equals(r10)     // Catch:{ Exception -> 0x02e0 }
            if (r1 != 0) goto L_0x0182
            java.lang.String r1 = "grouper"
            java.lang.String r10 = com.google.android.exoplayer2.g.ae.f32500b     // Catch:{ Exception -> 0x02e0 }
            boolean r1 = r1.equals(r10)     // Catch:{ Exception -> 0x02e0 }
            if (r1 != 0) goto L_0x0182
            java.lang.String r1 = "tilapia"
            java.lang.String r10 = com.google.android.exoplayer2.g.ae.f32500b     // Catch:{ Exception -> 0x02e0 }
            boolean r1 = r1.equals(r10)     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x0184
        L_0x0182:
            r1 = 1
            goto L_0x0185
        L_0x0184:
            r1 = 0
        L_0x0185:
            r7.H = r1     // Catch:{ Exception -> 0x02e0 }
            java.lang.String r1 = com.google.android.exoplayer2.g.ae.f32502d     // Catch:{ Exception -> 0x02e0 }
            java.lang.String r10 = "SM-T230"
            boolean r1 = r1.startsWith(r10)     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x019b
            java.lang.String r1 = "OMX.MARVELL.VIDEO.HW.CODA7542DECODER"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x019b
            r1 = 1
            goto L_0x019c
        L_0x019b:
            r1 = 0
        L_0x019c:
            r7.I = r1     // Catch:{ Exception -> 0x02e0 }
            com.google.android.exoplayer2.Format r1 = r7.D     // Catch:{ Exception -> 0x02e0 }
            int r10 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ Exception -> 0x02e0 }
            if (r10 >= r2) goto L_0x01b6
            java.util.List<byte[]> r1 = r1.k     // Catch:{ Exception -> 0x02e0 }
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x01b6
            java.lang.String r1 = "OMX.MTK.VIDEO.DECODER.AVC"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x01b6
            r1 = 1
            goto L_0x01b7
        L_0x01b6:
            r1 = 0
        L_0x01b7:
            r7.J = r1     // Catch:{ Exception -> 0x02e0 }
            int r1 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ Exception -> 0x02e0 }
            r10 = 19
            r5 = 18
            if (r1 < r5) goto L_0x01f4
            int r1 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ Exception -> 0x02e0 }
            if (r1 != r5) goto L_0x01d5
            java.lang.String r1 = "OMX.SEC.avc.dec"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x02e0 }
            if (r1 != 0) goto L_0x01f4
            java.lang.String r1 = "OMX.SEC.avc.dec.secure"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x02e0 }
            if (r1 != 0) goto L_0x01f4
        L_0x01d5:
            int r1 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ Exception -> 0x02e0 }
            if (r1 != r10) goto L_0x01f2
            java.lang.String r1 = com.google.android.exoplayer2.g.ae.f32502d     // Catch:{ Exception -> 0x02e0 }
            java.lang.String r13 = "SM-G800"
            boolean r1 = r1.startsWith(r13)     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x01f2
            java.lang.String r1 = "OMX.Exynos.avc.dec"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x02e0 }
            if (r1 != 0) goto L_0x01f4
            boolean r1 = r6.equals(r0)     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x01f2
            goto L_0x01f4
        L_0x01f2:
            r1 = 0
            goto L_0x01f5
        L_0x01f4:
            r1 = 1
        L_0x01f5:
            r7.K = r1     // Catch:{ Exception -> 0x02e0 }
            int r1 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ Exception -> 0x02e0 }
            if (r1 > r12) goto L_0x0203
            java.lang.String r1 = "OMX.google.vorbis.decoder"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x02e0 }
            if (r1 != 0) goto L_0x022b
        L_0x0203:
            int r1 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ Exception -> 0x02e0 }
            if (r1 > r10) goto L_0x022d
            java.lang.String r1 = "hb2000"
            java.lang.String r6 = com.google.android.exoplayer2.g.ae.f32500b     // Catch:{ Exception -> 0x02e0 }
            boolean r1 = r1.equals(r6)     // Catch:{ Exception -> 0x02e0 }
            if (r1 != 0) goto L_0x021b
            java.lang.String r1 = "stvm8"
            java.lang.String r6 = com.google.android.exoplayer2.g.ae.f32500b     // Catch:{ Exception -> 0x02e0 }
            boolean r1 = r1.equals(r6)     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x022d
        L_0x021b:
            java.lang.String r1 = "OMX.amlogic.avc.decoder.awesome"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x02e0 }
            if (r1 != 0) goto L_0x022b
            java.lang.String r1 = "OMX.amlogic.avc.decoder.awesome.secure"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x022d
        L_0x022b:
            r1 = 1
            goto L_0x022e
        L_0x022d:
            r1 = 0
        L_0x022e:
            r7.L = r1     // Catch:{ Exception -> 0x02e0 }
            int r1 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ Exception -> 0x02e0 }
            if (r1 != r2) goto L_0x023e
            java.lang.String r1 = "OMX.google.aac.decoder"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x023e
            r1 = 1
            goto L_0x023f
        L_0x023e:
            r1 = 0
        L_0x023f:
            r7.M = r1     // Catch:{ Exception -> 0x02e0 }
            com.google.android.exoplayer2.Format r1 = r7.D     // Catch:{ Exception -> 0x02e0 }
            int r2 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ Exception -> 0x02e0 }
            if (r2 > r5) goto L_0x0255
            int r1 = r1.v     // Catch:{ Exception -> 0x02e0 }
            if (r1 != r9) goto L_0x0255
            java.lang.String r1 = "OMX.MTK.AUDIO.DECODER.MP3"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x0255
            r1 = 1
            goto L_0x0256
        L_0x0255:
            r1 = 0
        L_0x0256:
            r7.N = r1     // Catch:{ Exception -> 0x02e0 }
            java.lang.String r1 = r11.f31326a     // Catch:{ Exception -> 0x02e0 }
            int r2 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ Exception -> 0x02e0 }
            r5 = 25
            if (r2 > r5) goto L_0x0268
            java.lang.String r2 = "OMX.rk.video_decoder.avc"
            boolean r2 = r2.equals(r1)     // Catch:{ Exception -> 0x02e0 }
            if (r2 != 0) goto L_0x028e
        L_0x0268:
            int r2 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ Exception -> 0x02e0 }
            r5 = 17
            if (r2 > r5) goto L_0x0276
            java.lang.String r2 = "OMX.allwinner.video.decoder.avc"
            boolean r1 = r2.equals(r1)     // Catch:{ Exception -> 0x02e0 }
            if (r1 != 0) goto L_0x028e
        L_0x0276:
            java.lang.String r1 = "Amazon"
            java.lang.String r2 = com.google.android.exoplayer2.g.ae.f32501c     // Catch:{ Exception -> 0x02e0 }
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x0290
            java.lang.String r1 = "AFTS"
            java.lang.String r2 = com.google.android.exoplayer2.g.ae.f32502d     // Catch:{ Exception -> 0x02e0 }
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x0290
            boolean r1 = r11.f31332g     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x0290
        L_0x028e:
            r1 = 1
            goto L_0x0291
        L_0x0290:
            r1 = 0
        L_0x0291:
            if (r1 != 0) goto L_0x029c
            boolean r1 = r17.x()     // Catch:{ Exception -> 0x02e0 }
            if (r1 == 0) goto L_0x029a
            goto L_0x029c
        L_0x029a:
            r1 = 0
            goto L_0x029d
        L_0x029c:
            r1 = 1
        L_0x029d:
            r7.Q = r1     // Catch:{ Exception -> 0x02e0 }
            r17.D()     // Catch:{ Exception -> 0x02e0 }
            r17.E()     // Catch:{ Exception -> 0x02e0 }
            int r1 = r7.f31140c     // Catch:{ Exception -> 0x02e0 }
            r2 = 2
            if (r1 != r2) goto L_0x02b2
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x02e0 }
            r5 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 + r5
            goto L_0x02b7
        L_0x02b2:
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x02b7:
            r7.T = r1     // Catch:{ Exception -> 0x02e0 }
            r10 = 0
            r7.Z = r10     // Catch:{ Exception -> 0x02f5 }
            r7.aa = r10     // Catch:{ Exception -> 0x02f5 }
            r7.ae = r10     // Catch:{ Exception -> 0x02f5 }
            r7.ad = r10     // Catch:{ Exception -> 0x02f5 }
            r7.ab = r10     // Catch:{ Exception -> 0x02f5 }
            r7.ac = r10     // Catch:{ Exception -> 0x02f5 }
            r7.O = r10     // Catch:{ Exception -> 0x02f5 }
            r7.P = r10     // Catch:{ Exception -> 0x02f5 }
            r7.X = r10     // Catch:{ Exception -> 0x02f5 }
            r7.Y = r10     // Catch:{ Exception -> 0x02f5 }
            r7.ak = r9     // Catch:{ Exception -> 0x02f5 }
            com.google.android.exoplayer2.c.d r1 = r7.f31337i     // Catch:{ Exception -> 0x02f5 }
            int r2 = r1.f31301a     // Catch:{ Exception -> 0x02f5 }
            int r2 = r2 + r9
            r1.f31301a = r2     // Catch:{ Exception -> 0x02f5 }
            long r5 = r3 - r14
            r1 = r17
            r2 = r0
            r1.a((java.lang.String) r2, (long) r3, (long) r5)     // Catch:{ Exception -> 0x02f5 }
            goto L_0x0326
        L_0x02e0:
            r0 = move-exception
            r10 = 0
            goto L_0x02f6
        L_0x02e3:
            r0 = move-exception
            r1 = r16
            goto L_0x02ec
        L_0x02e7:
            r0 = move-exception
            r1 = r6
            goto L_0x02ec
        L_0x02ea:
            r0 = move-exception
            r1 = 0
        L_0x02ec:
            if (r1 == 0) goto L_0x02f4
            r17.B()     // Catch:{ Exception -> 0x02f5 }
            r1.release()     // Catch:{ Exception -> 0x02f5 }
        L_0x02f4:
            throw r0     // Catch:{ Exception -> 0x02f5 }
        L_0x02f5:
            r0 = move-exception
        L_0x02f6:
            java.lang.String r1 = java.lang.String.valueOf(r11)
            java.lang.String r2 = "Failed to initialize decoder: "
            java.lang.String r1 = r2.concat(r1)
            com.google.android.exoplayer2.g.l.a(r1, r0)
            java.util.ArrayDeque<com.google.android.exoplayer2.d.a> r1 = r7.F
            r1.removeFirst()
            com.google.android.exoplayer2.d.b$a r1 = new com.google.android.exoplayer2.d.b$a
            com.google.android.exoplayer2.Format r2 = r7.v
            java.lang.String r3 = r11.f31326a
            r1.<init>((com.google.android.exoplayer2.Format) r2, (java.lang.Throwable) r0, (boolean) r8, (java.lang.String) r3)
            com.google.android.exoplayer2.d.b$a r0 = r7.G
            if (r0 != 0) goto L_0x0318
            r7.G = r1
            goto L_0x031e
        L_0x0318:
            com.google.android.exoplayer2.d.b$a r0 = r0.copyWithFallbackException(r1)
            r7.G = r0
        L_0x031e:
            java.util.ArrayDeque<com.google.android.exoplayer2.d.a> r0 = r7.F
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0329
        L_0x0326:
            r9 = 0
            goto L_0x007d
        L_0x0329:
            com.google.android.exoplayer2.d.b$a r0 = r7.G
            throw r0
        L_0x032c:
            r1 = r9
            r7.F = r1
            return
        L_0x0330:
            r1 = r9
            com.google.android.exoplayer2.d.b$a r0 = new com.google.android.exoplayer2.d.b$a
            com.google.android.exoplayer2.Format r2 = r7.v
            r3 = -49999(0xffffffffffff3cb1, float:NaN)
            r0.<init>((com.google.android.exoplayer2.Format) r2, (java.lang.Throwable) r1, (boolean) r8, (int) r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.d.b.a(android.media.MediaCrypto, boolean):void");
    }

    private void B() {
        if (ae.f32499a < 21) {
            this.R = null;
            this.S = null;
        }
    }

    private boolean C() {
        return this.V >= 0;
    }

    private void D() {
        this.U = -1;
        this.p.f31311c = null;
    }

    private void E() {
        this.V = -1;
        this.W = null;
    }

    private void a(com.google.android.exoplayer2.drm.d<i> dVar) {
        com.google.android.exoplayer2.drm.d<i> dVar2 = this.y;
        this.y = dVar;
        c(dVar2);
    }

    private void b(com.google.android.exoplayer2.drm.d<i> dVar) {
        com.google.android.exoplayer2.drm.d<i> dVar2 = this.x;
        this.x = dVar;
        c(dVar2);
    }

    private void c(com.google.android.exoplayer2.drm.d<i> dVar) {
        if (dVar != null && dVar != this.y && dVar != this.x) {
            this.l.a(dVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:91:0x0165 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0166  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean F() throws com.google.android.exoplayer2.i {
        /*
            r13 = this;
            android.media.MediaCodec r0 = r13.f31335g
            r1 = 0
            if (r0 == 0) goto L_0x0200
            int r2 = r13.ab
            r3 = 2
            if (r2 == r3) goto L_0x0200
            boolean r2 = r13.ah
            if (r2 == 0) goto L_0x0010
            goto L_0x0200
        L_0x0010:
            int r2 = r13.U
            if (r2 >= 0) goto L_0x003b
            r4 = 0
            int r0 = r0.dequeueInputBuffer(r4)
            r13.U = r0
            int r0 = r13.U
            if (r0 >= 0) goto L_0x0021
            return r1
        L_0x0021:
            com.google.android.exoplayer2.c.e r2 = r13.p
            int r4 = com.google.android.exoplayer2.g.ae.f32499a
            r5 = 21
            if (r4 < r5) goto L_0x0030
            android.media.MediaCodec r4 = r13.f31335g
            java.nio.ByteBuffer r0 = r4.getInputBuffer(r0)
            goto L_0x0034
        L_0x0030:
            java.nio.ByteBuffer[] r4 = r13.R
            r0 = r4[r0]
        L_0x0034:
            r2.f31311c = r0
            com.google.android.exoplayer2.c.e r0 = r13.p
            r0.a()
        L_0x003b:
            int r0 = r13.ab
            r2 = 1
            if (r0 != r2) goto L_0x0058
            boolean r0 = r13.Q
            if (r0 != 0) goto L_0x0055
            r13.ae = r2
            android.media.MediaCodec r4 = r13.f31335g
            int r5 = r13.U
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 4
            r4.queueInputBuffer(r5, r6, r7, r8, r10)
            r13.D()
        L_0x0055:
            r13.ab = r3
            return r1
        L_0x0058:
            boolean r0 = r13.O
            if (r0 == 0) goto L_0x007b
            r13.O = r1
            com.google.android.exoplayer2.c.e r0 = r13.p
            java.nio.ByteBuffer r0 = r0.f31311c
            byte[] r1 = j
            r0.put(r1)
            android.media.MediaCodec r3 = r13.f31335g
            int r4 = r13.U
            r5 = 0
            byte[] r0 = j
            int r6 = r0.length
            r7 = 0
            r9 = 0
            r3.queueInputBuffer(r4, r5, r6, r7, r9)
            r13.D()
            r13.ad = r2
            return r2
        L_0x007b:
            boolean r0 = r13.aj
            if (r0 == 0) goto L_0x0082
            r0 = -4
            r4 = 0
            goto L_0x00ba
        L_0x0082:
            int r0 = r13.aa
            if (r0 != r2) goto L_0x00a7
            r0 = 0
        L_0x0087:
            com.google.android.exoplayer2.Format r4 = r13.D
            java.util.List<byte[]> r4 = r4.k
            int r4 = r4.size()
            if (r0 >= r4) goto L_0x00a5
            com.google.android.exoplayer2.Format r4 = r13.D
            java.util.List<byte[]> r4 = r4.k
            java.lang.Object r4 = r4.get(r0)
            byte[] r4 = (byte[]) r4
            com.google.android.exoplayer2.c.e r5 = r13.p
            java.nio.ByteBuffer r5 = r5.f31311c
            r5.put(r4)
            int r0 = r0 + 1
            goto L_0x0087
        L_0x00a5:
            r13.aa = r3
        L_0x00a7:
            com.google.android.exoplayer2.c.e r0 = r13.p
            java.nio.ByteBuffer r0 = r0.f31311c
            int r0 = r0.position()
            com.google.android.exoplayer2.o r4 = r13.r
            com.google.android.exoplayer2.c.e r5 = r13.p
            int r4 = r13.a((com.google.android.exoplayer2.o) r4, (com.google.android.exoplayer2.c.e) r5, (boolean) r1)
            r12 = r4
            r4 = r0
            r0 = r12
        L_0x00ba:
            boolean r5 = r13.g()
            if (r5 == 0) goto L_0x00c4
            long r5 = r13.ag
            r13.af = r5
        L_0x00c4:
            r5 = -3
            if (r0 != r5) goto L_0x00c8
            return r1
        L_0x00c8:
            r5 = -5
            if (r0 != r5) goto L_0x00de
            int r0 = r13.aa
            if (r0 != r3) goto L_0x00d6
            com.google.android.exoplayer2.c.e r0 = r13.p
            r0.a()
            r13.aa = r2
        L_0x00d6:
            com.google.android.exoplayer2.o r0 = r13.r
            com.google.android.exoplayer2.Format r0 = r0.f32757a
            r13.b((com.google.android.exoplayer2.Format) r0)
            return r2
        L_0x00de:
            com.google.android.exoplayer2.c.e r0 = r13.p
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0119
            int r0 = r13.aa
            if (r0 != r3) goto L_0x00f1
            com.google.android.exoplayer2.c.e r0 = r13.p
            r0.a()
            r13.aa = r2
        L_0x00f1:
            r13.ah = r2
            boolean r0 = r13.ad
            if (r0 != 0) goto L_0x00fb
            r13.J()
            return r1
        L_0x00fb:
            boolean r0 = r13.Q     // Catch:{ CryptoException -> 0x0111 }
            if (r0 != 0) goto L_0x0110
            r13.ae = r2     // Catch:{ CryptoException -> 0x0111 }
            android.media.MediaCodec r3 = r13.f31335g     // Catch:{ CryptoException -> 0x0111 }
            int r4 = r13.U     // Catch:{ CryptoException -> 0x0111 }
            r5 = 0
            r6 = 0
            r7 = 0
            r9 = 4
            r3.queueInputBuffer(r4, r5, r6, r7, r9)     // Catch:{ CryptoException -> 0x0111 }
            r13.D()     // Catch:{ CryptoException -> 0x0111 }
        L_0x0110:
            return r1
        L_0x0111:
            r0 = move-exception
            int r1 = r13.f31139b
            com.google.android.exoplayer2.i r0 = com.google.android.exoplayer2.i.createForRenderer(r0, r1)
            throw r0
        L_0x0119:
            boolean r0 = r13.ak
            if (r0 == 0) goto L_0x0131
            com.google.android.exoplayer2.c.e r0 = r13.p
            boolean r0 = r0.d()
            if (r0 != 0) goto L_0x0131
            com.google.android.exoplayer2.c.e r0 = r13.p
            r0.a()
            int r0 = r13.aa
            if (r0 != r3) goto L_0x0130
            r13.aa = r2
        L_0x0130:
            return r2
        L_0x0131:
            r13.ak = r1
            com.google.android.exoplayer2.c.e r0 = r13.p
            boolean r0 = r0.f()
            com.google.android.exoplayer2.drm.d<com.google.android.exoplayer2.drm.i> r3 = r13.x
            if (r3 == 0) goto L_0x015e
            if (r0 != 0) goto L_0x0144
            boolean r3 = r13.m
            if (r3 == 0) goto L_0x0144
            goto L_0x015e
        L_0x0144:
            com.google.android.exoplayer2.drm.d<com.google.android.exoplayer2.drm.i> r3 = r13.x
            int r3 = r3.e()
            if (r3 == r2) goto L_0x0151
            r5 = 4
            if (r3 == r5) goto L_0x015e
            r3 = 1
            goto L_0x015f
        L_0x0151:
            com.google.android.exoplayer2.drm.d<com.google.android.exoplayer2.drm.i> r0 = r13.x
            com.google.android.exoplayer2.drm.d$a r0 = r0.f()
            int r1 = r13.f31139b
            com.google.android.exoplayer2.i r0 = com.google.android.exoplayer2.i.createForRenderer(r0, r1)
            throw r0
        L_0x015e:
            r3 = 0
        L_0x015f:
            r13.aj = r3
            boolean r3 = r13.aj
            if (r3 == 0) goto L_0x0166
            return r1
        L_0x0166:
            boolean r3 = r13.J
            if (r3 == 0) goto L_0x0180
            if (r0 != 0) goto L_0x0180
            com.google.android.exoplayer2.c.e r3 = r13.p
            java.nio.ByteBuffer r3 = r3.f31311c
            com.google.android.exoplayer2.g.p.a((java.nio.ByteBuffer) r3)
            com.google.android.exoplayer2.c.e r3 = r13.p
            java.nio.ByteBuffer r3 = r3.f31311c
            int r3 = r3.position()
            if (r3 != 0) goto L_0x017e
            return r2
        L_0x017e:
            r13.J = r1
        L_0x0180:
            com.google.android.exoplayer2.c.e r3 = r13.p     // Catch:{ CryptoException -> 0x01f8 }
            long r9 = r3.f31312d     // Catch:{ CryptoException -> 0x01f8 }
            com.google.android.exoplayer2.c.e r3 = r13.p     // Catch:{ CryptoException -> 0x01f8 }
            boolean r3 = r3.j_()     // Catch:{ CryptoException -> 0x01f8 }
            if (r3 == 0) goto L_0x0195
            java.util.ArrayList<java.lang.Long> r3 = r13.t     // Catch:{ CryptoException -> 0x01f8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r9)     // Catch:{ CryptoException -> 0x01f8 }
            r3.add(r5)     // Catch:{ CryptoException -> 0x01f8 }
        L_0x0195:
            boolean r3 = r13.al     // Catch:{ CryptoException -> 0x01f8 }
            if (r3 == 0) goto L_0x01a2
            com.google.android.exoplayer2.g.aa<com.google.android.exoplayer2.Format> r3 = r13.s     // Catch:{ CryptoException -> 0x01f8 }
            com.google.android.exoplayer2.Format r5 = r13.v     // Catch:{ CryptoException -> 0x01f8 }
            r3.a((long) r9, r5)     // Catch:{ CryptoException -> 0x01f8 }
            r13.al = r1     // Catch:{ CryptoException -> 0x01f8 }
        L_0x01a2:
            long r5 = r13.ag     // Catch:{ CryptoException -> 0x01f8 }
            long r5 = java.lang.Math.max(r5, r9)     // Catch:{ CryptoException -> 0x01f8 }
            r13.ag = r5     // Catch:{ CryptoException -> 0x01f8 }
            com.google.android.exoplayer2.c.e r3 = r13.p     // Catch:{ CryptoException -> 0x01f8 }
            r3.g()     // Catch:{ CryptoException -> 0x01f8 }
            com.google.android.exoplayer2.c.e r3 = r13.p     // Catch:{ CryptoException -> 0x01f8 }
            r13.a((com.google.android.exoplayer2.c.e) r3)     // Catch:{ CryptoException -> 0x01f8 }
            if (r0 == 0) goto L_0x01d8
            com.google.android.exoplayer2.c.e r0 = r13.p     // Catch:{ CryptoException -> 0x01f8 }
            com.google.android.exoplayer2.c.b r0 = r0.f31310b     // Catch:{ CryptoException -> 0x01f8 }
            android.media.MediaCodec$CryptoInfo r8 = r0.f31298i     // Catch:{ CryptoException -> 0x01f8 }
            if (r4 != 0) goto L_0x01bf
            goto L_0x01ce
        L_0x01bf:
            int[] r0 = r8.numBytesOfClearData     // Catch:{ CryptoException -> 0x01f8 }
            if (r0 != 0) goto L_0x01c7
            int[] r0 = new int[r2]     // Catch:{ CryptoException -> 0x01f8 }
            r8.numBytesOfClearData = r0     // Catch:{ CryptoException -> 0x01f8 }
        L_0x01c7:
            int[] r0 = r8.numBytesOfClearData     // Catch:{ CryptoException -> 0x01f8 }
            r3 = r0[r1]     // Catch:{ CryptoException -> 0x01f8 }
            int r3 = r3 + r4
            r0[r1] = r3     // Catch:{ CryptoException -> 0x01f8 }
        L_0x01ce:
            android.media.MediaCodec r5 = r13.f31335g     // Catch:{ CryptoException -> 0x01f8 }
            int r6 = r13.U     // Catch:{ CryptoException -> 0x01f8 }
            r7 = 0
            r11 = 0
            r5.queueSecureInputBuffer(r6, r7, r8, r9, r11)     // Catch:{ CryptoException -> 0x01f8 }
            goto L_0x01e9
        L_0x01d8:
            android.media.MediaCodec r5 = r13.f31335g     // Catch:{ CryptoException -> 0x01f8 }
            int r6 = r13.U     // Catch:{ CryptoException -> 0x01f8 }
            r7 = 0
            com.google.android.exoplayer2.c.e r0 = r13.p     // Catch:{ CryptoException -> 0x01f8 }
            java.nio.ByteBuffer r0 = r0.f31311c     // Catch:{ CryptoException -> 0x01f8 }
            int r8 = r0.limit()     // Catch:{ CryptoException -> 0x01f8 }
            r11 = 0
            r5.queueInputBuffer(r6, r7, r8, r9, r11)     // Catch:{ CryptoException -> 0x01f8 }
        L_0x01e9:
            r13.D()     // Catch:{ CryptoException -> 0x01f8 }
            r13.ad = r2     // Catch:{ CryptoException -> 0x01f8 }
            r13.aa = r1     // Catch:{ CryptoException -> 0x01f8 }
            com.google.android.exoplayer2.c.d r0 = r13.f31337i     // Catch:{ CryptoException -> 0x01f8 }
            int r1 = r0.f31303c     // Catch:{ CryptoException -> 0x01f8 }
            int r1 = r1 + r2
            r0.f31303c = r1     // Catch:{ CryptoException -> 0x01f8 }
            return r2
        L_0x01f8:
            r0 = move-exception
            int r1 = r13.f31139b
            com.google.android.exoplayer2.i r0 = com.google.android.exoplayer2.i.createForRenderer(r0, r1)
            throw r0
        L_0x0200:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.d.b.F():boolean");
    }

    /* access modifiers changed from: protected */
    public void b(Format format) throws com.google.android.exoplayer2.i {
        Format format2 = this.v;
        this.v = format;
        boolean z2 = true;
        this.al = true;
        if (!ae.a((Object) format.l, (Object) format2 == null ? null : format2.l)) {
            if (format.l != null) {
                e<i> eVar = this.l;
                if (eVar != null) {
                    com.google.android.exoplayer2.drm.d<i> a2 = eVar.a(Looper.myLooper(), format.l);
                    if (a2 == this.y || a2 == this.x) {
                        this.l.a(a2);
                    }
                    a(a2);
                } else {
                    throw com.google.android.exoplayer2.i.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), this.f31139b);
                }
            } else {
                a((com.google.android.exoplayer2.drm.d<i>) null);
            }
        }
        if (this.f31335g == null) {
            w();
        } else if ((this.y != null || this.x == null) && ((this.y == null || this.x != null) && ((this.y == null || this.f31336h.f31332g) && (ae.f32499a >= 23 || this.y == this.x)))) {
            int a3 = a(this.f31336h, this.D, format);
            if (a3 == 0) {
                I();
            } else if (a3 == 1) {
                this.D = format;
                G();
                if (this.y != this.x) {
                    H();
                } else if (this.ad) {
                    this.ab = 1;
                    this.ac = 1;
                }
            } else if (a3 != 2) {
                if (a3 == 3) {
                    this.D = format;
                    G();
                    if (this.y != this.x) {
                        H();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException();
            } else if (this.I) {
                I();
            } else {
                this.Z = true;
                this.aa = 1;
                int i2 = this.H;
                if (!(i2 == 2 || (i2 == 1 && format.n == this.D.n && format.o == this.D.o))) {
                    z2 = false;
                }
                this.O = z2;
                this.D = format;
                G();
                if (this.y != this.x) {
                    H();
                }
            }
        } else {
            I();
        }
    }

    public boolean u() {
        return this.ai;
    }

    public boolean t() {
        if (this.v == null || this.aj) {
            return false;
        }
        if ((g() ? this.f31143f : this.f31141d.a()) || C()) {
            return true;
        }
        return this.T != -9223372036854775807L && SystemClock.elapsedRealtime() < this.T;
    }

    private void G() throws com.google.android.exoplayer2.i {
        if (ae.f32499a >= 23) {
            float a2 = a(this.C, this.f31142e);
            float f2 = this.E;
            if (f2 == a2) {
                return;
            }
            if (a2 == -1.0f) {
                I();
            } else if (f2 != -1.0f || a2 > this.o) {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", a2);
                this.f31335g.setParameters(bundle);
                this.E = a2;
            }
        }
    }

    private void H() throws com.google.android.exoplayer2.i {
        if (ae.f32499a < 23) {
            I();
        } else if (this.ad) {
            this.ab = 1;
            this.ac = 2;
        } else {
            L();
        }
    }

    private void I() throws com.google.android.exoplayer2.i {
        if (this.ad) {
            this.ab = 1;
            this.ac = 3;
            return;
        }
        K();
    }

    /* JADX WARNING: Removed duplicated region for block: B:87:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(long r19, long r21) throws com.google.android.exoplayer2.i {
        /*
            r18 = this;
            r14 = r18
            boolean r0 = r18.C()
            r15 = 1
            r13 = 0
            if (r0 != 0) goto L_0x0112
            boolean r0 = r14.M
            r1 = 0
            if (r0 == 0) goto L_0x0029
            boolean r0 = r14.ae
            if (r0 == 0) goto L_0x0029
            android.media.MediaCodec r0 = r14.f31335g     // Catch:{ IllegalStateException -> 0x001d }
            android.media.MediaCodec$BufferInfo r3 = r14.u     // Catch:{ IllegalStateException -> 0x001d }
            int r0 = r0.dequeueOutputBuffer(r3, r1)     // Catch:{ IllegalStateException -> 0x001d }
            goto L_0x0031
        L_0x001d:
            r18.J()
            boolean r0 = r14.ai
            if (r0 == 0) goto L_0x0028
            r18.y()
        L_0x0028:
            return r13
        L_0x0029:
            android.media.MediaCodec r0 = r14.f31335g
            android.media.MediaCodec$BufferInfo r3 = r14.u
            int r0 = r0.dequeueOutputBuffer(r3, r1)
        L_0x0031:
            r1 = 21
            if (r0 >= 0) goto L_0x0088
            r2 = -2
            if (r0 != r2) goto L_0x0067
            android.media.MediaCodec r0 = r14.f31335g
            android.media.MediaFormat r0 = r0.getOutputFormat()
            int r1 = r14.H
            if (r1 == 0) goto L_0x0058
            java.lang.String r1 = "width"
            int r1 = r0.getInteger(r1)
            r2 = 32
            if (r1 != r2) goto L_0x0058
            java.lang.String r1 = "height"
            int r1 = r0.getInteger(r1)
            if (r1 != r2) goto L_0x0058
            r14.P = r15
            goto L_0x0066
        L_0x0058:
            boolean r1 = r14.N
            if (r1 == 0) goto L_0x0061
            java.lang.String r1 = "channel-count"
            r0.setInteger(r1, r15)
        L_0x0061:
            android.media.MediaCodec r1 = r14.f31335g
            r14.a((android.media.MediaCodec) r1, (android.media.MediaFormat) r0)
        L_0x0066:
            return r15
        L_0x0067:
            r2 = -3
            if (r0 != r2) goto L_0x0077
            int r0 = com.google.android.exoplayer2.g.ae.f32499a
            if (r0 >= r1) goto L_0x0076
            android.media.MediaCodec r0 = r14.f31335g
            java.nio.ByteBuffer[] r0 = r0.getOutputBuffers()
            r14.S = r0
        L_0x0076:
            return r15
        L_0x0077:
            boolean r0 = r14.Q
            if (r0 == 0) goto L_0x0087
            boolean r0 = r14.ah
            if (r0 != 0) goto L_0x0084
            int r0 = r14.ab
            r1 = 2
            if (r0 != r1) goto L_0x0087
        L_0x0084:
            r18.J()
        L_0x0087:
            return r13
        L_0x0088:
            boolean r2 = r14.P
            if (r2 == 0) goto L_0x0094
            r14.P = r13
            android.media.MediaCodec r1 = r14.f31335g
            r1.releaseOutputBuffer(r0, r13)
            return r15
        L_0x0094:
            android.media.MediaCodec$BufferInfo r2 = r14.u
            int r2 = r2.size
            if (r2 != 0) goto L_0x00a6
            android.media.MediaCodec$BufferInfo r2 = r14.u
            int r2 = r2.flags
            r2 = r2 & 4
            if (r2 == 0) goto L_0x00a6
            r18.J()
            return r13
        L_0x00a6:
            r14.V = r0
            int r2 = com.google.android.exoplayer2.g.ae.f32499a
            if (r2 < r1) goto L_0x00b3
            android.media.MediaCodec r1 = r14.f31335g
            java.nio.ByteBuffer r0 = r1.getOutputBuffer(r0)
            goto L_0x00b7
        L_0x00b3:
            java.nio.ByteBuffer[] r1 = r14.S
            r0 = r1[r0]
        L_0x00b7:
            r14.W = r0
            java.nio.ByteBuffer r0 = r14.W
            if (r0 == 0) goto L_0x00d2
            android.media.MediaCodec$BufferInfo r1 = r14.u
            int r1 = r1.offset
            r0.position(r1)
            java.nio.ByteBuffer r0 = r14.W
            android.media.MediaCodec$BufferInfo r1 = r14.u
            int r1 = r1.offset
            android.media.MediaCodec$BufferInfo r2 = r14.u
            int r2 = r2.size
            int r1 = r1 + r2
            r0.limit(r1)
        L_0x00d2:
            android.media.MediaCodec$BufferInfo r0 = r14.u
            long r0 = r0.presentationTimeUs
            java.util.ArrayList<java.lang.Long> r2 = r14.t
            int r2 = r2.size()
            r3 = 0
        L_0x00dd:
            if (r3 >= r2) goto L_0x00f9
            java.util.ArrayList<java.lang.Long> r4 = r14.t
            java.lang.Object r4 = r4.get(r3)
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 != 0) goto L_0x00f6
            java.util.ArrayList<java.lang.Long> r0 = r14.t
            r0.remove(r3)
            r0 = 1
            goto L_0x00fa
        L_0x00f6:
            int r3 = r3 + 1
            goto L_0x00dd
        L_0x00f9:
            r0 = 0
        L_0x00fa:
            r14.X = r0
            long r0 = r14.af
            android.media.MediaCodec$BufferInfo r2 = r14.u
            long r2 = r2.presentationTimeUs
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0108
            r0 = 1
            goto L_0x0109
        L_0x0108:
            r0 = 0
        L_0x0109:
            r14.Y = r0
            android.media.MediaCodec$BufferInfo r0 = r14.u
            long r0 = r0.presentationTimeUs
            r14.d(r0)
        L_0x0112:
            boolean r0 = r14.M
            if (r0 == 0) goto L_0x014e
            boolean r0 = r14.ae
            if (r0 == 0) goto L_0x014e
            android.media.MediaCodec r5 = r14.f31335g     // Catch:{ IllegalStateException -> 0x0141 }
            java.nio.ByteBuffer r6 = r14.W     // Catch:{ IllegalStateException -> 0x0141 }
            int r7 = r14.V     // Catch:{ IllegalStateException -> 0x0141 }
            android.media.MediaCodec$BufferInfo r0 = r14.u     // Catch:{ IllegalStateException -> 0x0141 }
            int r8 = r0.flags     // Catch:{ IllegalStateException -> 0x0141 }
            android.media.MediaCodec$BufferInfo r0 = r14.u     // Catch:{ IllegalStateException -> 0x0141 }
            long r9 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0141 }
            boolean r11 = r14.X     // Catch:{ IllegalStateException -> 0x0141 }
            boolean r12 = r14.Y     // Catch:{ IllegalStateException -> 0x0141 }
            com.google.android.exoplayer2.Format r3 = r14.w     // Catch:{ IllegalStateException -> 0x0141 }
            r0 = r18
            r1 = r19
            r16 = r3
            r3 = r21
            r17 = 0
            r13 = r16
            boolean r0 = r0.a(r1, r3, r5, r6, r7, r8, r9, r11, r12, r13)     // Catch:{ IllegalStateException -> 0x013f }
            goto L_0x016e
        L_0x013f:
            goto L_0x0143
        L_0x0141:
            r17 = 0
        L_0x0143:
            r18.J()
            boolean r0 = r14.ai
            if (r0 == 0) goto L_0x014d
            r18.y()
        L_0x014d:
            return r17
        L_0x014e:
            r17 = 0
            android.media.MediaCodec r5 = r14.f31335g
            java.nio.ByteBuffer r6 = r14.W
            int r7 = r14.V
            android.media.MediaCodec$BufferInfo r0 = r14.u
            int r8 = r0.flags
            android.media.MediaCodec$BufferInfo r0 = r14.u
            long r9 = r0.presentationTimeUs
            boolean r11 = r14.X
            boolean r12 = r14.Y
            com.google.android.exoplayer2.Format r13 = r14.w
            r0 = r18
            r1 = r19
            r3 = r21
            boolean r0 = r0.a(r1, r3, r5, r6, r7, r8, r9, r11, r12, r13)
        L_0x016e:
            if (r0 == 0) goto L_0x018b
            android.media.MediaCodec$BufferInfo r0 = r14.u
            long r0 = r0.presentationTimeUs
            r14.c((long) r0)
            android.media.MediaCodec$BufferInfo r0 = r14.u
            int r0 = r0.flags
            r0 = r0 & 4
            if (r0 == 0) goto L_0x0181
            r0 = 1
            goto L_0x0182
        L_0x0181:
            r0 = 0
        L_0x0182:
            r18.E()
            if (r0 != 0) goto L_0x0188
            return r15
        L_0x0188:
            r18.J()
        L_0x018b:
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.d.b.b(long, long):boolean");
    }

    private void J() throws com.google.android.exoplayer2.i {
        int i2 = this.ac;
        if (i2 == 1) {
            z();
        } else if (i2 == 2) {
            L();
        } else if (i2 != 3) {
            this.ai = true;
            v();
        } else {
            K();
        }
    }

    private void K() throws com.google.android.exoplayer2.i {
        y();
        w();
    }

    private void L() throws com.google.android.exoplayer2.i {
        i g2 = this.y.g();
        if (g2 == null) {
            K();
        } else if (c.f31288e.equals(g2.f31385a)) {
            K();
        } else if (!z()) {
            try {
                this.z.setMediaDrmSession(g2.f31386b);
                b(this.y);
                this.ab = 0;
                this.ac = 0;
            } catch (MediaCryptoException e2) {
                throw com.google.android.exoplayer2.i.createForRenderer(e2, this.f31139b);
            }
        }
    }
}
