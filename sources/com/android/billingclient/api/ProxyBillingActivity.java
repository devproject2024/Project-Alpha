package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.a.a;

public class ProxyBillingActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private ResultReceiver f30906a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        super.onCreate(bundle);
        a.a("ProxyBillingActivity");
        this.f30906a = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
        } else {
            pendingIntent = getIntent().hasExtra("SUBS_MANAGEMENT_INTENT") ? (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT") : null;
        }
        try {
            startIntentSenderForResult(pendingIntent.getIntentSender(), 100, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e2) {
            "Got exception while trying to start a purchase flow: ".concat(String.valueOf(e2));
            a.b("ProxyBillingActivity");
            this.f30906a.send(6, (Bundle) null);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 100) {
            int a2 = a.a(intent, "ProxyBillingActivity");
            if (!(i3 == -1 && a2 == 0)) {
                StringBuilder sb = new StringBuilder("Activity finished with resultCode ");
                sb.append(i3);
                sb.append(" and billing's responseCode: ");
                sb.append(a2);
                a.b("ProxyBillingActivity");
            }
            this.f30906a.send(a2, intent == null ? null : intent.getExtras());
        } else {
            StringBuilder sb2 = new StringBuilder("Got onActivityResult with wrong requestCode: ");
            sb2.append(i2);
            sb2.append("; skipping...");
            a.b("ProxyBillingActivity");
        }
        finish();
    }
}
