package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.view.viewHolder.CLPInfiniteGridHolder;

public abstract class ItemRowInfiniteGridBinding extends ViewDataBinding {
    public final CLPRobotoTextView avgratingTxt;
    public final View endView;
    public final TextView itemAddTag;
    public final CLPRobotoTextView itemBrandName;
    public final ImageView itemHeart;
    public final ImageView itemImage1;
    public final CLPRobotoTextView itemName1;
    public final LinearLayout llPrice;
    public final LinearLayout llRoot;
    protected String mBadgeImageUrl;
    protected String mBadgeText;
    protected String mCashback;
    protected CLPInfiniteGridHolder mHandler;
    protected Boolean mIsWishListed;
    protected CJRGridProduct mItem;
    protected Boolean mOfferTag;
    protected Integer mPosition;
    protected boolean mShowPrice;
    protected Boolean mShowRating;
    protected boolean mShowSeparation;
    protected Boolean mShowWishListIcon;
    protected String mSubCashback;
    public final RelativeLayout product1;
    public final CLPRobotoTextView product1CashbackSubtext;
    public final CLPRobotoTextView product1CashbackText;
    public final CLPRobotoTextView product1DiscountPercent;
    public final CLPRobotoTextView product1OldPrice;
    public final CLPRobotoTextView product1Price;
    public final LinearLayout productName;
    public final ImageView ratingImg;
    public final CLPRobotoTextView ratingTxt;
    public final LinearLayout ratingll;
    public final CLPRobotoTextView variantLabel;

    public abstract void setBadgeImageUrl(String str);

    public abstract void setBadgeText(String str);

    public abstract void setCashback(String str);

    public abstract void setHandler(CLPInfiniteGridHolder cLPInfiniteGridHolder);

    public abstract void setIsWishListed(Boolean bool);

    public abstract void setItem(CJRGridProduct cJRGridProduct);

    public abstract void setOfferTag(Boolean bool);

    public abstract void setPosition(Integer num);

    public abstract void setShowPrice(boolean z);

    public abstract void setShowRating(Boolean bool);

    public abstract void setShowSeparation(boolean z);

    public abstract void setShowWishListIcon(Boolean bool);

    public abstract void setSubCashback(String str);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ItemRowInfiniteGridBinding(e eVar, View view, int i2, CLPRobotoTextView cLPRobotoTextView, View view2, TextView textView, CLPRobotoTextView cLPRobotoTextView2, ImageView imageView, ImageView imageView2, CLPRobotoTextView cLPRobotoTextView3, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, CLPRobotoTextView cLPRobotoTextView4, CLPRobotoTextView cLPRobotoTextView5, CLPRobotoTextView cLPRobotoTextView6, CLPRobotoTextView cLPRobotoTextView7, CLPRobotoTextView cLPRobotoTextView8, LinearLayout linearLayout3, ImageView imageView3, CLPRobotoTextView cLPRobotoTextView9, LinearLayout linearLayout4, CLPRobotoTextView cLPRobotoTextView10) {
        super(eVar, view, i2);
        this.avgratingTxt = cLPRobotoTextView;
        this.endView = view2;
        this.itemAddTag = textView;
        this.itemBrandName = cLPRobotoTextView2;
        this.itemHeart = imageView;
        this.itemImage1 = imageView2;
        this.itemName1 = cLPRobotoTextView3;
        this.llPrice = linearLayout;
        this.llRoot = linearLayout2;
        this.product1 = relativeLayout;
        this.product1CashbackSubtext = cLPRobotoTextView4;
        this.product1CashbackText = cLPRobotoTextView5;
        this.product1DiscountPercent = cLPRobotoTextView6;
        this.product1OldPrice = cLPRobotoTextView7;
        this.product1Price = cLPRobotoTextView8;
        this.productName = linearLayout3;
        this.ratingImg = imageView3;
        this.ratingTxt = cLPRobotoTextView9;
        this.ratingll = linearLayout4;
        this.variantLabel = cLPRobotoTextView10;
    }

    public CJRGridProduct getItem() {
        return this.mItem;
    }

    public Boolean getOfferTag() {
        return this.mOfferTag;
    }

    public Boolean getShowRating() {
        return this.mShowRating;
    }

    public CLPInfiniteGridHolder getHandler() {
        return this.mHandler;
    }

    public String getCashback() {
        return this.mCashback;
    }

    public String getSubCashback() {
        return this.mSubCashback;
    }

    public Boolean getIsWishListed() {
        return this.mIsWishListed;
    }

    public String getBadgeText() {
        return this.mBadgeText;
    }

    public String getBadgeImageUrl() {
        return this.mBadgeImageUrl;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public boolean getShowSeparation() {
        return this.mShowSeparation;
    }

    public boolean getShowPrice() {
        return this.mShowPrice;
    }

    public Boolean getShowWishListIcon() {
        return this.mShowWishListIcon;
    }

    public static ItemRowInfiniteGridBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemRowInfiniteGridBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemRowInfiniteGridBinding) f.a(layoutInflater, R.layout.item_row_infinite_grid, viewGroup, z, eVar);
    }

    public static ItemRowInfiniteGridBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemRowInfiniteGridBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemRowInfiniteGridBinding) f.a(layoutInflater, R.layout.item_row_infinite_grid, (ViewGroup) null, false, eVar);
    }

    public static ItemRowInfiniteGridBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemRowInfiniteGridBinding bind(View view, e eVar) {
        return (ItemRowInfiniteGridBinding) bind(eVar, view, R.layout.item_row_infinite_grid);
    }
}
