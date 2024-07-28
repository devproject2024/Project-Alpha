package net.one97.paytm.coins.activity;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.paytm.android.chat.utils.ChatAnalyticsHelperKt;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.g;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.u;
import net.one97.paytm.coins.a.b;
import net.one97.paytm.coins.c.a;
import net.one97.paytm.coins.customview.SlideButton;
import net.one97.paytm.coins.d.b;
import net.one97.paytm.coins.model.Attributes;
import net.one97.paytm.coins.model.BalanceModel;
import net.one97.paytm.coins.model.CheckBalanceApiModel;
import net.one97.paytm.coins.model.CheckoutModel;
import net.one97.paytm.coins.model.CollectModel;
import net.one97.paytm.coins.model.ResultModel;
import net.one97.paytm.coins.model.Reward;
import net.one97.paytm.coins.model.RewardsModel;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.activity.AJRCashBackBaseActivity;
import net.one97.paytm.vipcashback.f.d;
import org.json.JSONObject;

public final class PointsRewardListActivity extends AJRCashBackBaseActivity implements b.C0246b, net.one97.paytm.coins.c.a {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.coins.d.b f16703a;

    /* renamed from: d  reason: collision with root package name */
    private com.google.android.material.bottomsheet.a f16704d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public net.one97.paytm.coins.a.b f16705e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public double f16706f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f16707g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f16708h = true;

    /* renamed from: i  reason: collision with root package name */
    private String f16709i = "";
    /* access modifiers changed from: private */
    public boolean j;
    private String k;
    private String l;
    private HashMap m;

    public final View a(int i2) {
        if (this.m == null) {
            this.m = new HashMap();
        }
        View view = (View) this.m.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.m.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a<T> implements z<ArrayList<Reward>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PointsRewardListActivity f16710a;

        a(PointsRewardListActivity pointsRewardListActivity) {
            this.f16710a = pointsRewardListActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList<Reward> arrayList = (ArrayList) obj;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f16710a.a(R.id.loaderInCenter);
            kotlin.g.b.k.a((Object) lottieAnimationView, "loaderInCenter");
            PointsRewardListActivity.a(lottieAnimationView);
            arrayList.add(0, new Reward((String) null, (String) null, (Attributes) null, 7, (kotlin.g.b.g) null));
            net.one97.paytm.coins.a.b h2 = this.f16710a.f16705e;
            if (h2 != null) {
                double i2 = this.f16710a.f16706f;
                if (arrayList != null) {
                    h2.f16651a = arrayList;
                    if (i2 > 0.0d) {
                        h2.f16654d = i2;
                    }
                    h2.notifyDataSetChanged();
                }
            }
        }
    }

    static final class e<T> implements z<CollectModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PointsRewardListActivity f16714a;

        e(PointsRewardListActivity pointsRewardListActivity) {
            this.f16714a = pointsRewardListActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String order_id = ((CollectModel) obj).getORDER_ID();
            if (order_id != null) {
                this.f16714a.f16708h = true;
                PointsRewardListActivity.a(this.f16714a, order_id);
            }
        }
    }

    static final class f<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PointsRewardListActivity f16715a;

        f(PointsRewardListActivity pointsRewardListActivity) {
            this.f16715a = pointsRewardListActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.a((Object) bool, "isValue");
            if (bool.booleanValue()) {
                this.f16715a.f16708h = true;
                this.f16715a.a("", "");
                net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(this.f16715a, "paytm_coins", "coins_redemption_failed", kotlin.a.k.d(this.f16715a.f16709i), "", "/paytm_order_failed", "cashback");
            }
        }
    }

    static final class g<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PointsRewardListActivity f16716a;

        g(PointsRewardListActivity pointsRewardListActivity) {
            this.f16716a = pointsRewardListActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            NetworkCustomError networkCustomError = (NetworkCustomError) obj;
            kotlin.g.b.k.a((Object) networkCustomError, "error");
            int statusCode = networkCustomError.getStatusCode();
            if (statusCode != 410 && statusCode != 401 && statusCode != 403) {
                this.f16716a.f16708h = true;
                PointsRewardListActivity.a(this.f16716a, networkCustomError);
                net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(this.f16716a, "paytm_coins", "coins_redemption_failed", kotlin.a.k.d(this.f16716a.f16709i), "", "/paytm_order_failed", "cashback");
            } else if (!this.f16716a.j) {
                this.f16716a.j = true;
                net.one97.paytm.vipcashback.c.a.b().showSessionTimeOutAlert(this.f16716a, (String) null, (Bundle) null, new NetworkCustomError(), false, true);
            }
        }
    }

    private static void a(LottieAnimationView lottieAnimationView, Boolean bool) {
        kotlin.g.b.k.c(lottieAnimationView, "walletLoader");
        a.C0247a.a(lottieAnimationView, bool);
    }

    public static final /* synthetic */ net.one97.paytm.coins.d.b g(PointsRewardListActivity pointsRewardListActivity) {
        net.one97.paytm.coins.d.b bVar = pointsRewardListActivity.f16703a;
        if (bVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return bVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_point_reward);
        ai a2 = am.a((FragmentActivity) this).a(net.one97.paytm.coins.d.b.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…ardViewModel::class.java]");
        this.f16703a = (net.one97.paytm.coins.d.b) a2;
        Intent intent = getIntent();
        kotlin.g.b.k.a((Object) intent, "intent");
        Bundle extras = intent.getExtras();
        String str = null;
        this.k = extras != null ? extras.getString("flowType") : null;
        if (extras != null) {
            str = extras.getString("mId");
        }
        this.l = str;
        net.one97.paytm.coins.d.b bVar = this.f16703a;
        if (bVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        String str2 = this.k;
        String str3 = this.l;
        bVar.f16769e = str2;
        bVar.f16770f = str3;
        net.one97.paytm.coins.d.b bVar2 = this.f16703a;
        if (bVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        q qVar = this;
        bVar2.f16766b.observe(qVar, new e(this));
        net.one97.paytm.coins.d.b bVar3 = this.f16703a;
        if (bVar3 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        bVar3.f16767c.observe(qVar, new f(this));
        net.one97.paytm.coins.d.b bVar4 = this.f16703a;
        if (bVar4 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        bVar4.f16768d.observe(qVar, new g(this));
        g();
        ((RecyclerView) a(R.id.recycler_view)).addOnItemTouchListener(new h(this));
        ((ImageView) a(R.id.iv_back_arrow_img)).setOnClickListener(new i(this));
    }

    public static final class h extends RecyclerView.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PointsRewardListActivity f16717a;

        h(PointsRewardListActivity pointsRewardListActivity) {
            this.f16717a = pointsRewardListActivity;
        }

        public final boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            kotlin.g.b.k.c(recyclerView, "rv");
            kotlin.g.b.k.c(motionEvent, "e");
            return !this.f16717a.f16708h;
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PointsRewardListActivity f16718a;

        i(PointsRewardListActivity pointsRewardListActivity) {
            this.f16718a = pointsRewardListActivity;
        }

        public final void onClick(View view) {
            this.f16718a.finish();
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PointsRewardListActivity f16711a;

        b(PointsRewardListActivity pointsRewardListActivity) {
            this.f16711a = pointsRewardListActivity;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            String activeBalance;
            ResultModel result;
            this.f16711a.f16707g = false;
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CheckBalanceApiModel)) {
                CheckBalanceApiModel checkBalanceApiModel = (CheckBalanceApiModel) iJRPaytmDataModel;
                BalanceModel response = checkBalanceApiModel.getResponse();
                String str = null;
                if ((response != null ? response.getResult() : null) != null) {
                    BalanceModel response2 = checkBalanceApiModel.getResponse();
                    if (!(response2 == null || (result = response2.getResult()) == null)) {
                        str = result.getResultStatus();
                    }
                    if ("S".equals(str)) {
                        BalanceModel response3 = checkBalanceApiModel.getResponse();
                        if (response3 == null || (activeBalance = response3.getActiveBalance()) == null) {
                            this.f16711a.b();
                        } else {
                            this.f16711a.a(activeBalance);
                        }
                    } else {
                        this.f16711a.b();
                    }
                } else {
                    this.f16711a.b();
                }
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "p1");
            kotlin.g.b.k.c(networkCustomError, "p2");
            PointsRewardListActivity.g(this.f16711a).f16768d.postValue(networkCustomError);
            this.f16711a.f16707g = false;
        }
    }

    private final void d() {
        net.one97.paytm.coins.d.b bVar = this.f16703a;
        if (bVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        bVar.a((com.paytm.network.listener.b) new b(this));
    }

    private final void e() {
        String str;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.loaderInCenter);
        kotlin.g.b.k.a((Object) lottieAnimationView, "loaderInCenter");
        b(lottieAnimationView);
        net.one97.paytm.coins.d.b bVar = this.f16703a;
        if (bVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        if (bVar.a()) {
            kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
            str = net.one97.paytm.vipcashback.f.f.J();
        } else {
            kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
            str = net.one97.paytm.vipcashback.f.f.I();
        }
        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
        d.a.c().a(a.C0715a.GET).a(str).b((String) null).a((Map<String, String>) bVar.a("default")).a((IJRPaytmDataModel) new RewardsModel((ArrayList) null, 1, (kotlin.g.b.g) null)).a(a.c.CASHBACK).a(a.b.USER_FACING).c("PaytmCoinLandingActivity").a((com.paytm.network.listener.b) new b.c(bVar)).l().a();
    }

    public static void a(LottieAnimationView lottieAnimationView) {
        kotlin.g.b.k.c(lottieAnimationView, "loader");
        a(lottieAnimationView, Boolean.FALSE);
    }

    private static void b(LottieAnimationView lottieAnimationView) {
        kotlin.g.b.k.c(lottieAnimationView, "loader");
        a(lottieAnimationView, Boolean.TRUE);
    }

    public final void a() {
        String string = getString(R.string.jr_pc_gv_title);
        String string2 = getString(R.string.jr_pc_gv_description);
        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
        AppCompatActivity appCompatActivity = this;
        kotlin.g.b.k.c(appCompatActivity, "activity");
        com.google.android.material.bottomsheet.a aVar2 = new com.google.android.material.bottomsheet.a(appCompatActivity, R.style.BottomSheetDialogTheme);
        View inflate = appCompatActivity.getLayoutInflater().inflate(R.layout.cb_offer_details_bottomsheet_lyt, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.title);
        kotlin.g.b.k.a((Object) findViewById, "bottomSheetView.findViewById<TextView>(R.id.title)");
        ((TextView) findViewById).setText(string);
        TextView textView = (TextView) inflate.findViewById(R.id.tnc_text);
        kotlin.g.b.k.a((Object) textView, "tncTV");
        textView.setText(string2);
        ((ImageView) inflate.findViewById(R.id.close)).setOnClickListener(new d.a.p(aVar2));
        aVar2.setContentView(inflate);
        aVar2.show();
    }

    public final void b() {
        this.f16706f = 0.0d;
        net.one97.paytm.coins.a.b bVar = this.f16705e;
        if (bVar != null) {
            bVar.a(this.f16706f);
        }
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "price");
        this.f16706f = Double.parseDouble(str);
        net.one97.paytm.coins.a.b bVar = this.f16705e;
        if (bVar != null) {
            bVar.a(this.f16706f);
        }
    }

    public final void a(int i2, Reward reward) {
        kotlin.g.b.k.c(reward, "_reward");
        Toast.makeText(this, "Open view Detail Page : ".concat(String.valueOf(i2)), 1).show();
    }

    public final void a(int i2, Reward reward, SlideButton slideButton) {
        kotlin.g.b.k.c(reward, "_reward");
        kotlin.g.b.k.c(slideButton, "sliderButton");
        String product_id = reward.getProduct_id();
        if (product_id == null) {
            kotlin.g.b.k.a();
        }
        this.f16709i = product_id;
        this.f16708h = false;
        net.one97.paytm.coins.d.b bVar = this.f16703a;
        if (bVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        bVar.a((com.paytm.network.listener.b) new j(this, reward, i2, slideButton));
    }

    public static final class j implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PointsRewardListActivity f16719a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Reward f16720b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f16721c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SlideButton f16722d;

        j(PointsRewardListActivity pointsRewardListActivity, Reward reward, int i2, SlideButton slideButton) {
            this.f16719a = pointsRewardListActivity;
            this.f16720b = reward;
            this.f16721c = i2;
            this.f16722d = slideButton;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            String activeBalance;
            ResultModel result;
            if (iJRPaytmDataModel != null) {
                if (iJRPaytmDataModel instanceof CheckBalanceApiModel) {
                    CheckBalanceApiModel checkBalanceApiModel = (CheckBalanceApiModel) iJRPaytmDataModel;
                    BalanceModel response = checkBalanceApiModel.getResponse();
                    String str = null;
                    if ((response != null ? response.getResult() : null) != null) {
                        BalanceModel response2 = checkBalanceApiModel.getResponse();
                        if (!(response2 == null || (result = response2.getResult()) == null)) {
                            str = result.getResultStatus();
                        }
                        if ("S".equals(str)) {
                            BalanceModel response3 = checkBalanceApiModel.getResponse();
                            if (response3 == null || (activeBalance = response3.getActiveBalance()) == null) {
                                PointsRewardListActivity.a(this.f16719a, this.f16722d);
                                return;
                            }
                            this.f16719a.a(activeBalance);
                            String product_id = this.f16720b.getProduct_id();
                            if (product_id != null) {
                                net.one97.paytm.coins.d.b g2 = PointsRewardListActivity.g(this.f16719a);
                                int i2 = this.f16721c;
                                SlideButton slideButton = this.f16722d;
                                kotlin.g.b.k.c(slideButton, "sliderButton");
                                kotlin.g.b.k.c(product_id, "productId");
                                kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
                                String K = net.one97.paytm.vipcashback.f.f.K();
                                net.one97.paytm.vipcashback.c.a a2 = net.one97.paytm.vipcashback.c.a.a();
                                kotlin.g.b.k.a((Object) a2, "CashbackHelper.getInstance()");
                                if (a2.c().equals(ChatAnalyticsHelperKt.VALUE_EVENT_DEVICE_PLATFORM_P4B) || g2.a()) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(K);
                                    sb.append("&sso_token=");
                                    net.one97.paytm.vipcashback.c.b b2 = net.one97.paytm.vipcashback.c.a.b();
                                    kotlin.g.b.k.a((Object) b2, "CashbackHelper.getImplListener()");
                                    sb.append(b2.getSSOToken());
                                    K = sb.toString();
                                }
                                String b3 = net.one97.paytm.coins.d.b.b(product_id);
                                HashMap<String, String> appCommonHeaders = net.one97.paytm.vipcashback.c.a.b().getAppCommonHeaders();
                                if (appCommonHeaders == null) {
                                    appCommonHeaders = new HashMap<>();
                                }
                                appCommonHeaders.put("Content-Type", "application/json");
                                net.one97.paytm.vipcashback.c.b b4 = net.one97.paytm.vipcashback.c.a.b();
                                kotlin.g.b.k.a((Object) b4, "CashbackHelper.getImplListener()");
                                appCommonHeaders.put(AppConstants.SSO_TOKEN, b4.getSSOToken());
                                if (g2.a()) {
                                    appCommonHeaders.putAll(g2.c("checkoutType"));
                                }
                                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                                d.a.c().a(a.C0715a.POST).a(K).b(b3).a((Map<String, String>) appCommonHeaders).a((IJRPaytmDataModel) new CheckoutModel((String) null, (String) null, (String) null, (String) null, (String) null, (Object) null, 63, (kotlin.g.b.g) null)).a(a.c.CASHBACK).a(a.b.USER_FACING).c("PaytmCoinLandingActivity").a((com.paytm.network.listener.b) new b.a(g2, i2, slideButton)).l().a();
                                return;
                            }
                        } else {
                            PointsRewardListActivity.a(this.f16719a, this.f16722d);
                            return;
                        }
                    } else {
                        PointsRewardListActivity.a(this.f16719a, this.f16722d);
                        return;
                    }
                }
                PointsRewardListActivity.a(this.f16719a, this.f16722d);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "p1");
            kotlin.g.b.k.c(networkCustomError, "error");
            PointsRewardListActivity.a(this.f16719a, this.f16722d);
            PointsRewardListActivity.g(this.f16719a).f16768d.postValue(networkCustomError);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PointsRewardListActivity f16712a;

        c(PointsRewardListActivity pointsRewardListActivity) {
            this.f16712a = pointsRewardListActivity;
        }

        public final void onClick(View view) {
            PointsRewardListActivity.j(this.f16712a);
        }
    }

    static final class k implements g.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PointsRewardListActivity f16723a;

        k(PointsRewardListActivity pointsRewardListActivity) {
            this.f16723a = pointsRewardListActivity;
        }

        public final void onDialogDismissed() {
            this.f16723a.finish();
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str, String str2) {
        com.paytm.utility.g.b(this, str, str2, new k(this));
    }

    public final void onResume() {
        if (this.f16707g) {
            d();
        }
        super.onResume();
    }

    public final void a(boolean z, View view) {
        kotlin.g.b.k.c(view, "view");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view;
        if (z) {
            a(lottieAnimationView);
        } else {
            b(lottieAnimationView);
        }
    }

    public final void attachBaseContext(Context context) {
        kotlin.g.b.k.c(context, "newBase");
        ContextWrapper baseContext = net.one97.paytm.vipcashback.c.a.b().getBaseContext(context);
        kotlin.g.b.k.a((Object) baseContext, "CashbackHelper.getImplLi…).getBaseContext(newBase)");
        super.attachBaseContext(baseContext);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    private final void f() {
        d();
        net.one97.paytm.coins.d.b bVar = this.f16703a;
        if (bVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        bVar.f16765a.observe(this, new a(this));
        RecyclerView recyclerView = (RecyclerView) a(R.id.recycler_view);
        kotlin.g.b.k.a((Object) recyclerView, "recycler_view");
        Context context = this;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        net.one97.paytm.coins.a.b bVar2 = this.f16705e;
        if (bVar2 == null) {
            bVar2 = new net.one97.paytm.coins.a.b(context, this, this.f16706f, com.paytm.utility.b.a((Activity) this));
        }
        this.f16705e = bVar2;
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.recycler_view);
        kotlin.g.b.k.a((Object) recyclerView2, "recycler_view");
        recyclerView2.setAdapter(this.f16705e);
        e();
    }

    /* access modifiers changed from: private */
    public final void g() {
        Context context = this;
        if (!com.paytm.utility.b.c(context)) {
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            d.a.a(context, true, (net.one97.paytm.coins.b.a) new d(this));
            return;
        }
        f();
    }

    public static final class d implements net.one97.paytm.coins.b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PointsRewardListActivity f16713a;

        d(PointsRewardListActivity pointsRewardListActivity) {
            this.f16713a = pointsRewardListActivity;
        }

        public final void a() {
            this.f16713a.finish();
        }

        public final void b() {
            this.f16713a.g();
        }
    }

    public final void c() {
        this.f16708h = true;
        Toast.makeText(this, getString(R.string.no_internet_cb), 1).show();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 3) {
            return;
        }
        if (i3 == -1) {
            d();
            net.one97.paytm.coins.a.b bVar = this.f16705e;
            if (bVar != null && bVar.getItemCount() == 0) {
                e();
            }
            this.j = false;
        } else if (i3 == 0) {
            finish();
        }
    }

    public final void a(Reward reward) {
        String str;
        Double points_price;
        kotlin.g.b.k.c(reward, "_reward");
        Double d2 = null;
        View inflate = getLayoutInflater().inflate(R.layout.point_reward_alert_bottom_sheet, (ViewGroup) null);
        Attributes attributes = reward.getAttributes();
        if (!(attributes == null || (points_price = attributes.getPoints_price()) == null)) {
            d2 = Double.valueOf(points_price.doubleValue() - this.f16706f);
        }
        kotlin.g.b.k.a((Object) inflate, "view");
        RoboTextView roboTextView = (RoboTextView) inflate.findViewById(R.id.tv_more_to_avail);
        kotlin.g.b.k.a((Object) roboTextView, "view.tv_more_to_avail");
        int i2 = R.string.more_to_avail;
        Object[] objArr = new Object[1];
        if (d2 == null || (str = net.one97.paytm.coins.c.e.a(d2.doubleValue())) == null) {
            str = "0";
        }
        objArr[0] = str;
        roboTextView.setText(getString(i2, objArr));
        this.f16704d = new com.google.android.material.bottomsheet.a(this, R.style.BottomSheetDialogTheme);
        com.google.android.material.bottomsheet.a aVar = this.f16704d;
        if (aVar == null) {
            kotlin.g.b.k.a("_alertSheetDialog");
        }
        aVar.setContentView(inflate);
        com.google.android.material.bottomsheet.a aVar2 = this.f16704d;
        if (aVar2 == null) {
            kotlin.g.b.k.a("_alertSheetDialog");
        }
        aVar2.setCanceledOnTouchOutside(false);
        ((AppCompatImageView) inflate.findViewById(R.id.ic_cancel)).setOnClickListener(new c(this));
        com.google.android.material.bottomsheet.a aVar3 = this.f16704d;
        if (aVar3 == null) {
            kotlin.g.b.k.a("_alertSheetDialog");
        }
        aVar3.show();
    }

    public static final /* synthetic */ void a(PointsRewardListActivity pointsRewardListActivity, String str) {
        Context context = pointsRewardListActivity;
        net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(context, "paytm_coins", "coins_redemption_success", kotlin.a.k.d(pointsRewardListActivity.f16709i), "", "/paytm_order_success", "cashback");
        pointsRewardListActivity.f16707g = true;
        net.one97.paytm.coins.d.b bVar = pointsRewardListActivity.f16703a;
        if (bVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        if (bVar.a()) {
            net.one97.paytm.vipcashback.c.b b2 = net.one97.paytm.vipcashback.c.a.b();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pullRefresh", false);
            jSONObject.put("canPullDown", false);
            jSONObject.put(H5Param.LONG_SHOW_TITLEBAR, false);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("params", "?orderId=" + str + "&pgmId=" + pointsRewardListActivity.l);
            kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
            jSONObject2.put(H5TabbarUtils.MATCH_TYPE_PATH, net.one97.paytm.vipcashback.f.f.U());
            jSONObject2.put("sparams", jSONObject);
            Charset charset = kotlin.m.d.f47971a;
            String jSONObject3 = jSONObject2.toString();
            kotlin.g.b.k.a((Object) jSONObject3, "obj.toString()");
            if (jSONObject3 != null) {
                byte[] bytes = jSONObject3.getBytes(charset);
                kotlin.g.b.k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                String encodeToString = Base64.encodeToString(bytes, 0);
                String stringFromGTM = net.one97.paytm.vipcashback.c.a.b().getStringFromGTM("AID");
                if (stringFromGTM == null) {
                    stringFromGTM = "109200364bd9adad098ce67c643bade349cd01d5";
                }
                b2.checkDeepLinking(context, "paytmmp://mini-app?aId=" + stringFromGTM + "&data=" + encodeToString + "&url=https://paytm.com");
                return;
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
        net.one97.paytm.vipcashback.c.a a2 = net.one97.paytm.vipcashback.c.a.a();
        kotlin.g.b.k.a((Object) a2, "CashbackHelper.getInstance()");
        if (a2.c().equals(ChatAnalyticsHelperKt.VALUE_EVENT_DEVICE_PLATFORM_P4B)) {
            net.one97.paytm.vipcashback.c.a.b().checkDeepLinking(context, "paytmba://cash_back/points_reedeemed/".concat(String.valueOf(str)));
        } else {
            net.one97.paytm.vipcashback.c.a.b().checkDeepLinking(context, "paytmmp://wallet-addmoney?featuretype=gvTxnDetail&orderId=".concat(String.valueOf(str)));
        }
    }

    public static final /* synthetic */ void a(PointsRewardListActivity pointsRewardListActivity, NetworkCustomError networkCustomError) {
        String alertMessage = networkCustomError.getAlertMessage();
        String alertTitle = networkCustomError.getAlertTitle();
        if (alertMessage != null && alertTitle != null) {
            pointsRewardListActivity.a(alertTitle, alertMessage);
        }
    }

    public static final /* synthetic */ void a(PointsRewardListActivity pointsRewardListActivity, SlideButton slideButton) {
        slideButton.a();
        pointsRewardListActivity.f16708h = true;
    }

    public static final /* synthetic */ void j(PointsRewardListActivity pointsRewardListActivity) {
        com.google.android.material.bottomsheet.a aVar = pointsRewardListActivity.f16704d;
        if (aVar == null) {
            kotlin.g.b.k.a("_alertSheetDialog");
        }
        aVar.hide();
    }
}
