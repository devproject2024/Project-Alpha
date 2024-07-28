package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytm.ads.PaytmAdView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.adapter.SliderViewPagerAdapter;

public abstract class ItemVpH1BannerHomeBinding extends ViewDataBinding {
    protected SliderViewPagerAdapter mHandler;
    protected Item mItem;
    public final PaytmAdView viewpagerImage;

    public abstract void setHandler(SliderViewPagerAdapter sliderViewPagerAdapter);

    public abstract void setItem(Item item);

    protected ItemVpH1BannerHomeBinding(e eVar, View view, int i2, PaytmAdView paytmAdView) {
        super(eVar, view, i2);
        this.viewpagerImage = paytmAdView;
    }

    public Item getItem() {
        return this.mItem;
    }

    public SliderViewPagerAdapter getHandler() {
        return this.mHandler;
    }

    public static ItemVpH1BannerHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemVpH1BannerHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemVpH1BannerHomeBinding) f.a(layoutInflater, R.layout.item_vp_h1_banner_home, viewGroup, z, eVar);
    }

    public static ItemVpH1BannerHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemVpH1BannerHomeBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemVpH1BannerHomeBinding) f.a(layoutInflater, R.layout.item_vp_h1_banner_home, (ViewGroup) null, false, eVar);
    }

    public static ItemVpH1BannerHomeBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemVpH1BannerHomeBinding bind(View view, e eVar) {
        return (ItemVpH1BannerHomeBinding) bind(eVar, view, R.layout.item_vp_h1_banner_home);
    }
}
