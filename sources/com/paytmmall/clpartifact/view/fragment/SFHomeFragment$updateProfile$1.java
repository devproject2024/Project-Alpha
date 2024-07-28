package com.paytmmall.clpartifact.view.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class SFHomeFragment$updateProfile$1 extends BroadcastReceiver {
    final /* synthetic */ SFHomeFragment this$0;

    SFHomeFragment$updateProfile$1(SFHomeFragment sFHomeFragment) {
        this.this$0 = sFHomeFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        this.this$0.setActionImage();
    }
}
