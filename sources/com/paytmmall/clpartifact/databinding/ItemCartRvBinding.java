package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithRV;

public abstract class ItemCartRvBinding extends ViewDataBinding {
    protected CLPItemRVAdapter mAdapter;
    protected CLPItemVHWithRV mHandler;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected View mView;
    public final LinearLayout mainLayout;
    public final RecyclerView rvThinBanner;
    public final CLPRobotoTextView viewAll;
    public final CLPRobotoTextView viewName;

    public abstract void setAdapter(CLPItemRVAdapter cLPItemRVAdapter);

    public abstract void setHandler(CLPItemVHWithRV cLPItemVHWithRV);

    public abstract void setLayoutManager(RecyclerView.LayoutManager layoutManager);

    public abstract void setView(View view);

    protected ItemCartRvBinding(e eVar, android.view.View view, int i2, LinearLayout linearLayout, RecyclerView recyclerView, CLPRobotoTextView cLPRobotoTextView, CLPRobotoTextView cLPRobotoTextView2) {
        super(eVar, view, i2);
        this.mainLayout = linearLayout;
        this.rvThinBanner = recyclerView;
        this.viewAll = cLPRobotoTextView;
        this.viewName = cLPRobotoTextView2;
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

    public static ItemCartRvBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemCartRvBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemCartRvBinding) f.a(layoutInflater, R.layout.item_cart_rv, viewGroup, z, eVar);
    }

    public static ItemCartRvBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemCartRvBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemCartRvBinding) f.a(layoutInflater, R.layout.item_cart_rv, (ViewGroup) null, false, eVar);
    }

    public static ItemCartRvBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static ItemCartRvBinding bind(android.view.View view, e eVar) {
        return (ItemCartRvBinding) bind(eVar, view, R.layout.item_cart_rv);
    }
}
