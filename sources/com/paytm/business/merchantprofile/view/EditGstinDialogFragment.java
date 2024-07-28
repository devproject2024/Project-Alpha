package com.paytm.business.merchantprofile.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Selection;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.databinding.f;
import androidx.lifecycle.z;
import com.business.common_module.events.a;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.e;
import com.business.common_module.utilities.i;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.BaseActivity;
import com.paytm.business.merchantprofile.common.BaseFragment;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.business.merchantprofile.databinding.PrFragmentEditGstinBinding;
import com.paytm.business.merchantprofile.event.EditBusinessDetailEvent;
import com.paytm.business.merchantprofile.listener.IEditGstin;
import com.paytm.business.merchantprofile.model.AddUpdateGstinResponseModel;
import com.paytm.business.merchantprofile.model.EditGstinAddress;
import com.paytm.business.merchantprofile.profileotp.AddMobileOTPActivity;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModel;
import com.paytm.business.merchantprofile.viewmodel.EditGstinViewModel;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.j;

public class EditGstinDialogFragment extends BaseFragment implements IEditGstin {
    public static final String KEY_ITEM = "item";
    public static final int PICK_REQUEST_CODE = 14;
    public final String TYPE_GSTIN = "update_gstin";
    public boolean isFirstFlow;
    public AddEditGstinViewModel mAddEditGstinViewModel;
    public PrFragmentEditGstinBinding mBinding;
    public String mBusinessName;
    public EditGstinAddress mEditGstinAddress;
    public EditGstinViewModel mViewModel;

    public void showOpenFileIntent() {
    }

    public static EditGstinDialogFragment newInstance(EditGstinAddress editGstinAddress, String str) {
        Bundle bundle = new Bundle();
        EditGstinDialogFragment editGstinDialogFragment = new EditGstinDialogFragment();
        bundle.putSerializable("item", editGstinAddress);
        bundle.putString("businessName", str);
        editGstinDialogFragment.setArguments(bundle);
        return editGstinDialogFragment;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10000 && i3 == -1) {
            String stringExtra = intent.getStringExtra("OTP");
            String stringExtra2 = intent.getStringExtra("OTP_STATE");
            if (!TextUtils.isEmpty(stringExtra) || !TextUtils.isEmpty(stringExtra2)) {
                processOtp(stringExtra, stringExtra2);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mEditGstinAddress = (EditGstinAddress) getArguments().getSerializable("item");
        this.mBusinessName = getArguments().getString("businessName");
        this.isFirstFlow = true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        PrFragmentEditGstinBinding prFragmentEditGstinBinding = (PrFragmentEditGstinBinding) f.a(layoutInflater, R.layout.pr_fragment_edit_gstin, viewGroup, false);
        this.mBinding = prFragmentEditGstinBinding;
        return prFragmentEditGstinBinding.getRoot();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initUI();
    }

    private void initObservers() {
        this.mAddEditGstinViewModel.getMAddUpdateGstinLiveData().observe(getViewLifecycleOwner(), new z() {
            public final void onChanged(Object obj) {
                EditGstinDialogFragment.this.observeAddUpdateResponse((b) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public void observeAddUpdateResponse(b<AddUpdateGstinResponseModel> bVar) {
        T t;
        if (!requireActivity().isFinishing()) {
            ((BaseActivity) requireActivity()).removeProgressDialog();
            if (bVar == null || (t = bVar.f7358c) == null) {
                if (i.a(ProfileConfig.getInstance().getApplication())) {
                    Toast.makeText(requireActivity(), ProfileConfig.getInstance().getAppContext().getString(R.string.pr_oops_something_went_wrong), 1).show();
                } else {
                    Toast.makeText(requireActivity(), ProfileConfig.getInstance().getAppContext().getString(R.string.pr_no_internet_connection), 1).show();
                }
            } else if (bVar.f7357b == e.SUCCESS) {
                Boolean isGstValid = ((AddUpdateGstinResponseModel) t).isGstValid();
                if (isGstValid == null || !isGstValid.booleanValue()) {
                    showAddUpdateGstinErrorToast((AddUpdateGstinResponseModel) bVar.f7358c);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(AppConstants.EDIT_OBJECT, getResult());
                requireActivity().setResult(-1, intent);
                requireActivity().finish();
            } else {
                showAddUpdateGstinErrorToast((AddUpdateGstinResponseModel) t);
            }
        }
    }

    private void showAddUpdateGstinErrorToast(AddUpdateGstinResponseModel addUpdateGstinResponseModel) {
        String str;
        if (addUpdateGstinResponseModel != null) {
            str = addUpdateGstinResponseModel.getResultMsg() != null ? addUpdateGstinResponseModel.getResultMsg().getDisplayMessage() : addUpdateGstinResponseModel.getStatusMessage();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = ProfileConfig.getInstance().getAppContext().getString(R.string.pr_oops_something_went_wrong);
        }
        Toast.makeText(requireActivity(), str, 1).show();
    }

    private EditBusinessDetailEvent getResult() {
        return new EditBusinessDetailEvent("update_gstin", this.mEditGstinAddress.getNewGstin());
    }

    public void initUI() {
        this.mBinding.etGstin.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        if (this.isFirstFlow) {
            EditGstinViewModel editGstinViewModel = (EditGstinViewModel) ((BaseActivity) getActivity()).provideViewModel(EditGstinViewModel.class, this);
            this.mViewModel = editGstinViewModel;
            editGstinViewModel.setData(this, this.mEditGstinAddress);
        }
        this.mBinding.setViewModel(this.mViewModel);
        this.isFirstFlow = false;
        this.mBinding.etGstin.post(new Runnable() {
            public final void run() {
                EditGstinDialogFragment.this.lambda$initUI$0$EditGstinDialogFragment();
            }
        });
        this.mAddEditGstinViewModel = (AddEditGstinViewModel) ((BaseActivity) getActivity()).provideViewModel(AddEditGstinViewModel.class, this);
        this.mBinding.addEditGstinSave.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditGstinDialogFragment.this.lambda$initUI$1$EditGstinDialogFragment(view);
            }
        });
        initObservers();
    }

    public /* synthetic */ void lambda$initUI$0$EditGstinDialogFragment() {
        Selection.setSelection(this.mBinding.etGstin.getText(), this.mBinding.etGstin.getText().length());
    }

    public /* synthetic */ void lambda$initUI$1$EditGstinDialogFragment(View view) {
        if (this.mViewModel.isGstinValidOnClient()) {
            startOtpActivity();
        }
    }

    public void dismissDialog() {
        getActivity().onBackPressed();
    }

    public void onStart() {
        super.onStart();
        c.a().a((Object) this);
    }

    public void onStop() {
        super.onStop();
        c.a().b(this);
    }

    @j
    public void onnDismissDialoEvent(a aVar) {
        getActivity().onBackPressed();
    }

    private void startOtpActivity() {
        Intent intent = new Intent(getActivity(), AddMobileOTPActivity.class);
        intent.putExtra("mobileNumber", ProfileConfig.getInstance().getMerchantDataProvider().z());
        intent.putExtra("otp_type", AppConstants.TYPE_OTP_GSTIN);
        startActivityForResult(intent, AppConstants.START_OTP_FLOW);
    }

    private void processOtp(String str, String str2) {
        String simpleName = EditGstinDialogFragment.class.getSimpleName();
        LogUtility.d(simpleName, "otp: " + str + "otpState: " + str2);
        if (this.mEditGstinAddress != null) {
            ((BaseActivity) requireActivity()).showProgressDialog();
            this.mAddEditGstinViewModel.callAddEditGstinApi(this.mEditGstinAddress, str, str2, this.mBusinessName);
        }
    }
}
