package com.business.merchant_payments.newhome;

import android.content.Context;
import android.view.View;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.newhome.HomeRVAdapter;
import com.business.merchant_payments.settlement.model.AmountModel;
import com.business.merchant_payments.settlement.model.SettlementBillListItemModel;
import kotlin.g.b.k;

public final class HomeRVAdapter$BWSettlementElementViewHolder$setCommonData$1 implements View.OnClickListener {
    public final /* synthetic */ SettlementBillListItemModel $modelData;
    public final /* synthetic */ HomeRVAdapter.BWSettlementElementViewHolder this$0;

    public HomeRVAdapter$BWSettlementElementViewHolder$setCommonData$1(HomeRVAdapter.BWSettlementElementViewHolder bWSettlementElementViewHolder, SettlementBillListItemModel settlementBillListItemModel) {
        this.this$0 = bWSettlementElementViewHolder;
        this.$modelData = settlementBillListItemModel;
    }

    public final void onClick(View view) {
        String str;
        String str2;
        String settlementTime = this.$modelData.getSettlementTime();
        if (settlementTime == null) {
            settlementTime = "";
        }
        String str3 = DateUtility.getTimeDiffForSettlement("yyyy-MM-dd'T'HH:mm:ssZZZZZ", settlementTime).toString();
        String convertDateToDifferentFormat = DateUtility.convertDateToDifferentFormat(this.$modelData.getSettlementTime(), "yyyy-MM-dd'T'HH:mm:ssZZZZZ", "dd-MM-yyyy");
        GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
        Context access$getMContext$p = this.this$0.this$0.mContext;
        StringBuilder sb = new StringBuilder("BW;");
        sb.append(str3);
        sb.append(';');
        sb.append(convertDateToDifferentFormat);
        sb.append(';');
        AmountModel netAmount = this.$modelData.getNetAmount();
        if (netAmount == null || (str = netAmount.getValue()) == null) {
            str = "";
        }
        sb.append(str);
        sb.append(';');
        AmountModel pendingAmount = this.$modelData.getPendingAmount();
        if (pendingAmount == null || (str2 = pendingAmount.getValue()) == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(";NA");
        singleInstance.sendEvent(access$getMContext$p, "HomePage", "Settlement Tab >Pending Settlement > Contact Us Clicked", "", sb.toString());
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        instance.getDeepLinkUtils().a(this.this$0.this$0.mContext, "paytmba://home-app/support|business-app/h/my-account/help");
    }
}
