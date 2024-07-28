package kotlinx.coroutines.android;

import kotlin.g.a.b;
import kotlin.g.b.l;
import kotlin.x;

final class HandlerContext$scheduleResumeAfterDelay$1 extends l implements b<Throwable, x> {
    final /* synthetic */ Runnable $block;
    final /* synthetic */ HandlerContext this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandlerContext$scheduleResumeAfterDelay$1(HandlerContext handlerContext, Runnable runnable) {
        super(1);
        this.this$0 = handlerContext;
        this.$block = runnable;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f47997a;
    }

    public final void invoke(Throwable th) {
        this.this$0.handler.removeCallbacks(this.$block);
    }
}
