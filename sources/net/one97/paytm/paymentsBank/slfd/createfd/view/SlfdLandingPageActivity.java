package net.one97.paytm.paymentsBank.slfd.createfd.view;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.airbnb.lottie.LottieAnimationView;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.v;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.createfd.activity.CreateFdActivity;
import net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionModel;
import net.one97.paytm.paymentsBank.slfd.SlfdBaseActivity;
import net.one97.paytm.paymentsBank.slfd.createfd.a.c;
import net.one97.paytm.paymentsBank.slfd.interestprojection.FDPassbookActivity;
import net.one97.paytm.paymentsBank.slfd.interestprojection.FixedDepositOfferingActivity;
import net.one97.paytm.paymentsBank.slfd.interestprojection.InterestProjectionActivity;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDMaxLimitModel;
import net.one97.paytm.paymentsBank.slfd.passbook.view.SlfdPassbookActivity;
import net.one97.paytm.paymentsBank.slfd.redeemFd.RedeemFdActivity;
import net.one97.paytm.paymentsBank.utils.n;
import net.one97.paytm.paymentsBank.utils.o;

public final class SlfdLandingPageActivity extends SlfdBaseActivity implements c.b {
    private String A;
    private String B;
    private SlfdMetaApiResponseModel C;
    private BroadcastReceiver D = new SlfdLandingPageActivity$refreshDataBroadcast$1(this);
    private HashMap E;

    /* renamed from: b  reason: collision with root package name */
    public c.a f19098b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f19099c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f19100d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f19101e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f19102f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f19103g;

    /* renamed from: h  reason: collision with root package name */
    private LottieAnimationView f19104h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f19105i;
    private View j;
    private ViewPager k;
    private TextView l;
    private TextView m;
    private ImageView n;
    private boolean o;
    /* access modifiers changed from: private */
    public boolean p;
    private boolean q;
    private int r;
    private HashMap<String, Double> s = new HashMap<>();
    private View t;
    private View u;
    private TextView v;
    private TextView w;
    private LottieAnimationView x;
    private View y;
    private String z = "";

    public final View a(int i2) {
        if (this.E == null) {
            this.E = new HashMap();
        }
        View view = (View) this.E.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.E.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a<T> implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdLandingPageActivity f19106a;

        a(SlfdLandingPageActivity slfdLandingPageActivity) {
            this.f19106a = slfdLandingPageActivity;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
            this.f19106a.ah_();
            if (iJRPaytmDataModel instanceof SlfdTransactionModel) {
                SlfdTransactionModel slfdTransactionModel = (SlfdTransactionModel) iJRPaytmDataModel;
                String status = slfdTransactionModel.getStatus();
                if (status == null) {
                    kotlin.g.b.k.a();
                }
                if (p.a(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, status, true)) {
                    SlfdLandingPageActivity slfdLandingPageActivity = this.f19106a;
                    com.paytm.utility.b.b((Context) slfdLandingPageActivity, slfdLandingPageActivity.getString(R.string.error), slfdTransactionModel.getMessage());
                } else if (slfdTransactionModel.getTransactionList() != null && slfdTransactionModel.getTransactionList().size() > 0) {
                    Intent intent = new Intent(this.f19106a, FDPassbookActivity.class);
                    intent.putExtra("extra_slfd_transaction_model", iJRPaytmDataModel);
                    this.f19106a.startActivity(intent);
                }
            }
        }
    }

    public static final /* synthetic */ TextView a(SlfdLandingPageActivity slfdLandingPageActivity) {
        TextView textView = slfdLandingPageActivity.l;
        if (textView == null) {
            kotlin.g.b.k.a("tvIntrestEarned");
        }
        return textView;
    }

    public final c.a f() {
        c.a aVar = this.f19098b;
        if (aVar == null) {
            kotlin.g.b.k.a("presenter");
        }
        return aVar;
    }

    public final int e() {
        return R.layout.activity_fd_landing;
    }

    public final void attachBaseContext(Context context) {
        kotlin.g.b.k.c(context, "newBase");
        super.attachBaseContext(o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        this.o = getIntent().getBooleanExtra("SLFD_IMPULSE_DO_ALLOW_BOOKING", false);
        if (getIntent().hasExtra(net.one97.paytm.paymentsBank.slfd.b.b.f18956a)) {
            String stringExtra = getIntent().getStringExtra(net.one97.paytm.paymentsBank.slfd.b.b.f18956a);
            kotlin.g.b.k.a((Object) stringExtra, "intent.getStringExtra(Sl…Constants.EXTRA_DEEPLINK)");
            this.z = stringExtra;
        }
        if (getIntent().hasExtra("user_type")) {
            this.A = getIntent().getStringExtra("user_type");
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ((ImageView) toolbar.findViewById(R.id.iv_back_arrow)).setOnClickListener(new j(this));
        View findViewById = findViewById(R.id.vp_fd_list);
        kotlin.g.b.k.a((Object) findViewById, "findViewById<ViewPager>(R.id.vp_fd_list)");
        this.k = (ViewPager) findViewById;
        ViewPager viewPager = this.k;
        if (viewPager == null) {
            kotlin.g.b.k.a("viewPager");
        }
        androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
        kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
        viewPager.setAdapter(new a(supportFragmentManager));
        View findViewById2 = findViewById(R.id.tv_intrest_label);
        kotlin.g.b.k.a((Object) findViewById2, "findViewById(R.id.tv_intrest_label)");
        this.l = (TextView) findViewById2;
        TextView textView = this.l;
        if (textView == null) {
            kotlin.g.b.k.a("tvIntrestEarned");
        }
        textView.setOnClickListener(new k(this));
        View findViewById3 = findViewById(R.id.create_fd_group);
        kotlin.g.b.k.a((Object) findViewById3, "findViewById(R.id.create_fd_group)");
        this.j = findViewById3;
        View findViewById4 = findViewById(R.id.rl_view_fd_passbook);
        findViewById4.setOnClickListener(new c(this));
        this.t = findViewById4;
        View findViewById5 = findViewById(R.id.rl_manage_fd);
        findViewById5.setOnClickListener(new d(this));
        if (net.one97.paytm.paymentsBank.utils.j.b()) {
            kotlin.g.b.k.a((Object) findViewById5, "it");
            findViewById5.setVisibility(0);
        } else {
            kotlin.g.b.k.a((Object) findViewById5, "it");
            findViewById5.setVisibility(8);
        }
        this.u = findViewById5;
        View findViewById6 = findViewById(R.id.tv_view_transaction);
        TextView textView2 = (TextView) findViewById6;
        textView2.setOnClickListener(new e(this));
        kotlin.g.b.k.a((Object) findViewById6, "(findViewById<TextView>(…)\n            }\n        }");
        this.f19101e = textView2;
        View findViewById7 = findViewById(R.id.tv_fd_total_amount);
        kotlin.g.b.k.a((Object) findViewById7, "findViewById<TextView>(R.id.tv_fd_total_amount)");
        this.f19099c = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.tv_total_interest_earned);
        kotlin.g.b.k.a((Object) findViewById8, "findViewById<TextView>(R…tv_total_interest_earned)");
        this.f19100d = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.ic_img_intrest_table);
        kotlin.g.b.k.a((Object) findViewById9, "findViewById<ImageView>(R.id.ic_img_intrest_table)");
        this.n = (ImageView) findViewById9;
        ImageView imageView = this.n;
        if (imageView == null) {
            kotlin.g.b.k.a("imgIntrestTable");
        }
        imageView.setOnClickListener(new l(this));
        TextView textView3 = (TextView) findViewById(R.id.tv_intrest_table);
        textView3.setOnClickListener(new f(this));
        this.w = textView3;
        View findViewById10 = findViewById(R.id.rl_create_fd);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById10;
        relativeLayout.setOnClickListener(new g(this));
        kotlin.g.b.k.a((Object) findViewById10, "(findViewById<RelativeLa…}\n            }\n        }");
        this.f19102f = relativeLayout;
        this.v = (TextView) findViewById(R.id.tv_your_investement_header);
        if (n.e()) {
            RelativeLayout relativeLayout2 = this.f19102f;
            if (relativeLayout2 == null) {
                kotlin.g.b.k.a("rlCreateFd");
            }
            relativeLayout2.setVisibility(0);
        } else {
            RelativeLayout relativeLayout3 = this.f19102f;
            if (relativeLayout3 == null) {
                kotlin.g.b.k.a("rlCreateFd");
            }
            relativeLayout3.setVisibility(8);
        }
        View findViewById11 = findViewById(R.id.rl_redeem_fd);
        RelativeLayout relativeLayout4 = (RelativeLayout) findViewById11;
        relativeLayout4.setOnClickListener(new h(this));
        kotlin.g.b.k.a((Object) findViewById11, "(findViewById<RelativeLa…)\n            }\n        }");
        this.f19103g = relativeLayout4;
        a(Boolean.TRUE);
        View findViewById12 = findViewById(R.id.fd_dot_progress_bar);
        kotlin.g.b.k.a((Object) findViewById12, "findViewById(R.id.fd_dot_progress_bar)");
        this.f19104h = (LottieAnimationView) findViewById12;
        View findViewById13 = findViewById(R.id.rl_dot_progress);
        kotlin.g.b.k.a((Object) findViewById13, "findViewById<RelativeLayout>(R.id.rl_dot_progress)");
        this.f19105i = (RelativeLayout) findViewById13;
        View findViewById14 = findViewById(R.id.fd_show_interest_loader);
        kotlin.g.b.k.a((Object) findViewById14, "findViewById<LottieAnima….fd_show_interest_loader)");
        this.x = (LottieAnimationView) findViewById14;
        View findViewById15 = findViewById(R.id.fd_show_interest_loader_lyt);
        kotlin.g.b.k.a((Object) findViewById15, "findViewById<View>(R.id.…show_interest_loader_lyt)");
        this.y = findViewById15;
        View findViewById16 = findViewById(R.id.tv_know_more);
        TextView textView4 = (TextView) findViewById16;
        textView4.setOnClickListener(new i(this));
        kotlin.g.b.k.a((Object) findViewById16, "(findViewById<TextView>(…)\n            }\n        }");
        this.m = textView4;
        AppCompatActivity appCompatActivity = this;
        net.one97.paytm.paymentsBank.accntfreeze.a.a().a(appCompatActivity, R.id.freezeContainer, new int[0]).a(appCompatActivity);
        Context context = this;
        net.one97.paytm.bankCommon.mapping.c.a("/fixed-deposit", "fixed-deposit", context);
        net.one97.paytm.paymentsBank.slfd.c cVar = net.one97.paytm.paymentsBank.slfd.c.f18958a;
        Context applicationContext = getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
        c.a cVar2 = new net.one97.paytm.paymentsBank.slfd.createfd.b.c(net.one97.paytm.paymentsBank.slfd.c.a(applicationContext), this);
        kotlin.g.b.k.c(cVar2, "<set-?>");
        this.f19098b = cVar2;
        f().a();
        if (!v.a(this.z)) {
            Uri parse = Uri.parse(this.z);
            if (parse == null || parse.getQueryParameter("featuretype") == null) {
                str = "";
            } else {
                str = parse.getQueryParameter("featuretype");
                if (str == null) {
                    throw new u("null cannot be cast to non-null type kotlin.String");
                }
            }
            if ("fd_projection".equals(str)) {
                if (!(parse == null || parse.getQueryParameter("fd_id") == null)) {
                    String queryParameter = parse.getQueryParameter("fd_id");
                    Intent intent = new Intent(context, InterestProjectionActivity.class);
                    intent.putExtra("fd_id", queryParameter);
                    intent.putExtra("redirect_time_line", true);
                    if (parse.getQueryParameter("shouldExpand") != null) {
                        intent.putExtra("expand_timeline", parse.getQueryParameter("shouldExpand"));
                    } else {
                        intent.putExtra("expand_timeline", false);
                    }
                    startActivity(intent);
                }
            } else if ("fd_interest_certificate".equals(str) || "fd_tds_certificate".equals(str) || "fd_form_15".equals(str)) {
                View view = this.u;
                if (view == null) {
                    kotlin.g.b.k.a();
                }
                view.performClick();
            } else if ("create_fd".equals(str)) {
                RelativeLayout relativeLayout5 = this.f19102f;
                if (relativeLayout5 == null) {
                    kotlin.g.b.k.a("rlCreateFd");
                }
                relativeLayout5.performClick();
            } else if ("fd_passbook".equals(str)) {
                View view2 = this.t;
                if (view2 != null) {
                    view2.performClick();
                }
            } else if ("fd_interest_table".equals(str)) {
                g();
            }
        }
        androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a(context);
        BroadcastReceiver broadcastReceiver = this.D;
        if (broadcastReceiver == null) {
            kotlin.g.b.k.a();
        }
        a2.a(broadcastReceiver, new IntentFilter("intent.action.updateSlfdLanding"));
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdLandingPageActivity f19115a;

        j(SlfdLandingPageActivity slfdLandingPageActivity) {
            this.f19115a = slfdLandingPageActivity;
        }

        public final void onClick(View view) {
            this.f19115a.finish();
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdLandingPageActivity f19116a;

        k(SlfdLandingPageActivity slfdLandingPageActivity) {
            this.f19116a = slfdLandingPageActivity;
        }

        public final void onClick(View view) {
            if (SlfdLandingPageActivity.a(this.f19116a).getText().equals(this.f19116a.getString(R.string.fd_show_interest)) && com.paytm.utility.b.c((Context) this.f19116a)) {
                this.f19116a.f().d();
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdLandingPageActivity f19108a;

        c(SlfdLandingPageActivity slfdLandingPageActivity) {
            this.f19108a = slfdLandingPageActivity;
        }

        public final void onClick(View view) {
            SlfdLandingPageActivity.b(this.f19108a);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdLandingPageActivity f19109a;

        d(SlfdLandingPageActivity slfdLandingPageActivity) {
            this.f19109a = slfdLandingPageActivity;
        }

        public final void onClick(View view) {
            if (net.one97.paytm.paymentsBank.utils.j.b()) {
                this.f19109a.f().a((Context) this.f19109a);
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdLandingPageActivity f19110a;

        e(SlfdLandingPageActivity slfdLandingPageActivity) {
            this.f19110a = slfdLandingPageActivity;
        }

        public final void onClick(View view) {
            Intent intent = this.f19110a.getIntent();
            intent.setClass(this.f19110a, SlfdPassbookActivity.class);
            this.f19110a.startActivity(intent);
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdLandingPageActivity f19117a;

        l(SlfdLandingPageActivity slfdLandingPageActivity) {
            this.f19117a = slfdLandingPageActivity;
        }

        public final void onClick(View view) {
            this.f19117a.g();
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdLandingPageActivity f19111a;

        f(SlfdLandingPageActivity slfdLandingPageActivity) {
            this.f19111a = slfdLandingPageActivity;
        }

        public final void onClick(View view) {
            this.f19111a.g();
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdLandingPageActivity f19112a;

        g(SlfdLandingPageActivity slfdLandingPageActivity) {
            this.f19112a = slfdLandingPageActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.bankCommon.mapping.c.a(this.f19112a, "fixed_deposit", "create_fixed_deposit_tab_clicked", (String) null, (String) null, (String) null, "/fixed-deposit/home", "fixed_deposit");
            if (n.e()) {
                this.f19112a.startActivityForResult(new Intent(this.f19112a, CreateFdActivity.class), 102);
            }
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdLandingPageActivity f19113a;

        h(SlfdLandingPageActivity slfdLandingPageActivity) {
            this.f19113a = slfdLandingPageActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.bankCommon.mapping.c.a(this.f19113a, "fixed_deposit", "redeem_fixed_deposit_tab_clicked", (String) null, (String) null, (String) null, "/fixed-deposit/home", "fixed_deposit");
            this.f19113a.f().c();
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdLandingPageActivity f19114a;

        i(SlfdLandingPageActivity slfdLandingPageActivity) {
            this.f19114a = slfdLandingPageActivity;
        }

        public final void onClick(View view) {
            this.f19114a.startActivity(new Intent(this.f19114a, FixedDepositOfferingActivity.class));
        }
    }

    public final void b(int i2) {
        if (i2 == 0) {
            RelativeLayout relativeLayout = this.f19103g;
            if (relativeLayout == null) {
                kotlin.g.b.k.a("rlRedeemFd");
            }
            if (relativeLayout != null) {
                net.one97.paytm.paymentsBank.slfd.b.a.b.b(relativeLayout);
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.rl_active_fds);
            if (relativeLayout2 != null) {
                relativeLayout2.setBackgroundColor(androidx.core.content.b.c(this, R.color.color_fafbfb));
            }
            TextView textView = (TextView) a(R.id.tv_your_investement_header);
            if (textView != null) {
                textView.setText(getString(R.string.fd_your_investments) + " (0)");
                return;
            }
            return;
        }
        RelativeLayout relativeLayout3 = this.f19103g;
        if (relativeLayout3 == null) {
            kotlin.g.b.k.a("rlRedeemFd");
        }
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(0);
        }
        RelativeLayout relativeLayout4 = (RelativeLayout) a(R.id.rl_active_fds);
        if (relativeLayout4 != null) {
            relativeLayout4.setBackgroundColor(androidx.core.content.b.c(this, R.color.color_fafbfb));
        }
        TextView textView2 = (TextView) a(R.id.tv_your_investement_header);
        if (textView2 != null) {
            textView2.setText(getString(R.string.fd_your_investments) + " (" + i2 + ")");
        }
    }

    /* access modifiers changed from: private */
    public final void g() {
        new net.one97.paytm.paymentsBank.slfd.common.view.d().show(getSupportFragmentManager(), "itTableBottomSheet");
    }

    public final void onResume() {
        super.onResume();
        this.p = true;
        h();
    }

    private final void h() {
        if (this.p) {
            this.p = false;
            this.q = true;
            f().a(false);
            ViewPager viewPager = this.k;
            if (viewPager == null) {
                kotlin.g.b.k.a("viewPager");
            }
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter instanceof a) {
                a aVar = (a) adapter;
                if (aVar.a() != null) {
                    Fragment a2 = aVar.a();
                    if (a2 instanceof net.one97.paytm.paymentsBank.slfd.common.view.e) {
                        net.one97.paytm.paymentsBank.slfd.common.view.e eVar = (net.one97.paytm.paymentsBank.slfd.common.view.e) a2;
                        eVar.a(this.s);
                        eVar.g();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
        if (r5 <= 0.0d) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.paymentsBank.model.slfd.ViewLifoFdResponse r15) {
        /*
            r14 = this;
            java.lang.String r0 = "viewLifoFdResponse"
            kotlin.g.b.k.c(r15, r0)
            java.util.List r0 = r15.getLifoFdList()
            if (r0 == 0) goto L_0x00de
            java.util.List r15 = r15.getLifoFdList()
            if (r15 == 0) goto L_0x00de
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.Iterator r15 = r15.iterator()
            r0 = 0
            r2 = r0
        L_0x001b:
            boolean r4 = r15.hasNext()
            if (r4 == 0) goto L_0x00de
            java.lang.Object r4 = r15.next()
            net.one97.paytm.paymentsBank.model.slfd.LifoRedeemFd r4 = (net.one97.paytm.paymentsBank.model.slfd.LifoRedeemFd) r4
            java.lang.Double r5 = r4.getNetInvestedAmount()
            if (r5 == 0) goto L_0x005f
            java.lang.Number r5 = (java.lang.Number) r5
            r5.doubleValue()
            java.lang.Double r5 = r4.getNetAmountPayout()
            if (r5 != 0) goto L_0x003b
            kotlin.g.b.k.a()
        L_0x003b:
            double r5 = r5.doubleValue()
            java.lang.Double r7 = r4.getRedemptionAmount()
            if (r7 == 0) goto L_0x005b
            java.lang.Number r7 = (java.lang.Number) r7
            r7.doubleValue()
            java.lang.Double r5 = r4.getNetAmountPayout()
            double r5 = r5.doubleValue()
            java.lang.Double r7 = r4.getRedemptionAmount()
            double r7 = r7.doubleValue()
            double r5 = r5 - r7
        L_0x005b:
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 > 0) goto L_0x0060
        L_0x005f:
            r5 = r0
        L_0x0060:
            java.util.HashMap<java.lang.String, java.lang.Double> r7 = r14.s
            java.lang.String r4 = r4.getFdId()
            if (r4 != 0) goto L_0x006b
            kotlin.g.b.k.a()
        L_0x006b:
            java.lang.Double r8 = java.lang.Double.valueOf(r5)
            r7.put(r4, r8)
            double r2 = r2 + r5
            int r4 = net.one97.paytm.paymentsBank.R.string.fd_intrest_earned
            r5 = 1
            java.lang.Object[] r6 = new java.lang.Object[r5]
            java.lang.Double r7 = java.lang.Double.valueOf(r2)
            java.lang.String r7 = net.one97.paytm.bankCommon.mapping.a.c(r7)
            r8 = 0
            r6[r8] = r7
            java.lang.String r4 = r14.getString(r4, r6)
            android.text.SpannableString r6 = new android.text.SpannableString
            r7 = r4
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.<init>(r7)
            android.text.Spannable r6 = (android.text.Spannable) r6
            android.text.style.ForegroundColorSpan r9 = new android.text.style.ForegroundColorSpan
            java.lang.String r10 = "#000000"
            int r10 = android.graphics.Color.parseColor(r10)
            r9.<init>(r10)
            java.lang.String r10 = "interestEarned"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r10)
            r10 = 6
            java.lang.String r11 = "₹"
            int r12 = kotlin.m.p.a((java.lang.CharSequence) r7, (java.lang.String) r11, (int) r8, (boolean) r8, (int) r10)
            r13 = 33
            r6.setSpan(r9, r8, r12, r13)
            android.text.style.ForegroundColorSpan r9 = new android.text.style.ForegroundColorSpan
            java.lang.String r12 = "#00c573"
            int r12 = android.graphics.Color.parseColor(r12)
            r9.<init>(r12)
            int r7 = kotlin.m.p.a((java.lang.CharSequence) r7, (java.lang.String) r11, (int) r8, (boolean) r8, (int) r10)
            int r7 = r7 - r5
            int r4 = r4.length()
            r6.setSpan(r9, r7, r4, r13)
            android.widget.TextView r4 = r14.l
            if (r4 != 0) goto L_0x00cf
            java.lang.String r7 = "tvIntrestEarned"
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x00cf:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            r14.b((boolean) r8)
            r14.p = r5
            r14.h()
            goto L_0x001b
        L_0x00de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.slfd.createfd.view.SlfdLandingPageActivity.a(net.one97.paytm.paymentsBank.model.slfd.ViewLifoFdResponse):void");
    }

    private final void a(Boolean bool) {
        if (!this.q) {
            String str = this.A;
            if (str != null) {
                if (str.equals("NOT_ACTIVE")) {
                    RelativeLayout relativeLayout = this.f19103g;
                    if (relativeLayout == null) {
                        kotlin.g.b.k.a("rlRedeemFd");
                    }
                    relativeLayout.setVisibility(8);
                } else if (kotlin.g.b.k.a((Object) bool, (Object) Boolean.TRUE)) {
                    RelativeLayout relativeLayout2 = this.f19103g;
                    if (relativeLayout2 == null) {
                        kotlin.g.b.k.a("rlRedeemFd");
                    }
                    relativeLayout2.setVisibility(0);
                } else {
                    RelativeLayout relativeLayout3 = this.f19103g;
                    if (relativeLayout3 == null) {
                        kotlin.g.b.k.a("rlRedeemFd");
                    }
                    relativeLayout3.setVisibility(4);
                }
            } else if (kotlin.g.b.k.a((Object) bool, (Object) Boolean.TRUE)) {
                RelativeLayout relativeLayout4 = this.f19103g;
                if (relativeLayout4 == null) {
                    kotlin.g.b.k.a("rlRedeemFd");
                }
                relativeLayout4.setVisibility(0);
            } else {
                RelativeLayout relativeLayout5 = this.f19103g;
                if (relativeLayout5 == null) {
                    kotlin.g.b.k.a("rlRedeemFd");
                }
                relativeLayout5.setVisibility(4);
            }
        }
    }

    public final void a(SlfdMetaApiResponseModel slfdMetaApiResponseModel) {
        if (slfdMetaApiResponseModel != null) {
            Intent intent = getIntent();
            intent.setClass(this, CreateSlfdActivity.class);
            intent.putExtra("slfd_meta_response", slfdMetaApiResponseModel);
            startActivity(intent);
            return;
        }
        String string = getString(R.string.pb_something_wrong_try_again);
        kotlin.g.b.k.a((Object) string, "getString(R.string.pb_something_wrong_try_again)");
        net.one97.paytm.paymentsBank.slfd.b.a.b.a((AppCompatActivity) this, (CharSequence) string);
    }

    public final void a(String str, SlfdMetaApiResponseModel slfdMetaApiResponseModel) {
        this.B = str;
        this.C = slfdMetaApiResponseModel;
        Context context = this;
        if (net.one97.paytm.bankCommon.h.b.p(context)) {
            Intent intent = getIntent();
            intent.setClass(context, RedeemFdActivity.class);
            intent.putExtra("slfd_meta_response", slfdMetaApiResponseModel);
            intent.putExtra("sfld_account_balance", str);
            startActivity(intent);
            return;
        }
        a(true);
        net.one97.paytm.paymentsBank.slfd.interestprojection.d.a a2 = net.one97.paytm.paymentsBank.slfd.interestprojection.d.a.a(context);
        kotlin.g.b.k.a((Object) a2, "InterestProjectionManage…tionManagerInstance(this)");
        a2.b(context);
        a2.a((g.b) this, (g.a) this);
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        kotlin.g.b.k.c(iJRPaytmDataModel, Payload.RESPONSE);
        a(false);
        if (iJRPaytmDataModel instanceof FDMaxLimitModel) {
            Intent intent = getIntent();
            intent.setClass(this, RedeemFdActivity.class);
            intent.putExtra("slfd_meta_response", this.C);
            intent.putExtra("sfld_account_balance", this.B);
            Double availableAmount = ((FDMaxLimitModel) iJRPaytmDataModel).getAvailableAmount();
            kotlin.g.b.k.a((Object) availableAmount, "fdMaxLimitModel.availableAmount");
            intent.putExtra("slfd_max_limit", availableAmount.doubleValue());
            startActivity(intent);
        }
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        kotlin.g.b.k.c(iJRPaytmDataModel, "model");
        kotlin.g.b.k.c(networkCustomError, "error");
        a(false);
        net.one97.paytm.bankCommon.utils.f.a((Activity) this, (Exception) networkCustomError, (String) null);
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "netInvestment");
        TextView textView = this.f19099c;
        if (textView == null) {
            kotlin.g.b.k.a("tvSlfdBalance");
        }
        textView.setVisibility(0);
        aa aaVar = aa.f47921a;
        String string = getString(R.string.rs_str);
        kotlin.g.b.k.a((Object) string, "getString(R.string.rs_str)");
        String format = String.format(string, Arrays.copyOf(new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(str)}, 1));
        kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
        TextView textView2 = this.f19099c;
        if (textView2 == null) {
            kotlin.g.b.k.a("tvSlfdBalance");
        }
        net.one97.paytm.bankCommon.mapping.e.a(format, textView2);
    }

    public final void a(double d2) {
        aa aaVar = aa.f47921a;
        String string = getString(R.string.fd_amount_without_space);
        kotlin.g.b.k.a((Object) string, "getString(R.string.fd_amount_without_space)");
        String format = String.format(string, Arrays.copyOf(new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(d2))}, 1));
        kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
        TextView textView = this.f19100d;
        if (textView == null) {
            kotlin.g.b.k.a("tvSlfdTotalInterestEarned");
        }
        net.one97.paytm.bankCommon.mapping.e.a(format, textView);
    }

    public final void a(boolean z2) {
        if (z2) {
            this.r++;
            View view = this.j;
            if (view == null) {
                kotlin.g.b.k.a("createFdGroup");
            }
            view.setVisibility(4);
            RelativeLayout relativeLayout = this.f19105i;
            if (relativeLayout == null) {
                kotlin.g.b.k.a("rlDotProgress");
            }
            relativeLayout.setVisibility(0);
            LottieAnimationView lottieAnimationView = this.f19104h;
            if (lottieAnimationView == null) {
                kotlin.g.b.k.a("lottieAnimationView");
            }
            net.one97.paytm.common.widgets.a.a(lottieAnimationView);
        } else {
            this.r--;
            if (this.r == 0) {
                RelativeLayout relativeLayout2 = this.f19105i;
                if (relativeLayout2 == null) {
                    kotlin.g.b.k.a("rlDotProgress");
                }
                relativeLayout2.setVisibility(8);
                View view2 = this.j;
                if (view2 == null) {
                    kotlin.g.b.k.a("createFdGroup");
                }
                view2.setVisibility(0);
                LottieAnimationView lottieAnimationView2 = this.f19104h;
                if (lottieAnimationView2 == null) {
                    kotlin.g.b.k.a("lottieAnimationView");
                }
                net.one97.paytm.common.widgets.a.b(lottieAnimationView2);
            }
        }
        a(Boolean.valueOf(!z2));
    }

    static final class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdLandingPageActivity f19107a;

        b(SlfdLandingPageActivity slfdLandingPageActivity) {
            this.f19107a = slfdLandingPageActivity;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f19107a.ah_();
            net.one97.paytm.bankCommon.utils.f.a((Activity) this.f19107a, (Exception) networkCustomError, (String) null);
        }
    }

    public final void a(String str, String str2) {
        kotlin.g.b.k.c(str, "errorTitle");
        kotlin.g.b.k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        com.paytm.utility.b.b((Context) this, str, str2);
    }

    public final void onDestroy() {
        super.onDestroy();
        androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) this);
        BroadcastReceiver broadcastReceiver = this.D;
        if (broadcastReceiver == null) {
            kotlin.g.b.k.a();
        }
        a2.a(broadcastReceiver);
        this.D = null;
        f().b();
    }

    public final void b(boolean z2) {
        if (z2) {
            View view = this.y;
            if (view == null) {
                kotlin.g.b.k.a("showInterestLoaderLyt");
            }
            view.setVisibility(0);
            LottieAnimationView lottieAnimationView = this.x;
            if (lottieAnimationView == null) {
                kotlin.g.b.k.a("loaderShowInterest");
            }
            lottieAnimationView.setVisibility(0);
            LottieAnimationView lottieAnimationView2 = this.x;
            if (lottieAnimationView2 == null) {
                kotlin.g.b.k.a("loaderShowInterest");
            }
            net.one97.paytm.common.widgets.a.a(lottieAnimationView2);
            TextView textView = this.l;
            if (textView == null) {
                kotlin.g.b.k.a("tvIntrestEarned");
            }
            textView.setVisibility(8);
            return;
        }
        View view2 = this.y;
        if (view2 == null) {
            kotlin.g.b.k.a("showInterestLoaderLyt");
        }
        view2.setVisibility(8);
        LottieAnimationView lottieAnimationView3 = this.x;
        if (lottieAnimationView3 == null) {
            kotlin.g.b.k.a("loaderShowInterest");
        }
        lottieAnimationView3.setVisibility(8);
        LottieAnimationView lottieAnimationView4 = this.x;
        if (lottieAnimationView4 == null) {
            kotlin.g.b.k.a("loaderShowInterest");
        }
        net.one97.paytm.common.widgets.a.b(lottieAnimationView4);
        TextView textView2 = this.l;
        if (textView2 == null) {
            kotlin.g.b.k.a("tvIntrestEarned");
        }
        textView2.setVisibility(0);
    }

    public final void a(FGHStatusModel fGHStatusModel, boolean z2) {
        if (!isFinishing() && !isDestroyed()) {
            net.one97.paytm.paymentsBank.form15g.a.b bVar = new net.one97.paytm.paymentsBank.form15g.a.b();
            Bundle bundle = new Bundle();
            bundle.putSerializable("FORM15GH_STATUS", fGHStatusModel);
            bundle.putBoolean("show_tds", z2);
            bundle.putBoolean("show_ic", true);
            if (!TextUtils.isEmpty(this.z)) {
                bundle.putString("deeplink", this.z);
            }
            bVar.setArguments(bundle);
            androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
            kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
            if (!supportFragmentManager.h()) {
                androidx.fragment.app.j supportFragmentManager2 = getSupportFragmentManager();
                kotlin.g.b.k.a((Object) supportFragmentManager2, "supportFragmentManager");
                if (!supportFragmentManager2.i()) {
                    bVar.show(getSupportFragmentManager(), bVar.getTag());
                }
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 102 && i3 == -1) {
            this.p = true;
        }
        super.onActivityResult(i2, i3, intent);
    }

    public static final /* synthetic */ void b(SlfdLandingPageActivity slfdLandingPageActivity) {
        Context context = slfdLandingPageActivity;
        if (com.paytm.utility.b.c(context)) {
            slfdLandingPageActivity.a(context, slfdLandingPageActivity.getString(R.string.pb_please_wait));
            new net.one97.paytm.paymentsBank.slfd.a.a.b.a(context).a((g.b<IJRPaytmDataModel>) new a(slfdLandingPageActivity), (g.a) new b(slfdLandingPageActivity), "A", "");
            return;
        }
        slfdLandingPageActivity.d();
    }
}
