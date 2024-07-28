package net.one97.paytm.o2o.movies.moviepass.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.b.f;
import net.one97.paytm.o2o.movies.moviepass.b.d;
import net.one97.paytm.o2o.movies.moviepass.widgets.CJRMoviePassOrderSummaryFooterView;
import net.one97.paytm.o2o.movies.utils.j;

public final class b extends net.one97.paytm.o2o.movies.fragment.b implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    final d.a f75489a;

    /* renamed from: b  reason: collision with root package name */
    private final String f75490b;

    /* renamed from: c  reason: collision with root package name */
    private CJROrderSummary f75491c;

    /* renamed from: d  reason: collision with root package name */
    private CJRUpcomingMovies f75492d;

    /* renamed from: e  reason: collision with root package name */
    private String f75493e = "In Process";

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f75494f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f75495g;

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f75496a = new a();

        a() {
        }

        public final void onClick(View view) {
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final c f75498a = new c();

        c() {
        }

        public final void onClick(View view) {
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public static final /* synthetic */ CJROrderSummary a(b bVar) {
        CJROrderSummary cJROrderSummary = bVar.f75491c;
        if (cJROrderSummary == null) {
            k.a("mOrderSummary");
        }
        return cJROrderSummary;
    }

    public b(d.a aVar) {
        k.c(aVar, "mActivityListener");
        this.f75489a = aVar;
        String simpleName = b.class.getSimpleName();
        k.a((Object) simpleName, "FJRMoviePassOrderSummary::class.java.simpleName");
        this.f75490b = simpleName;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle arguments = getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("movie_order_summary") : null;
            if (serializable != null) {
                this.f75491c = (CJROrderSummary) serializable;
                CJROrderSummary cJROrderSummary = this.f75491c;
                if (cJROrderSummary == null) {
                    k.a("mOrderSummary");
                }
                String status = cJROrderSummary.getStatus();
                k.a((Object) status, "mOrderSummary.status");
                this.f75493e = status;
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJROrderSummary");
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: android.widget.TextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: android.widget.TextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: android.widget.TextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: android.widget.TextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: android.widget.TextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r19, android.view.ViewGroup r20, android.os.Bundle r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            java.lang.String r2 = "inflater"
            kotlin.g.b.k.c(r1, r2)
            kotlin.g.b.x$e r2 = new kotlin.g.b.x$e
            r2.<init>()
            int r3 = net.one97.paytm.o2o.movies.R.layout.fragment_mp_order_summary
            r4 = 0
            android.view.View r3 = r1.inflate(r3, r4)
            r2.element = r3
            T r3 = r2.element
            android.view.View r3 = (android.view.View) r3
            if (r3 == 0) goto L_0x0026
            int r5 = net.one97.paytm.o2o.movies.R.id.mp_order_summary_root_lin_lay
            android.view.View r3 = r3.findViewById(r5)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            goto L_0x0027
        L_0x0026:
            r3 = r4
        L_0x0027:
            if (r3 == 0) goto L_0x02de
            r0.f75494f = r3
            android.widget.LinearLayout r7 = r0.f75494f
            java.lang.String r3 = "mLinLay"
            if (r7 != 0) goto L_0x0034
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0034:
            java.lang.String r8 = r0.f75493e
            java.lang.String r12 = "SUCCESS"
            r13 = 1
            boolean r5 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r12, (boolean) r13)
            java.lang.String r14 = "In Process"
            java.lang.String r15 = "PROCESSING"
            java.lang.String r16 = "mOrderSummary"
            r11 = 0
            java.lang.String r6 = "Your Movie Pass is ready"
            if (r5 == 0) goto L_0x008b
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r0.f75491c     // Catch:{ Exception -> 0x0086 }
            if (r5 != 0) goto L_0x004f
            kotlin.g.b.k.a((java.lang.String) r16)     // Catch:{ Exception -> 0x0086 }
        L_0x004f:
            java.util.ArrayList r5 = r5.getOrderedCartList()     // Catch:{ Exception -> 0x0086 }
            java.lang.Object r5 = r5.get(r11)     // Catch:{ Exception -> 0x0086 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r5     // Catch:{ Exception -> 0x0086 }
            net.one97.paytm.common.entity.movies.moviepass.CJRMPMataDataModel r5 = net.one97.paytm.o2o.movies.utils.m.b((net.one97.paytm.common.entity.shopping.CJROrderedCart) r5)     // Catch:{ Exception -> 0x0086 }
            net.one97.paytm.common.entity.movies.moviepass.CJRPrevalidateMoviePassModel r5 = r5.getMovie_pass()     // Catch:{ Exception -> 0x0086 }
            if (r5 == 0) goto L_0x0068
            net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassModel r5 = r5.getData()     // Catch:{ Exception -> 0x0086 }
            goto L_0x0069
        L_0x0068:
            r5 = r4
        L_0x0069:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0086 }
            java.lang.String r10 = "You have bought "
            r9.<init>(r10)     // Catch:{ Exception -> 0x0086 }
            if (r5 != 0) goto L_0x0075
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0086 }
        L_0x0075:
            java.lang.String r5 = r5.getHeading()     // Catch:{ Exception -> 0x0086 }
            r9.append(r5)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r5 = " successfully"
            r9.append(r5)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r5 = r9.toString()     // Catch:{ Exception -> 0x0086 }
            goto L_0x0088
        L_0x0086:
            java.lang.String r5 = ""
        L_0x0088:
            r10 = r5
            r9 = r6
            goto L_0x00a3
        L_0x008b:
            boolean r5 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r15, (boolean) r13)
            if (r5 != 0) goto L_0x009d
            boolean r5 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r14, (boolean) r13)
            if (r5 == 0) goto L_0x0098
            goto L_0x009d
        L_0x0098:
            java.lang.String r5 = "Oops! Order Failed"
            java.lang.String r6 = "If your money has been deducted, we will refund the amount to your wallet within 24 hours."
            goto L_0x00a1
        L_0x009d:
            java.lang.String r5 = "Confirmation Pending"
            java.lang.String r6 = "Your order is currently being processed. We will notify you once the order processing is complete."
        L_0x00a1:
            r9 = r5
            r10 = r6
        L_0x00a3:
            net.one97.paytm.o2o.movies.moviepass.widgets.CJRMoviePassOderSummaryHeaderView r6 = new net.one97.paytm.o2o.movies.moviepass.widgets.CJRMoviePassOderSummaryHeaderView
            android.content.Context r5 = r18.getContext()
            if (r5 != 0) goto L_0x00ae
            kotlin.g.b.k.a()
        L_0x00ae:
            java.lang.String r4 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            net.one97.paytm.o2o.movies.moviepass.c.b$b r11 = new net.one97.paytm.o2o.movies.moviepass.c.b$b
            r11.<init>(r0)
            android.view.View$OnClickListener r11 = (android.view.View.OnClickListener) r11
            r17 = r5
            r5 = r6
            r13 = r6
            r6 = r17
            r17 = r2
            r2 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            android.content.Context r5 = r13.f75620b
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r5)
            r13.f75619a = r5
            android.view.LayoutInflater r5 = r13.f75619a
            if (r5 == 0) goto L_0x00da
            int r6 = net.one97.paytm.o2o.movies.R.layout.mp_order_summary_header
            r7 = r13
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            r5.inflate(r6, r7)
        L_0x00da:
            int r5 = net.one97.paytm.o2o.movies.R.id.back_btn
            android.view.View r5 = r13.a(r5)
            androidx.appcompat.widget.AppCompatImageView r5 = (androidx.appcompat.widget.AppCompatImageView) r5
            net.one97.paytm.o2o.movies.moviepass.widgets.CJRMoviePassOderSummaryHeaderView$a r6 = new net.one97.paytm.o2o.movies.moviepass.widgets.CJRMoviePassOderSummaryHeaderView$a
            r6.<init>(r13)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r5.setOnClickListener(r6)
            java.lang.String r5 = r13.f75623e
            boolean r5 = com.paytm.utility.v.a((java.lang.String) r5)
            r6 = 8
            java.lang.String r7 = "heading_view"
            if (r5 != 0) goto L_0x0176
            int r5 = net.one97.paytm.o2o.movies.R.id.heading_view
            android.view.View r5 = r13.a(r5)
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            r5.setVisibility(r2)
            int r5 = net.one97.paytm.o2o.movies.R.id.heading_view
            android.view.View r5 = r13.a(r5)
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            java.lang.String r7 = r13.f75623e
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r5.setText(r7)
            java.lang.String r5 = r13.f75622d
            r7 = 1
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r12, (boolean) r7)
            if (r5 == 0) goto L_0x0144
            int r5 = net.one97.paytm.o2o.movies.R.id.heading_view
            android.view.View r5 = r13.a(r5)
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5
            r7 = 9
            r8 = 172(0xac, float:2.41E-43)
            r9 = 99
            int r7 = android.graphics.Color.rgb(r7, r8, r9)
            r5.setTextColor(r7)
            int r5 = net.one97.paytm.o2o.movies.R.id.info_icon
            android.view.View r5 = r13.a(r5)
            androidx.appcompat.widget.AppCompatImageView r5 = (androidx.appcompat.widget.AppCompatImageView) r5
            int r7 = net.one97.paytm.common.assets.R.drawable.success_toll_modification
            r5.setImageResource(r7)
            goto L_0x0184
        L_0x0144:
            java.lang.String r5 = r13.f75622d
            r7 = 1
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r15, (boolean) r7)
            if (r5 != 0) goto L_0x0155
            java.lang.String r5 = r13.f75622d
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r14, (boolean) r7)
            if (r5 == 0) goto L_0x0184
        L_0x0155:
            int r5 = net.one97.paytm.o2o.movies.R.id.heading_view
            android.view.View r5 = r13.a(r5)
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5
            r7 = 255(0xff, float:3.57E-43)
            r8 = 164(0xa4, float:2.3E-43)
            int r7 = android.graphics.Color.rgb(r7, r8, r2)
            r5.setTextColor(r7)
            int r5 = net.one97.paytm.o2o.movies.R.id.info_icon
            android.view.View r5 = r13.a(r5)
            androidx.appcompat.widget.AppCompatImageView r5 = (androidx.appcompat.widget.AppCompatImageView) r5
            int r7 = net.one97.paytm.common.assets.R.drawable.ic_status_pending
            r5.setImageResource(r7)
            goto L_0x0184
        L_0x0176:
            int r5 = net.one97.paytm.o2o.movies.R.id.heading_view
            android.view.View r5 = r13.a(r5)
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            r5.setVisibility(r6)
        L_0x0184:
            java.lang.String r5 = r13.f75624f
            boolean r5 = com.paytm.utility.v.a((java.lang.String) r5)
            java.lang.String r7 = "sub_heading_view"
            if (r5 != 0) goto L_0x01b0
            int r5 = net.one97.paytm.o2o.movies.R.id.sub_heading_view
            android.view.View r5 = r13.a(r5)
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            r5.setVisibility(r2)
            int r5 = net.one97.paytm.o2o.movies.R.id.sub_heading_view
            android.view.View r5 = r13.a(r5)
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            java.lang.String r6 = r13.f75624f
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
            goto L_0x01be
        L_0x01b0:
            int r5 = net.one97.paytm.o2o.movies.R.id.sub_heading_view
            android.view.View r5 = r13.a(r5)
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            r5.setVisibility(r6)
        L_0x01be:
            android.widget.LinearLayout r5 = r13.f75621c
            if (r5 == 0) goto L_0x01cc
            android.widget.LinearLayout r5 = r13.f75621c
            if (r5 == 0) goto L_0x01cc
            r6 = r13
            android.view.View r6 = (android.view.View) r6
            r5.addView(r6)
        L_0x01cc:
            android.widget.LinearLayout r9 = r0.f75494f
            if (r9 != 0) goto L_0x01d3
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x01d3:
            java.lang.String r10 = r0.f75493e
            net.one97.paytm.o2o.movies.moviepass.widgets.CJRMoviePassOrderSummaryDetailsView r5 = new net.one97.paytm.o2o.movies.moviepass.widgets.CJRMoviePassOrderSummaryDetailsView
            android.content.Context r8 = r18.getContext()
            if (r8 != 0) goto L_0x01e0
            kotlin.g.b.k.a()
        L_0x01e0:
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r0.f75491c
            if (r4 != 0) goto L_0x01ea
            kotlin.g.b.k.a((java.lang.String) r16)
        L_0x01ea:
            java.util.ArrayList r4 = r4.getOrderedCartList()
            java.lang.Object r4 = r4.get(r2)
            java.lang.String r6 = "mOrderSummary.orderedCartList[0]"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            r11 = r4
            net.one97.paytm.common.entity.shopping.CJROrderedCart r11 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r11
            net.one97.paytm.o2o.movies.moviepass.c.b$a r4 = net.one97.paytm.o2o.movies.moviepass.c.b.a.f75496a
            r12 = r4
            android.view.View$OnClickListener r12 = (android.view.View.OnClickListener) r12
            r7 = r5
            r7.<init>(r8, r9, r10, r11, r12)
            r5.a()
            android.widget.LinearLayout r4 = r0.f75494f
            if (r4 != 0) goto L_0x020d
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x020d:
            if (r1 == 0) goto L_0x0217
            int r5 = net.one97.paytm.o2o.movies.R.layout.mp_order_summary_price_view
            r6 = 0
            android.view.View r1 = r1.inflate(r5, r6)
            goto L_0x0219
        L_0x0217:
            r6 = 0
            r1 = r6
        L_0x0219:
            if (r1 == 0) goto L_0x0224
            int r5 = net.one97.paytm.o2o.movies.R.id.mp_order_summary_total_price
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            goto L_0x0225
        L_0x0224:
            r5 = r6
        L_0x0225:
            java.lang.String r7 = "null cannot be cast to non-null type android.widget.TextView"
            if (r5 == 0) goto L_0x02d8
            int r8 = net.one97.paytm.o2o.movies.R.id.movie_pass_name
            android.view.View r8 = r1.findViewById(r8)
            if (r8 == 0) goto L_0x02d2
            android.widget.TextView r8 = (android.widget.TextView) r8
            int r9 = net.one97.paytm.o2o.movies.R.id.mp_order_summary_total_price_2
            android.view.View r9 = r1.findViewById(r9)
            if (r9 == 0) goto L_0x02cc
            android.widget.TextView r9 = (android.widget.TextView) r9
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r0.f75491c     // Catch:{ Exception -> 0x029a }
            if (r7 != 0) goto L_0x0244
            kotlin.g.b.k.a((java.lang.String) r16)     // Catch:{ Exception -> 0x029a }
        L_0x0244:
            java.util.ArrayList r7 = r7.getOrderedCartList()     // Catch:{ Exception -> 0x029a }
            java.lang.Object r2 = r7.get(r2)     // Catch:{ Exception -> 0x029a }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r2     // Catch:{ Exception -> 0x029a }
            net.one97.paytm.common.entity.movies.moviepass.CJRMPMataDataModel r2 = net.one97.paytm.o2o.movies.utils.m.b((net.one97.paytm.common.entity.shopping.CJROrderedCart) r2)     // Catch:{ Exception -> 0x029a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x029a }
            r7.<init>()     // Catch:{ Exception -> 0x029a }
            int r10 = net.one97.paytm.o2o.movies.R.string.rupee_symbol     // Catch:{ Exception -> 0x029a }
            java.lang.String r10 = r0.getString(r10)     // Catch:{ Exception -> 0x029a }
            r7.append(r10)     // Catch:{ Exception -> 0x029a }
            net.one97.paytm.common.entity.movies.moviepass.CJRPrevalidateMoviePassModel r10 = r2.getMovie_pass()     // Catch:{ Exception -> 0x029a }
            if (r10 == 0) goto L_0x026b
            java.lang.String r10 = r10.getTotalChargedPrice()     // Catch:{ Exception -> 0x029a }
            goto L_0x026c
        L_0x026b:
            r10 = r6
        L_0x026c:
            r7.append(r10)     // Catch:{ Exception -> 0x029a }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x029a }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ Exception -> 0x029a }
            r5.setText(r7)     // Catch:{ Exception -> 0x029a }
            java.lang.CharSequence r5 = r5.getText()     // Catch:{ Exception -> 0x029a }
            r9.setText(r5)     // Catch:{ Exception -> 0x029a }
            net.one97.paytm.common.entity.movies.moviepass.CJRPrevalidateMoviePassModel r2 = r2.getMovie_pass()     // Catch:{ Exception -> 0x029a }
            if (r2 == 0) goto L_0x0290
            net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassModel r2 = r2.getData()     // Catch:{ Exception -> 0x029a }
            if (r2 == 0) goto L_0x0290
            java.lang.String r2 = r2.getHeading()     // Catch:{ Exception -> 0x029a }
            goto L_0x0291
        L_0x0290:
            r2 = r6
        L_0x0291:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x029a }
            r8.setText(r2)     // Catch:{ Exception -> 0x029a }
            r4.addView(r1)     // Catch:{ Exception -> 0x029a }
            goto L_0x029b
        L_0x029a:
        L_0x029b:
            android.widget.LinearLayout r1 = r0.f75494f
            if (r1 != 0) goto L_0x02a2
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x02a2:
            r0.a((android.widget.LinearLayout) r1)
            r1 = r17
            T r2 = r1.element
            android.view.View r2 = (android.view.View) r2
            int r3 = net.one97.paytm.o2o.movies.R.id.mp_card_contactus
            android.view.View r2 = r2.findViewById(r3)
            if (r2 == 0) goto L_0x02c4
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            net.one97.paytm.o2o.movies.moviepass.c.b$d r3 = new net.one97.paytm.o2o.movies.moviepass.c.b$d
            r3.<init>(r0, r1)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r2.setOnClickListener(r3)
            T r1 = r1.element
            android.view.View r1 = (android.view.View) r1
            return r1
        L_0x02c4:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.RelativeLayout"
            r1.<init>(r2)
            throw r1
        L_0x02cc:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r7)
            throw r1
        L_0x02d2:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r7)
            throw r1
        L_0x02d8:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r7)
            throw r1
        L_0x02de:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.LinearLayout"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.moviepass.c.b.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f75499a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f75500b;

        d(b bVar, x.e eVar) {
            this.f75499a = bVar;
            this.f75500b = eVar;
        }

        public final void onClick(View view) {
            Context context = this.f75499a.getContext();
            if (context != null) {
                new f((FragmentActivity) context, (ProgressBar) ((View) this.f75500b.element).findViewById(R.id.id_moviepass_summary_progress_bar)).a(b.a(this.f75499a));
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    private final void a(LinearLayout linearLayout) {
        Context context = getContext();
        if (context != null) {
            CJRUpcomingMovies cJRUpcomingMovies = this.f75492d;
            if (cJRUpcomingMovies == null) {
                j.a(context, (com.paytm.network.listener.b) this);
            } else if (linearLayout != null) {
                new CJRMoviePassOrderSummaryFooterView(context, linearLayout, cJRUpcomingMovies, c.f75498a).a();
            }
        }
    }

    /* renamed from: net.one97.paytm.o2o.movies.moviepass.c.b$b  reason: collision with other inner class name */
    static final class C1493b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f75497a;

        C1493b(b bVar) {
            this.f75497a = bVar;
        }

        public final void onClick(View view) {
            this.f75497a.f75489a.onBackPressed();
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel != null) {
            CJRUpcomingMovies cJRUpcomingMovies = (CJRUpcomingMovies) iJRPaytmDataModel;
            if (!net.one97.paytm.o2o.movies.common.d.a((List) cJRUpcomingMovies.getUpcomingMovieData())) {
                this.f75492d = cJRUpcomingMovies;
                LinearLayout linearLayout = this.f75494f;
                if (linearLayout == null) {
                    k.a("mLinLay");
                }
                a(linearLayout);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f75495g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
