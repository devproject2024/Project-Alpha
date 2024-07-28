package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.c;

public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    private int f8351a = 0;

    public static PendingIntent a(Context context, PendingIntent pendingIntent, int i2) {
        return PendingIntent.getActivity(context, 0, a(context, pendingIntent, i2, true), 134217728);
    }

    public static Intent a(Context context, PendingIntent pendingIntent, int i2, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i2);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f8351a = bundle.getInt(AppConstants.TAG_RESOLUTION);
        }
        if (this.f8351a != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get("error_code");
            if (pendingIntent == null && num == null) {
                finish();
            } else if (pendingIntent != null) {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, (Intent) null, 0, 0, 0);
                    this.f8351a = 1;
                } catch (IntentSender.SendIntentException unused) {
                    finish();
                }
            } else {
                c.a().a((Activity) this, num.intValue(), 2, (DialogInterface.OnCancelListener) this);
                this.f8351a = 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f8351a = 0;
            setResult(i3, intent);
            if (booleanExtra) {
                f a2 = f.a((Context) this);
                if (i3 == -1) {
                    a2.c();
                } else if (i3 == 0) {
                    a2.b(new ConnectionResult(13, (PendingIntent) null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i2 == 2) {
            this.f8351a = 0;
            setResult(i3, intent);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(AppConstants.TAG_RESOLUTION, this.f8351a);
        super.onSaveInstanceState(bundle);
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f8351a = 0;
        setResult(0);
        finish();
    }
}
