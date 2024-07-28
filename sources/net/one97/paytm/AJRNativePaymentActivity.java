package net.one97.paytm;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;

public final class AJRNativePaymentActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private final String f51381a = "mWebAppInvokeOrderId";

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(Build.VERSION.SDK_INT == 26 ? -1 : 1);
        Intent intent = new Intent(this, AJRPGAppLinkLauncherActivity.class);
        intent.putExtra("nativeSdkEnabled", true);
        intent.putExtra("enable_paytm_invoke", true);
        Intent intent2 = getIntent();
        k.a((Object) intent2, "intent");
        intent.putExtra("applink_intent_data", intent2.getDataString());
        Intent intent3 = getIntent();
        k.a((Object) intent3, "intent");
        intent.putExtra("applink_uri_data", intent3.getData());
        intent.addFlags(32768);
        intent.addFlags(268435456);
        startActivity(intent);
        finish();
    }
}
