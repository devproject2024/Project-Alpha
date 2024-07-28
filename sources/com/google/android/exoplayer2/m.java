package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.google.android.exoplayer2.aa;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.k;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.trackselection.f;
import com.google.android.exoplayer2.trackselection.i;
import com.google.android.exoplayer2.trackselection.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class m implements Handler.Callback, aa.a, g.a, n.a, o.b, i.a {
    private boolean A;
    private boolean B;
    private int C;
    private d D;
    private long E;
    private int F;

    /* renamed from: a  reason: collision with root package name */
    public final k f32621a;

    /* renamed from: b  reason: collision with root package name */
    final HandlerThread f32622b;

    /* renamed from: c  reason: collision with root package name */
    private final ab[] f32623c;

    /* renamed from: d  reason: collision with root package name */
    private final ac[] f32624d;

    /* renamed from: e  reason: collision with root package name */
    private final i f32625e;

    /* renamed from: f  reason: collision with root package name */
    private final j f32626f;

    /* renamed from: g  reason: collision with root package name */
    private final q f32627g;

    /* renamed from: h  reason: collision with root package name */
    private final com.google.android.exoplayer2.f.d f32628h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f32629i;
    private final ah.b j;
    private final ah.a k;
    private final long l;
    private final boolean m;
    private final g n;
    private final c o;
    private final ArrayList<b> p;
    private final com.google.android.exoplayer2.g.b q;
    private final u r = new u();
    private af s;
    private w t;
    private o u;
    private ab[] v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z;

    public final /* synthetic */ void a(v vVar) {
        this.f32621a.a(10, (Object) (n) vVar).sendToTarget();
    }

    public m(ab[] abVarArr, i iVar, j jVar, q qVar, com.google.android.exoplayer2.f.d dVar, boolean z2, int i2, boolean z3, Handler handler, com.google.android.exoplayer2.g.b bVar) {
        this.f32623c = abVarArr;
        this.f32625e = iVar;
        this.f32626f = jVar;
        this.f32627g = qVar;
        this.f32628h = dVar;
        this.x = z2;
        this.z = i2;
        this.A = z3;
        this.f32629i = handler;
        this.q = bVar;
        this.l = qVar.e();
        this.m = qVar.f();
        this.s = af.f31110e;
        this.t = w.a(-9223372036854775807L, jVar);
        this.o = new c((byte) 0);
        this.f32624d = new ac[abVarArr.length];
        for (int i3 = 0; i3 < abVarArr.length; i3++) {
            abVarArr[i3].a(i3);
            this.f32624d[i3] = abVarArr[i3].b();
        }
        this.n = new g(this, bVar);
        this.p = new ArrayList<>();
        this.v = new ab[0];
        this.j = new ah.b();
        this.k = new ah.a();
        iVar.f33507a = this;
        iVar.f33508b = dVar;
        this.f32622b = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f32622b.start();
        this.f32621a = bVar.a(this.f32622b.getLooper(), this);
    }

    public final void a(boolean z2) {
        this.f32621a.a(1, z2 ? 1 : 0).sendToTarget();
    }

    public final synchronized void a(aa aaVar) {
        if (this.w) {
            l.c();
            aaVar.a(false);
            return;
        }
        this.f32621a.a(15, (Object) aaVar).sendToTarget();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.w     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            com.google.android.exoplayer2.g.k r0 = r2.f32621a     // Catch:{ all -> 0x0023 }
            r1 = 7
            r0.a((int) r1)     // Catch:{ all -> 0x0023 }
            r0 = 0
        L_0x000e:
            boolean r1 = r2.w     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0018
            r2.wait()     // Catch:{ InterruptedException -> 0x0016 }
            goto L_0x000e
        L_0x0016:
            r0 = 1
            goto L_0x000e
        L_0x0018:
            if (r0 == 0) goto L_0x0021
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0023 }
            r0.interrupt()     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r2)
            return
        L_0x0023:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.m.a():void");
    }

    public final void onSourceInfoRefreshed(o oVar, ah ahVar, Object obj) {
        this.f32621a.a(8, (Object) new a(oVar, ahVar, obj)).sendToTarget();
    }

    public final void a(n nVar) {
        this.f32621a.a(9, (Object) nVar).sendToTarget();
    }

    public final void b() {
        this.f32621a.a(11);
    }

    public final void a(x xVar) {
        this.f32621a.a(17, (Object) xVar).sendToTarget();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0460, code lost:
        if (r2.a(r5) != false) goto L_0x0462;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0462, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0480, code lost:
        if (r2.a(r5) != false) goto L_0x0462;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x068e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x068f, code lost:
        r2 = r0;
        r1.t = r1.t.a(r4, r8, r29, m());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x06a2, code lost:
        if (r3 != false) goto L_0x06a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x06a6, code lost:
        r4 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:?, code lost:
        r1.o.b(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:333:?, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:537:0x0a31, code lost:
        if (r13 == false) goto L_0x0a33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:580:0x0ab9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:581:0x0aba, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:582:0x0abc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:583:0x0abd, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:593:0x0af4, code lost:
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:594:0x0af8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:595:0x0af9, code lost:
        r2 = r0;
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:596:0x0afb, code lost:
        r4 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:597:0x0afd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:598:0x0afe, code lost:
        r2 = r0;
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:599:0x0b00, code lost:
        r4 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:600:0x0b02, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:603:0x0b0f, code lost:
        r2 = com.google.android.exoplayer2.i.createForOutOfMemoryError((java.lang.OutOfMemoryError) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:604:0x0b16, code lost:
        r2 = com.google.android.exoplayer2.i.createForUnexpected((java.lang.RuntimeException) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:606:0x0b2f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:607:0x0b30, code lost:
        r3 = false;
        r4 = 2;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:610:0x0b4d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:611:0x0b4e, code lost:
        r3 = false;
        r4 = 2;
        r2 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03fd A[Catch:{ all -> 0x068e, i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError | RuntimeException -> 0x0b02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0483  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x048c A[Catch:{ i -> 0x051f, IOException -> 0x0517, OutOfMemoryError | RuntimeException -> 0x0510 }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0492 A[Catch:{ i -> 0x051f, IOException -> 0x0517, OutOfMemoryError | RuntimeException -> 0x0510 }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04c6 A[Catch:{ i -> 0x051f, IOException -> 0x0517, OutOfMemoryError | RuntimeException -> 0x0510 }] */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0500 A[Catch:{ i -> 0x051f, IOException -> 0x0517, OutOfMemoryError | RuntimeException -> 0x0510 }] */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x0534 A[Catch:{ all -> 0x068e, i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError | RuntimeException -> 0x0b02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x068a A[Catch:{ all -> 0x068e, i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError | RuntimeException -> 0x0b02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x0705 A[Catch:{ all -> 0x068e, i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError | RuntimeException -> 0x0b02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x07b9 A[Catch:{ all -> 0x068e, i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError | RuntimeException -> 0x0b02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x07d6 A[Catch:{ all -> 0x068e, i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError | RuntimeException -> 0x0b02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:489:0x098f A[Catch:{ all -> 0x068e, i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError | RuntimeException -> 0x0b02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:600:0x0b02 A[ExcHandler: OutOfMemoryError | RuntimeException (e java.lang.Throwable), PHI: r1 
      PHI: (r1v4 com.google.android.exoplayer2.m) = (r1v0 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m), (r1v13 com.google.android.exoplayer2.m), (r1v10 com.google.android.exoplayer2.m), (r1v10 com.google.android.exoplayer2.m), (r1v10 com.google.android.exoplayer2.m), (r1v0 com.google.android.exoplayer2.m) binds: [B:1:0x0007, B:2:?, B:568:0x0a8e, B:569:?, B:570:0x0a90, B:540:0x0a38, B:541:?, B:542:0x0a3b, B:283:0x05f8, B:332:0x06b5, B:326:0x06a7, B:327:?, B:317:0x0678, B:303:0x0648, B:116:0x029e, B:117:?, B:118:0x02a0, B:246:0x052d, B:196:0x046d, B:188:0x045c, B:183:0x0451, B:6:0x0015] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0007] */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0b0f  */
    /* JADX WARNING: Removed duplicated region for block: B:604:0x0b16  */
    /* JADX WARNING: Removed duplicated region for block: B:640:0x04d0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:641:0x047c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r45) {
        /*
            r44 = this;
            r1 = r44
            r2 = r45
            r3 = 2
            r4 = 1
            r5 = 0
            int r6 = r2.what     // Catch:{ i -> 0x0b4d, IOException -> 0x0b2f, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r7 = 0
            r11 = 4
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            switch(r6) {
                case 0: goto L_0x0abf;
                case 1: goto L_0x0a86;
                case 2: goto L_0x06b6;
                case 3: goto L_0x059d;
                case 4: goto L_0x0592;
                case 5: goto L_0x058a;
                case 6: goto L_0x057c;
                case 7: goto L_0x0577;
                case 8: goto L_0x028c;
                case 9: goto L_0x0201;
                case 10: goto L_0x01e9;
                case 11: goto L_0x00ee;
                case 12: goto L_0x00d8;
                case 13: goto L_0x00bd;
                case 14: goto L_0x00ad;
                case 15: goto L_0x006d;
                case 16: goto L_0x005d;
                case 17: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            r2 = 0
            return r2
        L_0x0015:
            java.lang.Object r2 = r2.obj     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.x r2 = (com.google.android.exoplayer2.x) r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            android.os.Handler r6 = r1.f32629i     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            android.os.Message r6 = r6.obtainMessage(r4, r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r6.sendToTarget()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            float r6 = r2.f33727b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r7 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r7 = r7.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x002a:
            if (r7 == 0) goto L_0x004b
            boolean r8 = r7.f32773d     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r8 == 0) goto L_0x004b
            com.google.android.exoplayer2.trackselection.j r8 = r7.f()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.trackselection.g r8 = r8.f33511c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.trackselection.f[] r8 = r8.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r9 = r8.length     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r10 = 0
        L_0x003c:
            if (r10 >= r9) goto L_0x0048
            r11 = r8[r10]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r11 == 0) goto L_0x0045
            r11.a((float) r6)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x0045:
            int r10 = r10 + 1
            goto L_0x003c
        L_0x0048:
            com.google.android.exoplayer2.s r7 = r7.f32776g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x002a
        L_0x004b:
            com.google.android.exoplayer2.ab[] r6 = r1.f32623c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r7 = r6.length     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r8 = 0
        L_0x004f:
            if (r8 >= r7) goto L_0x0af4
            r9 = r6[r8]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r9 == 0) goto L_0x005a
            float r10 = r2.f33727b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r9.a((float) r10)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x005a:
            int r8 = r8 + 1
            goto L_0x004f
        L_0x005d:
            java.lang.Object r2 = r2.obj     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.aa r2 = (com.google.android.exoplayer2.aa) r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            android.os.Handler r6 = r2.f31099e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.-$$Lambda$m$4Qx5K64DTrdE0-6w1ZcvSJhdtGk r7 = new com.google.android.exoplayer2.-$$Lambda$m$4Qx5K64DTrdE0-6w1ZcvSJhdtGk     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r7.<init>(r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r6.post(r7)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x006d:
            java.lang.Object r2 = r2.obj     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.aa r2 = (com.google.android.exoplayer2.aa) r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r6 = r2.f31101g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r8 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r8 != 0) goto L_0x007c
            r1.b((com.google.android.exoplayer2.aa) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x007c:
            com.google.android.exoplayer2.source.o r6 = r1.u     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r6 == 0) goto L_0x00a1
            int r6 = r1.C     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r6 <= 0) goto L_0x0085
            goto L_0x00a1
        L_0x0085:
            com.google.android.exoplayer2.m$b r6 = new com.google.android.exoplayer2.m$b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r6.<init>(r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r7 = r1.a((com.google.android.exoplayer2.m.b) r6)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r7 == 0) goto L_0x009c
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r2 = r1.p     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r2.add(r6)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r2 = r1.p     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.util.Collections.sort(r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x009c:
            r2.a((boolean) r5)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x00a1:
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r6 = r1.p     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.m$b r7 = new com.google.android.exoplayer2.m$b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r7.<init>(r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r6.add(r7)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x00ad:
            int r6 = r2.arg1     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r6 == 0) goto L_0x00b3
            r6 = 1
            goto L_0x00b4
        L_0x00b3:
            r6 = 0
        L_0x00b4:
            java.lang.Object r2 = r2.obj     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.util.concurrent.atomic.AtomicBoolean r2 = (java.util.concurrent.atomic.AtomicBoolean) r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.a((boolean) r6, (java.util.concurrent.atomic.AtomicBoolean) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x00bd:
            int r2 = r2.arg1     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 == 0) goto L_0x00c3
            r2 = 1
            goto L_0x00c4
        L_0x00c3:
            r2 = 0
        L_0x00c4:
            r1.A = r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r6 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r6.f33515c = r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r2 = r6.d()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 != 0) goto L_0x00d3
            r1.c((boolean) r4)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x00d3:
            r1.d((boolean) r5)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x00d8:
            int r2 = r2.arg1     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.z = r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r6 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r6.f33514b = r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r2 = r6.d()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 != 0) goto L_0x00e9
            r1.c((boolean) r4)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x00e9:
            r1.d((boolean) r5)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x00ee:
            com.google.android.exoplayer2.u r2 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r2 = r2.b()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 == 0) goto L_0x0af4
            com.google.android.exoplayer2.g r2 = r1.n     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.x r2 = r2.e()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            float r2 = r2.f33727b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r6 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r6 = r6.f33516d     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r7 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r7 = r7.f33517e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r8 = 1
        L_0x0107:
            if (r6 == 0) goto L_0x0af4
            boolean r9 = r6.f32773d     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r9 != 0) goto L_0x010f
            goto L_0x0af4
        L_0x010f:
            com.google.android.exoplayer2.trackselection.j r13 = r6.a((float) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r13 != 0) goto L_0x011b
            if (r6 != r7) goto L_0x0118
            r8 = 0
        L_0x0118:
            com.google.android.exoplayer2.s r6 = r6.f32776g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0107
        L_0x011b:
            if (r8 == 0) goto L_0x01ba
            com.google.android.exoplayer2.u r2 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r2 = r2.f33516d     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r6 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r16 = r6.a((com.google.android.exoplayer2.s) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.ab[] r6 = r1.f32623c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r6 = r6.length     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean[] r6 = new boolean[r6]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r7 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r14 = r7.m     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r12 = r2
            r17 = r6
            long r7 = r12.a(r13, r14, r16, r17)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r9 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r9 = r9.f33722f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r9 == r11) goto L_0x0169
            com.google.android.exoplayer2.w r9 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r9 = r9.m     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 == 0) goto L_0x0169
            com.google.android.exoplayer2.w r9 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r10 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r10 = r10.f33719c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r12 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r12 = r12.f33721e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r23 = r44.m()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r17 = r9
            r18 = r10
            r19 = r7
            r21 = r12
            com.google.android.exoplayer2.w r9 = r17.a(r18, r19, r21, r23)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.t = r9     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.m$c r9 = r1.o     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r9.b((int) r11)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.a((long) r7)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x0169:
            com.google.android.exoplayer2.ab[] r7 = r1.f32623c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r7 = r7.length     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean[] r7 = new boolean[r7]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r8 = 0
            r9 = 0
        L_0x0170:
            com.google.android.exoplayer2.ab[] r10 = r1.f32623c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r10 = r10.length     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r8 >= r10) goto L_0x01a6
            com.google.android.exoplayer2.ab[] r10 = r1.f32623c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r10 = r10[r8]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r12 = r10.f_()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r12 == 0) goto L_0x0181
            r12 = 1
            goto L_0x0182
        L_0x0181:
            r12 = 0
        L_0x0182:
            r7[r8] = r12     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.u[] r12 = r2.f32772c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r12 = r12[r8]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r12 == 0) goto L_0x018c
            int r9 = r9 + 1
        L_0x018c:
            boolean r13 = r7[r8]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r13 == 0) goto L_0x01a3
            com.google.android.exoplayer2.source.u r13 = r10.f()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r12 == r13) goto L_0x019a
            r1.b((com.google.android.exoplayer2.ab) r10)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x01a3
        L_0x019a:
            boolean r12 = r6[r8]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r12 == 0) goto L_0x01a3
            long r12 = r1.E     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r10.a((long) r12)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x01a3:
            int r8 = r8 + 1
            goto L_0x0170
        L_0x01a6:
            com.google.android.exoplayer2.w r6 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.TrackGroupArray r8 = r2.e()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.trackselection.j r2 = r2.f()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r2 = r6.a((com.google.android.exoplayer2.source.TrackGroupArray) r8, (com.google.android.exoplayer2.trackselection.j) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.t = r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.a((boolean[]) r7, (int) r9)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x01d3
        L_0x01ba:
            com.google.android.exoplayer2.u r2 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r2.a((com.google.android.exoplayer2.s) r6)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r2 = r6.f32773d     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 == 0) goto L_0x01d3
            com.google.android.exoplayer2.t r2 = r6.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r7 = r2.f33412b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r9 = r1.E     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r14 = r6.f32778i     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r9 = r9 - r14
            long r7 = java.lang.Math.max(r7, r9)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r6.a(r13, r7)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x01d3:
            r1.d((boolean) r4)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r2 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r2 = r2.f33722f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 == r11) goto L_0x0af4
            r44.l()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r44.f()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.g.k r2 = r1.f32621a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r2.a((int) r3)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x01e9:
            java.lang.Object r2 = r2.obj     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.n r2 = (com.google.android.exoplayer2.source.n) r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r6 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r2 = r6.a((com.google.android.exoplayer2.source.n) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 == 0) goto L_0x0af4
            com.google.android.exoplayer2.u r2 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r6 = r1.E     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r2.a((long) r6)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r44.l()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x0201:
            java.lang.Object r2 = r2.obj     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.n r2 = (com.google.android.exoplayer2.source.n) r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r6 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r2 = r6.a((com.google.android.exoplayer2.source.n) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 == 0) goto L_0x0af4
            com.google.android.exoplayer2.u r2 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r2 = r2.f33518f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.g r6 = r1.n     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.x r6 = r6.e()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            float r6 = r6.f33727b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r2.f32773d = r4     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.n r8 = r2.f32770a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.TrackGroupArray r8 = r8.b()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r2.f32777h = r8     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.trackselection.j r6 = r2.a((float) r6)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Object r6 = com.google.android.exoplayer2.g.a.a(r6)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.trackselection.j r6 = (com.google.android.exoplayer2.trackselection.j) r6     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.t r8 = r2.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r8 = r8.f33412b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r12 = r2.a(r6, r8)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r8 = r2.f32778i     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.t r6 = r2.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r10 = r6.f33412b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r10 = r10 - r12
            long r8 = r8 + r10
            r2.f32778i = r8     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.t r6 = r2.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r8 = r6.f33412b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r10 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x0248
            goto L_0x0263
        L_0x0248:
            com.google.android.exoplayer2.t r8 = new com.google.android.exoplayer2.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r11 = r6.f33411a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r14 = r6.f33413c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r9 = r6.f33414d     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r3 = r6.f33415e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r5 = r6.f33416f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r6 = r6.f33417g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r16 = r9
            r10 = r8
            r18 = r3
            r20 = r5
            r21 = r6
            r10.<init>(r11, r12, r14, r16, r18, r20, r21)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r6 = r8
        L_0x0263:
            r2.f32775f = r6     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r2.e()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.trackselection.j r2 = r2.f()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.a((com.google.android.exoplayer2.trackselection.j) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r2 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r2 = r2.b()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 != 0) goto L_0x0287
            com.google.android.exoplayer2.u r2 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r2 = r2.c()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.t r2 = r2.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r2 = r2.f33412b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.a((long) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.a((com.google.android.exoplayer2.s) r7)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x0287:
            r44.l()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x028c:
            java.lang.Object r2 = r2.obj     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.m$a r2 = (com.google.android.exoplayer2.m.a) r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o r3 = r2.f32630a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o r4 = r1.u     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r3 != r4) goto L_0x0af4
            com.google.android.exoplayer2.m$c r3 = r1.o     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r4 = r1.C     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r3.a((int) r4)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r3 = 0
            r1.C = r3     // Catch:{ i -> 0x0abc, IOException -> 0x0ab9, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r3 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.ah r3 = r3.f33717a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.ah r4 = r2.f32631b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Object r2 = r2.f32632c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r5 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r5.f33513a = r4     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r5 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r6 = new com.google.android.exoplayer2.w     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r10 = r5.f33719c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r14 = r5.f33720d     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r8 = r5.f33721e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r11 = r5.f33722f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r12 = r5.f33723g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.TrackGroupArray r13 = r5.f33724h     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.trackselection.j r7 = r5.f33725i     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r21 = r3
            com.google.android.exoplayer2.source.o$a r3 = r5.j     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r34 = r12
            r35 = r13
            long r12 = r5.k     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r38 = r12
            long r12 = r5.l     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r40 = r12
            long r12 = r5.m     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r25 = r6
            r26 = r4
            r27 = r2
            r28 = r10
            r29 = r14
            r31 = r8
            r33 = r11
            r36 = r7
            r37 = r3
            r42 = r12
            r25.<init>(r26, r27, r28, r29, r31, r33, r34, r35, r36, r37, r38, r40, r42)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.t = r6     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r2 = r1.p     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r2 = r2.size()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r3 = 1
            int r2 = r2 - r3
        L_0x02f1:
            if (r2 < 0) goto L_0x0317
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r3 = r1.p     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.m$b r3 = (com.google.android.exoplayer2.m.b) r3     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r3 = r1.a((com.google.android.exoplayer2.m.b) r3)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r3 != 0) goto L_0x0314
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r3 = r1.p     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.m$b r3 = (com.google.android.exoplayer2.m.b) r3     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.aa r3 = r3.f32633a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r5 = 0
            r3.a((boolean) r5)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r3 = r1.p     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r3.remove(r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x0314:
            int r2 = r2 + -1
            goto L_0x02f1
        L_0x0317:
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r2 = r1.p     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.util.Collections.sort(r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r2 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r2 = r2.f33719c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r3 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r3 = r3.f33719c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r3 = r3.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r3 == 0) goto L_0x032f
            com.google.android.exoplayer2.w r3 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r5 = r3.f33721e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0333
        L_0x032f:
            com.google.android.exoplayer2.w r3 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r5 = r3.m     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x0333:
            com.google.android.exoplayer2.m$d r3 = r1.D     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r3 == 0) goto L_0x035c
            com.google.android.exoplayer2.m$d r2 = r1.D     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r3 = 1
            android.util.Pair r2 = r1.a((com.google.android.exoplayer2.m.d) r2, (boolean) r3)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r3 = 0
            r1.D = r3     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 != 0) goto L_0x0348
            r44.k()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x0348:
            java.lang.Object r3 = r2.second     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r3 = r3.longValue()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r7 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Object r2 = r2.first     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r2 = r7.a((java.lang.Object) r2, (long) r3)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x0358:
            r8 = r2
            r11 = r3
            goto L_0x03ef
        L_0x035c:
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x0398
            boolean r3 = r4.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r3 != 0) goto L_0x0398
            boolean r2 = r1.A     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r2 = r4.b(r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            android.util.Pair r2 = r1.a((com.google.android.exoplayer2.ah) r4, (int) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r3 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Object r4 = r2.first     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Object r7 = r2.second     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r7 = r7.longValue()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r3 = r3.a((java.lang.Object) r4, (long) r7)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r4 = r3.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 != 0) goto L_0x0394
            java.lang.Object r2 = r2.second     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r7 = r2.longValue()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0395
        L_0x0394:
            r7 = r5
        L_0x0395:
            r11 = r7
            r8 = r3
            goto L_0x03ef
        L_0x0398:
            java.lang.Object r3 = r2.f33224a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r3 = r4.a((java.lang.Object) r3)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r7 = -1
            if (r3 != r7) goto L_0x03cd
            java.lang.Object r2 = r2.f33224a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r3 = r21
            java.lang.Object r2 = r1.a((java.lang.Object) r2, (com.google.android.exoplayer2.ah) r3, (com.google.android.exoplayer2.ah) r4)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 != 0) goto L_0x03b0
            r44.k()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x03b0:
            com.google.android.exoplayer2.ah$a r3 = r1.k     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.ah$a r2 = r4.a((java.lang.Object) r2, (com.google.android.exoplayer2.ah.a) r3)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r2 = r2.f31125c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            android.util.Pair r2 = r1.a((com.google.android.exoplayer2.ah) r4, (int) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Object r3 = r2.second     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r3 = r3.longValue()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r7 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Object r2 = r2.first     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r2 = r7.a((java.lang.Object) r2, (long) r3)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0358
        L_0x03cd:
            com.google.android.exoplayer2.u r2 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r3 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r3 = r3.f33719c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Object r3 = r3.f33224a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r2 = r2.a((java.lang.Object) r3, (long) r5)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r3 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r3 = r3.f33719c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r3 = r3.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r3 != 0) goto L_0x03ed
            boolean r3 = r2.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r3 != 0) goto L_0x03ed
            com.google.android.exoplayer2.w r2 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r2 = r2.f33719c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x03ed:
            r8 = r2
            r11 = r5
        L_0x03ef:
            com.google.android.exoplayer2.w r2 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r2 = r2.f33719c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r2 = r2.equals(r8)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 == 0) goto L_0x0534
            int r2 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x0534
            com.google.android.exoplayer2.u r2 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r3 = r1.E     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r5 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r5 = r5.f33517e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r8 = -9223372036854775808
            if (r5 != 0) goto L_0x040c
            r16 = 0
            goto L_0x0445
        L_0x040c:
            long r6 = r5.f32778i     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r10 = r6
            r6 = 0
        L_0x0410:
            com.google.android.exoplayer2.ab[] r7 = r1.f32623c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r7 = r7.length     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r6 >= r7) goto L_0x0443
            com.google.android.exoplayer2.ab[] r7 = r1.f32623c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r7 = r7[r6]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r7 = r7.f_()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r7 == 0) goto L_0x0440
            com.google.android.exoplayer2.ab[] r7 = r1.f32623c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r7 = r7[r6]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.u r7 = r7.f()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.u[] r12 = r5.f32772c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r12 = r12[r6]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r7 != r12) goto L_0x0440
            com.google.android.exoplayer2.ab[] r7 = r1.f32623c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r7 = r7[r6]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r12 = r7.h()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r7 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x043c
            r16 = r8
            goto L_0x0445
        L_0x043c:
            long r10 = java.lang.Math.max(r12, r10)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x0440:
            int r6 = r6 + 1
            goto L_0x0410
        L_0x0443:
            r16 = r10
        L_0x0445:
            com.google.android.exoplayer2.s r5 = r2.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r7 = r5
            r5 = 0
        L_0x044b:
            if (r7 == 0) goto L_0x0527
            com.google.android.exoplayer2.t r6 = r7.f32775f     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            if (r5 != 0) goto L_0x0456
            com.google.android.exoplayer2.t r5 = r2.a((com.google.android.exoplayer2.t) r6)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0484
        L_0x0456:
            com.google.android.exoplayer2.t r10 = r2.a((com.google.android.exoplayer2.s) r5, (long) r3)     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            if (r10 != 0) goto L_0x0465
            boolean r2 = r2.a((com.google.android.exoplayer2.s) r5)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 == 0) goto L_0x0527
        L_0x0462:
            r1 = 0
            goto L_0x0528
        L_0x0465:
            long r11 = r6.f33412b     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            long r13 = r10.f33412b     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 != 0) goto L_0x0479
            com.google.android.exoplayer2.source.o$a r11 = r6.f33411a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r12 = r10.f33411a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r11 = r11.equals(r12)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r11 == 0) goto L_0x0479
            r11 = 1
            goto L_0x047a
        L_0x0479:
            r11 = 0
        L_0x047a:
            if (r11 != 0) goto L_0x0483
            boolean r2 = r2.a((com.google.android.exoplayer2.s) r5)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 == 0) goto L_0x0527
            goto L_0x0462
        L_0x0483:
            r5 = r10
        L_0x0484:
            long r10 = r6.f33413c     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            long r12 = r5.f33413c     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 != 0) goto L_0x0492
            r21 = r2
            r39 = r3
            r12 = r5
            goto L_0x04b7
        L_0x0492:
            com.google.android.exoplayer2.t r12 = new com.google.android.exoplayer2.t     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            com.google.android.exoplayer2.source.o$a r13 = r5.f33411a     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            long r14 = r5.f33412b     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            long r8 = r5.f33414d     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            r39 = r3
            long r3 = r5.f33415e     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            boolean r1 = r5.f33416f     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            r21 = r2
            boolean r2 = r5.f33417g     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            r25 = r12
            r26 = r13
            r27 = r14
            r29 = r10
            r31 = r8
            r33 = r3
            r35 = r1
            r36 = r2
            r25.<init>(r26, r27, r29, r31, r33, r35, r36)     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
        L_0x04b7:
            r7.f32775f = r12     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            long r1 = r6.f33415e     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            long r3 = r5.f33415e     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x04cd
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x04cb
            goto L_0x04cd
        L_0x04cb:
            r1 = 0
            goto L_0x04ce
        L_0x04cd:
            r1 = 1
        L_0x04ce:
            if (r1 != 0) goto L_0x0500
            long r1 = r5.f33415e     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x04df
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x04db:
            r2 = r1
            r1 = r21
            goto L_0x04e5
        L_0x04df:
            long r1 = r5.f33415e     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            long r3 = r7.f32778i     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            long r1 = r1 + r3
            goto L_0x04db
        L_0x04e5:
            com.google.android.exoplayer2.s r4 = r1.f33517e     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            if (r7 != r4) goto L_0x04f5
            r4 = -9223372036854775808
            int r6 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x04f3
            int r4 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x04f5
        L_0x04f3:
            r2 = 1
            goto L_0x04f6
        L_0x04f5:
            r2 = 0
        L_0x04f6:
            boolean r1 = r1.a((com.google.android.exoplayer2.s) r7)     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            if (r1 != 0) goto L_0x0462
            if (r2 == 0) goto L_0x0527
            goto L_0x0462
        L_0x0500:
            r1 = r21
            r4 = -9223372036854775808
            com.google.android.exoplayer2.s r2 = r7.f32776g     // Catch:{ i -> 0x051f, IOException -> 0x0517, RuntimeException -> 0x0512, OutOfMemoryError -> 0x0510 }
            r8 = r4
            r5 = r7
            r3 = r39
            r7 = r2
            r2 = r1
            r1 = r44
            goto L_0x044b
        L_0x0510:
            r0 = move-exception
            goto L_0x0513
        L_0x0512:
            r0 = move-exception
        L_0x0513:
            r1 = r44
            goto L_0x0b05
        L_0x0517:
            r0 = move-exception
            r2 = r0
            r3 = 0
            r4 = 2
            r1 = r44
            goto L_0x0b33
        L_0x051f:
            r0 = move-exception
            r2 = r0
            r3 = 0
            r4 = 2
            r1 = r44
            goto L_0x0b51
        L_0x0527:
            r1 = 1
        L_0x0528:
            if (r1 != 0) goto L_0x0531
            r2 = 0
            r1 = r44
            r1.c((boolean) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0571
        L_0x0531:
            r1 = r44
            goto L_0x0571
        L_0x0534:
            com.google.android.exoplayer2.u r2 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r2 = r2.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 == 0) goto L_0x0557
        L_0x053c:
            com.google.android.exoplayer2.s r3 = r2.f32776g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r3 == 0) goto L_0x0557
            com.google.android.exoplayer2.s r2 = r2.f32776g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.t r3 = r2.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r3 = r3.f33411a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r3 = r3.equals(r8)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r3 == 0) goto L_0x053c
            com.google.android.exoplayer2.u r3 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.t r4 = r2.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.t r3 = r3.a((com.google.android.exoplayer2.t) r4)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r2.f32775f = r3     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x053c
        L_0x0557:
            boolean r2 = r8.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 == 0) goto L_0x0560
            r2 = 0
            goto L_0x0561
        L_0x0560:
            r2 = r11
        L_0x0561:
            long r9 = r1.a((com.google.android.exoplayer2.source.o.a) r8, (long) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r7 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r13 = r44.m()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r2 = r7.a(r8, r9, r11, r13)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.t = r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x0571:
            r2 = 0
            r1.d((boolean) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x0577:
            r44.g()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r2 = 1
            return r2
        L_0x057c:
            int r2 = r2.arg1     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 == 0) goto L_0x0582
            r2 = 1
            goto L_0x0583
        L_0x0582:
            r2 = 0
        L_0x0583:
            r3 = 1
            r4 = 0
            r1.a((boolean) r4, (boolean) r2, (boolean) r3)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x058a:
            java.lang.Object r2 = r2.obj     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.af r2 = (com.google.android.exoplayer2.af) r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.s = r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x0592:
            java.lang.Object r2 = r2.obj     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.x r2 = (com.google.android.exoplayer2.x) r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.g r3 = r1.n     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r3.a((com.google.android.exoplayer2.x) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x059d:
            java.lang.Object r2 = r2.obj     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.m$d r2 = (com.google.android.exoplayer2.m.d) r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.m$c r3 = r1.o     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r4 = 1
            r3.a((int) r4)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            android.util.Pair r3 = r1.a((com.google.android.exoplayer2.m.d) r2, (boolean) r4)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r3 != 0) goto L_0x05c4
            com.google.android.exoplayer2.w r3 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r4 = r1.A     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.ah$b r5 = r1.j     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r3 = r3.a((boolean) r4, (com.google.android.exoplayer2.ah.b) r5)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r4 = r3
            r3 = 1
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r29 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x05f8
        L_0x05c4:
            java.lang.Object r4 = r3.first     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Object r5 = r3.second     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r12 = r5.longValue()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r5 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r4 = r5.a((java.lang.Object) r4, (long) r12)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r5 = r4.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r5 == 0) goto L_0x05e0
            r29 = r12
            r3 = 1
            r8 = 0
            goto L_0x05f8
        L_0x05e0:
            java.lang.Object r3 = r3.second     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r8 = r3.longValue()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r5 = r2.f32643c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r3 != 0) goto L_0x05f5
            r3 = 1
            goto L_0x05f6
        L_0x05f5:
            r3 = 0
        L_0x05f6:
            r29 = r12
        L_0x05f8:
            com.google.android.exoplayer2.source.o r5 = r1.u     // Catch:{ all -> 0x068e }
            if (r5 == 0) goto L_0x0674
            int r5 = r1.C     // Catch:{ all -> 0x068e }
            if (r5 <= 0) goto L_0x0602
            goto L_0x0674
        L_0x0602:
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0614
            r1.a((int) r11)     // Catch:{ all -> 0x068e }
            r2 = 1
            r5 = 0
            r1.a(r5, r5, r2, r5)     // Catch:{ all -> 0x068e }
            goto L_0x0676
        L_0x0614:
            com.google.android.exoplayer2.w r2 = r1.t     // Catch:{ all -> 0x068e }
            com.google.android.exoplayer2.source.o$a r2 = r2.f33719c     // Catch:{ all -> 0x068e }
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x068e }
            if (r2 == 0) goto L_0x0664
            com.google.android.exoplayer2.u r2 = r1.r     // Catch:{ all -> 0x068e }
            com.google.android.exoplayer2.s r2 = r2.f33516d     // Catch:{ all -> 0x068e }
            if (r2 == 0) goto L_0x0633
            r5 = 0
            int r7 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0633
            com.google.android.exoplayer2.source.n r2 = r2.f32770a     // Catch:{ all -> 0x068e }
            com.google.android.exoplayer2.af r5 = r1.s     // Catch:{ all -> 0x068e }
            long r5 = r2.a((long) r8, (com.google.android.exoplayer2.af) r5)     // Catch:{ all -> 0x068e }
            goto L_0x0634
        L_0x0633:
            r5 = r8
        L_0x0634:
            long r10 = com.google.android.exoplayer2.c.a(r5)     // Catch:{ all -> 0x068e }
            com.google.android.exoplayer2.w r2 = r1.t     // Catch:{ all -> 0x068e }
            long r12 = r2.m     // Catch:{ all -> 0x068e }
            long r12 = com.google.android.exoplayer2.c.a(r12)     // Catch:{ all -> 0x068e }
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0665
            com.google.android.exoplayer2.w r2 = r1.t     // Catch:{ all -> 0x068e }
            long r5 = r2.m     // Catch:{ all -> 0x068e }
            com.google.android.exoplayer2.w r2 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r31 = r44.m()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r25 = r2
            r26 = r4
            r27 = r5
            com.google.android.exoplayer2.w r2 = r25.a(r26, r27, r29, r31)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.t = r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r3 == 0) goto L_0x0af4
            com.google.android.exoplayer2.m$c r2 = r1.o     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r3 = 2
        L_0x065f:
            r2.b((int) r3)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x0664:
            r5 = r8
        L_0x0665:
            long r5 = r1.a((com.google.android.exoplayer2.source.o.a) r4, (long) r5)     // Catch:{ all -> 0x068e }
            int r2 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x066f
            r2 = 1
            goto L_0x0670
        L_0x066f:
            r2 = 0
        L_0x0670:
            r3 = r3 | r2
            r27 = r5
            goto L_0x0678
        L_0x0674:
            r1.D = r2     // Catch:{ all -> 0x068e }
        L_0x0676:
            r27 = r8
        L_0x0678:
            com.google.android.exoplayer2.w r2 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r31 = r44.m()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r25 = r2
            r26 = r4
            com.google.android.exoplayer2.w r2 = r25.a(r26, r27, r29, r31)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.t = r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r3 == 0) goto L_0x0af4
            com.google.android.exoplayer2.m$c r2 = r1.o     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r3 = 2
            goto L_0x065f
        L_0x068e:
            r0 = move-exception
            r2 = r0
            com.google.android.exoplayer2.w r5 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r31 = r44.m()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r25 = r5
            r26 = r4
            r27 = r8
            com.google.android.exoplayer2.w r4 = r25.a(r26, r27, r29, r31)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.t = r4     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r3 == 0) goto L_0x06b5
            com.google.android.exoplayer2.m$c r3 = r1.o     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r4 = 2
            r3.b((int) r4)     // Catch:{ i -> 0x06b0, IOException -> 0x06ab, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x06b5
        L_0x06ab:
            r0 = move-exception
            r2 = r0
            r3 = 0
            goto L_0x0b33
        L_0x06b0:
            r0 = move-exception
            r2 = r0
            r3 = 0
            goto L_0x0b51
        L_0x06b5:
            throw r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x06b6:
            r5 = 0
            com.google.android.exoplayer2.g.b r2 = r1.q     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r2 = r2.b()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o r4 = r1.u     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 == 0) goto L_0x0918
            int r4 = r1.C     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 <= 0) goto L_0x06cd
            com.google.android.exoplayer2.source.o r4 = r1.u     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r4.b()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0918
        L_0x06cd:
            com.google.android.exoplayer2.u r4 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r7 = r1.E     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r4.a((long) r7)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r4 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r7 = r4.f33518f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r7 == 0) goto L_0x0702
            com.google.android.exoplayer2.s r7 = r4.f33518f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.t r7 = r7.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r7 = r7.f33417g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r7 != 0) goto L_0x0700
            com.google.android.exoplayer2.s r7 = r4.f33518f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r7 = r7.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r7 == 0) goto L_0x0700
            com.google.android.exoplayer2.s r7 = r4.f33518f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.t r7 = r7.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r7 = r7.f33415e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r9 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r9 == 0) goto L_0x0700
            int r4 = r4.f33519g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r7 = 100
            if (r4 >= r7) goto L_0x0700
            goto L_0x0702
        L_0x0700:
            r4 = 0
            goto L_0x0703
        L_0x0702:
            r4 = 1
        L_0x0703:
            if (r4 == 0) goto L_0x07b3
            com.google.android.exoplayer2.u r12 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r7 = r1.E     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r4 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r9 = r12.f33518f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r9 != 0) goto L_0x071c
            com.google.android.exoplayer2.source.o$a r13 = r4.f33719c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r14 = r4.f33721e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r7 = r4.f33720d     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r16 = r7
            com.google.android.exoplayer2.t r4 = r12.a((com.google.android.exoplayer2.source.o.a) r13, (long) r14, (long) r16)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0722
        L_0x071c:
            com.google.android.exoplayer2.s r4 = r12.f33518f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.t r4 = r12.a((com.google.android.exoplayer2.s) r4, (long) r7)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x0722:
            if (r4 != 0) goto L_0x0742
            com.google.android.exoplayer2.u r4 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r4 = r4.f33518f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 == 0) goto L_0x073b
            com.google.android.exoplayer2.ab[] r4 = r1.v     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r5 = r4.length     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r6 = 0
        L_0x072e:
            if (r6 >= r5) goto L_0x073b
            r7 = r4[r6]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r7 = r7.g()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r7 == 0) goto L_0x07b3
            int r6 = r6 + 1
            goto L_0x072e
        L_0x073b:
            com.google.android.exoplayer2.source.o r4 = r1.u     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r4.b()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x07b3
        L_0x0742:
            com.google.android.exoplayer2.u r7 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.ac[] r8 = r1.f32624d     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.trackselection.i r9 = r1.f32625e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.q r12 = r1.f32627g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.f.b r30 = r12.d()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o r12 = r1.u     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r13 = r7.f33518f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r13 != 0) goto L_0x076c
            com.google.android.exoplayer2.source.o$a r13 = r4.f33411a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r13 = r13.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r13 == 0) goto L_0x0769
            long r13 = r4.f33413c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r15 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 == 0) goto L_0x0769
            long r5 = r4.f33413c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x0769:
            r27 = r5
            goto L_0x077b
        L_0x076c:
            com.google.android.exoplayer2.s r5 = r7.f33518f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r5 = r5.f32778i     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r13 = r7.f33518f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.t r13 = r13.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r13 = r13.f33415e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r5 = r5 + r13
            long r13 = r4.f33412b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r5 = r5 - r13
            goto L_0x0769
        L_0x077b:
            com.google.android.exoplayer2.s r5 = new com.google.android.exoplayer2.s     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r25 = r5
            r26 = r8
            r29 = r9
            r31 = r12
            r32 = r4
            r25.<init>(r26, r27, r29, r30, r31, r32)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r6 = r7.f33518f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r6 == 0) goto L_0x079a
            boolean r6 = r7.b()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.g.a.b(r6)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r6 = r7.f33518f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r6.a((com.google.android.exoplayer2.s) r5)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x079a:
            r6 = 0
            r7.f33520h = r6     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r7.f33518f = r5     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r6 = r7.f33519g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r8 = 1
            int r6 = r6 + r8
            r7.f33519g = r6     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.n r5 = r5.f32770a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r6 = r4.f33412b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r5.a((com.google.android.exoplayer2.source.n.a) r1, (long) r6)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.b((boolean) r8)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r4 = 0
            r1.d((boolean) r4)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x07b3:
            com.google.android.exoplayer2.u r4 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r4 = r4.f33518f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 == 0) goto L_0x07ca
            boolean r4 = r4.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 == 0) goto L_0x07c0
            goto L_0x07ca
        L_0x07c0:
            com.google.android.exoplayer2.w r4 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r4 = r4.f33723g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 != 0) goto L_0x07ce
            r44.l()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x07ce
        L_0x07ca:
            r4 = 0
            r1.b((boolean) r4)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x07ce:
            com.google.android.exoplayer2.u r4 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r4 = r4.b()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 == 0) goto L_0x0918
            com.google.android.exoplayer2.u r4 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r4 = r4.f33516d     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r5 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r5 = r5.f33517e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r6 = 0
        L_0x07df:
            boolean r7 = r1.x     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r7 == 0) goto L_0x0836
            if (r4 == r5) goto L_0x0836
            long r7 = r1.E     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r9 = r4.f32776g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.t r12 = r9.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r12 = r12.f33412b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r14 = r9.f32778i     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r12 = r12 + r14
            int r9 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r9 < 0) goto L_0x0836
            if (r6 == 0) goto L_0x07f9
            r44.c()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x07f9:
            com.google.android.exoplayer2.t r6 = r4.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r6 = r6.f33416f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r6 == 0) goto L_0x0801
            r6 = 0
            goto L_0x0802
        L_0x0801:
            r6 = 3
        L_0x0802:
            com.google.android.exoplayer2.u r7 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r7 = r7.c()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.a((com.google.android.exoplayer2.s) r4)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r4 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.t r8 = r7.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o$a r8 = r8.f33411a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.t r9 = r7.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r12 = r9.f33412b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.t r9 = r7.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r14 = r9.f33413c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r31 = r44.m()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r25 = r4
            r26 = r8
            r27 = r12
            r29 = r14
            com.google.android.exoplayer2.w r4 = r25.a(r26, r27, r29, r31)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.t = r4     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.m$c r4 = r1.o     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r4.b((int) r6)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r44.f()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r4 = r7
            r6 = 1
            goto L_0x07df
        L_0x0836:
            com.google.android.exoplayer2.t r4 = r5.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r4 = r4.f33417g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 == 0) goto L_0x085e
            r4 = 0
        L_0x083d:
            com.google.android.exoplayer2.ab[] r6 = r1.f32623c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r6 = r6.length     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 >= r6) goto L_0x0918
            com.google.android.exoplayer2.ab[] r6 = r1.f32623c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r6 = r6[r4]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.u[] r7 = r5.f32772c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r7 = r7[r4]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r7 == 0) goto L_0x085b
            com.google.android.exoplayer2.source.u r8 = r6.f()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r8 != r7) goto L_0x085b
            boolean r7 = r6.g()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r7 == 0) goto L_0x085b
            r6.i()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x085b:
            int r4 = r4 + 1
            goto L_0x083d
        L_0x085e:
            com.google.android.exoplayer2.s r4 = r5.f32776g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 == 0) goto L_0x0918
            r4 = 0
        L_0x0863:
            com.google.android.exoplayer2.ab[] r6 = r1.f32623c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r6 = r6.length     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 >= r6) goto L_0x0883
            com.google.android.exoplayer2.ab[] r6 = r1.f32623c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r6 = r6[r4]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.u[] r7 = r5.f32772c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r7 = r7[r4]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.u r8 = r6.f()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r8 != r7) goto L_0x0918
            if (r7 == 0) goto L_0x0880
            boolean r6 = r6.g()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r6 != 0) goto L_0x0880
            goto L_0x0918
        L_0x0880:
            int r4 = r4 + 1
            goto L_0x0863
        L_0x0883:
            com.google.android.exoplayer2.s r4 = r5.f32776g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r4 = r4.f32773d     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 != 0) goto L_0x088e
            r44.j()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0918
        L_0x088e:
            com.google.android.exoplayer2.trackselection.j r4 = r5.f()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.u r5 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r6 = r5.f33517e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r6 == 0) goto L_0x08a0
            com.google.android.exoplayer2.s r6 = r5.f33517e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r6 = r6.f32776g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r6 == 0) goto L_0x08a0
            r6 = 1
            goto L_0x08a1
        L_0x08a0:
            r6 = 0
        L_0x08a1:
            com.google.android.exoplayer2.g.a.b(r6)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r6 = r5.f33517e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r6 = r6.f32776g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r5.f33517e = r6     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r5 = r5.f33517e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.trackselection.j r6 = r5.f()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.n r7 = r5.f32770a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r7 = r7.c()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r9 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r9 == 0) goto L_0x08c1
            r7 = 1
            goto L_0x08c2
        L_0x08c1:
            r7 = 0
        L_0x08c2:
            r8 = 0
        L_0x08c3:
            com.google.android.exoplayer2.ab[] r9 = r1.f32623c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r9 = r9.length     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r8 >= r9) goto L_0x0918
            com.google.android.exoplayer2.ab[] r9 = r1.f32623c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r9 = r9[r8]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r12 = r4.a((int) r8)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r12 == 0) goto L_0x0915
            if (r7 != 0) goto L_0x0912
            boolean r12 = r9.j()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r12 != 0) goto L_0x0915
            com.google.android.exoplayer2.trackselection.g r12 = r6.f33511c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.trackselection.f[] r12 = r12.f33505b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r12 = r12[r8]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r13 = r6.a((int) r8)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.ac[] r14 = r1.f32624d     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r14 = r14[r8]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r14 = r14.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r15 = 6
            if (r14 != r15) goto L_0x08f1
            r14 = 1
            goto L_0x08f2
        L_0x08f1:
            r14 = 0
        L_0x08f2:
            com.google.android.exoplayer2.ad[] r15 = r4.f33510b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r15 = r15[r8]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.ad[] r10 = r6.f33510b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r10 = r10[r8]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r13 == 0) goto L_0x0912
            boolean r10 = r10.equals(r15)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r10 == 0) goto L_0x0912
            if (r14 != 0) goto L_0x0912
            com.google.android.exoplayer2.Format[] r10 = a((com.google.android.exoplayer2.trackselection.f) r12)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.u[] r12 = r5.f32772c     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r12 = r12[r8]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r13 = r5.f32778i     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r9.a(r10, r12, r13)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0915
        L_0x0912:
            r9.i()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x0915:
            int r8 = r8 + 1
            goto L_0x08c3
        L_0x0918:
            com.google.android.exoplayer2.u r4 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r4 = r4.b()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r5 = 10
            if (r4 != 0) goto L_0x092a
            r44.j()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.a((long) r2, (long) r5)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x092a:
            com.google.android.exoplayer2.u r4 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r4 = r4.f33516d     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            java.lang.String r7 = "doSomeWork"
            com.google.android.exoplayer2.g.ac.a(r7)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r44.f()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r9 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r9
            com.google.android.exoplayer2.source.n r12 = r4.f32770a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.w r13 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r13 = r13.m     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r9 = r1.l     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r13 = r13 - r9
            boolean r9 = r1.m     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r12.a((long) r13, (boolean) r9)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.ab[] r9 = r1.v     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r10 = r9.length     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r12 = 0
            r13 = 1
            r14 = 1
        L_0x0952:
            if (r12 >= r10) goto L_0x099e
            r15 = r9[r12]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r5 = r1.E     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r15.a(r5, r7)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r14 == 0) goto L_0x0965
            boolean r5 = r15.u()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r5 == 0) goto L_0x0965
            r14 = 1
            goto L_0x0966
        L_0x0965:
            r14 = 0
        L_0x0966:
            boolean r5 = r15.t()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r5 != 0) goto L_0x098c
            boolean r5 = r15.u()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r5 != 0) goto L_0x098c
            com.google.android.exoplayer2.u r5 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r5 = r5.f33517e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r5 = r5.f32776g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r5 == 0) goto L_0x0986
            boolean r5 = r5.f32773d     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r5 == 0) goto L_0x0986
            boolean r5 = r15.g()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r5 == 0) goto L_0x0986
            r5 = 1
            goto L_0x0987
        L_0x0986:
            r5 = 0
        L_0x0987:
            if (r5 == 0) goto L_0x098a
            goto L_0x098c
        L_0x098a:
            r5 = 0
            goto L_0x098d
        L_0x098c:
            r5 = 1
        L_0x098d:
            if (r5 != 0) goto L_0x0992
            r15.k()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x0992:
            if (r13 == 0) goto L_0x0998
            if (r5 == 0) goto L_0x0998
            r13 = 1
            goto L_0x0999
        L_0x0998:
            r13 = 0
        L_0x0999:
            int r12 = r12 + 1
            r5 = 10
            goto L_0x0952
        L_0x099e:
            if (r13 != 0) goto L_0x09a3
            r44.j()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x09a3:
            com.google.android.exoplayer2.t r5 = r4.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r5 = r5.f33415e     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r14 == 0) goto L_0x09c8
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x09ba
            com.google.android.exoplayer2.w r7 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r7 = r7.m     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x09c8
        L_0x09ba:
            com.google.android.exoplayer2.t r4 = r4.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r4 = r4.f33417g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 == 0) goto L_0x09c8
            r1.a((int) r11)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r44.e()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0a3e
        L_0x09c8:
            com.google.android.exoplayer2.w r4 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r4 = r4.f33722f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r5 = 2
            if (r4 != r5) goto L_0x0a1e
            com.google.android.exoplayer2.ab[] r4 = r1.v     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r4 = r4.length     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 != 0) goto L_0x09d9
            boolean r4 = r44.i()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0a10
        L_0x09d9:
            if (r13 == 0) goto L_0x0a0f
            com.google.android.exoplayer2.w r4 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r4 = r4.f33723g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 != 0) goto L_0x09e3
        L_0x09e1:
            r4 = 1
            goto L_0x0a10
        L_0x09e3:
            com.google.android.exoplayer2.u r4 = r1.r     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.s r4 = r4.f33518f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r5 = r4.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r5 == 0) goto L_0x09f5
            com.google.android.exoplayer2.t r4 = r4.f32775f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r4 = r4.f33417g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 == 0) goto L_0x09f5
            r4 = 1
            goto L_0x09f6
        L_0x09f5:
            r4 = 0
        L_0x09f6:
            if (r4 != 0) goto L_0x09e1
            com.google.android.exoplayer2.q r4 = r1.f32627g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            long r5 = r44.m()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.g r7 = r1.n     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.x r7 = r7.e()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            float r7 = r7.f33727b     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r8 = r1.y     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r4 = r4.a(r5, r7, r8)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 == 0) goto L_0x0a0f
            goto L_0x09e1
        L_0x0a0f:
            r4 = 0
        L_0x0a10:
            if (r4 == 0) goto L_0x0a1e
            r4 = 3
            r1.a((int) r4)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            boolean r4 = r1.x     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 == 0) goto L_0x0a3e
            r44.d()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0a3e
        L_0x0a1e:
            com.google.android.exoplayer2.w r4 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r4 = r4.f33722f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r5 = 3
            if (r4 != r5) goto L_0x0a3e
            com.google.android.exoplayer2.ab[] r4 = r1.v     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r4 = r4.length     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 != 0) goto L_0x0a31
            boolean r4 = r44.i()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 == 0) goto L_0x0a33
            goto L_0x0a3e
        L_0x0a31:
            if (r13 != 0) goto L_0x0a3e
        L_0x0a33:
            boolean r4 = r1.x     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.y = r4     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r4 = 2
            r1.a((int) r4)     // Catch:{ i -> 0x06b0, IOException -> 0x06ab, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r44.e()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x0a3e:
            com.google.android.exoplayer2.w r4 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r4 = r4.f33722f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r5 = 2
            if (r4 != r5) goto L_0x0a53
            com.google.android.exoplayer2.ab[] r4 = r1.v     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r5 = r4.length     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r6 = 0
        L_0x0a49:
            if (r6 >= r5) goto L_0x0a53
            r7 = r4[r6]     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r7.k()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r6 = r6 + 1
            goto L_0x0a49
        L_0x0a53:
            boolean r4 = r1.x     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 == 0) goto L_0x0a5e
            com.google.android.exoplayer2.w r4 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r4 = r4.f33722f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r5 = 3
            if (r4 == r5) goto L_0x0a65
        L_0x0a5e:
            com.google.android.exoplayer2.w r4 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r4 = r4.f33722f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r5 = 2
            if (r4 != r5) goto L_0x0a6b
        L_0x0a65:
            r4 = 10
            r1.a((long) r2, (long) r4)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0a81
        L_0x0a6b:
            com.google.android.exoplayer2.ab[] r4 = r1.v     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r4 = r4.length     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 == 0) goto L_0x0a7c
            com.google.android.exoplayer2.w r4 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r4 = r4.f33722f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 == r11) goto L_0x0a7c
            r4 = 1000(0x3e8, double:4.94E-321)
            r1.a((long) r2, (long) r4)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0a81
        L_0x0a7c:
            com.google.android.exoplayer2.g.k r2 = r1.f32621a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r2.b()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x0a81:
            com.google.android.exoplayer2.g.ac.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x0a86:
            int r2 = r2.arg1     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 == 0) goto L_0x0a8c
            r2 = 1
            goto L_0x0a8d
        L_0x0a8c:
            r2 = 0
        L_0x0a8d:
            r3 = 0
            r1.y = r3     // Catch:{ i -> 0x0abc, IOException -> 0x0ab9, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.x = r2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 != 0) goto L_0x0a9b
            r44.e()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r44.f()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x0a9b:
            com.google.android.exoplayer2.w r2 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r2 = r2.f33722f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r3 = 3
            if (r2 != r3) goto L_0x0aac
            r44.d()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.g.k r2 = r1.f32621a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r3 = 2
            r2.a((int) r3)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x0aac:
            com.google.android.exoplayer2.w r2 = r1.t     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r2 = r2.f33722f     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r3 = 2
            if (r2 != r3) goto L_0x0af4
            com.google.android.exoplayer2.g.k r2 = r1.f32621a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r2.a((int) r3)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0af4
        L_0x0ab9:
            r0 = move-exception
            r2 = r0
            goto L_0x0afb
        L_0x0abc:
            r0 = move-exception
            r2 = r0
            goto L_0x0b00
        L_0x0abf:
            java.lang.Object r3 = r2.obj     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.source.o r3 = (com.google.android.exoplayer2.source.o) r3     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            int r4 = r2.arg1     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r4 == 0) goto L_0x0ac9
            r4 = 1
            goto L_0x0aca
        L_0x0ac9:
            r4 = 0
        L_0x0aca:
            int r2 = r2.arg2     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            if (r2 == 0) goto L_0x0ad0
            r2 = 1
            goto L_0x0ad1
        L_0x0ad0:
            r2 = 0
        L_0x0ad1:
            int r5 = r1.C     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r6 = 1
            int r5 = r5 + r6
            r1.C = r5     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r5 = 0
            r1.a(r5, r6, r4, r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.q r2 = r1.f32627g     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r2.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r1.u = r3     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r2 = 2
            r1.a((int) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.f.d r4 = r1.f32628h     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.f.ad r4 = r4.a()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r3.a((com.google.android.exoplayer2.source.o.b) r1, (com.google.android.exoplayer2.f.ad) r4)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            com.google.android.exoplayer2.g.k r3 = r1.f32621a     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            r3.a((int) r2)     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
        L_0x0af4:
            r44.c()     // Catch:{ i -> 0x0afd, IOException -> 0x0af8, RuntimeException -> 0x0b04, OutOfMemoryError -> 0x0b02 }
            goto L_0x0b4b
        L_0x0af8:
            r0 = move-exception
            r2 = r0
            r3 = 0
        L_0x0afb:
            r4 = 2
            goto L_0x0b33
        L_0x0afd:
            r0 = move-exception
            r2 = r0
            r3 = 0
        L_0x0b00:
            r4 = 2
            goto L_0x0b51
        L_0x0b02:
            r0 = move-exception
            goto L_0x0b05
        L_0x0b04:
            r0 = move-exception
        L_0x0b05:
            r2 = r0
            java.lang.String r3 = "Internal runtime error."
            com.google.android.exoplayer2.g.l.b(r3, r2)
            boolean r3 = r2 instanceof java.lang.OutOfMemoryError
            if (r3 == 0) goto L_0x0b16
            java.lang.OutOfMemoryError r2 = (java.lang.OutOfMemoryError) r2
            com.google.android.exoplayer2.i r2 = com.google.android.exoplayer2.i.createForOutOfMemoryError(r2)
            goto L_0x0b1c
        L_0x0b16:
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2
            com.google.android.exoplayer2.i r2 = com.google.android.exoplayer2.i.createForUnexpected(r2)
        L_0x0b1c:
            android.os.Handler r3 = r1.f32629i
            r4 = 2
            android.os.Message r2 = r3.obtainMessage(r4, r2)
            r2.sendToTarget()
            r2 = 1
            r3 = 0
            r1.a((boolean) r2, (boolean) r3, (boolean) r3)
            r44.c()
            goto L_0x0b4b
        L_0x0b2f:
            r0 = move-exception
            r3 = 0
            r4 = 2
            r2 = r0
        L_0x0b33:
            java.lang.String r5 = "Source error."
            com.google.android.exoplayer2.g.l.b(r5, r2)
            android.os.Handler r5 = r1.f32629i
            com.google.android.exoplayer2.i r2 = com.google.android.exoplayer2.i.createForSource(r2)
            android.os.Message r2 = r5.obtainMessage(r4, r2)
            r2.sendToTarget()
            r1.a((boolean) r3, (boolean) r3, (boolean) r3)
            r44.c()
        L_0x0b4b:
            r2 = 1
            goto L_0x0b66
        L_0x0b4d:
            r0 = move-exception
            r3 = 0
            r4 = 2
            r2 = r0
        L_0x0b51:
            java.lang.String r5 = "Playback error."
            com.google.android.exoplayer2.g.l.b(r5, r2)
            android.os.Handler r5 = r1.f32629i
            android.os.Message r2 = r5.obtainMessage(r4, r2)
            r2.sendToTarget()
            r2 = 1
            r1.a((boolean) r2, (boolean) r3, (boolean) r3)
            r44.c()
        L_0x0b66:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.m.handleMessage(android.os.Message):boolean");
    }

    private void a(int i2) {
        if (this.t.f33722f != i2) {
            this.t = this.t.a(i2);
        }
    }

    private void b(boolean z2) {
        if (this.t.f33723g != z2) {
            this.t = this.t.a(z2);
        }
    }

    private void c() {
        int i2;
        if (this.o.a(this.t)) {
            Handler handler = this.f32629i;
            int i3 = this.o.f32637a;
            if (this.o.f32638b) {
                i2 = this.o.f32639c;
            } else {
                i2 = -1;
            }
            handler.obtainMessage(0, i3, i2, this.t).sendToTarget();
            this.o.b(this.t);
        }
    }

    private void c(boolean z2) throws i {
        o.a aVar = this.r.f33516d.f32775f.f33411a;
        long a2 = a(aVar, this.t.m, true);
        if (a2 != this.t.m) {
            w wVar = this.t;
            this.t = wVar.a(aVar, a2, wVar.f33721e, m());
            if (z2) {
                this.o.b(4);
            }
        }
    }

    private void d() throws i {
        this.y = false;
        this.n.a();
        for (ab g_ : this.v) {
            g_.g_();
        }
    }

    private void e() throws i {
        this.n.b();
        for (ab a2 : this.v) {
            a(a2);
        }
    }

    private void f() throws i {
        if (this.r.b()) {
            s sVar = this.r.f33516d;
            long c2 = sVar.f32770a.c();
            if (c2 != -9223372036854775807L) {
                a(c2);
                if (c2 != this.t.m) {
                    w wVar = this.t;
                    this.t = wVar.a(wVar.f33719c, c2, this.t.f33721e, m());
                    this.o.b(4);
                }
            } else {
                this.E = this.n.c();
                long j2 = this.E - sVar.f32778i;
                b(this.t.m, j2);
                this.t.m = j2;
            }
            s sVar2 = this.r.f33518f;
            this.t.k = sVar2.b();
            this.t.l = m();
        }
    }

    private void a(long j2, long j3) {
        this.f32621a.b();
        this.f32621a.a(j2 + j3);
    }

    private long a(o.a aVar, long j2) throws i {
        return a(aVar, j2, this.r.f33516d != this.r.f33517e);
    }

    private long a(o.a aVar, long j2, boolean z2) throws i {
        e();
        this.y = false;
        a(2);
        s sVar = this.r.f33516d;
        s sVar2 = sVar;
        while (true) {
            if (sVar2 != null) {
                if (aVar.equals(sVar2.f32775f.f33411a) && sVar2.f32773d) {
                    this.r.a(sVar2);
                    break;
                }
                sVar2 = this.r.c();
            } else {
                break;
            }
        }
        if (z2 || sVar != sVar2 || (sVar2 != null && sVar2.f32778i + j2 < 0)) {
            for (ab b2 : this.v) {
                b(b2);
            }
            this.v = new ab[0];
            sVar = null;
            if (sVar2 != null) {
                sVar2.f32778i = 0;
            }
        }
        if (sVar2 != null) {
            a(sVar);
            if (sVar2.f32774e) {
                long b3 = sVar2.f32770a.b(j2);
                sVar2.f32770a.a(b3 - this.l, this.m);
                j2 = b3;
            }
            a(j2);
            l();
        } else {
            this.r.a(true);
            this.t = this.t.a(TrackGroupArray.f32783a, this.f32626f);
            a(j2);
        }
        d(false);
        this.f32621a.a(2);
        return j2;
    }

    private void a(long j2) throws i {
        if (this.r.b()) {
            j2 += this.r.f33516d.f32778i;
        }
        this.E = j2;
        this.n.a(this.E);
        for (ab a2 : this.v) {
            a2.a(this.E);
        }
        h();
    }

    private void a(boolean z2, AtomicBoolean atomicBoolean) {
        if (this.B != z2) {
            this.B = z2;
            if (!z2) {
                for (ab abVar : this.f32623c) {
                    if (abVar.f_() == 0) {
                        abVar.n();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void a(boolean z2, boolean z3, boolean z4) {
        a(z2 || !this.B, true, z3, z3);
        this.o.a(this.C + (z4 ? 1 : 0));
        this.C = 0;
        this.f32627g.b();
        a(1);
    }

    private void g() {
        a(true, true, true, true);
        this.f32627g.c();
        a(1);
        this.f32622b.quit();
        synchronized (this) {
            this.w = true;
            notifyAll();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(boolean r24, boolean r25, boolean r26, boolean r27) {
        /*
            r23 = this;
            r1 = r23
            com.google.android.exoplayer2.g.k r0 = r1.f32621a
            r0.b()
            r2 = 0
            r1.y = r2
            com.google.android.exoplayer2.g r0 = r1.n
            r0.b()
            r3 = 0
            r1.E = r3
            com.google.android.exoplayer2.ab[] r3 = r1.v
            int r4 = r3.length
            r5 = 0
        L_0x0017:
            if (r5 >= r4) goto L_0x002a
            r0 = r3[r5]
            r1.b((com.google.android.exoplayer2.ab) r0)     // Catch:{ i -> 0x0021, RuntimeException -> 0x001f }
            goto L_0x0027
        L_0x001f:
            r0 = move-exception
            goto L_0x0022
        L_0x0021:
            r0 = move-exception
        L_0x0022:
            java.lang.String r6 = "Disable failed."
            com.google.android.exoplayer2.g.l.b(r6, r0)
        L_0x0027:
            int r5 = r5 + 1
            goto L_0x0017
        L_0x002a:
            if (r24 == 0) goto L_0x0042
            com.google.android.exoplayer2.ab[] r3 = r1.f32623c
            int r4 = r3.length
            r5 = 0
        L_0x0030:
            if (r5 >= r4) goto L_0x0042
            r0 = r3[r5]
            r0.n()     // Catch:{ RuntimeException -> 0x0038 }
            goto L_0x003f
        L_0x0038:
            r0 = move-exception
            r6 = r0
            java.lang.String r0 = "Reset failed."
            com.google.android.exoplayer2.g.l.b(r0, r6)
        L_0x003f:
            int r5 = r5 + 1
            goto L_0x0030
        L_0x0042:
            com.google.android.exoplayer2.ab[] r0 = new com.google.android.exoplayer2.ab[r2]
            r1.v = r0
            r0 = 0
            if (r26 == 0) goto L_0x004c
            r1.D = r0
            goto L_0x0083
        L_0x004c:
            if (r27 == 0) goto L_0x0083
            com.google.android.exoplayer2.m$d r3 = r1.D
            if (r3 != 0) goto L_0x0081
            com.google.android.exoplayer2.w r3 = r1.t
            com.google.android.exoplayer2.ah r3 = r3.f33717a
            boolean r3 = r3.a()
            if (r3 != 0) goto L_0x0081
            com.google.android.exoplayer2.w r3 = r1.t
            com.google.android.exoplayer2.ah r3 = r3.f33717a
            com.google.android.exoplayer2.w r4 = r1.t
            com.google.android.exoplayer2.source.o$a r4 = r4.f33719c
            java.lang.Object r4 = r4.f33224a
            com.google.android.exoplayer2.ah$a r5 = r1.k
            r3.a((java.lang.Object) r4, (com.google.android.exoplayer2.ah.a) r5)
            com.google.android.exoplayer2.w r3 = r1.t
            long r3 = r3.m
            com.google.android.exoplayer2.ah$a r5 = r1.k
            long r5 = r5.f31127e
            long r3 = r3 + r5
            com.google.android.exoplayer2.m$d r5 = new com.google.android.exoplayer2.m$d
            com.google.android.exoplayer2.ah r6 = com.google.android.exoplayer2.ah.f31122a
            com.google.android.exoplayer2.ah$a r7 = r1.k
            int r7 = r7.f31125c
            r5.<init>(r6, r7, r3)
            r1.D = r5
        L_0x0081:
            r3 = 1
            goto L_0x0085
        L_0x0083:
            r3 = r26
        L_0x0085:
            com.google.android.exoplayer2.u r4 = r1.r
            r5 = r3 ^ 1
            r4.a((boolean) r5)
            r1.b((boolean) r2)
            if (r27 == 0) goto L_0x00b6
            com.google.android.exoplayer2.u r4 = r1.r
            com.google.android.exoplayer2.ah r5 = com.google.android.exoplayer2.ah.f31122a
            r4.f33513a = r5
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r4 = r1.p
            java.util.Iterator r4 = r4.iterator()
        L_0x009d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00af
            java.lang.Object r5 = r4.next()
            com.google.android.exoplayer2.m$b r5 = (com.google.android.exoplayer2.m.b) r5
            com.google.android.exoplayer2.aa r5 = r5.f32633a
            r5.a((boolean) r2)
            goto L_0x009d
        L_0x00af:
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r4 = r1.p
            r4.clear()
            r1.F = r2
        L_0x00b6:
            if (r3 == 0) goto L_0x00c3
            com.google.android.exoplayer2.w r2 = r1.t
            boolean r4 = r1.A
            com.google.android.exoplayer2.ah$b r5 = r1.j
            com.google.android.exoplayer2.source.o$a r2 = r2.a((boolean) r4, (com.google.android.exoplayer2.ah.b) r5)
            goto L_0x00c7
        L_0x00c3:
            com.google.android.exoplayer2.w r2 = r1.t
            com.google.android.exoplayer2.source.o$a r2 = r2.f33719c
        L_0x00c7:
            r16 = r2
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r3 == 0) goto L_0x00d3
            r21 = r4
            goto L_0x00d9
        L_0x00d3:
            com.google.android.exoplayer2.w r2 = r1.t
            long r6 = r2.m
            r21 = r6
        L_0x00d9:
            if (r3 == 0) goto L_0x00dd
            r10 = r4
            goto L_0x00e2
        L_0x00dd:
            com.google.android.exoplayer2.w r2 = r1.t
            long r2 = r2.f33721e
            r10 = r2
        L_0x00e2:
            com.google.android.exoplayer2.w r2 = new com.google.android.exoplayer2.w
            if (r27 == 0) goto L_0x00e9
            com.google.android.exoplayer2.ah r3 = com.google.android.exoplayer2.ah.f31122a
            goto L_0x00ed
        L_0x00e9:
            com.google.android.exoplayer2.w r3 = r1.t
            com.google.android.exoplayer2.ah r3 = r3.f33717a
        L_0x00ed:
            r5 = r3
            if (r27 == 0) goto L_0x00f2
            r6 = r0
            goto L_0x00f7
        L_0x00f2:
            com.google.android.exoplayer2.w r3 = r1.t
            java.lang.Object r3 = r3.f33718b
            r6 = r3
        L_0x00f7:
            com.google.android.exoplayer2.w r3 = r1.t
            int r12 = r3.f33722f
            r13 = 0
            if (r27 == 0) goto L_0x0101
            com.google.android.exoplayer2.source.TrackGroupArray r3 = com.google.android.exoplayer2.source.TrackGroupArray.f32783a
            goto L_0x0105
        L_0x0101:
            com.google.android.exoplayer2.w r3 = r1.t
            com.google.android.exoplayer2.source.TrackGroupArray r3 = r3.f33724h
        L_0x0105:
            r14 = r3
            if (r27 == 0) goto L_0x010b
            com.google.android.exoplayer2.trackselection.j r3 = r1.f32626f
            goto L_0x010f
        L_0x010b:
            com.google.android.exoplayer2.w r3 = r1.t
            com.google.android.exoplayer2.trackselection.j r3 = r3.f33725i
        L_0x010f:
            r15 = r3
            r19 = 0
            r4 = r2
            r7 = r16
            r8 = r21
            r17 = r21
            r4.<init>(r5, r6, r7, r8, r10, r12, r13, r14, r15, r16, r17, r19, r21)
            r1.t = r2
            if (r25 == 0) goto L_0x0129
            com.google.android.exoplayer2.source.o r2 = r1.u
            if (r2 == 0) goto L_0x0129
            r2.a((com.google.android.exoplayer2.source.o.b) r1)
            r1.u = r0
        L_0x0129:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.m.a(boolean, boolean, boolean, boolean):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(aa aaVar) {
        try {
            c(aaVar);
        } catch (i e2) {
            l.b("Unexpected error delivering message on external thread.", e2);
            throw new RuntimeException(e2);
        }
    }

    private static void c(aa aaVar) throws i {
        if (!aaVar.b()) {
            try {
                aaVar.f31095a.a(aaVar.f31097c, aaVar.f31098d);
            } finally {
                aaVar.a(true);
            }
        }
    }

    private boolean a(b bVar) {
        if (bVar.f32636d == null) {
            Pair<Object, Long> a2 = a(new d(bVar.f32633a.f31096b, bVar.f32633a.f31100f, c.b(bVar.f32633a.f31101g)), false);
            if (a2 == null) {
                return false;
            }
            bVar.a(this.t.f33717a.a(a2.first), ((Long) a2.second).longValue(), a2.first);
            return true;
        }
        int a3 = this.t.f33717a.a(bVar.f32636d);
        if (a3 == -1) {
            return false;
        }
        bVar.f32634b = a3;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063 A[EDGE_INSN: B:67:0x0063->B:21:0x0063 ?: BREAK  
    EDGE_INSN: B:68:0x0063->B:21:0x0063 ?: BREAK  
    EDGE_INSN: B:69:0x0063->B:21:0x0063 ?: BREAK  ] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00be A[SYNTHETIC, Splitter:B:46:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00a8 A[EDGE_INSN: B:71:0x00a8->B:85:0x00a8 ?: BREAK  
    EDGE_INSN: B:72:0x00a8->B:85:0x00a8 ?: BREAK  
    EDGE_INSN: B:74:0x00a8->B:85:0x00a8 ?: BREAK  
    EDGE_INSN: B:75:0x00a8->B:85:0x00a8 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(long r7, long r9) throws com.google.android.exoplayer2.i {
        /*
            r6 = this;
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r0 = r6.p
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0116
            com.google.android.exoplayer2.w r0 = r6.t
            com.google.android.exoplayer2.source.o$a r0 = r0.f33719c
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0014
            goto L_0x0116
        L_0x0014:
            com.google.android.exoplayer2.w r0 = r6.t
            long r0 = r0.f33720d
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x001f
            r0 = 1
            long r7 = r7 - r0
        L_0x001f:
            com.google.android.exoplayer2.w r0 = r6.t
            com.google.android.exoplayer2.ah r0 = r0.f33717a
            com.google.android.exoplayer2.w r1 = r6.t
            com.google.android.exoplayer2.source.o$a r1 = r1.f33719c
            java.lang.Object r1 = r1.f33224a
            int r0 = r0.a((java.lang.Object) r1)
            int r1 = r6.F
            r2 = 0
            if (r1 <= 0) goto L_0x003d
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r3 = r6.p
            int r1 = r1 + -1
            java.lang.Object r1 = r3.get(r1)
            com.google.android.exoplayer2.m$b r1 = (com.google.android.exoplayer2.m.b) r1
            goto L_0x003e
        L_0x003d:
            r1 = r2
        L_0x003e:
            if (r1 == 0) goto L_0x0063
            int r3 = r1.f32634b
            if (r3 > r0) goto L_0x004e
            int r3 = r1.f32634b
            if (r3 != r0) goto L_0x0063
            long r3 = r1.f32635c
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x0063
        L_0x004e:
            int r1 = r6.F
            int r1 = r1 + -1
            r6.F = r1
            int r1 = r6.F
            if (r1 <= 0) goto L_0x003d
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r3 = r6.p
            int r1 = r1 + -1
            java.lang.Object r1 = r3.get(r1)
            com.google.android.exoplayer2.m$b r1 = (com.google.android.exoplayer2.m.b) r1
            goto L_0x003e
        L_0x0063:
            int r1 = r6.F
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r3 = r6.p
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0078
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r1 = r6.p
            int r3 = r6.F
            java.lang.Object r1 = r1.get(r3)
            com.google.android.exoplayer2.m$b r1 = (com.google.android.exoplayer2.m.b) r1
            goto L_0x0079
        L_0x0078:
            r1 = r2
        L_0x0079:
            if (r1 == 0) goto L_0x00a8
            java.lang.Object r3 = r1.f32636d
            if (r3 == 0) goto L_0x00a8
            int r3 = r1.f32634b
            if (r3 < r0) goto L_0x008d
            int r3 = r1.f32634b
            if (r3 != r0) goto L_0x00a8
            long r3 = r1.f32635c
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 > 0) goto L_0x00a8
        L_0x008d:
            int r1 = r6.F
            int r1 = r1 + 1
            r6.F = r1
            int r1 = r6.F
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r3 = r6.p
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0078
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r1 = r6.p
            int r3 = r6.F
            java.lang.Object r1 = r1.get(r3)
            com.google.android.exoplayer2.m$b r1 = (com.google.android.exoplayer2.m.b) r1
            goto L_0x0079
        L_0x00a8:
            if (r1 == 0) goto L_0x0116
            java.lang.Object r3 = r1.f32636d
            if (r3 == 0) goto L_0x0116
            int r3 = r1.f32634b
            if (r3 != r0) goto L_0x0116
            long r3 = r1.f32635c
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0116
            long r3 = r1.f32635c
            int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x0116
            com.google.android.exoplayer2.aa r3 = r1.f32633a     // Catch:{ all -> 0x00f7 }
            r6.b((com.google.android.exoplayer2.aa) r3)     // Catch:{ all -> 0x00f7 }
            com.google.android.exoplayer2.aa r3 = r1.f32633a
            boolean r3 = r3.f31102h
            if (r3 != 0) goto L_0x00d9
            com.google.android.exoplayer2.aa r1 = r1.f32633a
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x00d2
            goto L_0x00d9
        L_0x00d2:
            int r1 = r6.F
            int r1 = r1 + 1
            r6.F = r1
            goto L_0x00e0
        L_0x00d9:
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r1 = r6.p
            int r3 = r6.F
            r1.remove(r3)
        L_0x00e0:
            int r1 = r6.F
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r3 = r6.p
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x00f5
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r1 = r6.p
            int r3 = r6.F
            java.lang.Object r1 = r1.get(r3)
            com.google.android.exoplayer2.m$b r1 = (com.google.android.exoplayer2.m.b) r1
            goto L_0x00a8
        L_0x00f5:
            r1 = r2
            goto L_0x00a8
        L_0x00f7:
            r7 = move-exception
            com.google.android.exoplayer2.aa r8 = r1.f32633a
            boolean r8 = r8.f31102h
            if (r8 != 0) goto L_0x010e
            com.google.android.exoplayer2.aa r8 = r1.f32633a
            boolean r8 = r8.b()
            if (r8 == 0) goto L_0x0107
            goto L_0x010e
        L_0x0107:
            int r8 = r6.F
            int r8 = r8 + 1
            r6.F = r8
            goto L_0x0115
        L_0x010e:
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r8 = r6.p
            int r9 = r6.F
            r8.remove(r9)
        L_0x0115:
            throw r7
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.m.b(long, long):void");
    }

    private static void a(ab abVar) throws i {
        if (abVar.f_() == 2) {
            abVar.l();
        }
    }

    private void b(ab abVar) throws i {
        this.n.b(abVar);
        a(abVar);
        abVar.m();
    }

    private void h() {
        for (s a2 = this.r.a(); a2 != null; a2 = a2.f32776g) {
            j f2 = a2.f();
            if (f2 != null) {
                f2.f33511c.a();
            }
        }
    }

    private boolean i() {
        s sVar = this.r.f33516d;
        s sVar2 = sVar.f32776g;
        long j2 = sVar.f32775f.f33415e;
        if (j2 == -9223372036854775807L || this.t.m < j2) {
            return true;
        }
        if (sVar2 != null) {
            return sVar2.f32773d || sVar2.f32775f.f33411a.a();
        }
        return false;
    }

    private void j() throws IOException {
        s sVar = this.r.f33518f;
        s sVar2 = this.r.f33517e;
        if (sVar != null && !sVar.f32773d) {
            if (sVar2 == null || sVar2.f32776g == sVar) {
                ab[] abVarArr = this.v;
                int length = abVarArr.length;
                int i2 = 0;
                while (i2 < length) {
                    if (abVarArr[i2].g()) {
                        i2++;
                    } else {
                        return;
                    }
                }
                sVar.f32770a.i_();
            }
        }
    }

    private void k() {
        a(4);
        a(false, false, true, false);
    }

    private Object a(Object obj, ah ahVar, ah ahVar2) {
        int a2 = ahVar.a(obj);
        int c2 = ahVar.c();
        int i2 = a2;
        int i3 = -1;
        for (int i4 = 0; i4 < c2 && i3 == -1; i4++) {
            i2 = ahVar.a(i2, this.k, this.j, this.z, this.A);
            if (i2 == -1) {
                break;
            }
            i3 = ahVar2.a(ahVar.a(i2));
        }
        if (i3 == -1) {
            return null;
        }
        return ahVar2.a(i3);
    }

    private Pair<Object, Long> a(d dVar, boolean z2) {
        int a2;
        ah ahVar = this.t.f33717a;
        ah ahVar2 = dVar.f32641a;
        if (ahVar.a()) {
            return null;
        }
        if (ahVar2.a()) {
            ahVar2 = ahVar;
        }
        try {
            Pair<Object, Long> a3 = ahVar2.a(this.j, this.k, dVar.f32642b, dVar.f32643c);
            if (ahVar == ahVar2 || (a2 = ahVar.a(a3.first)) != -1) {
                return a3;
            }
            if (z2 && a(a3.first, ahVar2, ahVar) != null) {
                return a(ahVar, ahVar.a(a2, this.k, false).f31125c);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    private Pair<Object, Long> a(ah ahVar, int i2) {
        return ahVar.a(this.j, this.k, i2, -9223372036854775807L);
    }

    private void l() {
        s sVar = this.r.f33518f;
        long c2 = sVar.c();
        if (c2 == Long.MIN_VALUE) {
            b(false);
            return;
        }
        boolean a2 = this.f32627g.a(b(c2), this.n.e().f33727b);
        b(a2);
        if (a2) {
            sVar.b(this.E);
        }
    }

    private void a(s sVar) throws i {
        s sVar2 = this.r.f33516d;
        if (sVar2 != null && sVar != sVar2) {
            boolean[] zArr = new boolean[this.f32623c.length];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                ab[] abVarArr = this.f32623c;
                if (i2 < abVarArr.length) {
                    ab abVar = abVarArr[i2];
                    zArr[i2] = abVar.f_() != 0;
                    if (sVar2.f().a(i2)) {
                        i3++;
                    }
                    if (zArr[i2] && (!sVar2.f().a(i2) || (abVar.j() && abVar.f() == sVar.f32772c[i2]))) {
                        b(abVar);
                    }
                    i2++;
                } else {
                    this.t = this.t.a(sVar2.e(), sVar2.f());
                    a(zArr, i3);
                    return;
                }
            }
        }
    }

    private void a(boolean[] zArr, int i2) throws i {
        this.v = new ab[i2];
        j f2 = this.r.f33516d.f();
        for (int i3 = 0; i3 < this.f32623c.length; i3++) {
            if (!f2.a(i3)) {
                this.f32623c[i3].n();
            }
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f32623c.length; i5++) {
            if (f2.a(i5)) {
                a(i5, zArr[i5], i4);
                i4++;
            }
        }
    }

    private void a(int i2, boolean z2, int i3) throws i {
        s sVar = this.r.f33516d;
        ab abVar = this.f32623c[i2];
        this.v[i3] = abVar;
        if (abVar.f_() == 0) {
            j f2 = sVar.f();
            ad adVar = f2.f33510b[i2];
            Format[] a2 = a(f2.f33511c.f33505b[i2]);
            boolean z3 = this.x && this.t.f33722f == 3;
            abVar.a(adVar, a2, sVar.f32772c[i2], this.E, !z2 && z3, sVar.f32778i);
            this.n.a(abVar);
            if (z3) {
                abVar.g_();
            }
        }
    }

    private void d(boolean z2) {
        long j2;
        s sVar = this.r.f33518f;
        o.a aVar = sVar == null ? this.t.f33719c : sVar.f32775f.f33411a;
        boolean z3 = !this.t.j.equals(aVar);
        if (z3) {
            this.t = this.t.a(aVar);
        }
        w wVar = this.t;
        if (sVar == null) {
            j2 = wVar.m;
        } else {
            j2 = sVar.b();
        }
        wVar.k = j2;
        this.t.l = m();
        if ((z3 || z2) && sVar != null && sVar.f32773d) {
            sVar.e();
            a(sVar.f());
        }
    }

    private long m() {
        return b(this.t.k);
    }

    private long b(long j2) {
        s sVar = this.r.f33518f;
        if (sVar == null) {
            return 0;
        }
        return Math.max(0, j2 - (this.E - sVar.f32778i));
    }

    private void a(j jVar) {
        this.f32627g.a(this.f32623c, jVar.f33511c);
    }

    private static Format[] a(f fVar) {
        int f2 = fVar != null ? fVar.f() : 0;
        Format[] formatArr = new Format[f2];
        for (int i2 = 0; i2 < f2; i2++) {
            formatArr[i2] = fVar.a(i2);
        }
        return formatArr;
    }

    static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final ah f32641a;

        /* renamed from: b  reason: collision with root package name */
        public final int f32642b;

        /* renamed from: c  reason: collision with root package name */
        public final long f32643c;

        public d(ah ahVar, int i2, long j) {
            this.f32641a = ahVar;
            this.f32642b = i2;
            this.f32643c = j;
        }
    }

    static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        public final aa f32633a;

        /* renamed from: b  reason: collision with root package name */
        public int f32634b;

        /* renamed from: c  reason: collision with root package name */
        public long f32635c;

        /* renamed from: d  reason: collision with root package name */
        public Object f32636d;

        public final /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            if ((this.f32636d == null) != (bVar.f32636d == null)) {
                if (this.f32636d != null) {
                    return -1;
                }
                return 1;
            } else if (this.f32636d == null) {
                return 0;
            } else {
                int i2 = this.f32634b - bVar.f32634b;
                if (i2 != 0) {
                    return i2;
                }
                return ae.c(this.f32635c, bVar.f32635c);
            }
        }

        public b(aa aaVar) {
            this.f32633a = aaVar;
        }

        public final void a(int i2, long j, Object obj) {
            this.f32634b = i2;
            this.f32635c = j;
            this.f32636d = obj;
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final o f32630a;

        /* renamed from: b  reason: collision with root package name */
        public final ah f32631b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f32632c;

        public a(o oVar, ah ahVar, Object obj) {
            this.f32630a = oVar;
            this.f32631b = ahVar;
            this.f32632c = obj;
        }
    }

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        int f32637a;

        /* renamed from: b  reason: collision with root package name */
        boolean f32638b;

        /* renamed from: c  reason: collision with root package name */
        int f32639c;

        /* renamed from: d  reason: collision with root package name */
        private w f32640d;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final boolean a(w wVar) {
            return wVar != this.f32640d || this.f32637a > 0 || this.f32638b;
        }

        public final void b(w wVar) {
            this.f32640d = wVar;
            this.f32637a = 0;
            this.f32638b = false;
        }

        public final void a(int i2) {
            this.f32637a += i2;
        }

        public final void b(int i2) {
            boolean z = true;
            if (!this.f32638b || this.f32639c == 4) {
                this.f32638b = true;
                this.f32639c = i2;
                return;
            }
            if (i2 != 4) {
                z = false;
            }
            com.google.android.exoplayer2.g.a.a(z);
        }
    }

    private void b(aa aaVar) throws i {
        if (aaVar.f31099e.getLooper() == this.f32621a.a()) {
            c(aaVar);
            if (this.t.f33722f == 3 || this.t.f33722f == 2) {
                this.f32621a.a(2);
                return;
            }
            return;
        }
        this.f32621a.a(16, (Object) aaVar).sendToTarget();
    }
}
