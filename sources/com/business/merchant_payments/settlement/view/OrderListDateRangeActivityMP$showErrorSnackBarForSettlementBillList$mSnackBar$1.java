package com.business.merchant_payments.settlement.view;

import android.view.View;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.newhome.AcceptPaymentViewModel;
import kotlin.g.b.k;

public final class OrderListDateRangeActivityMP$showErrorSnackBarForSettlementBillList$mSnackBar$1 implements View.OnClickListener {
    public final /* synthetic */ OrderListDateRangeActivityMP this$0;

    public OrderListDateRangeActivityMP$showErrorSnackBarForSettlementBillList$mSnackBar$1(OrderListDateRangeActivityMP orderListDateRangeActivityMP) {
        this.this$0 = orderListDateRangeActivityMP;
    }

    public final void onClick(View view) {
        this.this$0.mIsPaginating = true;
        this.this$0.mIsListLoading = true;
        AcceptPaymentViewModel access$getMViewModel$p = OrderListDateRangeActivityMP.access$getMViewModel$p(this.this$0);
        int access$getMCurrentPage$p = this.this$0.mCurrentPage;
        String startDateOfDifferentFormat = DateUtility.getStartDateOfDifferentFormat(OrderListDateRangeActivityMP.access$getMStartDate$p(this.this$0), this.this$0.mDateFormatUsed, this.this$0.mApiDateFormat);
        k.b(startDateOfDifferentFormat, "DateUtility.getStartDate…rmatUsed, mApiDateFormat)");
        String endDateOfDifferentFormat = DateUtility.getEndDateOfDifferentFormat(OrderListDateRangeActivityMP.access$getMEndDate$p(this.this$0), this.this$0.mDateFormatUsed, this.this$0.mApiDateFormat);
        k.b(endDateOfDifferentFormat, "DateUtility.getEndDateOf…rmatUsed, mApiDateFormat)");
        access$getMViewModel$p.getSettlementBillList(access$getMCurrentPage$p, startDateOfDifferentFormat, endDateOfDifferentFormat, 50);
    }
}
