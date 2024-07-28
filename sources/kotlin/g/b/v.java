package kotlin.g.b;

import kotlin.k.b;
import kotlin.k.k;

public abstract class v extends s implements k {
    public v() {
    }

    public v(Object obj) {
        super(obj);
    }

    public v(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }

    /* access modifiers changed from: protected */
    public b computeReflected() {
        return y.a(this);
    }

    public Object invoke(Object obj) {
        return get(obj);
    }

    public k.a getGetter() {
        return ((k) getReflected()).getGetter();
    }

    public Object getDelegate(Object obj) {
        return ((k) getReflected()).getDelegate(obj);
    }
}
