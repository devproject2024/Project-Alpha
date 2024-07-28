package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytm.ads.PaytmAdView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPCarouselItem_1_3;

public abstract class ItemCarousel13Binding extends ViewDataBinding {
    public final ConstraintLayout carousel13Container;
    public final PaytmAdView carousel13Image;
    protected CLPCarouselItem_1_3 mHandler;
    protected Item mItem;
    protected Integer mPosition;

    public abstract void setHandler(CLPCarouselItem_1_3 cLPCarouselItem_1_3);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemCarousel13Binding(e eVar, View view, int i2, ConstraintLayout constraintLayout, PaytmAdView paytmAdView) {
        super(eVar, view, i2);
        this.carousel13Container = constraintLayout;
        this.carousel13Image = paytmAdView;
    }

    public Item getItem() {
        return this.mItem;
    }

    public CLPCarouselItem_1_3 getHandler() {
        return this.mHandler;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static ItemCarousel13Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemCarousel13Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemCarousel13Binding) f.a(layoutInflater, R.layout.item_carousel_1_3, viewGroup, z, eVar);
    }

    public static ItemCarousel13Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemCarousel13Binding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemCarousel13Binding) f.a(layoutInflater, R.layout.item_carousel_1_3, (ViewGroup) null, false, eVar);
    }

    public static ItemCarousel13Binding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemCarousel13Binding bind(View view, e eVar) {
        return (ItemCarousel13Binding) bind(eVar, view, R.layout.item_carousel_1_3);
    }
}
