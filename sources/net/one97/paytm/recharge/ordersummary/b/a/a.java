package net.one97.paytm.recharge.ordersummary.b.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.android.volley.RequestQueue;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.n;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.f.d;
import net.one97.paytm.recharge.common.utils.ap;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.bf;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.model.CJRContributionData;
import net.one97.paytm.recharge.model.CJRPersonalInsurance;
import net.one97.paytm.recharge.ordersummary.f.k;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONObject;

public final class a extends net.one97.paytm.recharge.common.b.c.a implements k {

    /* renamed from: b  reason: collision with root package name */
    public static final C1255a f64008b = new C1255a((byte) 0);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        kotlin.g.b.k.c(context, "context");
    }

    /* renamed from: net.one97.paytm.recharge.ordersummary.b.a.a$a  reason: collision with other inner class name */
    public static final class C1255a extends bf<a, Context> {
        private C1255a() {
            super(AnonymousClass1.INSTANCE);
        }

        public /* synthetic */ C1255a(byte b2) {
            this();
        }
    }

    public final void a(String str, ai aiVar, JSONObject jSONObject, String str2, String str3, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(str2, "url");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(String str, ai aiVar, String str2, String str3, net.one97.paytm.recharge.common.b.a.a aVar, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(str2, "url");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(String str, ai aiVar, String str2, String str3, String str4, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(str2, "url");
        kotlin.g.b.k.c(str3, "productId");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void b(String str, ai aiVar, JSONObject jSONObject, String str2, String str3, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(jSONObject, "body");
        kotlin.g.b.k.c(str2, "url");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(String str, ai aiVar, String str2, String str3, long j, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(str3, "rechargeNumber");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(String str, String str2, String str3, ai aiVar, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        CRUFlowModel flowName3;
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(str2, "orderId");
        kotlin.g.b.k.c(str3, "extraQueryParams");
        kotlin.g.b.k.c(aiVar, "responseListener");
        c cVar = c.f62654a;
        String a2 = c.a(str2);
        if (a2 == null) {
            a2 = "";
        }
        CJRRechargeUtilities.INSTANCE.debugLog("getOrderDetailResponse called ".concat(String.valueOf(a2)));
        if (URLUtil.isValidUrl(a2)) {
            String sSOToken = CJRRechargeUtilities.INSTANCE.getSSOToken(this.f60907a);
            if (TextUtils.isEmpty(sSOToken)) {
                if ((obj instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                    flowName2.setErrorType(ERROR_TYPE.AUTH.name());
                }
                CJRRechargeUtilities.INSTANCE.debugLog("getOrderDetailResponse: ssoToken is empty");
                aiVar.a(str, 0, (IJRPaytmDataModel) null, new net.one97.paytm.recharge.common.utils.c(), obj);
            } else if (b.c(this.f60907a)) {
                String b2 = com.paytm.utility.c.b(a2, this.f60907a);
                kotlin.g.b.k.a((Object) b2, "CJRDefaultRequestParam.g…lWithoutSSO(url, context)");
                String str4 = (b2 + str3) + "&actions=1";
                Map hashMap = new HashMap();
                hashMap.put(AppConstants.SSO_TOKEN, sSOToken);
                CJRRechargeUtilities.INSTANCE.debugLog("getOrderDetailResponse: CJRRechargeGetRequest called");
                net.one97.paytm.recharge.common.f.b bVar = new net.one97.paytm.recharge.common.f.b(str, str4, aiVar, new CJROrderSummary(), hashMap, obj);
                bVar.a("order_detail_request");
                c cVar2 = c.f62654a;
                if (!c.D()) {
                    bVar.b();
                    a(str4);
                }
                d.a();
                d.b(bVar);
            } else {
                if ((obj instanceof CJRRechargeErrorModel) && (flowName3 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                    flowName3.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
                }
                CJRRechargeUtilities.INSTANCE.debugLog("getOrderDetailResponse: No Internet connection found");
                aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
            }
        } else {
            if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
            }
            CJRRechargeUtilities.INSTANCE.debugLog("getOrderDetailResponse: url is not valid ".concat(String.valueOf(a2)));
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
        }
    }

    public final void a(String str, ai aiVar, String str2, String str3, String str4, String str5, CJROrderedCart cJROrderedCart, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        CRUFlowModel flowName3;
        String str6 = str2;
        String str7 = str3;
        String str8 = str4;
        String str9 = str5;
        Object obj2 = obj;
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "responseListener");
        kotlin.g.b.k.c(str6, "url");
        kotlin.g.b.k.c(str7, "productMasterNumber");
        kotlin.g.b.k.c(str8, "productMasterId");
        kotlin.g.b.k.c(str9, "rechargeMasterPrice");
        kotlin.g.b.k.c(cJROrderedCart, "masterProduct");
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        if (URLUtil.isValidUrl(str2)) {
            String sSOToken = CJRRechargeUtilities.INSTANCE.getSSOToken(this.f60907a);
            if (TextUtils.isEmpty(sSOToken)) {
                if ((obj2 instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                    flowName2.setErrorType(ERROR_TYPE.AUTH.name());
                }
                aiVar.a(str, 0, (IJRPaytmDataModel) null, new net.one97.paytm.recharge.common.utils.c(), obj);
            } else if (b.c(this.f60907a)) {
                Map map = hashMap;
                map.put("Content-Type", "application/json");
                map.put(AppConstants.SSO_TOKEN, sSOToken);
                try {
                    jSONObject.put("vertical_id", cJROrderedCart.getVerticalId());
                    jSONObject.put("merchant_id", cJROrderedCart.getMerchantId());
                    CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
                    kotlin.g.b.k.a((Object) productDetail, "mMasterProduct.productDetail");
                    CJRAttributes attributes = productDetail.getAttributes();
                    kotlin.g.b.k.a((Object) attributes, "mMasterProduct.productDetail.attributes");
                    jSONObject.put(StringSet.operator, attributes.getOperatorName());
                    CJROrderSummaryProductDetail productDetail2 = cJROrderedCart.getProductDetail();
                    kotlin.g.b.k.a((Object) productDetail2, "mMasterProduct.productDetail");
                    CJRAttributes attributes2 = productDetail2.getAttributes();
                    kotlin.g.b.k.a((Object) attributes2, "mMasterProduct.productDetail.attributes");
                    jSONObject.put("service", attributes2.getService());
                    CJROrderSummaryProductDetail productDetail3 = cJROrderedCart.getProductDetail();
                    kotlin.g.b.k.a((Object) productDetail3, "mMasterProduct.productDetail");
                    CJRAttributes attributes3 = productDetail3.getAttributes();
                    kotlin.g.b.k.a((Object) attributes3, "mMasterProduct.productDetail.attributes");
                    jSONObject.put("paytype", attributes3.getPaytype());
                    CJROrderSummaryProductDetail productDetail4 = cJROrderedCart.getProductDetail();
                    kotlin.g.b.k.a((Object) productDetail4, "mMasterProduct.productDetail");
                    jSONObject.put(CLPConstants.BRAND_PARAMS, productDetail4.getBrandName());
                } catch (Throwable th) {
                    CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
                }
                String a2 = ba.a(this.f60907a, str7, str8, str9, jSONObject);
                String s = b.s(this.f60907a, str6 + "&channel=android");
                kotlin.g.b.k.a((Object) s, "CJRAppCommonUtility.addD…WithoutSSO(context, mUrl)");
                net.one97.paytm.recharge.common.f.c cVar = new net.one97.paytm.recharge.common.f.c(str, s, aiVar, (IJRPaytmDataModel) new CJRPersonalInsurance(), (Map<String, String>) null, (Map<String, String>) map, a2, obj);
                d.a();
                d.b(cVar);
            } else {
                if ((obj2 instanceof CJRRechargeErrorModel) && (flowName3 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                    flowName3.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
                }
                aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
            }
        } else {
            if ((obj2 instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
        }
    }

    public final void a(String str, ai aiVar, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        c cVar = c.f62654a;
        String d2 = c.d();
        if (d2 == null) {
            d2 = "";
        }
        if (!URLUtil.isValidUrl(d2)) {
            if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
        } else if (b.c(this.f60907a)) {
            String b2 = com.paytm.utility.c.b(d2, this.f60907a);
            kotlin.g.b.k.a((Object) b2, "CJRDefaultRequestParam.g…lWithoutSSO(url, context)");
            net.one97.paytm.recharge.common.f.b bVar = new net.one97.paytm.recharge.common.f.b(str, b2, aiVar, (IJRPaytmDataModel) new CJRContributionData(), (Map<String, String>) null, obj, 5000);
            bVar.a("fetch_total_contribution");
            c cVar2 = c.f62654a;
            if (!c.D()) {
                bVar.b();
                a(b2);
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

    private final void a(String str) {
        try {
            RequestQueue b2 = f.b(this.f60907a);
            kotlin.g.b.k.a((Object) b2, "com.paytm.network.CJRVol….getRequestQueue(context)");
            b2.getCache().remove(str);
        } catch (Throwable th) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
        }
    }
}
