package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.a.ag;

public abstract class bs extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f23739a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23740b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23741c;

    /* renamed from: d  reason: collision with root package name */
    protected ag f23742d;

    public abstract void a(ag agVar);

    protected bs(Object obj, View view, ImageView imageView, ImageView imageView2, TextView textView) {
        super(obj, view, 0);
        this.f23739a = imageView;
        this.f23740b = imageView2;
        this.f23741c = textView;
    }

    public static bs a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (bs) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_srp_tool_tip, viewGroup, false, f.a());
    }
}
