package net.one97.paytm.passbook.spendanalytics.activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.customview.CustomToolTip;
import net.one97.paytm.passbook.spendanalytics.a.a;
import net.one97.paytm.passbook.spendanalytics.model.Response;
import net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsResponse;
import net.one97.paytm.passbook.spendanalytics.piechart.CircularGraphView;

public final class SpendAnalyticsMainActivity extends BaseActivity implements a.C1129a {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.passbook.spendanalytics.e.a f58522a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.passbook.spendanalytics.c.a f58523b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f58524c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Response> f58525d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Response> f58526e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f58527f;

    public final View a(int i2) {
        if (this.f58527f == null) {
            this.f58527f = new HashMap();
        }
        View view = (View) this.f58527f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f58527f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a<T> implements z<SpendAnalyticsResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58528a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f58529b;

        a(SpendAnalyticsMainActivity spendAnalyticsMainActivity, x.e eVar) {
            this.f58528a = spendAnalyticsMainActivity;
            this.f58529b = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool;
            String selectedMonth;
            SpendAnalyticsResponse spendAnalyticsResponse = (SpendAnalyticsResponse) obj;
            List<Response> list = null;
            if (kotlin.m.p.a("SUCCESS", spendAnalyticsResponse != null ? spendAnalyticsResponse.getStatusCode() : null, true)) {
                if (spendAnalyticsResponse == null || (selectedMonth = spendAnalyticsResponse.getSelectedMonth()) == null) {
                    bool = null;
                } else {
                    ArrayList c2 = this.f58528a.f58524c;
                    if (c2 == null) {
                        kotlin.g.b.k.a();
                    }
                    ViewPager viewPager = (ViewPager) this.f58528a.a(R.id.viewPagerSpendAnalytics);
                    kotlin.g.b.k.a((Object) viewPager, "viewPagerSpendAnalytics");
                    bool = Boolean.valueOf(selectedMonth.equals(c2.get(viewPager.getCurrentItem())));
                }
                if (bool == null) {
                    kotlin.g.b.k.a();
                }
                if (bool.booleanValue()) {
                    ArrayList<Response> spendAnalyticsResponse2 = spendAnalyticsResponse != null ? spendAnalyticsResponse.getSpendAnalyticsResponse() : null;
                    Integer valueOf = spendAnalyticsResponse2 != null ? Integer.valueOf(spendAnalyticsResponse2.size()) : null;
                    if (valueOf == null) {
                        kotlin.g.b.k.a();
                    }
                    if (valueOf.intValue() > 2) {
                        if (spendAnalyticsResponse2 != null) {
                            list = spendAnalyticsResponse2.subList(3, spendAnalyticsResponse2.size());
                        }
                        list.clear();
                    }
                    SpendAnalyticsMainActivity spendAnalyticsMainActivity = this.f58528a;
                    if (spendAnalyticsResponse2 == null) {
                        kotlin.g.b.k.a();
                    }
                    spendAnalyticsMainActivity.b(spendAnalyticsResponse2);
                    SpendAnalyticsMainActivity.e(this.f58528a);
                    net.one97.paytm.passbook.spendanalytics.c.a.a(false, (ArrayList<View>) (ArrayList) this.f58529b.element, (ShimmerFrameLayout) this.f58528a.a(R.id.shimmerFavStores));
                    return;
                }
                return;
            }
            SpendAnalyticsMainActivity spendAnalyticsMainActivity2 = this.f58528a;
            Toast.makeText(spendAnalyticsMainActivity2, spendAnalyticsMainActivity2.getString(R.string.some_went_wrong), 0).show();
        }
    }

    static final class b<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58530a;

        b(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
            this.f58530a = spendAnalyticsMainActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            SpendAnalyticsMainActivity.a(this.f58530a, (NetworkCustomError) obj);
        }
    }

    static final class c<T> implements z<SpendAnalyticsResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58531a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f58532b;

        c(SpendAnalyticsMainActivity spendAnalyticsMainActivity, x.e eVar) {
            this.f58531a = spendAnalyticsMainActivity;
            this.f58532b = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool;
            String selectedMonth;
            SpendAnalyticsResponse spendAnalyticsResponse = (SpendAnalyticsResponse) obj;
            ArrayList<Response> arrayList = null;
            if (kotlin.m.p.a("SUCCESS", spendAnalyticsResponse != null ? spendAnalyticsResponse.getStatusCode() : null, true)) {
                if (spendAnalyticsResponse == null || (selectedMonth = spendAnalyticsResponse.getSelectedMonth()) == null) {
                    bool = null;
                } else {
                    ArrayList c2 = this.f58531a.f58524c;
                    if (c2 == null) {
                        kotlin.g.b.k.a();
                    }
                    ViewPager viewPager = (ViewPager) this.f58531a.a(R.id.viewPagerSpendAnalytics);
                    kotlin.g.b.k.a((Object) viewPager, "viewPagerSpendAnalytics");
                    bool = Boolean.valueOf(selectedMonth.equals(c2.get(viewPager.getCurrentItem())));
                }
                if (bool == null) {
                    kotlin.g.b.k.a();
                }
                if (bool.booleanValue()) {
                    if (spendAnalyticsResponse != null) {
                        arrayList = spendAnalyticsResponse.getSpendAnalyticsResponse();
                    }
                    ArrayList<Response> arrayList2 = arrayList;
                    if (arrayList2 != null) {
                        this.f58531a.f58526e = new ArrayList();
                        SpendAnalyticsMainActivity.d(this.f58531a).addAll(arrayList2);
                        net.one97.paytm.passbook.spendanalytics.c.a e2 = SpendAnalyticsMainActivity.e(this.f58531a);
                        CircularGraphView circularGraphView = (CircularGraphView) this.f58531a.a(R.id.moneyReceivedChart);
                        kotlin.g.b.k.a((Object) circularGraphView, "moneyReceivedChart");
                        RecyclerView recyclerView = (RecyclerView) this.f58531a.a(R.id.rvMoneyReceived);
                        kotlin.g.b.k.a((Object) recyclerView, "rvMoneyReceived");
                        SpendAnalyticsMainActivity spendAnalyticsMainActivity = this.f58531a;
                        RoboTextView roboTextView = (RoboTextView) spendAnalyticsMainActivity.a(R.id.tvAmtReceived);
                        kotlin.g.b.k.a((Object) roboTextView, "tvAmtReceived");
                        e2.a(arrayList2, circularGraphView, recyclerView, spendAnalyticsMainActivity, "money_received_chart", roboTextView);
                    }
                    SpendAnalyticsMainActivity.e(this.f58531a);
                    net.one97.paytm.passbook.spendanalytics.c.a.a(false, (ArrayList<View>) (ArrayList) this.f58532b.element, (ShimmerFrameLayout) this.f58531a.a(R.id.shimmerMoneyReceived));
                    return;
                }
                return;
            }
            SpendAnalyticsMainActivity spendAnalyticsMainActivity2 = this.f58531a;
            Toast.makeText(spendAnalyticsMainActivity2, spendAnalyticsMainActivity2.getString(R.string.some_went_wrong), 0).show();
        }
    }

    static final class d<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58533a;

        d(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
            this.f58533a = spendAnalyticsMainActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            SpendAnalyticsMainActivity.a(this.f58533a, (NetworkCustomError) obj);
        }
    }

    static final class e<T> implements z<SpendAnalyticsResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58534a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f58535b;

        e(SpendAnalyticsMainActivity spendAnalyticsMainActivity, x.e eVar) {
            this.f58534a = spendAnalyticsMainActivity;
            this.f58535b = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool;
            String selectedMonth;
            SpendAnalyticsResponse spendAnalyticsResponse = (SpendAnalyticsResponse) obj;
            ArrayList<Response> arrayList = null;
            if (kotlin.m.p.a("SUCCESS", spendAnalyticsResponse != null ? spendAnalyticsResponse.getStatusCode() : null, true)) {
                if (spendAnalyticsResponse == null || (selectedMonth = spendAnalyticsResponse.getSelectedMonth()) == null) {
                    bool = null;
                } else {
                    ArrayList c2 = this.f58534a.f58524c;
                    if (c2 == null) {
                        kotlin.g.b.k.a();
                    }
                    ViewPager viewPager = (ViewPager) this.f58534a.a(R.id.viewPagerSpendAnalytics);
                    kotlin.g.b.k.a((Object) viewPager, "viewPagerSpendAnalytics");
                    bool = Boolean.valueOf(selectedMonth.equals(c2.get(viewPager.getCurrentItem())));
                }
                if (bool == null) {
                    kotlin.g.b.k.a();
                }
                if (bool.booleanValue()) {
                    if (spendAnalyticsResponse != null) {
                        arrayList = spendAnalyticsResponse.getSpendAnalyticsResponse();
                    }
                    this.f58534a.f58525d = new ArrayList();
                    ArrayList f2 = SpendAnalyticsMainActivity.f(this.f58534a);
                    if (arrayList == null) {
                        kotlin.g.b.k.a();
                    }
                    f2.addAll(arrayList);
                    SpendAnalyticsMainActivity.e(this.f58534a);
                    net.one97.paytm.passbook.spendanalytics.c.a.a((ArrayList<Response>) SpendAnalyticsMainActivity.f(this.f58534a), (Context) this.f58534a);
                    this.f58534a.a(arrayList);
                    RoboTextView roboTextView = (RoboTextView) this.f58534a.a(R.id.tvSpendsByCategory);
                    kotlin.g.b.k.a((Object) roboTextView, "tvSpendsByCategory");
                    roboTextView.setVisibility(0);
                    RecyclerView recyclerView = (RecyclerView) this.f58534a.a(R.id.rvSpendsByCategory);
                    kotlin.g.b.k.a((Object) recyclerView, "rvSpendsByCategory");
                    recyclerView.setVisibility(0);
                    net.one97.paytm.passbook.spendanalytics.c.a e2 = SpendAnalyticsMainActivity.e(this.f58534a);
                    ArrayList f3 = SpendAnalyticsMainActivity.f(this.f58534a);
                    CircularGraphView circularGraphView = (CircularGraphView) this.f58534a.a(R.id.moneySpentChart);
                    kotlin.g.b.k.a((Object) circularGraphView, "moneySpentChart");
                    RecyclerView recyclerView2 = (RecyclerView) this.f58534a.a(R.id.rvMoneySpent);
                    kotlin.g.b.k.a((Object) recyclerView2, "rvMoneySpent");
                    SpendAnalyticsMainActivity spendAnalyticsMainActivity = this.f58534a;
                    RoboTextView roboTextView2 = (RoboTextView) spendAnalyticsMainActivity.a(R.id.tvAmtSpent);
                    kotlin.g.b.k.a((Object) roboTextView2, "tvAmtSpent");
                    e2.a(f3, circularGraphView, recyclerView2, spendAnalyticsMainActivity, "money_spent_chart", roboTextView2);
                    SpendAnalyticsMainActivity.e(this.f58534a);
                    net.one97.paytm.passbook.spendanalytics.c.a.a(false, (ArrayList<View>) (ArrayList) this.f58535b.element, (ShimmerFrameLayout) this.f58534a.a(R.id.shimmerMoneySpent));
                    return;
                }
                return;
            }
            SpendAnalyticsMainActivity spendAnalyticsMainActivity2 = this.f58534a;
            Toast.makeText(spendAnalyticsMainActivity2, spendAnalyticsMainActivity2.getString(R.string.some_went_wrong), 0).show();
        }
    }

    static final class f<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58536a;

        f(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
            this.f58536a = spendAnalyticsMainActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            SpendAnalyticsMainActivity.a(this.f58536a, (NetworkCustomError) obj);
        }
    }

    public static final /* synthetic */ ArrayList d(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
        ArrayList<Response> arrayList = spendAnalyticsMainActivity.f58526e;
        if (arrayList == null) {
            kotlin.g.b.k.a("moneyReceivedList");
        }
        return arrayList;
    }

    public static final /* synthetic */ net.one97.paytm.passbook.spendanalytics.c.a e(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
        net.one97.paytm.passbook.spendanalytics.c.a aVar = spendAnalyticsMainActivity.f58523b;
        if (aVar == null) {
            kotlin.g.b.k.a("spendAnalyticsMainActivityPresenter");
        }
        return aVar;
    }

    public static final /* synthetic */ ArrayList f(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
        ArrayList<Response> arrayList = spendAnalyticsMainActivity.f58525d;
        if (arrayList == null) {
            kotlin.g.b.k.a("moneySpentList");
        }
        return arrayList;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_activity_spend_analytics_main);
        Context context = this;
        this.f58523b = new net.one97.paytm.passbook.spendanalytics.c.a(context);
        ai a2 = am.a((FragmentActivity) this).a(net.one97.paytm.passbook.spendanalytics.e.a.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…icsViewModel::class.java)");
        this.f58522a = (net.one97.paytm.passbook.spendanalytics.e.a) a2;
        ((ImageView) a(R.id.saIvBack)).setOnClickListener(new i(this));
        if (this.f58523b == null) {
            kotlin.g.b.k.a("spendAnalyticsMainActivityPresenter");
        }
        ArrayList arrayList = new ArrayList();
        int i2 = Calendar.getInstance().get(2);
        int i3 = Calendar.getInstance().get(1);
        int i4 = i2;
        for (int i5 = 0; i5 != 6; i5++) {
            if (i4 == 4) {
                String valueOf = String.valueOf(i3);
                if (valueOf != null) {
                    if (valueOf.contentEquals(r7)) {
                        break;
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            String[] months = new DateFormatSymbols().getMonths();
            kotlin.g.b.k.a((Object) months, "dfs.months");
            String str = (String) kotlin.a.k.d((String[]) Arrays.copyOf(months, months.length)).get(i4);
            if (str != null) {
                arrayList.add(str + ',' + i3);
            }
            i4--;
            if (i4 == -1) {
                i4 = 11;
                i3 = Calendar.getInstance().get(1) - 1;
            }
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int size = arrayList.size(); size > 0; size--) {
            arrayList2.add(arrayList.get(size - 1));
        }
        this.f58524c = arrayList2;
        ViewPager viewPager = (ViewPager) a(R.id.viewPagerSpendAnalytics);
        kotlin.g.b.k.a((Object) viewPager, "viewPagerSpendAnalytics");
        androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
        kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
        viewPager.setAdapter(new net.one97.paytm.passbook.spendanalytics.a.c(supportFragmentManager, this.f58524c));
        ViewPager viewPager2 = (ViewPager) a(R.id.viewPagerSpendAnalytics);
        kotlin.g.b.k.a((Object) viewPager2, "viewPagerSpendAnalytics");
        ArrayList<String> arrayList3 = this.f58524c;
        Integer valueOf2 = arrayList3 != null ? Integer.valueOf(arrayList3.size()) : null;
        if (valueOf2 == null) {
            kotlin.g.b.k.a();
        }
        viewPager2.setCurrentItem(valueOf2.intValue() - 1);
        ((ViewPager) a(R.id.viewPagerSpendAnalytics)).addOnPageChangeListener(new g(this));
        ((ImageView) a(R.id.ivLeftArrow)).setOnClickListener(new j(this));
        ((ImageView) a(R.id.ivRightArrow)).setOnClickListener(new k(this));
        ((ViewPager) a(R.id.viewPagerSpendAnalytics)).addOnPageChangeListener(new l(this));
        ((ViewPager) a(R.id.viewPagerSpendAnalytics)).setPageTransformer(false, new net.one97.paytm.passbook.spendanalytics.b());
        RecyclerView recyclerView = (RecyclerView) a(R.id.rvMoneySpent);
        kotlin.g.b.k.a((Object) recyclerView, "rvMoneySpent");
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rvMoneySpent);
        kotlin.g.b.k.a((Object) recyclerView2, "rvMoneySpent");
        recyclerView2.setNestedScrollingEnabled(false);
        RecyclerView recyclerView3 = (RecyclerView) a(R.id.rvMoneyReceived);
        kotlin.g.b.k.a((Object) recyclerView3, "rvMoneyReceived");
        recyclerView3.setLayoutManager(new LinearLayoutManager(context));
        RecyclerView recyclerView4 = (RecyclerView) a(R.id.rvMoneyReceived);
        kotlin.g.b.k.a((Object) recyclerView4, "rvMoneyReceived");
        recyclerView4.setNestedScrollingEnabled(false);
        RecyclerView recyclerView5 = (RecyclerView) a(R.id.rvSpendsByCategory);
        kotlin.g.b.k.a((Object) recyclerView5, "rvSpendsByCategory");
        recyclerView5.setLayoutManager(new LinearLayoutManager(context));
        RecyclerView recyclerView6 = (RecyclerView) a(R.id.rvSpendsByCategory);
        kotlin.g.b.k.a((Object) recyclerView6, "rvSpendsByCategory");
        recyclerView6.setNestedScrollingEnabled(false);
        e();
        net.one97.paytm.passbook.spendanalytics.e.a aVar = this.f58522a;
        if (aVar == null) {
            kotlin.g.b.k.a("spendAnalyticsViewModel");
        }
        aVar.f58572a.observe(this, new m(this));
        ((CircularGraphView) a(R.id.moneySpentChart)).setOnItemClickListener(new n(this));
        ((CircularGraphView) a(R.id.moneyReceivedChart)).setOnItemClickListener(new o(this));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new net.one97.paytm.passbook.spendanalytics.piechart.a(Integer.valueOf(Color.parseColor("#dde5ed")), Float.valueOf(1.0f), (String) null, (byte) 0));
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) a(R.id.shimmerMoneySpent);
        kotlin.g.b.k.a((Object) shimmerFrameLayout, "shimmerMoneySpent");
        ((CircularGraphView) shimmerFrameLayout.findViewById(R.id.vChartShimmer)).setData(arrayList4);
        ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) a(R.id.shimmerMoneyReceived);
        kotlin.g.b.k.a((Object) shimmerFrameLayout2, "shimmerMoneyReceived");
        ((CircularGraphView) shimmerFrameLayout2.findViewById(R.id.vChartShimmer)).setData(arrayList4);
        ((NestedScrollView) a(R.id.nsvContent)).setOnScrollChangeListener(new p(this));
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58539a;

        i(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
            this.f58539a = spendAnalyticsMainActivity;
        }

        public final void onClick(View view) {
            this.f58539a.onBackPressed();
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58540a;

        j(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
            this.f58540a = spendAnalyticsMainActivity;
        }

        public final void onClick(View view) {
            ViewPager viewPager = (ViewPager) this.f58540a.a(R.id.viewPagerSpendAnalytics);
            kotlin.g.b.k.a((Object) viewPager, "viewPagerSpendAnalytics");
            ViewPager viewPager2 = (ViewPager) this.f58540a.a(R.id.viewPagerSpendAnalytics);
            kotlin.g.b.k.a((Object) viewPager2, "viewPagerSpendAnalytics");
            viewPager.setCurrentItem(viewPager2.getCurrentItem() - 1);
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58541a;

        k(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
            this.f58541a = spendAnalyticsMainActivity;
        }

        public final void onClick(View view) {
            ViewPager viewPager = (ViewPager) this.f58541a.a(R.id.viewPagerSpendAnalytics);
            kotlin.g.b.k.a((Object) viewPager, "viewPagerSpendAnalytics");
            ViewPager viewPager2 = (ViewPager) this.f58541a.a(R.id.viewPagerSpendAnalytics);
            kotlin.g.b.k.a((Object) viewPager2, "viewPagerSpendAnalytics");
            viewPager.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    }

    public static final class l implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58542a;

        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        l(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
            this.f58542a = spendAnalyticsMainActivity;
        }

        public final void onPageSelected(int i2) {
            ConstraintLayout constraintLayout = (ConstraintLayout) this.f58542a.a(R.id.clSaAlert);
            kotlin.g.b.k.a((Object) constraintLayout, "clSaAlert");
            constraintLayout.setVisibility(8);
            CustomToolTip customToolTip = (CustomToolTip) this.f58542a.a(R.id.customToolTipLayout);
            kotlin.g.b.k.a((Object) customToolTip, "customToolTipLayout");
            customToolTip.setVisibility(8);
            this.f58542a.e();
        }
    }

    static final class n implements CircularGraphView.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58544a;

        n(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
            this.f58544a = spendAnalyticsMainActivity;
        }

        public final void a(int i2) {
            SpendAnalyticsMainActivity.a(this.f58544a, i2, "money_spent_chart");
        }
    }

    static final class o implements CircularGraphView.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58545a;

        o(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
            this.f58545a = spendAnalyticsMainActivity;
        }

        public final void a(int i2) {
            SpendAnalyticsMainActivity.a(this.f58545a, i2, "money_received_chart");
        }
    }

    static final class p implements NestedScrollView.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58546a;

        p(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
            this.f58546a = spendAnalyticsMainActivity;
        }

        public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            CustomToolTip customToolTip = (CustomToolTip) this.f58546a.a(R.id.customToolTipLayout);
            kotlin.g.b.k.a((Object) customToolTip, "customToolTipLayout");
            customToolTip.setVisibility(8);
            ((CircularGraphView) this.f58546a.a(R.id.moneySpentChart)).b();
            ((CircularGraphView) this.f58546a.a(R.id.moneyReceivedChart)).b();
        }
    }

    private final void a() {
        net.one97.paytm.passbook.spendanalytics.e.a aVar = this.f58522a;
        if (aVar == null) {
            kotlin.g.b.k.a("spendAnalyticsViewModel");
        }
        aVar.a();
    }

    public static final class g implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58537a;

        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageSelected(int i2) {
        }

        g(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
            this.f58537a = spendAnalyticsMainActivity;
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
            ImageView imageView = (ImageView) this.f58537a.a(R.id.ivLeftArrow);
            kotlin.g.b.k.a((Object) imageView, "ivLeftArrow");
            imageView.setVisibility(0);
            ImageView imageView2 = (ImageView) this.f58537a.a(R.id.ivRightArrow);
            kotlin.g.b.k.a((Object) imageView2, "ivRightArrow");
            imageView2.setVisibility(0);
            if (i2 == 0) {
                ImageView imageView3 = (ImageView) this.f58537a.a(R.id.ivLeftArrow);
                kotlin.g.b.k.a((Object) imageView3, "ivLeftArrow");
                imageView3.setVisibility(4);
                return;
            }
            ArrayList c2 = this.f58537a.f58524c;
            Integer valueOf = c2 != null ? Integer.valueOf(c2.size()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            if (i2 == valueOf.intValue() - 1) {
                ImageView imageView4 = (ImageView) this.f58537a.a(R.id.ivRightArrow);
                kotlin.g.b.k.a((Object) imageView4, "ivRightArrow");
                imageView4.setVisibility(4);
            }
        }
    }

    private final void b() {
        x.e eVar = new x.e();
        CircularGraphView circularGraphView = (CircularGraphView) a(R.id.moneyReceivedChart);
        kotlin.g.b.k.a((Object) circularGraphView, "moneyReceivedChart");
        RoboTextView roboTextView = (RoboTextView) a(R.id.tvMoneyReceived);
        kotlin.g.b.k.a((Object) roboTextView, "tvMoneyReceived");
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tvAmtReceived);
        kotlin.g.b.k.a((Object) roboTextView2, "tvAmtReceived");
        RecyclerView recyclerView = (RecyclerView) a(R.id.rvMoneyReceived);
        kotlin.g.b.k.a((Object) recyclerView, "rvMoneyReceived");
        eVar.element = kotlin.a.k.d(circularGraphView, roboTextView, roboTextView2, recyclerView);
        if (this.f58523b == null) {
            kotlin.g.b.k.a("spendAnalyticsMainActivityPresenter");
        }
        net.one97.paytm.passbook.spendanalytics.c.a.a(true, (ArrayList<View>) (ArrayList) eVar.element, (ShimmerFrameLayout) a(R.id.shimmerMoneyReceived));
        net.one97.paytm.passbook.spendanalytics.e.a aVar = this.f58522a;
        if (aVar == null) {
            kotlin.g.b.k.a("spendAnalyticsViewModel");
        }
        Context context = this;
        ArrayList<String> arrayList = this.f58524c;
        if (arrayList == null) {
            kotlin.g.b.k.a();
        }
        ViewPager viewPager = (ViewPager) a(R.id.viewPagerSpendAnalytics);
        kotlin.g.b.k.a((Object) viewPager, "viewPagerSpendAnalytics");
        String str = arrayList.get(viewPager.getCurrentItem());
        kotlin.g.b.k.a((Object) str, "displayMonthsList!![view…endAnalytics.currentItem]");
        kotlin.o<y<SpendAnalyticsResponse>, y<NetworkCustomError>> a2 = aVar.a(context, "money_received_request", str);
        androidx.lifecycle.q qVar = this;
        a2.getFirst().observe(qVar, new c(this, eVar));
        a2.getSecond().observe(qVar, new d(this));
    }

    private final void c() {
        x.e eVar = new x.e();
        View a2 = a(R.id.layoutFavStores);
        kotlin.g.b.k.a((Object) a2, "layoutFavStores");
        eVar.element = kotlin.a.k.d(a2);
        if (this.f58523b == null) {
            kotlin.g.b.k.a("spendAnalyticsMainActivityPresenter");
        }
        net.one97.paytm.passbook.spendanalytics.c.a.a(true, (ArrayList<View>) (ArrayList) eVar.element, (ShimmerFrameLayout) a(R.id.shimmerFavStores));
        b((ArrayList<Response>) new ArrayList());
        net.one97.paytm.passbook.spendanalytics.e.a aVar = this.f58522a;
        if (aVar == null) {
            kotlin.g.b.k.a("spendAnalyticsViewModel");
        }
        Context context = this;
        ArrayList<String> arrayList = this.f58524c;
        if (arrayList == null) {
            kotlin.g.b.k.a();
        }
        ViewPager viewPager = (ViewPager) a(R.id.viewPagerSpendAnalytics);
        kotlin.g.b.k.a((Object) viewPager, "viewPagerSpendAnalytics");
        String str = arrayList.get(viewPager.getCurrentItem());
        kotlin.g.b.k.a((Object) str, "displayMonthsList!![view…endAnalytics.currentItem]");
        kotlin.o<y<SpendAnalyticsResponse>, y<NetworkCustomError>> a3 = aVar.a(context, "fav_stores_request", str);
        androidx.lifecycle.q qVar = this;
        a3.getFirst().observe(qVar, new a(this, eVar));
        a3.getSecond().observe(qVar, new b(this));
    }

    private final void d() {
        x.e eVar = new x.e();
        CircularGraphView circularGraphView = (CircularGraphView) a(R.id.moneySpentChart);
        kotlin.g.b.k.a((Object) circularGraphView, "moneySpentChart");
        RoboTextView roboTextView = (RoboTextView) a(R.id.tvMoneySpent);
        kotlin.g.b.k.a((Object) roboTextView, "tvMoneySpent");
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tvAmtSpent);
        kotlin.g.b.k.a((Object) roboTextView2, "tvAmtSpent");
        RecyclerView recyclerView = (RecyclerView) a(R.id.rvMoneySpent);
        kotlin.g.b.k.a((Object) recyclerView, "rvMoneySpent");
        eVar.element = kotlin.a.k.d(circularGraphView, roboTextView, roboTextView2, recyclerView);
        RoboTextView roboTextView3 = (RoboTextView) a(R.id.tvSpendsByCategory);
        kotlin.g.b.k.a((Object) roboTextView3, "tvSpendsByCategory");
        roboTextView3.setVisibility(8);
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rvSpendsByCategory);
        kotlin.g.b.k.a((Object) recyclerView2, "rvSpendsByCategory");
        recyclerView2.setVisibility(8);
        if (this.f58523b == null) {
            kotlin.g.b.k.a("spendAnalyticsMainActivityPresenter");
        }
        net.one97.paytm.passbook.spendanalytics.c.a.a(true, (ArrayList<View>) (ArrayList) eVar.element, (ShimmerFrameLayout) a(R.id.shimmerMoneySpent));
        a((ArrayList<Response>) new ArrayList());
        net.one97.paytm.passbook.spendanalytics.e.a aVar = this.f58522a;
        if (aVar == null) {
            kotlin.g.b.k.a("spendAnalyticsViewModel");
        }
        Context context = this;
        ArrayList<String> arrayList = this.f58524c;
        if (arrayList == null) {
            kotlin.g.b.k.a();
        }
        ViewPager viewPager = (ViewPager) a(R.id.viewPagerSpendAnalytics);
        kotlin.g.b.k.a((Object) viewPager, "viewPagerSpendAnalytics");
        String str = arrayList.get(viewPager.getCurrentItem());
        kotlin.g.b.k.a((Object) str, "displayMonthsList!![view…endAnalytics.currentItem]");
        kotlin.o<y<SpendAnalyticsResponse>, y<NetworkCustomError>> a2 = aVar.a(context, "spends_by_category_request", str);
        androidx.lifecycle.q qVar = this;
        a2.getFirst().observe(qVar, new e(this, eVar));
        a2.getSecond().observe(qVar, new f(this));
    }

    /* access modifiers changed from: private */
    public final void a(ArrayList<Response> arrayList) {
        Context context = this;
        if (this.f58523b == null) {
            kotlin.g.b.k.a("spendAnalyticsMainActivityPresenter");
        }
        ArrayList<Response> a2 = net.one97.paytm.passbook.spendanalytics.c.a.a(arrayList);
        ArrayList<String> arrayList2 = this.f58524c;
        if (arrayList2 == null) {
            kotlin.g.b.k.a();
        }
        ViewPager viewPager = (ViewPager) a(R.id.viewPagerSpendAnalytics);
        kotlin.g.b.k.a((Object) viewPager, "viewPagerSpendAnalytics");
        String str = arrayList2.get(viewPager.getCurrentItem());
        kotlin.g.b.k.a((Object) str, "displayMonthsList!![view…endAnalytics.currentItem]");
        net.one97.paytm.passbook.spendanalytics.a.b bVar = new net.one97.paytm.passbook.spendanalytics.a.b(context, a2, str);
        RecyclerView recyclerView = (RecyclerView) a(R.id.rvSpendsByCategory);
        kotlin.g.b.k.a((Object) recyclerView, "rvSpendsByCategory");
        recyclerView.setAdapter(bVar);
        bVar.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public final void b(ArrayList<Response> arrayList) {
        net.one97.paytm.passbook.spendanalytics.c.a aVar = this.f58523b;
        if (aVar == null) {
            kotlin.g.b.k.a("spendAnalyticsMainActivityPresenter");
        }
        ArrayList<String> arrayList2 = this.f58524c;
        if (arrayList2 == null) {
            kotlin.g.b.k.a();
        }
        ViewPager viewPager = (ViewPager) a(R.id.viewPagerSpendAnalytics);
        kotlin.g.b.k.a((Object) viewPager, "viewPagerSpendAnalytics");
        String str = arrayList2.get(viewPager.getCurrentItem());
        kotlin.g.b.k.a((Object) str, "displayMonthsList!![view…endAnalytics.currentItem]");
        aVar.a(this, arrayList, str);
    }

    public final void onBackPressed() {
        super.onBackPressed();
        net.one97.paytm.passbook.spendanalytics.e.a aVar = this.f58522a;
        if (aVar == null) {
            kotlin.g.b.k.a("spendAnalyticsViewModel");
        }
        aVar.a();
    }

    public final void a(int i2, String str) {
        kotlin.g.b.k.c(str, "chartType");
        if (str.contentEquals("money_spent_chart")) {
            ((CircularGraphView) a(R.id.moneySpentChart)).b(i2);
        } else if (str.contentEquals("money_received_chart")) {
            ((CircularGraphView) a(R.id.moneyReceivedChart)).b(i2);
        }
    }

    static final class q implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58547a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f58548b;

        q(SpendAnalyticsMainActivity spendAnalyticsMainActivity, String str) {
            this.f58547a = spendAnalyticsMainActivity;
            this.f58548b = str;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (view != null) {
                view.setVisibility(8);
            }
            String str = this.f58548b;
            if (str == null) {
                throw new u("null cannot be cast to non-null type java.lang.String");
            } else if (str.contentEquals(r3)) {
                ((CircularGraphView) this.f58547a.a(R.id.moneySpentChart)).b();
                return false;
            } else {
                String str2 = this.f58548b;
                if (str2 == null) {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                } else if (!str2.contentEquals(r3)) {
                    return false;
                } else {
                    ((CircularGraphView) this.f58547a.a(R.id.moneyReceivedChart)).b();
                    return false;
                }
            }
        }
    }

    static final class r implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58549a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f58550b;

        r(SpendAnalyticsMainActivity spendAnalyticsMainActivity, String str) {
            this.f58549a = spendAnalyticsMainActivity;
            this.f58550b = str;
        }

        public final void onClick(View view) {
            String str = this.f58550b;
            if (str == null) {
                throw new u("null cannot be cast to non-null type java.lang.String");
            } else if (str.contentEquals(r0)) {
                CustomToolTip customToolTip = (CustomToolTip) this.f58549a.a(R.id.customToolTipLayout);
                kotlin.g.b.k.a((Object) customToolTip, "customToolTipLayout");
                customToolTip.setVisibility(8);
                ((CircularGraphView) this.f58549a.a(R.id.moneyReceivedChart)).b();
            }
        }
    }

    static final class s implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58551a;

        s(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
            this.f58551a = spendAnalyticsMainActivity;
        }

        public final void onClick(View view) {
            CustomToolTip customToolTip = (CustomToolTip) this.f58551a.a(R.id.customToolTipLayout);
            kotlin.g.b.k.a((Object) customToolTip, "customToolTipLayout");
            customToolTip.setVisibility(8);
            ((CircularGraphView) this.f58551a.a(R.id.moneyReceivedChart)).b();
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        a();
        b();
        c();
        d();
    }

    /* access modifiers changed from: private */
    public final void f() {
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.clSaAlert);
        kotlin.g.b.k.a((Object) constraintLayout, "clSaAlert");
        constraintLayout.setVisibility(0);
        RoboTextView roboTextView = (RoboTextView) a(R.id.errorTitle);
        kotlin.g.b.k.a((Object) roboTextView, "errorTitle");
        roboTextView.setText(getString(R.string.no_connection));
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.errorMessage);
        kotlin.g.b.k.a((Object) roboTextView2, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        roboTextView2.setText(getString(R.string.no_internet));
        ((TextView) a(R.id.tvRetry)).setOnClickListener(new h(this));
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58538a;

        h(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
            this.f58538a = spendAnalyticsMainActivity;
        }

        public final void onClick(View view) {
            ConstraintLayout constraintLayout = (ConstraintLayout) this.f58538a.a(R.id.clSaAlert);
            kotlin.g.b.k.a((Object) constraintLayout, "clSaAlert");
            constraintLayout.setVisibility(8);
            this.f58538a.e();
        }
    }

    static final class m<T> implements z<net.one97.paytm.passbook.mapping.a.e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpendAnalyticsMainActivity f58543a;

        m(SpendAnalyticsMainActivity spendAnalyticsMainActivity) {
            this.f58543a = spendAnalyticsMainActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f58543a.f();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r5.size() == 0) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        ((net.one97.paytm.passbook.spendanalytics.piechart.CircularGraphView) r9.a(net.one97.paytm.passbook.R.id.moneySpentChart)).b();
        ((net.one97.paytm.passbook.spendanalytics.piechart.CircularGraphView) r9.a(net.one97.paytm.passbook.R.id.moneyReceivedChart)).b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        if (r2.size() != 0) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity r9, int r10, java.lang.String r11) {
        /*
            int r0 = net.one97.paytm.passbook.R.id.nsvContent
            android.view.View r0 = r9.a((int) r0)
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            r1 = 0
            r0.scrollTo(r1, r1)
            r0 = 2
            int[] r3 = new int[r0]
            java.lang.String r0 = "money_spent_chart"
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = r11.contentEquals(r2)
            java.lang.String r4 = "moneySpentList"
            if (r2 == 0) goto L_0x0029
            java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r2 = r9.f58525d
            if (r2 != 0) goto L_0x0023
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0023:
            int r2 = r2.size()
            if (r2 == 0) goto L_0x0043
        L_0x0029:
            java.lang.String r2 = "money_received_chart"
            r5 = r2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = r11.contentEquals(r5)
            java.lang.String r6 = "moneyReceivedList"
            if (r5 == 0) goto L_0x005a
            java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r5 = r9.f58526e
            if (r5 != 0) goto L_0x003d
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x003d:
            int r5 = r5.size()
            if (r5 != 0) goto L_0x005a
        L_0x0043:
            int r10 = net.one97.paytm.passbook.R.id.moneySpentChart
            android.view.View r10 = r9.a((int) r10)
            net.one97.paytm.passbook.spendanalytics.piechart.CircularGraphView r10 = (net.one97.paytm.passbook.spendanalytics.piechart.CircularGraphView) r10
            r10.b()
            int r10 = net.one97.paytm.passbook.R.id.moneyReceivedChart
            android.view.View r9 = r9.a((int) r10)
            net.one97.paytm.passbook.spendanalytics.piechart.CircularGraphView r9 = (net.one97.paytm.passbook.spendanalytics.piechart.CircularGraphView) r9
            r9.b()
            return
        L_0x005a:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = r11.contentEquals(r0)
            java.lang.String r5 = "spendAnalyticsMainActivityPresenter"
            if (r0 == 0) goto L_0x009d
            int r0 = net.one97.paytm.passbook.R.id.moneySpentChart
            android.view.View r0 = r9.a((int) r0)
            net.one97.paytm.passbook.spendanalytics.piechart.CircularGraphView r0 = (net.one97.paytm.passbook.spendanalytics.piechart.CircularGraphView) r0
            r0.getLocationInWindow(r3)
            int r0 = net.one97.paytm.passbook.R.id.customToolTipLayout
            android.view.View r0 = r9.a((int) r0)
            r2 = r0
            net.one97.paytm.passbook.customview.CustomToolTip r2 = (net.one97.paytm.passbook.customview.CustomToolTip) r2
            java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r0 = r9.f58525d
            if (r0 != 0) goto L_0x0080
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0080:
            net.one97.paytm.passbook.spendanalytics.c.a r6 = r9.f58523b
            if (r6 != 0) goto L_0x0087
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0087:
            int r4 = net.one97.paytm.passbook.R.id.tvAmtSpent
            android.view.View r4 = r9.a((int) r4)
            r7 = r4
            com.paytm.utility.RoboTextView r7 = (com.paytm.utility.RoboTextView) r7
            java.lang.String r4 = "tvAmtSpent"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)
            r4 = r0
            r5 = r10
            r8 = r11
            r2.a(r3, r4, r5, r6, r7, r8)
            goto L_0x00db
        L_0x009d:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r0 = r11.contentEquals(r2)
            if (r0 == 0) goto L_0x00db
            int r0 = net.one97.paytm.passbook.R.id.moneyReceivedChart
            android.view.View r0 = r9.a((int) r0)
            net.one97.paytm.passbook.spendanalytics.piechart.CircularGraphView r0 = (net.one97.paytm.passbook.spendanalytics.piechart.CircularGraphView) r0
            r0.getLocationInWindow(r3)
            int r0 = net.one97.paytm.passbook.R.id.customToolTipLayout
            android.view.View r0 = r9.a((int) r0)
            r2 = r0
            net.one97.paytm.passbook.customview.CustomToolTip r2 = (net.one97.paytm.passbook.customview.CustomToolTip) r2
            java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r4 = r9.f58526e
            if (r4 != 0) goto L_0x00c0
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x00c0:
            net.one97.paytm.passbook.spendanalytics.c.a r6 = r9.f58523b
            if (r6 != 0) goto L_0x00c7
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00c7:
            int r0 = net.one97.paytm.passbook.R.id.tvAmtReceived
            android.view.View r0 = r9.a((int) r0)
            r7 = r0
            com.paytm.utility.RoboTextView r7 = (com.paytm.utility.RoboTextView) r7
            java.lang.String r0 = "tvAmtReceived"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            r5 = r10
            r8 = r11
            r2.a(r3, r4, r5, r6, r7, r8)
        L_0x00db:
            int r10 = net.one97.paytm.passbook.R.id.customToolTipLayout
            android.view.View r10 = r9.a((int) r10)
            net.one97.paytm.passbook.customview.CustomToolTip r10 = (net.one97.paytm.passbook.customview.CustomToolTip) r10
            java.lang.String r0 = "customToolTipLayout"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)
            r10.setVisibility(r1)
            int r10 = net.one97.paytm.passbook.R.id.customToolTipLayout
            android.view.View r10 = r9.a((int) r10)
            net.one97.paytm.passbook.customview.CustomToolTip r10 = (net.one97.paytm.passbook.customview.CustomToolTip) r10
            net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity$q r0 = new net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity$q
            r0.<init>(r9, r11)
            android.view.View$OnTouchListener r0 = (android.view.View.OnTouchListener) r0
            r10.setOnTouchListener(r0)
            int r10 = net.one97.paytm.passbook.R.id.clRootMoneySpent
            android.view.View r10 = r9.a((int) r10)
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity$r r0 = new net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity$r
            r0.<init>(r9, r11)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r10.setOnClickListener(r0)
            int r10 = net.one97.paytm.passbook.R.id.saTvSubheading
            android.view.View r10 = r9.a((int) r10)
            com.paytm.utility.RoboTextView r10 = (com.paytm.utility.RoboTextView) r10
            net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity$s r11 = new net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity$s
            r11.<init>(r9)
            android.view.View$OnClickListener r11 = (android.view.View.OnClickListener) r11
            r10.setOnClickListener(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity.a(net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity, int, java.lang.String):void");
    }

    public static final /* synthetic */ void a(SpendAnalyticsMainActivity spendAnalyticsMainActivity, NetworkCustomError networkCustomError) {
        Class<SpendAnalyticsMainActivity> cls = SpendAnalyticsMainActivity.class;
        Context context = spendAnalyticsMainActivity;
        if (!com.paytm.utility.b.c(context)) {
            spendAnalyticsMainActivity.f();
        } else if (net.one97.paytm.passbook.utility.j.a(context, networkCustomError)) {
        } else {
            if (((networkCustomError == null || networkCustomError.getStatusCode() != -1) && networkCustomError != null && networkCustomError.getStatusCode() == 410) || ((networkCustomError != null && networkCustomError.getStatusCode() == 401) || (networkCustomError != null && networkCustomError.getStatusCode() == 403))) {
                cls.getName();
                net.one97.paytm.passbook.utility.j.a(spendAnalyticsMainActivity, networkCustomError, true, false);
                return;
            }
            cls.getName();
            net.one97.paytm.passbook.utility.j.a((Activity) spendAnalyticsMainActivity, (Throwable) networkCustomError);
        }
    }
}
