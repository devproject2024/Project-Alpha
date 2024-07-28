package kotlin.g.b;

import kotlin.k.c;
import kotlin.k.d;

public class o extends n {
    public o(d dVar, String str, String str2) {
        super(NO_RECEIVER, ((d) dVar).a(), str, str2, (dVar instanceof c) ^ true ? 1 : 0);
    }

    public o(Class cls, String str, String str2, int i2) {
        super(NO_RECEIVER, cls, str, str2, i2);
    }

    public o(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }

    public Object get() {
        return getGetter().call(new Object[0]);
    }

    public void set(Object obj) {
        getSetter().call(obj);
    }
}
