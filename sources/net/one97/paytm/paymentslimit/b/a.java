package net.one97.paytm.paymentslimit.b;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import net.one97.paytm.paymentslimit.a.b;
import net.one97.paytm.paymentslimit.b.h;

public final class a extends e {

    /* renamed from: b  reason: collision with root package name */
    private String f59301b;

    public a(String str, h.a<IJRPaytmDataModel> aVar, f fVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, a.b bVar, String str2) {
        this(str, aVar, fVar, iJRPaytmDataModel, map, bVar, str2, (byte) 0);
    }

    private a(String str, h.a<IJRPaytmDataModel> aVar, f fVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, a.b bVar, String str2, byte b2) {
        String str3 = str;
        a.C0715a aVar2 = a.C0715a.GET;
        Context a2 = b.f59274a.a();
        if (str3 != null && a2 != null) {
            this.f59301b = str3;
            com.paytm.network.b a3 = a(a2, str, aVar, fVar, iJRPaytmDataModel, map);
            a3.f42879c = aVar2;
            a3.f42883g = null;
            a3.f42884h = null;
            a3.f42878b = a.c.PAY;
            a3.o = str2;
            a3.n = bVar;
            this.f59303a = a3.l();
        }
    }
}
