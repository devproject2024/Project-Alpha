package net.one97.paytm.d.a;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.payments.c.a.a;
import net.one97.paytm.payments.c.a.d;
import net.one97.paytm.payments.c.a.e;
import net.one97.paytm.payments.c.a.f;
import net.one97.paytm.payments.c.a.g;
import net.one97.paytm.payments.c.a.h;
import net.one97.paytm.payments.c.a.i;
import net.one97.paytm.payments.c.a.j;
import net.one97.paytm.payments.c.a.l;
import net.one97.paytm.payments.c.a.m;
import net.one97.paytm.payments.c.a.n;
import net.one97.paytm.payments.c.b.c;
import net.one97.paytm.phoenix.PhoenixManager;
import net.one97.paytm.upi.util.UpiConstants;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f16783a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static Bundle f16784b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final String f16785c = f16785c;

    private b() {
    }

    public static void a(String str, String str2, String str3, Bundle bundle, String str4) {
        String str5 = str;
        Bundle bundle2 = bundle;
        k.c(str, "verticalName");
        String str6 = str2;
        k.c(str2, "appId");
        String str7 = str3;
        k.c(str3, "url");
        k.c(bundle2, "bundle");
        k.c(str4, "deepLinkData");
        ArrayList d2 = kotlin.a.k.d(new c(str));
        List arrayList = new ArrayList();
        arrayList.add(new net.one97.paytm.payments.c.a.k());
        arrayList.add(new a());
        arrayList.add(new g());
        arrayList.add(new net.one97.paytm.payments.c.a.b());
        arrayList.add(new d());
        arrayList.add(new l());
        arrayList.add(new m());
        arrayList.add(new n());
        arrayList.add(new h());
        arrayList.add(new f());
        arrayList.add(new i());
        arrayList.add(new j());
        arrayList.add(new e());
        arrayList.add(new net.one97.paytm.payments.c.a.c());
        Bundle bundle3 = f16784b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        PhoenixManager.loadPage$default(str2, str3, (PhoenixManager.a) null, bundle, str4, false, arrayList, d2, (Activity) null, UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS, (Object) null);
    }
}
