package com.travel.citybus.brts.c;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.c;
import com.travel.citybus.brts.utils.d;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f23202a = new a();

    private a() {
    }

    public static void a(String str, Context context, boolean z, b bVar) {
        k.c(str, "url");
        k.c(context, "context");
        k.c(bVar, "listener");
        d.a aVar = d.f23400a;
        if (!TextUtils.isEmpty(d.a.a(context).b("sso_token=", "", true))) {
            String b2 = c.b(str, context);
            k.a((Object) b2, "CJRDefaultRequestParam.g…lWithoutSSO(url, context)");
            String str2 = b2 + "&actions=1";
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append("&post_payment=1");
            }
            Map hashMap = new HashMap();
            String a2 = com.paytm.utility.d.a(context);
            k.a((Object) a2, "CJRNetUtility.getSSOToken(context)");
            hashMap.put(AppConstants.SSO_TOKEN, a2);
            com.travel.citybus.brts.b.a.a();
            com.travel.citybus.brts.b.a.a(context, str, hashMap, new CJROrderSummary(), bVar);
            return;
        }
        bVar.handleErrorCode(400, (IJRPaytmDataModel) null, (NetworkCustomError) null);
    }
}
