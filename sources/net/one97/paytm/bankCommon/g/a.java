package net.one97.paytm.bankCommon.g;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.i;
import net.one97.paytm.bankOpen.f;

public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    com.paytm.network.a f16263a;

    /* renamed from: c  reason: collision with root package name */
    private i f16264c;

    /* renamed from: d  reason: collision with root package name */
    private IJRPaytmDataModel f16265d;

    public a(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        this(str, bVar, aVar, iJRPaytmDataModel, map, cVar, bVar2, hashMap, (byte) 0);
    }

    private a(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, a.c cVar, a.b bVar2, HashMap<String, String> hashMap, byte b2) {
        g.b<IJRPaytmDataModel> bVar3 = bVar;
        g.a aVar2 = aVar;
        a(str, new i(bVar, aVar), iJRPaytmDataModel, (Map<String, String>) null, map, cVar, bVar2, hashMap);
    }

    public a(String str, g.b bVar, g.a aVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, a.c cVar, a.b bVar2, HashMap<String, String> hashMap, char c2) {
        g.b bVar3 = bVar;
        g.a aVar2 = aVar;
        a(str, new i(bVar, aVar), iJRPaytmDataModel, (Map<String, String>) null, map, cVar, bVar2, hashMap);
    }

    public a(String str, g.b bVar, g.a aVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, Map<String, String> map2, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        g.b bVar3 = bVar;
        g.a aVar2 = aVar;
        a(str, new i(bVar, aVar), iJRPaytmDataModel, map, map2, cVar, bVar2, hashMap);
    }

    private void a(String str, i iVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, Map<String, String> map2, a.c cVar, a.b bVar, HashMap<String, String> hashMap) {
        Map<String, String> map3 = map2;
        if (str != null) {
            if (map3 != null && !map2.containsKey("Content-Type")) {
                map2.put("Content-Type", "application/json");
            }
            Context applicationContext = f.a().getApplicationContext();
            i iVar2 = iVar;
            this.f16264c = iVar2;
            IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
            this.f16265d = iJRPaytmDataModel2;
            b a2 = a(applicationContext, str, iVar, iVar2, iJRPaytmDataModel2, map2);
            a2.f42879c = a.C0715a.GET;
            a2.f42878b = cVar;
            a2.o = hashMap.get("screen_name");
            a2.n = bVar;
            a2.f42877a = applicationContext;
            a2.f42883g = map;
            this.f16263a = a2.l();
        }
    }

    public final void a() {
        if (com.paytm.utility.b.c(f.a().getApplicationContext())) {
            com.paytm.network.a aVar = this.f16263a;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        this.f16264c.onErrorResponse(-1, this.f16265d, new NetworkCustomError());
    }
}
