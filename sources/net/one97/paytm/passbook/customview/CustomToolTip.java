package net.one97.paytm.passbook.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;

public final class CustomToolTip extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f57171a;

    /* renamed from: b  reason: collision with root package name */
    private int f57172b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f57173c;

    private View a(int i2) {
        if (this.f57173c == null) {
            this.f57173c = new HashMap();
        }
        View view = (View) this.f57173c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f57173c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomToolTip(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomToolTip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
        k.c(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomToolTip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pass_sa_chart_popup, this, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…chart_popup, this, false)");
        this.f57171a = inflate;
        View view = this.f57171a;
        if (view == null) {
            k.a("mView");
        }
        addView(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x011d, code lost:
        r6 = r6.getDistribution();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int[] r8, java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r9, int r10, net.one97.paytm.passbook.spendanalytics.c.a r11, com.paytm.utility.RoboTextView r12, java.lang.String r13) {
        /*
            r7 = this;
            java.lang.String r0 = "chartPositions"
            kotlin.g.b.k.c(r8, r0)
            java.lang.String r0 = "amountList"
            kotlin.g.b.k.c(r9, r0)
            java.lang.String r0 = "spendAnalyticsPresenter"
            kotlin.g.b.k.c(r11, r0)
            java.lang.String r11 = "tvAmtSpent"
            kotlin.g.b.k.c(r12, r11)
            java.lang.String r11 = "chartType"
            kotlin.g.b.k.c(r13, r11)
            android.content.Context r11 = r7.getContext()
            int r0 = net.one97.paytm.passbook.R.drawable.pass_tooltip_bg
            android.graphics.drawable.Drawable r11 = androidx.core.content.b.a((android.content.Context) r11, (int) r0)
            r0 = 170(0xaa, float:2.38E-43)
            int r0 = net.one97.paytm.passbook.mapping.a.c((int) r0)
            r1 = 1
            r2 = r8[r1]
            int r2 = r2 - r0
            java.lang.String r3 = "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams"
            java.lang.String r4 = "mView"
            r5 = 0
            if (r2 < 0) goto L_0x005a
            android.view.ViewGroup$LayoutParams r2 = r7.getLayoutParams()
            if (r2 == 0) goto L_0x0054
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r2 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r2
            r6 = r8[r1]
            int r6 = r6 - r0
            r2.topMargin = r6
            android.view.View r0 = r7.f57171a
            if (r0 != 0) goto L_0x0048
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0048:
            int r2 = net.one97.paytm.passbook.R.id.tvPopupCategory
            android.view.View r0 = r0.findViewById(r2)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            r0.setPadding(r5, r5, r5, r5)
            goto L_0x0097
        L_0x0054:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r3)
            throw r8
        L_0x005a:
            android.view.ViewGroup$LayoutParams r11 = r7.getLayoutParams()
            if (r11 == 0) goto L_0x030a
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r11 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r11
            r0 = r8[r1]
            r2 = 1124204544(0x43020000, float:130.0)
            android.content.Context r6 = r7.getContext()
            int r2 = net.one97.paytm.passbook.utility.c.a(r2, r6)
            int r0 = r0 + r2
            r11.topMargin = r0
            android.content.Context r11 = r7.getContext()
            int r0 = net.one97.paytm.passbook.R.drawable.pass_tooltip_bg_flipped
            android.graphics.drawable.Drawable r11 = androidx.core.content.b.a((android.content.Context) r11, (int) r0)
            android.view.View r0 = r7.f57171a
            if (r0 != 0) goto L_0x0082
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0082:
            int r2 = net.one97.paytm.passbook.R.id.tvPopupCategory
            android.view.View r0 = r0.findViewById(r2)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            r2 = 1092616192(0x41200000, float:10.0)
            android.content.Context r6 = r7.getContext()
            int r2 = net.one97.paytm.passbook.mapping.a.a((float) r2, (android.content.Context) r6)
            r0.setPadding(r5, r2, r5, r5)
        L_0x0097:
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            if (r0 == 0) goto L_0x0304
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r0 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r0
            r2 = 1096810496(0x41600000, float:14.0)
            android.content.Context r3 = r7.getContext()
            int r2 = net.one97.paytm.passbook.utility.c.a(r2, r3)
            r0.leftMargin = r2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r2 = r8[r5]
            r0.append(r2)
            java.lang.String r2 = "--"
            r0.append(r2)
            r8 = r8[r1]
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            com.paytm.utility.q.b(r8)
            int r8 = android.os.Build.VERSION.SDK_INT
            r0 = 16
            if (r8 >= r0) goto L_0x00df
            android.view.View r8 = r7.f57171a
            if (r8 != 0) goto L_0x00d3
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00d3:
            int r0 = net.one97.paytm.passbook.R.id.rootRl
            android.view.View r8 = r8.findViewById(r0)
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            r8.setBackgroundDrawable(r11)
            goto L_0x00f1
        L_0x00df:
            android.view.View r8 = r7.f57171a
            if (r8 != 0) goto L_0x00e6
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00e6:
            int r0 = net.one97.paytm.passbook.R.id.rootRl
            android.view.View r8 = r8.findViewById(r0)
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            r8.setBackground(r11)
        L_0x00f1:
            java.lang.String r8 = "money_spent_chart"
            r11 = r8
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = r13.contentEquals(r11)
            java.lang.String r0 = "%"
            java.lang.String r1 = " "
            java.lang.String r2 = "tvPopupCategory"
            java.lang.String r3 = "money_received_chart"
            r4 = 0
            if (r11 == 0) goto L_0x0149
            int r11 = net.one97.paytm.passbook.R.id.tvPopupCategory
            android.view.View r11 = r7.a(r11)
            com.paytm.utility.RoboTextView r11 = (com.paytm.utility.RoboTextView) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Object r6 = r9.get(r10)
            net.one97.paytm.passbook.spendanalytics.model.Response r6 = (net.one97.paytm.passbook.spendanalytics.model.Response) r6
            if (r6 == 0) goto L_0x0128
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r6 = r6.getDistribution()
            if (r6 == 0) goto L_0x0128
            java.lang.String r6 = r6.getKey()
            goto L_0x0129
        L_0x0128:
            r6 = r4
        L_0x0129:
            r2.append(r6)
            r2.append(r1)
            java.util.ArrayList r12 = net.one97.paytm.passbook.spendanalytics.c.a.a((java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response>) r9, (com.paytm.utility.RoboTextView) r12)
            java.lang.Object r12 = r12.get(r10)
            java.lang.String r12 = (java.lang.String) r12
            r2.append(r12)
            r2.append(r0)
            java.lang.String r12 = r2.toString()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r11.setText(r12)
            goto L_0x019b
        L_0x0149:
            r11 = r3
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = r13.contentEquals(r11)
            if (r11 == 0) goto L_0x019b
            int r11 = net.one97.paytm.passbook.R.id.tvPopupCategory
            android.view.View r11 = r7.a(r11)
            com.paytm.utility.RoboTextView r11 = (com.paytm.utility.RoboTextView) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            net.one97.paytm.passbook.spendanalytics.a r6 = net.one97.paytm.passbook.spendanalytics.a.f58478a
            java.lang.Object r6 = r9.get(r10)
            net.one97.paytm.passbook.spendanalytics.model.Response r6 = (net.one97.paytm.passbook.spendanalytics.model.Response) r6
            if (r6 == 0) goto L_0x0177
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r6 = r6.getDistribution()
            if (r6 == 0) goto L_0x0177
            java.lang.String r6 = r6.getKey()
            goto L_0x0178
        L_0x0177:
            r6 = r4
        L_0x0178:
            java.lang.String r6 = net.one97.paytm.passbook.spendanalytics.a.e(r6)
            r2.append(r6)
            r2.append(r1)
            java.util.ArrayList r12 = net.one97.paytm.passbook.spendanalytics.c.a.a((java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response>) r9, (com.paytm.utility.RoboTextView) r12)
            java.lang.Object r12 = r12.get(r10)
            java.lang.String r12 = (java.lang.String) r12
            r2.append(r12)
            r2.append(r0)
            java.lang.String r12 = r2.toString()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r11.setText(r12)
        L_0x019b:
            int r11 = net.one97.paytm.passbook.R.id.tvPopupAmount
            android.view.View r11 = r7.a(r11)
            com.paytm.utility.RoboTextView r11 = (com.paytm.utility.RoboTextView) r11
            java.lang.String r12 = "tvPopupAmount"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "₹"
            r12.<init>(r0)
            java.lang.Object r0 = r9.get(r10)
            net.one97.paytm.passbook.spendanalytics.model.Response r0 = (net.one97.paytm.passbook.spendanalytics.model.Response) r0
            if (r0 == 0) goto L_0x01c2
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r0 = r0.getDistribution()
            if (r0 == 0) goto L_0x01c2
            java.lang.String r0 = r0.getSum()
            goto L_0x01c3
        L_0x01c2:
            r0 = r4
        L_0x01c3:
            java.lang.String r0 = net.one97.paytm.passbook.utility.c.c(r0)
            java.lang.String r1 = "CJRAppUtils.getFormatted…tion]?.distribution?.sum)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r1 = ".00"
            java.lang.String r2 = ""
            java.lang.String r0 = kotlin.m.p.a(r0, r1, r2, r5)
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r11.setText(r12)
            java.lang.Object r11 = r9.get(r10)
            net.one97.paytm.passbook.spendanalytics.model.Response r11 = (net.one97.paytm.passbook.spendanalytics.model.Response) r11
            if (r11 == 0) goto L_0x020b
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r11 = r11.getDistribution()
            if (r11 == 0) goto L_0x020b
            java.lang.String r11 = r11.getCnt()
            if (r11 == 0) goto L_0x020b
            java.lang.String r12 = "1"
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r11 == 0) goto L_0x0203
            boolean r11 = r11.contentEquals(r12)
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            goto L_0x020c
        L_0x0203:
            kotlin.u r8 = new kotlin.u
            java.lang.String r9 = "null cannot be cast to non-null type java.lang.String"
            r8.<init>(r9)
            throw r8
        L_0x020b:
            r11 = r4
        L_0x020c:
            if (r11 != 0) goto L_0x0211
            kotlin.g.b.k.a()
        L_0x0211:
            boolean r11 = r11.booleanValue()
            java.lang.String r12 = "tvPopupTotalPayments"
            if (r11 == 0) goto L_0x0244
            int r11 = net.one97.paytm.passbook.R.id.tvPopupTotalPayments
            android.view.View r11 = r7.a(r11)
            com.paytm.utility.RoboTextView r11 = (com.paytm.utility.RoboTextView) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            java.lang.Object r12 = r9.get(r10)
            net.one97.paytm.passbook.spendanalytics.model.Response r12 = (net.one97.paytm.passbook.spendanalytics.model.Response) r12
            if (r12 == 0) goto L_0x0237
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r12 = r12.getDistribution()
            if (r12 == 0) goto L_0x0237
            java.lang.String r12 = r12.getCnt()
            goto L_0x0238
        L_0x0237:
            r12 = r4
        L_0x0238:
            java.lang.String r0 = " Transfer"
            java.lang.String r12 = kotlin.g.b.k.a((java.lang.String) r12, (java.lang.Object) r0)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r11.setText(r12)
            goto L_0x026e
        L_0x0244:
            int r11 = net.one97.paytm.passbook.R.id.tvPopupTotalPayments
            android.view.View r11 = r7.a(r11)
            com.paytm.utility.RoboTextView r11 = (com.paytm.utility.RoboTextView) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            java.lang.Object r12 = r9.get(r10)
            net.one97.paytm.passbook.spendanalytics.model.Response r12 = (net.one97.paytm.passbook.spendanalytics.model.Response) r12
            if (r12 == 0) goto L_0x0262
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r12 = r12.getDistribution()
            if (r12 == 0) goto L_0x0262
            java.lang.String r12 = r12.getCnt()
            goto L_0x0263
        L_0x0262:
            r12 = r4
        L_0x0263:
            java.lang.String r0 = " Transfers"
            java.lang.String r12 = kotlin.g.b.k.a((java.lang.String) r12, (java.lang.Object) r0)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r11.setText(r12)
        L_0x026e:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = r13.contentEquals(r8)
            if (r8 == 0) goto L_0x02c8
            java.lang.Object r8 = r9.get(r10)
            net.one97.paytm.passbook.spendanalytics.model.Response r8 = (net.one97.paytm.passbook.spendanalytics.model.Response) r8
            if (r8 == 0) goto L_0x0289
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r8 = r8.getDistribution()
            if (r8 == 0) goto L_0x0289
            java.lang.String r8 = r8.getLogo()
            goto L_0x028a
        L_0x0289:
            r8 = r4
        L_0x028a:
            if (r8 == 0) goto L_0x02b2
            com.squareup.picasso.w r8 = com.squareup.picasso.w.a()
            java.lang.Object r9 = r9.get(r10)
            net.one97.paytm.passbook.spendanalytics.model.Response r9 = (net.one97.paytm.passbook.spendanalytics.model.Response) r9
            if (r9 == 0) goto L_0x02a2
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r9 = r9.getDistribution()
            if (r9 == 0) goto L_0x02a2
            java.lang.String r4 = r9.getLogo()
        L_0x02a2:
            com.squareup.picasso.aa r8 = r8.a((java.lang.String) r4)
            int r9 = net.one97.paytm.passbook.R.id.ivPopupImage
            android.view.View r9 = r7.a(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r8.a((android.widget.ImageView) r9)
            return
        L_0x02b2:
            com.squareup.picasso.w r8 = com.squareup.picasso.w.a()
            java.lang.String r9 = "https://s3.ap-south-1.amazonaws.com/paytm-wallet-images/Wallet_Images/icOthers.png"
            com.squareup.picasso.aa r8 = r8.a((java.lang.String) r9)
            int r9 = net.one97.paytm.passbook.R.id.ivPopupImage
            android.view.View r9 = r7.a(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r8.a((android.widget.ImageView) r9)
            return
        L_0x02c8:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r8 = r13.contentEquals(r3)
            if (r8 == 0) goto L_0x0303
            net.one97.paytm.passbook.spendanalytics.a r8 = net.one97.paytm.passbook.spendanalytics.a.f58478a
            java.lang.Object r8 = r9.get(r10)
            net.one97.paytm.passbook.spendanalytics.model.Response r8 = (net.one97.paytm.passbook.spendanalytics.model.Response) r8
            if (r8 == 0) goto L_0x02e4
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r8 = r8.getDistribution()
            if (r8 == 0) goto L_0x02e4
            java.lang.String r4 = r8.getKey()
        L_0x02e4:
            java.lang.Integer r8 = net.one97.paytm.passbook.spendanalytics.a.f(r4)
            if (r8 == 0) goto L_0x0303
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            com.squareup.picasso.w r9 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r8 = r9.a((int) r8)
            int r9 = net.one97.paytm.passbook.R.id.ivPopupImage
            android.view.View r9 = r7.a(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r8.a((android.widget.ImageView) r9)
        L_0x0303:
            return
        L_0x0304:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r3)
            throw r8
        L_0x030a:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r3)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.customview.CustomToolTip.a(int[], java.util.ArrayList, int, net.one97.paytm.passbook.spendanalytics.c.a, com.paytm.utility.RoboTextView, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f57172b = View.MeasureSpec.getSize(i3);
    }
}
