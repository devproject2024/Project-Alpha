package kotlinx.coroutines;

public class JobImpl extends JobSupport implements CompletableJob {
    private final boolean handlesException = handlesException();

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }

    public JobImpl(Job job) {
        super(true);
        initParentJobInternal$kotlinx_coroutines_core(job);
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.handlesException;
    }

    private final boolean handlesException() {
        JobSupport jobSupport;
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (!(parentHandle$kotlinx_coroutines_core instanceof ChildHandleNode)) {
            parentHandle$kotlinx_coroutines_core = null;
        }
        ChildHandleNode childHandleNode = (ChildHandleNode) parentHandle$kotlinx_coroutines_core;
        if (!(childHandleNode == null || (jobSupport = (JobSupport) childHandleNode.job) == null)) {
            while (!jobSupport.getHandlesException$kotlinx_coroutines_core()) {
                ChildHandle parentHandle$kotlinx_coroutines_core2 = jobSupport.getParentHandle$kotlinx_coroutines_core();
                if (!(parentHandle$kotlinx_coroutines_core2 instanceof ChildHandleNode)) {
                    parentHandle$kotlinx_coroutines_core2 = null;
                }
                ChildHandleNode childHandleNode2 = (ChildHandleNode) parentHandle$kotlinx_coroutines_core2;
                if (childHandleNode2 != null) {
                    jobSupport = (JobSupport) childHandleNode2.job;
                    if (jobSupport == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }
}
