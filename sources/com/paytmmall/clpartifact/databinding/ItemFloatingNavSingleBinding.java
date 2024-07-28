package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.widgets.component.viewholder.FabBaseVH;

public abstract class ItemFloatingNavSingleBinding extends ViewDataBinding {
    public final View dot;
    public final ImageView groupImageView;
    protected FabBaseVH mHandler;
    protected Item mItem;
    protected Integer mPosition;
    public final TextView tvLabel;

    public abstract void setHandler(FabBaseVH fabBaseVH);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemFloatingNavSingleBinding(e eVar, View view, int i2, View view2, ImageView imageView, TextView textView) {
        super(eVar, view, i2);
        this.dot = view2;
        this.groupImageView = imageView;
        this.tvLabel = textView;
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

    public static ItemFloatingNavSingleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemFloatingNavSingleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemFloatingNavSingleBinding) f.a(layoutInflater, R.layout.item_floating_nav_single, viewGroup, z, eVar);
    }

    public static ItemFloatingNavSingleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemFloatingNavSingleBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemFloatingNavSingleBinding) f.a(layoutInflater, R.layout.item_floating_nav_single, (ViewGroup) null, false, eVar);
    }

    public static ItemFloatingNavSingleBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemFloatingNavSingleBinding bind(View view, e eVar) {
        return (ItemFloatingNavSingleBinding) bind(eVar, view, R.layout.item_floating_nav_single);
    }
}
