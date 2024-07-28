package kotlin.a;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g.b.a.a;

public abstract class b<T> implements Iterator<T>, a {

    /* renamed from: a  reason: collision with root package name */
    ap f47878a = ap.NotReady;

    /* renamed from: b  reason: collision with root package name */
    T f47879b;

    /* access modifiers changed from: protected */
    public abstract void a();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean hasNext() {
        if (this.f47878a != ap.Failed) {
            int i2 = c.f47880a[this.f47878a.ordinal()];
            if (i2 == 1) {
                return false;
            }
            if (i2 == 2) {
                return true;
            }
            this.f47878a = ap.Failed;
            a();
            return this.f47878a == ap.Ready;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public T next() {
        if (hasNext()) {
            this.f47878a = ap.NotReady;
            return this.f47879b;
        }
        throw new NoSuchElementException();
    }
}
