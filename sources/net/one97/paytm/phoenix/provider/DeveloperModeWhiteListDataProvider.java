package net.one97.paytm.phoenix.provider;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.network.a;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.b.d;
import net.one97.paytm.dynamic.module.h5sdk.PaytmH5GtmDataLoader;
import net.one97.paytm.h5.model.H5AppDetailsForUserModel;
import net.one97.paytm.j.c;

public final class DeveloperModeWhiteListDataProvider implements PhoenixDeveloperModeWhitelisDataProvider {
    public final boolean isAppIdWhitelistedForDeveloperMode(String str) {
        k.c(str, "appUniqueId");
        List<String> whitelistAid = PaytmH5GtmDataLoader.getInstance().getWhitelistAid("whitelisted_aids_developer_app");
        if (whitelistAid != null) {
            return whitelistAid.contains(str);
        }
        return false;
    }

    public final void isUserWhitelistedForDeveloperMode(Context context, String str, UserWhitelistedForDeveloperModeCallback userWhitelistedForDeveloperModeCallback) {
        k.c(context, "context");
        k.c(str, "appUniqueId");
        k.c(userWhitelistedForDeveloperModeCallback, H5Event.TYPE_CALL_BACK);
        a dataFromMiniAppBackend = getDataFromMiniAppBackend(context, str, userWhitelistedForDeveloperModeCallback);
        if (dataFromMiniAppBackend == null) {
            userWhitelistedForDeveloperModeCallback.onError();
        } else if (!b.c(context)) {
            new Handler(Looper.getMainLooper()).post(new DeveloperModeWhiteListDataProvider$isUserWhitelistedForDeveloperMode$$inlined$let$lambda$1(dataFromMiniAppBackend, context));
        } else {
            dataFromMiniAppBackend.a();
        }
    }

    private final a getDataFromMiniAppBackend(Context context, String str, UserWhitelistedForDeveloperModeCallback userWhitelistedForDeveloperModeCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        b.a((HashMap<String, String>) hashMap, context);
        Map<String, String> f2 = c.a().f("developer_miniapps_endpoint");
        String str2 = f2 != null ? f2.get("app_details") : null;
        CharSequence charSequence = str2;
        if (charSequence == null || charSequence.length() == 0) {
            userWhitelistedForDeveloperModeCallback.onError();
            return null;
        }
        net.one97.paytm.h5.b.c cVar = net.one97.paytm.h5.b.c.f16920a;
        a a2 = d.a(context, net.one97.paytm.h5.b.c.a(context, str2 + "?app_id=" + str), new DeveloperModeWhiteListDataProvider$getDataFromMiniAppBackend$request$1(userWhitelistedForDeveloperModeCallback), hashMap, (Map<String, String>) null, a.C0715a.GET, (String) null, new H5AppDetailsForUserModel(), a.c.HOME, a.b.SILENT);
        a2.b(false);
        return a2;
    }
}
