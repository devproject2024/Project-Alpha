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

public abstract class ItemRow2xnBinding extends ViewDataBinding {
    public final TextView itemAddTag;
    protected CLPItemRVViewHolder mHandler;
    protected Item mItem;
    protected Integer mPosition;
    public final LinearLayout parentLayout;
    public final CLPRobotoTextView row1xnCost;
    public final ImageView row1xnImage;
    public final CLPRobotoTextView row1xnOfferPrice;
    public final CLPRobotoTextView row1xnTags;
    public final TextView row1xnText;

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemRow2xnBinding(e eVar, View view, int i2, TextView textView, LinearLayout linearLayout, CLPRobotoTextView cLPRobotoTextView, ImageView imageView, CLPRobotoTextView cLPRobotoTextView2, CLPRobotoTextView cLPRobotoTextView3, TextView textView2) {
        super(eVar, view, i2);
        this.itemAddTag = textView;
        this.parentLayout = linearLayout;
        this.row1xnCost = cLPRobotoTextView;
        this.row1xnImage = imageView;
        this.row1xnOfferPrice = cLPRobotoTextView2;
        this.row1xnTags = cLPRobotoTextView3;
        this.row1xnText = textView2;
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

    public static ItemRow2xnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemRow2xnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemRow2xnBinding) f.a(layoutInflater, R.layout.item_row2xn, viewGroup, z, eVar);
    }

    public static ItemRow2xnBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemRow2xnBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemRow2xnBinding) f.a(layoutInflater, R.layout.item_row2xn, (ViewGroup) null, false, eVar);
    }

    public static ItemRow2xnBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemRow2xnBinding bind(View view, e eVar) {
        return (ItemRow2xnBinding) bind(eVar, view, R.layout.item_row2xn);
    }
}
