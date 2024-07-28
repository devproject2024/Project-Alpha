package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.InfiniteGridCustomRecyclerview;

public abstract class ItemInfiniteGridContainerBinding extends ViewDataBinding {
    public final RecyclerView filterContainer;
    public final InfiniteGridCustomRecyclerview gridTabsContainer;
    public final ProgressBar mainProgressBar;
    public final LinearLayout noNetworkLL;
    public final ProgressBar progressBar;
    public final Button retryButton;
    public final TextView viewName;

    protected ItemInfiniteGridContainerBinding(e eVar, View view, int i2, RecyclerView recyclerView, InfiniteGridCustomRecyclerview infiniteGridCustomRecyclerview, ProgressBar progressBar2, LinearLayout linearLayout, ProgressBar progressBar3, Button button, TextView textView) {
        super(eVar, view, i2);
        this.filterContainer = recyclerView;
        this.gridTabsContainer = infiniteGridCustomRecyclerview;
        this.mainProgressBar = progressBar2;
        this.noNetworkLL = linearLayout;
        this.progressBar = progressBar3;
        this.retryButton = button;
        this.viewName = textView;
    }

    public static ItemInfiniteGridContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemInfiniteGridContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemInfiniteGridContainerBinding) f.a(layoutInflater, R.layout.item_infinite_grid_container, viewGroup, z, eVar);
    }

    public static ItemInfiniteGridContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemInfiniteGridContainerBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemInfiniteGridContainerBinding) f.a(layoutInflater, R.layout.item_infinite_grid_container, (ViewGroup) null, false, eVar);
    }

    public static ItemInfiniteGridContainerBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemInfiniteGridContainerBinding bind(View view, e eVar) {
        return (ItemInfiniteGridContainerBinding) bind(eVar, view, R.layout.item_infinite_grid_container);
    }
}
