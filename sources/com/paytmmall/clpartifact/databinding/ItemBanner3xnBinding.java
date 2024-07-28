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
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;

public abstract class ItemBanner3xnBinding extends ViewDataBinding {
    public final PaytmAdView avatar;
    protected CLPItemRVViewHolder mHandler;
    protected Item mItem;
    protected Integer mPosition;

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemBanner3xnBinding(e eVar, View view, int i2, PaytmAdView paytmAdView) {
        super(eVar, view, i2);
        this.avatar = paytmAdView;
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

    public static ItemBanner3xnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemBanner3xnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemBanner3xnBinding) f.a(layoutInflater, R.layout.item_banner_3xn, viewGroup, z, eVar);
    }

    public static ItemBanner3xnBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemBanner3xnBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemBanner3xnBinding) f.a(layoutInflater, R.layout.item_banner_3xn, (ViewGroup) null, false, eVar);
    }

    public static ItemBanner3xnBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemBanner3xnBinding bind(View view, e eVar) {
        return (ItemBanner3xnBinding) bind(eVar, view, R.layout.item_banner_3xn);
    }
}
