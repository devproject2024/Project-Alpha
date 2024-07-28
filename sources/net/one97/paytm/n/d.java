package net.one97.paytm.n;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.business.merchant_payments.common.utility.PaymentsGTMConstants;
import com.paytm.network.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.base.d;
import net.one97.paytm.common.entity.passcode.DeviceAuthAttribute;
import net.one97.paytm.common.entity.passcode.DeviceDetailPreference;
import net.one97.paytm.network.a;
import net.one97.paytm.network.b;
import net.one97.paytm.network.f;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f55759a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static a f55760b;

    /* renamed from: c  reason: collision with root package name */
    private static b f55761c;

    private d() {
    }

    public static LiveData<f> a(Context context) {
        k.c(context, "context");
        String b2 = com.paytm.utility.b.b(context, net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, PaymentsGTMConstants.USER_DETAILS) + net.one97.paytm.wallet.utility.a.c());
        k.a((Object) b2, "CJRAppCommonUtility.addS…ms(context, userV2APIUrl)");
        Map<String, String> k = net.one97.paytm.wallet.utility.a.k(context);
        Map hashMap = new HashMap();
        hashMap.put("screen_name", "PasscodeFlowRequestHandler.class");
        a aVar = f55760b;
        if (aVar != null) {
            aVar.b();
        }
        f55760b = new a(b2, new DeviceAuthAttribute(), hashMap, k);
        if (com.paytm.utility.b.c(context)) {
            a aVar2 = f55760b;
            if (aVar2 != null) {
                return aVar2.a();
            }
            return null;
        } else if (f55760b == null) {
            return null;
        } else {
            d.a aVar3 = net.one97.paytm.base.d.f49504d;
            a aVar4 = f55760b;
            if (aVar4 == null) {
                k.a();
            }
            return aVar3.a(context, aVar4);
        }
    }

    public static LiveData<f> b(Context context) {
        k.c(context, "context");
        String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "authPreferences");
        b bVar = f55761c;
        if (bVar != null) {
            bVar.b();
        }
        f55761c = new b(stringFromGTM, new DeviceDetailPreference(), (Map<String, String>) null, net.one97.paytm.wallet.utility.a.l(context), net.one97.paytm.wallet.utility.a.d(), a.C0715a.PUT, a.c.WALLET, a.b.SILENT, "PasscodeFlowRequestHandler");
        if (com.paytm.utility.b.c(context)) {
            b bVar2 = f55761c;
            if (bVar2 != null) {
                return bVar2.a();
            }
            return null;
        } else if (f55761c == null) {
            return null;
        } else {
            d.a aVar = net.one97.paytm.base.d.f49504d;
            b bVar3 = f55761c;
            if (bVar3 == null) {
                k.a();
            }
            return aVar.a(context, bVar3);
        }
    }

    public static void a() {
        net.one97.paytm.network.a aVar = f55760b;
        if (aVar != null) {
            aVar.b();
        }
        b bVar = f55761c;
        if (bVar != null) {
            bVar.b();
        }
    }
}
