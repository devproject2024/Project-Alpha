package com.travel.flight.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.paytm.utility.RoboTextView;
import com.travel.flight.flightSRPV2.viewModel.DRTListViewModel;
import com.travel.flight.pojo.flightticket.CJRDiscountedStrip;
import java.util.ArrayList;

public abstract class aw extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f23645a;

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f23646b;

    /* renamed from: c  reason: collision with root package name */
    public final RoboTextView f23647c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23648d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23649e;

    /* renamed from: f  reason: collision with root package name */
    protected DRTListViewModel f23650f;

    /* renamed from: g  reason: collision with root package name */
    protected CJRDiscountedStrip f23651g;

    /* renamed from: h  reason: collision with root package name */
    protected ArrayList<String> f23652h;

    protected aw(Object obj, View view, ImageView imageView, ConstraintLayout constraintLayout, RoboTextView roboTextView, TextView textView, TextView textView2) {
        super(obj, view, 0);
        this.f23645a = imageView;
        this.f23646b = constraintLayout;
        this.f23647c = roboTextView;
        this.f23648d = textView;
        this.f23649e = textView2;
    }
}
