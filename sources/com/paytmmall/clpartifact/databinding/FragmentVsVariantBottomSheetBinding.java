package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;

public abstract class FragmentVsVariantBottomSheetBinding extends ViewDataBinding {
    public final Button doneBtn;
    public final ProgressBar progressBar;
    public final ImageView varianrIV;
    public final TextView variantNameTV;
    public final RecyclerView variantRV;

    protected FragmentVsVariantBottomSheetBinding(e eVar, View view, int i2, Button button, ProgressBar progressBar2, ImageView imageView, TextView textView, RecyclerView recyclerView) {
        super(eVar, view, i2);
        this.doneBtn = button;
        this.progressBar = progressBar2;
        this.varianrIV = imageView;
        this.variantNameTV = textView;
        this.variantRV = recyclerView;
    }

    public static FragmentVsVariantBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static FragmentVsVariantBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (FragmentVsVariantBottomSheetBinding) f.a(layoutInflater, R.layout.fragment_vs_variant_bottom_sheet, viewGroup, z, eVar);
    }

    public static FragmentVsVariantBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static FragmentVsVariantBottomSheetBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (FragmentVsVariantBottomSheetBinding) f.a(layoutInflater, R.layout.fragment_vs_variant_bottom_sheet, (ViewGroup) null, false, eVar);
    }

    public static FragmentVsVariantBottomSheetBinding bind(View view) {
        return bind(view, f.a());
    }

    public static FragmentVsVariantBottomSheetBinding bind(View view, e eVar) {
        return (FragmentVsVariantBottomSheetBinding) bind(eVar, view, R.layout.fragment_vs_variant_bottom_sheet);
    }
}
