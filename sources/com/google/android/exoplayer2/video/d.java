package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.d.c;
import com.google.android.exoplayer2.d.d;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.e;
import com.google.android.exoplayer2.drm.i;
import com.google.android.exoplayer2.g.ac;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.o;
import com.google.android.exoplayer2.video.f;
import com.google.android.exoplayer2.video.h;
import com.sendbird.android.constant.StringSet;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class d extends com.google.android.exoplayer2.d.b {
    private static final int[] k = {1920, 1600, 1440, 1280, 960, 854, 640, 540, SDKConstants.ERROR_CODE_480};
    private static boolean l;
    private static boolean m;
    private boolean A;
    private long B;
    private long C;
    private long D;
    private int E;
    private int F;
    private int G;
    private long H;
    private int I;
    private float J;
    private int K;
    private int L;
    private int M;
    private float N;
    private int O;
    private int P;
    private int Q;
    private float R;
    private boolean S;
    private int T;
    private long U;
    private long V;
    private int W;
    private e X;
    b j;
    private final Context n;
    private final f o;
    private final h.a p;
    private final long q;
    private final int r = 50;
    private final boolean s;
    private final long[] t;
    private final long[] u;
    private a v;
    private boolean w;
    private Surface x;
    private Surface y;
    private int z;

    private static boolean f(long j2) {
        return j2 < -30000;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context, c cVar, long j2, e<i> eVar, boolean z2, boolean z3, Handler handler, h hVar) {
        super(2, cVar, eVar, z2, z3, 30.0f);
        this.q = j2;
        this.n = context.getApplicationContext();
        this.o = new f(this.n);
        this.p = new h.a(handler, hVar);
        this.s = "NVIDIA".equals(ae.f32501c);
        this.t = new long[10];
        this.u = new long[10];
        this.V = -9223372036854775807L;
        this.U = -9223372036854775807L;
        this.C = -9223372036854775807L;
        this.K = -1;
        this.L = -1;
        this.N = -1.0f;
        this.J = -1.0f;
        this.z = 1;
        E();
    }

    public final int a(c cVar, e<i> eVar, Format format) throws d.b {
        boolean z2;
        int i2 = 0;
        if (!o.b(format.f31069i)) {
            return 0;
        }
        DrmInitData drmInitData = format.l;
        if (drmInitData != null) {
            z2 = false;
            for (int i3 = 0; i3 < drmInitData.f31355c; i3++) {
                z2 |= drmInitData.f31353a[i3].f31361e;
            }
        } else {
            z2 = false;
        }
        List<com.google.android.exoplayer2.d.a> a2 = a(cVar, format, z2);
        if (a2.isEmpty()) {
            return (!z2 || cVar.a(format.f31069i, false, false).isEmpty()) ? 1 : 2;
        }
        if (!a((e<?>) eVar, drmInitData)) {
            return 2;
        }
        com.google.android.exoplayer2.d.a aVar = a2.get(0);
        boolean a3 = aVar.a(format);
        int i4 = aVar.b(format) ? 16 : 8;
        if (a3) {
            List<com.google.android.exoplayer2.d.a> a4 = cVar.a(format.f31069i, z2, true);
            if (!a4.isEmpty()) {
                com.google.android.exoplayer2.d.a aVar2 = a4.get(0);
                if (aVar2.a(format) && aVar2.b(format)) {
                    i2 = 32;
                }
            }
        }
        return (a3 ? 4 : 3) | i4 | i2;
    }

    public final List<com.google.android.exoplayer2.d.a> a(c cVar, Format format, boolean z2) throws d.b {
        return Collections.unmodifiableList(cVar.a(format.f31069i, z2, this.S));
    }

    public final void a(boolean z2) throws com.google.android.exoplayer2.i {
        super.a(z2);
        int i2 = this.T;
        this.T = this.f31138a.f31105b;
        this.S = this.T != 0;
        if (this.T != i2) {
            y();
        }
        this.p.a(this.f31337i);
        f fVar = this.o;
        fVar.f33706i = false;
        if (fVar.f33698a != null) {
            fVar.f33699b.f33711b.sendEmptyMessage(1);
            if (fVar.f33700c != null) {
                f.a aVar = fVar.f33700c;
                aVar.f33707a.registerDisplayListener(aVar, (Handler) null);
            }
            fVar.a();
        }
    }

    public final void a(Format[] formatArr, long j2) throws com.google.android.exoplayer2.i {
        if (this.V == -9223372036854775807L) {
            this.V = j2;
        } else {
            int i2 = this.W;
            if (i2 == this.t.length) {
                new StringBuilder("Too many stream changes, so dropping offset: ").append(this.t[this.W - 1]);
                l.c();
            } else {
                this.W = i2 + 1;
            }
            long[] jArr = this.t;
            int i3 = this.W;
            jArr[i3 - 1] = j2;
            this.u[i3 - 1] = this.U;
        }
        super.a(formatArr, j2);
    }

    public final void a(long j2, boolean z2) throws com.google.android.exoplayer2.i {
        super.a(j2, z2);
        C();
        this.B = -9223372036854775807L;
        this.F = 0;
        this.U = -9223372036854775807L;
        int i2 = this.W;
        if (i2 != 0) {
            this.V = this.t[i2 - 1];
            this.W = 0;
        }
        if (z2) {
            B();
        } else {
            this.C = -9223372036854775807L;
        }
    }

    public final boolean t() {
        Surface surface;
        if (super.t() && (this.A || (((surface = this.y) != null && this.x == surface) || this.f31335g == null || this.S))) {
            this.C = -9223372036854775807L;
            return true;
        } else if (this.C == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.C) {
                return true;
            }
            this.C = -9223372036854775807L;
            return false;
        }
    }

    public final void p() {
        super.p();
        this.E = 0;
        this.D = SystemClock.elapsedRealtime();
        this.H = SystemClock.elapsedRealtime() * 1000;
    }

    public final void q() {
        this.C = -9223372036854775807L;
        H();
        super.q();
    }

    public final void r() {
        this.U = -9223372036854775807L;
        this.V = -9223372036854775807L;
        this.W = 0;
        E();
        C();
        f fVar = this.o;
        if (fVar.f33698a != null) {
            if (fVar.f33700c != null) {
                f.a aVar = fVar.f33700c;
                aVar.f33707a.unregisterDisplayListener(aVar);
            }
            fVar.f33699b.f33711b.sendEmptyMessage(2);
        }
        this.j = null;
        try {
            super.r();
        } finally {
            this.p.b(this.f31337i);
        }
    }

    public final void s() {
        try {
            super.s();
        } finally {
            Surface surface = this.y;
            if (surface != null) {
                if (this.x == surface) {
                    this.x = null;
                }
                this.y.release();
                this.y = null;
            }
        }
    }

    public final void a(int i2, Object obj) throws com.google.android.exoplayer2.i {
        if (i2 == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                Surface surface2 = this.y;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    com.google.android.exoplayer2.d.a aVar = this.f31336h;
                    if (aVar != null && b(aVar)) {
                        this.y = DummySurface.a(this.n, aVar.f31332g);
                        surface = this.y;
                    }
                }
            }
            if (this.x != surface) {
                this.x = surface;
                int i3 = this.f31140c;
                MediaCodec mediaCodec = this.f31335g;
                if (mediaCodec != null) {
                    if (ae.f32499a < 23 || surface == null || this.w) {
                        y();
                        w();
                    } else {
                        mediaCodec.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.y) {
                    E();
                    C();
                    return;
                }
                G();
                C();
                if (i3 == 2) {
                    B();
                }
            } else if (surface != null && surface != this.y) {
                G();
                if (this.A) {
                    this.p.a(this.x);
                }
            }
        } else if (i2 == 4) {
            this.z = ((Integer) obj).intValue();
            MediaCodec mediaCodec2 = this.f31335g;
            if (mediaCodec2 != null) {
                mediaCodec2.setVideoScalingMode(this.z);
            }
        } else if (i2 == 6) {
            this.X = (e) obj;
        } else {
            super.a(i2, obj);
        }
    }

    public final boolean a(com.google.android.exoplayer2.d.a aVar) {
        return this.x != null || b(aVar);
    }

    public final boolean x() {
        return this.S;
    }

    public final void a(com.google.android.exoplayer2.d.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto, float f2) {
        a aVar2;
        boolean z2;
        Pair<Integer, Integer> a2;
        int a3;
        com.google.android.exoplayer2.d.a aVar3 = aVar;
        MediaCodec mediaCodec2 = mediaCodec;
        Format format2 = format;
        float f3 = f2;
        String str = aVar3.f31328c;
        Format[] formatArr = this.f31142e;
        int i2 = format2.n;
        int i3 = format2.o;
        int b2 = b(aVar3, format2);
        boolean z3 = false;
        if (formatArr.length == 1) {
            if (!(b2 == -1 || (a3 = a(aVar3, format2.f31069i, format2.n, format2.o)) == -1)) {
                b2 = Math.min((int) (((float) b2) * 1.5f), a3);
            }
            aVar2 = new a(i2, i3, b2);
        } else {
            int length = formatArr.length;
            int i4 = i3;
            int i5 = b2;
            boolean z4 = false;
            int i6 = i2;
            int i7 = 0;
            while (i7 < length) {
                Format format3 = formatArr[i7];
                if (aVar3.a(format2, format3, z3)) {
                    z4 |= format3.n == -1 || format3.o == -1;
                    i6 = Math.max(i6, format3.n);
                    int max = Math.max(i4, format3.o);
                    i5 = Math.max(i5, b(aVar3, format3));
                    i4 = max;
                }
                i7++;
                z3 = false;
            }
            if (z4) {
                StringBuilder sb = new StringBuilder("Resolutions unknown. Codec max resolution: ");
                sb.append(i6);
                sb.append("x");
                sb.append(i4);
                l.c();
                Point a4 = a(aVar3, format2);
                if (a4 != null) {
                    i6 = Math.max(i6, a4.x);
                    i4 = Math.max(i4, a4.y);
                    i5 = Math.max(i5, a(aVar3, format2.f31069i, i6, i4));
                    StringBuilder sb2 = new StringBuilder("Codec max resolution adjusted to: ");
                    sb2.append(i6);
                    sb2.append("x");
                    sb2.append(i4);
                    l.c();
                }
            }
            aVar2 = new a(i6, i4, i5);
        }
        this.v = aVar2;
        a aVar4 = this.v;
        boolean z5 = this.s;
        int i8 = this.T;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger(StringSet.width, format2.n);
        mediaFormat.setInteger(StringSet.height, format2.o);
        com.google.android.exoplayer2.d.e.a(mediaFormat, format2.k);
        float f4 = format2.p;
        if (f4 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f4);
        }
        com.google.android.exoplayer2.d.e.a(mediaFormat, "rotation-degrees", format2.q);
        ColorInfo colorInfo = format2.u;
        if (colorInfo != null) {
            com.google.android.exoplayer2.d.e.a(mediaFormat, "color-transfer", colorInfo.f33649c);
            com.google.android.exoplayer2.d.e.a(mediaFormat, "color-standard", colorInfo.f33647a);
            com.google.android.exoplayer2.d.e.a(mediaFormat, "color-range", colorInfo.f33648b);
            byte[] bArr = colorInfo.f33650d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(format2.f31069i) && (a2 = com.google.android.exoplayer2.d.d.a(format2.f31066f)) != null) {
            com.google.android.exoplayer2.d.e.a(mediaFormat, "profile", ((Integer) a2.first).intValue());
        }
        mediaFormat.setInteger("max-width", aVar4.f33694a);
        mediaFormat.setInteger("max-height", aVar4.f33695b);
        com.google.android.exoplayer2.d.e.a(mediaFormat, "max-input-size", aVar4.f33696c);
        if (ae.f32499a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f3 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f3);
            }
        }
        if (z5) {
            z2 = true;
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        } else {
            z2 = true;
        }
        if (i8 != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", z2);
            mediaFormat.setInteger("audio-session-id", i8);
        }
        if (this.x == null) {
            com.google.android.exoplayer2.g.a.b(b(aVar));
            if (this.y == null) {
                this.y = DummySurface.a(this.n, aVar3.f31332g);
            }
            this.x = this.y;
        }
        mediaCodec2.configure(mediaFormat, this.x, mediaCrypto, 0);
        if (ae.f32499a >= 23 && this.S) {
            this.j = new b(this, mediaCodec2, (byte) 0);
        }
    }

    public final int a(com.google.android.exoplayer2.d.a aVar, Format format, Format format2) {
        if (!aVar.a(format, format2, true) || format2.n > this.v.f33694a || format2.o > this.v.f33695b || b(aVar, format2) > this.v.f33696c) {
            return 0;
        }
        return format.b(format2) ? 3 : 2;
    }

    public final void y() {
        try {
            super.y();
        } finally {
            this.G = 0;
        }
    }

    public final boolean A() {
        try {
            return super.A();
        } finally {
            this.G = 0;
        }
    }

    public final float a(float f2, Format[] formatArr) {
        float f3 = -1.0f;
        for (Format format : formatArr) {
            float f4 = format.p;
            if (f4 != -1.0f) {
                f3 = Math.max(f3, f4);
            }
        }
        if (f3 == -1.0f) {
            return -1.0f;
        }
        return f3 * f2;
    }

    public final void a(String str, long j2, long j3) {
        this.p.a(str, j2, j3);
        this.w = a(str);
    }

    public final void b(Format format) throws com.google.android.exoplayer2.i {
        super.b(format);
        this.p.a(format);
        this.J = format.r;
        this.I = format.q;
    }

    public final void a(com.google.android.exoplayer2.c.e eVar) {
        this.G++;
        this.U = Math.max(eVar.f31312d, this.U);
        if (ae.f32499a < 23 && this.S) {
            e(eVar.f31312d);
        }
    }

    public final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i2;
        int i3;
        boolean z2 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z2) {
            i2 = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i2 = mediaFormat.getInteger(StringSet.width);
        }
        if (z2) {
            i3 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i3 = mediaFormat.getInteger(StringSet.height);
        }
        a(mediaCodec, i2, i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
        if ((f(r12) && r14 - r6.H > 100000) != false) goto L_0x01d0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x017f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(long r24, long r26, android.media.MediaCodec r28, java.nio.ByteBuffer r29, int r30, int r31, long r32, boolean r34, boolean r35, com.google.android.exoplayer2.Format r36) throws com.google.android.exoplayer2.i {
        /*
            r23 = this;
            r6 = r23
            r0 = r24
            r7 = r28
            r8 = r30
            r2 = r32
            long r4 = r6.B
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r11 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x0017
            r6.B = r0
        L_0x0017:
            long r4 = r6.V
            long r4 = r2 - r4
            r11 = 1
            if (r34 == 0) goto L_0x0024
            if (r35 != 0) goto L_0x0024
            r6.a((android.media.MediaCodec) r7, (int) r8)
            return r11
        L_0x0024:
            long r12 = r2 - r0
            android.view.Surface r14 = r6.x
            android.view.Surface r15 = r6.y
            r9 = 0
            if (r14 != r15) goto L_0x0038
            boolean r0 = f(r12)
            if (r0 == 0) goto L_0x0037
            r6.a((android.media.MediaCodec) r7, (int) r8)
            return r11
        L_0x0037:
            return r9
        L_0x0038:
            long r14 = android.os.SystemClock.elapsedRealtime()
            r16 = 1000(0x3e8, double:4.94E-321)
            long r14 = r14 * r16
            int r10 = r6.f31140c
            r11 = 2
            if (r10 != r11) goto L_0x0047
            r10 = 1
            goto L_0x0048
        L_0x0047:
            r10 = 0
        L_0x0048:
            boolean r11 = r6.A
            if (r11 == 0) goto L_0x01d0
            r34 = r10
            if (r10 == 0) goto L_0x0068
            long r9 = r6.H
            long r9 = r14 - r9
            boolean r18 = f(r12)
            if (r18 == 0) goto L_0x0063
            r18 = 100000(0x186a0, double:4.94066E-319)
            int r20 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r20 <= 0) goto L_0x0063
            r9 = 1
            goto L_0x0064
        L_0x0063:
            r9 = 0
        L_0x0064:
            if (r9 == 0) goto L_0x0068
            goto L_0x01d0
        L_0x0068:
            if (r34 == 0) goto L_0x01ce
            long r9 = r6.B
            int r18 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r18 != 0) goto L_0x0072
            goto L_0x01ce
        L_0x0072:
            long r14 = r14 - r26
            long r12 = r12 - r14
            long r9 = java.lang.System.nanoTime()
            long r12 = r12 * r16
            long r12 = r12 + r9
            com.google.android.exoplayer2.video.f r14 = r6.o
            r26 = r12
            long r11 = r2 * r16
            boolean r13 = r14.f33706i
            if (r13 == 0) goto L_0x00d4
            long r0 = r14.f33703f
            int r13 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r13 == 0) goto L_0x0098
            long r0 = r14.l
            r18 = 1
            long r0 = r0 + r18
            r14.l = r0
            long r0 = r14.f33705h
            r14.f33704g = r0
        L_0x0098:
            long r0 = r14.l
            r18 = 6
            int r13 = (r0 > r18 ? 1 : (r0 == r18 ? 0 : -1))
            if (r13 < 0) goto L_0x00c6
            long r0 = r14.k
            long r0 = r11 - r0
            r18 = r4
            long r4 = r14.l
            long r0 = r0 / r4
            long r4 = r14.f33704g
            long r0 = r0 + r4
            r4 = r26
            boolean r13 = r14.a(r0, r4)
            if (r13 == 0) goto L_0x00b8
            r13 = 0
            r14.f33706i = r13
            goto L_0x00d8
        L_0x00b8:
            r13 = 0
            long r7 = r14.j
            long r7 = r7 + r0
            r26 = r0
            long r0 = r14.k
            long r0 = r7 - r0
            r7 = r0
            r0 = r26
            goto L_0x00da
        L_0x00c6:
            r18 = r4
            r13 = 0
            r4 = r26
            boolean r0 = r14.a(r11, r4)
            if (r0 == 0) goto L_0x00d8
            r14.f33706i = r13
            goto L_0x00d8
        L_0x00d4:
            r18 = r4
            r4 = r26
        L_0x00d8:
            r7 = r4
            r0 = r11
        L_0x00da:
            boolean r13 = r14.f33706i
            if (r13 != 0) goto L_0x00e9
            r14.k = r11
            r14.j = r4
            r4 = 0
            r14.l = r4
            r4 = 1
            r14.f33706i = r4
        L_0x00e9:
            r14.f33703f = r2
            r14.f33705h = r0
            com.google.android.exoplayer2.video.f$b r0 = r14.f33699b
            if (r0 == 0) goto L_0x0128
            long r0 = r14.f33701d
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00fd
            goto L_0x0128
        L_0x00fd:
            com.google.android.exoplayer2.video.f$b r0 = r14.f33699b
            long r0 = r0.f33710a
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0106
            goto L_0x0128
        L_0x0106:
            long r2 = r14.f33701d
            long r4 = r7 - r0
            long r4 = r4 / r2
            long r4 = r4 * r2
            long r0 = r0 + r4
            int r4 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r4 > 0) goto L_0x011a
            long r2 = r0 - r2
            r21 = r0
            r0 = r2
            r2 = r21
            goto L_0x011b
        L_0x011a:
            long r2 = r2 + r0
        L_0x011b:
            long r4 = r2 - r7
            long r7 = r7 - r0
            int r11 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r11 >= 0) goto L_0x0123
            goto L_0x0124
        L_0x0123:
            r2 = r0
        L_0x0124:
            long r0 = r14.f33702e
            long r2 = r2 - r0
            r7 = r2
        L_0x0128:
            long r0 = r7 - r9
            long r0 = r0 / r16
            r2 = -500000(0xfffffffffff85ee0, double:NaN)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0135
            r2 = 1
            goto L_0x0136
        L_0x0135:
            r2 = 0
        L_0x0136:
            if (r2 == 0) goto L_0x013c
            if (r35 != 0) goto L_0x013c
            r2 = 1
            goto L_0x013d
        L_0x013c:
            r2 = 0
        L_0x013d:
            if (r2 == 0) goto L_0x015d
            int r2 = r23.b(r24)
            if (r2 != 0) goto L_0x0147
            r2 = 0
            goto L_0x0159
        L_0x0147:
            com.google.android.exoplayer2.c.d r3 = r6.f31337i
            int r4 = r3.f31309i
            r5 = 1
            int r4 = r4 + r5
            r3.f31309i = r4
            int r3 = r6.G
            int r3 = r3 + r2
            r6.b((int) r3)
            r23.z()
            r2 = 1
        L_0x0159:
            if (r2 == 0) goto L_0x015d
            r2 = 0
            return r2
        L_0x015d:
            boolean r2 = f(r0)
            if (r2 == 0) goto L_0x0167
            if (r35 != 0) goto L_0x0167
            r2 = 1
            goto L_0x0168
        L_0x0167:
            r2 = 0
        L_0x0168:
            if (r2 == 0) goto L_0x017f
            java.lang.String r0 = "dropVideoBuffer"
            com.google.android.exoplayer2.g.ac.a(r0)
            r9 = r28
            r10 = r30
            r0 = 0
            r9.releaseOutputBuffer(r10, r0)
            com.google.android.exoplayer2.g.ac.a()
            r0 = 1
            r6.b((int) r0)
            return r0
        L_0x017f:
            r9 = r28
            r10 = r30
            int r2 = com.google.android.exoplayer2.g.ae.f32499a
            r3 = 21
            if (r2 < r3) goto L_0x019f
            r2 = 50000(0xc350, double:2.47033E-319)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x01cc
            r0 = r23
            r1 = r18
            r3 = r7
            r5 = r36
            r0.a((long) r1, (long) r3, (com.google.android.exoplayer2.Format) r5)
            r6.a((android.media.MediaCodec) r9, (int) r10, (long) r7)
            r0 = 1
            return r0
        L_0x019f:
            r2 = 30000(0x7530, double:1.4822E-319)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x01cc
            r2 = 11000(0x2af8, double:5.4347E-320)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x01bd
            r2 = 10000(0x2710, double:4.9407E-320)
            long r0 = r0 - r2
            long r0 = r0 / r16
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x01b4 }
            goto L_0x01bd
        L_0x01b4:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            r0 = 0
            return r0
        L_0x01bd:
            r0 = r23
            r1 = r18
            r3 = r7
            r5 = r36
            r0.a((long) r1, (long) r3, (com.google.android.exoplayer2.Format) r5)
            r6.b((android.media.MediaCodec) r9, (int) r10)
            r0 = 1
            return r0
        L_0x01cc:
            r0 = 0
            return r0
        L_0x01ce:
            r0 = 0
            return r0
        L_0x01d0:
            r18 = r4
            r9 = r7
            r10 = r8
            long r7 = java.lang.System.nanoTime()
            r0 = r23
            r1 = r18
            r3 = r7
            r5 = r36
            r0.a((long) r1, (long) r3, (com.google.android.exoplayer2.Format) r5)
            int r0 = com.google.android.exoplayer2.g.ae.f32499a
            r1 = 21
            if (r0 < r1) goto L_0x01ec
            r6.a((android.media.MediaCodec) r9, (int) r10, (long) r7)
            goto L_0x01ef
        L_0x01ec:
            r6.b((android.media.MediaCodec) r9, (int) r10)
        L_0x01ef:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.d.a(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean, boolean, com.google.android.exoplayer2.Format):boolean");
    }

    private void a(MediaCodec mediaCodec, int i2, int i3) {
        this.K = i2;
        this.L = i3;
        this.N = this.J;
        if (ae.f32499a >= 21) {
            int i4 = this.I;
            if (i4 == 90 || i4 == 270) {
                int i5 = this.K;
                this.K = this.L;
                this.L = i5;
                this.N = 1.0f / this.N;
            }
        } else {
            this.M = this.I;
        }
        mediaCodec.setVideoScalingMode(this.z);
    }

    private void a(long j2, long j3, Format format) {
        e eVar = this.X;
        if (eVar != null) {
            eVar.a(j2, j3, format);
        }
    }

    /* access modifiers changed from: protected */
    public final void e(long j2) {
        Format d2 = d(j2);
        if (d2 != null) {
            a(this.f31335g, d2.n, d2.o);
        }
        F();
        D();
        c(j2);
    }

    public final void c(long j2) {
        this.G--;
        while (true) {
            int i2 = this.W;
            if (i2 != 0 && j2 >= this.u[0]) {
                long[] jArr = this.t;
                this.V = jArr[0];
                this.W = i2 - 1;
                System.arraycopy(jArr, 1, jArr, 0, this.W);
                long[] jArr2 = this.u;
                System.arraycopy(jArr2, 1, jArr2, 0, this.W);
            } else {
                return;
            }
        }
    }

    private void a(MediaCodec mediaCodec, int i2) {
        ac.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        ac.a();
        this.f31337i.f31306f++;
    }

    private void b(int i2) {
        this.f31337i.f31307g += i2;
        this.E += i2;
        this.F += i2;
        this.f31337i.f31308h = Math.max(this.F, this.f31337i.f31308h);
        int i3 = this.r;
        if (i3 > 0 && this.E >= i3) {
            H();
        }
    }

    private void b(MediaCodec mediaCodec, int i2) {
        F();
        ac.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, true);
        ac.a();
        this.H = SystemClock.elapsedRealtime() * 1000;
        this.f31337i.f31305e++;
        this.F = 0;
        D();
    }

    private void a(MediaCodec mediaCodec, int i2, long j2) {
        F();
        ac.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, j2);
        ac.a();
        this.H = SystemClock.elapsedRealtime() * 1000;
        this.f31337i.f31305e++;
        this.F = 0;
        D();
    }

    private boolean b(com.google.android.exoplayer2.d.a aVar) {
        if (ae.f32499a < 23 || this.S || a(aVar.f31326a)) {
            return false;
        }
        return !aVar.f31332g || DummySurface.a(this.n);
    }

    private void B() {
        this.C = this.q > 0 ? SystemClock.elapsedRealtime() + this.q : -9223372036854775807L;
    }

    private void C() {
        MediaCodec mediaCodec;
        this.A = false;
        if (ae.f32499a >= 23 && this.S && (mediaCodec = this.f31335g) != null) {
            this.j = new b(this, mediaCodec, (byte) 0);
        }
    }

    private void D() {
        if (!this.A) {
            this.A = true;
            this.p.a(this.x);
        }
    }

    private void E() {
        this.O = -1;
        this.P = -1;
        this.R = -1.0f;
        this.Q = -1;
    }

    private void F() {
        if (this.K != -1 || this.L != -1) {
            if (this.O != this.K || this.P != this.L || this.Q != this.M || this.R != this.N) {
                this.p.a(this.K, this.L, this.M, this.N);
                this.O = this.K;
                this.P = this.L;
                this.Q = this.M;
                this.R = this.N;
            }
        }
    }

    private void G() {
        if (this.O != -1 || this.P != -1) {
            this.p.a(this.O, this.P, this.Q, this.R);
        }
    }

    private void H() {
        if (this.E > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.p.a(this.E, elapsedRealtime - this.D);
            this.E = 0;
            this.D = elapsedRealtime;
        }
    }

    private static Point a(com.google.android.exoplayer2.d.a aVar, Format format) {
        int i2 = 0;
        boolean z2 = format.o > format.n;
        int i3 = z2 ? format.o : format.n;
        int i4 = z2 ? format.n : format.o;
        float f2 = ((float) i4) / ((float) i3);
        int[] iArr = k;
        int length = iArr.length;
        while (true) {
            Point point = null;
            if (i2 >= length) {
                break;
            }
            int i5 = iArr[i2];
            int i6 = (int) (((float) i5) * f2);
            if (i5 <= i3 || i6 <= i4) {
                break;
            }
            if (ae.f32499a >= 21) {
                int i7 = z2 ? i6 : i5;
                if (!z2) {
                    i5 = i6;
                }
                if (aVar.f31329d == null) {
                    aVar.a("align.caps");
                } else {
                    MediaCodecInfo.VideoCapabilities videoCapabilities = aVar.f31329d.getVideoCapabilities();
                    if (videoCapabilities == null) {
                        aVar.a("align.vCaps");
                    } else {
                        int widthAlignment = videoCapabilities.getWidthAlignment();
                        int heightAlignment = videoCapabilities.getHeightAlignment();
                        point = new Point(ae.a(i7, widthAlignment) * widthAlignment, ae.a(i5, heightAlignment) * heightAlignment);
                    }
                }
                if (aVar.a(point.x, point.y, (double) format.p)) {
                    return point;
                }
            } else {
                try {
                    int a2 = ae.a(i5, 16) * 16;
                    int a3 = ae.a(i6, 16) * 16;
                    if (a2 * a3 <= com.google.android.exoplayer2.d.d.b()) {
                        int i8 = z2 ? a3 : a2;
                        if (!z2) {
                            a2 = a3;
                        }
                        return new Point(i8, a2);
                    }
                } catch (d.b unused) {
                }
            }
            i2++;
        }
        return null;
    }

    private static int b(com.google.android.exoplayer2.d.a aVar, Format format) {
        if (format.j == -1) {
            return a(aVar, format.f31069i, format.n, format.o);
        }
        int size = format.k.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += format.k.get(i3).length;
        }
        return format.j + i2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(com.google.android.exoplayer2.d.a r7, java.lang.String r8, int r9, int r10) {
        /*
            r0 = -1
            if (r9 == r0) goto L_0x00af
            if (r10 != r0) goto L_0x0007
            goto L_0x00af
        L_0x0007:
            int r1 = r8.hashCode()
            r2 = 5
            r3 = 1
            r4 = 4
            r5 = 3
            r6 = 2
            switch(r1) {
                case -1664118616: goto L_0x004b;
                case -1662541442: goto L_0x0040;
                case 1187890754: goto L_0x0035;
                case 1331836730: goto L_0x002a;
                case 1599127256: goto L_0x001f;
                case 1599127257: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0056
        L_0x0014:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0056
            r8 = 5
            goto L_0x0057
        L_0x001f:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0056
            r8 = 3
            goto L_0x0057
        L_0x002a:
            java.lang.String r1 = "video/avc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0056
            r8 = 2
            goto L_0x0057
        L_0x0035:
            java.lang.String r1 = "video/mp4v-es"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0056
            r8 = 1
            goto L_0x0057
        L_0x0040:
            java.lang.String r1 = "video/hevc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0056
            r8 = 4
            goto L_0x0057
        L_0x004b:
            java.lang.String r1 = "video/3gpp"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0056
            r8 = 0
            goto L_0x0057
        L_0x0056:
            r8 = -1
        L_0x0057:
            if (r8 == 0) goto L_0x00a6
            if (r8 == r3) goto L_0x00a6
            if (r8 == r6) goto L_0x0067
            if (r8 == r5) goto L_0x00a6
            if (r8 == r4) goto L_0x0064
            if (r8 == r2) goto L_0x0064
            return r0
        L_0x0064:
            int r9 = r9 * r10
            goto L_0x00a9
        L_0x0067:
            java.lang.String r8 = com.google.android.exoplayer2.g.ae.f32502d
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r8 = r1.equals(r8)
            if (r8 != 0) goto L_0x00a5
            java.lang.String r8 = com.google.android.exoplayer2.g.ae.f32501c
            java.lang.String r1 = "Amazon"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x0094
            java.lang.String r8 = com.google.android.exoplayer2.g.ae.f32502d
            java.lang.String r1 = "KFSOWI"
            boolean r8 = r1.equals(r8)
            if (r8 != 0) goto L_0x00a5
            java.lang.String r8 = com.google.android.exoplayer2.g.ae.f32502d
            java.lang.String r1 = "AFTS"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x0094
            boolean r7 = r7.f31332g
            if (r7 == 0) goto L_0x0094
            goto L_0x00a5
        L_0x0094:
            r7 = 16
            int r8 = com.google.android.exoplayer2.g.ae.a((int) r9, (int) r7)
            int r9 = com.google.android.exoplayer2.g.ae.a((int) r10, (int) r7)
            int r8 = r8 * r9
            int r8 = r8 * 16
            int r9 = r8 * 16
            goto L_0x00a8
        L_0x00a5:
            return r0
        L_0x00a6:
            int r9 = r9 * r10
        L_0x00a8:
            r4 = 2
        L_0x00a9:
            int r9 = r9 * 3
            int r4 = r4 * 2
            int r9 = r9 / r4
            return r9
        L_0x00af:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.d.a(com.google.android.exoplayer2.d.a, java.lang.String, int, int):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:395:0x0612, code lost:
        r1 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:396:0x0613, code lost:
        switch(r1) {
            case 0: goto L_0x0617;
            case 1: goto L_0x0617;
            case 2: goto L_0x0617;
            case 3: goto L_0x0617;
            case 4: goto L_0x0617;
            case 5: goto L_0x0617;
            case 6: goto L_0x0617;
            case 7: goto L_0x0617;
            case 8: goto L_0x0617;
            case 9: goto L_0x0617;
            case 10: goto L_0x0617;
            case 11: goto L_0x0617;
            case 12: goto L_0x0617;
            case 13: goto L_0x0617;
            case 14: goto L_0x0617;
            case 15: goto L_0x0617;
            case 16: goto L_0x0617;
            case 17: goto L_0x0617;
            case 18: goto L_0x0617;
            case 19: goto L_0x0617;
            case 20: goto L_0x0617;
            case 21: goto L_0x0617;
            case 22: goto L_0x0617;
            case 23: goto L_0x0617;
            case 24: goto L_0x0617;
            case 25: goto L_0x0617;
            case 26: goto L_0x0617;
            case 27: goto L_0x0617;
            case 28: goto L_0x0617;
            case 29: goto L_0x0617;
            case 30: goto L_0x0617;
            case 31: goto L_0x0617;
            case 32: goto L_0x0617;
            case 33: goto L_0x0617;
            case 34: goto L_0x0617;
            case 35: goto L_0x0617;
            case 36: goto L_0x0617;
            case 37: goto L_0x0617;
            case 38: goto L_0x0617;
            case 39: goto L_0x0617;
            case 40: goto L_0x0617;
            case 41: goto L_0x0617;
            case 42: goto L_0x0617;
            case 43: goto L_0x0617;
            case 44: goto L_0x0617;
            case 45: goto L_0x0617;
            case 46: goto L_0x0617;
            case 47: goto L_0x0617;
            case 48: goto L_0x0617;
            case 49: goto L_0x0617;
            case 50: goto L_0x0617;
            case 51: goto L_0x0617;
            case 52: goto L_0x0617;
            case 53: goto L_0x0617;
            case 54: goto L_0x0617;
            case 55: goto L_0x0617;
            case 56: goto L_0x0617;
            case 57: goto L_0x0617;
            case 58: goto L_0x0617;
            case 59: goto L_0x0617;
            case 60: goto L_0x0617;
            case 61: goto L_0x0617;
            case 62: goto L_0x0617;
            case 63: goto L_0x0617;
            case 64: goto L_0x0617;
            case 65: goto L_0x0617;
            case 66: goto L_0x0617;
            case 67: goto L_0x0617;
            case 68: goto L_0x0617;
            case 69: goto L_0x0617;
            case 70: goto L_0x0617;
            case 71: goto L_0x0617;
            case 72: goto L_0x0617;
            case 73: goto L_0x0617;
            case 74: goto L_0x0617;
            case 75: goto L_0x0617;
            case 76: goto L_0x0617;
            case 77: goto L_0x0617;
            case 78: goto L_0x0617;
            case 79: goto L_0x0617;
            case 80: goto L_0x0617;
            case 81: goto L_0x0617;
            case 82: goto L_0x0617;
            case 83: goto L_0x0617;
            case 84: goto L_0x0617;
            case 85: goto L_0x0617;
            case 86: goto L_0x0617;
            case 87: goto L_0x0617;
            case 88: goto L_0x0617;
            case 89: goto L_0x0617;
            case 90: goto L_0x0617;
            case 91: goto L_0x0617;
            case 92: goto L_0x0617;
            case 93: goto L_0x0617;
            case 94: goto L_0x0617;
            case 95: goto L_0x0617;
            case 96: goto L_0x0617;
            case 97: goto L_0x0617;
            case 98: goto L_0x0617;
            case 99: goto L_0x0617;
            case 100: goto L_0x0617;
            case 101: goto L_0x0617;
            case 102: goto L_0x0617;
            case 103: goto L_0x0617;
            case 104: goto L_0x0617;
            case 105: goto L_0x0617;
            case 106: goto L_0x0617;
            case 107: goto L_0x0617;
            case 108: goto L_0x0617;
            case 109: goto L_0x0617;
            case 110: goto L_0x0617;
            case 111: goto L_0x0617;
            case 112: goto L_0x0617;
            case 113: goto L_0x0617;
            case 114: goto L_0x0617;
            case 115: goto L_0x0617;
            case 116: goto L_0x0617;
            case 117: goto L_0x0617;
            case 118: goto L_0x0617;
            case 119: goto L_0x0617;
            case 120: goto L_0x0617;
            case 121: goto L_0x0617;
            case 122: goto L_0x0617;
            case 123: goto L_0x0617;
            case 124: goto L_0x0617;
            default: goto L_0x0616;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x0617, code lost:
        m = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:399:0x0619, code lost:
        r1 = com.google.android.exoplayer2.g.ae.f32502d;
        r2 = r1.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:400:0x0622, code lost:
        if (r2 == 2006354) goto L_0x0634;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x0627, code lost:
        if (r2 == 2006367) goto L_0x062a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x0630, code lost:
        if (r1.equals("AFTN") == false) goto L_0x063d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:406:0x0632, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:408:0x063a, code lost:
        if (r1.equals("AFTA") == false) goto L_0x063d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x063d, code lost:
        r0 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:411:0x063e, code lost:
        if (r0 == 0) goto L_0x0643;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:412:0x0640, code lost:
        if (r0 == 1) goto L_0x0643;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x0643, code lost:
        m = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.lang.String r6) {
        /*
            java.lang.String r0 = "OMX.google"
            boolean r6 = r6.startsWith(r0)
            r0 = 0
            if (r6 == 0) goto L_0x000a
            return r0
        L_0x000a:
            java.lang.Class<com.google.android.exoplayer2.video.d> r6 = com.google.android.exoplayer2.video.d.class
            monitor-enter(r6)
            boolean r1 = l     // Catch:{ all -> 0x064b }
            if (r1 != 0) goto L_0x0647
            int r1 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ all -> 0x064b }
            r2 = 27
            r3 = 1
            if (r1 > r2) goto L_0x0030
            java.lang.String r1 = "dangal"
            java.lang.String r4 = com.google.android.exoplayer2.g.ae.f32500b     // Catch:{ all -> 0x064b }
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x064b }
            if (r1 != 0) goto L_0x002c
            java.lang.String r1 = "HWEML"
            java.lang.String r4 = com.google.android.exoplayer2.g.ae.f32500b     // Catch:{ all -> 0x064b }
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0030
        L_0x002c:
            m = r3     // Catch:{ all -> 0x064b }
            goto L_0x0645
        L_0x0030:
            int r1 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ all -> 0x064b }
            if (r1 >= r2) goto L_0x0645
            java.lang.String r1 = com.google.android.exoplayer2.g.ae.f32500b     // Catch:{ all -> 0x064b }
            int r4 = r1.hashCode()     // Catch:{ all -> 0x064b }
            r5 = -1
            switch(r4) {
                case -2144781245: goto L_0x0607;
                case -2144781185: goto L_0x05fc;
                case -2144781160: goto L_0x05f1;
                case -2097309513: goto L_0x05e6;
                case -2022874474: goto L_0x05db;
                case -1978993182: goto L_0x05d0;
                case -1978990237: goto L_0x05c5;
                case -1936688988: goto L_0x05ba;
                case -1936688066: goto L_0x05af;
                case -1936688065: goto L_0x05a3;
                case -1931988508: goto L_0x0597;
                case -1696512866: goto L_0x058b;
                case -1680025915: goto L_0x057f;
                case -1615810839: goto L_0x0573;
                case -1554255044: goto L_0x0566;
                case -1481772737: goto L_0x055a;
                case -1481772730: goto L_0x054e;
                case -1481772729: goto L_0x0542;
                case -1320080169: goto L_0x0536;
                case -1217592143: goto L_0x052a;
                case -1180384755: goto L_0x051e;
                case -1139198265: goto L_0x0512;
                case -1052835013: goto L_0x0506;
                case -993250464: goto L_0x04fb;
                case -993250458: goto L_0x04f0;
                case -965403638: goto L_0x04e4;
                case -958336948: goto L_0x04d8;
                case -879245230: goto L_0x04cb;
                case -842500323: goto L_0x04bf;
                case -821392978: goto L_0x04b4;
                case -797483286: goto L_0x04a8;
                case -794946968: goto L_0x049b;
                case -788334647: goto L_0x048e;
                case -782144577: goto L_0x0482;
                case -575125681: goto L_0x0476;
                case -521118391: goto L_0x046a;
                case -430914369: goto L_0x045e;
                case -290434366: goto L_0x0451;
                case -282781963: goto L_0x0445;
                case -277133239: goto L_0x0439;
                case -173639913: goto L_0x042d;
                case -56598463: goto L_0x0420;
                case 2126: goto L_0x0414;
                case 2564: goto L_0x0408;
                case 2715: goto L_0x03fc;
                case 2719: goto L_0x03f0;
                case 3483: goto L_0x03e4;
                case 73405: goto L_0x03d8;
                case 75739: goto L_0x03cc;
                case 76779: goto L_0x03c0;
                case 78669: goto L_0x03b4;
                case 79305: goto L_0x03a8;
                case 80618: goto L_0x039c;
                case 88274: goto L_0x0390;
                case 98846: goto L_0x0384;
                case 98848: goto L_0x0378;
                case 99329: goto L_0x036c;
                case 101481: goto L_0x0360;
                case 1513190: goto L_0x0355;
                case 1514184: goto L_0x034a;
                case 1514185: goto L_0x033f;
                case 2436959: goto L_0x0333;
                case 2463773: goto L_0x0327;
                case 2464648: goto L_0x031b;
                case 2689555: goto L_0x030f;
                case 3154429: goto L_0x0303;
                case 3284551: goto L_0x02f7;
                case 3351335: goto L_0x02eb;
                case 3386211: goto L_0x02df;
                case 41325051: goto L_0x02d3;
                case 55178625: goto L_0x02c7;
                case 61542055: goto L_0x02bc;
                case 65355429: goto L_0x02b0;
                case 66214468: goto L_0x02a4;
                case 66214470: goto L_0x0298;
                case 66214473: goto L_0x028c;
                case 66215429: goto L_0x0280;
                case 66215431: goto L_0x0274;
                case 66215433: goto L_0x0268;
                case 66216390: goto L_0x025c;
                case 76402249: goto L_0x0250;
                case 76404105: goto L_0x0244;
                case 76404911: goto L_0x0238;
                case 80963634: goto L_0x022c;
                case 82882791: goto L_0x0220;
                case 98715550: goto L_0x0214;
                case 102844228: goto L_0x0208;
                case 165221241: goto L_0x01fd;
                case 182191441: goto L_0x01f1;
                case 245388979: goto L_0x01e5;
                case 287431619: goto L_0x01d9;
                case 307593612: goto L_0x01cd;
                case 308517133: goto L_0x01c1;
                case 316215098: goto L_0x01b5;
                case 316215116: goto L_0x01a9;
                case 316246811: goto L_0x019d;
                case 316246818: goto L_0x0191;
                case 407160593: goto L_0x0185;
                case 507412548: goto L_0x0179;
                case 793982701: goto L_0x016d;
                case 794038622: goto L_0x0161;
                case 794040393: goto L_0x0155;
                case 835649806: goto L_0x0149;
                case 917340916: goto L_0x013d;
                case 958008161: goto L_0x0131;
                case 1060579533: goto L_0x0125;
                case 1150207623: goto L_0x0119;
                case 1176899427: goto L_0x010d;
                case 1280332038: goto L_0x0101;
                case 1306947716: goto L_0x00f5;
                case 1349174697: goto L_0x00e9;
                case 1522194893: goto L_0x00dc;
                case 1691543273: goto L_0x00d0;
                case 1709443163: goto L_0x00c4;
                case 1865889110: goto L_0x00b8;
                case 1906253259: goto L_0x00ac;
                case 1977196784: goto L_0x00a0;
                case 2006372676: goto L_0x0094;
                case 2029784656: goto L_0x0088;
                case 2030379515: goto L_0x007c;
                case 2033393791: goto L_0x0070;
                case 2047190025: goto L_0x0064;
                case 2047252157: goto L_0x0058;
                case 2048319463: goto L_0x004c;
                case 2048855701: goto L_0x0040;
                default: goto L_0x003e;
            }     // Catch:{ all -> 0x064b }
        L_0x003e:
            goto L_0x0612
        L_0x0040:
            java.lang.String r2 = "HWWAS-H"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 55
            goto L_0x0613
        L_0x004c:
            java.lang.String r2 = "HWVNS-H"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 54
            goto L_0x0613
        L_0x0058:
            java.lang.String r2 = "ELUGA_Prim"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 28
            goto L_0x0613
        L_0x0064:
            java.lang.String r4 = "ELUGA_Note"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 27
            goto L_0x0613
        L_0x0070:
            java.lang.String r2 = "ASUS_X00AD_2"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 12
            goto L_0x0613
        L_0x007c:
            java.lang.String r2 = "HWCAM-H"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 53
            goto L_0x0613
        L_0x0088:
            java.lang.String r2 = "HWBLN-H"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 52
            goto L_0x0613
        L_0x0094:
            java.lang.String r2 = "BRAVIA_ATV3_4K"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 16
            goto L_0x0613
        L_0x00a0:
            java.lang.String r2 = "Infinix-X572"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 58
            goto L_0x0613
        L_0x00ac:
            java.lang.String r2 = "PB2-670M"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 86
            goto L_0x0613
        L_0x00b8:
            java.lang.String r2 = "santoni"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 102(0x66, float:1.43E-43)
            goto L_0x0613
        L_0x00c4:
            java.lang.String r2 = "iball8735_9806"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 57
            goto L_0x0613
        L_0x00d0:
            java.lang.String r2 = "CPH1609"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 20
            goto L_0x0613
        L_0x00dc:
            java.lang.String r2 = "woods_f"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 118(0x76, float:1.65E-43)
            goto L_0x0613
        L_0x00e9:
            java.lang.String r2 = "htc_e56ml_dtul"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 50
            goto L_0x0613
        L_0x00f5:
            java.lang.String r2 = "EverStar_S"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 30
            goto L_0x0613
        L_0x0101:
            java.lang.String r2 = "hwALE-H"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 51
            goto L_0x0613
        L_0x010d:
            java.lang.String r2 = "itel_S41"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 60
            goto L_0x0613
        L_0x0119:
            java.lang.String r2 = "LS-5017"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 66
            goto L_0x0613
        L_0x0125:
            java.lang.String r2 = "panell_d"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 82
            goto L_0x0613
        L_0x0131:
            java.lang.String r2 = "j2xlteins"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 61
            goto L_0x0613
        L_0x013d:
            java.lang.String r2 = "A7000plus"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 8
            goto L_0x0613
        L_0x0149:
            java.lang.String r2 = "manning"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 68
            goto L_0x0613
        L_0x0155:
            java.lang.String r2 = "GIONEE_WBL7519"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 48
            goto L_0x0613
        L_0x0161:
            java.lang.String r2 = "GIONEE_WBL7365"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 47
            goto L_0x0613
        L_0x016d:
            java.lang.String r2 = "GIONEE_WBL5708"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 46
            goto L_0x0613
        L_0x0179:
            java.lang.String r2 = "QM16XE_U"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 100
            goto L_0x0613
        L_0x0185:
            java.lang.String r2 = "Pixi5-10_4G"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 92
            goto L_0x0613
        L_0x0191:
            java.lang.String r2 = "TB3-850M"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 110(0x6e, float:1.54E-43)
            goto L_0x0613
        L_0x019d:
            java.lang.String r2 = "TB3-850F"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 109(0x6d, float:1.53E-43)
            goto L_0x0613
        L_0x01a9:
            java.lang.String r2 = "TB3-730X"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 108(0x6c, float:1.51E-43)
            goto L_0x0613
        L_0x01b5:
            java.lang.String r2 = "TB3-730F"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 107(0x6b, float:1.5E-43)
            goto L_0x0613
        L_0x01c1:
            java.lang.String r2 = "A7020a48"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 10
            goto L_0x0613
        L_0x01cd:
            java.lang.String r2 = "A7010a48"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 9
            goto L_0x0613
        L_0x01d9:
            java.lang.String r2 = "griffin"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 49
            goto L_0x0613
        L_0x01e5:
            java.lang.String r2 = "marino_f"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 69
            goto L_0x0613
        L_0x01f1:
            java.lang.String r2 = "CPY83_I00"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 21
            goto L_0x0613
        L_0x01fd:
            java.lang.String r2 = "A2016a40"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 6
            goto L_0x0613
        L_0x0208:
            java.lang.String r2 = "le_x6"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 65
            goto L_0x0613
        L_0x0214:
            java.lang.String r2 = "i9031"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 56
            goto L_0x0613
        L_0x0220:
            java.lang.String r2 = "X3_HK"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 120(0x78, float:1.68E-43)
            goto L_0x0613
        L_0x022c:
            java.lang.String r2 = "V23GB"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 113(0x71, float:1.58E-43)
            goto L_0x0613
        L_0x0238:
            java.lang.String r2 = "Q4310"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 98
            goto L_0x0613
        L_0x0244:
            java.lang.String r2 = "Q4260"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 96
            goto L_0x0613
        L_0x0250:
            java.lang.String r2 = "PRO7S"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 94
            goto L_0x0613
        L_0x025c:
            java.lang.String r2 = "F3311"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 37
            goto L_0x0613
        L_0x0268:
            java.lang.String r2 = "F3215"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 36
            goto L_0x0613
        L_0x0274:
            java.lang.String r2 = "F3213"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 35
            goto L_0x0613
        L_0x0280:
            java.lang.String r2 = "F3211"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 34
            goto L_0x0613
        L_0x028c:
            java.lang.String r2 = "F3116"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 33
            goto L_0x0613
        L_0x0298:
            java.lang.String r2 = "F3113"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 32
            goto L_0x0613
        L_0x02a4:
            java.lang.String r2 = "F3111"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 31
            goto L_0x0613
        L_0x02b0:
            java.lang.String r2 = "E5643"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 25
            goto L_0x0613
        L_0x02bc:
            java.lang.String r2 = "A1601"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 5
            goto L_0x0613
        L_0x02c7:
            java.lang.String r2 = "Aura_Note_2"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 13
            goto L_0x0613
        L_0x02d3:
            java.lang.String r2 = "MEIZU_M5"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 70
            goto L_0x0613
        L_0x02df:
            java.lang.String r2 = "p212"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 79
            goto L_0x0613
        L_0x02eb:
            java.lang.String r2 = "mido"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 72
            goto L_0x0613
        L_0x02f7:
            java.lang.String r2 = "kate"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 64
            goto L_0x0613
        L_0x0303:
            java.lang.String r2 = "fugu"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 39
            goto L_0x0613
        L_0x030f:
            java.lang.String r2 = "XE2X"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 121(0x79, float:1.7E-43)
            goto L_0x0613
        L_0x031b:
            java.lang.String r2 = "Q427"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 97
            goto L_0x0613
        L_0x0327:
            java.lang.String r2 = "Q350"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 95
            goto L_0x0613
        L_0x0333:
            java.lang.String r2 = "P681"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 80
            goto L_0x0613
        L_0x033f:
            java.lang.String r2 = "1714"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 2
            goto L_0x0613
        L_0x034a:
            java.lang.String r2 = "1713"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 1
            goto L_0x0613
        L_0x0355:
            java.lang.String r2 = "1601"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 0
            goto L_0x0613
        L_0x0360:
            java.lang.String r2 = "flo"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 38
            goto L_0x0613
        L_0x036c:
            java.lang.String r2 = "deb"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 24
            goto L_0x0613
        L_0x0378:
            java.lang.String r2 = "cv3"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 23
            goto L_0x0613
        L_0x0384:
            java.lang.String r2 = "cv1"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 22
            goto L_0x0613
        L_0x0390:
            java.lang.String r2 = "Z80"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 124(0x7c, float:1.74E-43)
            goto L_0x0613
        L_0x039c:
            java.lang.String r2 = "QX1"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 101(0x65, float:1.42E-43)
            goto L_0x0613
        L_0x03a8:
            java.lang.String r2 = "PLE"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 93
            goto L_0x0613
        L_0x03b4:
            java.lang.String r2 = "P85"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 81
            goto L_0x0613
        L_0x03c0:
            java.lang.String r2 = "MX6"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 73
            goto L_0x0613
        L_0x03cc:
            java.lang.String r2 = "M5c"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 67
            goto L_0x0613
        L_0x03d8:
            java.lang.String r2 = "JGZ"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 62
            goto L_0x0613
        L_0x03e4:
            java.lang.String r2 = "mh"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 71
            goto L_0x0613
        L_0x03f0:
            java.lang.String r2 = "V5"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 114(0x72, float:1.6E-43)
            goto L_0x0613
        L_0x03fc:
            java.lang.String r2 = "V1"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 112(0x70, float:1.57E-43)
            goto L_0x0613
        L_0x0408:
            java.lang.String r2 = "Q5"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 99
            goto L_0x0613
        L_0x0414:
            java.lang.String r2 = "C1"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 17
            goto L_0x0613
        L_0x0420:
            java.lang.String r2 = "woods_fn"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 119(0x77, float:1.67E-43)
            goto L_0x0613
        L_0x042d:
            java.lang.String r2 = "ELUGA_A3_Pro"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 26
            goto L_0x0613
        L_0x0439:
            java.lang.String r2 = "Z12_PRO"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 123(0x7b, float:1.72E-43)
            goto L_0x0613
        L_0x0445:
            java.lang.String r2 = "BLACK-1X"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 14
            goto L_0x0613
        L_0x0451:
            java.lang.String r2 = "taido_row"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 106(0x6a, float:1.49E-43)
            goto L_0x0613
        L_0x045e:
            java.lang.String r2 = "Pixi4-7_3G"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 91
            goto L_0x0613
        L_0x046a:
            java.lang.String r2 = "GIONEE_GBL7360"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 42
            goto L_0x0613
        L_0x0476:
            java.lang.String r2 = "GiONEE_CBL7513"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 40
            goto L_0x0613
        L_0x0482:
            java.lang.String r2 = "OnePlus5T"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 78
            goto L_0x0613
        L_0x048e:
            java.lang.String r2 = "whyred"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 117(0x75, float:1.64E-43)
            goto L_0x0613
        L_0x049b:
            java.lang.String r2 = "watson"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 116(0x74, float:1.63E-43)
            goto L_0x0613
        L_0x04a8:
            java.lang.String r2 = "SVP-DTV15"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 104(0x68, float:1.46E-43)
            goto L_0x0613
        L_0x04b4:
            java.lang.String r2 = "A7000-a"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 7
            goto L_0x0613
        L_0x04bf:
            java.lang.String r2 = "nicklaus_f"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 75
            goto L_0x0613
        L_0x04cb:
            java.lang.String r2 = "tcl_eu"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 111(0x6f, float:1.56E-43)
            goto L_0x0613
        L_0x04d8:
            java.lang.String r2 = "ELUGA_Ray_X"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 29
            goto L_0x0613
        L_0x04e4:
            java.lang.String r2 = "s905x018"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 105(0x69, float:1.47E-43)
            goto L_0x0613
        L_0x04f0:
            java.lang.String r2 = "A10-70L"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 4
            goto L_0x0613
        L_0x04fb:
            java.lang.String r2 = "A10-70F"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 3
            goto L_0x0613
        L_0x0506:
            java.lang.String r2 = "namath"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 74
            goto L_0x0613
        L_0x0512:
            java.lang.String r2 = "Slate_Pro"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 103(0x67, float:1.44E-43)
            goto L_0x0613
        L_0x051e:
            java.lang.String r2 = "iris60"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 59
            goto L_0x0613
        L_0x052a:
            java.lang.String r2 = "BRAVIA_ATV2"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 15
            goto L_0x0613
        L_0x0536:
            java.lang.String r2 = "GiONEE_GBL7319"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 41
            goto L_0x0613
        L_0x0542:
            java.lang.String r2 = "panell_dt"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 85
            goto L_0x0613
        L_0x054e:
            java.lang.String r2 = "panell_ds"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 84
            goto L_0x0613
        L_0x055a:
            java.lang.String r2 = "panell_dl"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 83
            goto L_0x0613
        L_0x0566:
            java.lang.String r2 = "vernee_M5"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 115(0x73, float:1.61E-43)
            goto L_0x0613
        L_0x0573:
            java.lang.String r2 = "Phantom6"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 90
            goto L_0x0613
        L_0x057f:
            java.lang.String r2 = "ComioS1"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 18
            goto L_0x0613
        L_0x058b:
            java.lang.String r2 = "XT1663"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 122(0x7a, float:1.71E-43)
            goto L_0x0613
        L_0x0597:
            java.lang.String r2 = "AquaPowerM"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 11
            goto L_0x0613
        L_0x05a3:
            java.lang.String r2 = "PGN611"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 89
            goto L_0x0613
        L_0x05af:
            java.lang.String r2 = "PGN610"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 88
            goto L_0x0613
        L_0x05ba:
            java.lang.String r2 = "PGN528"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 87
            goto L_0x0613
        L_0x05c5:
            java.lang.String r2 = "NX573J"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 77
            goto L_0x0613
        L_0x05d0:
            java.lang.String r2 = "NX541J"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 76
            goto L_0x0613
        L_0x05db:
            java.lang.String r2 = "CP8676_I02"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 19
            goto L_0x0613
        L_0x05e6:
            java.lang.String r2 = "K50a40"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 63
            goto L_0x0613
        L_0x05f1:
            java.lang.String r2 = "GIONEE_SWW1631"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 45
            goto L_0x0613
        L_0x05fc:
            java.lang.String r2 = "GIONEE_SWW1627"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 44
            goto L_0x0613
        L_0x0607:
            java.lang.String r2 = "GIONEE_SWW1609"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x0612
            r1 = 43
            goto L_0x0613
        L_0x0612:
            r1 = -1
        L_0x0613:
            switch(r1) {
                case 0: goto L_0x0617;
                case 1: goto L_0x0617;
                case 2: goto L_0x0617;
                case 3: goto L_0x0617;
                case 4: goto L_0x0617;
                case 5: goto L_0x0617;
                case 6: goto L_0x0617;
                case 7: goto L_0x0617;
                case 8: goto L_0x0617;
                case 9: goto L_0x0617;
                case 10: goto L_0x0617;
                case 11: goto L_0x0617;
                case 12: goto L_0x0617;
                case 13: goto L_0x0617;
                case 14: goto L_0x0617;
                case 15: goto L_0x0617;
                case 16: goto L_0x0617;
                case 17: goto L_0x0617;
                case 18: goto L_0x0617;
                case 19: goto L_0x0617;
                case 20: goto L_0x0617;
                case 21: goto L_0x0617;
                case 22: goto L_0x0617;
                case 23: goto L_0x0617;
                case 24: goto L_0x0617;
                case 25: goto L_0x0617;
                case 26: goto L_0x0617;
                case 27: goto L_0x0617;
                case 28: goto L_0x0617;
                case 29: goto L_0x0617;
                case 30: goto L_0x0617;
                case 31: goto L_0x0617;
                case 32: goto L_0x0617;
                case 33: goto L_0x0617;
                case 34: goto L_0x0617;
                case 35: goto L_0x0617;
                case 36: goto L_0x0617;
                case 37: goto L_0x0617;
                case 38: goto L_0x0617;
                case 39: goto L_0x0617;
                case 40: goto L_0x0617;
                case 41: goto L_0x0617;
                case 42: goto L_0x0617;
                case 43: goto L_0x0617;
                case 44: goto L_0x0617;
                case 45: goto L_0x0617;
                case 46: goto L_0x0617;
                case 47: goto L_0x0617;
                case 48: goto L_0x0617;
                case 49: goto L_0x0617;
                case 50: goto L_0x0617;
                case 51: goto L_0x0617;
                case 52: goto L_0x0617;
                case 53: goto L_0x0617;
                case 54: goto L_0x0617;
                case 55: goto L_0x0617;
                case 56: goto L_0x0617;
                case 57: goto L_0x0617;
                case 58: goto L_0x0617;
                case 59: goto L_0x0617;
                case 60: goto L_0x0617;
                case 61: goto L_0x0617;
                case 62: goto L_0x0617;
                case 63: goto L_0x0617;
                case 64: goto L_0x0617;
                case 65: goto L_0x0617;
                case 66: goto L_0x0617;
                case 67: goto L_0x0617;
                case 68: goto L_0x0617;
                case 69: goto L_0x0617;
                case 70: goto L_0x0617;
                case 71: goto L_0x0617;
                case 72: goto L_0x0617;
                case 73: goto L_0x0617;
                case 74: goto L_0x0617;
                case 75: goto L_0x0617;
                case 76: goto L_0x0617;
                case 77: goto L_0x0617;
                case 78: goto L_0x0617;
                case 79: goto L_0x0617;
                case 80: goto L_0x0617;
                case 81: goto L_0x0617;
                case 82: goto L_0x0617;
                case 83: goto L_0x0617;
                case 84: goto L_0x0617;
                case 85: goto L_0x0617;
                case 86: goto L_0x0617;
                case 87: goto L_0x0617;
                case 88: goto L_0x0617;
                case 89: goto L_0x0617;
                case 90: goto L_0x0617;
                case 91: goto L_0x0617;
                case 92: goto L_0x0617;
                case 93: goto L_0x0617;
                case 94: goto L_0x0617;
                case 95: goto L_0x0617;
                case 96: goto L_0x0617;
                case 97: goto L_0x0617;
                case 98: goto L_0x0617;
                case 99: goto L_0x0617;
                case 100: goto L_0x0617;
                case 101: goto L_0x0617;
                case 102: goto L_0x0617;
                case 103: goto L_0x0617;
                case 104: goto L_0x0617;
                case 105: goto L_0x0617;
                case 106: goto L_0x0617;
                case 107: goto L_0x0617;
                case 108: goto L_0x0617;
                case 109: goto L_0x0617;
                case 110: goto L_0x0617;
                case 111: goto L_0x0617;
                case 112: goto L_0x0617;
                case 113: goto L_0x0617;
                case 114: goto L_0x0617;
                case 115: goto L_0x0617;
                case 116: goto L_0x0617;
                case 117: goto L_0x0617;
                case 118: goto L_0x0617;
                case 119: goto L_0x0617;
                case 120: goto L_0x0617;
                case 121: goto L_0x0617;
                case 122: goto L_0x0617;
                case 123: goto L_0x0617;
                case 124: goto L_0x0617;
                default: goto L_0x0616;
            }     // Catch:{ all -> 0x064b }
        L_0x0616:
            goto L_0x0619
        L_0x0617:
            m = r3     // Catch:{ all -> 0x064b }
        L_0x0619:
            java.lang.String r1 = com.google.android.exoplayer2.g.ae.f32502d     // Catch:{ all -> 0x064b }
            int r2 = r1.hashCode()     // Catch:{ all -> 0x064b }
            r4 = 2006354(0x1e9d52, float:2.811501E-39)
            if (r2 == r4) goto L_0x0634
            r0 = 2006367(0x1e9d5f, float:2.811519E-39)
            if (r2 == r0) goto L_0x062a
            goto L_0x063d
        L_0x062a:
            java.lang.String r0 = "AFTN"
            boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x064b }
            if (r0 == 0) goto L_0x063d
            r0 = 1
            goto L_0x063e
        L_0x0634:
            java.lang.String r2 = "AFTA"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x064b }
            if (r1 == 0) goto L_0x063d
            goto L_0x063e
        L_0x063d:
            r0 = -1
        L_0x063e:
            if (r0 == 0) goto L_0x0643
            if (r0 == r3) goto L_0x0643
            goto L_0x0645
        L_0x0643:
            m = r3     // Catch:{ all -> 0x064b }
        L_0x0645:
            l = r3     // Catch:{ all -> 0x064b }
        L_0x0647:
            monitor-exit(r6)     // Catch:{ all -> 0x064b }
            boolean r6 = m
            return r6
        L_0x064b:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x064b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.d.a(java.lang.String):boolean");
    }

    protected static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f33694a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33695b;

        /* renamed from: c  reason: collision with root package name */
        public final int f33696c;

        public a(int i2, int i3, int i4) {
            this.f33694a = i2;
            this.f33695b = i3;
            this.f33696c = i4;
        }
    }

    final class b implements MediaCodec.OnFrameRenderedListener {
        /* synthetic */ b(d dVar, MediaCodec mediaCodec, byte b2) {
            this(mediaCodec);
        }

        private b(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            if (this == d.this.j) {
                d.this.e(j);
            }
        }
    }
}
