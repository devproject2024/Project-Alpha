package com.travel.flight.flightSRPV2.view.ui.b.b;

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
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.travel.flight.R;
import com.travel.flight.b.am;
import com.travel.flight.flightSRPV2.viewModel.IRTViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.flightSRPV2.viewModel.factory.SRPViewModelFactory;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public final class c extends h {

    /* renamed from: a  reason: collision with root package name */
    private am f24286a;

    /* renamed from: b  reason: collision with root package name */
    private IRTViewModel f24287b;

    /* renamed from: c  reason: collision with root package name */
    private SRPSharedViewModel f24288c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f24289d;

    private View a(int i2) {
        if (this.f24289d == null) {
            this.f24289d = new HashMap();
        }
        View view = (View) this.f24289d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f24289d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ SRPSharedViewModel a(c cVar) {
        SRPSharedViewModel sRPSharedViewModel = cVar.f24288c;
        if (sRPSharedViewModel == null) {
            k.a("parentViewModel");
        }
        return sRPSharedViewModel;
    }

    public static final /* synthetic */ am c(c cVar) {
        am amVar = cVar.f24286a;
        if (amVar == null) {
            k.a("dataBinding");
        }
        return amVar;
    }

    public static final /* synthetic */ IRTViewModel d(c cVar) {
        IRTViewModel iRTViewModel = cVar.f24287b;
        if (iRTViewModel == null) {
            k.a("irtViewModel");
        }
        return iRTViewModel;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        am a2 = am.a(layoutInflater, viewGroup);
        k.a((Object) a2, "FragmentInternationalRou…flater, container, false)");
        this.f24286a = a2;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        ai a3 = androidx.lifecycle.am.a(activity).a(SRPSharedViewModel.class);
        k.a((Object) a3, "ViewModelProviders.of(ac…redViewModel::class.java)");
        this.f24288c = (SRPSharedViewModel) a3;
        Fragment fragment = this;
        SRPSharedViewModel sRPSharedViewModel = this.f24288c;
        if (sRPSharedViewModel == null) {
            k.a("parentViewModel");
        }
        ai a4 = androidx.lifecycle.am.a(fragment, (al.b) new SRPViewModelFactory(sRPSharedViewModel, false, 2, (g) null)).a(IRTViewModel.class);
        k.a((Object) a4, "ViewModelProviders.of(th…IRTViewModel::class.java)");
        this.f24287b = (IRTViewModel) a4;
        am amVar = this.f24286a;
        if (amVar == null) {
            k.a("dataBinding");
        }
        SRPSharedViewModel sRPSharedViewModel2 = this.f24288c;
        if (sRPSharedViewModel2 == null) {
            k.a("parentViewModel");
        }
        amVar.a(sRPSharedViewModel2);
        am amVar2 = this.f24286a;
        if (amVar2 == null) {
            k.a("dataBinding");
        }
        IRTViewModel iRTViewModel = this.f24287b;
        if (iRTViewModel == null) {
            k.a("irtViewModel");
        }
        amVar2.a(iRTViewModel);
        am amVar3 = this.f24286a;
        if (amVar3 == null) {
            k.a("dataBinding");
        }
        amVar3.setLifecycleOwner(getViewLifecycleOwner());
        d dVar = new d(this);
        am amVar4 = this.f24286a;
        if (amVar4 == null) {
            k.a("dataBinding");
        }
        amVar4.f23602c.addOnScrollListener(dVar);
        am amVar5 = this.f24286a;
        if (amVar5 == null) {
            k.a("dataBinding");
        }
        amVar5.f23601b.setOnRefreshListener(new C0464c(this));
        am amVar6 = this.f24286a;
        if (amVar6 == null) {
            k.a("dataBinding");
        }
        return amVar6.getRoot();
    }

    public static final class d extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f24293a;

        d(c cVar) {
            this.f24293a = cVar;
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            k.c(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            c.a(this.f24293a).isToolTipHidden().setValue(Boolean.valueOf(i2 != 0));
            if (i2 == 0) {
                c.b(this.f24293a);
                return;
            }
            ConstraintLayout constraintLayout = c.c(this.f24293a).f23600a.f23733d;
            k.a((Object) constraintLayout, "dataBinding.lytParentContainer.lytParentContainer");
            constraintLayout.setVisibility(8);
        }
    }

    /* renamed from: com.travel.flight.flightSRPV2.view.ui.b.b.c$c  reason: collision with other inner class name */
    static final class C0464c implements SwipeRefreshLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f24292a;

        C0464c(c cVar) {
            this.f24292a = cVar;
        }

        public final void onRefresh() {
            SwipeRefreshLayout swipeRefreshLayout = c.c(this.f24292a).f23601b;
            k.a((Object) swipeRefreshLayout, "this.dataBinding.pullToRefresh");
            swipeRefreshLayout.setRefreshing(false);
            SRPSharedViewModel a2 = c.a(this.f24292a);
            Context context = this.f24292a.getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            a2.refresh(context);
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((ConstraintLayout) a(R.id.container_filter_options)).setOnClickListener(new a(this));
        ((ConstraintLayout) a(R.id.container_filter_non_stop_flights)).setOnClickListener(new b(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f24290a;

        a(c cVar) {
            this.f24290a = cVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f24290a.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            if (activity.getSupportFragmentManager().c(R.id.container_full_overlay) instanceof a) {
                c.a(this.f24290a).onBackPressed();
            }
            c.a(this.f24290a).onFilterOptionsRequested();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f24291a;

        b(c cVar) {
            this.f24291a = cVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f24291a.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            if (activity.getSupportFragmentManager().c(R.id.container_full_overlay) instanceof a) {
                c.a(this.f24291a).onBackPressed();
            }
            c.d(this.f24291a).onNonStopFlightsFilterToggled();
        }
    }

    public static final /* synthetic */ void b(c cVar) {
        am amVar = cVar.f24286a;
        if (amVar == null) {
            k.a("dataBinding");
        }
        ConstraintLayout constraintLayout = amVar.f23600a.f23733d;
        k.a((Object) constraintLayout, "dataBinding.lytParentContainer.lytParentContainer");
        constraintLayout.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(cVar.getContext(), R.anim.flight_anim_slide_in_from_bottom);
        k.a((Object) loadAnimation, "AnimationUtils.loadAnima…nim_slide_in_from_bottom)");
        loadAnimation.setDuration(600);
        am amVar2 = cVar.f24286a;
        if (amVar2 == null) {
            k.a("dataBinding");
        }
        ConstraintLayout constraintLayout2 = amVar2.f23600a.f23733d;
        k.a((Object) constraintLayout2, "dataBinding.lytParentContainer.lytParentContainer");
        constraintLayout2.setAnimation(loadAnimation);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f24289d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
