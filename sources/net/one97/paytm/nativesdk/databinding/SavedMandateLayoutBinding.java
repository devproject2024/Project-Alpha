package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.bank_mandate.viewModel.SavedMandateViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class SavedMandateLayoutBinding extends ViewDataBinding {
    public final Button btnProceedSavedMandate;
    public final ConstraintLayout clMainSavedMandate;
    public final BankEMandateAuthUsingViewBinding includeAuthUsingViewSaved;
    public final ImageView ivSavedMandateBank;
    protected SavedMandateViewModel mModel;
    protected View mView;
    public final RadioButton rbBankName;
    public final RoboTextView txtAccount;

    public abstract void setModel(SavedMandateViewModel savedMandateViewModel);

    public abstract void setView(View view);

    protected SavedMandateLayoutBinding(Object obj, View view, int i2, Button button, ConstraintLayout constraintLayout, BankEMandateAuthUsingViewBinding bankEMandateAuthUsingViewBinding, ImageView imageView, RadioButton radioButton, RoboTextView roboTextView) {
        super(obj, view, i2);
        this.btnProceedSavedMandate = button;
        this.clMainSavedMandate = constraintLayout;
        this.includeAuthUsingViewSaved = bankEMandateAuthUsingViewBinding;
        setContainedBinding(this.includeAuthUsingViewSaved);
        this.ivSavedMandateBank = imageView;
        this.rbBankName = radioButton;
        this.txtAccount = roboTextView;
    }

    public SavedMandateViewModel getModel() {
        return this.mModel;
    }

    public View getView() {
        return this.mView;
    }

    public static SavedMandateLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static SavedMandateLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SavedMandateLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.saved_mandate_layout, viewGroup, z, obj);
    }

    public static SavedMandateLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static SavedMandateLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SavedMandateLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.saved_mandate_layout, (ViewGroup) null, false, obj);
    }

    public static SavedMandateLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static SavedMandateLayoutBinding bind(View view, Object obj) {
        return (SavedMandateLayoutBinding) bind(obj, view, R.layout.saved_mandate_layout);
    }
}
