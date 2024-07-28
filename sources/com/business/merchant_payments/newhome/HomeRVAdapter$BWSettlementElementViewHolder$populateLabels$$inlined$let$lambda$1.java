package com.business.merchant_payments.newhome;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.newhome.HomeRVAdapter;
import com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.business.merchant_payments.settlement.model.AmountModel;
import com.business.merchant_payments.settlement.model.SettlementBillListItemModel;

public final class HomeRVAdapter$BWSettlementElementViewHolder$populateLabels$$inlined$let$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ SettlementBillListItemModel $modelData$inlined;
    public final /* synthetic */ int $settlementType$inlined;
    public final /* synthetic */ HomeRVAdapter.BWSettlementElementViewHolder this$0;

    public HomeRVAdapter$BWSettlementElementViewHolder$populateLabels$$inlined$let$lambda$1(HomeRVAdapter.BWSettlementElementViewHolder bWSettlementElementViewHolder, SettlementBillListItemModel settlementBillListItemModel, int i2) {
        this.this$0 = bWSettlementElementViewHolder;
        this.$modelData$inlined = settlementBillListItemModel;
        this.$settlementType$inlined = i2;
    }

    public final void onClick(View view) {
        GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
        Context access$getMContext$p = this.this$0.this$0.mContext;
        String settleMode = this.$modelData$inlined.getSettleMode();
        String settlementTime = this.$modelData$inlined.getSettlementTime();
        if (settlementTime == null) {
            settlementTime = "";
        }
        singleInstance.sendEvent(access$getMContext$p, "HomePage", "Previous Settlement Summary -> View All Clicked", "", settleMode, "", DateUtility.getTimeDiffForSettlement("yyyy-MM-dd'T'HH:mm:ssZZZZZ", settlementTime).toString());
        GAGTMTagAnalytics.getSingleInstance().pushScreenEvent("Settlement View All Page");
        HomeRVAdapter.BWSettlementElementViewHolder bWSettlementElementViewHolder = this.this$0;
        LabelPopulationHelperMP labelPopulationHelperMP = LabelPopulationHelperMP.INSTANCE;
        AmountModel netAmount = this.$modelData$inlined.getNetAmount();
        Intent access$getIntentForSettlementDetail = bWSettlementElementViewHolder.getIntentForSettlementDetail(labelPopulationHelperMP.parseAndGetAmountString(netAmount != null ? netAmount.getValue() : null, true), P4BSettlementsDataHelperMP.M2B_QUERY_ALL, this.$modelData$inlined, this.$settlementType$inlined);
        Context access$getMContext$p2 = this.this$0.this$0.mContext;
        if (access$getMContext$p2 != null) {
            access$getMContext$p2.startActivity(access$getIntentForSettlementDetail);
        }
    }
}
