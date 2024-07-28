package com.travel.flight.b;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;

public abstract class ci extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f23809a;

    /* renamed from: b  reason: collision with root package name */
    protected SRPOneWayViewModel f23810b;

    protected ci(Object obj, View view, RecyclerView recyclerView) {
        super(obj, view, 1);
        this.f23809a = recyclerView;
    }
}
