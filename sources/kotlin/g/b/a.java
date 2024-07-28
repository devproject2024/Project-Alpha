package kotlin.g.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class a<T> implements Iterator<T>, kotlin.g.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    private int f47919a;

    /* renamed from: b  reason: collision with root package name */
    private final T[] f47920b;

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public a(T[] tArr) {
        k.d(tArr, "array");
        this.f47920b = tArr;
    }

    public final boolean hasNext() {
        return this.f47919a < this.f47920b.length;
    }

    public final T next() {
        try {
            T[] tArr = this.f47920b;
            int i2 = this.f47919a;
            this.f47919a = i2 + 1;
            return tArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f47919a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
