package kotlin.g.b;

import kotlin.k.b;
import kotlin.k.j;

public abstract class t extends s implements j {
    public t() {
    }

    public t(Object obj) {
        super(obj);
    }

    public t(Object obj, Class cls, String str, String str2, int i2) {
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
        return ((j) getReflected()).getGetter();
    }

    public Object getDelegate() {
        return ((j) getReflected()).getDelegate();
    }
}
