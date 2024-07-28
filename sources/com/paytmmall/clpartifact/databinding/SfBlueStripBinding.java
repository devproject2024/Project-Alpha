package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;

public abstract class SfBlueStripBinding extends ViewDataBinding {
    public final View view;
    public final View view1;

    protected SfBlueStripBinding(e eVar, View view2, int i2, View view3, View view4) {
        super(eVar, view2, i2);
        this.view = view3;
        this.view1 = view4;
    }

    public static SfBlueStripBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static SfBlueStripBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (SfBlueStripBinding) f.a(layoutInflater, R.layout.sf_blue_strip, viewGroup, z, eVar);
    }

    public static SfBlueStripBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static SfBlueStripBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (SfBlueStripBinding) f.a(layoutInflater, R.layout.sf_blue_strip, (ViewGroup) null, false, eVar);
    }

    public static SfBlueStripBinding bind(View view2) {
        return bind(view2, f.a());
    }

    public static SfBlueStripBinding bind(View view2, e eVar) {
        return (SfBlueStripBinding) bind(eVar, view2, R.layout.sf_blue_strip);
    }
}
