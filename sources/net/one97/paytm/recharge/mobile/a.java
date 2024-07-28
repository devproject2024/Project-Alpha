package net.one97.paytm.recharge.mobile;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.android.volley.RequestQueue;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.f.d;
import net.one97.paytm.recharge.common.utils.ac;
import net.one97.paytm.recharge.common.utils.al;
import net.one97.paytm.recharge.common.utils.ap;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.bf;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.legacy.catalog.model.v2.TopLevelCategoryHeader;
import net.one97.paytm.recharge.model.CJRInstantOperator;
import net.one97.paytm.recharge.model.CJRMNPDataModel;
import net.one97.paytm.recharge.model.mobile.CJRMadeForYouResponse;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRExtensionAttributes;
import net.one97.paytm.recharge.model.v4.CJRGroupings;
import net.one97.paytm.recharge.model.v4.CJRMetaInfo;
import net.one97.paytm.recharge.model.v4.CJRProtectionUrl;
import net.one97.paytm.recharge.model.v4.CJRUtilityButtonObjectV4;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class a extends net.one97.paytm.recharge.common.b.c.b implements c {

    /* renamed from: d  reason: collision with root package name */
    public static final C1232a f63585d = new C1232a((byte) 0);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        k.c(context, "context");
    }

    /* renamed from: net.one97.paytm.recharge.mobile.a$a  reason: collision with other inner class name */
    public static final class C1232a extends bf<a, Context> {
        private C1232a() {
            super(AnonymousClass1.INSTANCE);
        }

        public /* synthetic */ C1232a(byte b2) {
            this();
        }
    }

    public final void a(String str, ai aiVar, String str2, String str3, net.one97.paytm.recharge.common.b.a.a aVar, Object obj) {
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
            if (com.paytm.utility.b.c(this.f60907a)) {
                c cVar = c.f62654a;
                if (!c.D()) {
                    bVar.b();
                    try {
                        RequestQueue b2 = f.b(this.f60907a);
                        k.a((Object) b2, "com.paytm.network.CJRVol….getRequestQueue(context)");
                        b2.getCache().remove(d2);
                    } catch (Throwable th) {
                        CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
                    }
                }
                d.a();
                d.b(bVar);
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

    public final void e(String str, ai aiVar, String str2, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        k.c(str2, "mobileNumber");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        c cVar = c.f62654a;
        String H = c.H();
        if (!URLUtil.isValidUrl(H)) {
            if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
        } else if (com.paytm.utility.b.c(this.f60907a)) {
            Uri build = Uri.parse(H).buildUpon().appendQueryParameter("client", "androidapp").appendQueryParameter("version", com.paytm.utility.c.b(this.f60907a)).appendQueryParameter("number", str2).build();
            d.a();
            c cVar2 = c.f62654a;
            d.b(new net.one97.paytm.recharge.common.f.b(str, build.toString(), aiVar, (IJRPaytmDataModel) new CJRInstantOperator(), (Map<String, String>) null, obj, c.bU()));
        } else {
            if ((obj instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
        }
    }

    public final void f(String str, ai aiVar, String str2, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        k.c(str2, "mobileNumber");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        c cVar = c.f62654a;
        String H = c.H();
        if (!URLUtil.isValidUrl(H)) {
            if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
        } else if (com.paytm.utility.b.c(this.f60907a)) {
            Uri parse = Uri.parse(H);
            if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
                parse = Uri.parse("https://digitalproxy.paytm.com/v1/mobile/getopcirclebyrange");
            }
            String uri = parse.buildUpon().appendQueryParameter("client", "androidapp").appendQueryParameter("version", com.paytm.utility.c.b(this.f60907a)).appendQueryParameter("number", str2).build().toString();
            k.a((Object) uri, "uri.toString()");
            q.d(uri);
            c cVar2 = c.f62654a;
            net.one97.paytm.recharge.common.f.b bVar = new net.one97.paytm.recharge.common.f.b(str, uri, aiVar, (IJRPaytmDataModel) new CJRMNPDataModel((ac) null, 1, (g) null), (Map<String, String>) null, obj, c.bU());
            if (az.b(this.f60907a)) {
                if (d.a() != null) {
                    d.a();
                    d.a(this.f60907a, str);
                }
                bVar.a(str);
            }
            d.a();
            d.b(bVar);
        } else {
            if ((obj instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
        }
    }

    public final void a(String str, ai aiVar, String str2, long j, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        CRUFlowModel flowName3;
        String str3 = str;
        String str4 = str2;
        Object obj2 = obj;
        k.c(str3, "tag");
        k.c(aiVar, "responseListener");
        k.c(str4, "mobileNumber");
        ay ayVar = ay.f61523a;
        ay.a(str3, obj2);
        c cVar = c.f62654a;
        String G = c.G();
        if (!URLUtil.isValidUrl(G)) {
            if ((obj2 instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
        } else if (com.paytm.utility.b.c(this.f60907a)) {
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(CLPConstants.PRODUCT_ID, j);
                jSONObject.put("recharge_number", str4);
            } catch (Throwable th) {
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
            }
            if ((obj2 instanceof CJRRechargeErrorModel) && (flowName3 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                flowName3.setRequestBody(jSONObject.toString());
            }
            d.a();
            d.b(new net.one97.paytm.recharge.common.f.c(str, G, aiVar, new CJRMadeForYouResponse(), (Map) null, hashMap, jSONObject.toString(), (a.C0715a) null, (a.c) null, (a.b) null, (String) null, (String) null, obj, 5000, 0, 3968));
        } else {
            if ((obj2 instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x002c, code lost:
        r5 = r0.hashCode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r14, net.one97.paytm.recharge.common.e.ai r15, java.lang.String r16, java.lang.String r17, java.util.List<? extends java.util.Map<?, ?>> r18, java.util.List<? extends java.util.Map<?, ?>> r19, java.lang.Object r20) {
        /*
            r13 = this;
            r1 = r14
            java.lang.String r0 = "tag"
            kotlin.g.b.k.c(r14, r0)
            java.lang.String r0 = "responseListener"
            r2 = r15
            kotlin.g.b.k.c(r15, r0)
            java.lang.String r0 = "browsePlansCategory"
            r3 = r16
            kotlin.g.b.k.c(r3, r0)
            java.lang.String r0 = "groupingQueryParams"
            r4 = r17
            kotlin.g.b.k.c(r4, r0)
            net.one97.paytm.recharge.common.utils.ay r0 = net.one97.paytm.recharge.common.utils.ay.f61523a
            r11 = r20
            net.one97.paytm.recharge.common.utils.ay.a((java.lang.String) r14, (java.lang.Object) r11)
            r12 = r13
            android.content.Context r0 = r12.f60907a
            java.lang.String r0 = com.paytm.utility.b.b((android.content.Context) r0)
            if (r0 != 0) goto L_0x002c
            goto L_0x004e
        L_0x002c:
            int r5 = r0.hashCode()
            r6 = 1683(0x693, float:2.358E-42)
            if (r5 == r6) goto L_0x0043
            r6 = 2664213(0x28a715, float:3.733358E-39)
            if (r5 == r6) goto L_0x003a
            goto L_0x004e
        L_0x003a:
            java.lang.String r5 = "WIFI"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x004e
            goto L_0x004b
        L_0x0043:
            java.lang.String r5 = "4G"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x004e
        L_0x004b:
            r0 = 1
            r10 = 1
            goto L_0x0050
        L_0x004e:
            r0 = 0
            r10 = 0
        L_0x0050:
            r7 = 0
            r8 = 0
            r9 = 50
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r11 = r20
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.a(java.lang.String, net.one97.paytm.recharge.common.e.ai, java.lang.String, java.lang.String, java.util.List, java.util.List, java.lang.Object):void");
    }

    public final void a(String str, ai aiVar, String str2, String str3, List<? extends Map<?, ?>> list, List<? extends Map<?, ?>> list2, String str4, int i2, int i3, boolean z, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        String str5;
        CRUFlowModel flowName3;
        String str6 = str;
        String str7 = str2;
        List<? extends Map<?, ?>> list3 = list;
        List<? extends Map<?, ?>> list4 = list2;
        Object obj2 = obj;
        k.c(str, "tag");
        ai aiVar2 = aiVar;
        k.c(aiVar, "responseListener");
        k.c(str7, "browsePlansCategory");
        ay ayVar = ay.f61523a;
        ay.a(str, obj2);
        CharSequence charSequence = str7;
        if (TextUtils.isEmpty(charSequence)) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("BrowsePlan Category being BLANK");
            if (obj2 instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj2;
                CRUFlowModel flowName4 = cJRRechargeErrorModel.getFlowName();
                if (flowName4 != null) {
                    flowName4.setErrorType(ERROR_TYPE.INVALID_ARG.name());
                }
                CRUFlowModel flowName5 = cJRRechargeErrorModel.getFlowName();
                if (flowName5 != null) {
                    flowName5.setOtherDetails("BrowsePlan Api Call - Key browsePlansCategory - BrowsePlan Category being BLANK");
                }
                CJRRechargeUtilities.INSTANCE.sendEventToPaytmAnalytics(cJRRechargeErrorModel, this.f60907a);
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
            return;
        }
        String substring = str7.substring(p.a(charSequence, "/", 0, false, 6) + 1);
        k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
        if (TextUtils.isEmpty(substring) || k.a((Object) substring, (Object) str7)) {
            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("BrowsePlan Category-Id is not valid");
            if (obj2 instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel2 = (CJRRechargeErrorModel) obj2;
                CRUFlowModel flowName6 = cJRRechargeErrorModel2.getFlowName();
                if (flowName6 != null) {
                    flowName6.setErrorType(ERROR_TYPE.INVALID_ARG.name());
                }
                CRUFlowModel flowName7 = cJRRechargeErrorModel2.getFlowName();
                if (flowName7 != null) {
                    flowName7.setOtherDetails("BrowsePlan Category-Id is not valid, browsePlanCategory: " + str7 + ", categoryId: " + substring);
                }
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
            return;
        }
        String str8 = this.f60919b + "/browseplans/" + str7;
        if (URLUtil.isValidUrl(str8)) {
            StringBuilder sb = new StringBuilder(200);
            sb.append(str8);
            sb.append(com.paytm.utility.c.a(this.f60907a, false));
            sb.append("&channel=android");
            sb.append(str3);
            if (!TextUtils.isEmpty(str4)) {
                sb.append("&filter=".concat(String.valueOf(str4)));
            }
            sb.append("&pageCount=" + i2 + "&itemsPerPage=" + i3 + "&pagination=" + (z ? 1 : 0));
            c cVar = c.f62654a;
            if (c.F()) {
                StringBuilder sb2 = new StringBuilder("&sort_price=");
                sb2.append(az.b(this.f60907a) ? "asc" : "desc");
                sb.append(sb2.toString());
            }
            if (com.paytm.utility.b.c(this.f60907a)) {
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                try {
                    HashMap hashMap2 = new HashMap();
                    if (list3 != null) {
                        hashMap2.put("dynamicPlansGrouping", list3);
                    }
                    if (list4 != null) {
                        hashMap2.put("filters", list4);
                    }
                    str5 = new com.google.gsonhtcfix.f().a((Object) hashMap2);
                    k.a((Object) str5, "Gson().toJson(body)");
                } catch (Exception e2) {
                    if (obj2 instanceof CJRRechargeErrorModel) {
                        CJRRechargeErrorModel cJRRechargeErrorModel3 = (CJRRechargeErrorModel) obj2;
                        cJRRechargeErrorModel3.setErrorMsg("Unable to create plans body");
                        cJRRechargeErrorModel3.setUrl(sb.toString());
                        CRUFlowModel flowName8 = cJRRechargeErrorModel3.getFlowName();
                        if (flowName8 != null) {
                            flowName8.setTag(str);
                        }
                        cJRRechargeErrorModel3.setErrorType(ERROR_TYPE.UI_DISTORT);
                        CRUFlowModel flowName9 = cJRRechargeErrorModel3.getFlowName();
                        if (flowName9 != null) {
                            flowName9.setErrorType(ERROR_TYPE.UI_DISTORT.name());
                        }
                        az azVar = az.f61525a;
                        az.a(cJRRechargeErrorModel3, (Throwable) e2);
                    }
                    str5 = "{}";
                }
                String str9 = str5;
                if ((obj2 instanceof CJRRechargeErrorModel) && (flowName3 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                    flowName3.setRequestBody(str9);
                }
                d.a();
                d.b(new net.one97.paytm.recharge.common.f.c(str, sb.toString(), aiVar, (IJRPaytmDataModel) new CJRBrowsePlanResponseModelV8(), (Map<String, String>) null, (Map<String, String>) hashMap, str9, obj));
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

    public final void a(String str, ai aiVar, String str2, JSONObject jSONObject, String str3, String[] strArr, List<? extends Map<?, ?>> list, List<? extends Map<?, ?>> list2, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        CRUFlowModel flowName3;
        String str4 = str;
        String str5 = str2;
        JSONObject jSONObject2 = jSONObject;
        String str6 = str3;
        String[] strArr2 = strArr;
        Object obj2 = obj;
        k.c(str4, "tag");
        k.c(aiVar, "responseListener");
        k.c(str5, "browsePlansCategory");
        k.c(jSONObject2, "filters");
        k.c(str6, "query");
        k.c(strArr2, "searchKeys");
        ay ayVar = ay.f61523a;
        ay.a(str4, obj2);
        CharSequence charSequence = str5;
        if (TextUtils.isEmpty(charSequence)) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("BrowsePlan Category being BLANK");
            if (obj2 instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj2;
                CRUFlowModel flowName4 = cJRRechargeErrorModel.getFlowName();
                if (flowName4 != null) {
                    flowName4.setErrorType(ERROR_TYPE.INVALID_ARG.name());
                }
                CRUFlowModel flowName5 = cJRRechargeErrorModel.getFlowName();
                if (flowName5 != null) {
                    flowName5.setOtherDetails("BrowsePlanSearch Api Call - Key browsePlansCategory - BrowsePlan Category being BLANK");
                }
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
            return;
        }
        String substring = str5.substring(p.a(charSequence, "/", 0, false, 6) + 1);
        k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
        if (TextUtils.isEmpty(substring) || k.a((Object) substring, (Object) str5)) {
            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("BrowsePlan Category-Id is not valid");
            if (obj2 instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel2 = (CJRRechargeErrorModel) obj2;
                CRUFlowModel flowName6 = cJRRechargeErrorModel2.getFlowName();
                if (flowName6 != null) {
                    flowName6.setErrorType(ERROR_TYPE.INVALID_ARG.name());
                }
                CRUFlowModel flowName7 = cJRRechargeErrorModel2.getFlowName();
                if (flowName7 != null) {
                    flowName7.setOtherDetails("BrowsePlan Category-Id is not valid, browsePlanCategory: " + str5 + ", categoryId: " + substring);
                }
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
            return;
        }
        String str7 = this.f60919b + "/browseplans/search";
        if (URLUtil.isValidUrl(str7)) {
            String d2 = ba.d(str7 + com.paytm.utility.c.a(this.f60907a, false));
            k.a((Object) d2, "RechargeUtils.addDefaultRechargeParams(url)");
            if (com.paytm.utility.b.c(this.f60907a)) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("categoryId", substring);
                if (jSONObject2.has("filters")) {
                    Object obj3 = jSONObject2.get("filters");
                    if ((obj3 instanceof JSONArray) && list2 != null) {
                        for (Map jSONObject4 : list2) {
                            ((JSONArray) obj3).put(new JSONObject(jSONObject4));
                        }
                    }
                }
                Iterator<String> keys = jSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject3.put(next, jSONObject2.get(next));
                    }
                }
                if (list != null) {
                    jSONObject3.put("dynamicPlansGrouping", new JSONArray(list));
                }
                jSONObject3.put("query", str6);
                JSONArray jSONArray = new JSONArray();
                for (String put : strArr2) {
                    jSONArray.put(put);
                }
                jSONObject3.put("searchKeys", jSONArray);
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                if ((obj2 instanceof CJRRechargeErrorModel) && (flowName3 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                    flowName3.setRequestBody(jSONObject3.toString());
                }
                d.a();
                d.b(new net.one97.paytm.recharge.common.f.c(str, d2, aiVar, (IJRPaytmDataModel) new CJRBrowsePlanSearchModelV8(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject3.toString(), obj));
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

    public final void a(String str, ai aiVar, String str2, long j, String str3, String str4, Object obj, boolean z) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        CRUFlowModel flowName3;
        String str5 = str;
        ai aiVar2 = aiVar;
        long j2 = j;
        String str6 = str3;
        String str7 = str4;
        Object obj2 = obj;
        k.c(str5, "tag");
        k.c(aiVar2, "responseListener");
        k.c(str2, "categoryId");
        k.c(str6, "mobileNumber");
        ay ayVar = ay.f61523a;
        ay.a(str5, obj2);
        c cVar = c.f62654a;
        String c2 = z ? c.c(str2) : c.E();
        if (URLUtil.isValidUrl(c2)) {
            String a2 = com.paytm.utility.d.a(this.f60907a);
            if (TextUtils.isEmpty(a2)) {
                if ((obj2 instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                    flowName2.setErrorType(ERROR_TYPE.AUTH.name());
                }
                aiVar.a(str, 0, (IJRPaytmDataModel) null, new al(new net.one97.paytm.recharge.common.utils.c()), obj);
            } else if (com.paytm.utility.b.c(this.f60907a)) {
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                k.a((Object) a2, "ssoToken");
                hashMap.put(AppConstants.SSO_TOKEN, a2);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(CLPConstants.PRODUCT_ID, j2);
                    jSONObject2.put("qty", 1);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("recharge_number", str6);
                    if ((TextUtils.isEmpty(str6) || j2 == 0) && (obj2 instanceof CJRRechargeErrorModel)) {
                        CRUFlowModel flowName4 = ((CJRRechargeErrorModel) obj2).getFlowName();
                        if (flowName4 != null) {
                            flowName4.setErrorType(ERROR_TYPE.INVALID_ARG.name());
                        }
                        CRUFlowModel flowName5 = ((CJRRechargeErrorModel) obj2).getFlowName();
                        if (flowName5 != null) {
                            flowName5.setOtherDetails("Arguments : recharge_number: " + str6 + ", product_id: " + j2);
                        }
                        CJRRechargeUtilities.INSTANCE.sendEventToPaytmAnalytics((CJRRechargeErrorModel) obj2, this.f60907a);
                    }
                    if (!TextUtils.isEmpty(str7)) {
                        jSONObject3.put("price", str7);
                    } else {
                        jSONObject3.put("price", "100");
                    }
                    jSONObject2.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject3);
                    jSONArray.put(jSONObject2);
                    jSONObject.put("cart_items", jSONArray);
                } catch (Throwable th) {
                    CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
                }
                if (obj2 instanceof HashMap) {
                    Object obj3 = ((Map) obj2).get("hawkEyeModel");
                    if (obj3 instanceof CJRRechargeErrorModel) {
                        CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj3;
                        cJRRechargeErrorModel.setUrl(com.paytm.utility.b.P(c2));
                        CRUFlowModel flowName6 = cJRRechargeErrorModel.getFlowName();
                        if (flowName6 != null) {
                            flowName6.setRequestBody(jSONObject.toString());
                        }
                    }
                }
                net.one97.paytm.recharge.common.f.c cVar2 = new net.one97.paytm.recharge.common.f.c(str, c2, (ai) new b(aiVar2), (IJRPaytmDataModel) new CJRRechargeCart(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), obj);
                String str8 = ba.f61539a;
                k.a((Object) str8, "RechargeUtils.VOLLEY_REQ_TAG");
                cVar2.a(str8);
                d.a();
                d.b(cVar2);
            } else {
                if ((obj2 instanceof CJRRechargeErrorModel) && (flowName3 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                    flowName3.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
                }
                aiVar.a(str, 0, (IJRPaytmDataModel) null, new al(new as(false, 1, (g) null)), obj);
            }
        } else {
            if ((obj2 instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new al(new ap()), obj);
        }
    }

    public static final class b implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ai f63591a;

        b(ai aiVar) {
            this.f63591a = aiVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            this.f63591a.a(str, 0, (IJRPaytmDataModel) null, new al(networkCustomError), obj);
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            this.f63591a.a_(str, iJRPaytmDataModel, obj);
        }
    }
}
