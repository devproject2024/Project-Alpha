package kotlinx.coroutines.flow.internal;

import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.l;
import kotlin.u;
import kotlinx.coroutines.Job;

final class SafeCollector_commonKt$checkContext$result$1 extends l implements m<Integer, f.b, Integer> {
    final /* synthetic */ SafeCollector $this_checkContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SafeCollector_commonKt$checkContext$result$1(SafeCollector safeCollector) {
        super(2);
        this.$this_checkContext = safeCollector;
    }

    public final /* synthetic */ Object invoke(Object obj, Object obj2) {
        return Integer.valueOf(invoke(((Number) obj).intValue(), (f.b) obj2));
    }

    public final int invoke(int i2, f.b bVar) {
        f.c key = bVar.getKey();
        f.b bVar2 = this.$this_checkContext.collectContext.get(key);
        if (key == Job.Key) {
            Job job = (Job) bVar2;
            if (bVar != null) {
                Job transitiveCoroutineParent = SafeCollector_commonKt.transitiveCoroutineParent((Job) bVar, job);
                if (transitiveCoroutineParent == job) {
                    return job == null ? i2 : i2 + 1;
                }
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + transitiveCoroutineParent + ", expected child of " + job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
            }
            throw new u("null cannot be cast to non-null type kotlinx.coroutines.Job");
        } else if (bVar != bVar2) {
            return Integer.MIN_VALUE;
        } else {
            return i2 + 1;
        }
    }
}
