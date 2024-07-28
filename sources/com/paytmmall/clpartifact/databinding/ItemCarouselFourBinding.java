package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;

public abstract class ItemCarouselFourBinding extends ViewDataBinding {
    public final ImageView image1;
    protected CLPItemRVViewHolder mHandler;
    protected Item mItem;
    protected Integer mPosition;

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemCarouselFourBinding(e eVar, View view, int i2, ImageView imageView) {
        super(eVar, view, i2);
        this.image1 = imageView;
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

    public static ItemCarouselFourBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemCarouselFourBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemCarouselFourBinding) f.a(layoutInflater, R.layout.item_carousel_four, viewGroup, z, eVar);
    }

    public static ItemCarouselFourBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemCarouselFourBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemCarouselFourBinding) f.a(layoutInflater, R.layout.item_carousel_four, (ViewGroup) null, false, eVar);
    }

    public static ItemCarouselFourBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemCarouselFourBinding bind(View view, e eVar) {
        return (ItemCarouselFourBinding) bind(eVar, view, R.layout.item_carousel_four);
    }
}
