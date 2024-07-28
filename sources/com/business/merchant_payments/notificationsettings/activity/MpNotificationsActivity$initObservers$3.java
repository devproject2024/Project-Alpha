package com.business.merchant_payments.notificationsettings.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.lifecycle.z;
import com.business.merchant_payments.R;
import com.business.merchant_payments.biometrics.PaymentsP4BLockActivity;
import com.business.merchant_payments.common.utility.AppConstants;

public final class MpNotificationsActivity$initObservers$3<T> implements z<Integer> {
    public final /* synthetic */ MpNotificationsActivity this$0;

    public MpNotificationsActivity$initObservers$3(MpNotificationsActivity mpNotificationsActivity) {
        this.this$0 = mpNotificationsActivity;
    }

    public final void onChanged(Integer num) {
        if (num != null && num.intValue() == 2) {
            Bundle bundle = new Bundle();
            bundle.putInt(AppConstants.NOTIFICATION_TYPE, 2);
            bundle.putSerializable(AppConstants.NOTIFICATION_SETIINGS, MpNotificationsActivity.access$getMViewModel$p(this.this$0).q);
            MpNotificationsActivity mpNotificationsActivity = this.this$0;
            Intent intent = new Intent(mpNotificationsActivity, EmailAndSmsNotificationActivity.class);
            intent.putExtra(AppConstants.NOTIFICATION_LIST, bundle);
            mpNotificationsActivity.startActivityForResult(intent, this.this$0.SMS_SETTINGS_REQUEST_CODE);
        } else if (num != null && num.intValue() == 1) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt(AppConstants.NOTIFICATION_TYPE, 1);
            bundle2.putSerializable(AppConstants.NOTIFICATION_SETIINGS, MpNotificationsActivity.access$getMViewModel$p(this.this$0).p);
            MpNotificationsActivity mpNotificationsActivity2 = this.this$0;
            Intent intent2 = new Intent(mpNotificationsActivity2, EmailAndSmsNotificationActivity.class);
            intent2.putExtra(AppConstants.NOTIFICATION_LIST, bundle2);
            mpNotificationsActivity2.startActivityForResult(intent2, this.this$0.EMAIL_SETTINGS_REQUEST_CODE);
        } else if (num != null && num.intValue() == 4) {
            this.this$0.finish();
        } else if (num != null && num.intValue() == 5) {
            MpNotificationsActivity mpNotificationsActivity3 = this.this$0;
            mpNotificationsActivity3.startActivityForResult(new Intent(mpNotificationsActivity3, PaymentsP4BLockActivity.class), this.this$0.ADD_EMAIL_REQUEST_CODE);
        } else if (num != null && num.intValue() == 7) {
            this.this$0.showEmailDeactivationDialog();
        } else if (num != null && num.intValue() == 8) {
            this.this$0.showSmsDeactivationDialog();
        } else if (num != null && num.intValue() == 10) {
            MpNotificationsActivity mpNotificationsActivity4 = this.this$0;
            mpNotificationsActivity4.showSnackBar(MpNotificationsActivity.access$getMBinding$p(mpNotificationsActivity4).getRoot(), this.this$0.getString(R.string.no_internet), (String) null, 0, new Runnable(this) {
                public final /* synthetic */ MpNotificationsActivity$initObservers$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    MpNotificationsActivity.access$getMViewModel$p(this.this$0.this$0).g();
                }
            });
        } else if (num != null && num.intValue() == 11) {
            MpNotificationsActivity mpNotificationsActivity5 = this.this$0;
            Toast.makeText(mpNotificationsActivity5, mpNotificationsActivity5.getResources().getString(R.string.mp_access_denied_error), 1).show();
        }
    }
}
