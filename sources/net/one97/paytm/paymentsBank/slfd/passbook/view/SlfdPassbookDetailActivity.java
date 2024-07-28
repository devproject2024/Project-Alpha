package net.one97.paytm.paymentsBank.slfd.passbook.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.y;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem;
import net.one97.paytm.paymentsBank.model.slfd.RedemptionResponseListItem;
import net.one97.paytm.paymentsBank.slfd.SlfdBaseActivity;
import net.one97.paytm.paymentsBank.slfd.passbook.a.a;

public final class SlfdPassbookDetailActivity extends SlfdBaseActivity implements a.b {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ kotlin.k.i[] f19265b;

    /* renamed from: c  reason: collision with root package name */
    public a.C0340a f19266c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.g f19267d = kotlin.h.a(new k(this));

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.g f19268e = kotlin.h.a(new a(this));

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.g f19269f = kotlin.h.a(new j(this));

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.g f19270g = kotlin.h.a(new w(this));

    /* renamed from: h  reason: collision with root package name */
    private final kotlin.g f19271h = kotlin.h.a(new l(this));

    /* renamed from: i  reason: collision with root package name */
    private final kotlin.g f19272i = kotlin.h.a(new h(this));
    private final kotlin.g j = kotlin.h.a(new f(this));
    private final kotlin.g k = kotlin.h.a(new d(this));
    private final kotlin.g l = kotlin.h.a(new v(this));
    private final kotlin.g m = kotlin.h.a(new e(this));
    private final kotlin.g n = kotlin.h.a(new u(this));
    private final kotlin.g o = kotlin.h.a(new t(this));
    private final kotlin.g p = kotlin.h.a(new o(this));
    private final kotlin.g q = kotlin.h.a(new r(this));
    private final kotlin.g r = kotlin.h.a(new q(this));
    private final kotlin.g s = kotlin.h.a(new p(this));
    private final kotlin.g t = kotlin.h.a(new b(this));
    private final kotlin.g u = kotlin.h.a(new g(this));
    private final kotlin.g v = kotlin.h.a(new n(this));
    private final kotlin.g w = kotlin.h.a(new m(this));
    private final kotlin.g x = kotlin.h.a(new s(this));
    private final kotlin.g y = kotlin.h.a(new c(this));
    private HashMap z;

    static {
        Class<SlfdPassbookDetailActivity> cls = SlfdPassbookDetailActivity.class;
        f19265b = new kotlin.k.i[]{y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "orderId", "getOrderId()Ljava/lang/String;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "amount", "getAmount()D")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "orderDate", "getOrderDate()J")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), SDKConstants.TXN_TYPE, "getTxnType()Ljava/lang/String;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "progressLoader", "getProgressLoader()Lcom/airbnb/lottie/LottieAnimationView;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "mainContent", "getMainContent()Landroidx/core/widget/NestedScrollView;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "llErrorContainer", "getLlErrorContainer()Landroid/widget/LinearLayout;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "ivClose", "getIvClose()Landroid/widget/ImageView;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "tvTxnId", "getTvTxnId()Landroid/widget/TextView;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "ivFdStatus", "getIvFdStatus()Landroid/widget/ImageView;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "tvStatusTitle", "getTvStatusTitle()Landroid/widget/TextView;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "tvStatusMsg", "getTvStatusMsg()Landroid/widget/TextView;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "tvAmount", "getTvAmount()Landroid/widget/TextView;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "tvFdNumber", "getTvFdNumber()Landroid/widget/TextView;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "tvFdInterest", "getTvFdInterest()Landroid/widget/TextView;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "tvFdDate", "getTvFdDate()Landroid/widget/TextView;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "createdFdDetails", "getCreatedFdDetails()Landroid/widget/LinearLayout;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "llRedeemFdContainer", "getLlRedeemFdContainer()Landroid/widget/LinearLayout;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "rvRedemptionList", "getRvRedemptionList()Landroidx/recyclerview/widget/RecyclerView;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "rvEodList", "getRvEodList()Landroidx/recyclerview/widget/RecyclerView;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "tvFdStatusTip", "getTvFdStatusTip()Landroid/widget/TextView;")), y.a((kotlin.g.b.v) new kotlin.g.b.w(y.b(cls), "fdTipContainer", "getFdTipContainer()Landroid/widget/LinearLayout;"))};
    }

    private final String f() {
        return (String) this.f19267d.getValue();
    }

    private LottieAnimationView g() {
        return (LottieAnimationView) this.f19271h.getValue();
    }

    private NestedScrollView h() {
        return (NestedScrollView) this.f19272i.getValue();
    }

    private LinearLayout i() {
        return (LinearLayout) this.j.getValue();
    }

    private ImageView j() {
        return (ImageView) this.m.getValue();
    }

    private TextView k() {
        return (TextView) this.n.getValue();
    }

    private TextView l() {
        return (TextView) this.o.getValue();
    }

    private RecyclerView m() {
        return (RecyclerView) this.v.getValue();
    }

    private RecyclerView n() {
        return (RecyclerView) this.w.getValue();
    }

    private TextView o() {
        return (TextView) this.x.getValue();
    }

    private LinearLayout p() {
        return (LinearLayout) this.y.getValue();
    }

    public final View a(int i2) {
        if (this.z == null) {
            this.z = new HashMap();
        }
        View view = (View) this.z.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.z.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(boolean z2) {
    }

    public final int e() {
        return R.layout.layout_slfd_passbook_detail;
    }

    static final class k extends kotlin.g.b.l implements kotlin.g.a.a<String> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("order_id");
            return stringExtra == null ? "" : stringExtra;
        }
    }

    static final class a extends kotlin.g.b.l implements kotlin.g.a.a<Double> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final double invoke() {
            return this.this$0.getIntent().getDoubleExtra("slfd_amount", 0.0d);
        }
    }

    static final class j extends kotlin.g.b.l implements kotlin.g.a.a<Long> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final long invoke() {
            return this.this$0.getIntent().getLongExtra("slfd_order_date", 0);
        }
    }

    static final class w extends kotlin.g.b.l implements kotlin.g.a.a<String> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("vertical_id");
            return stringExtra == null ? "" : stringExtra;
        }
    }

    static final class l extends kotlin.g.b.l implements kotlin.g.a.a<LottieAnimationView> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final LottieAnimationView invoke() {
            return (LottieAnimationView) this.this$0.findViewById(R.id.wallet_loader);
        }
    }

    static final class h extends kotlin.g.b.l implements kotlin.g.a.a<NestedScrollView> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final NestedScrollView invoke() {
            return (NestedScrollView) this.this$0.findViewById(R.id.nsv_main_content);
        }
    }

    static final class f extends kotlin.g.b.l implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final LinearLayout invoke() {
            return (LinearLayout) this.this$0.findViewById(R.id.error_layout);
        }
    }

    static final class d extends kotlin.g.b.l implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final ImageView invoke() {
            return (ImageView) this.this$0.findViewById(R.id.iv_close);
        }
    }

    static final class v extends kotlin.g.b.l implements kotlin.g.a.a<TextView> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final TextView invoke() {
            return (TextView) this.this$0.findViewById(R.id.tv_fd_txnId);
        }
    }

    static final class e extends kotlin.g.b.l implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final ImageView invoke() {
            return (ImageView) this.this$0.findViewById(R.id.iv_fd_status);
        }
    }

    static final class u extends kotlin.g.b.l implements kotlin.g.a.a<TextView> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final TextView invoke() {
            return (TextView) this.this$0.findViewById(R.id.tv_status_title);
        }
    }

    static final class t extends kotlin.g.b.l implements kotlin.g.a.a<TextView> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final TextView invoke() {
            return (TextView) this.this$0.findViewById(R.id.tv_status_message);
        }
    }

    static final class o extends kotlin.g.b.l implements kotlin.g.a.a<TextView> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final TextView invoke() {
            return (TextView) this.this$0.findViewById(R.id.tv_fd_amount);
        }
    }

    static final class r extends kotlin.g.b.l implements kotlin.g.a.a<TextView> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final TextView invoke() {
            return (TextView) this.this$0.findViewById(R.id.tv_fd_number);
        }
    }

    static final class q extends kotlin.g.b.l implements kotlin.g.a.a<TextView> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final TextView invoke() {
            return (TextView) this.this$0.findViewById(R.id.tv_fd_interest);
        }
    }

    static final class p extends kotlin.g.b.l implements kotlin.g.a.a<TextView> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final TextView invoke() {
            return (TextView) this.this$0.findViewById(R.id.tv_fd_date);
        }
    }

    static final class b extends kotlin.g.b.l implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final LinearLayout invoke() {
            return (LinearLayout) this.this$0.findViewById(R.id.ll_created_fd_details);
        }
    }

    static final class g extends kotlin.g.b.l implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final LinearLayout invoke() {
            return (LinearLayout) this.this$0.findViewById(R.id.ll_redeem_fd_parent);
        }
    }

    static final class n extends kotlin.g.b.l implements kotlin.g.a.a<RecyclerView> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final RecyclerView invoke() {
            return (RecyclerView) this.this$0.findViewById(R.id.rv_redemption_list);
        }
    }

    static final class m extends kotlin.g.b.l implements kotlin.g.a.a<RecyclerView> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final RecyclerView invoke() {
            return (RecyclerView) this.this$0.findViewById(R.id.rv_eod_list);
        }
    }

    static final class s extends kotlin.g.b.l implements kotlin.g.a.a<TextView> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final TextView invoke() {
            return (TextView) this.this$0.findViewById(R.id.tv_fd_status_tip);
        }
    }

    static final class c extends kotlin.g.b.l implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ SlfdPassbookDetailActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            super(0);
            this.this$0 = slfdPassbookDetailActivity;
        }

        public final LinearLayout invoke() {
            return (LinearLayout) this.this$0.findViewById(R.id.ll_fd_tip);
        }
    }

    private a.C0340a q() {
        a.C0340a aVar = this.f19266c;
        if (aVar == null) {
            kotlin.g.b.k.a("presenter");
        }
        return aVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context context = this;
        m().setLayoutManager(new LinearLayoutManager(context));
        m().addItemDecoration(new net.one97.paytm.paymentsBank.slfd.redeemFd.h(net.one97.paytm.bankCommon.mapping.a.a(10.0f, context)));
        n().setLayoutManager(new LinearLayoutManager(context));
        n().addItemDecoration(new androidx.recyclerview.widget.i(context, 1));
        String f2 = f();
        String n2 = com.paytm.utility.b.n(context);
        kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.getUserId(this)");
        net.one97.paytm.paymentsBank.slfd.c cVar = net.one97.paytm.paymentsBank.slfd.c.f18958a;
        Context applicationContext = getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "this.applicationContext");
        a.C0340a aVar = new net.one97.paytm.paymentsBank.slfd.passbook.b.a(f2, n2, (String) this.f19270g.getValue(), net.one97.paytm.paymentsBank.slfd.c.a(applicationContext), this);
        kotlin.g.b.k.c(aVar, "<set-?>");
        this.f19266c = aVar;
        q().a();
        ((ImageView) this.k.getValue()).setOnClickListener(new i(this));
        ((TextView) this.l.getValue()).setText(getString(R.string.fd_reference_num, new Object[]{f()}));
        String c2 = net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(((Number) this.f19268e.getValue()).doubleValue()));
        net.one97.paytm.bankCommon.mapping.e.a(getString(R.string.fd_amount, new Object[]{c2}), (TextView) this.p.getValue());
        ((TextView) this.s.getValue()).setText(net.one97.paytm.paymentsBank.slfd.b.a.a.a("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "hh:mm a, dd MMM yyyy", ((Number) this.f19269f.getValue()).longValue()));
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdPassbookDetailActivity f19273a;

        i(SlfdPassbookDetailActivity slfdPassbookDetailActivity) {
            this.f19273a = slfdPassbookDetailActivity;
        }

        public final void onClick(View view) {
            this.f19273a.finish();
        }
    }

    public final void attachBaseContext(Context context) {
        kotlin.g.b.k.c(context, "newBase");
        super.attachBaseContext(net.one97.paytm.paymentsBank.utils.o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public final void a() {
        net.one97.paytm.common.widgets.a.a(g());
        NestedScrollView h2 = h();
        kotlin.g.b.k.a((Object) h2, "mainContent");
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(h2);
        LinearLayout i2 = i();
        kotlin.g.b.k.a((Object) i2, "llErrorContainer");
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(i2);
    }

    public final void b() {
        LinearLayout i2 = i();
        kotlin.g.b.k.a((Object) i2, "llErrorContainer");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(i2);
        net.one97.paytm.common.widgets.a.b(g());
        NestedScrollView h2 = h();
        kotlin.g.b.k.a((Object) h2, "mainContent");
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(h2);
    }

    public final void aj_() {
        net.one97.paytm.common.widgets.a.b(g());
        NestedScrollView h2 = h();
        kotlin.g.b.k.a((Object) h2, "mainContent");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(h2);
        LinearLayout i2 = i();
        kotlin.g.b.k.a((Object) i2, "llErrorContainer");
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(i2);
    }

    public final void a(String str) {
        k().setText(getString(R.string.fd_create_title_for_status_pending));
        l().setText(str);
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(j(), R.drawable.pb_pb_ic_status_pending);
        LinearLayout p2 = p();
        kotlin.g.b.k.a((Object) p2, "fdTipContainer");
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(p2);
    }

    public final void b(String str) {
        k().setText(getString(R.string.fd_create_title_for_status_success));
        l().setText(str);
        o().setText(getString(R.string.fd_auto_renewed));
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(j(), R.drawable.pb_pb_ic_success_icon);
    }

    public final void c(String str) {
        k().setText(getString(R.string.fd_create_title_for_status_failed));
        l().setText(str);
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(j(), R.drawable.pb_ic_fail);
        LinearLayout p2 = p();
        kotlin.g.b.k.a((Object) p2, "fdTipContainer");
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(p2);
    }

    public final void d(String str) {
        k().setText(getString(R.string.fd_redeem_title_for_status_pending));
        l().setText(str);
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(j(), R.drawable.pb_pb_ic_status_pending);
        LinearLayout p2 = p();
        kotlin.g.b.k.a((Object) p2, "fdTipContainer");
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(p2);
    }

    public final void e(String str) {
        k().setText(getString(R.string.fd_redeem_title_for_status_failed));
        l().setText(str);
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(j(), R.drawable.pb_ic_fail);
        LinearLayout p2 = p();
        kotlin.g.b.k.a((Object) p2, "fdTipContainer");
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(p2);
    }

    public final void f(String str) {
        k().setText(getString(R.string.fd_redeem_title_for_status_success));
        l().setText(str);
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(j(), R.drawable.pb_fg_ic_success);
        o().setText(getString(R.string.fd_current_value_note));
    }

    public final void g(String str) {
        k().setText(getString(R.string.fd_redeem_title_for_status_partial));
        l().setText(str);
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(j(), R.drawable.pb_pb_ic_status_pending);
        o().setText(getString(R.string.fd_current_value_note));
    }

    public final void onDestroy() {
        super.onDestroy();
        q().b();
    }

    public final void b(List<BookingResponseListItem> list) {
        net.one97.paytm.paymentsBank.slfd.b.a.b.a((LinearLayout) this.t.getValue());
        if (list != null) {
            n().setAdapter(new net.one97.paytm.paymentsBank.slfd.common.view.c(list));
        }
    }

    public final void a(List<RedemptionResponseListItem> list) {
        net.one97.paytm.paymentsBank.slfd.b.a.b.a((LinearLayout) this.u.getValue());
        m().setAdapter(new net.one97.paytm.paymentsBank.slfd.common.view.a(list, false));
        RecyclerView.a adapter = m().getAdapter();
        if (adapter == null) {
            kotlin.g.b.k.a();
        }
        adapter.notifyDataSetChanged();
    }
}
