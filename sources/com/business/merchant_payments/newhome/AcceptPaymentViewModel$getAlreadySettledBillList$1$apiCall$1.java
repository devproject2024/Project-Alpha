package com.business.merchant_payments.newhome;

import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.business.merchant_payments.settlement.model.SettlementBillListDetailModel;
import com.business.merchant_payments.settlement.repo.SettlementRepo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "AcceptPaymentViewModel.kt", c = {158}, d = "invokeSuspend", e = "com.business.merchant_payments.newhome.AcceptPaymentViewModel$getAlreadySettledBillList$1$apiCall$1")
public final class AcceptPaymentViewModel$getAlreadySettledBillList$1$apiCall$1 extends k implements m<CoroutineScope, d<? super b<SettlementBillListDetailModel>>, Object> {
    public final /* synthetic */ SimpleDateFormat $dateFormat;
    public final /* synthetic */ Calendar $endDateCalendar;
    public final /* synthetic */ String $queryType;
    public final /* synthetic */ Calendar $startDateCalendar;
    public final /* synthetic */ String $url;
    public Object L$0;
    public int label;
    public CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AcceptPaymentViewModel$getAlreadySettledBillList$1$apiCall$1(String str, SimpleDateFormat simpleDateFormat, Calendar calendar, Calendar calendar2, String str2, d dVar) {
        super(2, dVar);
        this.$url = str;
        this.$dateFormat = simpleDateFormat;
        this.$startDateCalendar = calendar;
        this.$endDateCalendar = calendar2;
        this.$queryType = str2;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        AcceptPaymentViewModel$getAlreadySettledBillList$1$apiCall$1 acceptPaymentViewModel$getAlreadySettledBillList$1$apiCall$1 = new AcceptPaymentViewModel$getAlreadySettledBillList$1$apiCall$1(this.$url, this.$dateFormat, this.$startDateCalendar, this.$endDateCalendar, this.$queryType, dVar);
        acceptPaymentViewModel$getAlreadySettledBillList$1$apiCall$1.p$ = (CoroutineScope) obj;
        return acceptPaymentViewModel$getAlreadySettledBillList$1$apiCall$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AcceptPaymentViewModel$getAlreadySettledBillList$1$apiCall$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            SettlementRepo settlementRepo = SettlementRepo.INSTANCE;
            String str = this.$url;
            P4BSettlementsDataHelperMP p4BSettlementsDataHelperMP = P4BSettlementsDataHelperMP.INSTANCE;
            SimpleDateFormat simpleDateFormat = this.$dateFormat;
            Calendar calendar = this.$startDateCalendar;
            kotlin.g.b.k.b(calendar, "startDateCalendar");
            String format = simpleDateFormat.format(calendar.getTime());
            kotlin.g.b.k.b(format, "dateFormat.format(startDateCalendar.time)");
            SimpleDateFormat simpleDateFormat2 = this.$dateFormat;
            Calendar calendar2 = this.$endDateCalendar;
            kotlin.g.b.k.b(calendar2, "endDateCalendar");
            String format2 = simpleDateFormat2.format(calendar2.getTime());
            kotlin.g.b.k.b(format2, "dateFormat.format(endDateCalendar.time)");
            HashMap<String, Object> settlementBillListItemDetailQueryMap = p4BSettlementsDataHelperMP.getSettlementBillListItemDetailQueryMap(format, format2, 1, 50, this.$queryType);
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = settlementRepo.getSettlementBillListItemDetail(str, settlementBillListItemDetailQueryMap, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i2 == 1) {
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
