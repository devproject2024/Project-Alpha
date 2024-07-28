package net.one97.paytm.bankCommon.g;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.i;
import net.one97.paytm.bankOpen.f;

public final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    private a f16266a;

    /* renamed from: c  reason: collision with root package name */
    private i f16267c;

    /* renamed from: d  reason: collision with root package name */
    private IJRPaytmDataModel f16268d;

    public b(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, String str2, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        this(str, bVar, aVar, iJRPaytmDataModel, (Map<String, String>) null, map, str2, a.C0715a.POST, cVar, bVar2, hashMap);
    }

    public b(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, Map<String, String> map2, String str2, a.C0715a aVar2, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        g.b<IJRPaytmDataModel> bVar3 = bVar;
        g.a aVar3 = aVar;
        this.f16267c = new i(bVar, aVar);
        a(str, this.f16267c, iJRPaytmDataModel, map, map2, str2, cVar, bVar2, hashMap, aVar2);
    }

    public b(String str, g.b bVar, g.a aVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, Map<String, String> map2, String str2, a.c cVar, a.b bVar2, HashMap<String, String> hashMap, a.C0715a aVar2) {
        g.b bVar3 = bVar;
        g.a aVar3 = aVar;
        a(str, new i(bVar, aVar), iJRPaytmDataModel, map, map2, str2, cVar, bVar2, hashMap, aVar2);
    }

    private void a(String str, i iVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, Map<String, String> map2, String str2, a.c cVar, a.b bVar, HashMap<String, String> hashMap, a.C0715a aVar) {
        Map<String, String> map3 = map2;
        if (str != null) {
            if (map3 != null && !map2.containsKey("Content-Type")) {
                map2.put("Content-Type", "application/json");
            }
            Context applicationContext = f.a().getApplicationContext();
            i iVar2 = iVar;
            this.f16267c = iVar2;
            IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
            this.f16268d = iJRPaytmDataModel2;
            com.paytm.network.b a2 = a(applicationContext, str, iVar, iVar2, iJRPaytmDataModel2, map2);
            a2.f42884h = str2;
            a2.f42878b = cVar;
            a2.o = hashMap.get("screen_name");
            a2.n = bVar;
            a2.f42883g = map;
            a2.f42879c = aVar;
            this.f16266a = a2.l();
        }
    }

    public final void a() {
        if (com.paytm.utility.b.c(f.a().getApplicationContext())) {
            a aVar = this.f16266a;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        this.f16267c.onErrorResponse(-1, this.f16268d, new NetworkCustomError());
    }
}
