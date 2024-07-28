package com.paytm.business.merchantprofile.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.lifecycle.z;
import com.business.common_module.events.a;
import com.business.common_module.utilities.a.b;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.BaseActivity;
import com.paytm.business.merchantprofile.common.BaseFragment;
import com.paytm.business.merchantprofile.databinding.PrFragmentConfirmGstinAddressBinding;
import com.paytm.business.merchantprofile.event.EditBusinessDetailEvent;
import com.paytm.business.merchantprofile.listener.IConfirmGstinAddress;
import com.paytm.business.merchantprofile.model.EditGstinAddress;
import com.paytm.business.merchantprofile.model.MerchantProfileResponse;
import com.paytm.business.merchantprofile.view.MessageBottomSheet;
import com.paytm.business.merchantprofile.viewmodel.ConfirmGstinAddressViewModel;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.j;

public class ConfirmGstinAddressDialogFragment extends BaseFragment implements IConfirmGstinAddress {
    public static final String KEY_ITEM = "item";
    public static final String TYPE_GSTIN = "update_gstin";
    public PrFragmentConfirmGstinAddressBinding mBinding;
    public EditGstinAddress mEditGstinAddress;
    public ConfirmGstinAddressViewModel mViewModel;

    public static ConfirmGstinAddressDialogFragment newInstance(EditGstinAddress editGstinAddress) {
        Bundle bundle = new Bundle();
        ConfirmGstinAddressDialogFragment confirmGstinAddressDialogFragment = new ConfirmGstinAddressDialogFragment();
        bundle.putSerializable("item", editGstinAddress);
        confirmGstinAddressDialogFragment.setArguments(bundle);
        return confirmGstinAddressDialogFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mEditGstinAddress = (EditGstinAddress) getArguments().getSerializable("item");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        PrFragmentConfirmGstinAddressBinding prFragmentConfirmGstinAddressBinding = (PrFragmentConfirmGstinAddressBinding) f.a(layoutInflater, R.layout.pr_fragment_confirm_gstin_address, viewGroup, false);
        this.mBinding = prFragmentConfirmGstinAddressBinding;
        return prFragmentConfirmGstinAddressBinding.getRoot();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initUI();
    }

    public void initUI() {
        ConfirmGstinAddressViewModel confirmGstinAddressViewModel = (ConfirmGstinAddressViewModel) ((BaseActivity) getActivity()).provideViewModel(ConfirmGstinAddressViewModel.class, this);
        this.mViewModel = confirmGstinAddressViewModel;
        confirmGstinAddressViewModel.setData(this, "update_gstin", this.mEditGstinAddress);
        this.mBinding.setViewModel(this.mViewModel);
        this.mBinding.ivCross.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ConfirmGstinAddressDialogFragment.this.lambda$initUI$0$ConfirmGstinAddressDialogFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$initUI$0$ConfirmGstinAddressDialogFragment(View view) {
        getActivity().onBackPressed();
    }

    public void dismissDialog() {
        getActivity().onBackPressed();
    }

    public void setResponseObserver() {
        this.mViewModel.responseLiveData.observe(this, new z() {
            public final void onChanged(Object obj) {
                ConfirmGstinAddressDialogFragment.this.lambda$setResponseObserver$1$ConfirmGstinAddressDialogFragment((b) obj);
            }
        });
    }

    public /* synthetic */ void lambda$setResponseObserver$1$ConfirmGstinAddressDialogFragment(b bVar) {
        T t;
        removeProgressDialog();
        if (bVar != null && (t = bVar.f7358c) != null && ("SUCCESS".equals(((MerchantProfileResponse) t).getStatus()) || "PENDING".equals(((MerchantProfileResponse) bVar.f7358c).getStatus()))) {
            EditBusinessDetailEvent editBusinessDetailEvent = new EditBusinessDetailEvent("update_gstin", this.mViewModel.getRequestConfirmationValue());
            editBusinessDetailEvent.setEditGstinAddress(this.mEditGstinAddress);
            c.a().c(editBusinessDetailEvent);
            c.a().c(new a());
            dismissDialog();
        } else if (getActivity() != null && isAdded()) {
            final MessageBottomSheet messageBottomSheet = new MessageBottomSheet();
            messageBottomSheet.setListener(new MessageBottomSheet.ResolveIssueListener(this) {
                public void removeProgressDialog() {
                }

                public void showProgressDialog() {
                }

                public void finishActivity() {
                    messageBottomSheet.dismiss();
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString("title", getString(R.string.pr_response_could_not_submitted));
            bundle.putBoolean("FAILURE", true);
            messageBottomSheet.setArguments(bundle);
            messageBottomSheet.setCancelable(true);
            messageBottomSheet.show(getActivity().getSupportFragmentManager(), "message bottom sheet");
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
    public void onErrorRetryEvent(com.business.common_module.events.b bVar) {
        if ("update_gstin".equals(bVar.f7341a)) {
            this.mViewModel.onContinue();
        }
    }
}
