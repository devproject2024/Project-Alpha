package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.viewModel.IRTViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public abstract class am extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final bq f23600a;

    /* renamed from: b  reason: collision with root package name */
    public final SwipeRefreshLayout f23601b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f23602c;

    /* renamed from: d  reason: collision with root package name */
    protected SRPSharedViewModel f23603d;

    /* renamed from: e  reason: collision with root package name */
    protected IRTViewModel f23604e;

    public abstract void a(IRTViewModel iRTViewModel);

    public abstract void a(SRPSharedViewModel sRPSharedViewModel);

    protected am(Object obj, View view, bq bqVar, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView) {
        super(obj, view, 2);
        this.f23600a = bqVar;
        setContainedBinding(this.f23600a);
        this.f23601b = swipeRefreshLayout;
        this.f23602c = recyclerView;
    }

    public static am a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (am) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_international_round_trip, viewGroup, false, f.a());
    }
}
