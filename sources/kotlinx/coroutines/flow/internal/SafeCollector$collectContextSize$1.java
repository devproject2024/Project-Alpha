package kotlinx.coroutines.flow.internal;

import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.l;

final class SafeCollector$collectContextSize$1 extends l implements m<Integer, f.b, Integer> {
    public static final SafeCollector$collectContextSize$1 INSTANCE = new SafeCollector$collectContextSize$1();

    SafeCollector$collectContextSize$1() {
        super(2);
    }

    public final int invoke(int i2, f.b bVar) {
        return i2 + 1;
    }

    public final /* synthetic */ Object invoke(Object obj, Object obj2) {
        return Integer.valueOf(invoke(((Number) obj).intValue(), (f.b) obj2));
    }
}
