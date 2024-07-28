package com.travel.flight.b;

import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.travel.flight.flightSRPV2.viewModel.IRTViewModel;

public abstract class bq extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f23730a;

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f23731b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f23732c;

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f23733d;

    /* renamed from: e  reason: collision with root package name */
    public final View f23734e;

    /* renamed from: f  reason: collision with root package name */
    public final View f23735f;

    /* renamed from: g  reason: collision with root package name */
    public final Switch f23736g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23737h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f23738i;
    public final TextView j;
    public final View k;
    protected IRTViewModel l;

    public abstract void a(IRTViewModel iRTViewModel);

    protected bq(Object obj, View view, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, View view2, View view3, Switch switchR, TextView textView, TextView textView2, TextView textView3, View view4) {
        super(obj, view, 3);
        this.f23730a = constraintLayout;
        this.f23731b = constraintLayout2;
        this.f23732c = constraintLayout3;
        this.f23733d = constraintLayout4;
        this.f23734e = view2;
        this.f23735f = view3;
        this.f23736g = switchR;
        this.f23737h = textView;
        this.f23738i = textView2;
        this.j = textView3;
        this.k = view4;
    }
}
