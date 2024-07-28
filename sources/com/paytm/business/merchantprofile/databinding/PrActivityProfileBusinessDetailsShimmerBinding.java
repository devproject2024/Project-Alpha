package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.widget.ShimmerFrameLayout;

public abstract class PrActivityProfileBusinessDetailsShimmerBinding extends ViewDataBinding {
    public final RelativeLayout llBusinessNameHeader1;
    public final RelativeLayout llBusinessNameHeader2;
    public final ShimmerFrameLayout sBfContainer;
    public final RelativeLayout shmrRlBusinessDetailsContainer1;
    public final RelativeLayout shmrRlBusinessDetailsContainer2;
    public final LinearLayout shmrRlParentContainer;

    public PrActivityProfileBusinessDetailsShimmerBinding(Object obj, View view, int i2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ShimmerFrameLayout shimmerFrameLayout, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, LinearLayout linearLayout) {
        super(obj, view, i2);
        this.llBusinessNameHeader1 = relativeLayout;
        this.llBusinessNameHeader2 = relativeLayout2;
        this.sBfContainer = shimmerFrameLayout;
        this.shmrRlBusinessDetailsContainer1 = relativeLayout3;
        this.shmrRlBusinessDetailsContainer2 = relativeLayout4;
        this.shmrRlParentContainer = linearLayout;
    }

    public static PrActivityProfileBusinessDetailsShimmerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrActivityProfileBusinessDetailsShimmerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrActivityProfileBusinessDetailsShimmerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_activity_profile_business_details_shimmer, viewGroup, z, obj);
    }

    public static PrActivityProfileBusinessDetailsShimmerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrActivityProfileBusinessDetailsShimmerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrActivityProfileBusinessDetailsShimmerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_activity_profile_business_details_shimmer, (ViewGroup) null, false, obj);
    }

    public static PrActivityProfileBusinessDetailsShimmerBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrActivityProfileBusinessDetailsShimmerBinding bind(View view, Object obj) {
        return (PrActivityProfileBusinessDetailsShimmerBinding) ViewDataBinding.bind(obj, view, R.layout.pr_activity_profile_business_details_shimmer);
    }
}
