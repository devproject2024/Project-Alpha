package com.travel.flight.flightorder.d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytmmall.clpartifact.listeners.IAdListener;
import com.paytmmall.clpartifact.listeners.IGAClickListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.travel.flight.R;
import com.travel.flight.b.be;
import com.travel.flight.b.bg;
import com.travel.flight.b.dq;
import com.travel.flight.flightorder.activity.FlightOrderSummary;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.flightorder.g.b;
import com.travel.flight.flightorder.g.c;
import com.travel.flight.flightorder.g.g;
import com.travel.flight.flightorder.j.d;
import com.travel.flight.flightorder.j.h;
import com.travel.flight.flightorder.j.j;
import com.travel.flight.flightorder.j.k;
import com.travel.flight.flightorder.j.l;
import com.travel.flight.flightorder.j.n;
import com.travel.flight.flightorder.j.o;
import com.travel.flight.flightorder.j.p;
import com.travel.flight.flightticket.activity.AJRFlightModifyTicket;
import com.travel.flight.pojo.CJRHotelOptions;
import com.travel.flight.pojo.e;
import com.travel.flight.pojo.flightticket.CJRActionResponse;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import com.travel.flight.pojo.flightticket.CJRNPSCaptureDataModel;
import com.travel.flight.utils.i;
import com.travel.utils.q;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryAction;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems;
import net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse;
import net.one97.paytm.common.entity.replacement.CJRReplacementResponse;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytmflight.common.entity.flightticket.BundleCard;
import net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation;
import net.one97.paytmflight.common.shopping.CJRFlightImageData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends b implements com.travel.flight.flightorder.g.a, b, c, g {
    private String A;
    private e B;
    private CJRHotelOptions C;
    private boolean D = false;
    private boolean E = false;
    /* access modifiers changed from: private */
    public IStaticWidget F;
    /* access modifiers changed from: private */
    public int G = com.paytm.utility.b.c(100);
    /* access modifiers changed from: private */
    public int H = 0;

    /* renamed from: a  reason: collision with root package name */
    public m f24354a;
    private com.travel.flight.flightorder.h.a q;
    private ScheduledExecutorService r;
    private CJROrderSummaryCancellation s;
    private FlightOrderSummary.a t;
    private CJRNPSCaptureDataModel u;
    private com.travel.flight.flightorder.j.g v;
    private boolean w = false;
    private com.travel.flight.flightorder.f.a x;
    private com.travel.flight.flightorder.f.a y;
    private String z;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f24366b = this;
        this.t = (FlightOrderSummary.a) getArguments().getSerializable("VERTICAL");
        if (getArguments() != null) {
            this.w = getArguments().getBoolean("isFromPayment");
            this.n = this.w;
        }
        this.q = new com.travel.flight.flightorder.h.a(getActivity());
        this.q.f24416b = this;
        return onCreateView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        com.travel.flight.flightorder.h.a aVar = this.q;
        if (aVar == null) {
            aVar.f24416b = null;
            this.q = null;
        }
        l();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        q.a(getActivity());
        q.c(getActivity());
    }

    /* JADX WARNING: Removed duplicated region for block: B:182:0x04d1 A[Catch:{ Exception -> 0x0517 }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r12) {
        /*
            r11 = this;
            if (r12 == 0) goto L_0x0518
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r0 = r12.getBody()
            if (r0 != 0) goto L_0x000a
            goto L_0x0518
        L_0x000a:
            java.util.List<com.travel.flight.flightorder.d.b$a> r0 = r11.f24367c
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x01eb
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r3 = r11.j()
            com.travel.flight.flightorder.d.b$a r4 = com.travel.flight.flightorder.d.b.a.HEADER
            r0.add(r4)
            com.travel.flight.flightorder.d.b$a r4 = com.travel.flight.flightorder.d.b.a.TICKET_VARIOUS_OPTIONS
            r0.add(r4)
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r4 = r3.getBody()
            java.lang.String r4 = r4.getInfo_box_html()
            if (r4 == 0) goto L_0x002d
            com.travel.flight.flightorder.d.b$a r4 = com.travel.flight.flightorder.d.b.a.ITEM_VIEW_HTML_BOX
            r0.add(r4)
        L_0x002d:
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r4 = r11.j()
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r4 = r4.getBody()
            net.one97.paytmflight.common.entity.flightticket.BundleCard r4 = r4.getBundle_card()
            if (r4 == 0) goto L_0x0047
            java.lang.String r4 = r4.getPromo_title()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0047
            r4 = 1
            goto L_0x0048
        L_0x0047:
            r4 = 0
        L_0x0048:
            if (r4 == 0) goto L_0x004f
            com.travel.flight.flightorder.d.b$a r4 = com.travel.flight.flightorder.d.b.a.FLIGHT_BUNDLE_COUPON
            r0.add(r4)
        L_0x004f:
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r4 = r3.getBody()
            com.travel.flight.pojo.FlightBookingRefundDetails r4 = r4.getRefundDetails()
            if (r4 == 0) goto L_0x005e
            com.travel.flight.flightorder.d.b$a r4 = com.travel.flight.flightorder.d.b.a.REFUND_DETAILS
            r0.add(r4)
        L_0x005e:
            com.travel.flight.flightorder.d.b$a r4 = com.travel.flight.flightorder.d.b.a.PASSENGER_DESC_CARD_ONGOING
            r0.add(r4)
            boolean r4 = com.travel.flight.flightorder.h.a.a(r3)
            if (r4 == 0) goto L_0x006e
            com.travel.flight.flightorder.d.b$a r4 = com.travel.flight.flightorder.d.b.a.PASSENGER_DESC_CARD_RETURN
            r0.add(r4)
        L_0x006e:
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r4 = r11.j()
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r4 = r4.getBody()
            com.travel.flight.pojo.ModifiedParentOrder r4 = r4.getModifiedParentOrder()
            if (r4 == 0) goto L_0x0088
            java.lang.String r4 = r4.getOrderId()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0088
            r4 = 1
            goto L_0x0089
        L_0x0088:
            r4 = 0
        L_0x0089:
            if (r4 == 0) goto L_0x0090
            com.travel.flight.flightorder.d.b$a r4 = com.travel.flight.flightorder.d.b.a.MODIFY
            r0.add(r4)
        L_0x0090:
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r4 = r11.j()
            if (r4 == 0) goto L_0x00a8
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r5 = r4.getBody()
            if (r5 == 0) goto L_0x00a8
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r4 = r4.getBody()
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryCashbackCard r4 = r4.getCashback_card()
            if (r4 == 0) goto L_0x00a8
            r4 = 1
            goto L_0x00a9
        L_0x00a8:
            r4 = 0
        L_0x00a9:
            if (r4 == 0) goto L_0x00b0
            com.travel.flight.flightorder.d.b$a r4 = com.travel.flight.flightorder.d.b.a.CASHBACK_DETAILS
            r0.add(r4)
        L_0x00b0:
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r4 = r11.j()
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r4 = r4.getBody()
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryCancallationProtect r4 = r4.getCp_card()
            if (r4 == 0) goto L_0x00c0
            r4 = 1
            goto L_0x00c1
        L_0x00c0:
            r4 = 0
        L_0x00c1:
            if (r4 == 0) goto L_0x00c8
            com.travel.flight.flightorder.d.b$a r4 = com.travel.flight.flightorder.d.b.a.CANCEL_PROTECT
            r0.add(r4)
        L_0x00c8:
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r4 = r11.j()
            boolean r4 = com.travel.flight.flightorder.h.a.b(r4)
            if (r4 != 0) goto L_0x00e6
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r4 = r11.j()
            boolean r4 = com.travel.flight.flightorder.h.a.d(r4)
            if (r4 != 0) goto L_0x00e6
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r4 = r11.j()
            boolean r4 = com.travel.flight.flightorder.h.a.c(r4)
            if (r4 == 0) goto L_0x00eb
        L_0x00e6:
            com.travel.flight.flightorder.d.b$a r4 = com.travel.flight.flightorder.d.b.a.FLIGHT_ANCILLARY
            r0.add(r4)
        L_0x00eb:
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r4 = r3.getBody()
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryPymntSummary r4 = r4.getPymnt_summary()
            if (r4 == 0) goto L_0x00f7
            r4 = 1
            goto L_0x00f8
        L_0x00f7:
            r4 = 0
        L_0x00f8:
            if (r4 == 0) goto L_0x00ff
            com.travel.flight.flightorder.d.b$a r4 = com.travel.flight.flightorder.d.b.a.PAYMENT_DETAILS
            r0.add(r4)
        L_0x00ff:
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r4 = r11.j()
            if (r4 == 0) goto L_0x0121
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r5 = r4.getBody()
            if (r5 == 0) goto L_0x0121
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r5 = r4.getBody()
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryAllStates r5 = r5.getAll_states()
            if (r5 == 0) goto L_0x0121
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r4 = r4.getBody()
            net.one97.paytmflight.common.entity.flightticket.OrderSummaryRefundSummary r4 = r4.getRefund_summary()
            if (r4 == 0) goto L_0x0121
            r4 = 1
            goto L_0x0122
        L_0x0121:
            r4 = 0
        L_0x0122:
            if (r4 == 0) goto L_0x0133
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r3 = r3.getBody()
            com.travel.flight.pojo.FlightBookingRefundDetails r3 = r3.getRefundDetails()
            if (r3 == 0) goto L_0x0133
            com.travel.flight.flightorder.d.b$a r3 = com.travel.flight.flightorder.d.b.a.REFUND_SUMMARY
            r0.add(r3)
        L_0x0133:
            boolean r3 = r11.m()
            if (r3 == 0) goto L_0x01a6
            boolean r3 = r11.E
            if (r3 != 0) goto L_0x01a6
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.travel.flight.b.a()
            com.travel.flight.c r4 = com.travel.flight.b.b()
            java.lang.String r4 = r4.ac()
            r3.append(r4)
            androidx.fragment.app.FragmentActivity r4 = r11.getActivity()
            java.lang.String r4 = com.paytm.utility.c.a((android.content.Context) r4, (boolean) r1)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.paytmmall.clpartifact.utils.SFInterface r4 = com.paytmmall.clpartifact.utils.SFInterface.INSTANCE
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            com.paytm.network.a$c r6 = com.paytm.network.a.c.FLIGHT
            com.travel.flight.flightorder.d.a$2 r7 = new com.travel.flight.flightorder.d.a$2
            r7.<init>()
            r4.getStoreFrontReponse(r3, r5, r6, r7)
            net.one97.paytm.cashback.posttxn.e r3 = net.one97.paytm.cashback.posttxn.c.a()
            if (r3 == 0) goto L_0x01a6
            androidx.fragment.app.FragmentActivity r4 = r11.getActivity()
            boolean r4 = r4 instanceof androidx.appcompat.app.AppCompatActivity
            if (r4 == 0) goto L_0x01a6
            androidx.fragment.app.FragmentActivity r4 = r11.getActivity()
            androidx.appcompat.app.AppCompatActivity r4 = (androidx.appcompat.app.AppCompatActivity) r4
            r3.a(r4)
            net.one97.paytm.cashback.posttxn.f$a r4 = new net.one97.paytm.cashback.posttxn.f$a
            r4.<init>()
            java.lang.String r5 = r11.f24370f
            r4.f49546b = r5
            java.lang.String r5 = "64"
            r4.f49550f = r5
            java.lang.String r5 = "69089"
            r4.f49551g = r5
            net.one97.paytm.cashback.posttxn.f r4 = r4.a()
            com.travel.flight.flightorder.d.a$3 r5 = new com.travel.flight.flightorder.d.a$3
            r5.<init>()
            r3.a((net.one97.paytm.cashback.posttxn.f) r4, (net.one97.paytm.cashback.posttxn.a) r5)
            r11.E = r2
        L_0x01a6:
            com.travel.flight.flightorder.d.b$b r3 = r11.m
            com.travel.flight.flightorder.d.b$b r4 = com.travel.flight.flightorder.d.b.C0467b.BOOKING_SUCCESSFUL
            if (r3 != r4) goto L_0x01b5
            boolean r3 = r11.f24371g
            if (r3 == 0) goto L_0x01b5
            com.travel.flight.flightorder.d.b$a r3 = com.travel.flight.flightorder.d.b.a.REVIEW_RATING_WIDGET
            r0.add(r3)
        L_0x01b5:
            com.travel.flight.flightorder.d.b$a r3 = com.travel.flight.flightorder.d.b.a.FOOTER
            r0.add(r3)
            com.travel.flight.pojo.e r3 = r11.B
            if (r3 == 0) goto L_0x01eb
            com.travel.flight.pojo.CJRHotelOptions r3 = r11.C
            if (r3 == 0) goto L_0x01eb
            java.util.List r3 = r3.getData()
            if (r3 == 0) goto L_0x01eb
            com.travel.flight.pojo.CJRHotelOptions r3 = r11.C
            java.util.List r3 = r3.getData()
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x01eb
            com.travel.flight.pojo.e r3 = r11.B
            int r3 = r3.f25423a
            if (r3 <= 0) goto L_0x01eb
            int r3 = r3 + -1
            int r4 = r0.size()
            if (r3 <= r4) goto L_0x01e6
            int r3 = r0.size()
        L_0x01e6:
            com.travel.flight.flightorder.d.b$a r4 = com.travel.flight.flightorder.d.b.a.HOTEL_OPTIONS
            r0.add(r3, r4)
        L_0x01eb:
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r0 = r12.getBody()
            r3 = 0
            if (r0 == 0) goto L_0x03a8
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r0 = r12.getBody()
            java.lang.String r0 = r0.getOrder_id()
            if (r0 == 0) goto L_0x03a8
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r0 = r12.getBody()
            java.lang.String r0 = r0.getOrder_status()
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r4 = r12.getBody()
            java.util.ArrayList r4 = r4.getItems()
            if (r4 == 0) goto L_0x0394
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r4 = r12.getBody()
            java.util.ArrayList r4 = r4.getItems()
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x0394
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r5 = r12.getBody()
            java.util.ArrayList r5 = r5.getItems()
            java.lang.Object r5 = r5.get(r1)
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems r5 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems) r5
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r6 = r12.getBody()
            java.util.ArrayList r6 = r6.getItems()
            int r6 = r6.size()
            if (r6 <= r2) goto L_0x024c
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r6 = r12.getBody()
            java.util.ArrayList r6 = r6.getItems()
            java.lang.Object r6 = r6.get(r2)
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems r6 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems) r6
            goto L_0x024d
        L_0x024c:
            r6 = r3
        L_0x024d:
            java.lang.String r7 = r5.getIs_roundtrip()
            java.lang.String r8 = "true"
            boolean r7 = r7.equalsIgnoreCase(r8)
            r7 = r7 ^ r2
            java.lang.String r9 = r5.getIs_international()
            boolean r8 = r9.equalsIgnoreCase(r8)
            boolean r9 = android.text.TextUtils.isEmpty(r0)
            if (r9 != 0) goto L_0x026c
            java.lang.String r9 = "event_label"
            r4.put(r9, r0)
        L_0x026c:
            com.travel.flight.utils.j$a r0 = com.travel.flight.utils.j.f25593a
            java.lang.String r0 = com.travel.flight.utils.j.a.a((boolean) r7, (boolean) r8)
            java.lang.String r8 = "event_label2"
            r4.put(r8, r0)
            java.lang.String r0 = r5.getSource()
            java.lang.String r8 = "event_label3"
            r4.put(r8, r0)
            java.lang.String r0 = r5.getDestination()
            java.lang.String r8 = "event_label4"
            r4.put(r8, r0)
            com.travel.flight.utils.j$a r0 = com.travel.flight.utils.j.f25593a
            java.lang.String r0 = r5.getBooking_class()
            androidx.fragment.app.FragmentActivity r8 = r11.getActivity()
            java.lang.String r0 = com.travel.flight.utils.j.a.a((java.lang.String) r0, (android.content.Context) r8)
            java.lang.String r8 = "event_label6"
            r4.put(r8, r0)
            java.lang.String r0 = r5.getTravel_date()
            java.lang.String r8 = "dd MMM yy"
            java.lang.String r9 = "yyyy-MM-dd"
            java.lang.String r0 = com.paytm.utility.b.h(r0, r9, r8)
            java.lang.String r10 = "event_label7"
            r4.put(r10, r0)
            if (r7 != 0) goto L_0x02bf
            if (r6 == 0) goto L_0x02bf
            java.lang.String r0 = r6.getTravel_date()
            java.lang.String r0 = com.paytm.utility.b.h(r0, r9, r8)
            java.lang.String r8 = "event_label8"
            r4.put(r8, r0)
        L_0x02bf:
            java.lang.String r0 = r5.getOrigin_iata()
            java.lang.String r8 = "event_label9"
            r4.put(r8, r0)
            java.lang.String r0 = r5.getDestination_iata()
            java.lang.String r8 = "event_label10"
            r4.put(r8, r0)
            com.travel.flight.utils.j$a r0 = com.travel.flight.utils.j.f25593a
            java.lang.String r0 = com.travel.flight.utils.j.a.a((boolean) r7)
            java.lang.String r8 = "event_label11"
            r4.put(r8, r0)
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r0 = r5.getJourney_details()
            if (r0 == 0) goto L_0x0395
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r0 = r5.getJourney_details()
            java.util.ArrayList r0 = r0.getFlights()
            if (r0 == 0) goto L_0x0395
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r0 = r5.getJourney_details()
            java.util.ArrayList r0 = r0.getFlights()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0395
            java.lang.String r0 = " "
            java.lang.String r8 = "event_label5"
            if (r7 == 0) goto L_0x033a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r7 = r5.getJourney_details()
            java.util.ArrayList r7 = r7.getFlights()
            java.lang.Object r7 = r7.get(r1)
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights r7 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights) r7
            java.lang.String r7 = r7.getAirline_code()
            r6.append(r7)
            r6.append(r0)
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r0 = r5.getJourney_details()
            java.util.ArrayList r0 = r0.getFlights()
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights r0 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights) r0
            java.lang.String r0 = r0.getFlight_no()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r4.put(r8, r0)
            goto L_0x0395
        L_0x033a:
            if (r6 == 0) goto L_0x0395
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r7 = r6.getJourney_details()
            if (r7 == 0) goto L_0x0395
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r7 = r6.getJourney_details()
            java.util.ArrayList r7 = r7.getFlights()
            if (r7 == 0) goto L_0x0395
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r6 = r6.getJourney_details()
            java.util.ArrayList r6 = r6.getFlights()
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x0395
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r7 = r5.getJourney_details()
            java.util.ArrayList r7 = r7.getFlights()
            java.lang.Object r7 = r7.get(r1)
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights r7 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights) r7
            java.lang.String r7 = r7.getAirline_code()
            r6.append(r7)
            r6.append(r0)
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r0 = r5.getJourney_details()
            java.util.ArrayList r0 = r0.getFlights()
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights r0 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights) r0
            java.lang.String r0 = r0.getFlight_no()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r4.put(r8, r0)
            goto L_0x0395
        L_0x0394:
            r4 = r3
        L_0x0395:
            java.lang.String r0 = "order_status"
            b((java.lang.String) r0, (java.util.HashMap<java.lang.String, java.lang.Object>) r4)
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r0 = r12.getBody()
            java.lang.String r0 = r0.getOrder_id()
            com.travel.flight.pojo.flightticket.CJRNPSCaptureDataModel r0 = com.travel.flight.flightorder.h.a.a(r0, r12)
            r11.u = r0
        L_0x03a8:
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r0 = r12.getBody()
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryAllStates r0 = r0.getAll_states()
            int r0 = r0.getBooking()
            r4 = 7
            if (r0 == r4) goto L_0x0407
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r0 = r12.getBody()
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryAllStates r0 = r0.getAll_states()
            int r0 = r0.getBooking()
            r4 = 8
            if (r0 == r4) goto L_0x0407
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r0 = r12.getBody()
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryAllStates r0 = r0.getAll_states()
            int r0 = r0.getBooking()
            r4 = 15
            if (r0 == r4) goto L_0x0407
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r0 = r12.getBody()
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryAllStates r0 = r0.getAll_states()
            int r0 = r0.getBooking()
            r4 = 16
            if (r0 == r4) goto L_0x0407
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r0 = r12.getBody()
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryAllStates r0 = r0.getAll_states()
            int r0 = r0.getBooking()
            r4 = 17
            if (r0 == r4) goto L_0x0407
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r0 = r12.getBody()
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryAllStates r0 = r0.getAll_states()
            int r0 = r0.getBooking()
            r4 = 18
            if (r0 != r4) goto L_0x0408
        L_0x0407:
            r1 = 1
        L_0x0408:
            if (r1 == 0) goto L_0x0486
            net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation r0 = r11.s
            if (r0 != 0) goto L_0x0486
            super.f()
            com.travel.flight.flightorder.h.a r0 = r11.q
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r1 = r12.getBody()
            java.lang.String r1 = r1.getOrder_id()
            com.travel.flight.b.a()
            com.travel.flight.c r4 = com.travel.flight.b.b()
            java.lang.String r4 = r4.p()
            android.content.Context r5 = r0.f24415a
            java.lang.String r4 = com.paytm.utility.b.s(r5, r4)
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r6 = "order_id"
            r5.put(r6, r1)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            android.content.Context r6 = r0.f24415a
            java.lang.String r6 = com.paytm.utility.a.q(r6)
            java.lang.String r7 = "sso_token"
            r1.put(r7, r6)
            com.paytm.network.b r6 = new com.paytm.network.b
            r6.<init>()
            android.content.Context r7 = r0.f24415a
            r6.f42877a = r7
            com.paytm.network.a$b r7 = com.paytm.network.a.b.SILENT
            r6.n = r7
            android.content.Context r7 = r0.f24415a
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getSimpleName()
            r6.o = r7
            com.paytm.network.a$c r7 = com.paytm.network.a.c.FLIGHT
            r6.f42878b = r7
            com.paytm.network.a$a r7 = com.paytm.network.a.C0715a.GET
            r6.f42879c = r7
            r6.f42880d = r4
            r6.f42881e = r3
            r6.f42882f = r1
            r6.f42883g = r5
            r6.f42884h = r3
            net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation r1 = new net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation
            r1.<init>()
            r6.f42885i = r1
            r6.j = r0
            r6.t = r3
            r6.l = r2
            com.paytm.network.a r0 = r6.l()
            r0.a()
        L_0x0486:
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r0 = r12.getBody()     // Catch:{ Exception -> 0x0517 }
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryAllStates r0 = r0.getAll_states()     // Catch:{ Exception -> 0x0517 }
            java.lang.String r1 = "PAYMENT_FAILED"
            if (r0 == 0) goto L_0x04c3
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r0 = r12.getBody()     // Catch:{ Exception -> 0x0517 }
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryAllStates r0 = r0.getAll_states()     // Catch:{ Exception -> 0x0517 }
            int r0 = r0.getBooking()     // Catch:{ Exception -> 0x0517 }
            if (r0 == 0) goto L_0x04c3
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r0 = r12.getBody()     // Catch:{ Exception -> 0x0517 }
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryAllStates r0 = r0.getAll_states()     // Catch:{ Exception -> 0x0517 }
            int r0 = r0.getBooking()     // Catch:{ Exception -> 0x0517 }
            if (r0 == r2) goto L_0x04c4
            r2 = 2
            if (r0 != r2) goto L_0x04b2
            goto L_0x04c4
        L_0x04b2:
            r2 = 3
            if (r0 == r2) goto L_0x04c4
            r2 = 4
            if (r0 == r2) goto L_0x04c4
            r2 = 5
            if (r0 == r2) goto L_0x04c4
            r2 = 6
            if (r0 != r2) goto L_0x04bf
            goto L_0x04c4
        L_0x04bf:
            if (r0 <= r2) goto L_0x04c3
            java.lang.String r3 = "PAYMENT_SUCCESS"
        L_0x04c3:
            r1 = r3
        L_0x04c4:
            a((com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse) r12, (java.lang.String) r1)     // Catch:{ Exception -> 0x0517 }
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r12 = r12.getBody()     // Catch:{ Exception -> 0x0517 }
            java.util.ArrayList r12 = r12.getPayments()     // Catch:{ Exception -> 0x0517 }
            if (r12 == 0) goto L_0x0517
            java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x0517 }
            java.lang.String r0 = ""
            r1 = r0
        L_0x04d8:
            boolean r2 = r12.hasNext()     // Catch:{ Exception -> 0x0517 }
            if (r2 == 0) goto L_0x0517
            java.lang.Object r2 = r12.next()     // Catch:{ Exception -> 0x0517 }
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryPayments r2 = (net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryPayments) r2     // Catch:{ Exception -> 0x0517 }
            boolean r3 = r1.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0517 }
            if (r3 == 0) goto L_0x04fe
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
            r3.<init>()     // Catch:{ Exception -> 0x0517 }
            r3.append(r1)     // Catch:{ Exception -> 0x0517 }
            java.lang.String r1 = r2.getPayment_method()     // Catch:{ Exception -> 0x0517 }
            r3.append(r1)     // Catch:{ Exception -> 0x0517 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0517 }
            goto L_0x04d8
        L_0x04fe:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
            r3.<init>()     // Catch:{ Exception -> 0x0517 }
            r3.append(r1)     // Catch:{ Exception -> 0x0517 }
            java.lang.String r1 = "/"
            r3.append(r1)     // Catch:{ Exception -> 0x0517 }
            java.lang.String r1 = r2.getPayment_method()     // Catch:{ Exception -> 0x0517 }
            r3.append(r1)     // Catch:{ Exception -> 0x0517 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0517 }
            goto L_0x04d8
        L_0x0517:
            return
        L_0x0518:
            androidx.fragment.app.FragmentActivity r12 = r11.getActivity()
            com.travel.flight.flightorder.activity.FlightOrderSummary r12 = (com.travel.flight.flightorder.activity.FlightOrderSummary) r12
            r12.showErrorMessage()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightorder.d.a.a(com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse):void");
    }

    private static void a(CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_label", str);
        try {
            if (!(cJRFlightOrderSummaryResponse.getBody() == null || cJRFlightOrderSummaryResponse.getBody().getPayments() == null || cJRFlightOrderSummaryResponse.getBody().getPayments().size() <= 0)) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < cJRFlightOrderSummaryResponse.getBody().getPayments().size(); i2++) {
                    sb.append(cJRFlightOrderSummaryResponse.getBody().getPayments().get(i2).getPayment_method());
                    sb.append(", ");
                }
                if (!TextUtils.isEmpty(new StringBuilder(sb.substring(sb.length() - 2, sb.length() - 1).trim()))) {
                    hashMap.put("event_label", str);
                }
            }
        } catch (Exception unused) {
        }
        b("payment_status", (HashMap<String, Object>) hashMap);
    }

    public final b.C0467b a(boolean z2) {
        b.C0467b bVar = b.C0467b.NO_OP;
        int booking = j().getBody().getAll_states().getBooking();
        if (booking == 1 || booking == 2) {
            bVar = b.C0467b.PAYMENT_FAILED;
        } else if (booking == 3 || booking == 4 || booking == 5 || booking == 6) {
            bVar = b.C0467b.PAYMENT_PENDING;
        } else if (booking == 13 || booking == 14) {
            bVar = b.C0467b.BOOKING_SUCCESSFUL;
        } else if (booking == 7 || booking == 8) {
            bVar = b.C0467b.BOOKING_FAILED;
        } else if (booking == 9 || booking == 10 || booking == 11 || booking == 12) {
            bVar = b.C0467b.BOOKING_PENDING;
        } else if (booking == 16) {
            bVar = b.C0467b.BOOKING_FULLY_CANCELLED;
        } else if (booking == 17 || booking == 15) {
            bVar = b.C0467b.BOOKING_PARTIALLY_CANCELLED;
        } else if (booking == 18) {
            bVar = b.C0467b.BOOKING_CANCELLATION_INPROGRESS;
        } else if (booking == 19) {
            bVar = b.C0467b.BOOKING_MODIFIED;
        }
        if (booking > 6) {
            FragmentActivity activity = getActivity();
            Set hashSet = new HashSet();
            try {
                com.paytm.b.a.a a2 = i.a(activity.getApplicationContext());
                f fVar = new f();
                String b2 = a2.b("userDropVerticalList", "", true);
                if (!TextUtils.isEmpty(b2)) {
                    hashSet = (Set) fVar.a(b2, new com.google.gson.b.a<Set<Integer>>() {
                    }.getType());
                }
                hashSet.remove(12);
                a2.a("userDropVerticalList", fVar.a((Object) hashSet), true);
            } catch (Exception unused) {
            }
        }
        if (!z2) {
            switch (bVar) {
                case BOOKING_SUCCESSFUL:
                    bVar = b.C0467b.BOOKING_SUCCESSFUL;
                    break;
                case BOOKING_PENDING:
                case BOOKING_PENDING_DELAYED:
                    bVar = b.C0467b.PAYMENT_SUCCESS;
                    break;
                case BOOKING_FAILED:
                    bVar = b.C0467b.BOOKING_FAILED;
                    break;
                case PAYMENT_FAILED:
                    bVar = b.C0467b.PAYMENT_FAILED;
                    break;
                case PAYMENT_PENDING_DELAYED:
                    bVar = b.C0467b.PAYMENT_PENDING;
                    break;
            }
        }
        if (z2) {
            int i2 = AnonymousClass7.f24362a[bVar.ordinal()];
            if (i2 == 1) {
                bVar = b.C0467b.BOOKING_SUCCESSFUL;
            } else if (i2 == 7) {
                bVar = b.C0467b.PAYMENT_SUCCESS;
            }
        }
        l();
        return bVar;
    }

    private void l() {
        ScheduledExecutorService scheduledExecutorService = this.r;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            this.r.shutdownNow();
        }
    }

    public final RecyclerView.v a(ViewGroup viewGroup, b.a aVar) {
        if (!(j() == null || j().getBody() == null || j().getBody().getOrder_id() == null || j().getBody().getOrder_id().isEmpty())) {
            this.u = com.travel.flight.flightorder.h.a.a(j().getBody().getOrder_id(), j());
        }
        switch (aVar) {
            case REFUND_DETAILS:
                return new p((be) be.bind(androidx.databinding.f.a(), LayoutInflater.from(getActivity()).inflate(R.layout.layout_flight_refund, viewGroup, false), R.layout.layout_flight_refund), j());
            case HEADER:
                return new d(c(viewGroup, aVar), j(), this, this.t);
            case MODIFY:
                return new l((bg) b(viewGroup, aVar), j().getBody().getModifiedParentOrder(), this);
            case PASSENGER_DESC_CARD_ONGOING:
                com.travel.flight.flightorder.j.m mVar = new com.travel.flight.flightorder.j.m(c(viewGroup, aVar), j(), this, true);
                this.x = mVar;
                return mVar;
            case PASSENGER_DESC_CARD_RETURN:
                com.travel.flight.flightorder.j.m mVar2 = new com.travel.flight.flightorder.j.m(c(viewGroup, aVar), j(), this, false);
                this.y = mVar2;
                return mVar2;
            case CASHBACK_DETAILS:
                return new com.travel.flight.flightorder.j.i(c(viewGroup, aVar), j(), this.t);
            case TICKET_VARIOUS_OPTIONS:
                com.travel.flight.flightorder.j.g gVar = new com.travel.flight.flightorder.j.g(c(viewGroup, aVar), j(), this, getActivity(), this);
                this.v = gVar;
                return gVar;
            case PAYMENT_DETAILS:
                return new n(getActivity(), c(viewGroup, aVar), j(), this);
            case CANCEL_PROTECT:
                return new com.travel.flight.flightorder.j.b(c(viewGroup, aVar), j(), this);
            case REVIEW_RATING_WIDGET:
                return new com.travel.flight.flightorder.j.c(getActivity(), c(viewGroup, aVar), this, this.u);
            case FLIGHT_ANCILLARY:
                return new com.travel.flight.flightorder.j.a(c(viewGroup, aVar), j());
            case REFUND_SUMMARY:
                return new o(c(viewGroup, aVar), j(), this.s, this.f24370f, this.t);
            case FOOTER:
                return new k(c(viewGroup, aVar), j(), this, this.t, this.f24354a);
            case HOTEL_OPTIONS:
                return new com.travel.flight.flightorder.j.f(b(viewGroup, aVar));
            case FLIGHT_BUNDLE_COUPON:
                return new j((dq) androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.row_flight_order_summary_bundle_coupon, viewGroup, false));
            case THIN_BANNER:
                if (this.p.size() > 0) {
                    return ViewHolderFactory.getViewHolder(viewGroup, ViewHolderFactory.parseViewType(((CJRHomePageLayoutV2) this.p.get(0)).getLayout()), getActivity().getSupportFragmentManager(), new IGAHandlerListener() {
                        public final boolean IsClickEnable() {
                            return true;
                        }

                        public /* synthetic */ void OnItemClick(Item item, int i2, boolean z) {
                            IGAClickListener.CC.$default$OnItemClick(this, item, i2, z);
                        }

                        public /* synthetic */ void fireInfiniteGridProductImpression(CJRGridProduct cJRGridProduct, int i2) {
                            IGAHandlerListener.CC.$default$fireInfiniteGridProductImpression(this, cJRGridProduct, i2);
                        }

                        public final int getClient() {
                            return 1004;
                        }

                        public /* synthetic */ String getClientRequestID() {
                            return IAdListener.CC.$default$getClientRequestID(this);
                        }

                        public final void fireImpression(Item item, int i2) {
                            if (!TextUtils.isEmpty(a.this.k) && !String.valueOf(a.this.k.charAt(a.this.k.length() - 1)).equals("-")) {
                                a aVar = a.this;
                                aVar.k = a.this.k + "-";
                            }
                            int intValue = (item.getGaData() == null || !item.getGaData().containsKey(CLPConstants.WIDGET_BIND_POSITION) || !(item.getGaData().get(CLPConstants.WIDGET_BIND_POSITION) instanceof Number)) ? 0 : ((Integer) item.getGaData().get(CLPConstants.WIDGET_BIND_POSITION)).intValue();
                            String str = (item.getMdisplaymetadata() == null || item.getMdisplaymetadata().getMmetadata() == null) ? "" : "ads";
                            com.travel.flight.b.a();
                            com.travel.flight.c b2 = com.travel.flight.b.b();
                            String id = item.getId();
                            TreeMap<String, String> a2 = b2.a(id, a.this.k + item.getParentType(), item.getGaCategory(), item.getName(), i2, item.getName(), intValue, item.getContainerinstatnceid(), item.getVariantInstanceId(), str);
                            ArrayList arrayList = new ArrayList();
                            if (a2 != null) {
                                arrayList.add(a2);
                            }
                            com.travel.flight.b.a();
                            com.travel.flight.b.b().a((List<TreeMap<String, String>>) arrayList, a.this.getActivity().getApplicationContext());
                        }

                        public final void fireImpression(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
                            System.out.println("impression");
                        }

                        public final void OnItemClick(Item item, int i2) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("event_label", item.getName());
                            hashMap.put("event_label2", item.getId());
                            hashMap.put("event_label3", item.getParentType());
                            hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, Integer.valueOf(item.getPosition()));
                            a.b(GAConstants.ACTION.BANNER_CLICKED, (HashMap<String, Object>) hashMap);
                        }
                    });
                }
                return null;
            case ITEM_VIEW_HTML_BOX:
                return new com.travel.flight.flightticket.j.l(c(viewGroup, aVar), getActivity(), "order_summary");
            default:
                return null;
        }
    }

    public final void a(RecyclerView.v vVar) {
        if (vVar instanceof com.travel.flight.flightorder.f.a) {
            CJROrderSummaryCancellation cJROrderSummaryCancellation = this.s;
            if (cJROrderSummaryCancellation != null) {
                if (vVar instanceof h) {
                    ((h) vVar).f24504a = cJROrderSummaryCancellation;
                } else if (vVar instanceof o) {
                    ((o) vVar).f24567a = cJROrderSummaryCancellation;
                }
            }
            if (vVar instanceof com.travel.flight.flightorder.j.f) {
                com.travel.flight.flightorder.j.f fVar = (com.travel.flight.flightorder.j.f) vVar;
                fVar.f24482b = this.C;
                fVar.f24481a.a(fVar.f24482b);
                fVar.f24481a.a(fVar.f24483c);
                fVar.f24481a.executePendingBindings();
            }
            if (vVar instanceof j) {
                j jVar = (j) vVar;
                BundleCard bundle_card = j().getBody().getBundle_card();
                kotlin.g.b.k.c(bundle_card, "data");
                jVar.f24524a.a(bundle_card);
                jVar.f24524a.a(j.f24523c);
                jVar.f24525b = jVar.f24524a.f23954a;
                LinearLayout linearLayout = jVar.f24525b;
                if (linearLayout != null) {
                    String background_image_url = bundle_card.getBackground_image_url();
                    kotlin.g.b.k.a((Object) background_image_url, "data.background_image_url");
                    j.a(linearLayout, background_image_url);
                    jVar.f24524a.executePendingBindings();
                } else {
                    throw new u("null cannot be cast to non-null type android.view.View");
                }
            }
            if (vVar instanceof com.travel.flight.flightticket.j.l) {
                ((com.travel.flight.flightticket.j.l) vVar).a(j().getBody().getInfo_box_html());
            }
            ((com.travel.flight.flightorder.f.a) vVar).a(this.m);
        } else if (vVar instanceof CLPBaseViewHolder) {
            ((CLPBaseViewHolder) vVar).bind(new f().a(this.p.get(0)), (CLPBaseViewHolder.IParentListProvider) null);
        }
    }

    private static ViewDataBinding b(ViewGroup viewGroup, b.a aVar) {
        int i2 = AnonymousClass7.f24363b[aVar.ordinal()];
        if (i2 == 3) {
            return androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.layout_modified_order_summary_item, viewGroup, false);
        }
        if (i2 != 14) {
            return null;
        }
        return androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.pre_f_layout_order_summary_hotel_options, viewGroup, false);
    }

    private static View c(ViewGroup viewGroup, b.a aVar) {
        int i2;
        int i3 = AnonymousClass7.f24363b[aVar.ordinal()];
        if (i3 != 17) {
            switch (i3) {
                case 2:
                    i2 = R.layout.pre_f_order_summary_flight_header_card;
                    break;
                case 3:
                    i2 = R.layout.layout_modified_order_summary_item;
                    break;
                case 4:
                case 5:
                    i2 = R.layout.pre_f_order_summary_passenger_desc_card_revamp;
                    break;
                case 6:
                    i2 = R.layout.pre_f_flight_new_cashback_card;
                    break;
                case 7:
                    i2 = R.layout.pre_f_flight_download_ticket_layout_revamp;
                    break;
                case 8:
                    i2 = R.layout.pre_f_flight_summary_payment_card_revamp;
                    break;
                case 9:
                    i2 = R.layout.pre_f_flight_cancel_protect_layout;
                    break;
                case 10:
                    i2 = R.layout.pre_f_flight_ticket_booking_recommendation_lyt;
                    break;
                case 11:
                    i2 = R.layout.pre_f_flight_order_ancillary_lyt_revamp;
                    break;
                case 12:
                    i2 = R.layout.pre_f_flight_refund_summary_card_revamp;
                    break;
                case 13:
                    i2 = R.layout.pre_f_order_summary_payment_footer;
                    break;
                default:
                    i2 = -1;
                    break;
            }
        } else {
            i2 = R.layout.pre_f_item_html_box;
        }
        if (i2 != -1) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
        }
        return null;
    }

    public final ScheduledExecutorService a() {
        l();
        this.r = Executors.newSingleThreadScheduledExecutor();
        return this.r;
    }

    public final Context b() {
        return getActivity();
    }

    public final void a(String str, boolean z2) {
        if (z2) {
            this.z = str;
        } else {
            this.A = str;
        }
        com.travel.flight.flightorder.h.a aVar = this.q;
        com.travel.flight.b.a();
        String o = com.travel.flight.b.b().o();
        HashMap hashMap = new HashMap();
        hashMap.put("dest_codes", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(aVar.f24415a));
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = aVar.f24415a;
        bVar.n = a.b.SILENT;
        bVar.o = aVar.f24415a.getClass().getSimpleName();
        bVar.f42878b = a.c.FLIGHT;
        bVar.f42879c = a.C0715a.GET;
        bVar.f42880d = o;
        bVar.f42881e = null;
        bVar.f42882f = hashMap2;
        bVar.f42883g = hashMap;
        bVar.f42884h = null;
        bVar.f42885i = new CJRFlightImageData();
        bVar.j = aVar;
        bVar.t = null;
        bVar.l = false;
        bVar.l().a();
    }

    public final void a(CJRHotelOptions cJRHotelOptions) {
        e eVar = this.B;
        if (eVar != null && cJRHotelOptions != null && eVar.f25423a > 0) {
            this.C = cJRHotelOptions;
            i();
        }
    }

    public final void a(JSONObject jSONObject) {
        String str;
        com.travel.flight.flightorder.f.a aVar;
        com.travel.flight.flightorder.f.a aVar2;
        if (jSONObject != null) {
            String str2 = null;
            try {
                str = jSONObject.getString(this.z);
            } catch (Exception unused) {
                str = null;
            }
            if (str == null) {
                try {
                    str2 = jSONObject.getString(this.A);
                } catch (Exception unused2) {
                }
            }
            if (!TextUtils.isEmpty(str) && (aVar2 = this.x) != null) {
                ((com.travel.flight.flightorder.j.m) aVar2).a(str);
            } else if (!TextUtils.isEmpty(str2) && (aVar = this.y) != null) {
                ((com.travel.flight.flightorder.j.m) aVar).a(str2);
            }
        }
    }

    public final void a(CJROrderSummaryCancellation cJROrderSummaryCancellation) {
        this.s = cJROrderSummaryCancellation;
        i();
    }

    /* access modifiers changed from: protected */
    public final NestedScrollView.b c() {
        return new NestedScrollView.b() {
            public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                int unused = a.this.H = nestedScrollView.computeVerticalScrollOffset();
                if (a.this.H > a.this.G && a.this.F != null && a.this.F.getView().getVisibility() == 0) {
                    a.this.F.getView().setVisibility(8);
                } else if (a.this.H < a.this.G && a.this.F != null && a.this.F.getView().getVisibility() == 8) {
                    a.this.F.getView().setVisibility(0);
                }
            }
        };
    }

    /* renamed from: com.travel.flight.flightorder.d.a$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f24364c = new int[com.travel.flight.flightorder.c.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|25|26|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|(3:69|70|72)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|25|26|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|72) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|25|26|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|72) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|21|22|23|25|26|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|72) */
        /* JADX WARNING: Can't wrap try/catch for region: R(61:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|21|22|23|25|26|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|72) */
        /* JADX WARNING: Can't wrap try/catch for region: R(63:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|72) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00b9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00c5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00d1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00dd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x0112 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x011c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0126 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0130 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x013a */
        static {
            /*
                com.travel.flight.flightorder.c.a[] r0 = com.travel.flight.flightorder.c.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24364c = r0
                r0 = 1
                int[] r1 = f24364c     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.flight.flightorder.c.a r2 = com.travel.flight.flightorder.c.a.DOWNLOAD_TICKET_CLICK     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f24364c     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.flight.flightorder.c.a r3 = com.travel.flight.flightorder.c.a.SUMMARY_REVIEW_AND_RATINGS     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f24364c     // Catch:{ NoSuchFieldError -> 0x002a }
                com.travel.flight.flightorder.c.a r4 = com.travel.flight.flightorder.c.a.MODIFY_TICKET_CLICK     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.travel.flight.flightorder.d.b$a[] r3 = com.travel.flight.flightorder.d.b.a.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f24363b = r3
                int[] r3 = f24363b     // Catch:{ NoSuchFieldError -> 0x003d }
                com.travel.flight.flightorder.d.b$a r4 = com.travel.flight.flightorder.d.b.a.REFUND_DETAILS     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r3 = f24363b     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.travel.flight.flightorder.d.b$a r4 = com.travel.flight.flightorder.d.b.a.HEADER     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r3 = f24363b     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.travel.flight.flightorder.d.b$a r4 = com.travel.flight.flightorder.d.b.a.MODIFY     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                r3 = 4
                int[] r4 = f24363b     // Catch:{ NoSuchFieldError -> 0x005c }
                com.travel.flight.flightorder.d.b$a r5 = com.travel.flight.flightorder.d.b.a.PASSENGER_DESC_CARD_ONGOING     // Catch:{ NoSuchFieldError -> 0x005c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                r4 = 5
                int[] r5 = f24363b     // Catch:{ NoSuchFieldError -> 0x0067 }
                com.travel.flight.flightorder.d.b$a r6 = com.travel.flight.flightorder.d.b.a.PASSENGER_DESC_CARD_RETURN     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                r5 = 6
                int[] r6 = f24363b     // Catch:{ NoSuchFieldError -> 0x0072 }
                com.travel.flight.flightorder.d.b$a r7 = com.travel.flight.flightorder.d.b.a.CASHBACK_DETAILS     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                r6 = 7
                int[] r7 = f24363b     // Catch:{ NoSuchFieldError -> 0x007d }
                com.travel.flight.flightorder.d.b$a r8 = com.travel.flight.flightorder.d.b.a.TICKET_VARIOUS_OPTIONS     // Catch:{ NoSuchFieldError -> 0x007d }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r7 = f24363b     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.travel.flight.flightorder.d.b$a r8 = com.travel.flight.flightorder.d.b.a.PAYMENT_DETAILS     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r9 = 8
                r7[r8] = r9     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                int[] r7 = f24363b     // Catch:{ NoSuchFieldError -> 0x0095 }
                com.travel.flight.flightorder.d.b$a r8 = com.travel.flight.flightorder.d.b.a.CANCEL_PROTECT     // Catch:{ NoSuchFieldError -> 0x0095 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0095 }
                r9 = 9
                r7[r8] = r9     // Catch:{ NoSuchFieldError -> 0x0095 }
            L_0x0095:
                int[] r7 = f24363b     // Catch:{ NoSuchFieldError -> 0x00a1 }
                com.travel.flight.flightorder.d.b$a r8 = com.travel.flight.flightorder.d.b.a.REVIEW_RATING_WIDGET     // Catch:{ NoSuchFieldError -> 0x00a1 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r9 = 10
                r7[r8] = r9     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                int[] r7 = f24363b     // Catch:{ NoSuchFieldError -> 0x00ad }
                com.travel.flight.flightorder.d.b$a r8 = com.travel.flight.flightorder.d.b.a.FLIGHT_ANCILLARY     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r9 = 11
                r7[r8] = r9     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r7 = f24363b     // Catch:{ NoSuchFieldError -> 0x00b9 }
                com.travel.flight.flightorder.d.b$a r8 = com.travel.flight.flightorder.d.b.a.REFUND_SUMMARY     // Catch:{ NoSuchFieldError -> 0x00b9 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b9 }
                r9 = 12
                r7[r8] = r9     // Catch:{ NoSuchFieldError -> 0x00b9 }
            L_0x00b9:
                int[] r7 = f24363b     // Catch:{ NoSuchFieldError -> 0x00c5 }
                com.travel.flight.flightorder.d.b$a r8 = com.travel.flight.flightorder.d.b.a.FOOTER     // Catch:{ NoSuchFieldError -> 0x00c5 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c5 }
                r9 = 13
                r7[r8] = r9     // Catch:{ NoSuchFieldError -> 0x00c5 }
            L_0x00c5:
                int[] r7 = f24363b     // Catch:{ NoSuchFieldError -> 0x00d1 }
                com.travel.flight.flightorder.d.b$a r8 = com.travel.flight.flightorder.d.b.a.HOTEL_OPTIONS     // Catch:{ NoSuchFieldError -> 0x00d1 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d1 }
                r9 = 14
                r7[r8] = r9     // Catch:{ NoSuchFieldError -> 0x00d1 }
            L_0x00d1:
                int[] r7 = f24363b     // Catch:{ NoSuchFieldError -> 0x00dd }
                com.travel.flight.flightorder.d.b$a r8 = com.travel.flight.flightorder.d.b.a.FLIGHT_BUNDLE_COUPON     // Catch:{ NoSuchFieldError -> 0x00dd }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dd }
                r9 = 15
                r7[r8] = r9     // Catch:{ NoSuchFieldError -> 0x00dd }
            L_0x00dd:
                int[] r7 = f24363b     // Catch:{ NoSuchFieldError -> 0x00e9 }
                com.travel.flight.flightorder.d.b$a r8 = com.travel.flight.flightorder.d.b.a.THIN_BANNER     // Catch:{ NoSuchFieldError -> 0x00e9 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e9 }
                r9 = 16
                r7[r8] = r9     // Catch:{ NoSuchFieldError -> 0x00e9 }
            L_0x00e9:
                int[] r7 = f24363b     // Catch:{ NoSuchFieldError -> 0x00f5 }
                com.travel.flight.flightorder.d.b$a r8 = com.travel.flight.flightorder.d.b.a.ITEM_VIEW_HTML_BOX     // Catch:{ NoSuchFieldError -> 0x00f5 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f5 }
                r9 = 17
                r7[r8] = r9     // Catch:{ NoSuchFieldError -> 0x00f5 }
            L_0x00f5:
                com.travel.flight.flightorder.d.b$b[] r7 = com.travel.flight.flightorder.d.b.C0467b.values()
                int r7 = r7.length
                int[] r7 = new int[r7]
                f24362a = r7
                int[] r7 = f24362a     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.travel.flight.flightorder.d.b$b r8 = com.travel.flight.flightorder.d.b.C0467b.BOOKING_SUCCESSFUL     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r7[r8] = r0     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r0 = f24362a     // Catch:{ NoSuchFieldError -> 0x0112 }
                com.travel.flight.flightorder.d.b$b r7 = com.travel.flight.flightorder.d.b.C0467b.BOOKING_PENDING     // Catch:{ NoSuchFieldError -> 0x0112 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0112 }
                r0[r7] = r1     // Catch:{ NoSuchFieldError -> 0x0112 }
            L_0x0112:
                int[] r0 = f24362a     // Catch:{ NoSuchFieldError -> 0x011c }
                com.travel.flight.flightorder.d.b$b r1 = com.travel.flight.flightorder.d.b.C0467b.BOOKING_PENDING_DELAYED     // Catch:{ NoSuchFieldError -> 0x011c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x011c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x011c }
            L_0x011c:
                int[] r0 = f24362a     // Catch:{ NoSuchFieldError -> 0x0126 }
                com.travel.flight.flightorder.d.b$b r1 = com.travel.flight.flightorder.d.b.C0467b.BOOKING_FAILED     // Catch:{ NoSuchFieldError -> 0x0126 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0126 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0126 }
            L_0x0126:
                int[] r0 = f24362a     // Catch:{ NoSuchFieldError -> 0x0130 }
                com.travel.flight.flightorder.d.b$b r1 = com.travel.flight.flightorder.d.b.C0467b.PAYMENT_FAILED     // Catch:{ NoSuchFieldError -> 0x0130 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0130 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0130 }
            L_0x0130:
                int[] r0 = f24362a     // Catch:{ NoSuchFieldError -> 0x013a }
                com.travel.flight.flightorder.d.b$b r1 = com.travel.flight.flightorder.d.b.C0467b.PAYMENT_PENDING_DELAYED     // Catch:{ NoSuchFieldError -> 0x013a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x013a }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x013a }
            L_0x013a:
                int[] r0 = f24362a     // Catch:{ NoSuchFieldError -> 0x0144 }
                com.travel.flight.flightorder.d.b$b r1 = com.travel.flight.flightorder.d.b.C0467b.PAYMENT_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0144 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0144 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x0144 }
            L_0x0144:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightorder.d.a.AnonymousClass7.<clinit>():void");
        }
    }

    public final void a(com.travel.flight.flightorder.c.a aVar, IJRDataModel iJRDataModel) {
        int i2 = AnonymousClass7.f24364c[aVar.ordinal()];
        if (i2 == 1) {
            com.travel.flight.flightorder.e.a aVar2 = this.j;
            CJROrderSummaryAction cJROrderSummaryAction = (CJROrderSummaryAction) iJRDataModel;
            if (cJROrderSummaryAction != null) {
                aVar2.f24389e = 1;
                aVar2.f24390f = cJROrderSummaryAction;
                aVar2.a(cJROrderSummaryAction);
            }
        } else if (i2 == 2) {
            CJRNPSCaptureDataModel cJRNPSCaptureDataModel = (CJRNPSCaptureDataModel) iJRDataModel;
            CJRNPSCaptureDataModel cJRNPSCaptureDataModel2 = this.u;
            if (j() != null && cJRNPSCaptureDataModel2.getItemIds() != null && cJRNPSCaptureDataModel != null && com.paytm.utility.b.c((Context) getActivity())) {
                a((Context) getActivity(), getResources().getString(R.string.pre_f_please_wait_progress_msg));
                FragmentActivity activity = getActivity();
                int response = cJRNPSCaptureDataModel.getResponse();
                String order_id = j().getBody().getOrder_id();
                ArrayList<String> itemIds = cJRNPSCaptureDataModel2.getItemIds();
                com.travel.flight.b.a();
                String n = com.travel.flight.b.b().n();
                if (URLUtil.isValidUrl(n)) {
                    String b2 = com.paytm.utility.b.b((Context) activity, n);
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(Payload.RESPONSE, response);
                        if (!TextUtils.isEmpty(order_id)) {
                            jSONObject.put("orderid", order_id);
                        }
                        jSONObject.put("category", "npsFeedback-flight");
                        jSONObject.put("items", new JSONArray(itemIds));
                        jSONObject.put("utm_source", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                    } catch (JSONException unused) {
                    }
                    if (com.paytm.utility.b.c((Context) activity)) {
                        com.paytm.network.b bVar = new com.paytm.network.b();
                        bVar.f42877a = activity;
                        bVar.f42878b = a.c.FLIGHT;
                        bVar.f42879c = a.C0715a.POST;
                        bVar.n = a.b.SILENT;
                        bVar.o = activity.getClass().getSimpleName();
                        bVar.f42880d = b2;
                        bVar.f42881e = null;
                        bVar.f42882f = hashMap;
                        bVar.f42883g = null;
                        bVar.f42884h = jSONObject.toString();
                        bVar.f42885i = new CJRNpsTrackingResponse();
                        bVar.j = this;
                        bVar.t = null;
                        com.paytm.network.a l = bVar.l();
                        l.f42860d = true;
                        l.a();
                    }
                }
            }
        } else if (i2 != 3) {
            final CJROrderSummaryAction cJROrderSummaryAction2 = (CJROrderSummaryAction) iJRDataModel;
            if (!TextUtils.isEmpty(cJROrderSummaryAction2.getConfirmation())) {
                try {
                    String confirmation = cJROrderSummaryAction2.getConfirmation();
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(confirmation);
                    builder.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            dialogInterface.dismiss();
                            a.this.a(cJROrderSummaryAction2);
                        }
                    });
                    builder.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.setCancelable(false);
                    builder.show();
                } catch (Exception unused2) {
                }
            } else {
                a(cJROrderSummaryAction2);
            }
            a((Context) getActivity(), getResources().getString(R.string.pre_f_please_wait_progress_msg));
        } else {
            CJROrderSummaryAction cJROrderSummaryAction3 = (CJROrderSummaryAction) iJRDataModel;
            Intent intent = new Intent();
            try {
                intent.putExtra("requestId", com.travel.flight.c.d.a.a(new URL(cJROrderSummaryAction3.getUrlParams().getUrl())).get("request_id"));
                intent.putExtra("orderId", j().getBody().getOrder_id());
            } catch (UnsupportedEncodingException | MalformedURLException unused3) {
            }
            intent.setClass(getContext(), AJRFlightModifyTicket.class);
            startActivity(intent);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            this.f24371g = false;
            if (this.l != null) {
                this.l.sendEmptyMessage(1);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(CJROrderSummaryAction cJROrderSummaryAction) {
        try {
            boolean b2 = b(cJROrderSummaryAction);
            if (cJROrderSummaryAction.getUrlParams() == null || cJROrderSummaryAction.getUrlParams().getMethod() == null || !cJROrderSummaryAction.getUrlParams().getMethod().equalsIgnoreCase("POST")) {
                this.j.a(cJROrderSummaryAction.getLabel());
                a(cJROrderSummaryAction.getLabel(), cJROrderSummaryAction.getUrlParams().getUrl(), b2);
                return;
            }
            String str = null;
            if (cJROrderSummaryAction.getUrlParams().getBody() != null) {
                str = cJROrderSummaryAction.getUrlParams().getBody().toString();
            }
            this.j.a(cJROrderSummaryAction.getLabel());
            a(cJROrderSummaryAction.getLabel(), cJROrderSummaryAction.getUrlParams().getUrl(), str, b2);
        } catch (Exception unused) {
        }
    }

    private void a(String str, String str2, String str3, boolean z2) {
        String str4;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("invoice") || str.equalsIgnoreCase("share ticket")) {
            str4 = b(str2);
        } else {
            com.travel.flight.b.a();
            hashMap.put("sso_token=", com.travel.flight.b.b().a((Context) getActivity()));
            str4 = com.paytm.utility.b.s(getActivity(), str2);
        }
        String replace = str4.replace(" ", "%20");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("ssotoken", com.travel.flight.flightorder.i.a.a((Context) getActivity()));
        if (z2) {
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = getActivity();
            bVar.f42878b = a.c.FLIGHT;
            bVar.f42879c = a.C0715a.POST;
            bVar.n = a.b.SILENT;
            bVar.o = getActivity().getClass().getSimpleName();
            bVar.f42880d = replace;
            bVar.f42881e = null;
            bVar.f42882f = hashMap2;
            bVar.f42883g = null;
            bVar.f42884h = str3;
            bVar.f42885i = new CJRReplacementResponse();
            bVar.j = this;
            bVar.t = null;
            com.paytm.network.a l = bVar.l();
            l.f42860d = true;
            l.a();
            return;
        }
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = getActivity();
        bVar2.f42878b = a.c.FLIGHT;
        bVar2.f42879c = a.C0715a.POST;
        bVar2.n = a.b.SILENT;
        bVar2.o = getActivity().getClass().getSimpleName();
        bVar2.f42880d = replace;
        bVar2.f42881e = null;
        bVar2.f42882f = hashMap2;
        bVar2.f42883g = null;
        bVar2.f42884h = str3;
        bVar2.f42885i = new CJRActionResponse();
        bVar2.j = this;
        bVar2.t = null;
        com.paytm.network.a l2 = bVar2.l();
        l2.f42860d = true;
        l2.a();
    }

    private void a(String str, String str2, boolean z2) {
        String str3;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("invoice") || str.equalsIgnoreCase("share ticket")) {
            str3 = b(str2);
        } else {
            com.travel.flight.b.a();
            hashMap.put("sso_token=", com.travel.flight.b.b().a((Context) getActivity()));
            str3 = com.paytm.utility.b.s(getActivity(), str2);
        }
        String replace = str3.replace(" ", "%20");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("ssotoken", com.travel.flight.flightorder.i.a.a((Context) getActivity()));
        if (z2) {
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = getActivity();
            bVar.f42878b = a.c.FLIGHT;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = replace;
            bVar.f42881e = null;
            bVar.f42882f = hashMap2;
            bVar.f42883g = null;
            bVar.f42884h = null;
            bVar.f42885i = new CJRReplacementResponse();
            bVar.j = this;
            bVar.t = null;
            com.paytm.network.a l = bVar.l();
            l.f42860d = true;
            l.a();
            return;
        }
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = getActivity();
        bVar2.f42878b = a.c.FLIGHT;
        bVar2.f42879c = a.C0715a.GET;
        bVar2.n = a.b.SILENT;
        bVar2.o = getActivity().getClass().getSimpleName();
        bVar2.f42880d = replace;
        bVar2.f42881e = null;
        bVar2.f42882f = hashMap2;
        bVar2.f42883g = null;
        bVar2.f42884h = null;
        bVar2.f42885i = new CJRActionResponse();
        bVar2.j = this;
        bVar2.t = null;
        com.paytm.network.a l2 = bVar2.l();
        l2.f42860d = true;
        l2.a();
    }

    private static boolean b(CJROrderSummaryAction cJROrderSummaryAction) {
        return (cJROrderSummaryAction == null || cJROrderSummaryAction.getName() == null || !cJROrderSummaryAction.getName().equalsIgnoreCase("Replace_Item")) ? false : true;
    }

    private String b(String str) {
        String str2;
        Uri parse = Uri.parse(str);
        if (parse == null) {
            str2 = str + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN;
        } else if (parse.getQuery() != null) {
            str2 = str + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN;
        } else {
            str2 = str + "?";
        }
        return str2 + "sso_token=" + i.a(getActivity().getApplicationContext()).b("sso_token=", "", true);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        com.travel.flight.flightorder.j.g gVar = this.v;
        if (gVar != null && strArr != null && iArr != null && strArr.length > 0 && strArr[0].equalsIgnoreCase("android.permission.WRITE_EXTERNAL_STORAGE") && iArr.length > 0 && iArr[0] == 0 && gVar.f24487a != null) {
            gVar.f24487a.a(com.travel.flight.flightorder.c.a.DOWNLOAD_TICKET_CLICK, gVar.f24491e);
        }
    }

    private boolean m() {
        b.C0467b bVar;
        try {
            if (getActivity() == null) {
                return false;
            }
            com.travel.flight.b.a();
            if (!com.travel.flight.b.b().b((Context) getActivity()) || !this.w) {
                return false;
            }
            b.C0467b bVar2 = b.C0467b.NO_OP;
            if (Integer.parseInt(j().getBody().getAll_states().getPymnt_summary()) > 3) {
                bVar = b.C0467b.PAYMENT_SUCCESS;
            } else {
                bVar = b.C0467b.PAYMENT_FAILED;
            }
            if (bVar == b.C0467b.PAYMENT_SUCCESS) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void d() {
        Iterator<CJROrderSummaryItems> it2 = j().getBody().getItems().iterator();
        while (it2.hasNext()) {
            CJROrderSummaryItems next = it2.next();
            if (next.getAction() != null) {
                Iterator<CJROrderSummaryAction> it3 = next.getAction().iterator();
                while (it3.hasNext()) {
                    CJROrderSummaryAction next2 = it3.next();
                    if (next2.getLabel().equals("Share Ticket")) {
                        a(com.travel.flight.flightorder.c.a.DOWNLOAD_TICKET_CLICK, (IJRDataModel) next2);
                    }
                }
            }
        }
    }

    public final void e() {
        if (getActivity() != null) {
            ((FlightOrderSummary) getActivity()).shouldDisplayShareButton(true);
        }
    }

    public final void a(String str) {
        if (getActivity() != null) {
            ((FlightOrderSummary) getActivity()).showParentFlightOrderSummary(str);
        }
    }

    public final void f() {
        super.f();
    }

    public final void g() {
        super.g();
    }

    public final void h() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_label", this.f24370f);
        b("cancellation_request_submitted", (HashMap<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    public static void b(String str, HashMap<String, Object> hashMap) {
        com.travel.flight.b.a();
        com.travel.flight.b.b().a(GAUtil.CUSTOM_EVENT, "/flights/order-summary", "flights_summary", str, hashMap);
    }
}
