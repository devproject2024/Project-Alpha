package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.MpRoboTextView;

public abstract class MpNoSettlementsDataViewBinding extends ViewDataBinding {
    public final LinearLayout calendarContainer;
    public final MpRoboTextView noSettlementsDataDesc;
    public final ImageView noSettlementsDataImage;

    public MpNoSettlementsDataViewBinding(Object obj, View view, int i2, LinearLayout linearLayout, MpRoboTextView mpRoboTextView, ImageView imageView) {
        super(obj, view, i2);
        this.calendarContainer = linearLayout;
        this.noSettlementsDataDesc = mpRoboTextView;
        this.noSettlementsDataImage = imageView;
    }

    public static MpNoSettlementsDataViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpNoSettlementsDataViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpNoSettlementsDataViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_no_settlements_data_view, viewGroup, z, obj);
    }

    public static MpNoSettlementsDataViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpNoSettlementsDataViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpNoSettlementsDataViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_no_settlements_data_view, (ViewGroup) null, false, obj);
    }

    public static MpNoSettlementsDataViewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpNoSettlementsDataViewBinding bind(View view, Object obj) {
        return (MpNoSettlementsDataViewBinding) ViewDataBinding.bind(obj, view, R.layout.mp_no_settlements_data_view);
    }
}
