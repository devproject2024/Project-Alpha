package com.travel.citybus.best.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.citybus.R;
import com.travel.citybus.best.e.d;
import com.travel.citybus.best.ui.a.h;
import com.travel.citybus.brts.CJRActionBarBaseActivity;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;

public final class CityBusRechargeOrderSummaryActivity extends CJRActionBarBaseActivity implements h.a {
    private HashMap _$_findViewCache;
    private int colorFailed;
    private int colorPending;
    private int colorSuccess;
    /* access modifiers changed from: private */
    public boolean didRetry;
    private Handler handler;
    private boolean isPostPayment;
    private String orderId;
    /* access modifiers changed from: private */
    public CJROrderSummary orderSummary;
    /* access modifiers changed from: private */
    public h paymentDetailsFragment;

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCancel() {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_city_bus_recharge_status);
        this.handler = new Handler();
        getIntentExtras();
        initResources();
        getOrderDetails();
    }

    public final void onDestroy() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
        this.handler = null;
        super.onDestroy();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void getIntentExtras() {
        /*
            r2 = this;
            android.content.Intent r0 = r2.getIntent()
            if (r0 == 0) goto L_0x0013
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x0013
            java.lang.String r1 = "order_id"
            java.lang.String r0 = r0.getString(r1)
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            r2.orderId = r0
            android.content.Intent r0 = r2.getIntent()
            if (r0 == 0) goto L_0x0029
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x0029
            java.lang.String r1 = "is_from_payment"
            boolean r0 = r0.getBoolean(r1)
            goto L_0x002a
        L_0x0029:
            r0 = 0
        L_0x002a:
            r2.isPostPayment = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.best.ui.activities.CityBusRechargeOrderSummaryActivity.getIntentExtras():void");
    }

    private final void initResources() {
        this.colorPending = getResources().getColor(R.color.city_bus_color_pending);
        this.colorSuccess = getResources().getColor(R.color.city_bus_color_success);
        this.colorFailed = getResources().getColor(R.color.city_bus_color_failure);
    }

    /* access modifiers changed from: private */
    public final void getOrderDetails() {
        if (this.orderId != null) {
            showProgress(true);
            com.travel.citybus.best.d.a aVar = com.travel.citybus.best.d.a.f23050a;
            Context context = this;
            String str = this.orderId;
            if (str == null) {
                k.a();
            }
            com.travel.citybus.best.d.a.a(context, str, this.isPostPayment, (com.paytm.network.listener.b) new a(this));
        }
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CityBusRechargeOrderSummaryActivity f23129a;

        a(CityBusRechargeOrderSummaryActivity cityBusRechargeOrderSummaryActivity) {
            this.f23129a = cityBusRechargeOrderSummaryActivity;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f23129a.showProgress(false);
            d.a aVar = com.travel.citybus.best.e.d.f23053a;
            CityBusRechargeOrderSummaryActivity cityBusRechargeOrderSummaryActivity = this.f23129a;
            String string = cityBusRechargeOrderSummaryActivity.getString(R.string.brts_error);
            k.a((Object) string, "getString(R.string.brts_error)");
            String string2 = this.f23129a.getString(R.string.brts_some_went_wrong);
            k.a((Object) string2, "getString(R.string.brts_some_went_wrong)");
            d.a.a(cityBusRechargeOrderSummaryActivity, string, string2);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f23129a.showProgress(false);
            if (iJRPaytmDataModel instanceof CJROrderSummary) {
                this.f23129a.orderSummary = (CJROrderSummary) iJRPaytmDataModel;
                this.f23129a.processOrderSummary();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showProgress(boolean z) {
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.progressBar);
        k.a((Object) progressBar, "progressBar");
        progressBar.setVisibility(z ? 0 : 8);
    }

    /* access modifiers changed from: private */
    public final void processOrderSummary() {
        com.travel.citybus.best.a.a aVar = com.travel.citybus.best.a.a.FAILED;
        CJROrderSummary cJROrderSummary = this.orderSummary;
        String str = null;
        if (p.a(cJROrderSummary != null ? cJROrderSummary.getPaymentStatus() : null, "failed", true)) {
            aVar = com.travel.citybus.best.a.a.FAILED;
        } else {
            CJROrderSummary cJROrderSummary2 = this.orderSummary;
            if (cJROrderSummary2 != null) {
                str = cJROrderSummary2.getPaymentStatus();
            }
            if (p.a(str, "processing", true)) {
                aVar = com.travel.citybus.best.a.a.PENDING;
            } else {
                CJROrderSummary cJROrderSummary3 = this.orderSummary;
                if (!(cJROrderSummary3 == null || cJROrderSummary3.getOrderedCartList() == null || cJROrderSummary3.getOrderedCartList().size() <= 0)) {
                    CJROrderedCart cJROrderedCart = cJROrderSummary3.getOrderedCartList().get(0);
                    k.a((Object) cJROrderedCart, "cjrOrderedCart");
                    String itemStatus = cJROrderedCart.getItemStatus();
                    aVar = (k.a((Object) itemStatus, (Object) "1") || k.a((Object) itemStatus, (Object) "2") || k.a((Object) itemStatus, (Object) "5")) ? com.travel.citybus.best.a.a.PENDING : k.a((Object) itemStatus, (Object) "7") ? com.travel.citybus.best.a.a.SUCCESS : com.travel.citybus.best.a.a.FAILED;
                }
            }
        }
        setViews(aVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v31, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: com.travel.citybus.best.model.BestFulfilment} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setViews(com.travel.citybus.best.a.a r12) {
        /*
            r11 = this;
            int r0 = com.travel.citybus.R.id.nsvContainer
            android.view.View r0 = r11._$_findCachedViewById(r0)
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            java.lang.String r1 = "nsvContainer"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 0
            r0.setVisibility(r1)
            int r0 = com.travel.citybus.R.id.rsNoteTv
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = "rsNoteTv"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r3 = 8
            r0.setVisibility(r3)
            int r0 = com.travel.citybus.R.id.tvEPurseRechargeTime
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = "tvEPurseRechargeTime"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r1)
            int r0 = com.travel.citybus.R.id.tvViewPaymentDetails
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r5 = "tvViewPaymentDetails"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r0.setVisibility(r1)
            int r0 = com.travel.citybus.R.id.tvPaymentTime
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r6 = "tvPaymentTime"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            com.travel.citybus.best.e.c r6 = com.travel.citybus.best.e.c.f23051a
            net.one97.paytm.common.entity.shopping.CJROrderSummary r6 = r11.orderSummary
            r7 = 0
            if (r6 == 0) goto L_0x005f
            java.lang.String r6 = r6.getCreatedAt()
            goto L_0x0060
        L_0x005f:
            r6 = r7
        L_0x0060:
            java.lang.String r8 = "hh:mm a, dd MMM yyyy"
            java.lang.String r6 = com.travel.citybus.best.e.c.a((java.lang.String) r6, (java.lang.String) r8)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
            int r0 = com.travel.citybus.R.id.tvEPurseRechargeTime
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            com.travel.citybus.best.e.c r4 = com.travel.citybus.best.e.c.f23051a
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r11.orderSummary
            if (r4 == 0) goto L_0x0081
            java.lang.String r4 = r4.getCreatedAt()
            goto L_0x0082
        L_0x0081:
            r4 = r7
        L_0x0082:
            java.lang.String r4 = com.travel.citybus.best.e.c.a((java.lang.String) r4, (java.lang.String) r8)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
            int r0 = com.travel.citybus.R.id.tvOrderId
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = "tvOrderId"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "Order ID : "
            r4.<init>(r6)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r6 = r11.orderSummary
            if (r6 == 0) goto L_0x00a9
            java.lang.String r6 = r6.getId()
            goto L_0x00aa
        L_0x00a9:
            r6 = r7
        L_0x00aa:
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
            int r0 = com.travel.citybus.R.id.tvOrderAmount
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = "tvOrderAmount"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r11.orderSummary
            if (r4 == 0) goto L_0x00d1
            double r8 = r4.getGrandTotal()
            java.lang.Double r4 = java.lang.Double.valueOf(r8)
            goto L_0x00d2
        L_0x00d1:
            r4 = r7
        L_0x00d2:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r4 = com.travel.citybus.best.e.b.a((java.lang.String) r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
            kotlin.g.b.x$e r0 = new kotlin.g.b.x$e
            r0.<init>()
            r0.element = r7
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r11.orderSummary
            r6 = 1
            if (r4 == 0) goto L_0x0198
            java.util.ArrayList r4 = r4.getOrderedCartList()
            if (r4 == 0) goto L_0x0198
            r8 = r4
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            r8 = r8 ^ r6
            if (r8 == 0) goto L_0x0198
            java.lang.Object r8 = r4.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r8 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r8
            java.lang.Object r8 = r8.mMetaDataResponse
            if (r8 == 0) goto L_0x0137
            boolean r9 = r8 instanceof java.util.Map
            if (r9 == 0) goto L_0x0137
            java.util.Map r8 = (java.util.Map) r8
            java.lang.String r9 = "display_merchant_name"
            java.lang.Object r8 = r8.get(r9)
            if (r8 == 0) goto L_0x012f
            java.lang.String r8 = (java.lang.String) r8
            r0.element = r8
            int r8 = com.travel.citybus.R.id.tvMerchantName
            android.view.View r8 = r11._$_findCachedViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.String r9 = "tvMerchantName"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            T r9 = r0.element
            java.lang.String r9 = (java.lang.String) r9
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r8.setText(r9)
            goto L_0x0137
        L_0x012f:
            kotlin.u r12 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.String"
            r12.<init>(r0)
            throw r12
        L_0x0137:
            java.lang.Object r4 = r4.get(r1)
            java.lang.String r8 = "list[0]"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r4 = r4.getFullFillmentOject()
            java.lang.String r8 = "list[0].fullFillmentOject"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
            java.lang.String r4 = r4.getFulfillmentResponse()
            if (r4 == 0) goto L_0x0198
            com.google.gsonhtcfix.f r7 = new com.google.gsonhtcfix.f
            r7.<init>()
            java.lang.Class<com.travel.citybus.best.model.BestFulfilment> r8 = com.travel.citybus.best.model.BestFulfilment.class
            java.lang.Object r4 = r7.a((java.lang.String) r4, r8)
            r7 = r4
            com.travel.citybus.best.model.BestFulfilment r7 = (com.travel.citybus.best.model.BestFulfilment) r7
            if (r7 == 0) goto L_0x0198
            com.travel.citybus.best.model.BestPassData r4 = r7.getPassData()
            if (r4 == 0) goto L_0x0198
            java.lang.String r4 = r4.getPassId()
            if (r4 == 0) goto L_0x0198
            int r8 = com.travel.citybus.R.id.tvPassId
            android.view.View r8 = r11._$_findCachedViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.String r9 = "tvPassId"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            r8.setVisibility(r1)
            int r8 = com.travel.citybus.R.id.tvPassId
            android.view.View r8 = r11._$_findCachedViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r9 = "Pass ID : "
            java.lang.String r4 = r9.concat(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r8.setText(r4)
        L_0x0198:
            int[] r4 = com.travel.citybus.best.ui.activities.a.f23150a
            int r12 = r12.ordinal()
            r12 = r4[r12]
            java.lang.String r4 = "tvEPurseRechargeStatus"
            java.lang.String r8 = "tvPaymentStatus"
            java.lang.String r9 = "tvRechargeStatus"
            if (r12 == r6) goto L_0x02f4
            r10 = 2
            if (r12 == r10) goto L_0x024c
            r6 = 3
            if (r12 == r6) goto L_0x01b3
            goto L_0x039d
        L_0x01b3:
            int r12 = com.travel.citybus.R.id.tvRechargeStatus
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r9)
            int r6 = com.travel.citybus.R.string.city_bus_best_recharge_failed
            java.lang.String r6 = r11.getString(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r12.setText(r6)
            int r12 = com.travel.citybus.R.id.tvRechargeStatus
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            int r6 = r11.colorFailed
            r12.setBackgroundColor(r6)
            int r12 = com.travel.citybus.R.id.tvPaymentStatus
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r8)
            int r6 = com.travel.citybus.R.string.city_bus_best_payment_failed
            java.lang.String r6 = r11.getString(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r12.setText(r6)
            int r12 = com.travel.citybus.R.id.tvEPurseRechargeStatus
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r4)
            int r4 = com.travel.citybus.R.string.city_bus_best_e_purse_recharge_failed
            java.lang.String r4 = r11.getString(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r12.setText(r4)
            r11.showSuccessFailureViews(r1)
            int r12 = com.travel.citybus.R.id.rsNoteTv
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            r12.setVisibility(r1)
            int r12 = com.travel.citybus.R.id.rsNoteTv
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            int r2 = com.travel.citybus.R.string.booking_failed_refund_msg
            java.lang.String r2 = r11.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r12 = r11.orderSummary
            if (r12 == 0) goto L_0x039d
            java.util.ArrayList r12 = r12.getPayModes()
            if (r12 == 0) goto L_0x039d
            int r2 = com.travel.citybus.R.id.tvViewPaymentDetails
            android.view.View r2 = r11._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            int r12 = r12.size()
            if (r12 <= 0) goto L_0x0245
            goto L_0x0247
        L_0x0245:
            r1 = 8
        L_0x0247:
            r2.setVisibility(r1)
            goto L_0x039d
        L_0x024c:
            int r12 = com.travel.citybus.R.id.tvRechargeStatus
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r9)
            int r2 = com.travel.citybus.R.string.city_bus_best_recharge_successful
            java.lang.String r2 = r11.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
            int r12 = com.travel.citybus.R.id.tvRechargeStatus
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            int r2 = r11.colorSuccess
            r12.setBackgroundColor(r2)
            int r12 = com.travel.citybus.R.id.tvPaymentStatus
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r8)
            int r2 = com.travel.citybus.R.string.city_bus_best_payment_received
            java.lang.String r2 = r11.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
            int r12 = com.travel.citybus.R.id.tvEPurseRechargeStatus
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r4)
            int r2 = com.travel.citybus.R.string.city_bus_best_e_purse_recharge_successful
            java.lang.String r2 = r11.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
            r11.showSuccessFailureViews(r6)
            int r12 = com.travel.citybus.R.id.tvOverAllStatus
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            java.lang.String r2 = "tvOverAllStatus"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            int r2 = com.travel.citybus.R.string.city_bus_best_money_added
            java.lang.String r2 = r11.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
            if (r7 == 0) goto L_0x039d
            com.travel.citybus.best.model.BestPassData r12 = r7.getPassData()
            if (r12 == 0) goto L_0x039d
            com.travel.citybus.best.model.BestTopupDetails r12 = r12.getTopupDetails()
            if (r12 == 0) goto L_0x039d
            java.lang.Double r12 = r12.getAmount()
            int r2 = com.travel.citybus.R.id.tvOverAllStatusTime
            android.view.View r2 = r11._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = "tvOverAllStatusTime"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            int r3 = com.travel.citybus.R.string.city_bus_best_money_added_to_wallet
            java.lang.Object[] r4 = new java.lang.Object[r6]
            double r5 = r12.doubleValue()
            java.lang.String r12 = java.lang.String.valueOf(r5)
            java.lang.String r12 = com.travel.citybus.best.e.b.b(r12)
            r4[r1] = r12
            java.lang.String r12 = r11.getString(r3, r4)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r2.setText(r12)
            goto L_0x039d
        L_0x02f4:
            int r12 = com.travel.citybus.R.id.tvRechargeStatus
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r9)
            int r6 = com.travel.citybus.R.string.city_bus_best_recharge_pending
            java.lang.String r6 = r11.getString(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r12.setText(r6)
            int r12 = com.travel.citybus.R.id.tvRechargeStatus
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            int r6 = r11.colorPending
            r12.setBackgroundColor(r6)
            int r12 = com.travel.citybus.R.id.tvPaymentStatus
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r8)
            int r6 = com.travel.citybus.R.string.city_bus_best_payment_pending
            java.lang.String r6 = r11.getString(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r12.setText(r6)
            int r12 = com.travel.citybus.R.id.tvEPurseRechargeStatus
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r4)
            int r4 = com.travel.citybus.R.string.city_bus_best_e_purse_recharge_pending
            java.lang.String r4 = r11.getString(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r12.setText(r4)
            int r12 = com.travel.citybus.R.id.tvViewPaymentDetails
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            r12.setVisibility(r3)
            r11.showSuccessFailureViews(r1)
            int r12 = com.travel.citybus.R.id.rsNoteTv
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            r12.setVisibility(r1)
            int r12 = com.travel.citybus.R.id.rsNoteTv
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            boolean r1 = r11.isPostPayment
            if (r1 == 0) goto L_0x037a
            int r1 = com.travel.citybus.R.string.city_bus_best_checking_payment_status
            java.lang.String r1 = r11.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x0382
        L_0x037a:
            int r1 = com.travel.citybus.R.string.booking_failed_refund_msg
            java.lang.String r1 = r11.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x0382:
            r12.setText(r1)
            boolean r12 = r11.isPostPayment
            if (r12 == 0) goto L_0x039d
            boolean r12 = r11.didRetry
            if (r12 != 0) goto L_0x039d
            android.os.Handler r12 = r11.handler
            if (r12 == 0) goto L_0x039d
            com.travel.citybus.best.ui.activities.CityBusRechargeOrderSummaryActivity$b r1 = new com.travel.citybus.best.ui.activities.CityBusRechargeOrderSummaryActivity$b
            r1.<init>(r11)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r2 = 6000(0x1770, double:2.9644E-320)
            r12.postDelayed(r1, r2)
        L_0x039d:
            int r12 = com.travel.citybus.R.id.tvViewPaymentDetails
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            com.travel.citybus.best.ui.activities.CityBusRechargeOrderSummaryActivity$c r1 = new com.travel.citybus.best.ui.activities.CityBusRechargeOrderSummaryActivity$c
            r1.<init>(r11, r0)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r12.setOnClickListener(r1)
            int r12 = com.travel.citybus.R.id.ivBackButton
            android.view.View r12 = r11._$_findCachedViewById(r12)
            androidx.appcompat.widget.AppCompatImageView r12 = (androidx.appcompat.widget.AppCompatImageView) r12
            com.travel.citybus.best.ui.activities.CityBusRechargeOrderSummaryActivity$d r0 = new com.travel.citybus.best.ui.activities.CityBusRechargeOrderSummaryActivity$d
            r0.<init>(r11)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r12.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.best.ui.activities.CityBusRechargeOrderSummaryActivity.setViews(com.travel.citybus.best.a.a):void");
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CityBusRechargeOrderSummaryActivity f23130a;

        b(CityBusRechargeOrderSummaryActivity cityBusRechargeOrderSummaryActivity) {
            this.f23130a = cityBusRechargeOrderSummaryActivity;
        }

        public final void run() {
            this.f23130a.showProgress(true);
            this.f23130a.getOrderDetails();
            this.f23130a.didRetry = true;
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CityBusRechargeOrderSummaryActivity f23131a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f23132b;

        c(CityBusRechargeOrderSummaryActivity cityBusRechargeOrderSummaryActivity, x.e eVar) {
            this.f23131a = cityBusRechargeOrderSummaryActivity;
            this.f23132b = eVar;
        }

        public final void onClick(View view) {
            h access$getPaymentDetailsFragment$p = this.f23131a.paymentDetailsFragment;
            if (access$getPaymentDetailsFragment$p != null) {
                access$getPaymentDetailsFragment$p.dismiss();
            }
            this.f23131a.paymentDetailsFragment = new h();
            Bundle bundle = new Bundle();
            bundle.putSerializable("intent_extra_order_summary", this.f23131a.orderSummary);
            bundle.putString("extra_merchant_name", (String) this.f23132b.element);
            h access$getPaymentDetailsFragment$p2 = this.f23131a.paymentDetailsFragment;
            if (access$getPaymentDetailsFragment$p2 == null) {
                k.a();
            }
            access$getPaymentDetailsFragment$p2.setArguments(bundle);
            h access$getPaymentDetailsFragment$p3 = this.f23131a.paymentDetailsFragment;
            if (access$getPaymentDetailsFragment$p3 == null) {
                k.a();
            }
            access$getPaymentDetailsFragment$p3.show(this.f23131a.getSupportFragmentManager(), h.class.getSimpleName());
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CityBusRechargeOrderSummaryActivity f23133a;

        d(CityBusRechargeOrderSummaryActivity cityBusRechargeOrderSummaryActivity) {
            this.f23133a = cityBusRechargeOrderSummaryActivity;
        }

        public final void onClick(View view) {
            this.f23133a.onBackPressed();
        }
    }

    private final void showSuccessFailureViews(boolean z) {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.view);
        k.a((Object) _$_findCachedViewById, "view");
        int i2 = 0;
        _$_findCachedViewById.setVisibility(z ? 0 : 8);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.rsStatusThreeIv);
        k.a((Object) imageView, "rsStatusThreeIv");
        imageView.setVisibility(z ? 0 : 8);
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvOverAllStatus);
        k.a((Object) textView, "tvOverAllStatus");
        textView.setVisibility(z ? 0 : 8);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvOverAllStatusTime);
        k.a((Object) textView2, "tvOverAllStatusTime");
        if (!z) {
            i2 = 8;
        }
        textView2.setVisibility(i2);
    }
}
