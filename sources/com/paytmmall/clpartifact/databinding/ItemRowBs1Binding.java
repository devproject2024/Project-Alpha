package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;

public abstract class ItemRowBs1Binding extends ViewDataBinding {
    public final TextView itemAddTag;
    protected CLPItemRVViewHolder mHandler;
    protected Item mItem;
    protected Integer mPosition;

    public abstract void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder);

    public abstract void setItem(Item item);

    public abstract void setPosition(Integer num);

    protected ItemRowBs1Binding(e eVar, View view, int i2, TextView textView) {
        super(eVar, view, i2);
        this.itemAddTag = textView;
    }

    public Item getItem() {
        return this.mItem;
    }

    public CLPItemRVViewHolder getHandler() {
        return this.mHandler;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public static ItemRowBs1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemRowBs1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemRowBs1Binding) f.a(layoutInflater, R.layout.item_row_bs1, viewGroup, z, eVar);
    }

    public static ItemRowBs1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemRowBs1Binding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemRowBs1Binding) f.a(layoutInflater, R.layout.item_row_bs1, (ViewGroup) null, false, eVar);
    }

    public static ItemRowBs1Binding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemRowBs1Binding bind(View view, e eVar) {
        return (ItemRowBs1Binding) bind(eVar, view, R.layout.item_row_bs1);
    }
}
