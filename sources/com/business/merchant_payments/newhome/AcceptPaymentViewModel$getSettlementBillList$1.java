package com.business.merchant_payments.newhome;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.settlement.model.SettlementBillListModel;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.x;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

@f(b = "AcceptPaymentViewModel.kt", c = {135}, d = "invokeSuspend", e = "com.business.merchant_payments.newhome.AcceptPaymentViewModel$getSettlementBillList$1")
public final class AcceptPaymentViewModel$getSettlementBillList$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    public final /* synthetic */ String $endDate;
    public final /* synthetic */ int $page;
    public final /* synthetic */ int $pageSize;
    public final /* synthetic */ String $startDate;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ AcceptPaymentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AcceptPaymentViewModel$getSettlementBillList$1(AcceptPaymentViewModel acceptPaymentViewModel, String str, String str2, int i2, int i3, d dVar) {
        super(2, dVar);
        this.this$0 = acceptPaymentViewModel;
        this.$startDate = str;
        this.$endDate = str2;
        this.$page = i2;
        this.$pageSize = i3;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        AcceptPaymentViewModel$getSettlementBillList$1 acceptPaymentViewModel$getSettlementBillList$1 = new AcceptPaymentViewModel$getSettlementBillList$1(this.this$0, this.$startDate, this.$endDate, this.$page, this.$pageSize, dVar);
        acceptPaymentViewModel$getSettlementBillList$1.p$ = (CoroutineScope) obj;
        return acceptPaymentViewModel$getSettlementBillList$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AcceptPaymentViewModel$getSettlementBillList$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        y yVar;
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            x.e eVar = new x.e();
            T settlementBillListApiUrl = GTMDataProviderImpl.Companion.getMInstance().getSettlementBillListApiUrl();
            eVar.element = settlementBillListApiUrl;
            T uri = Uri.parse((String) settlementBillListApiUrl).buildUpon().appendQueryParameter("merchantStatusRequired", "true").build().toString();
            kotlin.g.b.k.b(uri, "Uri.parse(url)\n         …      .build().toString()");
            eVar.element = uri;
            if (!this.this$0.isBillListAPIOngoing()) {
                Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (kotlin.d.f) null, (CoroutineStart) null, new AcceptPaymentViewModel$getSettlementBillList$1$apiCall$1(this, eVar, (d) null), 3, (Object) null);
                LiveData<b<SettlementBillListModel>> mSettlementBillListModel = this.this$0.getMSettlementBillListModel();
                if (mSettlementBillListModel != null) {
                    y yVar2 = (y) mSettlementBillListModel;
                    this.L$0 = coroutineScope;
                    this.L$1 = eVar;
                    this.L$2 = async$default;
                    this.L$3 = yVar2;
                    this.label = 1;
                    obj = async$default.await(this);
                    if (obj == aVar) {
                        return aVar;
                    }
                    yVar = yVar2;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.business.common_module.utilities.viewModel.LiveDataWrapper<com.business.merchant_payments.settlement.model.SettlementBillListModel?>>");
                }
            }
            return kotlin.x.f47997a;
        } else if (i2 == 1) {
            yVar = (y) this.L$3;
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        yVar.setValue(obj);
        this.this$0.setBillListAPIOngoing(false);
        return kotlin.x.f47997a;
    }
}
