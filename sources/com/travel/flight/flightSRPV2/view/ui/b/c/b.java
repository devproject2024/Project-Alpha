package com.travel.flight.flightSRPV2.view.ui.b.c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.travel.flight.R;
import com.travel.flight.b.au;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.flightSRPV2.viewModel.factory.SRPViewModelFactory;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public final class b extends h {

    /* renamed from: a  reason: collision with root package name */
    private au f24300a;

    /* renamed from: b  reason: collision with root package name */
    private SRPOneWayViewModel f24301b;

    /* renamed from: c  reason: collision with root package name */
    private SRPSharedViewModel f24302c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f24303d;

    private View a(int i2) {
        if (this.f24303d == null) {
            this.f24303d = new HashMap();
        }
        View view = (View) this.f24303d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f24303d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class e<T> implements z<com.travel.flight.flightSRPV2.a.c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f24308a;

        e(b bVar) {
            this.f24308a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.travel.flight.flightSRPV2.a.c cVar = (com.travel.flight.flightSRPV2.a.c) obj;
            if (cVar != null) {
                RecyclerView recyclerView = b.c(this.f24308a).f23642g;
                k.a((Object) recyclerView, "this.dataBinding.rvSrpResult");
                RecyclerView.a adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    int i2 = cVar.f24093a;
                    if (i2 == 1) {
                        adapter.notifyItemRangeInserted(cVar.f24094b.f47939a, (cVar.f24094b.f47940b - cVar.f24094b.f47939a) + 1);
                    } else if (i2 == 2) {
                        adapter.notifyItemRangeRemoved(cVar.f24094b.f47939a, (cVar.f24094b.f47940b - cVar.f24094b.f47939a) + 1);
                    }
                    b.c(this.f24308a).f23642g.invalidateItemDecorations();
                }
            }
        }
    }

    public static final /* synthetic */ SRPSharedViewModel b(b bVar) {
        SRPSharedViewModel sRPSharedViewModel = bVar.f24302c;
        if (sRPSharedViewModel == null) {
            k.a("parentViewModel");
        }
        return sRPSharedViewModel;
    }

    public static final /* synthetic */ au c(b bVar) {
        au auVar = bVar.f24300a;
        if (auVar == null) {
            k.a("dataBinding");
        }
        return auVar;
    }

    public static final /* synthetic */ SRPOneWayViewModel d(b bVar) {
        SRPOneWayViewModel sRPOneWayViewModel = bVar.f24301b;
        if (sRPOneWayViewModel == null) {
            k.a("oneWayViewModel");
        }
        return sRPOneWayViewModel;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        au a2 = au.a(layoutInflater, viewGroup);
        k.a((Object) a2, "FragmentSrpOneWayV2Bindi…flater, container, false)");
        this.f24300a = a2;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        ai a3 = am.a(activity).a(SRPSharedViewModel.class);
        k.a((Object) a3, "ViewModelProviders.of(ac…redViewModel::class.java)");
        this.f24302c = (SRPSharedViewModel) a3;
        Fragment fragment = this;
        SRPSharedViewModel sRPSharedViewModel = this.f24302c;
        if (sRPSharedViewModel == null) {
            k.a("parentViewModel");
        }
        ai a4 = am.a(fragment, (al.b) new SRPViewModelFactory(sRPSharedViewModel, false, 2, (g) null)).a(SRPOneWayViewModel.class);
        k.a((Object) a4, "ViewModelProviders.of(th…WayViewModel::class.java)");
        this.f24301b = (SRPOneWayViewModel) a4;
        au auVar = this.f24300a;
        if (auVar == null) {
            k.a("dataBinding");
        }
        SRPOneWayViewModel sRPOneWayViewModel = this.f24301b;
        if (sRPOneWayViewModel == null) {
            k.a("oneWayViewModel");
        }
        auVar.a(sRPOneWayViewModel);
        au auVar2 = this.f24300a;
        if (auVar2 == null) {
            k.a("dataBinding");
        }
        auVar2.setLifecycleOwner(getViewLifecycleOwner());
        SRPOneWayViewModel sRPOneWayViewModel2 = this.f24301b;
        if (sRPOneWayViewModel2 == null) {
            k.a("oneWayViewModel");
        }
        com.travel.flight.flightSRPV2.c.b<com.travel.flight.flightSRPV2.a.c> itemRangeAlteredEvent = sRPOneWayViewModel2.getItemRangeAlteredEvent();
        q viewLifecycleOwner = getViewLifecycleOwner();
        k.a((Object) viewLifecycleOwner, "viewLifecycleOwner");
        itemRangeAlteredEvent.observe(viewLifecycleOwner, new e(this));
        au auVar3 = this.f24300a;
        if (auVar3 == null) {
            k.a("dataBinding");
        }
        return auVar3.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        SRPSharedViewModel sRPSharedViewModel = this.f24302c;
        if (sRPSharedViewModel == null) {
            k.a("parentViewModel");
        }
        if (sRPSharedViewModel.isSortFilterEnable()) {
            ((ConstraintLayout) a(R.id.container_filter_options)).setOnClickListener(new c(this));
            ((ConstraintLayout) a(R.id.container_filter_non_stop_flights)).setOnClickListener(new d(this));
            au auVar = this.f24300a;
            if (auVar == null) {
                k.a("dataBinding");
            }
            auVar.f23642g.addOnScrollListener(new a(this));
        } else {
            au auVar2 = this.f24300a;
            if (auVar2 == null) {
                k.a("dataBinding");
            }
            ConstraintLayout constraintLayout = auVar2.f23636a.f23712a;
            k.a((Object) constraintLayout, "dataBinding.bottomBar.bottomBar");
            constraintLayout.setVisibility(8);
        }
        au auVar3 = this.f24300a;
        if (auVar3 == null) {
            k.a("dataBinding");
        }
        auVar3.f23640e.setOnRefreshListener(new C0466b(this));
    }

    public static final class a extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f24304a;

        a(b bVar) {
            this.f24304a = bVar;
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            k.c(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                b.a(this.f24304a);
                b.b(this.f24304a).isToolTipHidden().setValue(Boolean.FALSE);
                return;
            }
            ConstraintLayout constraintLayout = b.c(this.f24304a).f23636a.f23712a;
            k.a((Object) constraintLayout, "dataBinding.bottomBar.bottomBar");
            constraintLayout.setVisibility(8);
            b.b(this.f24304a).isToolTipHidden().setValue(Boolean.TRUE);
        }
    }

    /* renamed from: com.travel.flight.flightSRPV2.view.ui.b.c.b$b  reason: collision with other inner class name */
    static final class C0466b implements SwipeRefreshLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f24305a;

        C0466b(b bVar) {
            this.f24305a = bVar;
        }

        public final void onRefresh() {
            SwipeRefreshLayout swipeRefreshLayout = b.c(this.f24305a).f23640e;
            k.a((Object) swipeRefreshLayout, "this.dataBinding.pullToRefresh");
            swipeRefreshLayout.setRefreshing(false);
            SRPSharedViewModel b2 = b.b(this.f24305a);
            Context context = this.f24305a.getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            b2.refresh(context);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f24306a;

        c(b bVar) {
            this.f24306a = bVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f24306a.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            if (activity.getSupportFragmentManager().c(R.id.container_full_overlay) instanceof a) {
                b.d(this.f24306a).getParentViewModel().onBackPressed();
            }
            b.d(this.f24306a).getParentViewModel().onFilterOptionsRequested();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f24307a;

        d(b bVar) {
            this.f24307a = bVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f24307a.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            if (activity.getSupportFragmentManager().c(R.id.container_full_overlay) instanceof a) {
                b.d(this.f24307a).getParentViewModel().onBackPressed();
            }
            b.d(this.f24307a).onNonStopFlightsFilterToggled();
        }
    }

    public static final /* synthetic */ void a(b bVar) {
        au auVar = bVar.f24300a;
        if (auVar == null) {
            k.a("dataBinding");
        }
        ConstraintLayout constraintLayout = auVar.f23636a.f23712a;
        k.a((Object) constraintLayout, "dataBinding.bottomBar.bottomBar");
        constraintLayout.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(bVar.getContext(), R.anim.flight_anim_slide_in_from_bottom);
        k.a((Object) loadAnimation, "AnimationUtils.loadAnima…nim_slide_in_from_bottom)");
        loadAnimation.setDuration(600);
        au auVar2 = bVar.f24300a;
        if (auVar2 == null) {
            k.a("dataBinding");
        }
        ConstraintLayout constraintLayout2 = auVar2.f23636a.f23712a;
        k.a((Object) constraintLayout2, "dataBinding.bottomBar.bottomBar");
        constraintLayout2.setAnimation(loadAnimation);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f24303d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
