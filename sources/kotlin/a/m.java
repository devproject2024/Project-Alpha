package kotlin.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import kotlin.j.d;

public class m extends l {
    public static final <T> Collection<T> a(T[] tArr) {
        k.d(tArr, "$this$asCollection");
        return new e<>(tArr, false);
    }

    public static final <T> List<T> b(T... tArr) {
        k.d(tArr, "elements");
        return tArr.length > 0 ? f.a(tArr) : w.INSTANCE;
    }

    public static final <T> List<T> c(T... tArr) {
        k.d(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new e(tArr, true));
    }

    public static final <T> ArrayList<T> d(T... tArr) {
        k.d(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new e(tArr, true));
    }

    public static final d a(Collection<?> collection) {
        k.d(collection, "$this$indices");
        return new d(0, collection.size() - 1);
    }

    public static final <T> int a(List<? extends T> list) {
        k.d(list, "$this$lastIndex");
        return list.size() - 1;
    }

    public static final <T> List<T> b(List<? extends T> list) {
        k.d(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size == 0) {
            return w.INSTANCE;
        }
        if (size != 1) {
            return list;
        }
        return k.a(list.get(0));
    }

    public static final void a() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final void b() {
        throw new ArithmeticException("Count overflow has happened.");
    }
}
