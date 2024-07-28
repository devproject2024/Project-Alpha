package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;

public abstract class ClpFlashSaleLayoutBinding extends ViewDataBinding {
    public final View divider;
    public final RecyclerView timeSlotRv;

    protected ClpFlashSaleLayoutBinding(e eVar, View view, int i2, View view2, RecyclerView recyclerView) {
        super(eVar, view, i2);
        this.divider = view2;
        this.timeSlotRv = recyclerView;
    }

    public static ClpFlashSaleLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ClpFlashSaleLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ClpFlashSaleLayoutBinding) f.a(layoutInflater, R.layout.clp_flash_sale_layout, viewGroup, z, eVar);
    }

    public static ClpFlashSaleLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ClpFlashSaleLayoutBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ClpFlashSaleLayoutBinding) f.a(layoutInflater, R.layout.clp_flash_sale_layout, (ViewGroup) null, false, eVar);
    }

    public static ClpFlashSaleLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ClpFlashSaleLayoutBinding bind(View view, e eVar) {
        return (ClpFlashSaleLayoutBinding) bind(eVar, view, R.layout.clp_flash_sale_layout);
    }
}
