package com.business.merchant_payments.settlement.view;

import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.business.common_module.a.a.b;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.newhome.SelectDateBottomSheet;
import kotlin.g.b.k;
import kotlin.m.p;

public final class OrderListDateRangeActivityMP$setCalendarUtils$2 implements b.a {
    public final /* synthetic */ OrderListDateRangeActivityMP this$0;

    public OrderListDateRangeActivityMP$setCalendarUtils$2(OrderListDateRangeActivityMP orderListDateRangeActivityMP) {
        this.this$0 = orderListDateRangeActivityMP;
    }

    public final void onCustomDateSelected(String str, String str2, String str3) {
        k.d(str, "startDate");
        k.d(str2, "endDate");
        k.d(str3, "identifier");
        if (p.a(str) || p.a(str2)) {
            OrderListDateRangeActivityMP orderListDateRangeActivityMP = this.this$0;
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            Toast.makeText(orderListDateRangeActivityMP, instance.getAppContext().getString(R.string.mp_label_inavlid_date_range_selected_error), 0).show();
            return;
        }
        Fragment c2 = this.this$0.getSupportFragmentManager().c(SelectDateBottomSheet.class.getSimpleName());
        if (c2 != null && c2.isVisible() && (c2 instanceof SelectDateBottomSheet)) {
            SelectDateBottomSheet selectDateBottomSheet = (SelectDateBottomSheet) c2;
            selectDateBottomSheet.setDates(str, str2);
            selectDateBottomSheet.setDownloadTextForCalendar();
        }
        this.this$0.mDownloadStartDate = str;
        this.this$0.mDownloadEndDate = str2;
    }

    public final void onCustomDateSelected(String str) {
        k.d(str, "identifier");
        this.this$0.fireGAEventOnDateSelect("Download Statement > Date Range Selected", str);
    }
}
