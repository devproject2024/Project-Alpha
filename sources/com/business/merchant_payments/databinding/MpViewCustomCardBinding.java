package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.model.customcards.CustomCardUIModel;

public abstract class MpViewCustomCardBinding extends ViewDataBinding {
    public final TextView body;
    public final TextView cardCta;
    public final ConstraintLayout cardRoot;
    public final TextView header;
    public final ImageView icCard;
    public final ImageView icCloseCard;
    public CustomCardUIModel mModel;

    public abstract void setModel(CustomCardUIModel customCardUIModel);

    public MpViewCustomCardBinding(Object obj, View view, int i2, TextView textView, TextView textView2, ConstraintLayout constraintLayout, TextView textView3, ImageView imageView, ImageView imageView2) {
        super(obj, view, i2);
        this.body = textView;
        this.cardCta = textView2;
        this.cardRoot = constraintLayout;
        this.header = textView3;
        this.icCard = imageView;
        this.icCloseCard = imageView2;
    }

    public CustomCardUIModel getModel() {
        return this.mModel;
    }

    public static MpViewCustomCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpViewCustomCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpViewCustomCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_view_custom_card, viewGroup, z, obj);
    }

    public static MpViewCustomCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpViewCustomCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpViewCustomCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_view_custom_card, (ViewGroup) null, false, obj);
    }

    public static MpViewCustomCardBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpViewCustomCardBinding bind(View view, Object obj) {
        return (MpViewCustomCardBinding) ViewDataBinding.bind(obj, view, R.layout.mp_view_custom_card);
    }
}
