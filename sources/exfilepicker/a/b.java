package exfilepicker.a;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class b {

    public interface a<T> {
        boolean a(T t);
    }

    public static <T> void a(T[] tArr, List<T> list, a<T> aVar) {
        a(Arrays.asList(tArr), (List) list, aVar);
    }

    public static <T> void a(List<T> list, List<T> list2, a<T> aVar) {
        if (aVar == null) {
            list2.addAll(list);
            return;
        }
        for (T next : list) {
            if (aVar.a(next)) {
                list2.add(next);
            }
        }
    }

    public static <T> void a(List<T> list, a<T> aVar) {
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            if (aVar.a(it2.next())) {
                it2.remove();
            }
        }
    }
}
