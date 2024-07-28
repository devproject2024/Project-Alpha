package kotlinx.coroutines.channels;

import kotlin.d.f;
import kotlin.x;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.channels.SendChannel;

public class ProducerCoroutine<E> extends ChannelCoroutine<E> implements ProducerScope<E> {
    public ProducerCoroutine(f fVar, Channel<E> channel) {
        super(fVar, channel, true);
    }

    public boolean isActive() {
        return super.isActive();
    }

    /* access modifiers changed from: protected */
    public void onCompleted(x xVar) {
        SendChannel.DefaultImpls.close$default(get_channel(), (Throwable) null, 1, (Object) null);
    }

    public void onCancelled(Throwable th, boolean z) {
        if (!get_channel().close(th) && !z) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
        }
    }
}
