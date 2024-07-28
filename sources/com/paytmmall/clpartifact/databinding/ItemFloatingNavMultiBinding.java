package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.widgets.component.viewholder.FabBaseVH;

public abstract class ItemFloatingNavMultiBinding extends ViewDataBinding {
    public final CLPRobotoTextView categoryTitle;
    public final View dot;
    public final ImageView groupImageView;
    protected FabBaseVH mHandler;
    protected Item mItem;
    protected Integer mPosition;

    public abstract void setHandler(FabBaseVH fabBaseVH);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemFloatingNavMultiBinding(e eVar, View view, int i2, CLPRobotoTextView cLPRobotoTextView, View view2, ImageView imageView) {
        super(eVar, view, i2);
        this.categoryTitle = cLPRobotoTextView;
        this.dot = view2;
        this.groupImageView = imageView;
    }

    public Item getItem() {
        return this.mItem;
    }

    public FabBaseVH getHandler() {
        return this.mHandler;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static ItemFloatingNavMultiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemFloatingNavMultiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemFloatingNavMultiBinding) f.a(layoutInflater, R.layout.item_floating_nav_multi, viewGroup, z, eVar);
    }

    public static ItemFloatingNavMultiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemFloatingNavMultiBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemFloatingNavMultiBinding) f.a(layoutInflater, R.layout.item_floating_nav_multi, (ViewGroup) null, false, eVar);
    }

    public static ItemFloatingNavMultiBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemFloatingNavMultiBinding bind(View view, e eVar) {
        return (ItemFloatingNavMultiBinding) bind(eVar, view, R.layout.item_floating_nav_multi);
    }
}
