package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPTreeViewHolder;

public abstract class ExpandTreeBinding extends ViewDataBinding {
    protected CLPTreeViewHolder mHandler;
    protected Item mItem;
    protected Integer mPosition;

    public abstract void setHandler(CLPTreeViewHolder cLPTreeViewHolder);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ExpandTreeBinding(e eVar, View view, int i2) {
        super(eVar, view, i2);
    }

    public Item getItem() {
        return this.mItem;
    }

    public CLPTreeViewHolder getHandler() {
        return this.mHandler;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static ExpandTreeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ExpandTreeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ExpandTreeBinding) f.a(layoutInflater, R.layout.expand_tree, viewGroup, z, eVar);
    }

    public static ExpandTreeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ExpandTreeBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ExpandTreeBinding) f.a(layoutInflater, R.layout.expand_tree, (ViewGroup) null, false, eVar);
    }

    public static ExpandTreeBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ExpandTreeBinding bind(View view, e eVar) {
        return (ExpandTreeBinding) bind(eVar, view, R.layout.expand_tree);
    }
}
