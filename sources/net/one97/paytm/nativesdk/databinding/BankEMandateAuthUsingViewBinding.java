package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class BankEMandateAuthUsingViewBinding extends ViewDataBinding {
    public final ConstraintLayout clBankEMandateAuth;
    public final RecyclerView rvBankEMandateAuthList;
    public final RoboTextView tvAuthenticateUsing;

    protected BankEMandateAuthUsingViewBinding(Object obj, View view, int i2, ConstraintLayout constraintLayout, RecyclerView recyclerView, RoboTextView roboTextView) {
        super(obj, view, i2);
        this.clBankEMandateAuth = constraintLayout;
        this.rvBankEMandateAuthList = recyclerView;
        this.tvAuthenticateUsing = roboTextView;
    }

    public static BankEMandateAuthUsingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static BankEMandateAuthUsingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BankEMandateAuthUsingViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.bank_e_mandate_auth_using_view, viewGroup, z, obj);
    }

    public static BankEMandateAuthUsingViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static BankEMandateAuthUsingViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BankEMandateAuthUsingViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.bank_e_mandate_auth_using_view, (ViewGroup) null, false, obj);
    }

    public static BankEMandateAuthUsingViewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static BankEMandateAuthUsingViewBinding bind(View view, Object obj) {
        return (BankEMandateAuthUsingViewBinding) bind(obj, view, R.layout.bank_e_mandate_auth_using_view);
    }
}
