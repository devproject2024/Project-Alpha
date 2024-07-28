package kotlin.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;

public class n extends m {
    public static final <T> int a(Iterable<? extends T> iterable) {
        k.d(iterable, "$this$collectionSizeOrDefault");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }

    public static final <T> List<T> b(Iterable<? extends Iterable<? extends T>> iterable) {
        k.d(iterable, "$this$flatten");
        ArrayList arrayList = new ArrayList();
        for (Iterable a2 : iterable) {
            k.a(arrayList, a2);
        }
        return arrayList;
    }
}
