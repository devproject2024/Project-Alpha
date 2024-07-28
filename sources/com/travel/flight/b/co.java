package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.a.x;
import com.travel.flight.flightSRPV2.a.z;

public abstract class co extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f23831a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23832b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23833c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23834d;

    /* renamed from: e  reason: collision with root package name */
    protected x f23835e;

    /* renamed from: f  reason: collision with root package name */
    protected z f23836f;

    /* renamed from: g  reason: collision with root package name */
    protected Integer f23837g;

    public abstract void a(x xVar);

    public abstract void a(z zVar);

    public abstract void a(Integer num);

    protected co(Object obj, View view, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        super(obj, view, 0);
        this.f23831a = constraintLayout;
        this.f23832b = imageView;
        this.f23833c = imageView2;
        this.f23834d = textView;
    }

    public static co a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (co) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pre_f_flight_filter_item_v2, viewGroup, false, f.a());
    }
}
