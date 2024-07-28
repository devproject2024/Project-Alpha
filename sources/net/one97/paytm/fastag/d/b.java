package net.one97.paytm.fastag.d;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import net.one97.paytm.fastag.d.g;

public class b extends e {

    /* renamed from: a  reason: collision with root package name */
    a f13562a;

    /* renamed from: b  reason: collision with root package name */
    private String f13563b;

    @Deprecated
    public b(String str, g.a<IJRPaytmDataModel> aVar, d dVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, String str2, a.C0715a aVar2) {
        this(str, aVar, dVar, iJRPaytmDataModel, map, str2, aVar2, a.c.PASSBOOK, a.b.USER_FACING, b.class.getSimpleName());
    }

    public b(String str, g.a<IJRPaytmDataModel> aVar, d dVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, String str2, a.C0715a aVar2, a.c cVar, a.b bVar, String str3) {
        String str4 = str;
        g.a<IJRPaytmDataModel> aVar3 = aVar;
        d dVar2 = dVar;
        f fVar = new f(aVar, dVar);
        Context applicationContext = net.one97.paytm.fastag.c.a.a().f13559b.getApplicationContext();
        if (str4 != null && applicationContext != null) {
            this.f13563b = str4;
            com.paytm.network.b a2 = a(applicationContext, str, fVar, fVar, iJRPaytmDataModel, map);
            a2.f42879c = aVar2;
            a2.f42883g = null;
            a2.f42884h = str2;
            a2.f42878b = cVar;
            a2.o = str3;
            a2.n = bVar;
            this.f13562a = a2.l();
        }
    }

    public final String a() {
        return this.f13563b;
    }
}
