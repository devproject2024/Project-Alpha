package com.business.merchant_payments.newhome;

import android.view.View;
import com.business.merchant_payments.payment.model.GridItem;
import com.business.merchant_payments.payment.model.QRGridModel;

public final class P4BSmartGridViewHolder$bindData$7 implements View.OnClickListener {
    public final /* synthetic */ GridItem $item3;
    public final /* synthetic */ Object $model;

    public P4BSmartGridViewHolder$bindData$7(Object obj, GridItem gridItem) {
        this.$model = obj;
        this.$item3 = gridItem;
    }

    public final void onClick(View view) {
        ((QRGridModel) this.$model).openDeeplink(this.$item3);
    }
}
