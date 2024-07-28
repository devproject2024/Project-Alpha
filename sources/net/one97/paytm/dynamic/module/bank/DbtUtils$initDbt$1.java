package net.one97.paytm.dynamic.module.bank;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.sendbird.android.constant.StringSet;
import kotlin.g.b.k;
import net.one97.paytm.h5.c;
import net.one97.paytm.upi.util.UpiContract;
import net.one97.paytm.utils.t;

public final class DbtUtils$initDbt$1 implements c.b {
    final /* synthetic */ Context $context;

    DbtUtils$initDbt$1(Context context) {
        this.$context = context;
    }

    public final void provideValuesForKeys(String str, c.C0910c cVar) {
        k.c(str, "key");
        if (cVar != null) {
            switch (str.hashCode()) {
                case -1940613496:
                    if (str.equals("networkType")) {
                        cVar.onResult(a.l(this.$context));
                        return;
                    }
                    break;
                case -1459599807:
                    if (str.equals("lastName")) {
                        cVar.onResult(b.i(this.$context));
                        return;
                    }
                    break;
                case -1133543344:
                    if (str.equals("deviceLocale")) {
                        cVar.onResult(b.g());
                        return;
                    }
                    break;
                case -1068855134:
                    if (str.equals("mobile")) {
                        cVar.onResult(a.b(this.$context));
                        return;
                    }
                    break;
                case -836030906:
                    if (str.equals("userId")) {
                        cVar.onResult(a.a(this.$context));
                        return;
                    }
                    break;
                case -662089212:
                    if (str.equals("appVersionCode")) {
                        cVar.onResult(720656);
                        return;
                    }
                    break;
                case -661774686:
                    if (str.equals("appVersionName")) {
                        cVar.onResult(b.Q(this.$context));
                        return;
                    }
                    break;
                case 96619420:
                    if (str.equals(AppConstants.KEY_EMAIL)) {
                        cVar.onResult(a.c(this.$context));
                        return;
                    }
                    break;
                case 124644323:
                    if (str.equals("hasCreditCard")) {
                        cVar.onResult(Boolean.valueOf(DbtUtils.INSTANCE.hasCC(this.$context)));
                        return;
                    }
                    break;
                case 132835675:
                    if (str.equals("firstName")) {
                        cVar.onResult(b.h(this.$context));
                        return;
                    }
                    break;
                case 780851262:
                    if (str.equals("deviceImei")) {
                        cVar.onResult(DbtUtils.INSTANCE.getImei(this.$context));
                        return;
                    }
                    break;
                case 780988929:
                    if (str.equals("deviceName")) {
                        cVar.onResult(Build.MODEL);
                        return;
                    }
                    break;
                case 802258218:
                    if (str.equals("ssoToken")) {
                        cVar.onResult(t.b(this.$context));
                        return;
                    }
                    break;
                case 1109191185:
                    if (str.equals("deviceId")) {
                        cVar.onResult(Settings.Secure.getString(this.$context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID));
                        return;
                    }
                    break;
                case 1170165752:
                    if (str.equals("isPlaystoreInstall")) {
                        cVar.onResult(Boolean.valueOf(DbtUtils.INSTANCE.isPlayStoreInstall(this.$context)));
                        return;
                    }
                    break;
                case 1812004436:
                    if (str.equals("osVersion")) {
                        cVar.onResult(Integer.valueOf(b.d()));
                        return;
                    }
                    break;
                case 1843562588:
                    if (str.equals("deviceAccounts")) {
                        cVar.onResult(DbtUtils.INSTANCE.getAllEmails(this.$context).toString());
                        return;
                    }
                    break;
                case 1874684019:
                    if (str.equals("platform")) {
                        cVar.onResult(StringSet.Android);
                        return;
                    }
                    break;
                case 1998308679:
                    if (str.equals("deviceManufacturer")) {
                        cVar.onResult(Build.MANUFACTURER);
                        return;
                    }
                    break;
            }
            cVar.onResult("");
        }
    }
}
