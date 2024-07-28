package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.MpRoboTextView;

public abstract class MpTitleTileBinding extends ViewDataBinding {
    public final LinearLayout calendarContainer;
    public final MpRoboTextView dateRangeText;
    public final MpRoboTextView tileTitle;
    public final ConstraintLayout titleTileRoot;

    public MpTitleTileBinding(Object obj, View view, int i2, LinearLayout linearLayout, MpRoboTextView mpRoboTextView, MpRoboTextView mpRoboTextView2, ConstraintLayout constraintLayout) {
        super(obj, view, i2);
        this.calendarContainer = linearLayout;
        this.dateRangeText = mpRoboTextView;
        this.tileTitle = mpRoboTextView2;
        this.titleTileRoot = constraintLayout;
    }

    public static MpTitleTileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpTitleTileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpTitleTileBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_title_tile, viewGroup, z, obj);
    }

    public static MpTitleTileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpTitleTileBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpTitleTileBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_title_tile, (ViewGroup) null, false, obj);
    }

    public static MpTitleTileBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpTitleTileBinding bind(View view, Object obj) {
        return (MpTitleTileBinding) ViewDataBinding.bind(obj, view, R.layout.mp_title_tile);
    }
}
