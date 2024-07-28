package com.travel.flight.b;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.paytm.utility.RoboTextView;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public abstract class cs extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f23849a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23850b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23851c;

    /* renamed from: d  reason: collision with root package name */
    public final RoboTextView f23852d;

    /* renamed from: e  reason: collision with root package name */
    public final RoboTextView f23853e;

    /* renamed from: f  reason: collision with root package name */
    public final RoboTextView f23854f;

    /* renamed from: g  reason: collision with root package name */
    protected SRPSharedViewModel f23855g;

    public abstract void a(SRPSharedViewModel sRPSharedViewModel);

    protected cs(Object obj, View view, ImageView imageView, ImageView imageView2, ImageView imageView3, RoboTextView roboTextView, RoboTextView roboTextView2, RoboTextView roboTextView3) {
        super(obj, view, 1);
        this.f23849a = imageView;
        this.f23850b = imageView2;
        this.f23851c = imageView3;
        this.f23852d = roboTextView;
        this.f23853e = roboTextView2;
        this.f23854f = roboTextView3;
    }
}
