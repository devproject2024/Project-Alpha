package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.viewHolder.CLPMerchantBannerVHWithoutRV;

public abstract class ItemMerchantBannerBinding extends ViewDataBinding {
    public final ImageView backButton;
    protected CLPMerchantBannerVHWithoutRV mClickHandler;
    protected View mView;
    public final TextView search;
    public final ImageView storeImage;
    public final TextView txvLocation;
    public final TextView txvName;

    public abstract void setClickHandler(CLPMerchantBannerVHWithoutRV cLPMerchantBannerVHWithoutRV);

    public abstract void setView(View view);

    protected ItemMerchantBannerBinding(e eVar, android.view.View view, int i2, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, TextView textView3) {
        super(eVar, view, i2);
        this.backButton = imageView;
        this.search = textView;
        this.storeImage = imageView2;
        this.txvLocation = textView2;
        this.txvName = textView3;
    }

    public View getView() {
        return this.mView;
    }

    public CLPMerchantBannerVHWithoutRV getClickHandler() {
        return this.mClickHandler;
    }

    public static ItemMerchantBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemMerchantBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemMerchantBannerBinding) f.a(layoutInflater, R.layout.item_merchant_banner, viewGroup, z, eVar);
    }

    public static ItemMerchantBannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemMerchantBannerBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemMerchantBannerBinding) f.a(layoutInflater, R.layout.item_merchant_banner, (ViewGroup) null, false, eVar);
    }

    public static ItemMerchantBannerBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static ItemMerchantBannerBinding bind(android.view.View view, e eVar) {
        return (ItemMerchantBannerBinding) bind(eVar, view, R.layout.item_merchant_banner);
    }
}
