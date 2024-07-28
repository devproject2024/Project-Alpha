package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public abstract class ak extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RoboTextView f23591a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f23592b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f23593c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f23594d;

    /* renamed from: e  reason: collision with root package name */
    public final View f23595e;

    /* renamed from: f  reason: collision with root package name */
    protected SRPSharedViewModel f23596f;

    public abstract void a(SRPSharedViewModel sRPSharedViewModel);

    protected ak(Object obj, View view, RoboTextView roboTextView, LinearLayout linearLayout, ConstraintLayout constraintLayout, LinearLayout linearLayout2, View view2) {
        super(obj, view, 1);
        this.f23591a = roboTextView;
        this.f23592b = linearLayout;
        this.f23593c = constraintLayout;
        this.f23594d = linearLayout2;
        this.f23595e = view2;
    }

    public static ak a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ak) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_flight_one_way_sort_home, viewGroup, false, f.a());
    }
}
