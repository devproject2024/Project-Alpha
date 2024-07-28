package com.travel.bus.orders.i;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.travel.bus.R;
import com.travel.bus.common.AJREmbedWebView;
import com.travel.bus.orders.activity.BusOrderSummary;
import com.travel.bus.orders.c.c;
import com.travel.bus.orders.e.a;
import com.travel.bus.pojo.busticket.CJRBusOrderSummary;
import com.travel.bus.pojo.busticket.CJRBusRefundDetails;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class f extends a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private CJRBusOrderSummary f22685a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f22686b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22687c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f22688d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f22689e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f22690f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f22691g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f22692h = "";

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f22693i;
    private CJRBusRefundDetails j;
    private BusOrderSummary.a k;

    public final void onClick(View view) {
    }

    public f(View view, CJRBusOrderSummary cJRBusOrderSummary, BusOrderSummary.a aVar, CJRBusRefundDetails cJRBusRefundDetails) {
        super(view);
        CJRBusRefundDetails cJRBusRefundDetails2;
        this.f22685a = cJRBusOrderSummary;
        this.f22686b = view.getContext();
        this.j = cJRBusRefundDetails;
        this.f22687c = (TextView) view.findViewById(R.id.flight_cancel_protect_order_status_title);
        this.f22688d = (TextView) view.findViewById(R.id.flight_cancel_protect_order_status_msg);
        this.f22689e = (ImageView) view.findViewById(R.id.flight_cancel_protect_order_status_icon);
        this.f22693i = (LinearLayout) view.findViewById(R.id.lyt_container_insurance_card);
        this.k = aVar;
        if (aVar == BusOrderSummary.a.BUS && (cJRBusRefundDetails2 = this.j) != null && cJRBusRefundDetails2.getInsuranceText() != null) {
            this.f22693i.setVisibility(0);
            ResourceUtils.loadBusImagesFromCDN(this.f22689e, "insurance_success.png", false, false, n.a.V1);
            if (this.j.getInsuranceText().getOnward() != null) {
                a(this.j.getInsuranceText().getOnward().getTitle(), this.j.getInsuranceText().getOnward().getDescription());
            } else if (this.j.getInsuranceText().getOnward() != null) {
                a(this.j.getInsuranceText().getReturn().getTitle(), this.j.getInsuranceText().getReturn().getDescription());
            }
        }
    }

    public final void a(c.b bVar) {
        if (this.k == BusOrderSummary.a.BUS) {
            a();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|(2:12|(2:14|(8:16|17|(2:21|(1:23)(5:24|(1:26)(2:27|(1:29)(1:30))|(1:35)|36|(2:38|48)(1:47)))|31|33|35|36|(0)(0))(1:46))(1:45))(2:11|44)|42|5|4) */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x001c */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x010d A[Catch:{ Exception -> 0x001c }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x001c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0022 A[Catch:{ Exception -> 0x014c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a() {
        /*
            r13 = this;
            java.lang.String r0 = "cancellation_protect"
            java.lang.String r1 = ""
            java.lang.String r2 = "failure"
            java.lang.String r3 = "pending"
            java.lang.String r4 = "success"
            android.widget.LinearLayout r5 = r13.f22693i
            r6 = 0
            r5.setVisibility(r6)
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r5 = r13.f22685a     // Catch:{ Exception -> 0x014b }
            java.util.ArrayList r5 = r5.getOrderedCartList()     // Catch:{ Exception -> 0x014b }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x014b }
            r7 = r1
        L_0x001c:
            boolean r8 = r5.hasNext()     // Catch:{ Exception -> 0x014c }
            if (r8 == 0) goto L_0x014c
            java.lang.Object r8 = r5.next()     // Catch:{ Exception -> 0x014c }
            net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r8 = (net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r8     // Catch:{ Exception -> 0x014c }
            java.lang.Object r9 = r8.getMetaDataResponse()     // Catch:{ Exception -> 0x014c }
            com.google.gsonhtcfix.f r10 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x014c }
            r10.<init>()     // Catch:{ Exception -> 0x014c }
            java.lang.String r9 = r10.a((java.lang.Object) r9)     // Catch:{ Exception -> 0x014c }
            java.lang.Class<com.travel.bus.pojo.CJRFlightSummaryMetadataResponse> r11 = com.travel.bus.pojo.CJRFlightSummaryMetadataResponse.class
            java.lang.Object r9 = r10.a((java.lang.String) r9, r11)     // Catch:{ Exception -> 0x014c }
            com.travel.bus.pojo.CJRFlightSummaryMetadataResponse r9 = (com.travel.bus.pojo.CJRFlightSummaryMetadataResponse) r9     // Catch:{ Exception -> 0x014c }
            java.lang.String r10 = r9.getInsuranceType()     // Catch:{ Exception -> 0x014c }
            if (r10 == 0) goto L_0x0054
            java.lang.String r10 = r9.getInsuranceType()     // Catch:{ Exception -> 0x014c }
            java.lang.String r11 = "2"
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x014c }
            if (r10 == 0) goto L_0x0054
            java.lang.String r7 = r8.getItemStatus()     // Catch:{ Exception -> 0x014c }
            goto L_0x001c
        L_0x0054:
            java.lang.String r9 = r9.getAddonType()     // Catch:{ Exception -> 0x014c }
            if (r9 != 0) goto L_0x001c
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x014c }
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r8 = r8.getFullFillmentOject()     // Catch:{ Exception -> 0x014c }
            java.lang.String r8 = r8.getFulfillmentResponse()     // Catch:{ Exception -> 0x014c }
            r9.<init>(r8)     // Catch:{ Exception -> 0x014c }
            boolean r8 = r9.has(r0)     // Catch:{ Exception -> 0x014c }
            if (r8 == 0) goto L_0x001c
            org.json.JSONObject r8 = r9.getJSONObject(r0)     // Catch:{ Exception -> 0x001c }
            java.lang.String r9 = "img_url"
            org.json.JSONObject r9 = r8.getJSONObject(r9)     // Catch:{ Exception -> 0x001c }
            java.lang.String r10 = "display_text"
            org.json.JSONObject r10 = r8.getJSONObject(r10)     // Catch:{ Exception -> 0x001c }
            java.lang.String r11 = "message"
            org.json.JSONObject r11 = r8.getJSONObject(r11)     // Catch:{ Exception -> 0x001c }
            java.lang.String r12 = "tnc"
            java.lang.String r8 = r8.getString(r12)     // Catch:{ Exception -> 0x001c }
            r13.f22690f = r8     // Catch:{ Exception -> 0x001c }
            java.lang.String r8 = "7"
            boolean r8 = r7.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x001c }
            if (r8 != 0) goto L_0x00d9
            java.lang.String r8 = "17"
            boolean r8 = r7.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x001c }
            if (r8 != 0) goto L_0x00d9
            java.lang.String r8 = "18"
            boolean r8 = r7.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x001c }
            if (r8 == 0) goto L_0x00a5
            goto L_0x00d9
        L_0x00a5:
            java.lang.String r8 = "13"
            boolean r8 = r7.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x001c }
            if (r8 == 0) goto L_0x00be
            java.lang.String r8 = r9.getString(r3)     // Catch:{ Exception -> 0x001c }
            java.lang.String r9 = r11.getString(r3)     // Catch:{ Exception -> 0x001c }
            r13.f22691g = r9     // Catch:{ Exception -> 0x001c }
            java.lang.String r9 = r10.getString(r3)     // Catch:{ Exception -> 0x001c }
            r13.f22692h = r9     // Catch:{ Exception -> 0x001c }
            goto L_0x00e9
        L_0x00be:
            java.lang.String r8 = "6"
            boolean r8 = r7.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x001c }
            if (r8 == 0) goto L_0x00d7
            java.lang.String r8 = r9.getString(r2)     // Catch:{ Exception -> 0x001c }
            java.lang.String r9 = r11.getString(r2)     // Catch:{ Exception -> 0x001c }
            r13.f22691g = r9     // Catch:{ Exception -> 0x001c }
            java.lang.String r9 = r10.getString(r2)     // Catch:{ Exception -> 0x001c }
            r13.f22692h = r9     // Catch:{ Exception -> 0x001c }
            goto L_0x00e9
        L_0x00d7:
            r8 = r1
            goto L_0x00e9
        L_0x00d9:
            java.lang.String r8 = r9.getString(r4)     // Catch:{ Exception -> 0x001c }
            java.lang.String r9 = r11.getString(r4)     // Catch:{ Exception -> 0x001c }
            r13.f22691g = r9     // Catch:{ Exception -> 0x001c }
            java.lang.String r9 = r10.getString(r4)     // Catch:{ Exception -> 0x001c }
            r13.f22692h = r9     // Catch:{ Exception -> 0x001c }
        L_0x00e9:
            if (r8 == 0) goto L_0x00fe
            boolean r9 = android.webkit.URLUtil.isValidUrl(r8)     // Catch:{ Exception -> 0x001c }
            if (r9 == 0) goto L_0x00fe
            android.content.Context r9 = r13.f22686b     // Catch:{ Exception -> 0x001c }
            com.paytm.utility.b.b$a$a r9 = com.paytm.utility.b.b.a(r9)     // Catch:{ Exception -> 0x001c }
            r9.f43753a = r8     // Catch:{ Exception -> 0x001c }
            android.widget.ImageView r8 = r13.f22689e     // Catch:{ Exception -> 0x001c }
            r9.a((android.widget.ImageView) r8)     // Catch:{ Exception -> 0x001c }
        L_0x00fe:
            android.widget.TextView r8 = r13.f22687c     // Catch:{ Exception -> 0x001c }
            java.lang.String r9 = r13.f22691g     // Catch:{ Exception -> 0x001c }
            r8.setText(r9)     // Catch:{ Exception -> 0x001c }
            java.lang.String r8 = r13.f22692h     // Catch:{ Exception -> 0x001c }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x001c }
            if (r8 != 0) goto L_0x001c
            android.text.SpannableString r8 = new android.text.SpannableString     // Catch:{ Exception -> 0x001c }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001c }
            r9.<init>()     // Catch:{ Exception -> 0x001c }
            java.lang.String r10 = r13.f22692h     // Catch:{ Exception -> 0x001c }
            r9.append(r10)     // Catch:{ Exception -> 0x001c }
            java.lang.String r10 = " T&C "
            r9.append(r10)     // Catch:{ Exception -> 0x001c }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x001c }
            r8.<init>(r9)     // Catch:{ Exception -> 0x001c }
            com.travel.bus.orders.i.f$1 r9 = new com.travel.bus.orders.i.f$1     // Catch:{ Exception -> 0x001c }
            r9.<init>()     // Catch:{ Exception -> 0x001c }
            java.lang.String r10 = r13.f22692h     // Catch:{ Exception -> 0x001c }
            int r10 = r10.length()     // Catch:{ Exception -> 0x001c }
            java.lang.String r11 = r13.f22692h     // Catch:{ Exception -> 0x001c }
            int r11 = r11.length()     // Catch:{ Exception -> 0x001c }
            int r11 = r11 + 4
            r8.setSpan(r9, r10, r11, r6)     // Catch:{ Exception -> 0x001c }
            android.widget.TextView r9 = r13.f22688d     // Catch:{ Exception -> 0x001c }
            android.text.method.MovementMethod r10 = android.text.method.LinkMovementMethod.getInstance()     // Catch:{ Exception -> 0x001c }
            r9.setMovementMethod(r10)     // Catch:{ Exception -> 0x001c }
            android.widget.TextView r9 = r13.f22688d     // Catch:{ Exception -> 0x001c }
            r9.setText(r8)     // Catch:{ Exception -> 0x001c }
            goto L_0x001c
        L_0x014b:
            r7 = r1
        L_0x014c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.i.f.a():java.lang.String");
    }

    private void a(String str, String str2) {
        this.f22687c.setText(str);
        this.f22688d.setText(str2);
    }

    static /* synthetic */ void a(f fVar, String str) {
        Intent intent = new Intent(fVar.f22686b, AJREmbedWebView.class);
        intent.putExtra("url", str);
        intent.putExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, "");
        fVar.f22686b.startActivity(intent);
    }
}
