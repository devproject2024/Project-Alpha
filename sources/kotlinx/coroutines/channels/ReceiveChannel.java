package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.d.d;

public interface ReceiveChannel<E> {
    void cancel(CancellationException cancellationException);

    Object receiveOrClosed(d<? super ValueOrClosed<? extends E>> dVar);
}
