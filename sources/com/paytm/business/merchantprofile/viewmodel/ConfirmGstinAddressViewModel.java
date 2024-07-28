package com.paytm.business.merchantprofile.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import androidx.lifecycle.LiveData;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.common.ErrorUtil;
import com.paytm.business.merchantprofile.common.utility.AppUtility;
import com.paytm.business.merchantprofile.listener.IConfirmGstinAddress;
import com.paytm.business.merchantprofile.model.EditGstinAddress;
import com.paytm.business.merchantprofile.model.MerchantProfileResponse;
import com.paytm.business.merchantprofile.repo.ProfileRepository;

public class ConfirmGstinAddressViewModel extends c {
    public IConfirmGstinAddress iConfirmGstinAddress;
    public i<String> mAddress;
    public ObservableInt mAddressVisibility;
    public i<String> mDocName;
    public ObservableInt mDocNameVisibility;
    public EditGstinAddress mEditGstinAddress;
    public i<String> mGstin;
    public ObservableInt mGstinVisibility;
    public String mType;
    public LiveData<b<MerchantProfileResponse>> responseLiveData;

    public ConfirmGstinAddressViewModel(Application application) {
        super(application);
    }

    public void initDefaultParams() {
        this.mGstin = new i<>("");
        this.mDocName = new i<>("");
        this.mAddress = new i<>("");
        this.mGstinVisibility = new ObservableInt();
        this.mDocNameVisibility = new ObservableInt();
        this.mAddressVisibility = new ObservableInt();
    }

    public void setData(IConfirmGstinAddress iConfirmGstinAddress2, String str, EditGstinAddress editGstinAddress) {
        this.iConfirmGstinAddress = iConfirmGstinAddress2;
        this.mType = str;
        this.mEditGstinAddress = editGstinAddress;
        int i2 = 8;
        if (editGstinAddress.isAddressOnly()) {
            this.mDocNameVisibility.set(8);
            this.mGstinVisibility.set(8);
        } else {
            this.mDocNameVisibility.set(0);
            this.mGstinVisibility.set(0);
            this.mDocName.set(this.mEditGstinAddress.getFileName());
            this.mGstin.set(this.mEditGstinAddress.getNewGstin());
        }
        String stringAddressDetailModel = AppUtility.getStringAddressDetailModel(this.mEditGstinAddress.getNewBillingAddress());
        this.mAddress.set(stringAddressDetailModel);
        ObservableInt observableInt = this.mAddressVisibility;
        if (!TextUtils.isEmpty(stringAddressDetailModel)) {
            i2 = 0;
        }
        observableInt.set(i2);
    }

    public void onContinue() {
        if (!com.business.common_module.utilities.i.a(ProfileConfig.getInstance().getApplication())) {
            ErrorUtil.handleNoNetworkError(this.mType);
            return;
        }
        this.iConfirmGstinAddress.showProgressDialog();
        this.responseLiveData = ProfileRepository.getInstance().updateMerchantProfileGstin(this.mEditGstinAddress, this.mType);
        this.iConfirmGstinAddress.setResponseObserver();
    }

    public void onClose() {
        this.iConfirmGstinAddress.dismissDialog();
    }

    public String getRequestConfirmationValue() {
        return this.mEditGstinAddress.isAddressOnly() ? this.mAddress.get() : "";
    }
}
