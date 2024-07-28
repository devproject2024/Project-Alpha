package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.viewmodel.ProfileBusinessDetailsViewModel;
import com.paytm.business.merchantprofile.widget.CircularImageView;

public abstract class PrProfileScreenHeaderBinding extends ViewDataBinding {
    public final TextView businessDisplayName;
    public ProfileBusinessDetailsViewModel mViewModel;
    public final LinearLayout merchantSwitchView;
    public final CircularImageView profilePic;
    public final TextView userName;

    public abstract void setViewModel(ProfileBusinessDetailsViewModel profileBusinessDetailsViewModel);

    public PrProfileScreenHeaderBinding(Object obj, View view, int i2, TextView textView, LinearLayout linearLayout, CircularImageView circularImageView, TextView textView2) {
        super(obj, view, i2);
        this.businessDisplayName = textView;
        this.merchantSwitchView = linearLayout;
        this.profilePic = circularImageView;
        this.userName = textView2;
    }

    public ProfileBusinessDetailsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static PrProfileScreenHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrProfileScreenHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrProfileScreenHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_profile_screen_header, viewGroup, z, obj);
    }

    public static PrProfileScreenHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrProfileScreenHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrProfileScreenHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_profile_screen_header, (ViewGroup) null, false, obj);
    }

    public static PrProfileScreenHeaderBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrProfileScreenHeaderBinding bind(View view, Object obj) {
        return (PrProfileScreenHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.pr_profile_screen_header);
    }
}
