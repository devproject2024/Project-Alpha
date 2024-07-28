package net.one97.paytm.addmoney.towallet.c;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.databinding.i;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;

public final class c extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f48841a;

    /* renamed from: b  reason: collision with root package name */
    public i<String> f48842b = new i<>();

    /* renamed from: c  reason: collision with root package name */
    public d f48843c;

    /* renamed from: d  reason: collision with root package name */
    public y<d> f48844d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<Boolean> f48845e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<Integer> f48846f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public y<com.paytm.network.a> f48847g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public y<IJRPaytmDataModel> f48848h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public y<o<IJRPaytmDataModel, NetworkCustomError>> f48849i = new y<>();
    public CJROrderSummary j;
    private final int k = net.one97.paytm.helper.a.f50546a.a().h("addmoney_total_polling_count");
    private final int l = net.one97.paytm.helper.a.f50546a.a().h("addMoney_polling_gap_in_seconds");
    private final long m = TimeUnit.SECONDS.toMillis((long) this.l);
    private final long n = ((long) this.k);
    private int o;
    /* access modifiers changed from: private */
    public String p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final void a(d dVar) {
        k.c(dVar, "state");
        if (!this.f48841a || dVar != d.SUCCESS_INITIAL) {
            this.f48843c = dVar;
            this.f48844d.setValue(dVar);
            return;
        }
        this.f48843c = d.SUCCESS_DETAIL;
        this.f48844d.setValue(d.SUCCESS_DETAIL);
    }

    public final void a(String str, boolean z) {
        this.p = str;
        if (!TextUtils.isEmpty(this.p)) {
            this.o++;
            net.one97.paytm.addmoney.towallet.b.a.a aVar = net.one97.paytm.addmoney.towallet.b.a.a.f48829a;
            com.paytm.network.a a2 = net.one97.paytm.addmoney.towallet.b.a.a.a(getApplication(), str, new b(this, z));
            if (a2 != null) {
                a(a2);
            }
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f48853a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f48854b;

        b(c cVar, boolean z) {
            this.f48853a = cVar;
            this.f48854b = z;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f48853a.f48849i.postValue(new o(iJRPaytmDataModel, networkCustomError));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
            r5 = (r5 = r5.getOrderedCartList()).get(0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r5) {
            /*
                r4 = this;
                boolean r0 = r5 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummary
                if (r0 == 0) goto L_0x0018
                net.one97.paytm.addmoney.towallet.c.c r0 = r4.f48853a
                net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r5
                boolean r1 = r4.f48854b
                android.app.Application r2 = r0.getApplication()
                java.lang.String r3 = "getApplication()"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                android.content.Context r2 = (android.content.Context) r2
                net.one97.paytm.addmoney.towallet.c.c.a(r0, r5, r1, r2)
            L_0x0018:
                net.one97.paytm.addmoney.towallet.c.c r5 = r4.f48853a
                net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r5.j
                if (r5 == 0) goto L_0x0083
                net.one97.paytm.addmoney.towallet.c.c r5 = r4.f48853a
                net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r5.j
                r0 = 0
                if (r5 == 0) goto L_0x002a
                java.util.ArrayList r5 = r5.getOrderedCartList()
                goto L_0x002b
            L_0x002a:
                r5 = r0
            L_0x002b:
                if (r5 == 0) goto L_0x0083
                net.one97.paytm.addmoney.towallet.c.c r5 = r4.f48853a
                net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r5.j
                r1 = 0
                if (r5 == 0) goto L_0x0047
                java.util.ArrayList r5 = r5.getOrderedCartList()
                if (r5 == 0) goto L_0x0047
                java.lang.Object r5 = r5.get(r1)
                net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r5
                if (r5 == 0) goto L_0x0047
                net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r5 = r5.getFullFillmentOject()
                goto L_0x0048
            L_0x0047:
                r5 = r0
            L_0x0048:
                if (r5 == 0) goto L_0x0083
                net.one97.paytm.addmoney.towallet.c.c r5 = r4.f48853a
                net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r5.j
                if (r5 == 0) goto L_0x006c
                java.util.ArrayList r5 = r5.getOrderedCartList()
                if (r5 == 0) goto L_0x006c
                java.lang.Object r5 = r5.get(r1)
                net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r5
                if (r5 == 0) goto L_0x006c
                net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r5 = r5.getFullFillmentOject()
                if (r5 == 0) goto L_0x006c
                double r0 = r5.getBalance()
                java.lang.Double r0 = java.lang.Double.valueOf(r0)
            L_0x006c:
                if (r0 == 0) goto L_0x0083
                r5 = r0
                java.lang.Number r5 = (java.lang.Number) r5
                r5.doubleValue()
                net.one97.paytm.addmoney.towallet.c.c r5 = r4.f48853a
                android.app.Application r5 = r5.getApplication()
                android.content.Context r5 = (android.content.Context) r5
                double r0 = r0.doubleValue()
                net.one97.paytm.addmoney.utils.j.c((android.content.Context) r5, (double) r0)
            L_0x0083:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.towallet.c.c.b.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
        }
    }

    private void a(CJROrderSummary cJROrderSummary, boolean z, boolean z2) {
        if (!z) {
            if (z2) {
                a(d.FULLFILMENT_PENDING);
            } else {
                a(d.PENDING);
            }
            this.f48848h.postValue(cJROrderSummary);
        } else if (((long) this.o) > this.n) {
            if (z2) {
                a(d.FULLFILMENT_PENDING);
            } else {
                a(d.PENDING);
            }
            this.f48848h.postValue(cJROrderSummary);
        } else {
            new Handler().postDelayed(new a(this, z, z2), this.m);
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f48850a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f48851b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f48852c;

        a(c cVar, boolean z, boolean z2) {
            this.f48850a = cVar;
            this.f48851b = z;
            this.f48852c = z2;
        }

        public final void run() {
            try {
                this.f48850a.a(this.f48850a.p, this.f48851b);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (this.f48852c) {
                    this.f48850a.a(d.FULLFILMENT_PENDING);
                } else {
                    this.f48850a.a(d.PENDING);
                }
            }
        }
    }

    public final void a(com.paytm.network.a aVar) {
        k.c(aVar, "networkCall");
        if (com.paytm.network.b.b.a(getApplication())) {
            a(d.LOADING);
            aVar.a();
            return;
        }
        this.f48847g.postValue(aVar);
    }

    public static String a(CJROrderSummary cJROrderSummary) {
        if (cJROrderSummary.getPaymentInfo() == null || cJROrderSummary.getPaymentInfo().size() <= 0) {
            return null;
        }
        CJROrderSummaryPayment cJROrderSummaryPayment = cJROrderSummary.getPaymentInfo().get(0);
        k.a((Object) cJROrderSummaryPayment, CJRRechargeCart.KEY_PAYMENT_INFO);
        return cJROrderSummaryPayment.getPaymentMethod();
    }

    public static final /* synthetic */ void a(c cVar, CJROrderSummary cJROrderSummary, boolean z, Context context) {
        cVar.j = cJROrderSummary;
        if (cJROrderSummary != null && cJROrderSummary.getOrderedCartList() != null && cJROrderSummary.getOrderedCartList().size() > 0) {
            int orderStatus = cJROrderSummary.getOrderStatus();
            CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(0);
            k.a((Object) cJROrderedCart, "orderSummary.orderedCartList[0]");
            String itemStatus = cJROrderedCart.getItemStatus();
            if (2 == orderStatus) {
                if (p.a("20", itemStatus, true) || p.a("7", itemStatus, true)) {
                    cVar.a(d.SUCCESS_INITIAL);
                    cVar.f48848h.postValue(cJROrderSummary);
                } else if (p.a("2", itemStatus, true) || p.a("5", itemStatus, true) || p.a("15", itemStatus, true)) {
                    cVar.a(cJROrderSummary, z, true);
                } else if (p.a("6", itemStatus, true) || p.a("8", itemStatus, true) || p.a("18", itemStatus, true)) {
                    cVar.a(d.FAILURE);
                    cJROrderSummary.setmPaymentText(context.getString(R.string.fullfillment_failure_text));
                    cVar.f48848h.postValue(cJROrderSummary);
                }
            } else if (1 == orderStatus || 3 == orderStatus) {
                cVar.a(cJROrderSummary, z, false);
            } else if (4 == orderStatus || 8 == orderStatus) {
                cVar.a(d.FAILURE);
                cVar.f48848h.postValue(cJROrderSummary);
            } else {
                cVar.a(cJROrderSummary, z, false);
            }
        }
    }
}
