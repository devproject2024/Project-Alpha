package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.MpRoboTextView;

public abstract class MpCommonOverlayDialogBinding extends ViewDataBinding {
    public final MpRoboTextView btnTxt;
    public final ImageView crossBtn;
    public final MpRoboTextView description;
    public final MpRoboTextView title;

    public MpCommonOverlayDialogBinding(Object obj, View view, int i2, MpRoboTextView mpRoboTextView, ImageView imageView, MpRoboTextView mpRoboTextView2, MpRoboTextView mpRoboTextView3) {
        super(obj, view, i2);
        this.btnTxt = mpRoboTextView;
        this.crossBtn = imageView;
        this.description = mpRoboTextView2;
        this.title = mpRoboTextView3;
    }

    public static MpCommonOverlayDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpCommonOverlayDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpCommonOverlayDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_common_overlay_dialog, viewGroup, z, obj);
    }

    public static MpCommonOverlayDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpCommonOverlayDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpCommonOverlayDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_common_overlay_dialog, (ViewGroup) null, false, obj);
    }

    public static MpCommonOverlayDialogBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpCommonOverlayDialogBinding bind(View view, Object obj) {
        return (MpCommonOverlayDialogBinding) ViewDataBinding.bind(obj, view, R.layout.mp_common_overlay_dialog);
    }
}
