package net.one97.paytm.p2mNewDesign.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.io.IOException;
import net.one97.paytm.p2mNewDesign.entity.ShowCodePushModel;
import net.one97.paytm.wallet.utility.d;

public class SilentPushReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        ShowCodePushModel showCodePushModel;
        if (context != null && intent != null && intent.getAction() != null && "com.android.wallet.SILENT_PUSH_TOTP".equals(intent.getAction()) && (showCodePushModel = (ShowCodePushModel) intent.getSerializableExtra("TOTP_DATA")) != null) {
            try {
                d dVar = d.f72319a;
                d.a(context, showCodePushModel);
            } catch (IOException unused) {
            }
        }
    }
}
