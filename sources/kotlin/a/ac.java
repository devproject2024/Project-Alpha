package kotlin.a;

import java.util.Iterator;
import kotlin.g.b.a.a;

public abstract class ac implements Iterator<Integer>, a {
    public abstract int a();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ Object next() {
        return Integer.valueOf(a());
    }
}
