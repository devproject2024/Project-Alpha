package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.transaction.ppb.BankOfferPaytmBankViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class PaytmBankInfoBankofferBinding extends ViewDataBinding {
    public final LinearLayout bankPinLayout;
    public final EditText etPaytmPasscode;
    public final RelativeLayout llInstrumentInfo;
    public final LinearLayout llMictLines;
    public final LinearLayout lytValidatingOtp;
    protected BankOfferPaytmBankViewModel mBankViewModel;
    protected View mView;
    public final RadioButton rbCardNumber;
    public final TextView tvNewTxt;
    public final TextView tvPayback;
    public final RoboTextView txtErrorMsg;
    public final TextView txtPrimaryInfo;
    public final TextView txtamount;

    public abstract void setBankViewModel(BankOfferPaytmBankViewModel bankOfferPaytmBankViewModel);

    public abstract void setView(View view);

    protected PaytmBankInfoBankofferBinding(Object obj, View view, int i2, LinearLayout linearLayout, EditText editText, RelativeLayout relativeLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RadioButton radioButton, TextView textView, TextView textView2, RoboTextView roboTextView, TextView textView3, TextView textView4) {
        super(obj, view, i2);
        this.bankPinLayout = linearLayout;
        this.etPaytmPasscode = editText;
        this.llInstrumentInfo = relativeLayout;
        this.llMictLines = linearLayout2;
        this.lytValidatingOtp = linearLayout3;
        this.rbCardNumber = radioButton;
        this.tvNewTxt = textView;
        this.tvPayback = textView2;
        this.txtErrorMsg = roboTextView;
        this.txtPrimaryInfo = textView3;
        this.txtamount = textView4;
    }

    public BankOfferPaytmBankViewModel getBankViewModel() {
        return this.mBankViewModel;
    }

    public View getView() {
        return this.mView;
    }

    public static PaytmBankInfoBankofferBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PaytmBankInfoBankofferBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PaytmBankInfoBankofferBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.paytm_bank_info_bankoffer, viewGroup, z, obj);
    }

    public static PaytmBankInfoBankofferBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PaytmBankInfoBankofferBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PaytmBankInfoBankofferBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.paytm_bank_info_bankoffer, (ViewGroup) null, false, obj);
    }

    public static PaytmBankInfoBankofferBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PaytmBankInfoBankofferBinding bind(View view, Object obj) {
        return (PaytmBankInfoBankofferBinding) bind(obj, view, R.layout.paytm_bank_info_bankoffer);
    }
}
