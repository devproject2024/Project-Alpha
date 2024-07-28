package com.paytmmall.clpartifact.view.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.paytm.utility.a;
import com.paytmmall.clpartifact.utils.CategoryImpressionAndApiHandler;

public final class SFHomeFragment$broadCastReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ SFHomeFragment this$0;

    SFHomeFragment$broadCastReceiver$1(SFHomeFragment sFHomeFragment) {
        this.this$0 = sFHomeFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        if (a.m(this.this$0.getContext())) {
            SFHomeFragment.access$getViewModel$p(this.this$0).refreshHome();
            CategoryImpressionAndApiHandler.INSTANCE.resetAll();
        }
        this.this$0.setActionImage();
    }
}
