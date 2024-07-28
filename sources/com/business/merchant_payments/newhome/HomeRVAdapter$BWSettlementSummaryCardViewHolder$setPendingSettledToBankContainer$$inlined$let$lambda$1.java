package com.business.merchant_payments.newhome;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.newhome.HomeRVAdapter;
import com.business.merchant_payments.settlement.model.LabelModel;
import com.business.merchant_payments.settlement.model.M2BOrderListItemModel;
import java.util.ArrayList;

public final class HomeRVAdapter$BWSettlementSummaryCardViewHolder$setPendingSettledToBankContainer$$inlined$let$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ LabelModel $label$inlined;
    public final /* synthetic */ ArrayList $settlementList$inlined;
    public final /* synthetic */ HomeRVAdapter.BWSettlementSummaryCardViewHolder this$0;

    public HomeRVAdapter$BWSettlementSummaryCardViewHolder$setPendingSettledToBankContainer$$inlined$let$lambda$1(HomeRVAdapter.BWSettlementSummaryCardViewHolder bWSettlementSummaryCardViewHolder, LabelModel labelModel, ArrayList arrayList) {
        this.this$0 = bWSettlementSummaryCardViewHolder;
        this.$label$inlined = labelModel;
        this.$settlementList$inlined = arrayList;
    }

    public final void onClick(View view) {
        GAGTMTagAnalytics.getSingleInstance().sendEvent(this.this$0.this$0.mContext, "HomePage", "Settlement Summary -> View All Clicked", "", this.this$0.this$0.mViewModel.getMMerchantSettlemntTypeGA());
        GAGTMTagAnalytics.getSingleInstance().pushScreenEvent("Settlement View All Page");
        HomeRVAdapter.BWSettlementSummaryCardViewHolder bWSettlementSummaryCardViewHolder = this.this$0;
        LabelModel labelModel = this.$label$inlined;
        ArrayList arrayList = this.$settlementList$inlined;
        Intent access$getIntentForSettlementDetail = bWSettlementSummaryCardViewHolder.getIntentForSettlementDetail(labelModel, "PENDING", (arrayList != null ? (M2BOrderListItemModel) arrayList.get(0) : null).getOrderCreatedTime(), 1);
        Context access$getMContext$p = this.this$0.this$0.mContext;
        if (access$getMContext$p != null) {
            access$getMContext$p.startActivity(access$getIntentForSettlementDetail);
        }
    }
}
