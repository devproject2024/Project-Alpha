package com.business.merchant_payments.notificationsettings.activity;

import androidx.lifecycle.z;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.notificationsettings.model.MerchantProfileResponse;
import kotlin.g.b.k;

public final class EmailAndSmsNotificationActivity$initObservers$2<T> implements z<b<MerchantProfileResponse>> {
    public final /* synthetic */ EmailAndSmsNotificationActivity this$0;

    public EmailAndSmsNotificationActivity$initObservers$2(EmailAndSmsNotificationActivity emailAndSmsNotificationActivity) {
        this.this$0 = emailAndSmsNotificationActivity;
    }

    public final void onChanged(b<MerchantProfileResponse> bVar) {
        EmailAndSmsNotificationActivity emailAndSmsNotificationActivity = this.this$0;
        k.b(bVar, "value");
        emailAndSmsNotificationActivity.removeSecondaryDetailOnSuccess(bVar);
    }
}
