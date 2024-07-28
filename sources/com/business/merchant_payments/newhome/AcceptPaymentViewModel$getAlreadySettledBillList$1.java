package com.business.merchant_payments.newhome;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.settlement.model.SettlementBillListDetailModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

@f(b = "AcceptPaymentViewModel.kt", c = {168, 170}, d = "invokeSuspend", e = "com.business.merchant_payments.newhome.AcceptPaymentViewModel$getAlreadySettledBillList$1")
public final class AcceptPaymentViewModel$getAlreadySettledBillList$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    public final /* synthetic */ boolean $isPending;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public Object L$6;
    public Object L$7;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ AcceptPaymentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AcceptPaymentViewModel$getAlreadySettledBillList$1(AcceptPaymentViewModel acceptPaymentViewModel, boolean z, d dVar) {
        super(2, dVar);
        this.this$0 = acceptPaymentViewModel;
        this.$isPending = z;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        AcceptPaymentViewModel$getAlreadySettledBillList$1 acceptPaymentViewModel$getAlreadySettledBillList$1 = new AcceptPaymentViewModel$getAlreadySettledBillList$1(this.this$0, this.$isPending, dVar);
        acceptPaymentViewModel$getAlreadySettledBillList$1.p$ = (CoroutineScope) obj;
        return acceptPaymentViewModel$getAlreadySettledBillList$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AcceptPaymentViewModel$getAlreadySettledBillList$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        y yVar;
        Object obj3;
        y yVar2;
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US);
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            Calendar instance2 = Calendar.getInstance();
            String settlementBillListItmDetailUrl = GTMDataProviderImpl.Companion.getMInstance().getSettlementBillListItmDetailUrl();
            String str = this.$isPending ? "PENDING" : "SUCCESS";
            String str2 = str;
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (kotlin.d.f) null, (CoroutineStart) null, new AcceptPaymentViewModel$getAlreadySettledBillList$1$apiCall$1(settlementBillListItmDetailUrl, simpleDateFormat, instance, instance2, str, (d) null), 3, (Object) null);
            if (this.$isPending) {
                LiveData<b<SettlementBillListDetailModel>> mPendingSettleListModel = this.this$0.getMPendingSettleListModel();
                if (mPendingSettleListModel != null) {
                    y yVar3 = (y) mPendingSettleListModel;
                    this.L$0 = coroutineScope;
                    this.L$1 = simpleDateFormat;
                    this.L$2 = instance;
                    this.L$3 = instance2;
                    this.L$4 = settlementBillListItmDetailUrl;
                    this.L$5 = str2;
                    this.L$6 = async$default;
                    this.L$7 = yVar3;
                    this.label = 1;
                    obj3 = async$default.await(this);
                    if (obj3 == aVar) {
                        return aVar;
                    }
                    yVar2 = yVar3;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.business.common_module.utilities.viewModel.LiveDataWrapper<com.business.merchant_payments.settlement.model.SettlementBillListDetailModel?>>");
                }
            } else {
                LiveData<b<SettlementBillListDetailModel>> mAlreadySettledBillListModel = this.this$0.getMAlreadySettledBillListModel();
                if (mAlreadySettledBillListModel != null) {
                    y yVar4 = (y) mAlreadySettledBillListModel;
                    this.L$0 = coroutineScope;
                    this.L$1 = simpleDateFormat;
                    this.L$2 = instance;
                    this.L$3 = instance2;
                    this.L$4 = settlementBillListItmDetailUrl;
                    this.L$5 = str2;
                    this.L$6 = async$default;
                    this.L$7 = yVar4;
                    this.label = 2;
                    obj2 = async$default.await(this);
                    if (obj2 == aVar) {
                        return aVar;
                    }
                    yVar = yVar4;
                    yVar.setValue(obj2);
                    return x.f47997a;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.business.common_module.utilities.viewModel.LiveDataWrapper<com.business.merchant_payments.settlement.model.SettlementBillListDetailModel?>>");
            }
        } else if (i2 == 1) {
            yVar2 = (y) this.L$7;
            ResultKt.a(obj);
            obj3 = obj;
        } else if (i2 == 2) {
            yVar = (y) this.L$7;
            ResultKt.a(obj);
            obj2 = obj;
            yVar.setValue(obj2);
            return x.f47997a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        yVar2.setValue(obj3);
        return x.f47997a;
    }
}
