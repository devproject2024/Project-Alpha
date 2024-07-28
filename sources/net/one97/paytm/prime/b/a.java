package net.one97.paytm.prime.b;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f59744a = "PrimeHelper";

    /* renamed from: b  reason: collision with root package name */
    private static net.one97.paytm.prime.e.a f59745b;

    public static net.one97.paytm.prime.e.a a() {
        net.one97.paytm.prime.e.a aVar = f59745b;
        if (aVar != null) {
            return aVar;
        }
        try {
            net.one97.paytm.prime.e.a aVar2 = (net.one97.paytm.prime.e.a) Class.forName("net.one97.paytm.landingpage.utils.k").newInstance();
            f59745b = aVar2;
            return aVar2;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public static com.paytm.network.a a(Context context, String str, b bVar, Map<String, String> map, a.C0715a aVar, IJRPaytmDataModel iJRPaytmDataModel, a.c cVar, a.b bVar2) {
        com.paytm.network.b bVar3 = new com.paytm.network.b();
        bVar3.f42877a = context;
        bVar3.f42878b = cVar;
        bVar3.f42879c = aVar;
        bVar3.n = bVar2;
        bVar3.o = context.getClass().getSimpleName();
        bVar3.f42880d = str;
        bVar3.f42885i = iJRPaytmDataModel;
        bVar3.j = bVar;
        bVar3.f42882f = map;
        if (!TextUtils.isEmpty((CharSequence) null)) {
            bVar3.f42884h = null;
        }
        return bVar3.l();
    }
}
