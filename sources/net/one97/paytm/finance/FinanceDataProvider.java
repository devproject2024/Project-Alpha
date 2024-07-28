package net.one97.paytm.finance;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.sendbird.android.constant.StringSet;
import java.util.Iterator;
import net.one97.paytm.common.entity.RiskAnalysis.DeviceAccount;
import net.one97.paytm.h5.c;
import net.one97.paytm.upi.util.UpiContract;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.t;
import org.json.JSONArray;

public class FinanceDataProvider {
    public static final String ORIGIN = "paytm";

    public static void initFianceApp(Context context) {
        c cVar = c.f50543a;
        c.a("gold", new c.b(context) {
            private final /* synthetic */ Context f$0;

            {
                this.f$0 = r1;
            }

            public final void provideValuesForKeys(String str, c.C0910c cVar) {
                FinanceDataProvider.lambda$initFianceApp$0(this.f$0, str, cVar);
            }
        });
    }

    static /* synthetic */ void lambda$initFianceApp$0(Context context, String str, c.C0910c cVar) {
        if (cVar != null) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1940613496:
                    if (str.equals("networkType")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case -1459599807:
                    if (str.equals("lastName")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1357712437:
                    if (str.equals("client")) {
                        c2 = 23;
                        break;
                    }
                    break;
                case -1133543344:
                    if (str.equals("deviceLocale")) {
                        c2 = 10;
                        break;
                    }
                    break;
                case -1068855134:
                    if (str.equals("mobile")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1008619738:
                    if (str.equals("origin")) {
                        c2 = 21;
                        break;
                    }
                    break;
                case -836030906:
                    if (str.equals("userId")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -662089212:
                    if (str.equals("appVersionCode")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -661774686:
                    if (str.equals("appVersionName")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -586608551:
                    if (str.equals("Authorization")) {
                        c2 = 24;
                        break;
                    }
                    break;
                case 3373707:
                    if (str.equals("name")) {
                        c2 = 20;
                        break;
                    }
                    break;
                case 96619420:
                    if (str.equals(AppConstants.KEY_EMAIL)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 124644323:
                    if (str.equals("hasCreditCard")) {
                        c2 = 17;
                        break;
                    }
                    break;
                case 132835675:
                    if (str.equals("firstName")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 780851262:
                    if (str.equals("deviceImei")) {
                        c2 = 12;
                        break;
                    }
                    break;
                case 780988929:
                    if (str.equals("deviceName")) {
                        c2 = 9;
                        break;
                    }
                    break;
                case 802258218:
                    if (str.equals("ssoToken")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 899225419:
                    if (str.equals("h5Version")) {
                        c2 = 19;
                        break;
                    }
                    break;
                case 908408390:
                    if (str.equals("clientId")) {
                        c2 = 22;
                        break;
                    }
                    break;
                case 1109191185:
                    if (str.equals("deviceId")) {
                        c2 = 15;
                        break;
                    }
                    break;
                case 1170165752:
                    if (str.equals("isPlaystoreInstall")) {
                        c2 = 14;
                        break;
                    }
                    break;
                case 1812004436:
                    if (str.equals("osVersion")) {
                        c2 = 13;
                        break;
                    }
                    break;
                case 1843562588:
                    if (str.equals("deviceAccounts")) {
                        c2 = 18;
                        break;
                    }
                    break;
                case 1874684019:
                    if (str.equals("platform")) {
                        c2 = 16;
                        break;
                    }
                    break;
                case 1998308679:
                    if (str.equals("deviceManufacturer")) {
                        c2 = 8;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    cVar.onResult(t.b(context));
                    return;
                case 1:
                    cVar.onResult(b.h(context));
                    return;
                case 2:
                    cVar.onResult(b.i(context));
                    return;
                case 3:
                    cVar.onResult(a.c(context));
                    return;
                case 4:
                    cVar.onResult(a.b(context));
                    return;
                case 5:
                    cVar.onResult(a.a(context));
                    return;
                case 6:
                    cVar.onResult(720656);
                    return;
                case 7:
                    cVar.onResult(b.Q(context));
                    return;
                case 8:
                    cVar.onResult(Build.MANUFACTURER);
                    return;
                case 9:
                    cVar.onResult(Build.MODEL);
                    return;
                case 10:
                    cVar.onResult(b.g());
                    return;
                case 11:
                    cVar.onResult(a.l(context));
                    return;
                case 12:
                    cVar.onResult(getImei(context));
                    return;
                case 13:
                    cVar.onResult(Integer.valueOf(b.d()));
                    return;
                case 14:
                    cVar.onResult(Boolean.valueOf(isPlayStoreInstall(context)));
                    return;
                case 15:
                    cVar.onResult(Settings.Secure.getString(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID));
                    return;
                case 16:
                    cVar.onResult(StringSet.Android);
                    return;
                case 17:
                    cVar.onResult(Boolean.valueOf(hasCC(context)));
                    return;
                case 18:
                    cVar.onResult(getAllEmails(context).toString());
                    return;
                case 19:
                    cVar.onResult("2.1.40-MB-07");
                    return;
                case 20:
                    cVar.onResult(b.aa(context));
                    return;
                case 21:
                    cVar.onResult("paytm");
                    return;
                case 22:
                    cVar.onResult("market-app");
                    return;
                case 23:
                    cVar.onResult("androidapp");
                    return;
                case 24:
                    cVar.onResult(b.m());
                    return;
                default:
                    cVar.onResult("");
                    return;
            }
        }
    }

    private static JSONArray getAllEmails(Context context) {
        JSONArray jSONArray = new JSONArray();
        Iterator<DeviceAccount> it2 = l.d(context).iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().getValue());
        }
        return jSONArray;
    }

    private static boolean hasCC(Context context) {
        if (context != null) {
            return ag.a(context.getApplicationContext()).b("isCreditCard", false, true);
        }
        return false;
    }

    private static String getImei(Context context) {
        try {
            context.getSystemService(ContactColumn.PHONE_NUMBER);
            return a.f(context);
        } catch (Exception unused) {
            return "";
        }
    }

    private static boolean isPlayStoreInstall(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            String installerPackageName = packageManager.getInstallerPackageName(context.getPackageName());
            if (!TextUtils.isEmpty(installerPackageName)) {
                return "com.android.vending".equalsIgnoreCase(installerPackageName);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
