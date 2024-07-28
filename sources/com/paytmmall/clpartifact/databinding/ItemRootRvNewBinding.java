package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.FlashSaleView;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithRV;

public abstract class ItemRootRvNewBinding extends ViewDataBinding {
    public final View background;
    public final ImageView backgroundImage;
    public final Barrier barrier1;
    public final ConstraintLayout clParent;
    public final View colorBackground;
    public final ImageView imgBg;
    public final ImageView ivFlashImage;
    public final View layoutBackground;
    protected CLPItemRVAdapter mAdapter;
    protected CLPItemVHWithRV mHandler;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected Boolean mTitle;
    protected com.paytmmall.clpartifact.modal.clpCommon.View mView;
    public final View marginView1;
    public final View marginView2;
    public final RecyclerView rvThinBanner;
    public final View superLayout;
    public final FlashSaleView timerView;
    public final TextView tvEndsIn;
    public final CLPRobotoTextView viewAll;
    public final CLPRobotoTextView viewName;
    public final View viewTopLayout;

    public abstract void setAdapter(CLPItemRVAdapter cLPItemRVAdapter);

    public abstract void setHandler(CLPItemVHWithRV cLPItemVHWithRV);

    public abstract void setLayoutManager(RecyclerView.LayoutManager layoutManager);

    public abstract void setTitle(Boolean bool);

    public abstract void setView(com.paytmmall.clpartifact.modal.clpCommon.View view);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ItemRootRvNewBinding(e eVar, View view, int i2, View view2, ImageView imageView, Barrier barrier, ConstraintLayout constraintLayout, View view3, ImageView imageView2, ImageView imageView3, View view4, View view5, View view6, RecyclerView recyclerView, View view7, FlashSaleView flashSaleView, TextView textView, CLPRobotoTextView cLPRobotoTextView, CLPRobotoTextView cLPRobotoTextView2, View view8) {
        super(eVar, view, i2);
        this.background = view2;
        this.backgroundImage = imageView;
        this.barrier1 = barrier;
        this.clParent = constraintLayout;
        this.colorBackground = view3;
        this.imgBg = imageView2;
        this.ivFlashImage = imageView3;
        this.layoutBackground = view4;
        this.marginView1 = view5;
        this.marginView2 = view6;
        this.rvThinBanner = recyclerView;
        this.superLayout = view7;
        this.timerView = flashSaleView;
        this.tvEndsIn = textView;
        this.viewAll = cLPRobotoTextView;
        this.viewName = cLPRobotoTextView2;
        this.viewTopLayout = view8;
    }

    public Boolean getTitle() {
        return this.mTitle;
    }

    public com.paytmmall.clpartifact.modal.clpCommon.View getView() {
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

    public static ItemRootRvNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemRootRvNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemRootRvNewBinding) f.a(layoutInflater, R.layout.item_root_rv_new, viewGroup, z, eVar);
    }

    public static ItemRootRvNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemRootRvNewBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemRootRvNewBinding) f.a(layoutInflater, R.layout.item_root_rv_new, (ViewGroup) null, false, eVar);
    }

    public static ItemRootRvNewBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemRootRvNewBinding bind(View view, e eVar) {
        return (ItemRootRvNewBinding) bind(eVar, view, R.layout.item_root_rv_new);
    }
}
