package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.a.d;
import com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel;

public abstract class ce extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f23796a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23797b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23798c;

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f23799d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f23800e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23801f;

    /* renamed from: g  reason: collision with root package name */
    public final CheckBox f23802g;

    /* renamed from: h  reason: collision with root package name */
    protected d f23803h;

    /* renamed from: i  reason: collision with root package name */
    protected FlightFilterViewModel f23804i;

    protected ce(Object obj, View view, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout, ImageView imageView, TextView textView4, CheckBox checkBox) {
        super(obj, view, 1);
        this.f23796a = textView;
        this.f23797b = textView2;
        this.f23798c = textView3;
        this.f23799d = constraintLayout;
        this.f23800e = imageView;
        this.f23801f = textView4;
        this.f23802g = checkBox;
    }

    public static ce a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ce) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pre_f_airline_filter_item, viewGroup, false, f.a());
    }
}
