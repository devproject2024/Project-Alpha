package kotlinx.coroutines;

import kotlin.x;

public final class ChildHandleNode extends JobCancellingNode<JobSupport> implements ChildHandle {
    public final ChildJob childJob;

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f47997a;
    }

    public ChildHandleNode(JobSupport jobSupport, ChildJob childJob2) {
        super(jobSupport);
        this.childJob = childJob2;
    }

    public final void invoke(Throwable th) {
        this.childJob.parentCancelled((ParentJob) this.job);
    }

    public final boolean childCancelled(Throwable th) {
        return ((JobSupport) this.job).childCancelled(th);
    }

    public final String toString() {
        return "ChildHandle[" + this.childJob + ']';
    }
}
