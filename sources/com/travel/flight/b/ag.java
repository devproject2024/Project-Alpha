package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public abstract class ag extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f23573a;

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f23574b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f23575c;

    /* renamed from: d  reason: collision with root package name */
    public final View f23576d;

    /* renamed from: e  reason: collision with root package name */
    protected SRPSharedViewModel f23577e;

    public abstract void a(SRPSharedViewModel sRPSharedViewModel);

    protected ag(Object obj, View view, LinearLayout linearLayout, ConstraintLayout constraintLayout, LinearLayout linearLayout2, View view2) {
        super(obj, view, 2);
        this.f23573a = linearLayout;
        this.f23574b = constraintLayout;
        this.f23575c = linearLayout2;
        this.f23576d = view2;
    }

    public static ag a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ag) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_flight_irt_sort_home, viewGroup, false, f.a());
    }
}
