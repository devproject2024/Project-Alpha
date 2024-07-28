package com.business.merchant_payments.newhome;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.business.merchant_payments.newhome.HomeRVAdapter;
import kotlin.g.b.k;

public final class HomeRVAdapter$BWSettlementSummaryCardViewHolder$setDisabledSettleNowInfoText$1 extends ClickableSpan {
    public final /* synthetic */ HomeRVAdapter.BWSettlementSummaryCardViewHolder this$0;

    public HomeRVAdapter$BWSettlementSummaryCardViewHolder$setDisabledSettleNowInfoText$1(HomeRVAdapter.BWSettlementSummaryCardViewHolder bWSettlementSummaryCardViewHolder) {
        this.this$0 = bWSettlementSummaryCardViewHolder;
    }

    public final void onClick(View view) {
        k.d(view, "widget");
        this.this$0.this$0.mListener.onDisabledSettleNowInfoClicked();
    }

    public final void updateDrawState(TextPaint textPaint) {
        k.d(textPaint, "ds");
        textPaint.setUnderlineText(false);
    }
}
