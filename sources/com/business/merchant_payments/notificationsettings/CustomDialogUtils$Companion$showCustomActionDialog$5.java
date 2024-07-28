package com.business.merchant_payments.notificationsettings;

import android.app.Dialog;
import android.view.View;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import kotlin.g.a.a;
import kotlin.g.b.k;

public final class CustomDialogUtils$Companion$showCustomActionDialog$5 implements View.OnClickListener {
    public final /* synthetic */ Dialog $dialog;
    public final /* synthetic */ String $gaEventAction;
    public final /* synthetic */ String $gaEventCategory;
    public final /* synthetic */ boolean $isFireGaEvent;
    public final /* synthetic */ a $positiveAction;
    public final /* synthetic */ String $positiveText;

    public CustomDialogUtils$Companion$showCustomActionDialog$5(a aVar, Dialog dialog, boolean z, String str, String str2, String str3) {
        this.$positiveAction = aVar;
        this.$dialog = dialog;
        this.$isFireGaEvent = z;
        this.$gaEventCategory = str;
        this.$gaEventAction = str2;
        this.$positiveText = str3;
    }

    public final void onClick(View view) {
        this.$positiveAction.invoke();
        this.$dialog.dismiss();
        this.$dialog.cancel();
        if (this.$isFireGaEvent) {
            GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            singleInstance.sendEvent(instance.getAppContext(), this.$gaEventCategory, this.$gaEventAction, "", this.$positiveText);
        }
    }
}
