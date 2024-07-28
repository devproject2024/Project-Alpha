package net.one97.paytm.d.a;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.kych5.bridge.b;
import net.one97.paytm.phoenix.PhoenixManager;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f50281a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final String f50282b = f50282b;

    private a() {
    }

    public static void a(String str, String str2, String str3, Bundle bundle, String str4) {
        String str5 = str;
        k.c(str, "verticalName");
        k.c(str2, "appId");
        k.c(str3, "url");
        Bundle bundle2 = bundle;
        k.c(bundle2, "bundle");
        String str6 = str4;
        k.c(str6, "deepLinkData");
        ArrayList d2 = kotlin.a.k.d(new net.one97.paytm.kych5.a.a(str));
        List arrayList = new ArrayList();
        arrayList.add(new b());
        arrayList.add(new net.one97.paytm.kych5.bridge.a());
        PhoenixManager.loadPage$default(str2, str3, (PhoenixManager.a) null, bundle2, str6, false, arrayList, d2, (Activity) null, UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS, (Object) null);
    }
}
