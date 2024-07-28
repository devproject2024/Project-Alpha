package net.one97.paytm.recharge.common.f;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.di.f;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;

public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private a f61097a;

    /* renamed from: b  reason: collision with root package name */
    private String f61098b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public b(String str, String str2, ai aiVar, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        this(str, str2, aiVar, iJRPaytmDataModel, (Map) null, a.c.RECHARGES, a.b.SILENT, SDKConstants.NATIVE_SDK_NONE, obj);
        k.c(str, "tag");
        k.c(aiVar, "listener");
        k.c(iJRPaytmDataModel, "model");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public b(String str, String str2, ai aiVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, Object obj) {
        this(str, str2, aiVar, iJRPaytmDataModel, map, a.c.RECHARGES, a.b.SILENT, SDKConstants.NATIVE_SDK_NONE, obj);
        k.c(str, "tag");
        k.c(aiVar, "listener");
        k.c(iJRPaytmDataModel, "model");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public b(String str, String str2, ai aiVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, Object obj, byte b2) {
        this(str, str2, aiVar, iJRPaytmDataModel, map, a.c.RECHARGES, a.b.SILENT, SDKConstants.NATIVE_SDK_NONE, obj);
        k.c(str, "tag");
        k.c(aiVar, "listener");
        k.c(iJRPaytmDataModel, "model");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(java.lang.String r14, java.lang.String r15, net.one97.paytm.recharge.common.e.ai r16, com.paytm.network.model.IJRPaytmDataModel r17, java.util.Map<java.lang.String, java.lang.String> r18, java.lang.Object r19, int r20) {
        /*
            r13 = this;
            java.lang.String r0 = "tag"
            r2 = r14
            kotlin.g.b.k.c(r14, r0)
            java.lang.String r0 = "listener"
            r4 = r16
            kotlin.g.b.k.c(r4, r0)
            java.lang.String r0 = "model"
            r5 = r17
            kotlin.g.b.k.c(r5, r0)
            com.paytm.network.a$c r7 = com.paytm.network.a.c.RECHARGES
            com.paytm.network.a$b r8 = com.paytm.network.a.b.SILENT
            java.lang.String r9 = "NONE"
            r12 = 0
            r1 = r13
            r3 = r15
            r6 = r18
            r10 = r19
            r11 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.f.b.<init>(java.lang.String, java.lang.String, net.one97.paytm.recharge.common.e.ai, com.paytm.network.model.IJRPaytmDataModel, java.util.Map, java.lang.Object, int):void");
    }

    private /* synthetic */ b(String str, String str2, ai aiVar, IJRPaytmDataModel iJRPaytmDataModel, Map map, a.c cVar, a.b bVar, String str3, Object obj) {
        this(str, str2, aiVar, iJRPaytmDataModel, map, cVar, bVar, str3, obj, 60000, 1);
    }

    private b(String str, String str2, ai aiVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, a.c cVar, a.b bVar, String str3, Object obj, int i2, int i3) {
        String str4 = str2;
        a.c cVar2 = cVar;
        a.b bVar2 = bVar;
        String str5 = str3;
        Object obj2 = obj;
        String str6 = str;
        k.c(str, "tag");
        k.c(aiVar, "listener");
        k.c(iJRPaytmDataModel, "model");
        k.c(cVar2, "vertical");
        k.c(bVar2, "userfacing");
        k.c(str5, SDKConstants.EVENT_KEY_SCREEN_NAME);
        if (obj2 instanceof CJRRechargeErrorModel) {
            CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj2;
            cJRRechargeErrorModel.setUrl(com.paytm.utility.b.P(str2));
            CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
            if (flowName != null) {
                flowName.setRequestTimeout(Integer.valueOf(i2));
            }
            CRUFlowModel flowName2 = cJRRechargeErrorModel.getFlowName();
            if (flowName2 != null) {
                flowName2.setRequestRetryCount(Integer.valueOf(i3));
            }
        }
        e eVar = new e(str, aiVar, str2, str3, obj);
        a.C0715a aVar = a.C0715a.GET;
        Context e2 = f.f62644a.e();
        if (str4 != null && e2 != null) {
            this.f61098b = str4;
            com.paytm.network.b a2 = a(e2, str2, eVar, iJRPaytmDataModel, map).a(aVar);
            a2.b((Map) null);
            k.a((Object) a2, "networkCallBuilder");
            a2.b((String) null);
            a2.a(cVar2);
            a2.c(str5);
            a2.a(bVar2);
            a2.f();
            a2.b(i2);
            a2.a(i3);
            this.f61097a = a2.l();
        }
    }

    public final void a() {
        a aVar = this.f61097a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void a(String str) {
        k.c(str, "tag");
        a aVar = this.f61097a;
        if (aVar != null) {
            aVar.a((Object) str);
        }
    }

    public final void b() {
        a aVar = this.f61097a;
        if (aVar != null) {
            aVar.a(true);
        }
    }

    public final String c() {
        a aVar = this.f61097a;
        Object obj = null;
        if (!((aVar != null ? aVar.c() : null) instanceof String)) {
            return null;
        }
        a aVar2 = this.f61097a;
        if (aVar2 != null) {
            obj = aVar2.c();
        }
        if (obj != null) {
            return (String) obj;
        }
        throw new u("null cannot be cast to non-null type kotlin.String");
    }
}
