package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPTreeViewHolder;

public abstract class ItemTreeOneBinding extends ViewDataBinding {
    public final ImageView imageViewArrow;
    protected CLPTreeViewHolder mHandler;
    protected Item mItem;
    protected String mLabel;
    public final RecyclerView treeExpande;

    public abstract void setHandler(CLPTreeViewHolder cLPTreeViewHolder);

    public abstract void setItem(Item item);

    public abstract void setLabel(String str);

    protected ItemTreeOneBinding(e eVar, View view, int i2, ImageView imageView, RecyclerView recyclerView) {
        super(eVar, view, i2);
        this.imageViewArrow = imageView;
        this.treeExpande = recyclerView;
    }

    public Item getItem() {
        return this.mItem;
    }

    public CLPTreeViewHolder getHandler() {
        return this.mHandler;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public static ItemTreeOneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemTreeOneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemTreeOneBinding) f.a(layoutInflater, R.layout.item_tree_one, viewGroup, z, eVar);
    }

    public static ItemTreeOneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemTreeOneBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemTreeOneBinding) f.a(layoutInflater, R.layout.item_tree_one, (ViewGroup) null, false, eVar);
    }

    public static ItemTreeOneBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemTreeOneBinding bind(View view, e eVar) {
        return (ItemTreeOneBinding) bind(eVar, view, R.layout.item_tree_one);
    }
}
