package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.View;

public abstract class Carousel13Binding extends ViewDataBinding {
    public final RecyclerView carousel13Rv;
    protected View mView;

    public abstract void setView(View view);

    protected Carousel13Binding(e eVar, android.view.View view, int i2, RecyclerView recyclerView) {
        super(eVar, view, i2);
        this.carousel13Rv = recyclerView;
    }

    public View getView() {
        return this.mView;
    }

    public static Carousel13Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static Carousel13Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (Carousel13Binding) f.a(layoutInflater, R.layout.carousel_1_3, viewGroup, z, eVar);
    }

    public static Carousel13Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static Carousel13Binding inflate(LayoutInflater layoutInflater, e eVar) {
        return (Carousel13Binding) f.a(layoutInflater, R.layout.carousel_1_3, (ViewGroup) null, false, eVar);
    }

    public static Carousel13Binding bind(android.view.View view) {
        return bind(view, f.a());
    }

    public static Carousel13Binding bind(android.view.View view, e eVar) {
        return (Carousel13Binding) bind(eVar, view, R.layout.carousel_1_3);
    }
}
