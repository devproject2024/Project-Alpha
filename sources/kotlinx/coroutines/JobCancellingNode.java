package kotlinx.coroutines;

import kotlinx.coroutines.Job;

public abstract class JobCancellingNode<J extends Job> extends JobNode<J> {
    public JobCancellingNode(J j) {
        super(j);
    }
}
