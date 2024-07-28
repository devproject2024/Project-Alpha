package com.travel.flight.b;

import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;

public abstract class bm extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f23712a;

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f23713b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f23714c;

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f23715d;

    /* renamed from: e  reason: collision with root package name */
    public final View f23716e;

    /* renamed from: f  reason: collision with root package name */
    public final View f23717f;

    /* renamed from: g  reason: collision with root package name */
    public final Switch f23718g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23719h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f23720i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final View m;
    protected SRPOneWayViewModel n;

    public abstract void a(SRPOneWayViewModel sRPOneWayViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected bm(Object obj, View view, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, View view2, View view3, Switch switchR, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view4) {
        super(obj, view, 2);
        Object obj2 = obj;
        View view5 = view;
        this.f23712a = constraintLayout;
        this.f23713b = constraintLayout2;
        this.f23714c = constraintLayout3;
        this.f23715d = constraintLayout4;
        this.f23716e = view2;
        this.f23717f = view3;
        this.f23718g = switchR;
        this.f23719h = textView;
        this.f23720i = textView2;
        this.j = textView3;
        this.k = textView4;
        this.l = textView5;
        this.m = view4;
    }
}
