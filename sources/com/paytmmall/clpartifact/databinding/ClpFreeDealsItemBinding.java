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
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.view.viewHolder.FreeDealsItemViewHolder;

public abstract class ClpFreeDealsItemBinding extends ViewDataBinding {
    public final TextView Free;
    public final ImageView imageView;
    protected FreeDealsItemViewHolder mHolder;
    protected CJRGridProduct mProduct;
    public final TextView textView;
    public final TextView textView2;

    public abstract void setHolder(FreeDealsItemViewHolder freeDealsItemViewHolder);

    public abstract void setProduct(CJRGridProduct cJRGridProduct);

    protected ClpFreeDealsItemBinding(e eVar, View view, int i2, TextView textView3, ImageView imageView2, TextView textView4, TextView textView5) {
        super(eVar, view, i2);
        this.Free = textView3;
        this.imageView = imageView2;
        this.textView = textView4;
        this.textView2 = textView5;
    }

    public CJRGridProduct getProduct() {
        return this.mProduct;
    }

    public FreeDealsItemViewHolder getHolder() {
        return this.mHolder;
    }

    public static ClpFreeDealsItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ClpFreeDealsItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ClpFreeDealsItemBinding) f.a(layoutInflater, R.layout.clp_free_deals_item, viewGroup, z, eVar);
    }

    public static ClpFreeDealsItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ClpFreeDealsItemBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ClpFreeDealsItemBinding) f.a(layoutInflater, R.layout.clp_free_deals_item, (ViewGroup) null, false, eVar);
    }

    public static ClpFreeDealsItemBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ClpFreeDealsItemBinding bind(View view, e eVar) {
        return (ClpFreeDealsItemBinding) bind(eVar, view, R.layout.clp_free_deals_item);
    }
}
