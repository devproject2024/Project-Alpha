package io.reactivex.rxjava3.android.b;

import android.os.Handler;
import android.os.Message;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.a.d;
import java.util.concurrent.TimeUnit;

final class b extends x {

    /* renamed from: b  reason: collision with root package name */
    private final Handler f46631b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f46632c = true;

    b(Handler handler) {
        this.f46631b = handler;
    }

    public final c a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit != null) {
            C0784b bVar = new C0784b(this.f46631b, io.reactivex.rxjava3.h.a.a(runnable));
            Message obtain = Message.obtain(this.f46631b, bVar);
            if (this.f46632c) {
                obtain.setAsynchronous(true);
            }
            this.f46631b.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            return bVar;
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public final x.c a() {
        return new a(this.f46631b, this.f46632c);
    }

    static final class a extends x.c {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f46633a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f46634b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f46635c;

        a(Handler handler, boolean z) {
            this.f46633a = handler;
            this.f46634b = z;
        }

        public final c a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.f46635c) {
                return d.INSTANCE;
            } else {
                C0784b bVar = new C0784b(this.f46633a, io.reactivex.rxjava3.h.a.a(runnable));
                Message obtain = Message.obtain(this.f46633a, bVar);
                obtain.obj = this;
                if (this.f46634b) {
                    obtain.setAsynchronous(true);
                }
                this.f46633a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (!this.f46635c) {
                    return bVar;
                }
                this.f46633a.removeCallbacks(bVar);
                return d.INSTANCE;
            }
        }

        public final void dispose() {
            this.f46635c = true;
            this.f46633a.removeCallbacksAndMessages(this);
        }

        public final boolean isDisposed() {
            return this.f46635c;
        }
    }

    /* renamed from: io.reactivex.rxjava3.android.b.b$b  reason: collision with other inner class name */
    static final class C0784b implements c, Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f46636a;

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f46637b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f46638c;

        C0784b(Handler handler, Runnable runnable) {
            this.f46636a = handler;
            this.f46637b = runnable;
        }

        public final void run() {
            try {
                this.f46637b.run();
            } catch (Throwable th) {
                io.reactivex.rxjava3.h.a.a(th);
            }
        }

        public final void dispose() {
            this.f46636a.removeCallbacks(this);
            this.f46638c = true;
        }

        public final boolean isDisposed() {
            return this.f46638c;
        }
    }
}
