package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.paytm.utility.h;
import net.one97.paytm.deeplink.h;

final class PaytmH5ShowSessionPopUpDialogProvider$showPopUp$1 implements View.OnClickListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ h $dialog;

    PaytmH5ShowSessionPopUpDialogProvider$showPopUp$1(h hVar, Activity activity) {
        this.$dialog = hVar;
        this.$activity = activity;
    }

    public final void onClick(View view) {
        this.$dialog.cancel();
        h.a aVar = net.one97.paytm.deeplink.h.f50349a;
        h.a.a(this.$activity, "paytmmp://login?screen=signOutLogin", (Bundle) null);
    }
}
