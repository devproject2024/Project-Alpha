package com.business.merchant_payments.notificationsettings.activity;

import android.widget.Toast;
import androidx.lifecycle.z;
import com.business.merchant_payments.R;
import com.business.merchant_payments.notificationsettings.adapter.NotificationReceiverListAdapter;

public final class EmailAndSmsNotificationActivity$initObservers$4<T> implements z<Integer> {
    public final /* synthetic */ EmailAndSmsNotificationActivity this$0;

    public EmailAndSmsNotificationActivity$initObservers$4(EmailAndSmsNotificationActivity emailAndSmsNotificationActivity) {
        this.this$0 = emailAndSmsNotificationActivity;
    }

    public final void onChanged(Integer num) {
        if (num != null && num.intValue() == 1) {
            this.this$0.launchP4BLockScreen();
        } else if (num != null && num.intValue() == 2) {
            NotificationReceiverListAdapter access$getMNotificationAdapter$p = this.this$0.mNotificationAdapter;
            if (access$getMNotificationAdapter$p != null) {
                access$getMNotificationAdapter$p.itemRemovedFromPosition(this.this$0.getMViewModel().getRemovedPosition());
            }
            this.this$0.getMViewModel().resetReceiverInfo();
        } else if (num != null && num.intValue() == 3) {
            this.this$0.showTransactionDeactivateDialog();
        } else if (num != null && num.intValue() == 4) {
            this.this$0.showRefundDeactivateDialog();
        } else if (num != null && num.intValue() == 5) {
            EmailAndSmsNotificationActivity emailAndSmsNotificationActivity = this.this$0;
            emailAndSmsNotificationActivity.showSnackBar(emailAndSmsNotificationActivity.getMBinding().getRoot(), this.this$0.getString(R.string.no_internet), (String) null, 0, new Runnable(this) {
                public final /* synthetic */ EmailAndSmsNotificationActivity$initObservers$4 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    this.this$0.this$0.getMViewModel().updateNotificationSettingsTryAgain();
                }
            });
        } else if (num != null && num.intValue() == 6) {
            EmailAndSmsNotificationActivity emailAndSmsNotificationActivity2 = this.this$0;
            emailAndSmsNotificationActivity2.showSnackBar(emailAndSmsNotificationActivity2.getMBinding().getRoot(), this.this$0.getString(R.string.no_internet), this.this$0.getString(R.string.retry), 0, new Runnable(this) {
                public final /* synthetic */ EmailAndSmsNotificationActivity$initObservers$4 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    this.this$0.this$0.getMViewModel().removeSecondaryReceiver();
                }
            });
        } else if (num != null && num.intValue() == 7) {
            this.this$0.onBackPressed();
        } else if (num != null && num.intValue() == 8) {
            EmailAndSmsNotificationActivity emailAndSmsNotificationActivity3 = this.this$0;
            Toast.makeText(emailAndSmsNotificationActivity3, emailAndSmsNotificationActivity3.getResources().getString(R.string.mp_access_denied_error), 1).show();
        } else if (num != null && num.intValue() == 9) {
            this.this$0.onBackPressed();
        }
    }
}
