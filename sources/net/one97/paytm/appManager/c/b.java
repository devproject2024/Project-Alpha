package net.one97.paytm.appManager.c;

import android.content.Context;
import com.paytm.network.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.appManager.beans.Data;
import net.one97.paytm.appManager.beans.ResponseData;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f49042a = new b();

    private b() {
    }

    public static a a(Context context, com.paytm.network.listener.b bVar, int i2, long j) {
        k.c(context, "context");
        k.c(bVar, "responseHandler");
        String str = net.one97.paytm.appManager.d.a.a().getFetchDataURL() + "version=" + j + "&pageno=" + i2 + "&pagesize=200";
        HashMap hashMap = new HashMap();
        hashMap.put("AUTHORIZATION_VALUE", net.one97.paytm.appManager.d.a.a().getAuthValue());
        String str2 = new String();
        a aVar = a.f49041a;
        com.paytm.network.b a2 = a.a(context, str, bVar, new ResponseData((Integer) null, (Data) null, 3, (g) null), hashMap);
        a2.a(a.C0715a.GET);
        a2.b((Map) new HashMap());
        a2.b(str2);
        a2.a(false);
        a2.i();
        return a2.l();
    }
}
