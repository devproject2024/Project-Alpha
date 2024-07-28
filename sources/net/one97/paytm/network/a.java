package net.one97.paytm.network;

import androidx.lifecycle.LiveData;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;

public class a extends d {

    /* renamed from: d  reason: collision with root package name */
    private String f55774d;

    public a(String str, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, Map<String, String> map2) {
        this(str, iJRPaytmDataModel, map, map2, a.c.WALLET, a.b.USER_FACING, a.class.getSimpleName());
    }

    public a(String str, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, Map<String, String> map2, a.c cVar, a.b bVar, String str2) {
        a.C0715a aVar = a.C0715a.GET;
        Boolean bool = Boolean.TRUE;
        if (str != null) {
            this.f55774d = str;
            a(str, iJRPaytmDataModel, map2);
            this.f55776a.f42879c = aVar;
            this.f55776a.f42883g = map;
            this.f55776a.f42878b = cVar;
            this.f55776a.o = str2;
            this.f55776a.k = bool.booleanValue();
            this.f55776a.n = bVar;
        }
    }

    public final LiveData<f> a() {
        return c();
    }

    public final void b() {
        d();
    }
}
