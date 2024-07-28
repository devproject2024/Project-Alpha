package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;

public abstract class ClpItemProgressbarBinding extends ViewDataBinding {
    protected ClpItemProgressbarBinding(e eVar, View view, int i2) {
        super(eVar, view, i2);
    }

    public static ClpItemProgressbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ClpItemProgressbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ClpItemProgressbarBinding) f.a(layoutInflater, R.layout.clp_item_progressbar, viewGroup, z, eVar);
    }

    public static ClpItemProgressbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ClpItemProgressbarBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ClpItemProgressbarBinding) f.a(layoutInflater, R.layout.clp_item_progressbar, (ViewGroup) null, false, eVar);
    }

    public static ClpItemProgressbarBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ClpItemProgressbarBinding bind(View view, e eVar) {
        return (ClpItemProgressbarBinding) bind(eVar, view, R.layout.clp_item_progressbar);
    }
}
