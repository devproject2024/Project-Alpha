package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextInputEditText;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;

public abstract class MpFragmentSaveFeedbackBinding extends ViewDataBinding {
    public final CustomTextView btnSubmit;
    public final ConstraintLayout clResponseBox;
    public final CustomTextInputEditText etResponse;
    public final ImageView ivBack;
    public final AppCompatImageView ivReason1;
    public final AppCompatImageView ivReason2;
    public final AppCompatImageView ivReasonOther;
    public final CustomTextView pfbTextView;
    public final View seperator1;
    public final View seperator2;
    public final CustomTextView textView6;
    public final CustomTextView tvReason2;
    public final CustomTextView tvReasonOther;
    public final CustomTextView tvYourComments;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpFragmentSaveFeedbackBinding(Object obj, View view, int i2, CustomTextView customTextView, ConstraintLayout constraintLayout, CustomTextInputEditText customTextInputEditText, ImageView imageView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, CustomTextView customTextView2, View view2, View view3, CustomTextView customTextView3, CustomTextView customTextView4, CustomTextView customTextView5, CustomTextView customTextView6) {
        super(obj, view, i2);
        this.btnSubmit = customTextView;
        this.clResponseBox = constraintLayout;
        this.etResponse = customTextInputEditText;
        this.ivBack = imageView;
        this.ivReason1 = appCompatImageView;
        this.ivReason2 = appCompatImageView2;
        this.ivReasonOther = appCompatImageView3;
        this.pfbTextView = customTextView2;
        this.seperator1 = view2;
        this.seperator2 = view3;
        this.textView6 = customTextView3;
        this.tvReason2 = customTextView4;
        this.tvReasonOther = customTextView5;
        this.tvYourComments = customTextView6;
    }

    public static MpFragmentSaveFeedbackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpFragmentSaveFeedbackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpFragmentSaveFeedbackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_fragment_save_feedback, viewGroup, z, obj);
    }

    public static MpFragmentSaveFeedbackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpFragmentSaveFeedbackBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpFragmentSaveFeedbackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_fragment_save_feedback, (ViewGroup) null, false, obj);
    }

    public static MpFragmentSaveFeedbackBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpFragmentSaveFeedbackBinding bind(View view, Object obj) {
        return (MpFragmentSaveFeedbackBinding) ViewDataBinding.bind(obj, view, R.layout.mp_fragment_save_feedback);
    }
}
