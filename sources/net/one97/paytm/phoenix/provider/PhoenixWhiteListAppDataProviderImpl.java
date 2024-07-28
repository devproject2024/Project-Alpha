package net.one97.paytm.phoenix.provider;

import android.content.Context;
import com.alipay.mobile.h5container.api.H5Event;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.dynamic.module.h5sdk.PaytmH5GtmDataLoader;
import net.one97.paytm.h5.b.c;
import net.one97.paytm.phoenix.b.b;
import net.one97.paytm.verifier.a.c;

public final class PhoenixWhiteListAppDataProviderImpl implements PaytmPhoenixWhitelistAppDataProvider {
    public final void doesAppExist(String str, Context context, b bVar) {
        k.c(str, "appUniqueId");
        k.c(context, "context");
        k.c(bVar, H5Event.TYPE_CALL_BACK);
        if (c.a()) {
            bVar.a(Boolean.TRUE);
        } else {
            net.one97.paytm.h5.b.c.a(context, str, (c.a) new PhoenixWhiteListAppDataProviderImpl$doesAppExist$1(bVar));
        }
    }

    public final boolean isAppWhitelisted(String str) {
        k.c(str, "appUniqueId");
        return isAppWhitelisted(str, "whitelisted_aids_auth");
    }

    public final boolean isAppWhitelisted(String str, String str2) {
        k.c(str, "appUniqueId");
        k.c(str2, "whitelisedAIDKey");
        List<String> whitelistAid = PaytmH5GtmDataLoader.getInstance().getWhitelistAid(str2);
        if (whitelistAid != null) {
            return whitelistAid.contains(str);
        }
        return false;
    }

    public final boolean isDomainWhitelisted(String str) {
        k.c(str, "url");
        return PaytmH5GtmDataLoader.getInstance().isDomainWhitelisted(str);
    }
}
