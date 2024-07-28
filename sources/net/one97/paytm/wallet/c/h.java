package net.one97.paytm.wallet.c;

import android.app.Application;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.p2mNewDesign.db.PaymentInstrumentDatabase;

public final class h extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    private final PaymentInstrumentDatabase f70043a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(PaymentInstrumentDatabase paymentInstrumentDatabase, Application application) {
        super(application);
        k.c(paymentInstrumentDatabase, "database");
        k.c(application, "application");
        this.f70043a = paymentInstrumentDatabase;
    }

    public final void a(String str, String str2) {
        k.c(str, "payMode");
        k.c(str2, "uniqueIdentifier");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new a(this, str, str2, (d) null), 3, (Object) null);
    }

    public final void b(String str, String str2) {
        k.c(str, "userId");
        k.c(str2, "mId");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new b(this, str, str2, (d) null), 3, (Object) null);
    }

    @kotlin.d.b.a.f(b = "FJRPostPaymentFragmentViewModel.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.wallet.fragment.FJRPostPaymentFragmentViewModel$initLastUsedInstrument$1")
    static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ String $payMode;
        final /* synthetic */ String $uniqueIdentifier;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(h hVar, String str, String str2, d dVar) {
            super(2, dVar);
            this.this$0 = hVar;
            this.$payMode = str;
            this.$uniqueIdentifier = str2;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            a aVar = new a(this.this$0, this.$payMode, this.$uniqueIdentifier, dVar);
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
                this.this$0.f70043a.a().a(new net.one97.paytm.p2mNewDesign.db.b.a(this.$payMode, this.$uniqueIdentifier, System.currentTimeMillis()));
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.d.b.a.f(b = "FJRPostPaymentFragmentViewModel.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.wallet.fragment.FJRPostPaymentFragmentViewModel$updatePaymentStatusInDB$1")
    static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ String $mId;
        final /* synthetic */ String $userId;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(h hVar, String str, String str2, d dVar) {
            super(2, dVar);
            this.this$0 = hVar;
            this.$userId = str;
            this.$mId = str2;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            b bVar = new b(this.this$0, this.$userId, this.$mId, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                this.this$0.f70043a.c().b(this.$userId, this.$mId);
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
