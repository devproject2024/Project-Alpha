package net.one97.paytm.moneytransfer.utils;

import android.app.Activity;
import android.text.TextUtils;
import net.one97.paytm.moneytransfer.R;

public final class p {
    public static void a() {
        Class[] clsArr = new Class[0];
        try {
            Class<?> cls = Class.forName("net.one97.paytm.deeplink.MoneyTransferDeepLinkHandler");
            cls.getDeclaredMethod("reInitialize", clsArr).invoke(cls.newInstance(), (Object[]) null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String a(Activity activity, String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            str2 = str.trim().replaceAll("[^\\d+]", "").replaceAll(" ", "");
        } else {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        int i2 = 0;
        String replaceAll = str2.trim().replaceAll("[^\\d+]", "");
        if (replaceAll.startsWith(activity.getString(R.string.mobile_number_prefix_91))) {
            i2 = 3;
        } else if (replaceAll.startsWith(activity.getString(R.string.mobile_number_prefix_91_without_plus))) {
            i2 = 2;
        } else if (replaceAll.startsWith(activity.getString(R.string.mobile_number_prefix_0))) {
            i2 = 1;
        }
        return replaceAll.substring(i2, replaceAll.length()).trim().replaceAll(" ", "");
    }
}
