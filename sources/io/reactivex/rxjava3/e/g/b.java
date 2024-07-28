package io.reactivex.rxjava3.e.g;

import io.reactivex.rxjava3.e.c.j;
import io.reactivex.rxjava3.e.k.p;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class b<E> extends AtomicReferenceArray<E> implements j<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex = new AtomicLong();
    final int lookAheadStep;
    final int mask = (length() - 1);
    final AtomicLong producerIndex = new AtomicLong();
    long producerLookAhead;

    /* access modifiers changed from: package-private */
    public final int calcElementOffset(long j, int i2) {
        return ((int) j) & i2;
    }

    public b(int i2) {
        super(p.a(i2));
        this.lookAheadStep = Math.min(i2 / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    public final boolean offer(E e2) {
        if (e2 != null) {
            int i2 = this.mask;
            long j = this.producerIndex.get();
            int calcElementOffset = calcElementOffset(j, i2);
            if (j >= this.producerLookAhead) {
                long j2 = ((long) this.lookAheadStep) + j;
                if (lvElement(calcElementOffset(j2, i2)) == null) {
                    this.producerLookAhead = j2;
                } else if (lvElement(calcElementOffset) != null) {
                    return false;
                }
            }
            soElement(calcElementOffset, e2);
            soProducerIndex(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public final boolean offer(E e2, E e3) {
        return offer(e2) && offer(e3);
    }

    public final E poll() {
        long j = this.consumerIndex.get();
        int calcElementOffset = calcElementOffset(j);
        E lvElement = lvElement(calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soConsumerIndex(j + 1);
        soElement(calcElementOffset, (Object) null);
        return lvElement;
    }

    public final boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    /* access modifiers changed from: package-private */
    public final void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    /* access modifiers changed from: package-private */
    public final void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int calcElementOffset(long j) {
        return this.mask & ((int) j);
    }

    /* access modifiers changed from: package-private */
    public final void soElement(int i2, E e2) {
        lazySet(i2, e2);
    }

    /* access modifiers changed from: package-private */
    public final E lvElement(int i2) {
        return get(i2);
    }
}
