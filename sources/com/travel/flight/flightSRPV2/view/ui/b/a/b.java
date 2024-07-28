package com.travel.flight.flightSRPV2.view.ui.b.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.travel.flight.R;
import com.travel.flight.b.y;
import com.travel.flight.flightSRPV2.a.ah;
import com.travel.flight.flightSRPV2.viewModel.DRTListViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.flightSRPV2.viewModel.factory.SRPViewModelFactory;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public final class b extends h {

    /* renamed from: a  reason: collision with root package name */
    private y f24244a;

    /* renamed from: b  reason: collision with root package name */
    private SRPSharedViewModel f24245b;

    /* renamed from: c  reason: collision with root package name */
    private DRTListViewModel f24246c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f24247d;

    private View a(int i2) {
        if (this.f24247d == null) {
            this.f24247d = new HashMap();
        }
        View view = (View) this.f24247d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f24247d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c<T> implements z<CJRFlightDetailsItem> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f24251a;

        c(b bVar) {
            this.f24251a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            b.a(this.f24251a).serDRTPrice((CJRFlightDetailsItem) obj, true);
        }
    }

    static final class d<T> implements z<CJRFlightDetailsItem> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f24252a;

        d(b bVar) {
            this.f24252a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            b.a(this.f24252a).serDRTPrice((CJRFlightDetailsItem) obj, false);
        }
    }

    static final class e<T> implements z<ah> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f24253a;

        e(b bVar) {
            this.f24253a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            final ah ahVar = (ah) obj;
            if (ahVar.f24090b) {
                new Handler().postDelayed(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ e f24254a;

                    {
                        this.f24254a = r1;
                    }

                    public final void run() {
                        b.b(this.f24254a.f24253a).o.scrollToPosition(ahVar.f24089a);
                    }
                }, 200);
            } else {
                new Handler().postDelayed(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ e f24256a;

                    {
                        this.f24256a = r1;
                    }

                    public final void run() {
                        b.b(this.f24256a.f24253a).p.scrollToPosition(ahVar.f24089a);
                    }
                }, 200);
            }
        }
    }

    public static final /* synthetic */ DRTListViewModel a(b bVar) {
        DRTListViewModel dRTListViewModel = bVar.f24246c;
        if (dRTListViewModel == null) {
            k.a("viewModel");
        }
        return dRTListViewModel;
    }

    public static final /* synthetic */ y b(b bVar) {
        y yVar = bVar.f24244a;
        if (yVar == null) {
            k.a("dataBinding");
        }
        return yVar;
    }

    public static final /* synthetic */ SRPSharedViewModel c(b bVar) {
        SRPSharedViewModel sRPSharedViewModel = bVar.f24245b;
        if (sRPSharedViewModel == null) {
            k.a("parentViewModel");
        }
        return sRPSharedViewModel;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        y a2 = y.a(layoutInflater, viewGroup);
        k.a((Object) a2, "FragmentDomesticRoundTri…flater, container, false)");
        this.f24244a = a2;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        ai a3 = am.a(activity).a(SRPSharedViewModel.class);
        k.a((Object) a3, "ViewModelProviders.of(ac…redViewModel::class.java)");
        this.f24245b = (SRPSharedViewModel) a3;
        Fragment fragment = this;
        SRPSharedViewModel sRPSharedViewModel = this.f24245b;
        if (sRPSharedViewModel == null) {
            k.a("parentViewModel");
        }
        ai a4 = am.a(fragment, (al.b) new SRPViewModelFactory(sRPSharedViewModel, false, 2, (kotlin.g.b.g) null)).a(DRTListViewModel.class);
        k.a((Object) a4, "ViewModelProviders.of(th…istViewModel::class.java)");
        this.f24246c = (DRTListViewModel) a4;
        y yVar = this.f24244a;
        if (yVar == null) {
            k.a("dataBinding");
        }
        SRPSharedViewModel sRPSharedViewModel2 = this.f24245b;
        if (sRPSharedViewModel2 == null) {
            k.a("parentViewModel");
        }
        yVar.a(sRPSharedViewModel2);
        y yVar2 = this.f24244a;
        if (yVar2 == null) {
            k.a("dataBinding");
        }
        DRTListViewModel dRTListViewModel = this.f24246c;
        if (dRTListViewModel == null) {
            k.a("viewModel");
        }
        yVar2.a(dRTListViewModel);
        y yVar3 = this.f24244a;
        if (yVar3 == null) {
            k.a("dataBinding");
        }
        yVar3.setLifecycleOwner(getViewLifecycleOwner());
        DRTListViewModel dRTListViewModel2 = this.f24246c;
        if (dRTListViewModel2 == null) {
            k.a("viewModel");
        }
        dRTListViewModel2.getSelectedOnwardFlight().observe(getViewLifecycleOwner(), new c(this));
        DRTListViewModel dRTListViewModel3 = this.f24246c;
        if (dRTListViewModel3 == null) {
            k.a("viewModel");
        }
        dRTListViewModel3.getSelectedReturnFlight().observe(getViewLifecycleOwner(), new d(this));
        DRTListViewModel dRTListViewModel4 = this.f24246c;
        if (dRTListViewModel4 == null) {
            k.a("viewModel");
        }
        dRTListViewModel4.getScrollUpdate().observe(getViewLifecycleOwner(), new e(this));
        g gVar = new g(this);
        y yVar4 = this.f24244a;
        if (yVar4 == null) {
            k.a("dataBinding");
        }
        RecyclerView.l lVar = gVar;
        yVar4.o.addOnScrollListener(lVar);
        y yVar5 = this.f24244a;
        if (yVar5 == null) {
            k.a("dataBinding");
        }
        yVar5.p.addOnScrollListener(lVar);
        y yVar6 = this.f24244a;
        if (yVar6 == null) {
            k.a("dataBinding");
        }
        yVar6.f24054i.setOnRefreshListener(new f(this));
        y yVar7 = this.f24244a;
        if (yVar7 == null) {
            k.a("dataBinding");
        }
        return yVar7.getRoot();
    }

    public static final class g extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f24259a;

        g(b bVar) {
            this.f24259a = bVar;
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            k.c(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            b.c(this.f24259a).isToolTipHidden().setValue(Boolean.valueOf(i2 != 0));
        }
    }

    static final class f implements SwipeRefreshLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f24258a;

        f(b bVar) {
            this.f24258a = bVar;
        }

        public final void onRefresh() {
            SwipeRefreshLayout swipeRefreshLayout = b.b(this.f24258a).f24054i;
            k.a((Object) swipeRefreshLayout, "this.dataBinding.pullToRefresh");
            swipeRefreshLayout.setRefreshing(false);
            SRPSharedViewModel c2 = b.c(this.f24258a);
            Context context = this.f24258a.getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            c2.refresh(context);
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((ConstraintLayout) a(R.id.container_filter_options)).setOnClickListener(new a(this));
        ((ConstraintLayout) a(R.id.container_filter_non_stop_flights)).setOnClickListener(new C0461b(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f24249a;

        a(b bVar) {
            this.f24249a = bVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f24249a.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            if (activity.getSupportFragmentManager().c(R.id.container_full_overlay) instanceof a) {
                b.c(this.f24249a).onBackPressed();
            }
            b.c(this.f24249a).onFilterOptionsRequested();
        }
    }

    /* renamed from: com.travel.flight.flightSRPV2.view.ui.b.a.b$b  reason: collision with other inner class name */
    static final class C0461b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f24250a;

        C0461b(b bVar) {
            this.f24250a = bVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f24250a.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            if (activity.getSupportFragmentManager().c(R.id.container_full_overlay) instanceof a) {
                b.c(this.f24250a).onBackPressed();
            }
            b.a(this.f24250a).onNonStopFlightsFilterToggled();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f24247d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
