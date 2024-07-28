package net.one97.paytm.recharge.common.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.android.material.tabs.TabLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.x;
import net.one97.paytm.common.widgets.SmartViewPager;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.aa;
import net.one97.paytm.recharge.common.e.e;
import net.one97.paytm.recharge.common.fragment.f;
import net.one97.paytm.recharge.common.fragment.g;
import net.one97.paytm.recharge.common.fragment.k;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.widget.CJRCustomTabLayout;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.model.CJRBrowsePlanHeader;
import net.one97.paytm.recharge.model.CJRBrowsePlansHeader;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescription;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescriptions;
import net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData;
import net.one97.paytm.recharge.model.mobile.CJRMadeForYouResponse;
import net.one97.paytm.recharge.widgets.c.b;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class AJRBrowsePlanActivity extends CJRRechargeToolbarActivity implements TabLayout.b, e, net.one97.paytm.recharge.coupons.c.a {

    /* renamed from: a  reason: collision with root package name */
    public static String f60738a = "is_dynamic";
    private String A;
    private String B;
    /* access modifiers changed from: private */
    public String C;
    /* access modifiers changed from: private */
    public long D;
    private boolean E;
    private ArrayList<Boolean> F;
    private ArrayList<Integer> G;
    private final int H = 20;
    /* access modifiers changed from: private */
    public String I;
    private String J;
    private String K;

    /* renamed from: b  reason: collision with root package name */
    protected SmartViewPager f60739b;

    /* renamed from: c  reason: collision with root package name */
    protected CJRCustomTabLayout f60740c;

    /* renamed from: d  reason: collision with root package name */
    protected RelativeLayout f60741d;

    /* renamed from: e  reason: collision with root package name */
    protected TextView f60742e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f60743f = false;

    /* renamed from: g  reason: collision with root package name */
    boolean f60744g = true;

    /* renamed from: h  reason: collision with root package name */
    CJRMadeForYouResponse f60745h;

    /* renamed from: i  reason: collision with root package name */
    String f60746i;
    String j;
    boolean k = true;
    boolean l;
    String m;
    String n;
    View o;
    /* access modifiers changed from: private */
    public CJRBrowsePlansHeader v;
    private a w;
    /* access modifiers changed from: private */
    public HashMap<Integer, CJRBrowsePlanDescriptions> x = new HashMap<>();
    private String y;
    private String z;

    public void onTabReselected(TabLayout.f fVar) {
    }

    public void onTabUnselected(TabLayout.f fVar) {
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.browse_plan_activity);
        al_();
        this.s = true;
        this.y = getIntent().getStringExtra(AppManagerUtil.EXTEND_TYPE);
        this.z = getIntent().getStringExtra(StringSet.operator);
        this.A = getIntent().getStringExtra("operator_display");
        this.B = getIntent().getStringExtra("circle");
        this.I = getIntent().getStringExtra("roaming");
        this.D = getIntent().getLongExtra(CLPConstants.PRODUCT_ID, 0);
        this.m = getIntent().getStringExtra("category_id");
        this.n = getIntent().getStringExtra(SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.C = getIntent().getStringExtra("recharge_number");
        this.f60744g = getIntent().getBooleanExtra("made_for_you_flag", false);
        this.f60743f = getIntent().getBooleanExtra(f60738a, false);
        this.f60746i = getIntent().getStringExtra("one2one_disclaimer");
        this.j = getIntent().getStringExtra("one2one_tab_title");
        this.f60745h = (CJRMadeForYouResponse) getIntent().getSerializableExtra("one2one_offers_object");
        if (getIntent().hasExtra("ContentMap")) {
            this.x = (HashMap) getIntent().getSerializableExtra("ContentMap");
        }
        if (getIntent().hasExtra("browsePlanHeader")) {
            this.v = (CJRBrowsePlansHeader) getIntent().getSerializableExtra("browsePlanHeader");
        }
        if (getIntent().hasExtra("operator_heading")) {
            this.J = getIntent().getStringExtra("operator_heading");
        }
        if (getIntent().hasExtra("circle_heading")) {
            this.K = getIntent().getStringExtra("circle_heading");
        }
        this.f60741d = (RelativeLayout) findViewById(R.id.browse_lyt_progress_bar);
        if (!TextUtils.isEmpty(this.A)) {
            if (this.J != null) {
                str = "" + this.J + " ";
            } else {
                str = "" + this.A + " ";
            }
            if (!TextUtils.isEmpty(this.B) && !this.B.equalsIgnoreCase(StringSet.all)) {
                if (this.K != null) {
                    str = str + " - " + this.K + " ";
                } else {
                    str = str + " - " + this.B + " ";
                }
            }
            setTitle(str + getString(R.string.plans));
        } else {
            setTitle(getResources().getString(R.string.indicative_plans));
        }
        b.a(new kotlin.g.a.a() {
            public final Object invoke() {
                return AJRBrowsePlanActivity.this.l();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x l() {
        if (!TextUtils.isEmpty(this.y) && this.y.equalsIgnoreCase("mobile")) {
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            net.one97.paytm.recharge.di.helper.b.a((Context) this, "recharge/browse-plans-tab");
        }
        if (TextUtils.isEmpty(this.y) || !this.y.equalsIgnoreCase("dth")) {
            return null;
        }
        net.one97.paytm.recharge.di.helper.b bVar2 = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a((Context) this, "/dth/browse-plans");
        return null;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: private */
    public void a(CJRBrowsePlansHeader cJRBrowsePlansHeader) {
        this.f60739b = (SmartViewPager) findViewById(R.id.plans_pager);
        this.f60742e = (TextView) findViewById(R.id.disclaimer_textview);
        com.paytm.utility.b.b(this.f60742e);
        this.F = new ArrayList<>();
        this.G = new ArrayList<>();
        if (cJRBrowsePlansHeader != null) {
            this.v = cJRBrowsePlansHeader;
            c();
            return;
        }
        d dVar = d.f64967a;
        CJRRechargeErrorModel a2 = d.a(ACTION_TYPE.BROWSE_PLAN, ERROR_TYPE.UNDEFINED);
        if (!isFinishing()) {
            try {
                if (!TextUtils.isEmpty(this.y) && !TextUtils.isEmpty(this.z) && !TextUtils.isEmpty(this.B)) {
                    c cVar = c.f62654a;
                    String ad = c.ad();
                    try {
                        ad = ad + "/" + URLEncoder.encode(this.y, AppConstants.UTF_8) + "?operator=" + URLEncoder.encode(this.z, AppConstants.UTF_8);
                        if (!this.B.equalsIgnoreCase(StringSet.all)) {
                            ad = ad + "&circle=" + URLEncoder.encode(this.B, AppConstants.UTF_8);
                        }
                    } catch (UnsupportedEncodingException e2) {
                        q.d(e2.getMessage());
                    }
                    if (TextUtils.isEmpty(ad)) {
                        return;
                    }
                    if (com.paytm.utility.b.c((Context) this)) {
                        String b2 = com.paytm.utility.b.b((Context) this, ad);
                        getApplicationContext();
                        net.one97.paytm.recharge.common.f.d.a();
                        net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b("fetch_browse_plan_header", com.paytm.utility.b.t(this, b2), this, new CJRBrowsePlansHeader(), a2));
                        this.f60741d.setVisibility(0);
                        return;
                    }
                    ba.a((net.one97.paytm.recharge.common.f.a) new net.one97.paytm.recharge.common.f.b("fetch_browse_plan_header", com.paytm.utility.b.b((Context) this, ad), this, new CJRBrowsePlansHeader(), a2), (Context) this, (DialogInterface.OnCancelListener) this, (aa) null);
                }
            } catch (Exception e3) {
                q.d(e3.getMessage());
            }
        }
    }

    private void c() {
        if (!isFinishing()) {
            try {
                this.f60741d.setVisibility(8);
                this.f60739b.setVisibility(0);
                if (this.v != null) {
                    if (this.f60744g) {
                        CJRBrowsePlanHeader cJRBrowsePlanHeader = new CJRBrowsePlanHeader();
                        if (TextUtils.isEmpty(this.j)) {
                            cJRBrowsePlanHeader.setmName("121 Made for You");
                        } else {
                            cJRBrowsePlanHeader.setmName(this.j);
                        }
                        cJRBrowsePlanHeader.setMadeForYouPlan(true);
                        this.v.getBrowsePlans().add(0, cJRBrowsePlanHeader);
                    }
                    this.G.clear();
                    this.F.clear();
                    for (int i2 = 0; i2 < this.v.getBrowsePlans().size(); i2++) {
                        this.G.add(1);
                        this.F.add(Boolean.TRUE);
                    }
                    if (this.v.getBrowsePlans() == null || !this.v.getBrowsePlans().isEmpty()) {
                        getApplicationContext();
                        this.w = new a(getSupportFragmentManager(), this.v);
                        this.f60739b.setAdapter(this.w);
                        this.f60740c = (CJRCustomTabLayout) findViewById(R.id.indicator);
                        this.f60740c.setupWithViewPager(this.f60739b);
                        this.f60740c.a((TabLayout.b) this);
                        LayoutInflater from = LayoutInflater.from(getApplicationContext());
                        for (int i3 = 0; i3 < this.v.getBrowsePlans().size(); i3++) {
                            TabLayout.f a2 = this.f60740c.a(i3);
                            View inflate = from.inflate(R.layout.browse_plan_custom_tab_title, (ViewGroup) null);
                            TextView textView = (TextView) inflate.findViewById(R.id.tab_title);
                            getApplicationContext();
                            com.paytm.utility.b.c(textView);
                            textView.setText(this.v.getBrowsePlans().get(i3).getName());
                            a2.a(inflate);
                        }
                        this.f60740c.setSelectedTabIndicatorHeight(0);
                        if (this.I != null) {
                            new Handler().postDelayed(new Runnable() {
                                public final void run() {
                                    if (AJRBrowsePlanActivity.this.f60740c.a(6) != null) {
                                        AJRBrowsePlanActivity.this.f60740c.a(6).d();
                                        String unused = AJRBrowsePlanActivity.this.I = null;
                                    }
                                }
                            }, 1000);
                        } else if (!this.f60743f || this.f60744g) {
                            onTabSelected(this.f60740c.a(0));
                        } else {
                            new Handler().postDelayed(new Runnable() {
                                public final void run() {
                                    AJRBrowsePlanActivity.this.onTabSelected(AJRBrowsePlanActivity.this.f60740c.a(0));
                                }
                            }, 500);
                        }
                        this.f60740c.getLayoutParams().height = ((com.paytm.utility.b.f((Context) this) * 9) / 2) / 2;
                        return;
                    }
                    d();
                }
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        try {
            if (!isFinishing()) {
                CJRRechargeUtilities.INSTANCE.handleError(str, this, (Fragment) null, networkCustomError, true, 3, obj);
            }
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        if (!isFinishing()) {
            try {
                if (iJRPaytmDataModel instanceof CJRBrowsePlansHeader) {
                    this.v = (CJRBrowsePlansHeader) iJRPaytmDataModel;
                    c();
                } else if (iJRPaytmDataModel instanceof CJRBrowsePlanDescriptions) {
                    CJRBrowsePlanDescriptions cJRBrowsePlanDescriptions = (CJRBrowsePlanDescriptions) iJRPaytmDataModel;
                    if (cJRBrowsePlanDescriptions != null && (cJRBrowsePlanDescriptions.getDescription() == null || (cJRBrowsePlanDescriptions.getDescription().size() == 0 && !this.F.isEmpty() && this.F.size() > 0))) {
                        this.F.set(this.f60739b.getCurrentItem(), Boolean.FALSE);
                    }
                    try {
                        if (this.F.size() > 0 && !this.F.isEmpty() && this.f60739b != null) {
                            this.F.set(this.f60739b.getCurrentItem(), Boolean.valueOf(cJRBrowsePlanDescriptions.hasMore()));
                        }
                    } catch (IndexOutOfBoundsException e2) {
                        q.d(e2.getMessage());
                    }
                    boolean z2 = false;
                    if (this.E) {
                        this.E = false;
                        if (!isFinishing() && cJRBrowsePlanDescriptions != null) {
                            try {
                                g gVar = (g) this.w.a(this.f60739b.getCurrentItem());
                                if (gVar != null) {
                                    if (!TextUtils.isEmpty(this.y) && (this.y.equalsIgnoreCase("mobile") || this.y.equalsIgnoreCase("datacard"))) {
                                        z2 = true;
                                    }
                                    CJRBrowsePlanDescriptions cJRBrowsePlanDescriptions2 = cJRBrowsePlanDescriptions;
                                    if (!(gVar.f61180d == null || cJRBrowsePlanDescriptions2.getDescription() == null)) {
                                        g.a aVar = gVar.f61180d;
                                        Iterator<CJRBrowsePlanDescription> it2 = cJRBrowsePlanDescriptions2.getDescription().iterator();
                                        while (it2.hasNext()) {
                                            aVar.f61184a.add(it2.next());
                                        }
                                        aVar.f61185b = z2;
                                        aVar.notifyDataSetChanged();
                                    }
                                }
                            } catch (Exception e3) {
                                q.d(e3.getMessage());
                            }
                        }
                    } else if (!isFinishing() && cJRBrowsePlanDescriptions != null) {
                        try {
                            if (!(this.x == null || this.f60739b == null)) {
                                this.x.put(Integer.valueOf(this.f60739b.getCurrentItem()), cJRBrowsePlanDescriptions);
                                g gVar2 = (g) this.w.a(this.f60739b.getCurrentItem());
                                if (gVar2 != null) {
                                    if (!TextUtils.isEmpty(this.y) && (this.y.equalsIgnoreCase("mobile") || this.y.equalsIgnoreCase("datacard"))) {
                                        z2 = true;
                                    }
                                    gVar2.a(cJRBrowsePlanDescriptions, z2);
                                }
                            }
                        } catch (Exception e4) {
                            q.d(e4.getMessage());
                        }
                    }
                    this.f60739b.setPagingEnabled(true);
                }
            } catch (Exception e5) {
                q.d(e5.getMessage());
            }
        }
    }

    public class a extends m {

        /* renamed from: a  reason: collision with root package name */
        HashMap<Integer, String> f60751a = new HashMap<>();

        /* renamed from: b  reason: collision with root package name */
        CJRBrowsePlansHeader f60752b;

        /* renamed from: d  reason: collision with root package name */
        private j f60754d;

        public a(j jVar, CJRBrowsePlansHeader cJRBrowsePlansHeader) {
            super(jVar);
            this.f60754d = jVar;
            this.f60752b = cJRBrowsePlansHeader;
        }

        public final CharSequence getPageTitle(int i2) {
            return this.f60752b.getBrowsePlans().get(i2).getName();
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i2) {
            Object instantiateItem = super.instantiateItem(viewGroup, i2);
            if (instantiateItem instanceof Fragment) {
                this.f60751a.put(Integer.valueOf(i2), ((Fragment) instantiateItem).getTag());
            }
            return instantiateItem;
        }

        public final Fragment getItem(int i2) {
            if (this.f60752b.getBrowsePlans().get(i2).isMadeForYouPlan()) {
                return k.a(this.f60752b.getBrowsePlans().get(i2).getName(), AJRBrowsePlanActivity.this.f60742e.getHeight(), AJRBrowsePlanActivity.this.f60745h, AJRBrowsePlanActivity.this.C, AJRBrowsePlanActivity.this.D);
            }
            return g.a(this.f60752b.getBrowsePlans().get(i2).getName(), AJRBrowsePlanActivity.this.f60742e.getHeight(), AJRBrowsePlanActivity.this.f60743f && !AJRBrowsePlanActivity.this.f60744g);
        }

        public final int getCount() {
            ArrayList<CJRBrowsePlanHeader> browsePlans;
            CJRBrowsePlansHeader cJRBrowsePlansHeader = this.f60752b;
            if (cJRBrowsePlansHeader == null || (browsePlans = cJRBrowsePlansHeader.getBrowsePlans()) == null) {
                return 0;
            }
            return browsePlans.size();
        }

        public final Fragment a(int i2) {
            String str = this.f60751a.get(Integer.valueOf(i2));
            if (str == null) {
                return (Fragment) instantiateItem(AJRBrowsePlanActivity.this.f60739b, i2);
            }
            return this.f60754d.c(str);
        }

        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView(((Fragment) obj).getView());
            this.f60751a.remove(Integer.valueOf(i2));
            super.destroyItem(viewGroup, i2, obj);
        }
    }

    public void onTabSelected(TabLayout.f fVar) {
        if (!isFinishing()) {
            b.a(new kotlin.g.a.a(fVar) {
                private final /* synthetic */ TabLayout.f f$1;

                {
                    this.f$1 = r2;
                }

                public final Object invoke() {
                    return AJRBrowsePlanActivity.this.a(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x a(TabLayout.f fVar) {
        String str;
        String str2 = this.y;
        if (str2 != null && str2.equalsIgnoreCase("dth")) {
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            net.one97.paytm.recharge.di.helper.b.a((Context) this, this.y + " (new)", "browse_plans_tab_clicked", "/" + this.y.toLowerCase() + "/browse-plans", fVar.f36763c.toString());
        }
        CJRBrowsePlansHeader cJRBrowsePlansHeader = this.v;
        boolean z2 = true;
        if (cJRBrowsePlansHeader == null || cJRBrowsePlansHeader.getBrowsePlans() == null || this.v.getBrowsePlans().size() <= fVar.f36765e || !this.v.getBrowsePlans().get(fVar.f36765e).isMadeForYouPlan() || TextUtils.isEmpty(this.f60746i)) {
            this.f60742e.setText(R.string.disclaimer_text);
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("Disclaimer - " + this.f60746i);
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, 11, 33);
            this.f60742e.setText(spannableStringBuilder);
        }
        this.f60739b.setCurrentItem(fVar.f36765e);
        this.l = false;
        this.f60742e.setVisibility(0);
        View view = fVar.f36766f;
        TextView textView = (TextView) view.findViewById(R.id.tab_title);
        getApplicationContext();
        com.paytm.utility.b.d(textView);
        textView.setTextColor(getResources().getColor(R.color.tab_selected_color));
        view.findViewById(R.id.tab_indicator_view).setVisibility(0);
        View view2 = this.o;
        if (view2 != null) {
            TextView textView2 = (TextView) view2.findViewById(R.id.tab_title);
            textView2.setTextColor(getResources().getColor(R.color.tab_unselected_color));
            getApplicationContext();
            com.paytm.utility.b.c(textView2);
            this.o.findViewById(R.id.tab_indicator_view).setVisibility(4);
        }
        this.o = view;
        if (!this.x.containsKey(Integer.valueOf(fVar.f36765e))) {
            String url = this.v.getBrowsePlans().get(fVar.f36765e).getUrl();
            if (url != null && url.trim().length() > 0) {
                d dVar = d.f64967a;
                a("load_plan_description", url, 1, d.a(ACTION_TYPE.BROWSE_PLAN, ERROR_TYPE.UNDEFINED));
            }
        } else {
            g gVar = (g) this.w.a(this.f60739b.getCurrentItem());
            if (gVar != null) {
                if (TextUtils.isEmpty(this.y) || (!this.y.equalsIgnoreCase("mobile") && !this.y.equalsIgnoreCase("datacard"))) {
                    z2 = false;
                }
                gVar.a(this.x.get(Integer.valueOf(fVar.f36765e)), z2);
            }
        }
        if (!this.y.equalsIgnoreCase("mobile")) {
            return null;
        }
        net.one97.paytm.recharge.di.helper.b bVar2 = net.one97.paytm.recharge.di.helper.b.f62652a;
        if (getIntent() == null || !getIntent().hasExtra("mobile_recharge_type")) {
            str = "";
        } else {
            str = getIntent().getExtras().getString("mobile_recharge_type");
        }
        net.one97.paytm.recharge.di.helper.b.a((Context) this, str, "browse_plans_tabs_clicked", "");
        return null;
    }

    private void a(String str, String str2, int i2, Object obj) {
        String str3;
        if (!isFinishing()) {
            try {
                if (Uri.parse(str2).getQuery() != null) {
                    str3 = str2 + "&description=1&";
                } else {
                    str3 = str2 + "?description=1&";
                }
                c cVar = c.f62654a;
                if (c.F()) {
                    str3 = str3 + "sort_price=1&";
                }
                if (!TextUtils.isEmpty(this.z) && !TextUtils.isEmpty(this.B)) {
                    try {
                        if (!this.B.equalsIgnoreCase(StringSet.all)) {
                            str3 = str3 + "circle=" + URLEncoder.encode(this.B, AppConstants.UTF_8) + "&operator=" + URLEncoder.encode(this.z, AppConstants.UTF_8) + "&items_per_page=20&page_count=" + i2 + "&attributes=Product%20Type";
                        } else {
                            str3 = str3 + "operator=" + URLEncoder.encode(this.z, AppConstants.UTF_8) + "&items_per_page=20&page_count=" + i2 + "&attributes=Product%20Type";
                        }
                    } catch (UnsupportedEncodingException e2) {
                        q.d(e2.getMessage());
                    }
                }
                this.f60739b.setPagingEnabled(false);
                if (com.paytm.utility.b.c((Context) this)) {
                    String b2 = com.paytm.utility.b.b((Context) this, str3);
                    getApplicationContext();
                    net.one97.paytm.recharge.common.f.d.a();
                    net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b(str, com.paytm.utility.b.t(this, b2), this, new CJRBrowsePlanDescriptions(), obj));
                    return;
                }
                ba.a((net.one97.paytm.recharge.common.f.a) new net.one97.paytm.recharge.common.f.b(str, com.paytm.utility.b.b((Context) this, str3), this, new CJRBrowsePlanDescriptions(), obj), (Context) this, (DialogInterface.OnCancelListener) this, (aa) null);
            } catch (Exception e3) {
                q.d(e3.getMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00db A[Catch:{ Exception -> 0x00fe }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r5, boolean r6, java.util.HashMap<java.lang.String, java.lang.String> r7, java.lang.String r8, java.lang.String r9, net.one97.paytm.recharge.model.mobile.CJRBrowsePlansDescAttributes r10, boolean r11) {
        /*
            r4 = this;
            boolean r0 = r4.isFinishing()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x00fe }
            r0.<init>()     // Catch:{ Exception -> 0x00fe }
            net.one97.paytm.recharge.model.CJRBrowsePlansHeader r1 = r4.v     // Catch:{ Exception -> 0x00fe }
            java.lang.String r2 = "title"
            if (r1 == 0) goto L_0x003f
            net.one97.paytm.recharge.model.CJRBrowsePlansHeader r1 = r4.v     // Catch:{ Exception -> 0x00fe }
            java.util.ArrayList r1 = r1.getBrowsePlans()     // Catch:{ Exception -> 0x00fe }
            net.one97.paytm.common.widgets.SmartViewPager r3 = r4.f60739b     // Catch:{ Exception -> 0x00fe }
            int r3 = r3.getCurrentItem()     // Catch:{ Exception -> 0x00fe }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x00fe }
            if (r1 == 0) goto L_0x003f
            net.one97.paytm.recharge.model.CJRBrowsePlansHeader r1 = r4.v     // Catch:{ Exception -> 0x00fe }
            java.util.ArrayList r1 = r1.getBrowsePlans()     // Catch:{ Exception -> 0x00fe }
            net.one97.paytm.common.widgets.SmartViewPager r3 = r4.f60739b     // Catch:{ Exception -> 0x00fe }
            int r3 = r3.getCurrentItem()     // Catch:{ Exception -> 0x00fe }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x00fe }
            net.one97.paytm.recharge.model.CJRBrowsePlanHeader r1 = (net.one97.paytm.recharge.model.CJRBrowsePlanHeader) r1     // Catch:{ Exception -> 0x00fe }
            java.lang.String r1 = r1.getCategoryId()     // Catch:{ Exception -> 0x00fe }
            r0.putExtra(r2, r1)     // Catch:{ Exception -> 0x00fe }
            goto L_0x006e
        L_0x003f:
            net.one97.paytm.recharge.model.CJRBrowsePlansHeader r1 = r4.v     // Catch:{ Exception -> 0x00fe }
            if (r1 == 0) goto L_0x006e
            net.one97.paytm.recharge.model.CJRBrowsePlansHeader r1 = r4.v     // Catch:{ Exception -> 0x00fe }
            java.util.ArrayList r1 = r1.getBrowsePlans()     // Catch:{ Exception -> 0x00fe }
            net.one97.paytm.common.widgets.SmartViewPager r3 = r4.f60739b     // Catch:{ Exception -> 0x00fe }
            int r3 = r3.getCurrentItem()     // Catch:{ Exception -> 0x00fe }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x00fe }
            if (r1 == 0) goto L_0x006e
            net.one97.paytm.recharge.model.CJRBrowsePlansHeader r1 = r4.v     // Catch:{ Exception -> 0x00fe }
            java.util.ArrayList r1 = r1.getBrowsePlans()     // Catch:{ Exception -> 0x00fe }
            net.one97.paytm.common.widgets.SmartViewPager r3 = r4.f60739b     // Catch:{ Exception -> 0x00fe }
            int r3 = r3.getCurrentItem()     // Catch:{ Exception -> 0x00fe }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x00fe }
            net.one97.paytm.recharge.model.CJRBrowsePlanHeader r1 = (net.one97.paytm.recharge.model.CJRBrowsePlanHeader) r1     // Catch:{ Exception -> 0x00fe }
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x00fe }
            r0.putExtra(r2, r1)     // Catch:{ Exception -> 0x00fe }
        L_0x006e:
            net.one97.paytm.recharge.model.CJRBrowsePlansHeader r1 = r4.v     // Catch:{ Exception -> 0x00fe }
            java.util.ArrayList r1 = r1.getBrowsePlans()     // Catch:{ Exception -> 0x00fe }
            net.one97.paytm.common.widgets.SmartViewPager r2 = r4.f60739b     // Catch:{ Exception -> 0x00fe }
            int r2 = r2.getCurrentItem()     // Catch:{ Exception -> 0x00fe }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x00fe }
            net.one97.paytm.recharge.model.CJRBrowsePlanHeader r1 = (net.one97.paytm.recharge.model.CJRBrowsePlanHeader) r1     // Catch:{ Exception -> 0x00fe }
            boolean r1 = r1.isOtc()     // Catch:{ Exception -> 0x00fe }
            java.lang.String r2 = "amount"
            r0.putExtra(r2, r5)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r5 = "operator"
            java.lang.String r2 = r4.z     // Catch:{ Exception -> 0x00fe }
            r0.putExtra(r5, r2)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r5 = "circle"
            java.lang.String r2 = r4.B     // Catch:{ Exception -> 0x00fe }
            r0.putExtra(r5, r2)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r5 = "product-type"
            r0.putExtra(r5, r6)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r5 = "is_otc"
            r0.putExtra(r5, r1)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r5 = "plan_guid"
            r0.putExtra(r5, r8)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r5 = "plan_name"
            r0.putExtra(r5, r9)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r5 = "plan_desc"
            r0.putExtra(r5, r10)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r5 = "use_plan_name_in_plan_description"
            r0.putExtra(r5, r11)     // Catch:{ Exception -> 0x00fe }
            if (r7 == 0) goto L_0x00c3
            int r5 = r7.size()     // Catch:{ Exception -> 0x00fe }
            if (r5 <= 0) goto L_0x00c3
            java.lang.String r5 = "meta_description"
            r0.putExtra(r5, r7)     // Catch:{ Exception -> 0x00fe }
        L_0x00c3:
            net.one97.paytm.recharge.model.CJRBrowsePlansHeader r5 = r4.v     // Catch:{ Exception -> 0x00fe }
            java.util.ArrayList r5 = r5.getBrowsePlans()     // Catch:{ Exception -> 0x00fe }
            net.one97.paytm.common.widgets.SmartViewPager r6 = r4.f60739b     // Catch:{ Exception -> 0x00fe }
            int r6 = r6.getCurrentItem()     // Catch:{ Exception -> 0x00fe }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ Exception -> 0x00fe }
            net.one97.paytm.recharge.model.CJRBrowsePlanHeader r5 = (net.one97.paytm.recharge.model.CJRBrowsePlanHeader) r5     // Catch:{ Exception -> 0x00fe }
            java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x00fe }
            if (r5 == 0) goto L_0x00f6
            java.lang.String r5 = "package_name"
            net.one97.paytm.recharge.model.CJRBrowsePlansHeader r6 = r4.v     // Catch:{ Exception -> 0x00fe }
            java.util.ArrayList r6 = r6.getBrowsePlans()     // Catch:{ Exception -> 0x00fe }
            net.one97.paytm.common.widgets.SmartViewPager r7 = r4.f60739b     // Catch:{ Exception -> 0x00fe }
            int r7 = r7.getCurrentItem()     // Catch:{ Exception -> 0x00fe }
            java.lang.Object r6 = r6.get(r7)     // Catch:{ Exception -> 0x00fe }
            net.one97.paytm.recharge.model.CJRBrowsePlanHeader r6 = (net.one97.paytm.recharge.model.CJRBrowsePlanHeader) r6     // Catch:{ Exception -> 0x00fe }
            java.lang.String r6 = r6.getName()     // Catch:{ Exception -> 0x00fe }
            r0.putExtra(r5, r6)     // Catch:{ Exception -> 0x00fe }
        L_0x00f6:
            r5 = -1
            r4.setResult(r5, r0)     // Catch:{ Exception -> 0x00fe }
            r4.finish()     // Catch:{ Exception -> 0x00fe }
            return
        L_0x00fe:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.paytm.utility.q.d(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.activity.AJRBrowsePlanActivity.a(java.lang.String, boolean, java.util.HashMap, java.lang.String, java.lang.String, net.one97.paytm.recharge.model.mobile.CJRBrowsePlansDescAttributes, boolean):void");
    }

    public final void b() {
        if (!isFinishing()) {
            try {
                if (!this.E) {
                    int currentItem = this.f60739b.getCurrentItem();
                    if (!this.F.get(currentItem).booleanValue()) {
                        com.paytm.utility.b.j();
                        return;
                    }
                    String url = this.v.getBrowsePlans().get(currentItem).getUrl();
                    if (url != null && url.trim().length() > 0) {
                        this.E = true;
                        if (this.G.size() > 0 && !this.G.isEmpty()) {
                            ArrayList<Integer> arrayList = this.G;
                            arrayList.set(currentItem, Integer.valueOf(arrayList.get(currentItem).intValue() + 1));
                        }
                        int intValue = this.G.get(currentItem).intValue();
                        d dVar = d.f64967a;
                        a("load_plan_description", url, intValue, d.a(ACTION_TYPE.BROWSE_PLAN, ERROR_TYPE.UNDEFINED));
                    }
                }
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:18|19|20|21|22|23|(2:25|26)(2:27|28)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x007d */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0097 A[Catch:{ Exception -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009e A[Catch:{ Exception -> 0x00b3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r11 = this;
            boolean r0 = r11.isFinishing()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = r11.f60743f     // Catch:{ Exception -> 0x00b3 }
            if (r0 == 0) goto L_0x00a3
            boolean r0 = r11.f60744g     // Catch:{ Exception -> 0x00b3 }
            if (r0 != 0) goto L_0x00a3
            net.one97.paytm.recharge.model.CJRBrowsePlansHeader r0 = r11.v     // Catch:{ Exception -> 0x00b3 }
            if (r0 == 0) goto L_0x001d
            java.util.HashMap<java.lang.Integer, net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescriptions> r0 = r11.x     // Catch:{ Exception -> 0x00b3 }
            if (r0 == 0) goto L_0x001d
            net.one97.paytm.recharge.model.CJRBrowsePlansHeader r0 = r11.v     // Catch:{ Exception -> 0x00b3 }
            r11.a((net.one97.paytm.recharge.model.CJRBrowsePlansHeader) r0)     // Catch:{ Exception -> 0x00b3 }
            return
        L_0x001d:
            android.widget.RelativeLayout r0 = r11.f60741d     // Catch:{ Exception -> 0x00b3 }
            r1 = 0
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r3 = "fetch_dynamic_plan"
            net.one97.paytm.recharge.di.helper.c r0 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r4 = net.one97.paytm.recharge.di.helper.c.G()     // Catch:{ Exception -> 0x00b3 }
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ Exception -> 0x00b3 }
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.BROWSE_PLAN     // Catch:{ Exception -> 0x00b3 }
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED     // Catch:{ Exception -> 0x00b3 }
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r10 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)     // Catch:{ Exception -> 0x00b3 }
            boolean r0 = android.webkit.URLUtil.isValidUrl(r4)     // Catch:{ Exception -> 0x00b3 }
            if (r0 != 0) goto L_0x0059
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a     // Catch:{ Exception -> 0x00b3 }
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INVALID_URL     // Catch:{ Exception -> 0x00b3 }
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r1 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.BROWSE_PLAN     // Catch:{ Exception -> 0x00b3 }
            android.content.res.Resources r2 = r11.getResources()     // Catch:{ Exception -> 0x00b3 }
            int r3 = net.one97.paytm.recharge.R.string.error     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x00b3 }
            android.content.res.Resources r3 = r11.getResources()     // Catch:{ Exception -> 0x00b3 }
            int r4 = net.one97.paytm.recharge.R.string.msg_invalid_url     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x00b3 }
            net.one97.paytm.recharge.common.utils.az.a(r11, r0, r1, r2, r3)     // Catch:{ Exception -> 0x00b3 }
            return
        L_0x0059:
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ Exception -> 0x00b3 }
            r8.<init>()     // Catch:{ Exception -> 0x00b3 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Exception -> 0x00b3 }
            r7.<init>()     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r0 = "Content-Type"
            java.lang.String r1 = "application/json"
            r8.put(r0, r1)     // Catch:{ Exception -> 0x00b3 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b3 }
            r0.<init>()     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r1 = "recharge_number"
            java.lang.String r2 = r11.C     // Catch:{ JSONException -> 0x007d }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x007d }
            java.lang.String r1 = "product_id"
            long r5 = r11.D     // Catch:{ JSONException -> 0x007d }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x007d }
        L_0x007d:
            net.one97.paytm.recharge.common.f.c r1 = new net.one97.paytm.recharge.common.f.c     // Catch:{ Exception -> 0x00b3 }
            net.one97.paytm.recharge.common.activity.AJRBrowsePlanActivity$3 r5 = new net.one97.paytm.recharge.common.activity.AJRBrowsePlanActivity$3     // Catch:{ Exception -> 0x00b3 }
            r5.<init>()     // Catch:{ Exception -> 0x00b3 }
            net.one97.paytm.recharge.model.CJRDynamicBrowsePlans r6 = new net.one97.paytm.recharge.model.CJRDynamicBrowsePlans     // Catch:{ Exception -> 0x00b3 }
            r6.<init>()     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x00b3 }
            r2 = r1
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (net.one97.paytm.recharge.common.e.ai) r5, (com.paytm.network.model.IJRPaytmDataModel) r6, (java.util.Map<java.lang.String, java.lang.String>) r7, (java.util.Map<java.lang.String, java.lang.String>) r8, (java.lang.String) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x00b3 }
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r11)     // Catch:{ Exception -> 0x00b3 }
            if (r0 == 0) goto L_0x009e
            net.one97.paytm.recharge.common.f.d.a()     // Catch:{ Exception -> 0x00b3 }
            net.one97.paytm.recharge.common.f.d.b(r1)     // Catch:{ Exception -> 0x00b3 }
            return
        L_0x009e:
            r0 = 0
            net.one97.paytm.recharge.common.utils.ba.a((net.one97.paytm.recharge.common.f.a) r1, (android.content.Context) r11, (android.content.DialogInterface.OnCancelListener) r11, (net.one97.paytm.recharge.common.e.aa) r0)     // Catch:{ Exception -> 0x00b3 }
            return
        L_0x00a3:
            android.content.Intent r0 = r11.getIntent()     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r1 = "indicative_paln_list"
            java.io.Serializable r0 = r0.getSerializableExtra(r1)     // Catch:{ Exception -> 0x00b3 }
            net.one97.paytm.recharge.model.CJRBrowsePlansHeader r0 = (net.one97.paytm.recharge.model.CJRBrowsePlansHeader) r0     // Catch:{ Exception -> 0x00b3 }
            r11.a((net.one97.paytm.recharge.model.CJRBrowsePlansHeader) r0)     // Catch:{ Exception -> 0x00b3 }
            return
        L_0x00b3:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.activity.AJRBrowsePlanActivity.a():void");
    }

    public void onDestroy() {
        try {
            if (this.x != null) {
                this.x.clear();
                this.x = null;
            }
            if (!(this.v == null || this.v.getBrowsePlans() == null)) {
                this.v.getBrowsePlans().clear();
                this.v = null;
            }
            if (this.w != null) {
                a aVar = this.w;
                if (aVar.f60751a != null) {
                    aVar.f60751a.clear();
                    aVar.f60751a = null;
                }
                if (aVar.f60752b != null) {
                    aVar.f60752b = null;
                }
            }
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        super.onBackPressed();
        try {
            new net.one97.paytm.recharge.ordersummary.h.d(getApplicationContext()).a("DTH (new)", "plan_back_button_clicked", "", "", "", "", "");
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        com.paytm.utility.g.f43805b = new g.a() {
            public final void onOkClick() {
                AJRBrowsePlanActivity.this.finish();
            }
        };
        az azVar = az.f61525a;
        az.a(this, ERROR_TYPE.UNDEFINED, ACTION_TYPE.BROWSE_PLAN, getString(R.string.error), getString(R.string.browse_plan_no_data_error), false, this.m, this.n, String.valueOf(this.D), false);
    }

    public final void a(CJRBrowsePlanDescription cJRBrowsePlanDescription, String str) {
        f.a(cJRBrowsePlanDescription, str).show(getSupportFragmentManager(), f.f61166a);
    }

    public final void a(CJRMadeForYouPlanData cJRMadeForYouPlanData, String str) {
        f.a(cJRMadeForYouPlanData, str).show(getSupportFragmentManager(), f.f61166a);
    }
}
