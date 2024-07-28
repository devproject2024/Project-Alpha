package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;

public abstract class FragmentHsVariantBottomSheetBinding extends ViewDataBinding {
    public final ProgressBar progressBar;
    public final TextView variantNameTV;
    public final RecyclerView variantRV;

    protected FragmentHsVariantBottomSheetBinding(e eVar, View view, int i2, ProgressBar progressBar2, TextView textView, RecyclerView recyclerView) {
        super(eVar, view, i2);
        this.progressBar = progressBar2;
        this.variantNameTV = textView;
        this.variantRV = recyclerView;
    }

    public static FragmentHsVariantBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static FragmentHsVariantBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (FragmentHsVariantBottomSheetBinding) f.a(layoutInflater, R.layout.fragment_hs_variant_bottom_sheet, viewGroup, z, eVar);
    }

    public static FragmentHsVariantBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static FragmentHsVariantBottomSheetBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (FragmentHsVariantBottomSheetBinding) f.a(layoutInflater, R.layout.fragment_hs_variant_bottom_sheet, (ViewGroup) null, false, eVar);
    }

    public static FragmentHsVariantBottomSheetBinding bind(View view) {
        return bind(view, f.a());
    }

    public static FragmentHsVariantBottomSheetBinding bind(View view, e eVar) {
        return (FragmentHsVariantBottomSheetBinding) bind(eVar, view, R.layout.fragment_hs_variant_bottom_sheet);
    }
}
