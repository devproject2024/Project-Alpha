package androidx.lifecycle;

import androidx.lifecycle.k;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

public final class LifecycleCoroutineScopeImpl extends m implements o {

    /* renamed from: a  reason: collision with root package name */
    final k f3583a;

    /* renamed from: b  reason: collision with root package name */
    private final f f3584b;

    public final f getCoroutineContext() {
        return this.f3584b;
    }

    public LifecycleCoroutineScopeImpl(k kVar, f fVar) {
        k.c(kVar, "lifecycle");
        k.c(fVar, "coroutineContext");
        this.f3583a = kVar;
        this.f3584b = fVar;
        if (this.f3583a.a() == k.b.DESTROYED) {
            JobKt__JobKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    @kotlin.d.b.a.f(b = "Lifecycle.kt", c = {}, d = "invokeSuspend", e = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1")
    static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ LifecycleCoroutineScopeImpl this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, d dVar) {
            super(2, dVar);
            this.this$0 = lifecycleCoroutineScopeImpl;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            a aVar = new a(this.this$0, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = this.p$;
                if (this.this$0.f3583a.a().compareTo(k.b.INITIALIZED) >= 0) {
                    this.this$0.f3583a.a(this.this$0);
                } else {
                    JobKt__JobKt.cancel$default(coroutineScope.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
                }
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void a(q qVar, k.a aVar) {
        kotlin.g.b.k.c(qVar, "source");
        kotlin.g.b.k.c(aVar, AppConstants.NOTIFICATION_DETAILS.EVENT);
        if (this.f3583a.a().compareTo(k.b.DESTROYED) <= 0) {
            this.f3583a.b(this);
            JobKt__JobKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }
}
