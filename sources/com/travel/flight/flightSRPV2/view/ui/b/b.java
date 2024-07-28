package com.travel.flight.flightSRPV2.view.ui.b;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.google.android.material.tabs.TabLayout;
import com.travel.flight.R;
import com.travel.flight.b.ac;
import com.travel.flight.flightSRPV2.b.f;
import com.travel.flight.flightSRPV2.view.ui.a.e;
import com.travel.flight.flightSRPV2.view.ui.widget.LockableViewPager;
import com.travel.flight.flightSRPV2.viewModel.FlightFilterHomeViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.flightSRPV2.viewModel.factory.SRPViewModelFactory;
import com.travel.flight.utils.c;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.h;

public final class b extends h {

    /* renamed from: a  reason: collision with root package name */
    private ac f24271a;

    /* renamed from: b  reason: collision with root package name */
    private FlightFilterHomeViewModel f24272b;

    /* renamed from: c  reason: collision with root package name */
    private SRPSharedViewModel f24273c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f24274d;

    static final class a<T> implements z<List<? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f24275a;

        a(b bVar) {
            this.f24275a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            int i2 = 0;
            int size = list != null ? list.size() : 0;
            LockableViewPager lockableViewPager = b.a(this.f24275a).f23560g;
            k.a((Object) lockableViewPager, "this.dataBinding.viewpagerFlightFilter");
            androidx.viewpager.widget.a adapter = lockableViewPager.getAdapter();
            if (!(adapter instanceof e)) {
                adapter = null;
            }
            e eVar = (e) adapter;
            if (eVar == null || eVar.f24187a != size) {
                LockableViewPager lockableViewPager2 = b.a(this.f24275a).f23560g;
                k.a((Object) lockableViewPager2, "this.dataBinding.viewpagerFlightFilter");
                j childFragmentManager = this.f24275a.getChildFragmentManager();
                k.a((Object) childFragmentManager, "this.childFragmentManager");
                lockableViewPager2.setAdapter(new e(size, childFragmentManager));
            }
            LockableViewPager lockableViewPager3 = b.a(this.f24275a).f23560g;
            k.a((Object) lockableViewPager3, "this.dataBinding.viewpagerFlightFilter");
            lockableViewPager3.setOffscreenPageLimit(2);
            b.a(this.f24275a).f23556c.setupWithViewPager(b.a(this.f24275a).f23560g);
            if (size <= 1) {
                TabLayout tabLayout = b.a(this.f24275a).f23556c;
                k.a((Object) tabLayout, "this.dataBinding.tabLytFlightFilters");
                tabLayout.setVisibility(8);
                return;
            }
            TabLayout tabLayout2 = b.a(this.f24275a).f23556c;
            k.a((Object) tabLayout2, "this.dataBinding.tabLytFlightFilters");
            tabLayout2.setVisibility(0);
            k.a((Object) list, "it");
            int size2 = list.size();
            while (i2 < size2) {
                String str = (String) list.get(i2);
                FragmentActivity activity = this.f24275a.getActivity();
                if (activity == null) {
                    k.a();
                }
                View inflate = LayoutInflater.from(activity).inflate(R.layout.pre_f_view_flight_filter_custom_tab, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.txt_filter_tab_title);
                if (findViewById != null) {
                    ((TextView) findViewById).setText(str);
                    TabLayout.f a2 = b.a(this.f24275a).f23556c.a(i2);
                    if (a2 == null) {
                        k.a();
                    }
                    k.a((Object) a2, "this.dataBinding.tabLytF…Filters.getTabAt(index)!!");
                    a2.a(inflate);
                    i2++;
                } else {
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
            }
        }
    }

    /* renamed from: com.travel.flight.flightSRPV2.view.ui.b.b$b  reason: collision with other inner class name */
    static final class C0463b<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f24281a;

        C0463b(b bVar) {
            this.f24281a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num = (Integer) obj;
            if (num != null && num.intValue() == 1) {
                f fVar = f.f24150a;
                FragmentActivity activity = this.f24281a.getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                fVar.a(activity);
            }
        }
    }

    public static final /* synthetic */ ac a(b bVar) {
        ac acVar = bVar.f24271a;
        if (acVar == null) {
            k.a("dataBinding");
        }
        return acVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        ai a2 = am.a(activity).a(SRPSharedViewModel.class);
        k.a((Object) a2, "ViewModelProviders.of(ac…redViewModel::class.java)");
        this.f24273c = (SRPSharedViewModel) a2;
        Fragment fragment = this;
        SRPSharedViewModel sRPSharedViewModel = this.f24273c;
        if (sRPSharedViewModel == null) {
            k.a("parentViewModel");
        }
        ai a3 = am.a(fragment, (al.b) new SRPViewModelFactory(sRPSharedViewModel, false, 2, (g) null)).a(FlightFilterHomeViewModel.class);
        k.a((Object) a3, "ViewModelProviders.of(th…omeViewModel::class.java)");
        this.f24272b = (FlightFilterHomeViewModel) a3;
        ac a4 = ac.a(layoutInflater, viewGroup);
        k.a((Object) a4, "FragmentFlightFilterHome…flater, container, false)");
        this.f24271a = a4;
        ac acVar = this.f24271a;
        if (acVar == null) {
            k.a("dataBinding");
        }
        FlightFilterHomeViewModel flightFilterHomeViewModel = this.f24272b;
        if (flightFilterHomeViewModel == null) {
            k.a("viewModel");
        }
        acVar.a(flightFilterHomeViewModel);
        ac acVar2 = this.f24271a;
        if (acVar2 == null) {
            k.a("dataBinding");
        }
        acVar2.setLifecycleOwner(getViewLifecycleOwner());
        FlightFilterHomeViewModel flightFilterHomeViewModel2 = this.f24272b;
        if (flightFilterHomeViewModel2 == null) {
            k.a("viewModel");
        }
        flightFilterHomeViewModel2.getTabs().observe(getViewLifecycleOwner(), new a(this));
        FlightFilterHomeViewModel flightFilterHomeViewModel3 = this.f24272b;
        if (flightFilterHomeViewModel3 == null) {
            k.a("viewModel");
        }
        flightFilterHomeViewModel3.getEvent().observe(getViewLifecycleOwner(), new C0463b(this));
        ac acVar3 = this.f24271a;
        if (acVar3 == null) {
            k.a("dataBinding");
        }
        return acVar3.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ac acVar = this.f24271a;
        if (acVar == null) {
            k.a("dataBinding");
        }
        acVar.f23555b.setImageResource(com.travel.common.R.drawable.travel_res_common_close);
    }

    public final void onPause() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        c.a((Activity) activity);
        super.onPause();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f24274d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
