package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CirclePageIndicator;
import com.paytmmall.clpartifact.view.SFCustomPager;

public abstract class ItemH1BannerHomeBannerBinding extends ViewDataBinding {
    public final SFCustomPager mallImagePager;
    public final CirclePageIndicator sliderPageIndicator;
    public final ConstraintLayout viewPagerLayout;

    protected ItemH1BannerHomeBannerBinding(e eVar, View view, int i2, SFCustomPager sFCustomPager, CirclePageIndicator circlePageIndicator, ConstraintLayout constraintLayout) {
        super(eVar, view, i2);
        this.mallImagePager = sFCustomPager;
        this.sliderPageIndicator = circlePageIndicator;
        this.viewPagerLayout = constraintLayout;
    }

    public static ItemH1BannerHomeBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemH1BannerHomeBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemH1BannerHomeBannerBinding) f.a(layoutInflater, R.layout.item_h1_banner_home_banner, viewGroup, z, eVar);
    }

    public static ItemH1BannerHomeBannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemH1BannerHomeBannerBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemH1BannerHomeBannerBinding) f.a(layoutInflater, R.layout.item_h1_banner_home_banner, (ViewGroup) null, false, eVar);
    }

    public static ItemH1BannerHomeBannerBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemH1BannerHomeBannerBinding bind(View view, e eVar) {
        return (ItemH1BannerHomeBannerBinding) bind(eVar, view, R.layout.item_h1_banner_home_banner);
    }
}
