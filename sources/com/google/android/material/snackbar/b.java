package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

final class b {

    /* renamed from: e  reason: collision with root package name */
    private static b f36704e;

    /* renamed from: a  reason: collision with root package name */
    final Object f36705a = new Object();

    /* renamed from: b  reason: collision with root package name */
    final Handler f36706b = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public final boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b bVar = b.this;
            C0609b bVar2 = (C0609b) message.obj;
            synchronized (bVar.f36705a) {
                if (bVar.f36707c == bVar2 || bVar.f36708d == bVar2) {
                    bVar.a(bVar2, 2);
                }
            }
            return true;
        }
    });

    /* renamed from: c  reason: collision with root package name */
    C0609b f36707c;

    /* renamed from: d  reason: collision with root package name */
    C0609b f36708d;

    interface a {
        void a();

        void a(int i2);
    }

    static b a() {
        if (f36704e == null) {
            f36704e = new b();
        }
        return f36704e;
    }

    private b() {
    }

    public final void a(a aVar, int i2) {
        synchronized (this.f36705a) {
            if (f(aVar)) {
                a(this.f36707c, i2);
            } else if (g(aVar)) {
                a(this.f36708d, i2);
            }
        }
    }

    public final void a(a aVar) {
        synchronized (this.f36705a) {
            if (f(aVar)) {
                a(this.f36707c);
            }
        }
    }

    public final void b(a aVar) {
        synchronized (this.f36705a) {
            if (f(aVar) && !this.f36707c.f36712c) {
                this.f36707c.f36712c = true;
                this.f36706b.removeCallbacksAndMessages(this.f36707c);
            }
        }
    }

    public final void c(a aVar) {
        synchronized (this.f36705a) {
            if (f(aVar) && this.f36707c.f36712c) {
                this.f36707c.f36712c = false;
                a(this.f36707c);
            }
        }
    }

    public final boolean d(a aVar) {
        boolean f2;
        synchronized (this.f36705a) {
            f2 = f(aVar);
        }
        return f2;
    }

    public final boolean e(a aVar) {
        boolean z;
        synchronized (this.f36705a) {
            if (!f(aVar)) {
                if (!g(aVar)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    /* renamed from: com.google.android.material.snackbar.b$b  reason: collision with other inner class name */
    static class C0609b {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<a> f36710a;

        /* renamed from: b  reason: collision with root package name */
        int f36711b;

        /* renamed from: c  reason: collision with root package name */
        boolean f36712c;

        C0609b(int i2, a aVar) {
            this.f36710a = new WeakReference<>(aVar);
            this.f36711b = i2;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(a aVar) {
            return aVar != null && this.f36710a.get() == aVar;
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        C0609b bVar = this.f36708d;
        if (bVar != null) {
            this.f36707c = bVar;
            this.f36708d = null;
            a aVar = (a) this.f36707c.f36710a.get();
            if (aVar != null) {
                aVar.a();
            } else {
                this.f36707c = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(C0609b bVar, int i2) {
        a aVar = (a) bVar.f36710a.get();
        if (aVar == null) {
            return false;
        }
        this.f36706b.removeCallbacksAndMessages(bVar);
        aVar.a(i2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean f(a aVar) {
        C0609b bVar = this.f36707c;
        return bVar != null && bVar.a(aVar);
    }

    /* access modifiers changed from: package-private */
    public final boolean g(a aVar) {
        C0609b bVar = this.f36708d;
        return bVar != null && bVar.a(aVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(C0609b bVar) {
        if (bVar.f36711b != -2) {
            int i2 = 2750;
            if (bVar.f36711b > 0) {
                i2 = bVar.f36711b;
            } else if (bVar.f36711b == -1) {
                i2 = 1500;
            }
            this.f36706b.removeCallbacksAndMessages(bVar);
            Handler handler = this.f36706b;
            handler.sendMessageDelayed(Message.obtain(handler, 0, bVar), (long) i2);
        }
    }
}
