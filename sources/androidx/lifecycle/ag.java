package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.k;

public final class ag<T> extends y<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f21321a = new AtomicBoolean(false);

    static final class a<T> implements z<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ag f21322a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z f21323b;

        a(ag agVar, z zVar) {
            this.f21322a = agVar;
            this.f21323b = zVar;
        }

        public final void onChanged(T t) {
            if (this.f21322a.f21321a.compareAndSet(true, false)) {
                this.f21323b.onChanged(t);
            }
        }
    }

    public final void observe(q qVar, z<? super T> zVar) {
        k.c(qVar, "owner");
        k.c(zVar, "observer");
        super.observe(qVar, new a(this, zVar));
    }

    public final void setValue(T t) {
        this.f21321a.set(true);
        super.setValue(t);
    }
}
