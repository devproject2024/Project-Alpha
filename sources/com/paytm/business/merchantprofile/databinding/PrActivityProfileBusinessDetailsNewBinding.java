package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.viewmodel.ProfileBusinessDetailsViewModel;

public abstract class PrActivityProfileBusinessDetailsNewBinding extends ViewDataBinding {
    public final TextView addAddress;
    public final TextView addGstIn;
    public final LinearLayout edcDetails;
    public final TextView editAddress;
    public final TextView editDisplayName;
    public final LinearLayout llBusinessDetailsHeader;
    public final LinearLayout llBusinessNameHeader;
    public final PrProfileReactivateBinding llDeactivateContainer;
    public final LinearLayout llDispName;
    public final LinearLayout llGstin;
    public final LinearLayout llMerchantId;
    public final LinearLayout llPan;
    public final TextView logoutBtn;
    public ProfileBusinessDetailsViewModel mViewModel;
    public final TextView noOfDevicesUnderPlanTxt;
    public final TextView noOfDevicesUnderPlanValue;
    public final TextView planType;
    public final RelativeLayout planTypeMenuContainer;
    public final TextView planTypeValue;
    public final LinearLayout registeredAddress;
    public final RelativeLayout rl;
    public final RelativeLayout rlBusinessDetailsContainer;
    public final RelativeLayout rlContainerBusinessDetails;
    public final LinearLayout rlParentContainer;
    public final ScrollView scrollView;
    public final PrActivityProfileBusinessDetailsShimmerBinding shimmerContainer;
    public final TextView termsAndConditionsTxt;
    public final Toolbar toolbar;
    public final TextView totalRentalForXDevicesTxt;
    public final TextView totalRentalForXDevicesValue;
    public final TextView usageDepositTxt;
    public final TextView usageDepositValue;
    public final PrViewEditChangeInProgressNewBinding viewDisplayNameChange;
    public final PrViewEditChangeInProgressNewBinding viewGstinChange;
    public final View viewOverlayBusinessDetails;
    public final View viewOverlayBusinessName;
    public final View viewOverlayRegisteredAddress;
    public final PrProfileScreenHeaderBinding viewProfileHeader;

    public abstract void setViewModel(ProfileBusinessDetailsViewModel profileBusinessDetailsViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PrActivityProfileBusinessDetailsNewBinding(Object obj, View view, int i2, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3, TextView textView4, LinearLayout linearLayout2, LinearLayout linearLayout3, PrProfileReactivateBinding prProfileReactivateBinding, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, TextView textView5, TextView textView6, TextView textView7, TextView textView8, RelativeLayout relativeLayout, TextView textView9, LinearLayout linearLayout8, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, LinearLayout linearLayout9, ScrollView scrollView2, PrActivityProfileBusinessDetailsShimmerBinding prActivityProfileBusinessDetailsShimmerBinding, TextView textView10, Toolbar toolbar2, TextView textView11, TextView textView12, TextView textView13, TextView textView14, PrViewEditChangeInProgressNewBinding prViewEditChangeInProgressNewBinding, PrViewEditChangeInProgressNewBinding prViewEditChangeInProgressNewBinding2, View view2, View view3, View view4, PrProfileScreenHeaderBinding prProfileScreenHeaderBinding) {
        super(obj, view, i2);
        PrProfileReactivateBinding prProfileReactivateBinding2 = prProfileReactivateBinding;
        PrActivityProfileBusinessDetailsShimmerBinding prActivityProfileBusinessDetailsShimmerBinding2 = prActivityProfileBusinessDetailsShimmerBinding;
        PrViewEditChangeInProgressNewBinding prViewEditChangeInProgressNewBinding3 = prViewEditChangeInProgressNewBinding;
        PrViewEditChangeInProgressNewBinding prViewEditChangeInProgressNewBinding4 = prViewEditChangeInProgressNewBinding2;
        PrProfileScreenHeaderBinding prProfileScreenHeaderBinding2 = prProfileScreenHeaderBinding;
        this.addAddress = textView;
        this.addGstIn = textView2;
        this.edcDetails = linearLayout;
        this.editAddress = textView3;
        this.editDisplayName = textView4;
        this.llBusinessDetailsHeader = linearLayout2;
        this.llBusinessNameHeader = linearLayout3;
        this.llDeactivateContainer = prProfileReactivateBinding2;
        setContainedBinding(prProfileReactivateBinding2);
        this.llDispName = linearLayout4;
        this.llGstin = linearLayout5;
        this.llMerchantId = linearLayout6;
        this.llPan = linearLayout7;
        this.logoutBtn = textView5;
        this.noOfDevicesUnderPlanTxt = textView6;
        this.noOfDevicesUnderPlanValue = textView7;
        this.planType = textView8;
        this.planTypeMenuContainer = relativeLayout;
        this.planTypeValue = textView9;
        this.registeredAddress = linearLayout8;
        this.rl = relativeLayout2;
        this.rlBusinessDetailsContainer = relativeLayout3;
        this.rlContainerBusinessDetails = relativeLayout4;
        this.rlParentContainer = linearLayout9;
        this.scrollView = scrollView2;
        this.shimmerContainer = prActivityProfileBusinessDetailsShimmerBinding2;
        setContainedBinding(prActivityProfileBusinessDetailsShimmerBinding2);
        this.termsAndConditionsTxt = textView10;
        this.toolbar = toolbar2;
        this.totalRentalForXDevicesTxt = textView11;
        this.totalRentalForXDevicesValue = textView12;
        this.usageDepositTxt = textView13;
        this.usageDepositValue = textView14;
        this.viewDisplayNameChange = prViewEditChangeInProgressNewBinding3;
        setContainedBinding(prViewEditChangeInProgressNewBinding3);
        this.viewGstinChange = prViewEditChangeInProgressNewBinding4;
        setContainedBinding(prViewEditChangeInProgressNewBinding4);
        this.viewOverlayBusinessDetails = view2;
        this.viewOverlayBusinessName = view3;
        this.viewOverlayRegisteredAddress = view4;
        this.viewProfileHeader = prProfileScreenHeaderBinding2;
        setContainedBinding(prProfileScreenHeaderBinding2);
    }

    public ProfileBusinessDetailsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static PrActivityProfileBusinessDetailsNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrActivityProfileBusinessDetailsNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrActivityProfileBusinessDetailsNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_activity_profile_business_details_new, viewGroup, z, obj);
    }

    public static PrActivityProfileBusinessDetailsNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrActivityProfileBusinessDetailsNewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrActivityProfileBusinessDetailsNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_activity_profile_business_details_new, (ViewGroup) null, false, obj);
    }

    public static PrActivityProfileBusinessDetailsNewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrActivityProfileBusinessDetailsNewBinding bind(View view, Object obj) {
        return (PrActivityProfileBusinessDetailsNewBinding) ViewDataBinding.bind(obj, view, R.layout.pr_activity_profile_business_details_new);
    }
}
