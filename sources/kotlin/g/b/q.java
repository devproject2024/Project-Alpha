package kotlin.g.b;

import kotlin.k.c;
import kotlin.k.d;

public final class q extends p {
    public q(d dVar, String str, String str2) {
        super(NO_RECEIVER, ((d) dVar).a(), str, str2, (dVar instanceof c) ^ true ? 1 : 0);
    }

    public q(Class cls, String str, String str2, int i2) {
        super(NO_RECEIVER, cls, str, str2, i2);
    }

    public q(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }

    public final Object get(Object obj) {
        return getGetter().call(obj);
    }

    public final void set(Object obj, Object obj2) {
        getSetter().call(obj, obj2);
    }
}
