package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;

public abstract class MpFragmentRequestMoneyBinding extends ViewDataBinding {
    public final RecyclerView merhcantLinkRv;
    public final ImageView noImg;
    public final LinearLayout noItemContainer;
    public final FrameLayout progressBarLyt;
    public final CoordinatorLayout requestMoneyContainerCl;
    public final RelativeLayout requestMoneyLayout;
    public final CustomTextView tvNoDataText;

    public MpFragmentRequestMoneyBinding(Object obj, View view, int i2, RecyclerView recyclerView, ImageView imageView, LinearLayout linearLayout, FrameLayout frameLayout, CoordinatorLayout coordinatorLayout, RelativeLayout relativeLayout, CustomTextView customTextView) {
        super(obj, view, i2);
        this.merhcantLinkRv = recyclerView;
        this.noImg = imageView;
        this.noItemContainer = linearLayout;
        this.progressBarLyt = frameLayout;
        this.requestMoneyContainerCl = coordinatorLayout;
        this.requestMoneyLayout = relativeLayout;
        this.tvNoDataText = customTextView;
    }

    public static MpFragmentRequestMoneyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpFragmentRequestMoneyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpFragmentRequestMoneyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_fragment_request_money, viewGroup, z, obj);
    }

    public static MpFragmentRequestMoneyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpFragmentRequestMoneyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpFragmentRequestMoneyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_fragment_request_money, (ViewGroup) null, false, obj);
    }

    public static MpFragmentRequestMoneyBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpFragmentRequestMoneyBinding bind(View view, Object obj) {
        return (MpFragmentRequestMoneyBinding) ViewDataBinding.bind(obj, view, R.layout.mp_fragment_request_money);
    }
}
