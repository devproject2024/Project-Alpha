package net.one97.paytm.vipcashback.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.vipcashback.VoucherFilterItem;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.activity.AJRVIPCashBackActivity;
import net.one97.paytm.vipcashback.f.d;

public final class d extends net.one97.paytm.i.h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f20943a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private boolean f20944b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f20945c;

    /* renamed from: d  reason: collision with root package name */
    private String f20946d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final int f20947e = 1;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final int f20948f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public net.one97.paytm.vipcashback.a.e f20949g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f20950h;

    /* renamed from: i  reason: collision with root package name */
    private int f20951i;
    /* access modifiers changed from: private */
    public ViewGroup j;
    /* access modifiers changed from: private */
    public ViewGroup k;
    private net.one97.paytm.vipcashback.g.c l;
    private kotlin.g.a.m<? super ArrayList<VoucherFilterItem>, ? super Integer, x> m;
    private HashMap n;

    static final class l<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final l f20970a = new l();

        l() {
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object obj) {
        }
    }

    public final View a(int i2) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        View view = (View) this.n.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.n.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class m<T> implements z<net.one97.paytm.vipcashback.f.h<Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20971a;

        m(d dVar) {
            this.f20971a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.vipcashback.f.h hVar = (net.one97.paytm.vipcashback.f.h) obj;
            Integer valueOf = hVar != null ? Integer.valueOf(hVar.f20893a) : null;
            if ((valueOf != null && valueOf.intValue() == 102) || (valueOf != null && valueOf.intValue() == 104)) {
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                FragmentActivity activity = this.f20971a.getActivity();
                if (activity != null) {
                    d.a.a((Context) (AppCompatActivity) activity, (kotlin.g.a.a<x>) new kotlin.g.a.a<x>(this) {
                        final /* synthetic */ m this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void invoke() {
                            FragmentActivity activity = this.this$0.f20971a.getActivity();
                            if (activity != null) {
                                activity.finish();
                            }
                        }
                    });
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            }
        }
    }

    static final class n extends kotlin.g.b.l implements kotlin.g.a.m<ArrayList<VoucherFilterItem>, Integer, x> {
        final /* synthetic */ d this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(d dVar) {
            super(2);
            this.this$0 = dVar;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((ArrayList<VoucherFilterItem>) (ArrayList) obj, ((Number) obj2).intValue());
            return x.f47997a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r0 = r0.f20629a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void invoke(java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.VoucherFilterItem> r3, int r4) {
            /*
                r2 = this;
                net.one97.paytm.vipcashback.fragment.d r0 = r2.this$0
                net.one97.paytm.vipcashback.a.e r0 = r0.f20949g
                if (r0 == 0) goto L_0x0011
                java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r0.f20629a
                if (r0 == 0) goto L_0x0011
                int r0 = r0.size()
                goto L_0x0012
            L_0x0011:
                r0 = 0
            L_0x0012:
                if (r0 <= 0) goto L_0x0041
                net.one97.paytm.vipcashback.fragment.d r0 = r2.this$0
                net.one97.paytm.vipcashback.a.e r0 = r0.f20949g
                if (r0 == 0) goto L_0x0028
                java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r0.f20629a
                if (r0 == 0) goto L_0x0028
                r1 = 1
                java.lang.Object r0 = r0.get(r1)
                androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
                goto L_0x0029
            L_0x0028:
                r0 = 0
            L_0x0029:
                boolean r1 = r0 instanceof net.one97.paytm.v2.features.cashbackoffers.ui.b
                if (r1 == 0) goto L_0x0041
                net.one97.paytm.v2.features.cashbackoffers.ui.b r0 = (net.one97.paytm.v2.features.cashbackoffers.ui.b) r0
                net.one97.paytm.v2.features.cashbackoffers.c.a r0 = r0.f20403c
                if (r0 == 0) goto L_0x0039
                net.one97.paytm.v2.features.cashbacklanding.d.e r0 = (net.one97.paytm.v2.features.cashbacklanding.d.e) r0
                r0.a((int) r4, (java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.VoucherFilterItem>) r3)
                goto L_0x0041
            L_0x0039:
                kotlin.u r3 = new kotlin.u
                java.lang.String r4 = "null cannot be cast to non-null type net.one97.paytm.v2.features.cashbacklanding.viewmodel.VoucherViewModel"
                r3.<init>(r4)
                throw r3
            L_0x0041:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.fragment.d.n.invoke(java.util.ArrayList, int):void");
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static d a(String str) {
            d dVar = new d();
            Bundle bundle = new Bundle();
            bundle.putBoolean("KEY_IS_FROM_DRAWER", false);
            bundle.putBoolean("LOAD_ON_CREATE_DATA", true);
            bundle.putString("OFFER_TAG", str);
            dVar.setArguments(bundle);
            return dVar;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        boolean z = false;
        this.f20944b = arguments != null ? arguments.getBoolean("KEY_IS_FROM_DRAWER") : false;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            z = arguments2.getBoolean("LOAD_ON_CREATE_DATA");
        }
        this.f20945c = z;
        Bundle arguments3 = getArguments();
        this.f20946d = arguments3 != null ? arguments3.getString("OFFER_TAG") : null;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_merchant_landing, (ViewGroup) null, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        LiveData liveData;
        LiveData<String> liveData2;
        net.one97.paytm.v2.features.cashbackoffers.b.c cVar;
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.k = (ViewGroup) view.findViewById(R.id.tabLayoutMerchant);
        this.j = (ViewGroup) view.findViewById(R.id.tabLayoutHeader);
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context, "context!!");
        androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
        kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
        this.f20949g = new net.one97.paytm.vipcashback.a.e(context, childFragmentManager, this.f20944b, this.f20945c, this.f20946d);
        ViewPager viewPager = (ViewPager) a(R.id.viewPager);
        if (viewPager != null) {
            viewPager.setOffscreenPageLimit(1);
        }
        ViewPager viewPager2 = (ViewPager) a(R.id.viewPager);
        if (viewPager2 != null) {
            viewPager2.setAdapter(this.f20949g);
        }
        ViewPager viewPager3 = (ViewPager) a(R.id.viewPager);
        if (viewPager3 != null) {
            viewPager3.addOnPageChangeListener(new k(this, view));
        }
        ViewPager viewPager4 = (ViewPager) a(R.id.viewPager);
        if (viewPager4 != null) {
            viewPager4.setCurrentItem(0);
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        this.l = (net.one97.paytm.vipcashback.g.c) am.a(activity).a(net.one97.paytm.vipcashback.g.c.class);
        net.one97.paytm.vipcashback.g.c cVar2 = this.l;
        if (cVar2 != null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity2, "activity!!");
            cVar2.f21015d = new net.one97.paytm.v2.features.cashbackoffers.b.c(activity2);
        }
        net.one97.paytm.vipcashback.g.c cVar3 = this.l;
        if (!(cVar3 == null || (cVar = cVar3.f21015d) == null)) {
            cVar.a(cVar3.f21012a);
        }
        net.one97.paytm.vipcashback.g.c cVar4 = this.l;
        if (!(cVar4 == null || (liveData2 = cVar4.f21016e) == null)) {
            FragmentActivity activity3 = getActivity();
            if (activity3 == null) {
                kotlin.g.b.k.a();
            }
            liveData2.observe(activity3, l.f20970a);
        }
        net.one97.paytm.vipcashback.g.c cVar5 = this.l;
        if (!(cVar5 == null || (liveData = cVar5.f21014c) == null)) {
            liveData.observe(this, new m(this));
        }
        this.m = new n(this);
        ViewGroup viewGroup = this.j;
        if (viewGroup != null) {
            RoboTextView roboTextView = (RoboTextView) viewGroup.findViewById(R.id.vouchersTab);
            if (roboTextView != null) {
                roboTextView.setOnClickListener(new e(this, view));
            }
            RoboTextView roboTextView2 = (RoboTextView) viewGroup.findViewById(R.id.offersTab);
            if (roboTextView2 != null) {
                roboTextView2.setOnClickListener(new f(this, view));
            }
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.filterLayout);
            if (viewGroup2 != null) {
                viewGroup2.setOnClickListener(new g(this, view));
            }
            ViewGroup viewGroup3 = (ViewGroup) viewGroup.findViewById(R.id.filterLayout);
            if (viewGroup3 != null) {
                viewGroup3.setVisibility(8);
            }
        }
        ViewGroup viewGroup4 = this.k;
        if (viewGroup4 != null) {
            RoboTextView roboTextView3 = (RoboTextView) viewGroup4.findViewById(R.id.vouchersTab);
            if (roboTextView3 != null) {
                roboTextView3.setOnClickListener(new h(this, view));
            }
            RoboTextView roboTextView4 = (RoboTextView) viewGroup4.findViewById(R.id.offersTab);
            if (roboTextView4 != null) {
                roboTextView4.setOnClickListener(new i(this, view));
            }
            ViewGroup viewGroup5 = (ViewGroup) viewGroup4.findViewById(R.id.filterLayout);
            if (viewGroup5 != null) {
                viewGroup5.setOnClickListener(new j(this, view));
            }
            ViewGroup viewGroup6 = (ViewGroup) viewGroup4.findViewById(R.id.filterLayout);
            if (viewGroup6 != null) {
                viewGroup6.setVisibility(8);
            }
        }
        net.one97.paytm.vipcashback.f.f.a();
        if (net.one97.paytm.vipcashback.f.f.O()) {
            View a2 = a(R.id.pointsView);
            kotlin.g.b.k.a((Object) a2, "pointsView");
            a2.setVisibility(8);
        } else {
            View a3 = a(R.id.pointsView);
            if (a3 != null) {
                a3.setOnClickListener(new b(this));
            }
        }
        AppBarLayout appBarLayout = (AppBarLayout) a(R.id.appBarLayout);
        if (appBarLayout != null) {
            appBarLayout.a((AppBarLayout.b) new c(this, view));
        }
        ImageView imageView = (ImageView) a(R.id.backArrow);
        if (imageView != null) {
            imageView.setOnClickListener(new C0405d(this));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20952a;

        b(d dVar) {
            this.f20952a = dVar;
        }

        public final void onClick(View view) {
            d.a(this.f20952a);
        }
    }

    static final class c implements AppBarLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20953a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f20954b;

        c(d dVar, View view) {
            this.f20953a = dVar;
            this.f20954b = view;
        }

        public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            int abs = Math.abs(i2);
            kotlin.g.b.k.a((Object) appBarLayout, "appBarLayout");
            if (abs - appBarLayout.getTotalScrollRange() == 0) {
                if (!this.f20953a.f20950h) {
                    ImageView imageView = (ImageView) this.f20953a.a(R.id.headerImage);
                    if (imageView != null) {
                        imageView.setVisibility(4);
                    }
                    View a2 = this.f20953a.a(R.id.tabLayoutHeader);
                    if (a2 != null) {
                        a2.setVisibility(0);
                    }
                    this.f20953a.f20950h = true;
                    d.c(this.f20953a);
                }
            } else if (this.f20953a.f20950h) {
                ImageView imageView2 = (ImageView) this.f20953a.a(R.id.headerImage);
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                View a3 = this.f20953a.a(R.id.tabLayoutHeader);
                if (a3 != null) {
                    a3.setVisibility(8);
                }
                this.f20953a.f20950h = false;
                d.c(this.f20953a);
            }
        }
    }

    /* renamed from: net.one97.paytm.vipcashback.fragment.d$d  reason: collision with other inner class name */
    static final class C0405d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20955a;

        C0405d(d dVar) {
            this.f20955a = dVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity;
            d dVar = this.f20955a;
            if ((dVar.getActivity() instanceof AJRVIPCashBackActivity) && (activity = dVar.getActivity()) != null) {
                activity.onBackPressed();
            }
        }
    }

    public static final class k implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20968a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f20969b;

        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        k(d dVar, View view) {
            this.f20968a = dVar;
            this.f20969b = view;
        }

        public final void onPageSelected(int i2) {
            ViewGroup viewGroup = null;
            if (this.f20968a.f20950h) {
                d dVar = this.f20968a;
                View view = this.f20969b;
                if (view != null) {
                    viewGroup = (ViewGroup) view.findViewById(R.id.tabLayoutHeader);
                }
                kotlin.g.b.k.a((Object) viewGroup, "view?.findViewById<ViewG…up>(R.id.tabLayoutHeader)");
                dVar.a(i2, viewGroup);
                return;
            }
            d dVar2 = this.f20968a;
            View view2 = this.f20969b;
            if (view2 != null) {
                viewGroup = (ViewGroup) view2.findViewById(R.id.tabLayoutMerchant);
            }
            kotlin.g.b.k.a((Object) viewGroup, "view?.findViewById<ViewG…>(R.id.tabLayoutMerchant)");
            dVar2.a(i2, viewGroup);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20956a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f20957b;

        e(d dVar, View view) {
            this.f20956a = dVar;
            this.f20957b = view;
        }

        public final void onClick(View view) {
            d dVar = this.f20956a;
            int e2 = dVar.f20947e;
            ViewGroup f2 = this.f20956a.j;
            if (f2 == null) {
                kotlin.g.b.k.a();
            }
            dVar.a(e2, f2);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20958a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f20959b;

        f(d dVar, View view) {
            this.f20958a = dVar;
            this.f20959b = view;
        }

        public final void onClick(View view) {
            d dVar = this.f20958a;
            int g2 = dVar.f20948f;
            ViewGroup f2 = this.f20958a.j;
            if (f2 == null) {
                kotlin.g.b.k.a();
            }
            dVar.a(g2, f2);
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20960a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f20961b;

        g(d dVar, View view) {
            this.f20960a = dVar;
            this.f20961b = view;
        }

        public final void onClick(View view) {
            d.a(this.f20960a, this.f20961b);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20962a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f20963b;

        h(d dVar, View view) {
            this.f20962a = dVar;
            this.f20963b = view;
        }

        public final void onClick(View view) {
            ((AppBarLayout) this.f20962a.a(R.id.appBarLayout)).setExpanded(true);
            d dVar = this.f20962a;
            int e2 = dVar.f20947e;
            ViewGroup h2 = this.f20962a.k;
            if (h2 == null) {
                kotlin.g.b.k.a();
            }
            dVar.a(e2, h2);
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20964a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f20965b;

        i(d dVar, View view) {
            this.f20964a = dVar;
            this.f20965b = view;
        }

        public final void onClick(View view) {
            ((AppBarLayout) this.f20964a.a(R.id.appBarLayout)).setExpanded(true);
            d dVar = this.f20964a;
            int g2 = dVar.f20948f;
            ViewGroup h2 = this.f20964a.k;
            if (h2 == null) {
                kotlin.g.b.k.a();
            }
            dVar.a(g2, h2);
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20966a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f20967b;

        j(d dVar, View view) {
            this.f20966a = dVar;
            this.f20967b = view;
        }

        public final void onClick(View view) {
            d.a(this.f20966a, this.f20967b);
        }
    }

    /* access modifiers changed from: private */
    public final void a(int i2, ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        RoboTextView roboTextView;
        RoboTextView roboTextView2;
        RoboTextView roboTextView3;
        RoboTextView roboTextView4;
        ViewGroup viewGroup3;
        RoboTextView roboTextView5;
        RoboTextView roboTextView6;
        RoboTextView roboTextView7;
        RoboTextView roboTextView8;
        if (i2 == this.f20948f) {
            this.f20951i = 0;
            if (!(viewGroup == null || (roboTextView8 = (RoboTextView) viewGroup.findViewById(R.id.vouchersTab)) == null)) {
                Context context = getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                roboTextView8.setTextColor(androidx.core.content.b.c(context, net.one97.paytm.common.assets.R.color.color_00b9f5));
            }
            if (!(viewGroup == null || (roboTextView7 = (RoboTextView) viewGroup.findViewById(R.id.vouchersTab)) == null)) {
                Context context2 = getContext();
                if (context2 == null) {
                    kotlin.g.b.k.a();
                }
                roboTextView7.setBackground(androidx.core.content.b.a(context2, R.drawable.cashback_blue_border_right_round_bg));
            }
            if (!(viewGroup == null || (roboTextView6 = (RoboTextView) viewGroup.findViewById(R.id.offersTab)) == null)) {
                Context context3 = getContext();
                if (context3 == null) {
                    kotlin.g.b.k.a();
                }
                roboTextView6.setTextColor(androidx.core.content.b.c(context3, net.one97.paytm.common.assets.R.color.white));
            }
            if (!(viewGroup == null || (roboTextView5 = (RoboTextView) viewGroup.findViewById(R.id.offersTab)) == null)) {
                Context context4 = getContext();
                if (context4 == null) {
                    kotlin.g.b.k.a();
                }
                roboTextView5.setBackground(androidx.core.content.b.a(context4, R.drawable.cashback_filled_blue_left_round_bg));
            }
            ViewPager viewPager = (ViewPager) a(R.id.viewPager);
            if (viewPager != null) {
                viewPager.setCurrentItem(i2);
            }
            if (!(viewGroup == null || (viewGroup3 = (ViewGroup) viewGroup.findViewById(R.id.filterLayout)) == null)) {
                viewGroup3.setVisibility(8);
            }
            ViewPager viewPager2 = (ViewPager) a(R.id.viewPager);
            if (viewPager2 != null) {
                viewPager2.arrowScroll(17);
            }
        } else if (i2 == this.f20947e) {
            this.f20951i = 1;
            if (!(viewGroup == null || (roboTextView4 = (RoboTextView) viewGroup.findViewById(R.id.offersTab)) == null)) {
                Context context5 = getContext();
                if (context5 == null) {
                    kotlin.g.b.k.a();
                }
                roboTextView4.setTextColor(androidx.core.content.b.c(context5, net.one97.paytm.common.assets.R.color.color_00b9f5));
            }
            if (!(viewGroup == null || (roboTextView3 = (RoboTextView) viewGroup.findViewById(R.id.offersTab)) == null)) {
                Context context6 = getContext();
                if (context6 == null) {
                    kotlin.g.b.k.a();
                }
                roboTextView3.setBackground(androidx.core.content.b.a(context6, R.drawable.cashback_blue_border_left_round_bg));
            }
            if (!(viewGroup == null || (roboTextView2 = (RoboTextView) viewGroup.findViewById(R.id.vouchersTab)) == null)) {
                Context context7 = getContext();
                if (context7 == null) {
                    kotlin.g.b.k.a();
                }
                roboTextView2.setTextColor(androidx.core.content.b.c(context7, net.one97.paytm.common.assets.R.color.white));
            }
            if (!(viewGroup == null || (roboTextView = (RoboTextView) viewGroup.findViewById(R.id.vouchersTab)) == null)) {
                Context context8 = getContext();
                if (context8 == null) {
                    kotlin.g.b.k.a();
                }
                roboTextView.setBackground(androidx.core.content.b.a(context8, R.drawable.cashback_filled_blue_right_round_bg));
            }
            ViewPager viewPager3 = (ViewPager) a(R.id.viewPager);
            if (viewPager3 != null) {
                viewPager3.setCurrentItem(i2);
            }
            if (!(viewGroup == null || (viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.filterLayout)) == null)) {
                viewGroup2.setVisibility(0);
            }
            ViewPager viewPager4 = (ViewPager) a(R.id.viewPager);
            if (viewPager4 != null) {
                viewPager4.arrowScroll(66);
            }
        }
    }

    public static final /* synthetic */ void a(d dVar) {
        if (dVar.getActivity() != null) {
            kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
            CharSequence N = net.one97.paytm.vipcashback.f.f.N();
            if (!(N == null || N.length() == 0)) {
                kotlin.g.b.k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
                net.one97.paytm.vipcashback.c.a.b().checkDeepLinking(dVar.getActivity(), net.one97.paytm.vipcashback.f.f.N());
            }
        }
    }

    public static final /* synthetic */ void c(d dVar) {
        ViewGroup viewGroup;
        if (!dVar.f20950h || (viewGroup = dVar.j) == null) {
            ViewGroup viewGroup2 = dVar.k;
            if (viewGroup2 != null) {
                int i2 = dVar.f20951i;
                if (viewGroup2 == null) {
                    kotlin.g.b.k.a();
                }
                dVar.a(i2, viewGroup2);
                return;
            }
            return;
        }
        int i3 = dVar.f20951i;
        if (viewGroup == null) {
            kotlin.g.b.k.a();
        }
        dVar.a(i3, viewGroup);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r3 = r3.f20629a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.vipcashback.fragment.d r2, android.view.View r3) {
        /*
            net.one97.paytm.vipcashback.f.d$a r0 = net.one97.paytm.vipcashback.f.d.f20859a
            net.one97.paytm.vipcashback.f.d.a.a((android.view.View) r3)
            net.one97.paytm.vipcashback.a.e r3 = r2.f20949g
            if (r3 == 0) goto L_0x0012
            java.util.ArrayList<androidx.fragment.app.Fragment> r3 = r3.f20629a
            if (r3 == 0) goto L_0x0012
            int r3 = r3.size()
            goto L_0x0013
        L_0x0012:
            r3 = 0
        L_0x0013:
            if (r3 <= 0) goto L_0x0065
            net.one97.paytm.vipcashback.a.e r3 = r2.f20949g
            r0 = 0
            if (r3 == 0) goto L_0x0026
            java.util.ArrayList<androidx.fragment.app.Fragment> r3 = r3.f20629a
            if (r3 == 0) goto L_0x0026
            r1 = 1
            java.lang.Object r3 = r3.get(r1)
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3
            goto L_0x0027
        L_0x0026:
            r3 = r0
        L_0x0027:
            boolean r1 = r3 instanceof net.one97.paytm.v2.features.cashbackoffers.ui.b
            if (r1 == 0) goto L_0x0065
            net.one97.paytm.vipcashback.g.c r1 = r2.l
            if (r1 == 0) goto L_0x003a
            androidx.lifecycle.y<java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.Facets>> r1 = r1.f21013b
            if (r1 == 0) goto L_0x003a
            java.lang.Object r1 = r1.getValue()
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            goto L_0x003b
        L_0x003a:
            r1 = r0
        L_0x003b:
            if (r1 == 0) goto L_0x0065
            kotlin.g.a.m<? super java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.VoucherFilterItem>, ? super java.lang.Integer, kotlin.x> r1 = r2.m
            if (r1 == 0) goto L_0x0065
            net.one97.paytm.v2.features.cashbackoffers.ui.b r3 = (net.one97.paytm.v2.features.cashbackoffers.ui.b) r3
            net.one97.paytm.vipcashback.g.c r1 = r2.l
            if (r1 == 0) goto L_0x0051
            androidx.lifecycle.y<java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.Facets>> r1 = r1.f21013b
            if (r1 == 0) goto L_0x0051
            java.lang.Object r0 = r1.getValue()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
        L_0x0051:
            if (r0 != 0) goto L_0x0056
            kotlin.g.b.k.a()
        L_0x0056:
            java.lang.String r1 = "merchantVoucherViewModel?.filterData?.value!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            kotlin.g.a.m<? super java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.VoucherFilterItem>, ? super java.lang.Integer, kotlin.x> r2 = r2.m
            if (r2 != 0) goto L_0x0062
            kotlin.g.b.k.a()
        L_0x0062:
            r3.a(r0, r2)
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.fragment.d.a(net.one97.paytm.vipcashback.fragment.d, android.view.View):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
