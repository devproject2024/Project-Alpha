package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.grid.CJRFilterItem;
import com.paytmmall.clpartifact.view.viewHolder.CLPSortingViewHolder;

public abstract class ItemFilterBinding extends ViewDataBinding {
    public final LinearLayout filterTxt;
    public final TextView filterTxtValue1;
    public final TextView filterTxtValue2;
    protected CLPSortingViewHolder mHandler;
    protected CJRFilterItem mItem;

    public abstract void setHandler(CLPSortingViewHolder cLPSortingViewHolder);

    public abstract void setItem(CJRFilterItem cJRFilterItem);

    protected ItemFilterBinding(e eVar, View view, int i2, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(eVar, view, i2);
        this.filterTxt = linearLayout;
        this.filterTxtValue1 = textView;
        this.filterTxtValue2 = textView2;
    }

    public CJRFilterItem getItem() {
        return this.mItem;
    }

    public CLPSortingViewHolder getHandler() {
        return this.mHandler;
    }

    public static ItemFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemFilterBinding) f.a(layoutInflater, R.layout.item_filter, viewGroup, z, eVar);
    }

    public static ItemFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemFilterBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemFilterBinding) f.a(layoutInflater, R.layout.item_filter, (ViewGroup) null, false, eVar);
    }

    public static ItemFilterBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemFilterBinding bind(View view, e eVar) {
        return (ItemFilterBinding) bind(eVar, view, R.layout.item_filter);
    }
}
