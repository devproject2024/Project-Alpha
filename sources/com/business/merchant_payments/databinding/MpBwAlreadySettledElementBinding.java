package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.MpRoboTextView;

public abstract class MpBwAlreadySettledElementBinding extends ViewDataBinding {
    public final MpRoboTextView bwAlreadySettledAmount;
    public final MpRoboTextView bwAlreadySettledBankAccountNumber;
    public final LinearLayout bwAlreadySettledDetails;
    public final View bwAlreadySettledDivider;
    public final ImageView bwAlreadySettledTickImage;
    public final MpRoboTextView bwAlreadySettledTime;
    public final MpRoboTextView bwAlreadySettledUTRNumber;
    public final ImageView bwAlreadySettledlBankLogoImage;
    public final MpRoboTextView bwPendingSettlementTime;
    public final View bwVerticalSpace;
    public final LinearLayout llBankDetails;

    public MpBwAlreadySettledElementBinding(Object obj, View view, int i2, MpRoboTextView mpRoboTextView, MpRoboTextView mpRoboTextView2, LinearLayout linearLayout, View view2, ImageView imageView, MpRoboTextView mpRoboTextView3, MpRoboTextView mpRoboTextView4, ImageView imageView2, MpRoboTextView mpRoboTextView5, View view3, LinearLayout linearLayout2) {
        super(obj, view, i2);
        this.bwAlreadySettledAmount = mpRoboTextView;
        this.bwAlreadySettledBankAccountNumber = mpRoboTextView2;
        this.bwAlreadySettledDetails = linearLayout;
        this.bwAlreadySettledDivider = view2;
        this.bwAlreadySettledTickImage = imageView;
        this.bwAlreadySettledTime = mpRoboTextView3;
        this.bwAlreadySettledUTRNumber = mpRoboTextView4;
        this.bwAlreadySettledlBankLogoImage = imageView2;
        this.bwPendingSettlementTime = mpRoboTextView5;
        this.bwVerticalSpace = view3;
        this.llBankDetails = linearLayout2;
    }

    public static MpBwAlreadySettledElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpBwAlreadySettledElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpBwAlreadySettledElementBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bw_already_settled_element, viewGroup, z, obj);
    }

    public static MpBwAlreadySettledElementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpBwAlreadySettledElementBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpBwAlreadySettledElementBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bw_already_settled_element, (ViewGroup) null, false, obj);
    }

    public static MpBwAlreadySettledElementBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpBwAlreadySettledElementBinding bind(View view, Object obj) {
        return (MpBwAlreadySettledElementBinding) ViewDataBinding.bind(obj, view, R.layout.mp_bw_already_settled_element);
    }
}
