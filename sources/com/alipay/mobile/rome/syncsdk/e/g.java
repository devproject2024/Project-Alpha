package com.alipay.mobile.rome.syncsdk.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.telephony.TelephonyManager;
import com.paytm.contactsSdk.database.ContactColumn;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Random;
import net.one97.paytm.upi.util.UpiConstants;

public final class g {

    /* renamed from: d  reason: collision with root package name */
    private static final String f15089d = g.class.getSimpleName();

    /* renamed from: g  reason: collision with root package name */
    private static g f15090g;

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f15091h = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", AppConstants.FEED_COMMUNITY, UpiConstants.DEFAULT_ACCOUNT_CONSTANT, "E", AppConstants.FEED_SUB_TYPE, "G", "H", AppConstants.IMAGE_SUBTYPE, "J", AppConstants.THOUSANDS, "L", "M", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, "O", AppConstants.FEED_COMMUNITY_POST, "Q", "R", "S", "T", AppConstants.USER_SUB_TYPE, "V", AppConstants.CAROUSEL_SUB_TYPE, "X", "Y", "Z"};

    /* renamed from: a  reason: collision with root package name */
    volatile String f15092a = "000000000000000";

    /* renamed from: b  reason: collision with root package name */
    volatile String f15093b = "000000000000000";

    /* renamed from: c  reason: collision with root package name */
    volatile String f15094c = "0000000000";

    /* renamed from: e  reason: collision with root package name */
    private volatile String f15095e;

    /* renamed from: f  reason: collision with root package name */
    private volatile int f15096f;

    private g() {
    }

    public static synchronized g a(Context context) {
        g gVar;
        String str;
        String str2;
        synchronized (g.class) {
            if (f15090g == null) {
                g gVar2 = new g();
                f15090g = gVar2;
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                    gVar2.f15095e = packageInfo.versionName;
                    gVar2.f15096f = packageInfo.versionCode;
                } catch (Exception e2) {
                    String str3 = f15089d;
                    h.d(str3, "init: [ Exception " + e2 + " ]");
                }
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER);
                    String deviceId = telephonyManager.getDeviceId();
                    if (deviceId != null) {
                        str = (deviceId + "000000000000000").substring(0, 15);
                    } else {
                        str = "000000000000000";
                    }
                    gVar2.f15092a = str;
                    String subscriberId = telephonyManager.getSubscriberId();
                    if (subscriberId != null) {
                        str2 = (subscriberId + "000000000000000").substring(0, 15);
                    } else {
                        str2 = "000000000000000";
                    }
                    gVar2.f15093b = str2;
                } catch (Exception e3) {
                    String str4 = f15089d;
                    h.d(str4, "init: [ Exception " + e3 + " ]");
                }
                gVar2.f15094c = a();
            }
            gVar = f15090g;
        }
        return gVar;
    }

    private static String a() {
        Random random = new Random(System.currentTimeMillis());
        int length = f15091h.length;
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 10; i2++) {
            sb.append(f15091h[random.nextInt(length)]);
        }
        return sb.toString();
    }
}
