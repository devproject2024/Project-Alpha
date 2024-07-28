package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.bank_mandate.viewModel.BankMandateIfscCodeViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class FragmentBankMandateFindIfscBinding extends ViewDataBinding {
    public final Button btnIfscContinue;
    public final Group clIfscDetails;
    public final FrameLayout container;
    public final ImageView ivBackIfsc;
    protected BankMandateIfscCodeViewModel mBankMandateIfscCodeViewModel;
    public final TextInputEditText tiEtBank;
    public final TextInputEditText tiEtBranch;
    public final TextInputEditText tiEtCity;
    public final TextInputEditText tiEtState;
    public final TextInputLayout tilFindBank;
    public final TextInputLayout tilFindBranch;
    public final TextInputLayout tilFindCity;
    public final TextInputLayout tilFindState;
    public final RoboTextView tvIfscCode;
    public final RoboTextView tvIfscText;
    public final RoboTextView tvToolbarTitle;
    public final View viewIfsc;

    public abstract void setBankMandateIfscCodeViewModel(BankMandateIfscCodeViewModel bankMandateIfscCodeViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected FragmentBankMandateFindIfscBinding(Object obj, View view, int i2, Button button, Group group, FrameLayout frameLayout, ImageView imageView, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextInputEditText textInputEditText3, TextInputEditText textInputEditText4, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, TextInputLayout textInputLayout4, RoboTextView roboTextView, RoboTextView roboTextView2, RoboTextView roboTextView3, View view2) {
        super(obj, view, i2);
        this.btnIfscContinue = button;
        this.clIfscDetails = group;
        this.container = frameLayout;
        this.ivBackIfsc = imageView;
        this.tiEtBank = textInputEditText;
        this.tiEtBranch = textInputEditText2;
        this.tiEtCity = textInputEditText3;
        this.tiEtState = textInputEditText4;
        this.tilFindBank = textInputLayout;
        this.tilFindBranch = textInputLayout2;
        this.tilFindCity = textInputLayout3;
        this.tilFindState = textInputLayout4;
        this.tvIfscCode = roboTextView;
        this.tvIfscText = roboTextView2;
        this.tvToolbarTitle = roboTextView3;
        this.viewIfsc = view2;
    }

    public BankMandateIfscCodeViewModel getBankMandateIfscCodeViewModel() {
        return this.mBankMandateIfscCodeViewModel;
    }

    public static FragmentBankMandateFindIfscBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static FragmentBankMandateFindIfscBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentBankMandateFindIfscBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_bank_mandate_find_ifsc, viewGroup, z, obj);
    }

    public static FragmentBankMandateFindIfscBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static FragmentBankMandateFindIfscBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentBankMandateFindIfscBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_bank_mandate_find_ifsc, (ViewGroup) null, false, obj);
    }

    public static FragmentBankMandateFindIfscBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static FragmentBankMandateFindIfscBinding bind(View view, Object obj) {
        return (FragmentBankMandateFindIfscBinding) bind(obj, view, R.layout.fragment_bank_mandate_find_ifsc);
    }
}
