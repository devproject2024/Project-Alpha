package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.utility.h;
import kotlin.g.b.k;
import net.one97.paytm.auth.b.b;

public final class PaytmH5ShowSessionPopUpDialogProvider implements PhoenixSessionTimeOutPopUpProvider {
    public final void showPopUp(Activity activity) {
        k.c(activity, "activity");
        b.b(activity);
        h hVar = new h(activity);
        hVar.setTitle("Session Time Out");
        hVar.a("You've been logged out of Paytm. Don't worry, just login again to continue");
        hVar.setCancelable(false);
        hVar.a(-3, Payload.RESPONSE_OK, new PaytmH5ShowSessionPopUpDialogProvider$showPopUp$1(hVar, activity));
        hVar.show();
    }
}
