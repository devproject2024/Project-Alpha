package com.travel.flight.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.travel.flight.flightorder.j.j;
import net.one97.paytmflight.common.entity.flightticket.BundleCard;

public abstract class dq extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f23954a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23955b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23956c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23957d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23958e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23959f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23960g;

    /* renamed from: h  reason: collision with root package name */
    protected BundleCard f23961h;

    /* renamed from: i  reason: collision with root package name */
    protected j.a f23962i;

    public abstract void a(j.a aVar);

    public abstract void a(BundleCard bundleCard);

    protected dq(Object obj, View view, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, 0);
        this.f23954a = linearLayout;
        this.f23955b = textView;
        this.f23956c = textView2;
        this.f23957d = textView3;
        this.f23958e = textView4;
        this.f23959f = textView5;
        this.f23960g = textView6;
    }
}
