package androidx.dynamicanimation.a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.a.g;
import java.util.ArrayList;

final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<a> f14543a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    final g<b, Long> f14544b = new g<>();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<b> f14545c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    long f14546d = 0;

    /* renamed from: e  reason: collision with root package name */
    boolean f14547e = false;

    /* renamed from: f  reason: collision with root package name */
    private final C0198a f14548f = new C0198a();

    /* renamed from: g  reason: collision with root package name */
    private c f14549g;

    interface b {
        boolean a(long j);
    }

    a() {
    }

    /* renamed from: androidx.dynamicanimation.a.a$a  reason: collision with other inner class name */
    class C0198a {
        C0198a() {
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            a.this.f14546d = SystemClock.uptimeMillis();
            a aVar = a.this;
            long j = aVar.f14546d;
            long uptimeMillis = SystemClock.uptimeMillis();
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (i2 >= aVar.f14545c.size()) {
                    break;
                }
                b bVar = aVar.f14545c.get(i2);
                if (bVar != null) {
                    Long l = aVar.f14544b.get(bVar);
                    if (l != null) {
                        if (l.longValue() < uptimeMillis) {
                            aVar.f14544b.remove(bVar);
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        bVar.a(j);
                    }
                }
                i2++;
            }
            if (aVar.f14547e) {
                for (int size = aVar.f14545c.size() - 1; size >= 0; size--) {
                    if (aVar.f14545c.get(size) == null) {
                        aVar.f14545c.remove(size);
                    }
                }
                aVar.f14547e = false;
            }
            if (a.this.f14545c.size() > 0) {
                a.this.b().a();
            }
        }
    }

    public static a a() {
        if (f14543a.get() == null) {
            f14543a.set(new a());
        }
        return f14543a.get();
    }

    /* access modifiers changed from: package-private */
    public final c b() {
        if (this.f14549g == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f14549g = new e(this.f14548f);
            } else {
                this.f14549g = new d(this.f14548f);
            }
        }
        return this.f14549g;
    }

    static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        private final Choreographer f14556b = Choreographer.getInstance();

        /* renamed from: c  reason: collision with root package name */
        private final Choreographer.FrameCallback f14557c = new Choreographer.FrameCallback() {
            public final void doFrame(long j) {
                e.this.f14551a.a();
            }
        };

        e(C0198a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f14556b.postFrameCallback(this.f14557c);
        }
    }

    static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        long f14552b = -1;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f14553c = new Runnable() {
            public final void run() {
                d.this.f14552b = SystemClock.uptimeMillis();
                d.this.f14551a.a();
            }
        };

        /* renamed from: d  reason: collision with root package name */
        private final Handler f14554d = new Handler(Looper.myLooper());

        d(C0198a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f14554d.postDelayed(this.f14553c, Math.max(10 - (SystemClock.uptimeMillis() - this.f14552b), 0));
        }
    }

    static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final C0198a f14551a;

        /* access modifiers changed from: package-private */
        public abstract void a();

        c(C0198a aVar) {
            this.f14551a = aVar;
        }
    }
}
