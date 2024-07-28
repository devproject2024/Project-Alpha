package kotlinx.coroutines;

import kotlin.u;
import kotlinx.coroutines.Job;

public abstract class JobNode<J extends Job> extends CompletionHandlerBase implements DisposableHandle, Incomplete {
    public final J job;

    public NodeList getList() {
        return null;
    }

    public boolean isActive() {
        return true;
    }

    public JobNode(J j) {
        this.job = j;
    }

    public void dispose() {
        J j = this.job;
        if (j != null) {
            ((JobSupport) j).removeNode$kotlinx_coroutines_core(this);
            return;
        }
        throw new u("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
    }
}
