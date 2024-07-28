package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandateSectionWrapper;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class NativesdkBankMandateListProviderItemBinding extends ViewDataBinding {
    public final ImageView ivBmBankIcon;
    protected BankMandateSectionWrapper mBankMandate;
    protected View mView;
    public final RoboTextView tvBankName;

    public abstract void setBankMandate(BankMandateSectionWrapper bankMandateSectionWrapper);

    public abstract void setView(View view);

    protected NativesdkBankMandateListProviderItemBinding(Object obj, View view, int i2, ImageView imageView, RoboTextView roboTextView) {
        super(obj, view, i2);
        this.ivBmBankIcon = imageView;
        this.tvBankName = roboTextView;
    }

    public BankMandateSectionWrapper getBankMandate() {
        return this.mBankMandate;
    }

    public View getView() {
        return this.mView;
    }

    public static NativesdkBankMandateListProviderItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static NativesdkBankMandateListProviderItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NativesdkBankMandateListProviderItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nativesdk_bank_mandate_list_provider_item, viewGroup, z, obj);
    }

    public static NativesdkBankMandateListProviderItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static NativesdkBankMandateListProviderItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NativesdkBankMandateListProviderItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nativesdk_bank_mandate_list_provider_item, (ViewGroup) null, false, obj);
    }

    public static NativesdkBankMandateListProviderItemBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static NativesdkBankMandateListProviderItemBinding bind(View view, Object obj) {
        return (NativesdkBankMandateListProviderItemBinding) bind(obj, view, R.layout.nativesdk_bank_mandate_list_provider_item);
    }
}
