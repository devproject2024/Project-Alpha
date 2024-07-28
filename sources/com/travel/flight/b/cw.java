package com.travel.flight.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;

public abstract class cw extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f23867a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23868b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f23869c;

    /* renamed from: d  reason: collision with root package name */
    protected CJRFlightDetailsItem f23870d;

    /* renamed from: e  reason: collision with root package name */
    protected SRPOneWayViewModel f23871e;

    protected cw(Object obj, View view, TextView textView, TextView textView2, RecyclerView recyclerView) {
        super(obj, view, 1);
        this.f23867a = textView;
        this.f23868b = textView2;
        this.f23869c = recyclerView;
    }
}
