package com.business.merchant_payments.notificationsettings.activity;

public final class EmailAndSmsNotificationActivity$handleUpdatedSettings$$inlined$let$lambda$1 implements Runnable {
    public final /* synthetic */ EmailAndSmsNotificationActivity this$0;

    public EmailAndSmsNotificationActivity$handleUpdatedSettings$$inlined$let$lambda$1(EmailAndSmsNotificationActivity emailAndSmsNotificationActivity) {
        this.this$0 = emailAndSmsNotificationActivity;
    }

    public final void run() {
        this.this$0.getMViewModel().updateNotificationSettingsTryAgain();
    }
}
