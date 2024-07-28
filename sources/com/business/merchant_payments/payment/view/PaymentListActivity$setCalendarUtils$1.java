package com.business.merchant_payments.payment.view;

import android.widget.Toast;
import com.business.common_module.a.a.b;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import kotlin.g.b.k;
import kotlin.m.p;

public final class PaymentListActivity$setCalendarUtils$1 implements b.a {
    public final /* synthetic */ PaymentListActivity this$0;

    public PaymentListActivity$setCalendarUtils$1(PaymentListActivity paymentListActivity) {
        this.this$0 = paymentListActivity;
    }

    public final void onCustomDateSelected(String str, String str2, String str3) {
        k.d(str, "startDate");
        k.d(str2, "endDate");
        k.d(str3, "identifier");
        this.this$0.fireGAEventOnDateSelect("Top Date > Date Range Selected", str3);
        if (p.a(str) || p.a(str2)) {
            PaymentListActivity paymentListActivity = this.this$0;
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            Toast.makeText(paymentListActivity, instance.getAppContext().getString(R.string.mp_label_inavlid_date_range_selected_error), 0).show();
        } else if ((!k.a((Object) str, (Object) this.this$0.getMStartDate())) || (!k.a((Object) str2, (Object) this.this$0.getMEndDate()))) {
            this.this$0.resetCurrentRange(str, str2);
        }
    }

    public final void onCustomDateSelected(String str) {
        k.d(str, "identifier");
        this.this$0.fireGAEventOnDateSelect("Top Date > Date Range Selected", str);
    }
}
