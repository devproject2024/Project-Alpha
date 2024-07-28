package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.gson.f;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.a;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.k.e;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRCashWalletResponse;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.catalog.model.v2.CJRUtilityCheckboxItem;
import net.one97.paytm.recharge.model.CJRCheckoutRequestModel;
import net.one97.paytm.recharge.model.CJRPersonalInsurance;
import net.one97.paytm.recharge.model.ContactItemModel;
import net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse;
import net.one97.paytm.recharge.model.rechargeutility.CJRSetUserConsentApiResponse;
import net.one97.paytm.recharge.model.rechargeutility.UnsubscribeApiResponse;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.model.v4.CJRMyBillData;
import net.one97.paytm.recharge.model.v4.CJRMyBillDataError;
import net.one97.paytm.recharge.model.v4.CJRMyBillDetails;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ALERT_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class w implements FetchPayOptionsListener, ai {

    /* renamed from: a  reason: collision with root package name */
    public CJRRechargeCart f61781a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f61782b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61783c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61784d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61785e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61786f;

    /* renamed from: g  reason: collision with root package name */
    public e<x> f61787g;

    /* renamed from: h  reason: collision with root package name */
    public e<x> f61788h;

    /* renamed from: i  reason: collision with root package name */
    public net.one97.paytm.recharge.common.b.c f61789i;
    public x j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public boolean o;
    public String p = "";
    public Context q;
    private CJRRechargePayment r;
    private String s;
    private JSONArray t;
    private Map<String, String> u;
    private CJRRechargeErrorModel v;

    public void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
        k.c(cJPayMethodResponse, "cjPayMethodResponse");
    }

    public void onRequestStart() {
    }

    public void onVpaReceived(VpaFetch vpaFetch) {
        k.c(vpaFetch, "vpaFetch");
    }

    public w(Context context) {
        this.q = context;
    }

    public final void a() {
        this.f61787g = null;
        this.f61788h = null;
        this.f61789i = null;
        x xVar = this.j;
        if (xVar != null) {
            xVar.f61812a = null;
        }
        this.j = null;
        this.f61781a = null;
        this.r = null;
    }

    public static /* synthetic */ JSONObject a(Map map, Map map2, JSONObject jSONObject, String str, List list, CJRPersonalInsurance cJRPersonalInsurance, int i2) {
        if ((i2 & 512) != 0) {
            cJRPersonalInsurance = null;
        }
        return a(map, map2, jSONObject, str, list, (String) null, (String) null, cJRPersonalInsurance, (o) null);
    }

    private static JSONObject a(Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, String str, List<CJRProductsItem> list, String str2, String str3, CJRPersonalInsurance cJRPersonalInsurance, o oVar) {
        JSONObject jSONObject2;
        Map<String, String> metaData;
        Set<String> keySet;
        String checkBoxKey;
        Map<String, String> map3 = map;
        Map<String, String> map4 = map2;
        JSONObject jSONObject3 = jSONObject;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        k.c(map3, "productIdAmountMap");
        k.c(jSONObject3, "metaData");
        k.c(str4, CJRQRScanResultModel.KEY_TOTAL_AMOUNT);
        JSONObject jSONObject4 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (!(!map.isEmpty())) {
            return null;
        }
        int size = map.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            JSONObject jSONObject5 = new JSONObject();
            int i4 = size;
            Object[] array = map.keySet().toArray(new String[i2]);
            if (array != null) {
                String str7 = ((String[]) array)[i3];
                jSONObject5.put(CLPConstants.PRODUCT_ID, str7);
                Integer valueOf = Integer.valueOf(str7);
                k.a((Object) valueOf, "Integer.valueOf(productId)");
                CJRUtilityCheckboxItem a2 = a((List<CJRUtilityCheckboxItem>) null, valueOf.intValue());
                Integer valueOf2 = Integer.valueOf(str7);
                k.a((Object) valueOf2, "Integer.valueOf(productId)");
                CJRProductsItem b2 = b(list, valueOf2.intValue());
                jSONObject5.put("qty", 1);
                if (map4 == null) {
                    jSONObject2 = new JSONObject();
                }
                jSONObject2.put("price", map3.get(str7));
                jSONObject2.put("totalamount", str4);
                jSONObject5.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject2);
                JSONObject jSONObject6 = new JSONObject();
                if (!(b2 == null || (checkBoxKey = b2.getCheckBoxKey()) == null)) {
                    if (checkBoxKey.length() > 0) {
                        jSONObject6.put("checkBoxKey", b2.getCheckBoxKey());
                    }
                }
                if (((a2 == null || (metaData = a2.getMetaData()) == null || (keySet = metaData.keySet()) == null) ? 0 : keySet.size()) > 0) {
                    if (a2 == null) {
                        k.a();
                    }
                    for (String next : a2.getMetaData().keySet()) {
                        jSONObject6.put(next, a2.getMetaData().get(next));
                    }
                }
                JSONArray names = jSONObject.names();
                if ((names != null ? names.length() : 0) > 0) {
                    int length = jSONObject.names().length();
                    for (int i5 = 0; i5 < length; i5++) {
                        jSONObject6.put(jSONObject.names().get(i5).toString(), jSONObject3.get(jSONObject.names().get(i5).toString()));
                    }
                }
                jSONObject5.put("meta_data", jSONObject6);
                jSONArray.put(jSONObject5);
                i3++;
                size = i4;
                i2 = 0;
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        if (cJRPersonalInsurance != null) {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put(CLPConstants.PRODUCT_ID, cJRPersonalInsurance.getProductID());
            jSONObject7.put("qty", 1);
            try {
                String b3 = new f().b(cJRPersonalInsurance.getMetaDataInsurance());
                if (!TextUtils.isEmpty(b3)) {
                    jSONObject7.put("meta_data", new JSONObject(b3));
                }
            } catch (Throwable th) {
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
            }
            jSONArray.put(jSONObject7);
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        jSONObject4.put("cart_items", jSONArray);
        if (g.c((String) null)) {
            jSONObject4.put("payment_method", (Object) null);
        }
        if (!TextUtils.isEmpty(str5)) {
            jSONObject4.put("payment_request_type", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            jSONObject4.put(Utility.EVENT_CATEGORY_PROMOCODE, str6);
            if (oVar != null && !TextUtils.isEmpty(oVar.d())) {
                jSONObject4.put("payment_intent", oVar.d());
            }
        }
        return jSONObject4;
    }

    public static /* synthetic */ void a(w wVar, String str, Map map, Map map2, JSONObject jSONObject, String str2, boolean z, boolean z2, boolean z3, String str3, List list, Object obj, String str4, CJRPersonalInsurance cJRPersonalInsurance, o oVar) {
        w wVar2 = wVar;
        Object obj2 = obj;
        String str5 = str;
        k.c(str, "tag");
        k.c(map, "productIdAmountMap");
        k.c(jSONObject, "metaData");
        k.c(str2, CJRQRScanResultModel.KEY_TOTAL_AMOUNT);
        k.c(str3, SDKConstants.EVENT_KEY_SCREEN_NAME);
        if (!wVar2.k) {
            wVar2.l = z2;
            wVar2.f61783c = true;
            wVar2.f61784d = z;
            wVar2.f61785e = z3;
            JSONObject a2 = a(map, map2, jSONObject, str2, list, (String) null, str4, cJRPersonalInsurance, oVar);
            if (a2 != null) {
                if (a2.opt(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS) instanceof JSONObject) {
                    Object obj3 = a2.get(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
                    if (obj3 != null) {
                        wVar2.f61782b = (JSONObject) obj3;
                    } else {
                        throw new u("null cannot be cast to non-null type org.json.JSONObject");
                    }
                }
                az azVar = az.f61525a;
                wVar2.n = az.a(a2);
                y yVar = y.f61814b;
                y.a(a2);
                if (obj2 instanceof CJRRechargeErrorModel) {
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    String a3 = net.one97.paytm.recharge.widgets.c.d.a(a2);
                    CRUFlowModel flowName = ((CJRRechargeErrorModel) obj2).getFlowName();
                    if (flowName != null) {
                        flowName.setRequestBody(a3);
                    }
                }
                net.one97.paytm.recharge.common.b.c cVar = wVar2.f61789i;
                if (cVar != null) {
                    cVar.a(str, wVar2, a2, str3, a.b.USER_FACING, obj, 0, true);
                    return;
                }
                return;
            }
            Context context = wVar2.q;
            String str6 = null;
            String string = context != null ? context.getString(R.string.operator_unavailable_tittle) : null;
            Context context2 = wVar2.q;
            if (context2 != null) {
                str6 = context2.getString(R.string.product_not_available);
            }
            wVar.a(str, 0, (IJRPaytmDataModel) null, (NetworkCustomError) new ae(string, str6), obj);
        }
    }

    public final void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, String str2, boolean z, boolean z2, String str3, List<CJRProductsItem> list, Object obj, String str4, String str5, CJRPersonalInsurance cJRPersonalInsurance, o oVar, ai aiVar) {
        Object obj2 = obj;
        k.c(str, "tag");
        k.c(map, "productIdAmountMap");
        k.c(jSONObject, "metaData");
        k.c(str2, CJRQRScanResultModel.KEY_TOTAL_AMOUNT);
        k.c(str3, SDKConstants.EVENT_KEY_SCREEN_NAME);
        if (!this.k) {
            this.l = z;
            this.f61783c = true;
            this.f61784d = false;
            this.f61785e = z2;
            JSONObject a2 = a(map, map2, jSONObject, str2, list, str4, str5, cJRPersonalInsurance, oVar);
            if (a2 != null) {
                if (a2.opt(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS) instanceof JSONObject) {
                    Object obj3 = a2.get(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
                    if (obj3 != null) {
                        this.f61782b = (JSONObject) obj3;
                    } else {
                        throw new u("null cannot be cast to non-null type org.json.JSONObject");
                    }
                }
                az azVar = az.f61525a;
                this.n = az.a(a2);
                y yVar = y.f61814b;
                y.a(a2);
                if (obj2 instanceof CJRRechargeErrorModel) {
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    String a3 = net.one97.paytm.recharge.widgets.c.d.a(a2);
                    CRUFlowModel flowName = ((CJRRechargeErrorModel) obj2).getFlowName();
                    if (flowName != null) {
                        flowName.setRequestBody(a3);
                    }
                }
                net.one97.paytm.recharge.common.b.c cVar = this.f61789i;
                if (cVar != null) {
                    cVar.a(str, aiVar == null ? this : aiVar, a2, str3, a.b.USER_FACING, obj, 0, true);
                    return;
                }
                return;
            }
            String str6 = null;
            if (aiVar == null) {
                Context context = this.q;
                String string = context != null ? context.getString(R.string.operator_unavailable_tittle) : null;
                Context context2 = this.q;
                if (context2 != null) {
                    str6 = context2.getString(R.string.product_not_available);
                }
                a(str, 0, (IJRPaytmDataModel) null, (NetworkCustomError) new ae(string, str6), obj);
                return;
            }
            Context context3 = this.q;
            String string2 = context3 != null ? context3.getString(R.string.operator_unavailable_tittle) : null;
            Context context4 = this.q;
            if (context4 != null) {
                str6 = context4.getString(R.string.product_not_available);
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new ae(string2, str6), obj);
        }
    }

    public final void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, String str2, String str3, boolean z, boolean z2, boolean z3, List<CJRUtilityCheckboxItem> list, boolean z4, String str4, List<CJRProductsItem> list2, Object obj, String str5, String str6, ai aiVar) {
        String str7;
        StringBuilder journeyStackTrace;
        JSONObject jSONObject2;
        Map<String, String> metaData;
        Set<String> keySet;
        String checkBoxKey;
        List b2;
        Map<String, String> map3 = map;
        Map<String, String> map4 = map2;
        JSONObject jSONObject3 = jSONObject;
        String str8 = str2;
        String str9 = str3;
        boolean z5 = z;
        Object obj2 = obj;
        String str10 = str5;
        String str11 = str6;
        k.c(str, "tag");
        k.c(map3, "productIdAmountMap");
        k.c(jSONObject3, "metaData");
        k.c(str8, CJRQRScanResultModel.KEY_TOTAL_AMOUNT);
        k.c(str4, SDKConstants.EVENT_KEY_SCREEN_NAME);
        if (!this.k) {
            this.l = z3;
            this.f61783c = z5;
            this.f61784d = z2;
            this.f61785e = z4;
            JSONObject jSONObject4 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (str9 == null || (b2 = p.a((CharSequence) str9, new String[]{" "})) == null) {
                str7 = null;
            } else {
                Iterator it2 = b2.iterator();
                if (it2.hasNext()) {
                    Object next = it2.next();
                    while (it2.hasNext()) {
                        next = ((String) next) + " " + ((String) it2.next());
                        it2 = it2;
                        String str12 = str4;
                    }
                    str7 = (String) next;
                } else {
                    throw new UnsupportedOperationException("Empty collection can't be reduced.");
                }
            }
            String.valueOf(str7);
            if (!map.isEmpty()) {
                w wVar = this;
                int size = map.size();
                int i2 = 0;
                while (i2 < size) {
                    JSONObject jSONObject5 = new JSONObject();
                    int i3 = size;
                    Object[] array = map.keySet().toArray(new String[0]);
                    if (array != null) {
                        String str13 = ((String[]) array)[i2];
                        jSONObject5.put(CLPConstants.PRODUCT_ID, str13);
                        Integer valueOf = Integer.valueOf(str13);
                        k.a((Object) valueOf, "Integer.valueOf(productId)");
                        CJRUtilityCheckboxItem a2 = a(list, valueOf.intValue());
                        Integer valueOf2 = Integer.valueOf(str13);
                        k.a((Object) valueOf2, "Integer.valueOf(productId)");
                        CJRProductsItem b3 = b(list2, valueOf2.intValue());
                        jSONObject5.put("qty", 1);
                        if (map4 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        jSONObject2.put("price", map3.get(str13));
                        jSONObject2.put("totalamount", str8);
                        jSONObject5.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject2);
                        JSONObject jSONObject6 = new JSONObject();
                        if (b3 != null && (checkBoxKey = b3.getCheckBoxKey()) != null) {
                            if (checkBoxKey.length() > 0) {
                                jSONObject6.put("checkBoxKey", b3.getCheckBoxKey());
                            }
                        }
                        if (((a2 == null || (metaData = a2.getMetaData()) == null || (keySet = metaData.keySet()) == null) ? 0 : keySet.size()) > 0) {
                            if (a2 == null) {
                                k.a();
                            }
                            for (String next2 : a2.getMetaData().keySet()) {
                                jSONObject6.put(next2, a2.getMetaData().get(next2));
                            }
                        }
                        JSONArray names = jSONObject.names();
                        if ((names != null ? names.length() : 0) > 0) {
                            int length = jSONObject.names().length();
                            for (int i4 = 0; i4 < length; i4++) {
                                jSONObject6.put(jSONObject.names().get(i4).toString(), jSONObject3.get(jSONObject.names().get(i4).toString()));
                            }
                        }
                        jSONObject5.put("meta_data", jSONObject6);
                        jSONArray.put(jSONObject5);
                        i2++;
                        boolean z6 = z;
                        Object obj3 = obj;
                        String str14 = str6;
                        size = i3;
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                if (jSONArray.length() == 0) {
                    Context context = wVar.q;
                    String string = context != null ? context.getString(R.string.operator_unavailable_tittle) : null;
                    Context context2 = wVar.q;
                    wVar.a(str, 0, (IJRPaytmDataModel) null, (NetworkCustomError) new ae(string, context2 != null ? context2.getString(R.string.product_not_available) : null), obj);
                    return;
                }
                jSONObject4.put("cart_items", jSONArray);
                if (g.c(str3)) {
                    jSONObject4.put("payment_method", str9);
                }
                if (!TextUtils.isEmpty(str10)) {
                    jSONObject4.put("payment_request_type", str10);
                }
                String str15 = str6;
                if (!TextUtils.isEmpty(str15)) {
                    jSONObject4.put(Utility.EVENT_CATEGORY_PROMOCODE, str15);
                }
                if (jSONObject4.opt(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS) instanceof JSONObject) {
                    Object obj4 = jSONObject4.get(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
                    if (obj4 != null) {
                        wVar.f61782b = (JSONObject) obj4;
                    } else {
                        throw new u("null cannot be cast to non-null type org.json.JSONObject");
                    }
                }
                az azVar = az.f61525a;
                wVar.n = az.a(jSONObject4);
                y yVar = y.f61814b;
                y.a(jSONObject4);
                Object obj5 = obj;
                if (obj5 instanceof CJRRechargeErrorModel) {
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    String a3 = net.one97.paytm.recharge.widgets.c.d.a(jSONObject4);
                    CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj5;
                    CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
                    if (flowName != null) {
                        flowName.setRequestBody(a3);
                    }
                    if (z) {
                        String str16 = " - isFastForward - " + wVar.f61784d;
                        CRUFlowModel flowName2 = cJRRechargeErrorModel.getFlowName();
                        if (!(flowName2 == null || (journeyStackTrace = flowName2.getJourneyStackTrace()) == null)) {
                            journeyStackTrace.append(str16);
                        }
                    }
                }
                net.one97.paytm.recharge.common.b.c cVar = wVar.f61789i;
                if (cVar != null) {
                    cVar.a(str, aiVar == null ? wVar : aiVar, jSONObject4, str4, a.b.USER_FACING, obj, 0, true);
                    return;
                }
                return;
            }
            Object obj6 = obj2;
            Context context3 = this.q;
            String string2 = context3 != null ? context3.getString(R.string.operator_unavailable_tittle) : null;
            Context context4 = this.q;
            a(str, 0, (IJRPaytmDataModel) null, (NetworkCustomError) new ae(string2, context4 != null ? context4.getString(R.string.product_not_available) : null), obj);
        }
    }

    public final void a(JSONArray jSONArray, String str) {
        this.t = jSONArray;
        this.s = str;
    }

    public static /* synthetic */ void a(w wVar, JSONArray jSONArray, Object obj, int i2) {
        if ((i2 & 1) != 0) {
            jSONArray = null;
        }
        if ((i2 & 2) != 0) {
            obj = null;
        }
        wVar.a(jSONArray, obj);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x00a2: MOVE  (r4v5 java.util.Collection) = 
          (r4v4 java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRCartProduct>)
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0129  */
    private void a(org.json.JSONArray r11, java.lang.Object r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            java.lang.String r1 = ""
            r2 = 0
            if (r0 == 0) goto L_0x008e
            boolean r3 = r10.f61783c
            if (r3 == 0) goto L_0x0016
            net.one97.paytm.recharge.widgets.c.d r3 = net.one97.paytm.recharge.widgets.c.d.f64967a
            r3 = r12
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.FINAL_VERIFY_CALL_SUCCESSFUL
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r4)
            goto L_0x0020
        L_0x0016:
            net.one97.paytm.recharge.widgets.c.d r3 = net.one97.paytm.recharge.widgets.c.d.f64967a
            r3 = r12
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.VERIFY_CALL_SUCCESSFUL
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r4)
        L_0x0020:
            r3 = r12
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r3.getFlowName()
            if (r4 == 0) goto L_0x002e
            java.lang.StringBuilder r4 = r4.getJourneyStackTrace()
            goto L_0x002f
        L_0x002e:
            r4 = r2
        L_0x002f:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r5 = r3.getFlowName()
            if (r5 == 0) goto L_0x003e
            java.lang.String r5 = r5.getAlertType()
            goto L_0x003f
        L_0x003e:
            r5 = r2
        L_0x003f:
            net.one97.paytm.recharge.widgets.c.d r6 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r6 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r2)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r7 = r6.getFlowName()
            if (r7 == 0) goto L_0x0054
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r8 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r8 = r8.name()
            r7.setErrorType(r8)
        L_0x0054:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r7 = r6.getFlowName()
            if (r7 == 0) goto L_0x0060
            if (r5 != 0) goto L_0x005d
            r5 = r1
        L_0x005d:
            r7.setAlertType(r5)
        L_0x0060:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r5 = r6.getFlowName()
            if (r5 == 0) goto L_0x0075
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r3.getFlowName()
            if (r3 == 0) goto L_0x0071
            java.lang.String r3 = r3.getActionType()
            goto L_0x0072
        L_0x0071:
            r3 = r2
        L_0x0072:
            r5.setActionType(r3)
        L_0x0075:
            r3 = r4
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x008f
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r6.getFlowName()
            if (r3 == 0) goto L_0x008f
            java.lang.StringBuilder r3 = r3.getJourneyStackTrace()
            if (r3 == 0) goto L_0x008f
            r3.append(r4)
            goto L_0x008f
        L_0x008e:
            r6 = r2
        L_0x008f:
            r3 = 1
            if (r11 == 0) goto L_0x00f2
            net.one97.paytm.common.entity.CJRRechargeCart r4 = r10.f61781a     // Catch:{ Exception -> 0x00f1 }
            if (r4 == 0) goto L_0x00f2
            net.one97.paytm.common.entity.shopping.CJRCart r4 = r4.getCart()     // Catch:{ Exception -> 0x00f1 }
            if (r4 == 0) goto L_0x00f2
            java.util.ArrayList r4 = r4.getCartItems()     // Catch:{ Exception -> 0x00f1 }
            if (r4 == 0) goto L_0x00f2
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ Exception -> 0x00f1 }
            if (r4 == 0) goto L_0x00f2
            boolean r5 = r4.isEmpty()     // Catch:{ Exception -> 0x00f1 }
            r5 = r5 ^ r3
            if (r5 == 0) goto L_0x00f2
            java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ Exception -> 0x00f1 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00f1 }
        L_0x00b3:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x00f1 }
            if (r5 == 0) goto L_0x00f2
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x00f1 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r5 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r5     // Catch:{ Exception -> 0x00f1 }
            if (r5 == 0) goto L_0x00b3
            java.lang.Object r7 = r5.getMetaDataResponse()     // Catch:{ Exception -> 0x00f1 }
            if (r7 == 0) goto L_0x00b3
            com.google.gson.f r7 = new com.google.gson.f     // Catch:{ Exception -> 0x00f1 }
            r7.<init>()     // Catch:{ Exception -> 0x00f1 }
            java.lang.Object r8 = r5.getMetaDataResponse()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r7 = r7.b(r8)     // Catch:{ Exception -> 0x00f1 }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f1 }
            r8.<init>(r7)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r7 = "key"
            r8.put(r7, r11)     // Catch:{ Exception -> 0x00f1 }
            com.google.gson.f r7 = new com.google.gson.f     // Catch:{ Exception -> 0x00f1 }
            r7.<init>()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00f1 }
            java.lang.Class<java.lang.Object> r9 = java.lang.Object.class
            java.lang.Object r7 = r7.a((java.lang.String) r8, r9)     // Catch:{ Exception -> 0x00f1 }
            r5.setMetaDataResponse(r7)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x00b3
        L_0x00f1:
        L_0x00f2:
            java.lang.String r11 = r10.n
            r4 = 0
            if (r11 == 0) goto L_0x010e
            android.content.Context r5 = r10.q
            if (r5 == 0) goto L_0x0106
            net.one97.paytm.common.entity.CJRRechargeCart r7 = r10.f61781a
            boolean r11 = net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r5, (java.lang.String) r11, (net.one97.paytm.common.entity.CJRRechargeCart) r7)
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            goto L_0x0107
        L_0x0106:
            r11 = r2
        L_0x0107:
            if (r11 == 0) goto L_0x010e
            boolean r11 = r11.booleanValue()
            goto L_0x010f
        L_0x010e:
            r11 = 0
        L_0x010f:
            boolean r5 = r10.l
            if (r5 == 0) goto L_0x0129
            kotlin.k.e<kotlin.x> r11 = r10.f61787g
            if (r11 == 0) goto L_0x0128
            kotlin.g.a.b r11 = (kotlin.g.a.b) r11
            net.one97.paytm.recharge.model.v4.CJRInstruct$openAutomaticAddNewBill r12 = new net.one97.paytm.recharge.model.v4.CJRInstruct$openAutomaticAddNewBill
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r10.f61781a
            if (r0 != 0) goto L_0x0122
            kotlin.g.b.k.a()
        L_0x0122:
            r12.<init>(r0)
            r11.invoke(r12)
        L_0x0128:
            return
        L_0x0129:
            boolean r5 = r10.f61783c
            if (r5 != 0) goto L_0x0143
            kotlin.k.e<kotlin.x> r11 = r10.f61787g
            if (r11 == 0) goto L_0x0142
            kotlin.g.a.b r11 = (kotlin.g.a.b) r11
            net.one97.paytm.recharge.model.v4.CJRInstruct$showNotMandatoryFields r12 = new net.one97.paytm.recharge.model.v4.CJRInstruct$showNotMandatoryFields
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r10.f61781a
            if (r0 != 0) goto L_0x013c
            kotlin.g.b.k.a()
        L_0x013c:
            r12.<init>(r0)
            r11.invoke(r12)
        L_0x0142:
            return
        L_0x0143:
            boolean r5 = r10.f61784d
            java.lang.String r7 = " - isDeferredCheckoutFlag - "
            if (r5 == 0) goto L_0x01a1
            if (r0 == 0) goto L_0x017a
            if (r6 == 0) goto L_0x0161
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r12 = r6.getFlowName()
            if (r12 == 0) goto L_0x0161
            if (r11 == 0) goto L_0x015a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            goto L_0x015e
        L_0x015a:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
        L_0x015e:
            r12.setDeferredCheckout(r1)
        L_0x0161:
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r11 = r7.concat(r11)
            if (r6 == 0) goto L_0x017a
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r12 = r6.getFlowName()
            if (r12 == 0) goto L_0x017a
            java.lang.StringBuilder r12 = r12.getJourneyStackTrace()
            if (r12 == 0) goto L_0x017a
            r12.append(r11)
        L_0x017a:
            if (r0 == 0) goto L_0x018f
            if (r6 == 0) goto L_0x018f
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r11 = r6.getFlowName()
            if (r11 == 0) goto L_0x018f
            java.lang.StringBuilder r11 = r11.getJourneyStackTrace()
            if (r11 == 0) goto L_0x018f
            java.lang.String r12 = " - CashWalletAPI "
            r11.append(r12)
        L_0x018f:
            net.one97.paytm.recharge.widgets.c.d r11 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r11 = "cash_wallet"
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r6, (java.lang.String) r11)
            net.one97.paytm.recharge.common.b.c r12 = r10.f61789i
            if (r12 == 0) goto L_0x01a0
            r0 = r10
            net.one97.paytm.recharge.common.e.ai r0 = (net.one97.paytm.recharge.common.e.ai) r0
            r12.b(r11, r0, r6)
        L_0x01a0:
            return
        L_0x01a1:
            boolean r5 = r10.f61785e
            if (r5 == 0) goto L_0x0248
            if (r0 == 0) goto L_0x020d
            if (r6 == 0) goto L_0x01bf
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r6.getFlowName()
            if (r1 == 0) goto L_0x01bf
            boolean r2 = r10.f61785e
            if (r2 == 0) goto L_0x01b8
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            goto L_0x01bc
        L_0x01b8:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
        L_0x01bc:
            r1.setProceedDirectlyToPG(r2)
        L_0x01bf:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = " - isProceedDirectlyToPG - "
            r1.<init>(r2)
            boolean r2 = r10.f61785e
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            if (r6 == 0) goto L_0x01e5
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r6.getFlowName()
            if (r2 == 0) goto L_0x01e5
            if (r11 == 0) goto L_0x01de
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x01e2
        L_0x01de:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
        L_0x01e2:
            r2.setDeferredCheckout(r3)
        L_0x01e5:
            java.lang.String r2 = java.lang.String.valueOf(r11)
            java.lang.String r2 = r7.concat(r2)
            if (r6 == 0) goto L_0x020d
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r6.getFlowName()
            if (r3 == 0) goto L_0x020d
            java.lang.StringBuilder r3 = r3.getJourneyStackTrace()
            if (r3 == 0) goto L_0x020d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            r5.append(r2)
            java.lang.String r1 = r5.toString()
            r3.append(r1)
        L_0x020d:
            if (r11 == 0) goto L_0x021a
            net.one97.paytm.common.entity.CJRRechargeCart r11 = r10.f61781a
            if (r11 != 0) goto L_0x0216
            kotlin.g.b.k.a()
        L_0x0216:
            r10.a((net.one97.paytm.common.entity.CJRRechargeCart) r11, (java.lang.Object) r6)
            return
        L_0x021a:
            r10.f61786f = r4
            if (r0 == 0) goto L_0x023a
            if (r6 == 0) goto L_0x0231
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r11 = r6.getFlowName()
            if (r11 == 0) goto L_0x0231
            java.lang.StringBuilder r11 = r11.getJourneyStackTrace()
            if (r11 == 0) goto L_0x0231
            java.lang.String r0 = " - WalletTokenAPI "
            r11.append(r0)
        L_0x0231:
            net.one97.paytm.recharge.widgets.c.d r11 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r12 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r12
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r11 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.WALLET_TOKEN
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r12, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r11)
        L_0x023a:
            net.one97.paytm.recharge.common.b.c r11 = r10.f61789i
            if (r11 == 0) goto L_0x0247
            r12 = r10
            net.one97.paytm.recharge.common.e.ai r12 = (net.one97.paytm.recharge.common.e.ai) r12
            java.lang.String r0 = "wallet_token"
            r11.a_(r0, r12, r6)
        L_0x0247:
            return
        L_0x0248:
            if (r11 == 0) goto L_0x02af
            boolean r12 = r10.m
            if (r12 == 0) goto L_0x02af
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r5 = " - isFromCoupons - "
            r12.<init>(r5)
            boolean r5 = r10.m
            r12.append(r5)
            java.lang.String r12 = r12.toString()
            if (r0 == 0) goto L_0x029e
            if (r6 == 0) goto L_0x0276
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r6.getFlowName()
            if (r0 == 0) goto L_0x0276
            if (r11 == 0) goto L_0x026f
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0273
        L_0x026f:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
        L_0x0273:
            r0.setDeferredCheckout(r3)
        L_0x0276:
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r11 = r7.concat(r11)
            if (r6 == 0) goto L_0x029e
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r6.getFlowName()
            if (r0 == 0) goto L_0x029e
            java.lang.StringBuilder r0 = r0.getJourneyStackTrace()
            if (r0 == 0) goto L_0x029e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r11)
            r3.append(r12)
            java.lang.String r11 = r3.toString()
            r0.append(r11)
        L_0x029e:
            kotlin.k.e<kotlin.x> r11 = r10.f61787g
            if (r11 == 0) goto L_0x02ae
            kotlin.g.a.b r11 = (kotlin.g.a.b) r11
            net.one97.paytm.recharge.model.v4.CJRInstruct$openRechargePaymentActivity r12 = new net.one97.paytm.recharge.model.v4.CJRInstruct$openRechargePaymentActivity
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r10.f61781a
            r12.<init>(r1, r0, r2, r6)
            r11.invoke(r12)
        L_0x02ae:
            return
        L_0x02af:
            kotlin.k.e<kotlin.x> r11 = r10.f61787g
            if (r11 == 0) goto L_0x02c6
            kotlin.g.a.b r11 = (kotlin.g.a.b) r11
            net.one97.paytm.recharge.model.v4.CJRInstruct$openCouponsActivity r12 = new net.one97.paytm.recharge.model.v4.CJRInstruct$openCouponsActivity
            net.one97.paytm.common.entity.CJRRechargeCart r2 = r10.f61781a
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r1 = ""
            r0 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r11.invoke(r12)
        L_0x02c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.w.a(org.json.JSONArray, java.lang.Object):void");
    }

    private final void a(CJRRechargeCart cJRRechargeCart, Object obj) {
        CRUFlowModel flowName;
        StringBuilder journeyStackTrace;
        if (!(!(obj instanceof CJRRechargeErrorModel) || (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) == null || (journeyStackTrace = flowName.getJourneyStackTrace()) == null)) {
            journeyStackTrace.append("- Redirect to PG Page");
        }
        az azVar = az.f61525a;
        az.a(cJRRechargeCart);
        e<x> eVar = this.f61787g;
        if (eVar != null) {
            ((kotlin.g.a.b) eVar).invoke(new CJRInstruct.openRechargePaymentActivity("", cJRRechargeCart, (CJRRechargePayment) null, obj, 4, (g) null));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0088, code lost:
        r13 = (r13 = (r13 = r13.getCart()).getCartItems()).get(0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x013a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r13, net.one97.paytm.common.entity.CJRRechargeCart r14, java.lang.Object r15) {
        /*
            r12 = this;
            java.lang.String r0 = "tag"
            kotlin.g.b.k.c(r13, r0)
            java.lang.String r0 = "cjrRechargeCart"
            kotlin.g.b.k.c(r14, r0)
            boolean r0 = r12.l
            if (r0 == 0) goto L_0x001e
            kotlin.k.e<kotlin.x> r13 = r12.f61787g
            if (r13 == 0) goto L_0x001d
            kotlin.g.a.b r13 = (kotlin.g.a.b) r13
            net.one97.paytm.recharge.model.v4.CJRInstruct$openAutomaticAddNewBill r15 = new net.one97.paytm.recharge.model.v4.CJRInstruct$openAutomaticAddNewBill
            r15.<init>(r14)
            r13.invoke(r15)
        L_0x001d:
            return
        L_0x001e:
            net.one97.paytm.common.entity.shopping.CJRCartStatus r0 = r14.getCartStatus()
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x01b1
            net.one97.paytm.common.entity.shopping.CJRCartStatus r0 = r14.getCartStatus()
            java.lang.String r4 = "cjrRechargeCart.cartStatus"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            java.lang.String r0 = r0.getResult()
            java.lang.String r4 = "SUCCESS"
            boolean r0 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r0, (boolean) r3)
            if (r0 == 0) goto L_0x01b1
            boolean r13 = r12.b((java.lang.String) r13, (net.one97.paytm.common.entity.CJRRechargeCart) r14, (java.lang.Object) r15)
            if (r13 != 0) goto L_0x02eb
            boolean r13 = r15 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r13 == 0) goto L_0x005a
            r13 = r15
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r13 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r13
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r13 = r13.getFlowName()
            if (r13 == 0) goto L_0x005a
            java.lang.StringBuilder r13 = r13.getJourneyStackTrace()
            if (r13 == 0) goto L_0x005a
            java.lang.String r0 = " - verifySuccess"
            r13.append(r0)
        L_0x005a:
            r12.f61781a = r14
            kotlin.k.e<kotlin.x> r13 = r12.f61787g
            if (r13 == 0) goto L_0x006a
            kotlin.g.a.b r13 = (kotlin.g.a.b) r13
            net.one97.paytm.recharge.model.v4.CJRInstruct$saveRechargeCart r0 = new net.one97.paytm.recharge.model.v4.CJRInstruct$saveRechargeCart
            r0.<init>(r14)
            r13.invoke(r0)
        L_0x006a:
            net.one97.paytm.recharge.di.helper.c r13 = net.one97.paytm.recharge.di.helper.c.f62654a
            boolean r13 = net.one97.paytm.recharge.di.helper.c.bb()
            if (r13 == 0) goto L_0x01a9
            boolean r13 = r12.o
            if (r13 == 0) goto L_0x01a9
            net.one97.paytm.recharge.widgets.c.d r13 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ Exception -> 0x019d }
            net.one97.paytm.common.entity.CJRRechargeCart r13 = r12.f61781a     // Catch:{ Exception -> 0x019d }
            if (r13 == 0) goto L_0x0095
            net.one97.paytm.common.entity.shopping.CJRCart r13 = r13.getCart()     // Catch:{ Exception -> 0x019d }
            if (r13 == 0) goto L_0x0095
            java.util.ArrayList r13 = r13.getCartItems()     // Catch:{ Exception -> 0x019d }
            if (r13 == 0) goto L_0x0095
            java.lang.Object r13 = r13.get(r1)     // Catch:{ Exception -> 0x019d }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r13 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r13     // Catch:{ Exception -> 0x019d }
            if (r13 == 0) goto L_0x0095
            net.one97.paytm.common.entity.shopping.CJRServiceOptions r13 = r13.getServiceOptions()     // Catch:{ Exception -> 0x019d }
            goto L_0x0096
        L_0x0095:
            r13 = r2
        L_0x0096:
            net.one97.paytm.common.entity.shopping.CJRServiceActions r13 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.common.entity.shopping.CJRServiceOptions) r13)     // Catch:{ Exception -> 0x019d }
            if (r13 == 0) goto L_0x00a1
            java.util.ArrayList r13 = r13.getGroupDisplay()     // Catch:{ Exception -> 0x019d }
            goto L_0x00a2
        L_0x00a1:
            r13 = r2
        L_0x00a2:
            java.util.List r13 = (java.util.List) r13     // Catch:{ Exception -> 0x019d }
            net.one97.paytm.recharge.di.helper.c r14 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x019d }
            boolean r14 = net.one97.paytm.recharge.di.helper.c.bz()     // Catch:{ Exception -> 0x019d }
            if (r14 == 0) goto L_0x00e0
            net.one97.paytm.common.entity.CJRRechargeCart r13 = r12.f61781a     // Catch:{ Exception -> 0x019d }
            if (r13 == 0) goto L_0x00dd
            net.one97.paytm.common.entity.shopping.CJRCart r13 = r13.getCart()     // Catch:{ Exception -> 0x019d }
            if (r13 == 0) goto L_0x00dd
            java.util.ArrayList r13 = r13.getCartItems()     // Catch:{ Exception -> 0x019d }
            if (r13 == 0) goto L_0x00dd
            java.lang.Object r13 = r13.get(r1)     // Catch:{ Exception -> 0x019d }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r13 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r13     // Catch:{ Exception -> 0x019d }
            if (r13 == 0) goto L_0x00dd
            net.one97.paytm.common.entity.shopping.CJRServiceOptions r13 = r13.getServiceOptions()     // Catch:{ Exception -> 0x019d }
            if (r13 == 0) goto L_0x00dd
            java.util.ArrayList r13 = r13.getActions()     // Catch:{ Exception -> 0x019d }
            if (r13 == 0) goto L_0x00dd
            java.lang.Object r13 = r13.get(r1)     // Catch:{ Exception -> 0x019d }
            net.one97.paytm.common.entity.shopping.CJRServiceActions r13 = (net.one97.paytm.common.entity.shopping.CJRServiceActions) r13     // Catch:{ Exception -> 0x019d }
            if (r13 == 0) goto L_0x00dd
            java.util.ArrayList r13 = r13.getGroupDisplay()     // Catch:{ Exception -> 0x019d }
            goto L_0x00de
        L_0x00dd:
            r13 = r2
        L_0x00de:
            java.util.List r13 = (java.util.List) r13     // Catch:{ Exception -> 0x019d }
        L_0x00e0:
            if (r13 == 0) goto L_0x0196
            if (r13 == 0) goto L_0x0140
            java.lang.Iterable r13 = (java.lang.Iterable) r13     // Catch:{ Exception -> 0x019d }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ Exception -> 0x019d }
        L_0x00ea:
            boolean r14 = r13.hasNext()     // Catch:{ Exception -> 0x019d }
            if (r14 == 0) goto L_0x013b
            java.lang.Object r14 = r13.next()     // Catch:{ Exception -> 0x019d }
            r0 = r14
            net.one97.paytm.common.entity.shopping.CJRGroupDisplay r0 = (net.one97.paytm.common.entity.shopping.CJRGroupDisplay) r0     // Catch:{ Exception -> 0x019d }
            if (r0 == 0) goto L_0x010a
            java.lang.String r4 = r0.getType()     // Catch:{ Exception -> 0x019d }
            if (r4 == 0) goto L_0x010a
            java.lang.String r5 = "radio"
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r5, (boolean) r3)     // Catch:{ Exception -> 0x019d }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x019d }
            goto L_0x010b
        L_0x010a:
            r4 = r2
        L_0x010b:
            if (r4 != 0) goto L_0x0110
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x019d }
        L_0x0110:
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x019d }
            if (r4 == 0) goto L_0x0137
            if (r0 == 0) goto L_0x0129
            java.lang.String r0 = r0.getPlacement()     // Catch:{ Exception -> 0x019d }
            if (r0 == 0) goto L_0x0129
            java.lang.String r4 = "bottomsheet"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r3)     // Catch:{ Exception -> 0x019d }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x019d }
            goto L_0x012a
        L_0x0129:
            r0 = r2
        L_0x012a:
            if (r0 != 0) goto L_0x012f
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x019d }
        L_0x012f:
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x019d }
            if (r0 == 0) goto L_0x0137
            r0 = 1
            goto L_0x0138
        L_0x0137:
            r0 = 0
        L_0x0138:
            if (r0 == 0) goto L_0x00ea
            goto L_0x013c
        L_0x013b:
            r14 = r2
        L_0x013c:
            r13 = r14
            net.one97.paytm.common.entity.shopping.CJRGroupDisplay r13 = (net.one97.paytm.common.entity.shopping.CJRGroupDisplay) r13     // Catch:{ Exception -> 0x019d }
            goto L_0x0141
        L_0x0140:
            r13 = r2
        L_0x0141:
            if (r13 == 0) goto L_0x018d
            if (r13 == 0) goto L_0x015a
            java.util.Map r14 = r13.getValuesMap()     // Catch:{ Exception -> 0x019d }
            if (r14 == 0) goto L_0x015a
            java.util.Set r14 = r14.keySet()     // Catch:{ Exception -> 0x019d }
            if (r14 == 0) goto L_0x015a
            int r14 = r14.size()     // Catch:{ Exception -> 0x019d }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x019d }
            goto L_0x015b
        L_0x015a:
            r14 = r2
        L_0x015b:
            if (r14 != 0) goto L_0x0160
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x019d }
        L_0x0160:
            int r14 = r14.intValue()     // Catch:{ Exception -> 0x019d }
            if (r14 <= 0) goto L_0x0186
            if (r13 == 0) goto L_0x016d
            java.util.Map r14 = r13.getValuesMap()     // Catch:{ Exception -> 0x019d }
            goto L_0x016e
        L_0x016d:
            r14 = r2
        L_0x016e:
            r12.u = r14     // Catch:{ Exception -> 0x019d }
            kotlin.k.e<kotlin.x> r14 = r12.f61787g     // Catch:{ Exception -> 0x019d }
            if (r14 == 0) goto L_0x0184
            kotlin.g.a.b r14 = (kotlin.g.a.b) r14     // Catch:{ Exception -> 0x019d }
            net.one97.paytm.recharge.model.v4.CJRInstruct$openSubscriberBottomSheet r0 = new net.one97.paytm.recharge.model.v4.CJRInstruct$openSubscriberBottomSheet     // Catch:{ Exception -> 0x019d }
            net.one97.paytm.common.entity.CJRRechargeCart r1 = r12.f61781a     // Catch:{ Exception -> 0x019d }
            r0.<init>(r1, r13)     // Catch:{ Exception -> 0x019d }
            java.lang.Object r13 = r14.invoke(r0)     // Catch:{ Exception -> 0x019d }
            kotlin.x r13 = (kotlin.x) r13     // Catch:{ Exception -> 0x019d }
            goto L_0x018b
        L_0x0184:
            r13 = r2
            goto L_0x018b
        L_0x0186:
            a((net.one97.paytm.recharge.common.utils.w) r12, (org.json.JSONArray) r2, (java.lang.Object) r15, (int) r3)     // Catch:{ Exception -> 0x019d }
            kotlin.x r13 = kotlin.x.f47997a     // Catch:{ Exception -> 0x019d }
        L_0x018b:
            if (r13 != 0) goto L_0x0195
        L_0x018d:
            r13 = r12
            net.one97.paytm.recharge.common.utils.w r13 = (net.one97.paytm.recharge.common.utils.w) r13     // Catch:{ Exception -> 0x019d }
            a((net.one97.paytm.recharge.common.utils.w) r13, (org.json.JSONArray) r2, (java.lang.Object) r15, (int) r3)     // Catch:{ Exception -> 0x019d }
            kotlin.x r13 = kotlin.x.f47997a     // Catch:{ Exception -> 0x019d }
        L_0x0195:
            return
        L_0x0196:
            r13 = r12
            net.one97.paytm.recharge.common.utils.w r13 = (net.one97.paytm.recharge.common.utils.w) r13     // Catch:{ Exception -> 0x019d }
            a((net.one97.paytm.recharge.common.utils.w) r13, (org.json.JSONArray) r2, (java.lang.Object) r15, (int) r3)     // Catch:{ Exception -> 0x019d }
            return
        L_0x019d:
            r13 = move-exception
            java.lang.String r13 = r13.getMessage()
            com.paytm.utility.q.d(r13)
            a((net.one97.paytm.recharge.common.utils.w) r12, (org.json.JSONArray) r2, (java.lang.Object) r15, (int) r3)
            return
        L_0x01a9:
            org.json.JSONArray r13 = r12.t
            r12.a((org.json.JSONArray) r13, (java.lang.Object) r15)
            r12.t = r2
            return
        L_0x01b1:
            android.content.Context r0 = r12.q
            if (r0 == 0) goto L_0x01c2
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x01c2
            int r4 = net.one97.paytm.recharge.R.string.network_error_message_re
            java.lang.String r0 = r0.getString(r4)
            goto L_0x01c3
        L_0x01c2:
            r0 = r2
        L_0x01c3:
            net.one97.paytm.common.entity.CJRRechargeCart r4 = r12.f61781a
            r5 = 32
            java.lang.String r6 = ""
            if (r4 == 0) goto L_0x0234
            net.one97.paytm.common.entity.shopping.CJRCartStatus r4 = r4.getCartStatus()
            if (r4 == 0) goto L_0x0234
            com.paytm.network.model.CJRError r4 = r4.getMessage()
            if (r4 == 0) goto L_0x0234
            java.lang.String r4 = r4.getMessage()
            if (r4 == 0) goto L_0x0234
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r7 = r4.length()
            int r7 = r7 - r3
            r8 = r7
            r7 = 0
            r9 = 0
        L_0x01e7:
            if (r7 > r8) goto L_0x0205
            if (r9 != 0) goto L_0x01ed
            r10 = r7
            goto L_0x01ee
        L_0x01ed:
            r10 = r8
        L_0x01ee:
            char r10 = r4.charAt(r10)
            if (r10 > r5) goto L_0x01f6
            r10 = 1
            goto L_0x01f7
        L_0x01f6:
            r10 = 0
        L_0x01f7:
            if (r9 != 0) goto L_0x0200
            if (r10 != 0) goto L_0x01fd
            r9 = 1
            goto L_0x01e7
        L_0x01fd:
            int r7 = r7 + 1
            goto L_0x01e7
        L_0x0200:
            if (r10 == 0) goto L_0x0205
            int r8 = r8 + -1
            goto L_0x01e7
        L_0x0205:
            int r8 = r8 + r3
            java.lang.CharSequence r4 = r4.subSequence(r7, r8)
            java.lang.String r4 = r4.toString()
            if (r4 == 0) goto L_0x0234
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x021a
            r4 = 1
            goto L_0x021b
        L_0x021a:
            r4 = 0
        L_0x021b:
            if (r4 != r3) goto L_0x0234
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r12.f61781a
            if (r0 == 0) goto L_0x0233
            net.one97.paytm.common.entity.shopping.CJRCartStatus r0 = r0.getCartStatus()
            if (r0 == 0) goto L_0x0233
            com.paytm.network.model.CJRError r0 = r0.getMessage()
            if (r0 == 0) goto L_0x0233
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L_0x0234
        L_0x0233:
            r0 = r6
        L_0x0234:
            android.content.Context r4 = r12.q
            if (r4 == 0) goto L_0x023f
            int r7 = net.one97.paytm.recharge.R.string.network_error_heading_re
            java.lang.String r4 = r4.getString(r7)
            goto L_0x0240
        L_0x023f:
            r4 = r2
        L_0x0240:
            net.one97.paytm.common.entity.CJRRechargeCart r7 = r12.f61781a
            if (r7 == 0) goto L_0x02ae
            net.one97.paytm.common.entity.shopping.CJRCartStatus r7 = r7.getCartStatus()
            if (r7 == 0) goto L_0x02ae
            com.paytm.network.model.CJRError r7 = r7.getMessage()
            if (r7 == 0) goto L_0x02ae
            java.lang.String r7 = r7.getTitle()
            if (r7 == 0) goto L_0x02ae
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r8 = r7.length()
            int r8 = r8 - r3
            r9 = r8
            r8 = 0
            r10 = 0
        L_0x0260:
            if (r8 > r9) goto L_0x027e
            if (r10 != 0) goto L_0x0266
            r11 = r8
            goto L_0x0267
        L_0x0266:
            r11 = r9
        L_0x0267:
            char r11 = r7.charAt(r11)
            if (r11 > r5) goto L_0x026f
            r11 = 1
            goto L_0x0270
        L_0x026f:
            r11 = 0
        L_0x0270:
            if (r10 != 0) goto L_0x0279
            if (r11 != 0) goto L_0x0276
            r10 = 1
            goto L_0x0260
        L_0x0276:
            int r8 = r8 + 1
            goto L_0x0260
        L_0x0279:
            if (r11 == 0) goto L_0x027e
            int r9 = r9 + -1
            goto L_0x0260
        L_0x027e:
            int r9 = r9 + r3
            java.lang.CharSequence r5 = r7.subSequence(r8, r9)
            java.lang.String r5 = r5.toString()
            if (r5 == 0) goto L_0x02ae
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x0292
            r1 = 1
        L_0x0292:
            if (r1 != r3) goto L_0x02ae
            net.one97.paytm.common.entity.CJRRechargeCart r1 = r12.f61781a
            if (r1 == 0) goto L_0x02ad
            net.one97.paytm.common.entity.shopping.CJRCartStatus r1 = r1.getCartStatus()
            if (r1 == 0) goto L_0x02ad
            com.paytm.network.model.CJRError r1 = r1.getMessage()
            if (r1 == 0) goto L_0x02ad
            java.lang.String r1 = r1.getTitle()
            if (r1 != 0) goto L_0x02ab
            goto L_0x02ad
        L_0x02ab:
            r4 = r1
            goto L_0x02ae
        L_0x02ad:
            r4 = r6
        L_0x02ae:
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r14.getCart()
            if (r1 == 0) goto L_0x02db
            java.lang.String r1 = r1.getPromoFailureText()
            if (r1 == 0) goto L_0x02db
            boolean r1 = net.one97.paytm.recharge.common.utils.g.c(r1)
            if (r1 != r3) goto L_0x02db
            android.content.Context r0 = r12.q
            if (r0 == 0) goto L_0x02ca
            int r1 = net.one97.paytm.recharge.R.string.msg_invalid_recharge_promo_code
            java.lang.String r2 = r0.getString(r1)
        L_0x02ca:
            r4 = r2
            net.one97.paytm.common.entity.shopping.CJRCart r14 = r14.getCart()
            if (r14 == 0) goto L_0x02da
            java.lang.String r14 = r14.getPromoFailureText()
            if (r14 != 0) goto L_0x02d8
            goto L_0x02da
        L_0x02d8:
            r0 = r14
            goto L_0x02db
        L_0x02da:
            r0 = r6
        L_0x02db:
            r7 = 0
            r8 = 0
            net.one97.paytm.recharge.common.utils.ae r14 = new net.one97.paytm.recharge.common.utils.ae
            r14.<init>(r4, r0)
            r9 = r14
            com.paytm.network.model.NetworkCustomError r9 = (com.paytm.network.model.NetworkCustomError) r9
            r5 = r12
            r6 = r13
            r10 = r15
            r5.a((java.lang.String) r6, (int) r7, (com.paytm.network.model.IJRPaytmDataModel) r8, (com.paytm.network.model.NetworkCustomError) r9, (java.lang.Object) r10)
        L_0x02eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.w.a(java.lang.String, net.one97.paytm.common.entity.CJRRechargeCart, java.lang.Object):void");
    }

    private final void a(String str, CJRPGTokenList cJRPGTokenList, Object obj) {
        CRUFlowModel flowName;
        StringBuilder journeyStackTrace;
        CJRRechargeErrorModel cJRRechargeErrorModel;
        CJRCart cart;
        ArrayList<CJRCartProduct> cartItems;
        CJRCartProduct cJRCartProduct;
        StringBuilder journeyStackTrace2;
        CRUFlowModel flowName2;
        StringBuilder journeyStackTrace3;
        String str2;
        String pgToken = CJRRechargeUtilities.INSTANCE.getPgToken(cJRPGTokenList);
        CharSequence charSequence = pgToken;
        if (!(charSequence == null || charSequence.length() == 0)) {
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel2 = (CJRRechargeErrorModel) obj;
                CRUFlowModel flowName3 = cJRRechargeErrorModel2.getFlowName();
                String valueOf = String.valueOf(flowName3 != null ? flowName3.getJourneyStackTrace() : null);
                ACTION_TYPE.Companion companion = ACTION_TYPE.Companion;
                CRUFlowModel flowName4 = cJRRechargeErrorModel2.getFlowName();
                ACTION_TYPE actionType = companion.getActionType(flowName4 != null ? flowName4.getActionType() : null, ACTION_TYPE.CHECKOUT);
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a(actionType, ERROR_TYPE.UNDEFINED);
                CRUFlowModel flowName5 = a2.getFlowName();
                if (flowName5 != null) {
                    CRUFlowModel flowName6 = cJRRechargeErrorModel2.getFlowName();
                    if (flowName6 == null || (str2 = flowName6.getAlertType()) == null) {
                        str2 = ALERT_TYPE.PROCEED_TO_PG.name();
                    }
                    flowName5.setAlertType(str2);
                }
                if (!(TextUtils.isEmpty(valueOf) || (flowName2 = a2.getFlowName()) == null || (journeyStackTrace3 = flowName2.getJourneyStackTrace()) == null)) {
                    journeyStackTrace3.append(valueOf);
                }
                CRUFlowModel flowName7 = a2.getFlowName();
                if (!(flowName7 == null || (journeyStackTrace2 = flowName7.getJourneyStackTrace()) == null)) {
                    journeyStackTrace2.append(" - WalletTokenResponse success");
                }
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                net.one97.paytm.recharge.widgets.c.d.a(a2, ACTION_TYPE.GET_WALLET_TOKEN_SUCCESSFUL);
                net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                net.one97.paytm.recharge.widgets.c.d.a(a2, ACTION_TYPE.CHECKOUT);
                cJRRechargeErrorModel = a2;
            } else {
                cJRRechargeErrorModel = null;
            }
            x.e eVar = new x.e();
            eVar.element = null;
            try {
                CJRRechargeCart cJRRechargeCart = this.f61781a;
                Map configurationList = (cJRRechargeCart == null || (cart = cJRRechargeCart.getCart()) == null || (cartItems = cart.getCartItems()) == null || (cJRCartProduct = cartItems.get(0)) == null) ? null : cJRCartProduct.getConfigurationList();
                if (configurationList == null) {
                    k.a();
                }
                eVar.element = (String) configurationList.get("recharge_number");
            } catch (Exception unused) {
            }
            if (com.paytm.utility.b.c((String) eVar.element)) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(new b(this, eVar, str, pgToken, cJRRechargeErrorModel));
                return;
            }
            CJRRechargeCart cJRRechargeCart2 = this.f61781a;
            if (cJRRechargeCart2 != null) {
                aw awVar = aw.f61520a;
                CJRCheckoutRequestModel a3 = aw.a(cJRRechargeCart2, (String) null, (String) null, 6);
                net.one97.paytm.recharge.widgets.c.d dVar4 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                a(str, pgToken, a3, net.one97.paytm.recharge.widgets.c.d.a(this.q, (String) null, (String) null), (Object) cJRRechargeErrorModel);
                return;
            }
            return;
        }
        if (!(!(obj instanceof CJRRechargeErrorModel) || (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) == null || (journeyStackTrace = flowName.getJourneyStackTrace()) == null)) {
            journeyStackTrace.append(" tokenList is null");
        }
        a(str, 0, (IJRPaytmDataModel) null, (NetworkCustomError) new bd(new NetworkCustomError()), obj);
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f61799a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f61800b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f61801c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f61802d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f61803e;

        b(w wVar, x.e eVar, String str, String str2, Object obj) {
            this.f61799a = wVar;
            this.f61800b = eVar;
            this.f61801c = str;
            this.f61802d = str2;
            this.f61803e = obj;
        }

        public final void run() {
            x.e eVar = new x.e();
            n nVar = n.f61679a;
            String str = (String) this.f61800b.element;
            if (str == null) {
                k.a();
            }
            ContactItemModel a2 = n.a(str);
            eVar.element = a2 != null ? a2.getName() : null;
            if (TextUtils.isEmpty((String) eVar.element)) {
                eVar.element = ab.a(this.f61799a.q, (String) this.f61800b.element);
            }
            CJRRechargeCart cJRRechargeCart = this.f61799a.f61781a;
            if (cJRRechargeCart != null) {
                aw awVar = aw.f61520a;
                CJRCheckoutRequestModel a3 = aw.a(cJRRechargeCart, (String) eVar.element, (String) null, 4);
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                new Handler(Looper.getMainLooper()).post(new a(a3, net.one97.paytm.recharge.widgets.c.d.a(this.f61799a.q, (String) eVar.element, (String) this.f61800b.element), this, eVar));
            }
        }

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CJRCheckoutRequestModel f61804a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f61805b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ b f61806c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ x.e f61807d;

            a(CJRCheckoutRequestModel cJRCheckoutRequestModel, String str, b bVar, x.e eVar) {
                this.f61804a = cJRCheckoutRequestModel;
                this.f61805b = str;
                this.f61806c = bVar;
                this.f61807d = eVar;
            }

            public final void run() {
                this.f61806c.f61799a.a(this.f61806c.f61801c, this.f61806c.f61802d, this.f61804a, this.f61805b, this.f61806c.f61803e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r13, java.lang.String r14, net.one97.paytm.recharge.model.CJRCheckoutRequestModel r15, java.lang.String r16, java.lang.Object r17) {
        /*
            r12 = this;
            r0 = r12
            r11 = r17
            java.lang.String r1 = r0.n
            if (r1 == 0) goto L_0x001e
            android.content.Context r2 = r0.q
            if (r2 == 0) goto L_0x0016
            net.one97.paytm.common.entity.CJRRechargeCart r3 = r0.f61781a
            boolean r1 = net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r2, (java.lang.String) r1, (net.one97.paytm.common.entity.CJRRechargeCart) r3)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            if (r1 == 0) goto L_0x001e
            boolean r1 = r1.booleanValue()
            goto L_0x001f
        L_0x001e:
            r1 = 0
        L_0x001f:
            boolean r2 = r0.f61786f
            if (r2 != 0) goto L_0x002d
            if (r1 == 0) goto L_0x002d
            net.one97.paytm.common.entity.CJRRechargeCart r1 = r0.f61781a
            if (r1 == 0) goto L_0x002c
            r12.a((net.one97.paytm.common.entity.CJRRechargeCart) r1, (java.lang.Object) r11)
        L_0x002c:
            return
        L_0x002d:
            boolean r1 = r11 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r1 == 0) goto L_0x0058
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
            org.json.JSONObject r1 = r15.getMetaData()
            java.lang.String r1 = net.one97.paytm.recharge.widgets.c.d.a((org.json.JSONObject) r1)
            r2 = r11
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r2
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r2.getFlowName()
            if (r3 == 0) goto L_0x0047
            r3.setRequestBody(r1)
        L_0x0047:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r2.getFlowName()
            if (r1 == 0) goto L_0x0058
            java.lang.StringBuilder r1 = r1.getJourneyStackTrace()
            if (r1 == 0) goto L_0x0058
            java.lang.String r2 = " - checkoutApiCall"
            r1.append(r2)
        L_0x0058:
            net.one97.paytm.recharge.common.b.c r1 = r0.f61789i
            if (r1 == 0) goto L_0x007d
            r4 = r0
            net.one97.paytm.recharge.common.e.ai r4 = (net.one97.paytm.recharge.common.e.ai) r4
            java.lang.String r5 = r15.getRechargeNumber()
            java.lang.String r6 = r15.getRechargeUserName()
            boolean r7 = r0.f61784d
            org.json.JSONObject r8 = r15.getMetaData()
            if (r8 != 0) goto L_0x0072
            kotlin.g.b.k.a()
        L_0x0072:
            boolean r9 = r0.f61786f
            r2 = r13
            r3 = r14
            r10 = r16
            r11 = r17
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.w.a(java.lang.String, java.lang.String, net.one97.paytm.recharge.model.CJRCheckoutRequestModel, java.lang.String, java.lang.Object):void");
    }

    private final void a(String str, CJRRechargePayment cJRRechargePayment, Object obj) {
        Resources resources;
        Resources resources2;
        CJRRechargeErrorModel cJRRechargeErrorModel;
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        StringBuilder journeyStackTrace;
        CJRRechargePayment cJRRechargePayment2 = cJRRechargePayment;
        Object obj2 = obj;
        String str2 = null;
        if (p.a(cJRRechargePayment2 != null ? cJRRechargePayment.getStatus() : null, "SUCCESS", true)) {
            e<kotlin.x> eVar = this.f61787g;
            if (eVar != null) {
                ((kotlin.g.a.b) eVar).invoke(new CJRInstruct.saveRechargePayment(cJRRechargePayment2));
            }
            boolean z = obj2 instanceof CJRRechargeErrorModel;
            if (z) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel cJRRechargeErrorModel2 = (CJRRechargeErrorModel) obj2;
                net.one97.paytm.recharge.widgets.c.d.a(cJRRechargeErrorModel2, ACTION_TYPE.CHECKOUT_SUCCESSFUL);
                CRUFlowModel flowName3 = cJRRechargeErrorModel2.getFlowName();
                if (!(flowName3 == null || (journeyStackTrace = flowName3.getJourneyStackTrace()) == null)) {
                    journeyStackTrace.append(" - checkout response success");
                }
            }
            if (this.f61786f) {
                e<kotlin.x> eVar2 = this.f61787g;
                if (eVar2 != null) {
                    ((kotlin.g.a.b) eVar2).invoke(new CJRInstruct.openPostOrderSummaryActivity(cJRRechargePayment2, this.f61781a, obj2));
                }
            } else if (ab.a(cJRRechargePayment)) {
                this.r = cJRRechargePayment2;
                if (z) {
                    this.v = (CJRRechargeErrorModel) obj2;
                }
                ba.a(this.q, cJRRechargePayment2, (FetchPayOptionsListener) this);
            } else {
                e<kotlin.x> eVar3 = this.f61787g;
                if (eVar3 != null) {
                    ((kotlin.g.a.b) eVar3).invoke(new CJRInstruct.openRechargePaymentActivity("", this.f61781a, cJRRechargePayment2, obj2));
                }
            }
        } else {
            NetworkCustomError networkCustomError = new NetworkCustomError();
            networkCustomError.setStatusCode(cJRRechargePayment2 != null ? cJRRechargePayment.getCode() : -1);
            if (CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                if (!TextUtils.isEmpty(net.one97.paytm.recharge.di.helper.c.a((JSONObject) null))) {
                    net.one97.paytm.recharge.di.helper.c cVar2 = net.one97.paytm.recharge.di.helper.c.f62654a;
                    networkCustomError.setUrl(net.one97.paytm.recharge.di.helper.c.a((JSONObject) null));
                    if (cJRRechargePayment2 == null) {
                        k.a();
                    }
                    if (cJRRechargePayment.getError() != null) {
                        CJRError error = cJRRechargePayment.getError();
                        k.a((Object) error, "response.error");
                        if (!TextUtils.isEmpty(error.getMessage())) {
                            CJRError error2 = cJRRechargePayment.getError();
                            k.a((Object) error2, "response.error");
                            networkCustomError.setAlertMessage(error2.getMessage());
                        }
                    }
                }
                a(str, 0, (IJRPaytmDataModel) null, (NetworkCustomError) new bc(networkCustomError), obj);
                return;
            }
            if ((cJRRechargePayment2 != null ? cJRRechargePayment.getError() : null) != null) {
                if (obj2 instanceof CJRRechargeErrorModel) {
                    CJRRechargeErrorModel cJRRechargeErrorModel3 = (CJRRechargeErrorModel) obj2;
                    CRUFlowModel flowName4 = cJRRechargeErrorModel3.getFlowName();
                    if (flowName4 != null) {
                        flowName4.setAlertType(ALERT_TYPE.PROCEED_TO_PG.name());
                    }
                    cJRRechargeErrorModel = cJRRechargeErrorModel3;
                } else {
                    cJRRechargeErrorModel = null;
                }
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                String errorType = (cJRRechargeErrorModel == null || (flowName2 = cJRRechargeErrorModel.getFlowName()) == null) ? null : flowName2.getErrorType();
                Enum enumR = ERROR_TYPE.UNDEFINED;
                ERROR_TYPE error_type = enumR;
                if (!TextUtils.isEmpty(errorType)) {
                    if (errorType == null) {
                        try {
                            k.a();
                        } catch (Exception unused) {
                            error_type = enumR;
                        }
                    }
                    error_type = ERROR_TYPE.valueOf(errorType);
                }
                ERROR_TYPE error_type2 = (ERROR_TYPE) error_type;
                net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                if (!(cJRRechargeErrorModel == null || (flowName = cJRRechargeErrorModel.getFlowName()) == null)) {
                    str2 = flowName.getActionType();
                }
                Enum enumR2 = ACTION_TYPE.UNDEFINED;
                ACTION_TYPE action_type = enumR2;
                if (!TextUtils.isEmpty(str2)) {
                    if (str2 == null) {
                        try {
                            k.a();
                        } catch (Exception unused2) {
                            action_type = enumR2;
                        }
                    }
                    action_type = ACTION_TYPE.valueOf(str2);
                }
                az azVar = az.f61525a;
                Context context = this.q;
                CJRError error3 = cJRRechargePayment.getError();
                k.a((Object) error3, "response.error");
                String title = error3.getTitle();
                CJRError error4 = cJRRechargePayment.getError();
                k.a((Object) error4, "response.error");
                az.a(context, error_type2, (ACTION_TYPE) action_type, title, error4.getMessage(), false, cJRRechargeErrorModel, false, 1504);
                return;
            }
            Context context2 = this.q;
            String string = (context2 == null || (resources2 = context2.getResources()) == null) ? null : resources2.getString(R.string.error);
            Context context3 = this.q;
            if (!(context3 == null || (resources = context3.getResources()) == null)) {
                str2 = resources.getString(R.string.msg_invalid_url);
            }
            a(str, 0, (IJRPaytmDataModel) null, (NetworkCustomError) new ae(string, str2), obj);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        r4 = r4.getCart();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPaymentOptionsError() {
        /*
            r28 = this;
            r0 = r28
            kotlin.k.e<kotlin.x> r1 = r0.f61787g
            java.lang.String r2 = ""
            r3 = 0
            if (r1 == 0) goto L_0x0021
            kotlin.g.a.b r1 = (kotlin.g.a.b) r1
            net.one97.paytm.recharge.model.v4.CJRInstruct$openRechargePaymentActivity r4 = new net.one97.paytm.recharge.model.v4.CJRInstruct$openRechargePaymentActivity
            net.one97.paytm.common.entity.CJRRechargeCart r5 = r0.f61781a
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r6 = r0.r
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r7 = r0.v
            if (r7 != 0) goto L_0x001b
            net.one97.paytm.recharge.widgets.c.d r7 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r7 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r3, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r3)
        L_0x001b:
            r4.<init>(r2, r5, r6, r7)
            r1.invoke(r4)
        L_0x0021:
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r3, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r3)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r1.getFlowName()
            if (r4 != 0) goto L_0x0056
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = new net.one97.paytm.recharge.widgets.model.CRUFlowModel
            r5 = r4
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r27 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
        L_0x0056:
            r1.setFlowName(r4)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r1.getFlowName()
            if (r4 == 0) goto L_0x0068
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r5 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UI_DESCRIPTION
            java.lang.String r5 = r5.name()
            r4.setErrorType(r5)
        L_0x0068:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r1.getFlowName()
            if (r4 == 0) goto L_0x0077
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r5 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            java.lang.String r5 = r5.name()
            r4.setActionType(r5)
        L_0x0077:
            net.one97.paytm.common.entity.CJRRechargeCart r4 = r0.f61781a
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x00bd
            net.one97.paytm.common.entity.shopping.CJRCart r4 = r4.getCart()
            if (r4 == 0) goto L_0x00bd
            java.util.ArrayList r4 = r4.getCartItems()
            if (r4 == 0) goto L_0x00bd
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r6
            if (r4 != r6) goto L_0x00bd
            net.one97.paytm.common.entity.CJRRechargeCart r4 = r0.f61781a
            if (r4 == 0) goto L_0x00a1
            net.one97.paytm.common.entity.shopping.CJRCart r4 = r4.getCart()
            if (r4 == 0) goto L_0x00a1
            java.util.ArrayList r4 = r4.getCartItems()
            goto L_0x00a2
        L_0x00a1:
            r4 = r3
        L_0x00a2:
            if (r4 != 0) goto L_0x00a7
            kotlin.g.b.k.a()
        L_0x00a7:
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r7 = "rechargeCart?.cart?.cartItems!![0]"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r4 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r4
            java.lang.String r4 = r4.getProductId()
            if (r4 != 0) goto L_0x00b9
            goto L_0x00ba
        L_0x00b9:
            r2 = r4
        L_0x00ba:
            r1.setProductId(r2)
        L_0x00bd:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r1.getFlowName()
            if (r2 == 0) goto L_0x00c8
            java.lang.String r4 = "fetchPaymentOptions"
            r2.setTag(r4)
        L_0x00c8:
            android.content.Context r2 = r0.q
            if (r2 == 0) goto L_0x00e1
            int r3 = net.one97.paytm.recharge.R.string.error_message
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r7 = "onPaymentOptionsError"
            r4[r5] = r7
            java.lang.Class<net.one97.paytm.recharge.common.utils.w> r5 = net.one97.paytm.recharge.common.utils.w.class
            java.lang.String r5 = r5.getSimpleName()
            r4[r6] = r5
            java.lang.String r3 = r2.getString(r3, r4)
        L_0x00e1:
            r1.setErrorMsg(r3)
            net.one97.paytm.recharge.common.utils.az r2 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.w.onPaymentOptionsError():void");
    }

    public void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
        PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
        e<kotlin.x> eVar = this.f61787g;
        if (eVar != null) {
            kotlin.g.a.b bVar = (kotlin.g.a.b) eVar;
            CJRRechargeCart cJRRechargeCart = this.f61781a;
            CJRRechargePayment cJRRechargePayment = this.r;
            CJRRechargeErrorModel cJRRechargeErrorModel = this.v;
            if (cJRRechargeErrorModel == null) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                cJRRechargeErrorModel = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            }
            bVar.invoke(new CJRInstruct.openRechargePaymentActivity("", cJRRechargeCart, cJRRechargePayment, cJRRechargeErrorModel));
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        UnsubscribeApiResponse unsubscribeApiResponse;
        Integer status;
        CRUFlowModel flowName;
        StringBuilder journeyStackTrace;
        kotlin.x xVar;
        StringBuilder journeyStackTrace2;
        StringBuilder journeyStackTrace3;
        CJRCart cart;
        String finalPrice;
        k.c(str, "tag");
        if (iJRPaytmDataModel instanceof CJRRechargeCart) {
            a(str, (CJRRechargeCart) iJRPaytmDataModel, obj);
        } else if (iJRPaytmDataModel instanceof CJRCashWallet) {
            CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
            if (cJRCashWallet != null) {
                CJRCashWalletResponse response = cJRCashWallet.getResponse();
                int amount = response != null ? (int) response.getAmount() : -1;
                float f2 = 0.0f;
                try {
                    CJRRechargeCart cJRRechargeCart = this.f61781a;
                    if (!(cJRRechargeCart == null || (cart = cJRRechargeCart.getCart()) == null || (finalPrice = cart.getFinalPrice()) == null)) {
                        f2 = Float.parseFloat(finalPrice);
                    }
                } catch (Exception e2) {
                    q.d(e2.getMessage());
                }
                if (this.m) {
                    if (this.f61786f && f2 > ((float) amount)) {
                        this.f61786f = false;
                    }
                } else if (this.f61784d && f2 <= ((float) amount)) {
                    this.f61786f = true;
                }
                if (obj instanceof CJRRechargeErrorModel) {
                    String str2 = " - cashWalletApiSuccess - status code " + cJRCashWallet.getStatusCode() + " - withdrawAmount - " + this.f61786f;
                    CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                    CRUFlowModel flowName2 = cJRRechargeErrorModel.getFlowName();
                    if (!(flowName2 == null || (journeyStackTrace3 = flowName2.getJourneyStackTrace()) == null)) {
                        journeyStackTrace3.append(str2);
                    }
                    CRUFlowModel flowName3 = cJRRechargeErrorModel.getFlowName();
                    if (!(flowName3 == null || (journeyStackTrace2 = flowName3.getJourneyStackTrace()) == null)) {
                        journeyStackTrace2.append(" - WalletTokenApi");
                    }
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    net.one97.paytm.recharge.widgets.c.d.a(cJRRechargeErrorModel, ACTION_TYPE.GET_CASH_WALLET_SUCCESSFUL);
                    net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    net.one97.paytm.recharge.widgets.c.d.a(cJRRechargeErrorModel, ACTION_TYPE.WALLET_TOKEN);
                }
                net.one97.paytm.recharge.common.b.c cVar = this.f61789i;
                if (cVar != null) {
                    cVar.a_("wallet_token", this, obj);
                    xVar = kotlin.x.f47997a;
                } else {
                    xVar = null;
                }
                if (xVar != null) {
                    return;
                }
            }
            w wVar = this;
            if (!(!(obj instanceof CJRRechargeErrorModel) || (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) == null || (journeyStackTrace = flowName.getJourneyStackTrace()) == null)) {
                journeyStackTrace.append(" - cashWalletResponse = null");
            }
            wVar.a(str, 0, (IJRPaytmDataModel) null, new NetworkCustomError(), obj);
            kotlin.x xVar2 = kotlin.x.f47997a;
        } else if (iJRPaytmDataModel instanceof CJRPGTokenList) {
            a(str, (CJRPGTokenList) iJRPaytmDataModel, obj);
        } else if (iJRPaytmDataModel instanceof CJRRechargePayment) {
            a(str, (CJRRechargePayment) iJRPaytmDataModel, obj);
        } else if (iJRPaytmDataModel instanceof CJRSetUserConsentApiResponse) {
            CJRSetUserConsentApiResponse cJRSetUserConsentApiResponse = (CJRSetUserConsentApiResponse) iJRPaytmDataModel;
            Integer status2 = cJRSetUserConsentApiResponse.getStatus();
            if (status2 != null && status2.intValue() == 200) {
                net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.USER_CONSENT_CREATE_BILL_SUCCESSFUL);
                e<kotlin.x> eVar = this.f61787g;
                if (eVar != null) {
                    ((kotlin.g.a.b) eVar).invoke(new CJRInstruct.updateCreateBillResponse(cJRSetUserConsentApiResponse));
                    return;
                }
                return;
            }
            Integer status3 = cJRSetUserConsentApiResponse.getStatus();
            if (status3 != null && status3.intValue() == 204) {
                net.one97.paytm.recharge.widgets.c.d dVar4 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.USER_CONSENT_CREATE_BILL_SUCCESSFUL);
                e<kotlin.x> eVar2 = this.f61787g;
                if (eVar2 != null) {
                    ((kotlin.g.a.b) eVar2).invoke(new CJRInstruct.updateCreateBillResponse(cJRSetUserConsentApiResponse));
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRGetUserConsentApiResponse) {
            CJRGetUserConsentApiResponse cJRGetUserConsentApiResponse = (CJRGetUserConsentApiResponse) iJRPaytmDataModel;
            net.one97.paytm.recharge.widgets.c.d dVar5 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.USER_CONSENT_GET_BILL_SUCCESSFUL);
            e<kotlin.x> eVar3 = this.f61787g;
            if (eVar3 != null) {
                ((kotlin.g.a.b) eVar3).invoke(new CJRInstruct.updateGetBillResponse(cJRGetUserConsentApiResponse));
            }
        } else if ((iJRPaytmDataModel instanceof UnsubscribeApiResponse) && (status = unsubscribeApiResponse.getStatus()) != null && status.intValue() == 200) {
            net.one97.paytm.recharge.widgets.c.d dVar6 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.USER_CONSENT_UNSUBSCRIBED_SUCCESSFUL);
            e<kotlin.x> eVar4 = this.f61787g;
            if (eVar4 != null) {
                ((kotlin.g.a.b) eVar4).invoke(new CJRInstruct.updateUnsubscribeBillResponse((unsubscribeApiResponse = (UnsubscribeApiResponse) iJRPaytmDataModel)));
            }
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
        e<kotlin.x> eVar = this.f61788h;
        if (eVar != null) {
            ((kotlin.g.a.q) eVar).invoke(str, networkCustomError, obj);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean b(String str, CJRRechargeCart cJRRechargeCart, Object obj) {
        k.c(str, "tag");
        az azVar = az.f61525a;
        Bundle a2 = az.a(this.q, cJRRechargeCart, true, 4);
        boolean z = a2.getBoolean("extra.has.error");
        if (z) {
            String string = a2.getString("extra.error.title");
            String string2 = a2.getString("extra.error.msg");
            String string3 = a2.getString("extra.error.action.btn.label");
            String string4 = a2.getString("extra.error.action.btn");
            boolean z2 = a2.getBoolean("extra.show.error.info.dialog");
            e<kotlin.x> eVar = this.f61787g;
            if (eVar != null) {
                ((kotlin.g.a.b) eVar).invoke(new CJRInstruct.showAlertDialog(string, string2, string3, ba.b(string4), Boolean.valueOf(z2), obj));
            }
            e<kotlin.x> eVar2 = this.f61787g;
            if (eVar2 != null) {
                ((kotlin.g.a.b) eVar2).invoke(new CJRInstruct.onContainsError(string2, str, obj));
            }
        }
        return z;
    }

    private static CJRUtilityCheckboxItem a(List<CJRUtilityCheckboxItem> list, int i2) {
        if (list == null) {
            return null;
        }
        for (CJRUtilityCheckboxItem cJRUtilityCheckboxItem : list) {
            if (cJRUtilityCheckboxItem.getId() == ((long) i2)) {
                return cJRUtilityCheckboxItem;
            }
        }
        return null;
    }

    private static CJRProductsItem b(List<CJRProductsItem> list, int i2) {
        if (list != null) {
            for (CJRProductsItem cJRProductsItem : list) {
                Long productId = cJRProductsItem != null ? cJRProductsItem.getProductId() : null;
                long j2 = (long) i2;
                if (productId != null && productId.longValue() == j2) {
                    return cJRProductsItem;
                }
            }
        }
        return null;
    }

    public final void a(String str, HashMap<Object, Object> hashMap, Object obj) {
        k.c(str, "tag");
        k.c(hashMap, "paramsMap");
        JSONObject jSONObject = new JSONObject(hashMap);
        net.one97.paytm.recharge.common.b.c cVar = this.f61789i;
        if (cVar != null) {
            cVar.a(str, (ai) this, jSONObject, obj);
        }
    }

    public static final class d implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f61810a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ai f61811b;

        d(w wVar, ai aiVar) {
            this.f61810a = wVar;
            this.f61811b = aiVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            while (true) {
                k.c(str, "tag");
                e<kotlin.x> eVar = this.f61810a.f61788h;
                if (eVar != null) {
                    ((kotlin.g.a.q) eVar).invoke(str, networkCustomError, obj);
                }
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            this.f61810a.a_(str, iJRPaytmDataModel, obj);
            this.f61811b.a_(str, iJRPaytmDataModel, obj);
        }
    }

    public final void a(String str, ai aiVar, String str2, HashMap<Object, Object> hashMap, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "customerId");
        k.c(hashMap, "paramsMap");
        JSONObject jSONObject = new JSONObject(hashMap);
        net.one97.paytm.recharge.common.b.c cVar = this.f61789i;
        if (cVar != null) {
            cVar.a(str, (ai) new d(this, aiVar), jSONObject, obj);
        }
    }

    public static final class c implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f61808a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ai f61809b;

        c(w wVar, ai aiVar) {
            this.f61808a = wVar;
            this.f61809b = aiVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            e<kotlin.x> eVar = this.f61808a.f61788h;
            if (eVar != null) {
                ((kotlin.g.a.q) eVar).invoke(str, networkCustomError, obj);
            }
            this.f61808a.a(str, 0, (IJRPaytmDataModel) null, networkCustomError, obj);
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            this.f61808a.a_(str, iJRPaytmDataModel, obj);
            this.f61809b.a_(str, iJRPaytmDataModel, obj);
        }
    }

    public final void b(String str, HashMap<Object, Object> hashMap, Object obj) {
        k.c(str, "tag");
        k.c(hashMap, "paramsMap");
        String str2 = "?operator=" + hashMap.get(StringSet.operator) + "&customerId=" + hashMap.get("customerId") + "&rechargeNumber=" + hashMap.get("rechargeNumber") + "&productId=" + hashMap.get("productId");
        net.one97.paytm.recharge.common.b.c cVar = this.f61789i;
        if (cVar != null) {
            cVar.d(str, this, str2, obj);
        }
    }

    public final void a(String str, ai aiVar, JSONObject jSONObject, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        Object obj2 = obj;
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        String bx = net.one97.paytm.recharge.di.helper.c.bx();
        if (!URLUtil.isValidUrl(bx)) {
            bx = p.a("release", SDKConstants.KEY_STAGING_API, true) ? "https://digitalproxy-staging.paytm.com/customerbills/v1/recharge/customerbill" : "https://digitalproxy.paytm.com/customerbills/v1/recharge/customerbill";
        }
        if (URLUtil.isValidUrl(bx)) {
            String b2 = com.paytm.utility.b.b(this.q, bx);
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            net.one97.paytm.recharge.common.f.c cVar2 = new net.one97.paytm.recharge.common.f.c(str, b2, aiVar, new CJRMyBillData((Integer) null, (CJRMyBillDetails) null, (CJRMyBillDataError) null, 7, (g) null), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject != null ? jSONObject.toString() : null, obj);
            cVar2.a(true);
            if (com.paytm.utility.b.c(this.q)) {
                net.one97.paytm.recharge.common.f.d.a();
                net.one97.paytm.recharge.common.f.d.b(cVar2);
                return;
            }
            if ((obj2 instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a("view_my_bill", 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
            return;
        }
        if ((obj2 instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
            flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
        }
        aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
    }

    public final void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, ai aiVar, String str2, String str3, Object obj) {
        JSONObject jSONObject2;
        Map<String, String> map3 = map;
        Map<String, String> map4 = map2;
        JSONObject jSONObject3 = jSONObject;
        String str4 = str3;
        Object obj2 = obj;
        k.c(str, "tag");
        k.c(map3, "productIdAmountMap");
        k.c(jSONObject3, "metaData");
        k.c(aiVar, "listener");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str4, "categoryId");
        JSONObject jSONObject4 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (!map.isEmpty()) {
            w wVar = this;
            int size = map.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                JSONObject jSONObject5 = new JSONObject();
                int i4 = size;
                Object[] array = map.keySet().toArray(new String[i2]);
                if (array != null) {
                    String str5 = ((String[]) array)[i3];
                    jSONObject5.put(CLPConstants.PRODUCT_ID, str5);
                    jSONObject5.put("qty", 1);
                    if (map4 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    jSONObject2.put("price", map3.get(str5));
                    jSONObject2.put("category_id", str4);
                    jSONObject5.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject2);
                    jSONObject5.put("meta_data", jSONObject3);
                    jSONArray.put(jSONObject5);
                    i3++;
                    ai aiVar2 = aiVar;
                    size = i4;
                    i2 = 0;
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            if (jSONArray.length() == 0) {
                Context context = wVar.q;
                String string = context != null ? context.getString(R.string.operator_unavailable_tittle) : null;
                Context context2 = wVar.q;
                a(str, 0, (IJRPaytmDataModel) null, (NetworkCustomError) new ae(string, context2 != null ? context2.getString(R.string.product_not_available) : null), obj);
                return;
            }
            jSONObject4.put("cart_items", jSONArray);
            if (obj2 instanceof CJRRechargeErrorModel) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                String a2 = net.one97.paytm.recharge.widgets.c.d.a(jSONObject4);
                CRUFlowModel flowName = ((CJRRechargeErrorModel) obj2).getFlowName();
                if (flowName != null) {
                    flowName.setRequestBody(a2);
                }
            }
            if (jSONObject4.opt(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS) instanceof JSONObject) {
                Object obj3 = jSONObject4.get(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
                if (obj3 != null) {
                    wVar.f61782b = (JSONObject) obj3;
                } else {
                    throw new u("null cannot be cast to non-null type org.json.JSONObject");
                }
            }
            az azVar = az.f61525a;
            wVar.n = az.a(jSONObject4);
            y yVar = y.f61814b;
            y.a(jSONObject4);
            net.one97.paytm.recharge.common.b.c cVar = wVar.f61789i;
            if (cVar != null) {
                cVar.a(str, new a(wVar, this, map, map2, str3, jSONObject, jSONArray, str, obj, jSONObject4, aiVar, str2), jSONObject4, str2, a.b.USER_FACING, obj, 0, true);
                return;
            }
            return;
        }
        Context context3 = this.q;
        String string2 = context3 != null ? context3.getString(R.string.operator_unavailable_tittle) : null;
        Context context4 = this.q;
        aiVar.a(str, 0, (IJRPaytmDataModel) null, new ae(string2, context4 != null ? context4.getString(R.string.product_not_available) : null), obj);
    }

    public static final class a implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f61790a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w f61791b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f61792c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Map f61793d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f61794e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ JSONObject f61795f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ JSONArray f61796g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f61797h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ Object f61798i;
        final /* synthetic */ JSONObject j;
        final /* synthetic */ ai k;
        final /* synthetic */ String l;

        a(w wVar, w wVar2, Map map, Map map2, String str, JSONObject jSONObject, JSONArray jSONArray, String str2, Object obj, JSONObject jSONObject2, ai aiVar, String str3) {
            this.f61790a = wVar;
            this.f61791b = wVar2;
            this.f61792c = map;
            this.f61793d = map2;
            this.f61794e = str;
            this.f61795f = jSONObject;
            this.f61796g = jSONArray;
            this.f61797h = str2;
            this.f61798i = obj;
            this.j = jSONObject2;
            this.k = aiVar;
            this.l = str3;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            this.k.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
            r14 = r14.getResources();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a_(java.lang.String r13, com.paytm.network.model.IJRPaytmDataModel r14, java.lang.Object r15) {
            /*
                r12 = this;
                java.lang.String r0 = "tag"
                kotlin.g.b.k.c(r13, r0)
                boolean r0 = r14 instanceof net.one97.paytm.common.entity.CJRRechargeCart
                if (r0 == 0) goto L_0x0175
                r0 = r14
                net.one97.paytm.common.entity.CJRRechargeCart r0 = (net.one97.paytm.common.entity.CJRRechargeCart) r0
                net.one97.paytm.common.entity.shopping.CJRCartStatus r1 = r0.getCartStatus()
                r2 = 1
                if (r1 == 0) goto L_0x0048
                net.one97.paytm.common.entity.shopping.CJRCartStatus r1 = r0.getCartStatus()
                java.lang.String r3 = "cjrRechargeCart.cartStatus"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
                java.lang.String r1 = r1.getResult()
                java.lang.String r3 = "SUCCESS"
                boolean r1 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r1, (boolean) r2)
                if (r1 == 0) goto L_0x0048
                net.one97.paytm.recharge.common.utils.w r1 = r12.f61790a
                boolean r0 = r1.b((java.lang.String) r13, (net.one97.paytm.common.entity.CJRRechargeCart) r0, (java.lang.Object) r15)
                if (r0 != 0) goto L_0x0037
                net.one97.paytm.recharge.common.e.ai r0 = r12.k
                r0.a_(r13, r14, r15)
                return
            L_0x0037:
                net.one97.paytm.recharge.common.utils.w r13 = r12.f61790a
                kotlin.k.e<kotlin.x> r13 = r13.f61787g
                if (r13 == 0) goto L_0x0047
                kotlin.g.a.b r13 = (kotlin.g.a.b) r13
                net.one97.paytm.recharge.model.v4.CJRInstruct$errorInFetchAmountField r14 = new net.one97.paytm.recharge.model.v4.CJRInstruct$errorInFetchAmountField
                r14.<init>()
                r13.invoke(r14)
            L_0x0047:
                return
            L_0x0048:
                net.one97.paytm.recharge.common.utils.w r14 = r12.f61790a
                android.content.Context r14 = r14.q
                r1 = 0
                if (r14 == 0) goto L_0x005c
                android.content.res.Resources r14 = r14.getResources()
                if (r14 == 0) goto L_0x005c
                int r3 = net.one97.paytm.recharge.R.string.network_error_message_re
                java.lang.String r14 = r14.getString(r3)
                goto L_0x005d
            L_0x005c:
                r14 = r1
            L_0x005d:
                net.one97.paytm.common.entity.shopping.CJRCartStatus r3 = r0.getCartStatus()
                r4 = 32
                java.lang.String r5 = ""
                r6 = 0
                if (r3 == 0) goto L_0x00c7
                com.paytm.network.model.CJRError r3 = r3.getMessage()
                if (r3 == 0) goto L_0x00c7
                java.lang.String r3 = r3.getMessage()
                if (r3 == 0) goto L_0x00c7
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                int r7 = r3.length()
                int r7 = r7 - r2
                r8 = r7
                r7 = 0
                r9 = 0
            L_0x007e:
                if (r7 > r8) goto L_0x009c
                if (r9 != 0) goto L_0x0084
                r10 = r7
                goto L_0x0085
            L_0x0084:
                r10 = r8
            L_0x0085:
                char r10 = r3.charAt(r10)
                if (r10 > r4) goto L_0x008d
                r10 = 1
                goto L_0x008e
            L_0x008d:
                r10 = 0
            L_0x008e:
                if (r9 != 0) goto L_0x0097
                if (r10 != 0) goto L_0x0094
                r9 = 1
                goto L_0x007e
            L_0x0094:
                int r7 = r7 + 1
                goto L_0x007e
            L_0x0097:
                if (r10 == 0) goto L_0x009c
                int r8 = r8 + -1
                goto L_0x007e
            L_0x009c:
                int r8 = r8 + r2
                java.lang.CharSequence r3 = r3.subSequence(r7, r8)
                java.lang.String r3 = r3.toString()
                if (r3 == 0) goto L_0x00c7
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                int r3 = r3.length()
                if (r3 <= 0) goto L_0x00b1
                r3 = 1
                goto L_0x00b2
            L_0x00b1:
                r3 = 0
            L_0x00b2:
                if (r3 != r2) goto L_0x00c7
                net.one97.paytm.common.entity.shopping.CJRCartStatus r14 = r0.getCartStatus()
                if (r14 == 0) goto L_0x00c6
                com.paytm.network.model.CJRError r14 = r14.getMessage()
                if (r14 == 0) goto L_0x00c6
                java.lang.String r14 = r14.getMessage()
                if (r14 != 0) goto L_0x00c7
            L_0x00c6:
                r14 = r5
            L_0x00c7:
                net.one97.paytm.recharge.common.utils.w r3 = r12.f61790a
                android.content.Context r3 = r3.q
                if (r3 == 0) goto L_0x00d4
                int r7 = net.one97.paytm.recharge.R.string.network_error_heading_re
                java.lang.String r3 = r3.getString(r7)
                goto L_0x00d5
            L_0x00d4:
                r3 = r1
            L_0x00d5:
                net.one97.paytm.common.entity.shopping.CJRCartStatus r7 = r0.getCartStatus()
                if (r7 == 0) goto L_0x0138
                com.paytm.network.model.CJRError r7 = r7.getMessage()
                if (r7 == 0) goto L_0x0138
                java.lang.String r7 = r7.getTitle()
                if (r7 == 0) goto L_0x0138
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                int r8 = r7.length()
                int r8 = r8 - r2
                r9 = r8
                r8 = 0
                r10 = 0
            L_0x00f1:
                if (r8 > r9) goto L_0x010f
                if (r10 != 0) goto L_0x00f7
                r11 = r8
                goto L_0x00f8
            L_0x00f7:
                r11 = r9
            L_0x00f8:
                char r11 = r7.charAt(r11)
                if (r11 > r4) goto L_0x0100
                r11 = 1
                goto L_0x0101
            L_0x0100:
                r11 = 0
            L_0x0101:
                if (r10 != 0) goto L_0x010a
                if (r11 != 0) goto L_0x0107
                r10 = 1
                goto L_0x00f1
            L_0x0107:
                int r8 = r8 + 1
                goto L_0x00f1
            L_0x010a:
                if (r11 == 0) goto L_0x010f
                int r9 = r9 + -1
                goto L_0x00f1
            L_0x010f:
                int r9 = r9 + r2
                java.lang.CharSequence r4 = r7.subSequence(r8, r9)
                java.lang.String r4 = r4.toString()
                if (r4 == 0) goto L_0x0138
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                int r4 = r4.length()
                if (r4 <= 0) goto L_0x0123
                r6 = 1
            L_0x0123:
                if (r6 != r2) goto L_0x0138
                net.one97.paytm.common.entity.shopping.CJRCartStatus r3 = r0.getCartStatus()
                if (r3 == 0) goto L_0x0137
                com.paytm.network.model.CJRError r3 = r3.getMessage()
                if (r3 == 0) goto L_0x0137
                java.lang.String r3 = r3.getTitle()
                if (r3 != 0) goto L_0x0138
            L_0x0137:
                r3 = r5
            L_0x0138:
                net.one97.paytm.common.entity.shopping.CJRCart r4 = r0.getCart()
                if (r4 == 0) goto L_0x0164
                java.lang.String r4 = r4.getPromoFailureText()
                if (r4 == 0) goto L_0x0164
                boolean r4 = net.one97.paytm.recharge.common.utils.g.c(r4)
                if (r4 != r2) goto L_0x0164
                net.one97.paytm.recharge.common.utils.w r14 = r12.f61790a
                android.content.Context r14 = r14.q
                if (r14 == 0) goto L_0x0156
                int r1 = net.one97.paytm.recharge.R.string.msg_invalid_recharge_promo_code
                java.lang.String r1 = r14.getString(r1)
            L_0x0156:
                r3 = r1
                net.one97.paytm.common.entity.shopping.CJRCart r14 = r0.getCart()
                if (r14 == 0) goto L_0x0163
                java.lang.String r14 = r14.getPromoFailureText()
                if (r14 != 0) goto L_0x0164
            L_0x0163:
                r14 = r5
            L_0x0164:
                net.one97.paytm.recharge.common.utils.w r4 = r12.f61791b
                r6 = 0
                r7 = 0
                net.one97.paytm.recharge.common.utils.ae r0 = new net.one97.paytm.recharge.common.utils.ae
                r0.<init>(r3, r14)
                r8 = r0
                com.paytm.network.model.NetworkCustomError r8 = (com.paytm.network.model.NetworkCustomError) r8
                r5 = r13
                r9 = r15
                r4.a((java.lang.String) r5, (int) r6, (com.paytm.network.model.IJRPaytmDataModel) r7, (com.paytm.network.model.NetworkCustomError) r8, (java.lang.Object) r9)
            L_0x0175:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.w.a.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
        }
    }
}
