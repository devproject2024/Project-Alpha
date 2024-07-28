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

public abstract class ItemSmartIconButton2xnBinding extends ViewDataBinding {
    public final TextView button2XNText;
    public final ImageView buttonIcon;
    public final ConstraintLayout cashbackView2XN;
    protected CLPItemRVViewHolder mHandler;
    protected Item mItem;
    protected Integer mPosition;

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemSmartIconButton2xnBinding(e eVar, View view, int i2, TextView textView, ImageView imageView, ConstraintLayout constraintLayout) {
        super(eVar, view, i2);
        this.button2XNText = textView;
        this.buttonIcon = imageView;
        this.cashbackView2XN = constraintLayout;
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

    public static ItemSmartIconButton2xnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemSmartIconButton2xnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemSmartIconButton2xnBinding) f.a(layoutInflater, R.layout.item_smart_icon_button_2xn, viewGroup, z, eVar);
    }

    public static ItemSmartIconButton2xnBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemSmartIconButton2xnBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemSmartIconButton2xnBinding) f.a(layoutInflater, R.layout.item_smart_icon_button_2xn, (ViewGroup) null, false, eVar);
    }

    public static ItemSmartIconButton2xnBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemSmartIconButton2xnBinding bind(View view, e eVar) {
        return (ItemSmartIconButton2xnBinding) bind(eVar, view, R.layout.item_smart_icon_button_2xn);
    }
}
