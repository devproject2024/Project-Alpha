package net.one97.paytm.fastag.d;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import net.one97.paytm.fastag.d.g;

public final class a extends e {

    /* renamed from: a  reason: collision with root package name */
    com.paytm.network.a f13560a;

    /* renamed from: b  reason: collision with root package name */
    private String f13561b;

    public a(String str, g.a<IJRPaytmDataModel> aVar, d dVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, a.c cVar, a.b bVar, String str2) {
        this(str, aVar, dVar, iJRPaytmDataModel, map, cVar, bVar, str2, (byte) 0);
    }

    @Deprecated
    public a(String str, g.a<IJRPaytmDataModel> aVar, d dVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map) {
        this(str, aVar, dVar, iJRPaytmDataModel, map, (a.c) null, (a.b) null, (String) null, (byte) 0);
    }

    private a(String str, g.a<IJRPaytmDataModel> aVar, d dVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, a.c cVar, a.b bVar, String str2, byte b2) {
        String str3 = str;
        g.a<IJRPaytmDataModel> aVar2 = aVar;
        d dVar2 = dVar;
        f fVar = new f(aVar, dVar);
        a.C0715a aVar3 = a.C0715a.GET;
        Context applicationContext = net.one97.paytm.fastag.c.a.a().f13559b.getApplicationContext();
        if (str3 != null && applicationContext != null) {
            this.f13561b = str3;
            b a2 = a(applicationContext, str, fVar, fVar, iJRPaytmDataModel, map);
            a2.f42879c = aVar3;
            a2.f42883g = null;
            a2.f42884h = null;
            a2.f42878b = cVar;
            a2.o = str2;
            a2.n = bVar;
            this.f13560a = a2.l();
        }
    }

    public final String a() {
        return this.f13561b;
    }
}
