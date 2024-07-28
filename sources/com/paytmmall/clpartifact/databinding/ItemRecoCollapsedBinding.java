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
import com.paytmmall.clpartifact.view.viewHolder.CLPRecoItemVH;

public abstract class ItemRecoCollapsedBinding extends ViewDataBinding {
    public final ImageView imageLL;
    protected CLPRecoItemVH mHandler;
    protected Item mItem;
    protected Integer mPosition;

    public abstract void setHandler(CLPRecoItemVH cLPRecoItemVH);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemRecoCollapsedBinding(e eVar, View view, int i2, ImageView imageView) {
        super(eVar, view, i2);
        this.imageLL = imageView;
    }

    public Item getItem() {
        return this.mItem;
    }

    public CLPRecoItemVH getHandler() {
        return this.mHandler;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static ItemRecoCollapsedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemRecoCollapsedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemRecoCollapsedBinding) f.a(layoutInflater, R.layout.item_reco_collapsed, viewGroup, z, eVar);
    }

    public static ItemRecoCollapsedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemRecoCollapsedBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemRecoCollapsedBinding) f.a(layoutInflater, R.layout.item_reco_collapsed, (ViewGroup) null, false, eVar);
    }

    public static ItemRecoCollapsedBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemRecoCollapsedBinding bind(View view, e eVar) {
        return (ItemRecoCollapsedBinding) bind(eVar, view, R.layout.item_reco_collapsed);
    }
}
