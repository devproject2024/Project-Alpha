package h.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    protected List<h> f46262a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    protected List<h> f46263b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    protected List<Object> f46264c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    protected int f46265d = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f46266e = false;

    /* access modifiers changed from: package-private */
    public final synchronized void a(f fVar, Throwable th) {
        this.f46263b.add(new h(fVar, th));
        Iterator<Object> it2 = a().iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(f fVar, b bVar) {
        this.f46262a.add(new h(fVar, bVar));
        Iterator<Object> it2 = a().iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized List<Object> a() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f46264c);
        return arrayList;
    }

    public final void a(f fVar) {
        int countTestCases = fVar.countTestCases();
        synchronized (this) {
            this.f46265d += countTestCases;
        }
        Iterator<Object> it2 = a().iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }
}
