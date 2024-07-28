package com.travel.flight.b;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.travel.flight.flightSRPV2.viewModel.NoFlightsFoundViewModel;

public abstract class g extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final Button f23972a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23973b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23974c;

    /* renamed from: d  reason: collision with root package name */
    protected NoFlightsFoundViewModel f23975d;

    public abstract void a(NoFlightsFoundViewModel noFlightsFoundViewModel);

    protected g(Object obj, View view, Button button, ImageView imageView, TextView textView) {
        super(obj, view, 2);
        this.f23972a = button;
        this.f23973b = imageView;
        this.f23974c = textView;
    }
}
