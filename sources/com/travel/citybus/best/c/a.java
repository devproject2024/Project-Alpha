package com.travel.citybus.best.c;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.d;
import com.travel.citybus.best.b.a;
import com.travel.citybus.best.model.BestEPurse;
import com.travel.citybus.best.model.BestEPurseRechargeParams;
import com.travel.citybus.brts.f;
import com.travel.citybus.brts.model.CJRBCLLWithdraw;
import com.travel.citybus.brts.model.pojo.CJRCity;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    boolean f23034a;

    /* renamed from: b  reason: collision with root package name */
    Timer f23035b = new Timer();

    /* renamed from: c  reason: collision with root package name */
    final a.C0443a f23036c;

    /* renamed from: d  reason: collision with root package name */
    private final CJRCity f23037d;

    /* renamed from: e  reason: collision with root package name */
    private final BestEPurse f23038e;

    public a(a.C0443a aVar, CJRCity cJRCity, BestEPurse bestEPurse) {
        k.c(aVar, "view");
        this.f23036c = aVar;
        this.f23037d = cJRCity;
        this.f23038e = bestEPurse;
    }

    public final void a(Context context, String str, boolean z, float f2) {
        String str2;
        k.c(context, "context");
        k.c(str, "walletToken");
        k.a((Object) f.d(), "TransportBrtsController.getInstance()");
        String a2 = f.e().a("cityBusEPurseRechargeUrl");
        if (TextUtils.isEmpty(a2)) {
            a2 = com.travel.citybus.brts.a.l;
        }
        String str3 = a2 + com.paytm.utility.c.a(context, false);
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("wallet_token", str);
        String a3 = d.a(context);
        k.a((Object) a3, "CJRNetUtility.getSSOToken(context)");
        hashMap.put(AppConstants.SSO_TOKEN, a3);
        BestEPurseRechargeParams bestEPurseRechargeParams = new BestEPurseRechargeParams();
        CJRCity cJRCity = this.f23037d;
        String str4 = null;
        bestEPurseRechargeParams.setMerchant_id(cJRCity != null ? cJRCity.getMerchantId() : null);
        CJRCity cJRCity2 = this.f23037d;
        bestEPurseRechargeParams.setProduct_id(cJRCity2 != null ? cJRCity2.getProductId() : null);
        bestEPurseRechargeParams.setIs_fast_forward(z ? 1 : 0);
        bestEPurseRechargeParams.setTotal_amount(Float.valueOf(f2));
        BestEPurse bestEPurse = this.f23038e;
        if (bestEPurse == null || (str2 = bestEPurse.getPassNumber()) == null) {
            str2 = "";
        }
        bestEPurseRechargeParams.setPass_number(str2);
        BestEPurse bestEPurse2 = this.f23038e;
        if (bestEPurse2 != null) {
            str4 = bestEPurse2.getPassNumber();
        }
        bestEPurseRechargeParams.setOperation_type(str4 == null ? "ISSUE" : "RECHARGE");
        com.travel.citybus.brts.b.a.a();
        com.travel.citybus.brts.b.a.a(context, str3, (Map) null, hashMap, new com.google.gson.f().b(bestEPurseRechargeParams), new CJRBCLLWithdraw(), new c(this));
        this.f23034a = false;
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23045a;

        c(a aVar) {
            this.f23045a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f23045a.f23036c.a(com.travel.citybus.best.e.a.a(networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRBCLLWithdraw) {
                a.C0443a aVar = this.f23045a.f23036c;
                CJRRechargePayment response = ((CJRBCLLWithdraw) iJRPaytmDataModel).getResponse();
                k.a((Object) response, "response?.response");
                aVar.a(response);
            }
        }
    }

    public final void a(Context context, String str) {
        k.c(context, "context");
        k.c(str, "orderId");
        StringBuilder sb = new StringBuilder();
        k.a((Object) f.d(), "TransportBrtsController.getInstance()");
        com.travel.citybus.a e2 = f.e();
        k.a((Object) e2, "TransportBrtsController.…ransportBrtsEventListener");
        sb.append(e2.b());
        sb.append(str);
        String b2 = com.paytm.utility.c.b(sb.toString(), context);
        k.a((Object) b2, "CJRDefaultRequestParam.g…lWithoutSSO(url, context)");
        Map hashMap = new HashMap();
        String a2 = d.a(context);
        k.a((Object) a2, "CJRNetUtility.getSSOToken(context)");
        hashMap.put(AppConstants.SSO_TOKEN, a2);
        com.travel.citybus.brts.b.a.a();
        com.travel.citybus.brts.b.a.a(context, (b2 + "&actions=0") + "&post_payment=1", hashMap, new CJROrderSummary(), new C0444a(this, str, context));
    }

    /* renamed from: com.travel.citybus.best.c.a$a  reason: collision with other inner class name */
    public static final class C0444a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23039a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f23040b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f23041c;

        C0444a(a aVar, String str, Context context) {
            this.f23039a = aVar;
            this.f23040b = str;
            this.f23041c = context;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f23039a.f23036c.R_();
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x0086  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0095  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r9) {
            /*
                r8 = this;
                boolean r0 = r9 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummary
                if (r0 == 0) goto L_0x009a
                com.travel.citybus.best.c.a r0 = r8.f23039a
                net.one97.paytm.common.entity.shopping.CJROrderSummary r9 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r9
                java.lang.String r1 = r8.f23040b
                android.content.Context r2 = r8.f23041c
                com.travel.citybus.best.a.a r3 = com.travel.citybus.best.a.a.FAILED
                r4 = 0
                if (r9 == 0) goto L_0x0016
                java.lang.String r5 = r9.getPaymentStatus()
                goto L_0x0017
            L_0x0016:
                r5 = r4
            L_0x0017:
                r6 = 1
                java.lang.String r7 = "failed"
                boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r7, (boolean) r6)
                if (r5 != 0) goto L_0x007c
                if (r9 == 0) goto L_0x0026
                java.lang.String r4 = r9.getPaymentStatus()
            L_0x0026:
                java.lang.String r5 = "processing"
                boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r5, (boolean) r6)
                if (r4 == 0) goto L_0x0031
                com.travel.citybus.best.a.a r3 = com.travel.citybus.best.a.a.PENDING
                goto L_0x007e
            L_0x0031:
                java.util.ArrayList r4 = r9.getOrderedCartList()
                if (r4 == 0) goto L_0x007e
                java.util.ArrayList r4 = r9.getOrderedCartList()
                int r4 = r4.size()
                if (r4 <= 0) goto L_0x007e
                java.util.ArrayList r9 = r9.getOrderedCartList()
                r3 = 0
                java.lang.Object r9 = r9.get(r3)
                net.one97.paytm.common.entity.shopping.CJROrderedCart r9 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r9
                java.lang.String r3 = "cjrOrderedCart"
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r3)
                java.lang.String r9 = r9.getItemStatus()
                java.lang.String r3 = "1"
                boolean r3 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r3)
                if (r3 != 0) goto L_0x0079
                java.lang.String r3 = "2"
                boolean r3 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r3)
                if (r3 != 0) goto L_0x0079
                java.lang.String r3 = "5"
                boolean r3 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r3)
                if (r3 == 0) goto L_0x006e
                goto L_0x0079
            L_0x006e:
                java.lang.String r3 = "7"
                boolean r9 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r3)
                if (r9 == 0) goto L_0x007c
                com.travel.citybus.best.a.a r3 = com.travel.citybus.best.a.a.SUCCESS
                goto L_0x007e
            L_0x0079:
                com.travel.citybus.best.a.a r3 = com.travel.citybus.best.a.a.PENDING
                goto L_0x007e
            L_0x007c:
                com.travel.citybus.best.a.a r3 = com.travel.citybus.best.a.a.FAILED
            L_0x007e:
                boolean r9 = r0.f23034a
                if (r9 != 0) goto L_0x0095
                com.travel.citybus.best.a.a r9 = com.travel.citybus.best.a.a.PENDING
                if (r3 != r9) goto L_0x0095
                java.util.Timer r9 = r0.f23035b
                com.travel.citybus.best.c.a$b r3 = new com.travel.citybus.best.c.a$b
                r3.<init>(r0, r2, r1)
                java.util.TimerTask r3 = (java.util.TimerTask) r3
                r0 = 6000(0x1770, double:2.9644E-320)
                r9.schedule(r3, r0)
                return
            L_0x0095:
                com.travel.citybus.best.b.a$a r9 = r0.f23036c
                r9.a((com.travel.citybus.best.a.a) r3)
            L_0x009a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.best.c.a.C0444a.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
        }
    }

    public static final class b extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23042a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f23043b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f23044c;

        b(a aVar, Context context, String str) {
            this.f23042a = aVar;
            this.f23043b = context;
            this.f23044c = str;
        }

        public final void run() {
            this.f23042a.a(this.f23043b, this.f23044c);
            this.f23042a.f23034a = true;
        }
    }
}
