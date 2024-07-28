package net.one97.paytm.p2b.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.p2b.data.a.a;
import net.one97.paytm.p2b.view.Activity.SendMoneyToBankActivity;
import org.json.JSONObject;

public final class i {
    public static void a(Context context, Map<String, Object> map, boolean z) {
        if (!z) {
            try {
                h.b().a("wallet_error_displayed", (Map<String, ? extends Object>) map, context.getApplicationContext());
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        h.b().a(context, str2, str3, str4, SendMoneyToBankActivity.f12799a, (String) null, str, (String) null);
    }

    public static void a(Context context, b bVar, String str) {
        try {
            String e2 = h.b().e();
            if (e2 == null) {
                return;
            }
            if (URLUtil.isValidUrl(e2)) {
                String e3 = com.paytm.utility.b.e(context, e2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("request", new JSONObject().put("isDetailInfo", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", h.b().a(context));
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("Content-Type", "application/json");
                com.paytm.network.b bVar2 = new com.paytm.network.b();
                bVar2.f42877a = context;
                bVar2.f42878b = a.c.P2B;
                bVar2.f42879c = a.C0715a.POST;
                bVar2.n = a.b.SILENT;
                bVar2.o = "SendMoneyToBankHelper";
                bVar2.f42884h = jSONObject.toString();
                bVar2.f42882f = hashMap;
                bVar2.f42880d = e3;
                bVar2.f42885i = new CJRCashWallet();
                bVar2.j = bVar;
                bVar2.x = 0;
                a l = bVar2.l();
                l.a((Object) str);
                l.a();
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, String str, String str2, b bVar) {
        String str3 = h.b().a("orderdetail") + str;
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.P2B;
        bVar2.f42879c = a.C0715a.GET;
        bVar2.n = a.b.SILENT;
        bVar2.o = "P2BHelperBase";
        bVar2.f42880d = com.paytm.utility.b.b(context, str3) + "&actions=1";
        bVar2.f42885i = new CJROrderSummary();
        bVar2.j = bVar;
        bVar2.x = 0;
        a l = bVar2.l();
        l.a((Object) str2);
        l.a();
    }

    public static void a(Activity activity, final a.C0169a aVar) {
        if (!TextUtils.isEmpty(com.paytm.utility.a.q(activity))) {
            h.b().a(activity, (b) new b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    aVar.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    aVar.a((NetworkCustomError) null);
                }
            });
        }
    }
}
