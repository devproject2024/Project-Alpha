package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPRecoItemVH;

public abstract class ItemRecommendationBannerLargeImageBinding extends ViewDataBinding {
    public final ImageView bgImage;
    public final CLPRobotoTextView cta;
    public final ImageView image;
    protected CLPRecoItemVH mHandler;
    protected Item mItem;
    protected Integer mPosition;
    public final CLPRobotoTextView subTitle;
    public final CLPRobotoTextView title;

    public abstract void setHandler(CLPRecoItemVH cLPRecoItemVH);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemRecommendationBannerLargeImageBinding(e eVar, View view, int i2, ImageView imageView, CLPRobotoTextView cLPRobotoTextView, ImageView imageView2, CLPRobotoTextView cLPRobotoTextView2, CLPRobotoTextView cLPRobotoTextView3) {
        super(eVar, view, i2);
        this.bgImage = imageView;
        this.cta = cLPRobotoTextView;
        this.image = imageView2;
        this.subTitle = cLPRobotoTextView2;
        this.title = cLPRobotoTextView3;
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

    public static ItemRecommendationBannerLargeImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemRecommendationBannerLargeImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemRecommendationBannerLargeImageBinding) f.a(layoutInflater, R.layout.item_recommendation_banner_large_image, viewGroup, z, eVar);
    }

    public static ItemRecommendationBannerLargeImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemRecommendationBannerLargeImageBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemRecommendationBannerLargeImageBinding) f.a(layoutInflater, R.layout.item_recommendation_banner_large_image, (ViewGroup) null, false, eVar);
    }

    public static ItemRecommendationBannerLargeImageBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemRecommendationBannerLargeImageBinding bind(View view, e eVar) {
        return (ItemRecommendationBannerLargeImageBinding) bind(eVar, view, R.layout.item_recommendation_banner_large_image);
    }
}
