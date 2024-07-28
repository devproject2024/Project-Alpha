package retrofit2;

import kotlin.d.b.a.d;
import kotlin.d.b.a.f;

@f(b = "KotlinExtensions.kt", c = {113}, d = "suspendAndThrow", e = "retrofit2.KotlinExtensions")
final class KotlinExtensions$suspendAndThrow$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    KotlinExtensions$suspendAndThrow$1(kotlin.d.d dVar) {
        super(dVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return KotlinExtensions.suspendAndThrow((Exception) null, this);
    }
}
