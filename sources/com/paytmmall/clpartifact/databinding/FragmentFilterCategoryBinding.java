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

public abstract class FragmentFilterCategoryBinding extends ViewDataBinding {
    public final LinearLayout lytSearch;
    public final RecyclerView rvFilterValues;

    protected FragmentFilterCategoryBinding(e eVar, View view, int i2, LinearLayout linearLayout, RecyclerView recyclerView) {
        super(eVar, view, i2);
        this.lytSearch = linearLayout;
        this.rvFilterValues = recyclerView;
    }

    public static FragmentFilterCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static FragmentFilterCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (FragmentFilterCategoryBinding) f.a(layoutInflater, R.layout.fragment_filter_category, viewGroup, z, eVar);
    }

    public static FragmentFilterCategoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static FragmentFilterCategoryBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (FragmentFilterCategoryBinding) f.a(layoutInflater, R.layout.fragment_filter_category, (ViewGroup) null, false, eVar);
    }

    public static FragmentFilterCategoryBinding bind(View view) {
        return bind(view, f.a());
    }

    public static FragmentFilterCategoryBinding bind(View view, e eVar) {
        return (FragmentFilterCategoryBinding) bind(eVar, view, R.layout.fragment_filter_category);
    }
}
