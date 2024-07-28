package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public abstract class ai extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final Button f23582a;

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f23583b;

    /* renamed from: c  reason: collision with root package name */
    public final RoboTextView f23584c;

    /* renamed from: d  reason: collision with root package name */
    public final RoboTextView f23585d;

    /* renamed from: e  reason: collision with root package name */
    protected SRPSharedViewModel f23586e;

    public abstract void a(SRPSharedViewModel sRPSharedViewModel);

    protected ai(Object obj, View view, Button button, ConstraintLayout constraintLayout, RoboTextView roboTextView, RoboTextView roboTextView2) {
        super(obj, view, 0);
        this.f23582a = button;
        this.f23583b = constraintLayout;
        this.f23584c = roboTextView;
        this.f23585d = roboTextView2;
    }

    public static ai a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ai) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_flight_no_network_v2, viewGroup, false, f.a());
    }
}
