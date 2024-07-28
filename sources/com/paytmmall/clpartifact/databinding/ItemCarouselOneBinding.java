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

public abstract class ItemCarouselOneBinding extends ViewDataBinding {
    protected CLPItemRVViewHolder mHandler;
    protected Item mItem;
    protected Integer mPosition;

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemCarouselOneBinding(e eVar, View view, int i2) {
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

    public static ItemCarouselOneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemCarouselOneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemCarouselOneBinding) f.a(layoutInflater, R.layout.item_carousel_one, viewGroup, z, eVar);
    }

    public static ItemCarouselOneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemCarouselOneBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemCarouselOneBinding) f.a(layoutInflater, R.layout.item_carousel_one, (ViewGroup) null, false, eVar);
    }

    public static ItemCarouselOneBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemCarouselOneBinding bind(View view, e eVar) {
        return (ItemCarouselOneBinding) bind(eVar, view, R.layout.item_carousel_one);
    }
}
