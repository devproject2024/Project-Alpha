package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CirclePageIndicator;
import com.paytmmall.clpartifact.view.adapter.SlidingViewPager;

public abstract class ItemH1BannerBinding extends ViewDataBinding {
    public final SlidingViewPager mallImagePager;
    public final CirclePageIndicator sliderPageIndicator;
    public final RelativeLayout viewPagerLayout;

    protected ItemH1BannerBinding(e eVar, View view, int i2, SlidingViewPager slidingViewPager, CirclePageIndicator circlePageIndicator, RelativeLayout relativeLayout) {
        super(eVar, view, i2);
        this.mallImagePager = slidingViewPager;
        this.sliderPageIndicator = circlePageIndicator;
        this.viewPagerLayout = relativeLayout;
    }

    public static ItemH1BannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemH1BannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemH1BannerBinding) f.a(layoutInflater, R.layout.item_h1_banner, viewGroup, z, eVar);
    }

    public static ItemH1BannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemH1BannerBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemH1BannerBinding) f.a(layoutInflater, R.layout.item_h1_banner, (ViewGroup) null, false, eVar);
    }

    public static ItemH1BannerBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemH1BannerBinding bind(View view, e eVar) {
        return (ItemH1BannerBinding) bind(eVar, view, R.layout.item_h1_banner);
    }
}
