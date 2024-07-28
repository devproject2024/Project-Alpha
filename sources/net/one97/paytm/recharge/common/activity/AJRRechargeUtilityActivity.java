package net.one97.paytm.recharge.common.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.URLUtil;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import androidx.viewpager.widget.ViewPager;
import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Cache;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.material.tabs.TabLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.e;
import com.paytm.utility.n;
import com.paytmmall.clpartifact.utils.CLPConstants;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.r;
import io.reactivex.rxjava3.a.s;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.y;
import java.io.Reader;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.t;
import net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.ak;
import net.one97.paytm.recharge.common.e.am;
import net.one97.paytm.recharge.common.e.c;
import net.one97.paytm.recharge.common.e.l;
import net.one97.paytm.recharge.common.e.v;
import net.one97.paytm.recharge.common.fragment.a;
import net.one97.paytm.recharge.common.fragment.o;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.common.widget.CustomViewPager;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.dth.a.f;
import net.one97.paytm.recharge.dth.a.g;
import net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2;
import net.one97.paytm.recharge.mobile.a.i;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class AJRRechargeUtilityActivity extends CJRRechargeToolbarActivity implements ak, am, c, l, v, a.C1182a, FJRRechargeUtilityBaseV2.b {

    /* renamed from: d  reason: collision with root package name */
    public static boolean f60795d = true;
    private String A;
    private boolean B = false;
    /* access modifiers changed from: private */
    public boolean C = false;
    private long D = 4000;
    private boolean E = false;
    private net.one97.paytm.recharge.creditcard.b.a F;
    private final String G = "android:support:fragments";
    private com.paytm.b.a.a H;
    /* access modifiers changed from: private */
    public View I;
    /* access modifiers changed from: private */
    public Boolean J = Boolean.TRUE;
    /* access modifiers changed from: private */
    public Boolean K = Boolean.FALSE;
    private TabLayout.b L = new TabLayout.b() {
        public final void onTabReselected(TabLayout.f fVar) {
        }

        public final void onTabSelected(TabLayout.f fVar) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    AJRRechargeUtilityActivity.this.q();
                }
            }, 200);
            int unused = AJRRechargeUtilityActivity.this.o = fVar.f36765e;
            AJRRechargeUtilityActivity.this.v.setCurrentItem(fVar.f36765e, false);
            Fragment a2 = AJRRechargeUtilityActivity.this.w.a(fVar.f36765e);
            if ((a2 instanceof net.one97.paytm.recharge.creditcard.b.a) && a2.isAdded()) {
                net.one97.paytm.recharge.creditcard.b.a aVar = (net.one97.paytm.recharge.creditcard.b.a) a2;
                if (!z.a((Context) aVar.getActivity())) {
                    z.a((Activity) aVar.getActivity());
                    d dVar = d.f64967a;
                    CJRRechargeErrorModel a3 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                    CRUFlowModel flowName = a3.getFlowName();
                    if (flowName != null) {
                        flowName.setErrorType(ERROR_TYPE.AUTH.name());
                    }
                    CRUFlowModel flowName2 = a3.getFlowName();
                    if (flowName2 != null) {
                        flowName2.setActionType(ACTION_TYPE.HOME_PAGE.name());
                    }
                    az azVar = az.f61525a;
                    az.a(a3);
                }
            }
            TextView textView = (TextView) ((LinearLayout) ((ViewGroup) AJRRechargeUtilityActivity.this.y.getChildAt(0)).getChildAt(fVar.f36765e)).getChildAt(1);
            textView.setTypeface(textView.getTypeface(), 1);
        }

        public final void onTabUnselected(TabLayout.f fVar) {
            ((TextView) ((LinearLayout) ((ViewGroup) AJRRechargeUtilityActivity.this.y.getChildAt(0)).getChildAt(fVar.f36765e)).getChildAt(1)).setTypeface((Typeface) null, 0);
        }
    };
    private a M = new a(this);

    /* renamed from: a  reason: collision with root package name */
    public boolean f60796a = false;

    /* renamed from: b  reason: collision with root package name */
    protected RelativeLayout f60797b;

    /* renamed from: c  reason: collision with root package name */
    List<CJRHomePageItem> f60798c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public String f60799e = "";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public CJRItem f60800f;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.recharge.legacy.catalog.fragment.c f60801g;

    /* renamed from: h  reason: collision with root package name */
    private o f60802h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f60803i = false;
    private com.google.android.youtube.player.c j;
    private boolean k;
    private LottieAnimationView l;
    private f m;
    private boolean n = false;
    /* access modifiers changed from: private */
    public int o = -1;
    /* access modifiers changed from: private */
    public CustomViewPager v;
    /* access modifiers changed from: private */
    public t w;
    /* access modifiers changed from: private */
    public View x;
    /* access modifiers changed from: private */
    public TabLayout y;
    /* access modifiers changed from: private */
    public Fragment z;

    public final void a() {
    }

    public void onCreate(Bundle bundle) {
        b.e((Activity) this);
        setRequestedOrientation(1);
        if (bundle != null && bundle.containsKey("android:support:fragments")) {
            bundle.remove("android:support:fragments");
        }
        super.onCreate(bundle);
        setContentView(R.layout.recharge_vertical_base_lyt);
        this.H = ax.a(getApplicationContext());
        this.f60797b = (RelativeLayout) findViewById(R.id.progress_view);
        this.l = (LottieAnimationView) findViewById(R.id.loading_threedots);
        this.x = findViewById(R.id.all_categories_container);
        this.I = findViewById(R.id.vertical_container);
        a(getIntent());
        v();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
        CJRItem cJRItem = this.f60800f;
        if ((cJRItem != null && ((CJRHomePageItem) cJRItem).isDeepLinking()) || this.f60803i) {
            v();
        } else if ("rechOrdSum".equals(this.A) || "rechAdClp".equals(this.A)) {
            finish();
            startActivity(intent);
        } else if (this.f60800f != null && e.z.equalsIgnoreCase(this.f60800f.getCategoryId())) {
            v();
        }
    }

    /* access modifiers changed from: protected */
    public final void al_() {
        super.al_();
        if (this.f60803i) {
            setTitle("");
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        CJRRechargeUtilities.INSTANCE.debugLog("main recharge activity on restoreInstanceState savedInstanceState present start");
        try {
            super.onRestoreInstanceState(bundle);
        } catch (Exception e2) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
        }
    }

    private void a(Intent intent) {
        if (intent != null) {
            Bundle extras = intent.getExtras();
            this.n = false;
            this.C = false;
            if (extras != null) {
                this.f60803i = extras.getBoolean("open_activity_in_automatic_mode", false);
                if (extras.containsKey("extra_home_data")) {
                    Serializable serializable = extras.getSerializable("extra_home_data");
                    if (serializable instanceof CJRHomePageItem) {
                        this.A = ((CJRHomePageItem) serializable).getOrigin();
                    }
                    if (serializable instanceof CJRItem) {
                        this.f60800f = (CJRItem) serializable;
                        if (!TextUtils.isEmpty(this.f60800f.getCategoryId()) || this.f60800f.getURL() == null) {
                            this.f60799e = this.f60800f.getCategoryId();
                        } else {
                            this.f60799e = Uri.parse(this.f60800f.getURL()).getLastPathSegment();
                        }
                    }
                }
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == 283) {
            finish();
            return;
        }
        try {
            if ((this.z instanceof net.one97.paytm.recharge.legacy.catalog.fragment.c) && this.z.isAdded()) {
                this.z.onActivityResult(i2, i3, intent);
                super.onActivityResult(i2, i3, intent);
            } else if ((this.z instanceof o) && this.z.isAdded()) {
                this.z.onActivityResult(i2, i3, intent);
                super.onActivityResult(i2, i3, intent);
            } else if (this.f60801g != null && this.f60801g.isAdded()) {
                this.f60801g.onActivityResult(i2, i3, intent);
                super.onActivityResult(i2, i3, intent);
            } else if (this.f60802h != null && this.f60802h.isAdded()) {
                this.f60802h.onActivityResult(i2, i3, intent);
                super.onActivityResult(i2, i3, intent);
            } else if (this.m == null || !this.m.isAdded()) {
                if (this.F != null && this.F.isAdded()) {
                    this.F.onActivityResult(i2, i3, intent);
                }
                super.onActivityResult(i2, i3, intent);
            } else {
                Fragment c2 = this.m.getChildFragmentManager().c(g.class.getSimpleName());
                if (c2 != null) {
                    c2.onActivityResult(i2, i3, intent);
                }
                super.onActivityResult(i2, i3, intent);
            }
        } catch (Exception unused) {
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder) {
        net.one97.paytm.recharge.legacy.catalog.fragment.c cVar = this.f60801g;
        if (cVar != null) {
            cVar.c(cJRFrequentOrder);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        q();
        y();
        TabLayout tabLayout = this.y;
        if (tabLayout != null) {
            tabLayout.setupWithViewPager((ViewPager) null);
            this.y = null;
        }
        CustomViewPager customViewPager = this.v;
        if (customViewPager != null) {
            customViewPager.removeAllViews();
            this.v.clearOnPageChangeListeners();
            this.v = null;
        }
        net.one97.paytm.recharge.legacy.catalog.b.a.f62799d = null;
        d dVar = d.f64967a;
        d.b().clear();
    }

    public void onBackPressed() {
        com.google.android.youtube.player.c cVar;
        if (this.k && (cVar = this.j) != null) {
            cVar.a(false);
        } else if ("rechOrdSum".equalsIgnoreCase(this.A) || "rechAdClp".equals(this.A)) {
            ba.a((Activity) this);
        } else {
            f fVar = this.m;
            if (fVar == null || !fVar.isAdded() || !this.m.isVisible() || this.m.getChildFragmentManager() == null || this.m.getChildFragmentManager().f() <= 1) {
                if (az.b((Context) this)) {
                    Fragment fragment = this.z;
                    if (fragment instanceof net.one97.paytm.recharge.mobile_v3.b.g) {
                        if (((net.one97.paytm.recharge.mobile_v3.b.g) fragment).d()) {
                            super.onBackPressed();
                        } else {
                            return;
                        }
                    }
                } else {
                    Fragment fragment2 = this.z;
                    if (fragment2 instanceof i) {
                        if (((i) fragment2).d()) {
                            super.onBackPressed();
                        } else {
                            return;
                        }
                    }
                }
                Fragment fragment3 = this.z;
                if (fragment3 instanceof net.one97.paytm.recharge.legacy.catalog.fragment.c) {
                    if (!((net.one97.paytm.recharge.legacy.catalog.fragment.c) fragment3).E()) {
                        return;
                    }
                } else if (fragment3 instanceof o) {
                    ((o) fragment3).L();
                } else if (!(fragment3 instanceof net.one97.paytm.recharge.creditcard.b.a) || !fragment3.isAdded() || !this.z.isVisible()) {
                    net.one97.paytm.recharge.legacy.catalog.fragment.c cVar2 = this.f60801g;
                    if (cVar2 == null) {
                        o oVar = this.f60802h;
                        if (oVar == null || !oVar.isAdded() || !this.f60802h.isVisible()) {
                            net.one97.paytm.recharge.creditcard.b.a aVar = this.F;
                            if (aVar != null && aVar.isAdded() && this.F.isVisible()) {
                                this.F.b();
                                return;
                            }
                        } else {
                            this.f60802h.L();
                        }
                    } else if (!cVar2.E()) {
                        return;
                    }
                } else {
                    ((net.one97.paytm.recharge.creditcard.b.a) this.z).b();
                    return;
                }
                super.onBackPressed();
                return;
            }
            this.m.getChildFragmentManager().d();
        }
    }

    public final void a(boolean z2) {
        this.f60796a = z2;
    }

    public final void a(com.google.android.youtube.player.c cVar, boolean z2) {
        this.j = cVar;
        this.k = z2;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            b(false);
            this.t.a();
        } else if (!r()) {
            b(true);
            this.t.a(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public void A() {
        ba.a(this.l);
        ba.a(0, (View) this.f60797b);
    }

    public final void a(int i2) {
        RelativeLayout relativeLayout = this.f60797b;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    AJRRechargeUtilityActivity.this.D();
                }
            }, (long) i2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D() {
        ba.a(8, (View) this.f60797b);
        ba.b(this.l);
    }

    public final void a(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().b(true);
    }

    public final void c() {
        Fragment fragment = this.z;
        if (fragment instanceof a.C1182a) {
            ((a.C1182a) fragment).c();
            return;
        }
        net.one97.paytm.recharge.legacy.catalog.fragment.c cVar = this.f60801g;
        if (cVar != null) {
            cVar.c();
        }
    }

    public final void ao_() {
        Fragment fragment = this.z;
        if (fragment instanceof a.C1182a) {
            ((a.C1182a) fragment).ao_();
            return;
        }
        net.one97.paytm.recharge.legacy.catalog.fragment.c cVar = this.f60801g;
        if (cVar != null) {
            cVar.ao_();
            return;
        }
        o oVar = this.f60802h;
        if (oVar != null) {
            oVar.ao_();
        }
    }

    private void v() {
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        if (!net.one97.paytm.recharge.di.helper.c.bw()) {
            A();
            this.E = true;
            CJRRechargeUtilities.INSTANCE.getGtmContainerInitializationObservable().subscribe(new io.reactivex.rxjava3.d.g() {
                public final void accept(Object obj) {
                    AJRRechargeUtilityActivity.this.a((Boolean) obj);
                }
            });
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    AJRRechargeUtilityActivity.this.B();
                }
            }, 10000);
            return;
        }
        w();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) throws Throwable {
        if (bool.booleanValue() && this.E) {
            runOnUiThread(new Runnable() {
                public final void run() {
                    AJRRechargeUtilityActivity.this.C();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C() {
        this.E = false;
        a(0);
        w();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B() {
        if (this.E) {
            finish();
        }
    }

    private void w() {
        if (!az.b(this.f60800f.getCategoryId(), (Context) this) && !this.B) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            if (net.one97.paytm.recharge.di.helper.c.bu()) {
                if (CJRRechargeUtilities.INSTANCE.getRechargeHomePageTabs() == null || ba.c((Context) this)) {
                    al_();
                    String x2 = x();
                    if (!TextUtils.isEmpty(x2)) {
                        c(x2);
                        return;
                    }
                    this.x.setVisibility(8);
                    this.I.setVisibility(0);
                    a(Boolean.FALSE, this.f60800f);
                    return;
                }
                CJRHomePageV2 rechargeHomePageTabs = CJRRechargeUtilities.INSTANCE.getRechargeHomePageTabs();
                d dVar = d.f64967a;
                a_("fetch_category_menu", rechargeHomePageTabs, d.a(ACTION_TYPE.GET_CATEGORY_MENU, ERROR_TYPE.UNDEFINED));
                return;
            }
        }
        al_();
        this.x.setVisibility(8);
        this.I.setVisibility(0);
        a(Boolean.FALSE, this.f60800f);
    }

    private void c(String str) {
        p.create(new s(str) {
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(r rVar) {
                AJRRechargeUtilityActivity.this.a(this.f$1, rVar);
            }
        }).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribeOn(io.reactivex.rxjava3.i.a.b()).subscribe(new w<CJRHomePageV2>() {
            public final void onComplete() {
            }

            public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            }

            public final /* synthetic */ void onNext(Object obj) {
                CJRHomePageV2 cJRHomePageV2 = (CJRHomePageV2) obj;
                if (cJRHomePageV2 == null) {
                    AJRRechargeUtilityActivity.a(AJRRechargeUtilityActivity.this);
                    return;
                }
                AJRRechargeUtilityActivity.this.a(cJRHomePageV2);
                Boolean unused = AJRRechargeUtilityActivity.this.K = Boolean.TRUE;
                y.a(new ab() {
                    public final void subscribe(io.reactivex.rxjava3.a.z zVar) {
                        AJRRechargeUtilityActivity.AnonymousClass1.this.a(zVar);
                    }
                }).b(io.reactivex.rxjava3.i.a.b()).d();
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void a(io.reactivex.rxjava3.a.z zVar) throws Throwable {
                if (!zVar.isDisposed()) {
                    AJRRechargeUtilityActivity.a(AJRRechargeUtilityActivity.this);
                }
            }

            public final void onError(Throwable th) {
                AJRRechargeUtilityActivity.a(AJRRechargeUtilityActivity.this);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, r rVar) throws Throwable {
        if (!rVar.isDisposed()) {
            rVar.onNext((CJRHomePageV2) a(str, (Context) this, (IJRPaytmDataModel) new CJRHomePageV2()));
        }
    }

    private String x() {
        int a2 = n.a((Context) this, n.b());
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        String bt = net.one97.paytm.recharge.di.helper.c.bt();
        if (TextUtils.isEmpty(bt) || !URLUtil.isValidUrl(bt)) {
            return null;
        }
        try {
            Uri parse = Uri.parse(bt);
            if (parse == null) {
                return bt;
            }
            Uri.Builder buildUpon = parse.buildUpon();
            buildUpon.appendQueryParameter(AppConstants.TAG_LANG_ID, String.valueOf(a2));
            return buildUpon.build().toString();
        } catch (Exception unused) {
            return bt;
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        super.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
        al_();
        a(10);
    }

    /* access modifiers changed from: private */
    public void a(CJRHomePageV2 cJRHomePageV2) {
        CJRRechargeUtilities.INSTANCE.setRechargeHomePageTabs(cJRHomePageV2);
        CJRHomePageV2 cJRHomePageV22 = cJRHomePageV2;
        ArrayList<CJRHomePageLayoutV2> arrayList = null;
        ArrayList<CJRHomePageDetailV2> arrayList2 = (cJRHomePageV22 == null || cJRHomePageV22.getmPage() == null || cJRHomePageV22.getmPage().size() <= 0) ? null : cJRHomePageV22.getmPage();
        CJRHomePageDetailV2 cJRHomePageDetailV2 = arrayList2 != null ? arrayList2.get(0) : null;
        if (!(cJRHomePageDetailV2 == null || cJRHomePageDetailV2.getHomePageLayoutList() == null || cJRHomePageDetailV2.getHomePageLayoutList().size() <= 0)) {
            arrayList = cJRHomePageDetailV2.getHomePageLayoutList();
        }
        a((List<CJRHomePageItem>) new ArrayList(arrayList.get(0).getHomePageItemList()));
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        al_();
        a(0);
        if ((iJRPaytmDataModel instanceof CJRHomePageV2) && !this.C) {
            this.C = true;
            a((CJRHomePageV2) iJRPaytmDataModel);
        }
        super.a_(str, iJRPaytmDataModel, obj);
    }

    private static CJRHomePageItem a(CJRHomePageItem cJRHomePageItem) {
        CJRHomePageItem cJRHomePageItem2 = new CJRHomePageItem();
        cJRHomePageItem2.setCategoryId(cJRHomePageItem.getCategoryId());
        cJRHomePageItem2.setVertical(cJRHomePageItem.getVertical());
        cJRHomePageItem2.setVerticalId(cJRHomePageItem.getVerticalId());
        cJRHomePageItem2.setRelatedCategories(cJRHomePageItem.getRelatedCategories());
        cJRHomePageItem2.setUrl(cJRHomePageItem.getURL());
        cJRHomePageItem2.setUrlType(cJRHomePageItem.getURLType());
        cJRHomePageItem2.setDeepLinking(cJRHomePageItem.isDeepLinking());
        cJRHomePageItem2.setDeeplink(cJRHomePageItem.getDeeplink());
        cJRHomePageItem2.setName(cJRHomePageItem.getName());
        cJRHomePageItem2.setTitle(cJRHomePageItem.getTitle());
        cJRHomePageItem2.setAccount(cJRHomePageItem.getAccount());
        cJRHomePageItem2.setAppLink(cJRHomePageItem.isAppLink());
        cJRHomePageItem2.setDeeplinkType(cJRHomePageItem.getDeeplinkType());
        cJRHomePageItem2.setSubtitle(cJRHomePageItem.getSubtitle());
        cJRHomePageItem2.setEventCategory(cJRHomePageItem.getEventCategory());
        cJRHomePageItem2.setmEventId(cJRHomePageItem.getmEventId());
        cJRHomePageItem2.setImageUrl(cJRHomePageItem.getImageUrl());
        cJRHomePageItem2.setL1(cJRHomePageItem.getL1());
        cJRHomePageItem2.setL2(cJRHomePageItem.getL2());
        cJRHomePageItem2.setParentId(cJRHomePageItem.getParentId());
        return cJRHomePageItem2;
    }

    private void a(List<CJRHomePageItem> list) {
        CustomViewPager customViewPager;
        ba.d((Context) this);
        if (this.f60803i) {
            y();
            this.n = false;
            this.x.setVisibility(8);
            this.I.setVisibility(0);
            setTitle("");
            a(Boolean.FALSE, this.f60800f);
            return;
        }
        if (list.size() > 0) {
            this.f60798c.clear();
            for (int i2 = 0; i2 < list.size(); i2++) {
                CJRHomePageItem cJRHomePageItem = list.get(i2);
                if ("1".equalsIgnoreCase(cJRHomePageItem.getShareable())) {
                    String url = cJRHomePageItem.getURL();
                    if (URLUtil.isValidUrl(url)) {
                        String lastPathSegment = Uri.parse(url).getLastPathSegment();
                        if (!TextUtils.isEmpty(lastPathSegment)) {
                            cJRHomePageItem.setCategoryId(lastPathSegment);
                            if (url.contains("buyInsuranceEnabled")) {
                                net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
                                url = net.one97.paytm.recharge.common.utils.y.a().get(lastPathSegment);
                            }
                            z.a(lastPathSegment, url, cJRHomePageItem.getURLType());
                        }
                        if (!TextUtils.isEmpty(cJRHomePageItem.getSubtitle())) {
                            String[] split = cJRHomePageItem.getSubtitle().split(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
                            if (split.length > 1) {
                                cJRHomePageItem.setName(cJRHomePageItem.getNewTitle());
                                CJRHomePageItem cJRHomePageItem2 = cJRHomePageItem;
                                for (int i3 = 1; i3 < split.length; i3++) {
                                    int i4 = i2 + 1;
                                    while (true) {
                                        if (i4 >= list.size()) {
                                            break;
                                        }
                                        String lastPathSegment2 = Uri.parse(list.get(i4).getURL()).getLastPathSegment();
                                        if (!TextUtils.isEmpty(lastPathSegment2)) {
                                            list.get(i4).setCategoryId(lastPathSegment2);
                                        }
                                        if (split[i3].equalsIgnoreCase(lastPathSegment2)) {
                                            if (this.f60800f != null && !TextUtils.isEmpty(this.f60799e) && this.f60799e.equals(lastPathSegment2)) {
                                                String newTitle = cJRHomePageItem2.getNewTitle();
                                                CJRHomePageItem a2 = a(list.get(i4));
                                                a2.setName(newTitle);
                                                a2.setUrl(this.f60800f.getURL());
                                                this.n = true;
                                                this.o = this.f60798c.size();
                                                cJRHomePageItem2 = a2;
                                            }
                                            list.remove(i4);
                                        } else {
                                            i4++;
                                        }
                                    }
                                }
                                cJRHomePageItem = cJRHomePageItem2;
                            }
                        }
                        if ("156705".equalsIgnoreCase(cJRHomePageItem.getCategoryId())) {
                            CJRItem cJRItem = this.f60800f;
                            if (cJRItem instanceof CJRHomePageItem) {
                                cJRHomePageItem.setDeepLinking(((CJRHomePageItem) cJRItem).isDeepLinking());
                            }
                            b(cJRHomePageItem);
                        } else if (!"156705".equalsIgnoreCase(cJRHomePageItem.getCategoryId())) {
                            CJRItem cJRItem2 = this.f60800f;
                            if (cJRItem2 instanceof CJRHomePageItem) {
                                cJRHomePageItem.setDeepLinking(((CJRHomePageItem) cJRItem2).isDeepLinking());
                                cJRHomePageItem.setAppLink(((CJRHomePageItem) this.f60800f).isAppLink());
                            }
                            b(cJRHomePageItem);
                        }
                    }
                }
            }
        }
        if (this.u != null) {
            this.u.setVisibility(0);
        }
        if (this.f60798c.size() < 3) {
            this.n = false;
        }
        if (this.n) {
            setTitle(getResources().getString(R.string.recharge_tabs_toolbar_title));
            TabLayout tabLayout = this.y;
            if (!(tabLayout == null || tabLayout.getTabCount() <= 0 || (customViewPager = this.v) == null || customViewPager.getAdapter() == null)) {
                y();
            }
            this.y = (TabLayout) findViewById(R.id.recharges_home_tab);
            findViewById(R.id.vertical_container).setVisibility(8);
            this.w = new t(this, getSupportFragmentManager(), this.f60798c, this, this.y);
            for (int i5 = 0; i5 < this.f60798c.size(); i5++) {
                TabLayout tabLayout2 = this.y;
                tabLayout2.a(tabLayout2.a().a(this.w.getPageTitle(i5)));
            }
            this.v = (CustomViewPager) findViewById(R.id.all_categories_view_pager);
            this.v.setSaveFromParentEnabled(false);
            this.y.setupWithViewPager(this.v);
            this.v.setAdapter(this.w);
            this.v.setSaveFromParentEnabled(false);
            this.v.setOnPageChangeListener(new ViewPager.e() {
                public final void onPageScrolled(int i2, float f2, int i3) {
                }

                /* JADX WARNING: Removed duplicated region for block: B:52:0x016e A[Catch:{ Exception -> 0x0160 }] */
                /* JADX WARNING: Removed duplicated region for block: B:67:0x01b9 A[Catch:{ Exception -> 0x0160 }] */
                /* JADX WARNING: Removed duplicated region for block: B:68:0x01d0 A[Catch:{ Exception -> 0x0160 }] */
                /* JADX WARNING: Removed duplicated region for block: B:88:0x024d  */
                /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onPageSelected(int r6) {
                    /*
                        r5 = this;
                        net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
                        net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.b()
                        r0.clear()
                        net.one97.paytm.recharge.widgets.model.VERTICAL r1 = net.one97.paytm.recharge.widgets.model.VERTICAL.UTILITIES
                        r0.setVerticalName(r1)
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this
                        java.util.List<net.one97.paytm.common.entity.shopping.CJRHomePageItem> r1 = r1.f60798c
                        java.lang.Object r1 = r1.get(r6)
                        net.one97.paytm.common.entity.shopping.CJRHomePageItem r1 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r1
                        java.lang.String r1 = r1.getCategoryId()
                        r0.setCategoryId(r1)
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this
                        com.google.android.material.tabs.TabLayout r1 = r1.y
                        com.google.android.material.tabs.TabLayout$f r1 = r1.a((int) r6)
                        java.lang.CharSequence r1 = r1.f36763c
                        java.lang.String r1 = r1.toString()
                        r0.setScreenName(r1)
                        r0 = 0
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        java.lang.Boolean r1 = r1.J     // Catch:{ Exception -> 0x024a }
                        boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x024a }
                        if (r1 != 0) goto L_0x0048
                        net.one97.paytm.recharge.common.activity.-$$Lambda$AJRRechargeUtilityActivity$3$Ocm9aewaFx9nR2vmj5QW-CwC_mc r1 = new net.one97.paytm.recharge.common.activity.-$$Lambda$AJRRechargeUtilityActivity$3$Ocm9aewaFx9nR2vmj5QW-CwC_mc     // Catch:{ Exception -> 0x024a }
                        r1.<init>(r6)     // Catch:{ Exception -> 0x024a }
                        net.one97.paytm.recharge.widgets.c.b.a(r1)     // Catch:{ Exception -> 0x024a }
                        goto L_0x004f
                    L_0x0048:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x024a }
                        java.lang.Boolean unused = r1.J = r2     // Catch:{ Exception -> 0x024a }
                    L_0x004f:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x024a }
                        if (r1 == 0) goto L_0x00ea
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x024a }
                        boolean r1 = r1.isAdded()     // Catch:{ Exception -> 0x024a }
                        if (r1 == 0) goto L_0x00ea
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x024a }
                        boolean r1 = r1 instanceof net.one97.paytm.recharge.common.fragment.o     // Catch:{ Exception -> 0x024a }
                        if (r1 == 0) goto L_0x0077
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x024a }
                        net.one97.paytm.recharge.common.fragment.o r1 = (net.one97.paytm.recharge.common.fragment.o) r1     // Catch:{ Exception -> 0x024a }
                        r1.s = r0     // Catch:{ Exception -> 0x024a }
                    L_0x0077:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x024a }
                        boolean r1 = r1 instanceof net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2     // Catch:{ Exception -> 0x024a }
                        if (r1 == 0) goto L_0x008c
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x024a }
                        net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2 r1 = (net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2) r1     // Catch:{ Exception -> 0x024a }
                        r1.e((boolean) r0)     // Catch:{ Exception -> 0x024a }
                    L_0x008c:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        boolean r1 = net.one97.paytm.recharge.common.utils.az.b((android.content.Context) r1)     // Catch:{ Exception -> 0x024a }
                        if (r1 == 0) goto L_0x00aa
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x024a }
                        boolean r1 = r1 instanceof net.one97.paytm.recharge.mobile_v3.b.g     // Catch:{ Exception -> 0x024a }
                        if (r1 == 0) goto L_0x00bf
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x024a }
                        net.one97.paytm.recharge.mobile_v3.b.g r1 = (net.one97.paytm.recharge.mobile_v3.b.g) r1     // Catch:{ Exception -> 0x024a }
                        r1.a((boolean) r0)     // Catch:{ Exception -> 0x024a }
                        goto L_0x00bf
                    L_0x00aa:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x024a }
                        boolean r1 = r1 instanceof net.one97.paytm.recharge.mobile.a.i     // Catch:{ Exception -> 0x024a }
                        if (r1 == 0) goto L_0x00bf
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x024a }
                        net.one97.paytm.recharge.mobile.a.i r1 = (net.one97.paytm.recharge.mobile.a.i) r1     // Catch:{ Exception -> 0x024a }
                        r1.a((boolean) r0)     // Catch:{ Exception -> 0x024a }
                    L_0x00bf:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x024a }
                        boolean r1 = r1 instanceof net.one97.paytm.recharge.dth.a.f     // Catch:{ Exception -> 0x024a }
                        if (r1 == 0) goto L_0x00d5
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x024a }
                        net.one97.paytm.recharge.dth.a.f r1 = (net.one97.paytm.recharge.dth.a.f) r1     // Catch:{ Exception -> 0x024a }
                        r1.a((boolean) r0)     // Catch:{ Exception -> 0x024a }
                        goto L_0x00ea
                    L_0x00d5:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x024a }
                        boolean r1 = r1 instanceof net.one97.paytm.recharge.creditcard.b.a     // Catch:{ Exception -> 0x024a }
                        if (r1 == 0) goto L_0x00ea
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x024a }
                        net.one97.paytm.recharge.creditcard.b.a r1 = (net.one97.paytm.recharge.creditcard.b.a) r1     // Catch:{ Exception -> 0x024a }
                        r1.a((boolean) r0)     // Catch:{ Exception -> 0x024a }
                    L_0x00ea:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r2 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        net.one97.paytm.recharge.common.a.t r2 = r2.w     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r6 = r2.a(r6)     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment unused = r1.z = r6     // Catch:{ Exception -> 0x024a }
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r6 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r6 = r6.z     // Catch:{ Exception -> 0x024a }
                        if (r6 == 0) goto L_0x024a
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r6 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r6 = r6.z     // Catch:{ Exception -> 0x024a }
                        boolean r6 = r6.isAdded()     // Catch:{ Exception -> 0x024a }
                        if (r6 == 0) goto L_0x024a
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r6 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        boolean r6 = net.one97.paytm.recharge.common.utils.az.b((android.content.Context) r6)     // Catch:{ Exception -> 0x024a }
                        r1 = 1
                        if (r6 == 0) goto L_0x012c
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r6 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r6 = r6.z     // Catch:{ Exception -> 0x024a }
                        boolean r6 = r6 instanceof net.one97.paytm.recharge.mobile_v3.b.g     // Catch:{ Exception -> 0x024a }
                        if (r6 == 0) goto L_0x0163
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r6 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r6 = r6.z     // Catch:{ Exception -> 0x024a }
                        net.one97.paytm.recharge.mobile_v3.b.g r6 = (net.one97.paytm.recharge.mobile_v3.b.g) r6     // Catch:{ Exception -> 0x024a }
                        r6.a((boolean) r1)     // Catch:{ Exception -> 0x024a }
                        goto L_0x0163
                    L_0x012c:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r6 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r6 = r6.z     // Catch:{ Exception -> 0x024a }
                        boolean r6 = r6 instanceof net.one97.paytm.recharge.mobile.a.i     // Catch:{ Exception -> 0x024a }
                        if (r6 == 0) goto L_0x0163
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r6 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r6 = r6.z     // Catch:{ Exception -> 0x024a }
                        net.one97.paytm.recharge.mobile.a.i r6 = (net.one97.paytm.recharge.mobile.a.i) r6     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.j r6 = r6.getChildFragmentManager()     // Catch:{ Exception -> 0x024a }
                        int r2 = net.one97.paytm.recharge.R.id.container_frame     // Catch:{ Exception -> 0x024a }
                        androidx.fragment.app.Fragment r6 = r6.c((int) r2)     // Catch:{ Exception -> 0x024a }
                        boolean r2 = r6 instanceof net.one97.paytm.recharge.mobile.a.j     // Catch:{ Exception -> 0x024a }
                        if (r2 == 0) goto L_0x0153
                        net.one97.paytm.recharge.mobile.a.j r6 = (net.one97.paytm.recharge.mobile.a.j) r6     // Catch:{ Exception -> 0x024a }
                        boolean r6 = r6.J()     // Catch:{ Exception -> 0x024a }
                        goto L_0x0154
                    L_0x0153:
                        r6 = 0
                    L_0x0154:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r2 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x0160 }
                        androidx.fragment.app.Fragment r2 = r2.z     // Catch:{ Exception -> 0x0160 }
                        net.one97.paytm.recharge.mobile.a.i r2 = (net.one97.paytm.recharge.mobile.a.i) r2     // Catch:{ Exception -> 0x0160 }
                        r2.a((boolean) r1)     // Catch:{ Exception -> 0x0160 }
                        goto L_0x0164
                    L_0x0160:
                        goto L_0x024b
                    L_0x0163:
                        r6 = 0
                    L_0x0164:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r2 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x0160 }
                        androidx.fragment.app.Fragment r2 = r2.z     // Catch:{ Exception -> 0x0160 }
                        boolean r2 = r2 instanceof net.one97.paytm.recharge.dth.a.f     // Catch:{ Exception -> 0x0160 }
                        if (r2 == 0) goto L_0x01af
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r2 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x0160 }
                        androidx.fragment.app.Fragment r2 = r2.z     // Catch:{ Exception -> 0x0160 }
                        net.one97.paytm.recharge.dth.a.f r2 = (net.one97.paytm.recharge.dth.a.f) r2     // Catch:{ Exception -> 0x0160 }
                        java.lang.String r3 = r2.f62683h     // Catch:{ Exception -> 0x0160 }
                        if (r3 == 0) goto L_0x01a3
                        androidx.fragment.app.FragmentActivity r3 = r2.getActivity()     // Catch:{ Exception -> 0x0160 }
                        boolean r3 = r3 instanceof net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity     // Catch:{ Exception -> 0x0160 }
                        if (r3 == 0) goto L_0x01a3
                        androidx.fragment.app.FragmentActivity r3 = r2.getActivity()     // Catch:{ Exception -> 0x0160 }
                        if (r3 == 0) goto L_0x019b
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r3 = (net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity) r3     // Catch:{ Exception -> 0x0160 }
                        java.lang.String r4 = r2.f62683h     // Catch:{ Exception -> 0x0160 }
                        r3.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0160 }
                        java.lang.String r2 = r2.f62683h     // Catch:{ Exception -> 0x0160 }
                        java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0160 }
                        boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0160 }
                        if (r6 != 0) goto L_0x01a3
                        r6 = 1
                        goto L_0x01a4
                    L_0x019b:
                        kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0160 }
                        java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity"
                        r0.<init>(r1)     // Catch:{ Exception -> 0x0160 }
                        throw r0     // Catch:{ Exception -> 0x0160 }
                    L_0x01a3:
                        r6 = 0
                    L_0x01a4:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r2 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x0160 }
                        androidx.fragment.app.Fragment r2 = r2.z     // Catch:{ Exception -> 0x0160 }
                        net.one97.paytm.recharge.dth.a.f r2 = (net.one97.paytm.recharge.dth.a.f) r2     // Catch:{ Exception -> 0x0160 }
                        r2.a((boolean) r1)     // Catch:{ Exception -> 0x0160 }
                    L_0x01af:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r2 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x0160 }
                        androidx.fragment.app.Fragment r2 = r2.z     // Catch:{ Exception -> 0x0160 }
                        boolean r2 = r2 instanceof net.one97.paytm.recharge.common.fragment.o     // Catch:{ Exception -> 0x0160 }
                        if (r2 == 0) goto L_0x01d0
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r2 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x0160 }
                        androidx.fragment.app.Fragment r2 = r2.z     // Catch:{ Exception -> 0x0160 }
                        net.one97.paytm.recharge.common.fragment.o r2 = (net.one97.paytm.recharge.common.fragment.o) r2     // Catch:{ Exception -> 0x0160 }
                        boolean r6 = r2.E()     // Catch:{ Exception -> 0x0160 }
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r2 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x0160 }
                        androidx.fragment.app.Fragment r2 = r2.z     // Catch:{ Exception -> 0x0160 }
                        net.one97.paytm.recharge.common.fragment.o r2 = (net.one97.paytm.recharge.common.fragment.o) r2     // Catch:{ Exception -> 0x0160 }
                        r2.s = r1     // Catch:{ Exception -> 0x0160 }
                        goto L_0x0219
                    L_0x01d0:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r2 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x0160 }
                        androidx.fragment.app.Fragment r2 = r2.z     // Catch:{ Exception -> 0x0160 }
                        boolean r2 = r2 instanceof net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2     // Catch:{ Exception -> 0x0160 }
                        if (r2 == 0) goto L_0x0204
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r2 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x0160 }
                        androidx.fragment.app.Fragment r2 = r2.z     // Catch:{ Exception -> 0x0160 }
                        net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2 r2 = (net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2) r2     // Catch:{ Exception -> 0x0160 }
                        net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$b r3 = r2.aI     // Catch:{ Exception -> 0x0160 }
                        if (r3 == 0) goto L_0x01f7
                        net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2$b r3 = r2.aI     // Catch:{ Exception -> 0x0160 }
                        java.lang.String r4 = r2.aL     // Catch:{ Exception -> 0x0160 }
                        r3.a(r4)     // Catch:{ Exception -> 0x0160 }
                        java.lang.String r2 = r2.aL     // Catch:{ Exception -> 0x0160 }
                        boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0160 }
                        if (r6 != 0) goto L_0x01f7
                        r6 = 1
                        goto L_0x01f8
                    L_0x01f7:
                        r6 = 0
                    L_0x01f8:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r2 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x0160 }
                        androidx.fragment.app.Fragment r2 = r2.z     // Catch:{ Exception -> 0x0160 }
                        net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2 r2 = (net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2) r2     // Catch:{ Exception -> 0x0160 }
                        r2.e((boolean) r1)     // Catch:{ Exception -> 0x0160 }
                        goto L_0x0219
                    L_0x0204:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r2 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x0160 }
                        androidx.fragment.app.Fragment r2 = r2.z     // Catch:{ Exception -> 0x0160 }
                        boolean r2 = r2 instanceof net.one97.paytm.recharge.creditcard.b.a     // Catch:{ Exception -> 0x0160 }
                        if (r2 == 0) goto L_0x0219
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r2 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x0160 }
                        androidx.fragment.app.Fragment r2 = r2.z     // Catch:{ Exception -> 0x0160 }
                        net.one97.paytm.recharge.creditcard.b.a r2 = (net.one97.paytm.recharge.creditcard.b.a) r2     // Catch:{ Exception -> 0x0160 }
                        r2.a((boolean) r1)     // Catch:{ Exception -> 0x0160 }
                    L_0x0219:
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x0160 }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x0160 }
                        if (r1 == 0) goto L_0x024b
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x0160 }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x0160 }
                        android.view.View r1 = r1.getView()     // Catch:{ Exception -> 0x0160 }
                        if (r1 == 0) goto L_0x024b
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x0160 }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x0160 }
                        android.view.View r1 = r1.getView()     // Catch:{ Exception -> 0x0160 }
                        r2 = 8
                        r1.setVisibility(r2)     // Catch:{ Exception -> 0x0160 }
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this     // Catch:{ Exception -> 0x0160 }
                        androidx.fragment.app.Fragment r1 = r1.z     // Catch:{ Exception -> 0x0160 }
                        android.view.View r1 = r1.getView()     // Catch:{ Exception -> 0x0160 }
                        r1.setVisibility(r0)     // Catch:{ Exception -> 0x0160 }
                        goto L_0x024b
                    L_0x024a:
                        r6 = 0
                    L_0x024b:
                        if (r6 != 0) goto L_0x0253
                        net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r6 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.this
                        r0 = 0
                        r6.a((java.lang.String) r0)
                    L_0x0253:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.AnonymousClass3.onPageSelected(int):void");
                }

                /* access modifiers changed from: private */
                public /* synthetic */ x a(int i2) {
                    net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                    AJRRechargeUtilityActivity aJRRechargeUtilityActivity = AJRRechargeUtilityActivity.this;
                    net.one97.paytm.recharge.di.helper.b.a((Context) aJRRechargeUtilityActivity, "recharges_utilities", "category_selected", aJRRechargeUtilityActivity.y.a(i2).f36763c.toString(), "", "", "recharges_utilities");
                    return null;
                }

                public final void onPageScrollStateChanged(int i2) {
                    if (i2 == 0) {
                        AJRRechargeUtilityActivity.this.q();
                    }
                }
            });
            if (this.o != -1) {
                TextView textView = (TextView) ((LinearLayout) ((ViewGroup) this.y.getChildAt(0)).getChildAt(this.o)).getChildAt(1);
                textView.setTypeface(textView.getTypeface(), 1);
                this.v.setCurrentItem(this.o, true);
                this.x.post(new Runnable() {
                    public final void run() {
                        AJRRechargeUtilityActivity.this.x.setVisibility(0);
                        AJRRechargeUtilityActivity.this.I.setVisibility(8);
                    }
                });
            }
            this.y.a(this.L);
            this.v.setVisibility(0);
            return;
        }
        this.x.setVisibility(8);
        this.I.setVisibility(0);
        setTitle("");
        a(Boolean.FALSE, this.f60800f);
    }

    private void b(CJRHomePageItem cJRHomePageItem) {
        CJRHomePageItem a2 = a(cJRHomePageItem);
        this.f60798c.add(a2);
        if (this.f60800f != null && !TextUtils.isEmpty(this.f60799e) && this.f60799e.equals(a2.getCategoryId())) {
            this.n = true;
            this.o = this.f60798c.size() - 1;
            a2.setUrl(this.f60800f.getURL());
        }
    }

    private void y() {
        CustomViewPager customViewPager = this.v;
        if (customViewPager != null) {
            customViewPager.setAdapter((androidx.viewpager.widget.a) null);
        }
        TabLayout tabLayout = this.y;
        if (tabLayout != null) {
            tabLayout.b();
            this.y.b(this.L);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (this.n) {
            super.setTitle(getResources().getString(R.string.recharge_tabs_toolbar_title));
        } else {
            super.setTitle(charSequence);
        }
    }

    public final Fragment a(Boolean bool, CJRItem cJRItem) {
        if (cJRItem == null) {
            finish();
        }
        if ("190833".equalsIgnoreCase(this.f60799e) || "132098".equalsIgnoreCase(this.f60799e)) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("recharge_item", cJRItem);
        bundle.putBoolean("is_from_home", false);
        bundle.putBoolean("open_activity_in_automatic_mode", this.f60803i);
        bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
        if (this.n) {
            bundle.putBoolean("is_recharge_tabs_flow", true);
        }
        return net.one97.paytm.recharge.common.utils.g.a(this, ba.a(cJRItem), new kotlin.g.a.a(cJRItem, bundle, bool) {
            private final /* synthetic */ CJRItem f$1;
            private final /* synthetic */ Bundle f$2;
            private final /* synthetic */ Boolean f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Object invoke() {
                return AJRRechargeUtilityActivity.this.b(this.f$1, this.f$2, this.f$3);
            }
        }, new kotlin.g.a.a(cJRItem, bundle, bool) {
            private final /* synthetic */ CJRItem f$1;
            private final /* synthetic */ Bundle f$2;
            private final /* synthetic */ Boolean f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Object invoke() {
                return AJRRechargeUtilityActivity.this.a(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Fragment b(CJRItem cJRItem, Bundle bundle, Boolean bool) {
        Fragment fragment;
        if (cJRItem == null) {
            finish();
        }
        long j2 = 0;
        if (cJRItem != null) {
            j2 = Long.valueOf(cJRItem.getCategoryId()).longValue();
        }
        if (String.valueOf(j2).equalsIgnoreCase("18")) {
            if (!this.n) {
                this.u.setVisibility(8);
            }
            f.a aVar = f.f62680i;
            k.c(bundle, "bundle");
            f fVar = new f();
            fVar.setArguments(bundle);
            this.m = fVar;
            if (this.z == null) {
                this.z = this.m;
                bundle.putBoolean("is_selected_in_tabs", true);
            }
            if (bool.booleanValue()) {
                return this.m;
            }
            getSupportFragmentManager().a().a(R.id.vertical_container, (Fragment) this.m).c();
            return this.m;
        }
        String uRLType = cJRItem != null ? cJRItem.getURLType() : "";
        if ("mobile_postpaid".equalsIgnoreCase(uRLType) || "mobile-postpaid".equalsIgnoreCase(uRLType) || "mobile_prepaid".equalsIgnoreCase(uRLType) || "mobile-prepaid".equalsIgnoreCase(uRLType) || "datacard_postpaid".equalsIgnoreCase(uRLType) || "datacard-postpaid".equalsIgnoreCase(uRLType) || "datacard_prepaid".equalsIgnoreCase(uRLType) || "datacard-prepaid".equalsIgnoreCase(uRLType)) {
            d dVar = d.f64967a;
            d.b().getActionsMap().put(String.valueOf(j2), (Object) null);
            if (az.b((Context) this)) {
                fragment = Fragment.instantiate(this, net.one97.paytm.recharge.mobile_v3.b.g.class.getName(), bundle);
            } else {
                bundle.putBoolean("isInitialFragment", true);
                fragment = Fragment.instantiate(this, i.class.getName(), bundle);
            }
            if (this.z == null) {
                this.z = fragment;
            }
            if (!this.n) {
                this.u.setVisibility(8);
            }
            if (bool.booleanValue()) {
                return fragment;
            }
            getSupportFragmentManager().a().a(R.id.vertical_container, fragment, "parent").c();
            if (this.z == null) {
                this.z = fragment;
            }
            return fragment;
        } else if (ba.f61544f == j2 || "utility_creditcard".equalsIgnoreCase(uRLType)) {
            return a(bool.booleanValue(), bundle);
        } else {
            if (this.z == null) {
                bundle.putBoolean("is_selected_in_tabs", true);
            }
            this.f60802h = (o) Fragment.instantiate(this, o.class.getName(), bundle);
            if (this.z == null) {
                this.z = this.f60802h;
            }
            if (bool.booleanValue()) {
                return this.f60802h;
            }
            getSupportFragmentManager().a().a(R.id.vertical_container, this.f60802h, "parent").c();
            return this.f60802h;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Fragment a(CJRItem cJRItem, Bundle bundle, Boolean bool) {
        long j2;
        String str;
        Fragment fragment;
        if (cJRItem == null) {
            finish();
        }
        if (cJRItem != null) {
            str = cJRItem.getURLType();
            j2 = Long.valueOf(cJRItem.getCategoryId()).longValue();
        } else {
            str = "";
            j2 = 0;
        }
        if (!"mobile_postpaid".equalsIgnoreCase(str) && !"mobile-postpaid".equalsIgnoreCase(str) && !"mobile_prepaid".equalsIgnoreCase(str) && !"mobile-prepaid".equalsIgnoreCase(str) && !"datacard_postpaid".equalsIgnoreCase(str) && !"datacard-postpaid".equalsIgnoreCase(str) && !"datacard_prepaid".equalsIgnoreCase(str) && !"datacard-prepaid".equalsIgnoreCase(str)) {
            if (cJRItem == null) {
                try {
                    finish();
                    return null;
                } catch (Exception unused) {
                }
            }
            if (ba.f61544f == j2 || "utility_creditcard".equalsIgnoreCase(cJRItem.getURLType())) {
                this.f60796a = true;
                Fragment a2 = a(bool.booleanValue(), bundle);
                if (this.z == null) {
                    this.z = a2;
                }
                return a2;
            }
            this.f60801g = new net.one97.paytm.recharge.legacy.catalog.fragment.c();
            if (this.z == null) {
                this.z = this.f60801g;
                bundle.putBoolean("open_auth_activity_if_needed", true);
                bundle.putBoolean("is_selected_in_tabs", true);
            }
            this.f60801g.setArguments(bundle);
            if (bool.booleanValue()) {
                return this.f60801g;
            }
            getSupportFragmentManager().a().a(R.id.vertical_container, this.f60801g, "parent").c();
            return this.f60801g;
        } else if (cJRItem == null) {
            finish();
            return null;
        } else {
            d dVar = d.f64967a;
            d.b().getActionsMap().put(String.valueOf(j2), (Object) null);
            if (az.b((Context) this)) {
                fragment = Fragment.instantiate(this, net.one97.paytm.recharge.mobile_v3.b.g.class.getName(), bundle);
            } else {
                bundle.putBoolean("isInitialFragment", true);
                fragment = Fragment.instantiate(this, i.class.getName(), bundle);
            }
            if (this.z == null) {
                this.z = fragment;
            }
            if (!this.n) {
                this.u.setVisibility(8);
            }
            if (bool.booleanValue()) {
                return fragment;
            }
            getSupportFragmentManager().a().a(R.id.vertical_container, fragment, "parent").c();
            if (this.z == null) {
                this.z = fragment;
            }
            return fragment;
        }
    }

    private Fragment a(boolean z2, Bundle bundle) {
        this.F = new net.one97.paytm.recharge.creditcard.b.a();
        bundle.putBoolean("open_auth_activity_if_needed", true);
        bundle.putBoolean("is_selected_in_tabs", true);
        this.F.setArguments(bundle);
        if (z2) {
            return this.F;
        }
        q a2 = getSupportFragmentManager().a();
        int i2 = R.anim.enter_from_right;
        a2.a(i2, i2).a(R.id.vertical_container, this.F, "parent").c();
        return this.F;
    }

    public final void e() {
        if (this.n) {
            super.e();
            j();
            TabLayout tabLayout = this.y;
            if (tabLayout != null) {
                tabLayout.setVisibility(8);
                h();
            }
        }
    }

    public final void az_() {
        if (this.n) {
            super.az_();
            k();
            TabLayout tabLayout = this.y;
            if (tabLayout != null) {
                tabLayout.setVisibility(0);
                g();
            }
        }
    }

    public final void g() {
        if (this.n) {
            super.g();
            this.v.setSwipeEnabled(true);
        }
    }

    public final void h() {
        if (this.n) {
            super.h();
            this.v.setSwipeEnabled(false);
        }
    }

    public final void i() {
        super.i();
        if (this.u != null) {
            this.u.setVisibility(8);
        }
    }

    public final void b(String str) {
        super.b(str);
        if (this.u != null) {
            this.u.setVisibility(0);
            this.u.setTitle((CharSequence) str);
        }
    }

    public final void j() {
        if (this.n) {
            super.j();
            h();
            LinearLayout linearLayout = (LinearLayout) this.y.getChildAt(0);
            linearLayout.setEnabled(false);
            for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                linearLayout.getChildAt(i2).setClickable(false);
            }
        }
    }

    public final void k() {
        if (this.n) {
            super.k();
            g();
            LinearLayout linearLayout = (LinearLayout) this.y.getChildAt(0);
            linearLayout.setEnabled(false);
            for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                linearLayout.getChildAt(i2).setClickable(true);
            }
        }
    }

    public final Fragment b(int i2) {
        super.b(i2);
        t tVar = this.w;
        if (tVar != null) {
            return tVar.a(i2);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void z() {
        al_();
        this.x.setVisibility(8);
        this.I.setVisibility(0);
        a(Boolean.FALSE, this.f60800f);
    }

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<AJRRechargeUtilityActivity> f60810a;

        a(AJRRechargeUtilityActivity aJRRechargeUtilityActivity) {
            this.f60810a = new WeakReference<>(aJRRechargeUtilityActivity);
        }

        public final void run() {
            if (this.f60810a.get() != null && !((AJRRechargeUtilityActivity) this.f60810a.get()).C) {
                boolean unused = ((AJRRechargeUtilityActivity) this.f60810a.get()).C = true;
                ((AJRRechargeUtilityActivity) this.f60810a.get()).z();
                ((AJRRechargeUtilityActivity) this.f60810a.get()).a(10);
            }
        }
    }

    private static IJRPaytmDataModel a(String str, Context context, IJRPaytmDataModel iJRPaytmDataModel) {
        IJRPaytmDataModel iJRPaytmDataModel2;
        try {
            Cache.Entry entry = com.paytm.network.f.b(context).getCache().get(str);
            if (entry != null) {
                com.google.gsonhtcfix.f fVar = new com.google.gsonhtcfix.f();
                String str2 = entry.responseHeaders.get("Content-Encoding");
                if (entry.data != null) {
                    if (str2 == null || !str2.equals("gzip")) {
                        return (IJRPaytmDataModel) fVar.a(new String(entry.data, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8), iJRPaytmDataModel.getClass());
                    }
                    Reader a2 = com.paytm.network.b.g.a(entry.data);
                    iJRPaytmDataModel2 = (IJRPaytmDataModel) fVar.a(a2, iJRPaytmDataModel.getClass());
                    try {
                        a2.close();
                        return iJRPaytmDataModel2;
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            iJRPaytmDataModel2 = null;
            com.paytm.utility.q.d(e.getMessage());
            return iJRPaytmDataModel2;
        }
    }

    public final void a(boolean z2, boolean z3) {
        if (z2) {
            findViewById(R.id.overlay_view).setVisibility(0);
            if (z3 && Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(androidx.core.content.b.c(this, R.color.color_B31D252D));
                return;
            }
            return;
        }
        findViewById(R.id.overlay_view).setVisibility(8);
        if (z3 && Build.VERSION.SDK_INT >= 21) {
            Window window2 = getWindow();
            window2.addFlags(Integer.MIN_VALUE);
            window2.setStatusBarColor(androidx.core.content.b.c(this, R.color.white));
        }
    }

    public final void l() {
        setSupportActionBar(this.u);
    }

    static /* synthetic */ void a(AJRRechargeUtilityActivity aJRRechargeUtilityActivity) {
        String x2 = aJRRechargeUtilityActivity.x();
        if (!TextUtils.isEmpty(x2) && b.c((Context) aJRRechargeUtilityActivity)) {
            String b2 = com.paytm.utility.c.b(x2, (Context) aJRRechargeUtilityActivity);
            if (URLUtil.isValidUrl(b2)) {
                HashMap hashMap = new HashMap();
                hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(aJRRechargeUtilityActivity));
                AnonymousClass2 r3 = new ai() {
                    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                        if (AJRRechargeUtilityActivity.this.K.booleanValue()) {
                            Boolean unused = AJRRechargeUtilityActivity.this.K = Boolean.FALSE;
                        } else {
                            AJRRechargeUtilityActivity.this.a_(str, iJRPaytmDataModel, obj);
                        }
                    }

                    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                        if (AJRRechargeUtilityActivity.this.K.booleanValue()) {
                            Boolean unused = AJRRechargeUtilityActivity.this.K = Boolean.FALSE;
                        } else if (!AJRRechargeUtilityActivity.this.C) {
                            boolean unused2 = AJRRechargeUtilityActivity.this.C = true;
                            AJRRechargeUtilityActivity.this.al_();
                            AJRRechargeUtilityActivity.this.x.setVisibility(8);
                            AJRRechargeUtilityActivity.this.I.setVisibility(0);
                            AJRRechargeUtilityActivity.this.a(Boolean.FALSE, AJRRechargeUtilityActivity.this.f60800f);
                            AJRRechargeUtilityActivity.this.a(10);
                        }
                    }
                };
                CJRHomePageV2 cJRHomePageV2 = new CJRHomePageV2();
                d dVar = d.f64967a;
                net.one97.paytm.recharge.common.f.c cVar = new net.one97.paytm.recharge.common.f.c("fetch_category_menu", b2, (ai) r3, (IJRPaytmDataModel) cJRHomePageV2, (Map<String, String>) hashMap, (String) null, x2, (Object) d.a(ACTION_TYPE.GET_CATEGORY_MENU, ERROR_TYPE.UNDEFINED));
                cVar.a(true);
                net.one97.paytm.recharge.common.f.d.a();
                net.one97.paytm.recharge.common.f.d.b(cVar);
                if (!aJRRechargeUtilityActivity.K.booleanValue()) {
                    aJRRechargeUtilityActivity.C = false;
                    aJRRechargeUtilityActivity.f60797b.post(new Runnable() {
                        public final void run() {
                            AJRRechargeUtilityActivity.this.A();
                        }
                    });
                    TabLayout tabLayout = aJRRechargeUtilityActivity.y;
                    if (tabLayout != null) {
                        tabLayout.postDelayed(aJRRechargeUtilityActivity.M, aJRRechargeUtilityActivity.D);
                    }
                }
            }
        } else if (!aJRRechargeUtilityActivity.K.booleanValue()) {
            aJRRechargeUtilityActivity.z();
        }
    }
}
