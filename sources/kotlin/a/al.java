package kotlin.a;

import java.util.Collections;
import java.util.Set;
import kotlin.g.b.k;

public class al {
    public static final <T> Set<T> a(T t) {
        Set<T> singleton = Collections.singleton(t);
        k.b(singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }
}
