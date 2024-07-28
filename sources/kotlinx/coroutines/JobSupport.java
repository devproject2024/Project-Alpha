package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.a;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class JobSupport implements ChildJob, Job, ParentJob {
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* access modifiers changed from: protected */
    public void afterCompletion(Object obj) {
    }

    /* access modifiers changed from: protected */
    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean handleJobException(Throwable th) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isScopedCoroutine() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCancelling(Throwable th) {
    }

    /* access modifiers changed from: protected */
    public void onCompletionInternal(Object obj) {
    }

    public void onStartInternal$kotlinx_coroutines_core() {
    }

    public JobSupport(boolean z) {
        this._state = z ? JobSupportKt.EMPTY_ACTIVE : JobSupportKt.EMPTY_NEW;
        this._parentHandle = null;
    }

    public <R> R fold(R r, m<? super R, ? super f.b, ? extends R> mVar) {
        return Job.DefaultImpls.fold(this, r, mVar);
    }

    public <E extends f.b> E get(f.c<E> cVar) {
        return Job.DefaultImpls.get(this, cVar);
    }

    public f minusKey(f.c<?> cVar) {
        return Job.DefaultImpls.minusKey(this, cVar);
    }

    public f plus(f fVar) {
        return Job.DefaultImpls.plus(this, fVar);
    }

    public final f.c<?> getKey() {
        return Job.Key;
    }

    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle) this._parentHandle;
    }

    public final void setParentHandle$kotlinx_coroutines_core(ChildHandle childHandle) {
        this._parentHandle = childHandle;
    }

    public final void initParentJobInternal$kotlinx_coroutines_core(Job job) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getParentHandle$kotlinx_coroutines_core() == null)) {
                throw new AssertionError();
            }
        }
        if (job == null) {
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
            return;
        }
        job.start();
        ChildHandle attachChild = job.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(attachChild);
        if (isCompleted()) {
            attachChild.dispose();
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
    }

    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).isActive();
    }

    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    private final Object finalizeFinishingState(Finishing finishing, Object obj) {
        boolean isCancelling;
        Throwable finalRootCause;
        boolean z = true;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getState$kotlinx_coroutines_core() == finishing)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED() && !(!finishing.isSealed())) {
            throw new AssertionError();
        } else if (!DebugKt.getASSERTIONS_ENABLED() || finishing.isCompleting()) {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) (!(obj instanceof CompletedExceptionally) ? null : obj);
            Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
            synchronized (finishing) {
                isCancelling = finishing.isCancelling();
                List<Throwable> sealLocked = finishing.sealLocked(th);
                finalRootCause = getFinalRootCause(finishing, sealLocked);
                if (finalRootCause != null) {
                    addSuppressedExceptions(finalRootCause, sealLocked);
                }
            }
            if (!(finalRootCause == null || finalRootCause == th)) {
                obj = new CompletedExceptionally(finalRootCause, false, 2, (g) null);
            }
            if (finalRootCause != null) {
                if (!cancelParent(finalRootCause) && !handleJobException(finalRootCause)) {
                    z = false;
                }
                if (z) {
                    if (obj != null) {
                        ((CompletedExceptionally) obj).makeHandled();
                    } else {
                        throw new u("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                    }
                }
            }
            if (!isCancelling) {
                onCancelling(finalRootCause);
            }
            onCompletionInternal(obj);
            boolean compareAndSet = _state$FU.compareAndSet(this, finishing, JobSupportKt.boxIncomplete(obj));
            if (!DebugKt.getASSERTIONS_ENABLED() || compareAndSet) {
                completeStateFinalization(finishing, obj);
                return obj;
            }
            throw new AssertionError();
        } else {
            throw new AssertionError();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Throwable getFinalRootCause(kotlinx.coroutines.JobSupport.Finishing r6, java.util.List<? extends java.lang.Throwable> r7) {
        /*
            r5 = this;
            boolean r0 = r7.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x001d
            boolean r6 = r6.isCancelling()
            if (r6 == 0) goto L_0x001c
            kotlinx.coroutines.JobCancellationException r6 = new kotlinx.coroutines.JobCancellationException
            java.lang.String r7 = r5.cancellationExceptionMessage()
            r0 = r5
            kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
            r6.<init>(r7, r1, r0)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            return r6
        L_0x001c:
            return r1
        L_0x001d:
            r6 = r7
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r0 = r6.iterator()
        L_0x0024:
            boolean r2 = r0.hasNext()
            r3 = 1
            if (r2 == 0) goto L_0x0038
            java.lang.Object r2 = r0.next()
            r4 = r2
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r4 = r4 instanceof java.util.concurrent.CancellationException
            r4 = r4 ^ r3
            if (r4 == 0) goto L_0x0024
            goto L_0x0039
        L_0x0038:
            r2 = r1
        L_0x0039:
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            if (r2 == 0) goto L_0x003e
            return r2
        L_0x003e:
            r0 = 0
            java.lang.Object r7 = r7.get(r0)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            boolean r2 = r7 instanceof kotlinx.coroutines.TimeoutCancellationException
            if (r2 == 0) goto L_0x006b
            java.util.Iterator r6 = r6.iterator()
        L_0x004d:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x0066
            java.lang.Object r2 = r6.next()
            r4 = r2
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            if (r4 == r7) goto L_0x0062
            boolean r4 = r4 instanceof kotlinx.coroutines.TimeoutCancellationException
            if (r4 == 0) goto L_0x0062
            r4 = 1
            goto L_0x0063
        L_0x0062:
            r4 = 0
        L_0x0063:
            if (r4 == 0) goto L_0x004d
            r1 = r2
        L_0x0066:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            if (r1 == 0) goto L_0x006b
            return r1
        L_0x006b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.getFinalRootCause(kotlinx.coroutines.JobSupport$Finishing, java.util.List):java.lang.Throwable");
    }

    private final void addSuppressedExceptions(Throwable th, List<? extends Throwable> list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            Throwable unwrapImpl = !DebugKt.getRECOVER_STACK_TRACES() ? th : StackTraceRecoveryKt.unwrapImpl(th);
            for (Throwable th2 : list) {
                if (DebugKt.getRECOVER_STACK_TRACES()) {
                    th2 = StackTraceRecoveryKt.unwrapImpl(th2);
                }
                if (th2 != th && th2 != unwrapImpl && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                    a.a(th, th2);
                }
            }
        }
    }

    private final boolean tryFinalizeSimpleState(Incomplete incomplete, Object obj) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!((incomplete instanceof Empty) || (incomplete instanceof JobNode))) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED() && !(!(obj instanceof CompletedExceptionally))) {
            throw new AssertionError();
        } else if (!_state$FU.compareAndSet(this, incomplete, JobSupportKt.boxIncomplete(obj))) {
            return false;
        } else {
            onCancelling((Throwable) null);
            onCompletionInternal(obj);
            completeStateFinalization(incomplete, obj);
            return true;
        }
    }

    private final void completeStateFinalization(Incomplete incomplete, Object obj) {
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            parentHandle$kotlinx_coroutines_core.dispose();
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
        Throwable th = null;
        if (!(obj instanceof CompletedExceptionally)) {
            obj = null;
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
        if (completedExceptionally != null) {
            th = completedExceptionally.cause;
        }
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).invoke(th);
            } catch (Throwable th2) {
                handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
            }
        } else {
            NodeList list = incomplete.getList();
            if (list != null) {
                notifyCompletion(list, th);
            }
        }
    }

    private final void notifyCancelling(NodeList nodeList, Throwable th) {
        onCancelling(th);
        LockFreeLinkedListHead lockFreeLinkedListHead = nodeList;
        Object next = lockFreeLinkedListHead.getNext();
        if (next != null) {
            Throwable th2 = null;
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !k.a((Object) lockFreeLinkedListNode, (Object) lockFreeLinkedListHead); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                    JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                    try {
                        jobNode.invoke(th);
                    } catch (Throwable th3) {
                        if (th2 != null) {
                            a.a(th2, th3);
                            if (th2 != null) {
                            }
                        }
                        th2 = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th3);
                        x xVar = x.f47997a;
                    }
                }
            }
            if (th2 != null) {
                handleOnCompletionException$kotlinx_coroutines_core(th2);
            }
            cancelParent(th);
            return;
        }
        throw new u("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    private final boolean cancelParent(Throwable th) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core == null || parentHandle$kotlinx_coroutines_core == NonDisposableHandle.INSTANCE) {
            return z;
        }
        if (parentHandle$kotlinx_coroutines_core.childCancelled(th) || z) {
            return true;
        }
        return false;
    }

    private final int startInternal(Object obj) {
        if (obj instanceof Empty) {
            if (((Empty) obj).isActive()) {
                return 0;
            }
            if (!_state$FU.compareAndSet(this, obj, JobSupportKt.EMPTY_ACTIVE)) {
                return -1;
            }
            onStartInternal$kotlinx_coroutines_core();
            return 1;
        } else if (!(obj instanceof InactiveNodeList)) {
            return 0;
        } else {
            if (!_state$FU.compareAndSet(this, obj, ((InactiveNodeList) obj).getList())) {
                return -1;
            }
            onStartInternal$kotlinx_coroutines_core();
            return 1;
        }
    }

    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            Throwable rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
            if (rootCause != null) {
                CancellationException cancellationException = toCancellationException(rootCause, DebugStringsKt.getClassSimpleName(this) + " is cancelling");
                if (cancellationException != null) {
                    return cancellationException;
                }
            }
            throw new IllegalStateException("Job is still new or active: ".concat(String.valueOf(this)).toString());
        } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException("Job is still new or active: ".concat(String.valueOf(this)).toString());
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return toCancellationException$default(this, ((CompletedExceptionally) state$kotlinx_coroutines_core).cause, (String) null, 1, (Object) null);
        } else {
            return new JobCancellationException(DebugStringsKt.getClassSimpleName(this) + " has completed normally", (Throwable) null, this);
        }
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport jobSupport, Throwable th, String str, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = null;
            }
            return jobSupport.toCancellationException(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    /* access modifiers changed from: protected */
    public final CancellationException toCancellationException(Throwable th, String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (cancellationException != null) {
            return cancellationException;
        }
        if (str == null) {
            str = cancellationExceptionMessage();
        }
        return new JobCancellationException(str, th, this);
    }

    public final DisposableHandle invokeOnCompletion(b<? super Throwable, x> bVar) {
        return invokeOnCompletion(false, true, bVar);
    }

    private final JobNode<?> makeNode(b<? super Throwable, x> bVar, boolean z) {
        boolean z2 = true;
        JobCancellingNode jobCancellingNode = null;
        if (z) {
            if (bVar instanceof JobCancellingNode) {
                jobCancellingNode = bVar;
            }
            JobCancellingNode jobCancellingNode2 = jobCancellingNode;
            if (jobCancellingNode2 != null) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (jobCancellingNode2.job != this) {
                        z2 = false;
                    }
                    if (!z2) {
                        throw new AssertionError();
                    }
                }
                if (jobCancellingNode2 != null) {
                    return jobCancellingNode2;
                }
            }
            return new InvokeOnCancelling(this, bVar);
        }
        if (bVar instanceof JobNode) {
            jobCancellingNode = bVar;
        }
        JobNode<?> jobNode = jobCancellingNode;
        if (jobNode != null) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (jobNode.job != this || (jobNode instanceof JobCancellingNode)) {
                    z2 = false;
                }
                if (!z2) {
                    throw new AssertionError();
                }
            }
            if (jobNode != null) {
                return jobNode;
            }
        }
        return new InvokeOnCompletion(this, bVar);
    }

    private final boolean addLastAtomic(Object obj, NodeList nodeList, JobNode<?> jobNode) {
        int tryCondAddNext;
        LockFreeLinkedListNode lockFreeLinkedListNode = nodeList;
        LockFreeLinkedListNode lockFreeLinkedListNode2 = jobNode;
        LockFreeLinkedListNode.CondAddOp jobSupport$addLastAtomic$$inlined$addLastIf$1 = new JobSupport$addLastAtomic$$inlined$addLastIf$1(lockFreeLinkedListNode2, lockFreeLinkedListNode2, this, obj);
        do {
            tryCondAddNext = lockFreeLinkedListNode.getPrevNode().tryCondAddNext(lockFreeLinkedListNode2, lockFreeLinkedListNode, jobSupport$addLastAtomic$$inlined$addLastIf$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    private final void promoteEmptyToNodeList(Empty empty) {
        NodeList nodeList = new NodeList();
        _state$FU.compareAndSet(this, empty, empty.isActive() ? nodeList : new InactiveNodeList(nodeList));
    }

    private final void promoteSingleToNodeList(JobNode<?> jobNode) {
        jobNode.addOneIfEmpty(new NodeList());
        _state$FU.compareAndSet(this, jobNode, jobNode.getNextNode());
    }

    public final Object join(d<? super x> dVar) {
        if (!joinInternal()) {
            YieldKt.checkCompletion(dVar.getContext());
            return x.f47997a;
        }
        Object joinSuspend = joinSuspend(dVar);
        return joinSuspend == kotlin.d.a.a.COROUTINE_SUSPENDED ? joinSuspend : x.f47997a;
    }

    public void cancel(CancellationException cancellationException) {
        cancelInternal(cancellationException != null ? cancellationException : new JobCancellationException(cancellationExceptionMessage(), (Throwable) null, this));
    }

    public void cancelInternal(Throwable th) {
        cancelImpl$kotlinx_coroutines_core(th);
    }

    public final void parentCancelled(ParentJob parentJob) {
        cancelImpl$kotlinx_coroutines_core(parentJob);
    }

    public boolean childCancelled(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (!cancelImpl$kotlinx_coroutines_core(th) || !getHandlesException$kotlinx_coroutines_core()) {
            return false;
        }
        return true;
    }

    public final boolean cancelCoroutine(Throwable th) {
        return cancelImpl$kotlinx_coroutines_core(th);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(Object obj) {
        Object access$getCOMPLETING_ALREADY$p = JobSupportKt.COMPLETING_ALREADY;
        if (getOnCancelComplete$kotlinx_coroutines_core() && (access$getCOMPLETING_ALREADY$p = cancelMakeCompleting(obj)) == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        if (access$getCOMPLETING_ALREADY$p == JobSupportKt.COMPLETING_ALREADY) {
            access$getCOMPLETING_ALREADY$p = makeCancelling(obj);
        }
        if (access$getCOMPLETING_ALREADY$p == JobSupportKt.COMPLETING_ALREADY || access$getCOMPLETING_ALREADY$p == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        if (access$getCOMPLETING_ALREADY$p == JobSupportKt.TOO_LATE_TO_CANCEL) {
            return false;
        }
        afterCompletion(access$getCOMPLETING_ALREADY$p);
        return true;
    }

    public CancellationException getChildJobCancellationCause() {
        Throwable th;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        CancellationException cancellationException = null;
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            th = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            th = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            th = null;
        } else {
            throw new IllegalStateException("Cannot be cancelling child in this state: ".concat(String.valueOf(state$kotlinx_coroutines_core)).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = th;
        }
        CancellationException cancellationException2 = cancellationException;
        if (cancellationException2 != null) {
            return cancellationException2;
        }
        return new JobCancellationException("Parent job is " + stateString(state$kotlinx_coroutines_core), th, this);
    }

    private final Throwable createCauseException(Object obj) {
        boolean z;
        if (obj != null) {
            z = obj instanceof Throwable;
        } else {
            z = true;
        }
        if (z) {
            if (obj != null) {
                return (Throwable) obj;
            }
            return new JobCancellationException(cancellationExceptionMessage(), (Throwable) null, this);
        } else if (obj != null) {
            return ((ParentJob) obj).getChildJobCancellationCause();
        } else {
            throw new u("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        }
    }

    private final NodeList getOrPromoteCancellingList(Incomplete incomplete) {
        NodeList list = incomplete.getList();
        if (list != null) {
            return list;
        }
        if (incomplete instanceof Empty) {
            return new NodeList();
        }
        if (incomplete instanceof JobNode) {
            promoteSingleToNodeList((JobNode) incomplete);
            return null;
        }
        throw new IllegalStateException("State should have list: ".concat(String.valueOf(incomplete)).toString());
    }

    private final boolean tryMakeCancelling(Incomplete incomplete, Throwable th) {
        if (DebugKt.getASSERTIONS_ENABLED() && !(!(incomplete instanceof Finishing))) {
            throw new AssertionError();
        } else if (!DebugKt.getASSERTIONS_ENABLED() || incomplete.isActive()) {
            NodeList orPromoteCancellingList = getOrPromoteCancellingList(incomplete);
            if (orPromoteCancellingList == null) {
                return false;
            }
            if (!_state$FU.compareAndSet(this, incomplete, new Finishing(orPromoteCancellingList, false, th))) {
                return false;
            }
            notifyCancelling(orPromoteCancellingList, th);
            return true;
        } else {
            throw new AssertionError();
        }
    }

    private final Object tryMakeCompleting(Object obj, Object obj2) {
        if (!(obj instanceof Incomplete)) {
            return JobSupportKt.COMPLETING_ALREADY;
        }
        if ((!(obj instanceof Empty) && !(obj instanceof JobNode)) || (obj instanceof ChildHandleNode) || (obj2 instanceof CompletedExceptionally)) {
            return tryMakeCompletingSlowPath((Incomplete) obj, obj2);
        }
        if (tryFinalizeSimpleState((Incomplete) obj, obj2)) {
            return obj2;
        }
        return JobSupportKt.COMPLETING_RETRY;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0073, code lost:
        if (r2 == null) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0075, code lost:
        notifyCancelling(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0078, code lost:
        r7 = firstChild(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x007c, code lost:
        if (r7 == null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0082, code lost:
        if (tryWaitForChild(r1, r7, r8) == false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0086, code lost:
        return kotlinx.coroutines.JobSupportKt.COMPLETING_WAITING_CHILDREN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x008b, code lost:
        return finalizeFinishingState(r1, r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object tryMakeCompletingSlowPath(kotlinx.coroutines.Incomplete r7, java.lang.Object r8) {
        /*
            r6 = this;
            kotlinx.coroutines.NodeList r0 = r6.getOrPromoteCancellingList(r7)
            if (r0 != 0) goto L_0x000b
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.COMPLETING_RETRY
            return r7
        L_0x000b:
            boolean r1 = r7 instanceof kotlinx.coroutines.JobSupport.Finishing
            r2 = 0
            if (r1 != 0) goto L_0x0012
            r1 = r2
            goto L_0x0013
        L_0x0012:
            r1 = r7
        L_0x0013:
            kotlinx.coroutines.JobSupport$Finishing r1 = (kotlinx.coroutines.JobSupport.Finishing) r1
            if (r1 != 0) goto L_0x001d
            kotlinx.coroutines.JobSupport$Finishing r1 = new kotlinx.coroutines.JobSupport$Finishing
            r3 = 0
            r1.<init>(r0, r3, r2)
        L_0x001d:
            monitor-enter(r1)
            boolean r3 = r1.isCompleting()     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x002a
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.COMPLETING_ALREADY     // Catch:{ all -> 0x008c }
            monitor-exit(r1)
            return r7
        L_0x002a:
            r3 = 1
            r1.setCompleting(r3)     // Catch:{ all -> 0x008c }
            if (r1 == r7) goto L_0x003e
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = _state$FU     // Catch:{ all -> 0x008c }
            boolean r4 = r4.compareAndSet(r6, r7, r1)     // Catch:{ all -> 0x008c }
            if (r4 != 0) goto L_0x003e
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.COMPLETING_RETRY     // Catch:{ all -> 0x008c }
            monitor-exit(r1)
            return r7
        L_0x003e:
            boolean r4 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()     // Catch:{ all -> 0x008c }
            if (r4 == 0) goto L_0x0054
            boolean r4 = r1.isSealed()     // Catch:{ all -> 0x008c }
            r4 = r4 ^ r3
            if (r4 == 0) goto L_0x004c
            goto L_0x0054
        L_0x004c:
            java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch:{ all -> 0x008c }
            r7.<init>()     // Catch:{ all -> 0x008c }
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x008c }
            throw r7     // Catch:{ all -> 0x008c }
        L_0x0054:
            boolean r4 = r1.isCancelling()     // Catch:{ all -> 0x008c }
            boolean r5 = r8 instanceof kotlinx.coroutines.CompletedExceptionally     // Catch:{ all -> 0x008c }
            if (r5 != 0) goto L_0x005e
            r5 = r2
            goto L_0x005f
        L_0x005e:
            r5 = r8
        L_0x005f:
            kotlinx.coroutines.CompletedExceptionally r5 = (kotlinx.coroutines.CompletedExceptionally) r5     // Catch:{ all -> 0x008c }
            if (r5 == 0) goto L_0x0068
            java.lang.Throwable r5 = r5.cause     // Catch:{ all -> 0x008c }
            r1.addExceptionLocked(r5)     // Catch:{ all -> 0x008c }
        L_0x0068:
            java.lang.Throwable r5 = r1.getRootCause()     // Catch:{ all -> 0x008c }
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x0070
            r2 = r5
        L_0x0070:
            kotlin.x r3 = kotlin.x.f47997a     // Catch:{ all -> 0x008c }
            monitor-exit(r1)
            if (r2 == 0) goto L_0x0078
            r6.notifyCancelling(r0, r2)
        L_0x0078:
            kotlinx.coroutines.ChildHandleNode r7 = r6.firstChild(r7)
            if (r7 == 0) goto L_0x0087
            boolean r7 = r6.tryWaitForChild(r1, r7, r8)
            if (r7 == 0) goto L_0x0087
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.COMPLETING_WAITING_CHILDREN
            return r7
        L_0x0087:
            java.lang.Object r7 = r6.finalizeFinishingState(r1, r8)
            return r7
        L_0x008c:
            r7 = move-exception
            monitor-exit(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.tryMakeCompletingSlowPath(kotlinx.coroutines.Incomplete, java.lang.Object):java.lang.Object");
    }

    private final Throwable getExceptionOrNull(Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            obj = null;
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    private final ChildHandleNode firstChild(Incomplete incomplete) {
        ChildHandleNode childHandleNode = (ChildHandleNode) (!(incomplete instanceof ChildHandleNode) ? null : incomplete);
        if (childHandleNode != null) {
            return childHandleNode;
        }
        NodeList list = incomplete.getList();
        if (list != null) {
            return nextChild(list);
        }
        return null;
    }

    private final boolean tryWaitForChild(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        while (Job.DefaultImpls.invokeOnCompletion$default(childHandleNode.childJob, false, false, new ChildCompletion(this, finishing, childHandleNode, obj), 1, (Object) null) == NonDisposableHandle.INSTANCE) {
            childHandleNode = nextChild(childHandleNode);
            if (childHandleNode == null) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void continueCompleting(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getState$kotlinx_coroutines_core() == finishing)) {
                throw new AssertionError();
            }
        }
        ChildHandleNode nextChild = nextChild(childHandleNode);
        if (nextChild == null || !tryWaitForChild(finishing, nextChild, obj)) {
            afterCompletion(finalizeFinishingState(finishing, obj));
        }
    }

    private final ChildHandleNode nextChild(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getPrevNode();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    public final ChildHandle attachChild(ChildJob childJob) {
        DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(this, true, false, new ChildHandleNode(this, childJob), 2, (Object) null);
        if (invokeOnCompletion$default != null) {
            return (ChildHandle) invokeOnCompletion$default;
        }
        throw new u("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(Throwable th) {
        throw th;
    }

    public String toString() {
        return toDebugString() + '@' + DebugStringsKt.getHexAddress(this);
    }

    public final String toDebugString() {
        return nameString$kotlinx_coroutines_core() + '{' + stateString(getState$kotlinx_coroutines_core()) + '}';
    }

    public String nameString$kotlinx_coroutines_core() {
        return DebugStringsKt.getClassSimpleName(this);
    }

    private final String stateString(Object obj) {
        if (obj instanceof Finishing) {
            Finishing finishing = (Finishing) obj;
            if (finishing.isCancelling()) {
                return "Cancelling";
            }
            if (finishing.isCompleting()) {
                return "Completing";
            }
            return "Active";
        } else if (!(obj instanceof Incomplete)) {
            return obj instanceof CompletedExceptionally ? "Cancelled" : "Completed";
        } else {
            if (((Incomplete) obj).isActive()) {
                return "Active";
            }
            return SDKConstants.GA_KEY_NEW;
        }
    }

    static final class Finishing implements Incomplete {
        private volatile Object _exceptionsHolder = null;
        private volatile int _isCompleting;
        private volatile Object _rootCause;
        private final NodeList list;

        public final NodeList getList() {
            return this.list;
        }

        public Finishing(NodeList nodeList, boolean z, Throwable th) {
            this.list = nodeList;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
        public final boolean isCompleting() {
            return this._isCompleting;
        }

        public final void setCompleting(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        public final Throwable getRootCause() {
            return (Throwable) this._rootCause;
        }

        public final void setRootCause(Throwable th) {
            this._rootCause = th;
        }

        private final Object getExceptionsHolder() {
            return this._exceptionsHolder;
        }

        private final void setExceptionsHolder(Object obj) {
            this._exceptionsHolder = obj;
        }

        public final boolean isSealed() {
            return getExceptionsHolder() == JobSupportKt.SEALED;
        }

        public final boolean isCancelling() {
            return getRootCause() != null;
        }

        public final boolean isActive() {
            return getRootCause() == null;
        }

        public final List<Throwable> sealLocked(Throwable th) {
            ArrayList<Throwable> arrayList;
            Object exceptionsHolder = getExceptionsHolder();
            if (exceptionsHolder == null) {
                arrayList = allocateList();
            } else if (exceptionsHolder instanceof Throwable) {
                ArrayList<Throwable> allocateList = allocateList();
                allocateList.add(exceptionsHolder);
                arrayList = allocateList;
            } else if (exceptionsHolder instanceof ArrayList) {
                arrayList = (ArrayList) exceptionsHolder;
            } else {
                throw new IllegalStateException("State is ".concat(String.valueOf(exceptionsHolder)).toString());
            }
            Throwable rootCause = getRootCause();
            if (rootCause != null) {
                arrayList.add(0, rootCause);
            }
            if (th != null && (!k.a((Object) th, (Object) rootCause))) {
                arrayList.add(th);
            }
            setExceptionsHolder(JobSupportKt.SEALED);
            return arrayList;
        }

        public final void addExceptionLocked(Throwable th) {
            Throwable rootCause = getRootCause();
            if (rootCause == null) {
                setRootCause(th);
            } else if (th != rootCause) {
                Object exceptionsHolder = getExceptionsHolder();
                if (exceptionsHolder == null) {
                    setExceptionsHolder(th);
                } else if (exceptionsHolder instanceof Throwable) {
                    if (th != exceptionsHolder) {
                        ArrayList<Throwable> allocateList = allocateList();
                        allocateList.add(exceptionsHolder);
                        allocateList.add(th);
                        setExceptionsHolder(allocateList);
                    }
                } else if (exceptionsHolder instanceof ArrayList) {
                    ((ArrayList) exceptionsHolder).add(th);
                } else {
                    throw new IllegalStateException("State is ".concat(String.valueOf(exceptionsHolder)).toString());
                }
            }
        }

        private final ArrayList<Throwable> allocateList() {
            return new ArrayList<>(4);
        }

        public final String toString() {
            return "Finishing[cancelling=" + isCancelling() + ", completing=" + isCompleting() + ", rootCause=" + getRootCause() + ", exceptions=" + getExceptionsHolder() + ", list=" + getList() + ']';
        }
    }

    static final class ChildCompletion extends JobNode<Job> {
        private final ChildHandleNode child;
        private final JobSupport parent;
        private final Object proposedUpdate;
        private final Finishing state;

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return x.f47997a;
        }

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
            super(childHandleNode.childJob);
            this.parent = jobSupport;
            this.state = finishing;
            this.child = childHandleNode;
            this.proposedUpdate = obj;
        }

        public final void invoke(Throwable th) {
            this.parent.continueCompleting(this.state, this.child, this.proposedUpdate);
        }

        public final String toString() {
            return "ChildCompletion[" + this.child + ", " + this.proposedUpdate + ']';
        }
    }

    static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        private final JobSupport job;

        /* access modifiers changed from: protected */
        public final String nameString() {
            return "AwaitContinuation";
        }

        public AwaitContinuation(d<? super T> dVar, JobSupport jobSupport) {
            super(dVar, 1);
            this.job = jobSupport;
        }

        public final Throwable getContinuationCancellationCause(Job job2) {
            Throwable rootCause;
            Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
            if ((state$kotlinx_coroutines_core instanceof Finishing) && (rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause()) != null) {
                return rootCause;
            }
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                return ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            }
            return job2.getCancellationException();
        }
    }

    public final Object awaitInternal$kotlinx_coroutines_core(d<Object> dVar) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                    return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
                }
                Throwable th = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
                if (!DebugKt.getRECOVER_STACK_TRACES()) {
                    throw th;
                } else if (!(dVar instanceof e)) {
                    throw th;
                } else {
                    throw StackTraceRecoveryKt.recoverFromStackFrame(th, (e) dVar);
                }
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return awaitSuspend(dVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object awaitSuspend(d<Object> dVar) {
        AwaitContinuation awaitContinuation = new AwaitContinuation(kotlin.d.a.b.a(dVar), this);
        CancellableContinuationKt.disposeOnCancellation(awaitContinuation, invokeOnCompletion(new ResumeAwaitOnCompletion(this, awaitContinuation)));
        Object result = awaitContinuation.getResult();
        if (result == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return result;
    }

    public final Object getState$kotlinx_coroutines_core() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    private final void notifyCompletion(NodeList nodeList, Throwable th) {
        LockFreeLinkedListHead lockFreeLinkedListHead = nodeList;
        Object next = lockFreeLinkedListHead.getNext();
        if (next != null) {
            Throwable th2 = null;
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !k.a((Object) lockFreeLinkedListNode, (Object) lockFreeLinkedListHead); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof JobNode) {
                    JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                    try {
                        jobNode.invoke(th);
                    } catch (Throwable th3) {
                        if (th2 != null) {
                            a.a(th2, th3);
                            if (th2 != null) {
                            }
                        }
                        th2 = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th3);
                        x xVar = x.f47997a;
                    }
                }
            }
            if (th2 != null) {
                handleOnCompletionException$kotlinx_coroutines_core(th2);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    public final boolean start() {
        int startInternal;
        do {
            startInternal = startInternal(getState$kotlinx_coroutines_core());
            if (startInternal == 0) {
                return false;
            }
        } while (startInternal != 1);
        return true;
    }

    public final DisposableHandle invokeOnCompletion(boolean z, boolean z2, b<? super Throwable, x> bVar) {
        Throwable th;
        Throwable th2 = null;
        JobNode<?> jobNode = null;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Empty) {
                Empty empty = (Empty) state$kotlinx_coroutines_core;
                if (empty.isActive()) {
                    if (jobNode == null) {
                        jobNode = makeNode(bVar, z);
                    }
                    if (_state$FU.compareAndSet(this, state$kotlinx_coroutines_core, jobNode)) {
                        return jobNode;
                    }
                } else {
                    promoteEmptyToNodeList(empty);
                }
            } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
                NodeList list = ((Incomplete) state$kotlinx_coroutines_core).getList();
                if (list != null) {
                    DisposableHandle disposableHandle = NonDisposableHandle.INSTANCE;
                    if (!z || !(state$kotlinx_coroutines_core instanceof Finishing)) {
                        th = null;
                    } else {
                        synchronized (state$kotlinx_coroutines_core) {
                            th = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
                            if (th == null || ((bVar instanceof ChildHandleNode) && !((Finishing) state$kotlinx_coroutines_core).isCompleting())) {
                                if (jobNode == null) {
                                    jobNode = makeNode(bVar, z);
                                }
                                if (addLastAtomic(state$kotlinx_coroutines_core, list, jobNode)) {
                                    if (th == null) {
                                        DisposableHandle disposableHandle2 = jobNode;
                                        return disposableHandle2;
                                    }
                                    disposableHandle = jobNode;
                                }
                            }
                            x xVar = x.f47997a;
                        }
                    }
                    if (th != null) {
                        if (z2) {
                            bVar.invoke(th);
                        }
                        return disposableHandle;
                    }
                    if (jobNode == null) {
                        jobNode = makeNode(bVar, z);
                    }
                    if (addLastAtomic(state$kotlinx_coroutines_core, list, jobNode)) {
                        return jobNode;
                    }
                } else if (state$kotlinx_coroutines_core != null) {
                    promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
                } else {
                    throw new u("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                }
            } else {
                if (z2) {
                    if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                        state$kotlinx_coroutines_core = null;
                    }
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) state$kotlinx_coroutines_core;
                    if (completedExceptionally != null) {
                        th2 = completedExceptionally.cause;
                    }
                    bVar.invoke(th2);
                }
                return NonDisposableHandle.INSTANCE;
            }
        }
    }

    private final boolean joinInternal() {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                return false;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object joinSuspend(d<? super x> dVar) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.d.a.b.a(dVar), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        CancellableContinuationKt.disposeOnCancellation(cancellableContinuation, invokeOnCompletion(new ResumeOnCompletion(this, cancellableContinuation)));
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return result;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void removeNode$kotlinx_coroutines_core(kotlinx.coroutines.JobNode<?> r4) {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Object r0 = r3.getState$kotlinx_coroutines_core()
            boolean r1 = r0 instanceof kotlinx.coroutines.JobNode
            if (r1 == 0) goto L_0x0018
            if (r0 == r4) goto L_0x000b
            return
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = _state$FU
            kotlinx.coroutines.Empty r2 = kotlinx.coroutines.JobSupportKt.EMPTY_ACTIVE
            boolean r0 = r1.compareAndSet(r3, r0, r2)
            if (r0 == 0) goto L_0x0000
            return
        L_0x0018:
            boolean r1 = r0 instanceof kotlinx.coroutines.Incomplete
            if (r1 == 0) goto L_0x0027
            kotlinx.coroutines.Incomplete r0 = (kotlinx.coroutines.Incomplete) r0
            kotlinx.coroutines.NodeList r0 = r0.getList()
            if (r0 == 0) goto L_0x0027
            r4.remove()
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.removeNode$kotlinx_coroutines_core(kotlinx.coroutines.JobNode):void");
    }

    private final Object cancelMakeCompleting(Object obj) {
        Object tryMakeCompleting;
        do {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete) || ((state$kotlinx_coroutines_core instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core).isCompleting())) {
                return JobSupportKt.COMPLETING_ALREADY;
            }
            tryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new CompletedExceptionally(createCauseException(obj), false, 2, (g) null));
        } while (tryMakeCompleting == JobSupportKt.COMPLETING_RETRY);
        return tryMakeCompleting;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        if (r7 == null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
        notifyCancelling(((kotlinx.coroutines.JobSupport.Finishing) r2).getList(), r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        return kotlinx.coroutines.JobSupportKt.COMPLETING_ALREADY;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object makeCancelling(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r6.getState$kotlinx_coroutines_core()
            boolean r3 = r2 instanceof kotlinx.coroutines.JobSupport.Finishing
            if (r3 == 0) goto L_0x0052
            monitor-enter(r2)
            r3 = r2
            kotlinx.coroutines.JobSupport$Finishing r3 = (kotlinx.coroutines.JobSupport.Finishing) r3     // Catch:{ all -> 0x004f }
            boolean r3 = r3.isSealed()     // Catch:{ all -> 0x004f }
            if (r3 == 0) goto L_0x001a
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.TOO_LATE_TO_CANCEL     // Catch:{ all -> 0x004f }
            monitor-exit(r2)
            return r7
        L_0x001a:
            r3 = r2
            kotlinx.coroutines.JobSupport$Finishing r3 = (kotlinx.coroutines.JobSupport.Finishing) r3     // Catch:{ all -> 0x004f }
            boolean r3 = r3.isCancelling()     // Catch:{ all -> 0x004f }
            if (r7 != 0) goto L_0x0025
            if (r3 != 0) goto L_0x0031
        L_0x0025:
            if (r1 != 0) goto L_0x002b
            java.lang.Throwable r1 = r6.createCauseException(r7)     // Catch:{ all -> 0x004f }
        L_0x002b:
            r7 = r2
            kotlinx.coroutines.JobSupport$Finishing r7 = (kotlinx.coroutines.JobSupport.Finishing) r7     // Catch:{ all -> 0x004f }
            r7.addExceptionLocked(r1)     // Catch:{ all -> 0x004f }
        L_0x0031:
            r7 = r2
            kotlinx.coroutines.JobSupport$Finishing r7 = (kotlinx.coroutines.JobSupport.Finishing) r7     // Catch:{ all -> 0x004f }
            java.lang.Throwable r7 = r7.getRootCause()     // Catch:{ all -> 0x004f }
            r1 = r3 ^ 1
            if (r1 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r7 = r0
        L_0x003e:
            monitor-exit(r2)
            if (r7 == 0) goto L_0x004a
            kotlinx.coroutines.JobSupport$Finishing r2 = (kotlinx.coroutines.JobSupport.Finishing) r2
            kotlinx.coroutines.NodeList r0 = r2.getList()
            r6.notifyCancelling(r0, r7)
        L_0x004a:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.COMPLETING_ALREADY
            return r7
        L_0x004f:
            r7 = move-exception
            monitor-exit(r2)
            throw r7
        L_0x0052:
            boolean r3 = r2 instanceof kotlinx.coroutines.Incomplete
            if (r3 == 0) goto L_0x009e
            if (r1 != 0) goto L_0x005c
            java.lang.Throwable r1 = r6.createCauseException(r7)
        L_0x005c:
            r3 = r2
            kotlinx.coroutines.Incomplete r3 = (kotlinx.coroutines.Incomplete) r3
            boolean r4 = r3.isActive()
            if (r4 == 0) goto L_0x0070
            boolean r2 = r6.tryMakeCancelling(r3, r1)
            if (r2 == 0) goto L_0x0002
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.COMPLETING_ALREADY
            return r7
        L_0x0070:
            kotlinx.coroutines.CompletedExceptionally r3 = new kotlinx.coroutines.CompletedExceptionally
            r4 = 0
            r5 = 2
            r3.<init>(r1, r4, r5, r0)
            java.lang.Object r3 = r6.tryMakeCompleting(r2, r3)
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.JobSupportKt.COMPLETING_ALREADY
            if (r3 == r4) goto L_0x0088
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.JobSupportKt.COMPLETING_RETRY
            if (r3 == r2) goto L_0x0002
            return r3
        L_0x0088:
            java.lang.String r7 = java.lang.String.valueOf(r2)
            java.lang.String r0 = "Cannot happen in "
            java.lang.String r7 = r0.concat(r7)
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x009e:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.TOO_LATE_TO_CANCEL
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.makeCancelling(java.lang.Object):java.lang.Object");
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object obj) {
        Object tryMakeCompleting;
        do {
            tryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj);
            if (tryMakeCompleting == JobSupportKt.COMPLETING_ALREADY) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, getExceptionOrNull(obj));
            }
        } while (tryMakeCompleting == JobSupportKt.COMPLETING_RETRY);
        return tryMakeCompleting;
    }
}
