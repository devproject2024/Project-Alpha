package kotlinx.coroutines.internal;

import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.l;
import kotlinx.coroutines.ThreadContextElement;

final class ThreadContextKt$countAll$1 extends l implements m<Object, f.b, Object> {
    public static final ThreadContextKt$countAll$1 INSTANCE = new ThreadContextKt$countAll$1();

    ThreadContextKt$countAll$1() {
        super(2);
    }

    public final Object invoke(Object obj, f.b bVar) {
        if (!(bVar instanceof ThreadContextElement)) {
            return obj;
        }
        if (!(obj instanceof Integer)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        int intValue = num != null ? num.intValue() : 1;
        if (intValue == 0) {
            return bVar;
        }
        return Integer.valueOf(intValue + 1);
    }
}
