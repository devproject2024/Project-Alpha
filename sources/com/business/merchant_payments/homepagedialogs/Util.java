package com.business.merchant_payments.homepagedialogs;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class Util {
    public static void startPaytmBusinessApp(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.paytm.business");
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(268435456);
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            context.startActivity(launchIntentForPackage);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        try {
            intent.setData(Uri.parse("market://details?id=".concat("com.paytm.business")));
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            intent.setData(Uri.parse("http://play.google.com/store/apps/details?id=".concat("com.paytm.business")));
            context.startActivity(intent);
        }
    }
}
