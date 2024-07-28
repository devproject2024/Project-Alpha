package net.one97.paytm.fastscanner.b;

import android.content.Context;
import android.net.Uri;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.gms.common.c;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import kotlin.g.b.k;
import net.one97.paytm.fastscanner.R;
import net.one97.paytm.fastscanner.c.a;

public class f {

    /* renamed from: b  reason: collision with root package name */
    private static volatile f f50436b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f50437a = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private HandlerThread f50438c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f50439d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f50440e = false;

    /* renamed from: f  reason: collision with root package name */
    private long f50441f;

    /* renamed from: g  reason: collision with root package name */
    private long f50442g;

    /* renamed from: h  reason: collision with root package name */
    private long f50443h;

    private f() {
    }

    public final void a(Context context) {
        this.f50441f = System.currentTimeMillis();
        a aVar = a.f50448b;
        this.f50442g = a.h().getMinDiffToProcessBitmap();
        this.f50438c = new HandlerThread(f.class.getSimpleName());
        this.f50438c.start();
        this.f50437a.clear();
        this.f50437a.add(new net.one97.paytm.fastscanner.e.a(this.f50438c));
        if (c.a().a(context) == 0) {
            this.f50437a.add(new net.one97.paytm.fastscanner.d.a(this.f50438c));
        }
    }

    public static f a() {
        if (f50436b == null) {
            synchronized (f.class) {
                if (f50436b == null) {
                    f50436b = new f();
                }
            }
        }
        return f50436b;
    }

    public final void b() {
        for (int i2 = 0; i2 < this.f50437a.size(); i2++) {
            a aVar = this.f50437a.get(i2);
            Message.obtain(aVar, R.id.quit).sendToTarget();
            aVar.removeMessages(R.id.decode);
            aVar.removeMessages(R.id.quit);
        }
        this.f50437a.clear();
        HandlerThread handlerThread = this.f50438c;
        if (handlerThread != null && handlerThread.isAlive()) {
            this.f50438c.quit();
        }
        this.f50438c = null;
        this.f50440e = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072 A[LOOP:0: B:23:0x006a->B:25:0x0072, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r10, int r11, int r12, byte[] r13, android.hardware.Camera.Parameters r14) {
        /*
            r9 = this;
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r9.f50441f
            long r2 = r0 - r2
            long r4 = r9.f50442g
            r6 = 1
            r7 = 0
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x002e
            net.one97.paytm.fastscanner.b.d r2 = net.one97.paytm.fastscanner.b.d.f50426a
            boolean r2 = net.one97.paytm.fastscanner.b.d.h()
            if (r2 != 0) goto L_0x002e
            net.one97.paytm.fastscanner.c.a r2 = net.one97.paytm.fastscanner.c.a.f50448b
            net.one97.paytm.fastscanner.c.d r2 = net.one97.paytm.fastscanner.c.a.b()
            if (r2 == 0) goto L_0x002e
            net.one97.paytm.fastscanner.c.a r2 = net.one97.paytm.fastscanner.c.a.f50448b
            net.one97.paytm.fastscanner.c.d r2 = net.one97.paytm.fastscanner.c.a.b()
            boolean r2 = r2.aI_()
            if (r2 == 0) goto L_0x002e
            r2 = 1
            goto L_0x002f
        L_0x002e:
            r2 = 0
        L_0x002f:
            if (r2 == 0) goto L_0x006a
            if (r13 == 0) goto L_0x006a
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()
            long r2 = r2.maxMemory()
            r4 = 1024(0x400, double:5.06E-321)
            long r2 = r2 / r4
            int r3 = (int) r2
            r2 = 1024(0x400, float:1.435E-42)
            if (r3 < r2) goto L_0x0045
            r2 = 1
            goto L_0x0046
        L_0x0045:
            r2 = 0
        L_0x0046:
            if (r2 == 0) goto L_0x0050
            net.one97.paytm.fastscanner.b.c r2 = net.one97.paytm.fastscanner.b.c.f50425a
            net.one97.paytm.fastscanner.b.c.a(r13, r14, r11, r12)
            r9.f50441f = r0
            goto L_0x006a
        L_0x0050:
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r9.f50443h
            long r0 = r0 - r2
            r2 = 5000(0x1388, double:2.4703E-320)
            int r14 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r14 < 0) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r6 = 0
        L_0x005f:
            if (r6 == 0) goto L_0x006a
            java.lang.System.gc()
            long r0 = java.lang.System.currentTimeMillis()
            r9.f50443h = r0
        L_0x006a:
            java.util.ArrayList<net.one97.paytm.fastscanner.b.a> r14 = r9.f50437a
            int r14 = r14.size()
            if (r7 >= r14) goto L_0x0084
            java.util.ArrayList<net.one97.paytm.fastscanner.b.a> r14 = r9.f50437a
            java.lang.Object r14 = r14.get(r7)
            net.one97.paytm.fastscanner.b.a r14 = (net.one97.paytm.fastscanner.b.a) r14
            android.os.Message r14 = r14.obtainMessage(r10, r11, r12, r13)
            r14.sendToTarget()
            int r7 = r7 + 1
            goto L_0x006a
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.fastscanner.b.f.a(int, int, int, byte[], android.hardware.Camera$Parameters):void");
    }

    public final void a(final int i2, final Uri uri) {
        this.f50440e = false;
        new Thread(new Runnable() {
            public final void run() {
                f fVar = f.this;
                CountDownLatch unused = fVar.f50439d = new CountDownLatch(fVar.f50437a.size());
                for (int i2 = 0; i2 < f.this.f50437a.size(); i2++) {
                    a aVar = (a) f.this.f50437a.get(i2);
                    CountDownLatch b2 = f.this.f50439d;
                    k.c(b2, "<set-?>");
                    aVar.f50422a = b2;
                    aVar.obtainMessage(i2, uri).sendToTarget();
                }
                try {
                    f.this.f50439d.await();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (!f.this.f50440e) {
                    d dVar = d.f50426a;
                    Message.obtain(d.b(), R.id.exception).sendToTarget();
                }
            }
        }).start();
    }

    public final void c() {
        if (this.f50439d.getCount() != 0) {
            this.f50440e = true;
            while (this.f50439d.getCount() > 0) {
                this.f50439d.countDown();
            }
        }
    }
}
