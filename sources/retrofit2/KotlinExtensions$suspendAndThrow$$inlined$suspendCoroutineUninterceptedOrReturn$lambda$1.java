package retrofit2;

import kotlin.ResultKt;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.p;

final class KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 implements Runnable {
    final /* synthetic */ d $continuation;
    final /* synthetic */ Exception $this_suspendAndThrow$inlined;

    KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1(d dVar, Exception exc) {
        this.$continuation = dVar;
        this.$this_suspendAndThrow$inlined = exc;
    }

    public final void run() {
        d a2 = b.a(this.$continuation);
        p.a aVar = p.Companion;
        a2.resumeWith(p.m530constructorimpl(ResultKt.a((Throwable) this.$this_suspendAndThrow$inlined)));
    }
}
