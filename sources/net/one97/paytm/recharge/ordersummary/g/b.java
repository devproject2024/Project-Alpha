package net.one97.paytm.recharge.ordersummary.g;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.paytm.utility.q;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJRFullFillmentObject;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.b.a;
import net.one97.paytm.recharge.ordersummary.f.c;
import net.one97.paytm.recharge.ordersummary.f.m;
import net.one97.paytm.recharge.ordersummary.h.c;
import org.json.JSONObject;

public final class b extends h {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(c cVar, m mVar) {
        super(cVar, mVar);
        k.c(cVar, "textRepository");
        k.c(mVar, "gtmEventListener");
    }

    public final SpannableString b(Context context, CJROSActionResponseV2 cJROSActionResponseV2) {
        String str;
        String str2;
        CJROSActionResponseV2 itemLevelActions;
        k.c(context, "context");
        String str3 = "";
        if (cJROSActionResponseV2 == null || (itemLevelActions = cJROSActionResponseV2.getItemLevelActions()) == null || (str = itemLevelActions.getMessage()) == null) {
            str = str3;
        }
        if (TextUtils.isEmpty(str)) {
            c cVar = this.f64305b;
            if (cVar != null) {
                e eVar = (e) cVar;
                a aVar = this.f64304a;
                if (aVar == null) {
                    k.a();
                }
                CJROrderedCart u = aVar.u();
                if (u == null) {
                    k.a();
                }
                CJROrderSummaryProductDetail productDetail = u.getProductDetail();
                if (productDetail != null) {
                    productDetail.getAttributes();
                }
                try {
                    CJRFullFillmentObject fullFillmentOject = u.getFullFillmentOject();
                    if (fullFillmentOject == null || (str2 = fullFillmentOject.getFulfillmentResponse()) == null) {
                        str2 = str3;
                    }
                    JSONObject jSONObject = new JSONObject(str2);
                    str3 = net.one97.paytm.recharge.ordersummary.h.c.f64331a.a(jSONObject, "opt_ref_id");
                    if (TextUtils.isEmpty(str3)) {
                        str3 = net.one97.paytm.recharge.ordersummary.h.c.f64331a.a(jSONObject, "operatorRefNumber");
                    }
                } catch (Exception e2) {
                    q.d(e2.getMessage());
                }
                String str4 = null;
                if (!TextUtils.isEmpty(str3)) {
                    int i2 = R.string.v8_os_ref_num_post_action_mobile_postpaid_prepaid_dth;
                    Object[] objArr = new Object[3];
                    String str5 = eVar.f64295g;
                    if (str5 != null) {
                        if (str5 != null) {
                            str4 = str5.toLowerCase();
                            k.a((Object) str4, "(this as java.lang.String).toLowerCase()");
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    objArr[0] = str4;
                    objArr[1] = eVar.f64291c;
                    objArr[2] = str3;
                    str = context.getString(i2, objArr);
                    k.a((Object) str, "context.getString(R.stri…Name, paymentReferenceNo)");
                } else {
                    int i3 = R.string.v8_os_default_post_action_dth;
                    Object[] objArr2 = new Object[1];
                    String str6 = eVar.f64295g;
                    if (str6 != null) {
                        if (str6 != null) {
                            str4 = str6.toLowerCase();
                            k.a((Object) str4, "(this as java.lang.String).toLowerCase()");
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    objArr2[0] = str4;
                    str = context.getString(i3, objArr2);
                    k.a((Object) str, "context.getString(R.stri…pitalized?.toLowerCase())");
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
            }
        }
        c.a aVar2 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
        return c.a.a(str, str3);
    }

    public final String f(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
        CJRAttributes attributes = productDetail != null ? productDetail.getAttributes() : null;
        if (attributes == null) {
            return "";
        }
        String rechargeNumberDisplayLabel = attributes.getRechargeNumberDisplayLabel();
        if (rechargeNumberDisplayLabel == null) {
            rechargeNumberDisplayLabel = "";
        }
        if (TextUtils.isEmpty(rechargeNumberDisplayLabel)) {
            c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
            StringBuilder sb = new StringBuilder();
            String operatorDisplayLabel = attributes.getOperatorDisplayLabel();
            if (operatorDisplayLabel == null) {
                operatorDisplayLabel = "";
            }
            sb.append(operatorDisplayLabel);
            sb.append(' ');
            String serviceDisplayLabel = attributes.getServiceDisplayLabel();
            if (serviceDisplayLabel == null) {
                serviceDisplayLabel = "";
            }
            sb.append(serviceDisplayLabel);
            String a2 = c.a.a(sb.toString());
            if (a2 == null) {
                return "";
            }
            return a2;
        }
        c.a aVar2 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
        String a3 = c.a.a(attributes.getOperatorDisplayLabel());
        if (a3 == null) {
            return "";
        }
        return a3;
    }

    public final String R(Context context) {
        CJROrderSummaryProductDetail productDetail;
        CJRAttributes attributes;
        k.c(context, "context");
        net.one97.paytm.recharge.ordersummary.f.c cVar = this.f64305b;
        if (cVar != null) {
            e eVar = (e) cVar;
            a aVar = this.f64304a;
            String str = null;
            CJROrderedCart u = aVar != null ? aVar.u() : null;
            if (!(u == null || (productDetail = u.getProductDetail()) == null || (attributes = productDetail.getAttributes()) == null)) {
                str = attributes.getRechargeNumberDisplayLabel();
            }
            if (!TextUtils.isEmpty(str)) {
                return super.R(context);
            }
            if (com.paytm.utility.b.c(eVar.f64294f)) {
                String string = context.getString(R.string.v8_os_order_storefront_dth_recharge_title_mobile, new Object[]{eVar.f64291c});
                k.a((Object) string, "context.getString(R.stri…obile, repo.operatorName)");
                return string;
            }
            String string2 = context.getString(R.string.v8_os_order_storefront_dth_recharge_title_subscription, new Object[]{eVar.f64291c});
            k.a((Object) string2, "context.getString(R.stri…ption, repo.operatorName)");
            return string2;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
    }
}
