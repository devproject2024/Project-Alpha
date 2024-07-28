package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithRV;

public abstract class ParentStandardRvBinding extends ViewDataBinding {
    public final ConstraintLayout clParent;
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

    protected ParentStandardRvBinding(e eVar, android.view.View view, int i2, ConstraintLayout constraintLayout, RecyclerView recyclerView) {
        super(eVar, view, i2);
        this.clParent = constraintLayout;
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

    public static ParentStandardRvBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ParentStandardRvBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ParentStandardRvBinding) f.a(layoutInflater, R.layout.parent_standard_rv, viewGroup, z, eVar);
    }

    public static ParentStandardRvBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ParentStandardRvBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ParentStandardRvBinding) f.a(layoutInflater, R.layout.parent_standard_rv, (ViewGroup) null, false, eVar);
    }

    public static ParentStandardRvBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static ParentStandardRvBinding bind(android.view.View view, e eVar) {
        return (ParentStandardRvBinding) bind(eVar, view, R.layout.parent_standard_rv);
    }
}
