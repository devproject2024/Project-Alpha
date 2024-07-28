package kotlinx.coroutines.internal;

import kotlin.g.b.k;

public abstract class AtomicDesc {
    public AtomicOp<?> atomicOp;

    public final AtomicOp<?> getAtomicOp() {
        AtomicOp<?> atomicOp2 = this.atomicOp;
        if (atomicOp2 == null) {
            k.a("atomicOp");
        }
        return atomicOp2;
    }
}
