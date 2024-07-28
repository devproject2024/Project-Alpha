package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.google.android.material.tabs.TabLayout;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.SFCustomPager;
import com.paytmmall.clpartifact.view.viewHolder.InfiniteGridRowViewHolder;

public abstract class ItemInfiniteRowHeaderrBinding extends ViewDataBinding {
    public final View Divider;
    public final SFCustomPager infiniteGrid;
    protected InfiniteGridRowViewHolder mHandler;
    protected Item mItem;
    public final ConstraintLayout relativeLayout;
    public final TextView singleTab;
    public final FrameLayout tabContainer;
    public final TabLayout tabs;

    public abstract void setHandler(InfiniteGridRowViewHolder infiniteGridRowViewHolder);

    public abstract void setItem(Item item);

    protected ItemInfiniteRowHeaderrBinding(e eVar, View view, int i2, View view2, SFCustomPager sFCustomPager, ConstraintLayout constraintLayout, TextView textView, FrameLayout frameLayout, TabLayout tabLayout) {
        super(eVar, view, i2);
        this.Divider = view2;
        this.infiniteGrid = sFCustomPager;
        this.relativeLayout = constraintLayout;
        this.singleTab = textView;
        this.tabContainer = frameLayout;
        this.tabs = tabLayout;
    }

    public Item getItem() {
        return this.mItem;
    }

    public InfiniteGridRowViewHolder getHandler() {
        return this.mHandler;
    }

    public static ItemInfiniteRowHeaderrBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemInfiniteRowHeaderrBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemInfiniteRowHeaderrBinding) f.a(layoutInflater, R.layout.item_infinite_row_headerr, viewGroup, z, eVar);
    }

    public static ItemInfiniteRowHeaderrBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemInfiniteRowHeaderrBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemInfiniteRowHeaderrBinding) f.a(layoutInflater, R.layout.item_infinite_row_headerr, (ViewGroup) null, false, eVar);
    }

    public static ItemInfiniteRowHeaderrBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemInfiniteRowHeaderrBinding bind(View view, e eVar) {
        return (ItemInfiniteRowHeaderrBinding) bind(eVar, view, R.layout.item_infinite_row_headerr);
    }
}
