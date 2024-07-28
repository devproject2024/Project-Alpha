package com.business.merchant_payments.settlement.view;

import android.widget.Toast;
import com.business.common_module.a.a.b;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import kotlin.g.b.k;
import kotlin.m.p;

public final class OrderListDateRangeActivityMP$setCalendarUtils$1 implements b.a {
    public final /* synthetic */ OrderListDateRangeActivityMP this$0;

    public OrderListDateRangeActivityMP$setCalendarUtils$1(OrderListDateRangeActivityMP orderListDateRangeActivityMP) {
        this.this$0 = orderListDateRangeActivityMP;
    }

    public final void onCustomDateSelected(String str, String str2, String str3) {
        k.d(str, "startDate");
        k.d(str2, "endDate");
        k.d(str3, "identifier");
        this.this$0.fireGAEventOnDateSelect("Top Date > Date Range Selected", str3);
        if (p.a(str) || p.a(str2)) {
            OrderListDateRangeActivityMP orderListDateRangeActivityMP = this.this$0;
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            Toast.makeText(orderListDateRangeActivityMP, instance.getAppContext().getString(R.string.mp_label_inavlid_date_range_selected_error), 0).show();
            return;
        }
        this.this$0.setDateRange(str, str2);
        this.this$0.loadSettlementRangeSummary();
        this.this$0.loadRecyclerViewSettlementData();
    }

    public final void onCustomDateSelected(String str) {
        k.d(str, "identifier");
        this.this$0.fireGAEventOnDateSelect("Top Date > Date Range Selected", str);
    }
}
