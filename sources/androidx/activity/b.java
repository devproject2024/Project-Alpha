package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f984a = false;

    /* renamed from: b  reason: collision with root package name */
    private CopyOnWriteArrayList<a> f985b = new CopyOnWriteArrayList<>();

    public abstract void b();

    public final void a() {
        Iterator<a> it2 = this.f985b.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        this.f985b.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public final void b(a aVar) {
        this.f985b.remove(aVar);
    }
}
