package net.one97.paytm.recharge.common.b.c;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.android.volley.RequestQueue;
import com.paytm.network.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.CLPConstants;
import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.a.z;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.af;
import net.one97.paytm.recharge.common.utils.ao;
import net.one97.paytm.recharge.common.utils.ap;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.bf;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.catalog.model.v2.TopLevelCategoryHeader;
import net.one97.paytm.recharge.model.CJRDynamicBrowsePlans;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRExtensionAttributes;
import net.one97.paytm.recharge.model.v4.CJRGroupings;
import net.one97.paytm.recharge.model.v4.CJRMetaInfo;
import net.one97.paytm.recharge.model.v4.CJRProductList;
import net.one97.paytm.recharge.model.v4.CJRProductsItemMap;
import net.one97.paytm.recharge.model.v4.CJRProtectionUrl;
import net.one97.paytm.recharge.model.v4.CJRUtilityButtonObjectV4;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f60918c = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    protected String f60919b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        k.c(context, "context");
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        String B = net.one97.paytm.recharge.di.helper.c.B();
        this.f60919b = B == null ? "" : B;
    }

    public static final class a extends bf<b, Context> {
        private a() {
            super(AnonymousClass1.INSTANCE);
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(String str, ai aiVar, JSONObject jSONObject, String str2, String str3, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        String str4 = str;
        String str5 = str2;
        Object obj2 = obj;
        k.c(str4, "tag");
        k.c(aiVar, "responseListener");
        k.c(str5, "categoryId");
        ay ayVar = ay.f61523a;
        ay.a(str4, obj2);
        a();
        if (URLUtil.isValidUrl(this.f60919b)) {
            String a2 = a(str5);
            if (a2.charAt(a2.length() - 1) != '/') {
                a2 = a2 + "/";
            }
            String s = com.paytm.utility.b.s(this.f60907a, a2 + "getproductlist");
            k.a((Object) s, "CJRAppCommonUtility.addD…thoutSSO(context, newUrl)");
            String d2 = ba.d(s);
            k.a((Object) d2, "RechargeUtils.addDefaultRechargeParams(newUrl)");
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("REQUEST_ID", str3 == null ? "" : str3);
            net.one97.paytm.recharge.common.f.c cVar = new net.one97.paytm.recharge.common.f.c(str, d2, aiVar, new CJRProductList((CJRMetaInfo) null, (List) null, 3, (g) null), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject != null ? jSONObject.toString() : null, obj);
            cVar.a(false);
            if (com.paytm.utility.b.c(this.f60907a)) {
                a(this.f60907a, d2, cVar);
                return;
            }
            if ((obj2 instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
            return;
        }
        if ((obj2 instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
            flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
        }
        aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
    }

    public void a(String str, ai aiVar, String str2, String str3, net.one97.paytm.recharge.common.b.a.a aVar, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        String str4 = str;
        String str5 = str2;
        Object obj2 = obj;
        k.c(str4, "tag");
        k.c(aiVar, "responseListener");
        k.c(str5, "categoryId");
        ay ayVar = ay.f61523a;
        ay.a(str4, obj2);
        a();
        if (URLUtil.isValidUrl(this.f60919b)) {
            String a2 = a(str5);
            if (a2.charAt(a2.length() - 1) != '/') {
                a2 = a2 + "/";
            }
            String s = com.paytm.utility.b.s(this.f60907a, a2 + "getcategory");
            k.a((Object) s, "CJRAppCommonUtility.addD…thoutSSO(context, newUrl)");
            String d2 = ba.d(s);
            k.a((Object) d2, "RechargeUtils.addDefaultRechargeParams(newUrl)");
            Map hashMap = new HashMap();
            hashMap.put("REQUEST_ID", str3 == null ? "" : str3);
            net.one97.paytm.recharge.common.f.b bVar = new net.one97.paytm.recharge.common.f.b(str, d2, aiVar, new CJRCategoryData((List) null, (Integer) null, (Integer) null, (Integer) null, (List) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (CJRProtectionUrl) null, (Object) null, (Integer) null, (CJRUtilityButtonObjectV4) null, (Integer) null, (Integer) null, (String) null, (TopLevelCategoryHeader) null, (String) null, (String) null, (String) null, (Long) null, (List) null, (Integer) null, (String) null, (Object) null, (String) null, (CJRMetaInfo) null, (Integer) null, (CJRGroupings) null, (String) null, (List) null, (String) null, (String) null, (CJRExtensionAttributes) null, (CJRCategoryData) null, (Map) null, 0, 0, (List) null, 0, 0, -1, 4095, (g) null), hashMap, obj);
            if (!com.paytm.utility.b.c(this.f60907a)) {
                if ((obj2 instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                    flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
                }
                aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
                return;
            }
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            if (!net.one97.paytm.recharge.di.helper.c.aR()) {
                bVar.b();
                a(this.f60907a, d2, bVar);
                return;
            }
            net.one97.paytm.recharge.common.f.d.a();
            net.one97.paytm.recharge.common.f.d.b(bVar);
            return;
        }
        if ((obj2 instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
            flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
        }
        aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
    }

    public final void a(String str, ai aiVar, String str2, String str3, long j, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        String str4 = str;
        String str5 = str3;
        Object obj2 = obj;
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        k.c(str5, "rechargeNumber");
        ay ayVar = ay.f61523a;
        ay.a(str, obj2);
        a();
        if (URLUtil.isValidUrl(this.f60919b)) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Map map = hashMap;
            map.put("content-type", "application/json");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("recharge_number", str5);
                jSONObject.put(CLPConstants.PRODUCT_ID, j);
            } catch (JSONException unused) {
            }
            String jSONObject2 = jSONObject.toString();
            net.one97.paytm.recharge.common.f.c cVar = new net.one97.paytm.recharge.common.f.c(str, str2, aiVar, (IJRPaytmDataModel) new CJRDynamicBrowsePlans(), (Map<String, String>) hashMap2, (Map<String, String>) map, jSONObject2, obj);
            if (com.paytm.utility.b.c(this.f60907a)) {
                net.one97.paytm.recharge.common.f.d.a();
                net.one97.paytm.recharge.common.f.d.b(cVar);
                return;
            }
            if ((obj2 instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
            return;
        }
        if ((obj2 instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
            flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
        }
        aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
    }

    public final void a(String str, ai aiVar, String str2, String str3, String str4, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        k.c(str2, "categoryId");
        k.c(str3, "productId");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        a();
        if (URLUtil.isValidUrl(this.f60919b)) {
            String a2 = a(str2);
            String s = com.paytm.utility.b.s(this.f60907a, a2 + "/getproduct/" + str3);
            k.a((Object) s, "CJRAppCommonUtility.addD…thoutSSO(context, newUrl)");
            String d2 = ba.d(s);
            k.a((Object) d2, "RechargeUtils.addDefaultRechargeParams(newUrl)");
            Map hashMap = new HashMap();
            if (str4 == null) {
                str4 = "";
            }
            hashMap.put("REQUEST_ID", str4);
            net.one97.paytm.recharge.common.f.b bVar = new net.one97.paytm.recharge.common.f.b(str, d2, new d(aiVar), new CJRProductsItemMap(), hashMap, obj);
            if (com.paytm.utility.b.c(this.f60907a)) {
                net.one97.paytm.recharge.common.f.d.a();
                net.one97.paytm.recharge.common.f.d.b(bVar);
                return;
            }
            if ((obj instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
            return;
        }
        if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
            flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
        }
        aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
    }

    public static final class d implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ai f60924a;

        d(ai aiVar) {
            this.f60924a = aiVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            this.f60924a.a(str, 0, (IJRPaytmDataModel) null, new ao(networkCustomError), obj);
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            this.f60924a.a_(str, iJRPaytmDataModel, obj);
        }
    }

    private final void a() {
        if (p.a("", this.f60919b, true)) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            String B = net.one97.paytm.recharge.di.helper.c.B();
            if (B == null) {
                B = "";
            }
            this.f60919b = B;
        }
    }

    public final void b(String str, ai aiVar, JSONObject jSONObject, String str2, String str3, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        String str4;
        String str5 = str;
        String str6 = str2;
        Object obj2 = obj;
        k.c(str5, "tag");
        k.c(aiVar, "responseListener");
        k.c(jSONObject, "body");
        k.c(str6, "categoryId");
        ay ayVar = ay.f61523a;
        ay.a(str5, obj2);
        a();
        if (URLUtil.isValidUrl(this.f60919b)) {
            String a2 = a(str6);
            if (a2.charAt(a2.length() - 1) != '/') {
                a2 = a2 + "/";
            }
            String s = com.paytm.utility.b.s(this.f60907a, a2 + "grouping");
            k.a((Object) s, "CJRAppCommonUtility.addD…thoutSSO(context, newUrl)");
            String d2 = ba.d(s);
            k.a((Object) d2, "RechargeUtils.addDefaultRechargeParams(newUrl)");
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            String str7 = "";
            hashMap.put("REQUEST_ID", str3 == null ? str7 : str3);
            IJRPaytmDataModel cJRCategoryData = new CJRCategoryData((List) null, (Integer) null, (Integer) null, (Integer) null, (List) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (CJRProtectionUrl) null, (Object) null, (Integer) null, (CJRUtilityButtonObjectV4) null, (Integer) null, (Integer) null, (String) null, (TopLevelCategoryHeader) null, (String) null, (String) null, (String) null, (Long) null, (List) null, (Integer) null, (String) null, (Object) null, (String) null, (CJRMetaInfo) null, (Integer) null, (CJRGroupings) null, (String) null, (List) null, (String) null, (String) null, (CJRExtensionAttributes) null, (CJRCategoryData) null, (Map) null, 0, 0, (List) null, 0, 0, -1, 4095, (g) null);
            String jSONObject2 = jSONObject.toString();
            String jSONObject3 = jSONObject.toString();
            k.a((Object) jSONObject3, "body.toString()");
            af afVar = af.f61498a;
            if (!TextUtils.isEmpty(af.a(jSONObject3))) {
                CharSequence charSequence = d2;
                if (p.a(charSequence, (CharSequence) "?", false)) {
                    int a3 = p.a(charSequence, "?", 0, false, 6);
                    int length = d2.length();
                    if (d2 != null) {
                        str4 = d2.substring(a3, length);
                        k.a((Object) str4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    str4 = d2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str4);
                sb.append("&encryptedKey=");
                af afVar2 = af.f61498a;
                sb.append(af.a(jSONObject3));
                str7 = sb.toString();
            }
            net.one97.paytm.recharge.common.f.c cVar = new net.one97.paytm.recharge.common.f.c(str, d2, aiVar, cJRCategoryData, (Map<String, String>) hashMap, jSONObject2, str7, obj);
            if (com.paytm.utility.b.c(this.f60907a)) {
                net.one97.paytm.recharge.common.f.d.a();
                net.one97.paytm.recharge.common.f.d.b(cVar);
                return;
            }
            if ((obj2 instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
            return;
        }
        if ((obj2 instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
            flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
        }
        aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
    }

    /* access modifiers changed from: protected */
    public final String a(String str) {
        k.c(str, "categoryId");
        a();
        if (!URLUtil.isValidUrl(this.f60919b)) {
            return "";
        }
        return this.f60919b + "/category/" + str;
    }

    /* renamed from: net.one97.paytm.recharge.common.b.c.b$b  reason: collision with other inner class name */
    static final class C1176b<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f60920a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f60921b;

        C1176b(b bVar, String str) {
            this.f60920a = bVar;
            this.f60921b = str;
        }

        public final void subscribe(z<String> zVar) {
            k.a((Object) zVar, "emitter");
            if (!zVar.isDisposed()) {
                b.a(this.f60920a, this.f60921b);
                zVar.onSuccess("");
            }
        }
    }

    private final void a(Context context, String str, net.one97.paytm.recharge.common.f.a aVar) {
        y.a(new C1176b(this, str)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new c(context, aVar));
    }

    public static final class c implements aa<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f60922a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.recharge.common.f.a f60923b;

        public final void onError(Throwable th) {
            k.c(th, "e");
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            k.c(cVar, "d");
        }

        c(Context context, net.one97.paytm.recharge.common.f.a aVar) {
            this.f60922a = context;
            this.f60923b = aVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            k.c((String) obj, "t");
            net.one97.paytm.recharge.common.f.d.a();
            net.one97.paytm.recharge.common.f.d.b(this.f60923b);
        }
    }

    public static final /* synthetic */ void a(b bVar, String str) {
        try {
            RequestQueue b2 = f.b(bVar.f60907a);
            k.a((Object) b2, "com.paytm.network.CJRVol….getRequestQueue(context)");
            b2.getCache().remove(str);
        } catch (Throwable th) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
        }
    }
}
