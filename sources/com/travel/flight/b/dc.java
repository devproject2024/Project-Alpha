package com.travel.flight.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;

public abstract class dc extends ViewDataBinding {
    public final TextView A;
    public final TextView B;
    protected CJRFlightDetailsItem C;
    protected SRPOneWayViewModel D;

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f23893a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23894b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f23895c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f23896d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23897e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f23898f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23899g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23900h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f23901i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final View q;
    public final ImageView r;
    public final ImageView s;
    public final ImageView t;
    public final View u;
    public final TextView v;
    public final TextView w;
    public final View x;
    public final View y;
    public final TextView z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected dc(Object obj, View view, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, ImageView imageView, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, View view2, ImageView imageView3, ImageView imageView4, ImageView imageView5, View view3, TextView textView13, TextView textView14, View view4, View view5, TextView textView15, TextView textView16, TextView textView17) {
        super(obj, view, 0);
        Object obj2 = obj;
        View view6 = view;
        this.f23893a = linearLayout;
        this.f23894b = textView;
        this.f23895c = linearLayout2;
        this.f23896d = imageView;
        this.f23897e = textView2;
        this.f23898f = imageView2;
        this.f23899g = textView3;
        this.f23900h = textView4;
        this.f23901i = textView5;
        this.j = textView6;
        this.k = textView7;
        this.l = textView8;
        this.m = textView9;
        this.n = textView10;
        this.o = textView11;
        this.p = textView12;
        this.q = view2;
        this.r = imageView3;
        this.s = imageView4;
        this.t = imageView5;
        this.u = view3;
        this.v = textView13;
        this.w = textView14;
        this.x = view4;
        this.y = view5;
        this.z = textView15;
        this.A = textView16;
        this.B = textView17;
    }
}
