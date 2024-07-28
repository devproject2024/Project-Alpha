package kotlin.a;

import java.util.Collection;
import java.util.Iterator;
import kotlin.g.a.b;
import kotlin.g.b.k;

public class r extends q {
    public static final <T> boolean a(Collection<? super T> collection, Iterable<? extends T> iterable) {
        k.d(collection, "$this$addAll");
        k.d(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        for (Object add : iterable) {
            if (collection.add(add)) {
                z = true;
            }
        }
        return z;
    }

    public static final <T> boolean a(Collection<? super T> collection, T[] tArr) {
        k.d(collection, "$this$addAll");
        k.d(tArr, "elements");
        return collection.addAll(f.a(tArr));
    }

    public static final <T> boolean a(Iterable<? extends T> iterable, b<? super T, Boolean> bVar, boolean z) {
        Iterator<? extends T> it2 = iterable.iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            if (bVar.invoke(it2.next()).booleanValue() == z) {
                it2.remove();
                z2 = true;
            }
        }
        return z2;
    }
}
