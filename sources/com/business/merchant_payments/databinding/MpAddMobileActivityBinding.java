package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.notificationsettings.viewmodel.AddMobileViewModel;
import com.google.android.material.textfield.TextInputEditText;

public abstract class MpAddMobileActivityBinding extends ViewDataBinding {
    public final ImageView back;
    public final RelativeLayout button;
    public final CustomTextView buttonText;
    public final CoordinatorLayout coordinatorLayout;
    public final TextInputEditText etAddress1;
    public final RelativeLayout layoutBankHeaderBar;
    public AddMobileViewModel mViewModel;

    public abstract void setViewModel(AddMobileViewModel addMobileViewModel);

    public MpAddMobileActivityBinding(Object obj, View view, int i2, ImageView imageView, RelativeLayout relativeLayout, CustomTextView customTextView, CoordinatorLayout coordinatorLayout2, TextInputEditText textInputEditText, RelativeLayout relativeLayout2) {
        super(obj, view, i2);
        this.back = imageView;
        this.button = relativeLayout;
        this.buttonText = customTextView;
        this.coordinatorLayout = coordinatorLayout2;
        this.etAddress1 = textInputEditText;
        this.layoutBankHeaderBar = relativeLayout2;
    }

    public AddMobileViewModel getViewModel() {
        return this.mViewModel;
    }

    public static MpAddMobileActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpAddMobileActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpAddMobileActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_add_mobile_activity, viewGroup, z, obj);
    }

    public static MpAddMobileActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpAddMobileActivityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpAddMobileActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_add_mobile_activity, (ViewGroup) null, false, obj);
    }

    public static MpAddMobileActivityBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpAddMobileActivityBinding bind(View view, Object obj) {
        return (MpAddMobileActivityBinding) ViewDataBinding.bind(obj, view, R.layout.mp_add_mobile_activity);
    }
}
