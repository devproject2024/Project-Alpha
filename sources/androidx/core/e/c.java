package androidx.core.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.paytm.business.merchantprofile.common.utility.AppConstants;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    final Object f2895a = new Object();

    /* renamed from: b  reason: collision with root package name */
    HandlerThread f2896b;

    /* renamed from: c  reason: collision with root package name */
    Handler f2897c;

    /* renamed from: d  reason: collision with root package name */
    final int f2898d;

    /* renamed from: e  reason: collision with root package name */
    private int f2899e;

    /* renamed from: f  reason: collision with root package name */
    private Handler.Callback f2900f = new Handler.Callback() {
        public final boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                c cVar = c.this;
                synchronized (cVar.f2895a) {
                    if (!cVar.f2897c.hasMessages(1)) {
                        cVar.f2896b.quit();
                        cVar.f2896b = null;
                        cVar.f2897c = null;
                    }
                }
                return true;
            } else if (i2 != 1) {
                return true;
            } else {
                c cVar2 = c.this;
                ((Runnable) message.obj).run();
                synchronized (cVar2.f2895a) {
                    cVar2.f2897c.removeMessages(0);
                    cVar2.f2897c.sendMessageDelayed(cVar2.f2897c.obtainMessage(0), (long) cVar2.f2898d);
                }
                return true;
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final int f2901g;

    /* renamed from: h  reason: collision with root package name */
    private final String f2902h;

    public interface a<T> {
        void a(T t);
    }

    public c(String str) {
        this.f2902h = str;
        this.f2901g = 10;
        this.f2898d = AppConstants.START_OTP_FLOW;
        this.f2899e = 0;
    }

    /* access modifiers changed from: package-private */
    public final void a(Runnable runnable) {
        synchronized (this.f2895a) {
            if (this.f2896b == null) {
                this.f2896b = new HandlerThread(this.f2902h, this.f2901g);
                this.f2896b.start();
                this.f2897c = new Handler(this.f2896b.getLooper(), this.f2900f);
                this.f2899e++;
            }
            this.f2897c.removeMessages(0);
            this.f2897c.sendMessage(this.f2897c.obtainMessage(1, runnable));
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:9|10|11|12|(4:25|14|15|16)(1:17)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T a(java.util.concurrent.Callable<T> r13, int r14) throws java.lang.InterruptedException {
        /*
            r12 = this;
            java.util.concurrent.locks.ReentrantLock r7 = new java.util.concurrent.locks.ReentrantLock
            r7.<init>()
            java.util.concurrent.locks.Condition r8 = r7.newCondition()
            java.util.concurrent.atomic.AtomicReference r9 = new java.util.concurrent.atomic.AtomicReference
            r9.<init>()
            java.util.concurrent.atomic.AtomicBoolean r10 = new java.util.concurrent.atomic.AtomicBoolean
            r0 = 1
            r10.<init>(r0)
            androidx.core.e.c$3 r11 = new androidx.core.e.c$3
            r0 = r11
            r1 = r12
            r2 = r9
            r3 = r13
            r4 = r7
            r5 = r10
            r6 = r8
            r0.<init>(r2, r3, r4, r5, r6)
            r12.a(r11)
            r7.lock()
            boolean r13 = r10.get()     // Catch:{ all -> 0x005d }
            if (r13 != 0) goto L_0x0034
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x005d }
            r7.unlock()
            return r13
        L_0x0034:
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x005d }
            long r0 = (long) r14     // Catch:{ all -> 0x005d }
            long r13 = r13.toNanos(r0)     // Catch:{ all -> 0x005d }
        L_0x003b:
            long r13 = r8.awaitNanos(r13)     // Catch:{ InterruptedException -> 0x003f }
        L_0x003f:
            boolean r0 = r10.get()     // Catch:{ all -> 0x005d }
            if (r0 != 0) goto L_0x004d
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x005d }
            r7.unlock()
            return r13
        L_0x004d:
            r0 = 0
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0054
            goto L_0x003b
        L_0x0054:
            java.lang.InterruptedException r13 = new java.lang.InterruptedException     // Catch:{ all -> 0x005d }
            java.lang.String r14 = "timeout"
            r13.<init>(r14)     // Catch:{ all -> 0x005d }
            throw r13     // Catch:{ all -> 0x005d }
        L_0x005d:
            r13 = move-exception
            r7.unlock()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.e.c.a(java.util.concurrent.Callable, int):java.lang.Object");
    }
}
