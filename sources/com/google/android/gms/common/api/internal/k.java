package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.s;

public final class k<L> {

    /* renamed from: a  reason: collision with root package name */
    public volatile L f8617a;

    /* renamed from: b  reason: collision with root package name */
    public final a<L> f8618b;

    /* renamed from: c  reason: collision with root package name */
    private final c f8619c;

    public interface b<L> {
        void a(L l);
    }

    k(Looper looper, L l, String str) {
        this.f8619c = new c(looper);
        this.f8617a = s.a(l, (Object) "Listener must not be null");
        this.f8618b = new a<>(l, s.a(str));
    }

    final class c extends com.google.android.gms.internal.base.k {
        public c(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            s.b(z);
            b bVar = (b) message.obj;
            L l = k.this.f8617a;
            if (l != null) {
                try {
                    bVar.a(l);
                } catch (RuntimeException e2) {
                    throw e2;
                }
            }
        }
    }

    public static final class a<L> {

        /* renamed from: a  reason: collision with root package name */
        private final L f8620a;

        /* renamed from: b  reason: collision with root package name */
        private final String f8621b;

        a(L l, String str) {
            this.f8620a = l;
            this.f8621b = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f8620a == aVar.f8620a && this.f8621b.equals(aVar.f8621b);
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f8620a) * 31) + this.f8621b.hashCode();
        }
    }

    public final void a(b<? super L> bVar) {
        s.a(bVar, (Object) "Notifier must not be null");
        this.f8619c.sendMessage(this.f8619c.obtainMessage(1, bVar));
    }
}
