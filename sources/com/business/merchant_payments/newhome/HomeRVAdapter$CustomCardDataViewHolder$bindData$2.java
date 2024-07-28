package com.business.merchant_payments.newhome;

import android.view.View;
import com.business.merchant_payments.newhome.HomeRVAdapter;

public final class HomeRVAdapter$CustomCardDataViewHolder$bindData$2 implements View.OnClickListener {
    public final /* synthetic */ int $position;
    public final /* synthetic */ HomeRVAdapter.CustomCardDataViewHolder this$0;

    public HomeRVAdapter$CustomCardDataViewHolder$bindData$2(HomeRVAdapter.CustomCardDataViewHolder customCardDataViewHolder, int i2) {
        this.this$0 = customCardDataViewHolder;
        this.$position = i2;
    }

    public final void onClick(View view) {
        this.this$0.this$0.mListener.onCustomCardClick(this.this$0.getMBinding().getModel(), this.$position);
    }
}
