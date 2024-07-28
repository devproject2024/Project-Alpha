package kotlin.d.b.a;

import kotlin.d.d;
import kotlin.g.b.h;
import kotlin.g.b.k;
import kotlin.g.b.y;

public abstract class j extends i implements h<Object> {
    private final int arity;

    public int getArity() {
        return this.arity;
    }

    public j(int i2, d<Object> dVar) {
        super(dVar);
        this.arity = i2;
    }

    public j(int i2) {
        this(i2, (d<Object>) null);
    }

    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String a2 = y.a((h) this);
        k.b(a2, "Reflection.renderLambdaToString(this)");
        return a2;
    }
}
