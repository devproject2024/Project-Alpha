package kotlin.a;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.g.b.k;

public class q extends p {
    public static final <T extends Comparable<? super T>> void c(List<T> list) {
        k.d(list, "$this$sort");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final <T> void a(List<T> list, Comparator<? super T> comparator) {
        k.d(list, "$this$sortWith");
        k.d(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
