package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.FlashSaleView;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithRV;

public abstract class ItemFullWidthRootRvSmallTiBinding extends ViewDataBinding {
    public final ImageView backgroundImage;
    public final FrameLayout colorBackground;
    public final FrameLayout flashSaleContainer;
    public final LinearLayout llParent;
    protected CLPItemRVAdapter mAdapter;
    protected CLPItemVHWithRV mHandler;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected Boolean mTitle;
    protected View mView;
    public final RecyclerView rvThinBanner;
    public final TextView subTitle;
    public final FlashSaleView timerView;
    public final CLPRobotoTextView viewAll;
    public final CLPRobotoTextView viewName;

    public abstract void setAdapter(CLPItemRVAdapter cLPItemRVAdapter);

    public abstract void setHandler(CLPItemVHWithRV cLPItemVHWithRV);

    public abstract void setLayoutManager(RecyclerView.LayoutManager layoutManager);

    public abstract void setTitle(Boolean bool);

    public abstract void setView(View view);

    protected ItemFullWidthRootRvSmallTiBinding(e eVar, android.view.View view, int i2, ImageView imageView, FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, FlashSaleView flashSaleView, CLPRobotoTextView cLPRobotoTextView, CLPRobotoTextView cLPRobotoTextView2) {
        super(eVar, view, i2);
        this.backgroundImage = imageView;
        this.colorBackground = frameLayout;
        this.flashSaleContainer = frameLayout2;
        this.llParent = linearLayout;
        this.rvThinBanner = recyclerView;
        this.subTitle = textView;
        this.timerView = flashSaleView;
        this.viewAll = cLPRobotoTextView;
        this.viewName = cLPRobotoTextView2;
    }

    public Boolean getTitle() {
        return this.mTitle;
    }

    public View getView() {
        return this.mView;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.mLayoutManager;
    }

    public CLPItemRVAdapter getAdapter() {
        return this.mAdapter;
    }

    public CLPItemVHWithRV getHandler() {
        return this.mHandler;
    }

    public static ItemFullWidthRootRvSmallTiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemFullWidthRootRvSmallTiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemFullWidthRootRvSmallTiBinding) f.a(layoutInflater, R.layout.item_full_width_root_rv_small_ti, viewGroup, z, eVar);
    }

    public static ItemFullWidthRootRvSmallTiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemFullWidthRootRvSmallTiBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemFullWidthRootRvSmallTiBinding) f.a(layoutInflater, R.layout.item_full_width_root_rv_small_ti, (ViewGroup) null, false, eVar);
    }

    public static ItemFullWidthRootRvSmallTiBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static ItemFullWidthRootRvSmallTiBinding bind(android.view.View view, e eVar) {
        return (ItemFullWidthRootRvSmallTiBinding) bind(eVar, view, R.layout.item_full_width_root_rv_small_ti);
    }
}
