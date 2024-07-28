package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.bank_mandate.viewModel.BankMandateSubDetailsViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class FragmentBankMandateSubDetailsBinding extends ViewDataBinding {
    public final Button btnConfirm;
    public final ImageView ivBackArrow;
    public final ImageView ivBankSubLogo;
    public final ImageView ivEMandateNach;
    public final ImageView ivEMandateNpci;
    public final ImageView ivMerchantLogo;
    protected BankMandateSubDetailsViewModel mBankMandateSubDetailsViewModel;
    public final RoboTextView tvAuthTypeDesc;
    public final RoboTextView tvBankAcDetails;
    public final RoboTextView tvBankAcType;
    public final RoboTextView tvBankIfscCode;
    public final RoboTextView tvBankMandatePay;
    public final RoboTextView tvBankNameAcNum;
    public final RoboTextView tvCustName;
    public final RoboTextView tvCustNameDetails;
    public final RoboTextView tvExpiryDate;
    public final RoboTextView tvExpiryDateDetails;
    public final RoboTextView tvFrequency;
    public final RoboTextView tvFrequencyDetails;
    public final RoboTextView tvMandatePoweredBy;
    public final RoboTextView tvMaxAmt;
    public final RoboTextView tvMaxAmtDetails;
    public final RoboTextView tvMerchantName;
    public final RoboTextView tvPurpose;
    public final RoboTextView tvPurposeDetails;
    public final RoboTextView tvStartDate;
    public final RoboTextView tvStartDateDetails;
    public final RoboTextView tvSubDetails;
    public final RoboTextView tvWillBeDeducted;
    public final View viewDividerAcDetails;
    public final View viewHeader;
    public final View viewIvBankSubLogo;

    public abstract void setBankMandateSubDetailsViewModel(BankMandateSubDetailsViewModel bankMandateSubDetailsViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected FragmentBankMandateSubDetailsBinding(Object obj, View view, int i2, Button button, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, RoboTextView roboTextView, RoboTextView roboTextView2, RoboTextView roboTextView3, RoboTextView roboTextView4, RoboTextView roboTextView5, RoboTextView roboTextView6, RoboTextView roboTextView7, RoboTextView roboTextView8, RoboTextView roboTextView9, RoboTextView roboTextView10, RoboTextView roboTextView11, RoboTextView roboTextView12, RoboTextView roboTextView13, RoboTextView roboTextView14, RoboTextView roboTextView15, RoboTextView roboTextView16, RoboTextView roboTextView17, RoboTextView roboTextView18, RoboTextView roboTextView19, RoboTextView roboTextView20, RoboTextView roboTextView21, RoboTextView roboTextView22, View view2, View view3, View view4) {
        super(obj, view, i2);
        this.btnConfirm = button;
        this.ivBackArrow = imageView;
        this.ivBankSubLogo = imageView2;
        this.ivEMandateNach = imageView3;
        this.ivEMandateNpci = imageView4;
        this.ivMerchantLogo = imageView5;
        this.tvAuthTypeDesc = roboTextView;
        this.tvBankAcDetails = roboTextView2;
        this.tvBankAcType = roboTextView3;
        this.tvBankIfscCode = roboTextView4;
        this.tvBankMandatePay = roboTextView5;
        this.tvBankNameAcNum = roboTextView6;
        this.tvCustName = roboTextView7;
        this.tvCustNameDetails = roboTextView8;
        this.tvExpiryDate = roboTextView9;
        this.tvExpiryDateDetails = roboTextView10;
        this.tvFrequency = roboTextView11;
        this.tvFrequencyDetails = roboTextView12;
        this.tvMandatePoweredBy = roboTextView13;
        this.tvMaxAmt = roboTextView14;
        this.tvMaxAmtDetails = roboTextView15;
        this.tvMerchantName = roboTextView16;
        this.tvPurpose = roboTextView17;
        this.tvPurposeDetails = roboTextView18;
        this.tvStartDate = roboTextView19;
        this.tvStartDateDetails = roboTextView20;
        this.tvSubDetails = roboTextView21;
        this.tvWillBeDeducted = roboTextView22;
        this.viewDividerAcDetails = view2;
        this.viewHeader = view3;
        this.viewIvBankSubLogo = view4;
    }

    public BankMandateSubDetailsViewModel getBankMandateSubDetailsViewModel() {
        return this.mBankMandateSubDetailsViewModel;
    }

    public static FragmentBankMandateSubDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static FragmentBankMandateSubDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentBankMandateSubDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_bank_mandate_sub_details, viewGroup, z, obj);
    }

    public static FragmentBankMandateSubDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static FragmentBankMandateSubDetailsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentBankMandateSubDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_bank_mandate_sub_details, (ViewGroup) null, false, obj);
    }

    public static FragmentBankMandateSubDetailsBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static FragmentBankMandateSubDetailsBinding bind(View view, Object obj) {
        return (FragmentBankMandateSubDetailsBinding) bind(obj, view, R.layout.fragment_bank_mandate_sub_details);
    }
}
