package easypay.actions;

import android.content.Intent;
import android.os.Bundle;
import easypay.utils.AssistLogs;
import net.one97.paytm.i.h;

public class c extends h {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AssistLogs.printLog("Create NativeHeadLess fragment", this);
        setRetainInstance(true);
    }

    public static c a() {
        return new c();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 121 && i3 == -1) {
            AssistLogs.printLog("NO SMS permission, user consent received", this);
            if (intent != null) {
                AssistLogs.printLog("NO SMS permission, message data received", this);
                e.a().a(intent.getStringExtra("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE"), "", false);
            }
        }
    }

    public void startActivityForResult(Intent intent, int i2) {
        if (intent == null) {
            intent = new Intent();
        }
        super.startActivityForResult(intent, i2);
    }
}
