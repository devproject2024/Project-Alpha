package net.one97.paytm.bankCommon.b;

import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f16206a;

    /* renamed from: b  reason: collision with root package name */
    public g.b<IJRPaytmDataModel> f16207b;

    /* renamed from: c  reason: collision with root package name */
    public g.a f16208c;

    /* renamed from: d  reason: collision with root package name */
    public IJRPaytmDataModel f16209d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f16210e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f16211f;

    /* renamed from: g  reason: collision with root package name */
    public String f16212g;

    /* renamed from: h  reason: collision with root package name */
    public a.C0715a f16213h;

    /* renamed from: i  reason: collision with root package name */
    private String f16214i;
    private a.c j;
    private a.b k;
    private HashMap<String, String> l;

    public final void a(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, String str2, a.C0715a aVar2, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        this.f16206a = str;
        this.f16207b = bVar;
        this.f16208c = aVar;
        this.f16209d = iJRPaytmDataModel;
        this.f16210e = null;
        this.f16211f = map;
        this.f16212g = str2;
        this.f16213h = aVar2;
        this.j = cVar;
        this.l = hashMap;
        this.k = bVar2;
        this.f16214i = "post";
    }

    public final void a(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        this.f16206a = str;
        this.f16207b = bVar;
        this.f16208c = aVar;
        this.f16209d = iJRPaytmDataModel;
        this.f16211f = map;
        this.f16212g = null;
        this.j = cVar;
        this.l = hashMap;
        this.k = bVar2;
        this.f16214i = "get";
    }

    public final f a() {
        if (this.f16214i.equals("post")) {
            return new net.one97.paytm.bankCommon.g.b(this.f16206a, this.f16207b, this.f16208c, this.f16209d, this.f16210e, this.f16211f, this.f16212g, this.f16213h, this.j, this.k, this.l);
        }
        if (this.f16214i.equals("get")) {
            return new net.one97.paytm.bankCommon.g.a(this.f16206a, this.f16207b, this.f16208c, this.f16209d, this.f16211f, this.j, this.k, this.l);
        }
        return null;
    }
}
