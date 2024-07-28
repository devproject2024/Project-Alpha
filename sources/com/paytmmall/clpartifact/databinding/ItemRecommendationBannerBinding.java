package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPRecoItemVH;

public abstract class ItemRecommendationBannerBinding extends ViewDataBinding {
    public final CLPRobotoTextView categoryTitle;
    public final CLPRobotoTextView categorycta;
    public final View firstItemImageContainer;
    public final Group gridContainer1;
    public final ImageView groupImageView;
    protected CLPRecoItemVH mHandler;
    protected Item mItem;
    protected Integer mPosition;
    public final ConstraintLayout mainLayoutReco;
    public final TextView recoLabel;

    public abstract void setHandler(CLPRecoItemVH cLPRecoItemVH);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemRecommendationBannerBinding(e eVar, View view, int i2, CLPRobotoTextView cLPRobotoTextView, CLPRobotoTextView cLPRobotoTextView2, View view2, Group group, ImageView imageView, ConstraintLayout constraintLayout, TextView textView) {
        super(eVar, view, i2);
        this.categoryTitle = cLPRobotoTextView;
        this.categorycta = cLPRobotoTextView2;
        this.firstItemImageContainer = view2;
        this.gridContainer1 = group;
        this.groupImageView = imageView;
        this.mainLayoutReco = constraintLayout;
        this.recoLabel = textView;
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

    public static ItemRecommendationBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemRecommendationBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemRecommendationBannerBinding) f.a(layoutInflater, R.layout.item_recommendation_banner, viewGroup, z, eVar);
    }

    public static ItemRecommendationBannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemRecommendationBannerBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemRecommendationBannerBinding) f.a(layoutInflater, R.layout.item_recommendation_banner, (ViewGroup) null, false, eVar);
    }

    public static ItemRecommendationBannerBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemRecommendationBannerBinding bind(View view, e eVar) {
        return (ItemRecommendationBannerBinding) bind(eVar, view, R.layout.item_recommendation_banner);
    }
}
