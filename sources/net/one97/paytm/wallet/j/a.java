package net.one97.paytm.wallet.j;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import java.util.HashMap;
import java.util.Map;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponse;
import net.one97.paytm.p2mNewDesign.db.PaymentInstrumentDatabase;
import net.one97.paytm.postpayment.models.CJRObdResponse;
import net.one97.paytm.wallet.rateMerchant.RateMerchantHelper;
import net.one97.paytm.wallet.rateMerchant.entity.MerchantPPReviewData;

public final class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public y<Boolean> f70416a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<MerchantPPReviewData> f70417b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    private final PaymentInstrumentDatabase f70418c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(PaymentInstrumentDatabase paymentInstrumentDatabase, Application application) {
        super(application);
        k.c(paymentInstrumentDatabase, "database");
        k.c(application, "application");
        this.f70418c = paymentInstrumentDatabase;
    }

    public final void a(String str, String str2) {
        k.c(str, "payMode");
        k.c(str2, "uniqueIdentifier");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new b(this, str, str2, (d) null), 3, (Object) null);
    }

    public final void b(String str, String str2) {
        k.c(str, "userId");
        k.c(str2, "mId");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new c(this, str, str2, (d) null), 3, (Object) null);
    }

    public static LiveData<net.one97.paytm.network.f> a(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str, "orderId");
        k.c(str2, "mId");
        net.one97.paytm.p2mNewDesign.h.b bVar = net.one97.paytm.p2mNewDesign.h.b.f51296a;
        net.one97.paytm.network.b bVar2 = new net.one97.paytm.network.b(com.paytm.utility.b.e(context, net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "offline_pg_merchant_transaction_status_URL")), new CJRMerchantTransactionStatusResponse(), (Map<String, String>) null, (Map<String, String>) null, net.one97.paytm.p2mNewDesign.h.b.a(context, str, str2));
        bVar2.e();
        bVar2.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "p2mGenericAPITimeOut")));
        if (com.paytm.utility.b.c(context)) {
            return bVar2.a();
        }
        return net.one97.paytm.base.d.f49504d.a(context, bVar2);
    }

    public static LiveData<net.one97.paytm.network.f> a(Context context, String str) {
        k.c(context, "context");
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "obdCallMerchantUrl");
        Map hashMap = new HashMap();
        String a2 = net.one97.paytm.paymentslimit.b.c.a(context);
        k.a((Object) a2, "CJRServerUtility.getSSOToken(context)");
        hashMap.put("ssotoken", a2);
        net.one97.paytm.p2mNewDesign.h.b bVar = net.one97.paytm.p2mNewDesign.h.b.f51296a;
        net.one97.paytm.network.b bVar2 = new net.one97.paytm.network.b(stringFromGTM, new CJRObdResponse(), (Map<String, String>) null, hashMap, net.one97.paytm.p2mNewDesign.h.b.a(str));
        bVar2.e();
        bVar2.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "p2mGenericAPITimeOut")));
        net.one97.paytm.wallet.communicator.c a3 = net.one97.paytm.wallet.communicator.b.a();
        k.a((Object) a3, "WalletCommManager.getWalletCommunicator()");
        if (com.paytm.utility.b.c(a3.getContext())) {
            return bVar2.a();
        }
        return net.one97.paytm.base.d.f49504d.a(context, bVar2);
    }

    /* renamed from: net.one97.paytm.wallet.j.a$a  reason: collision with other inner class name */
    public static final class C1423a implements RateMerchantHelper.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f70419a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f70420b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f70421c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ q f70422d;

        C1423a(Context context, a aVar, String str, q qVar) {
            this.f70419a = context;
            this.f70420b = aVar;
            this.f70421c = str;
            this.f70422d = qVar;
        }

        public final void a(MerchantPPReviewData merchantPPReviewData) {
            net.one97.paytm.p2mNewDesign.h.a aVar = net.one97.paytm.p2mNewDesign.h.a.f51295a;
            if (net.one97.paytm.p2mNewDesign.h.a.a(this.f70419a)) {
                net.one97.paytm.p2mNewDesign.h.a aVar2 = net.one97.paytm.p2mNewDesign.h.a.f51295a;
                if (net.one97.paytm.p2mNewDesign.h.a.b(this.f70419a)) {
                    this.f70420b.f70416a.postValue(Boolean.TRUE);
                } else {
                    this.f70420b.f70417b.postValue(merchantPPReviewData);
                }
            } else {
                this.f70420b.f70417b.postValue(merchantPPReviewData);
            }
        }

        public final void a() {
            net.one97.paytm.p2mNewDesign.h.a aVar = net.one97.paytm.p2mNewDesign.h.a.f51295a;
            if (net.one97.paytm.p2mNewDesign.h.a.a(this.f70419a)) {
                this.f70420b.f70416a.postValue(Boolean.TRUE);
            }
        }
    }

    public final void a(String str, Context context, q qVar) {
        k.c(qVar, "lifecycleOwner");
        if (context != null) {
            CharSequence charSequence = str;
            if (!(charSequence == null || charSequence.length() == 0)) {
                new RateMerchantHelper(context, qVar, str, new C1423a(context, this, str, qVar));
                return;
            }
            net.one97.paytm.p2mNewDesign.h.a aVar = net.one97.paytm.p2mNewDesign.h.a.f51295a;
            if (net.one97.paytm.p2mNewDesign.h.a.a(context)) {
                this.f70416a.postValue(Boolean.TRUE);
            }
        }
    }

    @kotlin.d.b.a.f(b = "FJRP2MPostPaymentFragmentViewModel.kt", c = {38}, d = "invokeSuspend", e = "net/one97/paytm/wallet/viewmodel/FJRP2MPostPaymentFragmentViewModel$initLastUsedInstrument$1")
    static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ String $payMode;
        final /* synthetic */ String $uniqueIdentifier;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, String str, String str2, d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
            this.$payMode = str;
            this.$uniqueIdentifier = str2;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            b bVar = new b(this.this$0, this.$payMode, this.$uniqueIdentifier, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                this.this$0.f70418c.a().a(new net.one97.paytm.p2mNewDesign.db.b.a(this.$payMode, this.$uniqueIdentifier, System.currentTimeMillis()));
                return x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    @kotlin.d.b.a.f(b = "FJRP2MPostPaymentFragmentViewModel.kt", c = {44}, d = "invokeSuspend", e = "net/one97/paytm/wallet/viewmodel/FJRP2MPostPaymentFragmentViewModel$updatePaymentStatusInDB$1")
    static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ String $mId;
        final /* synthetic */ String $userId;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar, String str, String str2, d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
            this.$userId = str;
            this.$mId = str2;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            c cVar = new c(this.this$0, this.$userId, this.$mId, dVar);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                this.this$0.f70418c.c().b(this.$userId, this.$mId);
                return x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }
}
