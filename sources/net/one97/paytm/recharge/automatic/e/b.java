package net.one97.paytm.recharge.automatic.e;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.widgets.b.d;

public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    a f60274a;

    /* renamed from: b  reason: collision with root package name */
    private String f60275b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public b(String str, d dVar, IJRPaytmDataModel iJRPaytmDataModel) {
        this(str, dVar, iJRPaytmDataModel, (Map<String, String>) null, a.c.RECHARGES, a.b.SILENT, SDKConstants.NATIVE_SDK_NONE);
        k.c(dVar, "listener");
        k.c(iJRPaytmDataModel, "model");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public b(String str, d dVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map) {
        this(str, dVar, iJRPaytmDataModel, map, a.c.RECHARGES, a.b.SILENT, SDKConstants.NATIVE_SDK_NONE);
        k.c(dVar, "listener");
        k.c(iJRPaytmDataModel, "model");
    }

    private b(String str, d dVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, a.c cVar, a.b bVar, String str2) {
        k.c(dVar, "listener");
        k.c(iJRPaytmDataModel, "model");
        k.c(cVar, "vertical");
        k.c(bVar, "userfacing");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        e eVar = new e(dVar, str);
        a.C0715a aVar = a.C0715a.GET;
        net.one97.paytm.recharge.automatic.c.d dVar2 = net.one97.paytm.recharge.automatic.c.d.f60262c;
        Context b2 = net.one97.paytm.recharge.automatic.c.d.b();
        if (str != null && b2 != null) {
            this.f60275b = str;
            com.paytm.network.b a2 = a(b2, str, eVar, iJRPaytmDataModel, map).a(aVar);
            a2.b((Map) null);
            k.a((Object) a2, "networkCallBuilder");
            a2.b((String) null);
            a2.a(cVar);
            a2.c(str2);
            a2.a(bVar);
            a2.f();
            this.f60274a = a2.l();
        }
    }
}
