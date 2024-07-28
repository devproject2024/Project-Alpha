package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.g.b.g;
import kotlinx.coroutines.DebugKt;

public final class LockFreeTaskQueueCore<E> {
    public static final Companion Companion = new Companion((g) null);
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
    private static final AtomicReferenceFieldUpdater _next$FU;
    private static final AtomicLongFieldUpdater _state$FU;
    private volatile Object _next = null;
    private volatile long _state = 0;
    private AtomicReferenceArray array;
    private final int capacity;
    private final int mask;
    private final boolean singleConsumer;

    public LockFreeTaskQueueCore(int i2, boolean z) {
        this.capacity = i2;
        this.singleConsumer = z;
        int i3 = this.capacity;
        this.mask = i3 - 1;
        this.array = new AtomicReferenceArray(i3);
        boolean z2 = false;
        if (this.mask <= 1073741823) {
            if (!((this.capacity & this.mask) == 0 ? true : z2)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final boolean isEmpty() {
        long j = this._state;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    public final int getSize() {
        long j = this._state;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0)));
    }

    private final LockFreeTaskQueueCore<E> fillPlaceholder(int i2, E e2) {
        Object obj = this.array.get(this.mask & i2);
        if (!(obj instanceof Placeholder) || ((Placeholder) obj).index != i2) {
            return null;
        }
        this.array.set(i2 & this.mask, e2);
        return this;
    }

    public final LockFreeTaskQueueCore<E> next() {
        return allocateOrGetNextCopy(markFrozen());
    }

    private final LockFreeTaskQueueCore<E> allocateNextCopy(long j) {
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = new LockFreeTaskQueueCore<>(this.capacity * 2, this.singleConsumer);
        int i2 = (int) ((1073741823 & j) >> 0);
        int i3 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i4 = this.mask;
            if ((i2 & i4) != (i3 & i4)) {
                Object obj = this.array.get(i4 & i2);
                if (obj == null) {
                    obj = new Placeholder(i2);
                }
                lockFreeTaskQueueCore.array.set(lockFreeTaskQueueCore.mask & i2, obj);
                i2++;
            } else {
                lockFreeTaskQueueCore._state = Companion.wo(j, 1152921504606846976L);
                return lockFreeTaskQueueCore;
            }
        }
    }

    public static final class Placeholder {
        public final int index;

        public Placeholder(int i2) {
            this.index = i2;
        }
    }

    public static final class Companion {
        public final int addFailReason(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long wo(long j, long j2) {
            return j & (~j2);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final long updateHead(long j, int i2) {
            return wo(j, 1073741823) | (((long) i2) << 0);
        }

        public final long updateTail(long j, int i2) {
            return wo(j, 1152921503533105152L) | (((long) i2) << 30);
        }
    }

    static {
        Class<LockFreeTaskQueueCore> cls = LockFreeTaskQueueCore.class;
        _next$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        _state$FU = AtomicLongFieldUpdater.newUpdater(cls, "_state");
    }

    public final boolean close() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!_state$FU.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a A[LOOP:1: B:19:0x006a->B:22:0x007b, LOOP_START, PHI: r0 
      PHI: (r0v16 kotlinx.coroutines.internal.LockFreeTaskQueueCore) = (r0v15 kotlinx.coroutines.internal.LockFreeTaskQueueCore), (r0v18 kotlinx.coroutines.internal.LockFreeTaskQueueCore) binds: [B:18:0x0060, B:22:0x007b] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int addLast(E r13) {
        /*
            r12 = this;
        L_0x0000:
            long r2 = r12._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x0012
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r13 = Companion
            int r13 = r13.addFailReason(r2)
            return r13
        L_0x0012:
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            r8 = 0
            long r0 = r0 >> r8
            int r1 = (int) r0
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r0 = 30
            long r4 = r4 >> r0
            int r9 = (int) r4
            int r10 = r12.mask
            int r0 = r9 + 2
            r0 = r0 & r10
            r4 = r1 & r10
            r5 = 1
            if (r0 != r4) goto L_0x002e
            return r5
        L_0x002e:
            boolean r0 = r12.singleConsumer
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 != 0) goto L_0x004d
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.array
            r11 = r9 & r10
            java.lang.Object r0 = r0.get(r11)
            if (r0 == 0) goto L_0x004d
            int r0 = r12.capacity
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L_0x004c
            int r9 = r9 - r1
            r1 = r9 & r4
            int r0 = r0 >> 1
            if (r1 <= r0) goto L_0x0000
        L_0x004c:
            return r5
        L_0x004d:
            int r0 = r9 + 1
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = _state$FU
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r4 = Companion
            long r4 = r4.updateTail(r2, r0)
            r0 = r1
            r1 = r12
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L_0x0000
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.array
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) r0
        L_0x006a:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x007d
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = r0.next()
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = r0.fillPlaceholder(r9, r13)
            if (r0 != 0) goto L_0x006a
        L_0x007d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeTaskQueueCore.addLast(java.lang.Object):int");
    }

    public final Object removeFirstOrNull() {
        while (true) {
            long j = this._state;
            if ((1152921504606846976L & j) != 0) {
                return REMOVE_FROZEN;
            }
            int i2 = (int) ((1073741823 & j) >> 0);
            int i3 = (int) ((1152921503533105152L & j) >> 30);
            int i4 = this.mask;
            if ((i3 & i4) == (i2 & i4)) {
                return null;
            }
            Object obj = this.array.get(i4 & i2);
            if (obj == null) {
                if (this.singleConsumer) {
                    return null;
                }
            } else if (obj instanceof Placeholder) {
                return null;
            } else {
                int i5 = (i2 + 1) & 1073741823;
                if (_state$FU.compareAndSet(this, j, Companion.updateHead(j, i5))) {
                    this.array.set(this.mask & i2, (Object) null);
                    return obj;
                } else if (this.singleConsumer) {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
                    do {
                        lockFreeTaskQueueCore = lockFreeTaskQueueCore.removeSlowPath(i2, i5);
                    } while (lockFreeTaskQueueCore != null);
                    return obj;
                }
            }
        }
    }

    private final LockFreeTaskQueueCore<E> removeSlowPath(int i2, int i3) {
        long j;
        int i4;
        do {
            j = this._state;
            boolean z = false;
            i4 = (int) ((1073741823 & j) >> 0);
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (i4 == i2) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j) != 0) {
                return next();
            }
        } while (!_state$FU.compareAndSet(this, j, Companion.updateHead(j, i3)));
        this.array.set(this.mask & i4, (Object) null);
        return null;
    }

    private final long markFrozen() {
        long j;
        long j2;
        do {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!_state$FU.compareAndSet(this, j, j2));
        return j2;
    }

    private final LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long j) {
        while (true) {
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._next;
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            _next$FU.compareAndSet(this, (Object) null, allocateNextCopy(j));
        }
    }
}
