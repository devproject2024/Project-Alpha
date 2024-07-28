package net.one97.paytm.nativesdk.bank_mandate.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.fragment.app.j;
import com.android.volley.Request;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandateIFSCBranchDetails;
import net.one97.paytm.nativesdk.bank_mandate.listeners.BankMandateProviderListener;
import net.one97.paytm.nativesdk.bank_mandate.viewModel.BankMandateIfscCodeViewModel;
import net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBinding;

public class BankMandateFindIFSCFragment extends h implements BankMandateProviderListener {
    public BankMandateIfscCodeViewModel bankMandateIfscCodeViewModel;
    private FragmentBankMandateFindIfscBinding fragmentBankMandateFindIfscBinding;
    /* access modifiers changed from: private */
    public BankMandateIFSCSelectListener mListener;

    public interface BankMandateIFSCSelectListener {
        void onIFSCSelected(String str);
    }

    public void onNetworkUnavailable(Request request) {
    }

    public void setListener(BankMandateIFSCSelectListener bankMandateIFSCSelectListener) {
        this.mListener = bankMandateIFSCSelectListener;
    }

    public static BankMandateFindIFSCFragment getInstance() {
        return new BankMandateFindIFSCFragment();
    }

    public static BankMandateFindIFSCFragment newInstance() {
        return new BankMandateFindIFSCFragment();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fragmentBankMandateFindIfscBinding = (FragmentBankMandateFindIfscBinding) f.a(getLayoutInflater(), R.layout.fragment_bank_mandate_find_ifsc, (ViewGroup) null, false);
        this.bankMandateIfscCodeViewModel = new BankMandateIfscCodeViewModel(getActivity(), this, this.mListener);
        this.fragmentBankMandateFindIfscBinding.setBankMandateIfscCodeViewModel(this.bankMandateIfscCodeViewModel);
        this.fragmentBankMandateFindIfscBinding.btnIfscContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankMandateFindIFSCFragment.this.mListener.onIFSCSelected(BankMandateFindIFSCFragment.this.bankMandateIfscCodeViewModel.ifscCode.get());
                BankMandateFindIFSCFragment.this.onBackPressed();
            }
        });
        this.fragmentBankMandateFindIfscBinding.ivBackIfsc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankMandateFindIFSCFragment.this.onBackPressed();
            }
        });
        return this.fragmentBankMandateFindIfscBinding.getRoot();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        SDKUtility.hideKeyboard(getActivity());
    }

    public void onBankListReceived(ArrayList<String> arrayList) {
        new BankMandateStateCityBrFragment();
        BankMandateStateCityBrFragment newInstance = BankMandateStateCityBrFragment.newInstance(arrayList, SDKConstants.TYPE_BANK);
        getActivity().getSupportFragmentManager().a().a(R.id.container, newInstance, BankMandateStateCityBrFragment.class.getName()).a((String) null).c();
        newInstance.setViewModel(this.bankMandateIfscCodeViewModel);
    }

    public void onStateListReceived(ArrayList<String> arrayList) {
        new BankMandateStateCityBrFragment();
        BankMandateStateCityBrFragment newInstance = BankMandateStateCityBrFragment.newInstance(arrayList, "STATE");
        getActivity().getSupportFragmentManager().a().a(R.id.container, newInstance, BankMandateStateCityBrFragment.class.getName()).a((String) null).c();
        newInstance.setViewModel(this.bankMandateIfscCodeViewModel);
    }

    public void onCityListReceived(ArrayList<String> arrayList) {
        new BankMandateStateCityBrFragment();
        BankMandateStateCityBrFragment newInstance = BankMandateStateCityBrFragment.newInstance(arrayList, "CITY");
        getActivity().getSupportFragmentManager().a().a(R.id.container, newInstance, BankMandateStateCityBrFragment.class.getName()).a((String) null).c();
        newInstance.setViewModel(this.bankMandateIfscCodeViewModel);
    }

    public void onBranchListReceived(ArrayList<BankMandateIFSCBranchDetails> arrayList) {
        try {
            ArrayList arrayList2 = new ArrayList();
            Iterator<BankMandateIFSCBranchDetails> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BankMandateIFSCBranchDetails next = it2.next();
                if (!TextUtils.isEmpty(next.getDisplayName())) {
                    arrayList2.add(next.getDisplayName());
                }
            }
            new BankMandateStateCityBrFragment();
            BankMandateStateCityBrFragment newInstance = BankMandateStateCityBrFragment.newInstance(arrayList2, arrayList, SDKConstants.TYPE_BRANCH);
            getActivity().getSupportFragmentManager().a().a(R.id.container, newInstance, BankMandateStateCityBrFragment.class.getName()).a((String) null).c();
            newInstance.setViewModel(this.bankMandateIfscCodeViewModel);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onBackPressed() {
        j supportFragmentManager = getActivity().getSupportFragmentManager();
        if (supportFragmentManager != null) {
            supportFragmentManager.d();
        }
    }
}
