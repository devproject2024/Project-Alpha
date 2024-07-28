package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.i.c;
import kotlin.j.e;
import kotlin.x;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.TimeSource;
import kotlinx.coroutines.TimeSourceKt;
import kotlinx.coroutines.internal.Symbol;

public final class CoroutineScheduler implements Closeable, Executor {
    public static final Companion Companion = new Companion((g) null);
    public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK");
    private static final AtomicIntegerFieldUpdater _isTerminated$FU;
    static final AtomicLongFieldUpdater controlState$FU;
    private static final AtomicLongFieldUpdater parkedWorkersStack$FU;
    private volatile int _isTerminated;
    volatile long controlState;
    public final int corePoolSize;
    public final GlobalQueue globalBlockingQueue;
    public final GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    private volatile long parkedWorkersStack;
    public final String schedulerName;
    public final AtomicReferenceArray<Worker> workers;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkerState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[WorkerState.PARKING.ordinal()] = 1;
            $EnumSwitchMapping$0[WorkerState.BLOCKING.ordinal()] = 2;
            $EnumSwitchMapping$0[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            $EnumSwitchMapping$0[WorkerState.DORMANT.ordinal()] = 4;
            $EnumSwitchMapping$0[WorkerState.TERMINATED.ordinal()] = 5;
        }
    }

    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public CoroutineScheduler(int i2, int i3, long j, String str) {
        this.corePoolSize = i2;
        this.maxPoolSize = i3;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (this.corePoolSize > 0) {
            if (this.maxPoolSize >= this.corePoolSize) {
                if (this.maxPoolSize <= 2097150) {
                    if (this.idleWorkerKeepAliveNs > 0) {
                        this.globalCpuQueue = new GlobalQueue();
                        this.globalBlockingQueue = new GlobalQueue();
                        this.parkedWorkersStack = 0;
                        this.workers = new AtomicReferenceArray<>(this.maxPoolSize + 1);
                        this.controlState = ((long) this.corePoolSize) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + this.idleWorkerKeepAliveNs + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + this.maxPoolSize + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + this.maxPoolSize + " should be greater than or equals to core pool size " + this.corePoolSize).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + this.corePoolSize + " should be at least 1").toString());
    }

    public final boolean parkedWorkersStackPush$kotlinx_coroutines_core(Worker worker) {
        long j;
        long j2;
        int indexInArray;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        do {
            j = this.parkedWorkersStack;
            int i2 = (int) (2097151 & j);
            j2 = (2097152 + j) & -2097152;
            indexInArray = worker.getIndexInArray();
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(indexInArray != 0)) {
                    throw new AssertionError();
                }
            }
            worker.setNextParkedWorker(this.workers.get(i2));
        } while (!parkedWorkersStack$FU.compareAndSet(this, j, ((long) indexInArray) | j2));
        return true;
    }

    private final int parkedWorkersStackNextIndex(Worker worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != NOT_IN_STACK) {
            if (nextParkedWorker == null) {
                return 0;
            }
            Worker worker2 = (Worker) nextParkedWorker;
            int indexInArray = worker2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = worker2.getNextParkedWorker();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final int getCreatedWorkers() {
        return (int) (this.controlState & 2097151);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    static {
        Class<CoroutineScheduler> cls = CoroutineScheduler.class;
        parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(cls, "parkedWorkersStack");
        controlState$FU = AtomicLongFieldUpdater.newUpdater(cls, "controlState");
        _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "_isTerminated");
    }

    public final void execute(Runnable runnable) {
        dispatch$default(this, runnable, (TaskContext) null, false, 6, (Object) null);
    }

    public final void close() {
        shutdown(10000);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0072, code lost:
        if (r9 == null) goto L_0x0074;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void shutdown(long r9) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = _isTerminated$FU
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r0 = r8.currentWorker()
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$Worker> r3 = r8.workers
            monitor-enter(r3)
            long r4 = r8.controlState     // Catch:{ all -> 0x00bc }
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r5 = (int) r4
            monitor-exit(r3)
            if (r5 <= 0) goto L_0x0062
            r3 = 1
        L_0x001d:
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$Worker> r4 = r8.workers
            java.lang.Object r4 = r4.get(r3)
            if (r4 != 0) goto L_0x0028
            kotlin.g.b.k.a()
        L_0x0028:
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r4 = (kotlinx.coroutines.scheduling.CoroutineScheduler.Worker) r4
            if (r4 == r0) goto L_0x005d
        L_0x002c:
            boolean r6 = r4.isAlive()
            if (r6 == 0) goto L_0x003c
            r6 = r4
            java.lang.Thread r6 = (java.lang.Thread) r6
            java.util.concurrent.locks.LockSupport.unpark(r6)
            r4.join(r9)
            goto L_0x002c
        L_0x003c:
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r6 = r4.state
            boolean r7 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            if (r7 == 0) goto L_0x0056
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r7 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            if (r6 != r7) goto L_0x004a
            r6 = 1
            goto L_0x004b
        L_0x004a:
            r6 = 0
        L_0x004b:
            if (r6 == 0) goto L_0x004e
            goto L_0x0056
        L_0x004e:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        L_0x0056:
            kotlinx.coroutines.scheduling.WorkQueue r4 = r4.localQueue
            kotlinx.coroutines.scheduling.GlobalQueue r6 = r8.globalBlockingQueue
            r4.offloadAllWorkTo(r6)
        L_0x005d:
            if (r3 == r5) goto L_0x0062
            int r3 = r3 + 1
            goto L_0x001d
        L_0x0062:
            kotlinx.coroutines.scheduling.GlobalQueue r9 = r8.globalBlockingQueue
            r9.close()
            kotlinx.coroutines.scheduling.GlobalQueue r9 = r8.globalCpuQueue
            r9.close()
        L_0x006c:
            if (r0 == 0) goto L_0x0074
            kotlinx.coroutines.scheduling.Task r9 = r0.findTask(r2)
            if (r9 != 0) goto L_0x007c
        L_0x0074:
            kotlinx.coroutines.scheduling.GlobalQueue r9 = r8.globalCpuQueue
            java.lang.Object r9 = r9.removeFirstOrNull()
            kotlinx.coroutines.scheduling.Task r9 = (kotlinx.coroutines.scheduling.Task) r9
        L_0x007c:
            if (r9 != 0) goto L_0x0086
            kotlinx.coroutines.scheduling.GlobalQueue r9 = r8.globalBlockingQueue
            java.lang.Object r9 = r9.removeFirstOrNull()
            kotlinx.coroutines.scheduling.Task r9 = (kotlinx.coroutines.scheduling.Task) r9
        L_0x0086:
            if (r9 != 0) goto L_0x00b8
            if (r0 == 0) goto L_0x008f
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r9 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.tryReleaseCpu$kotlinx_coroutines_core(r9)
        L_0x008f:
            boolean r9 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            if (r9 == 0) goto L_0x00b1
            long r9 = r8.controlState
            r3 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r3
            r0 = 42
            long r9 = r9 >> r0
            int r10 = (int) r9
            int r9 = r8.corePoolSize
            if (r10 != r9) goto L_0x00a6
            r1 = 1
        L_0x00a6:
            if (r1 == 0) goto L_0x00a9
            goto L_0x00b1
        L_0x00a9:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        L_0x00b1:
            r9 = 0
            r8.parkedWorkersStack = r9
            r8.controlState = r9
            return
        L_0x00b8:
            r8.runSafely(r9)
            goto L_0x006c
        L_0x00bc:
            r9 = move-exception
            monitor-exit(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.shutdown(long):void");
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            taskContext = NonBlockingContext.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        coroutineScheduler.dispatch(runnable, taskContext, z);
    }

    public final void dispatch(Runnable runnable, TaskContext taskContext, boolean z) {
        TimeSource timeSource = TimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.trackTask();
        }
        Task createTask$kotlinx_coroutines_core = createTask$kotlinx_coroutines_core(runnable, taskContext);
        Worker currentWorker = currentWorker();
        Task submitToLocalQueue = submitToLocalQueue(currentWorker, createTask$kotlinx_coroutines_core, z);
        if (submitToLocalQueue == null || addToGlobalQueue(submitToLocalQueue)) {
            boolean z2 = z && currentWorker != null;
            if (createTask$kotlinx_coroutines_core.taskContext.getTaskMode() != 0) {
                signalBlockingWork(z2);
            } else if (!z2) {
                signalCpuWork$kotlinx_coroutines_core();
            }
        } else {
            throw new RejectedExecutionException(this.schedulerName + " was terminated");
        }
    }

    public final Task createTask$kotlinx_coroutines_core(Runnable runnable, TaskContext taskContext) {
        long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
        if (!(runnable instanceof Task)) {
            return new TaskImpl(runnable, nanoTime, taskContext);
        }
        Task task = (Task) runnable;
        task.submissionTime = nanoTime;
        task.taskContext = taskContext;
        return task;
    }

    public final void signalCpuWork$kotlinx_coroutines_core() {
        if (!tryUnpark() && !tryCreateWorker$default(this, 0, 1, (Object) null)) {
            tryUnpark();
        }
    }

    static /* synthetic */ boolean tryCreateWorker$default(CoroutineScheduler coroutineScheduler, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = coroutineScheduler.controlState;
        }
        return coroutineScheduler.tryCreateWorker(j);
    }

    private final boolean tryCreateWorker(long j) {
        if (e.b(((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)), 0) < this.corePoolSize) {
            int createNewWorker = createNewWorker();
            if (createNewWorker == 1 && this.corePoolSize > 1) {
                createNewWorker();
            }
            if (createNewWorker > 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean tryUnpark() {
        Worker parkedWorkersStackPop;
        do {
            parkedWorkersStackPop = parkedWorkersStackPop();
            if (parkedWorkersStackPop == null) {
                return false;
            }
        } while (!Worker.workerCtl$FU.compareAndSet(parkedWorkersStackPop, -1, 0));
        LockSupport.unpark(parkedWorkersStackPop);
        return true;
    }

    private final int createNewWorker() {
        synchronized (this.workers) {
            if (isTerminated()) {
                return -1;
            }
            long j = this.controlState;
            int i2 = (int) (j & 2097151);
            boolean z = false;
            int b2 = e.b(i2 - ((int) ((j & 4398044413952L) >> 21)), 0);
            if (b2 >= this.corePoolSize) {
                return 0;
            }
            if (i2 >= this.maxPoolSize) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (i3 > 0 && this.workers.get(i3) == null) {
                Worker worker = new Worker(this, i3);
                this.workers.set(i3, worker);
                if (i3 == ((int) (2097151 & controlState$FU.incrementAndGet(this)))) {
                    z = true;
                }
                if (z) {
                    worker.start();
                    int i4 = b2 + 1;
                    return i4;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final Task submitToLocalQueue(Worker worker, Task task, boolean z) {
        if (worker == null || worker.state == WorkerState.TERMINATED) {
            return task;
        }
        if (task.taskContext.getTaskMode() == 0 && worker.state == WorkerState.BLOCKING) {
            return task;
        }
        worker.mayHaveLocalTasks = true;
        return worker.localQueue.add(task, z);
    }

    private final Worker currentWorker() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof Worker)) {
            currentThread = null;
        }
        Worker worker = (Worker) currentThread;
        if (worker == null || !k.a((Object) CoroutineScheduler.this, (Object) this)) {
            return null;
        }
        return worker;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.workers.length();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < length; i7++) {
            Worker worker = this.workers.get(i7);
            if (worker != null) {
                int size$kotlinx_coroutines_core = worker.localQueue.getSize$kotlinx_coroutines_core();
                int i8 = WhenMappings.$EnumSwitchMapping$0[worker.state.ordinal()];
                if (i8 == 1) {
                    i4++;
                } else if (i8 == 2) {
                    i3++;
                    arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + "b");
                } else if (i8 == 3) {
                    i2++;
                    arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + "c");
                } else if (i8 == 4) {
                    i5++;
                    if (size$kotlinx_coroutines_core > 0) {
                        arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + "d");
                    }
                } else if (i8 == 5) {
                    i6++;
                }
            }
        }
        long j = this.controlState;
        return this.schedulerName + '@' + DebugStringsKt.getHexAddress(this) + '[' + "Pool Size {core = " + this.corePoolSize + ", max = " + this.maxPoolSize + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.globalCpuQueue.getSize() + ", global blocking queue size = " + this.globalBlockingQueue.getSize() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.corePoolSize - ((int) ((j & 9223367638808264704L) >> 42))) + "}]";
    }

    public final void runSafely(Task task) {
        try {
            task.run();
            TimeSource timeSource = TimeSourceKt.getTimeSource();
            if (timeSource != null) {
                timeSource.unTrackTask();
            }
        } catch (Throwable th) {
            TimeSource timeSource2 = TimeSourceKt.getTimeSource();
            if (timeSource2 != null) {
                timeSource2.unTrackTask();
            }
            throw th;
        }
    }

    public final class Worker extends Thread {
        static final AtomicIntegerFieldUpdater workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        private volatile int indexInArray;
        public final WorkQueue localQueue;
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        private int rngState;
        public WorkerState state;
        private long terminationDeadline;
        volatile int workerCtl;

        private Worker() {
            setDaemon(true);
            this.localQueue = new WorkQueue();
            this.state = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            c.a aVar = c.f47937b;
            this.rngState = c.f47936a.b();
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final void setIndexInArray(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i2) {
            this();
            setIndexInArray(i2);
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        private final boolean tryAcquireCpuPermit() {
            boolean z;
            if (this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            while (true) {
                long j = coroutineScheduler.controlState;
                if (((int) ((9223367638808264704L & j) >> 42)) != 0) {
                    if (CoroutineScheduler.controlState$FU.compareAndSet(coroutineScheduler, j, j - 4398046511104L)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                return false;
            }
            this.state = WorkerState.CPU_ACQUIRED;
            return true;
        }

        public final boolean tryReleaseCpu$kotlinx_coroutines_core(WorkerState workerState) {
            WorkerState workerState2 = this.state;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return z;
        }

        public final void run() {
            runWorker();
        }

        private final void runWorker() {
            loop0:
            while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                    Task findTask = findTask(this.mayHaveLocalTasks);
                    if (findTask != null) {
                        this.minDelayUntilStealableTaskNs = 0;
                        executeTask(findTask);
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs == 0) {
                            tryPark();
                        } else if (!z) {
                            z = true;
                        } else {
                            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0;
                        }
                    }
                }
            }
            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.TERMINATED);
        }

        private final void tryPark() {
            if (!inStack()) {
                CoroutineScheduler.this.parkedWorkersStackPush$kotlinx_coroutines_core(this);
                return;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(this.localQueue.getSize$kotlinx_coroutines_core() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (inStack() && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                tryReleaseCpu$kotlinx_coroutines_core(WorkerState.PARKING);
                Thread.interrupted();
                park();
            }
        }

        private final boolean inStack() {
            return this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK;
        }

        private final void beforeTask(int i2) {
            if (i2 != 0 && tryReleaseCpu$kotlinx_coroutines_core(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.signalCpuWork$kotlinx_coroutines_core();
            }
        }

        private final void afterTask(int i2) {
            if (i2 != 0) {
                CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, -2097152);
                WorkerState workerState = this.state;
                if (workerState != WorkerState.TERMINATED) {
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        if (!(workerState == WorkerState.BLOCKING)) {
                            throw new AssertionError();
                        }
                    }
                    this.state = WorkerState.DORMANT;
                }
            }
        }

        public final int nextInt$kotlinx_coroutines_core(int i2) {
            int i3 = this.rngState;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.rngState = i6;
            int i7 = i2 - 1;
            if ((i7 & i2) == 0) {
                return i6 & i7;
            }
            return (i6 & Integer.MAX_VALUE) % i2;
        }

        private final void park() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0;
                tryTerminateWorker();
            }
        }

        private final void tryTerminateWorker() {
            synchronized (CoroutineScheduler.this.workers) {
                if (!CoroutineScheduler.this.isTerminated()) {
                    if (CoroutineScheduler.this.getCreatedWorkers() > CoroutineScheduler.this.corePoolSize) {
                        if (workerCtl$FU.compareAndSet(this, -1, 1)) {
                            int i2 = this.indexInArray;
                            setIndexInArray(0);
                            CoroutineScheduler.this.parkedWorkersStackTopUpdate$kotlinx_coroutines_core(this, i2, 0);
                            int andDecrement = (int) (CoroutineScheduler.controlState$FU.getAndDecrement(CoroutineScheduler.this) & 2097151);
                            if (andDecrement != i2) {
                                Worker worker = CoroutineScheduler.this.workers.get(andDecrement);
                                if (worker == null) {
                                    k.a();
                                }
                                Worker worker2 = worker;
                                CoroutineScheduler.this.workers.set(i2, worker2);
                                worker2.setIndexInArray(i2);
                                CoroutineScheduler.this.parkedWorkersStackTopUpdate$kotlinx_coroutines_core(worker2, andDecrement, i2);
                            }
                            CoroutineScheduler.this.workers.set(andDecrement, (Object) null);
                            x xVar = x.f47997a;
                            this.state = WorkerState.TERMINATED;
                        }
                    }
                }
            }
        }

        private final void idleReset(int i2) {
            this.terminationDeadline = 0;
            if (this.state == WorkerState.PARKING) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean z = true;
                    if (i2 != 1) {
                        z = false;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                this.state = WorkerState.BLOCKING;
            }
        }

        public final Task findTask(boolean z) {
            Task task;
            if (tryAcquireCpuPermit()) {
                return findAnyTask(z);
            }
            if (!z || (task = this.localQueue.poll()) == null) {
                task = (Task) CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            return task == null ? trySteal(true) : task;
        }

        private final Task findAnyTask(boolean z) {
            Task pollGlobalQueues;
            Task pollGlobalQueues2;
            if (z) {
                boolean z2 = nextInt$kotlinx_coroutines_core(CoroutineScheduler.this.corePoolSize * 2) == 0;
                if (z2 && (pollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return pollGlobalQueues2;
                }
                Task poll = this.localQueue.poll();
                if (poll != null) {
                    return poll;
                }
                if (!z2 && (pollGlobalQueues = pollGlobalQueues()) != null) {
                    return pollGlobalQueues;
                }
            } else {
                Task pollGlobalQueues3 = pollGlobalQueues();
                if (pollGlobalQueues3 != null) {
                    return pollGlobalQueues3;
                }
            }
            return trySteal(false);
        }

        private final Task pollGlobalQueues() {
            if (nextInt$kotlinx_coroutines_core(2) == 0) {
                Task task = (Task) CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
                if (task != null) {
                    return task;
                }
                return (Task) CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            Task task2 = (Task) CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            if (task2 != null) {
                return task2;
            }
            return (Task) CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
        }

        private final Task trySteal(boolean z) {
            long j;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(this.localQueue.getSize$kotlinx_coroutines_core() == 0)) {
                    throw new AssertionError();
                }
            }
            int access$getCreatedWorkers$p = CoroutineScheduler.this.getCreatedWorkers();
            if (access$getCreatedWorkers$p < 2) {
                return null;
            }
            int nextInt$kotlinx_coroutines_core = nextInt$kotlinx_coroutines_core(access$getCreatedWorkers$p);
            long j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < access$getCreatedWorkers$p; i2++) {
                nextInt$kotlinx_coroutines_core++;
                if (nextInt$kotlinx_coroutines_core > access$getCreatedWorkers$p) {
                    nextInt$kotlinx_coroutines_core = 1;
                }
                Worker worker = CoroutineScheduler.this.workers.get(nextInt$kotlinx_coroutines_core);
                if (!(worker == null || worker == this)) {
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        if (!(this.localQueue.getSize$kotlinx_coroutines_core() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    if (z) {
                        j = this.localQueue.tryStealBlockingFrom(worker.localQueue);
                    } else {
                        j = this.localQueue.tryStealFrom(worker.localQueue);
                    }
                    if (j == -1) {
                        return this.localQueue.poll();
                    }
                    if (j > 0) {
                        j2 = Math.min(j2, j);
                    }
                }
            }
            if (j2 == Long.MAX_VALUE) {
                j2 = 0;
            }
            this.minDelayUntilStealableTaskNs = j2;
            return null;
        }

        private final void executeTask(Task task) {
            int taskMode = task.taskContext.getTaskMode();
            idleReset(taskMode);
            beforeTask(taskMode);
            CoroutineScheduler.this.runSafely(task);
            afterTask(taskMode);
        }
    }

    private final boolean addToGlobalQueue(Task task) {
        boolean z = true;
        if (task.taskContext.getTaskMode() != 1) {
            z = false;
        }
        if (z) {
            return this.globalBlockingQueue.addLast(task);
        }
        return this.globalCpuQueue.addLast(task);
    }

    public final void parkedWorkersStackTopUpdate$kotlinx_coroutines_core(Worker worker, int i2, int i3) {
        while (true) {
            long j = this.parkedWorkersStack;
            int i4 = (int) (2097151 & j);
            long j2 = (2097152 + j) & -2097152;
            int parkedWorkersStackNextIndex = i4 == i2 ? i3 == 0 ? parkedWorkersStackNextIndex(worker) : i3 : i4;
            if (parkedWorkersStackNextIndex >= 0) {
                if (parkedWorkersStack$FU.compareAndSet(this, j, j2 | ((long) parkedWorkersStackNextIndex))) {
                    return;
                }
            }
        }
    }

    private final Worker parkedWorkersStackPop() {
        while (true) {
            long j = this.parkedWorkersStack;
            Worker worker = this.workers.get((int) (2097151 & j));
            if (worker == null) {
                return null;
            }
            long j2 = (2097152 + j) & -2097152;
            int parkedWorkersStackNextIndex = parkedWorkersStackNextIndex(worker);
            if (parkedWorkersStackNextIndex >= 0) {
                if (parkedWorkersStack$FU.compareAndSet(this, j, ((long) parkedWorkersStackNextIndex) | j2)) {
                    worker.setNextParkedWorker(NOT_IN_STACK);
                    return worker;
                }
            }
        }
    }

    private final void signalBlockingWork(boolean z) {
        long addAndGet = controlState$FU.addAndGet(this, 2097152);
        if (!z && !tryUnpark() && !tryCreateWorker(addAndGet)) {
            tryUnpark();
        }
    }
}
