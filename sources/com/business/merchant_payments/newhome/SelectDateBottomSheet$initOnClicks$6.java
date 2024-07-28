package com.business.merchant_payments.newhome;

import android.view.View;
import com.business.merchant_payments.common.utility.DateRange;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.utility.MPConstants;
import java.util.Date;
import kotlin.g.b.k;

public final class SelectDateBottomSheet$initOnClicks$6 implements View.OnClickListener {
    public final /* synthetic */ SelectDateBottomSheet this$0;

    public SelectDateBottomSheet$initOnClicks$6(SelectDateBottomSheet selectDateBottomSheet) {
        this.this$0 = selectDateBottomSheet;
    }

    public final void onClick(View view) {
        DateRange currentMonthDateRange = DateUtility.getCurrentMonthDateRange();
        this.this$0.currSelection = MPConstants.PaymentSummaryRange.MONTH;
        SelectDateBottomSheet selectDateBottomSheet = this.this$0;
        Date date = currentMonthDateRange.startDate;
        k.b(date, "dateRange.startDate");
        Date date2 = currentMonthDateRange.endDate;
        k.b(date2, "dateRange.endDate");
        selectDateBottomSheet.handleOnClick(date, date2);
    }
}
