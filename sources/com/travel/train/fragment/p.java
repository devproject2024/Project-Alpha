package com.travel.train.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.google.android.material.tabs.TabLayout;
import com.travel.train.R;
import com.travel.train.b.u;
import com.travel.train.j.w;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.widgets.CJRCustomViewPager;

public final class p extends am {

    /* renamed from: a  reason: collision with root package name */
    public static final a f27120a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private boolean f27121b;

    /* renamed from: c  reason: collision with root package name */
    private com.paytm.b.a.a f27122c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f27123d;

    public final View a(int i2) {
        if (this.f27123d == null) {
            this.f27123d = new HashMap();
        }
        View view = (View) this.f27123d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f27123d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_train_booking_fragment_viewpager, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        com.paytm.b.a.a aVar;
        u uVar;
        Resources resources;
        Context applicationContext;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Context context = getContext();
        String str = null;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            aVar = null;
        } else {
            w.a aVar2 = w.f27609a;
            aVar = w.a.a(applicationContext);
        }
        this.f27122c = aVar;
        com.paytm.b.a.a aVar3 = this.f27122c;
        Boolean valueOf = aVar3 != null ? Boolean.valueOf(aVar3.b("train_show_tip_view_for_tab", false, false)) : null;
        if (valueOf == null) {
            k.a();
        }
        this.f27121b = valueOf.booleanValue();
        TabLayout tabLayout = (TabLayout) a(R.id.train_booking_tab);
        if (tabLayout != null) {
            TabLayout tabLayout2 = (TabLayout) a(R.id.train_booking_tab);
            TabLayout.f a2 = tabLayout2 != null ? tabLayout2.a() : null;
            if (a2 == null) {
                k.a();
            }
            tabLayout.a(a2);
        }
        TabLayout tabLayout3 = (TabLayout) a(R.id.train_booking_tab);
        if (tabLayout3 != null) {
            TabLayout tabLayout4 = (TabLayout) a(R.id.train_booking_tab);
            TabLayout.f a3 = tabLayout4 != null ? tabLayout4.a() : null;
            if (a3 == null) {
                k.a();
            }
            tabLayout3.a(a3);
        }
        TabLayout tabLayout5 = (TabLayout) a(R.id.train_booking_tab);
        if (tabLayout5 != null) {
            tabLayout5.setTabGravity(0);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            k.a((Object) activity, "it");
            Bundle arguments = getArguments();
            j supportFragmentManager = activity.getSupportFragmentManager();
            k.a((Object) supportFragmentManager, "it.supportFragmentManager");
            uVar = new u(activity, arguments, supportFragmentManager);
        } else {
            uVar = null;
        }
        TabLayout tabLayout6 = (TabLayout) a(R.id.train_booking_tab);
        if (tabLayout6 != null) {
            tabLayout6.setSelectedTabIndicatorColor(androidx.core.content.b.c(requireContext(), R.color.color_00b9f5));
        }
        CJRCustomViewPager cJRCustomViewPager = (CJRCustomViewPager) a(R.id.train_booking_viewpager);
        if (cJRCustomViewPager != null) {
            cJRCustomViewPager.setOffscreenPageLimit(0);
        }
        CJRCustomViewPager cJRCustomViewPager2 = (CJRCustomViewPager) a(R.id.train_booking_viewpager);
        if (cJRCustomViewPager2 != null) {
            cJRCustomViewPager2.setAdapter(uVar);
        }
        TabLayout tabLayout7 = (TabLayout) a(R.id.train_booking_tab);
        if (tabLayout7 != null) {
            tabLayout7.setupWithViewPager((CJRCustomViewPager) a(R.id.train_booking_viewpager));
        }
        TabLayout tabLayout8 = (TabLayout) a(R.id.train_booking_tab);
        if (tabLayout8 != null) {
            tabLayout8.a((TabLayout.c) new b(this));
        }
        if (!this.f27121b) {
            View childAt = ((TabLayout) a(R.id.train_booking_tab)).getChildAt(0);
            if (childAt != null) {
                View childAt2 = ((ViewGroup) childAt).getChildAt(1);
                k.a((Object) childAt2, "it");
                com.travel.train.hintsbuilder.a a4 = new com.travel.train.hintsbuilder.a(getActivity()).a(childAt2).a("1/1");
                FragmentActivity activity2 = getActivity();
                if (!(activity2 == null || (resources = activity2.getResources()) == null)) {
                    str = resources.getString(R.string.train_show_tip_view_tab_desc);
                }
                a4.b(str).a(100).b().c().b(R.layout.pre_t_train_show_square_tip_view).a().a((Activity) getActivity());
                com.paytm.b.a.a aVar4 = this.f27122c;
                if (aVar4 != null) {
                    aVar4.a("train_show_tip_view_for_tab", true, false);
                    return;
                }
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public static final class b implements TabLayout.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f27124a;

        public final void onTabReselected(TabLayout.f fVar) {
            k.c(fVar, "tab");
        }

        public final void onTabUnselected(TabLayout.f fVar) {
            k.c(fVar, "tab");
        }

        b(p pVar) {
            this.f27124a = pVar;
        }

        public final void onTabSelected(TabLayout.f fVar) {
            k.c(fVar, "tab");
            CJRCustomViewPager cJRCustomViewPager = (CJRCustomViewPager) this.f27124a.a(R.id.train_booking_viewpager);
            if (cJRCustomViewPager != null) {
                cJRCustomViewPager.setCurrentItem(fVar.b());
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f27123d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
