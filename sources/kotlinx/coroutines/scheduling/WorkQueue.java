package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.DebugKt;

public final class WorkQueue {
    private static final AtomicIntegerFieldUpdater blockingTasksInBuffer$FU;
    private static final AtomicIntegerFieldUpdater consumerIndex$FU;
    private static final AtomicReferenceFieldUpdater lastScheduledTask$FU;
    private static final AtomicIntegerFieldUpdater producerIndex$FU;
    private volatile int blockingTasksInBuffer = 0;
    private final AtomicReferenceArray<Task> buffer = new AtomicReferenceArray<>(128);
    private volatile int consumerIndex = 0;
    private volatile Object lastScheduledTask = null;
    private volatile int producerIndex = 0;

    static {
        Class<WorkQueue> cls = WorkQueue.class;
        lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        blockingTasksInBuffer$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    public final int getBufferSize$kotlinx_coroutines_core() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int getSize$kotlinx_coroutines_core() {
        return this.lastScheduledTask != null ? getBufferSize$kotlinx_coroutines_core() + 1 : getBufferSize$kotlinx_coroutines_core();
    }

    public final Task poll() {
        Task task = (Task) lastScheduledTask$FU.getAndSet(this, (Object) null);
        return task == null ? pollBuffer() : task;
    }

    public static /* synthetic */ Task add$default(WorkQueue workQueue, Task task, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return workQueue.add(task, z);
    }

    public final Task add(Task task, boolean z) {
        if (z) {
            return addLast(task);
        }
        Task task2 = (Task) lastScheduledTask$FU.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return addLast(task2);
    }

    public final long tryStealFrom(WorkQueue workQueue) {
        boolean z = true;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getBufferSize$kotlinx_coroutines_core() == 0)) {
                throw new AssertionError();
            }
        }
        Task pollBuffer = workQueue.pollBuffer();
        if (pollBuffer == null) {
            return tryStealLastScheduled(workQueue, false);
        }
        Task add$default = add$default(this, pollBuffer, false, 2, (Object) null);
        if (!DebugKt.getASSERTIONS_ENABLED()) {
            return -1;
        }
        if (add$default != null) {
            z = false;
        }
        if (z) {
            return -1;
        }
        throw new AssertionError();
    }

    public final long tryStealBlockingFrom(WorkQueue workQueue) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getBufferSize$kotlinx_coroutines_core() == 0)) {
                throw new AssertionError();
            }
        }
        int i2 = workQueue.producerIndex;
        AtomicReferenceArray<Task> atomicReferenceArray = workQueue.buffer;
        for (int i3 = workQueue.consumerIndex; i3 != i2; i3++) {
            int i4 = i3 & 127;
            if (workQueue.blockingTasksInBuffer == 0) {
                break;
            }
            Task task = atomicReferenceArray.get(i4);
            if (task != null) {
                if ((task.taskContext.getTaskMode() == 1) && atomicReferenceArray.compareAndSet(i4, task, (Object) null)) {
                    blockingTasksInBuffer$FU.decrementAndGet(workQueue);
                    add$default(this, task, false, 2, (Object) null);
                    return -1;
                }
            }
        }
        return tryStealLastScheduled(workQueue, true);
    }

    public final void offloadAllWorkTo(GlobalQueue globalQueue) {
        Task task = (Task) lastScheduledTask$FU.getAndSet(this, (Object) null);
        if (task != null) {
            globalQueue.addLast(task);
        }
        do {
        } while (pollTo(globalQueue));
    }

    private final long tryStealLastScheduled(WorkQueue workQueue, boolean z) {
        Task task;
        do {
            task = (Task) workQueue.lastScheduledTask;
            if (task == null) {
                return -2;
            }
            if (z) {
                boolean z2 = true;
                if (task.taskContext.getTaskMode() != 1) {
                    z2 = false;
                }
                if (!z2) {
                    return -2;
                }
            }
            long nanoTime = TasksKt.schedulerTimeSource.nanoTime() - task.submissionTime;
            if (nanoTime < TasksKt.WORK_STEALING_TIME_RESOLUTION_NS) {
                return TasksKt.WORK_STEALING_TIME_RESOLUTION_NS - nanoTime;
            }
        } while (!lastScheduledTask$FU.compareAndSet(workQueue, task, (Object) null));
        add$default(this, task, false, 2, (Object) null);
        return -1;
    }

    private final boolean pollTo(GlobalQueue globalQueue) {
        Task pollBuffer = pollBuffer();
        if (pollBuffer == null) {
            return false;
        }
        globalQueue.addLast(pollBuffer);
        return true;
    }

    private final Task pollBuffer() {
        Task andSet;
        while (true) {
            int i2 = this.consumerIndex;
            if (i2 - this.producerIndex == 0) {
                return null;
            }
            int i3 = i2 & 127;
            if (consumerIndex$FU.compareAndSet(this, i2, i2 + 1) && (andSet = this.buffer.getAndSet(i3, (Object) null)) != null) {
                decrementIfBlocking(andSet);
                return andSet;
            }
        }
    }

    private final Task addLast(Task task) {
        boolean z = true;
        if (task.taskContext.getTaskMode() != 1) {
            z = false;
        }
        if (z) {
            blockingTasksInBuffer$FU.incrementAndGet(this);
        }
        if (getBufferSize$kotlinx_coroutines_core() == 127) {
            return task;
        }
        int i2 = this.producerIndex & 127;
        while (this.buffer.get(i2) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(i2, task);
        producerIndex$FU.incrementAndGet(this);
        return null;
    }

    private final void decrementIfBlocking(Task task) {
        if (task != null) {
            boolean z = false;
            if (task.taskContext.getTaskMode() == 1) {
                int decrementAndGet = blockingTasksInBuffer$FU.decrementAndGet(this);
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (decrementAndGet >= 0) {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }
}
