package d.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

final class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final i f45968a = new i();

    /* renamed from: b  reason: collision with root package name */
    private final int f45969b = 10;

    /* renamed from: c  reason: collision with root package name */
    private final c f45970c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f45971d;

    f(c cVar, Looper looper) {
        super(looper);
        this.f45970c = cVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(m mVar, Object obj) {
        h a2 = h.a(mVar, obj);
        synchronized (this) {
            this.f45968a.a(a2);
            if (!this.f45971d) {
                this.f45971d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new e("Could not send handler message");
                }
            }
        }
    }

    public final void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                h a2 = this.f45968a.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f45968a.a();
                        if (a2 == null) {
                            this.f45971d = false;
                            this.f45971d = false;
                            return;
                        }
                    }
                }
                this.f45970c.a(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f45969b));
            if (sendMessage(obtainMessage())) {
                this.f45971d = true;
                return;
            }
            throw new e("Could not send handler message");
        } catch (Throwable th) {
            this.f45971d = false;
            throw th;
        }
    }
}
