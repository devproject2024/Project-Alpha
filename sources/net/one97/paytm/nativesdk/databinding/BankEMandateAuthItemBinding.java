package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;

public abstract class BankEMandateAuthItemBinding extends ViewDataBinding {
    public final RadioButton rbAuthUsing;

    protected BankEMandateAuthItemBinding(Object obj, View view, int i2, RadioButton radioButton) {
        super(obj, view, i2);
        this.rbAuthUsing = radioButton;
    }

    public static BankEMandateAuthItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static BankEMandateAuthItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BankEMandateAuthItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.bank_e_mandate_auth_item, viewGroup, z, obj);
    }

    public static BankEMandateAuthItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static BankEMandateAuthItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BankEMandateAuthItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.bank_e_mandate_auth_item, (ViewGroup) null, false, obj);
    }

    public static BankEMandateAuthItemBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static BankEMandateAuthItemBinding bind(View view, Object obj) {
        return (BankEMandateAuthItemBinding) bind(obj, view, R.layout.bank_e_mandate_auth_item);
    }
}
