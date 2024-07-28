package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;

public abstract class SfItemTiBinding extends ViewDataBinding {
    public final ImageView altIcon;
    public final ImageView backArrow;
    public final View dividerView;
    public final ImageView icon;
    protected CLPItemRVViewHolder mHandler;
    protected Item mItem;
    protected Integer mPosition;
    public final TextView name;
    public final ConstraintLayout rootLayout;
    public final TextView subTitle;
    public final TextView title;
    public final TextView tvLabel;

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected SfItemTiBinding(e eVar, View view, int i2, ImageView imageView, ImageView imageView2, View view2, ImageView imageView3, TextView textView, ConstraintLayout constraintLayout, TextView textView2, TextView textView3, TextView textView4) {
        super(eVar, view, i2);
        this.altIcon = imageView;
        this.backArrow = imageView2;
        this.dividerView = view2;
        this.icon = imageView3;
        this.name = textView;
        this.rootLayout = constraintLayout;
        this.subTitle = textView2;
        this.title = textView3;
        this.tvLabel = textView4;
    }

    public Item getItem() {
        return this.mItem;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public CLPItemRVViewHolder getHandler() {
        return this.mHandler;
    }

    public static SfItemTiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static SfItemTiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (SfItemTiBinding) f.a(layoutInflater, R.layout.sf_item_ti, viewGroup, z, eVar);
    }

    public static SfItemTiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static SfItemTiBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (SfItemTiBinding) f.a(layoutInflater, R.layout.sf_item_ti, (ViewGroup) null, false, eVar);
    }

    public static SfItemTiBinding bind(View view) {
        return bind(view, f.a());
    }

    public static SfItemTiBinding bind(View view, e eVar) {
        return (SfItemTiBinding) bind(eVar, view, R.layout.sf_item_ti);
    }
}
