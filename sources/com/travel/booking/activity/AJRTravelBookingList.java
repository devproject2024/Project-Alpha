package com.travel.booking.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.paytm.network.model.NetworkCustomError;
import com.travel.R;
import com.travel.booking.datamodel.CJRTravelBookingData;
import com.travel.booking.datamodel.NetworkErrorLiveDataModel;
import com.travel.cdn.ResourceUtils;
import com.travel.common.TravelBaseActivity;
import com.travel.utils.n;
import com.travel.utils.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;

public final class AJRTravelBookingList extends TravelBaseActivity {
    private HashMap _$_findViewCache;
    private com.travel.c.e dataBinding;
    private com.travel.booking.e.a viewModel;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class d<T> implements z<NetworkErrorLiveDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRTravelBookingList f21466a;

        d(AJRTravelBookingList aJRTravelBookingList) {
            this.f21466a = aJRTravelBookingList;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
            r1 = r5.getError();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r5) {
            /*
                r4 = this;
                com.travel.booking.datamodel.NetworkErrorLiveDataModel r5 = (com.travel.booking.datamodel.NetworkErrorLiveDataModel) r5
                if (r5 == 0) goto L_0x000c
                int r0 = r5.getErrorCode()
                r1 = 401(0x191, float:5.62E-43)
                if (r0 == r1) goto L_0x0020
            L_0x000c:
                if (r5 == 0) goto L_0x0016
                int r0 = r5.getErrorCode()
                r1 = 410(0x19a, float:5.75E-43)
                if (r0 == r1) goto L_0x0020
            L_0x0016:
                if (r5 == 0) goto L_0x002a
                int r0 = r5.getErrorCode()
                r1 = 403(0x193, float:5.65E-43)
                if (r0 != r1) goto L_0x002a
            L_0x0020:
                com.travel.booking.activity.AJRTravelBookingList r0 = r4.f21466a
                com.paytm.network.model.NetworkCustomError r5 = r5.getError()
                r0.showSessionTimeoutAlert(r5)
                return
            L_0x002a:
                r0 = 0
                if (r5 == 0) goto L_0x0035
                int r1 = r5.getErrorCode()
                r2 = 500(0x1f4, float:7.0E-43)
                if (r1 == r2) goto L_0x004c
            L_0x0035:
                if (r5 == 0) goto L_0x0042
                com.paytm.network.model.NetworkCustomError r1 = r5.getError()
                if (r1 == 0) goto L_0x0042
                java.lang.String r1 = r1.getMessage()
                goto L_0x0043
            L_0x0042:
                r1 = r0
            L_0x0043:
                r2 = 1
                java.lang.String r3 = "failure_error"
                boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)
                if (r1 == 0) goto L_0x006e
            L_0x004c:
                com.travel.booking.activity.AJRTravelBookingList r1 = r4.f21466a
                android.content.Context r1 = (android.content.Context) r1
                if (r5 == 0) goto L_0x005d
                com.paytm.network.model.NetworkCustomError r2 = r5.getError()
                if (r2 == 0) goto L_0x005d
                java.lang.String r2 = r2.getAlertTitle()
                goto L_0x005e
            L_0x005d:
                r2 = r0
            L_0x005e:
                if (r5 == 0) goto L_0x006a
                com.paytm.network.model.NetworkCustomError r5 = r5.getError()
                if (r5 == 0) goto L_0x006a
                java.lang.String r0 = r5.getAlertMessage()
            L_0x006a:
                com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r0)
                return
            L_0x006e:
                com.travel.booking.activity.AJRTravelBookingList r1 = r4.f21466a
                android.content.Context r1 = (android.content.Context) r1
                if (r5 == 0) goto L_0x007f
                com.paytm.network.model.NetworkCustomError r2 = r5.getError()
                if (r2 == 0) goto L_0x007f
                java.lang.String r2 = r2.getAlertTitle()
                goto L_0x0080
            L_0x007f:
                r2 = r0
            L_0x0080:
                if (r5 == 0) goto L_0x008c
                com.paytm.network.model.NetworkCustomError r5 = r5.getError()
                if (r5 == 0) goto L_0x008c
                java.lang.String r0 = r5.getAlertMessage()
            L_0x008c:
                com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.booking.activity.AJRTravelBookingList.d.onChanged(java.lang.Object):void");
        }
    }

    static final class e<T> implements z<List<? extends CJRTravelBookingData>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRTravelBookingList f21467a;

        e(AJRTravelBookingList aJRTravelBookingList) {
            this.f21467a = aJRTravelBookingList;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f21467a.initViewPagerFragments((List) obj);
        }
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        q.a(context);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding a2 = f.a(this, R.layout.activity_travel_bookings_list);
        k.a((Object) a2, "DataBindingUtil.setConte…ity_travel_bookings_list)");
        this.dataBinding = (com.travel.c.e) a2;
        com.travel.c.e eVar = this.dataBinding;
        if (eVar == null) {
            k.a("dataBinding");
        }
        ResourceUtils.loadTCoreImagesFromCDN(eVar.f22872a.f22827b, "paytm_travel_logo_booking.png", false, false, n.a.V1);
        initViewModel();
        wireEventHandlers();
    }

    private final void initViewModel() {
        ai a2 = am.a((FragmentActivity) this).a(com.travel.booking.e.a.class);
        k.a((Object) a2, "ViewModelProviders.of(th…istViewModel::class.java)");
        this.viewModel = (com.travel.booking.e.a) a2;
        com.travel.c.e eVar = this.dataBinding;
        if (eVar == null) {
            k.a("dataBinding");
        }
        eVar.setLifecycleOwner(this);
        com.travel.c.e eVar2 = this.dataBinding;
        if (eVar2 == null) {
            k.a("dataBinding");
        }
        com.travel.booking.e.a aVar = this.viewModel;
        if (aVar == null) {
            k.a("viewModel");
        }
        eVar2.a(aVar);
        com.travel.booking.e.a aVar2 = this.viewModel;
        if (aVar2 == null) {
            k.a("viewModel");
        }
        Context baseContext = getBaseContext();
        k.a((Object) baseContext, "baseContext");
        aVar2.a(baseContext, false);
    }

    private final void wireEventHandlers() {
        com.travel.booking.e.a aVar = this.viewModel;
        if (aVar == null) {
            k.a("viewModel");
        }
        y<x> yVar = aVar.f21489b;
        if (yVar != null) {
            androidx.lifecycle.q qVar = this;
            yVar.observe(qVar, new c(this));
            com.travel.booking.e.a aVar2 = this.viewModel;
            if (aVar2 == null) {
                k.a("viewModel");
            }
            aVar2.f21488a.observe(qVar, new d(this));
            com.travel.booking.e.a aVar3 = this.viewModel;
            if (aVar3 == null) {
                k.a("viewModel");
            }
            aVar3.b().observe(qVar, new e(this));
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Unit>");
    }

    static final class b extends l implements kotlin.g.a.b<CJRTravelBookingData, String> {
        public static final b INSTANCE = new b();

        b() {
            super(1);
        }

        public final String invoke(CJRTravelBookingData cJRTravelBookingData) {
            k.c(cJRTravelBookingData, "it");
            String headerText = cJRTravelBookingData.getHeaderText();
            if (headerText == null) {
                k.a();
            }
            return headerText;
        }
    }

    /* access modifiers changed from: private */
    public final void initViewPagerFragments(List<CJRTravelBookingData> list) {
        kotlin.g.a.b bVar = b.INSTANCE;
        k.c(bVar, "transformer");
        List arrayList = new ArrayList();
        if (list != null) {
            for (CJRTravelBookingData invoke : list) {
                arrayList.add(bVar.invoke(invoke));
            }
        }
        int size = list != null ? list.size() : 0;
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        com.travel.booking.a.a aVar = new com.travel.booking.a.a(size, arrayList, supportFragmentManager);
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(R.id.view_pager);
        k.a((Object) viewPager, "this.view_pager");
        viewPager.setAdapter(aVar);
        ((TabLayout) _$_findCachedViewById(R.id.tab_layout)).setupWithViewPager((ViewPager) _$_findCachedViewById(R.id.view_pager), true);
        Context context = this;
        ((TabLayout) _$_findCachedViewById(R.id.tab_layout)).setSelectedTabIndicatorColor(androidx.core.content.b.c(context, 17170445));
        TabLayout tabLayout = (TabLayout) _$_findCachedViewById(R.id.tab_layout);
        k.a((Object) tabLayout, "this.tab_layout");
        int tabCount = tabLayout.getTabCount();
        for (int i2 = 0; i2 < tabCount; i2++) {
            TabLayout.f a2 = ((TabLayout) _$_findCachedViewById(R.id.tab_layout)).a(i2);
            if (a2 == null) {
                k.a();
            }
            k.a((Object) a2, "this.tab_layout.getTabAt(pos)!!");
            LayoutInflater from = LayoutInflater.from(context);
            k.a((Object) from, "LayoutInflater.from(this)");
            k.c(from, "inflater");
            k.c(context, "context");
            View inflate = from.inflate(R.layout.layout_tab_travel_booking, (TabLayout) _$_findCachedViewById(R.id.tab_layout), false);
            View findViewById = inflate.findViewById(R.id.text_view_travel_tab_header);
            k.a((Object) findViewById, "view.findViewById(R.id.t…t_view_travel_tab_header)");
            TextView textView = (TextView) findViewById;
            if (i2 == 0) {
                textView.setTextColor(androidx.core.content.b.c(context, R.color.color_ffffff));
                textView.setBackgroundResource(R.drawable.pre_round_cornered_blue_stroke_10dp);
            }
            textView.setText(aVar.f21462a.get(i2));
            k.a((Object) inflate, "view");
            a2.a(inflate);
        }
        ((ViewPager) _$_findCachedViewById(R.id.view_pager)).addOnPageChangeListener(new a(this));
    }

    public static final class a implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRTravelBookingList f21464a;

        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        a(AJRTravelBookingList aJRTravelBookingList) {
            this.f21464a = aJRTravelBookingList;
        }

        public final void onPageSelected(int i2) {
            TabLayout tabLayout = (TabLayout) this.f21464a._$_findCachedViewById(R.id.tab_layout);
            k.a((Object) tabLayout, "tab_layout");
            int tabCount = tabLayout.getTabCount();
            for (int i3 = 0; i3 < tabCount; i3++) {
                TabLayout.f a2 = ((TabLayout) this.f21464a._$_findCachedViewById(R.id.tab_layout)).a(i3);
                View a3 = a2 != null ? a2.a() : null;
                if (a3 == null) {
                    k.a();
                }
                View findViewById = a3.findViewById(R.id.text_view_travel_tab_header);
                k.a((Object) findViewById, "view!!.findViewById(R.id…t_view_travel_tab_header)");
                TextView textView = (TextView) findViewById;
                if (i3 == i2) {
                    textView.setTextColor(androidx.core.content.b.c(this.f21464a, R.color.color_ffffff));
                    textView.setBackgroundResource(R.drawable.pre_round_cornered_blue_stroke_10dp);
                } else {
                    textView.setTextColor(androidx.core.content.b.c(this.f21464a, R.color.color_554d4d4d));
                    textView.setBackgroundResource(R.drawable.travel_list_selector_transparent);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showSessionTimeoutAlert(NetworkCustomError networkCustomError) {
        if (!isFinishing()) {
            try {
                k.a((Object) com.travel.d.a(), "TravelController.getInstance()");
                com.travel.d.b().a((Activity) this, (Exception) networkCustomError, true);
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 3 && i3 == -1) {
            com.travel.booking.e.a aVar = this.viewModel;
            if (aVar == null) {
                k.a("viewModel");
            }
            Context baseContext = getBaseContext();
            k.a((Object) baseContext, "baseContext");
            aVar.a(baseContext, true);
        }
    }

    static final class c<T> implements z<x> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRTravelBookingList f21465a;

        c(AJRTravelBookingList aJRTravelBookingList) {
            this.f21465a = aJRTravelBookingList;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f21465a.finish();
        }
    }
}
