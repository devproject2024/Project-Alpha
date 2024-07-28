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
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithRV;

public abstract class ItemSmartIconButton2xnRootBinding extends ViewDataBinding {
    public final ConstraintLayout clParent;
    protected CLPItemRVAdapter mAdapter;
    protected CLPItemVHWithRV mHandler;
    protected Item mItem;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected Boolean mTitle;
    protected View mView;
    public final RecyclerView rvThinBanner;
    public final CLPRobotoTextView viewAll;
    public final CLPRobotoTextView viewName;

    public abstract void setAdapter(CLPItemRVAdapter cLPItemRVAdapter);

    public abstract void setHandler(CLPItemVHWithRV cLPItemVHWithRV);

    public abstract void setItem(Item item);

    public abstract void setLayoutManager(RecyclerView.LayoutManager layoutManager);

    public abstract void setTitle(Boolean bool);

    public abstract void setView(View view);

    protected ItemSmartIconButton2xnRootBinding(e eVar, android.view.View view, int i2, ConstraintLayout constraintLayout, RecyclerView recyclerView, CLPRobotoTextView cLPRobotoTextView, CLPRobotoTextView cLPRobotoTextView2) {
        super(eVar, view, i2);
        this.clParent = constraintLayout;
        this.rvThinBanner = recyclerView;
        this.viewAll = cLPRobotoTextView;
        this.viewName = cLPRobotoTextView2;
    }

    public Item getItem() {
        return this.mItem;
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

    public static ItemSmartIconButton2xnRootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemSmartIconButton2xnRootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemSmartIconButton2xnRootBinding) f.a(layoutInflater, R.layout.item_smart_icon_button_2xn_root, viewGroup, z, eVar);
    }

    public static ItemSmartIconButton2xnRootBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemSmartIconButton2xnRootBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemSmartIconButton2xnRootBinding) f.a(layoutInflater, R.layout.item_smart_icon_button_2xn_root, (ViewGroup) null, false, eVar);
    }

    public static ItemSmartIconButton2xnRootBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static ItemSmartIconButton2xnRootBinding bind(android.view.View view, e eVar) {
        return (ItemSmartIconButton2xnRootBinding) bind(eVar, view, R.layout.item_smart_icon_button_2xn_root);
    }
}
