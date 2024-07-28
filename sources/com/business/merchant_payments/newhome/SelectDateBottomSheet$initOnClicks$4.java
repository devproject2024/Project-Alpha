package com.business.merchant_payments.newhome;

import android.view.View;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.DateRange;
import com.business.merchant_payments.common.utility.DateUtility;
import java.util.Date;
import kotlin.g.b.k;

public final class SelectDateBottomSheet$initOnClicks$4 implements View.OnClickListener {
    public final /* synthetic */ SelectDateBottomSheet this$0;

    public SelectDateBottomSheet$initOnClicks$4(SelectDateBottomSheet selectDateBottomSheet) {
        this.this$0 = selectDateBottomSheet;
    }

    public final void onClick(View view) {
        DateRange yesterDayRange = DateUtility.getYesterDayRange();
        this.this$0.currSelection = AppConstants.YESTERDAY;
        SelectDateBottomSheet selectDateBottomSheet = this.this$0;
        Date date = yesterDayRange.startDate;
        k.b(date, "dateRange.startDate");
        Date date2 = yesterDayRange.endDate;
        k.b(date2, "dateRange.endDate");
        selectDateBottomSheet.handleOnClick(date, date2);
    }
}
