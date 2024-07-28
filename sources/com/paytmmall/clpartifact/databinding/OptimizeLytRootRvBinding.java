package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;

public abstract class OptimizeLytRootRvBinding extends ViewDataBinding {
    public final ConstraintLayout clParent;
    protected CLPItemRVAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected View mView;
    public final RecyclerView rvThinBanner;
    public final CLPRobotoTextView viewName;

    public abstract void setAdapter(CLPItemRVAdapter cLPItemRVAdapter);

    public abstract void setLayoutManager(RecyclerView.LayoutManager layoutManager);

    public abstract void setView(View view);

    protected OptimizeLytRootRvBinding(e eVar, android.view.View view, int i2, ConstraintLayout constraintLayout, RecyclerView recyclerView, CLPRobotoTextView cLPRobotoTextView) {
        super(eVar, view, i2);
        this.clParent = constraintLayout;
        this.rvThinBanner = recyclerView;
        this.viewName = cLPRobotoTextView;
    }

    public View getView() {
        return this.mView;
    }

    public CLPItemRVAdapter getAdapter() {
        return this.mAdapter;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.mLayoutManager;
    }

    public static OptimizeLytRootRvBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static OptimizeLytRootRvBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (OptimizeLytRootRvBinding) f.a(layoutInflater, R.layout.optimize_lyt_root_rv, viewGroup, z, eVar);
    }

    public static OptimizeLytRootRvBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static OptimizeLytRootRvBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (OptimizeLytRootRvBinding) f.a(layoutInflater, R.layout.optimize_lyt_root_rv, (ViewGroup) null, false, eVar);
    }

    public static OptimizeLytRootRvBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static OptimizeLytRootRvBinding bind(android.view.View view, e eVar) {
        return (OptimizeLytRootRvBinding) bind(eVar, view, R.layout.optimize_lyt_root_rv);
    }
}
