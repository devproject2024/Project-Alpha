package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.widget.ShimmerFrameLayout;

public abstract class PrProfileReactivateBinding extends ViewDataBinding {
    public final LinearLayout llDeactivate;
    public final ShimmerFrameLayout shimmerDeactivate;
    public final TextView tvAccountStatus;
    public final TextView tvDeactivateAccount;
    public final TextView tvStatusMsg;
    public final PrViewEditChangeInProgressNewBinding viewDisplayDeactivationStatus;

    public PrProfileReactivateBinding(Object obj, View view, int i2, LinearLayout linearLayout, ShimmerFrameLayout shimmerFrameLayout, TextView textView, TextView textView2, TextView textView3, PrViewEditChangeInProgressNewBinding prViewEditChangeInProgressNewBinding) {
        super(obj, view, i2);
        this.llDeactivate = linearLayout;
        this.shimmerDeactivate = shimmerFrameLayout;
        this.tvAccountStatus = textView;
        this.tvDeactivateAccount = textView2;
        this.tvStatusMsg = textView3;
        this.viewDisplayDeactivationStatus = prViewEditChangeInProgressNewBinding;
        setContainedBinding(prViewEditChangeInProgressNewBinding);
    }

    public static PrProfileReactivateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrProfileReactivateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrProfileReactivateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_profile_reactivate, viewGroup, z, obj);
    }

    public static PrProfileReactivateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrProfileReactivateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrProfileReactivateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_profile_reactivate, (ViewGroup) null, false, obj);
    }

    public static PrProfileReactivateBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrProfileReactivateBinding bind(View view, Object obj) {
        return (PrProfileReactivateBinding) ViewDataBinding.bind(obj, view, R.layout.pr_profile_reactivate);
    }
}
