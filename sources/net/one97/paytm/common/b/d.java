package net.one97.paytm.common.b;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.crashlytics.c;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static a f49586a;

    /* renamed from: b  reason: collision with root package name */
    private static e f49587b;

    public static a b() {
        a aVar = f49586a;
        if (aVar != null) {
            return aVar;
        }
        try {
            a aVar2 = (a) Class.forName("net.one97.paytm.landingpage.utils.a").newInstance();
            f49586a = aVar2;
            return aVar2;
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (InstantiationException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static a a(Context context, String str, b bVar, Map<String, String> map, Map<String, String> map2, a.C0715a aVar, String str2, IJRPaytmDataModel iJRPaytmDataModel, a.c cVar, a.b bVar2) {
        com.paytm.network.b bVar3 = new com.paytm.network.b();
        bVar3.f42877a = context;
        bVar3.f42878b = cVar;
        bVar3.f42879c = aVar;
        bVar3.n = bVar2;
        bVar3.o = context.getClass().getSimpleName();
        bVar3.f42880d = str;
        bVar3.f42885i = iJRPaytmDataModel;
        bVar3.j = bVar;
        if (map != null) {
            bVar3.f42882f = map;
        }
        if (!TextUtils.isEmpty(str2)) {
            bVar3.f42884h = str2;
        }
        if (map2 != null && map2.size() > 0) {
            bVar3.f42883g = map2;
        }
        return bVar3.l();
    }

    public static e a() {
        if (b().l()) {
            c.a().a((Throwable) new Exception("HomeModuleInterface can only be accessed afterHomeSettle!!"));
        }
        e eVar = f49587b;
        if (eVar != null) {
            return eVar;
        }
        try {
            e eVar2 = (e) Class.forName("net.one97.paytm.landingpage.utils.i").newInstance();
            f49587b = eVar2;
            return eVar2;
        } catch (ClassNotFoundException e2) {
            q.b(e2.getMessage());
            return null;
        } catch (IllegalAccessException e3) {
            q.b(e3.getMessage());
            return null;
        } catch (InstantiationException e4) {
            q.b(e4.getMessage());
            return null;
        }
    }
}
