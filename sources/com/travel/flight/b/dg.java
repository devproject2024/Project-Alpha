package com.travel.flight.b;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;

public abstract class dg extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f23911a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23912b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23913c;

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f23914d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23915e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23916f;

    /* renamed from: g  reason: collision with root package name */
    protected CJRFlightDetailsItem f23917g;

    /* renamed from: h  reason: collision with root package name */
    protected Boolean f23918h;

    /* renamed from: i  reason: collision with root package name */
    protected SRPOneWayViewModel f23919i;

    protected dg(Object obj, View view, TextView textView, TextView textView2, TextView textView3, FrameLayout frameLayout, TextView textView4, TextView textView5) {
        super(obj, view, 3);
        this.f23911a = textView;
        this.f23912b = textView2;
        this.f23913c = textView3;
        this.f23914d = frameLayout;
        this.f23915e = textView4;
        this.f23916f = textView5;
    }
}
