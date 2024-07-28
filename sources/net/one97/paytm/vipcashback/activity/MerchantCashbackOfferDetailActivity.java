package net.one97.paytm.vipcashback.activity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.u;
import net.one97.paytm.cashback.posttxn.Campaign;
import net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal;
import net.one97.paytm.common.entity.vipcashback.MerchantCampaignGameItem;
import net.one97.paytm.common.entity.vipcashback.MerchantCampaignGameResponse;
import net.one97.paytm.common.entity.vipcashback.MerchantCashBackMyOfferModel;
import net.one97.paytm.common.entity.vipcashback.MerchantGameItem;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.d;

public final class MerchantCashbackOfferDetailActivity extends AJRCashBackBaseActivity {
    /* access modifiers changed from: private */
    public static final String I = I;
    /* access modifiers changed from: private */
    public static final String J = J;
    /* access modifiers changed from: private */
    public static final int K = 11;

    /* renamed from: a  reason: collision with root package name */
    public static final a f20667a = new a((byte) 0);
    private LottieAnimationView A;
    private net.one97.paytm.vipcashback.a.c B;
    private boolean C;
    /* access modifiers changed from: private */
    public String D;
    /* access modifiers changed from: private */
    public boolean E;
    private boolean F;
    private net.one97.paytm.vipcashback.g.b G;
    /* access modifiers changed from: private */
    public int H = -1;
    private HashMap L;

    /* renamed from: d  reason: collision with root package name */
    private TextView f20668d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f20669e;

    /* renamed from: f  reason: collision with root package name */
    private CircularImageView f20670f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f20671g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f20672h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f20673i;
    private TextView j;
    private TextView k;
    private LinearLayout l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private LinearLayout q;
    private TextView r;
    private TextView s;
    private LinearLayout t;
    private TextView u;
    private RelativeLayout v;
    private RelativeLayout w;
    private Toolbar x;
    private AppBarLayout y;
    private RelativeLayout z;

    public final View a(int i2) {
        if (this.L == null) {
            this.L = new HashMap();
        }
        View view = (View) this.L.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.L.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class e<T> implements z<net.one97.paytm.vipcashback.f.h<Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MerchantCashbackOfferDetailActivity f20677a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MerchantGameItem f20678b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f20679c;

        e(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity, MerchantGameItem merchantGameItem, View view) {
            this.f20677a = merchantCashbackOfferDetailActivity;
            this.f20678b = merchantGameItem;
            this.f20679c = view;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.vipcashback.f.h hVar = (net.one97.paytm.vipcashback.f.h) obj;
            if (hVar != null && hVar.f20893a == 104) {
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                Context context = this.f20677a;
                T t = hVar.f20894b;
                if (t != null) {
                    d.a.a(context, (com.paytm.network.a) t, false);
                    return;
                }
                throw new u("null cannot be cast to non-null type com.paytm.network.CJRCommonNetworkCall");
            } else if (hVar != null && hVar.f20893a == 101) {
                T t2 = hVar.f20894b;
                if (t2 instanceof MerchantCashBackMyOfferModel) {
                    MerchantCashBackMyOfferModel merchantCashBackMyOfferModel = (MerchantCashBackMyOfferModel) t2;
                    if (merchantCashBackMyOfferModel.getStatus() == 1 && merchantCashBackMyOfferModel.getData() != null) {
                        MerchantGameItem data = merchantCashBackMyOfferModel.getData();
                        kotlin.g.b.k.a((Object) data, "response.data");
                        Campaign campaign = data.getCampaign();
                        kotlin.g.b.k.a((Object) campaign, "response.data.campaign");
                        Campaign campaign2 = this.f20678b.getCampaign();
                        kotlin.g.b.k.a((Object) campaign2, "merchantGameItem.campaign");
                        campaign.setMyOffersListPosition(campaign2.getMyOffersListPosition());
                        this.f20677a.hideActivateProgress(this.f20679c);
                        MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity = this.f20677a;
                        MerchantGameItem data2 = merchantCashBackMyOfferModel.getData();
                        kotlin.g.b.k.a((Object) data2, "response.data");
                        MerchantCashbackOfferDetailActivity.a(merchantCashbackOfferDetailActivity, data2, this.f20679c);
                    }
                }
            } else if (hVar == null || hVar.f20893a != 103) {
                this.f20677a.hideActivateProgress(this.f20679c);
                d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
                Throwable th = hVar != null ? hVar.f20895c : null;
                if (th != null) {
                    NetworkCustomError networkCustomError = (NetworkCustomError) th;
                    MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity2 = this.f20677a;
                    if (merchantCashbackOfferDetailActivity2 != null) {
                        d.a.a(networkCustomError, (FragmentActivity) merchantCashbackOfferDetailActivity2, Boolean.FALSE, 8);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                }
                throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
            } else {
                this.f20677a.showActivateProgress(this.f20679c);
            }
        }
    }

    public static final /* synthetic */ TextView c(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity) {
        TextView textView = merchantCashbackOfferDetailActivity.o;
        if (textView == null) {
            kotlin.g.b.k.a("tvOfferViewMoreTnc");
        }
        return textView;
    }

    public static final /* synthetic */ TextView d(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity) {
        TextView textView = merchantCashbackOfferDetailActivity.r;
        if (textView == null) {
            kotlin.g.b.k.a("tvOfferViewMoreTncCampaign");
        }
        return textView;
    }

    public static final /* synthetic */ Toolbar f(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity) {
        Toolbar toolbar = merchantCashbackOfferDetailActivity.x;
        if (toolbar == null) {
            kotlin.g.b.k.a("toolbar");
        }
        return toolbar;
    }

    public static final /* synthetic */ TextView g(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity) {
        TextView textView = merchantCashbackOfferDetailActivity.f20668d;
        if (textView == null) {
            kotlin.g.b.k.a("tvOfferTitle");
        }
        return textView;
    }

    public static final /* synthetic */ TextView h(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity) {
        TextView textView = merchantCashbackOfferDetailActivity.f20669e;
        if (textView == null) {
            kotlin.g.b.k.a("tvOfferDesc");
        }
        return textView;
    }

    public static final /* synthetic */ CircularImageView i(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity) {
        CircularImageView circularImageView = merchantCashbackOfferDetailActivity.f20670f;
        if (circularImageView == null) {
            kotlin.g.b.k.a("ivIcon");
        }
        return circularImageView;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_merchant_cashback_offer_detail);
        Application application = getApplication();
        boolean z2 = false;
        if (application != null) {
            this.G = (net.one97.paytm.vipcashback.g.b) am.a((FragmentActivity) this, (al.b) new net.one97.paytm.vipcashback.g.a(application, new String[0])).a(net.one97.paytm.vipcashback.g.b.class);
        }
        View findViewById = findViewById(R.id.tv_offer_title);
        kotlin.g.b.k.a((Object) findViewById, "findViewById(R.id.tv_offer_title)");
        this.f20668d = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.tv_offer_desc);
        kotlin.g.b.k.a((Object) findViewById2, "findViewById(R.id.tv_offer_desc)");
        this.f20669e = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.iv_icon);
        kotlin.g.b.k.a((Object) findViewById3, "findViewById(R.id.iv_icon)");
        this.f20670f = (CircularImageView) findViewById3;
        View findViewById4 = findViewById(R.id.tv_game_end_title);
        kotlin.g.b.k.a((Object) findViewById4, "findViewById(R.id.tv_game_end_title)");
        this.f20671g = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.tv_date);
        kotlin.g.b.k.a((Object) findViewById5, "findViewById(R.id.tv_date)");
        this.f20672h = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.rv_progress);
        kotlin.g.b.k.a((Object) findViewById6, "findViewById(R.id.rv_progress)");
        this.f20673i = (RecyclerView) findViewById6;
        View findViewById7 = findViewById(R.id.tv_days_left);
        kotlin.g.b.k.a((Object) findViewById7, "findViewById(R.id.tv_days_left)");
        this.j = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.tv_days_left_to_expire);
        kotlin.g.b.k.a((Object) findViewById8, "findViewById(R.id.tv_days_left_to_expire)");
        this.k = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.offer_view_more);
        kotlin.g.b.k.a((Object) findViewById9, "findViewById(R.id.offer_view_more)");
        this.o = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.offer_imp_tnc);
        kotlin.g.b.k.a((Object) findViewById10, "findViewById(R.id.offer_imp_tnc)");
        this.p = (TextView) findViewById10;
        View findViewById11 = findViewById(R.id.view_more);
        kotlin.g.b.k.a((Object) findViewById11, "findViewById(R.id.view_more)");
        this.r = (TextView) findViewById11;
        View findViewById12 = findViewById(R.id.offer_tnc);
        kotlin.g.b.k.a((Object) findViewById12, "findViewById(R.id.offer_tnc)");
        this.s = (TextView) findViewById12;
        View findViewById13 = findViewById(R.id.tv_offer_summary);
        kotlin.g.b.k.a((Object) findViewById13, "findViewById(R.id.tv_offer_summary)");
        this.m = (TextView) findViewById13;
        View findViewById14 = findViewById(R.id.tv_redemption_text);
        kotlin.g.b.k.a((Object) findViewById14, "findViewById(R.id.tv_redemption_text)");
        this.n = (TextView) findViewById14;
        View findViewById15 = findViewById(R.id.ll_offer_summary);
        kotlin.g.b.k.a((Object) findViewById15, "findViewById(R.id.ll_offer_summary)");
        this.l = (LinearLayout) findViewById15;
        View findViewById16 = findViewById(R.id.imp_termsLL);
        kotlin.g.b.k.a((Object) findViewById16, "findViewById(R.id.imp_termsLL)");
        this.q = (LinearLayout) findViewById16;
        View findViewById17 = findViewById(R.id.imp_terms_ll);
        kotlin.g.b.k.a((Object) findViewById17, "findViewById(R.id.imp_terms_ll)");
        this.t = (LinearLayout) findViewById17;
        View findViewById18 = findViewById(R.id.tv_activate_offer);
        kotlin.g.b.k.a((Object) findViewById18, "findViewById(R.id.tv_activate_offer)");
        this.u = (TextView) findViewById18;
        View findViewById19 = findViewById(R.id.rl_init_bottom);
        kotlin.g.b.k.a((Object) findViewById19, "findViewById(R.id.rl_init_bottom)");
        this.v = (RelativeLayout) findViewById19;
        View findViewById20 = findViewById(R.id.rl_activated_offer);
        kotlin.g.b.k.a((Object) findViewById20, "findViewById(R.id.rl_activated_offer)");
        this.w = (RelativeLayout) findViewById20;
        View findViewById21 = findViewById(R.id.app_bar_layout);
        kotlin.g.b.k.a((Object) findViewById21, "findViewById(R.id.app_bar_layout)");
        this.y = (AppBarLayout) findViewById21;
        View findViewById22 = findViewById(R.id.toolbar);
        kotlin.g.b.k.a((Object) findViewById22, "findViewById(R.id.toolbar)");
        this.x = (Toolbar) findViewById22;
        View findViewById23 = findViewById(R.id.layout_container);
        kotlin.g.b.k.a((Object) findViewById23, "findViewById(R.id.layout_container)");
        this.z = (RelativeLayout) findViewById23;
        View findViewById24 = findViewById(R.id.loader);
        kotlin.g.b.k.a((Object) findViewById24, "findViewById(R.id.loader)");
        this.A = (LottieAnimationView) findViewById24;
        Toolbar toolbar = this.x;
        if (toolbar == null) {
            kotlin.g.b.k.a("toolbar");
        }
        Context context = this;
        toolbar.setTitleTextColor(androidx.core.content.b.c(context, net.one97.paytm.common.assets.R.color.white));
        Toolbar toolbar2 = this.x;
        if (toolbar2 == null) {
            kotlin.g.b.k.a("toolbar");
        }
        toolbar2.setNavigationOnClickListener(new d(this));
        RecyclerView recyclerView = this.f20673i;
        if (recyclerView == null) {
            kotlin.g.b.k.a("rvProgress");
        }
        recyclerView.setNestedScrollingEnabled(false);
        Intent intent = getIntent();
        Serializable serializable = null;
        this.f20645c = intent != null ? Boolean.valueOf(intent.getBooleanExtra("IS_FROM_DRAWER", false)) : null;
        this.C = getIntent().getBooleanExtra("showHomeOnBack", false);
        this.D = getIntent().getStringExtra("action");
        Intent intent2 = getIntent();
        String stringExtra = intent2 != null ? intent2.getStringExtra("campaignid") : null;
        Intent intent3 = getIntent();
        String stringExtra2 = intent3 != null ? intent3.getStringExtra("gameid") : null;
        Intent intent4 = getIntent();
        if (intent4 != null && intent4.hasExtra("gameid")) {
            Intent intent5 = getIntent();
            if (intent5 == null) {
                kotlin.g.b.k.a();
            }
            this.H = intent5.getIntExtra("stageNumber", -1);
        }
        Intent intent6 = getIntent();
        if (intent6 != null) {
            z2 = intent6.getBooleanExtra("COMING_FROM_P4B_HOME", false);
        }
        this.F = z2;
        if (!TextUtils.isEmpty(stringExtra2)) {
            if (stringExtra2 == null) {
                kotlin.g.b.k.a();
            }
            StringBuilder sb = new StringBuilder();
            kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
            sb.append(net.one97.paytm.vipcashback.f.f.i());
            sb.append("/");
            sb.append(stringExtra2);
            String sb2 = sb.toString();
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.b a2 = d.a.c().a(a.C0715a.GET).a(sb2);
            d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.a l2 = a2.a((Map<String, String>) d.a.a(context)).a((IJRPaytmDataModel) new MerchantCashBackMyOfferModel()).c(this.f20644b).a((com.paytm.network.listener.b) new c(this)).l();
            if (com.paytm.utility.b.c(context)) {
                d();
                l2.a();
            } else {
                kotlin.g.b.k.a((Object) l2, "networkCall");
                a(l2);
            }
        } else if (!TextUtils.isEmpty(stringExtra)) {
            if (stringExtra == null) {
                kotlin.g.b.k.a();
            }
            StringBuilder sb3 = new StringBuilder();
            kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
            sb3.append(net.one97.paytm.vipcashback.f.f.i());
            sb3.append("/campaign-games/");
            sb3.append(stringExtra);
            String sb4 = sb3.toString();
            d.a aVar3 = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.b a3 = d.a.c().a(a.C0715a.GET).a(sb4);
            d.a aVar4 = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.a l3 = a3.a((Map<String, String>) d.a.a(context)).a((IJRPaytmDataModel) new MerchantCampaignGameResponse()).c(this.f20644b).a((com.paytm.network.listener.b) new b(this)).l();
            if (com.paytm.utility.b.c(context)) {
                d();
                l3.a();
            } else {
                kotlin.g.b.k.a((Object) l3, "networkCall");
                a(l3);
            }
        } else {
            Intent intent7 = getIntent();
            if (intent7 != null) {
                serializable = intent7.getSerializableExtra("offer");
            }
            a((MerchantGameItem) serializable);
        }
        AppBarLayout appBarLayout = this.y;
        if (appBarLayout == null) {
            kotlin.g.b.k.a("appBarLayout");
        }
        appBarLayout.a((AppBarLayout.b) new l(this));
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MerchantCashbackOfferDetailActivity f20675a;

        c(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity) {
            this.f20675a = merchantCashbackOfferDetailActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x006f, code lost:
            r0 = r0.getMerchantStages();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r4) {
            /*
                r3 = this;
                net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity r0 = r3.f20675a
                net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity.a((net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity) r0)
                boolean r0 = r4 instanceof net.one97.paytm.common.entity.vipcashback.MerchantCashBackMyOfferModel
                if (r0 == 0) goto L_0x00d9
                net.one97.paytm.common.entity.vipcashback.MerchantCashBackMyOfferModel r4 = (net.one97.paytm.common.entity.vipcashback.MerchantCashBackMyOfferModel) r4
                int r0 = r4.getStatus()
                r1 = 1
                if (r0 != r1) goto L_0x00ae
                net.one97.paytm.common.entity.vipcashback.MerchantGameItem r0 = r4.getData()
                if (r0 == 0) goto L_0x00ae
                net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity r0 = r3.f20675a
                net.one97.paytm.common.entity.vipcashback.MerchantGameItem r2 = r4.getData()
                r0.a((net.one97.paytm.common.entity.vipcashback.MerchantGameItem) r2)
                net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity r0 = r3.f20675a
                int r0 = r0.H
                r2 = -1
                if (r0 == r2) goto L_0x00d9
                net.one97.paytm.common.entity.vipcashback.MerchantGameItem r0 = r4.getData()
                if (r0 == 0) goto L_0x00ad
                java.util.ArrayList r0 = r0.getMerchantStages()
                if (r0 == 0) goto L_0x00ad
                java.util.Collection r0 = (java.util.Collection) r0
                boolean r0 = r0.isEmpty()
                r0 = r0 ^ r1
                if (r0 != r1) goto L_0x00d9
                net.one97.paytm.common.entity.vipcashback.MerchantGameItem r0 = r4.getData()
                if (r0 == 0) goto L_0x00ad
                java.util.ArrayList r0 = r0.getMerchantStages()
                if (r0 == 0) goto L_0x00ad
                net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity r2 = r3.f20675a
                int r2 = r2.H
                java.lang.Object r0 = r0.get(r2)
                net.one97.paytm.common.entity.vipcashback.MerchantStage r0 = (net.one97.paytm.common.entity.vipcashback.MerchantStage) r0
                if (r0 == 0) goto L_0x00ad
                java.util.ArrayList r0 = r0.getTasks()
                if (r0 == 0) goto L_0x00ad
                java.util.Collection r0 = (java.util.Collection) r0
                boolean r0 = r0.isEmpty()
                r0 = r0 ^ r1
                if (r0 != r1) goto L_0x00d9
                net.one97.paytm.common.entity.vipcashback.MerchantGameItem r0 = r4.getData()
                r1 = 0
                if (r0 == 0) goto L_0x0082
                java.util.ArrayList r0 = r0.getMerchantStages()
                if (r0 == 0) goto L_0x0082
                net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity r2 = r3.f20675a
                int r2 = r2.H
                java.lang.Object r0 = r0.get(r2)
                net.one97.paytm.common.entity.vipcashback.MerchantStage r0 = (net.one97.paytm.common.entity.vipcashback.MerchantStage) r0
                goto L_0x0083
            L_0x0082:
                r0 = r1
            L_0x0083:
                if (r0 == 0) goto L_0x00d9
                net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity r0 = r3.f20675a
                net.one97.paytm.common.entity.vipcashback.MerchantGameItem r4 = r4.getData()
                if (r4 == 0) goto L_0x00a0
                java.util.ArrayList r4 = r4.getMerchantStages()
                if (r4 == 0) goto L_0x00a0
                net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity r1 = r3.f20675a
                int r1 = r1.H
                java.lang.Object r4 = r4.get(r1)
                r1 = r4
                net.one97.paytm.common.entity.vipcashback.MerchantStage r1 = (net.one97.paytm.common.entity.vipcashback.MerchantStage) r1
            L_0x00a0:
                if (r1 != 0) goto L_0x00a5
                kotlin.g.b.k.a()
            L_0x00a5:
                java.lang.String r4 = "response?.data?.merchantStages?.get(stageNumber)!!"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
                r0.a((net.one97.paytm.common.entity.vipcashback.MerchantStage) r1)
            L_0x00ad:
                return
            L_0x00ae:
                java.util.ArrayList r0 = r4.getErrors()
                if (r0 == 0) goto L_0x00d9
                java.util.ArrayList r0 = r4.getErrors()
                int r0 = r0.size()
                if (r0 <= 0) goto L_0x00d9
                net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity r0 = r3.f20675a
                net.one97.paytm.vipcashback.f.d$a r1 = net.one97.paytm.vipcashback.f.d.f20859a
                java.util.ArrayList r4 = r4.getErrors()
                r1 = 0
                java.lang.Object r4 = r4.get(r1)
                java.lang.String r1 = "response.errors[0]"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
                net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal r4 = (net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal) r4
                com.paytm.network.model.NetworkCustomError r4 = net.one97.paytm.vipcashback.f.d.a.a((net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal) r4)
                r0.a((com.paytm.network.model.NetworkCustomError) r4)
            L_0x00d9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity.c.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "p1");
            kotlin.g.b.k.c(networkCustomError, "p2");
            MerchantCashbackOfferDetailActivity.a(this.f20675a);
            this.f20675a.a(networkCustomError);
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f20694a;

        m(com.google.android.material.bottomsheet.a aVar) {
            this.f20694a = aVar;
        }

        public final void onClick(View view) {
            this.f20694a.dismiss();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: net.one97.paytm.cashback.posttxn.CashbackDealData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.vipcashback.MerchantStage r10) {
        /*
            r9 = this;
            java.lang.String r0 = "merchantStage"
            kotlin.g.b.k.c(r10, r0)
            java.util.ArrayList r0 = r10.getTasks()
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x0014
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.vipcashback.MerchantTasksItem r0 = (net.one97.paytm.common.entity.vipcashback.MerchantTasksItem) r0
            goto L_0x0015
        L_0x0014:
            r0 = r2
        L_0x0015:
            net.one97.paytm.vipcashback.d.a$h$a r3 = net.one97.paytm.vipcashback.d.a.h.f20802a
            java.lang.String r3 = net.one97.paytm.vipcashback.d.a.h.f20805d
            if (r0 == 0) goto L_0x0022
            java.lang.String r4 = r0.getRedemptionType()
            goto L_0x0023
        L_0x0022:
            r4 = r2
        L_0x0023:
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00cd
            net.one97.paytm.vipcashback.d.a$g$a r3 = net.one97.paytm.vipcashback.d.a.g.f20797a
            java.lang.String r3 = net.one97.paytm.vipcashback.d.a.g.f20800d
            if (r0 == 0) goto L_0x0036
            java.lang.String r4 = r0.getRedemptionStatus()
            goto L_0x0037
        L_0x0036:
            r4 = r2
        L_0x0037:
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00cd
            if (r0 == 0) goto L_0x004a
            java.util.ArrayList r10 = r0.getCashbackCrossPromoData()
            if (r10 == 0) goto L_0x004a
            int r10 = r10.size()
            goto L_0x004b
        L_0x004a:
            r10 = 0
        L_0x004b:
            if (r10 <= 0) goto L_0x0225
            if (r0 == 0) goto L_0x005c
            java.util.ArrayList r10 = r0.getCashbackCrossPromoData()
            if (r10 == 0) goto L_0x005c
            java.lang.Object r10 = r10.get(r1)
            net.one97.paytm.cashback.posttxn.CashbackCrossPromoData r10 = (net.one97.paytm.cashback.posttxn.CashbackCrossPromoData) r10
            goto L_0x005d
        L_0x005c:
            r10 = r2
        L_0x005d:
            if (r10 == 0) goto L_0x0225
            android.content.Intent r10 = new android.content.Intent
            r3 = r9
            android.content.Context r3 = (android.content.Context) r3
            java.lang.Class<net.one97.paytm.vipcashback.activity.CashbackVoucherDetailsActivity> r4 = net.one97.paytm.vipcashback.activity.CashbackVoucherDetailsActivity.class
            r10.<init>(r3, r4)
            net.one97.paytm.vipcashback.c.a r3 = net.one97.paytm.vipcashback.c.a.a()
            java.lang.String r4 = "CashbackHelper.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r3 = r3.c()
            java.lang.String r4 = "p4b"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0095
            if (r0 == 0) goto L_0x008d
            java.util.ArrayList r0 = r0.getCashbackCrossPromoData()
            if (r0 == 0) goto L_0x008d
            java.lang.Object r0 = r0.get(r1)
            r2 = r0
            net.one97.paytm.cashback.posttxn.CashbackCrossPromoData r2 = (net.one97.paytm.cashback.posttxn.CashbackCrossPromoData) r2
        L_0x008d:
            java.io.Serializable r2 = (java.io.Serializable) r2
            java.lang.String r0 = "cb_promodata"
            r10.putExtra(r0, r2)
            goto L_0x00c9
        L_0x0095:
            if (r0 == 0) goto L_0x00aa
            java.util.ArrayList r3 = r0.getCashbackCrossPromoData()
            if (r3 == 0) goto L_0x00aa
            java.lang.Object r3 = r3.get(r1)
            net.one97.paytm.cashback.posttxn.CashbackCrossPromoData r3 = (net.one97.paytm.cashback.posttxn.CashbackCrossPromoData) r3
            if (r3 == 0) goto L_0x00aa
            java.lang.String r3 = r3.getCrossPromoCode()
            goto L_0x00ab
        L_0x00aa:
            r3 = r2
        L_0x00ab:
            java.lang.String r4 = "promocode"
            r10.putExtra(r4, r3)
            if (r0 == 0) goto L_0x00c4
            java.util.ArrayList r0 = r0.getCashbackCrossPromoData()
            if (r0 == 0) goto L_0x00c4
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.cashback.posttxn.CashbackCrossPromoData r0 = (net.one97.paytm.cashback.posttxn.CashbackCrossPromoData) r0
            if (r0 == 0) goto L_0x00c4
            java.lang.String r2 = r0.getSiteId()
        L_0x00c4:
            java.lang.String r0 = "siteid"
            r10.putExtra(r0, r2)
        L_0x00c9:
            r9.startActivity(r10)
            return
        L_0x00cd:
            net.one97.paytm.vipcashback.d.a$h$a r3 = net.one97.paytm.vipcashback.d.a.h.f20802a
            java.lang.String r3 = net.one97.paytm.vipcashback.d.a.h.f20806e
            if (r0 == 0) goto L_0x00da
            java.lang.String r4 = r0.getRedemptionType()
            goto L_0x00db
        L_0x00da:
            r4 = r2
        L_0x00db:
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0118
            net.one97.paytm.vipcashback.d.a$g$a r3 = net.one97.paytm.vipcashback.d.a.g.f20797a
            java.lang.String r3 = net.one97.paytm.vipcashback.d.a.g.f20800d
            if (r0 == 0) goto L_0x00ee
            java.lang.String r4 = r0.getRedemptionStatus()
            goto L_0x00ef
        L_0x00ee:
            r4 = r2
        L_0x00ef:
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0118
            android.content.Intent r10 = new android.content.Intent
            r1 = r9
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Class<net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity> r3 = net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity.class
            r10.<init>(r1, r3)
            net.one97.paytm.common.entity.vipcashback.CashbackStageItem r1 = new net.one97.paytm.common.entity.vipcashback.CashbackStageItem
            r1.<init>()
            if (r0 == 0) goto L_0x010a
            net.one97.paytm.cashback.posttxn.CashbackDealData r2 = r0.getCashbackDealData()
        L_0x010a:
            r1.setCashbackDealData(r2)
            java.io.Serializable r1 = (java.io.Serializable) r1
            java.lang.String r0 = "stageItem"
            r10.putExtra(r0, r1)
            r9.startActivity(r10)
            return
        L_0x0118:
            if (r0 == 0) goto L_0x011f
            java.lang.String r3 = r0.getRedemptionType()
            goto L_0x0120
        L_0x011f:
            r3 = r2
        L_0x0120:
            java.lang.String r4 = "coins"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0158
            net.one97.paytm.vipcashback.f.f r10 = net.one97.paytm.vipcashback.f.f.a()
            java.lang.String r0 = "GTMHelper.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)
            java.lang.String r10 = net.one97.paytm.vipcashback.f.f.N()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            if (r10 == 0) goto L_0x013f
            int r10 = r10.length()
            if (r10 != 0) goto L_0x0140
        L_0x013f:
            r1 = 1
        L_0x0140:
            if (r1 != 0) goto L_0x0225
            net.one97.paytm.vipcashback.c.b r10 = net.one97.paytm.vipcashback.c.a.b()
            r1 = r9
            android.content.Context r1 = (android.content.Context) r1
            net.one97.paytm.vipcashback.f.f r2 = net.one97.paytm.vipcashback.f.f.a()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            java.lang.String r0 = net.one97.paytm.vipcashback.f.f.N()
            r10.checkDeepLinking(r1, r0)
            return
        L_0x0158:
            r3 = r9
            androidx.appcompat.app.AppCompatActivity r3 = (androidx.appcompat.app.AppCompatActivity) r3
            java.lang.String r4 = r10.getStageGratificationText()
            java.util.ArrayList r10 = r10.getTasks()
            java.lang.Object r10 = r10.get(r1)
            java.lang.String r5 = "merchantStage.tasks.get(0)"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r5)
            net.one97.paytm.common.entity.vipcashback.MerchantTasksItem r10 = (net.one97.paytm.common.entity.vipcashback.MerchantTasksItem) r10
            java.lang.String r10 = r10.getRedemptionText()
            if (r0 == 0) goto L_0x0179
            boolean r5 = r0.isGratificationProcessed()
            goto L_0x017a
        L_0x0179:
            r5 = 0
        L_0x017a:
            if (r0 == 0) goto L_0x0181
            java.lang.String r0 = r0.getRrnNo()
            goto L_0x0182
        L_0x0181:
            r0 = r2
        L_0x0182:
            java.lang.String r6 = "activity"
            kotlin.g.b.k.c(r3, r6)
            com.google.android.material.bottomsheet.a r6 = new com.google.android.material.bottomsheet.a
            r7 = r3
            android.content.Context r7 = (android.content.Context) r7
            r6.<init>(r7)
            android.view.LayoutInflater r3 = r3.getLayoutInflater()
            int r7 = net.one97.paytm.vipcashback.R.layout.view_stage_gratification
            android.view.View r2 = r3.inflate(r7, r2)
            int r3 = net.one97.paytm.vipcashback.R.id.iv_close
            android.view.View r3 = r2.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity$m r7 = new net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity$m
            r7.<init>(r6)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r3.setOnClickListener(r7)
            int r3 = net.one97.paytm.vipcashback.R.id.title
            android.view.View r3 = r2.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            if (r5 == 0) goto L_0x01f3
            r5 = r9
            android.content.Context r5 = (android.content.Context) r5
            int r7 = net.one97.paytm.vipcashback.R.color.color_00c673
            int r5 = androidx.core.content.b.c(r5, r7)
            r3.setTextColor(r5)
            int r5 = net.one97.paytm.vipcashback.R.id.tv_ref
            android.view.View r5 = r2.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r7 = r0
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r8 = "tvRef"
            if (r7 != 0) goto L_0x01ea
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            r5.setVisibility(r1)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ref. No. "
            java.lang.String r0 = r1.concat(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r5.setText(r0)
            goto L_0x01ff
        L_0x01ea:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            r0 = 8
            r5.setVisibility(r0)
            goto L_0x01ff
        L_0x01f3:
            r0 = r9
            android.content.Context r0 = (android.content.Context) r0
            int r1 = net.one97.paytm.common.assets.R.color.color_f5a109
            int r0 = androidx.core.content.b.c(r0, r1)
            r3.setTextColor(r0)
        L_0x01ff:
            java.lang.String r0 = "tvTitle"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            int r0 = net.one97.paytm.vipcashback.R.id.tnc_text
            android.view.View r0 = r2.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tncTV"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.vipcashback.f.d$a r1 = net.one97.paytm.vipcashback.f.d.f20859a
            java.lang.CharSequence r10 = net.one97.paytm.vipcashback.f.d.a.a((java.lang.String) r10, (android.widget.TextView) r0)
            r0.setText(r10)
            r6.setContentView((android.view.View) r2)
            r6.show()
        L_0x0225:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity.a(net.one97.paytm.common.entity.vipcashback.MerchantStage):void");
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MerchantCashbackOfferDetailActivity f20674a;

        b(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity) {
            this.f20674a = merchantCashbackOfferDetailActivity;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            MerchantCashbackOfferDetailActivity.a(this.f20674a);
            if (iJRPaytmDataModel instanceof MerchantCampaignGameResponse) {
                MerchantCampaignGameResponse merchantCampaignGameResponse = (MerchantCampaignGameResponse) iJRPaytmDataModel;
                if (merchantCampaignGameResponse.getStatus() == 1 && merchantCampaignGameResponse.getData() != null) {
                    MerchantCampaignGameItem data = merchantCampaignGameResponse.getData();
                    kotlin.g.b.k.a((Object) data, "response.data");
                    if (data.isIsSupercashGame()) {
                        MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity = this.f20674a;
                        a aVar = MerchantCashbackOfferDetailActivity.f20667a;
                        merchantCashbackOfferDetailActivity.D = MerchantCashbackOfferDetailActivity.J;
                        MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity2 = this.f20674a;
                        MerchantCampaignGameItem data2 = merchantCampaignGameResponse.getData();
                        kotlin.g.b.k.a((Object) data2, "response.data");
                        merchantCashbackOfferDetailActivity2.a(data2.getSupercashGame());
                        return;
                    }
                    MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity3 = this.f20674a;
                    a aVar2 = MerchantCashbackOfferDetailActivity.f20667a;
                    merchantCashbackOfferDetailActivity3.D = MerchantCashbackOfferDetailActivity.I;
                    MerchantGameItem merchantGameItem = new MerchantGameItem();
                    MerchantCampaignGameItem data3 = merchantCampaignGameResponse.getData();
                    kotlin.g.b.k.a((Object) data3, "response.data");
                    merchantGameItem.setCampaign(data3.getCampaign());
                    this.f20674a.a(merchantGameItem);
                } else if (merchantCampaignGameResponse.getErrors() != null && merchantCampaignGameResponse.getErrors().size() > 0) {
                    MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity4 = this.f20674a;
                    d.a aVar3 = net.one97.paytm.vipcashback.f.d.f20859a;
                    GetVIPCashBackErrorModal getVIPCashBackErrorModal = merchantCampaignGameResponse.getErrors().get(0);
                    kotlin.g.b.k.a((Object) getVIPCashBackErrorModal, "response.errors[0]");
                    merchantCashbackOfferDetailActivity4.a(d.a.a(getVIPCashBackErrorModal));
                }
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "p1");
            kotlin.g.b.k.c(networkCustomError, "p2");
            MerchantCashbackOfferDetailActivity.a(this.f20674a);
            this.f20674a.a(networkCustomError);
        }
    }

    private final void d() {
        LottieAnimationView lottieAnimationView = this.A;
        if (lottieAnimationView == null) {
            kotlin.g.b.k.a("mLoader");
        }
        net.one97.paytm.common.widgets.a.a(lottieAnimationView);
        RelativeLayout relativeLayout = this.z;
        if (relativeLayout == null) {
            kotlin.g.b.k.a("layoutContainer");
        }
        relativeLayout.setVisibility(8);
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MerchantCashbackOfferDetailActivity f20676a;

        d(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity) {
            this.f20676a = merchantCashbackOfferDetailActivity;
        }

        public final void onClick(View view) {
            this.f20676a.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public final void a(MerchantGameItem merchantGameItem) {
        if (merchantGameItem != null && merchantGameItem.getCampaign() != null) {
            Campaign campaign = merchantGameItem.getCampaign();
            kotlin.g.b.k.a((Object) campaign, "merchantGameItem.campaign");
            a(campaign);
            if (I.equals(this.D)) {
                Campaign campaign2 = merchantGameItem.getCampaign();
                kotlin.g.b.k.a((Object) campaign2, "merchantGameItem.campaign");
                b(campaign2);
                return;
            }
            a.i.C0390a aVar = a.i.f20808a;
            if (a.i.f20810c.equals(merchantGameItem.getGameStatus())) {
                b(merchantGameItem);
            } else {
                c(merchantGameItem);
            }
        }
    }

    private final void b(MerchantGameItem merchantGameItem) {
        String str;
        RelativeLayout relativeLayout = this.v;
        if (relativeLayout == null) {
            kotlin.g.b.k.a("rlInitBottom");
        }
        relativeLayout.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) a(R.id.gameLL);
        kotlin.g.b.k.a((Object) linearLayout, "gameLL");
        linearLayout.setVisibility(8);
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.initialisedOfferLayout);
        kotlin.g.b.k.a((Object) relativeLayout2, "initialisedOfferLayout");
        relativeLayout2.setVisibility(0);
        View findViewById = ((RelativeLayout) a(R.id.initialisedOfferLayout)).findViewById(R.id.titleText);
        kotlin.g.b.k.a((Object) findViewById, "initialisedOfferLayout.f…TextView>(R.id.titleText)");
        ((TextView) findViewById).setText(merchantGameItem.getInitializedOfferText());
        View findViewById2 = ((RelativeLayout) a(R.id.initialisedOfferLayout)).findViewById(R.id.tv_days_left);
        kotlin.g.b.k.a((Object) findViewById2, "initialisedOfferLayout.f…tView>(R.id.tv_days_left)");
        ((TextView) findViewById2).setText(merchantGameItem.getOfferRemainingTime());
        View findViewById3 = ((RelativeLayout) a(R.id.initialisedOfferLayout)).findViewById(R.id.offer_imp_tnc);
        kotlin.g.b.k.a((Object) findViewById3, "initialisedOfferLayout.f…View>(R.id.offer_imp_tnc)");
        TextView textView = (TextView) findViewById3;
        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
        Campaign campaign = merchantGameItem.getCampaign();
        if (campaign == null || (str = campaign.getImportantTerms()) == null) {
            str = "";
        }
        textView.setText(d.a.c(str));
        ((RelativeLayout) a(R.id.initialisedOfferLayout)).findViewById(R.id.tv_activate_offer).setOnClickListener(new k(this, merchantGameItem));
        Campaign campaign2 = merchantGameItem.getCampaign();
        kotlin.g.b.k.a((Object) campaign2, "merchantGameItem.campaign");
        if (!TextUtils.isEmpty(campaign2.getSurpriseText())) {
            View findViewById4 = ((RelativeLayout) a(R.id.initialisedOfferLayout)).findViewById(R.id.offerDetailTnc);
            kotlin.g.b.k.a((Object) findViewById4, "initialisedOfferLayout.f…iew>(R.id.offerDetailTnc)");
            d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
            Campaign campaign3 = merchantGameItem.getCampaign();
            kotlin.g.b.k.a((Object) campaign3, "merchantGameItem.campaign");
            ((TextView) findViewById4).setText(d.a.c(campaign3.getSurpriseText()));
            View findViewById5 = ((RelativeLayout) a(R.id.initialisedOfferLayout)).findViewById(R.id.offerDetailTnc);
            kotlin.g.b.k.a((Object) findViewById5, "initialisedOfferLayout.f…iew>(R.id.offerDetailTnc)");
            ((TextView) findViewById5).setVisibility(0);
            View findViewById6 = ((RelativeLayout) a(R.id.initialisedOfferLayout)).findViewById(R.id.offerDetail);
            kotlin.g.b.k.a((Object) findViewById6, "initialisedOfferLayout.f…xtView>(R.id.offerDetail)");
            ((TextView) findViewById6).setVisibility(0);
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MerchantCashbackOfferDetailActivity f20691a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MerchantGameItem f20692b;

        k(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity, MerchantGameItem merchantGameItem) {
            this.f20691a = merchantCashbackOfferDetailActivity;
            this.f20692b = merchantGameItem;
        }

        public final void onClick(View view) {
            MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity = this.f20691a;
            MerchantGameItem merchantGameItem = this.f20692b;
            RelativeLayout relativeLayout = (RelativeLayout) merchantCashbackOfferDetailActivity.a(R.id.initialisedOfferLayout);
            kotlin.g.b.k.a((Object) relativeLayout, "initialisedOfferLayout");
            merchantCashbackOfferDetailActivity.a(merchantGameItem, (Campaign) null, (View) relativeLayout);
            ArrayList arrayList = new ArrayList();
            arrayList.add("Activate_offer");
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(this.f20691a, "Cashback", "Cashback_detail", arrayList, "", "", "");
        }
    }

    private final void a(Campaign campaign) {
        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
        Context context = this;
        String backgroundImageUrl = campaign.getBackgroundImageUrl();
        AppBarLayout appBarLayout = this.y;
        if (appBarLayout == null) {
            kotlin.g.b.k.a("appBarLayout");
        }
        View view = appBarLayout;
        Boolean offusTransaction = campaign.getOffusTransaction();
        boolean z2 = false;
        d.a.a(context, backgroundImageUrl, view, offusTransaction != null ? offusTransaction.booleanValue() : false, R.dimen.cashback_detail_app_bar_layout_height);
        TextView textView = this.f20668d;
        if (textView == null) {
            kotlin.g.b.k.a("tvOfferTitle");
        }
        String offerTextOverride = campaign.getOfferTextOverride();
        if (offerTextOverride == null) {
            offerTextOverride = campaign.getOfferTypeText();
        }
        textView.setText(offerTextOverride);
        TextView textView2 = this.f20669e;
        if (textView2 == null) {
            kotlin.g.b.k.a("tvOfferDesc");
        }
        textView2.setText(campaign.getShortDescription());
        d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
        CircularImageView circularImageView = this.f20670f;
        if (circularImageView == null) {
            kotlin.g.b.k.a("ivIcon");
        }
        Boolean offusTransaction2 = campaign.getOffusTransaction();
        if (offusTransaction2 != null) {
            z2 = offusTransaction2.booleanValue();
        }
        d.a.a(context, circularImageView, z2, campaign.getNewOffersImageUrl());
        TextView textView3 = this.p;
        if (textView3 == null) {
            kotlin.g.b.k.a("tvOfferImpTnc");
        }
        d.a aVar3 = net.one97.paytm.vipcashback.f.d.f20859a;
        String importantTerms = campaign.getImportantTerms();
        if (importantTerms == null) {
            importantTerms = "";
        }
        textView3.setText(d.a.c(importantTerms));
        TextView textView4 = this.o;
        if (textView4 == null) {
            kotlin.g.b.k.a("tvOfferViewMoreTnc");
        }
        textView4.setOnClickListener(new i(this, campaign));
        TextView textView5 = this.s;
        if (textView5 == null) {
            kotlin.g.b.k.a("tvOfferImpTncCampaign");
        }
        d.a aVar4 = net.one97.paytm.vipcashback.f.d.f20859a;
        String importantTerms2 = campaign.getImportantTerms();
        if (importantTerms2 == null) {
            importantTerms2 = "";
        }
        textView5.setText(d.a.c(importantTerms2));
        TextView textView6 = this.r;
        if (textView6 == null) {
            kotlin.g.b.k.a("tvOfferViewMoreTncCampaign");
        }
        textView6.setOnClickListener(new j(this, campaign));
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MerchantCashbackOfferDetailActivity f20687a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Campaign f20688b;

        i(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity, Campaign campaign) {
            this.f20687a = merchantCashbackOfferDetailActivity;
            this.f20688b = campaign;
        }

        public final void onClick(View view) {
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            d.a.a((View) MerchantCashbackOfferDetailActivity.c(this.f20687a));
            d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
            String tncUrl = this.f20688b.getTncUrl();
            String str = this.f20687a.f20644b;
            kotlin.g.b.k.a((Object) str, "TAG");
            d.a.a((AJRCashBackBaseActivity) this.f20687a, tncUrl, str, (String) null, (String) null, 1);
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MerchantCashbackOfferDetailActivity f20689a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Campaign f20690b;

        j(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity, Campaign campaign) {
            this.f20689a = merchantCashbackOfferDetailActivity;
            this.f20690b = campaign;
        }

        public final void onClick(View view) {
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            d.a.a((View) MerchantCashbackOfferDetailActivity.d(this.f20689a));
            d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
            String tncUrl = this.f20690b.getTncUrl();
            String str = this.f20689a.f20644b;
            kotlin.g.b.k.a((Object) str, "TAG");
            d.a.a((AJRCashBackBaseActivity) this.f20689a, tncUrl, str, (String) null, (String) null, 1);
            ArrayList arrayList = new ArrayList();
            arrayList.add("view_more");
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(this.f20689a, "Cashback", "Cashback_detail", arrayList, "", "", "");
        }
    }

    private final void b(Campaign campaign) {
        net.one97.paytm.vipcashback.c.a.b().sendOpenScreenWithDeviceInfo("/cashback-offers/merchant/activate-newoffer".concat(this.F ? "/home_carousal" : ""), "cashback", this);
        RelativeLayout relativeLayout = this.v;
        if (relativeLayout == null) {
            kotlin.g.b.k.a("rlInitBottom");
        }
        relativeLayout.setVisibility(0);
        LinearLayout linearLayout = this.l;
        if (linearLayout == null) {
            kotlin.g.b.k.a("llOfferSummary");
        }
        linearLayout.setVisibility(8);
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.rl_payments);
        kotlin.g.b.k.a((Object) relativeLayout2, "rl_payments");
        relativeLayout2.setVisibility(8);
        LinearLayout linearLayout2 = this.t;
        if (linearLayout2 == null) {
            kotlin.g.b.k.a("tncImpLayoutCampaign");
        }
        linearLayout2.setVisibility(0);
        LinearLayout linearLayout3 = this.q;
        if (linearLayout3 == null) {
            kotlin.g.b.k.a("tncImpLayout");
        }
        linearLayout3.setVisibility(8);
        if (!TextUtils.isEmpty(campaign.getSurpriseText())) {
            LinearLayout linearLayout4 = (LinearLayout) a(R.id.surpriseLl);
            kotlin.g.b.k.a((Object) linearLayout4, "surpriseLl");
            linearLayout4.setVisibility(0);
            TextView textView = (TextView) a(R.id.surpriseDetailsTextV);
            kotlin.g.b.k.a((Object) textView, "surpriseDetailsTextV");
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            textView.setText(d.a.c(campaign.getSurpriseText()));
        }
        TextView textView2 = this.j;
        if (textView2 == null) {
            kotlin.g.b.k.a("tvDaysLeft");
        }
        int i2 = R.string.offer_valid_till;
        d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
        textView2.setText(getString(i2, new Object[]{d.a.b(campaign.getValidUpto(), "dd MMM, yyyy")}));
        TextView textView3 = this.u;
        if (textView3 == null) {
            kotlin.g.b.k.a("tvActivateOffer");
        }
        textView3.setVisibility(0);
        TextView textView4 = this.u;
        if (textView4 == null) {
            kotlin.g.b.k.a("tvActivateOffer");
        }
        textView4.setOnClickListener(new g(this, campaign));
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MerchantCashbackOfferDetailActivity f20683a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Campaign f20684b;

        g(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity, Campaign campaign) {
            this.f20683a = merchantCashbackOfferDetailActivity;
            this.f20684b = campaign;
        }

        public final void onClick(View view) {
            MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity = this.f20683a;
            Campaign campaign = this.f20684b;
            RelativeLayout relativeLayout = (RelativeLayout) merchantCashbackOfferDetailActivity.a(R.id.rl_init_bottom);
            kotlin.g.b.k.a((Object) relativeLayout, "rl_init_bottom");
            merchantCashbackOfferDetailActivity.a((MerchantGameItem) null, campaign, (View) relativeLayout);
            ArrayList arrayList = new ArrayList();
            arrayList.add("Activate_offer");
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(this.f20683a, "Cashback", "Cashback_detail", arrayList, "", "", "");
        }
    }

    private final void c(MerchantGameItem merchantGameItem) {
        Campaign campaign = merchantGameItem.getCampaign();
        LinearLayout linearLayout = (LinearLayout) a(R.id.gameLL);
        kotlin.g.b.k.a((Object) linearLayout, "gameLL");
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = (LinearLayout) a(R.id.surpriseLl);
        kotlin.g.b.k.a((Object) linearLayout2, "surpriseLl");
        linearLayout2.setVisibility(8);
        RelativeLayout relativeLayout = this.v;
        if (relativeLayout == null) {
            kotlin.g.b.k.a("rlInitBottom");
        }
        relativeLayout.setVisibility(8);
        LinearLayout linearLayout3 = this.l;
        if (linearLayout3 == null) {
            kotlin.g.b.k.a("llOfferSummary");
        }
        linearLayout3.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.rl_payments);
        kotlin.g.b.k.a((Object) relativeLayout2, "rl_payments");
        relativeLayout2.setVisibility(0);
        RelativeLayout relativeLayout3 = (RelativeLayout) a(R.id.initialisedOfferLayout);
        kotlin.g.b.k.a((Object) relativeLayout3, "initialisedOfferLayout");
        relativeLayout3.setVisibility(8);
        LinearLayout linearLayout4 = this.t;
        if (linearLayout4 == null) {
            kotlin.g.b.k.a("tncImpLayoutCampaign");
        }
        linearLayout4.setVisibility(8);
        LinearLayout linearLayout5 = this.q;
        if (linearLayout5 == null) {
            kotlin.g.b.k.a("tncImpLayout");
        }
        linearLayout5.setVisibility(0);
        TextView textView = this.m;
        if (textView == null) {
            kotlin.g.b.k.a("tvOfferSummary");
        }
        textView.setText(merchantGameItem.getTxnCountText());
        RecyclerView recyclerView = this.f20673i;
        if (recyclerView == null) {
            kotlin.g.b.k.a("rvProgress");
        }
        recyclerView.setFocusable(false);
        Context context = this;
        this.B = new net.one97.paytm.vipcashback.a.c(context, merchantGameItem);
        RecyclerView recyclerView2 = this.f20673i;
        if (recyclerView2 == null) {
            kotlin.g.b.k.a("rvProgress");
        }
        recyclerView2.setVisibility(0);
        RecyclerView recyclerView3 = this.f20673i;
        if (recyclerView3 == null) {
            kotlin.g.b.k.a("rvProgress");
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(context));
        RecyclerView recyclerView4 = this.f20673i;
        if (recyclerView4 == null) {
            kotlin.g.b.k.a("rvProgress");
        }
        net.one97.paytm.vipcashback.a.c cVar = this.B;
        if (cVar == null) {
            kotlin.g.b.k.a("mAdapter");
        }
        recyclerView4.setAdapter(cVar);
        ((RelativeLayout) a(R.id.rl_payments)).setOnClickListener(new h(this, merchantGameItem));
        a.i.C0390a aVar = a.i.f20808a;
        if (a.i.f20809b.equals(merchantGameItem.getGameStatus())) {
            net.one97.paytm.vipcashback.c.a.b().sendOpenScreenWithDeviceInfo("/cashback-offers/merchant/progress", "cashback", context);
            TextView textView2 = this.m;
            if (textView2 == null) {
                kotlin.g.b.k.a("tvOfferSummary");
            }
            textView2.setTextSize(2, 16.0f);
            TextView textView3 = this.f20669e;
            if (textView3 == null) {
                kotlin.g.b.k.a("tvOfferDesc");
            }
            textView3.setText(merchantGameItem.getOfferProgressConstruct());
            TextView textView4 = this.k;
            if (textView4 == null) {
                kotlin.g.b.k.a("tvDaysLeftToExpire");
            }
            textView4.setVisibility(0);
            TextView textView5 = this.k;
            if (textView5 == null) {
                kotlin.g.b.k.a("tvDaysLeftToExpire");
            }
            textView5.setText(merchantGameItem.getRemainingTime());
            TextView textView6 = this.f20671g;
            if (textView6 == null) {
                kotlin.g.b.k.a("tvGameEndTitle");
            }
            textView6.setVisibility(8);
            TextView textView7 = this.f20672h;
            if (textView7 == null) {
                kotlin.g.b.k.a("tvDate");
            }
            textView7.setVisibility(8);
            return;
        }
        a.i.C0390a aVar2 = a.i.f20808a;
        if (a.i.f20815h.equals(merchantGameItem.getGameStatus())) {
            net.one97.paytm.vipcashback.c.a.b().sendOpenScreenWithDeviceInfo("/cashback-offers/merchant/completed", "cashback", context);
            TextView textView8 = this.m;
            if (textView8 == null) {
                kotlin.g.b.k.a("tvOfferSummary");
            }
            textView8.setTextSize(2, 12.0f);
            TextView textView9 = this.n;
            if (textView9 == null) {
                kotlin.g.b.k.a("tvRedemptionText");
            }
            textView9.setVisibility(0);
            TextView textView10 = this.n;
            if (textView10 == null) {
                kotlin.g.b.k.a("tvRedemptionText");
            }
            textView10.setText(merchantGameItem.getGameGratificationMessage());
            TextView textView11 = this.f20671g;
            if (textView11 == null) {
                kotlin.g.b.k.a("tvGameEndTitle");
            }
            textView11.setVisibility(0);
            TextView textView12 = this.f20671g;
            if (textView12 == null) {
                kotlin.g.b.k.a("tvGameEndTitle");
            }
            textView12.setText(getString(R.string.cash_back_congratulations));
            TextView textView13 = this.f20671g;
            if (textView13 == null) {
                kotlin.g.b.k.a("tvGameEndTitle");
            }
            textView13.setTextColor(androidx.core.content.b.c(context, net.one97.paytm.common.assets.R.color.color_09ac63));
            TextView textView14 = this.f20672h;
            if (textView14 == null) {
                kotlin.g.b.k.a("tvDate");
            }
            textView14.setVisibility(0);
            TextView textView15 = this.f20672h;
            if (textView15 == null) {
                kotlin.g.b.k.a("tvDate");
            }
            d.a aVar3 = net.one97.paytm.vipcashback.f.d.f20859a;
            String gameCompletionTime = merchantGameItem.getGameCompletionTime();
            kotlin.g.b.k.a((Object) gameCompletionTime, "merchantGameItem.gameCompletionTime");
            textView15.setText(d.a.a(gameCompletionTime));
            return;
        }
        net.one97.paytm.vipcashback.c.a.b().sendOpenScreenWithDeviceInfo("/cashback-offers/merchant/expired", "cashback", context);
        TextView textView16 = this.m;
        if (textView16 == null) {
            kotlin.g.b.k.a("tvOfferSummary");
        }
        textView16.setTextSize(2, 12.0f);
        int totalTxnCount = merchantGameItem.getTotalTxnCount() - merchantGameItem.getSuccessTxnCount();
        TextView textView17 = this.n;
        if (textView17 == null) {
            kotlin.g.b.k.a("tvRedemptionText");
        }
        String gameGratificationMessage = merchantGameItem.getGameGratificationMessage();
        if (gameGratificationMessage == null) {
            gameGratificationMessage = merchantGameItem.getGameExpiryReasonText();
        }
        CharSequence charSequence = gameGratificationMessage;
        if (charSequence == null) {
            int i2 = R.string.cash_back_offer_expired_txt;
            d.a aVar4 = net.one97.paytm.vipcashback.f.d.f20859a;
            int totalTxnCount2 = merchantGameItem.getTotalTxnCount();
            kotlin.g.b.k.a((Object) campaign, "campaign");
            charSequence = getString(i2, new Object[]{Integer.valueOf(totalTxnCount), Integer.valueOf(merchantGameItem.getSuccessTxnCount()), d.a.a(totalTxnCount2, campaign.getOfferKeyword())});
        }
        textView17.setText(charSequence);
        TextView textView18 = this.n;
        if (textView18 == null) {
            kotlin.g.b.k.a("tvRedemptionText");
        }
        textView18.setVisibility(0);
        TextView textView19 = this.f20671g;
        if (textView19 == null) {
            kotlin.g.b.k.a("tvGameEndTitle");
        }
        textView19.setVisibility(0);
        TextView textView20 = this.f20671g;
        if (textView20 == null) {
            kotlin.g.b.k.a("tvGameEndTitle");
        }
        textView20.setText(getString(R.string.cash_back_offer_expired));
        TextView textView21 = this.f20671g;
        if (textView21 == null) {
            kotlin.g.b.k.a("tvGameEndTitle");
        }
        textView21.setTextColor(androidx.core.content.b.c(context, net.one97.paytm.common.assets.R.color.color_fd5c5c));
        TextView textView22 = this.f20672h;
        if (textView22 == null) {
            kotlin.g.b.k.a("tvDate");
        }
        textView22.setVisibility(0);
        TextView textView23 = this.f20672h;
        if (textView23 == null) {
            kotlin.g.b.k.a("tvDate");
        }
        d.a aVar5 = net.one97.paytm.vipcashback.f.d.f20859a;
        String gameExpiry = merchantGameItem.getGameExpiry();
        kotlin.g.b.k.a((Object) gameExpiry, "merchantGameItem.gameExpiry");
        textView23.setText(d.a.a(gameExpiry));
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MerchantCashbackOfferDetailActivity f20685a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MerchantGameItem f20686b;

        h(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity, MerchantGameItem merchantGameItem) {
            this.f20685a = merchantCashbackOfferDetailActivity;
            this.f20686b = merchantGameItem;
        }

        public final void onClick(View view) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("payment_details");
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(this.f20685a, "Cashback", "Cashback_detail", arrayList, "", "", "");
            Intent intent = new Intent(this.f20685a, MerchantPaymentDetailsActivity.class);
            intent.putExtra("gameid", this.f20686b.getOfferId());
            intent.putExtra("stageItems", this.f20686b.getMerchantStages());
            this.f20685a.startActivity(intent);
        }
    }

    public final void a(MerchantGameItem merchantGameItem, Campaign campaign, View view) {
        net.one97.paytm.vipcashback.g.b bVar;
        kotlin.g.b.k.c(view, "view");
        if (!(merchantGameItem == null || (bVar = this.G) == null)) {
            bVar.a(merchantGameItem).observe(this, new e(this, merchantGameItem, view));
        }
        if (campaign != null) {
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            Context context = this;
            int id = campaign.getId();
            String str = this.f20644b;
            kotlin.g.b.k.a((Object) str, "TAG");
            com.paytm.network.a a2 = d.a.a(context, (com.paytm.network.listener.b) new f(this, view, campaign), id, "ACCEPT_OFFER", str, true);
            if (com.paytm.utility.b.c(context)) {
                showActivateProgress(view);
                a2.a();
                return;
            }
            a(a2);
        }
    }

    public static final class f implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MerchantCashbackOfferDetailActivity f20680a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f20681b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Campaign f20682c;

        f(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity, View view, Campaign campaign) {
            this.f20680a = merchantCashbackOfferDetailActivity;
            this.f20681b = view;
            this.f20682c = campaign;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            Campaign campaign;
            kotlin.g.b.k.c(iJRPaytmDataModel, Payload.RESPONSE);
            if (!this.f20680a.isFinishing()) {
                this.f20680a.hideActivateProgress(this.f20681b);
                if (iJRPaytmDataModel instanceof MerchantCashBackMyOfferModel) {
                    MerchantCashBackMyOfferModel merchantCashBackMyOfferModel = (MerchantCashBackMyOfferModel) iJRPaytmDataModel;
                    if (merchantCashBackMyOfferModel.getStatus() == 1 && merchantCashBackMyOfferModel.getData() != null) {
                        MerchantGameItem data = merchantCashBackMyOfferModel.getData();
                        if (!(data == null || (campaign = data.getCampaign()) == null)) {
                            Campaign campaign2 = this.f20682c;
                            campaign.setNewOffersListPosition((campaign2 != null ? Integer.valueOf(campaign2.getNewOffersListPosition()) : null).intValue());
                        }
                        MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity = this.f20680a;
                        kotlin.g.b.k.a((Object) data, "merchantGameItem");
                        MerchantCashbackOfferDetailActivity.a(merchantCashbackOfferDetailActivity, data, this.f20681b);
                    } else if (merchantCashBackMyOfferModel.getErrors() != null && merchantCashBackMyOfferModel.getErrors().size() > 0 && !this.f20680a.isFinishing()) {
                        MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity2 = this.f20680a;
                        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                        GetVIPCashBackErrorModal getVIPCashBackErrorModal = merchantCashBackMyOfferModel.getErrors().get(0);
                        kotlin.g.b.k.a((Object) getVIPCashBackErrorModal, "response.errors[0]");
                        merchantCashbackOfferDetailActivity2.a(d.a.a(getVIPCashBackErrorModal));
                    }
                }
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            if (!this.f20680a.isFinishing()) {
                this.f20680a.hideActivateProgress(this.f20681b);
                this.f20680a.a(networkCustomError);
            }
        }
    }

    public final void showActivateProgress(View view) {
        kotlin.g.b.k.c(view, "view");
        View findViewById = view.findViewById(R.id.tv_activate_offer);
        kotlin.g.b.k.a((Object) findViewById, "view.findViewById<View>(R.id.tv_activate_offer)");
        findViewById.setVisibility(8);
        net.one97.paytm.common.widgets.a.a((LottieAnimationView) view.findViewById(R.id.activate_loader));
    }

    public final void hideActivateProgress(View view) {
        kotlin.g.b.k.c(view, "view");
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) view.findViewById(R.id.activate_loader));
        View findViewById = view.findViewById(R.id.tv_activate_offer);
        kotlin.g.b.k.a((Object) findViewById, "view.findViewById<View>(R.id.tv_activate_offer)");
        findViewById.setVisibility(0);
    }

    static final class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MerchantCashbackOfferDetailActivity f20695a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f20696b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MerchantGameItem f20697c;

        n(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity, View view, MerchantGameItem merchantGameItem) {
            this.f20695a = merchantCashbackOfferDetailActivity;
            this.f20696b = view;
            this.f20697c = merchantGameItem;
        }

        public final void run() {
            if (!this.f20695a.isFinishing()) {
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                d.a.a((LottieAnimationView) this.f20696b.findViewById(R.id.activate_loader_sparcle));
                MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity = this.f20695a;
                a aVar2 = MerchantCashbackOfferDetailActivity.f20667a;
                merchantCashbackOfferDetailActivity.D = MerchantCashbackOfferDetailActivity.J;
                this.f20695a.a(this.f20697c);
                this.f20695a.E = true;
                Intent intent = new Intent();
                intent.putExtra("offer", this.f20697c);
                MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity2 = this.f20695a;
                a aVar3 = MerchantCashbackOfferDetailActivity.f20667a;
                merchantCashbackOfferDetailActivity2.setResult(MerchantCashbackOfferDetailActivity.K, intent);
            }
        }
    }

    static final class l implements AppBarLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MerchantCashbackOfferDetailActivity f20693a;

        l(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity) {
            this.f20693a = merchantCashbackOfferDetailActivity;
        }

        public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            int abs = Math.abs(i2);
            kotlin.g.b.k.a((Object) appBarLayout, "appBarLayout");
            if (abs >= appBarLayout.getTotalScrollRange()) {
                MerchantCashbackOfferDetailActivity.f(this.f20693a).setTitle(MerchantCashbackOfferDetailActivity.g(this.f20693a).getText());
                return;
            }
            float totalScrollRange = 1.0f - (((float) abs) / ((float) appBarLayout.getTotalScrollRange()));
            MerchantCashbackOfferDetailActivity.g(this.f20693a).setAlpha(totalScrollRange);
            MerchantCashbackOfferDetailActivity.h(this.f20693a).setAlpha(totalScrollRange);
            MerchantCashbackOfferDetailActivity.i(this.f20693a).setAlpha(totalScrollRange);
            MerchantCashbackOfferDetailActivity.f(this.f20693a).setTitle((CharSequence) "");
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != R.id.home) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public final void onBackPressed() {
        if (this.C) {
            Intent intent = new Intent(this, AJRVIPCashBackActivity.class);
            intent.putExtra("show_home_on_back", true);
            intent.putExtra("screen", "homescreenMerchant");
            startActivity(intent);
        } else if (!this.E) {
            supportFinishAfterTransition();
            return;
        }
        finish();
    }

    public static final /* synthetic */ void a(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity) {
        LottieAnimationView lottieAnimationView = merchantCashbackOfferDetailActivity.A;
        if (lottieAnimationView == null) {
            kotlin.g.b.k.a("mLoader");
        }
        net.one97.paytm.common.widgets.a.b(lottieAnimationView);
        RelativeLayout relativeLayout = merchantCashbackOfferDetailActivity.z;
        if (relativeLayout == null) {
            kotlin.g.b.k.a("layoutContainer");
        }
        relativeLayout.setVisibility(0);
    }

    public static final /* synthetic */ void a(MerchantCashbackOfferDetailActivity merchantCashbackOfferDetailActivity, MerchantGameItem merchantGameItem, View view) {
        View findViewById = view.findViewById(R.id.tv_activate_offer);
        kotlin.g.b.k.a((Object) findViewById, "view.findViewById<View>(R.id.tv_activate_offer)");
        findViewById.setVisibility(8);
        View findViewById2 = view.findViewById(R.id.rl_activated_offer);
        kotlin.g.b.k.a((Object) findViewById2, "view.findViewById<View>(R.id.rl_activated_offer)");
        findViewById2.setVisibility(0);
        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
        View findViewById3 = view.findViewById(R.id.activate_loader_sparcle);
        kotlin.g.b.k.a((Object) findViewById3, "view.findViewById<Lottie….activate_loader_sparcle)");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById3;
        kotlin.g.b.k.c(lottieAnimationView, "view");
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("activate_offer_sparcle_big.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
        new Handler().postDelayed(new n(merchantCashbackOfferDetailActivity, view, merchantGameItem), 1460);
    }
}
