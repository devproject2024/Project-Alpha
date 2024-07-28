package net.one97.paytm.o2o.movies.moviepass.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;

public final class CJRMoviePassOrderSummaryDetailsView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f75628a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f75629b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f75630c;

    /* renamed from: d  reason: collision with root package name */
    private String f75631d;

    /* renamed from: e  reason: collision with root package name */
    private CJROrderedCart f75632e;

    /* renamed from: f  reason: collision with root package name */
    private View.OnClickListener f75633f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f75634g;

    private View a(int i2) {
        if (this.f75634g == null) {
            this.f75634g = new HashMap();
        }
        View view = (View) this.f75634g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f75634g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final Context getMContext() {
        return this.f75629b;
    }

    public final LinearLayout getMParentView() {
        return this.f75630c;
    }

    public final void setMParentView(LinearLayout linearLayout) {
        this.f75630c = linearLayout;
    }

    public final String getMStatus() {
        return this.f75631d;
    }

    public final void setMStatus(String str) {
        k.c(str, "<set-?>");
        this.f75631d = str;
    }

    public final CJROrderedCart getMItem() {
        return this.f75632e;
    }

    public final void setMItem(CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "<set-?>");
        this.f75632e = cJROrderedCart;
    }

    public final View.OnClickListener getMClickListener() {
        return this.f75633f;
    }

    public final void setMClickListener(View.OnClickListener onClickListener) {
        k.c(onClickListener, "<set-?>");
        this.f75633f = onClickListener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRMoviePassOrderSummaryDetailsView(Context context, LinearLayout linearLayout, String str, CJROrderedCart cJROrderedCart, View.OnClickListener onClickListener) {
        super(context);
        k.c(context, "mContext");
        k.c(str, "mStatus");
        k.c(cJROrderedCart, "mItem");
        k.c(onClickListener, "mClickListener");
        this.f75629b = context;
        this.f75630c = linearLayout;
        this.f75631d = str;
        this.f75632e = cJROrderedCart;
        this.f75633f = onClickListener;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|(1:4)(1:5)|6|7|(3:9|10|(2:12|(1:14)(7:15|(1:17)|66|67|(1:69)|70|(2:72|(1:83)(2:76|79))(1:81))))|18|(20:20|(1:22)(1:23)|24|25|(1:27)(1:28)|29|(1:31)(1:32)|33|(1:35)(1:36)|37|(3:39|40|41)(1:42)|43|44|(2:(1:47)(1:48)|49)(1:50)|51|(1:53)|54|(2:56|(2:57|(1:59)(1:78)))(0)|60|(1:62)(1:63))|66|67|(0)|70|(0)(0)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:64|65) */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r0 = (net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView) a(net.one97.paytm.o2o.movies.R.id.tnc_view);
        kotlin.g.b.k.a((java.lang.Object) r0, "tnc_view");
        r0.setVisibility(8);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x01ee */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x01fc */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0200 A[Catch:{ Exception -> 0x0259 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0207 A[Catch:{ Exception -> 0x0259 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r13 = this;
            java.lang.String r0 = "SUCCESS"
            java.lang.String r1 = "tnc_view"
            android.content.Context r2 = r13.f75629b     // Catch:{ Exception -> 0x0259 }
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)     // Catch:{ Exception -> 0x0259 }
            r13.f75628a = r2     // Catch:{ Exception -> 0x0259 }
            android.view.LayoutInflater r2 = r13.f75628a     // Catch:{ Exception -> 0x0259 }
            r3 = 0
            if (r2 == 0) goto L_0x001b
            int r4 = net.one97.paytm.o2o.movies.R.layout.mp_order_summary_detail     // Catch:{ Exception -> 0x0259 }
            r5 = r13
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5     // Catch:{ Exception -> 0x0259 }
            android.view.View r2 = r2.inflate(r4, r5)     // Catch:{ Exception -> 0x0259 }
            goto L_0x001c
        L_0x001b:
            r2 = r3
        L_0x001c:
            java.lang.String r4 = r13.f75631d     // Catch:{ Exception -> 0x0259 }
            r5 = 1
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r0, (boolean) r5)     // Catch:{ Exception -> 0x0259 }
            java.lang.String r6 = "success_pending_detail"
            java.lang.String r7 = "failure_detail"
            r8 = 0
            r9 = 8
            if (r4 != 0) goto L_0x007b
            java.lang.String r4 = r13.f75631d     // Catch:{ Exception -> 0x0259 }
            java.lang.String r10 = "PROCESSING"
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r10, (boolean) r5)     // Catch:{ Exception -> 0x0259 }
            if (r4 != 0) goto L_0x007b
            java.lang.String r4 = r13.f75631d     // Catch:{ Exception -> 0x0259 }
            java.lang.String r10 = "In Process"
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r10, (boolean) r5)     // Catch:{ Exception -> 0x0259 }
            if (r4 == 0) goto L_0x0041
            goto L_0x007b
        L_0x0041:
            java.lang.String r0 = r13.f75631d     // Catch:{ Exception -> 0x0259 }
            java.lang.String r1 = "Failed"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)     // Catch:{ Exception -> 0x0259 }
            if (r0 == 0) goto L_0x01fc
            int r0 = net.one97.paytm.o2o.movies.R.id.failure_detail     // Catch:{ Exception -> 0x0259 }
            android.view.View r0 = r13.a(r0)     // Catch:{ Exception -> 0x0259 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x0259 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)     // Catch:{ Exception -> 0x0259 }
            r0.setVisibility(r9)     // Catch:{ Exception -> 0x0259 }
            int r0 = net.one97.paytm.o2o.movies.R.id.success_pending_detail     // Catch:{ Exception -> 0x0259 }
            android.view.View r0 = r13.a(r0)     // Catch:{ Exception -> 0x0259 }
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0     // Catch:{ Exception -> 0x0259 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)     // Catch:{ Exception -> 0x0259 }
            r0.setVisibility(r9)     // Catch:{ Exception -> 0x0259 }
            int r0 = net.one97.paytm.o2o.movies.R.id.failure_detail     // Catch:{ Exception -> 0x0259 }
            android.view.View r0 = r13.a(r0)     // Catch:{ Exception -> 0x0259 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x0259 }
            net.one97.paytm.o2o.movies.moviepass.widgets.CJRMoviePassOrderSummaryDetailsView$a r1 = new net.one97.paytm.o2o.movies.moviepass.widgets.CJRMoviePassOrderSummaryDetailsView$a     // Catch:{ Exception -> 0x0259 }
            r1.<init>(r13)     // Catch:{ Exception -> 0x0259 }
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1     // Catch:{ Exception -> 0x0259 }
            r0.setOnClickListener(r1)     // Catch:{ Exception -> 0x0259 }
            goto L_0x01fc
        L_0x007b:
            int r4 = net.one97.paytm.o2o.movies.R.id.failure_detail     // Catch:{ Exception -> 0x0259 }
            android.view.View r4 = r13.a(r4)     // Catch:{ Exception -> 0x0259 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x0259 }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)     // Catch:{ Exception -> 0x0259 }
            r4.setVisibility(r9)     // Catch:{ Exception -> 0x0259 }
            int r4 = net.one97.paytm.o2o.movies.R.id.success_pending_detail     // Catch:{ Exception -> 0x0259 }
            android.view.View r4 = r13.a(r4)     // Catch:{ Exception -> 0x0259 }
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4     // Catch:{ Exception -> 0x0259 }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)     // Catch:{ Exception -> 0x0259 }
            r4.setVisibility(r8)     // Catch:{ Exception -> 0x0259 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = r13.f75632e     // Catch:{ Exception -> 0x0259 }
            if (r4 == 0) goto L_0x01fc
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = r13.f75632e     // Catch:{ Exception -> 0x0259 }
            net.one97.paytm.common.entity.movies.moviepass.CJRMPMataDataModel r4 = net.one97.paytm.o2o.movies.utils.m.b((net.one97.paytm.common.entity.shopping.CJROrderedCart) r4)     // Catch:{ Exception -> 0x0259 }
            net.one97.paytm.common.entity.movies.moviepass.CJRPrevalidateMoviePassModel r6 = r4.getMovie_pass()     // Catch:{ Exception -> 0x0259 }
            if (r6 == 0) goto L_0x00ac
            net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassModel r6 = r6.getData()     // Catch:{ Exception -> 0x0259 }
            goto L_0x00ad
        L_0x00ac:
            r6 = r3
        L_0x00ad:
            int r7 = net.one97.paytm.o2o.movies.R.id.card_heading     // Catch:{ Exception | JSONException -> 0x01fc }
            android.view.View r7 = r13.a(r7)     // Catch:{ Exception | JSONException -> 0x01fc }
            com.paytm.utility.RoboTextView r7 = (com.paytm.utility.RoboTextView) r7     // Catch:{ Exception | JSONException -> 0x01fc }
            java.lang.String r10 = "card_heading"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r10)     // Catch:{ Exception | JSONException -> 0x01fc }
            if (r6 == 0) goto L_0x00c1
            java.lang.String r10 = r6.getHeading()     // Catch:{ Exception | JSONException -> 0x01fc }
            goto L_0x00c2
        L_0x00c1:
            r10 = r3
        L_0x00c2:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception | JSONException -> 0x01fc }
            r7.setText(r10)     // Catch:{ Exception | JSONException -> 0x01fc }
            int r7 = net.one97.paytm.o2o.movies.R.id.card_price_text     // Catch:{ Exception | JSONException -> 0x01fc }
            android.view.View r7 = r13.a(r7)     // Catch:{ Exception | JSONException -> 0x01fc }
            com.paytm.utility.RoboTextView r7 = (com.paytm.utility.RoboTextView) r7     // Catch:{ Exception | JSONException -> 0x01fc }
            java.lang.String r10 = "card_price_text"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r10)     // Catch:{ Exception | JSONException -> 0x01fc }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception | JSONException -> 0x01fc }
            java.lang.String r11 = "Worth "
            r10.<init>(r11)     // Catch:{ Exception | JSONException -> 0x01fc }
            android.content.Context r11 = r13.f75629b     // Catch:{ Exception | JSONException -> 0x01fc }
            int r12 = net.one97.paytm.o2o.movies.R.string.rupee_symbol     // Catch:{ Exception | JSONException -> 0x01fc }
            java.lang.String r11 = r11.getString(r12)     // Catch:{ Exception | JSONException -> 0x01fc }
            r10.append(r11)     // Catch:{ Exception | JSONException -> 0x01fc }
            net.one97.paytm.common.entity.movies.moviepass.CJRPrevalidateMoviePassModel r11 = r4.getMovie_pass()     // Catch:{ Exception | JSONException -> 0x01fc }
            if (r11 == 0) goto L_0x00f1
            java.lang.String r11 = r11.getTotalChargedPrice()     // Catch:{ Exception | JSONException -> 0x01fc }
            goto L_0x00f2
        L_0x00f1:
            r11 = r3
        L_0x00f2:
            r10.append(r11)     // Catch:{ Exception | JSONException -> 0x01fc }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception | JSONException -> 0x01fc }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception | JSONException -> 0x01fc }
            r7.setText(r10)     // Catch:{ Exception | JSONException -> 0x01fc }
            java.lang.String r7 = r13.f75631d     // Catch:{ Exception | JSONException -> 0x01fc }
            boolean r0 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r0, (boolean) r5)     // Catch:{ Exception | JSONException -> 0x01fc }
            if (r0 == 0) goto L_0x0116
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r13.f75632e     // Catch:{ Exception | JSONException -> 0x01fc }
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r0 = r0.getFullFillmentOject()     // Catch:{ Exception | JSONException -> 0x01fc }
            java.lang.String r7 = "mItem.fullFillmentOject"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)     // Catch:{ Exception | JSONException -> 0x01fc }
            org.json.JSONObject r0 = r0.getFullFillment()     // Catch:{ Exception | JSONException -> 0x01fc }
            goto L_0x0117
        L_0x0116:
            r0 = r3
        L_0x0117:
            java.lang.String r7 = "card_promo_code_text"
            if (r0 == 0) goto L_0x0138
            java.lang.String r10 = "promoData"
            org.json.JSONObject r0 = r0.getJSONObject(r10)     // Catch:{ Exception | JSONException -> 0x01fc }
            java.lang.String r10 = "code"
            java.lang.String r0 = r0.getString(r10)     // Catch:{ Exception | JSONException -> 0x01fc }
            int r10 = net.one97.paytm.o2o.movies.R.id.card_promo_code_text     // Catch:{ Exception | JSONException -> 0x01fc }
            android.view.View r10 = r13.a(r10)     // Catch:{ Exception | JSONException -> 0x01fc }
            com.paytm.utility.RoboTextView r10 = (com.paytm.utility.RoboTextView) r10     // Catch:{ Exception | JSONException -> 0x01fc }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r7)     // Catch:{ Exception | JSONException -> 0x01fc }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception | JSONException -> 0x01fc }
            r10.setText(r0)     // Catch:{ Exception | JSONException -> 0x01fc }
            goto L_0x014a
        L_0x0138:
            int r0 = net.one97.paytm.o2o.movies.R.id.card_promo_code_text     // Catch:{ Exception | JSONException -> 0x01fc }
            android.view.View r0 = r13.a(r0)     // Catch:{ Exception | JSONException -> 0x01fc }
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0     // Catch:{ Exception | JSONException -> 0x01fc }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)     // Catch:{ Exception | JSONException -> 0x01fc }
            java.lang.String r7 = "---"
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ Exception | JSONException -> 0x01fc }
            r0.setText(r7)     // Catch:{ Exception | JSONException -> 0x01fc }
        L_0x014a:
            java.util.Map r0 = r4.getInstructions()     // Catch:{ Exception -> 0x01ee }
            if (r0 == 0) goto L_0x015d
            if (r6 == 0) goto L_0x0157
            java.lang.Object r4 = r6.getRedeemSteps()     // Catch:{ Exception -> 0x01ee }
            goto L_0x0158
        L_0x0157:
            r4 = r3
        L_0x0158:
            java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x01ee }
            goto L_0x015e
        L_0x015d:
            r0 = r3
        L_0x015e:
            net.one97.paytm.o2o.movies.utils.m.c(r0)     // Catch:{ Exception -> 0x01ee }
            com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x01ee }
            r0.<init>()     // Catch:{ Exception -> 0x01ee }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x01ee }
            if (r6 == 0) goto L_0x016e
            java.lang.Object r3 = r6.getRedeemSteps()     // Catch:{ Exception -> 0x01ee }
        L_0x016e:
            java.lang.String r0 = r0.a((java.lang.Object) r3)     // Catch:{ Exception -> 0x01ee }
            r4.<init>(r0)     // Catch:{ Exception -> 0x01ee }
            java.lang.String r0 = "instructionsData"
            org.json.JSONArray r0 = r4.getJSONArray(r0)     // Catch:{ Exception -> 0x01ee }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x01ee }
            r3.<init>()     // Catch:{ Exception -> 0x01ee }
            java.util.List r3 = (java.util.List) r3     // Catch:{ Exception -> 0x01ee }
            int r6 = r0.length()     // Catch:{ Exception -> 0x01ee }
            int r6 = r6 - r5
            if (r6 < 0) goto L_0x01a1
            r5 = 0
        L_0x018a:
            org.json.JSONObject r7 = r0.getJSONObject(r5)     // Catch:{ Exception -> 0x01ee }
            java.lang.String r10 = "step"
            java.lang.String r7 = r7.getString(r10)     // Catch:{ Exception -> 0x01ee }
            java.lang.String r10 = "instruction.getJSONObject(index).getString(\"step\")"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r10)     // Catch:{ Exception -> 0x01ee }
            r3.add(r7)     // Catch:{ Exception -> 0x01ee }
            if (r5 == r6) goto L_0x01a1
            int r5 = r5 + 1
            goto L_0x018a
        L_0x01a1:
            int r0 = r3.size()     // Catch:{ Exception -> 0x01ee }
            if (r0 <= 0) goto L_0x01df
            int r0 = net.one97.paytm.o2o.movies.R.id.tnc_view     // Catch:{ Exception -> 0x01ee }
            android.view.View r0 = r13.a(r0)     // Catch:{ Exception -> 0x01ee }
            net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView r0 = (net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView) r0     // Catch:{ Exception -> 0x01ee }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x01ee }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x01ee }
            int r0 = net.one97.paytm.o2o.movies.R.id.tnc_view     // Catch:{ Exception -> 0x01ee }
            android.view.View r0 = r13.a(r0)     // Catch:{ Exception -> 0x01ee }
            net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView r0 = (net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView) r0     // Catch:{ Exception -> 0x01ee }
            r0.setDescription(r3)     // Catch:{ Exception -> 0x01ee }
            int r0 = net.one97.paytm.o2o.movies.R.id.tnc_view     // Catch:{ Exception -> 0x01ee }
            android.view.View r0 = r13.a(r0)     // Catch:{ Exception -> 0x01ee }
            net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView r0 = (net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView) r0     // Catch:{ Exception -> 0x01ee }
            r3 = 2
            r0.setMinimumVisibleLine(r3)     // Catch:{ Exception -> 0x01ee }
            int r0 = net.one97.paytm.o2o.movies.R.id.tnc_view     // Catch:{ Exception -> 0x01ee }
            android.view.View r0 = r13.a(r0)     // Catch:{ Exception -> 0x01ee }
            net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView r0 = (net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView) r0     // Catch:{ Exception -> 0x01ee }
            java.lang.String r3 = "heading"
            java.lang.String r3 = r4.getString(r3)     // Catch:{ Exception -> 0x01ee }
            r4 = 5
            r0.setTitle(r3, r4)     // Catch:{ Exception -> 0x01ee }
            goto L_0x01fc
        L_0x01df:
            int r0 = net.one97.paytm.o2o.movies.R.id.tnc_view     // Catch:{ Exception -> 0x01ee }
            android.view.View r0 = r13.a(r0)     // Catch:{ Exception -> 0x01ee }
            net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView r0 = (net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView) r0     // Catch:{ Exception -> 0x01ee }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x01ee }
            r0.setVisibility(r9)     // Catch:{ Exception -> 0x01ee }
            goto L_0x01fc
        L_0x01ee:
            int r0 = net.one97.paytm.o2o.movies.R.id.tnc_view     // Catch:{ Exception | JSONException -> 0x01fc }
            android.view.View r0 = r13.a(r0)     // Catch:{ Exception | JSONException -> 0x01fc }
            net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView r0 = (net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView) r0     // Catch:{ Exception | JSONException -> 0x01fc }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception | JSONException -> 0x01fc }
            r0.setVisibility(r9)     // Catch:{ Exception | JSONException -> 0x01fc }
        L_0x01fc:
            android.widget.LinearLayout r0 = r13.f75630c     // Catch:{ Exception -> 0x0259 }
            if (r0 == 0) goto L_0x0203
            r0.addView(r2)     // Catch:{ Exception -> 0x0259 }
        L_0x0203:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r13.f75632e     // Catch:{ Exception -> 0x0259 }
            if (r0 == 0) goto L_0x0259
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r13.f75632e     // Catch:{ Exception -> 0x0259 }
            java.lang.String r0 = r0.getPromoCode()     // Catch:{ Exception -> 0x0259 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = r13.f75632e     // Catch:{ Exception -> 0x0259 }
            java.lang.String r1 = r1.getPromoText()     // Catch:{ Exception -> 0x0259 }
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0259 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0259 }
            if (r2 != 0) goto L_0x0259
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0259 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0259 }
            if (r2 != 0) goto L_0x0259
            int r2 = net.one97.paytm.o2o.movies.R.id.promo_code_container     // Catch:{ Exception -> 0x0259 }
            android.view.View r2 = r13.a(r2)     // Catch:{ Exception -> 0x0259 }
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2     // Catch:{ Exception -> 0x0259 }
            java.lang.String r3 = "promo_code_container"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0259 }
            r2.setVisibility(r8)     // Catch:{ Exception -> 0x0259 }
            int r2 = net.one97.paytm.o2o.movies.R.id.promo_code     // Catch:{ Exception -> 0x0259 }
            android.view.View r2 = r13.a(r2)     // Catch:{ Exception -> 0x0259 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0259 }
            java.lang.String r3 = "promo_code"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0259 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0259 }
            r2.setText(r0)     // Catch:{ Exception -> 0x0259 }
            int r0 = net.one97.paytm.o2o.movies.R.id.promo_text     // Catch:{ Exception -> 0x0259 }
            android.view.View r0 = r13.a(r0)     // Catch:{ Exception -> 0x0259 }
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0     // Catch:{ Exception -> 0x0259 }
            java.lang.String r2 = "promo_text"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x0259 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0259 }
            r0.setText(r1)     // Catch:{ Exception -> 0x0259 }
        L_0x0259:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.moviepass.widgets.CJRMoviePassOrderSummaryDetailsView.a():void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRMoviePassOrderSummaryDetailsView f75635a;

        a(CJRMoviePassOrderSummaryDetailsView cJRMoviePassOrderSummaryDetailsView) {
            this.f75635a = cJRMoviePassOrderSummaryDetailsView;
        }

        public final void onClick(View view) {
            this.f75635a.getMClickListener().onClick(view);
        }
    }
}
