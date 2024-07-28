package net.one97.travelpass.b;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.tabs.TabLayout;
import com.one97.travelpass.custom.SlidingViewPager;

public abstract class bi extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TabLayout f30179a;

    /* renamed from: b  reason: collision with root package name */
    public final SlidingViewPager f30180b;

    protected bi(Object obj, View view, TabLayout tabLayout, SlidingViewPager slidingViewPager) {
        super(obj, view, 0);
        this.f30179a = tabLayout;
        this.f30180b = slidingViewPager;
    }
}
