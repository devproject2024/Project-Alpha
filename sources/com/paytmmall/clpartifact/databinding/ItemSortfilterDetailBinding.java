package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.grid.CJRSortingKeys;
import com.paytmmall.clpartifact.view.viewHolder.CLPSortBottomSheetVH;

public abstract class ItemSortfilterDetailBinding extends ViewDataBinding {
    protected CLPSortBottomSheetVH mHandler;
    protected CJRSortingKeys mItem;
    public final TextView sortFilterName;

    public abstract void setHandler(CLPSortBottomSheetVH cLPSortBottomSheetVH);

    public abstract void setItem(CJRSortingKeys cJRSortingKeys);

    protected ItemSortfilterDetailBinding(e eVar, View view, int i2, TextView textView) {
        super(eVar, view, i2);
        this.sortFilterName = textView;
    }

    public CJRSortingKeys getItem() {
        return this.mItem;
    }

    public CLPSortBottomSheetVH getHandler() {
        return this.mHandler;
    }

    public static ItemSortfilterDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemSortfilterDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemSortfilterDetailBinding) f.a(layoutInflater, R.layout.item_sortfilter_detail, viewGroup, z, eVar);
    }

    public static ItemSortfilterDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemSortfilterDetailBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemSortfilterDetailBinding) f.a(layoutInflater, R.layout.item_sortfilter_detail, (ViewGroup) null, false, eVar);
    }

    public static ItemSortfilterDetailBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemSortfilterDetailBinding bind(View view, e eVar) {
        return (ItemSortfilterDetailBinding) bind(eVar, view, R.layout.item_sortfilter_detail);
    }
}
