package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.utility.h;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.dynamic.module.h5sdk.PaytmH5GtmDataLoader;

public final class PhoenixAppPermissionProviderImpl implements PhoenixAppPermissionProvider {
    public final boolean doesAppHasPermissionToAccessThisBridge(String str, String str2) {
        k.c(str, "appId");
        k.c(str2, "bridgeName");
        return true;
    }

    public final boolean doesAppHasPermissionToOpenThisDomain(String str, Activity activity) {
        k.c(activity, "activity");
        List<String> whitelistAid = PaytmH5GtmDataLoader.getInstance().getWhitelistAid("miniapp_global_domain_blacklist");
        if (whitelistAid == null) {
            return true;
        }
        int size = whitelistAid.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str != null) {
                String str2 = whitelistAid.get(i2);
                k.a((Object) str2, "blackListedDomainList.get(i)");
                if (p.a((CharSequence) str, (CharSequence) str2, false)) {
                    showPopUp(activity);
                    return false;
                }
            }
        }
        return true;
    }

    public final void showPopUp(Activity activity) {
        k.c(activity, "activity");
        h hVar = new h(activity);
        hVar.setTitle("Alert");
        hVar.a("The URL you are trying to access is not allowed");
        hVar.setCancelable(false);
        hVar.a(-3, Payload.RESPONSE_OK, new PhoenixAppPermissionProviderImpl$showPopUp$1(hVar));
        hVar.show();
    }
}
