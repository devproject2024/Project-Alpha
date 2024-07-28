package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.x;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;

public class ChannelCoroutine<E> extends AbstractCoroutine<x> implements Channel<E> {
    private final Channel<E> _channel;

    public boolean close(Throwable th) {
        return this._channel.close(th);
    }

    public Object receiveOrClosed(d<? super ValueOrClosed<? extends E>> dVar) {
        return this._channel.receiveOrClosed(dVar);
    }

    public Object send(E e2, d<? super x> dVar) {
        return this._channel.send(e2, dVar);
    }

    /* access modifiers changed from: protected */
    public final Channel<E> get_channel() {
        return this._channel;
    }

    public ChannelCoroutine(f fVar, Channel<E> channel, boolean z) {
        super(fVar, z);
        this._channel = channel;
    }

    public final void cancel(CancellationException cancellationException) {
        Throwable th;
        if (cancellationException != null) {
            th = cancellationException;
        } else {
            JobSupport jobSupport = this;
            th = new JobCancellationException(jobSupport.cancellationExceptionMessage(), (Throwable) null, jobSupport);
        }
        cancelInternal(th);
    }

    public void cancelInternal(Throwable th) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, th, (String) null, 1, (Object) null);
        this._channel.cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }
}
