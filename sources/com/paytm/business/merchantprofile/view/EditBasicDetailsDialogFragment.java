package com.paytm.business.merchantprofile.view;

import android.os.Bundle;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.databinding.f;
import androidx.lifecycle.z;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.e;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.BaseActivity;
import com.paytm.business.merchantprofile.common.BaseFragment;
import com.paytm.business.merchantprofile.common.ErrorUtil;
import com.paytm.business.merchantprofile.common.gtm.GAGTMTagAnalytics;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.business.merchantprofile.databinding.PrFragmentEditBasicDetailsBinding;
import com.paytm.business.merchantprofile.event.CloseOtpScreenEvent;
import com.paytm.business.merchantprofile.event.EditBusinessDetailEvent;
import com.paytm.business.merchantprofile.event.OtpEnteredEvent;
import com.paytm.business.merchantprofile.event.OtpWrongEvent;
import com.paytm.business.merchantprofile.listener.IEditBasicDetails;
import com.paytm.business.merchantprofile.model.GenerateOtpResponseModel;
import com.paytm.business.merchantprofile.model.MerchantProfileResponse;
import com.paytm.business.merchantprofile.viewmodel.EditBasicDetailsViewModel;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.j;

public class EditBasicDetailsDialogFragment extends BaseFragment implements IEditBasicDetails {
    public static final String KEY_TYPE = "type";
    public static final String KEY_VALUE = "value";
    public static final String TYPE_DISPLAY_NAME = "update_display_name";
    public static final String TYPE_LOGIN_DETAILS = "update_login_details";
    public static final String TYPE_PRIMARY_EMAIL = "update_primary_email";
    public static final String TYPE_PRIMARY_MOBILE = "update_primary_mobile";
    public static final String TYPE_SECONDARY_EMAIL = "update_secondary_email";
    public static final String TYPE_SECONDARY_MOBILE = "update_secondary_mobile";
    public final String TAG = EditBasicDetailsDialogFragment.class.getSimpleName();
    public PrFragmentEditBasicDetailsBinding mBinding;
    public String mType;
    public EditBasicDetailsViewModel mViewModel;

    public static EditBasicDetailsDialogFragment newInstance(String str, String str2) {
        Bundle bundle = new Bundle();
        EditBasicDetailsDialogFragment editBasicDetailsDialogFragment = new EditBasicDetailsDialogFragment();
        bundle.putString("type", str);
        bundle.putString("value", str2);
        editBasicDetailsDialogFragment.setArguments(bundle);
        return editBasicDetailsDialogFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        PrFragmentEditBasicDetailsBinding prFragmentEditBasicDetailsBinding = (PrFragmentEditBasicDetailsBinding) f.a(layoutInflater, R.layout.pr_fragment_edit_basic_details, viewGroup, false);
        this.mBinding = prFragmentEditBasicDetailsBinding;
        return prFragmentEditBasicDetailsBinding.getRoot();
    }

    public void onResume() {
        super.onResume();
        GAGTMTagAnalytics.getSingleInstance().pushScreenEvent("business-app/Account/Business Profile/Change Business Name");
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initUI();
    }

    public void initUI() {
        this.mType = getArguments().getString("type");
        EditBasicDetailsViewModel editBasicDetailsViewModel = (EditBasicDetailsViewModel) ((BaseActivity) getActivity()).provideViewModel(EditBasicDetailsViewModel.class, this);
        this.mViewModel = editBasicDetailsViewModel;
        editBasicDetailsViewModel.setData(this, this.mType, getArguments().getString("value"));
        this.mBinding.setViewModel(this.mViewModel);
        this.mBinding.etInput.post(new Runnable() {
            public final void run() {
                EditBasicDetailsDialogFragment.this.lambda$initUI$0$EditBasicDetailsDialogFragment();
            }
        });
        this.mBinding.ivCross.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditBasicDetailsDialogFragment.this.lambda$initUI$1$EditBasicDetailsDialogFragment(view);
            }
        });
        this.mViewModel.getGenerateOtpEvent().observe(getViewLifecycleOwner(), new z() {
            public final void onChanged(Object obj) {
                EditBasicDetailsDialogFragment.this.lambda$initUI$2$EditBasicDetailsDialogFragment((b) obj);
            }
        });
    }

    public /* synthetic */ void lambda$initUI$0$EditBasicDetailsDialogFragment() {
        Selection.setSelection(this.mBinding.etInput.getText(), this.mBinding.etInput.getText().length());
    }

    public /* synthetic */ void lambda$initUI$1$EditBasicDetailsDialogFragment(View view) {
        getActivity().onBackPressed();
    }

    public /* synthetic */ void lambda$initUI$2$EditBasicDetailsDialogFragment(b bVar) {
        removeProgressDialog();
        if (bVar != null && bVar.f7356a != null) {
            OtpDialogFragment.newInstance(this.mType, getArguments().getString("value"), (GenerateOtpResponseModel) bVar.f7358c, false, false).show(getChildFragmentManager(), this.TAG);
        } else if (bVar != null) {
            Toast.makeText(getContext(), R.string.pr_lbl_please_try_again_later, 1).show();
        }
    }

    public void setResponseObserver() {
        this.mViewModel.responseLiveData.observe(this, new z() {
            public final void onChanged(Object obj) {
                EditBasicDetailsDialogFragment.this.lambda$setResponseObserver$3$EditBasicDetailsDialogFragment((b) obj);
            }
        });
    }

    public /* synthetic */ void lambda$setResponseObserver$3$EditBasicDetailsDialogFragment(b bVar) {
        if (bVar != null && bVar.f7357b != e.LOADING) {
            removeProgressDialog();
            T t = bVar.f7358c;
            if (t == null || ((MerchantProfileResponse) t).getStatus() == null) {
                if (TYPE_LOGIN_DETAILS.equalsIgnoreCase(this.mType)) {
                    c.a().c(new CloseOtpScreenEvent());
                }
                ErrorUtil.handleAPIError(this.mType, "UMP", bVar);
                return;
            }
            String upperCase = ((MerchantProfileResponse) bVar.f7358c).getStatus().toUpperCase();
            char c2 = 65535;
            switch (upperCase.hashCode()) {
                case -1149187101:
                    if (upperCase.equals("SUCCESS")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -368591510:
                    if (upperCase.equals("FAILURE")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 35394935:
                    if (upperCase.equals("PENDING")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 66247144:
                    if (upperCase.equals(AppConstants.TRANSACTION_STATUS_ERROR)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 2066319421:
                    if (upperCase.equals("FAILED")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                if (TYPE_LOGIN_DETAILS.equalsIgnoreCase(this.mType)) {
                    c.a().c(new CloseOtpScreenEvent());
                }
                c.a().c(new EditBusinessDetailEvent(this.mType, this.mViewModel.getUpdatedValue()));
                dismissDialog();
            } else if (c2 == 1) {
                c.a().c(new EditBusinessDetailEvent(this.mType, ""));
                dismissDialog();
            } else if (c2 != 2) {
                if (c2 != 3) {
                    ErrorUtil.handleAPIError(this.mType, "UMP", bVar);
                } else if (TYPE_LOGIN_DETAILS.equalsIgnoreCase(this.mType)) {
                    c.a().c(new OtpWrongEvent());
                } else {
                    Toast.makeText(getContext(), ((MerchantProfileResponse) bVar.f7358c).getStatus(), 1).show();
                }
            } else if (TYPE_LOGIN_DETAILS.equalsIgnoreCase(this.mType)) {
                c.a().c(new CloseOtpScreenEvent());
                Toast.makeText(getContext(), ((MerchantProfileResponse) bVar.f7358c).getStatus(), 1).show();
            } else if (this.mType.equalsIgnoreCase(TYPE_DISPLAY_NAME)) {
                Toast.makeText(getContext(), getContext().getString(R.string.pr_edit_display_name_restricted_desc), 1).show();
            } else {
                Toast.makeText(getContext(), ((MerchantProfileResponse) bVar.f7358c).getStatus(), 1).show();
            }
        }
    }

    public void dismissDialog() {
        getActivity().onBackPressed();
    }

    @j
    public void onErrorRetryEvent(com.business.common_module.events.b bVar) {
        if (this.mType.equals(bVar.f7341a)) {
            this.mViewModel.onContinue();
        }
    }

    public void showProgressDialog() {
        ((BaseActivity) getActivity()).showProgressDialog();
    }

    public void removeProgressDialog() {
        ((BaseActivity) getActivity()).removeProgressDialog();
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
    public void otpEnteredByUser(OtpEnteredEvent otpEnteredEvent) {
        this.mViewModel.onOtpEnteredByUser(otpEnteredEvent);
    }
}
