package net.one97.paytm.recharge.automatic.e;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.widgets.b.d;

public final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    a f60276a;

    /* renamed from: b  reason: collision with root package name */
    private b f60277b;

    /* renamed from: c  reason: collision with root package name */
    private String f60278c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public c(String str, d dVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, String str2) {
        this(str, dVar, iJRPaytmDataModel, map, str2, a.C0715a.POST);
        k.c(dVar, "listener");
        k.c(iJRPaytmDataModel, "model");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private c(java.lang.String r12, net.one97.paytm.recharge.widgets.b.d r13, com.paytm.network.model.IJRPaytmDataModel r14, java.util.Map<java.lang.String, java.lang.String> r15, java.lang.String r16, com.paytm.network.a.C0715a r17) {
        /*
            r11 = this;
            java.lang.String r0 = "listener"
            r3 = r13
            kotlin.g.b.k.c(r13, r0)
            java.lang.String r0 = "model"
            r4 = r14
            kotlin.g.b.k.c(r14, r0)
            java.lang.String r0 = "httpRequestMethod"
            r7 = r17
            kotlin.g.b.k.c(r7, r0)
            com.paytm.network.a$c r8 = com.paytm.network.a.c.RECHARGES
            com.paytm.network.a$b r9 = com.paytm.network.a.b.SILENT
            java.lang.String r10 = "None"
            r1 = r11
            r2 = r12
            r5 = r15
            r6 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.automatic.e.c.<init>(java.lang.String, net.one97.paytm.recharge.widgets.b.d, com.paytm.network.model.IJRPaytmDataModel, java.util.Map, java.lang.String, com.paytm.network.a$a):void");
    }

    private c(String str, d dVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, String str2, a.C0715a aVar, a.c cVar, a.b bVar, String str3) {
        String str4 = str;
        d dVar2 = dVar;
        a.C0715a aVar2 = aVar;
        a.c cVar2 = cVar;
        a.b bVar2 = bVar;
        String str5 = str3;
        k.c(dVar, "listener");
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        k.c(iJRPaytmDataModel, "model");
        k.c(aVar2, "methodType");
        k.c(cVar2, "vertical");
        k.c(bVar2, "userfacing");
        k.c(str5, SDKConstants.EVENT_KEY_SCREEN_NAME);
        e eVar = new e(dVar, str);
        net.one97.paytm.recharge.automatic.c.d dVar3 = net.one97.paytm.recharge.automatic.c.d.f60262c;
        Context b2 = net.one97.paytm.recharge.automatic.c.d.b();
        if (str4 != null && b2 != null) {
            this.f60278c = str4;
            b a2 = a(b2, str, eVar, iJRPaytmDataModel, map).a(aVar2);
            a2.b((Map) null);
            k.a((Object) a2, "networkCallBuilder");
            a2.b(str2);
            a2.a(cVar2);
            a2.c(str5);
            a2.a(bVar2);
            a2.f();
            a2.d((String) null);
            this.f60277b = a2;
            this.f60276a = a2.l();
        }
    }
}
