package com.business.merchant_payments.notificationsettings.activity;

import kotlin.g.a.a;
import kotlin.g.b.l;
import kotlin.x;

public final class EmailAndSmsNotificationActivity$showTransactionDeactivateDialog$1 extends l implements a<x> {
    public final /* synthetic */ EmailAndSmsNotificationActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmailAndSmsNotificationActivity$showTransactionDeactivateDialog$1(EmailAndSmsNotificationActivity emailAndSmsNotificationActivity) {
        super(0);
        this.this$0 = emailAndSmsNotificationActivity;
    }

    public final void invoke() {
        this.this$0.getMViewModel().updateNotificationSettingsOnServer("transaction", false);
    }
}
