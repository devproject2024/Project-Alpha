package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.SectionWrapper;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class NativesdkItemBankSectionBinding extends ViewDataBinding {
    protected SectionWrapper mSection;
    public final RoboTextView tvSectionLabel;

    public abstract void setSection(SectionWrapper sectionWrapper);

    protected NativesdkItemBankSectionBinding(Object obj, View view, int i2, RoboTextView roboTextView) {
        super(obj, view, i2);
        this.tvSectionLabel = roboTextView;
    }

    public SectionWrapper getSection() {
        return this.mSection;
    }

    public static NativesdkItemBankSectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static NativesdkItemBankSectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NativesdkItemBankSectionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nativesdk_item_bank_section, viewGroup, z, obj);
    }

    public static NativesdkItemBankSectionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static NativesdkItemBankSectionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NativesdkItemBankSectionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nativesdk_item_bank_section, (ViewGroup) null, false, obj);
    }

    public static NativesdkItemBankSectionBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static NativesdkItemBankSectionBinding bind(View view, Object obj) {
        return (NativesdkItemBankSectionBinding) bind(obj, view, R.layout.nativesdk_item_bank_section);
    }
}
