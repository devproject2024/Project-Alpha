package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.grid.CJRFilterItem;
import com.paytmmall.clpartifact.view.adapter.FilterRecyclerViewAdapter;

public abstract class ItemFilterListBinding extends ViewDataBinding {
    public final CLPRobotoTextView filterTextView;
    public final ImageView imageSelectedFilter;
    public final LinearLayout linearRectItem;
    protected FilterRecyclerViewAdapter.FilterListViewHolder mHandler;
    protected CJRFilterItem mItem;
    protected Integer mPosition;
    public final View selectedView;

    public abstract void setHandler(FilterRecyclerViewAdapter.FilterListViewHolder filterListViewHolder);

    public abstract void setItem(CJRFilterItem cJRFilterItem);

    public abstract void setPosition(Integer num);

    protected ItemFilterListBinding(e eVar, View view, int i2, CLPRobotoTextView cLPRobotoTextView, ImageView imageView, LinearLayout linearLayout, View view2) {
        super(eVar, view, i2);
        this.filterTextView = cLPRobotoTextView;
        this.imageSelectedFilter = imageView;
        this.linearRectItem = linearLayout;
        this.selectedView = view2;
    }

    public CJRFilterItem getItem() {
        return this.mItem;
    }

    public FilterRecyclerViewAdapter.FilterListViewHolder getHandler() {
        return this.mHandler;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static ItemFilterListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemFilterListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemFilterListBinding) f.a(layoutInflater, R.layout.item_filter_list, viewGroup, z, eVar);
    }

    public static ItemFilterListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemFilterListBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemFilterListBinding) f.a(layoutInflater, R.layout.item_filter_list, (ViewGroup) null, false, eVar);
    }

    public static ItemFilterListBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemFilterListBinding bind(View view, e eVar) {
        return (ItemFilterListBinding) bind(eVar, view, R.layout.item_filter_list);
    }
}
