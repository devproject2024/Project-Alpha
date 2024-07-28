package com.google.android.exoplayer2.b;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.g.ae;
import java.lang.reflect.Method;

final class k {

    /* renamed from: a  reason: collision with root package name */
    final a f31201a;

    /* renamed from: b  reason: collision with root package name */
    AudioTrack f31202b;

    /* renamed from: c  reason: collision with root package name */
    int f31203c;

    /* renamed from: d  reason: collision with root package name */
    int f31204d;

    /* renamed from: e  reason: collision with root package name */
    j f31205e;

    /* renamed from: f  reason: collision with root package name */
    int f31206f;

    /* renamed from: g  reason: collision with root package name */
    boolean f31207g;

    /* renamed from: h  reason: collision with root package name */
    long f31208h;

    /* renamed from: i  reason: collision with root package name */
    long f31209i;
    boolean j;
    boolean k;
    long l;
    long m;
    long n;
    long o;
    long p;
    private final long[] q;
    private long r;
    private long s;
    private Method t;
    private long u;
    private int v;
    private int w;
    private long x;
    private long y;

    public interface a {
        void a(int i2, long j);

        void a(long j);

        void a(long j, long j2, long j3, long j4);

        void b(long j, long j2, long j3, long j4);
    }

    public k(a aVar) {
        this.f31201a = (a) com.google.android.exoplayer2.g.a.a(aVar);
        if (ae.f32499a >= 18) {
            try {
                this.t = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.q = new long[10];
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x018f A[Catch:{ Exception -> 0x0199 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(boolean r24) {
        /*
            r23 = this;
            r0 = r23
            android.media.AudioTrack r1 = r0.f31202b
            java.lang.Object r1 = com.google.android.exoplayer2.g.a.a(r1)
            android.media.AudioTrack r1 = (android.media.AudioTrack) r1
            int r1 = r1.getPlayState()
            r2 = 1000(0x3e8, double:4.94E-321)
            r4 = 3
            r5 = 2
            r6 = 0
            r7 = 1
            if (r1 != r4) goto L_0x019e
            long r15 = r23.e()
            r13 = 0
            int r1 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r1 == 0) goto L_0x019e
            long r8 = java.lang.System.nanoTime()
            long r11 = r8 / r2
            long r8 = r0.s
            long r8 = r11 - r8
            r17 = 30000(0x7530, double:1.4822E-319)
            int r1 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r1 < 0) goto L_0x0060
            long[] r1 = r0.q
            int r8 = r0.v
            long r9 = r15 - r11
            r1[r8] = r9
            int r8 = r8 + r7
            r1 = 10
            int r8 = r8 % r1
            r0.v = r8
            int r8 = r0.w
            if (r8 >= r1) goto L_0x0045
            int r8 = r8 + r7
            r0.w = r8
        L_0x0045:
            r0.s = r11
            r0.r = r13
            r1 = 0
        L_0x004a:
            int r8 = r0.w
            if (r1 >= r8) goto L_0x0060
            long r9 = r0.r
            long[] r13 = r0.q
            r19 = r13[r1]
            long r13 = (long) r8
            long r19 = r19 / r13
            long r9 = r9 + r19
            r0.r = r9
            int r1 = r1 + 1
            r13 = 0
            goto L_0x004a
        L_0x0060:
            boolean r1 = r0.f31207g
            if (r1 != 0) goto L_0x019e
            com.google.android.exoplayer2.b.j r1 = r0.f31205e
            java.lang.Object r1 = com.google.android.exoplayer2.g.a.a(r1)
            com.google.android.exoplayer2.b.j r1 = (com.google.android.exoplayer2.b.j) r1
            com.google.android.exoplayer2.b.j$a r8 = r1.f31190a
            r19 = 500000(0x7a120, double:2.47033E-318)
            if (r8 == 0) goto L_0x0104
            long r8 = r1.f31194e
            long r8 = r11 - r8
            long r2 = r1.f31193d
            int r10 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r10 >= 0) goto L_0x007f
            goto L_0x0104
        L_0x007f:
            r1.f31194e = r11
            com.google.android.exoplayer2.b.j$a r2 = r1.f31190a
            android.media.AudioTrack r3 = r2.f31196a
            android.media.AudioTimestamp r8 = r2.f31197b
            boolean r3 = r3.getTimestamp(r8)
            if (r3 == 0) goto L_0x00a9
            android.media.AudioTimestamp r8 = r2.f31197b
            long r8 = r8.framePosition
            long r13 = r2.f31199d
            int r10 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x009f
            long r13 = r2.f31198c
            r21 = 1
            long r13 = r13 + r21
            r2.f31198c = r13
        L_0x009f:
            r2.f31199d = r8
            long r13 = r2.f31198c
            r10 = 32
            long r13 = r13 << r10
            long r8 = r8 + r13
            r2.f31200e = r8
        L_0x00a9:
            int r2 = r1.f31191b
            if (r2 == 0) goto L_0x00e0
            if (r2 == r7) goto L_0x00cb
            if (r2 == r5) goto L_0x00c4
            if (r2 == r4) goto L_0x00bd
            r13 = 4
            if (r2 != r13) goto L_0x00b7
            goto L_0x0105
        L_0x00b7:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x00bd:
            r13 = 4
            if (r3 == 0) goto L_0x0105
            r1.a()
            goto L_0x0105
        L_0x00c4:
            r13 = 4
            if (r3 != 0) goto L_0x0105
            r1.a()
            goto L_0x0105
        L_0x00cb:
            r13 = 4
            if (r3 == 0) goto L_0x00dc
            com.google.android.exoplayer2.b.j$a r2 = r1.f31190a
            long r8 = r2.f31200e
            long r13 = r1.f31195f
            int r2 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r2 <= 0) goto L_0x0105
            r1.a(r5)
            goto L_0x0105
        L_0x00dc:
            r1.a()
            goto L_0x0105
        L_0x00e0:
            if (r3 == 0) goto L_0x00f8
            com.google.android.exoplayer2.b.j$a r2 = r1.f31190a
            long r8 = r2.a()
            long r13 = r1.f31192c
            int r2 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x0104
            com.google.android.exoplayer2.b.j$a r2 = r1.f31190a
            long r8 = r2.f31200e
            r1.f31195f = r8
            r1.a(r7)
            goto L_0x0105
        L_0x00f8:
            long r8 = r1.f31192c
            long r8 = r11 - r8
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 <= 0) goto L_0x0105
            r1.a(r4)
            goto L_0x0105
        L_0x0104:
            r3 = 0
        L_0x0105:
            r21 = 5000000(0x4c4b40, double:2.470328E-317)
            if (r3 == 0) goto L_0x014c
            long r2 = r1.b()
            long r9 = r1.c()
            long r13 = r2 - r11
            long r13 = java.lang.Math.abs(r13)
            int r4 = (r13 > r21 ? 1 : (r13 == r21 ? 0 : -1))
            if (r4 <= 0) goto L_0x0129
            com.google.android.exoplayer2.b.k$a r8 = r0.f31201a
            r13 = r11
            r11 = r2
            r2 = r13
            r4 = 4
            r8.b(r9, r11, r13, r15)
            r1.a(r4)
            goto L_0x014d
        L_0x0129:
            r13 = r11
            r4 = 4
            long r11 = r0.d(r9)
            long r11 = r11 - r15
            long r11 = java.lang.Math.abs(r11)
            int r8 = (r11 > r21 ? 1 : (r11 == r21 ? 0 : -1))
            if (r8 <= 0) goto L_0x0143
            com.google.android.exoplayer2.b.k$a r8 = r0.f31201a
            r11 = r2
            r2 = r13
            r8.a(r9, r11, r13, r15)
            r1.a(r4)
            goto L_0x014d
        L_0x0143:
            r2 = r13
            int r8 = r1.f31191b
            if (r8 != r4) goto L_0x014d
            r1.a()
            goto L_0x014d
        L_0x014c:
            r2 = r11
        L_0x014d:
            boolean r1 = r0.k
            if (r1 == 0) goto L_0x019e
            java.lang.reflect.Method r1 = r0.t
            if (r1 == 0) goto L_0x019e
            long r8 = r0.u
            long r11 = r2 - r8
            int r4 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r4 < 0) goto L_0x019e
            android.media.AudioTrack r4 = r0.f31202b     // Catch:{ Exception -> 0x0199 }
            java.lang.Object r4 = com.google.android.exoplayer2.g.a.a(r4)     // Catch:{ Exception -> 0x0199 }
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0199 }
            java.lang.Object r1 = r1.invoke(r4, r8)     // Catch:{ Exception -> 0x0199 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0199 }
            java.lang.Object r1 = com.google.android.exoplayer2.g.ae.a(r1)     // Catch:{ Exception -> 0x0199 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0199 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0199 }
            long r8 = (long) r1     // Catch:{ Exception -> 0x0199 }
            r10 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 * r10
            long r10 = r0.f31208h     // Catch:{ Exception -> 0x0199 }
            long r8 = r8 - r10
            r0.f31209i = r8     // Catch:{ Exception -> 0x0199 }
            long r8 = r0.f31209i     // Catch:{ Exception -> 0x0199 }
            r10 = 0
            long r8 = java.lang.Math.max(r8, r10)     // Catch:{ Exception -> 0x0199 }
            r0.f31209i = r8     // Catch:{ Exception -> 0x0199 }
            long r8 = r0.f31209i     // Catch:{ Exception -> 0x0199 }
            int r1 = (r8 > r21 ? 1 : (r8 == r21 ? 0 : -1))
            if (r1 <= 0) goto L_0x019c
            com.google.android.exoplayer2.b.k$a r1 = r0.f31201a     // Catch:{ Exception -> 0x0199 }
            long r8 = r0.f31209i     // Catch:{ Exception -> 0x0199 }
            r1.a(r8)     // Catch:{ Exception -> 0x0199 }
            r0.f31209i = r10     // Catch:{ Exception -> 0x0199 }
            goto L_0x019c
        L_0x0199:
            r1 = 0
            r0.t = r1
        L_0x019c:
            r0.u = r2
        L_0x019e:
            long r1 = java.lang.System.nanoTime()
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            com.google.android.exoplayer2.b.j r3 = r0.f31205e
            java.lang.Object r3 = com.google.android.exoplayer2.g.a.a(r3)
            com.google.android.exoplayer2.b.j r3 = (com.google.android.exoplayer2.b.j) r3
            int r4 = r3.f31191b
            if (r4 == r7) goto L_0x01b8
            int r4 = r3.f31191b
            if (r4 != r5) goto L_0x01b6
            goto L_0x01b8
        L_0x01b6:
            r4 = 0
            goto L_0x01b9
        L_0x01b8:
            r4 = 1
        L_0x01b9:
            if (r4 == 0) goto L_0x01d2
            long r8 = r3.c()
            long r8 = r0.d(r8)
            int r4 = r3.f31191b
            if (r4 != r5) goto L_0x01c8
            r6 = 1
        L_0x01c8:
            if (r6 != 0) goto L_0x01cb
            return r8
        L_0x01cb:
            long r3 = r3.b()
            long r1 = r1 - r3
            long r8 = r8 + r1
            return r8
        L_0x01d2:
            int r3 = r0.w
            if (r3 != 0) goto L_0x01db
            long r1 = r23.e()
            goto L_0x01de
        L_0x01db:
            long r3 = r0.r
            long r1 = r1 + r3
        L_0x01de:
            if (r24 != 0) goto L_0x01e3
            long r3 = r0.f31209i
            long r1 = r1 - r3
        L_0x01e3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.b.k.a(boolean):long");
    }

    public final boolean a() {
        return ((AudioTrack) com.google.android.exoplayer2.g.a.a(this.f31202b)).getPlayState() == 3;
    }

    public final int a(long j2) {
        return this.f31204d - ((int) (j2 - (d() * ((long) this.f31203c))));
    }

    public final void b(long j2) {
        this.x = d();
        this.o = SystemClock.elapsedRealtime() * 1000;
        this.y = j2;
    }

    public final boolean c(long j2) {
        if (j2 <= d()) {
            return this.f31207g && ((AudioTrack) com.google.android.exoplayer2.g.a.a(this.f31202b)).getPlayState() == 2 && (d() > 0 ? 1 : (d() == 0 ? 0 : -1)) == 0;
        }
    }

    public final void b() {
        c();
        this.f31202b = null;
        this.f31205e = null;
    }

    /* access modifiers changed from: package-private */
    public final long d(long j2) {
        return (j2 * 1000000) / ((long) this.f31206f);
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.r = 0;
        this.w = 0;
        this.v = 0;
        this.s = 0;
    }

    private long e() {
        return d(d());
    }

    /* access modifiers changed from: package-private */
    public final long d() {
        AudioTrack audioTrack = (AudioTrack) com.google.android.exoplayer2.g.a.a(this.f31202b);
        if (this.o != -9223372036854775807L) {
            return Math.min(this.y, this.x + ((((SystemClock.elapsedRealtime() * 1000) - this.o) * ((long) this.f31206f)) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = 4294967295L & ((long) audioTrack.getPlaybackHeadPosition());
        if (this.f31207g) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.n = this.l;
            }
            playbackHeadPosition += this.n;
        }
        if (ae.f32499a <= 29) {
            if (playbackHeadPosition == 0 && this.l > 0 && playState == 3) {
                if (this.p == -9223372036854775807L) {
                    this.p = SystemClock.elapsedRealtime();
                }
                return this.l;
            }
            this.p = -9223372036854775807L;
        }
        if (this.l > playbackHeadPosition) {
            this.m++;
        }
        this.l = playbackHeadPosition;
        return playbackHeadPosition + (this.m << 32);
    }
}
