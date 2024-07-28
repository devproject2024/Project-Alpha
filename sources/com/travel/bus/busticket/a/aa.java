package com.travel.bus.busticket.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.paytm.utility.q;
import com.travel.bus.pojo.busticket.CJRBusSearchCancellationPolicy;
import java.util.ArrayList;

public final class aa extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f21536a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CJRBusSearchCancellationPolicy> f21537b;

    /* renamed from: c  reason: collision with root package name */
    private String f21538c;

    /* renamed from: d  reason: collision with root package name */
    private Context f21539d;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public aa(Context context, ArrayList<CJRBusSearchCancellationPolicy> arrayList, String str) {
        this.f21536a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f21537b = arrayList;
        this.f21538c = a(str);
        this.f21539d = context;
    }

    private static String a(String str) {
        try {
            return String.valueOf(Double.valueOf(Double.parseDouble(str)).intValue());
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return str;
        }
    }

    public final int getCount() {
        ArrayList<CJRBusSearchCancellationPolicy> arrayList = this.f21537b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final Object getItem(int i2) {
        return this.f21537b.get(i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.travel.bus.busticket.a.aa$a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r17, android.view.View r18, android.view.ViewGroup r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            if (r18 != 0) goto L_0x0036
            android.view.LayoutInflater r2 = r0.f21536a
            int r3 = com.travel.bus.R.layout.pre_b_cancellation_policy_list_item
            r4 = 0
            android.view.View r2 = r2.inflate(r3, r4)
            com.travel.bus.busticket.a.aa$a r3 = new com.travel.bus.busticket.a.aa$a
            r3.<init>()
            int r4 = com.travel.bus.R.id.txt_departure_heading
            android.view.View r4 = r2.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.f21540a = r4
            int r4 = com.travel.bus.R.id.txt_policy_heading
            android.view.View r4 = r2.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.f21541b = r4
            int r4 = com.travel.bus.R.id.txt_refund_amount
            android.view.View r4 = r2.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.f21542c = r4
            r2.setTag(r3)
            goto L_0x003f
        L_0x0036:
            java.lang.Object r2 = r18.getTag()
            r3 = r2
            com.travel.bus.busticket.a.aa$a r3 = (com.travel.bus.busticket.a.aa.a) r3
            r2 = r18
        L_0x003f:
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchCancellationPolicy> r4 = r0.f21537b
            java.lang.Object r4 = r4.get(r1)
            com.travel.bus.pojo.busticket.CJRBusSearchCancellationPolicy r4 = (com.travel.bus.pojo.busticket.CJRBusSearchCancellationPolicy) r4
            android.widget.TextView r5 = r3.f21540a
            java.lang.String r6 = ""
            r5.setText(r6)
            android.widget.TextView r5 = r3.f21541b
            r5.setText(r6)
            if (r4 == 0) goto L_0x01bc
            java.lang.String r5 = r4.getDeparture_heading()
            java.lang.String r7 = "sans-serif"
            r8 = 1095761920(0x41500000, float:13.0)
            java.lang.String r9 = "</b>"
            java.lang.String r10 = "<b>"
            java.lang.String r11 = "sans-serif-medium"
            r13 = 2
            if (r5 == 0) goto L_0x00bf
            java.lang.String r5 = r4.getDeparture_heading()
            if (r1 != 0) goto L_0x0098
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r10)
            r15.append(r5)
            r15.append(r9)
            java.lang.String r5 = r15.toString()
            android.widget.TextView r15 = r3.f21540a
            android.content.Context r12 = r0.f21539d
            int r14 = com.travel.bus.R.color.color_222222
            int r12 = androidx.core.content.b.c(r12, r14)
            r15.setTextColor(r12)
            android.widget.TextView r12 = r3.f21540a
            r12.setTextSize(r13, r8)
            android.widget.TextView r12 = r3.f21540a
            r14 = 0
            android.graphics.Typeface r15 = android.graphics.Typeface.create(r7, r14)
            r12.setTypeface(r15)
            goto L_0x00b6
        L_0x0098:
            r14 = 0
            android.widget.TextView r12 = r3.f21540a
            android.content.Context r15 = r0.f21539d
            int r8 = com.travel.bus.R.color.color_666666
            int r8 = androidx.core.content.b.c(r15, r8)
            r12.setTextColor(r8)
            android.widget.TextView r8 = r3.f21540a
            r12 = 1096810496(0x41600000, float:14.0)
            r8.setTextSize(r13, r12)
            android.widget.TextView r8 = r3.f21540a
            android.graphics.Typeface r12 = android.graphics.Typeface.create(r11, r14)
            r8.setTypeface(r12)
        L_0x00b6:
            android.widget.TextView r8 = r3.f21540a
            android.text.Spanned r5 = android.text.Html.fromHtml(r5)
            r8.setText(r5)
        L_0x00bf:
            java.lang.String r5 = r4.getPolicy_heading()
            if (r5 == 0) goto L_0x0120
            java.lang.String r5 = r4.getPolicy_heading()
            if (r1 != 0) goto L_0x00f9
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r10)
            r8.append(r5)
            r8.append(r9)
            java.lang.String r5 = r8.toString()
            android.widget.TextView r8 = r3.f21541b
            android.content.Context r12 = r0.f21539d
            int r14 = com.travel.bus.R.color.color_222222
            int r12 = androidx.core.content.b.c(r12, r14)
            r8.setTextColor(r12)
            android.widget.TextView r8 = r3.f21541b
            r12 = 1095761920(0x41500000, float:13.0)
            r8.setTextSize(r13, r12)
            android.widget.TextView r8 = r3.f21541b
            r12 = 0
            android.graphics.Typeface r14 = android.graphics.Typeface.create(r7, r12)
            r8.setTypeface(r14)
            goto L_0x0117
        L_0x00f9:
            r12 = 0
            android.widget.TextView r8 = r3.f21541b
            android.content.Context r14 = r0.f21539d
            int r15 = com.travel.bus.R.color.color_666666
            int r14 = androidx.core.content.b.c(r14, r15)
            r8.setTextColor(r14)
            android.widget.TextView r8 = r3.f21541b
            android.graphics.Typeface r14 = android.graphics.Typeface.create(r11, r12)
            r8.setTypeface(r14)
            android.widget.TextView r8 = r3.f21541b
            r12 = 1096810496(0x41600000, float:14.0)
            r8.setTextSize(r13, r12)
        L_0x0117:
            android.widget.TextView r8 = r3.f21541b
            android.text.Spanned r5 = android.text.Html.fromHtml(r5)
            r8.setText(r5)
        L_0x0120:
            java.lang.String r5 = r0.f21538c
            boolean r5 = r5.equalsIgnoreCase(r6)
            if (r5 != 0) goto L_0x01bc
            android.content.Context r5 = r0.f21539d
            boolean r5 = r5 instanceof com.travel.bus.busticket.activity.AJRBusSelectSeatsActivity
            if (r5 == 0) goto L_0x0134
            android.widget.TextView r5 = r3.f21542c
            r8 = 0
            r5.setVisibility(r8)
        L_0x0134:
            android.widget.TextView r5 = r3.f21542c
            r5.setText(r6)
            if (r1 != 0) goto L_0x018b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r4 = r0.f21539d
            int r5 = com.travel.bus.R.string.refund_amount_text
            java.lang.String r4 = r4.getString(r5)
            r1.append(r4)
            java.lang.String r4 = "*"
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r10)
            r4.append(r1)
            r4.append(r9)
            java.lang.String r1 = r4.toString()
            android.widget.TextView r4 = r3.f21542c
            android.text.Spanned r1 = android.text.Html.fromHtml(r1)
            r4.setText(r1)
            android.widget.TextView r1 = r3.f21542c
            android.content.Context r4 = r0.f21539d
            int r5 = com.travel.bus.R.color.color_222222
            int r4 = androidx.core.content.b.c(r4, r5)
            r1.setTextColor(r4)
            android.widget.TextView r1 = r3.f21542c
            r4 = 1095761920(0x41500000, float:13.0)
            r1.setTextSize(r13, r4)
            android.widget.TextView r1 = r3.f21542c
            r5 = 0
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r7, r5)
            r1.setTypeface(r3)
            goto L_0x01bc
        L_0x018b:
            r5 = 0
            android.widget.TextView r1 = r3.f21542c
            android.content.Context r6 = r0.f21539d
            int r7 = com.travel.bus.R.color.color_666666
            int r6 = androidx.core.content.b.c(r6, r7)
            r1.setTextColor(r6)
            android.widget.TextView r1 = r3.f21542c
            android.graphics.Typeface r5 = android.graphics.Typeface.create(r11, r5)
            r1.setTypeface(r5)
            android.widget.TextView r1 = r3.f21542c
            r5 = 1096810496(0x41600000, float:14.0)
            r1.setTextSize(r13, r5)
            java.lang.String r1 = r4.getPolicy_heading()
            if (r1 == 0) goto L_0x01bc
            android.widget.TextView r1 = r3.f21542c
            java.lang.String r3 = r4.getPolicy_heading()
            java.lang.String r3 = r0.b(r3)
            r1.setText(r3)
        L_0x01bc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.a.aa.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    private String b(String str) {
        float f2;
        String str2;
        if (!str.equalsIgnoreCase("Refund Percentage") && str != null && (str2 = this.f21538c) != null && !str2.equalsIgnoreCase("")) {
            this.f21538c = this.f21538c.replaceAll("[\\-\\+\\.\\^:,]", "");
            if (str.matches(".*\\d+.*")) {
                if (str.contains("%")) {
                    str = str.replace("%", "");
                }
                try {
                    f2 = (Float.parseFloat(this.f21538c) * Float.parseFloat(str)) / 100.0f;
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
                return String.valueOf(f2);
            }
        }
        f2 = 0.0f;
        return String.valueOf(f2);
    }

    public class a {

        /* renamed from: a  reason: collision with root package name */
        TextView f21540a;

        /* renamed from: b  reason: collision with root package name */
        TextView f21541b;

        /* renamed from: c  reason: collision with root package name */
        TextView f21542c;

        public a() {
        }
    }
}
