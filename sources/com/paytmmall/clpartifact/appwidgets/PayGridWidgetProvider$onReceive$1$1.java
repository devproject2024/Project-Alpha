package com.paytmmall.clpartifact.appwidgets;

import android.content.Intent;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GaHandler;

final class PayGridWidgetProvider$onReceive$1$1 implements Runnable {
    final /* synthetic */ Intent $this_apply;

    PayGridWidgetProvider$onReceive$1$1(Intent intent) {
        this.$this_apply = intent;
    }

    public final void run() {
        GaHandler.getInstance().sendClickEventForWidgets(this.$this_apply.getAction(), "home_widget_4xn", this.$this_apply.getStringExtra(CLPConstants.ARGUMENT_KEY_POSITION));
    }
}
