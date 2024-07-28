package com.travel.flight.flightticket.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.flightticket.f.k;
import com.travel.flight.flightticket.j.b;
import com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData;
import java.util.List;

public final class c extends RecyclerView.a<RecyclerView.v> implements p {

    /* renamed from: a  reason: collision with root package name */
    private Context f24615a = this.f24619e;

    /* renamed from: b  reason: collision with root package name */
    private List<FlightSellingBundleResponseData> f24616b = this.f24618d;

    /* renamed from: c  reason: collision with root package name */
    private String f24617c;

    /* renamed from: d  reason: collision with root package name */
    private List<FlightSellingBundleResponseData> f24618d;

    /* renamed from: e  reason: collision with root package name */
    private Context f24619e;

    /* renamed from: f  reason: collision with root package name */
    private k f24620f;

    public c(List<FlightSellingBundleResponseData> list, Context context, k kVar, String str) {
        kotlin.g.b.k.c(list, "data");
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(kVar, "mIternaryActionListener");
        kotlin.g.b.k.c(str, "totalFare");
        this.f24618d = list;
        this.f24619e = context;
        this.f24620f = kVar;
        this.f24617c = str;
    }

    public final void a(int i2) {
        int size = this.f24618d.size() - 1;
        if (size >= 0) {
            int i3 = 0;
            while (true) {
                if (Integer.valueOf(i3).equals(Integer.valueOf(i2))) {
                    this.f24618d.get(i3).setSelected(!this.f24618d.get(i3).isSelected());
                    boolean isSelected = this.f24618d.get(i3).isSelected();
                    Intent intent = new Intent();
                    intent.putExtra("INTENT_EXTRA_BUNDLE_INFO", this.f24618d.get(i3));
                    this.f24620f.reviewIternaryActionClick("", intent, Boolean.FALSE, isSelected ? com.travel.flight.flightticket.d.c.ON_BUNDLE_SELECTED : com.travel.flight.flightticket.d.c.ON_BUNDLE_DESELECTED);
                } else if (this.f24618d.get(i3).isSelected()) {
                    this.f24618d.get(i3).setSelected(false);
                    Intent intent2 = new Intent();
                    intent2.putExtra("INTENT_EXTRA_BUNDLE_INFO", this.f24618d.get(i3));
                    this.f24620f.reviewIternaryActionClick("", intent2, Boolean.FALSE, com.travel.flight.flightticket.d.c.ON_BUNDLE_DESELECTED);
                }
                if (i3 == size) {
                    break;
                }
                i3++;
            }
        }
        notifyDataSetChanged();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        kotlin.g.b.k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f24615a).inflate(R.layout.pre_f_bundle_package_item, viewGroup, false);
        kotlin.g.b.k.a((Object) inflate, "view");
        return new b(inflate, this.f24615a, this);
    }

    public final int getItemCount() {
        List<FlightSellingBundleResponseData> list = this.f24616b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0217  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r10, int r11) {
        /*
            r9 = this;
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r10, r0)
            java.util.List<com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData> r0 = r9.f24616b
            if (r0 != 0) goto L_0x000c
            kotlin.g.b.k.a()
        L_0x000c:
            java.lang.Object r11 = r0.get(r11)
            com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData r11 = (com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData) r11
            if (r10 == 0) goto L_0x02b5
            com.travel.flight.flightticket.j.b r10 = (com.travel.flight.flightticket.j.b) r10
            boolean r0 = r11.isSelected()
            if (r0 == 0) goto L_0x0037
            android.widget.ImageView r0 = r10.f25113b
            android.content.Context r1 = r9.f24619e
            int r2 = com.travel.flight.R.drawable.ic_green_tick
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r2)
            r0.setBackground(r1)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r10.f25112a
            android.content.Context r1 = r9.f24619e
            int r2 = com.travel.flight.R.drawable.flight_rcr_with_5dp_radius_green
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r2)
            r0.setBackground(r1)
            goto L_0x0051
        L_0x0037:
            android.widget.ImageView r0 = r10.f25113b
            android.content.Context r1 = r9.f24619e
            int r2 = com.travel.flight.R.drawable.pre_f_flight_circle_with_grey_stroke
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r2)
            r0.setBackground(r1)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r10.f25112a
            android.content.Context r1 = r9.f24619e
            int r2 = com.travel.flight.R.drawable.flight_rounded_corner_rect_with_5dp_radius
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r2)
            r0.setBackground(r1)
        L_0x0051:
            java.lang.String r0 = r11.getImage_url()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0064
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r0 = 0
            goto L_0x0065
        L_0x0064:
            r0 = 1
        L_0x0065:
            if (r0 != 0) goto L_0x007c
            com.paytm.utility.b.b$a r0 = com.paytm.utility.b.b.f43744a
            android.content.Context r0 = r9.f24619e
            com.paytm.utility.b.b$a$a r0 = com.paytm.utility.b.b.a.a(r0)
            java.lang.String r3 = r11.getImage_url()
            r0.f43753a = r3
            android.widget.ImageView r3 = r10.f25116e
            r4 = 0
            r5 = 2
            com.paytm.utility.b.b.a.C0750a.a(r0, r3, r4, r5)
        L_0x007c:
            java.lang.String r0 = r11.getTitle()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x008d
            int r0 = r0.length()
            if (r0 != 0) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            r0 = 0
            goto L_0x008e
        L_0x008d:
            r0 = 1
        L_0x008e:
            if (r0 != 0) goto L_0x009b
            android.widget.TextView r0 = r10.f25114c
            java.lang.String r3 = r11.getTitle()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
        L_0x009b:
            java.lang.String r0 = r11.getProduct_subtitle()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00ac
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00aa
            goto L_0x00ac
        L_0x00aa:
            r0 = 0
            goto L_0x00ad
        L_0x00ac:
            r0 = 1
        L_0x00ad:
            if (r0 != 0) goto L_0x00ba
            android.widget.TextView r0 = r10.f25115d
            java.lang.String r3 = r11.getProduct_subtitle()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
        L_0x00ba:
            java.util.List r0 = r11.getProduct_description()
            r3 = 4
            if (r0 == 0) goto L_0x017d
            java.util.List r0 = r11.getProduct_description()
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x00d2
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00d0
            goto L_0x00d2
        L_0x00d0:
            r0 = 0
            goto L_0x00d3
        L_0x00d2:
            r0 = 1
        L_0x00d3:
            r0 = r0 ^ r2
            java.util.List r4 = r11.getProduct_description()
            if (r4 != 0) goto L_0x00dd
            kotlin.g.b.k.a()
        L_0x00dd:
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r2
            r0 = r0 & r4
            if (r0 == 0) goto L_0x017d
            android.widget.LinearLayout r0 = r10.f25119h
            r0.setVisibility(r1)
            java.util.List r0 = r11.getProduct_description()
            if (r0 != 0) goto L_0x00f5
            kotlin.g.b.k.a()
        L_0x00f5:
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x012f
            java.util.List r0 = r11.getProduct_description()
            if (r0 != 0) goto L_0x0104
            kotlin.g.b.k.a()
        L_0x0104:
            java.lang.Object r0 = r0.get(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0112
            r0 = 1
            goto L_0x0113
        L_0x0112:
            r0 = 0
        L_0x0113:
            if (r0 != 0) goto L_0x012f
            android.widget.LinearLayout r0 = r10.f25120i
            r0.setVisibility(r1)
            android.widget.TextView r0 = r10.f25117f
            java.util.List r4 = r11.getProduct_description()
            if (r4 != 0) goto L_0x0125
            kotlin.g.b.k.a()
        L_0x0125:
            java.lang.Object r4 = r4.get(r1)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
            goto L_0x0134
        L_0x012f:
            android.widget.LinearLayout r0 = r10.f25120i
            r0.setVisibility(r3)
        L_0x0134:
            java.util.List r0 = r11.getProduct_description()
            if (r0 != 0) goto L_0x013d
            kotlin.g.b.k.a()
        L_0x013d:
            int r0 = r0.size()
            if (r0 <= r2) goto L_0x0177
            java.util.List r0 = r11.getProduct_description()
            if (r0 != 0) goto L_0x014c
            kotlin.g.b.k.a()
        L_0x014c:
            java.lang.Object r0 = r0.get(r2)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x015a
            r0 = 1
            goto L_0x015b
        L_0x015a:
            r0 = 0
        L_0x015b:
            if (r0 != 0) goto L_0x0177
            android.widget.LinearLayout r0 = r10.j
            r0.setVisibility(r1)
            android.widget.TextView r0 = r10.f25118g
            java.util.List r3 = r11.getProduct_description()
            if (r3 != 0) goto L_0x016d
            kotlin.g.b.k.a()
        L_0x016d:
            java.lang.Object r3 = r3.get(r2)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            goto L_0x0182
        L_0x0177:
            android.widget.LinearLayout r0 = r10.j
            r0.setVisibility(r3)
            goto L_0x0182
        L_0x017d:
            android.widget.LinearLayout r0 = r10.f25119h
            r0.setVisibility(r3)
        L_0x0182:
            double r3 = r11.getProduct_mrp()
            r5 = 0
            r0 = 33
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0217
            android.widget.TextView r3 = r10.k
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            android.content.Context r5 = r9.f24615a
            android.content.res.Resources r5 = r5.getResources()
            int r6 = com.travel.flight.R.string.save
            java.lang.String r5 = r5.getString(r6)
            r4.append(r5)
            java.lang.String r5 = " "
            r4.append(r5)
            android.content.Context r5 = r9.f24615a
            android.content.res.Resources r5 = r5.getResources()
            int r6 = com.travel.flight.R.string.rupee_symbol
            java.lang.String r5 = r5.getString(r6)
            r4.append(r5)
            double r5 = r11.getProduct_mrp()
            double r7 = r11.getProduct_selling_price()
            double r5 = r5 - r7
            java.lang.String r5 = com.travel.flight.utils.c.a((double) r5)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.content.Context r4 = r9.f24615a
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.travel.flight.R.string.rupee_symbol
            java.lang.String r4 = r4.getString(r5)
            r3.append(r4)
            double r4 = r11.getProduct_mrp()
            java.lang.String r6 = r9.f24617c
            double r6 = java.lang.Double.parseDouble(r6)
            double r4 = r4 + r6
            java.lang.String r4 = com.travel.flight.utils.c.a((double) r4)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.text.SpannableStringBuilder r4 = new android.text.SpannableStringBuilder
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r4.<init>(r5)
            android.text.style.StrikethroughSpan r5 = new android.text.style.StrikethroughSpan
            r5.<init>()
            int r3 = r3.length()
            r4.setSpan(r5, r1, r3, r0)
            android.widget.TextView r3 = r10.m
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            goto L_0x023d
        L_0x0217:
            android.widget.TextView r3 = r10.k
            android.content.Context r4 = r9.f24615a
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.travel.flight.R.string.flight_get_for_free
            java.lang.String r4 = r4.getString(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            android.widget.TextView r3 = r10.m
            android.content.Context r4 = r9.f24615a
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.travel.flight.R.string.flight_free
            java.lang.String r4 = r4.getString(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
        L_0x023d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.content.Context r4 = r9.f24615a
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.travel.flight.R.string.rupee_symbol
            java.lang.String r4 = r4.getString(r5)
            r3.append(r4)
            double r4 = r11.getProduct_selling_price()
            java.lang.String r11 = r9.f24617c
            double r6 = java.lang.Double.parseDouble(r11)
            double r4 = r4 + r6
            java.lang.String r11 = com.travel.flight.utils.c.a((double) r4)
            r3.append(r11)
            java.lang.String r11 = r3.toString()
            android.text.SpannableString r3 = new android.text.SpannableString
            r4 = r11
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.<init>(r4)
            android.text.Spannable r3 = (android.text.Spannable) r3
            java.lang.String r4 = "sans-serif"
            android.graphics.Typeface r4 = android.graphics.Typeface.create(r4, r1)
            java.lang.String r5 = "Typeface.create(\"sans-serif\", Typeface.NORMAL)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.text.style.ForegroundColorSpan r5 = new android.text.style.ForegroundColorSpan
            android.content.Context r6 = r9.f24619e
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.travel.flight.R.color.black
            int r6 = r6.getColor(r7)
            r5.<init>(r6)
            int r6 = r11.length()
            r3.setSpan(r5, r2, r6, r0)
            com.paytm.utility.CustomTypefaceSpan r5 = new com.paytm.utility.CustomTypefaceSpan
            java.lang.String r6 = ""
            r5.<init>(r6, r4)
            int r11 = r11.length()
            r3.setSpan(r5, r2, r11, r0)
            com.travel.flight.span.TopAlignProportionalSpan r11 = new com.travel.flight.span.TopAlignProportionalSpan
            r4 = 1058642330(0x3f19999a, float:0.6)
            r11.<init>(r4)
            r3.setSpan(r11, r1, r2, r0)
            android.widget.TextView r10 = r10.l
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r10.setText(r3)
            return
        L_0x02b5:
            kotlin.u r10 = new kotlin.u
            java.lang.String r11 = "null cannot be cast to non-null type com.travel.flight.flightticket.viewholders.CJRFRBundlePackageItemViewHolder"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.a.c.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }
}
