package net.one97.paytm.passbook.mapping.a;

import android.content.Context;
import com.paytm.network.a;
import java.util.Map;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.i;

public final class b extends e {

    /* renamed from: a  reason: collision with root package name */
    com.paytm.network.b f57875a;

    /* renamed from: b  reason: collision with root package name */
    private a f57876b;

    /* renamed from: c  reason: collision with root package name */
    private String f57877c;

    public b(String str, i.a<IJRDataModel> aVar, g gVar, IJRDataModel iJRDataModel, Map<String, String> map, String str2, a.c cVar, a.b bVar, String str3) {
        this(str, aVar, gVar, iJRDataModel, map, str2, a.C0715a.POST, cVar, bVar, str3);
    }

    public b(String str, i.a<IJRDataModel> aVar, g gVar, IJRDataModel iJRDataModel, Map<String, String> map, String str2, a.C0715a aVar2, a.c cVar, a.b bVar, String str3) {
        String str4 = str;
        i.a<IJRDataModel> aVar3 = aVar;
        g gVar2 = gVar;
        h hVar = new h(aVar, gVar);
        Context b2 = d.b().b();
        if (str4 != null && b2 != null) {
            this.f57877c = str4;
            com.paytm.network.b a2 = a(b2, str, hVar, hVar, iJRDataModel, map);
            a2.f42879c = aVar2;
            this.f57875a = a2;
            com.paytm.network.b bVar2 = this.f57875a;
            bVar2.f42883g = null;
            bVar2.f42884h = str2;
            bVar2.f42878b = cVar;
            bVar2.o = str3;
            bVar2.n = bVar;
            this.f57876b = bVar2.l();
        }
    }

    public final void a() {
        a aVar = this.f57876b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void b() {
        a aVar = this.f57876b;
        if (aVar != null) {
            aVar.b();
        }
    }
}
