package androidx.room;

import androidx.sqlite.db.f;

public abstract class b<T> extends q {
    /* access modifiers changed from: protected */
    public abstract void bind(f fVar, T t);

    /* access modifiers changed from: protected */
    public abstract String createQuery();

    public b(j jVar) {
        super(jVar);
    }

    public final int handle(T t) {
        f acquire = acquire();
        try {
            bind(acquire, t);
            return acquire.a();
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(Iterable<? extends T> iterable) {
        f acquire = acquire();
        int i2 = 0;
        try {
            for (Object bind : iterable) {
                bind(acquire, bind);
                i2 += acquire.a();
            }
            return i2;
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(T[] tArr) {
        f acquire = acquire();
        try {
            int i2 = 0;
            for (T bind : tArr) {
                bind(acquire, bind);
                i2 += acquire.a();
            }
            return i2;
        } finally {
            release(acquire);
        }
    }
}
