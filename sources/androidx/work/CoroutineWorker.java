package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.a.c;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

public abstract class CoroutineWorker extends ListenableWorker {

    /* renamed from: a  reason: collision with root package name */
    final CompletableJob f5035a = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);

    /* renamed from: b  reason: collision with root package name */
    final c<ListenableWorker.a> f5036b;

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineDispatcher f5037c;

    public abstract Object a(d<? super ListenableWorker.a> dVar);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        k.c(context, "appContext");
        k.c(workerParameters, "params");
        c<ListenableWorker.a> a2 = c.a();
        k.a((Object) a2, "SettableFuture.create()");
        this.f5036b = a2;
        androidx.work.impl.utils.b.a taskExecutor = getTaskExecutor();
        k.a((Object) taskExecutor, "taskExecutor");
        this.f5036b.a((Runnable) new Runnable(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CoroutineWorker f5038a;

            {
                this.f5038a = r1;
            }

            public final void run() {
                if (this.f5038a.f5036b.isCancelled()) {
                    Job.DefaultImpls.cancel$default(this.f5038a.f5035a, (CancellationException) null, 1, (Object) null);
                }
            }
        }, (Executor) taskExecutor.b());
        this.f5037c = Dispatchers.getDefault();
    }

    public final void onStopped() {
        super.onStopped();
        this.f5036b.cancel(false);
    }

    @f(b = "CoroutineWorker.kt", c = {68}, d = "invokeSuspend", e = "androidx.work.CoroutineWorker$startWork$1")
    static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ CoroutineWorker this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(CoroutineWorker coroutineWorker, d dVar) {
            super(2, dVar);
            this.this$0 = coroutineWorker;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            a aVar = new a(this.this$0, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = this.p$;
                CoroutineWorker coroutineWorker = this.this$0;
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = coroutineWorker.a(this);
                if (obj == aVar) {
                    return aVar;
                }
            } else if (i2 == 1) {
                try {
                    ResultKt.a(obj);
                } catch (Throwable th) {
                    this.this$0.f5036b.a(th);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.this$0.f5036b.a((ListenableWorker.a) obj);
            return x.f47997a;
        }
    }

    public final com.google.b.a.a.a<ListenableWorker.a> startWork() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.f5037c.plus(this.f5035a)), (kotlin.d.f) null, (CoroutineStart) null, new a(this, (d) null), 3, (Object) null);
        return this.f5036b;
    }
}
