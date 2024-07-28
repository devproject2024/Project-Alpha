package net.one97.paytm.phoenix.provider;

import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.utility.b;
import com.paytm.utility.c;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.utils.aa;
import org.json.JSONObject;

public final class PaytmAppInfoProvider implements PhoenixAppInfoProvider {
    public final int getVersionCode(Context context) {
        k.c(context, "context");
        return CJRJarvisApplication.t();
    }

    public final String getVersionName(Context context) {
        k.c(context, "context");
        String Q = b.Q(context);
        k.a((Object) Q, "CJRAppCommonUtility.getAppVersionName(context)");
        return Q;
    }

    public final void startPhoenixActivityToWebPageStartTrace(String str) {
        aa aaVar = aa.f69597a;
        aa.a(str);
    }

    public final void startWebPageLoadStartToFinishTrace(String str) {
        aa aaVar = aa.f69597a;
        aa.b(str);
    }

    public final JSONObject getDefaultParams(Context context) {
        k.c(context, "context");
        Map<String, String> b2 = c.b(context, false);
        b2.put(AppConstants.TAG_CHILD_SITE_ID, b.i());
        b2.put(AppConstants.TAG_SITE_ID, b.h());
        b2.put("os", "android");
        b2.put(AppConstants.TAG_RESOLUTION, String.valueOf(b.U(context)));
        return new JSONObject(b2);
    }

    public final void stopPhoenixActivityToWebPageStartTrace(String str) {
        aa aaVar = aa.f69597a;
        aa.d();
    }

    public final void stopWebPageLoadStartToFinishTrace() {
        aa aaVar = aa.f69597a;
        aa.e();
    }
}
