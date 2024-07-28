package kotlin.g.b;

import java.io.Serializable;

public abstract class l<R> implements Serializable, h<R> {
    private final int arity;

    public l(int i2) {
        this.arity = i2;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String a2 = y.a(this);
        k.b(a2, "Reflection.renderLambdaToString(this)");
        return a2;
    }
}
