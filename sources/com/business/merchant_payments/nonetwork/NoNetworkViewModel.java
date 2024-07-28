package com.business.merchant_payments.nonetwork;

import android.view.View;
import androidx.databinding.a;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.event.NoNetworkEvent;
import org.greenrobot.eventbus.c;

public class NoNetworkViewModel extends a {
    public String mClickedFrom;

    public NoNetworkViewModel(String str) {
        this.mClickedFrom = str;
    }

    public void onRetryClick(View view) {
        c.a().c(new NoNetworkEvent(AppConstants.NETWORK_RETRY_CLICK, this.mClickedFrom));
    }

    public void setClickedFrom(String str) {
        this.mClickedFrom = str;
    }
}
