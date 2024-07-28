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

public abstract class ItemSquareBannerBinding extends ViewDataBinding {
    protected CLPItemRVViewHolder mHandler;
    protected Item mItem;
    protected Integer mPosition;

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemSquareBannerBinding(e eVar, View view, int i2) {
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

    public static ItemSquareBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemSquareBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemSquareBannerBinding) f.a(layoutInflater, R.layout.item_square_banner, viewGroup, z, eVar);
    }

    public static ItemSquareBannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemSquareBannerBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemSquareBannerBinding) f.a(layoutInflater, R.layout.item_square_banner, (ViewGroup) null, false, eVar);
    }

    public static ItemSquareBannerBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemSquareBannerBinding bind(View view, e eVar) {
        return (ItemSquareBannerBinding) bind(eVar, view, R.layout.item_square_banner);
    }
}
