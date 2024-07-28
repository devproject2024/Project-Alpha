package com.travel.flight.b;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.paytm.utility.RoboTextView;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public abstract class c extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final cq f23772a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f23773b;

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f23774c;

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f23775d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f23776e;

    /* renamed from: f  reason: collision with root package name */
    public final RoboTextView f23777f;

    /* renamed from: g  reason: collision with root package name */
    public final RoboTextView f23778g;

    /* renamed from: h  reason: collision with root package name */
    protected SRPSharedViewModel f23779h;

    public abstract void a(SRPSharedViewModel sRPSharedViewModel);

    protected c(Object obj, View view, cq cqVar, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, LinearLayout linearLayout, RoboTextView roboTextView, RoboTextView roboTextView2) {
        super(obj, view, 4);
        this.f23772a = cqVar;
        setContainedBinding(this.f23772a);
        this.f23773b = frameLayout;
        this.f23774c = frameLayout2;
        this.f23775d = frameLayout3;
        this.f23776e = linearLayout;
        this.f23777f = roboTextView;
        this.f23778g = roboTextView2;
    }
}
