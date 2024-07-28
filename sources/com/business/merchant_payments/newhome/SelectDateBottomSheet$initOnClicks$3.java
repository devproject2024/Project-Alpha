package com.business.merchant_payments.newhome;

import android.view.View;
import java.util.Date;

public final class SelectDateBottomSheet$initOnClicks$3 implements View.OnClickListener {
    public final /* synthetic */ SelectDateBottomSheet this$0;

    public SelectDateBottomSheet$initOnClicks$3(SelectDateBottomSheet selectDateBottomSheet) {
        this.this$0 = selectDateBottomSheet;
    }

    public final void onClick(View view) {
        this.this$0.currSelection = "today";
        this.this$0.handleOnClick(new Date(), new Date());
    }
}
