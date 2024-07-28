package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;

public abstract class FragmentSmartIconListBinding extends ViewDataBinding {
    public final RecyclerView recyclerViewItem;

    protected FragmentSmartIconListBinding(e eVar, View view, int i2, RecyclerView recyclerView) {
        super(eVar, view, i2);
        this.recyclerViewItem = recyclerView;
    }

    public static FragmentSmartIconListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static FragmentSmartIconListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (FragmentSmartIconListBinding) f.a(layoutInflater, R.layout.fragment_smart_icon_list, viewGroup, z, eVar);
    }

    public static FragmentSmartIconListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static FragmentSmartIconListBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (FragmentSmartIconListBinding) f.a(layoutInflater, R.layout.fragment_smart_icon_list, (ViewGroup) null, false, eVar);
    }

    public static FragmentSmartIconListBinding bind(View view) {
        return bind(view, f.a());
    }

    public static FragmentSmartIconListBinding bind(View view, e eVar) {
        return (FragmentSmartIconListBinding) bind(eVar, view, R.layout.fragment_smart_icon_list);
    }
}
