package kotlinx.coroutines.flow.internal;

import kotlin.d.f;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.ScopeCoroutine;

public final class SafeCollector_commonKt {
    public static final void checkContext(SafeCollector<?> safeCollector, f fVar) {
        if (((Number) fVar.fold(0, new SafeCollector_commonKt$checkContext$result$1(safeCollector))).intValue() != safeCollector.collectContextSize) {
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + fVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
        }
    }

    public static final Job transitiveCoroutineParent(Job job, Job job2) {
        while (job != null) {
            if (job == job2 || !(job instanceof ScopeCoroutine)) {
                return job;
            }
            job = ((ScopeCoroutine) job).getParent$kotlinx_coroutines_core();
        }
        return null;
    }
}
