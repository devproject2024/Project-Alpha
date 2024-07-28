package com.business.common_module;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.business.common_module.utilities.LogUtility;
import com.google.android.gms.common.api.Status;

public class OTPSmsRetriever extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    Activity f7276a;

    /* renamed from: b  reason: collision with root package name */
    Fragment f7277b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7278c = 15;

    public OTPSmsRetriever(Activity activity) {
        this.f7276a = activity;
    }

    public OTPSmsRetriever(Fragment fragment) {
        this.f7277b = fragment;
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equalsIgnoreCase(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).f8360g == 0) {
                Intent intent2 = (Intent) extras.getParcelable("com.google.android.gms.auth.api.phone.EXTRA_CONSENT_INTENT");
                try {
                    if (this.f7276a != null) {
                        this.f7276a.startActivityForResult(intent2, 15);
                    } else if (this.f7277b != null) {
                        this.f7277b.startActivityForResult(intent2, 15);
                    }
                } catch (ActivityNotFoundException e2) {
                    LogUtility.printStackTrace(e2);
                }
            }
        }
    }
}
