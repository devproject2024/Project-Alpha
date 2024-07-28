package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithRV;

public abstract class ItemSmartHeaderRootBinding extends ViewDataBinding {
    public final ImageView backgroundImage;
    public final ConstraintLayout clParent;
    public final Guideline guideLineTop;
    public final Guideline guidelineBegin;
    public final Guideline guidelineBottom;
    public final Guideline guidelineEnd;
    public final ImageView imgBg;
    protected CLPItemRVAdapter mAdapter;
    protected CLPItemVHWithRV mHandler;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected Boolean mTitle;
    protected View mView;
    public final RecyclerView rvThinBanner;

    public abstract void setAdapter(CLPItemRVAdapter cLPItemRVAdapter);

    public abstract void setHandler(CLPItemVHWithRV cLPItemVHWithRV);

    public abstract void setLayoutManager(RecyclerView.LayoutManager layoutManager);

    public abstract void setTitle(Boolean bool);

    public abstract void setView(View view);

    protected ItemSmartHeaderRootBinding(e eVar, android.view.View view, int i2, ImageView imageView, ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, ImageView imageView2, RecyclerView recyclerView) {
        super(eVar, view, i2);
        this.backgroundImage = imageView;
        this.clParent = constraintLayout;
        this.guideLineTop = guideline;
        this.guidelineBegin = guideline2;
        this.guidelineBottom = guideline3;
        this.guidelineEnd = guideline4;
        this.imgBg = imageView2;
        this.rvThinBanner = recyclerView;
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

    public static ItemSmartHeaderRootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemSmartHeaderRootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemSmartHeaderRootBinding) f.a(layoutInflater, R.layout.item_smart_header_root, viewGroup, z, eVar);
    }

    public static ItemSmartHeaderRootBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemSmartHeaderRootBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemSmartHeaderRootBinding) f.a(layoutInflater, R.layout.item_smart_header_root, (ViewGroup) null, false, eVar);
    }

    public static ItemSmartHeaderRootBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static ItemSmartHeaderRootBinding bind(android.view.View view, e eVar) {
        return (ItemSmartHeaderRootBinding) bind(eVar, view, R.layout.item_smart_header_root);
    }
}
