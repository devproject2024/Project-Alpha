package androidx.lifecycle;

import androidx.arch.core.c.a;

public final class ah {
    public static <X, Y> LiveData<Y> a(LiveData<X> liveData, final a<X, Y> aVar) {
        final w wVar = new w();
        wVar.addSource(liveData, new z<X>() {
            public final void onChanged(X x) {
                wVar.setValue(aVar.apply(x));
            }
        });
        return wVar;
    }

    public static <X, Y> LiveData<Y> b(LiveData<X> liveData, final a<X, LiveData<Y>> aVar) {
        final w wVar = new w();
        wVar.addSource(liveData, new z<X>() {

            /* renamed from: a  reason: collision with root package name */
            LiveData<Y> f3635a;

            public final void onChanged(X x) {
                LiveData<Y> liveData = (LiveData) aVar.apply(x);
                LiveData<Y> liveData2 = this.f3635a;
                if (liveData2 != liveData) {
                    if (liveData2 != null) {
                        wVar.removeSource(liveData2);
                    }
                    this.f3635a = liveData;
                    LiveData<Y> liveData3 = this.f3635a;
                    if (liveData3 != null) {
                        wVar.addSource(liveData3, new z<Y>() {
                            public final void onChanged(Y y) {
                                wVar.setValue(y);
                            }
                        });
                    }
                }
            }
        });
        return wVar;
    }
}
