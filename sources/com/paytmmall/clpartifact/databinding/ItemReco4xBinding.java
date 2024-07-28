package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPCarouselItem4X;

public abstract class ItemReco4xBinding extends ViewDataBinding {
    public final CLPRobotoTextView categoryTitle;
    public final TextView categorycta;
    public final AppCompatImageView closeIcon;
    public final ImageView groupImageView;
    protected CLPCarouselItem4X mHandler;
    protected Item mItem;
    protected Integer mPosition;
    public final ConstraintLayout mainLayoutReco;
    public final TextView recoLabel;
    public final FrameLayout recoLayoutContainer;
    public final CLPRobotoTextView subtitle;

    public abstract void setHandler(CLPCarouselItem4X cLPCarouselItem4X);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemReco4xBinding(e eVar, View view, int i2, CLPRobotoTextView cLPRobotoTextView, TextView textView, AppCompatImageView appCompatImageView, ImageView imageView, ConstraintLayout constraintLayout, TextView textView2, FrameLayout frameLayout, CLPRobotoTextView cLPRobotoTextView2) {
        super(eVar, view, i2);
        this.categoryTitle = cLPRobotoTextView;
        this.categorycta = textView;
        this.closeIcon = appCompatImageView;
        this.groupImageView = imageView;
        this.mainLayoutReco = constraintLayout;
        this.recoLabel = textView2;
        this.recoLayoutContainer = frameLayout;
        this.subtitle = cLPRobotoTextView2;
    }

    public Item getItem() {
        return this.mItem;
    }

    public CLPCarouselItem4X getHandler() {
        return this.mHandler;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static ItemReco4xBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemReco4xBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemReco4xBinding) f.a(layoutInflater, R.layout.item_reco_4x, viewGroup, z, eVar);
    }

    public static ItemReco4xBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemReco4xBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemReco4xBinding) f.a(layoutInflater, R.layout.item_reco_4x, (ViewGroup) null, false, eVar);
    }

    public static ItemReco4xBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemReco4xBinding bind(View view, e eVar) {
        return (ItemReco4xBinding) bind(eVar, view, R.layout.item_reco_4x);
    }
}
