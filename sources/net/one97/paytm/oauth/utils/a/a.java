package net.one97.paytm.oauth.utils.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import androidx.core.content.b;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56764a = new a();

    private a() {
    }

    public static String a(Activity activity) {
        if (activity == null) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT < 22) {
                return "";
            }
            int a2 = b.a((Context) activity, "android.permission.READ_PHONE_STATE");
            if (Build.VERSION.SDK_INT >= 23 && a2 != 0) {
                return "";
            }
            Object systemService = activity.getSystemService("telephony_subscription_service");
            if (systemService != null) {
                List<SubscriptionInfo> activeSubscriptionInfoList = ((SubscriptionManager) systemService).getActiveSubscriptionInfoList();
                if (activeSubscriptionInfoList == null) {
                    return "";
                }
                new StringBuilder().append(activeSubscriptionInfoList.size());
                StringBuilder sb = new StringBuilder();
                int size = activeSubscriptionInfoList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    StringBuilder sb2 = new StringBuilder();
                    SubscriptionInfo subscriptionInfo = activeSubscriptionInfoList.get(i2);
                    k.a((Object) subscriptionInfo, "activeSubscriptionInfoList[i]");
                    sb2.append(subscriptionInfo.getSubscriptionId());
                    SubscriptionInfo subscriptionInfo2 = activeSubscriptionInfoList.get(i2);
                    k.a((Object) subscriptionInfo2, "activeSubscriptionInfoList[i]");
                    sb.append(subscriptionInfo2.getSubscriptionId());
                    if (i2 != activeSubscriptionInfoList.size() - 1) {
                        sb.append(AppConstants.COMMA);
                    }
                }
                String sb3 = sb.toString();
                k.a((Object) sb3, "ids.toString()");
                return sb3;
            }
            throw new u("null cannot be cast to non-null type android.telephony.SubscriptionManager");
        } catch (SecurityException e2) {
            q.b(e2.getMessage());
            return "";
        }
    }

    public static void b(Activity activity) {
        net.one97.paytm.oauth.utils.q qVar = net.one97.paytm.oauth.utils.q.f56798a;
        net.one97.paytm.oauth.utils.q.a(a(activity));
        net.one97.paytm.oauth.utils.q qVar2 = net.one97.paytm.oauth.utils.q.f56798a;
        net.one97.paytm.oauth.utils.q.n();
    }

    public static boolean c(Activity activity) {
        net.one97.paytm.oauth.utils.q qVar = net.one97.paytm.oauth.utils.q.f56798a;
        String f2 = net.one97.paytm.oauth.utils.q.f();
        if (f2 == null || p.a((CharSequence) f2, new String[]{AppConstants.COMMA}).get(0).length() <= 2) {
            return false;
        }
        net.one97.paytm.oauth.utils.q qVar2 = net.one97.paytm.oauth.utils.q.f56798a;
        net.one97.paytm.oauth.utils.q.a(a(activity));
        return true;
    }
}
