package net.one97.paytm.h5.b;

import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.utility.b;
import com.paytm.utility.c;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.h5paytmsdk.c.i;
import org.json.JSONObject;

public final class l implements i {
    public final int a(Context context) {
        k.c(context, "context");
        new StringBuilder("getVersionCode:").append(CJRJarvisApplication.t());
        return CJRJarvisApplication.t();
    }

    public final String b(Context context) {
        k.c(context, "context");
        new StringBuilder("getVersionName:").append(b.Q(context));
        String Q = b.Q(context);
        k.a((Object) Q, "CJRAppCommonUtility.getAppVersionName(context)");
        return Q;
    }

    public final JSONObject c(Context context) {
        k.c(context, "context");
        Map<String, String> b2 = c.b(context, false);
        b2.put(AppConstants.TAG_CHILD_SITE_ID, b.i());
        b2.put(AppConstants.TAG_SITE_ID, b.h());
        b2.put("os", "android");
        b2.put(AppConstants.TAG_RESOLUTION, String.valueOf(b.U(context)));
        JSONObject jSONObject = new JSONObject(b2);
        new StringBuilder("getDefaultParams").append(jSONObject);
        return jSONObject;
    }
}
