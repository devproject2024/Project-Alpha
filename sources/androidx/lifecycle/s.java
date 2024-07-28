package androidx.lifecycle;

import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import kotlin.d.d;
import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

public final class s {
    public static final m a(q qVar) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        k.c(qVar, "$this$lifecycleScope");
        k lifecycle = qVar.getLifecycle();
        k.a((Object) lifecycle, "lifecycle");
        k.c(lifecycle, "$this$coroutineScope");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.f3669a.get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        } while (!lifecycle.f3669a.compareAndSet((Object) null, lifecycleCoroutineScopeImpl));
        Job unused = BuildersKt__Builders_commonKt.launch$default(lifecycleCoroutineScopeImpl, Dispatchers.getMain().getImmediate(), (CoroutineStart) null, new LifecycleCoroutineScopeImpl.a(lifecycleCoroutineScopeImpl, (d) null), 2, (Object) null);
        return lifecycleCoroutineScopeImpl;
    }
}
