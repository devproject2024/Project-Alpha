package net.one97.paytm.recharge.common.f;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.di.f;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;

public final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public b f61099a;

    /* renamed from: b  reason: collision with root package name */
    private a f61100b;

    /* renamed from: c  reason: collision with root package name */
    private String f61101c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public c(String str, String str2, ai aiVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, Map<String, String> map2, String str3, Object obj) {
        this(str, str2, aiVar, iJRPaytmDataModel, map, map2, str3, a.C0715a.POST, a.c.RECHARGES, a.b.SILENT, SDKConstants.NATIVE_SDK_NONE, (String) null, obj, 0, 0, 24576);
        k.c(str, "tag");
        k.c(aiVar, "listener");
        k.c(iJRPaytmDataModel, "model");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public c(String str, String str2, ai aiVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, String str3, String str4, Object obj) {
        this(str, str2, aiVar, iJRPaytmDataModel, map, str3, a.C0715a.POST, str4, obj);
        k.c(str, "tag");
        k.c(aiVar, "listener");
        k.c(iJRPaytmDataModel, "model");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public c(String str, String str2, ai aiVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, String str3, a.c cVar, a.b bVar, String str4, Object obj) {
        this(str, str2, aiVar, iJRPaytmDataModel, (Map) null, map, str3, a.C0715a.POST, cVar, bVar, str4, (String) null, obj, 0, 0, 24576);
        k.c(str, "tag");
        k.c(aiVar, "listener");
        k.c(iJRPaytmDataModel, "model");
        k.c(cVar, "verticalId");
        k.c(bVar, "userfacing");
        k.c(str4, SDKConstants.EVENT_KEY_SCREEN_NAME);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public c(String str, String str2, ai aiVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, String str3, a.C0715a aVar, Object obj) {
        this(str, str2, aiVar, iJRPaytmDataModel, (Map) null, map, str3, aVar, a.c.RECHARGES, a.b.SILENT, "None", (String) null, obj, 0, 0, 24576);
        k.c(str, "tag");
        k.c(aiVar, "listener");
        k.c(iJRPaytmDataModel, "model");
        k.c(aVar, "httpRequestMethod");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private c(String str, String str2, ai aiVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, String str3, a.C0715a aVar, String str4, Object obj) {
        this(str, str2, aiVar, iJRPaytmDataModel, (Map) null, map, str3, aVar, a.c.RECHARGES, a.b.SILENT, "None", str4, obj, 0, 0, 24576);
        k.c(str, "tag");
        k.c(aiVar, "listener");
        k.c(iJRPaytmDataModel, "model");
        k.c(aVar, "httpRequestMethod");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ c(java.lang.String r20, java.lang.String r21, net.one97.paytm.recharge.common.e.ai r22, com.paytm.network.model.IJRPaytmDataModel r23, java.util.Map r24, java.util.Map r25, java.lang.String r26, com.paytm.network.a.C0715a r27, com.paytm.network.a.c r28, com.paytm.network.a.b r29, java.lang.String r30, java.lang.String r31, java.lang.Object r32, int r33, int r34, int r35) {
        /*
            r19 = this;
            r0 = r35
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r8 = r2
            goto L_0x000b
        L_0x0009:
            r8 = r24
        L_0x000b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0011
            r9 = r2
            goto L_0x0013
        L_0x0011:
            r9 = r25
        L_0x0013:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0019
            r10 = r2
            goto L_0x001b
        L_0x0019:
            r10 = r26
        L_0x001b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0023
            com.paytm.network.a$a r1 = com.paytm.network.a.C0715a.POST
            r11 = r1
            goto L_0x0025
        L_0x0023:
            r11 = r27
        L_0x0025:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x002d
            com.paytm.network.a$c r1 = com.paytm.network.a.c.RECHARGES
            r12 = r1
            goto L_0x002f
        L_0x002d:
            r12 = r28
        L_0x002f:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0037
            com.paytm.network.a$b r1 = com.paytm.network.a.b.SILENT
            r13 = r1
            goto L_0x0039
        L_0x0037:
            r13 = r29
        L_0x0039:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0041
            java.lang.String r1 = "None"
            r14 = r1
            goto L_0x0043
        L_0x0041:
            r14 = r30
        L_0x0043:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0049
            r15 = r2
            goto L_0x004b
        L_0x0049:
            r15 = r31
        L_0x004b:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0052
            r16 = r2
            goto L_0x0054
        L_0x0052:
            r16 = r32
        L_0x0054:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x005f
            r1 = 60000(0xea60, float:8.4078E-41)
            r17 = 60000(0xea60, float:8.4078E-41)
            goto L_0x0061
        L_0x005f:
            r17 = r33
        L_0x0061:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0069
            r0 = 1
            r18 = 1
            goto L_0x006b
        L_0x0069:
            r18 = r34
        L_0x006b:
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r23
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.f.c.<init>(java.lang.String, java.lang.String, net.one97.paytm.recharge.common.e.ai, com.paytm.network.model.IJRPaytmDataModel, java.util.Map, java.util.Map, java.lang.String, com.paytm.network.a$a, com.paytm.network.a$c, com.paytm.network.a$b, java.lang.String, java.lang.String, java.lang.Object, int, int, int):void");
    }

    private c(String str, String str2, ai aiVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, Map<String, String> map2, String str3, a.C0715a aVar, a.c cVar, a.b bVar, String str4, String str5, Object obj, int i2, int i3) {
        String str6 = str2;
        a.C0715a aVar2 = aVar;
        a.c cVar2 = cVar;
        a.b bVar2 = bVar;
        String str7 = str4;
        Object obj2 = obj;
        String str8 = str;
        k.c(str, "tag");
        k.c(aiVar, "listener");
        k.c(iJRPaytmDataModel, "model");
        k.c(aVar2, "methodType");
        k.c(cVar2, "vertical");
        k.c(bVar2, "userfacing");
        k.c(str7, SDKConstants.EVENT_KEY_SCREEN_NAME);
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
        e eVar = new e(str, aiVar, str2, str4, obj);
        Context e2 = f.f62644a.e();
        if (str6 != null && e2 != null) {
            this.f61101c = str6;
            b a2 = a(e2, str2, eVar, iJRPaytmDataModel, map2).a(aVar2);
            a2.b((Map) map);
            k.a((Object) a2, "networkCallBuilder");
            a2.b(str3);
            a2.a(cVar2);
            a2.c(str7);
            a2.a(bVar2);
            a2.b(i2);
            a2.a(i3);
            a2.f();
            a2.d(str5);
            this.f61099a = a2;
            this.f61100b = a2.l();
        }
    }

    public final void a() {
        a aVar = this.f61100b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void a(String str) {
        k.c(str, "tag");
        a aVar = this.f61100b;
        if (aVar != null && aVar != null) {
            aVar.a((Object) str);
        }
    }

    public final String b() {
        a aVar = this.f61100b;
        Object obj = null;
        if (!((aVar != null ? aVar.c() : null) instanceof String)) {
            return null;
        }
        a aVar2 = this.f61100b;
        if (aVar2 != null) {
            obj = aVar2.c();
        }
        if (obj != null) {
            return (String) obj;
        }
        throw new u("null cannot be cast to non-null type kotlin.String");
    }

    public final void a(boolean z) {
        a aVar = this.f61100b;
        if (aVar != null) {
            aVar.a(!z);
        }
    }

    public final String c() {
        b bVar = this.f61099a;
        if (bVar == null) {
            k.a("mCJRCommonNetworkCallBuilder");
        }
        if (bVar != null) {
            return bVar.e();
        }
        return null;
    }
}
