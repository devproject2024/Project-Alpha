package com.travel.flight.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.paytm.utility.RoboTextView;
import com.travel.flight.flightSRPV2.a.d;

public abstract class i extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f23981a;

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f23982b;

    /* renamed from: c  reason: collision with root package name */
    public final RoboTextView f23983c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23984d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23985e;

    /* renamed from: f  reason: collision with root package name */
    protected d f23986f;

    public abstract void a(d dVar);

    protected i(Object obj, View view, ImageView imageView, ConstraintLayout constraintLayout, RoboTextView roboTextView, TextView textView, TextView textView2) {
        super(obj, view, 1);
        this.f23981a = imageView;
        this.f23982b = constraintLayout;
        this.f23983c = roboTextView;
        this.f23984d = textView;
        this.f23985e = textView2;
    }
}
