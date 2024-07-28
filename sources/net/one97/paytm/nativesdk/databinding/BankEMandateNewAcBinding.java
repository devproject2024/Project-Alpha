package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class BankEMandateNewAcBinding extends ViewDataBinding {
    public final Button btnProceedMandate;
    public final Group clBankMandateBankForm;
    public final Group clBankMandateBankSelect;
    public final ConstraintLayout clMainBankMandate;
    public final Group clSelectAllOtherBank;
    public final BankEMandateAuthUsingViewBinding includeAuthUsingView;
    public final ImageView ivBankMandateSelectedLogo;
    public final ImageView ivNavigateSelectOtherBanks;
    public final RadioButton rbBankEMandate;
    public final RecyclerView rvGridBankList;
    public final TextInputEditText tiEtBankAc;
    public final TextInputEditText tiEtIfsc;
    public final TextInputEditText tiEtName;
    public final TextInputLayout tilEnterBankAc;
    public final TextInputLayout tilEnterIfsc;
    public final TextInputLayout tilEnterName;
    public final RoboTextView tvBankMandateChange;
    public final RoboTextView tvBankMandateFindIfsc;
    public final RoboTextView tvBankMandateSelectOtherBank;
    public final RoboTextView tvBankMandateSelectedBank;
    public final View viewOtherBank1;
    public final View viewOtherBank2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected BankEMandateNewAcBinding(Object obj, View view, int i2, Button button, Group group, Group group2, ConstraintLayout constraintLayout, Group group3, BankEMandateAuthUsingViewBinding bankEMandateAuthUsingViewBinding, ImageView imageView, ImageView imageView2, RadioButton radioButton, RecyclerView recyclerView, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextInputEditText textInputEditText3, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, RoboTextView roboTextView, RoboTextView roboTextView2, RoboTextView roboTextView3, RoboTextView roboTextView4, View view2, View view3) {
        super(obj, view, i2);
        this.btnProceedMandate = button;
        this.clBankMandateBankForm = group;
        this.clBankMandateBankSelect = group2;
        this.clMainBankMandate = constraintLayout;
        this.clSelectAllOtherBank = group3;
        this.includeAuthUsingView = bankEMandateAuthUsingViewBinding;
        setContainedBinding(this.includeAuthUsingView);
        this.ivBankMandateSelectedLogo = imageView;
        this.ivNavigateSelectOtherBanks = imageView2;
        this.rbBankEMandate = radioButton;
        this.rvGridBankList = recyclerView;
        this.tiEtBankAc = textInputEditText;
        this.tiEtIfsc = textInputEditText2;
        this.tiEtName = textInputEditText3;
        this.tilEnterBankAc = textInputLayout;
        this.tilEnterIfsc = textInputLayout2;
        this.tilEnterName = textInputLayout3;
        this.tvBankMandateChange = roboTextView;
        this.tvBankMandateFindIfsc = roboTextView2;
        this.tvBankMandateSelectOtherBank = roboTextView3;
        this.tvBankMandateSelectedBank = roboTextView4;
        this.viewOtherBank1 = view2;
        this.viewOtherBank2 = view3;
    }

    public static BankEMandateNewAcBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static BankEMandateNewAcBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BankEMandateNewAcBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.bank_e_mandate_new_ac, viewGroup, z, obj);
    }

    public static BankEMandateNewAcBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static BankEMandateNewAcBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BankEMandateNewAcBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.bank_e_mandate_new_ac, (ViewGroup) null, false, obj);
    }

    public static BankEMandateNewAcBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static BankEMandateNewAcBinding bind(View view, Object obj) {
        return (BankEMandateNewAcBinding) bind(obj, view, R.layout.bank_e_mandate_new_ac);
    }
}
