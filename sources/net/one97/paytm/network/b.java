package net.one97.paytm.network;

import androidx.lifecycle.LiveData;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;

public class b extends d {

    /* renamed from: d  reason: collision with root package name */
    private String f55775d;

    public b(String str, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, Map<String, String> map2, String str2) {
        this(str, iJRPaytmDataModel, map, map2, str2, a.b.USER_FACING, b.class.getSimpleName());
    }

    public b(String str, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, Map<String, String> map2, String str2, a.b bVar, String str3) {
        this(str, iJRPaytmDataModel, map, map2, str2, a.C0715a.POST, a.c.WALLET, bVar, str3);
    }

    public b(String str, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, Map<String, String> map2, String str2, a.C0715a aVar, a.c cVar, a.b bVar, String str3) {
        if (str != null) {
            this.f55775d = str;
            a(str, iJRPaytmDataModel, map2);
            this.f55776a.f42879c = aVar;
            this.f55776a.f42883g = map;
            this.f55776a.f42884h = str2;
            this.f55776a.f42878b = cVar;
            this.f55776a.o = str3;
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
