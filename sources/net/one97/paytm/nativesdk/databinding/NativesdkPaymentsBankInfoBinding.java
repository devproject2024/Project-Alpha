package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.paytmPaymentsBank.viewmodel.PaytmPaymentsBankViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class NativesdkPaymentsBankInfoBinding extends ViewDataBinding {
    public final LinearLayout bankPinLayout;
    public final RelativeLayout btnProceed;
    public final CheckBox cbTermsAndCondition;
    public final EditText etPaytmPasscode;
    public final LinearLayout llCheckOffer;
    public final RelativeLayout llInstrumentInfo;
    public final LinearLayout llMictLines;
    public final LinearLayout llTermConditions;
    public final LottieAnimationView ltvGetOffers;
    public final LottieAnimationView ltvLoading;
    public final LinearLayout lytFetchPaymentBankBalance;
    public final LinearLayout lytValidatingOtp;
    protected PaytmPaymentsBankViewModel mBankViewModel;
    protected View mView;
    public final TextView paysecurely;
    public final RadioButton rbCardNumber;
    public final RoboTextView tvBankOffer;
    public final TextView tvCheckingOffers;
    public final TextView tvConvFee;
    public final TextView tvDisableErrorMessage;
    public final TextView tvNewTxt;
    public final TextView tvPayback;
    public final TextView tvPromotion;
    public final TextView tvTerms;
    public final RoboTextView txtErrorMsg;
    public final TextView txtPrimaryInfo;
    public final RoboTextView txtSecondaryInfo;
    public final TextView txtamount;

    public abstract void setBankViewModel(PaytmPaymentsBankViewModel paytmPaymentsBankViewModel);

    public abstract void setView(View view);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected NativesdkPaymentsBankInfoBinding(Object obj, View view, int i2, LinearLayout linearLayout, RelativeLayout relativeLayout, CheckBox checkBox, EditText editText, LinearLayout linearLayout2, RelativeLayout relativeLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, LinearLayout linearLayout5, LinearLayout linearLayout6, TextView textView, RadioButton radioButton, RoboTextView roboTextView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, RoboTextView roboTextView2, TextView textView9, RoboTextView roboTextView3, TextView textView10) {
        super(obj, view, i2);
        this.bankPinLayout = linearLayout;
        this.btnProceed = relativeLayout;
        this.cbTermsAndCondition = checkBox;
        this.etPaytmPasscode = editText;
        this.llCheckOffer = linearLayout2;
        this.llInstrumentInfo = relativeLayout2;
        this.llMictLines = linearLayout3;
        this.llTermConditions = linearLayout4;
        this.ltvGetOffers = lottieAnimationView;
        this.ltvLoading = lottieAnimationView2;
        this.lytFetchPaymentBankBalance = linearLayout5;
        this.lytValidatingOtp = linearLayout6;
        this.paysecurely = textView;
        this.rbCardNumber = radioButton;
        this.tvBankOffer = roboTextView;
        this.tvCheckingOffers = textView2;
        this.tvConvFee = textView3;
        this.tvDisableErrorMessage = textView4;
        this.tvNewTxt = textView5;
        this.tvPayback = textView6;
        this.tvPromotion = textView7;
        this.tvTerms = textView8;
        this.txtErrorMsg = roboTextView2;
        this.txtPrimaryInfo = textView9;
        this.txtSecondaryInfo = roboTextView3;
        this.txtamount = textView10;
    }

    public PaytmPaymentsBankViewModel getBankViewModel() {
        return this.mBankViewModel;
    }

    public View getView() {
        return this.mView;
    }

    public static NativesdkPaymentsBankInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static NativesdkPaymentsBankInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NativesdkPaymentsBankInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nativesdk_payments_bank_info, viewGroup, z, obj);
    }

    public static NativesdkPaymentsBankInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static NativesdkPaymentsBankInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NativesdkPaymentsBankInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nativesdk_payments_bank_info, (ViewGroup) null, false, obj);
    }

    public static NativesdkPaymentsBankInfoBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static NativesdkPaymentsBankInfoBinding bind(View view, Object obj) {
        return (NativesdkPaymentsBankInfoBinding) bind(obj, view, R.layout.nativesdk_payments_bank_info);
    }
}
