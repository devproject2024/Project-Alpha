package com.travel.bus.orders.c;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.business.merchant_payments.businesswallet.util.TransactionType;
import com.google.gsonhtcfix.b.g;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.travel.bus.R;
import com.travel.bus.busticket.activity.AJRTravelReferralHomeActivity;
import com.travel.bus.busticket.i.o;
import com.travel.bus.busticket.i.p;
import com.travel.bus.busticket.i.v;
import com.travel.bus.busticket.i.y;
import com.travel.bus.orders.activity.BusOrderSummary;
import com.travel.bus.orders.c.c;
import com.travel.bus.orders.f.b;
import com.travel.bus.orders.f.c;
import com.travel.bus.orders.f.d;
import com.travel.bus.orders.f.e;
import com.travel.bus.orders.f.j;
import com.travel.bus.orders.i.i;
import com.travel.bus.orders.i.m;
import com.travel.bus.pojo.CJRNPSCaptureDataModel;
import com.travel.bus.pojo.CJROfferItems;
import com.travel.bus.pojo.CJRTrainBannerDetails;
import com.travel.bus.pojo.busticket.CJRBusFrontBanners;
import com.travel.bus.pojo.busticket.CJRBusNpsCaptureDataModel;
import com.travel.bus.pojo.busticket.CJRBusOperatorDetails;
import com.travel.bus.pojo.busticket.CJRBusOrderSummary;
import com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse;
import com.travel.bus.pojo.busticket.CJRBusOrderSummaryRating;
import com.travel.bus.pojo.busticket.CJRBusOrderSummaryRatingBody;
import com.travel.bus.pojo.busticket.CJRBusRefundDetails;
import com.travel.bus.pojo.common.entity.shopping.CJRBusOrderSummaryCancellation;
import com.travel.bus.pojo.hotel.CJRHotelObject;
import com.travel.bus.pojo.photos.CJRBusBPOnward;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import net.one97.paytm.common.entity.busticket.CJRBusOrderedCart;
import net.one97.paytm.common.entity.shopping.CJRActionResponse;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends c implements com.travel.bus.orders.f.a, c, d, e, j {
    private b B;
    private ScheduledExecutorService C;
    private CJRBusOrderSummaryCancellation D;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;
    private com.travel.bus.orders.d.c J;
    private boolean K = false;
    private boolean L = false;
    private CJRBusRefundDetails M = new CJRBusRefundDetails();
    private CJRBusBPOnward N = new CJRBusBPOnward();
    private CJRBusOperatorDetails.b O = new CJRBusOperatorDetails.b();
    private CJRBusOperatorDetails.a P = new CJRBusOperatorDetails.a();
    private double Q = 0.0d;
    private boolean R = false;
    private boolean S = false;
    private boolean T = false;
    private CJRBusOrderSummary U;
    private boolean V = false;
    /* access modifiers changed from: private */
    public IStaticWidget W;
    /* access modifiers changed from: private */
    public int X = com.paytm.utility.b.c(100);
    /* access modifiers changed from: private */
    public int Y = 0;

    /* renamed from: a  reason: collision with root package name */
    CJRNPSCaptureDataModel f22570a;

    /* renamed from: b  reason: collision with root package name */
    List<c.a> f22571b;

    /* renamed from: c  reason: collision with root package name */
    CJROfferItems f22572c;

    /* renamed from: d  reason: collision with root package name */
    CJRBusOrderSummaryRatingBody f22573d;

    /* renamed from: e  reason: collision with root package name */
    com.travel.bus.orders.e.a f22574e = null;

    /* renamed from: f  reason: collision with root package name */
    m f22575f = null;

    /* renamed from: g  reason: collision with root package name */
    public net.one97.paytm.m f22576g;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.l = this;
        if (getArguments() != null) {
            this.E = getArguments().getBoolean("isFromPayment");
            this.F = getArguments().getBoolean("isGAEvents");
        }
        this.B = new com.travel.bus.orders.g.b(getActivity());
        this.J = new com.travel.bus.orders.d.c(this);
        this.B.a(this);
        if (!(getActivity() == null || this.r == null)) {
            this.r.setText(((BusOrderSummary) getActivity()).getOrderTitle());
        }
        return onCreateView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        b bVar = this.B;
        if (bVar == null) {
            bVar.b();
            this.B = null;
        }
        h();
    }

    public void onDestroy() {
        v.a();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final NestedScrollView.b a() {
        return new NestedScrollView.b() {
            public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                int unused = a.this.Y = nestedScrollView.computeVerticalScrollOffset();
                if (a.this.Y > a.this.X && a.this.W != null && a.this.W.getView().getVisibility() == 0) {
                    a.this.W.getView().setVisibility(8);
                } else if (a.this.Y < a.this.X && a.this.W != null && a.this.W.getView().getVisibility() == 8) {
                    a.this.W.getView().setVisibility(0);
                }
            }
        };
    }

    public final void a(RecyclerView.v vVar) {
        if (vVar instanceof com.travel.bus.orders.e.a) {
            if (vVar instanceof i) {
                ((i) vVar).f22714a = this.M;
            }
            if (vVar instanceof com.travel.bus.orders.i.c) {
                com.travel.bus.orders.i.c cVar = (com.travel.bus.orders.i.c) vVar;
                CJRBusBPOnward cJRBusBPOnward = this.N;
                cVar.f22651d = cJRBusBPOnward.getBoardingPhotos();
                cVar.f22652e = cJRBusBPOnward;
            }
            ((com.travel.bus.orders.e.a) vVar).a(this.q);
        } else if (vVar instanceof CLPBaseViewHolder) {
            ((CLPBaseViewHolder) vVar).bind(new f().a(this.A.get(0)), (CLPBaseViewHolder.IParentListProvider) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e1, code lost:
        if (r7 != false) goto L_0x00e3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.travel.bus.pojo.busticket.CJRBusOrderSummary r12) {
        /*
            r11 = this;
            java.lang.String r0 = " "
            java.lang.String r1 = "metadataResponse"
            if (r12 != 0) goto L_0x0031
            androidx.fragment.app.FragmentActivity r12 = r11.getActivity()
            com.travel.bus.orders.activity.BusOrderSummary r12 = (com.travel.bus.orders.activity.BusOrderSummary) r12
            r12.showErrorMessage()
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()
            java.lang.String r0 = com.paytm.utility.b.n((android.content.Context) r0)
            java.lang.String r1 = "userid"
            r12.put(r1, r0)
            com.travel.bus.a.a()
            java.lang.String r0 = "customEvent"
            java.lang.String r1 = "/bus-tickets-summary"
            java.lang.String r2 = "bus_summary"
            java.lang.String r3 = "error_popup"
            com.travel.bus.a.a(r0, r1, r2, r3, r12)
            return
        L_0x0031:
            r11.U = r12
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r2 = r11.g()
            if (r2 == 0) goto L_0x0063
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r2 = r11.g()
            java.lang.String r2 = r2.getId()
            if (r2 == 0) goto L_0x0063
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r2 = r11.g()
            java.lang.String r2 = r2.getId()
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0063
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r2 = r11.g()
            java.lang.String r2 = r2.getId()
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r3 = r11.g()
            com.travel.bus.pojo.CJRNPSCaptureDataModel r2 = a((java.lang.String) r2, (com.travel.bus.pojo.busticket.CJRBusOrderSummary) r3)
            r11.f22570a = r2
        L_0x0063:
            boolean r2 = r11.x
            if (r2 != 0) goto L_0x006a
            r11.e(r12)
        L_0x006a:
            boolean r2 = r11.L
            if (r2 != 0) goto L_0x0071
            r11.j(r12)
        L_0x0071:
            java.lang.String r2 = r12.getStatus()
            java.lang.String r3 = "Successful"
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x027b
            boolean r2 = r11.R
            r3 = 1
            if (r2 != 0) goto L_0x0222
            r11.e()
            com.travel.bus.orders.d.c r2 = r11.J
            androidx.fragment.app.FragmentActivity r4 = r11.getActivity()
            boolean r5 = r11.E
            java.lang.String r6 = "context"
            kotlin.g.b.k.c(r4, r6)
            java.lang.String r6 = "orderSummary"
            kotlin.g.b.k.c(r12, r6)
            r2.f22632c = r12
            java.util.ArrayList r6 = r12.getOrderedCartList()
            r7 = 0
            java.lang.Object r6 = r6.get(r7)
            java.lang.String r8 = "orderSummary.orderedCartList[0]"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r6 = (net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r6
            java.lang.Object r6 = r6.getMetaDataResponse()
            com.google.gsonhtcfix.f r8 = new com.google.gsonhtcfix.f
            r8.<init>()
            java.lang.String r6 = r8.a((java.lang.Object) r6)
            java.lang.Class<com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse> r9 = com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse.class
            java.lang.Object r6 = r8.a((java.lang.String) r6, r9)
            com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse r6 = (com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse) r6
            com.travel.bus.a.a()
            com.travel.g.a r8 = com.travel.bus.a.b()
            java.lang.String r9 = "bus_hotel_recommendation_url"
            java.lang.String r8 = r8.f(r9)
            r2.f22631b = r8
            java.lang.String r8 = r2.f22631b
            if (r8 == 0) goto L_0x00e3
            java.lang.String r8 = r2.f22631b
            if (r8 != 0) goto L_0x00d8
            kotlin.g.b.k.a()
        L_0x00d8:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            int r8 = r8.length()
            if (r8 != 0) goto L_0x00e1
            r7 = 1
        L_0x00e1:
            if (r7 == 0) goto L_0x00e7
        L_0x00e3:
            java.lang.String r7 = "https://hotels.paytm.com/hotels/v1/hotel-recommendation"
            r2.f22631b = r7
        L_0x00e7:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0116 }
            r7.<init>()     // Catch:{ Exception -> 0x0116 }
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r8 = r6.getArrivalDate()     // Catch:{ Exception -> 0x0116 }
            r7.append(r8)     // Catch:{ Exception -> 0x0116 }
            r7.append(r0)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r8 = r6.getArrivalTime()     // Catch:{ Exception -> 0x0116 }
            r7.append(r8)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0116 }
            java.util.Date r7 = com.travel.bus.busticket.i.o.c((java.lang.String) r7)     // Catch:{ Exception -> 0x0116 }
            java.util.Date r8 = new java.util.Date     // Catch:{ Exception -> 0x0116 }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0116 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x0116 }
            boolean r5 = com.travel.bus.busticket.i.o.a((java.util.Date) r8, (java.util.Date) r7)     // Catch:{ Exception -> 0x0116 }
            goto L_0x0117
        L_0x0116:
        L_0x0117:
            if (r5 == 0) goto L_0x0220
            java.lang.String r5 = r2.f22631b
            android.net.Uri r5 = android.net.Uri.parse(r5)
            android.net.Uri$Builder r5 = r5.buildUpon()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
            java.lang.String r1 = r6.getArrivalDate()
            r7.append(r1)
            r7.append(r0)
            java.lang.String r0 = r6.getArrivalTime()
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            java.lang.String r1 = "checkinTime"
            android.net.Uri$Builder r0 = r5.appendQueryParameter(r1, r0)
            com.travel.bus.pojo.busticket.CJROrdeFare r1 = r6.getCjrOrderData()
            java.lang.String r5 = "metadataResponse.cjrOrderData"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            java.lang.String r1 = r1.getGrandTotal()
            java.lang.String r5 = "ticketPrice"
            android.net.Uri$Builder r0 = r0.appendQueryParameter(r5, r1)
            java.lang.String r1 = r12.getId()
            java.lang.String r5 = "orderId"
            android.net.Uri$Builder r0 = r0.appendQueryParameter(r5, r1)
            java.lang.String r1 = com.travel.bus.orders.d.c.a(r6)
            java.lang.String r5 = "paxInfo"
            android.net.Uri$Builder r0 = r0.appendQueryParameter(r5, r1)
            java.lang.String r1 = r6.getPassengerName()
            java.lang.String r5 = "customerName"
            android.net.Uri$Builder r0 = r0.appendQueryParameter(r5, r1)
            java.lang.String r1 = "verticalId"
            java.lang.String r5 = "26"
            android.net.Uri$Builder r0 = r0.appendQueryParameter(r1, r5)
            java.lang.String r1 = r6.getDestination()
            java.lang.String r5 = "city"
            android.net.Uri$Builder r0 = r0.appendQueryParameter(r5, r1)
            int r1 = r12.getOrderStatus()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r5 = "orderStatus"
            android.net.Uri$Builder r0 = r0.appendQueryParameter(r5, r1)
            android.net.Uri r0 = r0.build()
            java.lang.String r0 = r0.toString()
            r2.f22631b = r0
            java.lang.String r0 = r2.f22631b
            boolean r0 = android.webkit.URLUtil.isValidUrl(r0)
            if (r0 == 0) goto L_0x0220
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r4)     // Catch:{ Exception -> 0x0218 }
            if (r0 == 0) goto L_0x0220
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0218 }
            r0.<init>()     // Catch:{ Exception -> 0x0218 }
            r1 = 503(0x1f7, float:7.05E-43)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0218 }
            r0.add(r1)     // Catch:{ Exception -> 0x0218 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0218 }
            r0.<init>()     // Catch:{ Exception -> 0x0218 }
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x0218 }
            java.lang.String r5 = "ssoToken"
            java.lang.String r6 = com.paytm.utility.a.q(r4)     // Catch:{ Exception -> 0x0218 }
            java.lang.String r7 = "CJRNetUtility.getSSOToken(context)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x0218 }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x0218 }
            com.paytm.network.b r1 = new com.paytm.network.b     // Catch:{ Exception -> 0x0218 }
            r1.<init>()     // Catch:{ Exception -> 0x0218 }
            r1.f42877a = r4     // Catch:{ Exception -> 0x0218 }
            com.paytm.network.a$c r4 = com.paytm.network.a.c.BUS     // Catch:{ Exception -> 0x0218 }
            r1.f42878b = r4     // Catch:{ Exception -> 0x0218 }
            com.paytm.network.a$a r4 = com.paytm.network.a.C0715a.GET     // Catch:{ Exception -> 0x0218 }
            r1.f42879c = r4     // Catch:{ Exception -> 0x0218 }
            java.lang.String r4 = r2.f22631b     // Catch:{ Exception -> 0x0218 }
            r1.f42880d = r4     // Catch:{ Exception -> 0x0218 }
            r4 = 0
            r1.f42884h = r4     // Catch:{ Exception -> 0x0218 }
            r1.f42881e = r4     // Catch:{ Exception -> 0x0218 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x0218 }
            r1.f42882f = r0     // Catch:{ Exception -> 0x0218 }
            r1.f42883g = r4     // Catch:{ Exception -> 0x0218 }
            com.travel.bus.pojo.hotel.CJRHotelObject r0 = new com.travel.bus.pojo.hotel.CJRHotelObject     // Catch:{ Exception -> 0x0218 }
            r0.<init>()     // Catch:{ Exception -> 0x0218 }
            com.paytm.network.model.IJRPaytmDataModel r0 = (com.paytm.network.model.IJRPaytmDataModel) r0     // Catch:{ Exception -> 0x0218 }
            r1.f42885i = r0     // Catch:{ Exception -> 0x0218 }
            r0 = r2
            com.paytm.network.listener.b r0 = (com.paytm.network.listener.b) r0     // Catch:{ Exception -> 0x0218 }
            r1.j = r0     // Catch:{ Exception -> 0x0218 }
            org.json.JSONObject r0 = r2.a()     // Catch:{ Exception -> 0x0218 }
            r1.t = r0     // Catch:{ Exception -> 0x0218 }
            com.paytm.network.a$b r0 = com.paytm.network.a.b.SILENT     // Catch:{ Exception -> 0x0218 }
            r1.n = r0     // Catch:{ Exception -> 0x0218 }
            java.lang.String r0 = "bus-order-summary-page"
            r1.o = r0     // Catch:{ Exception -> 0x0218 }
            com.paytm.network.a r0 = r1.l()     // Catch:{ Exception -> 0x0218 }
            r0.a()     // Catch:{ Exception -> 0x0218 }
            goto L_0x0220
        L_0x0218:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
        L_0x0220:
            r11.R = r3
        L_0x0222:
            boolean r0 = r11.S
            if (r0 != 0) goto L_0x027b
            r11.e()
            java.lang.String r12 = r12.getId()
            com.travel.bus.a.a()
            com.travel.g.a r0 = com.travel.bus.a.b()
            java.lang.String r0 = r0.n()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0240
            java.lang.String r0 = "https://travel.paytm.com/bus/v1/order/other_details"
        L_0x0240:
            r5 = r0
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.String r1 = "Content-Type"
            java.lang.String r2 = "application/json"
            r6.put(r1, r2)
            java.lang.String r1 = "order_id"
            r0.put(r1, r12)     // Catch:{ JSONException -> 0x0258 }
            goto L_0x0260
        L_0x0258:
            r12 = move-exception
            java.lang.String r12 = r12.getMessage()
            com.paytm.utility.q.c(r12)
        L_0x0260:
            androidx.fragment.app.FragmentActivity r12 = r11.getActivity()
            boolean r12 = com.paytm.utility.b.c((android.content.Context) r12)
            if (r12 == 0) goto L_0x0279
            java.lang.String r7 = r0.toString()
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails r8 = new com.travel.bus.pojo.busticket.CJRBusOperatorDetails
            r8.<init>()
            com.paytm.network.a$a r9 = com.paytm.network.a.C0715a.POST
            r4 = r11
            r4.a(r5, r6, r7, r8, r9)
        L_0x0279:
            r11.S = r3
        L_0x027b:
            java.util.List<com.travel.bus.orders.c.c$a> r12 = r11.n
            r11.b((java.util.List<com.travel.bus.orders.c.c.a>) r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.c.a.a(com.travel.bus.pojo.busticket.CJRBusOrderSummary):void");
    }

    private void e(CJRBusOrderSummary cJRBusOrderSummary) {
        if (cJRBusOrderSummary != null && cJRBusOrderSummary.getOrderedCartList() != null && cJRBusOrderSummary.getOrderedCartList().size() > 0) {
            Iterator<CJRBusOrderedCart> it2 = cJRBusOrderSummary.getOrderedCartList().iterator();
            CJRBusOrderSummaryMetaDataResponse cJRBusOrderSummaryMetaDataResponse = null;
            while (it2.hasNext()) {
                CJRBusOrderedCart next = it2.next();
                if (com.travel.bus.orders.h.b.b(next)) {
                    Object metaDataResponse = next.getMetaDataResponse();
                    f fVar = new f();
                    cJRBusOrderSummaryMetaDataResponse = (CJRBusOrderSummaryMetaDataResponse) fVar.a(fVar.a(metaDataResponse), CJRBusOrderSummaryMetaDataResponse.class);
                }
            }
            if (cJRBusOrderSummaryMetaDataResponse == null) {
                return;
            }
            if ((cJRBusOrderSummaryMetaDataResponse.getIsRoundTrip() == null || cJRBusOrderSummaryMetaDataResponse.getIsRoundTrip().equals("0.0")) && !"FAILED".equalsIgnoreCase(cJRBusOrderSummary.getStatus())) {
                com.travel.bus.a.a();
                String n = com.travel.bus.a.b().n();
                if (TextUtils.isEmpty(n)) {
                    n = "https://travel.paytm.com/bus/v1/order/other_details";
                }
                String str = n;
                JSONObject jSONObject = new JSONObject();
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                try {
                    jSONObject.put("order_id", cJRBusOrderSummary.getId());
                } catch (JSONException e2) {
                    q.c(e2.getMessage());
                }
                if (com.paytm.utility.b.c((Context) getActivity())) {
                    a(str, hashMap, jSONObject.toString(), new CJRBusRefundDetails(), a.C0715a.POST);
                }
            }
        }
    }

    public final void a(CJRBusFrontBanners cJRBusFrontBanners) {
        if (cJRBusFrontBanners != null && cJRBusFrontBanners.getPage() != null && cJRBusFrontBanners.getPage().size() > 0) {
            if (cJRBusFrontBanners.getPage().get(0) != null && cJRBusFrontBanners.getPage().get(0).getmBannerDetails() != null && cJRBusFrontBanners.getPage().get(0).getmBannerDetails().size() > 0 && cJRBusFrontBanners.getPage().get(0).getmBannerDetails().get(0) != null) {
                CJRTrainBannerDetails cJRTrainBannerDetails = cJRBusFrontBanners.getPage().get(0).getmBannerDetails().get(0);
                if (cJRTrainBannerDetails.getmBannerItems() != null && cJRTrainBannerDetails.getmBannerItems().size() > 0 && cJRTrainBannerDetails.getmBannerItems().get(0) != null) {
                    this.f22572c = cJRTrainBannerDetails.getmBannerItems().get(0);
                    List<c.a> list = this.f22571b;
                    if (list != null && list.size() > 0) {
                        for (int i2 = 0; i2 < this.f22571b.size(); i2++) {
                            if (this.f22571b.get(i2) == c.a.TRAVEL_BUDDY_BANNER) {
                                this.K = true;
                            }
                        }
                        if (!this.K) {
                            List<c.a> list2 = this.f22571b;
                            list2.add(list2.size() - 1, c.a.TRAVEL_BUDDY_BANNER);
                        }
                        a(this.f22571b);
                    }
                }
            }
        }
    }

    public final c.b a(boolean z) {
        String str;
        ArrayList<CJRBusOrderedCart> orderedCartList;
        c.b bVar;
        c.b bVar2 = c.b.NO_OP;
        String paymentStatus = g().getPaymentStatus();
        int orderStatus = g().getOrderStatus();
        String str2 = null;
        if (paymentStatus.equalsIgnoreCase("success")) {
            c.b bVar3 = c.b.PAYMENT_SUCCESS;
            Iterator<CJROrderSummaryPayment> it2 = g().getPaymentInfo().iterator();
            String str3 = null;
            String str4 = null;
            while (it2.hasNext()) {
                CJROrderSummaryPayment next = it2.next();
                if (!TextUtils.isEmpty(next.getPaymentMethod())) {
                    str3 = next.getPaymentMethod();
                    str4 = next.getProvider();
                }
                str2 = next.getOrderId();
            }
            if (!this.F || this.H) {
                bVar = bVar3;
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("event_category", "bus_summary");
                bVar = bVar3;
                hashMap.put("event_action", "payment_successful");
                hashMap.put("event_label", str3);
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-summary");
                hashMap.put("user_id", com.paytm.utility.b.n((Context) getActivity()));
                hashMap.put("vertical_name", "bus");
                hashMap.put("event_label2", str4);
                com.travel.bus.a.a();
                com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) getActivity());
                this.H = true;
            }
            str = str2;
            bVar2 = bVar;
        } else {
            if (paymentStatus.equalsIgnoreCase("failed")) {
                bVar2 = c.b.PAYMENT_FAILED;
            } else if (paymentStatus.equalsIgnoreCase("processing")) {
                bVar2 = c.b.PAYMENT_PENDING;
            }
            str = null;
        }
        if (AnonymousClass2.f22578a[bVar2.ordinal()] == 1 && (orderedCartList = g().getOrderedCartList()) != null) {
            Iterator<CJRBusOrderedCart> it3 = orderedCartList.iterator();
            while (it3.hasNext()) {
                CJRBusOrderedCart next2 = it3.next();
                if (!a(next2)) {
                    Iterator<CJRBusOrderedCart> it4 = it3;
                    if (bVar2 != c.b.PAYMENT_SUCCESS) {
                        break;
                    }
                    int parseInt = Integer.parseInt(next2.getItemStatus());
                    if (parseInt == 2 || parseInt == 5) {
                        bVar2 = c.b.BOOKING_PENDING;
                    } else if (parseInt == 6) {
                        bVar2 = c.b.BOOKING_FAILED;
                    } else if (parseInt == 7) {
                        bVar2 = c.b.BOOKING_SUCCESSFUL;
                    }
                    it3 = it4;
                }
            }
        }
        if (!z) {
            if (AnonymousClass2.f22578a[bVar2.ordinal()] == 3) {
                bVar2 = c.b.PAYMENT_SUCCESS;
            }
        } else if (!this.G) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("event_category", "bus_summary");
            hashMap2.put("event_action", "order_status");
            hashMap2.put("event_label", orderStatus + " & " + str);
            hashMap2.put("user_id", com.paytm.utility.b.n((Context) getActivity()));
            hashMap2.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-summary");
            hashMap2.put("vertical_name", "bus");
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap2, (Context) getActivity());
            this.G = true;
        }
        h();
        return bVar2;
    }

    private static boolean a(CJRBusOrderedCart cJRBusOrderedCart) {
        if (!(cJRBusOrderedCart == null || cJRBusOrderedCart.getMetaDataResponse() == null)) {
            try {
                return new JSONObject(new f().a(cJRBusOrderedCart.getMetaDataResponse())).has("addon_type");
            } catch (JSONException e2) {
                q.c(e2.getMessage());
            }
        }
        return false;
    }

    private void h() {
        ScheduledExecutorService scheduledExecutorService = this.C;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            this.C.shutdownNow();
        }
    }

    /* JADX WARNING: type inference failed for: r0v12, types: [com.travel.bus.orders.i.o] */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r0v34, types: [com.travel.bus.orders.i.k] */
    /* JADX WARNING: type inference failed for: r0v35, types: [com.travel.bus.orders.i.g] */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.recyclerview.widget.RecyclerView.v a(android.view.ViewGroup r20, com.travel.bus.orders.c.c.a r21) {
        /*
            r19 = this;
            r9 = r19
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r19.g()
            if (r0 == 0) goto L_0x0032
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r19.g()
            java.lang.String r0 = r0.getId()
            if (r0 == 0) goto L_0x0032
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r19.g()
            java.lang.String r0 = r0.getId()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0032
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r19.g()
            java.lang.String r0 = r0.getId()
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r1 = r19.g()
            com.travel.bus.pojo.CJRNPSCaptureDataModel r0 = a((java.lang.String) r0, (com.travel.bus.pojo.busticket.CJRBusOrderSummary) r1)
            r9.f22570a = r0
        L_0x0032:
            int[] r0 = com.travel.bus.orders.c.a.AnonymousClass2.f22579b
            int r1 = r21.ordinal()
            r0 = r0[r1]
            r1 = 0
            switch(r0) {
                case 1: goto L_0x0189;
                case 2: goto L_0x015a;
                case 3: goto L_0x0134;
                case 4: goto L_0x0121;
                case 5: goto L_0x010e;
                case 6: goto L_0x00fb;
                case 7: goto L_0x00e3;
                case 8: goto L_0x00d1;
                case 9: goto L_0x00b8;
                case 10: goto L_0x009f;
                case 11: goto L_0x0083;
                case 12: goto L_0x006e;
                case 13: goto L_0x0040;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x01b0
        L_0x0040:
            java.util.ArrayList r0 = r9.A
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x01b0
            java.util.ArrayList r0 = r9.A
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2) r0
            java.lang.String r0 = r0.getLayout()
            int r0 = com.paytmmall.clpartifact.utils.ViewHolderFactory.parseViewType(r0)
            androidx.fragment.app.FragmentActivity r1 = r19.getActivity()
            androidx.fragment.app.j r1 = r1.getSupportFragmentManager()
            com.travel.bus.orders.c.a$4 r2 = new com.travel.bus.orders.c.a$4
            r2.<init>()
            r3 = r20
            com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder r1 = com.paytmmall.clpartifact.utils.ViewHolderFactory.getViewHolder(r3, r0, r1, r2)
            goto L_0x01b0
        L_0x006e:
            r3 = r20
            com.travel.bus.orders.i.f r1 = new com.travel.bus.orders.i.f
            android.view.View r0 = b((android.view.ViewGroup) r20, (com.travel.bus.orders.c.c.a) r21)
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r2 = r19.g()
            com.travel.bus.orders.activity.BusOrderSummary$a r3 = r9.k
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r4 = r9.M
            r1.<init>(r0, r2, r3, r4)
            goto L_0x01b0
        L_0x0083:
            r3 = r20
            com.travel.bus.orders.i.m r6 = new com.travel.bus.orders.i.m
            android.view.View r1 = b((android.view.ViewGroup) r20, (com.travel.bus.orders.c.c.a) r21)
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r2 = r19.g()
            com.travel.bus.orders.activity.BusOrderSummary$a r4 = r9.k
            net.one97.paytm.m r5 = r9.f22576g
            r0 = r6
            r3 = r19
            r0.<init>(r1, r2, r3, r4, r5)
            r9.f22575f = r6
            com.travel.bus.orders.i.m r1 = r9.f22575f
            goto L_0x01b0
        L_0x009f:
            r3 = r20
            com.travel.bus.orders.i.g r6 = new com.travel.bus.orders.i.g
            androidx.fragment.app.FragmentActivity r1 = r19.getActivity()
            android.view.View r2 = b((android.view.ViewGroup) r20, (com.travel.bus.orders.c.c.a) r21)
            com.travel.bus.pojo.busticket.CJRBusOrderSummaryRatingBody r4 = r9.f22573d
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r5 = r19.g()
            r0 = r6
            r3 = r19
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x00ce
        L_0x00b8:
            r3 = r20
            com.travel.bus.orders.i.k r6 = new com.travel.bus.orders.i.k
            androidx.fragment.app.FragmentActivity r1 = r19.getActivity()
            android.view.View r2 = b((android.view.ViewGroup) r20, (com.travel.bus.orders.c.c.a) r21)
            com.travel.bus.orders.activity.BusOrderSummary$a r3 = r9.k
            com.travel.bus.pojo.CJROfferItems r5 = r9.f22572c
            r0 = r6
            r4 = r19
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x00ce:
            r1 = r6
            goto L_0x01b0
        L_0x00d1:
            r3 = r20
            com.travel.bus.orders.i.h r1 = new com.travel.bus.orders.i.h
            r19.getActivity()
            android.view.View r0 = b((android.view.ViewGroup) r20, (com.travel.bus.orders.c.c.a) r21)
            com.travel.bus.pojo.CJRNPSCaptureDataModel r2 = r9.f22570a
            r1.<init>(r0, r9, r2)
            goto L_0x01b0
        L_0x00e3:
            r3 = r20
            com.travel.bus.orders.i.o r0 = new com.travel.bus.orders.i.o
            android.view.View r2 = b((android.view.ViewGroup) r20, (com.travel.bus.orders.c.c.a) r21)
            com.travel.bus.orders.f.h r3 = r9.m
            if (r3 != 0) goto L_0x00f0
            goto L_0x00f6
        L_0x00f0:
            com.travel.bus.orders.f.h r1 = r9.m
            com.travel.bus.pojo.hotel.CJRHotelObject r1 = r1.d()
        L_0x00f6:
            r0.<init>(r2, r1)
            goto L_0x0187
        L_0x00fb:
            r3 = r20
            com.travel.bus.orders.i.e r1 = new com.travel.bus.orders.i.e
            android.view.View r0 = b((android.view.ViewGroup) r20, (com.travel.bus.orders.c.c.a) r21)
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r2 = r19.g()
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r3 = r9.M
            r1.<init>(r0, r2, r3)
            goto L_0x01b0
        L_0x010e:
            r3 = r20
            com.travel.bus.orders.i.l r1 = new com.travel.bus.orders.i.l
            android.view.View r0 = b((android.view.ViewGroup) r20, (com.travel.bus.orders.c.c.a) r21)
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r2 = r19.g()
            com.travel.bus.orders.activity.BusOrderSummary$a r3 = r9.k
            r1.<init>(r0, r2, r3)
            goto L_0x01b0
        L_0x0121:
            r3 = r20
            com.travel.bus.orders.i.d r1 = new com.travel.bus.orders.i.d
            android.view.View r0 = b((android.view.ViewGroup) r20, (com.travel.bus.orders.c.c.a) r21)
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r2 = r19.g()
            com.travel.bus.orders.activity.BusOrderSummary$a r3 = r9.k
            r1.<init>(r0, r2, r9, r3)
            goto L_0x01b0
        L_0x0134:
            r3 = r20
            com.travel.bus.orders.i.i r8 = new com.travel.bus.orders.i.i
            android.view.View r1 = b((android.view.ViewGroup) r20, (com.travel.bus.orders.c.c.a) r21)
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r2 = r19.g()
            androidx.fragment.app.FragmentActivity r3 = r19.getActivity()
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r4 = r9.M
            com.travel.bus.orders.activity.BusOrderSummary$a r5 = r9.k
            boolean r7 = r19.j()
            double r10 = r9.Q
            int r0 = (int) r10
            java.lang.String.valueOf(r0)
            r0 = r8
            r6 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r1 = r8
            goto L_0x01b0
        L_0x015a:
            r3 = r20
            com.travel.bus.orders.i.c r0 = new com.travel.bus.orders.i.c
            android.view.View r11 = b((android.view.ViewGroup) r20, (com.travel.bus.orders.c.c.a) r21)
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r12 = r19.g()
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$b r13 = r9.O
            androidx.fragment.app.FragmentActivity r14 = r19.getActivity()
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r1 = r19.g()
            boolean r15 = d((com.travel.bus.pojo.busticket.CJRBusOrderSummary) r1)
            com.travel.bus.orders.c.a$3 r1 = new com.travel.bus.orders.c.a$3
            r1.<init>()
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$a r2 = r9.P
            com.travel.bus.pojo.photos.CJRBusBPOnward r3 = r9.N
            r10 = r0
            r16 = r1
            r17 = r2
            r18 = r3
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
        L_0x0187:
            r1 = r0
            goto L_0x01b0
        L_0x0189:
            r3 = r20
            com.travel.bus.orders.i.n r10 = new com.travel.bus.orders.i.n
            android.view.View r1 = b((android.view.ViewGroup) r20, (com.travel.bus.orders.c.c.a) r21)
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r2 = r19.g()
            com.travel.bus.orders.activity.BusOrderSummary$a r4 = r9.k
            java.lang.String r5 = r19.i()
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r19.g()
            boolean r6 = r9.k(r0)
            boolean r7 = r9.E
            androidx.fragment.app.FragmentActivity r8 = r19.getActivity()
            r0 = r10
            r3 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r1 = r10
        L_0x01b0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.c.a.a(android.view.ViewGroup, com.travel.bus.orders.c.c$a):androidx.recyclerview.widget.RecyclerView$v");
    }

    private String i() {
        JSONObject fullFillment;
        String str = null;
        if (g() == null) {
            return null;
        }
        try {
            Iterator<CJRBusOrderedCart> it2 = g().getOrderedCartList().iterator();
            while (it2.hasNext()) {
                CJRBusOrderedCart next = it2.next();
                if (com.travel.bus.orders.h.b.b(next) && (fullFillment = next.getFullFillmentOject().getFullFillment()) != null) {
                    str = fullFillment.has("pnr") ? fullFillment.getString("pnr") : "";
                    if (com.travel.bus.orders.h.b.a(fullFillment)) {
                        str = fullFillment.getJSONObject("order_data").getJSONArray("items").getJSONObject(0).getJSONObject("provider_transaction_detail").getString("pnr");
                    }
                }
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
        return str;
    }

    private static View b(ViewGroup viewGroup, c.a aVar) {
        int i2;
        switch (aVar) {
            case HEADER:
                i2 = R.layout.pre_b_order_summary_header_card;
                break;
            case PASSENGER_DESC_CARD_ONGOING:
                i2 = R.layout.pre_b_bus_order_summary_passenger_desc_card;
                break;
            case PASSENER_CARD_LIST:
                i2 = R.layout.pre_b_bus_order_passenger_list_item_revamp;
                break;
            case PAYMENT_DETAILS:
                i2 = R.layout.pre_b_bus_summary_payment_card;
                break;
            case CASHBACK_DETAILS:
                i2 = R.layout.pre_b_bus_cashback_card;
                break;
            case REFUND_SUMMARY:
                i2 = R.layout.pre_b_bus_refund_summary_card;
                break;
            case HOTEL_OPTIONS:
                i2 = R.layout.pre_b_bus_hotel_card_layout;
                break;
            case BUS_NPS_WIDGET:
                i2 = R.layout.pre_b_bus_ticket_booking_recommendation_lyt;
                break;
            case TRAVEL_BUDDY_BANNER:
                i2 = R.layout.pre_b_travel_buddy_banner_lyt;
                break;
            case BUS_RATING_WIDGET:
                i2 = R.layout.pre_b_bus_rating_widget;
                break;
            case FOOTER:
                i2 = R.layout.pre_b_order_summary_payment_footer;
                break;
            case CANCEL_PROTECT:
                i2 = R.layout.pre_b_bus_cancel_protect_lyt;
                break;
            default:
                i2 = -1;
                break;
        }
        if (i2 != -1) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
        }
        return null;
    }

    public final ScheduledExecutorService b() {
        this.C = Executors.newSingleThreadScheduledExecutor();
        return this.C;
    }

    public final Context c() {
        return getActivity();
    }

    public final void a(CJRBusOrderSummaryCancellation cJRBusOrderSummaryCancellation) {
        this.D = cJRBusOrderSummaryCancellation;
        super.c(g());
    }

    public final void a(String str, int i2, String str2, String str3) {
        o.a((Context) getActivity(), i2, str, str2);
        com.travel.bus.busticket.activity.a a2 = com.travel.bus.busticket.activity.a.a();
        a2.setCancelable(false);
        Bundle bundle = new Bundle();
        bundle.putInt("star_count", i2);
        bundle.putString("secretKey", str);
        bundle.putString("orderID", this.o);
        bundle.putString("channel", str2);
        bundle.putString("operator_name", str3);
        a2.setArguments(bundle);
        a2.show(getActivity().getSupportFragmentManager(), "ratingScreenBottomSheet");
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.util.List<com.travel.bus.orders.c.c.a> r9) {
        /*
            r8 = this;
            if (r9 != 0) goto L_0x0003
            return
        L_0x0003:
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r8.g()
            r1 = 18
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x006c
            java.util.ArrayList r4 = r0.getOrderedCartList()
            if (r4 == 0) goto L_0x006c
            java.util.ArrayList r4 = r0.getOrderedCartList()
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x006c
            java.util.ArrayList r4 = r0.getOrderedCartList()
            java.util.Iterator r4 = r4.iterator()
        L_0x0025:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0043
            java.lang.Object r5 = r4.next()
            net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r5 = (net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r5
            boolean r6 = com.travel.bus.orders.h.b.b(r5)
            if (r6 == 0) goto L_0x0025
            java.lang.String r5 = r5.getItemStatus()
            int r5 = java.lang.Integer.parseInt(r5)
            if (r5 != r1) goto L_0x0025
            r4 = 1
            goto L_0x0044
        L_0x0043:
            r4 = 0
        L_0x0044:
            if (r4 == 0) goto L_0x006c
            java.util.ArrayList r4 = r0.getOrderedCartList()
            java.util.Iterator r4 = r4.iterator()
        L_0x004e:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x006c
            java.lang.Object r5 = r4.next()
            net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r5 = (net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r5
            boolean r6 = com.travel.bus.orders.h.b.b(r5)
            if (r6 == 0) goto L_0x004e
            java.lang.String r5 = r5.getItemStatus()
            int r5 = java.lang.Integer.parseInt(r5)
            if (r5 == r1) goto L_0x004e
            r8.I = r3
        L_0x006c:
            com.travel.bus.orders.c.c$a r4 = com.travel.bus.orders.c.c.a.HEADER
            r9.add(r4)
            boolean r4 = h(r0)
            if (r4 == 0) goto L_0x007c
            com.travel.bus.orders.c.c$a r4 = com.travel.bus.orders.c.c.a.PASSENGER_DESC_CARD_ONGOING
            r9.add(r4)
        L_0x007c:
            boolean r4 = h(r0)
            if (r4 == 0) goto L_0x0087
            com.travel.bus.orders.c.c$a r4 = com.travel.bus.orders.c.c.a.PASSENER_CARD_LIST
            r9.add(r4)
        L_0x0087:
            java.lang.String r4 = r0.getStatus()
            java.lang.String r5 = "In Process"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0098
            com.travel.bus.orders.c.c$a r4 = com.travel.bus.orders.c.c.a.PAYMENT_DETAILS
            r9.remove(r4)
        L_0x0098:
            java.lang.String r0 = r0.getPaymentStatus()
            java.lang.String r4 = "PROCESSING"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x00b4
            java.lang.String r4 = "SUCCESS"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x00b4
            java.lang.String r4 = "FAILED"
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 == 0) goto L_0x00b9
        L_0x00b4:
            com.travel.bus.orders.c.c$a r0 = com.travel.bus.orders.c.c.a.PAYMENT_DETAILS
            r9.add(r0)
        L_0x00b9:
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r8.g()
            java.util.ArrayList r0 = r0.getOrderedCartList()
            java.util.Iterator r0 = r0.iterator()
        L_0x00c5:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x00f3
            java.lang.Object r4 = r0.next()
            net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r4 = (net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r4
            boolean r5 = com.travel.bus.orders.h.b.b(r4)
            if (r5 == 0) goto L_0x00c5
            java.lang.String r5 = r4.getItemStatus()
            int r5 = java.lang.Integer.parseInt(r5)
            r6 = 17
            if (r5 == r6) goto L_0x00ed
            java.lang.String r4 = r4.getItemStatus()
            int r4 = java.lang.Integer.parseInt(r4)
            if (r4 != r1) goto L_0x00c5
        L_0x00ed:
            com.travel.bus.orders.c.c$a r4 = com.travel.bus.orders.c.c.a.PAYMENT_DETAILS
            r9.remove(r4)
            goto L_0x00c5
        L_0x00f3:
            boolean r0 = r8.I
            if (r0 == 0) goto L_0x00fc
            com.travel.bus.orders.c.c$a r0 = com.travel.bus.orders.c.c.a.PAYMENT_DETAILS
            r9.remove(r0)
        L_0x00fc:
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            r1 = 3
            if (r0 == 0) goto L_0x0133
            com.travel.bus.a.a()
            com.travel.g.a r0 = com.travel.bus.a.b()
            androidx.fragment.app.FragmentActivity r4 = r8.getActivity()
            boolean r0 = r0.a((android.content.Context) r4)
            if (r0 == 0) goto L_0x0133
            boolean r0 = r8.E
            if (r0 == 0) goto L_0x0133
            int[] r0 = com.travel.bus.orders.c.a.AnonymousClass2.f22578a
            boolean r4 = r8.E
            com.travel.bus.orders.c.c$b r4 = r8.a((boolean) r4)
            int r4 = r4.ordinal()
            r0 = r0[r4]
            if (r0 == r3) goto L_0x0131
            if (r0 == r1) goto L_0x0131
            r4 = 4
            if (r0 == r4) goto L_0x0131
            r4 = 5
            if (r0 == r4) goto L_0x0131
            goto L_0x0133
        L_0x0131:
            r0 = 1
            goto L_0x0134
        L_0x0133:
            r0 = 0
        L_0x0134:
            if (r0 == 0) goto L_0x01a3
            boolean r0 = r8.V
            if (r0 != 0) goto L_0x01a3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.travel.bus.a.a()
            com.travel.g.a r4 = com.travel.bus.a.b()
            java.lang.String r4 = r4.P()
            r0.append(r4)
            android.content.Context r4 = r8.getContext()
            java.lang.String r4 = com.paytm.utility.c.a((android.content.Context) r4, (boolean) r2)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.paytmmall.clpartifact.utils.SFInterface r4 = com.paytmmall.clpartifact.utils.SFInterface.INSTANCE
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            com.paytm.network.a$c r6 = com.paytm.network.a.c.BUS
            com.travel.bus.orders.c.a$5 r7 = new com.travel.bus.orders.c.a$5
            r7.<init>()
            r4.getStoreFrontReponse(r0, r5, r6, r7)
            net.one97.paytm.cashback.posttxn.e r0 = net.one97.paytm.cashback.posttxn.c.a()
            if (r0 == 0) goto L_0x01a3
            androidx.fragment.app.FragmentActivity r4 = r8.getActivity()
            boolean r4 = r4 instanceof androidx.appcompat.app.AppCompatActivity
            if (r4 == 0) goto L_0x01a3
            androidx.fragment.app.FragmentActivity r4 = r8.getActivity()
            androidx.appcompat.app.AppCompatActivity r4 = (androidx.appcompat.app.AppCompatActivity) r4
            r0.a(r4)
            net.one97.paytm.cashback.posttxn.f$a r4 = new net.one97.paytm.cashback.posttxn.f$a
            r4.<init>()
            java.lang.String r5 = r8.o
            r4.f49546b = r5
            java.lang.String r5 = "26"
            r4.f49550f = r5
            java.lang.String r5 = "25173"
            r4.f49551g = r5
            net.one97.paytm.cashback.posttxn.f r4 = r4.a()
            com.travel.bus.orders.c.a$6 r5 = new com.travel.bus.orders.c.a$6
            r5.<init>()
            r0.a((net.one97.paytm.cashback.posttxn.f) r4, (net.one97.paytm.cashback.posttxn.a) r5)
            r8.V = r3
        L_0x01a3:
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r8.g()
            boolean r0 = r8.f(r0)
            if (r0 == 0) goto L_0x01cc
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r8.g()
            boolean r0 = d((com.travel.bus.pojo.busticket.CJRBusOrderSummary) r0)
            if (r0 != 0) goto L_0x01cc
            com.travel.bus.orders.c.c$b r0 = r8.q
            com.travel.bus.orders.c.c$b r4 = com.travel.bus.orders.c.c.b.PAYMENT_PENDING
            if (r0 == r4) goto L_0x01cc
            com.travel.bus.orders.c.c$b r0 = r8.q
            com.travel.bus.orders.c.c$b r4 = com.travel.bus.orders.c.c.b.BOOKING_PENDING
            if (r0 == r4) goto L_0x01cc
            boolean r0 = r8.E
            if (r0 == 0) goto L_0x01cc
            com.travel.bus.orders.c.c$a r0 = com.travel.bus.orders.c.c.a.BUS_NPS_WIDGET
            r9.add(r0)
        L_0x01cc:
            com.travel.bus.orders.c.c$a r0 = com.travel.bus.orders.c.c.a.FOOTER
            r9.add(r0)
            boolean r0 = r8.T
            if (r0 == 0) goto L_0x01d8
            r8.d(r9)
        L_0x01d8:
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r8.g()
            boolean r0 = i(r0)
            if (r0 == 0) goto L_0x0217
            r0 = -1
        L_0x01e3:
            int r4 = r9.size()
            if (r2 >= r4) goto L_0x01f6
            java.lang.Object r4 = r9.get(r2)
            com.travel.bus.orders.c.c$a r5 = com.travel.bus.orders.c.c.a.HOTEL_OPTIONS
            if (r4 != r5) goto L_0x01f3
            r0 = r2
            goto L_0x01f6
        L_0x01f3:
            int r2 = r2 + 1
            goto L_0x01e3
        L_0x01f6:
            com.travel.bus.orders.c.c$a r2 = com.travel.bus.orders.c.c.a.CASHBACK_DETAILS
            boolean r2 = r9.contains(r2)
            if (r2 == 0) goto L_0x0203
            com.travel.bus.orders.c.c$a r2 = com.travel.bus.orders.c.c.a.CASHBACK_DETAILS
            r9.remove(r2)
        L_0x0203:
            if (r0 <= 0) goto L_0x0212
            int r0 = r0 + r3
            int r2 = r9.size()
            if (r0 >= r2) goto L_0x0212
            com.travel.bus.orders.c.c$a r1 = com.travel.bus.orders.c.c.a.CASHBACK_DETAILS
            r9.add(r0, r1)
            goto L_0x0217
        L_0x0212:
            com.travel.bus.orders.c.c$a r0 = com.travel.bus.orders.c.c.a.CASHBACK_DETAILS
            r9.add(r1, r0)
        L_0x0217:
            boolean r0 = r8.I
            if (r0 == 0) goto L_0x0220
            com.travel.bus.orders.c.c$a r0 = com.travel.bus.orders.c.c.a.CASHBACK_DETAILS
            r9.remove(r0)
        L_0x0220:
            r8.f22571b = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.c.a.b(java.util.List):void");
    }

    private static void c(List<c.a> list) {
        int i2;
        int i3 = 0;
        while (true) {
            if (i3 >= list.size()) {
                i3 = -1;
                break;
            } else if (list.get(i3) == c.a.HOTEL_OPTIONS) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 <= 0 || (i2 = i3 + 1) >= list.size()) {
            list.add(3, c.a.CASHBACK_DETAILS);
        } else {
            list.add(i2, c.a.CASHBACK_DETAILS);
        }
    }

    private void d(List<c.a> list) {
        if (list != null) {
            int i2 = 0;
            if (list.size() > 0) {
                i2 = list.size() / 2;
            }
            com.travel.bus.a.a();
            int a2 = com.travel.bus.a.b().a("hotelIndexForBusOrderSummary", i2);
            if (a2 < list.size() && a2 >= 0) {
                i2 = a2;
            }
            list.add(i2, c.a.HOTEL_OPTIONS);
            if (i(g())) {
                if (list.contains(c.a.CASHBACK_DETAILS)) {
                    list.remove(c.a.CASHBACK_DETAILS);
                }
                c(list);
            }
            if (this.I) {
                list.remove(c.a.CASHBACK_DETAILS);
            }
        }
    }

    private boolean j() {
        CJRBusOrderSummary g2 = g();
        if (g2 == null) {
            return false;
        }
        boolean z = g2.getPaymentStatus().equals("FAILED") || g2.getPaymentStatus().equals("PROCESSING");
        if (g2.getStatus().equals(SDKConstants.GA_NATIVE_FAILED)) {
            z = true;
        }
        Iterator<CJRBusOrderedCart> it2 = g2.getOrderedCartList().iterator();
        while (it2.hasNext()) {
            CJRBusOrderedCart next = it2.next();
            if (com.travel.bus.orders.h.b.b(next)) {
                if (!(next == null || next.getFullFillmentOject() == null || next.getFullFillmentOject().getFullFillment() == null)) {
                    this.Q += next.getPrice();
                }
                if (next != null && next.getStatus().equalsIgnoreCase("FAILED")) {
                    z = true;
                }
            }
        }
        if (!z) {
            return true;
        }
        return false;
    }

    private boolean f(CJRBusOrderSummary cJRBusOrderSummary) {
        boolean z = false;
        if (!(cJRBusOrderSummary == null || cJRBusOrderSummary.getOrderedCartList() == null)) {
            Iterator<CJRBusOrderedCart> it2 = cJRBusOrderSummary.getOrderedCartList().iterator();
            while (it2.hasNext()) {
                if (com.travel.bus.orders.h.b.b(it2.next()) && cJRBusOrderSummary.getPaymentStatus().equals("SUCCESS") && this.q != c.b.BOOKING_FAILED) {
                    z = true;
                }
            }
        }
        return z;
    }

    private static boolean g(CJRBusOrderSummary cJRBusOrderSummary) {
        if (!(cJRBusOrderSummary == null || cJRBusOrderSummary.getOrderedCartList() == null || cJRBusOrderSummary.getOrderedCartList().size() <= 0)) {
            Iterator<CJRBusOrderedCart> it2 = cJRBusOrderSummary.getOrderedCartList().iterator();
            while (it2.hasNext()) {
                CJRBusOrderedCart next = it2.next();
                if (com.travel.bus.orders.h.b.b(next) && Integer.parseInt(next.getItemStatus()) == 18) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean h(CJRBusOrderSummary cJRBusOrderSummary) {
        boolean z = false;
        if (!(cJRBusOrderSummary == null || cJRBusOrderSummary.getOrderedCartList() == null)) {
            Iterator<CJRBusOrderedCart> it2 = cJRBusOrderSummary.getOrderedCartList().iterator();
            while (it2.hasNext()) {
                CJRBusOrderedCart next = it2.next();
                if ((com.travel.bus.orders.h.b.b(next) && next.getFullFillmentOject() != null && next.getFullFillmentOject().getFulfillmentResponse() != null) || cJRBusOrderSummary.getPaymentStatus().equals("FAILED") || cJRBusOrderSummary.getPaymentStatus().equals("PROCESSING") || cJRBusOrderSummary.getPaymentStatus().equals("SUCCESS")) {
                    z = true;
                }
            }
        }
        return z;
    }

    private static boolean i(CJRBusOrderSummary cJRBusOrderSummary) {
        boolean z;
        try {
            Iterator<CJRBusOrderedCart> it2 = cJRBusOrderSummary.getOrderedCartList().iterator();
            boolean z2 = false;
            while (true) {
                z = true;
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                CJRBusOrderedCart next = it2.next();
                if (cJRBusOrderSummary.getPaymentStatus().equalsIgnoreCase("success") && !TextUtils.isEmpty(next.getPromoCode())) {
                    z2 = true;
                }
                if (Integer.parseInt(next.getItemStatus()) == 17) {
                    break;
                }
            }
            if (d(cJRBusOrderSummary)) {
                z2 = false;
                z = false;
            }
            if (cJRBusOrderSummary.getPaymentStatus().equals("PROCESSING")) {
                z2 = false;
                z = false;
            }
            if (z) {
                return false;
            }
            return z2;
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return false;
        }
    }

    private void j(CJRBusOrderSummary cJRBusOrderSummary) {
        String str;
        if (cJRBusOrderSummary != null) {
            String id = cJRBusOrderSummary.getId();
            Iterator<CJRBusOrderedCart> it2 = cJRBusOrderSummary.getOrderedCartList().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    str = "";
                    break;
                }
                CJRBusOrderedCart next = it2.next();
                if (com.travel.bus.orders.h.b.b(next) && next != null) {
                    Object metaDataResponse = next.getMetaDataResponse();
                    f fVar = new f();
                    str = ((CJRBusOrderSummaryMetaDataResponse) fVar.a(fVar.a(metaDataResponse), CJRBusOrderSummaryMetaDataResponse.class)).getPaytmTripID();
                    break;
                }
            }
            com.travel.bus.a.a();
            String o = com.travel.bus.a.b().o();
            if (o == null || o.isEmpty()) {
                o = "https://travel.paytm.com/api/travel/rnr/v1/order_summary/rating";
            }
            String uri = Uri.parse(o).buildUpon().appendQueryParameter("order_id", id).appendQueryParameter("user_id", com.paytm.utility.b.n((Context) getActivity())).appendQueryParameter("paytm_trip_id", str).appendQueryParameter(ContactsConstant.LOCALE, com.paytm.utility.b.g()).build().toString();
            if (URLUtil.isValidUrl(uri)) {
                try {
                    if (getActivity() != null && !getActivity().isFinishing() && com.paytm.utility.b.c((Context) getActivity())) {
                        new ArrayList().add(Integer.valueOf(H5ErrorCode.HTTP_SERVICE_UNAVAILABLE));
                        HashMap hashMap = new HashMap();
                        hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(getActivity()));
                        a(uri, hashMap, (String) null, new CJRBusOrderSummaryRating(), a.C0715a.GET);
                    }
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
            }
        }
    }

    private boolean k(CJRBusOrderSummary cJRBusOrderSummary) {
        boolean z;
        if (!(cJRBusOrderSummary == null || cJRBusOrderSummary.getOrderedCartList() == null || this.q != c.b.BOOKING_SUCCESSFUL) || this.q == c.b.PAYMENT_SUCCESS) {
            Iterator<CJRBusOrderedCart> it2 = cJRBusOrderSummary.getOrderedCartList().iterator();
            while (it2.hasNext()) {
                CJRBusOrderedCart next = it2.next();
                if (com.travel.bus.orders.h.b.b(next) && next.getAction() != null && next.getAction().size() > 0) {
                    Iterator<CJROrderSummaryAction> it3 = next.getAction().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z = false;
                            break;
                        }
                        CJROrderSummaryAction next2 = it3.next();
                        if (next2.getOrderLevel() != null && next2.getOrderLevel().booleanValue()) {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: com.travel.bus.orders.c.a$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22578a = new int[c.b.values().length];

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f22580c = new int[com.travel.bus.orders.b.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|(2:15|16)|17|(2:19|20)|21|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|(2:39|40)|41|43|44|45|46|47|48|49|50|(3:51|52|54)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|(2:19|20)|21|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|(2:39|40)|41|43|44|45|46|47|48|49|50|(3:51|52|54)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|(2:1|2)|3|5|6|7|9|10|(2:11|12)|13|15|16|17|(2:19|20)|21|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|(2:39|40)|41|43|44|45|46|47|48|49|50|(3:51|52|54)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|(2:1|2)|3|5|6|7|9|10|11|12|13|15|16|17|(2:19|20)|21|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|43|44|45|46|47|48|49|50|(3:51|52|54)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|(2:1|2)|3|5|6|7|9|10|11|12|13|15|16|17|(2:19|20)|21|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|43|44|45|46|47|48|49|50|51|52|54) */
        /* JADX WARNING: Can't wrap try/catch for region: R(47:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|(2:19|20)|21|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|43|44|45|46|47|48|49|50|51|52|54) */
        /* JADX WARNING: Can't wrap try/catch for region: R(48:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|19|20|21|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|43|44|45|46|47|48|49|50|51|52|54) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0068 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0097 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00a3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00af */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00e2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00ec */
        static {
            /*
                com.travel.bus.orders.b.a[] r0 = com.travel.bus.orders.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22580c = r0
                r0 = 1
                int[] r1 = f22580c     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.bus.orders.b.a r2 = com.travel.bus.orders.b.a.TRAVEL_BUDDY_BANNER_CLICK     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f22580c     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.bus.orders.b.a r3 = com.travel.bus.orders.b.a.SUMMARY_REVIEW_AND_RATINGS     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                com.travel.bus.orders.c.c$a[] r2 = com.travel.bus.orders.c.c.a.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f22579b = r2
                int[] r2 = f22579b     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.travel.bus.orders.c.c$a r3 = com.travel.bus.orders.c.c.a.HEADER     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r2 = f22579b     // Catch:{ NoSuchFieldError -> 0x003c }
                com.travel.bus.orders.c.c$a r3 = com.travel.bus.orders.c.c.a.PASSENGER_DESC_CARD_ONGOING     // Catch:{ NoSuchFieldError -> 0x003c }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                r2 = 3
                int[] r3 = f22579b     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.travel.bus.orders.c.c$a r4 = com.travel.bus.orders.c.c.a.PASSENER_CARD_LIST     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                r3 = 4
                int[] r4 = f22579b     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.travel.bus.orders.c.c$a r5 = com.travel.bus.orders.c.c.a.PAYMENT_DETAILS     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                r4 = 5
                int[] r5 = f22579b     // Catch:{ NoSuchFieldError -> 0x005d }
                com.travel.bus.orders.c.c$a r6 = com.travel.bus.orders.c.c.a.CASHBACK_DETAILS     // Catch:{ NoSuchFieldError -> 0x005d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                int[] r5 = f22579b     // Catch:{ NoSuchFieldError -> 0x0068 }
                com.travel.bus.orders.c.c$a r6 = com.travel.bus.orders.c.c.a.REFUND_SUMMARY     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r7 = 6
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                int[] r5 = f22579b     // Catch:{ NoSuchFieldError -> 0x0073 }
                com.travel.bus.orders.c.c$a r6 = com.travel.bus.orders.c.c.a.HOTEL_OPTIONS     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r7 = 7
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                int[] r5 = f22579b     // Catch:{ NoSuchFieldError -> 0x007f }
                com.travel.bus.orders.c.c$a r6 = com.travel.bus.orders.c.c.a.BUS_NPS_WIDGET     // Catch:{ NoSuchFieldError -> 0x007f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r7 = 8
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                int[] r5 = f22579b     // Catch:{ NoSuchFieldError -> 0x008b }
                com.travel.bus.orders.c.c$a r6 = com.travel.bus.orders.c.c.a.TRAVEL_BUDDY_BANNER     // Catch:{ NoSuchFieldError -> 0x008b }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x008b }
                r7 = 9
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x008b }
            L_0x008b:
                int[] r5 = f22579b     // Catch:{ NoSuchFieldError -> 0x0097 }
                com.travel.bus.orders.c.c$a r6 = com.travel.bus.orders.c.c.a.BUS_RATING_WIDGET     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r7 = 10
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                int[] r5 = f22579b     // Catch:{ NoSuchFieldError -> 0x00a3 }
                com.travel.bus.orders.c.c$a r6 = com.travel.bus.orders.c.c.a.FOOTER     // Catch:{ NoSuchFieldError -> 0x00a3 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a3 }
                r7 = 11
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x00a3 }
            L_0x00a3:
                int[] r5 = f22579b     // Catch:{ NoSuchFieldError -> 0x00af }
                com.travel.bus.orders.c.c$a r6 = com.travel.bus.orders.c.c.a.CANCEL_PROTECT     // Catch:{ NoSuchFieldError -> 0x00af }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00af }
                r7 = 12
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x00af }
            L_0x00af:
                int[] r5 = f22579b     // Catch:{ NoSuchFieldError -> 0x00bb }
                com.travel.bus.orders.c.c$a r6 = com.travel.bus.orders.c.c.a.THIN_BANNER     // Catch:{ NoSuchFieldError -> 0x00bb }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bb }
                r7 = 13
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x00bb }
            L_0x00bb:
                com.travel.bus.orders.c.c$b[] r5 = com.travel.bus.orders.c.c.b.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f22578a = r5
                int[] r5 = f22578a     // Catch:{ NoSuchFieldError -> 0x00ce }
                com.travel.bus.orders.c.c$b r6 = com.travel.bus.orders.c.c.b.PAYMENT_SUCCESS     // Catch:{ NoSuchFieldError -> 0x00ce }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ce }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x00ce }
            L_0x00ce:
                int[] r0 = f22578a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.travel.bus.orders.c.c$b r5 = com.travel.bus.orders.c.c.b.PAYMENT_PENDING     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = f22578a     // Catch:{ NoSuchFieldError -> 0x00e2 }
                com.travel.bus.orders.c.c$b r1 = com.travel.bus.orders.c.c.b.BOOKING_SUCCESSFUL     // Catch:{ NoSuchFieldError -> 0x00e2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e2 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e2 }
            L_0x00e2:
                int[] r0 = f22578a     // Catch:{ NoSuchFieldError -> 0x00ec }
                com.travel.bus.orders.c.c$b r1 = com.travel.bus.orders.c.c.b.BOOKING_FAILED     // Catch:{ NoSuchFieldError -> 0x00ec }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ec }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00ec }
            L_0x00ec:
                int[] r0 = f22578a     // Catch:{ NoSuchFieldError -> 0x00f6 }
                com.travel.bus.orders.c.c$b r1 = com.travel.bus.orders.c.c.b.BOOKING_PENDING     // Catch:{ NoSuchFieldError -> 0x00f6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f6 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00f6 }
            L_0x00f6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.c.a.AnonymousClass2.<clinit>():void");
        }
    }

    public final void a(com.travel.bus.orders.b.a aVar, final CJROrderSummaryAction cJROrderSummaryAction) {
        if (AnonymousClass2.f22580c[aVar.ordinal()] == 1) {
            Intent intent = new Intent(getActivity(), AJRTravelReferralHomeActivity.class);
            intent.putExtra("previousScreen", "bus_order_summary");
            startActivity(intent);
        } else if (!this.w) {
            e();
            this.w = true;
            if (cJROrderSummaryAction == null || TextUtils.isEmpty(cJROrderSummaryAction.getConfirmation())) {
                if (!(cJROrderSummaryAction == null || cJROrderSummaryAction.getActionName() == null)) {
                    cJROrderSummaryAction.getActionName().equalsIgnoreCase(TransactionType.CANCEL);
                }
                a(cJROrderSummaryAction);
                return;
            }
            try {
                String confirmation = cJROrderSummaryAction.getConfirmation();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(confirmation);
                builder.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                        a.this.a(cJROrderSummaryAction);
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setCancelable(false);
                builder.show();
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
        if (this.w) {
            f();
            this.w = false;
        }
    }

    public void onStart() {
        super.onStart();
        m mVar = this.f22575f;
        if (mVar != null) {
            mVar.f22757a = false;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1 && this.z != null) {
            this.z.sendEmptyMessage(1);
        }
    }

    /* access modifiers changed from: private */
    public void a(CJROrderSummaryAction cJROrderSummaryAction) {
        try {
            if (cJROrderSummaryAction.getUrlParams() == null || cJROrderSummaryAction.getUrlParams().getMethod() == null || !cJROrderSummaryAction.getUrlParams().getMethod().equalsIgnoreCase("POST")) {
                this.f22600h.a(cJROrderSummaryAction.getLabel());
                b(cJROrderSummaryAction.getLabel(), cJROrderSummaryAction.getUrlParams().getUrl());
            } else {
                this.f22600h.a(cJROrderSummaryAction.getLabel());
                a(cJROrderSummaryAction.getLabel(), cJROrderSummaryAction.getUrlParams().getUrl());
            }
            b(cJROrderSummaryAction);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    private void b(CJROrderSummaryAction cJROrderSummaryAction) {
        HashMap hashMap;
        if (cJROrderSummaryAction != null) {
            try {
                if (!TextUtils.isEmpty(cJROrderSummaryAction.getLabel())) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("user_id", com.paytm.utility.b.n((Context) getActivity()));
                    HashMap hashMap3 = hashMap2;
                    if (cJROrderSummaryAction.getLabel().equalsIgnoreCase("Cancel Tickets")) {
                        if (!(this.U == null || this.U.getOrderedCartList() == null || this.U.getOrderedCartList().size() <= 0)) {
                            g gVar = (g) this.U.getOrderedCartList().get(0).getMetaDataResponse();
                            if (gVar.get("passengers") != null) {
                                ArrayList arrayList = (ArrayList) gVar.get("passengers");
                                HashMap hashMap4 = new HashMap();
                                hashMap4.put("event_label", ((g) arrayList.get(0)).get("operator_name"));
                                hashMap4.put("event_label2", ((g) arrayList.get(0)).get("source") + "/" + ((g) arrayList.get(0)).get("destination"));
                                hashMap4.put("event_label3", gVar.get("providerName"));
                                hashMap4.put("userid", com.paytm.utility.b.n((Context) getActivity()));
                                com.travel.bus.a.a();
                                com.travel.bus.a.a("customEvent", "/bus-tickets-summary", "bus_summary", "cancel_ticket_clicked", hashMap4);
                            }
                        }
                        com.travel.bus.a.a();
                        com.travel.bus.a.b().a(net.one97.paytm.common.utility.d.cz, (Map<String, Object>) hashMap3, (Context) getActivity());
                        return;
                    }
                    HashMap hashMap5 = hashMap3;
                    if (cJROrderSummaryAction.getLabel().equalsIgnoreCase("Resend Ticket")) {
                        if (!(this.U == null || this.U.getOrderedCartList() == null || this.U.getOrderedCartList().size() <= 0)) {
                            g gVar2 = (g) this.U.getOrderedCartList().get(0).getMetaDataResponse();
                            if (gVar2.get("passengers") != null) {
                                ArrayList arrayList2 = (ArrayList) gVar2.get("passengers");
                                HashMap hashMap6 = new HashMap();
                                hashMap = hashMap5;
                                hashMap6.put("event_label", ((g) arrayList2.get(0)).get("operator_name"));
                                hashMap6.put("event_label2", ((g) arrayList2.get(0)).get("source") + "/" + ((g) arrayList2.get(0)).get("destination"));
                                hashMap6.put("event_label3", gVar2.get("providerName"));
                                hashMap6.put("userid", com.paytm.utility.b.n((Context) getActivity()));
                                com.travel.bus.a.a();
                                com.travel.bus.a.a("customEvent", "/bus-tickets-summary", "bus_summary", "resend_ticket_clicked", hashMap6);
                                com.travel.bus.a.a();
                                com.travel.bus.a.b().a(net.one97.paytm.common.utility.d.cA, (Map<String, Object>) hashMap, (Context) getActivity());
                                return;
                            }
                        }
                        hashMap = hashMap5;
                        com.travel.bus.a.a();
                        com.travel.bus.a.b().a(net.one97.paytm.common.utility.d.cA, (Map<String, Object>) hashMap, (Context) getActivity());
                        return;
                    }
                    HashMap hashMap7 = hashMap5;
                    if (cJROrderSummaryAction.getLabel().equalsIgnoreCase("Invoice")) {
                        com.travel.bus.a.a();
                        com.travel.bus.a.b().a(net.one97.paytm.common.utility.d.cB, (Map<String, Object>) hashMap7, (Context) getActivity());
                    }
                }
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
    }

    private void a(String str, String str2) {
        String str3;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (str == null || str.equalsIgnoreCase("invoice")) {
            str3 = a(str2);
        } else {
            hashMap.put("sso_token=", p.a((Context) getActivity()));
            str3 = com.paytm.utility.b.s(getActivity(), str2);
        }
        String replace = str3.replace(" ", "%20");
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = getActivity();
        bVar.f42878b = a.c.BUS;
        bVar.f42879c = a.C0715a.POST;
        bVar.f42880d = replace;
        bVar.f42881e = null;
        bVar.f42882f = hashMap;
        bVar.f42883g = null;
        bVar.f42884h = null;
        bVar.f42885i = new CJRActionResponse();
        bVar.j = this;
        bVar.t = null;
        bVar.n = a.b.SILENT;
        bVar.o = "bus-order-summary-page";
        com.paytm.network.a l = bVar.l();
        l.f42860d = true;
        l.a();
    }

    private void b(String str, String str2) {
        String str3;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (str == null || str.equalsIgnoreCase("invoice")) {
            str3 = a(str2);
        } else {
            hashMap.put("sso_token=", p.a((Context) getActivity()));
            str3 = com.paytm.utility.b.s(getActivity(), str2);
        }
        String replace = str3.replace(" ", "%20");
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = getActivity();
        bVar.f42878b = a.c.BUS;
        bVar.f42879c = a.C0715a.GET;
        bVar.f42880d = replace;
        bVar.f42881e = null;
        bVar.f42882f = hashMap;
        bVar.f42883g = null;
        bVar.f42884h = null;
        bVar.f42885i = new CJRActionResponse();
        bVar.j = this;
        bVar.t = null;
        bVar.n = a.b.SILENT;
        bVar.o = "bus-order-summary-page";
        com.paytm.network.a l = bVar.l();
        l.f42860d = true;
        l.a();
    }

    private static String a(String str) {
        String str2;
        Uri parse = Uri.parse(str);
        if (parse == null) {
            str2 = str + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN;
        } else if (parse.getQuery() != null) {
            str2 = str + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN;
        } else {
            str2 = str + "?";
        }
        com.travel.bus.a.a();
        return str2 + "sso_token=" + com.travel.bus.b.a.a(com.travel.bus.a.b().D()).b("sso_token=", "", true);
    }

    public final void a(com.travel.bus.orders.b.a aVar, IJRPaytmDataModel iJRPaytmDataModel) {
        if (AnonymousClass2.f22580c[aVar.ordinal()] == 2) {
            CJRBusNpsCaptureDataModel cJRBusNpsCaptureDataModel = (CJRBusNpsCaptureDataModel) iJRPaytmDataModel;
            if (g() != null && this.f22570a.getItemIds() != null && cJRBusNpsCaptureDataModel != null && com.paytm.utility.b.c((Context) getActivity())) {
                com.travel.bus.orders.h.a.a(getActivity(), cJRBusNpsCaptureDataModel.getResponse(), g().getId(), "npsFeedback-bus", this.f22570a.getItemIds(), this);
            }
        }
    }

    private static CJRNPSCaptureDataModel a(String str, CJRBusOrderSummary cJRBusOrderSummary) {
        return new CJRNPSCaptureDataModel.a().a(str).a(l(cJRBusOrderSummary)).f22782a;
    }

    private static ArrayList<String> l(CJRBusOrderSummary cJRBusOrderSummary) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<CJRBusOrderedCart> it2 = cJRBusOrderSummary.getOrderedCartList().iterator();
        while (it2.hasNext()) {
            arrayList.add(String.valueOf(it2.next().getId()));
        }
        return arrayList;
    }

    public final void a(CJRBusRefundDetails cJRBusRefundDetails) {
        boolean z;
        y yVar = y.f22482a;
        y.a((Object) cJRBusRefundDetails);
        if (!(cJRBusRefundDetails == null || ((cJRBusRefundDetails.getRefundCard() == null || cJRBusRefundDetails.getRefundCard().getDisplayData() == null) && cJRBusRefundDetails.getCancelPolicy() == null))) {
            this.M = cJRBusRefundDetails;
            boolean z2 = false;
            if (!this.f22571b.contains(c.a.TRAVEL_BUDDY_BANNER) || !g(g())) {
                CJRBusRefundDetails cJRBusRefundDetails2 = this.M;
                if (!(cJRBusRefundDetails2 == null || cJRBusRefundDetails2.getRefundCard() == null)) {
                    Iterator<c.a> it2 = this.f22571b.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next() == c.a.REFUND_SUMMARY) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z && g(g())) {
                        this.f22571b.add(2, c.a.REFUND_SUMMARY);
                        this.x = true;
                    }
                }
            } else {
                List<c.a> list = this.f22571b;
                list.add(list.size() - 3, c.a.REFUND_SUMMARY);
                this.x = true;
            }
            CJRBusRefundDetails cJRBusRefundDetails3 = this.M;
            if (cJRBusRefundDetails3.getInsuranceText() != null && (!(cJRBusRefundDetails3.getInsuranceText().getOnward() == null && cJRBusRefundDetails3.getInsuranceText().getReturn() == null) && (!TextUtils.isEmpty(cJRBusRefundDetails3.getInsuranceText().getOnward().getTitle()) || !TextUtils.isEmpty(cJRBusRefundDetails3.getInsuranceText().getReturn().getTitle())))) {
                z2 = true;
            }
            if (z2) {
                this.f22571b.add(3, c.a.CANCEL_PROTECT);
            }
        }
        if (!(cJRBusRefundDetails == null || cJRBusRefundDetails.getBusBPPhotos() == null || cJRBusRefundDetails.getBusBPPhotos().getOnward() == null)) {
            this.N = cJRBusRefundDetails.getBusBPPhotos().getOnward();
        }
        a(this.f22571b);
    }

    public final void a(CJRBusOperatorDetails cJRBusOperatorDetails) {
        if (!(cJRBusOperatorDetails == null || cJRBusOperatorDetails.getBusDriverDetails() == null || cJRBusOperatorDetails.getBusDriverDetails().getOnwardJourney() == null)) {
            y yVar = y.f22482a;
            y.a((Object) cJRBusOperatorDetails.getBusDriverDetails().getOnwardJourney());
            this.O = cJRBusOperatorDetails.getBusDriverDetails().getOnwardJourney();
        }
        if (!(cJRBusOperatorDetails == null || cJRBusOperatorDetails.getBoardingCoordinates() == null || cJRBusOperatorDetails.getBoardingCoordinates().getOnward() == null)) {
            y yVar2 = y.f22482a;
            y.a((Object) cJRBusOperatorDetails.getBoardingCoordinates());
            this.P = cJRBusOperatorDetails.getBoardingCoordinates();
        }
        if (!(cJRBusOperatorDetails == null || cJRBusOperatorDetails.getBoardingCoordinates() == null || cJRBusOperatorDetails.getBoardingCoordinates().getReturn() == null)) {
            y yVar3 = y.f22482a;
            y.a((Object) cJRBusOperatorDetails.getBoardingCoordinates());
            this.P = cJRBusOperatorDetails.getBoardingCoordinates();
        }
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                a.this.f();
                a aVar = a.this;
                aVar.a(aVar.f22571b);
            }
        }, 500);
    }

    public final void a(CJRHotelObject cJRHotelObject) {
        f();
        if (cJRHotelObject != null) {
            if (g().getOrderStatus() == 2) {
                this.T = true;
                d(this.n);
                a(this.n);
            }
        }
    }

    public final void d() {
        f();
    }

    public final void a(CJRBusOrderSummaryRating cJRBusOrderSummaryRating) {
        if (cJRBusOrderSummaryRating != null && cJRBusOrderSummaryRating.getBody() != null) {
            this.f22573d = cJRBusOrderSummaryRating.getBody();
            if (this.f22573d.getIsTripCompleted() != null && this.f22573d.getIsTripCompleted().booleanValue()) {
                List<c.a> list = this.f22571b;
                if (list != null && list.size() > 2 && !this.f22571b.contains(c.a.BUS_RATING_WIDGET)) {
                    this.f22571b.add(1, c.a.BUS_RATING_WIDGET);
                }
                a(this.f22571b);
            }
        }
    }
}
