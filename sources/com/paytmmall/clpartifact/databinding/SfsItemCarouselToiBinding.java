package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;

public abstract class SfsItemCarouselToiBinding extends ViewDataBinding {
    public final AppCompatImageView bgImage;
    public final ImageView iconImage;
    protected CLPItemRVViewHolder mHandler;
    protected Item mItem;
    protected Integer mPosition;
    public final ConstraintLayout one;
    public final CLPRobotoTextView titletxt;

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected SfsItemCarouselToiBinding(e eVar, View view, int i2, AppCompatImageView appCompatImageView, ImageView imageView, ConstraintLayout constraintLayout, CLPRobotoTextView cLPRobotoTextView) {
        super(eVar, view, i2);
        this.bgImage = appCompatImageView;
        this.iconImage = imageView;
        this.one = constraintLayout;
        this.titletxt = cLPRobotoTextView;
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

    public static SfsItemCarouselToiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static SfsItemCarouselToiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (SfsItemCarouselToiBinding) f.a(layoutInflater, R.layout.sfs_item_carousel_toi, viewGroup, z, eVar);
    }

    public static SfsItemCarouselToiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static SfsItemCarouselToiBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (SfsItemCarouselToiBinding) f.a(layoutInflater, R.layout.sfs_item_carousel_toi, (ViewGroup) null, false, eVar);
    }

    public static SfsItemCarouselToiBinding bind(View view) {
        return bind(view, f.a());
    }

    public static SfsItemCarouselToiBinding bind(View view, e eVar) {
        return (SfsItemCarouselToiBinding) bind(eVar, view, R.layout.sfs_item_carousel_toi);
    }
}
