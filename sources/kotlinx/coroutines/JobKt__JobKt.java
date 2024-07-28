package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.d.f;

final /* synthetic */ class JobKt__JobKt {
    public static final CompletableJob Job(Job job) {
        return new JobImpl(job);
    }

    public static /* synthetic */ CompletableJob Job$default(Job job, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            job = null;
        }
        return JobKt.Job(job);
    }

    public static final DisposableHandle disposeOnCompletion(Job job, DisposableHandle disposableHandle) {
        return job.invokeOnCompletion(new DisposeOnCompletion(job, disposableHandle));
    }

    public static /* synthetic */ void cancel$default(f fVar, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancel(fVar, cancellationException);
    }

    public static final void cancel(f fVar, CancellationException cancellationException) {
        Job job = (Job) fVar.get(Job.Key);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }

    public static final void ensureActive(Job job) {
        if (!job.isActive()) {
            throw job.getCancellationException();
        }
    }

    public static final void ensureActive(f fVar) {
        Job job = (Job) fVar.get(Job.Key);
        if (job != null) {
            JobKt.ensureActive(job);
            return;
        }
        throw new IllegalStateException("Context cannot be checked for liveness because it does not have a job: ".concat(String.valueOf(fVar)).toString());
    }
}
