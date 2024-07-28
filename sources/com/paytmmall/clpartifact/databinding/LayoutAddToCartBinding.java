package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;

public abstract class LayoutAddToCartBinding extends ViewDataBinding {
    protected LayoutAddToCartBinding(e eVar, View view, int i2) {
        super(eVar, view, i2);
    }

    public static LayoutAddToCartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static LayoutAddToCartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (LayoutAddToCartBinding) f.a(layoutInflater, R.layout.layout_add_to_cart, viewGroup, z, eVar);
    }

    public static LayoutAddToCartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static LayoutAddToCartBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (LayoutAddToCartBinding) f.a(layoutInflater, R.layout.layout_add_to_cart, (ViewGroup) null, false, eVar);
    }

    public static LayoutAddToCartBinding bind(View view) {
        return bind(view, f.a());
    }

    public static LayoutAddToCartBinding bind(View view, e eVar) {
        return (LayoutAddToCartBinding) bind(eVar, view, R.layout.layout_add_to_cart);
    }
}
