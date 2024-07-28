package net.one97.paytm.acceptPayment.utils;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.acceptPayment.model.MerchantInfoRaw;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f52163a = new d();

    private d() {
    }

    public static a a(b bVar, String str) {
        k.d(bVar, "listener");
        k.d(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.b(net.one97.paytm.acceptPayment.b.b.a(), "GTMHelper.getInstance()");
        String d2 = net.one97.paytm.acceptPayment.b.b.d();
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("x-auth-ump", "app-3320-jmd-678-9b3");
        net.one97.paytm.acceptPayment.b.a b2 = net.one97.paytm.acceptPayment.configs.a.a().b();
        k.b(b2, "AcceptPaymentsConfig.get…tAcceptPaymentsListener()");
        String a2 = com.paytm.utility.d.a(b2.a());
        k.b(a2, "CJRNetUtility.getSSOToke…ner().applicationContext)");
        hashMap2.put("x-user-token", a2);
        return a.a(a.C0715a.GET, d2, new MerchantInfoRaw(), bVar, hashMap2, a.b.SILENT, hashMap);
    }

    public static HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("x-auth-ump", "app-3320-jmd-678-9b3");
        net.one97.paytm.acceptPayment.b.a b2 = net.one97.paytm.acceptPayment.configs.a.a().b();
        k.b(b2, "AcceptPaymentsConfig.get…tAcceptPaymentsListener()");
        hashMap.put("x-user-token", com.paytm.utility.d.a(b2.a()));
        hashMap.put("Content-Type", "application/json");
        net.one97.paytm.acceptPayment.b.a b3 = net.one97.paytm.acceptPayment.configs.a.a().b();
        k.b(b3, "AcceptPaymentsConfig.get…tAcceptPaymentsListener()");
        String X = com.paytm.utility.b.X(b3.a());
        if (X == null) {
            X = "";
        }
        hashMap.put("x-user-mid", X);
        net.one97.paytm.acceptPayment.b.a b4 = net.one97.paytm.acceptPayment.configs.a.a().b();
        k.b(b4, "AcceptPaymentsConfig.get…tAcceptPaymentsListener()");
        hashMap.put("accept-language", com.paytm.utility.b.a(b4.a()));
        return hashMap;
    }

    public static HashMap<String, String> a() {
        net.one97.paytm.acceptPayment.b.a b2 = net.one97.paytm.acceptPayment.configs.a.a().b();
        k.b(b2, "AcceptPaymentsConfig.get…tAcceptPaymentsListener()");
        Context a2 = b2.a();
        HashMap<String, String> n = com.paytm.utility.b.n();
        String n2 = com.paytm.utility.b.n(a2);
        String a3 = com.paytm.utility.d.a(a2);
        if (!TextUtils.isEmpty(n2) && com.paytm.utility.b.r(a2)) {
            k.b(n, "headers");
            n.put("user_id", n2);
        }
        if (!TextUtils.isEmpty(a3)) {
            k.b(n, "headers");
            n.put(AppConstants.SSO_TOKEN, a3);
        }
        k.b(n, "headers");
        return n;
    }
}
