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

public abstract class ItemRowBinding extends ViewDataBinding {
    public final TextView badgeTV;
    public final CLPRobotoTextView caption;
    public final TextView itemAddTag;
    protected CLPItemRVViewHolder mHandler;
    protected Item mItem;
    protected Integer mPosition;
    public final TextView offerText;
    public final LinearLayout parentLayout;
    public final ImageView rowImage;

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemRowBinding(e eVar, View view, int i2, TextView textView, CLPRobotoTextView cLPRobotoTextView, TextView textView2, TextView textView3, LinearLayout linearLayout, ImageView imageView) {
        super(eVar, view, i2);
        this.badgeTV = textView;
        this.caption = cLPRobotoTextView;
        this.itemAddTag = textView2;
        this.offerText = textView3;
        this.parentLayout = linearLayout;
        this.rowImage = imageView;
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

    public static ItemRowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemRowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemRowBinding) f.a(layoutInflater, R.layout.item_row, viewGroup, z, eVar);
    }

    public static ItemRowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemRowBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemRowBinding) f.a(layoutInflater, R.layout.item_row, (ViewGroup) null, false, eVar);
    }

    public static ItemRowBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemRowBinding bind(View view, e eVar) {
        return (ItemRowBinding) bind(eVar, view, R.layout.item_row);
    }
}
