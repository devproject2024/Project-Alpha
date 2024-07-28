package kotlin.g.b;

import kotlin.k.b;
import kotlin.k.g;
import kotlin.k.j;

public abstract class n extends m implements g {
    public n() {
    }

    public n(Object obj) {
        super(obj);
    }

    public n(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }

    /* access modifiers changed from: protected */
    public b computeReflected() {
        return y.a(this);
    }

    public Object invoke() {
        return get();
    }

    public j.a getGetter() {
        return ((g) getReflected()).getGetter();
    }

    public g.a getSetter() {
        return ((g) getReflected()).getSetter();
    }

    public Object getDelegate() {
        return ((g) getReflected()).getDelegate();
    }
}
