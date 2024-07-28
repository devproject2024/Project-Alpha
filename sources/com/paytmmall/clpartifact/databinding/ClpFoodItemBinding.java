package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.view.viewHolder.CLPInfiniteGridFoodViewHolder;

public abstract class ClpFoodItemBinding extends ViewDataBinding {
    public final TextView actualPrice;
    public final FrameLayout addToCartContainer;
    public final LayoutAddToCartBinding addToCartLayout;
    public final TextView discountPercent;
    public final LayoutEditCartBinding editCartLayout;
    public final View foodTag;
    public final TextView itemDescription;
    public final TextView itemName;
    protected CLPInfiniteGridFoodViewHolder mHolder;
    protected CJRGridProduct mItem;
    public final TextView offerPrice;

    public abstract void setHolder(CLPInfiniteGridFoodViewHolder cLPInfiniteGridFoodViewHolder);

    public abstract void setItem(CJRGridProduct cJRGridProduct);

    protected ClpFoodItemBinding(e eVar, View view, int i2, TextView textView, FrameLayout frameLayout, LayoutAddToCartBinding layoutAddToCartBinding, TextView textView2, LayoutEditCartBinding layoutEditCartBinding, View view2, TextView textView3, TextView textView4, TextView textView5) {
        super(eVar, view, i2);
        this.actualPrice = textView;
        this.addToCartContainer = frameLayout;
        this.addToCartLayout = layoutAddToCartBinding;
        setContainedBinding(this.addToCartLayout);
        this.discountPercent = textView2;
        this.editCartLayout = layoutEditCartBinding;
        setContainedBinding(this.editCartLayout);
        this.foodTag = view2;
        this.itemDescription = textView3;
        this.itemName = textView4;
        this.offerPrice = textView5;
    }

    public CJRGridProduct getItem() {
        return this.mItem;
    }

    public CLPInfiniteGridFoodViewHolder getHolder() {
        return this.mHolder;
    }

    public static ClpFoodItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ClpFoodItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ClpFoodItemBinding) f.a(layoutInflater, R.layout.clp_food_item, viewGroup, z, eVar);
    }

    public static ClpFoodItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ClpFoodItemBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ClpFoodItemBinding) f.a(layoutInflater, R.layout.clp_food_item, (ViewGroup) null, false, eVar);
    }

    public static ClpFoodItemBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ClpFoodItemBinding bind(View view, e eVar) {
        return (ClpFoodItemBinding) bind(eVar, view, R.layout.clp_food_item);
    }
}
