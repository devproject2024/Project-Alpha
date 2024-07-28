package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.viewHolder.TreeWidgetViewHolder;

public abstract class ItemTreeOneFixedBinding extends ViewDataBinding {
    public final ImageView arrowFixed;
    protected TreeWidgetViewHolder mHandler;
    protected Boolean mISCOLLAPSED;
    protected View mView;
    public final LinearLayout treeFixed;
    public final RecyclerView treeRecyclerview;

    public abstract void setHandler(TreeWidgetViewHolder treeWidgetViewHolder);

    public abstract void setISCOLLAPSED(Boolean bool);

    public abstract void setView(View view);

    protected ItemTreeOneFixedBinding(e eVar, android.view.View view, int i2, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView) {
        super(eVar, view, i2);
        this.arrowFixed = imageView;
        this.treeFixed = linearLayout;
        this.treeRecyclerview = recyclerView;
    }

    public View getView() {
        return this.mView;
    }

    public TreeWidgetViewHolder getHandler() {
        return this.mHandler;
    }

    public Boolean getISCOLLAPSED() {
        return this.mISCOLLAPSED;
    }

    public static ItemTreeOneFixedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemTreeOneFixedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemTreeOneFixedBinding) f.a(layoutInflater, R.layout.item_tree_one_fixed, viewGroup, z, eVar);
    }

    public static ItemTreeOneFixedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemTreeOneFixedBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemTreeOneFixedBinding) f.a(layoutInflater, R.layout.item_tree_one_fixed, (ViewGroup) null, false, eVar);
    }

    public static ItemTreeOneFixedBinding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static ItemTreeOneFixedBinding bind(android.view.View view, e eVar) {
        return (ItemTreeOneFixedBinding) bind(eVar, view, R.layout.item_tree_one_fixed);
    }
}
