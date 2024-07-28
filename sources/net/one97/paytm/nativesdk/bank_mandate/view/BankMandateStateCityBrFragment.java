package net.one97.paytm.nativesdk.bank_mandate.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.bank_mandate.adapter.BankMandateStateCityBrAdapter;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandateIFSCBranchDetails;
import net.one97.paytm.nativesdk.bank_mandate.viewModel.BankMandateIfscCodeViewModel;
import net.one97.paytm.nativesdk.databinding.FragmentBankMandateStateListBinding;
import net.one97.paytm.nativesdk.instruments.netbanking.listeners.RecyclerItemClickListner;

public class BankMandateStateCityBrFragment extends h {
    private static final String ARG_BRANCH_LIST = "BM_BRANCH_LIST";
    private static final String ARG_LIST = "BM_LIST";
    private static final String ARG_TYPE_LIST = "BM_LIST_TYPE";
    /* access modifiers changed from: private */
    public BankMandateIfscCodeViewModel bankMandateIfscCodeViewModel;
    /* access modifiers changed from: private */
    public BankMandateStateCityBrAdapter bankMandateStateCityBrAdapter;
    /* access modifiers changed from: private */
    public FragmentBankMandateStateListBinding lytBankMandateStateListBinding;
    /* access modifiers changed from: private */
    public List<BankMandateIFSCBranchDetails> mBranchList;
    private ArrayList<String> mList;
    /* access modifiers changed from: private */
    public String mType = "STATE";

    public static BankMandateStateCityBrFragment getInstance() {
        return new BankMandateStateCityBrFragment();
    }

    public static BankMandateStateCityBrFragment newInstance(Serializable serializable, String str) {
        BankMandateStateCityBrFragment bankMandateStateCityBrFragment = new BankMandateStateCityBrFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_LIST, serializable);
        bundle.putString(ARG_TYPE_LIST, str);
        bankMandateStateCityBrFragment.setArguments(bundle);
        return bankMandateStateCityBrFragment;
    }

    public static BankMandateStateCityBrFragment newInstance(Serializable serializable, Serializable serializable2, String str) {
        BankMandateStateCityBrFragment bankMandateStateCityBrFragment = new BankMandateStateCityBrFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_LIST, serializable);
        bundle.putSerializable(ARG_BRANCH_LIST, serializable2);
        bundle.putString(ARG_TYPE_LIST, str);
        bankMandateStateCityBrFragment.setArguments(bundle);
        return bankMandateStateCityBrFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mType = getArguments().getString(ARG_TYPE_LIST);
            this.mList = (ArrayList) getArguments().getSerializable(ARG_LIST);
            if (getArguments().get(ARG_BRANCH_LIST) != null) {
                this.mBranchList = (List) getArguments().getSerializable(ARG_BRANCH_LIST);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lytBankMandateStateListBinding = (FragmentBankMandateStateListBinding) f.a(getLayoutInflater(), R.layout.fragment_bank_mandate_state_list, (ViewGroup) null, false);
        this.lytBankMandateStateListBinding.rvStateList.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.lytBankMandateStateListBinding.rvStateList.setHasFixedSize(true);
        this.lytBankMandateStateListBinding.searchViewState.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (TextUtils.isEmpty(charSequence)) {
                    BankMandateStateCityBrFragment.this.lytBankMandateStateListBinding.imgEdtCross.setVisibility(8);
                } else {
                    BankMandateStateCityBrFragment.this.lytBankMandateStateListBinding.imgEdtCross.setVisibility(0);
                }
                if (BankMandateStateCityBrFragment.this.bankMandateStateCityBrAdapter != null) {
                    BankMandateStateCityBrFragment.this.bankMandateStateCityBrAdapter.getFilter().filter(charSequence);
                }
            }
        });
        this.lytBankMandateStateListBinding.searchViewState.requestFocus();
        this.lytBankMandateStateListBinding.imgEdtCross.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankMandateStateCityBrFragment.this.lytBankMandateStateListBinding.searchViewState.setText("");
            }
        });
        ArrayList<String> arrayList = this.mList;
        if (arrayList != null && arrayList.size() > 0) {
            this.bankMandateStateCityBrAdapter = new BankMandateStateCityBrAdapter(getActivity(), this.mList);
            this.lytBankMandateStateListBinding.rvStateList.setAdapter(this.bankMandateStateCityBrAdapter);
        }
        registerOnItemClickOnRecyclerView();
        if (this.mType.equals(SDKConstants.TYPE_BANK)) {
            this.lytBankMandateStateListBinding.tvToolbarTitle.setText(getActivity().getResources().getString(R.string.select_bank));
        } else if (this.mType.equals("STATE")) {
            this.lytBankMandateStateListBinding.tvToolbarTitle.setText(getActivity().getResources().getString(R.string.select_state_text));
        } else if (this.mType.equals("CITY")) {
            this.lytBankMandateStateListBinding.tvToolbarTitle.setText(getActivity().getResources().getString(R.string.select_city_text));
        } else if (this.mType.equals(SDKConstants.TYPE_BRANCH)) {
            this.lytBankMandateStateListBinding.tvToolbarTitle.setText(getActivity().getResources().getString(R.string.select_branch_text));
        }
        this.lytBankMandateStateListBinding.ivBackArrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankMandateStateCityBrFragment.this.onBackPressed();
            }
        });
        return this.lytBankMandateStateListBinding.getRoot();
    }

    public void setViewModel(BankMandateIfscCodeViewModel bankMandateIfscCodeViewModel2) {
        this.bankMandateIfscCodeViewModel = bankMandateIfscCodeViewModel2;
    }

    private void registerOnItemClickOnRecyclerView() {
        this.lytBankMandateStateListBinding.rvStateList.addOnItemTouchListener(new RecyclerItemClickListner(getActivity(), new RecyclerItemClickListner.OnItemClickListener() {
            public void onItemClick(View view, int i2) {
                String str = BankMandateStateCityBrFragment.this.bankMandateStateCityBrAdapter.getList().get(i2);
                if (BankMandateStateCityBrFragment.this.mType.equals(SDKConstants.TYPE_BANK)) {
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.bankName.set(str);
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.stateName.set("");
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.cityName.set("");
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.branchName.set("");
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.ifscCode.set("");
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.stateClickable.set(true);
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.cityClickable.set(false);
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.branchClickable.set(false);
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.ifscVisibility.set(8);
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.continueVisibility.set(8);
                } else if (BankMandateStateCityBrFragment.this.mType.equals("STATE")) {
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.stateName.set(str);
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.cityName.set("");
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.branchName.set("");
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.ifscCode.set("");
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.cityClickable.set(true);
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.branchClickable.set(false);
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.ifscVisibility.set(8);
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.continueVisibility.set(8);
                } else if (BankMandateStateCityBrFragment.this.mType.equals("CITY")) {
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.cityName.set(str);
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.branchName.set("");
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.ifscCode.set("");
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.branchClickable.set(true);
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.ifscVisibility.set(8);
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.continueVisibility.set(8);
                } else if (BankMandateStateCityBrFragment.this.mType.equals(SDKConstants.TYPE_BRANCH)) {
                    BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.branchName.set(str);
                    if (BankMandateStateCityBrFragment.this.mBranchList != null && BankMandateStateCityBrFragment.this.mBranchList.size() > 0) {
                        BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.ifscVisibility.set(0);
                        BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.continueVisibility.set(0);
                        Iterator it2 = BankMandateStateCityBrFragment.this.mBranchList.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            BankMandateIFSCBranchDetails bankMandateIFSCBranchDetails = (BankMandateIFSCBranchDetails) it2.next();
                            if (bankMandateIFSCBranchDetails.getDisplayName().equals(str)) {
                                BankMandateStateCityBrFragment.this.bankMandateIfscCodeViewModel.ifscCode.set(bankMandateIFSCBranchDetails.getIfscCode());
                                SDKUtility.hideKeyboard(BankMandateStateCityBrFragment.this.getActivity());
                                break;
                            }
                        }
                    }
                }
                BankMandateStateCityBrFragment.this.onBackPressed();
            }
        }));
    }

    public void onBackPressed() {
        j supportFragmentManager = getActivity().getSupportFragmentManager();
        if (supportFragmentManager != null) {
            supportFragmentManager.d();
        }
    }
}
