package com.travel.flight.flightSRPV2.view.ui.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import com.travel.flight.b.ai;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public final class f extends h {

    /* renamed from: a  reason: collision with root package name */
    private ai f24314a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f24315b;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        ai a2 = ai.a(layoutInflater, viewGroup);
        k.a((Object) a2, "FragmentFlightNoNetworkV…flater, container, false)");
        this.f24314a = a2;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        androidx.lifecycle.ai a3 = am.a(activity).a(SRPSharedViewModel.class);
        k.a((Object) a3, "ViewModelProviders.of(ac…redViewModel::class.java)");
        SRPSharedViewModel sRPSharedViewModel = (SRPSharedViewModel) a3;
        ai aiVar = this.f24314a;
        if (aiVar == null) {
            k.a("dataBinding");
        }
        aiVar.a(sRPSharedViewModel);
        ai aiVar2 = this.f24314a;
        if (aiVar2 == null) {
            k.a("dataBinding");
        }
        aiVar2.setLifecycleOwner(getViewLifecycleOwner());
        ai aiVar3 = this.f24314a;
        if (aiVar3 == null) {
            k.a("dataBinding");
        }
        return aiVar3.getRoot();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f24315b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
