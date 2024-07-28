package net.one97.paytm.recharge.common.b;

import android.content.Context;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.recharge.common.b.b.b;
import net.one97.paytm.recharge.common.b.b.c;
import net.one97.paytm.recharge.common.b.c;
import net.one97.paytm.recharge.common.b.c.b;
import net.one97.paytm.recharge.common.b.c.c;
import net.one97.paytm.recharge.common.utils.s;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.coupons.a;
import net.one97.paytm.recharge.coupons.b;
import net.one97.paytm.recharge.mobile.a;
import net.one97.paytm.recharge.mobile.b;
import net.one97.paytm.recharge.ordersummary.b.a.a;
import net.one97.paytm.recharge.ordersummary.b.a.b;
import org.json.JSONObject;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f60951a = new d();

    private d() {
    }

    public static final c a(Context context) {
        k.c(context, "context");
        c.a aVar = c.f60903b;
        c.a aVar2 = net.one97.paytm.recharge.common.b.b.c.f60889b;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        c.a aVar3 = net.one97.paytm.recharge.common.b.c.c.f60930b;
        Context applicationContext2 = context.getApplicationContext();
        k.a((Object) applicationContext2, "context.applicationContext");
        return aVar.a((b) aVar2.a(applicationContext), (net.one97.paytm.recharge.common.b.c.d) aVar3.a(applicationContext2));
    }

    public static final c b(Context context) {
        k.c(context, "context");
        c.a aVar = c.f60903b;
        c.a aVar2 = net.one97.paytm.recharge.common.b.b.c.f60889b;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        b.a aVar3 = net.one97.paytm.recharge.common.b.c.b.f60918c;
        Context applicationContext2 = context.getApplicationContext();
        k.a((Object) applicationContext2, "context.applicationContext");
        return aVar.a((net.one97.paytm.recharge.common.b.b.b) aVar2.a(applicationContext), (net.one97.paytm.recharge.common.b.c.d) aVar3.a(applicationContext2));
    }

    public static final net.one97.paytm.recharge.mobile.b c(Context context) {
        k.c(context, "context");
        b.a aVar = net.one97.paytm.recharge.mobile.b.f63674c;
        c.a aVar2 = net.one97.paytm.recharge.common.b.b.c.f60889b;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        a.C1232a aVar3 = a.f63585d;
        Context applicationContext2 = context.getApplicationContext();
        k.a((Object) applicationContext2, "context.applicationContext");
        return aVar.a((net.one97.paytm.recharge.common.b.b.b) aVar2.a(applicationContext), (net.one97.paytm.recharge.mobile.c) aVar3.a(applicationContext2));
    }

    public static final w d(Context context) {
        k.c(context, "context");
        return new w(context);
    }

    public static final net.one97.paytm.recharge.coupons.b e(Context context) {
        k.c(context, "context");
        b.a aVar = net.one97.paytm.recharge.coupons.b.f62263c;
        c.a aVar2 = net.one97.paytm.recharge.common.b.b.c.f60889b;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        a.C1193a aVar3 = net.one97.paytm.recharge.coupons.a.f62159b;
        Context applicationContext2 = context.getApplicationContext();
        k.a((Object) applicationContext2, "context.applicationContext");
        return aVar.a((net.one97.paytm.recharge.common.b.b.b) aVar2.a(applicationContext), (net.one97.paytm.recharge.coupons.c) aVar3.a(applicationContext2));
    }

    public static final s a(Context context, JSONObject jSONObject, CJRRechargeCart cJRRechargeCart) {
        k.c(context, "context");
        k.c(jSONObject, "verifyJson");
        k.c(cJRRechargeCart, "rechargeCart");
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        return new s(applicationContext, jSONObject, cJRRechargeCart);
    }

    public static final net.one97.paytm.recharge.ordersummary.b.a.b f(Context context) {
        k.c(context, "context");
        b.a aVar = net.one97.paytm.recharge.ordersummary.b.a.b.f64010a;
        c.a aVar2 = net.one97.paytm.recharge.common.b.b.c.f60889b;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        a.C1255a aVar3 = net.one97.paytm.recharge.ordersummary.b.a.a.f64008b;
        Context applicationContext2 = context.getApplicationContext();
        k.a((Object) applicationContext2, "context.applicationContext");
        b.a aVar4 = net.one97.paytm.recharge.common.b.c.b.f60918c;
        Context applicationContext3 = context.getApplicationContext();
        k.a((Object) applicationContext3, "context.applicationContext");
        return aVar.a((net.one97.paytm.recharge.common.b.b.b) aVar2.a(applicationContext), (net.one97.paytm.recharge.ordersummary.f.k) aVar3.a(applicationContext2), (net.one97.paytm.recharge.common.b.c.d) aVar4.a(applicationContext3));
    }
}
