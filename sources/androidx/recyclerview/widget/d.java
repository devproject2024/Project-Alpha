package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public final class d<T> {

    /* renamed from: h  reason: collision with root package name */
    private static final Executor f4180h = new b();

    /* renamed from: a  reason: collision with root package name */
    final s f4181a;

    /* renamed from: b  reason: collision with root package name */
    final c<T> f4182b;

    /* renamed from: c  reason: collision with root package name */
    Executor f4183c;

    /* renamed from: d  reason: collision with root package name */
    final List<a<T>> f4184d = new CopyOnWriteArrayList();

    /* renamed from: e  reason: collision with root package name */
    List<T> f4185e;

    /* renamed from: f  reason: collision with root package name */
    List<T> f4186f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    int f4187g;

    public interface a<T> {
    }

    static class b implements Executor {

        /* renamed from: a  reason: collision with root package name */
        final Handler f4196a = new Handler(Looper.getMainLooper());

        b() {
        }

        public final void execute(Runnable runnable) {
            this.f4196a.post(runnable);
        }
    }

    public d(s sVar, c<T> cVar) {
        this.f4181a = sVar;
        this.f4182b = cVar;
        if (cVar.f4172a != null) {
            this.f4183c = cVar.f4172a;
        } else {
            this.f4183c = f4180h;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Runnable runnable) {
        Iterator<a<T>> it2 = this.f4184d.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
        if (runnable != null) {
            runnable.run();
        }
    }
}
