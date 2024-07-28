package kotlin.g.b;

import java.util.Iterator;

public final class b {
    public static final <T> Iterator<T> a(T[] tArr) {
        k.d(tArr, "array");
        return new a<>(tArr);
    }
}
