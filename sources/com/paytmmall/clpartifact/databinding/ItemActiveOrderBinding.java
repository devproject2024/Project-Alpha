package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;

public abstract class ItemActiveOrderBinding extends ViewDataBinding {
    protected CLPItemRVAdapter mAdapter;
    protected CLPItemRVViewHolder mHandler;
    protected Item mItem;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected Integer mPosition;

    public abstract void setAdapter(CLPItemRVAdapter cLPItemRVAdapter);

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setItem(Item item);

    public abstract void setLayoutManager(RecyclerView.LayoutManager layoutManager);

    public abstract void setPosition(Integer num);

    protected ItemActiveOrderBinding(e eVar, View view, int i2) {
        super(eVar, view, i2);
    }

    public Item getItem() {
        return this.mItem;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.mLayoutManager;
    }

    public CLPItemRVAdapter getAdapter() {
        return this.mAdapter;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public CLPItemRVViewHolder getHandler() {
        return this.mHandler;
    }

    public static ItemActiveOrderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemActiveOrderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemActiveOrderBinding) f.a(layoutInflater, R.layout.item_active_order, viewGroup, z, eVar);
    }

    public static ItemActiveOrderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemActiveOrderBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemActiveOrderBinding) f.a(layoutInflater, R.layout.item_active_order, (ViewGroup) null, false, eVar);
    }

    public static ItemActiveOrderBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemActiveOrderBinding bind(View view, e eVar) {
        return (ItemActiveOrderBinding) bind(eVar, view, R.layout.item_active_order);
    }
}
