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
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;

public abstract class LytThinBannerSmallBinding extends ViewDataBinding {
    public final PaytmAdView avatar;
    protected CLPItemRVViewHolder mHandler;
    protected Item mItem;
    protected Integer mPosition;
    public final ConstraintLayout viewPagerLayout;

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected LytThinBannerSmallBinding(e eVar, View view, int i2, PaytmAdView paytmAdView, ConstraintLayout constraintLayout) {
        super(eVar, view, i2);
        this.avatar = paytmAdView;
        this.viewPagerLayout = constraintLayout;
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

    public static LytThinBannerSmallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static LytThinBannerSmallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (LytThinBannerSmallBinding) f.a(layoutInflater, R.layout.lyt_thin_banner_small, viewGroup, z, eVar);
    }

    public static LytThinBannerSmallBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static LytThinBannerSmallBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (LytThinBannerSmallBinding) f.a(layoutInflater, R.layout.lyt_thin_banner_small, (ViewGroup) null, false, eVar);
    }

    public static LytThinBannerSmallBinding bind(View view) {
        return bind(view, f.a());
    }

    public static LytThinBannerSmallBinding bind(View view, e eVar) {
        return (LytThinBannerSmallBinding) bind(eVar, view, R.layout.lyt_thin_banner_small);
    }
}
