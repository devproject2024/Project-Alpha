package com.travel.flight.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.paytm.utility.RoboTextView;
import com.travel.flight.flightSRPV2.viewModel.DRTListViewModel;

public abstract class bi extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RoboTextView f23697a;

    /* renamed from: b  reason: collision with root package name */
    public final RoboTextView f23698b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f23699c;

    /* renamed from: d  reason: collision with root package name */
    public final RoboTextView f23700d;

    /* renamed from: e  reason: collision with root package name */
    public final ConstraintLayout f23701e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f23702f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f23703g;

    /* renamed from: h  reason: collision with root package name */
    public final RoboTextView f23704h;

    /* renamed from: i  reason: collision with root package name */
    public final RoboTextView f23705i;
    public final View j;
    protected DRTListViewModel k;

    public abstract void a(DRTListViewModel dRTListViewModel);

    protected bi(Object obj, View view, RoboTextView roboTextView, RoboTextView roboTextView2, RelativeLayout relativeLayout, RoboTextView roboTextView3, ConstraintLayout constraintLayout, LinearLayout linearLayout, RelativeLayout relativeLayout2, RoboTextView roboTextView4, RoboTextView roboTextView5, View view2) {
        super(obj, view, 2);
        this.f23697a = roboTextView;
        this.f23698b = roboTextView2;
        this.f23699c = relativeLayout;
        this.f23700d = roboTextView3;
        this.f23701e = constraintLayout;
        this.f23702f = linearLayout;
        this.f23703g = relativeLayout2;
        this.f23704h = roboTextView4;
        this.f23705i = roboTextView5;
        this.j = view2;
    }
}
