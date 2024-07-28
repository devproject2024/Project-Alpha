package net.one97.paytm.recharge;

import android.app.Activity;
import com.paytm.paymentsettings.merchantSubscriptions.view.ActiveSubscriptionActivity;
import com.paytm.utility.q;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.h;
import kotlin.u;
import net.one97.paytm.AJROrderSummaryActivity;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.AJRUpdateMessage;
import net.one97.paytm.AJRWebViewActivity;
import net.one97.paytm.AJRYoutubeVideoPlay;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.recharge.di.a;

public final class f implements net.one97.paytm.recharge.di.a {

    /* renamed from: a  reason: collision with root package name */
    private final g f62772a = h.a(a.INSTANCE);

    static final class a extends l implements kotlin.g.a.a<Map<a.C1212a, Class<? extends Activity>>> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        public final Map<a.C1212a, Class<? extends Activity>> invoke() {
            Map<a.C1212a, Class<? extends Activity>> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(a.C1212a.AJRMainActivity, AJRMainActivity.class);
            linkedHashMap.put(a.C1212a.AJRRechargePaymentActivity, AJRRechargePaymentActivity.class);
            linkedHashMap.put(a.C1212a.AJRUpdateMessage, AJRUpdateMessage.class);
            linkedHashMap.put(a.C1212a.ActiveSubscriptionActivity, ActiveSubscriptionActivity.class);
            linkedHashMap.put(a.C1212a.AddDebitOrCreditCard, net.one97.paytm.helper.a.f50546a.a().d("net.one97.paytm.wallet.autoSubscription.AddDebitOrCreditCard"));
            linkedHashMap.put(a.C1212a.AuthActivity, AJRAuthActivity.class);
            linkedHashMap.put(a.C1212a.ORDER_SUMMARY, AJROrderSummaryActivity.class);
            linkedHashMap.put(a.C1212a.WebViewActivity, AJRWebViewActivity.class);
            linkedHashMap.put(a.C1212a.AJRYoutubeVideoPlay, AJRYoutubeVideoPlay.class);
            try {
                Class<?> cls = Class.forName("net.one97.paytm.cst.activity.AJRCSTOrderIssues");
                k.a((Object) cls, "Class.forName(castActivityName)");
                a.C1212a aVar = a.C1212a.AJRCSTOrderIssues;
                if (cls != null) {
                    linkedHashMap.put(aVar, cls);
                    return linkedHashMap;
                }
                throw new u("null cannot be cast to non-null type java.lang.Class<android.app.Activity>");
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    public final Map<a.C1212a, Class<? extends Activity>> getActivityMap() {
        return (Map) this.f62772a.getValue();
    }
}
