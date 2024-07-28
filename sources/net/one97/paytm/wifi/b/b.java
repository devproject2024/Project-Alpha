package net.one97.paytm.wifi.b;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;

public class b {

    /* renamed from: b  reason: collision with root package name */
    protected final Context f21083b;

    public b(Context context) {
        this.f21083b = context.getApplicationContext();
    }

    /* access modifiers changed from: protected */
    public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, String str2, c cVar) {
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this.f21083b;
        bVar.f42878b = a.c.WIFI;
        bVar.n = a.b.USER_FACING;
        bVar.o = "Wifi";
        bVar.f42879c = a.C0715a.POST;
        bVar.f42880d = str;
        bVar.f42883g = null;
        bVar.f42882f = map;
        bVar.f42884h = str2;
        bVar.f42885i = iJRPaytmDataModel;
        bVar.j = cVar;
        a l = bVar.l();
        l.f42859c = true;
        l.a();
    }
}
