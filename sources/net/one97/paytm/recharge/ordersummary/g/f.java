package net.one97.paytm.recharge.ordersummary.g;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.common.entity.shopping.CJRActionResponse;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.b.c.e;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.z;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.model.imps.CJRImpsRefundBodyModel;
import net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8;
import net.one97.paytm.recharge.model.imps.CJRImpsRefundHeadModel;
import net.one97.paytm.recharge.model.imps.CJRImpsRefundModel;
import net.one97.paytm.recharge.ordersummary.f.s;
import net.one97.paytm.recharge.ordersummary.f.t;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f implements s.a, t.a {

    /* renamed from: a  reason: collision with root package name */
    private t.b f64301a;

    /* renamed from: b  reason: collision with root package name */
    private e f64302b;

    /* renamed from: c  reason: collision with root package name */
    private CJROrderSummary f64303c;

    public f(t.b bVar, e eVar, CJROrderSummary cJROrderSummary) {
        this.f64301a = bVar;
        this.f64302b = eVar;
        this.f64303c = cJROrderSummary;
    }

    public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel, Integer num) {
        k.c(str, "tag");
        t.b bVar = this.f64301a;
        if (bVar != null) {
            bVar.a(iJRPaytmDataModel, num);
        }
    }

    public final void a(String str, NetworkCustomError networkCustomError, Integer num) {
        k.c(str, "tag");
        k.c(networkCustomError, "error");
        t.b bVar = this.f64301a;
        if (bVar != null) {
            bVar.a(networkCustomError, num);
        }
    }

    public final void a(int i2, String str) {
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderedCart cJROrderedCart;
        e eVar;
        e eVar2;
        e eVar3;
        IJRPaytmDataModel iJRPaytmDataModel;
        int i3 = i2;
        String str2 = str;
        if (i3 == 0) {
            k.c("0", "tag");
            e eVar4 = this.f64302b;
            if (eVar4 != null) {
                s.a aVar = this;
                CJROrderSummary cJROrderSummary = this.f64303c;
                d dVar = d.f64967a;
                CJRRechargeErrorModel a2 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                k.c("0", "tag");
                k.c(aVar, H5Event.TYPE_CALL_BACK);
                if (!ba.b(eVar4.f60938a)) {
                    Integer.valueOf(0);
                    eVar4.a("0", aVar);
                    return;
                }
                c cVar = c.f62654a;
                String b2 = com.paytm.utility.c.b(c.bc(), eVar4.f60938a);
                k.a((Object) b2, "CJRDefaultRequestParam.g…RefundDetailUrl, context)");
                if (URLUtil.isValidUrl(b2)) {
                    HashMap<String, String> a3 = b.a((HashMap<String, String>) new HashMap(), eVar4.f60938a);
                    k.a((Object) a3, "CJRAppCommonUtility.addS…nHeader(headers, context)");
                    Map map = a3;
                    map.put("channel_id", "APP");
                    map.put("device_id", b.A(eVar4.f60938a));
                    map.put("version", "2.0");
                    map.put(ContactsConstant.USER_AGENT, "android");
                    map.put("Content-Type", "application/json");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("orderId", cJROrderSummary != null ? cJROrderSummary.getId() : null);
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("itemId", (cJROrderSummary == null || (orderedCartList = cJROrderSummary.getOrderedCartList()) == null || (cJROrderedCart = orderedCartList.get(0)) == null) ? null : Long.valueOf(cJROrderedCart.getId()));
                    jSONObject2.put("cancellationCharges", "0");
                    jSONArray.put(jSONObject2);
                    jSONObject.put("itemsInfo", jSONArray);
                    x.e eVar5 = new x.e();
                    eVar5.element = null;
                    eVar5.element = new net.one97.paytm.recharge.common.f.c("0", b2, (ai) new e.c(eVar4, eVar5, aVar), (IJRPaytmDataModel) new CJRImpsRefundConsultViewV8(), (Map<String, String>) null, (Map<String, String>) map, jSONObject.toString(), (Object) a2);
                    e.a((net.one97.paytm.recharge.common.f.c) eVar5.element);
                    net.one97.paytm.recharge.common.f.d.a();
                    net.one97.paytm.recharge.common.f.d.b((net.one97.paytm.recharge.common.f.c) eVar5.element);
                    return;
                }
                aVar.a("0", new NetworkCustomError(), (Integer) 0);
                az azVar = az.f61525a;
                az.a(eVar4.f60938a, ERROR_TYPE.UNDEFINED, ACTION_TYPE.OS_CTA_CANCEL, "", eVar4.f60938a.getResources().getString(R.string.rc_msg_invalid_url));
            }
        } else if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3 && !TextUtils.isEmpty(str2) && (eVar3 = this.f64302b) != null) {
                    s.a aVar2 = this;
                    d dVar2 = d.f64967a;
                    CJRRechargeErrorModel a4 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                    k.c("3", "tag");
                    k.c(aVar2, H5Event.TYPE_CALL_BACK);
                    if (!ba.b(eVar3.f60938a)) {
                        Integer.valueOf(3);
                        eVar3.a("3", aVar2);
                        return;
                    }
                    if (eVar3.f60938a instanceof z) {
                        iJRPaytmDataModel = new CJRActionResponse();
                    } else {
                        iJRPaytmDataModel = new CJROSActionResponseV2();
                    }
                    IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
                    HashMap<String, String> a5 = b.a((HashMap<String, String>) new HashMap(), eVar3.f60938a);
                    k.a((Object) a5, "CJRAppCommonUtility.addS…nHeader(headers, context)");
                    Map map2 = a5;
                    map2.put("Content-Type", "application/json");
                    x.e eVar6 = new x.e();
                    eVar6.element = null;
                    eVar6.element = new net.one97.paytm.recharge.common.f.b("3", str, new e.d(eVar3, eVar6, aVar2), iJRPaytmDataModel2, map2, a4);
                    e.a((net.one97.paytm.recharge.common.f.b) eVar6.element);
                    net.one97.paytm.recharge.common.f.d.a();
                    net.one97.paytm.recharge.common.f.d.b((net.one97.paytm.recharge.common.f.b) eVar6.element);
                }
            } else if (!TextUtils.isEmpty(str2) && (eVar2 = this.f64302b) != null) {
                s.a aVar3 = this;
                d dVar3 = d.f64967a;
                d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                k.c("2", "tag");
                k.c(aVar3, H5Event.TYPE_CALL_BACK);
                if (!ba.b(eVar2.f60938a)) {
                    Integer.valueOf(2);
                    eVar2.a("2", aVar3);
                    return;
                }
                c cVar2 = c.f62654a;
                String b3 = com.paytm.utility.c.b(c.be(), eVar2.f60938a);
                if (URLUtil.isValidUrl(b3)) {
                    CJRImpsRefundModel a6 = eVar2.a();
                    CJRImpsRefundBodyModel body = a6.getBody();
                    if (body != null) {
                        body.setAssetId(str2);
                    }
                    String a7 = new com.google.gsonhtcfix.f().a((Object) a6);
                    x.e eVar7 = new x.e();
                    eVar7.element = null;
                    Map hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    eVar7.element = new net.one97.paytm.recharge.common.f.c("2", b3, new e.C1178e(eVar2, eVar7, aVar3), new CJRImpsRefundModel(), (Map) null, hashMap, a7, (a.C0715a) null, (a.c) null, (a.b) null, (String) null, (String) null, (Object) null, 0, 0, 32640);
                    if (b.c(eVar2.f60938a)) {
                        e.a((net.one97.paytm.recharge.common.f.c) eVar7.element);
                        net.one97.paytm.recharge.common.f.d.a();
                        net.one97.paytm.recharge.common.f.d.b((net.one97.paytm.recharge.common.f.c) eVar7.element);
                        return;
                    }
                    return;
                }
                aVar3.a("2", new NetworkCustomError(), (Integer) 2);
                az azVar2 = az.f61525a;
                az.a(eVar2.f60938a, ERROR_TYPE.UNDEFINED, ACTION_TYPE.OS_CTA_CANCEL, "", eVar2.f60938a.getResources().getString(R.string.rc_msg_invalid_url));
            }
        } else if (!TextUtils.isEmpty(str2) && (eVar = this.f64302b) != null) {
            s.a aVar4 = this;
            d dVar4 = d.f64967a;
            CJRRechargeErrorModel a8 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            k.c("1", "tag");
            k.c(aVar4, H5Event.TYPE_CALL_BACK);
            if (!ba.b(eVar.f60938a)) {
                Integer.valueOf(1);
                eVar.a("1", aVar4);
                return;
            }
            c cVar3 = c.f62654a;
            String b4 = com.paytm.utility.c.b(c.bd(), eVar.f60938a);
            if (URLUtil.isValidUrl(b4)) {
                CJRImpsRefundModel a9 = eVar.a();
                CJRImpsRefundHeadModel head = a9.getHead();
                if (head != null) {
                    head.setVersion("1.0");
                }
                CJRImpsRefundBodyModel body2 = a9.getBody();
                if (body2 != null) {
                    body2.setUpiAccountId(str2);
                }
                String a10 = new com.google.gsonhtcfix.f().a((Object) a9);
                x.e eVar8 = new x.e();
                eVar8.element = null;
                Map hashMap2 = new HashMap();
                hashMap2.put("Content-Type", "application/json");
                eVar8.element = new net.one97.paytm.recharge.common.f.c("1", b4, (ai) new e.b(eVar, eVar8, aVar4), (IJRPaytmDataModel) new CJRImpsRefundModel(), (Map<String, String>) null, (Map<String, String>) hashMap2, a10, (Object) a8);
                if (b.c(eVar.f60938a)) {
                    e.a((net.one97.paytm.recharge.common.f.c) eVar8.element);
                    net.one97.paytm.recharge.common.f.d.a();
                    net.one97.paytm.recharge.common.f.d.b((net.one97.paytm.recharge.common.f.c) eVar8.element);
                    return;
                }
                return;
            }
            aVar4.a("1", new NetworkCustomError(), (Integer) 1);
            az azVar3 = az.f61525a;
            az.a(eVar.f60938a, ERROR_TYPE.UNDEFINED, ACTION_TYPE.OS_CTA_CANCEL, "", eVar.f60938a.getResources().getString(R.string.rc_msg_invalid_url));
        }
    }
}
