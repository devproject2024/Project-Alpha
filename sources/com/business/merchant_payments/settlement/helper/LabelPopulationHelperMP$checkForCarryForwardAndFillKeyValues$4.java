package com.business.merchant_payments.settlement.helper;

import android.view.View;
import com.business.merchant_payments.newhome.HomeRVListener;

public final class LabelPopulationHelperMP$checkForCarryForwardAndFillKeyValues$4 implements View.OnClickListener {
    public final /* synthetic */ HomeRVListener $listener;

    public LabelPopulationHelperMP$checkForCarryForwardAndFillKeyValues$4(HomeRVListener homeRVListener) {
        this.$listener = homeRVListener;
    }

    public final void onClick(View view) {
        HomeRVListener homeRVListener = this.$listener;
        if (homeRVListener != null) {
            homeRVListener.onMDRChangesClick();
        }
    }
}
