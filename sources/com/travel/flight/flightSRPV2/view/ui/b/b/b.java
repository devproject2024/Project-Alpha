package com.travel.flight.flightSRPV2.view.ui.b.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.travel.flight.b.ao;
import com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.flightSRPV2.viewModel.factory.SRPViewModelFactory;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public final class b extends h {

    /* renamed from: a  reason: collision with root package name */
    private ao f24282a;

    /* renamed from: b  reason: collision with root package name */
    private SRPSharedViewModel f24283b;

    /* renamed from: c  reason: collision with root package name */
    private IRTSplitViewModel f24284c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f24285d;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        ao a2 = ao.a(layoutInflater, viewGroup);
        k.a((Object) a2, "FragmentIrtSplitViewBind…flater, container, false)");
        this.f24282a = a2;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        ai a3 = am.a(activity).a(SRPSharedViewModel.class);
        k.a((Object) a3, "ViewModelProviders.of(ac…redViewModel::class.java)");
        this.f24283b = (SRPSharedViewModel) a3;
        Fragment fragment = this;
        SRPSharedViewModel sRPSharedViewModel = this.f24283b;
        if (sRPSharedViewModel == null) {
            k.a("parentViewModel");
        }
        ai a4 = am.a(fragment, (al.b) new SRPViewModelFactory(sRPSharedViewModel, false, 2, (g) null)).a(IRTSplitViewModel.class);
        k.a((Object) a4, "ViewModelProviders.of(th…litViewModel::class.java)");
        this.f24284c = (IRTSplitViewModel) a4;
        ao aoVar = this.f24282a;
        if (aoVar == null) {
            k.a("dataBinding");
        }
        SRPSharedViewModel sRPSharedViewModel2 = this.f24283b;
        if (sRPSharedViewModel2 == null) {
            k.a("parentViewModel");
        }
        aoVar.a(sRPSharedViewModel2);
        ao aoVar2 = this.f24282a;
        if (aoVar2 == null) {
            k.a("dataBinding");
        }
        IRTSplitViewModel iRTSplitViewModel = this.f24284c;
        if (iRTSplitViewModel == null) {
            k.a("irtSplitViewModel");
        }
        aoVar2.a(iRTSplitViewModel);
        ao aoVar3 = this.f24282a;
        if (aoVar3 == null) {
            k.a("dataBinding");
        }
        aoVar3.setLifecycleOwner(getViewLifecycleOwner());
        ao aoVar4 = this.f24282a;
        if (aoVar4 == null) {
            k.a("dataBinding");
        }
        return aoVar4.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ao aoVar = this.f24282a;
        if (aoVar == null) {
            k.a("dataBinding");
        }
        aoVar.a("onward_revamp.png");
        ao aoVar2 = this.f24282a;
        if (aoVar2 == null) {
            k.a("dataBinding");
        }
        aoVar2.b("return_revamp.png");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f24285d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
