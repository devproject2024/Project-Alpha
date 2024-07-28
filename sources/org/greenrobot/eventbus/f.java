package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

final class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final i f72874a = new i();

    /* renamed from: b  reason: collision with root package name */
    private final int f72875b = 10;

    /* renamed from: c  reason: collision with root package name */
    private final c f72876c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f72877d;

    f(c cVar, Looper looper) {
        super(looper);
        this.f72876c = cVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(n nVar, Object obj) {
        h a2 = h.a(nVar, obj);
        synchronized (this) {
            this.f72874a.a(a2);
            if (!this.f72877d) {
                this.f72877d = true;
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
                h a2 = this.f72874a.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f72874a.a();
                        if (a2 == null) {
                            this.f72877d = false;
                            this.f72877d = false;
                            return;
                        }
                    }
                }
                this.f72876c.a(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f72875b));
            if (sendMessage(obtainMessage())) {
                this.f72877d = true;
                return;
            }
            throw new e("Could not send handler message");
        } catch (Throwable th) {
            this.f72877d = false;
            throw th;
        }
    }
}
