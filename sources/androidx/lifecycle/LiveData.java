package androidx.lifecycle;

import androidx.lifecycle.k;
import java.util.Iterator;
import java.util.Map;

public abstract class LiveData<T> {
    static final Object NOT_SET = new Object();
    static final int START_VERSION = -1;
    int mActiveCount;
    private volatile Object mData;
    final Object mDataLock;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private androidx.arch.core.b.b<z<? super T>, LiveData<T>.defpackage.b> mObservers;
    volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;

    /* access modifiers changed from: protected */
    public void onActive() {
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
    }

    public LiveData(T t) {
        this.mDataLock = new Object();
        this.mObservers = new androidx.arch.core.b.b<>();
        this.mActiveCount = 0;
        this.mPendingData = NOT_SET;
        this.mPostValueRunnable = new Runnable() {
            public final void run() {
                Object obj;
                synchronized (LiveData.this.mDataLock) {
                    obj = LiveData.this.mPendingData;
                    LiveData.this.mPendingData = LiveData.NOT_SET;
                }
                LiveData.this.setValue(obj);
            }
        };
        this.mData = t;
        this.mVersion = 0;
    }

    public LiveData() {
        this.mDataLock = new Object();
        this.mObservers = new androidx.arch.core.b.b<>();
        this.mActiveCount = 0;
        this.mPendingData = NOT_SET;
        this.mPostValueRunnable = new Runnable() {
            public final void run() {
                Object obj;
                synchronized (LiveData.this.mDataLock) {
                    obj = LiveData.this.mPendingData;
                    LiveData.this.mPendingData = LiveData.NOT_SET;
                }
                LiveData.this.setValue(obj);
            }
        };
        this.mData = NOT_SET;
        this.mVersion = -1;
    }

    private void considerNotify(LiveData<T>.defpackage.b bVar) {
        if (bVar.f3592d) {
            if (!bVar.a()) {
                bVar.a(false);
                return;
            }
            int i2 = bVar.f3593e;
            int i3 = this.mVersion;
            if (i2 < i3) {
                bVar.f3593e = i3;
                bVar.f3591c.onChanged(this.mData);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchingValue(LiveData<T>.defpackage.b bVar) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (bVar == null) {
                androidx.arch.core.b.b<K, V>.d a2 = this.mObservers.a();
                while (a2.hasNext()) {
                    considerNotify((b) ((Map.Entry) a2.next()).getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            } else {
                considerNotify(bVar);
                bVar = null;
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    public void observe(q qVar, z<? super T> zVar) {
        assertMainThread("observe");
        if (qVar.getLifecycle().a() != k.b.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(qVar, zVar);
            b a2 = this.mObservers.a(zVar, lifecycleBoundObserver);
            if (a2 != null && !a2.a(qVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (a2 == null) {
                qVar.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    public void observeForever(z<? super T> zVar) {
        assertMainThread("observeForever");
        a aVar = new a(zVar);
        b a2 = this.mObservers.a(zVar, aVar);
        if (a2 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (a2 == null) {
            aVar.a(true);
        }
    }

    public void removeObserver(z<? super T> zVar) {
        assertMainThread("removeObserver");
        b b2 = this.mObservers.b(zVar);
        if (b2 != null) {
            b2.b();
            b2.a(false);
        }
    }

    public void removeObservers(q qVar) {
        assertMainThread("removeObservers");
        Iterator<Map.Entry<z<? super T>, LiveData<T>.defpackage.b>> it2 = this.mObservers.iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            if (((b) next.getValue()).a(qVar)) {
                removeObserver((z) next.getKey());
            }
        }
    }

    public void postValue(T t) {
        boolean z;
        synchronized (this.mDataLock) {
            z = this.mPendingData == NOT_SET;
            this.mPendingData = t;
        }
        if (z) {
            androidx.arch.core.a.a.a().b(this.mPostValueRunnable);
        }
    }

    public void setValue(T t) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = t;
        dispatchingValue((LiveData<T>.defpackage.b) null);
    }

    public T getValue() {
        T t = this.mData;
        if (t != NOT_SET) {
            return t;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getVersion() {
        return this.mVersion;
    }

    public boolean hasObservers() {
        return this.mObservers.f1855e > 0;
    }

    public boolean hasActiveObservers() {
        return this.mActiveCount > 0;
    }

    class LifecycleBoundObserver extends LiveData<T>.defpackage.b implements o {

        /* renamed from: a  reason: collision with root package name */
        final q f3588a;

        LifecycleBoundObserver(q qVar, z<? super T> zVar) {
            super(zVar);
            this.f3588a = qVar;
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return this.f3588a.getLifecycle().a().isAtLeast(k.b.STARTED);
        }

        public final void a(q qVar, k.a aVar) {
            if (this.f3588a.getLifecycle().a() == k.b.DESTROYED) {
                LiveData.this.removeObserver(this.f3591c);
            } else {
                a(a());
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean a(q qVar) {
            return this.f3588a == qVar;
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            this.f3588a.getLifecycle().b(this);
        }
    }

    abstract class b {

        /* renamed from: c  reason: collision with root package name */
        final z<? super T> f3591c;

        /* renamed from: d  reason: collision with root package name */
        boolean f3592d;

        /* renamed from: e  reason: collision with root package name */
        int f3593e = -1;

        /* access modifiers changed from: package-private */
        public abstract boolean a();

        /* access modifiers changed from: package-private */
        public boolean a(q qVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void b() {
        }

        b(z<? super T> zVar) {
            this.f3591c = zVar;
        }

        /* access modifiers changed from: package-private */
        public final void a(boolean z) {
            if (z != this.f3592d) {
                this.f3592d = z;
                int i2 = 1;
                boolean z2 = LiveData.this.mActiveCount == 0;
                LiveData liveData = LiveData.this;
                int i3 = liveData.mActiveCount;
                if (!this.f3592d) {
                    i2 = -1;
                }
                liveData.mActiveCount = i3 + i2;
                if (z2 && this.f3592d) {
                    LiveData.this.onActive();
                }
                if (LiveData.this.mActiveCount == 0 && !this.f3592d) {
                    LiveData.this.onInactive();
                }
                if (this.f3592d) {
                    LiveData.this.dispatchingValue(this);
                }
            }
        }
    }

    class a extends LiveData<T>.defpackage.b {
        /* access modifiers changed from: package-private */
        public final boolean a() {
            return true;
        }

        a(z<? super T> zVar) {
            super(zVar);
        }
    }

    static void assertMainThread(String str) {
        if (!androidx.arch.core.a.a.a().f1844a.d()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }
}
