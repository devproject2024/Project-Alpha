package kotlin.g.b;

import kotlin.k.c;
import kotlin.k.d;

public final class w extends v {
    public w(d dVar, String str, String str2) {
        super(NO_RECEIVER, ((d) dVar).a(), str, str2, (dVar instanceof c) ^ true ? 1 : 0);
    }

    public w(Class cls, String str, String str2, int i2) {
        super(NO_RECEIVER, cls, str, str2, i2);
    }

    public w(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }

    public final Object get(Object obj) {
        return getGetter().call(obj);
    }
}
