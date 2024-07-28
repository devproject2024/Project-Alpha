package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class BankEMandateSavedBankBinding extends ViewDataBinding {
    public final ImageView ivBankMandateBankLogo;
    public final RadioButton rbBankEMandate;
    public final RoboTextView tvBankMandateAcNo;

    protected BankEMandateSavedBankBinding(Object obj, View view, int i2, ImageView imageView, RadioButton radioButton, RoboTextView roboTextView) {
        super(obj, view, i2);
        this.ivBankMandateBankLogo = imageView;
        this.rbBankEMandate = radioButton;
        this.tvBankMandateAcNo = roboTextView;
    }

    public static BankEMandateSavedBankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static BankEMandateSavedBankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BankEMandateSavedBankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.bank_e_mandate_saved_bank, viewGroup, z, obj);
    }

    public static BankEMandateSavedBankBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static BankEMandateSavedBankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BankEMandateSavedBankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.bank_e_mandate_saved_bank, (ViewGroup) null, false, obj);
    }

    public static BankEMandateSavedBankBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static BankEMandateSavedBankBinding bind(View view, Object obj) {
        return (BankEMandateSavedBankBinding) bind(obj, view, R.layout.bank_e_mandate_saved_bank);
    }
}
