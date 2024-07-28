package com.travel.bus.orders.i;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gsonhtcfix.f;
import com.paytm.utility.q;
import com.travel.bus.R;
import com.travel.bus.busticket.a.aa;
import com.travel.bus.busticket.a.h;
import com.travel.bus.busticket.activity.AJRBusWebViewActivity;
import com.travel.bus.common.AJREmbedWebView;
import com.travel.bus.orders.activity.BusOrderSummary;
import com.travel.bus.orders.c.c;
import com.travel.bus.orders.e.a;
import com.travel.bus.orders.h.b;
import com.travel.bus.pojo.busticket.CJRBusCancellationPolicy;
import com.travel.bus.pojo.busticket.CJRBusOrderSummary;
import com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse;
import com.travel.bus.pojo.busticket.CJRBusRefundDetails;
import com.travel.bus.pojo.busticket.CJRBusSearchCancellationPolicy;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.common.entity.busticket.CJRBusOrderedCart;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class i extends a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public CJRBusRefundDetails f22714a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f22715b;

    /* renamed from: c  reason: collision with root package name */
    private CJRBusOrderSummary f22716c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f22717d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22718e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f22719f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f22720g;

    /* renamed from: h  reason: collision with root package name */
    private View f22721h;

    /* renamed from: i  reason: collision with root package name */
    private BusOrderSummary.a f22722i;
    /* access modifiers changed from: private */
    public String j;
    private com.travel.bus.orders.f.a k;
    private TextView l;
    private String m;

    public i(View view, CJRBusOrderSummary cJRBusOrderSummary, Context context, CJRBusRefundDetails cJRBusRefundDetails, BusOrderSummary.a aVar, com.travel.bus.orders.f.a aVar2, boolean z) {
        super(view);
        this.f22715b = context;
        this.f22716c = cJRBusOrderSummary;
        this.f22714a = cJRBusRefundDetails;
        this.f22722i = aVar;
        this.k = aVar2;
        this.f22717d = (TextView) view.findViewById(R.id.passenger_title);
        this.f22718e = (TextView) view.findViewById(R.id.passenger_seats);
        this.f22719f = (LinearLayout) view.findViewById(R.id.lyt_traveller_list);
        this.f22720g = (LinearLayout) view.findViewById(R.id.lyt_passenger_info_list);
        this.f22721h = view.findViewById(R.id.passenger_list_devider);
        this.l = (TextView) view.findViewById(R.id.cancellation_policy_action_text);
        this.l.setOnClickListener(this);
        if (z) {
            this.l.setVisibility(0);
        }
    }

    public final void a(c.b bVar) {
        CJRBusOrderSummaryMetaDataResponse cJRBusOrderSummaryMetaDataResponse;
        Iterator<CJRBusOrderedCart> it2;
        c.b bVar2;
        String str;
        boolean z;
        TextView textView;
        ImageView imageView;
        View view;
        c.b bVar3 = bVar;
        if (this.f22716c != null) {
            try {
                this.f22719f.removeAllViews();
                this.f22720g.removeAllViews();
                Iterator<CJRBusOrderedCart> it3 = this.f22716c.getOrderedCartList().iterator();
                ViewGroup viewGroup = null;
                boolean z2 = false;
                CJRBusOrderSummaryMetaDataResponse cJRBusOrderSummaryMetaDataResponse2 = null;
                boolean z3 = false;
                int i2 = 0;
                while (it3.hasNext()) {
                    CJRBusOrderedCart next = it3.next();
                    if (b.b(next)) {
                        if (next != null) {
                            Object metaDataResponse = next.getMetaDataResponse();
                            f fVar = new f();
                            cJRBusOrderSummaryMetaDataResponse2 = (CJRBusOrderSummaryMetaDataResponse) fVar.a(fVar.a(metaDataResponse), CJRBusOrderSummaryMetaDataResponse.class);
                        }
                        String str2 = "";
                        String cat_card_number = cJRBusOrderSummaryMetaDataResponse2.getCat_card_number() != null ? cJRBusOrderSummaryMetaDataResponse2.getCat_card_number() : str2;
                        String str3 = "female";
                        if (next.getFullFillmentOject().getFullFillment() != null) {
                            this.f22719f.setVisibility(z2 ? 1 : 0);
                            String passengerName = cJRBusOrderSummaryMetaDataResponse2.getPassengerName() != null ? cJRBusOrderSummaryMetaDataResponse2.getPassengerName() : str2;
                            String passengerGender = cJRBusOrderSummaryMetaDataResponse2.getPassengerGender() != null ? cJRBusOrderSummaryMetaDataResponse2.getPassengerGender() : str2;
                            String seatNumber = cJRBusOrderSummaryMetaDataResponse2.getSeatNumber() != null ? cJRBusOrderSummaryMetaDataResponse2.getSeatNumber() : str2;
                            View inflate = LayoutInflater.from(this.f22715b).inflate(R.layout.pre_b_bus_order_passenger_list_item, viewGroup, z2);
                            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.order_state_image_view);
                            TextView textView2 = (TextView) inflate.findViewById(R.id.passenger_name);
                            ImageView imageView3 = (ImageView) inflate.findViewById(R.id.passenger_icon);
                            it2 = it3;
                            TextView textView3 = (TextView) inflate.findViewById(R.id.passenger_seat_text);
                            boolean z4 = z3;
                            TextView textView4 = (TextView) inflate.findViewById(R.id.passenger_cat_card_number);
                            cJRBusOrderSummaryMetaDataResponse = cJRBusOrderSummaryMetaDataResponse2;
                            ImageView imageView4 = (ImageView) inflate.findViewById(R.id.passenger_seat_icon);
                            int i3 = i2;
                            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.pax_seat_lyt);
                            String str4 = "order_summary_seat_loader.png";
                            TextView textView5 = (TextView) inflate.findViewById(R.id.refund_status_text);
                            if (!cat_card_number.isEmpty()) {
                                view = inflate;
                                textView4.setVisibility(0);
                                imageView = imageView2;
                                textView = textView5;
                                textView4.setText(this.f22715b.getString(R.string.bus_card_number_bus_order, new Object[]{cat_card_number}));
                            } else {
                                textView = textView5;
                                view = inflate;
                                imageView = imageView2;
                                textView4.setVisibility(8);
                            }
                            int i4 = R.drawable.travel_res_bus_order_summary_male_pax_icon;
                            int i5 = R.drawable.bus_passenger_seat_green;
                            if (!TextUtils.isEmpty(passengerGender) && passengerGender.equalsIgnoreCase(str3)) {
                                i4 = R.drawable.travel_res_bus_order_summary_female_pax_icon;
                                i5 = R.drawable.bus_passenger_seat_ladies;
                            }
                            textView2.setText(passengerName);
                            textView3.setText(seatNumber);
                            if (textView2.getText() != str2) {
                                z4 = true;
                            }
                            imageView4.setImageDrawable(androidx.core.content.b.a(this.f22719f.getContext(), i5));
                            imageView3.setImageDrawable(androidx.core.content.b.a(this.f22719f.getContext(), i4));
                            int parseInt = Integer.parseInt(next.getItemStatus());
                            String statusText = next.getStatusText();
                            if (parseInt == 17) {
                                frameLayout.setVisibility(8);
                                TextView textView6 = textView;
                                textView6.setVisibility(0);
                                this.f22718e.setVisibility(8);
                                textView6.setBackground(androidx.core.content.b.a(this.f22715b, R.drawable.travel_res_bus_failed_order_summary_badge_border));
                                textView6.setTextColor(androidx.core.content.b.c(this.f22715b, R.color.bus_refund_pending_color));
                                textView6.setText(this.f22715b.getString(R.string.bus_refund_pending));
                            } else {
                                TextView textView7 = textView;
                                int i6 = 18;
                                if (parseInt == 18) {
                                    if (!statusText.equalsIgnoreCase("Processing Refund")) {
                                        frameLayout.setVisibility(8);
                                        textView7.setVisibility(0);
                                        this.f22718e.setVisibility(8);
                                        textView7.setBackground(androidx.core.content.b.a(this.f22715b, R.drawable.travel_res_bus_success_order_summary_badge_border));
                                        textView7.setTextColor(androidx.core.content.b.c(this.f22715b, R.color.bus_refund_success_color));
                                        textView7.setText(this.f22715b.getString(R.string.bus_refund));
                                    } else {
                                        i6 = 18;
                                    }
                                }
                                if (parseInt != i6 || !statusText.equalsIgnoreCase("Processing Refund")) {
                                    frameLayout.setVisibility(0);
                                    textView7.setVisibility(8);
                                    this.f22718e.setVisibility(0);
                                    bVar2 = bVar;
                                    if (bVar2 == c.b.PAYMENT_FAILED) {
                                        textView3.setVisibility(8);
                                        imageView4.setImageResource(R.drawable.bus_booked_port);
                                    } else if (!(bVar2 == c.b.PAYMENT_SUCCESS || bVar2 == c.b.BOOKING_SUCCESSFUL)) {
                                        str = str4;
                                        ImageView imageView5 = imageView;
                                        ResourceUtils.loadBusImagesFromCDN(imageView5, str, false, false, n.a.V1);
                                        imageView5.setVisibility(0);
                                        frameLayout.setVisibility(8);
                                        if (!(this.k == null || this.k.b() == null)) {
                                            this.k.b().scheduleAtFixedRate(new Runnable(imageView5) {
                                                private final /* synthetic */ ImageView f$0;

                                                {
                                                    this.f$0 = r1;
                                                }

                                                public final void run() {
                                                    new Handler(Looper.getMainLooper()).post(new Runnable(this.f$0) {
                                                        private final /* synthetic */ ImageView f$0;

                                                        {
                                                            this.f$0 = r1;
                                                        }

                                                        public final void run() {
                                                            i.b(this.f$0);
                                                        }
                                                    });
                                                }
                                            }, 100, 100, TimeUnit.MILLISECONDS);
                                        }
                                        i2 = i3 + 1;
                                        this.f22719f.addView(view);
                                        z3 = z4;
                                    }
                                    str = str4;
                                    i2 = i3 + 1;
                                    this.f22719f.addView(view);
                                    z3 = z4;
                                } else {
                                    frameLayout.setVisibility(8);
                                    textView7.setVisibility(0);
                                    this.f22718e.setVisibility(8);
                                    textView7.setBackground(androidx.core.content.b.a(this.f22715b, R.drawable.travel_res_bus_failed_order_summary_badge_border));
                                    textView7.setTextColor(androidx.core.content.b.c(this.f22715b, R.color.bus_refund_pending_color));
                                    textView7.setText(this.f22715b.getString(R.string.bus_refund_pending));
                                }
                            }
                            bVar2 = bVar;
                            str = str4;
                            i2 = i3 + 1;
                            this.f22719f.addView(view);
                            z3 = z4;
                        } else {
                            bVar2 = bVar3;
                            it2 = it3;
                            cJRBusOrderSummaryMetaDataResponse = cJRBusOrderSummaryMetaDataResponse2;
                            boolean z5 = z3;
                            int i7 = i2;
                            str = "order_summary_seat_loader.png";
                        }
                        if (!z3) {
                            this.f22719f.setVisibility(0);
                            Iterator it4 = ((List) ((Map) next.getMetaDataResponse()).get("passengers")).iterator();
                            while (it4.hasNext()) {
                                Map map = (Map) it4.next();
                                String str5 = ((String) map.get("title")) + " " + ((String) map.get("name"));
                                String str6 = (String) map.get("gender");
                                String seatNumber2 = cJRBusOrderSummaryMetaDataResponse.getSeatNumber() != null ? cJRBusOrderSummaryMetaDataResponse.getSeatNumber() : str2;
                                View inflate2 = LayoutInflater.from(this.f22719f.getContext()).inflate(R.layout.pre_b_bus_order_passenger_list_item, (ViewGroup) null, false);
                                TextView textView8 = (TextView) inflate2.findViewById(R.id.passenger_name);
                                ImageView imageView6 = (ImageView) inflate2.findViewById(R.id.passenger_icon);
                                TextView textView9 = (TextView) inflate2.findViewById(R.id.passenger_seat_text);
                                Iterator it5 = it4;
                                ImageView imageView7 = (ImageView) inflate2.findViewById(R.id.passenger_seat_icon);
                                boolean z6 = z3;
                                TextView textView10 = (TextView) inflate2.findViewById(R.id.refund_status_text);
                                String str7 = str2;
                                FrameLayout frameLayout2 = (FrameLayout) inflate2.findViewById(R.id.pax_seat_lyt);
                                int i8 = i2;
                                final ImageView imageView8 = (ImageView) inflate2.findViewById(R.id.order_state_image_view);
                                int i9 = R.drawable.travel_res_bus_order_summary_male_pax_icon;
                                int i10 = R.drawable.bus_passenger_seat_green;
                                if (!TextUtils.isEmpty(str6) && str6.equalsIgnoreCase(str3)) {
                                    i9 = R.drawable.travel_res_bus_order_summary_female_pax_icon;
                                    i10 = R.drawable.bus_passenger_seat_ladies;
                                }
                                int i11 = i10;
                                String str8 = str3;
                                textView8.setText(str5);
                                textView9.setText(seatNumber2);
                                imageView7.setImageDrawable(androidx.core.content.b.a(this.f22719f.getContext(), i11));
                                imageView6.setImageDrawable(androidx.core.content.b.a(this.f22719f.getContext(), i9));
                                int parseInt2 = Integer.parseInt(next.getItemStatus());
                                String statusText2 = next.getStatusText();
                                if (parseInt2 == 17) {
                                    frameLayout2.setVisibility(8);
                                    textView10.setVisibility(0);
                                    this.f22718e.setVisibility(8);
                                    textView10.setBackground(androidx.core.content.b.a(this.f22715b, R.drawable.travel_res_bus_failed_order_summary_badge_border));
                                    textView10.setTextColor(androidx.core.content.b.c(this.f22715b, R.color.bus_refund_pending_color));
                                    textView10.setText(this.f22715b.getString(R.string.bus_refund_pending));
                                } else {
                                    int i12 = 18;
                                    if (parseInt2 == 18) {
                                        if (!statusText2.equalsIgnoreCase("Processing Refund ")) {
                                            frameLayout2.setVisibility(8);
                                            textView10.setVisibility(0);
                                            this.f22718e.setVisibility(8);
                                            textView10.setBackground(androidx.core.content.b.a(this.f22715b, R.drawable.travel_res_bus_success_order_summary_badge_border));
                                            textView10.setTextColor(androidx.core.content.b.c(this.f22715b, R.color.bus_refund_success_color));
                                            textView10.setText(this.f22715b.getString(R.string.bus_refund));
                                        } else {
                                            i12 = 18;
                                        }
                                    }
                                    if (parseInt2 != i12 || !statusText2.equalsIgnoreCase("Processing Refund ")) {
                                        textView10.setVisibility(8);
                                        frameLayout2.setVisibility(0);
                                        this.f22718e.setVisibility(0);
                                        if (bVar2 == c.b.PAYMENT_FAILED) {
                                            textView9.setVisibility(8);
                                            imageView7.setImageResource(R.drawable.bus_booked_port);
                                        } else if (!(bVar2 == c.b.PAYMENT_SUCCESS || bVar2 == c.b.BOOKING_SUCCESSFUL)) {
                                            ResourceUtils.loadBusImagesFromCDN(imageView8, str, false, false, n.a.V1);
                                            imageView8.setVisibility(0);
                                            frameLayout2.setVisibility(8);
                                            if (!(this.k == null || this.k.b() == null)) {
                                                this.k.b().scheduleAtFixedRate(new Runnable() {
                                                    public final void run() {
                                                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                                                            public final void run() {
                                                                float rotation = imageView8.getRotation() + 30.0f;
                                                                if (rotation == 360.0f) {
                                                                    rotation = 0.0f;
                                                                }
                                                                imageView8.setRotation(rotation);
                                                            }
                                                        });
                                                    }
                                                }, 100, 100, TimeUnit.MILLISECONDS);
                                            }
                                            i2 = i8 + 1;
                                            this.f22719f.addView(inflate2);
                                            it4 = it5;
                                            z3 = z6;
                                            str2 = str7;
                                            str3 = str8;
                                        }
                                    } else {
                                        frameLayout2.setVisibility(8);
                                        textView10.setVisibility(0);
                                        this.f22718e.setVisibility(8);
                                        textView10.setBackground(androidx.core.content.b.a(this.f22715b, R.drawable.travel_res_bus_failed_order_summary_badge_border));
                                        textView10.setTextColor(androidx.core.content.b.c(this.f22715b, R.color.bus_refund_pending_color));
                                        textView10.setText(this.f22715b.getString(R.string.bus_refund_pending));
                                    }
                                    i2 = i8 + 1;
                                    this.f22719f.addView(inflate2);
                                    it4 = it5;
                                    z3 = z6;
                                    str2 = str7;
                                    str3 = str8;
                                }
                                i2 = i8 + 1;
                                this.f22719f.addView(inflate2);
                                it4 = it5;
                                z3 = z6;
                                str2 = str7;
                                str3 = str8;
                            }
                            z = z3;
                            int i13 = i2;
                        } else {
                            z = z3;
                        }
                        if (i2 <= 1) {
                            this.f22717d.setText(this.f22715b.getString(R.string.bus_passenger));
                            this.f22718e.setText(this.f22715b.getString(R.string.bus_seat));
                        } else {
                            this.f22717d.setText(this.f22715b.getString(R.string.bus_passengers));
                            this.f22718e.setText(this.f22715b.getString(R.string.bus_seats));
                        }
                        bVar3 = bVar2;
                        z3 = z;
                        it3 = it2;
                        cJRBusOrderSummaryMetaDataResponse2 = cJRBusOrderSummaryMetaDataResponse;
                        viewGroup = null;
                        z2 = false;
                    } else {
                        boolean z7 = z3;
                        int i14 = i2;
                    }
                }
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
            if (this.f22722i == BusOrderSummary.a.BUS && "Successful".equalsIgnoreCase(this.f22716c.getStatus())) {
                a();
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(ImageView imageView) {
        float rotation = imageView.getRotation() + 30.0f;
        if (rotation == 360.0f) {
            rotation = 0.0f;
        }
        imageView.setRotation(rotation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0071, code lost:
        if (r11.has("insurance_text") != false) goto L_0x0073;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02ab A[Catch:{ Exception -> 0x0379 }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02ac A[Catch:{ Exception -> 0x0379 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0339 A[Catch:{ Exception -> 0x037d }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x036d A[Catch:{ Exception -> 0x037e }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x016d A[Catch:{ Exception -> 0x0392 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0172 A[Catch:{ Exception -> 0x0392 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r21 = this;
            r1 = r21
            java.lang.String r2 = "failure"
            java.lang.String r3 = "pending"
            java.lang.String r4 = "success"
            java.lang.String r5 = "cancellation_protect"
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r1.f22716c     // Catch:{ Exception -> 0x0392 }
            java.util.ArrayList r0 = r0.getOrderedCartList()     // Catch:{ Exception -> 0x0392 }
            java.util.Iterator r6 = r0.iterator()     // Catch:{ Exception -> 0x0392 }
            java.lang.String r7 = ""
            r8 = 0
            r9 = r7
            r0 = 0
        L_0x001a:
            boolean r10 = r6.hasNext()     // Catch:{ Exception -> 0x0392 }
            if (r10 == 0) goto L_0x0392
            java.lang.Object r10 = r6.next()     // Catch:{ Exception -> 0x0392 }
            net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r10 = (net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r10     // Catch:{ Exception -> 0x0392 }
            java.lang.Object r11 = r10.getMetaDataResponse()     // Catch:{ Exception -> 0x0392 }
            com.google.gsonhtcfix.f r12 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0392 }
            r12.<init>()     // Catch:{ Exception -> 0x0392 }
            java.lang.String r11 = r12.a((java.lang.Object) r11)     // Catch:{ Exception -> 0x0392 }
            java.lang.Class<com.travel.bus.pojo.CJRFlightSummaryMetadataResponse> r13 = com.travel.bus.pojo.CJRFlightSummaryMetadataResponse.class
            java.lang.Object r11 = r12.a((java.lang.String) r11, r13)     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.CJRFlightSummaryMetadataResponse r11 = (com.travel.bus.pojo.CJRFlightSummaryMetadataResponse) r11     // Catch:{ Exception -> 0x0392 }
            java.lang.String r12 = r11.getInsuranceType()     // Catch:{ Exception -> 0x0392 }
            if (r12 == 0) goto L_0x0052
            java.lang.String r12 = r11.getInsuranceType()     // Catch:{ Exception -> 0x0392 }
            java.lang.String r13 = "2"
            boolean r12 = r12.equals(r13)     // Catch:{ Exception -> 0x0392 }
            if (r12 == 0) goto L_0x0052
            java.lang.String r9 = r10.getItemStatus()     // Catch:{ Exception -> 0x0392 }
            goto L_0x001a
        L_0x0052:
            java.lang.String r11 = r11.getAddonType()     // Catch:{ Exception -> 0x0392 }
            if (r11 != 0) goto L_0x0380
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x0392 }
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r10 = r10.getFullFillmentOject()     // Catch:{ Exception -> 0x0392 }
            java.lang.String r10 = r10.getFulfillmentResponse()     // Catch:{ Exception -> 0x0392 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x0392 }
            boolean r10 = r11.has(r5)     // Catch:{ Exception -> 0x0392 }
            java.lang.String r12 = "insurance_text"
            if (r10 != 0) goto L_0x0073
            boolean r10 = r11.has(r12)     // Catch:{ Exception -> 0x0392 }
            if (r10 == 0) goto L_0x0380
        L_0x0073:
            boolean r10 = r11.has(r5)     // Catch:{ Exception -> 0x0392 }
            if (r10 == 0) goto L_0x007c
            r0 = 1
            r10 = 1
            goto L_0x007d
        L_0x007c:
            r10 = r0
        L_0x007d:
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r0 = r1.f22714a     // Catch:{ Exception -> 0x0392 }
            java.lang.String r13 = "insurance_success.png"
            r15 = 0
            if (r0 == 0) goto L_0x017c
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r0 = r1.f22714a     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusInsuranceText r0 = r0.getInsuranceText()     // Catch:{ Exception -> 0x0392 }
            if (r0 == 0) goto L_0x017c
            android.widget.LinearLayout r0 = r1.f22720g     // Catch:{ Exception -> 0x0392 }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x0392 }
            android.view.View r0 = r1.f22721h     // Catch:{ Exception -> 0x0392 }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x0392 }
            android.content.Context r0 = r1.f22715b     // Catch:{ Exception -> 0x0392 }
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)     // Catch:{ Exception -> 0x0392 }
            int r12 = com.travel.bus.R.layout.bus_order_summary_pax_info_list_item     // Catch:{ Exception -> 0x0392 }
            android.view.View r0 = r0.inflate(r12, r15, r8)     // Catch:{ Exception -> 0x0392 }
            int r12 = com.travel.bus.R.id.pax_info_icon     // Catch:{ Exception -> 0x0392 }
            android.view.View r12 = r0.findViewById(r12)     // Catch:{ Exception -> 0x0392 }
            android.widget.ImageView r12 = (android.widget.ImageView) r12     // Catch:{ Exception -> 0x0392 }
            int r15 = com.travel.bus.R.id.bus_pax_info_text     // Catch:{ Exception -> 0x0392 }
            android.view.View r15 = r0.findViewById(r15)     // Catch:{ Exception -> 0x0392 }
            android.widget.TextView r15 = (android.widget.TextView) r15     // Catch:{ Exception -> 0x0392 }
            int r14 = com.travel.bus.R.id.bus_pax_info_desc_text     // Catch:{ Exception -> 0x0392 }
            android.view.View r14 = r0.findViewById(r14)     // Catch:{ Exception -> 0x0392 }
            android.widget.TextView r14 = (android.widget.TextView) r14     // Catch:{ Exception -> 0x0392 }
            int r8 = com.travel.bus.R.id.pax_info_devider_view     // Catch:{ Exception -> 0x0392 }
            android.view.View r8 = r0.findViewById(r8)     // Catch:{ Exception -> 0x0392 }
            r17 = r6
            com.travel.utils.n$a r6 = com.travel.utils.n.a.V1     // Catch:{ Exception -> 0x0392 }
            r18 = r7
            r7 = 0
            com.travel.cdn.ResourceUtils.loadBusImagesFromCDN(r12, r13, r7, r7, r6)     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r6 = r1.f22714a     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusInsuranceText r6 = r6.getInsuranceText()     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusOnwardTrip r6 = r6.getOnward()     // Catch:{ Exception -> 0x0392 }
            if (r6 == 0) goto L_0x0119
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r6 = r1.f22714a     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusInsuranceText r6 = r6.getInsuranceText()     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusOnwardTrip r6 = r6.getOnward()     // Catch:{ Exception -> 0x0392 }
            java.lang.String r6 = r6.getTitle()     // Catch:{ Exception -> 0x0392 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0392 }
            if (r6 != 0) goto L_0x0100
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r6 = r1.f22714a     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusInsuranceText r6 = r6.getInsuranceText()     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusOnwardTrip r6 = r6.getOnward()     // Catch:{ Exception -> 0x0392 }
            java.lang.String r6 = r6.getTitle()     // Catch:{ Exception -> 0x0392 }
            r15.setText(r6)     // Catch:{ Exception -> 0x0392 }
            r6 = 0
            r15.setVisibility(r6)     // Catch:{ Exception -> 0x0392 }
            goto L_0x0105
        L_0x0100:
            r6 = 8
            r15.setVisibility(r6)     // Catch:{ Exception -> 0x0392 }
        L_0x0105:
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r6 = r1.f22714a     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusInsuranceText r6 = r6.getInsuranceText()     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusOnwardTrip r6 = r6.getOnward()     // Catch:{ Exception -> 0x0392 }
            java.lang.String r6 = r6.getDescription()     // Catch:{ Exception -> 0x0392 }
            r14.setText(r6)     // Catch:{ Exception -> 0x0392 }
        L_0x0116:
            r6 = 8
            goto L_0x016b
        L_0x0119:
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r6 = r1.f22714a     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusInsuranceText r6 = r6.getInsuranceText()     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusReturnTrip r6 = r6.getReturn()     // Catch:{ Exception -> 0x0392 }
            if (r6 == 0) goto L_0x0166
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r6 = r1.f22714a     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusInsuranceText r6 = r6.getInsuranceText()     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusReturnTrip r6 = r6.getReturn()     // Catch:{ Exception -> 0x0392 }
            java.lang.String r6 = r6.getTitle()     // Catch:{ Exception -> 0x0392 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0392 }
            if (r6 != 0) goto L_0x014f
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r6 = r1.f22714a     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusInsuranceText r6 = r6.getInsuranceText()     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusReturnTrip r6 = r6.getReturn()     // Catch:{ Exception -> 0x0392 }
            java.lang.String r6 = r6.getTitle()     // Catch:{ Exception -> 0x0392 }
            r15.setText(r6)     // Catch:{ Exception -> 0x0392 }
            r6 = 0
            r15.setVisibility(r6)     // Catch:{ Exception -> 0x0392 }
            goto L_0x0154
        L_0x014f:
            r6 = 8
            r15.setVisibility(r6)     // Catch:{ Exception -> 0x0392 }
        L_0x0154:
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r6 = r1.f22714a     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusInsuranceText r6 = r6.getInsuranceText()     // Catch:{ Exception -> 0x0392 }
            com.travel.bus.pojo.busticket.CJRBusReturnTrip r6 = r6.getReturn()     // Catch:{ Exception -> 0x0392 }
            java.lang.String r6 = r6.getDescription()     // Catch:{ Exception -> 0x0392 }
            r14.setText(r6)     // Catch:{ Exception -> 0x0392 }
            goto L_0x0116
        L_0x0166:
            r6 = 8
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x0392 }
        L_0x016b:
            if (r10 == 0) goto L_0x0172
            r7 = 0
            r8.setVisibility(r7)     // Catch:{ Exception -> 0x0392 }
            goto L_0x0175
        L_0x0172:
            r8.setVisibility(r6)     // Catch:{ Exception -> 0x0392 }
        L_0x0175:
            android.widget.LinearLayout r6 = r1.f22720g     // Catch:{ Exception -> 0x0392 }
            r6.addView(r0)     // Catch:{ Exception -> 0x0392 }
            goto L_0x0249
        L_0x017c:
            r17 = r6
            r18 = r7
            boolean r0 = r11.has(r12)     // Catch:{ JSONException -> 0x025d }
            if (r0 == 0) goto L_0x0249
            java.lang.String r0 = r11.getString(r12)     // Catch:{ JSONException -> 0x025d }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x025d }
            if (r0 != 0) goto L_0x0249
            org.json.JSONObject r0 = r11.getJSONObject(r12)     // Catch:{ JSONException -> 0x024e }
            if (r0 == 0) goto L_0x0249
            android.widget.LinearLayout r6 = r1.f22720g     // Catch:{ JSONException -> 0x024e }
            r7 = 0
            r6.setVisibility(r7)     // Catch:{ JSONException -> 0x024e }
            android.view.View r6 = r1.f22721h     // Catch:{ JSONException -> 0x024e }
            r6.setVisibility(r7)     // Catch:{ JSONException -> 0x024e }
            android.content.Context r6 = r1.f22715b     // Catch:{ JSONException -> 0x024e }
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)     // Catch:{ JSONException -> 0x024e }
            int r8 = com.travel.bus.R.layout.bus_order_summary_pax_info_list_item     // Catch:{ JSONException -> 0x024e }
            r12 = 0
            android.view.View r6 = r6.inflate(r8, r12, r7)     // Catch:{ JSONException -> 0x024e }
            int r7 = com.travel.bus.R.id.pax_info_icon     // Catch:{ JSONException -> 0x024e }
            android.view.View r7 = r6.findViewById(r7)     // Catch:{ JSONException -> 0x024e }
            android.widget.ImageView r7 = (android.widget.ImageView) r7     // Catch:{ JSONException -> 0x024e }
            int r8 = com.travel.bus.R.id.bus_pax_info_text     // Catch:{ JSONException -> 0x024e }
            android.view.View r8 = r6.findViewById(r8)     // Catch:{ JSONException -> 0x024e }
            android.widget.TextView r8 = (android.widget.TextView) r8     // Catch:{ JSONException -> 0x024e }
            int r12 = com.travel.bus.R.id.bus_pax_info_desc_text     // Catch:{ JSONException -> 0x024e }
            android.view.View r12 = r6.findViewById(r12)     // Catch:{ JSONException -> 0x024e }
            android.widget.TextView r12 = (android.widget.TextView) r12     // Catch:{ JSONException -> 0x024e }
            int r14 = com.travel.bus.R.id.pax_info_devider_view     // Catch:{ JSONException -> 0x024e }
            android.view.View r14 = r6.findViewById(r14)     // Catch:{ JSONException -> 0x024e }
            com.travel.utils.n$a r15 = com.travel.utils.n.a.V1     // Catch:{ JSONException -> 0x024e }
            r19 = r4
            r4 = 0
            com.travel.cdn.ResourceUtils.loadBusImagesFromCDN(r7, r13, r4, r4, r15)     // Catch:{ JSONException -> 0x0247 }
            java.lang.String r4 = "title"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ JSONException -> 0x0247 }
            java.lang.String r7 = "description"
            java.lang.String r7 = r0.getString(r7)     // Catch:{ JSONException -> 0x0247 }
            java.lang.String r15 = "tncLink"
            java.lang.String r0 = r0.getString(r15)     // Catch:{ JSONException -> 0x0247 }
            boolean r15 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0247 }
            if (r15 != 0) goto L_0x024b
            boolean r15 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0247 }
            if (r15 != 0) goto L_0x024b
            boolean r15 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x0247 }
            if (r15 != 0) goto L_0x024b
            r8.setText(r4)     // Catch:{ JSONException -> 0x0247 }
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0247 }
            if (r4 != 0) goto L_0x022e
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x0247 }
            if (r4 != 0) goto L_0x022e
            android.text.SpannableString r4 = new android.text.SpannableString     // Catch:{ JSONException -> 0x0247 }
            r4.<init>(r7)     // Catch:{ JSONException -> 0x0247 }
            com.travel.bus.orders.i.i$2 r15 = new com.travel.bus.orders.i.i$2     // Catch:{ JSONException -> 0x0247 }
            r15.<init>(r0)     // Catch:{ JSONException -> 0x0247 }
            int r0 = r7.length()     // Catch:{ JSONException -> 0x0247 }
            int r0 = r0 + -3
            int r7 = r7.length()     // Catch:{ JSONException -> 0x0247 }
            r20 = r13
            r13 = 0
            r4.setSpan(r15, r0, r7, r13)     // Catch:{ JSONException -> 0x0245 }
            r12.setText(r4)     // Catch:{ JSONException -> 0x0245 }
            android.text.method.MovementMethod r0 = android.text.method.LinkMovementMethod.getInstance()     // Catch:{ JSONException -> 0x0245 }
            r12.setMovementMethod(r0)     // Catch:{ JSONException -> 0x0245 }
            goto L_0x0230
        L_0x022e:
            r20 = r13
        L_0x0230:
            r4 = 0
            r8.setVisibility(r4)     // Catch:{ JSONException -> 0x0245 }
            if (r10 == 0) goto L_0x023a
            r14.setVisibility(r4)     // Catch:{ JSONException -> 0x0245 }
            goto L_0x023f
        L_0x023a:
            r0 = 8
            r14.setVisibility(r0)     // Catch:{ JSONException -> 0x0245 }
        L_0x023f:
            android.widget.LinearLayout r0 = r1.f22720g     // Catch:{ JSONException -> 0x0245 }
            r0.addView(r6)     // Catch:{ JSONException -> 0x0245 }
            goto L_0x0269
        L_0x0245:
            r0 = move-exception
            goto L_0x0253
        L_0x0247:
            r0 = move-exception
            goto L_0x0251
        L_0x0249:
            r19 = r4
        L_0x024b:
            r20 = r13
            goto L_0x0269
        L_0x024e:
            r0 = move-exception
            r19 = r4
        L_0x0251:
            r20 = r13
        L_0x0253:
            java.lang.String r0 = r0.getMessage()     // Catch:{ JSONException -> 0x025b }
            com.paytm.utility.q.c(r0)     // Catch:{ JSONException -> 0x025b }
            goto L_0x0269
        L_0x025b:
            r0 = move-exception
            goto L_0x0262
        L_0x025d:
            r0 = move-exception
            r19 = r4
            r20 = r13
        L_0x0262:
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0392 }
            com.paytm.utility.q.c(r0)     // Catch:{ Exception -> 0x0392 }
        L_0x0269:
            android.widget.LinearLayout r0 = r1.f22720g     // Catch:{ Exception -> 0x0379 }
            r4 = 0
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x0379 }
            android.view.View r0 = r1.f22721h     // Catch:{ Exception -> 0x0379 }
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x0379 }
            org.json.JSONObject r0 = r11.getJSONObject(r5)     // Catch:{ Exception -> 0x0379 }
            java.lang.String r4 = "img_url"
            org.json.JSONObject r4 = r0.getJSONObject(r4)     // Catch:{ Exception -> 0x0379 }
            java.lang.String r6 = "display_text"
            org.json.JSONObject r6 = r0.getJSONObject(r6)     // Catch:{ Exception -> 0x0379 }
            java.lang.String r7 = "message"
            org.json.JSONObject r7 = r0.getJSONObject(r7)     // Catch:{ Exception -> 0x0379 }
            java.lang.String r8 = "tnc"
            java.lang.String r0 = r0.getString(r8)     // Catch:{ Exception -> 0x0379 }
            r1.j = r0     // Catch:{ Exception -> 0x0379 }
            java.lang.String r0 = "7"
            boolean r0 = r9.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0379 }
            if (r0 != 0) goto L_0x02df
            java.lang.String r0 = "17"
            boolean r0 = r9.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0379 }
            if (r0 != 0) goto L_0x02df
            java.lang.String r0 = "18"
            boolean r0 = r9.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0379 }
            if (r0 == 0) goto L_0x02ac
            goto L_0x02df
        L_0x02ac:
            java.lang.String r0 = "13"
            boolean r0 = r9.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0379 }
            if (r0 == 0) goto L_0x02c3
            java.lang.String r0 = r4.getString(r3)     // Catch:{ Exception -> 0x0379 }
            java.lang.String r15 = r7.getString(r3)     // Catch:{ Exception -> 0x0379 }
            java.lang.String r4 = r6.getString(r3)     // Catch:{ Exception -> 0x0379 }
        L_0x02c0:
            r8 = r19
            goto L_0x02ed
        L_0x02c3:
            java.lang.String r0 = "6"
            boolean r0 = r9.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0379 }
            if (r0 == 0) goto L_0x02d8
            java.lang.String r0 = r4.getString(r2)     // Catch:{ Exception -> 0x0379 }
            java.lang.String r15 = r7.getString(r2)     // Catch:{ Exception -> 0x0379 }
            java.lang.String r4 = r6.getString(r2)     // Catch:{ Exception -> 0x0379 }
            goto L_0x02c0
        L_0x02d8:
            r0 = r18
            r8 = r19
            r4 = 0
            r15 = 0
            goto L_0x02ed
        L_0x02df:
            r8 = r19
            java.lang.String r0 = r4.getString(r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r15 = r7.getString(r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r4 = r6.getString(r8)     // Catch:{ Exception -> 0x0376 }
        L_0x02ed:
            android.content.Context r6 = r1.f22715b     // Catch:{ Exception -> 0x0376 }
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)     // Catch:{ Exception -> 0x0376 }
            int r7 = com.travel.bus.R.layout.bus_order_summary_pax_info_list_item     // Catch:{ Exception -> 0x0376 }
            r11 = 0
            r12 = 0
            android.view.View r6 = r6.inflate(r7, r11, r12)     // Catch:{ Exception -> 0x0376 }
            int r7 = com.travel.bus.R.id.pax_info_icon     // Catch:{ Exception -> 0x0376 }
            android.view.View r7 = r6.findViewById(r7)     // Catch:{ Exception -> 0x0376 }
            android.widget.ImageView r7 = (android.widget.ImageView) r7     // Catch:{ Exception -> 0x0376 }
            int r11 = com.travel.bus.R.id.bus_pax_info_text     // Catch:{ Exception -> 0x0376 }
            android.view.View r11 = r6.findViewById(r11)     // Catch:{ Exception -> 0x0376 }
            android.widget.TextView r11 = (android.widget.TextView) r11     // Catch:{ Exception -> 0x0376 }
            int r12 = com.travel.bus.R.id.bus_pax_info_desc_text     // Catch:{ Exception -> 0x0376 }
            android.view.View r12 = r6.findViewById(r12)     // Catch:{ Exception -> 0x0376 }
            android.widget.TextView r12 = (android.widget.TextView) r12     // Catch:{ Exception -> 0x0376 }
            com.travel.utils.n$a r13 = com.travel.utils.n.a.V1     // Catch:{ Exception -> 0x0376 }
            r16 = r2
            r14 = r20
            r2 = 0
            com.travel.cdn.ResourceUtils.loadBusImagesFromCDN(r7, r14, r2, r2, r13)     // Catch:{ Exception -> 0x037d }
            if (r0 == 0) goto L_0x0330
            boolean r2 = android.webkit.URLUtil.isValidUrl(r0)     // Catch:{ Exception -> 0x037d }
            if (r2 == 0) goto L_0x0330
            android.content.Context r2 = r1.f22715b     // Catch:{ Exception -> 0x037d }
            com.paytm.utility.b.b$a$a r2 = com.paytm.utility.b.b.a(r2)     // Catch:{ Exception -> 0x037d }
            r2.f43753a = r0     // Catch:{ Exception -> 0x037d }
            r2.a((android.widget.ImageView) r7)     // Catch:{ Exception -> 0x037d }
        L_0x0330:
            r11.setText(r15)     // Catch:{ Exception -> 0x037d }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x037d }
            if (r0 != 0) goto L_0x036d
            android.text.SpannableString r0 = new android.text.SpannableString     // Catch:{ Exception -> 0x037d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x037d }
            r2.<init>()     // Catch:{ Exception -> 0x037d }
            r2.append(r4)     // Catch:{ Exception -> 0x037d }
            java.lang.String r7 = " T&C "
            r2.append(r7)     // Catch:{ Exception -> 0x037d }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x037d }
            r0.<init>(r2)     // Catch:{ Exception -> 0x037d }
            com.travel.bus.orders.i.i$3 r2 = new com.travel.bus.orders.i.i$3     // Catch:{ Exception -> 0x037d }
            r2.<init>()     // Catch:{ Exception -> 0x037d }
            int r7 = r4.length()     // Catch:{ Exception -> 0x037d }
            int r4 = r4.length()     // Catch:{ Exception -> 0x037d }
            int r4 = r4 + 4
            r11 = 0
            r0.setSpan(r2, r7, r4, r11)     // Catch:{ Exception -> 0x037e }
            android.text.method.MovementMethod r2 = android.text.method.LinkMovementMethod.getInstance()     // Catch:{ Exception -> 0x037e }
            r12.setMovementMethod(r2)     // Catch:{ Exception -> 0x037e }
            r12.setText(r0)     // Catch:{ Exception -> 0x037e }
            goto L_0x036e
        L_0x036d:
            r11 = 0
        L_0x036e:
            android.widget.LinearLayout r0 = r1.f22720g     // Catch:{ Exception -> 0x037e }
            r0.addView(r6)     // Catch:{ Exception -> 0x037e }
            r4 = r8
            r0 = r10
            goto L_0x0389
        L_0x0376:
            r16 = r2
            goto L_0x037d
        L_0x0379:
            r16 = r2
            r8 = r19
        L_0x037d:
            r11 = 0
        L_0x037e:
            r0 = r10
            goto L_0x0388
        L_0x0380:
            r16 = r2
            r8 = r4
            r17 = r6
            r18 = r7
            r11 = 0
        L_0x0388:
            r4 = r8
        L_0x0389:
            r2 = r16
            r6 = r17
            r7 = r18
            r8 = 0
            goto L_0x001a
        L_0x0392:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.i.i.a():void");
    }

    public final void onClick(View view) {
        CJRBusRefundDetails cJRBusRefundDetails = this.f22714a;
        if (cJRBusRefundDetails == null || cJRBusRefundDetails.getCancelPolicy() == null || this.f22714a.getCancelPolicy().getBusOnwardCancellationPolicy() == null || this.f22714a.getCancelPolicy().getBusOnwardCancellationPolicy().getNewOrderSummaryCancellationPolicy() == null || this.f22714a.getCancelPolicy().getBusOnwardCancellationPolicy().getNewOrderSummaryCancellationPolicy().size() <= 0) {
            CJRBusRefundDetails cJRBusRefundDetails2 = this.f22714a;
            if (cJRBusRefundDetails2 != null && cJRBusRefundDetails2.getCancelPolicy() != null && this.f22714a.getCancelPolicy().getBusOnwardCancellationPolicy() != null && this.f22714a.getCancelPolicy().getBusOnwardCancellationPolicy().getOldOrderSummaryCancellationPolicy() != null && this.f22714a.getCancelPolicy().getBusOnwardCancellationPolicy().getOldOrderSummaryCancellationPolicy().size() > 0) {
                ArrayList<CJRBusSearchCancellationPolicy> oldOrderSummaryCancellationPolicy = this.f22714a.getCancelPolicy().getBusOnwardCancellationPolicy().getOldOrderSummaryCancellationPolicy();
                if (!TextUtils.isEmpty(this.m) && oldOrderSummaryCancellationPolicy != null && oldOrderSummaryCancellationPolicy.size() > 0) {
                    final Dialog dialog = new Dialog(this.f22715b);
                    dialog.requestWindowFeature(1);
                    dialog.setContentView(R.layout.item_bus_ticket_cancellation_policy);
                    Window window = dialog.getWindow();
                    window.setBackgroundDrawableResource(17170445);
                    window.setLayout(-1, -2);
                    ListView listView = (ListView) dialog.findViewById(R.id.cancellation_policy_listview);
                    ((RecyclerView) dialog.findViewById(R.id.bus_cancellation_recycler_view)).setVisibility(8);
                    listView.setVisibility(0);
                    Context context = this.f22715b;
                    int i2 = R.string.bus_order_summary_refund_desc_text;
                    ((TextView) dialog.findViewById(R.id.price_cal_message)).setText(context.getString(i2, new Object[]{this.f22715b.getString(R.string.rs_symbol) + " " + this.m}));
                    listView.setAdapter(new aa(this.f22715b, oldOrderSummaryCancellationPolicy, this.m));
                    ((Button) dialog.findViewById(R.id.button_submit_password)).setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                    return;
                }
                return;
            }
            return;
        }
        ArrayList<CJRBusCancellationPolicy> newOrderSummaryCancellationPolicy = this.f22714a.getCancelPolicy().getBusOnwardCancellationPolicy().getNewOrderSummaryCancellationPolicy();
        if (newOrderSummaryCancellationPolicy != null && newOrderSummaryCancellationPolicy.size() > 0) {
            Dialog dialog2 = new Dialog(this.f22715b);
            dialog2.requestWindowFeature(1);
            dialog2.setContentView(R.layout.item_bus_ticket_cancellation_policy);
            Window window2 = dialog2.getWindow();
            window2.setBackgroundDrawableResource(17170445);
            window2.setLayout(-1, -2);
            RecyclerView recyclerView = (RecyclerView) dialog2.findViewById(R.id.bus_cancellation_recycler_view);
            ListView listView2 = (ListView) dialog2.findViewById(R.id.cancellation_policy_listview);
            TextView textView = (TextView) dialog2.findViewById(R.id.price_cal_message);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.f22715b.getApplicationContext()));
            String str = (this.f22714a.getCancelPolicy().getBusOnwardCancellationPolicy().getCjrBusCancellationPolicyNoteTexts() == null || this.f22714a.getCancelPolicy().getBusOnwardCancellationPolicy().getCjrBusCancellationPolicyNoteTexts().size() <= 0) ? "" : this.f22714a.getCancelPolicy().getBusOnwardCancellationPolicy().getCjrBusCancellationPolicyNoteTexts().get(0);
            recyclerView.setVisibility(0);
            listView2.setVisibility(8);
            textView.setText(str);
            recyclerView.setAdapter(new h(newOrderSummaryCancellationPolicy, this.f22715b));
            ImageView imageView = (ImageView) dialog2.findViewById(R.id.close_icon_action);
            imageView.setImageResource(R.drawable.bus_close_normal);
            imageView.setOnClickListener(new View.OnClickListener(dialog2) {
                private final /* synthetic */ Dialog f$0;

                {
                    this.f$0 = r1;
                }

                public final void onClick(View view) {
                    this.f$0.dismiss();
                }
            });
            dialog2.show();
        }
    }

    static /* synthetic */ void a(i iVar, String str) {
        Intent intent = new Intent(iVar.f22715b, AJRBusWebViewActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("title", iVar.f22715b.getString(R.string.f21494paytm));
        iVar.f22715b.startActivity(intent);
    }

    static /* synthetic */ void b(i iVar, String str) {
        Intent intent = new Intent(iVar.f22715b, AJREmbedWebView.class);
        intent.putExtra("url", str);
        intent.putExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, "");
        iVar.f22715b.startActivity(intent);
    }
}
