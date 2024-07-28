package com.travel.flight.flightSRPV2.view.ui.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.b.g;
import com.travel.flight.flightSRPV2.c.b;
import com.travel.flight.flightSRPV2.viewModel.NoFlightsFoundViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.flightSRPV2.viewModel.factory.SRPViewModelFactory;
import com.travel.utils.n;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.i.h;

public final class e extends h {

    /* renamed from: a  reason: collision with root package name */
    private g f24310a;

    /* renamed from: b  reason: collision with root package name */
    private NoFlightsFoundViewModel f24311b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f24312c;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        ai a2 = am.a(activity).a(SRPSharedViewModel.class);
        k.a((Object) a2, "ViewModelProviders.of(ac…redViewModel::class.java)");
        ai a3 = am.a((Fragment) this, (al.b) new SRPViewModelFactory((SRPSharedViewModel) a2, false, 2, (kotlin.g.b.g) null)).a(NoFlightsFoundViewModel.class);
        k.a((Object) a3, "ViewModelProviders.of(th…undViewModel::class.java)");
        this.f24311b = (NoFlightsFoundViewModel) a3;
        ViewDataBinding a4 = f.a(layoutInflater, R.layout.flight_layout_no_flights_found, viewGroup, false);
        k.a((Object) a4, "DataBindingUtil.inflate(…_found, container, false)");
        this.f24310a = (g) a4;
        g gVar = this.f24310a;
        if (gVar == null) {
            k.a("dataBinding");
        }
        NoFlightsFoundViewModel noFlightsFoundViewModel = this.f24311b;
        if (noFlightsFoundViewModel == null) {
            k.a("viewModel");
        }
        gVar.a(noFlightsFoundViewModel);
        g gVar2 = this.f24310a;
        if (gVar2 == null) {
            k.a("dataBinding");
        }
        gVar2.setLifecycleOwner(getViewLifecycleOwner());
        NoFlightsFoundViewModel noFlightsFoundViewModel2 = this.f24311b;
        if (noFlightsFoundViewModel2 == null) {
            k.a("viewModel");
        }
        b<x> popPageEvent = noFlightsFoundViewModel2.getPopPageEvent();
        q viewLifecycleOwner = getViewLifecycleOwner();
        k.a((Object) viewLifecycleOwner, "viewLifecycleOwner");
        popPageEvent.observe(viewLifecycleOwner, new a(this));
        g gVar3 = this.f24310a;
        if (gVar3 == null) {
            k.a("dataBinding");
        }
        return gVar3.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        g gVar = this.f24310a;
        if (gVar == null) {
            k.a("dataBinding");
        }
        ResourceUtils.loadFlightImagesFromCDN(gVar.f23973b, "no_flights_available.png", false, false, n.a.V1);
    }

    static final class a<T> implements z<x> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f24313a;

        a(e eVar) {
            this.f24313a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.travel.flight.flightSRPV2.b.f fVar = com.travel.flight.flightSRPV2.b.f.f24150a;
            FragmentActivity activity = this.f24313a.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            fVar.a(activity);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f24312c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
