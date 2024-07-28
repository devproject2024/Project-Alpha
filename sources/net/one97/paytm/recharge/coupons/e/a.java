package net.one97.paytm.recharge.coupons.e;

import android.content.Context;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import kotlin.g.a.q;
import kotlin.g.b.i;
import kotlin.g.b.k;
import kotlin.k.e;
import kotlin.x;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRSelectedRecharge;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.common.entity.shopping.CJROffers;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.be;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.coupons.b;
import net.one97.paytm.recharge.model.CJRCouponGrid;
import net.one97.paytm.recharge.model.CJRCouponHeader;
import net.one97.paytm.recharge.model.CJRPersonalInsurance;
import net.one97.paytm.recharge.model.CJRPromoCodeTerms;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.ordersummary.h.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends ai implements net.one97.paytm.recharge.common.e.ai {

    /* renamed from: a  reason: collision with root package name */
    public y<CJRPersonalInsurance> f62280a;

    /* renamed from: b  reason: collision with root package name */
    public y<CJRCouponHeader> f62281b;

    /* renamed from: c  reason: collision with root package name */
    public y<CJRCouponGrid> f62282c;

    /* renamed from: d  reason: collision with root package name */
    public y<CJROffers> f62283d;

    /* renamed from: e  reason: collision with root package name */
    public y<CJRDetailProduct> f62284e;

    /* renamed from: f  reason: collision with root package name */
    public y<CJRPromoCodeTerms> f62285f;

    /* renamed from: g  reason: collision with root package name */
    public final be<CJRInstruct> f62286g;

    /* renamed from: h  reason: collision with root package name */
    public final b f62287h;

    /* renamed from: i  reason: collision with root package name */
    public final w f62288i;
    public final String j;
    public final String k;
    public final CJRCartProduct l;
    public final String m;
    public final String n;
    public final String o;
    public final d p;
    private y<CJRRechargeCart> q;
    private final e<x> r;

    /* renamed from: net.one97.paytm.recharge.coupons.e.a$a  reason: collision with other inner class name */
    static final /* synthetic */ class C1197a extends i implements kotlin.g.a.b<CJRInstruct, x> {
        C1197a(a aVar) {
            super(1, aVar);
        }

        public final String getName() {
            return "performUIOperation";
        }

        public final kotlin.k.d getOwner() {
            return kotlin.g.b.y.b(a.class);
        }

        public final String getSignature() {
            return "performUIOperation(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            w wVar;
            k.c(cJRInstruct, "p1");
            a aVar = (a) this.receiver;
            k.c(cJRInstruct, "cjrInstruct");
            if (cJRInstruct instanceof CJRInstruct.showAlertDialog) {
                CJRInstruct.showAlertDialog showalertdialog = (CJRInstruct.showAlertDialog) cJRInstruct;
                aVar.f62286g.setValue(new CJRInstruct.showAlertDialog(showalertdialog.getTitle(), showalertdialog.getMessage(), showalertdialog.getActionButtonLabel(), showalertdialog.getAction(), showalertdialog.getErrorInfoDialog(), showalertdialog.getHawkEyeEvent()));
            } else if (cJRInstruct instanceof CJRInstruct.openPostOrderSummaryActivity) {
                CJRInstruct.openPostOrderSummaryActivity openpostordersummaryactivity = (CJRInstruct.openPostOrderSummaryActivity) cJRInstruct;
                aVar.f62286g.setValue(new CJRInstruct.openPostOrderSummaryActivity(openpostordersummaryactivity.getRechargePayment(), openpostordersummaryactivity.getRechargeCart(), openpostordersummaryactivity.getHawkEyeEvent()));
            } else if (cJRInstruct instanceof CJRInstruct.openRechargePaymentActivity) {
                CJRInstruct.openRechargePaymentActivity openrechargepaymentactivity = (CJRInstruct.openRechargePaymentActivity) cJRInstruct;
                aVar.f62286g.setValue(new CJRInstruct.openRechargePaymentActivity("", openrechargepaymentactivity.getRechargeCart(), openrechargepaymentactivity.getRechargePayment(), openrechargepaymentactivity.getHawkEyeEvent()));
            } else if (cJRInstruct instanceof CJRInstruct.onContainsError) {
                CJRInstruct.onContainsError oncontainserror = (CJRInstruct.onContainsError) cJRInstruct;
                aVar.f62286g.setValue(new CJRInstruct.onContainsError(oncontainserror.getMessage(), oncontainserror.getTag(), oncontainserror.getHawkEyeModel()));
            } else if (cJRInstruct instanceof CJRInstruct.saveRechargeCart) {
                aVar.f62286g.setValue(new CJRInstruct.saveRechargeCart(((CJRInstruct.saveRechargeCart) cJRInstruct).getRechargeCart()));
            } else if (cJRInstruct instanceof CJRInstruct.saveRechargePayment) {
                aVar.f62286g.setValue(new CJRInstruct.saveRechargePayment(((CJRInstruct.saveRechargePayment) cJRInstruct).getRechargePayment()));
            } else if ((cJRInstruct instanceof CJRInstruct.openSubscriberBottomSheet) && (wVar = aVar.f62288i) != null) {
                w.a(wVar, (JSONArray) null, (Object) null, 3);
            }
        }
    }

    public a(b bVar, w wVar, e<x> eVar, String str, String str2, CJRCartProduct cJRCartProduct, String str3, String str4, String str5, d dVar) {
        k.c(bVar, "rechargeRepo");
        k.c(wVar, "rechargeProceedHelper");
        k.c(str, "productMasterNumber");
        k.c(str2, "rechargeMasterPrice");
        k.c(str3, "productMasterId");
        k.c(str4, StringSet.operator);
        k.c(str5, "circle");
        k.c(dVar, "gtmEventHelper");
        this.f62287h = bVar;
        this.f62288i = wVar;
        this.r = eVar;
        this.j = str;
        this.k = str2;
        this.l = cJRCartProduct;
        this.m = str3;
        this.n = str4;
        this.o = str5;
        this.p = dVar;
        this.f62280a = new y<>();
        this.f62281b = new y<>();
        this.f62282c = new y<>();
        this.f62283d = new y<>();
        this.q = new y<>();
        this.f62284e = new y<>();
        this.f62285f = new y<>();
        this.f62286g = new be<>();
        w wVar2 = this.f62288i;
        wVar2.f61789i = this.f62287h;
        wVar2.f61788h = this.r;
        wVar2.f61787g = new C1197a(this);
    }

    public final void a(String str, int i2, String str2, ArrayList<CJRSelectedRecharge> arrayList) {
        k.c(str, "url");
        k.c(str2, "rechargeNumber");
        k.c(arrayList, "selectedRechargeList");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        a2.setErrorType(ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setActionType(ACTION_TYPE.FETCH_DEAL_LIST.name());
        }
        this.f62287h.a("fetch_coupon_list", this, str, i2, str2, arrayList, this.n, this.o, a2);
    }

    public final y<CJRRechargeCart> a(String str, JSONObject jSONObject, net.one97.paytm.recharge.common.e.ai aiVar, Object obj) {
        k.c(str, "tag");
        k.c(jSONObject, "jsonCart");
        this.q.setValue(null);
        this.q.setValue(new CJRRechargeCart());
        if (obj instanceof CJRRechargeErrorModel) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            String a2 = net.one97.paytm.recharge.widgets.c.d.a(jSONObject);
            CRUFlowModel flowName = ((CJRRechargeErrorModel) obj).getFlowName();
            if (flowName != null) {
                flowName.setRequestBody(a2);
            }
        }
        b bVar = this.f62287h;
        if (aiVar == null) {
            aiVar = this;
        }
        bVar.a(str, aiVar, jSONObject, "coupon", a.b.USER_FACING, obj, 0, true);
        return this.q;
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        k.c(str, "tag");
        switch (str.hashCode()) {
            case -810965633:
                if (str.equals("fetch_deal_detail")) {
                    if (iJRPaytmDataModel instanceof CJRDetailProduct) {
                        this.f62284e.setValue(iJRPaytmDataModel);
                        return;
                    }
                    return;
                }
                break;
            case -70453332:
                if (str.equals("deal_verify")) {
                    if (iJRPaytmDataModel instanceof CJRRechargeCart) {
                        this.q.postValue(iJRPaytmDataModel);
                        az azVar = az.f61525a;
                        if (az.a((Context) null, (CJRRechargeCart) iJRPaytmDataModel, false, false).getBoolean("extra.has.error") && (obj instanceof CJRRechargeErrorModel)) {
                            az azVar2 = az.f61525a;
                            az.a((CJRRechargeErrorModel) obj);
                            return;
                        }
                        return;
                    }
                    return;
                }
                break;
            case 267720212:
                if (str.equals("fetch_insurance_data")) {
                    if (iJRPaytmDataModel instanceof CJRPersonalInsurance) {
                        this.f62280a.setValue(iJRPaytmDataModel);
                        return;
                    }
                    return;
                }
                break;
            case 892583754:
                if (str.equals("fetch_promo")) {
                    if (iJRPaytmDataModel instanceof CJROffers) {
                        this.f62283d.setValue(iJRPaytmDataModel);
                        return;
                    }
                    return;
                }
                break;
            case 1503450898:
                if (str.equals("fetch_coupon_list")) {
                    if (iJRPaytmDataModel instanceof CJRCouponGrid) {
                        this.f62282c.setValue(iJRPaytmDataModel);
                        return;
                    }
                    return;
                }
                break;
            case 1588542465:
                if (str.equals("fetch_coupon_header")) {
                    if (iJRPaytmDataModel instanceof CJRCouponHeader) {
                        this.f62281b.setValue(iJRPaytmDataModel);
                        return;
                    }
                    return;
                }
                break;
        }
        if (iJRPaytmDataModel instanceof CJRRechargeCart) {
            this.q.setValue(iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRPromoCodeTerms) {
            this.f62285f.setValue(iJRPaytmDataModel);
        }
    }

    public static String a() {
        net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
        if (net.one97.paytm.recharge.common.utils.y.g() == null) {
            return "";
        }
        az azVar = az.f61525a;
        net.one97.paytm.recharge.common.utils.y yVar2 = net.one97.paytm.recharge.common.utils.y.f61814b;
        JSONObject g2 = net.one97.paytm.recharge.common.utils.y.g();
        if (g2 == null) {
            k.a();
        }
        String a2 = az.a(g2);
        if (a2 == null) {
            return "";
        }
        return a2;
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
        switch (str.hashCode()) {
            case -810965633:
                if (str.equals("fetch_deal_detail")) {
                    e<x> eVar = this.r;
                    if (eVar != null) {
                        ((q) eVar).invoke(str, networkCustomError, obj);
                        return;
                    }
                    return;
                }
                break;
            case -70453332:
                if (str.equals("deal_verify")) {
                    e<x> eVar2 = this.r;
                    if (eVar2 != null) {
                        ((q) eVar2).invoke(str, networkCustomError, obj);
                        return;
                    }
                    return;
                }
                break;
            case 267720212:
                if (str.equals("fetch_insurance_data")) {
                    e<x> eVar3 = this.r;
                    if (eVar3 != null) {
                        ((q) eVar3).invoke(str, networkCustomError, obj);
                        return;
                    }
                    return;
                }
                break;
            case 892583754:
                if (str.equals("fetch_promo")) {
                    e<x> eVar4 = this.r;
                    if (eVar4 != null) {
                        ((q) eVar4).invoke(str, networkCustomError, obj);
                        return;
                    }
                    return;
                }
                break;
            case 1503450898:
                if (str.equals("fetch_coupon_list")) {
                    e<x> eVar5 = this.r;
                    if (eVar5 != null) {
                        ((q) eVar5).invoke(str, networkCustomError, obj);
                        return;
                    }
                    return;
                }
                break;
            case 1588542465:
                if (str.equals("fetch_coupon_header")) {
                    e<x> eVar6 = this.r;
                    if (eVar6 != null) {
                        ((q) eVar6).invoke(str, networkCustomError, obj);
                        return;
                    }
                    return;
                }
                break;
            case 2015626909:
                if (str.equals("fetch_promo_term_condition")) {
                    if (obj instanceof CJRRechargeErrorModel) {
                        String name = ERROR_TYPE.NO_CONNECTION.name();
                        CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                        CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
                        String str2 = null;
                        if (!k.a((Object) name, (Object) flowName != null ? flowName.getErrorType() : null)) {
                            String name2 = ERROR_TYPE.INVALID_URL.name();
                            CRUFlowModel flowName2 = cJRRechargeErrorModel.getFlowName();
                            if (flowName2 != null) {
                                str2 = flowName2.getErrorType();
                            }
                            if (!k.a((Object) name2, (Object) str2)) {
                                e<x> eVar7 = this.r;
                                if (eVar7 != null) {
                                    ((q) eVar7).invoke(str, networkCustomError, obj);
                                    return;
                                }
                                return;
                            }
                        }
                        az azVar = az.f61525a;
                        az.a(cJRRechargeErrorModel);
                        return;
                    }
                    return;
                }
                break;
        }
        e<x> eVar8 = this.r;
        if (eVar8 != null) {
            ((q) eVar8).invoke(str, networkCustomError, obj);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(net.one97.paytm.recharge.common.h.d.a r13) {
        /*
            r12 = this;
            java.lang.String r0 = "builder"
            kotlin.g.b.k.c(r13, r0)
            net.one97.paytm.recharge.common.b.c r0 = r13.f61429b
            if (r0 == 0) goto L_0x0032
            r2 = r0
            net.one97.paytm.recharge.coupons.b r2 = (net.one97.paytm.recharge.coupons.b) r2
            net.one97.paytm.recharge.common.utils.w r3 = r13.f61430c
            if (r3 != 0) goto L_0x0013
            kotlin.g.b.k.a()
        L_0x0013:
            kotlin.k.e<kotlin.x> r4 = r13.f61431d
            if (r4 != 0) goto L_0x001a
            kotlin.g.b.k.a()
        L_0x001a:
            java.lang.String r5 = r13.f61433f
            java.lang.String r6 = r13.f61434g
            net.one97.paytm.common.entity.shopping.CJRCartProduct r7 = r13.f61435h
            java.lang.String r8 = r13.f61436i
            java.lang.String r9 = r13.j
            java.lang.String r10 = r13.k
            net.one97.paytm.recharge.ordersummary.h.d r11 = r13.f61432e
            if (r11 != 0) goto L_0x002d
            kotlin.g.b.k.a()
        L_0x002d:
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        L_0x0032:
            kotlin.u r13 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.recharge.coupons.CJRCouponRepository"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.coupons.e.a.<init>(net.one97.paytm.recharge.common.h.d$a):void");
    }
}
