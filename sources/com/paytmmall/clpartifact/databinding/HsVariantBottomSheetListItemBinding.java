package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.view.viewHolder.HSVariantBottomSheetRVAdapterViewHolder;

public abstract class HsVariantBottomSheetListItemBinding extends ViewDataBinding {
    public final TextView actualPrice;
    public final TextView discountPercent;
    protected HSVariantBottomSheetRVAdapterViewHolder mHolder;
    protected CJRGridProduct mItem;

    public abstract void setHolder(HSVariantBottomSheetRVAdapterViewHolder hSVariantBottomSheetRVAdapterViewHolder);

    public abstract void setItem(CJRGridProduct cJRGridProduct);

    protected HsVariantBottomSheetListItemBinding(e eVar, View view, int i2, TextView textView, TextView textView2) {
        super(eVar, view, i2);
        this.actualPrice = textView;
        this.discountPercent = textView2;
    }

    public CJRGridProduct getItem() {
        return this.mItem;
    }

    public HSVariantBottomSheetRVAdapterViewHolder getHolder() {
        return this.mHolder;
    }

    public static HsVariantBottomSheetListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static HsVariantBottomSheetListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (HsVariantBottomSheetListItemBinding) f.a(layoutInflater, R.layout.hs_variant_bottom_sheet_list_item, viewGroup, z, eVar);
    }

    public static HsVariantBottomSheetListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static HsVariantBottomSheetListItemBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (HsVariantBottomSheetListItemBinding) f.a(layoutInflater, R.layout.hs_variant_bottom_sheet_list_item, (ViewGroup) null, false, eVar);
    }

    public static HsVariantBottomSheetListItemBinding bind(View view) {
        return bind(view, f.a());
    }

    public static HsVariantBottomSheetListItemBinding bind(View view, e eVar) {
        return (HsVariantBottomSheetListItemBinding) bind(eVar, view, R.layout.hs_variant_bottom_sheet_list_item);
    }
}
