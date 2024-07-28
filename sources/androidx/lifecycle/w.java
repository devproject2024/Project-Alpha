package androidx.lifecycle;

import androidx.arch.core.b.b;
import java.util.Iterator;
import java.util.Map;

public class w<T> extends y<T> {
    private b<LiveData<?>, a<?>> mSources = new b<>();

    public <S> void addSource(LiveData<S> liveData, z<? super S> zVar) {
        a aVar = new a(liveData, zVar);
        a a2 = this.mSources.a(liveData, aVar);
        if (a2 != null && a2.f3689b != zVar) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        } else if (a2 == null && hasActiveObservers()) {
            aVar.a();
        }
    }

    public <S> void removeSource(LiveData<S> liveData) {
        a b2 = this.mSources.b(liveData);
        if (b2 != null) {
            b2.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onActive() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it2 = this.mSources.iterator();
        while (it2.hasNext()) {
            ((a) it2.next().getValue()).a();
        }
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it2 = this.mSources.iterator();
        while (it2.hasNext()) {
            ((a) it2.next().getValue()).b();
        }
    }

    static class a<V> implements z<V> {

        /* renamed from: a  reason: collision with root package name */
        final LiveData<V> f3688a;

        /* renamed from: b  reason: collision with root package name */
        final z<? super V> f3689b;

        /* renamed from: c  reason: collision with root package name */
        int f3690c = -1;

        a(LiveData<V> liveData, z<? super V> zVar) {
            this.f3688a = liveData;
            this.f3689b = zVar;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f3688a.observeForever(this);
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            this.f3688a.removeObserver(this);
        }

        public final void onChanged(V v) {
            if (this.f3690c != this.f3688a.getVersion()) {
                this.f3690c = this.f3688a.getVersion();
                this.f3689b.onChanged(v);
            }
        }
    }
}
