package net.one97.paytm.coins.activity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.g;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.coins.a.a;
import net.one97.paytm.coins.c.a;
import net.one97.paytm.coins.model.CheckBalanceApiModel;
import net.one97.paytm.coins.model.LoyaltyModel;
import net.one97.paytm.common.widgets.RoboButton;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.activity.AJRCashBackBaseActivity;
import net.one97.paytm.vipcashback.f.d;

public final class PaytmCoinLandingActivity extends AJRCashBackBaseActivity implements AppBarLayout.b, a.c, a.d, net.one97.paytm.coins.c.a {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.coins.c.c f16680a;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.coins.d.a f16681d;

    /* renamed from: e  reason: collision with root package name */
    private com.google.android.material.bottomsheet.a f16682e;

    /* renamed from: f  reason: collision with root package name */
    private com.google.android.material.bottomsheet.a f16683f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f16684g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public net.one97.paytm.coins.a.a f16685h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f16686i;

    static final class k implements g.c {

        /* renamed from: a  reason: collision with root package name */
        public static final k f16697a = new k();

        k() {
        }

        public final void onDialogDismissed() {
        }
    }

    public final View a(int i2) {
        if (this.f16686i == null) {
            this.f16686i = new HashMap();
        }
        View view = (View) this.f16686i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f16686i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class e<T> implements z<ArrayList<LoyaltyModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmCoinLandingActivity f16691a;

        e(PaytmCoinLandingActivity paytmCoinLandingActivity) {
            this.f16691a = paytmCoinLandingActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList<LoyaltyModel> arrayList = (ArrayList) obj;
            PaytmCoinLandingActivity.e(this.f16691a);
            PaytmCoinLandingActivity.f(this.f16691a);
            if (arrayList == null || arrayList.size() == 0) {
                PaytmCoinLandingActivity.g(this.f16691a);
                return;
            }
            net.one97.paytm.coins.c.d dVar = net.one97.paytm.coins.c.d.f16733a;
            if (!net.one97.paytm.coins.c.d.b()) {
                PaytmCoinLandingActivity.g(this.f16691a);
                net.one97.paytm.coins.c.d dVar2 = net.one97.paytm.coins.c.d.f16733a;
                net.one97.paytm.coins.c.d.a();
            }
            net.one97.paytm.coins.a.a h2 = this.f16691a.f16685h;
            if (h2 != null && arrayList != null) {
                h2.f16638a = arrayList;
                h2.notifyDataSetChanged();
            }
        }
    }

    static final class f<T> implements z<CheckBalanceApiModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmCoinLandingActivity f16692a;

        f(PaytmCoinLandingActivity paytmCoinLandingActivity) {
            this.f16692a = paytmCoinLandingActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
            r0 = r5.getResponse();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r5) {
            /*
                r4 = this;
                net.one97.paytm.coins.model.CheckBalanceApiModel r5 = (net.one97.paytm.coins.model.CheckBalanceApiModel) r5
                net.one97.paytm.coins.activity.PaytmCoinLandingActivity r0 = r4.f16692a
                net.one97.paytm.coins.activity.PaytmCoinLandingActivity.i(r0)
                if (r5 == 0) goto L_0x0014
                net.one97.paytm.coins.model.BalanceModel r0 = r5.getResponse()
                if (r0 == 0) goto L_0x0014
                net.one97.paytm.coins.model.ResultModel r0 = r0.getResult()
                goto L_0x0015
            L_0x0014:
                r0 = 0
            L_0x0015:
                if (r0 == 0) goto L_0x0093
                if (r5 != 0) goto L_0x001c
                kotlin.g.b.k.a()
            L_0x001c:
                net.one97.paytm.coins.model.BalanceModel r0 = r5.getResponse()
                if (r0 != 0) goto L_0x0025
                kotlin.g.b.k.a()
            L_0x0025:
                net.one97.paytm.coins.model.ResultModel r0 = r0.getResult()
                if (r0 != 0) goto L_0x002e
                kotlin.g.b.k.a()
            L_0x002e:
                java.lang.String r0 = r0.getResultStatus()
                java.lang.String r1 = "S"
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L_0x008d
                net.one97.paytm.coins.model.BalanceModel r5 = r5.getResponse()
                if (r5 != 0) goto L_0x0043
                kotlin.g.b.k.a()
            L_0x0043:
                java.lang.String r5 = r5.getActiveBalance()
                if (r5 == 0) goto L_0x0087
                net.one97.paytm.coins.activity.PaytmCoinLandingActivity r0 = r4.f16692a
                java.lang.String r1 = "price"
                kotlin.g.b.k.c(r5, r1)
                int r1 = net.one97.paytm.vipcashback.R.id.tv_toolbar_total_balance
                android.view.View r1 = r0.a((int) r1)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r2 = "tv_toolbar_total_balance"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                double r2 = java.lang.Double.parseDouble(r5)
                java.lang.String r2 = net.one97.paytm.coins.c.e.a(r2)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r1.setText(r2)
                int r1 = net.one97.paytm.vipcashback.R.id.tv_paytm_balance_coins
                android.view.View r0 = r0.a((int) r1)
                com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
                java.lang.String r1 = "tv_paytm_balance_coins"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                double r1 = java.lang.Double.parseDouble(r5)
                java.lang.String r5 = net.one97.paytm.coins.c.e.a(r1)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r0.setText(r5)
                return
            L_0x0087:
                net.one97.paytm.coins.activity.PaytmCoinLandingActivity r5 = r4.f16692a
                r5.b()
                return
            L_0x008d:
                net.one97.paytm.coins.activity.PaytmCoinLandingActivity r5 = r4.f16692a
                r5.b()
                return
            L_0x0093:
                net.one97.paytm.coins.activity.PaytmCoinLandingActivity r5 = r4.f16692a
                r5.b()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.coins.activity.PaytmCoinLandingActivity.f.onChanged(java.lang.Object):void");
        }
    }

    static final class g<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmCoinLandingActivity f16693a;

        g(PaytmCoinLandingActivity paytmCoinLandingActivity) {
            this.f16693a = paytmCoinLandingActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            PaytmCoinLandingActivity.e(this.f16693a);
            PaytmCoinLandingActivity.f(this.f16693a);
            kotlin.g.b.k.a((Object) bool, "isValue");
            if (bool.booleanValue() && PaytmCoinLandingActivity.a(this.f16693a).a() == 0) {
                PaytmCoinLandingActivity.j(this.f16693a);
            }
        }
    }

    static final class i<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmCoinLandingActivity f16695a;

        i(PaytmCoinLandingActivity paytmCoinLandingActivity) {
            this.f16695a = paytmCoinLandingActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            NetworkCustomError networkCustomError = (NetworkCustomError) obj;
            kotlin.g.b.k.a((Object) networkCustomError, "error");
            if (networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403) {
                if (!this.f16695a.f16684g) {
                    this.f16695a.f16684g = true;
                    net.one97.paytm.vipcashback.c.a.b().showSessionTimeOutAlert(this.f16695a, (String) null, (Bundle) null, new NetworkCustomError(), false, true);
                }
            } else if (networkCustomError.mErrorType == NetworkCustomError.ErrorType.TimeOutError) {
                PaytmCoinLandingActivity.a(this.f16695a, networkCustomError);
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.coins.d.a a(PaytmCoinLandingActivity paytmCoinLandingActivity) {
        net.one97.paytm.coins.d.a aVar = paytmCoinLandingActivity.f16681d;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return aVar;
    }

    private static void a(LottieAnimationView lottieAnimationView, Boolean bool) {
        kotlin.g.b.k.c(lottieAnimationView, "walletLoader");
        a.C0247a.a(lottieAnimationView, bool);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_paytm_coin_landing);
        ((Toolbar) a(R.id.toolbar)).setNavigationIcon(net.one97.paytm.common.widgets.R.drawable.back_arrow);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.c(false);
        }
        ((Toolbar) a(R.id.toolbar)).setNavigationOnClickListener(new j(this));
        Context context = this;
        this.f16680a = new net.one97.paytm.coins.c.c(context, (LinearLayout) a(R.id.ll_toolbar_balance), (LinearLayout) a(R.id.ll_toolbar_header));
        ((AppBarLayout) a(R.id.appbar)).a((AppBarLayout.b) this);
        ((RoboTextView) a(R.id.tv_redeem_coins)).setOnClickListener(new d(this));
        ai a2 = am.a((FragmentActivity) this).a(net.one97.paytm.coins.d.a.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…insViewModel::class.java]");
        this.f16681d = (net.one97.paytm.coins.d.a) a2;
        net.one97.paytm.coins.d.a aVar = this.f16681d;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        q qVar = this;
        aVar.f16755b.observe(qVar, new e(this));
        f();
        a.c cVar = this;
        RecyclerView recyclerView = (RecyclerView) a(R.id.rvPassbookEntries);
        kotlin.g.b.k.a((Object) recyclerView, "rvPassbookEntries");
        kotlin.g.b.k.c(cVar, "listener");
        kotlin.g.b.k.c(recyclerView, "rvEntries");
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rvPassbookEntries);
        kotlin.g.b.k.a((Object) recyclerView2, "rvPassbookEntries");
        recyclerView2.setLayoutManager(new LinearLayoutManager(context));
        net.one97.paytm.coins.a.a aVar2 = this.f16685h;
        if (aVar2 == null) {
            aVar2 = new net.one97.paytm.coins.a.a(cVar, this);
        }
        this.f16685h = aVar2;
        net.one97.paytm.coins.a.a aVar3 = this.f16685h;
        if (aVar3 == null) {
            kotlin.g.b.k.a();
        }
        recyclerView.addItemDecoration(new net.one97.paytm.coins.e.a(aVar3));
        RecyclerView recyclerView3 = (RecyclerView) a(R.id.rvPassbookEntries);
        kotlin.g.b.k.a((Object) recyclerView3, "rvPassbookEntries");
        recyclerView3.setAdapter(this.f16685h);
        net.one97.paytm.coins.d.a aVar4 = this.f16681d;
        if (aVar4 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar4.f16754a.observe(qVar, new f(this));
        e();
        View inflate = getLayoutInflater().inflate(R.layout.paytm_coin_know_more_sheet, (ViewGroup) null);
        this.f16683f = new com.google.android.material.bottomsheet.a(context, R.style.BottomSheetDialogTheme);
        com.google.android.material.bottomsheet.a aVar5 = this.f16683f;
        if (aVar5 == null) {
            kotlin.g.b.k.a("_bottomSheetKnowDialog");
        }
        aVar5.setContentView(inflate);
        com.google.android.material.bottomsheet.a aVar6 = this.f16683f;
        if (aVar6 == null) {
            kotlin.g.b.k.a("_bottomSheetKnowDialog");
        }
        aVar6.setCanceledOnTouchOutside(false);
        kotlin.g.b.k.a((Object) inflate, "view");
        ((AppCompatImageView) inflate.findViewById(R.id.ic_know_cancel)).setOnClickListener(new c(this));
        net.one97.paytm.coins.d.a aVar7 = this.f16681d;
        if (aVar7 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar7.f16756c.observe(qVar, new g(this));
        net.one97.paytm.coins.d.a aVar8 = this.f16681d;
        if (aVar8 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar8.f16757d.observe(qVar, new h(this));
        net.one97.paytm.coins.d.a aVar9 = this.f16681d;
        if (aVar9 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar9.f16759f.observe(qVar, new i(this));
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmCoinLandingActivity f16690a;

        d(PaytmCoinLandingActivity paytmCoinLandingActivity) {
            this.f16690a = paytmCoinLandingActivity;
        }

        public final void onClick(View view) {
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            RoboTextView roboTextView = (RoboTextView) this.f16690a.a(R.id.tv_redeem_coins);
            kotlin.g.b.k.a((Object) roboTextView, "tv_redeem_coins");
            d.a.a((View) roboTextView);
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(view != null ? view.getContext() : null, "paytm_coins", "coins_passbook_redeem_clicked", kotlin.a.k.d(PaytmCoinLandingActivity.a(this.f16690a).f16760g), "", "/paytm_coins_passbook", "cashback");
            kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
            if (net.one97.paytm.vipcashback.f.f.C()) {
                PaytmCoinLandingActivity.b(this.f16690a);
                return;
            }
            PaytmCoinLandingActivity.c(this.f16690a);
            PaytmCoinLandingActivity.d(this.f16690a);
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmCoinLandingActivity f16696a;

        j(PaytmCoinLandingActivity paytmCoinLandingActivity) {
            this.f16696a = paytmCoinLandingActivity;
        }

        public final void onClick(View view) {
            this.f16696a.onBackPressed();
        }
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
        if (i2 == 0 || i2 >= -180) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.ll_toolbar_balance);
            kotlin.g.b.k.a((Object) linearLayout, "ll_toolbar_balance");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = (LinearLayout) a(R.id.ll_toolbar_header);
            kotlin.g.b.k.a((Object) linearLayout2, "ll_toolbar_header");
            if (linearLayout2.getVisibility() == 8) {
                net.one97.paytm.coins.c.c cVar = this.f16680a;
                if (cVar == null) {
                    kotlin.g.b.k.a("layoutSlideAnimationUtil");
                }
                cVar.b();
                net.one97.paytm.coins.c.c cVar2 = this.f16680a;
                if (cVar2 == null) {
                    kotlin.g.b.k.a("layoutSlideAnimationUtil");
                }
                cVar2.d();
                LinearLayout linearLayout3 = (LinearLayout) a(R.id.ll_toolbar_header);
                kotlin.g.b.k.a((Object) linearLayout3, "ll_toolbar_header");
                linearLayout3.setVisibility(0);
                return;
            }
            return;
        }
        LinearLayout linearLayout4 = (LinearLayout) a(R.id.ll_toolbar_header);
        kotlin.g.b.k.a((Object) linearLayout4, "ll_toolbar_header");
        linearLayout4.setVisibility(8);
        LinearLayout linearLayout5 = (LinearLayout) a(R.id.ll_toolbar_balance);
        kotlin.g.b.k.a((Object) linearLayout5, "ll_toolbar_balance");
        if (linearLayout5.getVisibility() == 8) {
            net.one97.paytm.coins.c.c cVar3 = this.f16680a;
            if (cVar3 == null) {
                kotlin.g.b.k.a("layoutSlideAnimationUtil");
            }
            cVar3.c();
            net.one97.paytm.coins.c.c cVar4 = this.f16680a;
            if (cVar4 == null) {
                kotlin.g.b.k.a("layoutSlideAnimationUtil");
            }
            cVar4.a();
            LinearLayout linearLayout6 = (LinearLayout) a(R.id.ll_toolbar_balance);
            kotlin.g.b.k.a((Object) linearLayout6, "ll_toolbar_balance");
            linearLayout6.setVisibility(0);
        }
    }

    private final void c() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.loaderCenter);
        kotlin.g.b.k.a((Object) lottieAnimationView, "loaderCenter");
        a(lottieAnimationView, Boolean.TRUE);
    }

    private final void d() {
        a(true);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.checkBalanceloader);
        kotlin.g.b.k.a((Object) lottieAnimationView, "checkBalanceloader");
        a(lottieAnimationView, Boolean.TRUE);
    }

    public final void a(LoyaltyModel loyaltyModel) {
        kotlin.g.b.k.c(loyaltyModel, "transaction");
        Context context = this;
        net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(context, "paytm_coins", "coins_passbook_detail_clicked", new ArrayList(), "", "/paytm_coins_passbook", "cashback");
        Intent intent = new Intent(context, PaytmCoinsPassbookTransactionDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("loyalty_model_key", loyaltyModel);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public final void a() {
        net.one97.paytm.coins.d.a aVar = this.f16681d;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        if (aVar.f16762i > 1 && aVar.f16758e != null) {
            if (aVar.f16758e.getTotalPage() == null) {
                aVar.f16761h = false;
            } else {
                int i2 = aVar.f16762i;
                Integer totalPage = aVar.f16758e.getTotalPage();
                if (totalPage == null) {
                    kotlin.g.b.k.a();
                }
                if (i2 > totalPage.intValue()) {
                    aVar.f16761h = false;
                }
            }
        }
        if (aVar.f16761h) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.loaderBottom);
            kotlin.g.b.k.a((Object) lottieAnimationView, "loaderBottom");
            a(lottieAnimationView, Boolean.TRUE);
            net.one97.paytm.coins.d.a aVar2 = this.f16681d;
            if (aVar2 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            aVar2.c();
        }
    }

    public final void b() {
        TextView textView = (TextView) a(R.id.tv_toolbar_total_balance);
        kotlin.g.b.k.a((Object) textView, "tv_toolbar_total_balance");
        textView.setText("--");
        RoboTextView roboTextView = (RoboTextView) a(R.id.tv_paytm_balance_coins);
        kotlin.g.b.k.a((Object) roboTextView, "tv_paytm_balance_coins");
        roboTextView.setText("--");
    }

    private void a(boolean z) {
        if (z) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.checkBalanceloader);
            kotlin.g.b.k.a((Object) lottieAnimationView, "checkBalanceloader");
            lottieAnimationView.setVisibility(0);
            RoboTextView roboTextView = (RoboTextView) a(R.id.tv_paytm_balance_coins);
            kotlin.g.b.k.a((Object) roboTextView, "tv_paytm_balance_coins");
            roboTextView.setVisibility(4);
            return;
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) a(R.id.checkBalanceloader);
        kotlin.g.b.k.a((Object) lottieAnimationView2, "checkBalanceloader");
        lottieAnimationView2.setVisibility(4);
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tv_paytm_balance_coins);
        kotlin.g.b.k.a((Object) roboTextView2, "tv_paytm_balance_coins");
        roboTextView2.setVisibility(0);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmCoinLandingActivity f16687a;

        a(PaytmCoinLandingActivity paytmCoinLandingActivity) {
            this.f16687a = paytmCoinLandingActivity;
        }

        public final void onClick(View view) {
            PaytmCoinLandingActivity.m(this.f16687a);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmCoinLandingActivity f16688a;

        b(PaytmCoinLandingActivity paytmCoinLandingActivity) {
            this.f16688a = paytmCoinLandingActivity;
        }

        public final void onClick(View view) {
            PaytmCoinLandingActivity.m(this.f16688a);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmCoinLandingActivity f16689a;

        c(PaytmCoinLandingActivity paytmCoinLandingActivity) {
            this.f16689a = paytmCoinLandingActivity;
        }

        public final void onClick(View view) {
            PaytmCoinLandingActivity.n(this.f16689a);
        }
    }

    public final void attachBaseContext(Context context) {
        kotlin.g.b.k.c(context, "newBase");
        ContextWrapper baseContext = net.one97.paytm.vipcashback.c.a.b().getBaseContext(context);
        kotlin.g.b.k.a((Object) baseContext, "CashbackHelper.getImplLi…).getBaseContext(newBase)");
        super.attachBaseContext(baseContext);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    /* access modifiers changed from: private */
    public final void e() {
        d();
        net.one97.paytm.coins.d.a aVar = this.f16681d;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar.b();
    }

    /* access modifiers changed from: private */
    public final void f() {
        c();
        net.one97.paytm.coins.d.a aVar = this.f16681d;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar.c();
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmCoinLandingActivity f16698a;

        l(PaytmCoinLandingActivity paytmCoinLandingActivity) {
            this.f16698a = paytmCoinLandingActivity;
        }

        public final void onClick(View view) {
            if (PaytmCoinLandingActivity.a(this.f16698a).a() == 0) {
                this.f16698a.f();
                RecyclerView recyclerView = (RecyclerView) this.f16698a.a(R.id.rvPassbookEntries);
                kotlin.g.b.k.a((Object) recyclerView, "rvPassbookEntries");
                recyclerView.setVisibility(0);
                NestedScrollView nestedScrollView = (NestedScrollView) this.f16698a.a(R.id.nested_sroll_try_again);
                kotlin.g.b.k.a((Object) nestedScrollView, "nested_sroll_try_again");
                nestedScrollView.setVisibility(4);
            }
            if (Double.parseDouble(PaytmCoinLandingActivity.a(this.f16698a).f16760g) == 0.0d) {
                this.f16698a.e();
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 3) {
            if (i3 == -1) {
                e();
                f();
                RecyclerView recyclerView = (RecyclerView) a(R.id.rvPassbookEntries);
                kotlin.g.b.k.a((Object) recyclerView, "rvPassbookEntries");
                recyclerView.setVisibility(0);
                NestedScrollView nestedScrollView = (NestedScrollView) a(R.id.nested_sroll_try_again);
                kotlin.g.b.k.a((Object) nestedScrollView, "nested_sroll_try_again");
                nestedScrollView.setVisibility(4);
                this.f16684g = false;
            } else if (i3 == 0) {
                finish();
            }
        } else if (i2 == 1000 && com.paytm.utility.b.c((Context) this)) {
            e();
        }
    }

    static final class h<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmCoinLandingActivity f16694a;

        h(PaytmCoinLandingActivity paytmCoinLandingActivity) {
            this.f16694a = paytmCoinLandingActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            PaytmCoinLandingActivity.i(this.f16694a);
            this.f16694a.b();
        }
    }

    public static final /* synthetic */ void b(PaytmCoinLandingActivity paytmCoinLandingActivity) {
        kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
        String W = net.one97.paytm.vipcashback.f.f.W();
        if (W != null) {
            net.one97.paytm.vipcashback.c.a.b().checkDeepLinking(paytmCoinLandingActivity, W);
        }
    }

    public static final /* synthetic */ void c(PaytmCoinLandingActivity paytmCoinLandingActivity) {
        View inflate = paytmCoinLandingActivity.getLayoutInflater().inflate(R.layout.paytm_coin_bottom_sheet, (ViewGroup) null);
        net.one97.paytm.coins.d.a aVar = paytmCoinLandingActivity.f16681d;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        double parseDouble = Double.parseDouble(aVar.f16760g);
        kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
        String D = net.one97.paytm.vipcashback.f.f.D();
        kotlin.g.b.k.a((Object) D, "GTMHelper.getInstance().gtmKeyPaytmRedeemLimit");
        if (parseDouble >= Double.parseDouble(D)) {
            kotlin.g.b.k.a((Object) inflate, "view");
            TextView textView = (TextView) inflate.findViewById(R.id.tv_redeem_point_msg);
            kotlin.g.b.k.a((Object) textView, "view.tv_redeem_point_msg");
            textView.setText(paytmCoinLandingActivity.getString(R.string.jr_pp_redeem_limit_flow_error));
        } else {
            kotlin.g.b.k.a((Object) inflate, "view");
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_redeem_point_msg);
            kotlin.g.b.k.a((Object) textView2, "view.tv_redeem_point_msg");
            int i2 = R.string.reedeem_coin_text;
            kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
            textView2.setText(paytmCoinLandingActivity.getString(i2, new Object[]{net.one97.paytm.vipcashback.f.f.D()}));
        }
        paytmCoinLandingActivity.f16682e = new com.google.android.material.bottomsheet.a(paytmCoinLandingActivity, R.style.BottomSheetDialogTheme);
        com.google.android.material.bottomsheet.a aVar2 = paytmCoinLandingActivity.f16682e;
        if (aVar2 == null) {
            kotlin.g.b.k.a("_bottomSheetDialog");
        }
        aVar2.setContentView(inflate);
        com.google.android.material.bottomsheet.a aVar3 = paytmCoinLandingActivity.f16682e;
        if (aVar3 == null) {
            kotlin.g.b.k.a("_bottomSheetDialog");
        }
        aVar3.setCanceledOnTouchOutside(false);
        ((AppCompatImageView) inflate.findViewById(R.id.ic_cancel)).setOnClickListener(new a(paytmCoinLandingActivity));
        ((RoboButton) inflate.findViewById(R.id.btn_button_click)).setOnClickListener(new b(paytmCoinLandingActivity));
    }

    public static final /* synthetic */ void d(PaytmCoinLandingActivity paytmCoinLandingActivity) {
        com.google.android.material.bottomsheet.a aVar = paytmCoinLandingActivity.f16682e;
        if (aVar == null) {
            kotlin.g.b.k.a("_bottomSheetDialog");
        }
        aVar.show();
    }

    public static final /* synthetic */ void e(PaytmCoinLandingActivity paytmCoinLandingActivity) {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) paytmCoinLandingActivity.a(R.id.loaderCenter);
        kotlin.g.b.k.a((Object) lottieAnimationView, "loaderCenter");
        a(lottieAnimationView, Boolean.FALSE);
    }

    public static final /* synthetic */ void f(PaytmCoinLandingActivity paytmCoinLandingActivity) {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) paytmCoinLandingActivity.a(R.id.loaderBottom);
        kotlin.g.b.k.a((Object) lottieAnimationView, "loaderBottom");
        a(lottieAnimationView, Boolean.FALSE);
    }

    public static final /* synthetic */ void g(PaytmCoinLandingActivity paytmCoinLandingActivity) {
        com.google.android.material.bottomsheet.a aVar = paytmCoinLandingActivity.f16683f;
        if (aVar == null) {
            kotlin.g.b.k.a("_bottomSheetKnowDialog");
        }
        aVar.show();
    }

    public static final /* synthetic */ void i(PaytmCoinLandingActivity paytmCoinLandingActivity) {
        paytmCoinLandingActivity.a(false);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) paytmCoinLandingActivity.a(R.id.checkBalanceloader);
        kotlin.g.b.k.a((Object) lottieAnimationView, "checkBalanceloader");
        a(lottieAnimationView, Boolean.FALSE);
    }

    public static final /* synthetic */ void j(PaytmCoinLandingActivity paytmCoinLandingActivity) {
        RecyclerView recyclerView = (RecyclerView) paytmCoinLandingActivity.a(R.id.rvPassbookEntries);
        kotlin.g.b.k.a((Object) recyclerView, "rvPassbookEntries");
        recyclerView.setVisibility(4);
        NestedScrollView nestedScrollView = (NestedScrollView) paytmCoinLandingActivity.a(R.id.nested_sroll_try_again);
        kotlin.g.b.k.a((Object) nestedScrollView, "nested_sroll_try_again");
        nestedScrollView.setVisibility(0);
        ((RelativeLayout) paytmCoinLandingActivity.a(R.id.rl_try_again)).setOnClickListener(new l(paytmCoinLandingActivity));
    }

    public static final /* synthetic */ void a(PaytmCoinLandingActivity paytmCoinLandingActivity, NetworkCustomError networkCustomError) {
        Context context = paytmCoinLandingActivity;
        com.paytm.utility.g.b(context, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage(), k.f16697a);
    }

    public static final /* synthetic */ void m(PaytmCoinLandingActivity paytmCoinLandingActivity) {
        com.google.android.material.bottomsheet.a aVar = paytmCoinLandingActivity.f16682e;
        if (aVar == null) {
            kotlin.g.b.k.a("_bottomSheetDialog");
        }
        aVar.hide();
    }

    public static final /* synthetic */ void n(PaytmCoinLandingActivity paytmCoinLandingActivity) {
        com.google.android.material.bottomsheet.a aVar = paytmCoinLandingActivity.f16683f;
        if (aVar == null) {
            kotlin.g.b.k.a("_bottomSheetKnowDialog");
        }
        aVar.hide();
    }
}
