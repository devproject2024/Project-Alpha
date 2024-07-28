package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;

public abstract class ItemRow1xnBinding extends ViewDataBinding {
    public final TextView badgeTV;
    public final TextView itemAddTag;
    protected CLPItemRVViewHolder mHandler;
    protected Boolean mIsWishListed;
    protected Item mItem;
    protected Integer mPosition;
    public final TextView offerText;
    public final LinearLayout parentLayout;
    public final CLPRobotoTextView row1xnCost;
    public final CLPRobotoTextView row1xnDiscount;
    public final ImageView row1xnImage;
    public final CLPRobotoTextView row1xnOriginalCost;
    public final CLPRobotoTextView row1xnText;
    public final ImageView wishlistIcon;

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setIsWishListed(Boolean bool);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemRow1xnBinding(e eVar, View view, int i2, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, CLPRobotoTextView cLPRobotoTextView, CLPRobotoTextView cLPRobotoTextView2, ImageView imageView, CLPRobotoTextView cLPRobotoTextView3, CLPRobotoTextView cLPRobotoTextView4, ImageView imageView2) {
        super(eVar, view, i2);
        this.badgeTV = textView;
        this.itemAddTag = textView2;
        this.offerText = textView3;
        this.parentLayout = linearLayout;
        this.row1xnCost = cLPRobotoTextView;
        this.row1xnDiscount = cLPRobotoTextView2;
        this.row1xnImage = imageView;
        this.row1xnOriginalCost = cLPRobotoTextView3;
        this.row1xnText = cLPRobotoTextView4;
        this.wishlistIcon = imageView2;
    }

    public Item getItem() {
        return this.mItem;
    }

    public CLPItemRVViewHolder getHandler() {
        return this.mHandler;
    }

    public Boolean getIsWishListed() {
        return this.mIsWishListed;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static ItemRow1xnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemRow1xnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemRow1xnBinding) f.a(layoutInflater, R.layout.item_row1xn, viewGroup, z, eVar);
    }

    public static ItemRow1xnBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemRow1xnBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemRow1xnBinding) f.a(layoutInflater, R.layout.item_row1xn, (ViewGroup) null, false, eVar);
    }

    public static ItemRow1xnBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemRow1xnBinding bind(View view, e eVar) {
        return (ItemRow1xnBinding) bind(eVar, view, R.layout.item_row1xn);
    }
}
