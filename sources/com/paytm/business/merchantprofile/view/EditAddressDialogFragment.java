package com.paytm.business.merchantprofile.view;

import android.os.Bundle;
import android.text.Selection;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.databinding.f;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.BaseActivity;
import com.paytm.business.merchantprofile.common.BaseFragment;
import com.paytm.business.merchantprofile.common.gtm.GAGTMTagAnalytics;
import com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBinding;
import com.paytm.business.merchantprofile.model.EditGstinAddress;
import com.paytm.business.merchantprofile.viewmodel.EditAddressViewModel;

public class EditAddressDialogFragment extends BaseFragment {
    public static final String KEY_ITEM = "item";
    public PfbSpinnerAdapter adapter;
    public boolean isFirstFlow;
    public PrFragmentEditAddressBinding mBinding;
    public EditGstinAddress mEditGstinAddress;
    public EditAddressViewModel mViewModel;

    public static EditAddressDialogFragment newInstance(EditGstinAddress editGstinAddress) {
        Bundle bundle = new Bundle();
        EditAddressDialogFragment editAddressDialogFragment = new EditAddressDialogFragment();
        bundle.putSerializable("item", editGstinAddress);
        editAddressDialogFragment.setArguments(bundle);
        return editAddressDialogFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mEditGstinAddress = (EditGstinAddress) getArguments().getSerializable("item");
        this.isFirstFlow = true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        PrFragmentEditAddressBinding prFragmentEditAddressBinding = (PrFragmentEditAddressBinding) f.a(layoutInflater, R.layout.pr_fragment_edit_address, viewGroup, false);
        this.mBinding = prFragmentEditAddressBinding;
        return prFragmentEditAddressBinding.getRoot();
    }

    public void onResume() {
        super.onResume();
        GAGTMTagAnalytics.getSingleInstance().pushScreenEvent("business-app/Account/Business Profile/Change registered Address");
    }

    public void initUI() {
        if (this.isFirstFlow) {
            EditAddressViewModel editAddressViewModel = (EditAddressViewModel) ((BaseActivity) getActivity()).provideViewModel(EditAddressViewModel.class, this);
            this.mViewModel = editAddressViewModel;
            editAddressViewModel.setData(this.mEditGstinAddress);
        }
        this.mBinding.setViewModel(this.mViewModel);
        this.isFirstFlow = false;
        this.mBinding.etAddress1.post(new Runnable() {
            public final void run() {
                EditAddressDialogFragment.this.lambda$initUI$0$EditAddressDialogFragment();
            }
        });
        this.mBinding.etAddress2.post(new Runnable() {
            public final void run() {
                EditAddressDialogFragment.this.lambda$initUI$1$EditAddressDialogFragment();
            }
        });
        this.mBinding.etAddress3.post(new Runnable() {
            public final void run() {
                EditAddressDialogFragment.this.lambda$initUI$2$EditAddressDialogFragment();
            }
        });
        this.mBinding.etPincode.post(new Runnable() {
            public final void run() {
                EditAddressDialogFragment.this.lambda$initUI$3$EditAddressDialogFragment();
            }
        });
        this.mBinding.etCity.post(new Runnable() {
            public final void run() {
                EditAddressDialogFragment.this.lambda$initUI$4$EditAddressDialogFragment();
            }
        });
        this.mBinding.ivCross.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditAddressDialogFragment.this.lambda$initUI$5$EditAddressDialogFragment(view);
            }
        });
        setStateAdapter();
    }

    public /* synthetic */ void lambda$initUI$0$EditAddressDialogFragment() {
        Selection.setSelection(this.mBinding.etAddress1.getText(), this.mBinding.etAddress1.getText().length());
    }

    public /* synthetic */ void lambda$initUI$1$EditAddressDialogFragment() {
        Selection.setSelection(this.mBinding.etAddress2.getText(), this.mBinding.etAddress2.getText().length());
    }

    public /* synthetic */ void lambda$initUI$2$EditAddressDialogFragment() {
        Selection.setSelection(this.mBinding.etAddress3.getText(), this.mBinding.etAddress3.getText().length());
    }

    public /* synthetic */ void lambda$initUI$3$EditAddressDialogFragment() {
        Selection.setSelection(this.mBinding.etPincode.getText(), this.mBinding.etPincode.getText().length());
    }

    public /* synthetic */ void lambda$initUI$4$EditAddressDialogFragment() {
        Selection.setSelection(this.mBinding.etCity.getText(), this.mBinding.etCity.getText().length());
    }

    public /* synthetic */ void lambda$initUI$5$EditAddressDialogFragment(View view) {
        getActivity().onBackPressed();
    }

    private void setStateAdapter() {
        PfbSpinnerAdapter pfbSpinnerAdapter = new PfbSpinnerAdapter(getContext(), 17367048, this.mViewModel.getGSTStateNamesList());
        this.adapter = pfbSpinnerAdapter;
        pfbSpinnerAdapter.setDropDownViewResource(17367049);
        this.mBinding.stateSpinner.setAdapter(this.adapter);
        this.mBinding.stateSpinner.setSelection(this.mViewModel.selectedStateIndex);
        this.mBinding.stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                if (i2 != 0) {
                    EditAddressDialogFragment.this.mViewModel.selectedStateIndex = i2;
                    String str = EditAddressDialogFragment.this.getResources().getStringArray(R.array.pr_gst_states)[i2];
                    EditAddressDialogFragment.this.mViewModel.stateGSTCode = str.substring(0, 2);
                    EditAddressDialogFragment.this.mViewModel.mState.set(str.substring(3));
                }
            }
        });
        this.mBinding.stateSpinner.setEnabled(TextUtils.isEmpty(this.mEditGstinAddress.getNewGstin()));
    }

    public void setPincodeDetails(String str, String str2) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mBinding.etCity.setText(str);
        }
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            this.mBinding.stateSpinner.setSelection(this.adapter.getPosition(str2));
        }
    }

    public void setPincodeError() {
        this.mViewModel.mPinCodeError.set(getContext().getString(R.string.pr_error_pincode_invalid));
    }
}
