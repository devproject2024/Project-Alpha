package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;

public abstract class FragmentItemListBinding extends ViewDataBinding {
    public final LinearLayout list;
    public final View storeNotFoundLayout;
    public final RecyclerView storeRecyclerview;
    public final LinearLayout storelayout;

    protected FragmentItemListBinding(e eVar, View view, int i2, LinearLayout linearLayout, View view2, RecyclerView recyclerView, LinearLayout linearLayout2) {
        super(eVar, view, i2);
        this.list = linearLayout;
        this.storeNotFoundLayout = view2;
        this.storeRecyclerview = recyclerView;
        this.storelayout = linearLayout2;
    }

    public static FragmentItemListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static FragmentItemListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (FragmentItemListBinding) f.a(layoutInflater, R.layout.fragment_item_list, viewGroup, z, eVar);
    }

    public static FragmentItemListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static FragmentItemListBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (FragmentItemListBinding) f.a(layoutInflater, R.layout.fragment_item_list, (ViewGroup) null, false, eVar);
    }

    public static FragmentItemListBinding bind(View view) {
        return bind(view, f.a());
    }

    public static FragmentItemListBinding bind(View view, e eVar) {
        return (FragmentItemListBinding) bind(eVar, view, R.layout.fragment_item_list);
    }
}
