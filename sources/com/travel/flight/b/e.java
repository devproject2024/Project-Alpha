package com.travel.flight.b;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytmflight.common.entity.prioritycheckinentity.a;

public abstract class e extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f23963a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f23964b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23965c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23966d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23967e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23968f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23969g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f23970h;

    /* renamed from: i  reason: collision with root package name */
    public final LottieAnimationView f23971i;
    public final RelativeLayout j;
    public final Toolbar k;
    public final ImageView l;
    protected a m;

    public abstract void a(a aVar);

    protected e(Object obj, View view, LinearLayout linearLayout, Button button, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView2, LottieAnimationView lottieAnimationView, RelativeLayout relativeLayout, Toolbar toolbar, ImageView imageView3) {
        super(obj, view, 0);
        this.f23963a = linearLayout;
        this.f23964b = button;
        this.f23965c = imageView;
        this.f23966d = textView;
        this.f23967e = textView2;
        this.f23968f = textView3;
        this.f23969g = textView4;
        this.f23970h = imageView2;
        this.f23971i = lottieAnimationView;
        this.j = relativeLayout;
        this.k = toolbar;
        this.l = imageView3;
    }
}
