package net.one97.travelpass.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.tabs.TabLayout;
import com.one97.travelpass.custom.SlidingViewPager;

public abstract class bm extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f30191a;

    /* renamed from: b  reason: collision with root package name */
    public final TabLayout f30192b;

    /* renamed from: c  reason: collision with root package name */
    public final SlidingViewPager f30193c;

    protected bm(Object obj, View view, TextView textView, TabLayout tabLayout, SlidingViewPager slidingViewPager) {
        super(obj, view, 0);
        this.f30191a = textView;
        this.f30192b = tabLayout;
        this.f30193c = slidingViewPager;
    }
}
