package kotlinx.coroutines;

import kotlin.d.f;

public final class YieldKt {
    public static final void checkCompletion(f fVar) {
        Job job = (Job) fVar.get(Job.Key);
        if (job != null && !job.isActive()) {
            throw job.getCancellationException();
        }
    }
}
