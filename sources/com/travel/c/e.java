package com.travel.c;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.airbnb.lottie.LottieAnimationView;
import com.travel.booking.e.a;

public abstract class e extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final a f22872a;

    /* renamed from: b  reason: collision with root package name */
    public final LottieAnimationView f22873b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewPager f22874c;

    /* renamed from: d  reason: collision with root package name */
    protected a f22875d;

    public abstract void a(a aVar);

    protected e(Object obj, View view, a aVar, LottieAnimationView lottieAnimationView, ViewPager viewPager) {
        super(obj, view, 2);
        this.f22872a = aVar;
        setContainedBinding(this.f22872a);
        this.f22873b = lottieAnimationView;
        this.f22874c = viewPager;
    }
}
