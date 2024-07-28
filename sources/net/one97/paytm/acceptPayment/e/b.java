package net.one97.paytm.acceptPayment.e;

import android.content.Context;
import com.business.common_module.b.c;
import com.business.merchant_payments.deeplinkUtil.DeepLinkHelper;
import kotlin.g.b.k;
import net.one97.paytm.acceptPayment.configs.a;

public final class b implements c {
    public final void a(Context context) {
        k.d(context, "context");
    }

    public final void a(Context context, String str) {
        String cADeepkink;
        k.d(context, "context");
        k.d(str, "linkUrl");
        String featureFromDeeplink = DeepLinkHelper.INSTANCE.getFeatureFromDeeplink(str);
        if (!(featureFromDeeplink == null || (cADeepkink = DeepLinkHelper.INSTANCE.getCADeepkink(featureFromDeeplink, str)) == null)) {
            str = cADeepkink;
        }
        k.d(context, "context");
        k.d(str, "linkUrl");
        a.a().b().a(context, str);
    }
}
