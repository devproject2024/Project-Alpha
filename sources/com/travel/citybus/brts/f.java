package com.travel.citybus.brts;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import com.travel.citybus.a;
import com.travel.utils.q;
import net.one97.paytm.common.entity.CJRPGTokenList;

public final class f implements a {

    /* renamed from: a  reason: collision with root package name */
    private static f f23378a;

    /* renamed from: b  reason: collision with root package name */
    private com.travel.common.a.a f23379b = q.a();

    private f() {
    }

    public static f d() {
        if (f23378a == null) {
            f23378a = new f();
        }
        return f23378a;
    }

    public static a e() {
        return d();
    }

    public final ContextWrapper a(Context context) {
        return this.f23379b.getBaseContext(context);
    }

    public final void a(Context context, Intent intent) {
        this.f23379b.startHomeScreen(context, intent);
    }

    public final void b(Context context, Intent intent) {
        Intent loginIntent = this.f23379b.getLoginIntent(context);
        if (!(intent == null || intent.getExtras() == null)) {
            loginIntent.putExtras(intent.getExtras());
        }
        context.startActivity(loginIntent);
    }

    public final String a() {
        return this.f23379b.getAppManagerStringValue("getalltokens", (String) null);
    }

    public final String b() {
        return this.f23379b.getAppManagerStringValue("orderdetail", (String) null);
    }

    public final String a(CJRPGTokenList cJRPGTokenList) {
        return this.f23379b.getPgToken(cJRPGTokenList);
    }

    public final String c() {
        return this.f23379b.getAppManagerStringValue("cityBusPaymentUrl", (String) null);
    }

    public final void c(Context context, Intent intent) {
        this.f23379b.startReachargePaymentActivity(context, intent);
    }

    public final void d(Context context, Intent intent) {
        this.f23379b.startReachargePaymentActivityForResult(context, intent, 1287);
    }

    public final boolean a(Object obj) {
        return this.f23379b.isInStanceOfHomeTab(obj);
    }

    public final String b(Object obj) {
        return this.f23379b.getHomeTabItemUrl(obj);
    }

    public final String a(String str) {
        return this.f23379b.getAppManagerStringValue(str, (String) null);
    }
}
