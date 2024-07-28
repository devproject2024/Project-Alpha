package com.bumptech.glide.g.a;

import android.util.Log;
import androidx.core.g.e;
import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final d<Object> f6598a = new d<Object>() {
        public final void a(Object obj) {
        }
    };

    /* renamed from: com.bumptech.glide.g.a.a$a  reason: collision with other inner class name */
    public interface C0091a<T> {
        T a();
    }

    public interface c {
        b e_();
    }

    public interface d<T> {
        void a(T t);
    }

    public static <T extends c> e.a<T> a(int i2, C0091a<T> aVar) {
        return a(new e.c(i2), aVar, f6598a);
    }

    private static <T> e.a<T> a(e.a<T> aVar, C0091a<T> aVar2, d<T> dVar) {
        return new b(aVar, aVar2, dVar);
    }

    static final class b<T> implements e.a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final C0091a<T> f6599a;

        /* renamed from: b  reason: collision with root package name */
        private final d<T> f6600b;

        /* renamed from: c  reason: collision with root package name */
        private final e.a<T> f6601c;

        b(e.a<T> aVar, C0091a<T> aVar2, d<T> dVar) {
            this.f6601c = aVar;
            this.f6599a = aVar2;
            this.f6600b = dVar;
        }

        public final T a() {
            T a2 = this.f6601c.a();
            if (a2 == null) {
                a2 = this.f6599a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    new StringBuilder("Created new ").append(a2.getClass());
                }
            }
            if (a2 instanceof c) {
                ((c) a2).e_().a(false);
            }
            return a2;
        }

        public final boolean a(T t) {
            if (t instanceof c) {
                ((c) t).e_().a(true);
            }
            this.f6600b.a(t);
            return this.f6601c.a(t);
        }
    }

    public static <T> e.a<List<T>> a() {
        return a(new e.c(20), new C0091a<List<T>>() {
            public final /* synthetic */ Object a() {
                return new ArrayList();
            }
        }, new d<List<T>>() {
            public final /* synthetic */ void a(Object obj) {
                ((List) obj).clear();
            }
        });
    }
}
