package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.stores.CJRStoreList;
import com.paytmmall.clpartifact.view.viewHolder.StoreListViewHolder;

public abstract class FragmentItemBinding extends ViewDataBinding {
    public final TextView Addresstxt;
    public final TextView call;
    public final TextView direction;
    public final TextView directiontxt;
    protected StoreListViewHolder mHandler;
    protected CJRStoreList mItem;
    public final ImageView map;
    public final TextView name;
    public final TextView timetxt;

    public abstract void setHandler(StoreListViewHolder storeListViewHolder);

    public abstract void setItem(CJRStoreList cJRStoreList);

    protected FragmentItemBinding(e eVar, View view, int i2, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, TextView textView5, TextView textView6) {
        super(eVar, view, i2);
        this.Addresstxt = textView;
        this.call = textView2;
        this.direction = textView3;
        this.directiontxt = textView4;
        this.map = imageView;
        this.name = textView5;
        this.timetxt = textView6;
    }

    public CJRStoreList getItem() {
        return this.mItem;
    }

    public StoreListViewHolder getHandler() {
        return this.mHandler;
    }

    public static FragmentItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static FragmentItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (FragmentItemBinding) f.a(layoutInflater, R.layout.fragment_item, viewGroup, z, eVar);
    }

    public static FragmentItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static FragmentItemBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (FragmentItemBinding) f.a(layoutInflater, R.layout.fragment_item, (ViewGroup) null, false, eVar);
    }

    public static FragmentItemBinding bind(View view) {
        return bind(view, f.a());
    }

    public static FragmentItemBinding bind(View view, e eVar) {
        return (FragmentItemBinding) bind(eVar, view, R.layout.fragment_item);
    }
}
