package kotlinx.coroutines;

public final class SupervisorKt {
    public static final CompletableJob SupervisorJob(Job job) {
        return new SupervisorJobImpl(job);
    }

    public static /* synthetic */ CompletableJob SupervisorJob$default(Job job, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            job = null;
        }
        return SupervisorJob(job);
    }
}
