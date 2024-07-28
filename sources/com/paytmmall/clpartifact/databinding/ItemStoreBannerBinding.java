package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.viewHolder.CLPStoreBannerVHWithoutRV;

public abstract class ItemStoreBannerBinding extends ViewDataBinding {
    public final ImageView BrandLogo;
    public final ImageView backButton;
    public final TextView follow;
    public final Group group;
    protected CLPStoreBannerVHWithoutRV mHandler;
    protected View mView;
    public final TextView rating;
    public final ImageView star;
    public final TextView storeName;
    public final TextView txvName;
    public final TextView viewAllStores;

    public abstract void setHandler(CLPStoreBannerVHWithoutRV cLPStoreBannerVHWithoutRV);

    public abstract void setView(View view);

    protected ItemStoreBannerBinding(e eVar, android.view.View view, int i2, ImageView imageView, ImageView imageView2, TextView textView, Group group2, TextView textView2, ImageView imageView3, TextView textView3, TextView textView4, TextView textView5) {
        super(eVar, view, i2);
        this.BrandLogo = imageView;
        this.backButton = imageView2;
        this.follow = textView;
        this.group = group2;
        this.rating = textView2;
        this.star = imageView3;
        this.storeName = textView3;
        this.txvName = textView4;
        this.viewAllStores = textView5;
    }

    public View getView() {
        return this.mView;
    }

    public CLPStoreBannerVHWithoutRV getHandler() {
        return this.mHandler;
    }

    public static ItemStoreBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemStoreBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemStoreBannerBinding) f.a(layoutInflater, R.layout.item_store_banner, viewGroup, z, eVar);
    }

    public static ItemStoreBannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemStoreBannerBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemStoreBannerBinding) f.a(layoutInflater, R.layout.item_store_banner, (ViewGroup) null, false, eVar);
    }

    public static ItemStoreBannerBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static ItemStoreBannerBinding bind(android.view.View view, e eVar) {
        return (ItemStoreBannerBinding) bind(eVar, view, R.layout.item_store_banner);
    }
}
