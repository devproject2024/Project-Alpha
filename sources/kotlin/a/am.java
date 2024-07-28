package kotlin.a;

import java.util.Set;
import kotlin.g.b.k;

public class am extends al {
    public static final <T> Set<T> a(T... tArr) {
        k.d(tArr, "elements");
        return tArr.length > 0 ? f.d(tArr) : y.INSTANCE;
    }
}
