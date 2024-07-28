package kotlin.a;

import java.util.Collections;
import java.util.List;
import kotlin.g.b.k;

public class l {
    public static final <T> List<T> a(T t) {
        List<T> singletonList = Collections.singletonList(t);
        k.b(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }
}
