package com.business.merchant_payments.newhome;

import android.view.View;
import com.business.merchant_payments.newhome.HomeRVAdapter;

public final class HomeRVAdapter$TitleTileViewHolder$bindData$1 implements View.OnClickListener {
    public final /* synthetic */ HomeRVAdapter.TitleTileViewHolder this$0;

    public HomeRVAdapter$TitleTileViewHolder$bindData$1(HomeRVAdapter.TitleTileViewHolder titleTileViewHolder) {
        this.this$0 = titleTileViewHolder;
    }

    public final void onClick(View view) {
        this.this$0.this$0.mListener.onSettlmentDateRangeClick();
    }
}
