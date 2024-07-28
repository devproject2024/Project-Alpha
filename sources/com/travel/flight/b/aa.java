package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public abstract class aa extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f23545a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23546b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f23547c;

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f23548d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f23549e;

    /* renamed from: f  reason: collision with root package name */
    public final View f23550f;

    /* renamed from: g  reason: collision with root package name */
    protected SRPSharedViewModel f23551g;

    public abstract void a(SRPSharedViewModel sRPSharedViewModel);

    protected aa(Object obj, View view, TextView textView, TextView textView2, LinearLayout linearLayout, ConstraintLayout constraintLayout, LinearLayout linearLayout2, View view2) {
        super(obj, view, 3);
        this.f23545a = textView;
        this.f23546b = textView2;
        this.f23547c = linearLayout;
        this.f23548d = constraintLayout;
        this.f23549e = linearLayout2;
        this.f23550f = view2;
    }

    public static aa a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (aa) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_flight_drt_sort_home, viewGroup, false, f.a());
    }
}
