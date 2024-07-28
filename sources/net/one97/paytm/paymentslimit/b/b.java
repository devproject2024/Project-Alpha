package net.one97.paytm.paymentslimit.b;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import net.one97.paytm.paymentslimit.b.h;

public final class b extends e {

    /* renamed from: b  reason: collision with root package name */
    private String f59302b;

    public b(String str, h.a<IJRPaytmDataModel> aVar, f fVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, String str2, a.c cVar, a.b bVar, String str3) {
        this(str, aVar, fVar, iJRPaytmDataModel, map, str2, a.C0715a.POST, cVar, bVar, str3);
    }

    public b(String str, h.a<IJRPaytmDataModel> aVar, f fVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, String str2, a.C0715a aVar2, a.c cVar, a.b bVar, String str3) {
        String str4 = str;
        Context a2 = net.one97.paytm.paymentslimit.a.b.f59274a.a();
        if (str4 != null && a2 != null) {
            this.f59302b = str4;
            com.paytm.network.b a3 = a(a2, str, aVar, fVar, iJRPaytmDataModel, map);
            a3.f42879c = aVar2;
            a3.f42883g = null;
            a3.f42884h = str2;
            a3.f42878b = cVar;
            a3.o = str3;
            a3.n = bVar;
            this.f59303a = a3.l();
        }
    }
}
