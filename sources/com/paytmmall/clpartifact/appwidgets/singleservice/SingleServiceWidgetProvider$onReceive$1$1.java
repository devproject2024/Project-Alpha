package com.paytmmall.clpartifact.appwidgets.singleservice;

import android.content.Intent;
import com.paytmmall.clpartifact.utils.GaHandler;

final class SingleServiceWidgetProvider$onReceive$1$1 implements Runnable {
    final /* synthetic */ Intent $this_apply;

    SingleServiceWidgetProvider$onReceive$1$1(Intent intent) {
        this.$this_apply = intent;
    }

    public final void run() {
        GaHandler.getInstance().sendClickEventForWidgets(this.$this_apply.getAction(), "home_widget_1", "");
    }
}
