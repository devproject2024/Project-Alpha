package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.util.Comparator;
import kotlin.b.a;

public final class ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1<T> implements Comparator<T> {
    public final int compare(T t, T t2) {
        return a.a(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
    }
}
