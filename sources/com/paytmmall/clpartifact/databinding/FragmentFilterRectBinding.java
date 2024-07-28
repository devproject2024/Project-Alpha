package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;

public abstract class FragmentFilterRectBinding extends ViewDataBinding {
    public final LinearLayout lytSearch;
    public final RecyclerView rvFilterValues;
    public final EditText searchTxt;

    protected FragmentFilterRectBinding(e eVar, View view, int i2, LinearLayout linearLayout, RecyclerView recyclerView, EditText editText) {
        super(eVar, view, i2);
        this.lytSearch = linearLayout;
        this.rvFilterValues = recyclerView;
        this.searchTxt = editText;
    }

    public static FragmentFilterRectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static FragmentFilterRectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (FragmentFilterRectBinding) f.a(layoutInflater, R.layout.fragment_filter_rect, viewGroup, z, eVar);
    }

    public static FragmentFilterRectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static FragmentFilterRectBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (FragmentFilterRectBinding) f.a(layoutInflater, R.layout.fragment_filter_rect, (ViewGroup) null, false, eVar);
    }

    public static FragmentFilterRectBinding bind(View view) {
        return bind(view, f.a());
    }

    public static FragmentFilterRectBinding bind(View view, e eVar) {
        return (FragmentFilterRectBinding) bind(eVar, view, R.layout.fragment_filter_rect);
    }
}
