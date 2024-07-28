package net.one97.paytm.nativesdk.bank_mandate.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.fragment.app.j;
import com.bumptech.glide.b;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.bank_mandate.listeners.MandateViewActionListener;
import net.one97.paytm.nativesdk.bank_mandate.viewModel.BankMandateSubDetailsViewModel;
import net.one97.paytm.nativesdk.databinding.FragmentBankMandateSubDetailsBinding;

public class BankMandateSubscriptionDetailsFragment extends h {
    private static final String AC_NO = "AC_NO";
    private static final String AC_TYPE = "AC_TYPE";
    private static final String AUTH_TYPE = "AUTH_TYPE";
    private static final String BANK_NAME = "BANK_NAME";
    private static final String CUST_NAME = "CUST_NAME";
    private static final String ICON_URL = "ICON_URL";
    private static final String IFSC = "IFSC";
    private static final String MANDATE_TYPE = "MANDATE_TYPE";
    private String acNo;
    private String accountType;
    private String authType;
    private BankMandateSubDetailsViewModel bankMandateSubDetailsViewModel;
    private String bankName;
    private String iconUrl;
    private String ifsc;
    private FragmentBankMandateSubDetailsBinding lytBankMandateSubDetailsBinding;
    /* access modifiers changed from: private */
    public MandateViewActionListener mListener;
    private String mandateType;
    private String name;

    public static BankMandateSubscriptionDetailsFragment getInstance() {
        return new BankMandateSubscriptionDetailsFragment();
    }

    public static BankMandateSubscriptionDetailsFragment newInstance(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        BankMandateSubscriptionDetailsFragment bankMandateSubscriptionDetailsFragment = new BankMandateSubscriptionDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CUST_NAME", str);
        bundle.putString(BANK_NAME, str2);
        bundle.putString(AC_NO, str3);
        bundle.putString(IFSC, str4);
        bundle.putString(ICON_URL, str5);
        bundle.putString(AC_TYPE, str6);
        bundle.putString(MANDATE_TYPE, str7);
        bundle.putString(AUTH_TYPE, str8);
        bankMandateSubscriptionDetailsFragment.setArguments(bundle);
        return bankMandateSubscriptionDetailsFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.name = getArguments().getString("CUST_NAME");
            this.bankName = getArguments().getString(BANK_NAME);
            this.acNo = getArguments().getString(AC_NO);
            this.ifsc = getArguments().getString(IFSC);
            this.iconUrl = getArguments().getString(ICON_URL);
            this.accountType = getArguments().getString(AC_TYPE);
            this.mandateType = getArguments().getString(MANDATE_TYPE);
            this.authType = getArguments().getString(AUTH_TYPE);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lytBankMandateSubDetailsBinding = (FragmentBankMandateSubDetailsBinding) f.a(getLayoutInflater(), R.layout.fragment_bank_mandate_sub_details, (ViewGroup) null, false);
        this.bankMandateSubDetailsViewModel = new BankMandateSubDetailsViewModel(getActivity(), this.name, this.bankName, this.acNo, this.ifsc, this.accountType, this.authType);
        this.lytBankMandateSubDetailsBinding.setBankMandateSubDetailsViewModel(this.bankMandateSubDetailsViewModel);
        if (MerchantBL.getMerchantInstance().getMerchantLogoUrl() == null || TextUtils.isEmpty(MerchantBL.getMerchantInstance().getMerchantLogoUrl())) {
            this.bankMandateSubDetailsViewModel.merchantName.set(MerchantBL.getMerchantInstance().getMerchantName());
            this.bankMandateSubDetailsViewModel.mNameVisibility.set(0);
            this.bankMandateSubDetailsViewModel.mLogoVisibility.set(8);
        } else {
            this.bankMandateSubDetailsViewModel.mLogoVisibility.set(0);
            this.bankMandateSubDetailsViewModel.mNameVisibility.set(8);
            b.a(getActivity()).a(MerchantBL.getMerchantInstance().getMerchantLogoUrl()).a(this.lytBankMandateSubDetailsBinding.ivMerchantLogo);
        }
        b.a(getActivity()).a(this.iconUrl).a(this.lytBankMandateSubDetailsBinding.ivBankSubLogo);
        b.a(getActivity()).a(SDKConstants.NACH_LOGO).a(this.lytBankMandateSubDetailsBinding.ivEMandateNach);
        b.a(getActivity()).a(SDKConstants.NPCI_LOGO).a(this.lytBankMandateSubDetailsBinding.ivEMandateNpci);
        this.lytBankMandateSubDetailsBinding.ivBackArrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankMandateSubscriptionDetailsFragment.this.onBackPressed();
            }
        });
        this.lytBankMandateSubDetailsBinding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankMandateSubscriptionDetailsFragment.this.mListener.onConfirmClick();
            }
        });
        return this.lytBankMandateSubDetailsBinding.getRoot();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        SDKUtility.hideKeyboard(getActivity());
    }

    public void setListener(MandateViewActionListener mandateViewActionListener) {
        this.mListener = mandateViewActionListener;
    }

    public void onBackPressed() {
        j supportFragmentManager = getActivity().getSupportFragmentManager();
        if (supportFragmentManager != null) {
            supportFragmentManager.d();
        }
    }
}
