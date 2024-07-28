package com.google.android.exoplayer2.b;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.google.android.exoplayer2.b.i;
import com.google.android.exoplayer2.b.k;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public final class o implements i {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f31221a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f31222b = false;
    private long A;
    private long B;
    private int C;
    private int D;
    private long E;
    private float F;
    private g[] G;
    private ByteBuffer[] H;
    private ByteBuffer I;
    private ByteBuffer J;
    private byte[] K;
    private int L;
    private int M;
    private boolean N;
    private boolean O;
    private boolean P;
    private int Q;
    private l R;
    private boolean S;
    /* access modifiers changed from: private */
    public long T;

    /* renamed from: c  reason: collision with root package name */
    private final d f31223c;

    /* renamed from: d  reason: collision with root package name */
    private final a f31224d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f31225e;

    /* renamed from: f  reason: collision with root package name */
    private final n f31226f;

    /* renamed from: g  reason: collision with root package name */
    private final w f31227g;

    /* renamed from: h  reason: collision with root package name */
    private final g[] f31228h;

    /* renamed from: i  reason: collision with root package name */
    private final g[] f31229i;
    /* access modifiers changed from: private */
    public final ConditionVariable j;
    private final k k;
    private final ArrayDeque<e> l;
    /* access modifiers changed from: private */
    public i.c m;
    private AudioTrack n;
    private b o;
    private b p;
    private AudioTrack q;
    private c r;
    private x s;
    private x t;
    private long u;
    private long v;
    private ByteBuffer w;
    private int x;
    private long y;
    private long z;

    public interface a {
        long a(long j);

        x a(x xVar);

        g[] a();

        long b();
    }

    public static final class d extends RuntimeException {
        private d(String str) {
            super(str);
        }
    }

    public static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        private final g[] f31243a;

        /* renamed from: b  reason: collision with root package name */
        private final t f31244b = new t();

        /* renamed from: c  reason: collision with root package name */
        private final v f31245c = new v();

        public c(g... gVarArr) {
            this.f31243a = new g[(gVarArr.length + 2)];
            System.arraycopy(gVarArr, 0, this.f31243a, 0, gVarArr.length);
            g[] gVarArr2 = this.f31243a;
            gVarArr2[gVarArr.length] = this.f31244b;
            gVarArr2[gVarArr.length + 1] = this.f31245c;
        }

        public final g[] a() {
            return this.f31243a;
        }

        public final x a(x xVar) {
            t tVar = this.f31244b;
            tVar.f31255f = xVar.f33729d;
            tVar.h();
            v vVar = this.f31245c;
            float a2 = ae.a(xVar.f33727b, 0.1f, 8.0f);
            if (vVar.f31269c != a2) {
                vVar.f31269c = a2;
                vVar.f31272f = true;
            }
            vVar.h();
            v vVar2 = this.f31245c;
            float a3 = ae.a(xVar.f33728c, 0.1f, 8.0f);
            if (vVar2.f31270d != a3) {
                vVar2.f31270d = a3;
                vVar2.f31272f = true;
            }
            vVar2.h();
            return new x(a2, a3, xVar.f33729d);
        }

        public final long a(long j) {
            v vVar = this.f31245c;
            if (vVar.f31274h < 1024) {
                return (long) (((double) vVar.f31269c) * ((double) j));
            }
            if (vVar.f31271e == vVar.f31268b) {
                return ae.b(j, vVar.f31273g, vVar.f31274h);
            }
            return ae.b(j, vVar.f31273g * ((long) vVar.f31271e), vVar.f31274h * ((long) vVar.f31268b));
        }

        public final long b() {
            return this.f31244b.f31256g;
        }
    }

    public o(d dVar, g[] gVarArr) {
        this(dVar, gVarArr, (byte) 0);
    }

    private o(d dVar, g[] gVarArr, byte b2) {
        this(dVar, (a) new c(gVarArr));
    }

    private o(d dVar, a aVar) {
        this.f31223c = dVar;
        this.f31224d = (a) com.google.android.exoplayer2.g.a.a(aVar);
        this.f31225e = false;
        this.j = new ConditionVariable(true);
        this.k = new k(new f(this, (byte) 0));
        this.f31226f = new n();
        this.f31227g = new w();
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new m[]{new s(), this.f31226f, this.f31227g});
        Collections.addAll(arrayList, aVar.a());
        this.f31228h = (g[]) arrayList.toArray(new g[0]);
        this.f31229i = new g[]{new q()};
        this.F = 1.0f;
        this.D = 0;
        this.r = c.f31165a;
        this.Q = 0;
        this.R = new l();
        this.t = x.f33726a;
        this.M = -1;
        this.G = new g[0];
        this.H = new ByteBuffer[0];
        this.l = new ArrayDeque<>();
    }

    public final void a(i.c cVar) {
        this.m = cVar;
    }

    public final boolean a(int i2, int i3) {
        if (ae.c(i3)) {
            return i3 != 4 || ae.f32499a >= 21;
        }
        d dVar = this.f31223c;
        if (dVar != null) {
            return (Arrays.binarySearch(dVar.f31175b, i3) >= 0) && (i2 == -1 || i2 <= this.f31223c.f31176c);
        }
    }

    public final long a(boolean z2) {
        long j2;
        long j3;
        long j4;
        if (!p() || this.D == 0) {
            return Long.MIN_VALUE;
        }
        long min = Math.min(this.k.a(z2), this.p.a(r()));
        long j5 = this.E;
        e eVar = null;
        while (!this.l.isEmpty() && min >= this.l.getFirst().f31248c) {
            eVar = this.l.remove();
        }
        if (eVar != null) {
            this.t = eVar.f31246a;
            this.v = eVar.f31248c;
            this.u = eVar.f31247b - this.E;
        }
        if (this.t.f33727b == 1.0f) {
            j2 = (min + this.u) - this.v;
        } else {
            if (this.l.isEmpty()) {
                j3 = this.u;
                j4 = this.f31224d.a(min - this.v);
            } else {
                j3 = this.u;
                j4 = ae.a(min - this.v, this.t.f33727b);
            }
            j2 = j4 + j3;
        }
        return j5 + j2 + this.p.a(this.f31224d.b());
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r21, int r22, int r23, int[] r24, int r25, int r26) throws com.google.android.exoplayer2.b.i.a {
        /*
            r20 = this;
            r1 = r20
            r0 = r22
            int r2 = com.google.android.exoplayer2.g.ae.f32499a
            r3 = 8
            r4 = 6
            r6 = 21
            if (r2 >= r6) goto L_0x001b
            if (r0 != r3) goto L_0x001b
            if (r24 != 0) goto L_0x001b
            int[] r2 = new int[r4]
            r6 = 0
        L_0x0014:
            if (r6 >= r4) goto L_0x001d
            r2[r6] = r6
            int r6 = r6 + 1
            goto L_0x0014
        L_0x001b:
            r2 = r24
        L_0x001d:
            boolean r7 = com.google.android.exoplayer2.g.ae.c((int) r21)
            r6 = 4
            r15 = 1
            r8 = r21
            if (r7 == 0) goto L_0x002b
            if (r8 == r6) goto L_0x002b
            r14 = 1
            goto L_0x002c
        L_0x002b:
            r14 = 0
        L_0x002c:
            boolean r9 = r1.f31225e
            if (r9 == 0) goto L_0x003e
            boolean r9 = r1.a((int) r0, (int) r6)
            if (r9 == 0) goto L_0x003e
            boolean r9 = com.google.android.exoplayer2.g.ae.d((int) r21)
            if (r9 == 0) goto L_0x003e
            r9 = 1
            goto L_0x003f
        L_0x003e:
            r9 = 0
        L_0x003f:
            if (r9 == 0) goto L_0x0044
            com.google.android.exoplayer2.b.g[] r10 = r1.f31229i
            goto L_0x0046
        L_0x0044:
            com.google.android.exoplayer2.b.g[] r10 = r1.f31228h
        L_0x0046:
            r13 = r10
            if (r14 == 0) goto L_0x008c
            com.google.android.exoplayer2.b.w r10 = r1.f31227g
            r11 = r25
            r10.f31276f = r11
            r11 = r26
            r10.f31277g = r11
            com.google.android.exoplayer2.b.n r10 = r1.f31226f
            r10.f31218f = r2
            int r2 = r13.length
            r3 = r23
            r11 = r0
            r4 = r8
            r10 = 0
            r12 = 0
        L_0x005e:
            if (r10 >= r2) goto L_0x0085
            r5 = r13[r10]
            boolean r18 = r5.a(r3, r11, r4)     // Catch:{ a -> 0x007d }
            r12 = r12 | r18
            boolean r18 = r5.a()
            if (r18 == 0) goto L_0x007a
            int r11 = r5.b()
            int r3 = r5.d()
            int r4 = r5.c()
        L_0x007a:
            int r10 = r10 + 1
            goto L_0x005e
        L_0x007d:
            r0 = move-exception
            r2 = r0
            com.google.android.exoplayer2.b.i$a r0 = new com.google.android.exoplayer2.b.i$a
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0085:
            r2 = r12
            r19 = r11
            r11 = r3
            r3 = r19
            goto L_0x0091
        L_0x008c:
            r11 = r23
            r3 = r0
            r4 = r8
            r2 = 0
        L_0x0091:
            int r5 = com.google.android.exoplayer2.g.ae.f32499a
            r10 = 28
            if (r5 > r10) goto L_0x00a9
            if (r7 != 0) goto L_0x00a9
            r5 = 7
            if (r3 != r5) goto L_0x009f
            r5 = 8
            goto L_0x00aa
        L_0x009f:
            r5 = 3
            if (r3 == r5) goto L_0x00a7
            if (r3 == r6) goto L_0x00a7
            r5 = 5
            if (r3 != r5) goto L_0x00a9
        L_0x00a7:
            r5 = 6
            goto L_0x00aa
        L_0x00a9:
            r5 = r3
        L_0x00aa:
            int r6 = com.google.android.exoplayer2.g.ae.f32499a
            r10 = 26
            if (r6 > r10) goto L_0x00bf
            java.lang.String r6 = com.google.android.exoplayer2.g.ae.f32500b
            java.lang.String r10 = "fugu"
            boolean r6 = r10.equals(r6)
            if (r6 == 0) goto L_0x00bf
            if (r7 != 0) goto L_0x00bf
            if (r5 != r15) goto L_0x00bf
            r5 = 2
        L_0x00bf:
            int r12 = com.google.android.exoplayer2.g.ae.e((int) r5)
            if (r12 == 0) goto L_0x010f
            r5 = -1
            if (r7 == 0) goto L_0x00ce
            int r0 = com.google.android.exoplayer2.g.ae.b((int) r21, (int) r22)
            r8 = r0
            goto L_0x00cf
        L_0x00ce:
            r8 = -1
        L_0x00cf:
            if (r7 == 0) goto L_0x00d7
            int r0 = com.google.android.exoplayer2.g.ae.b((int) r4, (int) r3)
            r10 = r0
            goto L_0x00d8
        L_0x00d7:
            r10 = -1
        L_0x00d8:
            if (r14 == 0) goto L_0x00de
            if (r9 != 0) goto L_0x00de
            r0 = 1
            goto L_0x00df
        L_0x00de:
            r0 = 0
        L_0x00df:
            com.google.android.exoplayer2.b.o$b r3 = new com.google.android.exoplayer2.b.o$b
            r6 = r3
            r9 = r23
            r5 = r13
            r13 = r4
            r4 = 1
            r15 = r0
            r16 = r5
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            if (r2 != 0) goto L_0x00f7
            com.google.android.exoplayer2.b.o$b r0 = r1.o
            if (r0 == 0) goto L_0x00f4
            goto L_0x00f7
        L_0x00f4:
            r17 = 0
            goto L_0x00f9
        L_0x00f7:
            r17 = 1
        L_0x00f9:
            boolean r0 = r20.p()
            if (r0 == 0) goto L_0x010c
            com.google.android.exoplayer2.b.o$b r0 = r1.p
            boolean r0 = r3.a((com.google.android.exoplayer2.b.o.b) r0)
            if (r0 == 0) goto L_0x0109
            if (r17 == 0) goto L_0x010c
        L_0x0109:
            r1.o = r3
            return
        L_0x010c:
            r1.p = r3
            return
        L_0x010f:
            com.google.android.exoplayer2.b.i$a r0 = new com.google.android.exoplayer2.b.i$a
            java.lang.String r2 = java.lang.String.valueOf(r3)
            java.lang.String r3 = "Unsupported channel count: "
            java.lang.String r2 = r3.concat(r2)
            r0.<init>((java.lang.String) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.b.o.a(int, int, int, int[], int, int):void");
    }

    private void k() {
        g[] gVarArr = this.p.k;
        ArrayList arrayList = new ArrayList();
        for (g gVar : gVarArr) {
            if (gVar.a()) {
                arrayList.add(gVar);
            } else {
                gVar.h();
            }
        }
        int size = arrayList.size();
        this.G = (g[]) arrayList.toArray(new g[size]);
        this.H = new ByteBuffer[size];
        l();
    }

    private void l() {
        int i2 = 0;
        while (true) {
            g[] gVarArr = this.G;
            if (i2 < gVarArr.length) {
                g gVar = gVarArr[i2];
                gVar.h();
                this.H[i2] = gVar.f();
                i2++;
            } else {
                return;
            }
        }
    }

    public final void a() {
        this.P = true;
        if (p()) {
            ((j) com.google.android.exoplayer2.g.a.a(this.k.f31205e)).a();
            this.q.play();
        }
    }

    public final void b() {
        if (this.D == 1) {
            this.D = 2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0155, code lost:
        if (r4.d() == 0) goto L_0x014a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x017d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x017e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.nio.ByteBuffer r25, long r26) throws com.google.android.exoplayer2.b.i.b, com.google.android.exoplayer2.b.i.d {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            java.nio.ByteBuffer r4 = r0.I
            r5 = 0
            if (r4 == 0) goto L_0x0010
            if (r1 != r4) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r4 = 0
            goto L_0x0011
        L_0x0010:
            r4 = 1
        L_0x0011:
            com.google.android.exoplayer2.g.a.a((boolean) r4)
            com.google.android.exoplayer2.b.o$b r4 = r0.o
            r7 = 0
            if (r4 == 0) goto L_0x0043
            boolean r4 = r24.m()
            if (r4 != 0) goto L_0x0020
            return r5
        L_0x0020:
            com.google.android.exoplayer2.b.o$b r4 = r0.o
            com.google.android.exoplayer2.b.o$b r8 = r0.p
            boolean r4 = r4.a((com.google.android.exoplayer2.b.o.b) r8)
            if (r4 != 0) goto L_0x0038
            r24.s()
            boolean r4 = r24.e()
            if (r4 == 0) goto L_0x0034
            return r5
        L_0x0034:
            r24.i()
            goto L_0x003e
        L_0x0038:
            com.google.android.exoplayer2.b.o$b r4 = r0.o
            r0.p = r4
            r0.o = r7
        L_0x003e:
            com.google.android.exoplayer2.x r4 = r0.t
            r0.a((com.google.android.exoplayer2.x) r4, (long) r2)
        L_0x0043:
            boolean r4 = r24.p()
            r8 = 6
            r9 = 5
            r12 = 0
            if (r4 != 0) goto L_0x012f
            android.os.ConditionVariable r4 = r0.j
            r4.block()
            com.google.android.exoplayer2.b.o$b r4 = r0.p
            java.lang.Object r4 = com.google.android.exoplayer2.g.a.a(r4)
            com.google.android.exoplayer2.b.o$b r4 = (com.google.android.exoplayer2.b.o.b) r4
            boolean r14 = r0.S
            com.google.android.exoplayer2.b.c r15 = r0.r
            int r7 = r0.Q
            android.media.AudioTrack r4 = r4.a(r14, r15, r7)
            r0.q = r4
            android.media.AudioTrack r4 = r0.q
            int r4 = r4.getAudioSessionId()
            boolean r7 = f31221a
            if (r7 == 0) goto L_0x009e
            int r7 = com.google.android.exoplayer2.g.ae.f32499a
            r14 = 21
            if (r7 >= r14) goto L_0x009e
            android.media.AudioTrack r7 = r0.n
            if (r7 == 0) goto L_0x0083
            int r7 = r7.getAudioSessionId()
            if (r4 == r7) goto L_0x0083
            r24.o()
        L_0x0083:
            android.media.AudioTrack r7 = r0.n
            if (r7 != 0) goto L_0x009e
            android.media.AudioTrack r7 = new android.media.AudioTrack
            r17 = 3
            r18 = 4000(0xfa0, float:5.605E-42)
            r19 = 4
            r20 = 2
            r21 = 2
            r22 = 0
            r16 = r7
            r23 = r4
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)
            r0.n = r7
        L_0x009e:
            int r7 = r0.Q
            if (r7 == r4) goto L_0x00ab
            r0.Q = r4
            com.google.android.exoplayer2.b.i$c r7 = r0.m
            if (r7 == 0) goto L_0x00ab
            r7.a(r4)
        L_0x00ab:
            com.google.android.exoplayer2.x r4 = r0.t
            r0.a((com.google.android.exoplayer2.x) r4, (long) r2)
            com.google.android.exoplayer2.b.k r4 = r0.k
            android.media.AudioTrack r7 = r0.q
            com.google.android.exoplayer2.b.o$b r14 = r0.p
            int r14 = r14.f31240g
            com.google.android.exoplayer2.b.o$b r15 = r0.p
            int r15 = r15.f31237d
            com.google.android.exoplayer2.b.o$b r6 = r0.p
            int r6 = r6.f31241h
            r4.f31202b = r7
            r4.f31203c = r15
            r4.f31204d = r6
            com.google.android.exoplayer2.b.j r10 = new com.google.android.exoplayer2.b.j
            r10.<init>(r7)
            r4.f31205e = r10
            int r7 = r7.getSampleRate()
            r4.f31206f = r7
            int r7 = com.google.android.exoplayer2.g.ae.f32499a
            r10 = 23
            if (r7 >= r10) goto L_0x00df
            if (r14 == r9) goto L_0x00dd
            if (r14 != r8) goto L_0x00df
        L_0x00dd:
            r7 = 1
            goto L_0x00e0
        L_0x00df:
            r7 = 0
        L_0x00e0:
            r4.f31207g = r7
            boolean r7 = com.google.android.exoplayer2.g.ae.c((int) r14)
            r4.k = r7
            boolean r7 = r4.k
            if (r7 == 0) goto L_0x00f3
            int r6 = r6 / r15
            long r6 = (long) r6
            long r10 = r4.d(r6)
            goto L_0x00f8
        L_0x00f3:
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x00f8:
            r4.f31208h = r10
            r4.l = r12
            r4.m = r12
            r4.n = r12
            r4.j = r5
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r4.o = r6
            r4.p = r6
            r4.f31209i = r12
            r24.n()
            com.google.android.exoplayer2.b.l r4 = r0.R
            int r4 = r4.f31210a
            if (r4 == 0) goto L_0x0128
            android.media.AudioTrack r4 = r0.q
            com.google.android.exoplayer2.b.l r6 = r0.R
            int r6 = r6.f31210a
            r4.attachAuxEffect(r6)
            android.media.AudioTrack r4 = r0.q
            com.google.android.exoplayer2.b.l r6 = r0.R
            float r6 = r6.f31211b
            r4.setAuxEffectSendLevel(r6)
        L_0x0128:
            boolean r4 = r0.P
            if (r4 == 0) goto L_0x012f
            r24.a()
        L_0x012f:
            com.google.android.exoplayer2.b.k r4 = r0.k
            long r6 = r24.r()
            android.media.AudioTrack r10 = r4.f31202b
            java.lang.Object r10 = com.google.android.exoplayer2.g.a.a(r10)
            android.media.AudioTrack r10 = (android.media.AudioTrack) r10
            int r10 = r10.getPlayState()
            boolean r11 = r4.f31207g
            r14 = 2
            if (r11 == 0) goto L_0x0158
            if (r10 != r14) goto L_0x014c
            r4.j = r5
        L_0x014a:
            r4 = 0
            goto L_0x017b
        L_0x014c:
            r11 = 1
            if (r10 != r11) goto L_0x0158
            long r19 = r4.d()
            int r11 = (r19 > r12 ? 1 : (r19 == r12 ? 0 : -1))
            if (r11 != 0) goto L_0x0158
            goto L_0x014a
        L_0x0158:
            boolean r11 = r4.j
            boolean r6 = r4.c(r6)
            r4.j = r6
            if (r11 == 0) goto L_0x017a
            boolean r6 = r4.j
            if (r6 != 0) goto L_0x017a
            r6 = 1
            if (r10 == r6) goto L_0x017a
            com.google.android.exoplayer2.b.k$a r6 = r4.f31201a
            if (r6 == 0) goto L_0x017a
            com.google.android.exoplayer2.b.k$a r6 = r4.f31201a
            int r7 = r4.f31204d
            long r10 = r4.f31208h
            long r10 = com.google.android.exoplayer2.c.a(r10)
            r6.a(r7, r10)
        L_0x017a:
            r4 = 1
        L_0x017b:
            if (r4 != 0) goto L_0x017e
            return r5
        L_0x017e:
            java.nio.ByteBuffer r4 = r0.I
            if (r4 != 0) goto L_0x0286
            boolean r4 = r25.hasRemaining()
            if (r4 != 0) goto L_0x018a
            r4 = 1
            return r4
        L_0x018a:
            com.google.android.exoplayer2.b.o$b r4 = r0.p
            boolean r4 = r4.f31234a
            if (r4 != 0) goto L_0x01ec
            int r4 = r0.C
            if (r4 != 0) goto L_0x01ec
            com.google.android.exoplayer2.b.o$b r4 = r0.p
            int r4 = r4.f31240g
            r6 = 7
            if (r4 == r6) goto L_0x01e0
            r6 = 8
            if (r4 != r6) goto L_0x01a0
            goto L_0x01e0
        L_0x01a0:
            if (r4 != r9) goto L_0x01a7
            int r4 = com.google.android.exoplayer2.b.a.a()
            goto L_0x01e4
        L_0x01a7:
            if (r4 == r8) goto L_0x01db
            r6 = 18
            if (r4 != r6) goto L_0x01ae
            goto L_0x01db
        L_0x01ae:
            r6 = 17
            if (r4 != r6) goto L_0x01b7
            int r4 = com.google.android.exoplayer2.b.b.a((java.nio.ByteBuffer) r25)
            goto L_0x01e4
        L_0x01b7:
            r6 = 14
            if (r4 != r6) goto L_0x01cb
            int r4 = com.google.android.exoplayer2.b.a.b((java.nio.ByteBuffer) r25)
            r6 = -1
            if (r4 != r6) goto L_0x01c4
            r4 = 0
            goto L_0x01e4
        L_0x01c4:
            int r4 = com.google.android.exoplayer2.b.a.a((java.nio.ByteBuffer) r1, (int) r4)
            int r4 = r4 * 16
            goto L_0x01e4
        L_0x01cb:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = java.lang.String.valueOf(r4)
            java.lang.String r3 = "Unexpected audio encoding: "
            java.lang.String r2 = r3.concat(r2)
            r1.<init>(r2)
            throw r1
        L_0x01db:
            int r4 = com.google.android.exoplayer2.b.a.a((java.nio.ByteBuffer) r25)
            goto L_0x01e4
        L_0x01e0:
            int r4 = com.google.android.exoplayer2.b.p.a((java.nio.ByteBuffer) r25)
        L_0x01e4:
            r0.C = r4
            int r4 = r0.C
            if (r4 != 0) goto L_0x01ec
            r4 = 1
            return r4
        L_0x01ec:
            com.google.android.exoplayer2.x r4 = r0.s
            if (r4 == 0) goto L_0x01ff
            boolean r4 = r24.m()
            if (r4 != 0) goto L_0x01f7
            return r5
        L_0x01f7:
            com.google.android.exoplayer2.x r4 = r0.s
            r6 = 0
            r0.s = r6
            r0.a((com.google.android.exoplayer2.x) r4, (long) r2)
        L_0x01ff:
            int r4 = r0.D
            if (r4 != 0) goto L_0x020d
            long r6 = java.lang.Math.max(r12, r2)
            r0.E = r6
            r4 = 1
            r0.D = r4
            goto L_0x026b
        L_0x020d:
            long r6 = r0.E
            com.google.android.exoplayer2.b.o$b r4 = r0.p
            long r8 = r24.q()
            com.google.android.exoplayer2.b.w r10 = r0.f31227g
            long r10 = r10.f31278h
            long r8 = r8 - r10
            r10 = 1000000(0xf4240, double:4.940656E-318)
            long r8 = r8 * r10
            int r4 = r4.f31236c
            long r10 = (long) r4
            long r8 = r8 / r10
            long r6 = r6 + r8
            int r4 = r0.D
            r8 = 1
            if (r4 != r8) goto L_0x0252
            long r8 = r6 - r2
            long r8 = java.lang.Math.abs(r8)
            r10 = 200000(0x30d40, double:9.8813E-319)
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x0252
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r8 = "Discontinuity detected [expected "
            r4.<init>(r8)
            r4.append(r6)
            java.lang.String r8 = ", got "
            r4.append(r8)
            r4.append(r2)
            java.lang.String r8 = "]"
            r4.append(r8)
            com.google.android.exoplayer2.g.l.d()
            r0.D = r14
        L_0x0252:
            int r4 = r0.D
            if (r4 != r14) goto L_0x026b
            long r6 = r2 - r6
            long r8 = r0.E
            long r8 = r8 + r6
            r0.E = r8
            r4 = 1
            r0.D = r4
            com.google.android.exoplayer2.b.i$c r4 = r0.m
            if (r4 == 0) goto L_0x026b
            int r8 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r8 == 0) goto L_0x026b
            r4.a()
        L_0x026b:
            com.google.android.exoplayer2.b.o$b r4 = r0.p
            boolean r4 = r4.f31234a
            if (r4 == 0) goto L_0x027c
            long r6 = r0.y
            int r4 = r25.remaining()
            long r8 = (long) r4
            long r6 = r6 + r8
            r0.y = r6
            goto L_0x0284
        L_0x027c:
            long r6 = r0.z
            int r4 = r0.C
            long r8 = (long) r4
            long r6 = r6 + r8
            r0.z = r6
        L_0x0284:
            r0.I = r1
        L_0x0286:
            com.google.android.exoplayer2.b.o$b r1 = r0.p
            boolean r1 = r1.f31242i
            if (r1 == 0) goto L_0x0290
            r0.a((long) r2)
            goto L_0x0295
        L_0x0290:
            java.nio.ByteBuffer r1 = r0.I
            r0.b(r1, r2)
        L_0x0295:
            java.nio.ByteBuffer r1 = r0.I
            boolean r1 = r1.hasRemaining()
            if (r1 != 0) goto L_0x02a2
            r1 = 0
            r0.I = r1
        L_0x02a0:
            r1 = 1
            return r1
        L_0x02a2:
            com.google.android.exoplayer2.b.k r1 = r0.k
            long r2 = r24.r()
            long r6 = r1.p
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x02c6
            int r4 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x02c6
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r6 = r1.p
            long r2 = r2 - r6
            r6 = 200(0xc8, double:9.9E-322)
            int r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x02c6
            r1 = 1
            goto L_0x02c7
        L_0x02c6:
            r1 = 0
        L_0x02c7:
            if (r1 == 0) goto L_0x02d0
            com.google.android.exoplayer2.g.l.c()
            r24.i()
            goto L_0x02a0
        L_0x02d0:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.b.o.a(java.nio.ByteBuffer, long):boolean");
    }

    private void a(long j2) throws i.d {
        ByteBuffer byteBuffer;
        int length = this.G.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                byteBuffer = this.H[i2 - 1];
            } else {
                byteBuffer = this.I;
                if (byteBuffer == null) {
                    byteBuffer = g.f31187a;
                }
            }
            if (i2 == length) {
                b(byteBuffer, j2);
            } else {
                g gVar = this.G[i2];
                gVar.a(byteBuffer);
                ByteBuffer f2 = gVar.f();
                this.H[i2] = f2;
                if (f2.hasRemaining()) {
                    i2++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i2--;
            } else {
                return;
            }
        }
    }

    private void b(ByteBuffer byteBuffer, long j2) throws i.d {
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.J;
            boolean z2 = true;
            int i2 = 0;
            if (byteBuffer2 != null) {
                com.google.android.exoplayer2.g.a.a(byteBuffer2 == byteBuffer);
            } else {
                this.J = byteBuffer;
                if (ae.f32499a < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.K;
                    if (bArr == null || bArr.length < remaining) {
                        this.K = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.K, 0, remaining);
                    byteBuffer.position(position);
                    this.L = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (ae.f32499a < 21) {
                int a2 = this.k.a(this.A);
                if (a2 > 0 && (i2 = this.q.write(this.K, this.L, Math.min(remaining2, a2))) > 0) {
                    this.L += i2;
                    byteBuffer.position(byteBuffer.position() + i2);
                }
            } else if (this.S) {
                if (j2 == -9223372036854775807L) {
                    z2 = false;
                }
                com.google.android.exoplayer2.g.a.b(z2);
                i2 = a(this.q, byteBuffer, remaining2, j2);
            } else {
                i2 = this.q.write(byteBuffer, remaining2, 1);
            }
            this.T = SystemClock.elapsedRealtime();
            if (i2 >= 0) {
                if (this.p.f31234a) {
                    this.A += (long) i2;
                }
                if (i2 == remaining2) {
                    if (!this.p.f31234a) {
                        this.B += (long) this.C;
                    }
                    this.J = null;
                    return;
                }
                return;
            }
            throw new i.d(i2);
        }
    }

    public final void c() throws i.d {
        if (!this.N && p() && m()) {
            s();
            this.N = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m() throws com.google.android.exoplayer2.b.i.d {
        /*
            r9 = this;
            int r0 = r9.M
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0016
            com.google.android.exoplayer2.b.o$b r0 = r9.p
            boolean r0 = r0.f31242i
            if (r0 == 0) goto L_0x000f
            r0 = 0
            goto L_0x0012
        L_0x000f:
            com.google.android.exoplayer2.b.g[] r0 = r9.G
            int r0 = r0.length
        L_0x0012:
            r9.M = r0
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            int r4 = r9.M
            com.google.android.exoplayer2.b.g[] r5 = r9.G
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x003a
            r4 = r5[r4]
            if (r0 == 0) goto L_0x002a
            r4.e()
        L_0x002a:
            r9.a((long) r7)
            boolean r0 = r4.g()
            if (r0 != 0) goto L_0x0034
            return r3
        L_0x0034:
            int r0 = r9.M
            int r0 = r0 + r2
            r9.M = r0
            goto L_0x0014
        L_0x003a:
            java.nio.ByteBuffer r0 = r9.J
            if (r0 == 0) goto L_0x0046
            r9.b(r0, r7)
            java.nio.ByteBuffer r0 = r9.J
            if (r0 == 0) goto L_0x0046
            return r3
        L_0x0046:
            r9.M = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.b.o.m():boolean");
    }

    public final boolean d() {
        if (p()) {
            return this.N && !e();
        }
        return true;
    }

    public final boolean e() {
        return p() && this.k.c(r());
    }

    public final x a(x xVar) {
        b bVar = this.p;
        if (bVar == null || bVar.j) {
            x xVar2 = this.s;
            if (xVar2 == null) {
                if (!this.l.isEmpty()) {
                    xVar2 = this.l.getLast().f31246a;
                } else {
                    xVar2 = this.t;
                }
            }
            if (!xVar.equals(xVar2)) {
                if (p()) {
                    this.s = xVar;
                } else {
                    this.t = xVar;
                }
            }
            return this.t;
        }
        this.t = x.f33726a;
        return this.t;
    }

    public final x f() {
        return this.t;
    }

    public final void a(c cVar) {
        if (!this.r.equals(cVar)) {
            this.r = cVar;
            if (!this.S) {
                i();
                this.Q = 0;
            }
        }
    }

    public final void a(l lVar) {
        if (!this.R.equals(lVar)) {
            int i2 = lVar.f31210a;
            float f2 = lVar.f31211b;
            if (this.q != null) {
                if (this.R.f31210a != i2) {
                    this.q.attachAuxEffect(i2);
                }
                if (i2 != 0) {
                    this.q.setAuxEffectSendLevel(f2);
                }
            }
            this.R = lVar;
        }
    }

    public final void a(int i2) {
        com.google.android.exoplayer2.g.a.b(ae.f32499a >= 21);
        if (!this.S || this.Q != i2) {
            this.S = true;
            this.Q = i2;
            i();
        }
    }

    public final void g() {
        if (this.S) {
            this.S = false;
            this.Q = 0;
            i();
        }
    }

    public final void a(float f2) {
        if (this.F != f2) {
            this.F = f2;
            n();
        }
    }

    private void n() {
        if (!p()) {
            return;
        }
        if (ae.f32499a >= 21) {
            this.q.setVolume(this.F);
            return;
        }
        AudioTrack audioTrack = this.q;
        float f2 = this.F;
        audioTrack.setStereoVolume(f2, f2);
    }

    public final void h() {
        boolean z2 = false;
        this.P = false;
        if (p()) {
            k kVar = this.k;
            kVar.c();
            if (kVar.o == -9223372036854775807L) {
                ((j) com.google.android.exoplayer2.g.a.a(kVar.f31205e)).a();
                z2 = true;
            }
            if (z2) {
                this.q.pause();
            }
        }
    }

    public final void i() {
        if (p()) {
            this.y = 0;
            this.z = 0;
            this.A = 0;
            this.B = 0;
            this.C = 0;
            x xVar = this.s;
            if (xVar != null) {
                this.t = xVar;
                this.s = null;
            } else if (!this.l.isEmpty()) {
                this.t = this.l.getLast().f31246a;
            }
            this.l.clear();
            this.u = 0;
            this.v = 0;
            this.f31227g.f31278h = 0;
            l();
            this.I = null;
            this.J = null;
            this.O = false;
            this.N = false;
            this.M = -1;
            this.w = null;
            this.x = 0;
            this.D = 0;
            if (this.k.a()) {
                this.q.pause();
            }
            final AudioTrack audioTrack = this.q;
            this.q = null;
            b bVar = this.o;
            if (bVar != null) {
                this.p = bVar;
                this.o = null;
            }
            this.k.b();
            this.j.close();
            new Thread() {
                public final void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        o.this.j.open();
                    }
                }
            }.start();
        }
    }

    public final void j() {
        i();
        o();
        for (g i2 : this.f31228h) {
            i2.i();
        }
        for (g i3 : this.f31229i) {
            i3.i();
        }
        this.Q = 0;
        this.P = false;
    }

    private void o() {
        final AudioTrack audioTrack = this.n;
        if (audioTrack != null) {
            this.n = null;
            new Thread() {
                public final void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    private void a(x xVar, long j2) {
        this.l.add(new e(this.p.j ? this.f31224d.a(xVar) : x.f33726a, Math.max(0, j2), this.p.a(r()), (byte) 0));
        k();
    }

    private boolean p() {
        return this.q != null;
    }

    /* access modifiers changed from: private */
    public long q() {
        return this.p.f31234a ? this.y / ((long) this.p.f31235b) : this.z;
    }

    /* access modifiers changed from: private */
    public long r() {
        return this.p.f31234a ? this.A / ((long) this.p.f31237d) : this.B;
    }

    private int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j2) {
        if (ae.f32499a >= 26) {
            return audioTrack.write(byteBuffer, i2, 1, j2 * 1000);
        }
        if (this.w == null) {
            this.w = ByteBuffer.allocate(16);
            this.w.order(ByteOrder.BIG_ENDIAN);
            this.w.putInt(1431633921);
        }
        if (this.x == 0) {
            this.w.putInt(4, i2);
            this.w.putLong(8, j2 * 1000);
            this.w.position(0);
            this.x = i2;
        }
        int remaining = this.w.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.w, remaining, 1);
            if (write < 0) {
                this.x = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int write2 = audioTrack.write(byteBuffer, i2, 1);
        if (write2 < 0) {
            this.x = 0;
            return write2;
        }
        this.x -= write2;
        return write2;
    }

    private void s() {
        if (!this.O) {
            this.O = true;
            this.k.b(r());
            this.q.stop();
            this.x = 0;
        }
    }

    static final class e {

        /* renamed from: a  reason: collision with root package name */
        final x f31246a;

        /* renamed from: b  reason: collision with root package name */
        final long f31247b;

        /* renamed from: c  reason: collision with root package name */
        final long f31248c;

        /* synthetic */ e(x xVar, long j, long j2, byte b2) {
            this(xVar, j, j2);
        }

        private e(x xVar, long j, long j2) {
            this.f31246a = xVar;
            this.f31247b = j;
            this.f31248c = j2;
        }
    }

    final class f implements k.a {
        private f() {
        }

        /* synthetic */ f(o oVar, byte b2) {
            this();
        }

        public final void a(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + o.this.q() + ", " + o.this.r();
            if (!o.f31222b) {
                l.c();
                return;
            }
            throw new d(str);
        }

        public final void b(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + o.this.q() + ", " + o.this.r();
            if (!o.f31222b) {
                l.c();
                return;
            }
            throw new d(str);
        }

        public final void a(long j) {
            "Ignoring impossibly large audio latency: ".concat(String.valueOf(j));
            l.c();
        }

        public final void a(int i2, long j) {
            if (o.this.m != null) {
                o.this.m.a(i2, j, SystemClock.elapsedRealtime() - o.this.T);
            }
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f31234a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31235b;

        /* renamed from: c  reason: collision with root package name */
        public final int f31236c;

        /* renamed from: d  reason: collision with root package name */
        public final int f31237d;

        /* renamed from: e  reason: collision with root package name */
        public final int f31238e;

        /* renamed from: f  reason: collision with root package name */
        public final int f31239f;

        /* renamed from: g  reason: collision with root package name */
        public final int f31240g;

        /* renamed from: h  reason: collision with root package name */
        public final int f31241h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f31242i;
        public final boolean j;
        public final g[] k;

        public b(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2, boolean z3, g[] gVarArr) {
            int i8;
            this.f31234a = z;
            this.f31235b = i2;
            this.f31236c = i3;
            this.f31237d = i4;
            this.f31238e = i5;
            this.f31239f = i6;
            this.f31240g = i7;
            if (this.f31234a) {
                int minBufferSize = AudioTrack.getMinBufferSize(this.f31238e, this.f31239f, this.f31240g);
                com.google.android.exoplayer2.g.a.b(minBufferSize != -2);
                i8 = ae.a(minBufferSize * 4, ((int) b(250000)) * this.f31237d, (int) Math.max((long) minBufferSize, b(750000) * ((long) this.f31237d)));
            } else {
                int b2 = o.b(this.f31240g);
                i8 = (int) ((((long) (this.f31240g == 5 ? b2 * 2 : b2)) * 250000) / 1000000);
            }
            this.f31241h = i8;
            this.f31242i = z2;
            this.j = z3;
            this.k = gVarArr;
        }

        public final boolean a(b bVar) {
            return bVar.f31240g == this.f31240g && bVar.f31238e == this.f31238e && bVar.f31239f == this.f31239f;
        }

        public final long a(long j2) {
            return (j2 * 1000000) / ((long) this.f31238e);
        }

        private long b(long j2) {
            return (j2 * ((long) this.f31238e)) / 1000000;
        }

        public final AudioTrack a(boolean z, c cVar, int i2) throws i.b {
            AudioTrack audioTrack;
            AudioAttributes audioAttributes;
            if (ae.f32499a >= 21) {
                if (z) {
                    audioAttributes = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
                } else {
                    audioAttributes = cVar.a();
                }
                audioTrack = new AudioTrack(audioAttributes, new AudioFormat.Builder().setChannelMask(this.f31239f).setEncoding(this.f31240g).setSampleRate(this.f31238e).build(), this.f31241h, 1, i2 != 0 ? i2 : 0);
            } else {
                int f2 = ae.f(cVar.f31168d);
                if (i2 == 0) {
                    audioTrack = new AudioTrack(f2, this.f31238e, this.f31239f, this.f31240g, this.f31241h, 1);
                } else {
                    audioTrack = new AudioTrack(f2, this.f31238e, this.f31239f, this.f31240g, this.f31241h, 1, i2);
                }
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new i.b(state, this.f31238e, this.f31239f, this.f31241h);
        }
    }

    static /* synthetic */ int b(int i2) {
        if (i2 == 5) {
            return 80000;
        }
        if (i2 == 6) {
            return 768000;
        }
        if (i2 == 7) {
            return 192000;
        }
        if (i2 == 8) {
            return 2250000;
        }
        if (i2 == 14) {
            return 3062500;
        }
        if (i2 == 17) {
            return 336000;
        }
        if (i2 == 18) {
            return 768000;
        }
        throw new IllegalArgumentException();
    }
}
