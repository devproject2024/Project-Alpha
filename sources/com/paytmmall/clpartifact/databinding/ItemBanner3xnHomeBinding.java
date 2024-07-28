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

public abstract class ItemBanner3xnHomeBinding extends ViewDataBinding {
    public final ImageView avatar;
    protected CLPItemRVViewHolder mHandler;
    protected Item mItem;
    protected Integer mPosition;

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemBanner3xnHomeBinding(e eVar, View view, int i2, ImageView imageView) {
        super(eVar, view, i2);
        this.avatar = imageView;
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

    public static ItemBanner3xnHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemBanner3xnHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemBanner3xnHomeBinding) f.a(layoutInflater, R.layout.item_banner_3xn_home, viewGroup, z, eVar);
    }

    public static ItemBanner3xnHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemBanner3xnHomeBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemBanner3xnHomeBinding) f.a(layoutInflater, R.layout.item_banner_3xn_home, (ViewGroup) null, false, eVar);
    }

    public static ItemBanner3xnHomeBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemBanner3xnHomeBinding bind(View view, e eVar) {
        return (ItemBanner3xnHomeBinding) bind(eVar, view, R.layout.item_banner_3xn_home);
    }
}
