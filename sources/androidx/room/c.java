package androidx.room;

import androidx.sqlite.db.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class c<T> extends q {
    /* access modifiers changed from: protected */
    public abstract void bind(f fVar, T t);

    public c(j jVar) {
        super(jVar);
    }

    public final void insert(T t) {
        f acquire = acquire();
        try {
            bind(acquire, t);
            acquire.b();
        } finally {
            release(acquire);
        }
    }

    public final void insert(T[] tArr) {
        f acquire = acquire();
        try {
            for (T bind : tArr) {
                bind(acquire, bind);
                acquire.b();
            }
        } finally {
            release(acquire);
        }
    }

    public final void insert(Iterable<? extends T> iterable) {
        f acquire = acquire();
        try {
            for (Object bind : iterable) {
                bind(acquire, bind);
                acquire.b();
            }
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(T t) {
        f acquire = acquire();
        try {
            bind(acquire, t);
            return acquire.b();
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> collection) {
        f acquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            int i2 = 0;
            for (Object bind : collection) {
                bind(acquire, bind);
                jArr[i2] = acquire.b();
                i2++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] tArr) {
        f acquire = acquire();
        try {
            long[] jArr = new long[tArr.length];
            int i2 = 0;
            for (T bind : tArr) {
                bind(acquire, bind);
                jArr[i2] = acquire.b();
                i2++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        f acquire = acquire();
        try {
            Long[] lArr = new Long[collection.size()];
            int i2 = 0;
            for (Object bind : collection) {
                bind(acquire, bind);
                lArr[i2] = Long.valueOf(acquire.b());
                i2++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] tArr) {
        f acquire = acquire();
        try {
            Long[] lArr = new Long[tArr.length];
            int i2 = 0;
            for (T bind : tArr) {
                bind(acquire, bind);
                lArr[i2] = Long.valueOf(acquire.b());
                i2++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] tArr) {
        f acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(tArr.length);
            int i2 = 0;
            for (T bind : tArr) {
                bind(acquire, bind);
                arrayList.add(i2, Long.valueOf(acquire.b()));
                i2++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> collection) {
        f acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(collection.size());
            int i2 = 0;
            for (Object bind : collection) {
                bind(acquire, bind);
                arrayList.add(i2, Long.valueOf(acquire.b()));
                i2++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }
}
