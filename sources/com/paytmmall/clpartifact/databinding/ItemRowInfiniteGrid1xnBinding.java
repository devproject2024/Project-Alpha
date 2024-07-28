package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.view.fragment.InfiniteFragment;
import com.paytmmall.clpartifact.view.viewHolder.CLPInfiniteGridHolder;

public abstract class ItemRowInfiniteGrid1xnBinding extends ViewDataBinding {
    public final TextView BrandNameTV;
    public final TextView actualPriceTV;
    public final LayoutAddToCartBinding addToCartLayout;
    public final ImageView badgeIV;
    public final View badgeSeparator;
    public final TextView badgeTV;
    public final FrameLayout cartContainer;
    public final TextView discountPercentTV;
    public final LayoutEditCartBinding editCartLayout;
    public final TextView itemAddTag;
    public final ImageView itemHeart;
    protected InfiniteFragment mFragment;
    protected CLPInfiniteGridHolder mHandler;
    protected Boolean mIsWishListed;
    protected CJRGridProduct mItem;
    protected Integer mPosition;
    protected Boolean mShowWishListIcon;
    public final TextView offerPriceTV;
    public final LinearLayout priceLayout;
    public final ImageView productImage;
    public final TextView productNameTV;
    public final TextView rating;
    public final ImageView star;
    public final View variantLayout;

    public abstract void setFragment(InfiniteFragment infiniteFragment);

    public abstract void setHandler(CLPInfiniteGridHolder cLPInfiniteGridHolder);

    public abstract void setIsWishListed(Boolean bool);

    public abstract void setItem(CJRGridProduct cJRGridProduct);

    public abstract void setPosition(Integer num);

    public abstract void setShowWishListIcon(Boolean bool);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ItemRowInfiniteGrid1xnBinding(e eVar, View view, int i2, TextView textView, TextView textView2, LayoutAddToCartBinding layoutAddToCartBinding, ImageView imageView, View view2, TextView textView3, FrameLayout frameLayout, TextView textView4, LayoutEditCartBinding layoutEditCartBinding, TextView textView5, ImageView imageView2, TextView textView6, LinearLayout linearLayout, ImageView imageView3, TextView textView7, TextView textView8, ImageView imageView4, View view3) {
        super(eVar, view, i2);
        this.BrandNameTV = textView;
        this.actualPriceTV = textView2;
        this.addToCartLayout = layoutAddToCartBinding;
        setContainedBinding(this.addToCartLayout);
        this.badgeIV = imageView;
        this.badgeSeparator = view2;
        this.badgeTV = textView3;
        this.cartContainer = frameLayout;
        this.discountPercentTV = textView4;
        this.editCartLayout = layoutEditCartBinding;
        setContainedBinding(this.editCartLayout);
        this.itemAddTag = textView5;
        this.itemHeart = imageView2;
        this.offerPriceTV = textView6;
        this.priceLayout = linearLayout;
        this.productImage = imageView3;
        this.productNameTV = textView7;
        this.rating = textView8;
        this.star = imageView4;
        this.variantLayout = view3;
    }

    public CLPInfiniteGridHolder getHandler() {
        return this.mHandler;
    }

    public Boolean getIsWishListed() {
        return this.mIsWishListed;
    }

    public InfiniteFragment getFragment() {
        return this.mFragment;
    }

    public CJRGridProduct getItem() {
        return this.mItem;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public Boolean getShowWishListIcon() {
        return this.mShowWishListIcon;
    }

    public static ItemRowInfiniteGrid1xnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemRowInfiniteGrid1xnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemRowInfiniteGrid1xnBinding) f.a(layoutInflater, R.layout.item_row_infinite_grid_1xn, viewGroup, z, eVar);
    }

    public static ItemRowInfiniteGrid1xnBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemRowInfiniteGrid1xnBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemRowInfiniteGrid1xnBinding) f.a(layoutInflater, R.layout.item_row_infinite_grid_1xn, (ViewGroup) null, false, eVar);
    }

    public static ItemRowInfiniteGrid1xnBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemRowInfiniteGrid1xnBinding bind(View view, e eVar) {
        return (ItemRowInfiniteGrid1xnBinding) bind(eVar, view, R.layout.item_row_infinite_grid_1xn);
    }
}
