package com.squareup.picasso;

import android.graphics.Bitmap;
import com.squareup.picasso.ab;
import com.squareup.picasso.u;
import com.squareup.picasso.w;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

final class c implements Runnable {
    private static final Object t = new Object();
    private static final ThreadLocal<StringBuilder> u = new ThreadLocal<StringBuilder>() {
        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            return new StringBuilder("Picasso-");
        }
    };
    private static final AtomicInteger v = new AtomicInteger();
    private static final ab w = new ab() {
        public final boolean a(z zVar) {
            return true;
        }

        public final ab.a a(z zVar, int i2) throws IOException {
            throw new IllegalStateException("Unrecognized type of request: ".concat(String.valueOf(zVar)));
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int f45393a = v.incrementAndGet();

    /* renamed from: b  reason: collision with root package name */
    final w f45394b;

    /* renamed from: c  reason: collision with root package name */
    final i f45395c;

    /* renamed from: d  reason: collision with root package name */
    final d f45396d;

    /* renamed from: e  reason: collision with root package name */
    final ad f45397e;

    /* renamed from: f  reason: collision with root package name */
    final String f45398f;

    /* renamed from: g  reason: collision with root package name */
    final z f45399g;

    /* renamed from: h  reason: collision with root package name */
    final int f45400h;

    /* renamed from: i  reason: collision with root package name */
    int f45401i;
    final ab j;
    a k;
    List<a> l;
    Bitmap m;
    Future<?> n;
    w.d o;
    Exception p;
    int q;
    int r;
    w.e s;

    private static boolean a(boolean z, int i2, int i3, int i4, int i5) {
        if (!z) {
            return true;
        }
        if (i4 == 0 || i2 <= i4) {
            return i5 != 0 && i3 > i5;
        }
        return true;
    }

    private c(w wVar, i iVar, d dVar, ad adVar, a aVar, ab abVar) {
        this.f45394b = wVar;
        this.f45395c = iVar;
        this.f45396d = dVar;
        this.f45397e = adVar;
        this.k = aVar;
        this.f45398f = aVar.f45349i;
        this.f45399g = aVar.f45342b;
        this.s = aVar.f45342b.t;
        this.f45400h = aVar.f45345e;
        this.f45401i = aVar.f45346f;
        this.j = abVar;
        this.r = abVar.a();
    }

    public final void run() {
        String str;
        Thread currentThread;
        String str2;
        String str3 = "Picasso-Idle";
        try {
            z zVar = this.f45399g;
            if (zVar.f45479d != null) {
                str2 = String.valueOf(zVar.f45479d.getPath());
            } else {
                str2 = Integer.toHexString(zVar.f45480e);
            }
            StringBuilder sb = u.get();
            sb.ensureCapacity(str2.length() + 8);
            sb.replace(8, sb.length(), str2);
            Thread.currentThread().setName(sb.toString());
            if (this.f45394b.n) {
                ai.a("Hunter", "executing", ai.a(this));
            }
            this.m = a();
            if (this.m == null) {
                this.f45395c.a(this);
            } else {
                i iVar = this.f45395c;
                iVar.f45422i.sendMessage(iVar.f45422i.obtainMessage(4, this));
            }
        } catch (u.b e2) {
            if (!t.isOfflineOnly(e2.networkPolicy) || e2.code != 504) {
                this.p = e2;
            }
            this.f45395c.a(this);
        } catch (IOException e3) {
            this.p = e3;
            i iVar2 = this.f45395c;
            iVar2.f45422i.sendMessageDelayed(iVar2.f45422i.obtainMessage(5, this), 500);
        } catch (OutOfMemoryError e4) {
            StringWriter stringWriter = new StringWriter();
            ad adVar = this.f45397e;
            int b2 = adVar.f45366b.b();
            int a2 = adVar.f45366b.a();
            long j2 = adVar.f45368d;
            long j3 = adVar.f45369e;
            long j4 = adVar.f45370f;
            str = str3;
            OutOfMemoryError outOfMemoryError = e4;
            long j5 = adVar.f45372h;
            StringWriter stringWriter2 = stringWriter;
            long j6 = adVar.f45373i;
            long j7 = adVar.j;
            long j8 = adVar.k;
            int i2 = adVar.l;
            long j9 = j8;
            int i3 = adVar.m;
            int i4 = adVar.n;
            ae aeVar = r5;
            ae aeVar2 = new ae(b2, a2, j2, j3, j4, adVar.f45371g, j5, j6, j7, j9, i2, i3, i4, System.currentTimeMillis());
            StringWriter stringWriter3 = stringWriter2;
            PrintWriter printWriter = new PrintWriter(stringWriter3);
            printWriter.println("===============BEGIN PICASSO STATS ===============");
            printWriter.println("Memory Cache Stats");
            printWriter.print("  Max Cache Size: ");
            ae aeVar3 = aeVar;
            printWriter.println(aeVar3.f45377a);
            printWriter.print("  Cache Size: ");
            printWriter.println(aeVar3.f45378b);
            printWriter.print("  Cache % Full: ");
            printWriter.println((int) Math.ceil((double) ((((float) aeVar3.f45378b) / ((float) aeVar3.f45377a)) * 100.0f)));
            printWriter.print("  Cache Hits: ");
            printWriter.println(aeVar3.f45379c);
            printWriter.print("  Cache Misses: ");
            printWriter.println(aeVar3.f45380d);
            printWriter.println("Network Stats");
            printWriter.print("  Download Count: ");
            printWriter.println(aeVar3.k);
            printWriter.print("  Total Download Size: ");
            printWriter.println(aeVar3.f45381e);
            printWriter.print("  Average Download Size: ");
            printWriter.println(aeVar3.f45384h);
            printWriter.println("Bitmap Stats");
            printWriter.print("  Total Bitmaps Decoded: ");
            printWriter.println(aeVar3.l);
            printWriter.print("  Total Bitmap Size: ");
            printWriter.println(aeVar3.f45382f);
            printWriter.print("  Total Transformed Bitmaps: ");
            printWriter.println(aeVar3.m);
            printWriter.print("  Total Transformed Bitmap Size: ");
            printWriter.println(aeVar3.f45383g);
            printWriter.print("  Average Bitmap Size: ");
            printWriter.println(aeVar3.f45385i);
            printWriter.print("  Average Transformed Bitmap Size: ");
            printWriter.println(aeVar3.j);
            printWriter.println("===============END PICASSO STATS ===============");
            printWriter.flush();
            RuntimeException runtimeException = new RuntimeException(stringWriter3.toString(), outOfMemoryError);
            this.p = runtimeException;
            this.f45395c.a(this);
            currentThread = Thread.currentThread();
            str3 = str;
        } catch (Exception e5) {
            this.p = e5;
            this.f45395c.a(this);
        } catch (Throwable th) {
            th = th;
            str3 = str;
            Thread.currentThread().setName(str3);
            throw th;
        }
        currentThread = Thread.currentThread();
        currentThread.setName(str3);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02da A[Catch:{ all -> 0x028f, all -> 0x0419 }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0367 A[Catch:{ all -> 0x028f, all -> 0x0419 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x03cc A[Catch:{ all -> 0x028f, all -> 0x0419 }] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x03d2  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x03db A[Catch:{ all -> 0x0423 }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x03f1 A[Catch:{ all -> 0x0423 }] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0412  */
    /* JADX WARNING: Removed duplicated region for block: B:209:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap a() throws java.io.IOException {
        /*
            r32 = this;
            r1 = r32
            int r0 = r1.f45400h
            boolean r0 = com.squareup.picasso.s.shouldReadFromMemoryCache(r0)
            r2 = 0
            if (r0 == 0) goto L_0x0034
            com.squareup.picasso.d r0 = r1.f45396d
            java.lang.String r3 = r1.f45398f
            android.graphics.Bitmap r0 = r0.a(r3)
            if (r0 == 0) goto L_0x0035
            com.squareup.picasso.ad r2 = r1.f45397e
            r2.a()
            com.squareup.picasso.w$d r2 = com.squareup.picasso.w.d.MEMORY
            r1.o = r2
            com.squareup.picasso.w r2 = r1.f45394b
            boolean r2 = r2.n
            if (r2 == 0) goto L_0x0033
            com.squareup.picasso.z r2 = r1.f45399g
            java.lang.String r2 = r2.a()
            java.lang.String r3 = "Hunter"
            java.lang.String r4 = "decoded"
            java.lang.String r5 = "from cache"
            com.squareup.picasso.ai.a(r3, r4, r2, r5)
        L_0x0033:
            return r0
        L_0x0034:
            r0 = r2
        L_0x0035:
            int r3 = r1.r
            if (r3 != 0) goto L_0x003e
            com.squareup.picasso.t r3 = com.squareup.picasso.t.OFFLINE
            int r3 = r3.index
            goto L_0x0040
        L_0x003e:
            int r3 = r1.f45401i
        L_0x0040:
            r1.f45401i = r3
            com.squareup.picasso.ab r3 = r1.j
            com.squareup.picasso.z r4 = r1.f45399g
            int r5 = r1.f45401i
            com.squareup.picasso.ab$a r3 = r3.a(r4, r5)
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x00d5
            com.squareup.picasso.w$d r0 = r3.f45360a
            r1.o = r0
            int r0 = r3.f45363d
            r1.q = r0
            android.graphics.Bitmap r0 = r3.f45361b
            if (r0 != 0) goto L_0x00d5
            i.v r3 = r3.f45362c
            com.squareup.picasso.z r0 = r1.f45399g     // Catch:{ all -> 0x00d0 }
            i.e r6 = i.n.a((i.v) r3)     // Catch:{ all -> 0x00d0 }
            boolean r7 = com.squareup.picasso.ai.a((i.e) r6)     // Catch:{ all -> 0x00d0 }
            boolean r8 = r0.r     // Catch:{ all -> 0x00d0 }
            if (r8 == 0) goto L_0x0074
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00d0 }
            r9 = 21
            if (r8 >= r9) goto L_0x0074
            r8 = 1
            goto L_0x0075
        L_0x0074:
            r8 = 0
        L_0x0075:
            android.graphics.BitmapFactory$Options r9 = com.squareup.picasso.ab.c(r0)     // Catch:{ all -> 0x00d0 }
            boolean r10 = com.squareup.picasso.ab.a((android.graphics.BitmapFactory.Options) r9)     // Catch:{ all -> 0x00d0 }
            if (r7 != 0) goto L_0x00b4
            if (r8 == 0) goto L_0x0082
            goto L_0x00b4
        L_0x0082:
            java.io.InputStream r6 = r6.e()     // Catch:{ all -> 0x00d0 }
            if (r10 == 0) goto L_0x00a5
            com.squareup.picasso.p r7 = new com.squareup.picasso.p     // Catch:{ all -> 0x00d0 }
            r7.<init>(r6)     // Catch:{ all -> 0x00d0 }
            r7.f45431a = r5     // Catch:{ all -> 0x00d0 }
            r6 = 1024(0x400, float:1.435E-42)
            long r10 = r7.a((int) r6)     // Catch:{ all -> 0x00d0 }
            android.graphics.BitmapFactory.decodeStream(r7, r2, r9)     // Catch:{ all -> 0x00d0 }
            int r6 = r0.f45483h     // Catch:{ all -> 0x00d0 }
            int r8 = r0.f45484i     // Catch:{ all -> 0x00d0 }
            com.squareup.picasso.ab.a(r6, r8, r9, r0)     // Catch:{ all -> 0x00d0 }
            r7.a((long) r10)     // Catch:{ all -> 0x00d0 }
            r7.f45431a = r4     // Catch:{ all -> 0x00d0 }
            r6 = r7
        L_0x00a5:
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r6, r2, r9)     // Catch:{ all -> 0x00d0 }
            if (r0 == 0) goto L_0x00ac
            goto L_0x00ca
        L_0x00ac:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00d0 }
            java.lang.String r2 = "Failed to decode stream."
            r0.<init>(r2)     // Catch:{ all -> 0x00d0 }
            throw r0     // Catch:{ all -> 0x00d0 }
        L_0x00b4:
            byte[] r2 = r6.s()     // Catch:{ all -> 0x00d0 }
            if (r10 == 0) goto L_0x00c5
            int r6 = r2.length     // Catch:{ all -> 0x00d0 }
            android.graphics.BitmapFactory.decodeByteArray(r2, r5, r6, r9)     // Catch:{ all -> 0x00d0 }
            int r6 = r0.f45483h     // Catch:{ all -> 0x00d0 }
            int r7 = r0.f45484i     // Catch:{ all -> 0x00d0 }
            com.squareup.picasso.ab.a(r6, r7, r9, r0)     // Catch:{ all -> 0x00d0 }
        L_0x00c5:
            int r0 = r2.length     // Catch:{ all -> 0x00d0 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r2, r5, r0, r9)     // Catch:{ all -> 0x00d0 }
        L_0x00ca:
            r3.close()     // Catch:{ IOException -> 0x00ce }
            goto L_0x00d5
        L_0x00ce:
            goto L_0x00d5
        L_0x00d0:
            r0 = move-exception
            r3.close()     // Catch:{ IOException -> 0x00d4 }
        L_0x00d4:
            throw r0
        L_0x00d5:
            if (r0 == 0) goto L_0x0425
            com.squareup.picasso.w r2 = r1.f45394b
            boolean r2 = r2.n
            if (r2 == 0) goto L_0x00ea
            com.squareup.picasso.z r2 = r1.f45399g
            java.lang.String r2 = r2.a()
            java.lang.String r3 = "Hunter"
            java.lang.String r6 = "decoded"
            com.squareup.picasso.ai.a(r3, r6, r2)
        L_0x00ea:
            com.squareup.picasso.ad r2 = r1.f45397e
            r3 = 2
            r2.a(r0, r3)
            com.squareup.picasso.z r2 = r1.f45399g
            boolean r6 = r2.d()
            if (r6 != 0) goto L_0x0101
            boolean r2 = r2.e()
            if (r2 == 0) goto L_0x00ff
            goto L_0x0101
        L_0x00ff:
            r2 = 0
            goto L_0x0102
        L_0x0101:
            r2 = 1
        L_0x0102:
            if (r2 != 0) goto L_0x0108
            int r2 = r1.q
            if (r2 == 0) goto L_0x0425
        L_0x0108:
            java.lang.Object r2 = t
            monitor-enter(r2)
            com.squareup.picasso.z r6 = r1.f45399g     // Catch:{ all -> 0x041d }
            boolean r6 = r6.d()     // Catch:{ all -> 0x041d }
            if (r6 != 0) goto L_0x011d
            int r6 = r1.q     // Catch:{ all -> 0x041d }
            if (r6 == 0) goto L_0x0118
            goto L_0x011d
        L_0x0118:
            r20 = r2
            r2 = r1
            goto L_0x03e9
        L_0x011d:
            com.squareup.picasso.z r6 = r1.f45399g     // Catch:{ all -> 0x041d }
            int r7 = r1.q     // Catch:{ all -> 0x041d }
            int r8 = r0.getWidth()     // Catch:{ all -> 0x041d }
            int r9 = r0.getHeight()     // Catch:{ all -> 0x041d }
            boolean r10 = r6.m     // Catch:{ all -> 0x041d }
            android.graphics.Matrix r12 = new android.graphics.Matrix     // Catch:{ all -> 0x041d }
            r12.<init>()     // Catch:{ all -> 0x041d }
            boolean r13 = r6.d()     // Catch:{ all -> 0x041d }
            if (r13 != 0) goto L_0x0142
            if (r7 == 0) goto L_0x0139
            goto L_0x0142
        L_0x0139:
            r28 = r0
            r20 = r2
            r4 = r8
            r5 = r9
            r0 = r12
            goto L_0x03bc
        L_0x0142:
            int r13 = r6.f45483h     // Catch:{ all -> 0x041d }
            int r14 = r6.f45484i     // Catch:{ all -> 0x041d }
            float r15 = r6.n     // Catch:{ all -> 0x041d }
            r16 = 0
            int r16 = (r15 > r16 ? 1 : (r15 == r16 ? 0 : -1))
            if (r16 == 0) goto L_0x0294
            double r13 = (double) r15
            double r16 = java.lang.Math.toRadians(r13)     // Catch:{ all -> 0x028f }
            double r16 = java.lang.Math.cos(r16)     // Catch:{ all -> 0x028f }
            double r13 = java.lang.Math.toRadians(r13)     // Catch:{ all -> 0x028f }
            double r13 = java.lang.Math.sin(r13)     // Catch:{ all -> 0x028f }
            boolean r5 = r6.q     // Catch:{ all -> 0x028f }
            if (r5 == 0) goto L_0x0210
            float r5 = r6.o     // Catch:{ all -> 0x028f }
            float r11 = r6.p     // Catch:{ all -> 0x028f }
            r12.setRotate(r15, r5, r11)     // Catch:{ all -> 0x028f }
            float r5 = r6.o     // Catch:{ all -> 0x028f }
            double r4 = (double) r5     // Catch:{ all -> 0x028f }
            r19 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r19 = r19 - r16
            double r4 = r4 * r19
            float r15 = r6.p     // Catch:{ all -> 0x028f }
            r21 = r12
            double r11 = (double) r15     // Catch:{ all -> 0x028f }
            double r11 = r11 * r13
            double r4 = r4 + r11
            float r11 = r6.p     // Catch:{ all -> 0x028f }
            double r11 = (double) r11     // Catch:{ all -> 0x028f }
            double r11 = r11 * r19
            float r15 = r6.o     // Catch:{ all -> 0x028f }
            r22 = r4
            double r3 = (double) r15     // Catch:{ all -> 0x028f }
            double r3 = r3 * r13
            double r11 = r11 - r3
            int r3 = r6.f45483h     // Catch:{ all -> 0x028f }
            double r3 = (double) r3     // Catch:{ all -> 0x028f }
            double r3 = r3 * r16
            double r4 = r22 + r3
            int r3 = r6.f45483h     // Catch:{ all -> 0x028f }
            r20 = r2
            double r1 = (double) r3
            double r1 = r1 * r13
            double r1 = r1 + r11
            int r3 = r6.f45483h     // Catch:{ all -> 0x0419 }
            r24 = r9
            r25 = r10
            double r9 = (double) r3     // Catch:{ all -> 0x0419 }
            double r9 = r9 * r16
            double r9 = r22 + r9
            int r3 = r6.f45484i     // Catch:{ all -> 0x0419 }
            r26 = r7
            r27 = r8
            double r7 = (double) r3     // Catch:{ all -> 0x0419 }
            double r7 = r7 * r13
            double r9 = r9 - r7
            int r3 = r6.f45483h     // Catch:{ all -> 0x0419 }
            double r7 = (double) r3     // Catch:{ all -> 0x0419 }
            double r7 = r7 * r13
            double r7 = r7 + r11
            int r3 = r6.f45484i     // Catch:{ all -> 0x0419 }
            r28 = r0
            r29 = r1
            double r0 = (double) r3     // Catch:{ all -> 0x0419 }
            double r0 = r0 * r16
            double r7 = r7 + r0
            int r0 = r6.f45484i     // Catch:{ all -> 0x0419 }
            double r0 = (double) r0     // Catch:{ all -> 0x0419 }
            double r0 = r0 * r13
            double r0 = r22 - r0
            int r2 = r6.f45484i     // Catch:{ all -> 0x0419 }
            double r2 = (double) r2     // Catch:{ all -> 0x0419 }
            double r2 = r2 * r16
            double r2 = r2 + r11
            r15 = r2
            r13 = r22
            double r2 = java.lang.Math.max(r13, r4)     // Catch:{ all -> 0x0419 }
            double r2 = java.lang.Math.max(r9, r2)     // Catch:{ all -> 0x0419 }
            double r2 = java.lang.Math.max(r0, r2)     // Catch:{ all -> 0x0419 }
            double r4 = java.lang.Math.min(r13, r4)     // Catch:{ all -> 0x0419 }
            double r4 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x0419 }
            double r0 = java.lang.Math.min(r0, r4)     // Catch:{ all -> 0x0419 }
            r4 = r29
            double r9 = java.lang.Math.max(r11, r4)     // Catch:{ all -> 0x0419 }
            double r9 = java.lang.Math.max(r7, r9)     // Catch:{ all -> 0x0419 }
            r13 = r15
            double r9 = java.lang.Math.max(r13, r9)     // Catch:{ all -> 0x0419 }
            double r4 = java.lang.Math.min(r11, r4)     // Catch:{ all -> 0x0419 }
            double r4 = java.lang.Math.min(r7, r4)     // Catch:{ all -> 0x0419 }
            double r4 = java.lang.Math.min(r13, r4)     // Catch:{ all -> 0x0419 }
            double r2 = r2 - r0
            double r0 = java.lang.Math.floor(r2)     // Catch:{ all -> 0x0419 }
            int r13 = (int) r0     // Catch:{ all -> 0x0419 }
            double r9 = r9 - r4
            double r0 = java.lang.Math.floor(r9)     // Catch:{ all -> 0x0419 }
            int r14 = (int) r0     // Catch:{ all -> 0x0419 }
            r15 = r6
            r0 = r21
            goto L_0x02a2
        L_0x0210:
            r28 = r0
            r20 = r2
            r26 = r7
            r27 = r8
            r24 = r9
            r25 = r10
            r0 = r12
            r0.setRotate(r15)     // Catch:{ all -> 0x0419 }
            int r1 = r6.f45483h     // Catch:{ all -> 0x0419 }
            double r1 = (double) r1     // Catch:{ all -> 0x0419 }
            double r1 = r1 * r16
            int r3 = r6.f45483h     // Catch:{ all -> 0x0419 }
            double r3 = (double) r3     // Catch:{ all -> 0x0419 }
            double r3 = r3 * r13
            int r5 = r6.f45483h     // Catch:{ all -> 0x0419 }
            double r7 = (double) r5     // Catch:{ all -> 0x0419 }
            double r7 = r7 * r16
            int r5 = r6.f45484i     // Catch:{ all -> 0x0419 }
            double r9 = (double) r5     // Catch:{ all -> 0x0419 }
            double r9 = r9 * r13
            double r7 = r7 - r9
            int r5 = r6.f45483h     // Catch:{ all -> 0x0419 }
            double r9 = (double) r5     // Catch:{ all -> 0x0419 }
            double r9 = r9 * r13
            int r5 = r6.f45484i     // Catch:{ all -> 0x0419 }
            double r11 = (double) r5     // Catch:{ all -> 0x0419 }
            double r11 = r11 * r16
            double r9 = r9 + r11
            int r5 = r6.f45484i     // Catch:{ all -> 0x0419 }
            double r11 = (double) r5     // Catch:{ all -> 0x0419 }
            double r11 = r11 * r13
            double r11 = -r11
            int r5 = r6.f45484i     // Catch:{ all -> 0x0419 }
            double r13 = (double) r5     // Catch:{ all -> 0x0419 }
            double r13 = r13 * r16
            r15 = r6
            r5 = 0
            r16 = r13
            double r13 = java.lang.Math.max(r5, r1)     // Catch:{ all -> 0x0419 }
            double r13 = java.lang.Math.max(r7, r13)     // Catch:{ all -> 0x0419 }
            double r13 = java.lang.Math.max(r11, r13)     // Catch:{ all -> 0x0419 }
            double r1 = java.lang.Math.min(r5, r1)     // Catch:{ all -> 0x0419 }
            double r1 = java.lang.Math.min(r7, r1)     // Catch:{ all -> 0x0419 }
            double r1 = java.lang.Math.min(r11, r1)     // Catch:{ all -> 0x0419 }
            double r7 = java.lang.Math.max(r5, r3)     // Catch:{ all -> 0x0419 }
            double r7 = java.lang.Math.max(r9, r7)     // Catch:{ all -> 0x0419 }
            r11 = r16
            double r7 = java.lang.Math.max(r11, r7)     // Catch:{ all -> 0x0419 }
            double r3 = java.lang.Math.min(r5, r3)     // Catch:{ all -> 0x0419 }
            double r3 = java.lang.Math.min(r9, r3)     // Catch:{ all -> 0x0419 }
            double r3 = java.lang.Math.min(r11, r3)     // Catch:{ all -> 0x0419 }
            double r13 = r13 - r1
            double r1 = java.lang.Math.floor(r13)     // Catch:{ all -> 0x0419 }
            int r13 = (int) r1     // Catch:{ all -> 0x0419 }
            double r7 = r7 - r3
            double r1 = java.lang.Math.floor(r7)     // Catch:{ all -> 0x0419 }
            int r14 = (int) r1     // Catch:{ all -> 0x0419 }
            goto L_0x02a2
        L_0x028f:
            r0 = move-exception
            r20 = r2
            goto L_0x041a
        L_0x0294:
            r28 = r0
            r20 = r2
            r15 = r6
            r26 = r7
            r27 = r8
            r24 = r9
            r25 = r10
            r0 = r12
        L_0x02a2:
            r1 = 5
            if (r26 == 0) goto L_0x02e0
            r5 = 270(0x10e, float:3.78E-43)
            r2 = 90
            switch(r26) {
                case 3: goto L_0x02b4;
                case 4: goto L_0x02b4;
                case 5: goto L_0x02b1;
                case 6: goto L_0x02b1;
                case 7: goto L_0x02ae;
                case 8: goto L_0x02ae;
                default: goto L_0x02ac;
            }     // Catch:{ all -> 0x0419 }
        L_0x02ac:
            r3 = 0
            goto L_0x02b6
        L_0x02ae:
            r3 = 270(0x10e, float:3.78E-43)
            goto L_0x02b6
        L_0x02b1:
            r3 = 90
            goto L_0x02b6
        L_0x02b4:
            r3 = 180(0xb4, float:2.52E-43)
        L_0x02b6:
            r4 = r26
            r6 = 2
            if (r4 == r6) goto L_0x02c5
            r6 = 7
            if (r4 == r6) goto L_0x02c5
            r6 = 4
            if (r4 == r6) goto L_0x02c5
            if (r4 == r1) goto L_0x02c5
            r4 = 1
            goto L_0x02c6
        L_0x02c5:
            r4 = -1
        L_0x02c6:
            if (r3 == 0) goto L_0x02d7
            float r6 = (float) r3     // Catch:{ all -> 0x0419 }
            r0.preRotate(r6)     // Catch:{ all -> 0x0419 }
            if (r3 == r2) goto L_0x02d0
            if (r3 != r5) goto L_0x02d7
        L_0x02d0:
            r2 = 1
            r31 = r14
            r14 = r13
            r13 = r31
            goto L_0x02d8
        L_0x02d7:
            r2 = 1
        L_0x02d8:
            if (r4 == r2) goto L_0x02e0
            float r2 = (float) r4     // Catch:{ all -> 0x0419 }
            r3 = 1065353216(0x3f800000, float:1.0)
            r0.postScale(r2, r3)     // Catch:{ all -> 0x0419 }
        L_0x02e0:
            r2 = r15
            boolean r3 = r2.j     // Catch:{ all -> 0x0419 }
            if (r3 == 0) goto L_0x0370
            if (r13 == 0) goto L_0x02ef
            float r3 = (float) r13     // Catch:{ all -> 0x0419 }
            r4 = r27
            float r5 = (float) r4     // Catch:{ all -> 0x0419 }
            float r3 = r3 / r5
            r5 = r24
            goto L_0x02f6
        L_0x02ef:
            r4 = r27
            float r3 = (float) r14     // Catch:{ all -> 0x0419 }
            r5 = r24
            float r6 = (float) r5     // Catch:{ all -> 0x0419 }
            float r3 = r3 / r6
        L_0x02f6:
            if (r14 == 0) goto L_0x02fb
            float r6 = (float) r14     // Catch:{ all -> 0x0419 }
            float r7 = (float) r5     // Catch:{ all -> 0x0419 }
            goto L_0x02fd
        L_0x02fb:
            float r6 = (float) r13     // Catch:{ all -> 0x0419 }
            float r7 = (float) r4     // Catch:{ all -> 0x0419 }
        L_0x02fd:
            float r6 = r6 / r7
            int r7 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r7 <= 0) goto L_0x032c
            float r1 = (float) r5     // Catch:{ all -> 0x0419 }
            float r6 = r6 / r3
            float r1 = r1 * r6
            double r6 = (double) r1     // Catch:{ all -> 0x0419 }
            double r6 = java.lang.Math.ceil(r6)     // Catch:{ all -> 0x0419 }
            int r9 = (int) r6     // Catch:{ all -> 0x0419 }
            int r1 = r2.k     // Catch:{ all -> 0x0419 }
            r6 = 48
            r1 = r1 & r6
            if (r1 != r6) goto L_0x0315
            r1 = 0
            goto L_0x0323
        L_0x0315:
            int r1 = r2.k     // Catch:{ all -> 0x0419 }
            r2 = 80
            r1 = r1 & r2
            if (r1 != r2) goto L_0x031f
            int r1 = r5 - r9
            goto L_0x0323
        L_0x031f:
            int r1 = r5 - r9
            r2 = 2
            int r1 = r1 / r2
        L_0x0323:
            float r2 = (float) r14     // Catch:{ all -> 0x0419 }
            float r6 = (float) r9     // Catch:{ all -> 0x0419 }
            float r6 = r2 / r6
            r2 = r1
            r8 = r4
            r1 = r25
            goto L_0x035f
        L_0x032c:
            int r7 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r7 >= 0) goto L_0x0359
            float r7 = (float) r4     // Catch:{ all -> 0x0419 }
            float r3 = r3 / r6
            float r7 = r7 * r3
            double r7 = (double) r7     // Catch:{ all -> 0x0419 }
            double r7 = java.lang.Math.ceil(r7)     // Catch:{ all -> 0x0419 }
            int r8 = (int) r7     // Catch:{ all -> 0x0419 }
            int r3 = r2.k     // Catch:{ all -> 0x0419 }
            r7 = 3
            r3 = r3 & r7
            if (r3 != r7) goto L_0x0342
            r1 = 0
            goto L_0x034e
        L_0x0342:
            int r2 = r2.k     // Catch:{ all -> 0x0419 }
            r2 = r2 & r1
            if (r2 != r1) goto L_0x034a
            int r1 = r4 - r8
            goto L_0x034e
        L_0x034a:
            int r1 = r4 - r8
            r2 = 2
            int r1 = r1 / r2
        L_0x034e:
            float r2 = (float) r13     // Catch:{ all -> 0x0419 }
            float r3 = (float) r8     // Catch:{ all -> 0x0419 }
            float r3 = r2 / r3
            r18 = r1
            r9 = r5
            r1 = r25
            r2 = 0
            goto L_0x0361
        L_0x0359:
            r8 = r4
            r9 = r5
            r3 = r6
            r1 = r25
            r2 = 0
        L_0x035f:
            r18 = 0
        L_0x0361:
            boolean r1 = a((boolean) r1, (int) r4, (int) r5, (int) r13, (int) r14)     // Catch:{ all -> 0x0419 }
            if (r1 == 0) goto L_0x036a
            r0.preScale(r3, r6)     // Catch:{ all -> 0x0419 }
        L_0x036a:
            r6 = r2
            r7 = r8
            r8 = r9
            r5 = r18
            goto L_0x03c0
        L_0x0370:
            r5 = r24
            r1 = r25
            r4 = r27
            boolean r2 = r2.l     // Catch:{ all -> 0x0419 }
            if (r2 == 0) goto L_0x039a
            if (r13 == 0) goto L_0x037f
            float r2 = (float) r13     // Catch:{ all -> 0x0419 }
            float r3 = (float) r4     // Catch:{ all -> 0x0419 }
            goto L_0x0381
        L_0x037f:
            float r2 = (float) r14     // Catch:{ all -> 0x0419 }
            float r3 = (float) r5     // Catch:{ all -> 0x0419 }
        L_0x0381:
            float r2 = r2 / r3
            if (r14 == 0) goto L_0x0387
            float r3 = (float) r14     // Catch:{ all -> 0x0419 }
            float r6 = (float) r5     // Catch:{ all -> 0x0419 }
            goto L_0x0389
        L_0x0387:
            float r3 = (float) r13     // Catch:{ all -> 0x0419 }
            float r6 = (float) r4     // Catch:{ all -> 0x0419 }
        L_0x0389:
            float r3 = r3 / r6
            int r6 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x038f
            goto L_0x0390
        L_0x038f:
            r2 = r3
        L_0x0390:
            boolean r1 = a((boolean) r1, (int) r4, (int) r5, (int) r13, (int) r14)     // Catch:{ all -> 0x0419 }
            if (r1 == 0) goto L_0x03bc
            r0.preScale(r2, r2)     // Catch:{ all -> 0x0419 }
            goto L_0x03bc
        L_0x039a:
            if (r13 != 0) goto L_0x039e
            if (r14 == 0) goto L_0x03bc
        L_0x039e:
            if (r13 != r4) goto L_0x03a2
            if (r14 == r5) goto L_0x03bc
        L_0x03a2:
            if (r13 == 0) goto L_0x03a7
            float r2 = (float) r13     // Catch:{ all -> 0x0419 }
            float r3 = (float) r4     // Catch:{ all -> 0x0419 }
            goto L_0x03a9
        L_0x03a7:
            float r2 = (float) r14     // Catch:{ all -> 0x0419 }
            float r3 = (float) r5     // Catch:{ all -> 0x0419 }
        L_0x03a9:
            float r2 = r2 / r3
            if (r14 == 0) goto L_0x03b0
            float r3 = (float) r14     // Catch:{ all -> 0x0419 }
            float r6 = (float) r5     // Catch:{ all -> 0x0419 }
        L_0x03ae:
            float r3 = r3 / r6
            goto L_0x03b3
        L_0x03b0:
            float r3 = (float) r13     // Catch:{ all -> 0x0419 }
            float r6 = (float) r4     // Catch:{ all -> 0x0419 }
            goto L_0x03ae
        L_0x03b3:
            boolean r1 = a((boolean) r1, (int) r4, (int) r5, (int) r13, (int) r14)     // Catch:{ all -> 0x0419 }
            if (r1 == 0) goto L_0x03bc
            r0.preScale(r2, r3)     // Catch:{ all -> 0x0419 }
        L_0x03bc:
            r7 = r4
            r8 = r5
            r5 = 0
            r6 = 0
        L_0x03c0:
            r10 = 1
            r4 = r28
            r9 = r0
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0419 }
            r1 = r28
            if (r0 == r1) goto L_0x03d2
            r1.recycle()     // Catch:{ all -> 0x0419 }
            r2 = r32
            goto L_0x03d5
        L_0x03d2:
            r2 = r32
            r0 = r1
        L_0x03d5:
            com.squareup.picasso.w r1 = r2.f45394b     // Catch:{ all -> 0x0423 }
            boolean r1 = r1.n     // Catch:{ all -> 0x0423 }
            if (r1 == 0) goto L_0x03e9
            java.lang.String r1 = "Hunter"
            java.lang.String r3 = "transformed"
            com.squareup.picasso.z r4 = r2.f45399g     // Catch:{ all -> 0x0423 }
            java.lang.String r4 = r4.a()     // Catch:{ all -> 0x0423 }
            com.squareup.picasso.ai.a(r1, r3, r4)     // Catch:{ all -> 0x0423 }
        L_0x03e9:
            com.squareup.picasso.z r1 = r2.f45399g     // Catch:{ all -> 0x0423 }
            boolean r1 = r1.e()     // Catch:{ all -> 0x0423 }
            if (r1 == 0) goto L_0x040f
            com.squareup.picasso.z r1 = r2.f45399g     // Catch:{ all -> 0x0423 }
            java.util.List<com.squareup.picasso.ah> r1 = r1.f45482g     // Catch:{ all -> 0x0423 }
            android.graphics.Bitmap r0 = a(r1, r0)     // Catch:{ all -> 0x0423 }
            com.squareup.picasso.w r1 = r2.f45394b     // Catch:{ all -> 0x0423 }
            boolean r1 = r1.n     // Catch:{ all -> 0x0423 }
            if (r1 == 0) goto L_0x040f
            java.lang.String r1 = "Hunter"
            java.lang.String r3 = "transformed"
            com.squareup.picasso.z r4 = r2.f45399g     // Catch:{ all -> 0x0423 }
            java.lang.String r4 = r4.a()     // Catch:{ all -> 0x0423 }
            java.lang.String r5 = "from custom transformations"
            com.squareup.picasso.ai.a(r1, r3, r4, r5)     // Catch:{ all -> 0x0423 }
        L_0x040f:
            monitor-exit(r20)     // Catch:{ all -> 0x0423 }
            if (r0 == 0) goto L_0x0428
            com.squareup.picasso.ad r1 = r2.f45397e
            r3 = 3
            r1.a(r0, r3)
            goto L_0x0428
        L_0x0419:
            r0 = move-exception
        L_0x041a:
            r2 = r32
            goto L_0x0421
        L_0x041d:
            r0 = move-exception
            r20 = r2
            r2 = r1
        L_0x0421:
            monitor-exit(r20)     // Catch:{ all -> 0x0423 }
            throw r0
        L_0x0423:
            r0 = move-exception
            goto L_0x0421
        L_0x0425:
            r2 = r1
            r1 = r0
            r0 = r1
        L_0x0428:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.c.a():android.graphics.Bitmap");
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        boolean z;
        boolean z2 = true;
        if (this.k == aVar) {
            this.k = null;
            z = true;
        } else {
            List<a> list = this.l;
            if (list != null) {
                z = list.remove(aVar);
            } else {
                z = false;
            }
        }
        if (z && aVar.f45342b.t == this.s) {
            w.e eVar = w.e.LOW;
            List<a> list2 = this.l;
            boolean z3 = list2 != null && !list2.isEmpty();
            if (this.k == null && !z3) {
                z2 = false;
            }
            if (z2) {
                a aVar2 = this.k;
                if (aVar2 != null) {
                    eVar = aVar2.f45342b.t;
                }
                if (z3) {
                    int size = this.l.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        w.e eVar2 = this.l.get(i2).f45342b.t;
                        if (eVar2.ordinal() > eVar.ordinal()) {
                            eVar = eVar2;
                        }
                    }
                }
            }
            this.s = eVar;
        }
        if (this.f45394b.n) {
            ai.a("Hunter", "removed", aVar.f45342b.a(), ai.a(this, "from "));
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        List<a> list;
        Future<?> future;
        if (this.k != null || (((list = this.l) != null && !list.isEmpty()) || (future = this.n) == null || !future.cancel(false))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        Future<?> future = this.n;
        return future != null && future.isCancelled();
    }

    private static Bitmap a(List<ah> list, Bitmap bitmap) {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            final ah ahVar = list.get(i2);
            try {
                Bitmap transform = ahVar.transform(bitmap);
                if (transform == null) {
                    final StringBuilder sb = new StringBuilder("Transformation ");
                    sb.append(ahVar.key());
                    sb.append(" returned null after ");
                    sb.append(i2);
                    sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (ah key : list) {
                        sb.append(key.key());
                        sb.append(10);
                    }
                    w.f45444a.post(new Runnable() {
                        public final void run() {
                            throw new NullPointerException(sb.toString());
                        }
                    });
                    return null;
                } else if (transform == bitmap && bitmap.isRecycled()) {
                    w.f45444a.post(new Runnable() {
                        public final void run() {
                            throw new IllegalStateException("Transformation " + ahVar.key() + " returned input Bitmap but recycled it.");
                        }
                    });
                    return null;
                } else if (transform == bitmap || bitmap.isRecycled()) {
                    i2++;
                    bitmap = transform;
                } else {
                    w.f45444a.post(new Runnable() {
                        public final void run() {
                            throw new IllegalStateException("Transformation " + ahVar.key() + " mutated input Bitmap but failed to recycle the original.");
                        }
                    });
                    return null;
                }
            } catch (RuntimeException e2) {
                w.f45444a.post(new Runnable() {
                    public final void run() {
                        throw new RuntimeException("Transformation " + ahVar.key() + " crashed with exception.", e2);
                    }
                });
                return null;
            }
        }
        return bitmap;
    }

    static c a(w wVar, i iVar, d dVar, ad adVar, a aVar) {
        z zVar = aVar.f45342b;
        List<ab> list = wVar.f45447d;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ab abVar = list.get(i2);
            if (abVar.a(zVar)) {
                return new c(wVar, iVar, dVar, adVar, aVar, abVar);
            }
        }
        return new c(wVar, iVar, dVar, adVar, aVar, w);
    }
}
