package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytm.business.merchantprofile.R;

public abstract class PrActivityEditBusinessProfileDetailsBinding extends ViewDataBinding {
    public final FrameLayout fragmentContainer;
    public final View loadingScreen;

    public PrActivityEditBusinessProfileDetailsBinding(Object obj, View view, int i2, FrameLayout frameLayout, View view2) {
        super(obj, view, i2);
        this.fragmentContainer = frameLayout;
        this.loadingScreen = view2;
    }

    public static PrActivityEditBusinessProfileDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrActivityEditBusinessProfileDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrActivityEditBusinessProfileDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_activity_edit_business_profile_details, viewGroup, z, obj);
    }

    public static PrActivityEditBusinessProfileDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrActivityEditBusinessProfileDetailsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrActivityEditBusinessProfileDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_activity_edit_business_profile_details, (ViewGroup) null, false, obj);
    }

    public static PrActivityEditBusinessProfileDetailsBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrActivityEditBusinessProfileDetailsBinding bind(View view, Object obj) {
        return (PrActivityEditBusinessProfileDetailsBinding) ViewDataBinding.bind(obj, view, R.layout.pr_activity_edit_business_profile_details);
    }
}
