package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;

public abstract class MpSmartGridBinding extends ViewDataBinding {
    public final ConstraintLayout grid;
    public final AppCompatImageView item0Icon;
    public final AppCompatTextView item0Text;
    public final AppCompatImageView item1Icon;
    public final AppCompatTextView item1Text;
    public final AppCompatImageView item2Icon;
    public final AppCompatTextView item2Text;
    public final AppCompatImageView item3Icon;
    public final AppCompatTextView item3Text;

    public MpSmartGridBinding(Object obj, View view, int i2, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView2, AppCompatImageView appCompatImageView3, AppCompatTextView appCompatTextView3, AppCompatImageView appCompatImageView4, AppCompatTextView appCompatTextView4) {
        super(obj, view, i2);
        this.grid = constraintLayout;
        this.item0Icon = appCompatImageView;
        this.item0Text = appCompatTextView;
        this.item1Icon = appCompatImageView2;
        this.item1Text = appCompatTextView2;
        this.item2Icon = appCompatImageView3;
        this.item2Text = appCompatTextView3;
        this.item3Icon = appCompatImageView4;
        this.item3Text = appCompatTextView4;
    }

    public static MpSmartGridBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpSmartGridBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpSmartGridBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_smart_grid, viewGroup, z, obj);
    }

    public static MpSmartGridBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpSmartGridBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpSmartGridBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_smart_grid, (ViewGroup) null, false, obj);
    }

    public static MpSmartGridBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpSmartGridBinding bind(View view, Object obj) {
        return (MpSmartGridBinding) ViewDataBinding.bind(obj, view, R.layout.mp_smart_grid);
    }
}
