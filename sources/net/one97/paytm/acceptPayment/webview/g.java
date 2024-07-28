package net.one97.paytm.acceptPayment.webview;

import com.sendbird.android.constant.StringSet;
import easypay.manager.Constants;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.t;
import net.one97.paytm.acceptPayment.b.a;
import net.one97.paytm.acceptPayment.utils.b;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    final String f52226a;

    /* renamed from: b  reason: collision with root package name */
    final String f52227b;

    public g(String str, String str2) {
        k.d(str, "id");
        this.f52226a = str;
        this.f52227b = str2;
    }

    static Map<String, String> a() {
        a b2 = net.one97.paytm.acceptPayment.configs.a.a().b();
        k.b(b2, "AcceptPaymentsConfig.get…tAcceptPaymentsListener()");
        return ae.b((o<? extends K, ? extends V>[]) new o[]{t.a(Constants.RISK_OS_TYPE, StringSet.Android), t.a("appVersion", String.valueOf(b.a(b2.a())))});
    }

    static h a(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -998335082) {
            if (hashCode != 21116443) {
                if (hashCode == 1747859616 && str.equals("limitsandcharges")) {
                    return c.f52222a;
                }
            } else if (str.equals("onboarding")) {
                return e.f52224a;
            }
        } else if (str.equals("ump_page")) {
            return f.f52225a;
        }
        return f.f52225a;
    }
}
