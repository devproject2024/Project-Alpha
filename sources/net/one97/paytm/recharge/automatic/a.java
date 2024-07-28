package net.one97.paytm.recharge.automatic;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.automatic.c.b;
import net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.mobile.activity.AJRMobileRechargeActivityV8;
import net.one97.paytm.recharge.ordersummary.h.d;
import net.one97.paytm.wallet.c.d;

public final class a implements net.one97.paytm.recharge.automatic.c.a, b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f60225a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ b f60226b = new b();

    public final int a(String str, int i2) {
        k.c(str, "key");
        return this.f60226b.a(str, i2);
    }

    public final String a(String str) {
        k.c(str, "key");
        return this.f60226b.a(str);
    }

    public final String a(String str, String str2) {
        k.c(str, "key");
        k.c(str2, "value");
        return this.f60226b.a(str, str2);
    }

    public final boolean a(String str, boolean z) {
        k.c(str, "key");
        return this.f60226b.a(str, z);
    }

    public a(Context context) {
        k.c(context, "context");
        this.f60225a = context;
    }

    public final void a(Context context, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Context context2 = context;
        k.c(context, "context");
        k.c(obj, "eventCategory");
        k.c(obj2, "eventAction");
        k.c(obj3, SDKConstants.EVENT_KEY_SCREEN_NAME);
        Object obj7 = obj4;
        k.c(obj7, "label");
        Object obj8 = obj5;
        k.c(obj8, "vertical");
        Object obj9 = obj6;
        k.c(obj9, "label2");
        d.a(new d(context), obj, obj2, obj3, obj7, obj8, obj9, (Object) null, 64);
    }

    public final Context a() {
        return this.f60225a;
    }

    public final ContextWrapper a(Context context) {
        k.c(context, "context");
        return CJRRechargeUtilities.INSTANCE.getRestringValue(context);
    }

    public final void a(String str, Bundle bundle, Context context) {
        String str2;
        String name;
        k.c(context, "context");
        if (str == null) {
            str2 = null;
        } else if (str != null) {
            str2 = str.toLowerCase();
            k.a((Object) str2, "(this as java.lang.String).toLowerCase()");
        } else {
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
        if (str2 != null && str2.hashCode() == 373568567 && str2.equals("mobile-postpaid")) {
            if (bundle == null) {
                k.a();
            }
            a.C1160a aVar = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
            a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            a(context, a2, net.one97.paytm.recharge.automatic.b.a.a.j, "", "mobile_postpaid", "recharges_utilities", "");
            Intent intent = new Intent(context, AJRMobileRechargeActivityV8.class);
            intent.putExtras(bundle);
            context.startActivity(intent);
            return;
        }
        if (bundle == null) {
            k.a();
        }
        String str3 = "";
        if (bundle.containsKey("extra_home_data")) {
            Serializable serializable = bundle.getSerializable("extra_home_data");
            if (!(serializable instanceof CJRHomePageItem)) {
                serializable = null;
            }
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) serializable;
            if (!(cJRHomePageItem == null || (name = cJRHomePageItem.getName()) == null)) {
                if (name != null) {
                    String lowerCase = name.toLowerCase();
                    k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (lowerCase != null) {
                        str3 = lowerCase;
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
        }
        a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
        String a3 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
        a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
        a(context, a3, net.one97.paytm.recharge.automatic.b.a.a.j, "", str3, "recharges_utilities", "");
        Intent intent2 = new Intent(context, AJRRechargeUtilityActivity.class);
        intent2.putExtras(bundle);
        context.startActivity(intent2);
    }

    public final void a(String str, j jVar) {
        net.one97.paytm.wallet.c.d dVar;
        k.c(jVar, "fragmentManager");
        if (TextUtils.isEmpty(str)) {
            dVar = net.one97.paytm.wallet.c.d.a(d.b.ALL);
            k.a((Object) dVar, "CvvHelpBottomSheetFragme…AddMoney.CvvHelpCard.ALL)");
        } else if (!p.a(str, SDKConstants.AMEX, true)) {
            dVar = net.one97.paytm.wallet.c.d.a(d.b.NON_AMEX);
            k.a((Object) dVar, "CvvHelpBottomSheetFragme…ney.CvvHelpCard.NON_AMEX)");
        } else {
            dVar = net.one97.paytm.wallet.c.d.a(d.b.AMEX);
            k.a((Object) dVar, "CvvHelpBottomSheetFragme…ddMoney.CvvHelpCard.AMEX)");
        }
        dVar.show(jVar, (String) null);
    }

    public final String b() {
        return CJRRechargeUtilities.INSTANCE.getBankAuthPasscodeRSA();
    }

    public final void a(Activity activity, NetworkCustomError networkCustomError, int i2) {
        k.c(networkCustomError, "error");
        CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, (String) null, activity, (Fragment) null, networkCustomError, true, i2, (Object) null, 4, (Object) null);
    }

    public final void a(Activity activity, Fragment fragment, NetworkCustomError networkCustomError, int i2) {
        k.c(fragment, "fragment");
        k.c(networkCustomError, "error");
        CJRRechargeUtilities.INSTANCE.handleError((String) null, activity, fragment, networkCustomError, true, i2, (Object) null);
    }

    public final void a(Activity activity, int i2) {
        z.a(activity, i2);
    }

    public final void a(Context context, String str) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        try {
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            net.one97.paytm.recharge.di.helper.b.a(context, str);
        } catch (Throwable unused) {
        }
    }

    public final void a(Context context, String str, CJRHomePageItem cJRHomePageItem) {
        k.c(context, "context");
        k.c(str, "url");
        k.c(cJRHomePageItem, "searchItem");
        CJRRechargeUtilities.INSTANCE.launchDeeplink(context, str, cJRHomePageItem);
    }

    public final Class<? extends Activity> c() {
        net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
        return net.one97.paytm.recharge.di.helper.a.h();
    }

    public final Class<? extends Activity> d() {
        net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
        return net.one97.paytm.recharge.di.helper.a.e();
    }

    public final void a(Context context, int i2) {
        k.c(context, "context");
        CJRRechargeUtilities.INSTANCE.openIFSCCodeActivity(context, i2);
    }

    public final boolean a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel, CJRFrequentOrder cJRFrequentOrder) {
        k.c(cJRAutomaticSubscriptionItemModel, "subscription");
        k.c(cJRFrequentOrder, "recent");
        az azVar = az.f61525a;
        return az.a(cJRAutomaticSubscriptionItemModel, cJRFrequentOrder);
    }

    public final void b(Context context) {
        k.c(context, "context");
        az.f(context, "");
    }

    public final boolean c(Context context) {
        k.c(context, "context");
        return az.c(context);
    }
}
