package net.one97.paytm.wallet.newdesign.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.utility.b;
import net.one97.paytm.utils.be;

public class InstallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(Payload.REFERRER);
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.contains("qrid")) {
            be.a(context.getApplicationContext()).a("Install_Referrer", true, true);
            String[] split = stringExtra.split("-");
            if (split.length >= 2) {
                String str = split[1];
                if (str.length() == 24) {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("paytmmp://cash_wallet?featuretype=scanner" + "&qrid=" + str));
                    intent2.addFlags(268435456);
                    context.startActivity(intent2);
                } else if (b.b(str)) {
                    Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse("paytmmp://cash_wallet?featuretype=sendmoneymobile" + "&recipient=" + str));
                    intent3.addFlags(268435456);
                    context.startActivity(intent3);
                } else {
                    Intent intent4 = new Intent("android.intent.action.VIEW", Uri.parse("paytmmp://cash_wallet?featuretype=scanner" + "&qrid=" + str));
                    intent4.addFlags(268435456);
                    context.startActivity(intent4);
                }
            }
        }
    }
}
