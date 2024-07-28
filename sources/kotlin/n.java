package kotlin;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class n extends Error {
    public n() {
        this((String) null, 1, (g) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(String str) {
        super(str);
        k.d(str, "message");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? "An operation is not implemented." : str);
    }
}
