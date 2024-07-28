package net.one97.paytm.landingpage.utils.bankutil;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.utility.c;
import com.paytm.utility.f;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.b.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ag;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f52901a = new a();

    private a() {
    }

    public static com.paytm.network.a a(Context context, b bVar, a.c cVar, a.b bVar2, String str) {
        k.c(context, "context");
        k.c(bVar, "listener");
        k.c(cVar, "verticalId");
        k.c(bVar2, "userFacing");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        Map<String, String> hashMap = new HashMap<>();
        String q = com.paytm.utility.a.q(context);
        k.a((Object) q, "ApplaunchUtility.getSSOToken(context)");
        hashMap.put("Authorization", q);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("client", "ANDROID");
        hashMap.put("User-Agent", UpiConstants.B2C_ANDROID);
        String a2 = d.b().a("passcodeExistsURL");
        if (!URLUtil.isValidUrl(a2)) {
            return null;
        }
        com.paytm.network.b bVar3 = new com.paytm.network.b();
        bVar3.f42880d = a2 + c.a(context, false);
        bVar3.f42882f = hashMap;
        bVar3.f42879c = a.C0715a.GET;
        bVar3.f42878b = cVar;
        bVar3.f42877a = context;
        bVar3.n = bVar2;
        bVar3.j = bVar;
        bVar3.f42885i = new ValidatePasscode();
        bVar3.l = true;
        bVar3.o = str;
        return bVar3.l();
    }

    public static void a(Context context) {
        k.c(context, "context");
        ag.a aVar = ag.f69605a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        ag.a.a(applicationContext).a("is_passcode_set", true, true);
    }

    public static void a(Context context, int i2) {
        k.c(context, "appContext");
        ag.a aVar = ag.f69605a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "appContext.applicationContext");
        com.paytm.b.a.a a2 = ag.a.a(applicationContext);
        if (i2 == net.one97.paytm.utils.a.NOT_APPLIED.getNumVal()) {
            a2.a("acc_status", 1, true);
        } else if (i2 == net.one97.paytm.utils.a.PROCESSING.getNumVal()) {
            a2.a("acc_status", 2, true);
        } else if (i2 == net.one97.paytm.utils.a.ISSUED.getNumVal()) {
            a2.a("acc_status", 3, true);
        }
    }

    public static void a(Context context, String str) {
        k.c(context, "context");
        k.c(str, "bankType");
        ag.a aVar = ag.f69605a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        ag.a.a(applicationContext).a("ppb_bank_type", str, true);
    }

    public static void b(Context context) {
        k.c(context, "context");
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.getApplicationContext()");
        k.c(applicationContext, "context");
        ag.a aVar = ag.f69605a;
        Context applicationContext2 = applicationContext.getApplicationContext();
        k.a((Object) applicationContext2, "context.applicationContext");
        ag.a.a(applicationContext2, f.a.PPB_ICA).a("acc_status", 3, true);
    }

    public static String a(String str, boolean... zArr) {
        k.c(str, "mainUrl");
        k.c(zArr, "isICA");
        net.one97.paytm.common.b.a b2 = d.b();
        k.a((Object) b2, "HomeHelper.getAppLaunchModuleInterface()");
        b2.a();
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            if (p.a(charSequence, (CharSequence) "product.paytmbank.com", false)) {
                str = p.a(str, "product.paytmbank.com", "veneer.paytmbank.com", false);
            } else {
                str = p.a(str, "product-ite.paytmbank.com", "veneer-ite.paytmbank.com", false);
            }
        }
        if (!zArr[0]) {
            return str;
        }
        CharSequence charSequence2 = str;
        if (TextUtils.isEmpty(charSequence2)) {
            return str;
        }
        if (p.a(charSequence2, (CharSequence) "?", false)) {
            return str + "&accType=ICA";
        }
        return str + "?accType=ICA";
    }
}
