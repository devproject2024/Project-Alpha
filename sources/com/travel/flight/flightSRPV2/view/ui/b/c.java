package com.travel.flight.flightSRPV2.view.ui.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.travel.flight.R;
import com.travel.flight.views.ShimmerFrameLayout;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public final class c extends h {

    /* renamed from: a  reason: collision with root package name */
    private ShimmerFrameLayout f24294a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f24295b;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_flight_srp_shimmer, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.shimmer_layout);
        k.a((Object) findViewById, "view.findViewById(R.id.shimmer_layout)");
        this.f24294a = (ShimmerFrameLayout) findViewById;
        return inflate;
    }

    public final void onResume() {
        super.onResume();
        ShimmerFrameLayout shimmerFrameLayout = this.f24294a;
        if (shimmerFrameLayout == null) {
            k.a("shimmerLayout");
        }
        shimmerFrameLayout.a();
    }

    public final void onPause() {
        super.onPause();
        ShimmerFrameLayout shimmerFrameLayout = this.f24294a;
        if (shimmerFrameLayout == null) {
            k.a("shimmerLayout");
        }
        shimmerFrameLayout.b();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f24295b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
