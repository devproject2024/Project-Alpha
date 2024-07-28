package kotlinx.coroutines.flow.internal;

import kotlin.d.a.a;
import kotlin.d.b.a.d;
import kotlin.d.f;
import kotlin.d.g;
import kotlin.g.a.q;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;

public final class SafeCollector<T> extends d implements FlowCollector<T> {
    public final f collectContext;
    public final int collectContextSize = ((Number) this.collectContext.fold(0, SafeCollector$collectContextSize$1.INSTANCE)).intValue();
    public final FlowCollector<T> collector;
    private kotlin.d.d<? super x> completion;
    private f lastEmissionContext;

    public SafeCollector(FlowCollector<? super T> flowCollector, f fVar) {
        super(NoOpContinuation.INSTANCE, g.INSTANCE);
        this.collector = flowCollector;
        this.collectContext = fVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.d.f getContext() {
        /*
            r1 = this;
            kotlin.d.d<? super kotlin.x> r0 = r1.completion
            if (r0 == 0) goto L_0x000a
            kotlin.d.f r0 = r0.getContext()
            if (r0 != 0) goto L_0x000e
        L_0x000a:
            kotlin.d.g r0 = kotlin.d.g.INSTANCE
            kotlin.d.f r0 = (kotlin.d.f) r0
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.SafeCollector.getContext():kotlin.d.f");
    }

    public final Object invokeSuspend(Object obj) {
        Throwable r0 = p.m533exceptionOrNullimpl(obj);
        if (r0 != null) {
            this.lastEmissionContext = new DownstreamExceptionElement(r0);
        }
        kotlin.d.d<? super x> dVar = this.completion;
        if (dVar != null) {
            dVar.resumeWith(obj);
        }
        return a.COROUTINE_SUSPENDED;
    }

    public final void releaseIntercepted() {
        super.releaseIntercepted();
    }

    public final Object emit(T t, kotlin.d.d<? super x> dVar) {
        try {
            Object emit = emit(dVar, t);
            if (emit == a.COROUTINE_SUSPENDED) {
                k.d(dVar, "frame");
            }
            return emit == a.COROUTINE_SUSPENDED ? emit : x.f47997a;
        } catch (Throwable th) {
            this.lastEmissionContext = new DownstreamExceptionElement(th);
            throw th;
        }
    }

    private final Object emit(kotlin.d.d<? super x> dVar, T t) {
        f context = dVar.getContext();
        JobKt.ensureActive(context);
        f fVar = this.lastEmissionContext;
        if (fVar != context) {
            checkContext(context, fVar, t);
        }
        this.completion = dVar;
        q access$getEmitFun$p = SafeCollectorKt.emitFun;
        FlowCollector<T> flowCollector = this.collector;
        if (flowCollector != null) {
            return access$getEmitFun$p.invoke(flowCollector, t, this);
        }
        throw new u("null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
    }

    private final void checkContext(f fVar, f fVar2, T t) {
        if (fVar2 instanceof DownstreamExceptionElement) {
            exceptionTransparencyViolated((DownstreamExceptionElement) fVar2, t);
        }
        SafeCollector_commonKt.checkContext(this, fVar);
        this.lastEmissionContext = fVar;
    }

    private final void exceptionTransparencyViolated(DownstreamExceptionElement downstreamExceptionElement, Object obj) {
        throw new IllegalStateException(kotlin.m.p.a("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + downstreamExceptionElement.f47998e + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }
}
