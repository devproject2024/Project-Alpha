package net.one97.paytm.recharge.coupons;

import android.content.Context;
import android.net.Uri;
import android.webkit.URLUtil;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import com.paytm.utility.d;
import com.sendbird.android.constant.StringSet;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.recharge.CJRSelectedRecharge;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.ap;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.bf;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.model.CJRCouponGrid;
import net.one97.paytm.recharge.model.CJRCouponHeader;
import net.one97.paytm.recharge.model.CJRPromoCodeTerms;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONObject;

public final class a extends net.one97.paytm.recharge.common.b.c.a implements c {

    /* renamed from: b  reason: collision with root package name */
    public static final C1193a f62159b = new C1193a((byte) 0);

    public final void a(String str, ai aiVar, String str2, String str3, long j, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str3, "rechargeNumber");
    }

    public final void a(String str, ai aiVar, String str2, String str3, String str4, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "url");
        k.c(str3, "productId");
    }

    public final void a(String str, ai aiVar, String str2, String str3, net.one97.paytm.recharge.common.b.a.a aVar, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "url");
    }

    public final void a(String str, ai aiVar, JSONObject jSONObject, String str2, String str3, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "url");
    }

    public final void b(String str, ai aiVar, JSONObject jSONObject, String str2, String str3, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(jSONObject, "body");
        k.c(str2, "url");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        k.c(context, "context");
    }

    /* renamed from: net.one97.paytm.recharge.coupons.a$a  reason: collision with other inner class name */
    public static final class C1193a extends bf<a, Context> {
        private C1193a() {
            super(AnonymousClass1.INSTANCE);
        }

        public /* synthetic */ C1193a(byte b2) {
            this();
        }
    }

    public final void a(String str, ai aiVar, String str2, String str3, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        k.c(str2, StringSet.operator);
        k.c(str3, "circle");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        c cVar = c.f62654a;
        String A = c.A();
        if (URLUtil.isValidUrl(A)) {
            if (A == null) {
                k.a();
            }
            String a2 = a(str2, A, str3);
            if (b.c(this.f60907a)) {
                Map hashMap = new HashMap();
                String a3 = d.a(this.f60907a);
                if (a3 == null) {
                    a3 = "";
                }
                hashMap.put(AppConstants.SSO_TOKEN, a3);
                String s = b.s(this.f60907a, a2);
                this.f60907a.getApplicationContext();
                net.one97.paytm.recharge.common.f.d.a();
                net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b(str, b.t(this.f60907a, s), aiVar, new CJRCouponHeader(), hashMap, obj));
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

    public final void a(String str, ai aiVar, String str2, int i2, String str3, ArrayList<CJRSelectedRecharge> arrayList, String str4, String str5, Object obj) {
        CRUFlowModel flowName;
        String str6;
        CRUFlowModel flowName2;
        String str7 = str;
        String str8 = str2;
        int i3 = i2;
        String str9 = str4;
        String str10 = str5;
        Object obj2 = obj;
        k.c(str, "tag");
        ai aiVar2 = aiVar;
        k.c(aiVar, "responseListener");
        k.c(str2, "mUrl");
        String str11 = str3;
        k.c(str3, "rechargeNumber");
        k.c(arrayList, "selectedRechargeList");
        k.c(str9, StringSet.operator);
        k.c(str10, "circle");
        ay ayVar = ay.f61523a;
        ay.a(str, obj2);
        if (URLUtil.isValidUrl(str2)) {
            Uri parse = Uri.parse(str2);
            k.a((Object) parse, "Uri.parse(url)");
            if (parse.getQuery() != null) {
                str6 = str2 + "&description=1&page_count=" + i2 + "&items_per_page=20";
            } else {
                str6 = str2 + "?description=1&page_count=" + i2 + "&items_per_page=20";
            }
            String a2 = a(str9, str6, str10);
            if (b.c(this.f60907a)) {
                "loadCouponList ::URL --------------------> ".concat(String.valueOf(a2));
                b.j();
                Map hashMap = new HashMap();
                String a3 = d.a(this.f60907a);
                if (a3 == null) {
                    a3 = "";
                }
                hashMap.put(AppConstants.SSO_TOKEN, a3);
                String s = b.s(this.f60907a, a2);
                k.a((Object) s, "CJRAppCommonUtility.addD…sWithoutSSO(context, url)");
                this.f60907a.getApplicationContext();
                net.one97.paytm.recharge.common.f.d.a();
                net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b(str, b.t(this.f60907a, s), aiVar, new CJRCouponGrid(), hashMap, obj));
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
        k.c(str2, "mUrl");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        Uri parse = Uri.parse(str2);
        if (parse != null) {
            if (parse.getQuery() != null) {
                str2 = str2 + "&resolution=280x360&quality=high";
            } else {
                str2 = str2 + "?resolution=280x360&quality=high";
            }
        }
        String a2 = com.paytm.utility.c.a(str2, this.f60907a);
        k.a((Object) a2, "CJRDefaultRequestParam.g…oductDetail(url, context)");
        if (!URLUtil.isValidUrl(a2)) {
            if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
        } else if (b.c(this.f60907a)) {
            b.j();
            net.one97.paytm.recharge.common.f.d.a();
            net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b(str, a2, aiVar, new CJRDetailProduct(), obj));
        } else {
            if ((obj instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
        }
    }

    private static String a(String str, String str2, String str3) {
        String str4;
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || p.a(charSequence))) {
            Uri parse = Uri.parse(str2);
            k.a((Object) parse, "Uri.parse(url1)");
            if (parse.getQuery() != null) {
                str2 = str2 + "&operator=";
            } else {
                str2 = str2 + "?operator=";
            }
            try {
                str2 = str2 + URLEncoder.encode(str, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
            } catch (Throwable th) {
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
            }
        }
        CharSequence charSequence2 = str3;
        if (charSequence2 == null || p.a(charSequence2)) {
            z = true;
        }
        if (z || p.a(str3, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.FOR_ALL, true)) {
            return str2;
        }
        Uri parse2 = Uri.parse(str2);
        k.a((Object) parse2, "Uri.parse(url1)");
        if (parse2.getQuery() != null) {
            str4 = str2 + "&circle=";
        } else {
            str4 = str2 + "?circle=";
        }
        String str5 = str4;
        try {
            return str5 + URLEncoder.encode(str3, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
        } catch (Throwable th2) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th2);
            return str5;
        }
    }

    public final void a(String str, String str2, ai aiVar, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        k.c(str, "tag");
        k.c(str2, "promoCode");
        k.c(aiVar, "responseListener");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        String str3 = "https://apiproxy.paytm.com/papi/v1/promosearch/" + str2 + "/1/tnc";
        if (!URLUtil.isValidUrl(str3)) {
            if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
        } else if (b.c(this.f60907a)) {
            net.one97.paytm.recharge.common.f.d.a();
            net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b(str, str3, aiVar, new CJRPromoCodeTerms((String) null, (String) null, (String) null, 7, (g) null), obj));
        } else {
            if ((obj instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
        }
    }
}
