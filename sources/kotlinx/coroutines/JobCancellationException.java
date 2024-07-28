package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.g.b.k;

public final class JobCancellationException extends CancellationException implements CopyableThrowable<JobCancellationException> {
    public final Job job;

    public JobCancellationException(String str, Throwable th, Job job2) {
        super(str);
        this.job = job2;
        if (th != null) {
            initCause(th);
        }
    }

    public final Throwable fillInStackTrace() {
        if (DebugKt.getDEBUG()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final JobCancellationException createCopy() {
        if (!DebugKt.getDEBUG()) {
            return null;
        }
        String message = getMessage();
        if (message == null) {
            k.a();
        }
        return new JobCancellationException(message, this, this.job);
    }

    public final String toString() {
        return super.toString() + "; job=" + this.job;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JobCancellationException)) {
            return false;
        }
        JobCancellationException jobCancellationException = (JobCancellationException) obj;
        return k.a((Object) jobCancellationException.getMessage(), (Object) getMessage()) && k.a((Object) jobCancellationException.job, (Object) this.job) && k.a((Object) jobCancellationException.getCause(), (Object) getCause());
    }

    public final int hashCode() {
        String message = getMessage();
        if (message == null) {
            k.a();
        }
        int hashCode = ((message.hashCode() * 31) + this.job.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }
}
