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
import com.paytmmall.clpartifact.view.viewHolder.DealsItemViewHolder;

public abstract class DealsItemClpBinding extends ViewDataBinding {
    public final ImageView imageView;
    protected DealsItemViewHolder mHolder;
    protected CJRGridProduct mProduct;
    public final TextView textView;
    public final TextView textView2;
    public final TextView textView3;

    public abstract void setHolder(DealsItemViewHolder dealsItemViewHolder);

    public abstract void setProduct(CJRGridProduct cJRGridProduct);

    protected DealsItemClpBinding(e eVar, View view, int i2, ImageView imageView2, TextView textView4, TextView textView5, TextView textView6) {
        super(eVar, view, i2);
        this.imageView = imageView2;
        this.textView = textView4;
        this.textView2 = textView5;
        this.textView3 = textView6;
    }

    public CJRGridProduct getProduct() {
        return this.mProduct;
    }

    public DealsItemViewHolder getHolder() {
        return this.mHolder;
    }

    public static DealsItemClpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static DealsItemClpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (DealsItemClpBinding) f.a(layoutInflater, R.layout.deals_item_clp, viewGroup, z, eVar);
    }

    public static DealsItemClpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static DealsItemClpBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (DealsItemClpBinding) f.a(layoutInflater, R.layout.deals_item_clp, (ViewGroup) null, false, eVar);
    }

    public static DealsItemClpBinding bind(View view) {
        return bind(view, f.a());
    }

    public static DealsItemClpBinding bind(View view, e eVar) {
        return (DealsItemClpBinding) bind(eVar, view, R.layout.deals_item_clp);
    }
}
