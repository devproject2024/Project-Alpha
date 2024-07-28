package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class BankEMandateBankItemBinding extends ViewDataBinding {
    public final ImageView ivBankMandateBankItem;
    public final ImageView ivBgBankMandateBankItem;
    public final RoboTextView tvBankMandateBankItem;

    protected BankEMandateBankItemBinding(Object obj, View view, int i2, ImageView imageView, ImageView imageView2, RoboTextView roboTextView) {
        super(obj, view, i2);
        this.ivBankMandateBankItem = imageView;
        this.ivBgBankMandateBankItem = imageView2;
        this.tvBankMandateBankItem = roboTextView;
    }

    public static BankEMandateBankItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static BankEMandateBankItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BankEMandateBankItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.bank_e_mandate_bank_item, viewGroup, z, obj);
    }

    public static BankEMandateBankItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static BankEMandateBankItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BankEMandateBankItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.bank_e_mandate_bank_item, (ViewGroup) null, false, obj);
    }

    public static BankEMandateBankItemBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static BankEMandateBankItemBinding bind(View view, Object obj) {
        return (BankEMandateBankItemBinding) bind(obj, view, R.layout.bank_e_mandate_bank_item);
    }
}
