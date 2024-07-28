package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class NativesdkBankMandateStateItemBinding extends ViewDataBinding {
    public final RoboTextView tvStateItem;

    protected NativesdkBankMandateStateItemBinding(Object obj, View view, int i2, RoboTextView roboTextView) {
        super(obj, view, i2);
        this.tvStateItem = roboTextView;
    }

    public static NativesdkBankMandateStateItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static NativesdkBankMandateStateItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NativesdkBankMandateStateItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nativesdk_bank_mandate_state_item, viewGroup, z, obj);
    }

    public static NativesdkBankMandateStateItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static NativesdkBankMandateStateItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NativesdkBankMandateStateItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nativesdk_bank_mandate_state_item, (ViewGroup) null, false, obj);
    }

    public static NativesdkBankMandateStateItemBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static NativesdkBankMandateStateItemBinding bind(View view, Object obj) {
        return (NativesdkBankMandateStateItemBinding) bind(obj, view, R.layout.nativesdk_bank_mandate_state_item);
    }
}
