package retrofit2;

import kotlin.g.a.b;
import kotlin.g.b.l;
import kotlin.x;

final class KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1 extends l implements b<Throwable, x> {
    final /* synthetic */ Call $this_await$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(Call call) {
        super(1);
        this.$this_await$inlined = call;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f47997a;
    }

    public final void invoke(Throwable th) {
        this.$this_await$inlined.cancel();
    }
}
