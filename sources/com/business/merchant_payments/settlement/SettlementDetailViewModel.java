package com.business.merchant_payments.settlement;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.aj;
import com.business.common_module.utilities.a.c;
import com.business.merchant_payments.settlement.model.BWSettlementM2BTransactionDetailObservableModel;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

public final class SettlementDetailViewModel extends c {
    public final LiveData<BWSettlementM2BTransactionDetailObservableModel> mSelectedSettledBillListDetail;

    public final void initDefaultParams() {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SettlementDetailViewModel() {
        /*
            r2 = this;
            com.business.merchant_payments.PaymentsConfig r0 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r1 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r0, r1)
            android.app.Application r0 = r0.getApplication()
            r2.<init>(r0)
            androidx.lifecycle.y r0 = new androidx.lifecycle.y
            r0.<init>()
            r2.mSelectedSettledBillListDetail = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.settlement.SettlementDetailViewModel.<init>():void");
    }

    public final LiveData<BWSettlementM2BTransactionDetailObservableModel> getMSelectedSettledBillListDetail() {
        return this.mSelectedSettledBillListDetail;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SettlementDetailViewModel(Application application) {
        this();
        k.d(application, "application");
    }

    public final void getSettlementBillListDetail(String str, String str2, String str3) {
        k.d(str, "startDate");
        k.d(str2, "endDate");
        k.d(str3, "settlementQueryType");
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (f) null, (CoroutineStart) null, new SettlementDetailViewModel$getSettlementBillListDetail$1(this, str, str2, str3, (d) null), 3, (Object) null);
    }
}
