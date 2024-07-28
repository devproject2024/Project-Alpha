package net.one97.paytm.upi.mandate.utils;

import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.k;

public final class s<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67415a = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private static final String f67416c = f67416c;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f67417b = new AtomicBoolean(false);

    public final void observe(q qVar, z<? super T> zVar) {
        k.c(qVar, "owner");
        k.c(zVar, "observer");
        hasActiveObservers();
        super.observe(qVar, new b(this, zVar));
    }

    static final class b<T> implements z<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f67418a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z f67419b;

        b(s sVar, z zVar) {
            this.f67418a = sVar;
            this.f67419b = zVar;
        }

        public final void onChanged(T t) {
            if (this.f67418a.f67417b.compareAndSet(true, false)) {
                this.f67419b.onChanged(t);
            }
        }
    }

    public final void setValue(T t) {
        this.f67417b.set(true);
        super.setValue(t);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
