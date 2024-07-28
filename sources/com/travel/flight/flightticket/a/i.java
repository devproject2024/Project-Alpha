package com.travel.flight.flightticket.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.travel.flight.b;
import com.travel.flight.flightticket.f.k;
import com.travel.flight.pojo.flightticket.CJRFlightOfferCode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<CJRFlightOfferCode> f24660a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public k f24661b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f24662c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f24663d;

    /* renamed from: e  reason: collision with root package name */
    private int f24664e = 2;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public i(Context context, List<CJRFlightOfferCode> list, k kVar) {
        this.f24663d = context;
        this.f24662c = LayoutInflater.from(context);
        this.f24660a = list;
        this.f24661b = kVar;
    }

    public final int getCount() {
        List<CJRFlightOfferCode> list = this.f24660a;
        if (list == null) {
            return 0;
        }
        int size = list.size();
        int i2 = this.f24664e;
        if (size > i2) {
            return i2;
        }
        return this.f24660a.size();
    }

    public final Object getItem(int i2) {
        return this.f24660a.get(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0139  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        /*
            r8 = this;
            r0 = 0
            if (r10 != 0) goto L_0x0045
            android.view.LayoutInflater r10 = r8.f24662c
            int r1 = com.travel.flight.R.layout.pre_f_layout_flight_offer_item
            android.view.View r10 = r10.inflate(r1, r11, r0)
            com.travel.flight.flightticket.a.i$a r11 = new com.travel.flight.flightticket.a.i$a
            r11.<init>(r8, r0)
            int r1 = com.travel.flight.R.id.linearlyt_flight_offer_container
            android.view.View r1 = r10.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r11.f24668a = r1
            android.widget.LinearLayout r1 = r11.f24668a
            com.travel.flight.flightticket.a.i$1 r2 = new com.travel.flight.flightticket.a.i$1
            r2.<init>(r11)
            r1.setOnClickListener(r2)
            int r1 = com.travel.flight.R.id.txt_flight_offer_radio_icon
            android.view.View r1 = r10.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r11.f24670c = r1
            int r1 = com.travel.flight.R.id.txt_flight_offer_promo_msg
            android.view.View r1 = r10.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r11.f24669b = r1
            int r1 = com.travel.flight.R.id.offer_amount
            android.view.View r1 = r10.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r11.f24671d = r1
            r10.setTag(r11)
        L_0x0045:
            java.lang.Object r11 = r10.getTag()
            com.travel.flight.flightticket.a.i$a r11 = (com.travel.flight.flightticket.a.i.a) r11
            java.util.List<com.travel.flight.pojo.flightticket.CJRFlightOfferCode> r1 = r8.f24660a
            java.lang.Object r9 = r1.get(r9)
            com.travel.flight.pojo.flightticket.CJRFlightOfferCode r9 = (com.travel.flight.pojo.flightticket.CJRFlightOfferCode) r9
            android.widget.LinearLayout r1 = r11.f24668a
            java.lang.String r2 = r9.getCode()
            r1.setTag(r2)
            java.lang.String r1 = r9.getCode()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0072
            android.widget.TextView r1 = r11.f24670c
            java.lang.String r3 = r9.getCode()
            r1.setText(r3)
            goto L_0x0077
        L_0x0072:
            android.widget.TextView r1 = r11.f24670c
            r1.setText(r2)
        L_0x0077:
            r1 = 0
            java.lang.String r3 = r9.getSavingsPrice()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0087
            java.lang.String r1 = r9.getSavingsPrice()
            goto L_0x0095
        L_0x0087:
            java.lang.String r3 = r9.getmTotalSaving()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0095
            java.lang.String r1 = r9.getmTotalSaving()
        L_0x0095:
            r3 = 0
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00a2 }
            if (r5 != 0) goto L_0x00a2
            double r5 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00a3
        L_0x00a2:
            r5 = r3
        L_0x00a3:
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x00bc
            android.widget.TextView r3 = r11.f24671d
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r4 = "Save ₹"
            java.lang.String r1 = r4.concat(r1)
            r3.setText(r1)
            android.widget.TextView r1 = r11.f24671d
            r1.setVisibility(r0)
            goto L_0x00c3
        L_0x00bc:
            android.widget.TextView r1 = r11.f24671d
            r3 = 8
            r1.setVisibility(r3)
        L_0x00c3:
            java.lang.String r1 = r9.getOfferText()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0139
            java.lang.String r1 = r9.getTerms()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x00e1
            android.widget.TextView r11 = r11.f24669b
            java.lang.String r9 = r9.getOfferText()
            r11.setText(r9)
            goto L_0x013e
        L_0x00e1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r9.getOfferText()
            r1.append(r2)
            java.lang.String r2 = " "
            r1.append(r2)
            android.content.Context r2 = r8.f24663d
            int r3 = com.travel.flight.R.string.view_t_and_c
            java.lang.String r2 = r2.getString(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.text.SpannableString r2 = new android.text.SpannableString
            r2.<init>(r1)
            com.travel.flight.flightticket.a.i$2 r3 = new com.travel.flight.flightticket.a.i$2
            r3.<init>()
            r1.length()
            java.lang.String r4 = "T&C"
            r1.lastIndexOf(r4)
            int r4 = r1.lastIndexOf(r4)
            int r1 = r1.length()
            r5 = 33
            r2.setSpan(r3, r4, r1, r5)
            android.widget.TextView r1 = r11.f24669b
            r1.setText(r2)
            android.widget.TextView r1 = r11.f24669b
            android.text.method.MovementMethod r2 = android.text.method.LinkMovementMethod.getInstance()
            r1.setMovementMethod(r2)
            android.widget.TextView r1 = r11.f24669b
            r1.setHighlightColor(r0)
            android.widget.TextView r11 = r11.f24669b
            r11.setTag(r9)
            goto L_0x013e
        L_0x0139:
            android.widget.TextView r9 = r11.f24669b
            r9.setText(r2)
        L_0x013e:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.a.i.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        LinearLayout f24668a;

        /* renamed from: b  reason: collision with root package name */
        TextView f24669b;

        /* renamed from: c  reason: collision with root package name */
        TextView f24670c;

        /* renamed from: d  reason: collision with root package name */
        TextView f24671d;

        private a() {
        }

        /* synthetic */ a(i iVar, byte b2) {
            this();
        }
    }

    static /* synthetic */ void b(i iVar) {
        try {
            HashMap hashMap = new HashMap();
            b.a();
            b.b().a("flights_review_promo_tnc_clicked", (Map<String, Object>) hashMap, iVar.f24663d);
        } catch (Exception unused) {
        }
    }
}
