package com.travel.flight.b;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;

public abstract class da extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f23884a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23885b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23886c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23887d;

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f23888e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23889f;

    /* renamed from: g  reason: collision with root package name */
    protected CJRFlightDetailsItem f23890g;

    /* renamed from: h  reason: collision with root package name */
    protected SRPOneWayViewModel f23891h;

    protected da(Object obj, View view, TextView textView, TextView textView2, TextView textView3, TextView textView4, FrameLayout frameLayout, TextView textView5) {
        super(obj, view, 2);
        this.f23884a = textView;
        this.f23885b = textView2;
        this.f23886c = textView3;
        this.f23887d = textView4;
        this.f23888e = frameLayout;
        this.f23889f = textView5;
    }
}
