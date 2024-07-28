package com.travel.flight.flightSRPV2.view.ui.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import com.travel.flight.b.aq;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import java.util.HashMap;
import kotlin.g.b.k;

public final class g extends d {

    /* renamed from: a  reason: collision with root package name */
    private aq f24316a;

    /* renamed from: b  reason: collision with root package name */
    private SRPSharedViewModel f24317b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f24318c;

    public final void a() {
        HashMap hashMap = this.f24318c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        aq a2 = aq.a(layoutInflater, viewGroup);
        k.a((Object) a2, "FragmentSrpLoadingBindin…nflater, container,false)");
        this.f24316a = a2;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        ai a3 = am.a(activity).a(SRPSharedViewModel.class);
        k.a((Object) a3, "ViewModelProviders.of(ac…redViewModel::class.java)");
        this.f24317b = (SRPSharedViewModel) a3;
        aq aqVar = this.f24316a;
        if (aqVar == null) {
            k.a("dataBinding");
        }
        aqVar.setLifecycleOwner(getViewLifecycleOwner());
        aq aqVar2 = this.f24316a;
        if (aqVar2 == null) {
            k.a("dataBinding");
        }
        SRPSharedViewModel sRPSharedViewModel = this.f24317b;
        if (sRPSharedViewModel == null) {
            k.a("parentViewModel");
        }
        aqVar2.a(sRPSharedViewModel);
        aq aqVar3 = this.f24316a;
        if (aqVar3 == null) {
            k.a("dataBinding");
        }
        return aqVar3.getRoot();
    }
}
