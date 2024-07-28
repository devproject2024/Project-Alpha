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

public abstract class ItemBannFullWidthBinding extends ViewDataBinding {
    public final PaytmAdView avatar;
    protected SliderViewPagerAdapter mHandler;
    protected Item mItem;

    public abstract void setHandler(SliderViewPagerAdapter sliderViewPagerAdapter);

    public abstract void setItem(Item item);

    protected ItemBannFullWidthBinding(e eVar, View view, int i2, PaytmAdView paytmAdView) {
        super(eVar, view, i2);
        this.avatar = paytmAdView;
    }

    public Item getItem() {
        return this.mItem;
    }

    public SliderViewPagerAdapter getHandler() {
        return this.mHandler;
    }

    public static ItemBannFullWidthBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemBannFullWidthBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemBannFullWidthBinding) f.a(layoutInflater, R.layout.item_bann_full_width, viewGroup, z, eVar);
    }

    public static ItemBannFullWidthBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemBannFullWidthBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemBannFullWidthBinding) f.a(layoutInflater, R.layout.item_bann_full_width, (ViewGroup) null, false, eVar);
    }

    public static ItemBannFullWidthBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemBannFullWidthBinding bind(View view, e eVar) {
        return (ItemBannFullWidthBinding) bind(eVar, view, R.layout.item_bann_full_width);
    }
}
