package com.business.merchant_payments.notificationsettings.activity;

import androidx.lifecycle.z;
import com.business.merchant_payments.notificationsettings.adapter.NotificationReceiverListAdapter;
import com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class EmailAndSmsNotificationActivity$initObservers$1<T> implements z<ArrayList<NotificationReceiverModel>> {
    public final /* synthetic */ EmailAndSmsNotificationActivity this$0;

    public EmailAndSmsNotificationActivity$initObservers$1(EmailAndSmsNotificationActivity emailAndSmsNotificationActivity) {
        this.this$0 = emailAndSmsNotificationActivity;
    }

    public final void onChanged(ArrayList<NotificationReceiverModel> arrayList) {
        NotificationReceiverListAdapter access$getMNotificationAdapter$p = this.this$0.mNotificationAdapter;
        if (access$getMNotificationAdapter$p != null) {
            k.b(arrayList, "value");
            access$getMNotificationAdapter$p.addAllSecondaryReceivers(arrayList);
        }
    }
}
