package androidx.coordinatorlayout.widget;

import androidx.a.g;
import androidx.core.g.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final e.a<ArrayList<T>> f2613a = new e.b(10);

    /* renamed from: b  reason: collision with root package name */
    final g<T, ArrayList<T>> f2614b = new g<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<T> f2615c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<T> f2616d = new HashSet<>();

    public final void a(T t) {
        if (!this.f2614b.containsKey(t)) {
            this.f2614b.put(t, null);
        }
    }

    public final List b(T t) {
        return this.f2614b.get(t);
    }

    public final ArrayList<T> a() {
        this.f2615c.clear();
        this.f2616d.clear();
        int size = this.f2614b.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(this.f2614b.b(i2), this.f2615c, this.f2616d);
        }
        return this.f2615c;
    }

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList arrayList2 = this.f2614b.get(t);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        a(arrayList2.get(i2), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }
}
