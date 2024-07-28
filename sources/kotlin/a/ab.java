package kotlin.a;

import java.util.Iterator;
import kotlin.g.b.a.a;
import kotlin.g.b.k;

public final class ab<T> implements Iterator<z<? extends T>>, a {

    /* renamed from: a  reason: collision with root package name */
    private int f47869a;

    /* renamed from: b  reason: collision with root package name */
    private final Iterator<T> f47870b;

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public ab(Iterator<? extends T> it2) {
        k.d(it2, "iterator");
        this.f47870b = it2;
    }

    public final boolean hasNext() {
        return this.f47870b.hasNext();
    }

    public final /* synthetic */ Object next() {
        int i2 = this.f47869a;
        this.f47869a = i2 + 1;
        if (i2 < 0) {
            k.a();
        }
        return new z(i2, this.f47870b.next());
    }
}
