package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandateSectionWrapper;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class NativesdkBankMandateSectionItemBinding extends ViewDataBinding {
    protected BankMandateSectionWrapper mSection;
    public final RoboTextView tvSectionLabel;

    public abstract void setSection(BankMandateSectionWrapper bankMandateSectionWrapper);

    protected NativesdkBankMandateSectionItemBinding(Object obj, View view, int i2, RoboTextView roboTextView) {
        super(obj, view, i2);
        this.tvSectionLabel = roboTextView;
    }

    public BankMandateSectionWrapper getSection() {
        return this.mSection;
    }

    public static NativesdkBankMandateSectionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static NativesdkBankMandateSectionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NativesdkBankMandateSectionItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nativesdk_bank_mandate_section_item, viewGroup, z, obj);
    }

    public static NativesdkBankMandateSectionItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static NativesdkBankMandateSectionItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NativesdkBankMandateSectionItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nativesdk_bank_mandate_section_item, (ViewGroup) null, false, obj);
    }

    public static NativesdkBankMandateSectionItemBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static NativesdkBankMandateSectionItemBinding bind(View view, Object obj) {
        return (NativesdkBankMandateSectionItemBinding) bind(obj, view, R.layout.nativesdk_bank_mandate_section_item);
    }
}
