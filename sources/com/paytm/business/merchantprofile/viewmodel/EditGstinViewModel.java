package com.paytm.business.merchantprofile.viewmodel;

import android.app.Application;
import android.text.Editable;
import android.text.TextUtils;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.i;
import com.business.common_module.utilities.a.c;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.gtm.GAGTMTagAnalytics;
import com.paytm.business.merchantprofile.common.utility.PatternsUtil;
import com.paytm.business.merchantprofile.listener.IEditGstin;
import com.paytm.business.merchantprofile.model.EditGstinAddress;

public class EditGstinViewModel extends c {
    public IEditGstin iEditGstin;
    public i<String> mDocName;
    public EditGstinAddress mEditGstinAddress;
    public i<String> mGstin;
    public i<String> mGstinError;
    public i<String> mSubTitle;
    public i<String> mTitle;
    public ObservableBoolean uploadDocVisibility;

    public EditGstinViewModel(Application application) {
        super(application);
    }

    public void initDefaultParams() {
        this.mGstin = new i<>("");
        this.mDocName = new i<>("");
        this.mTitle = new i<>("");
        this.mSubTitle = new i<>("");
        this.mGstinError = new i<>("");
        this.uploadDocVisibility = new ObservableBoolean(true);
    }

    public void setData(IEditGstin iEditGstin2, EditGstinAddress editGstinAddress) {
        String str;
        this.iEditGstin = iEditGstin2;
        this.mEditGstinAddress = editGstinAddress;
        this.mGstin.set(editGstinAddress.getOldGstin());
        i<String> iVar = this.mTitle;
        if (TextUtils.isEmpty(this.mEditGstinAddress.getOldGstin())) {
            str = ProfileConfig.getInstance().getAppContext().getString(R.string.pr_lbl_add_gstin_text);
        } else {
            str = ProfileConfig.getInstance().getAppContext().getString(R.string.pr_lbl_update_gstin);
        }
        iVar.set(str);
        if (isInvokedAfterStateMisMatched()) {
            this.mSubTitle.set(ProfileConfig.getInstance().getAppContext().getString(R.string.pr_update_gstin_subtitle));
        }
    }

    public void afterGstinChanged(Editable editable) {
        this.mGstinError.set("");
    }

    public boolean isGstinValidOnClient() {
        this.mGstinError.set("");
        if (!PatternsUtil.isValidGSTIN(this.mGstin.get(), !ProfileConfig.getInstance().getMerchantDataProvider().q())) {
            this.mGstinError.set(ProfileConfig.getInstance().getAppContext().getString(R.string.pr_enter_valid_gstin));
            return false;
        } else if (!"50k".equalsIgnoreCase(ProfileConfig.getInstance().getMerchantDataProvider().t()) && !this.mGstin.get().substring(2, 12).equals(this.mEditGstinAddress.getPanNo())) {
            this.mGstinError.set(ProfileConfig.getInstance().getAppContext().getString(R.string.pr_error_msg_pan_gstin_mismatch));
            return false;
        } else if (!isInvokedAfterStateMisMatched() || this.mGstin.get().startsWith(this.mEditGstinAddress.getNewBillingAddress().getStateGSTCode())) {
            this.mEditGstinAddress.setAddressOnly(false);
            this.mEditGstinAddress.setNewGstin(this.mGstin.get());
            if (TextUtils.isEmpty(this.mEditGstinAddress.getOldGstin())) {
                GAGTMTagAnalytics.getSingleInstance().sendEvent(getContext(), "Business Profile", "Business Details", "", "add_GSTIN");
            }
            return true;
        } else {
            this.mGstinError.set(ProfileConfig.getInstance().getAppContext().getString(R.string.pr_gstin_state_mismatch_error));
            return false;
        }
    }

    public void onUploadDoc() {
        this.iEditGstin.showOpenFileIntent();
    }

    public void onClose() {
        this.iEditGstin.dismissDialog();
    }

    private boolean isInvokedAfterStateMisMatched() {
        return this.mEditGstinAddress.getNewBillingAddress() != null && !"00".equals(this.mEditGstinAddress.getNewBillingAddress().getStateGSTCode());
    }

    public EditGstinAddress getEditGstinAddress() {
        return this.mEditGstinAddress;
    }
}
