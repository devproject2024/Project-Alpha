package kotlinx.coroutines;

import kotlin.d.b.a.d;
import kotlin.d.b.a.f;
import kotlin.g.a.m;

@f(b = "Timeout.kt", c = {80}, d = "withTimeoutOrNull", e = "kotlinx.coroutines.TimeoutKt")
final class TimeoutKt$withTimeoutOrNull$1 extends d {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    TimeoutKt$withTimeoutOrNull$1(kotlin.d.d dVar) {
        super(dVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TimeoutKt.withTimeoutOrNull(0, (m) null, this);
    }
}
