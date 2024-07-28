package net.one97.paytm.passbook.mapping.a;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.b;
import java.util.Map;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.i;

public final class a extends e {

    /* renamed from: a  reason: collision with root package name */
    public b f57873a;

    /* renamed from: b  reason: collision with root package name */
    private String f57874b;

    public a(String str, i.a<IJRDataModel> aVar, g gVar, IJRDataModel iJRDataModel, Map<String, String> map, a.c cVar, a.b bVar, String str2) {
        this(str, aVar, gVar, iJRDataModel, map, cVar, bVar, str2, (byte) 0);
    }

    public a(String str, i.a<IJRDataModel> aVar, g gVar, IJRDataModel iJRDataModel, Map<String, String> map, a.c cVar, a.b bVar, String str2, byte b2) {
        this(str, aVar, gVar, iJRDataModel, map, cVar, bVar, str2, (Boolean) null);
    }

    public a(String str, i.a<IJRDataModel> aVar, g gVar, IJRDataModel iJRDataModel, Map<String, String> map, a.c cVar, a.b bVar, String str2, Boolean bool) {
        String str3 = str;
        i.a<IJRDataModel> aVar2 = aVar;
        g gVar2 = gVar;
        h hVar = new h(aVar, gVar);
        a.C0715a aVar3 = a.C0715a.GET;
        Context b2 = d.b().b();
        if (str3 != null && b2 != null) {
            this.f57874b = str3;
            b a2 = a(b2, str, hVar, hVar, iJRDataModel, map);
            a2.f42879c = aVar3;
            this.f57873a = a2;
            b bVar2 = this.f57873a;
            bVar2.f42883g = null;
            bVar2.f42884h = null;
            bVar2.f42878b = cVar;
            bVar2.o = str2;
            if (bool != null) {
                bVar2.k = bool.booleanValue();
            }
            this.f57873a.n = bVar;
        }
    }

    public final void a() {
        b bVar = this.f57873a;
        if (bVar != null) {
            bVar.l().a();
        }
    }
}
