package com.travel.flight.b;

import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.travel.flight.flightSRPV2.viewModel.DRTListViewModel;

public abstract class bo extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f23721a;

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f23722b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f23723c;

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f23724d;

    /* renamed from: e  reason: collision with root package name */
    public final View f23725e;

    /* renamed from: f  reason: collision with root package name */
    public final View f23726f;

    /* renamed from: g  reason: collision with root package name */
    public final Switch f23727g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23728h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f23729i;
    public final TextView j;
    public final View k;
    protected DRTListViewModel l;

    public abstract void a(DRTListViewModel dRTListViewModel);

    protected bo(Object obj, View view, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, View view2, View view3, Switch switchR, TextView textView, TextView textView2, TextView textView3, View view4) {
        super(obj, view, 4);
        this.f23721a = constraintLayout;
        this.f23722b = constraintLayout2;
        this.f23723c = constraintLayout3;
        this.f23724d = constraintLayout4;
        this.f23725e = view2;
        this.f23726f = view3;
        this.f23727g = switchR;
        this.f23728h = textView;
        this.f23729i = textView2;
        this.j = textView3;
        this.k = view4;
    }
}
