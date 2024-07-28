package kotlin.b;

import java.util.Comparator;
import kotlin.g.b.k;

public class b {
    public static final <T extends Comparable<?>> int a(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    static final class a<T> implements Comparator<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b[] f47895a;

        a(kotlin.g.a.b[] bVarArr) {
            this.f47895a = bVarArr;
        }

        public final int compare(T t, T t2) {
            for (kotlin.g.a.b bVar : this.f47895a) {
                int a2 = a.a((Comparable) bVar.invoke(t), (Comparable) bVar.invoke(t2));
                if (a2 != 0) {
                    return a2;
                }
            }
            return 0;
        }
    }

    public static final <T> Comparator<T> a(kotlin.g.a.b<? super T, ? extends Comparable<?>>... bVarArr) {
        k.d(bVarArr, "selectors");
        return new a<>(bVarArr);
    }
}
