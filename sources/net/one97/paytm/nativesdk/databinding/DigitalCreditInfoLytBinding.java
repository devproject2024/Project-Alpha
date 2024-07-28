package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.digitalCredit.viewmodel.DigitalCreditViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class DigitalCreditInfoLytBinding extends ViewDataBinding {
    public final LinearLayout llInstrumentInfo;
    public final LinearLayout lytFetchPaymentBankBalance;
    protected DigitalCreditViewModel mDigitalCreditModel;
    public final RadioButton rbCardNumber;
    public final TextView txtPrimaryInfo;
    public final RoboTextView txtSecondaryInfo;

    public abstract void setDigitalCreditModel(DigitalCreditViewModel digitalCreditViewModel);

    protected DigitalCreditInfoLytBinding(Object obj, View view, int i2, LinearLayout linearLayout, LinearLayout linearLayout2, RadioButton radioButton, TextView textView, RoboTextView roboTextView) {
        super(obj, view, i2);
        this.llInstrumentInfo = linearLayout;
        this.lytFetchPaymentBankBalance = linearLayout2;
        this.rbCardNumber = radioButton;
        this.txtPrimaryInfo = textView;
        this.txtSecondaryInfo = roboTextView;
    }

    public DigitalCreditViewModel getDigitalCreditModel() {
        return this.mDigitalCreditModel;
    }

    public static DigitalCreditInfoLytBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static DigitalCreditInfoLytBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DigitalCreditInfoLytBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.digital_credit_info_lyt, viewGroup, z, obj);
    }

    public static DigitalCreditInfoLytBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static DigitalCreditInfoLytBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DigitalCreditInfoLytBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.digital_credit_info_lyt, (ViewGroup) null, false, obj);
    }

    public static DigitalCreditInfoLytBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static DigitalCreditInfoLytBinding bind(View view, Object obj) {
        return (DigitalCreditInfoLytBinding) bind(obj, view, R.layout.digital_credit_info_lyt);
    }
}
