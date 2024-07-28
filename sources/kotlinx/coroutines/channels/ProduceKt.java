package kotlinx.coroutines.channels;

import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.g;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

public final class ProduceKt {
    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, f fVar, int i2, CoroutineStart coroutineStart, b bVar, m mVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            fVar = g.INSTANCE;
        }
        f fVar2 = fVar;
        int i4 = (i3 & 2) != 0 ? 0 : i2;
        if ((i3 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i3 & 8) != 0) {
            bVar = null;
        }
        return produce(coroutineScope, fVar2, i4, coroutineStart2, bVar, mVar);
    }

    public static final <E> ReceiveChannel<E> produce(CoroutineScope coroutineScope, f fVar, int i2, CoroutineStart coroutineStart, b<? super Throwable, x> bVar, m<? super ProducerScope<? super E>, ? super d<? super x>, ? extends Object> mVar) {
        ProducerCoroutine producerCoroutine = new ProducerCoroutine(CoroutineContextKt.newCoroutineContext(coroutineScope, fVar), ChannelKt.Channel(i2));
        if (bVar != null) {
            producerCoroutine.invokeOnCompletion(bVar);
        }
        producerCoroutine.start(coroutineStart, producerCoroutine, mVar);
        return producerCoroutine;
    }
}
