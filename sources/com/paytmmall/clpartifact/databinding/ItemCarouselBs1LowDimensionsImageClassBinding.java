package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;

public abstract class ItemCarouselBs1LowDimensionsImageClassBinding extends ViewDataBinding {
    protected CLPItemRVViewHolder mHandler;
    protected Item mItem;
    protected Integer mPosition;

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemCarouselBs1LowDimensionsImageClassBinding(e eVar, View view, int i2) {
        super(eVar, view, i2);
    }

    public Item getItem() {
        return this.mItem;
    }

    public CLPItemRVViewHolder getHandler() {
        return this.mHandler;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static ItemCarouselBs1LowDimensionsImageClassBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemCarouselBs1LowDimensionsImageClassBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemCarouselBs1LowDimensionsImageClassBinding) f.a(layoutInflater, R.layout.item_carousel_bs1_low_dimensions_image_class, viewGroup, z, eVar);
    }

    public static ItemCarouselBs1LowDimensionsImageClassBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemCarouselBs1LowDimensionsImageClassBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemCarouselBs1LowDimensionsImageClassBinding) f.a(layoutInflater, R.layout.item_carousel_bs1_low_dimensions_image_class, (ViewGroup) null, false, eVar);
    }

    public static ItemCarouselBs1LowDimensionsImageClassBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemCarouselBs1LowDimensionsImageClassBinding bind(View view, e eVar) {
        return (ItemCarouselBs1LowDimensionsImageClassBinding) bind(eVar, view, R.layout.item_carousel_bs1_low_dimensions_image_class);
    }
}
