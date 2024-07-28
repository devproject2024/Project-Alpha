package net.one97.paytm.prime.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.c;
import java.util.HashMap;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.prime.e.b;

public final class a {
    public static com.paytm.network.a a(Activity activity, String str, final b bVar) {
        String str2 = net.one97.paytm.prime.b.a.a().a() + str;
        String str3 = c.b(str2, (Context) activity) + "&actions=1";
        HashMap hashMap = new HashMap();
        String a2 = net.one97.paytm.prime.b.a.a().a((Context) activity);
        if (!TextUtils.isEmpty(a2)) {
            hashMap.put(AppConstants.SSO_TOKEN, a2);
        }
        return net.one97.paytm.prime.b.a.a(activity, str3, new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                bVar.a(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                bVar.a();
            }
        }, hashMap, a.C0715a.GET, new CJROrderSummary(), a.c.PAYTM_FIRST, a.b.SILENT);
    }
}
