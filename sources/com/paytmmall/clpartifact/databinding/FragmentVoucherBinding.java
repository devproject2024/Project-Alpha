package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;

public abstract class FragmentVoucherBinding extends ViewDataBinding {
    public final LinearLayout buyVoucherContainer;
    public final View noVoucherLayout;
    public final ProgressBar progressBar;
    public final RecyclerView voucherRv;

    protected FragmentVoucherBinding(e eVar, View view, int i2, LinearLayout linearLayout, View view2, ProgressBar progressBar2, RecyclerView recyclerView) {
        super(eVar, view, i2);
        this.buyVoucherContainer = linearLayout;
        this.noVoucherLayout = view2;
        this.progressBar = progressBar2;
        this.voucherRv = recyclerView;
    }

    public static FragmentVoucherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static FragmentVoucherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (FragmentVoucherBinding) f.a(layoutInflater, R.layout.fragment_voucher, viewGroup, z, eVar);
    }

    public static FragmentVoucherBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static FragmentVoucherBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (FragmentVoucherBinding) f.a(layoutInflater, R.layout.fragment_voucher, (ViewGroup) null, false, eVar);
    }

    public static FragmentVoucherBinding bind(View view) {
        return bind(view, f.a());
    }

    public static FragmentVoucherBinding bind(View view, e eVar) {
        return (FragmentVoucherBinding) bind(eVar, view, R.layout.fragment_voucher);
    }
}
