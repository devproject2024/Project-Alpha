package com.paytm.business.merchantprofile.viewmodel;

import android.app.Application;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.databinding.i;
import com.business.common_module.utilities.a.c;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.gtm.GAGTMTagAnalytics;
import com.paytm.business.merchantprofile.common.utility.PatternsUtil;
import com.paytm.business.merchantprofile.model.AddressDetailsModel;
import com.paytm.business.merchantprofile.model.EditGstinAddress;
import com.paytm.business.merchantprofile.model.PincodeItem;
import java.util.Arrays;
import java.util.List;

public class EditAddressViewModel extends c {
    public boolean isValidPincode;
    public i<String> mAddressLine1;
    public i<String> mAddressLine1Error;
    public i<String> mAddressLine2;
    public i<String> mAddressLine2Error;
    public i<String> mAddressLine3;
    public i<String> mAddressLine3Error;
    public i<String> mCTAText;
    public i<String> mCity;
    public i<String> mCityError;
    public EditGstinAddress mEditGstinAddress;
    public i<String> mPinCode;
    public i<String> mPinCodeError;
    public i<String> mState;
    public i<String> mSubTitle;
    public i<String> mTitle;
    public int selectedStateIndex = 0;
    public String stateGSTCode;

    public EditAddressViewModel(Application application) {
        super(application);
    }

    public void initDefaultParams() {
        this.mTitle = new i<>("");
        this.mSubTitle = new i<>("");
        this.mAddressLine1 = new i<>("");
        this.mAddressLine2 = new i<>("");
        this.mAddressLine3 = new i<>("");
        this.mAddressLine1Error = new i<>();
        this.mAddressLine2Error = new i<>();
        this.mAddressLine3Error = new i<>();
        this.mPinCode = new i<>();
        this.mPinCodeError = new i<>();
        this.mCity = new i<>("");
        this.mCityError = new i<>("");
        this.mState = new i<>("");
        this.mCTAText = new i<>("");
    }

    public void setData(EditGstinAddress editGstinAddress) {
        String str;
        String str2;
        this.mEditGstinAddress = editGstinAddress;
        i<String> iVar = this.mTitle;
        if (editGstinAddress.getOldBillingAddress() == null || TextUtils.isEmpty(this.mEditGstinAddress.getOldBillingAddress().getState())) {
            str = ProfileConfig.getInstance().getAppContext().getString(R.string.pr_add_communication_address);
        } else {
            str = ProfileConfig.getInstance().getAppContext().getString(R.string.pr_change_communication_address);
        }
        iVar.set(str);
        this.mSubTitle.set(getContext().getString(R.string.pr_billing_address_subtitle));
        i<String> iVar2 = this.mCTAText;
        if (this.mEditGstinAddress.getOldBillingAddress() == null || TextUtils.isEmpty(this.mEditGstinAddress.getOldBillingAddress().getState())) {
            str2 = ProfileConfig.getInstance().getAppContext().getString(R.string.pr_add_communication_address);
        } else {
            str2 = ProfileConfig.getInstance().getAppContext().getString(R.string.pr_change_communication_address);
        }
        iVar2.set(str2);
        if (this.mEditGstinAddress.getOldBillingAddress() != null) {
            this.mAddressLine1.set(this.mEditGstinAddress.getOldBillingAddress().getAddress1());
            this.mAddressLine2.set(this.mEditGstinAddress.getOldBillingAddress().getAddress2());
            this.mAddressLine3.set(this.mEditGstinAddress.getOldBillingAddress().getAddress3());
            this.mCity.set(this.mEditGstinAddress.getOldBillingAddress().getCity());
            if (!TextUtils.isEmpty(this.mEditGstinAddress.getOldBillingAddress().getState())) {
                this.mState.set(this.mEditGstinAddress.getOldBillingAddress().getState());
                this.selectedStateIndex = getGSTStateIndex(this.mEditGstinAddress.getOldBillingAddress().getState());
            }
            if (PatternsUtil.isValidPinCode(this.mEditGstinAddress.getOldBillingAddress().getPin())) {
                this.mPinCode.set(this.mEditGstinAddress.getOldBillingAddress().getPin());
                this.isValidPincode = true;
            }
        }
        if (!TextUtils.isEmpty(this.mEditGstinAddress.getNewGstin())) {
            this.stateGSTCode = this.mEditGstinAddress.getNewGstin().substring(0, 2);
            this.mState.set(getContext().getResources().getStringArray(R.array.pr_gst_states)[Integer.parseInt(this.stateGSTCode)].substring(3));
            this.selectedStateIndex = Integer.parseInt(this.stateGSTCode);
        }
    }

    public void afterAddressLine1Changed(Editable editable) {
        this.mAddressLine1Error.set("");
    }

    public void afterAddressLine2Changed(Editable editable) {
        this.mAddressLine2Error.set("");
    }

    public void afterAddressLine3Changed(Editable editable) {
        this.mAddressLine3Error.set("");
    }

    public void afterCityChanged(Editable editable) {
        this.mCityError.set("");
    }

    public void afterPinCodeChanged(Editable editable) {
        this.mPinCodeError.set("");
        if (editable.length() == 6) {
            getAddressFromPinCodeApi(editable.toString());
        }
    }

    private void getAddressFromPinCodeApi(String str) {
        PincodeItem pincodeItem = new PincodeItem();
        pincodeItem.setPincode(str);
        org.greenrobot.eventbus.c.a().c(pincodeItem);
    }

    public void onContinue() {
        if (isValid()) {
            GAGTMTagAnalytics.getSingleInstance().sendEvent(getContext(), "Account", "Business Profile", "", "Save registered address");
            this.mEditGstinAddress.setNewBillingAddress(getNewBillingAddress());
            this.mEditGstinAddress.setAddressOnly(true);
            org.greenrobot.eventbus.c.a().c(this.mEditGstinAddress);
        }
    }

    private boolean isAddressSameAsOld() {
        if (this.mEditGstinAddress.getOldBillingAddress() != null) {
            return this.mEditGstinAddress.getOldBillingAddress().toString().contentEquals(getNewBillingAddress().toString());
        }
        return false;
    }

    private boolean isValid() {
        String string = getContext().getString(R.string.pr_error_invalid_address);
        if (!validateAddress(this.mAddressLine1.get())) {
            this.mAddressLine1Error.set(string);
            return false;
        } else if (!validateAddress(this.mAddressLine2.get())) {
            this.mAddressLine2Error.set(string);
            return false;
        } else if (!validateAddress(this.mAddressLine3.get())) {
            this.mAddressLine3Error.set(string);
            return false;
        } else if (this.mPinCode.get() == null) {
            return false;
        } else {
            if (this.mPinCode.get().length() < 6) {
                this.mPinCodeError.set(getContext().getString(R.string.pr_error_pincode_length));
                return false;
            } else if (this.mPinCode.get().length() != 6 || PatternsUtil.isValidPinCode(this.mPinCode.get())) {
                i<String> iVar = this.mCity;
                if (iVar == null) {
                    return false;
                }
                if (iVar.get().length() <= 0) {
                    this.mCityError.set(getContext().getString(R.string.pr_error_invalid_name));
                    return false;
                } else if (!isAddressSameAsOld()) {
                    return true;
                } else {
                    Toast.makeText(getContext(), R.string.pr_no_edit_change_desc, 1).show();
                    return false;
                }
            } else {
                this.mPinCodeError.set(getContext().getString(R.string.pr_error_pincode_invalid));
                return false;
            }
        }
    }

    private boolean validateAddress(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (!TextUtils.isEmpty(trim) && PatternsUtil.isValidAddress(trim)) {
            return true;
        }
        return false;
    }

    private AddressDetailsModel getNewBillingAddress() {
        AddressDetailsModel addressDetailsModel = new AddressDetailsModel();
        addressDetailsModel.setAddress1(this.mAddressLine1.get().trim());
        addressDetailsModel.setAddress2(this.mAddressLine2.get().trim());
        addressDetailsModel.setAddress3(this.mAddressLine3.get().trim());
        addressDetailsModel.setCity(this.mCity.get());
        addressDetailsModel.setState(this.mState.get());
        addressDetailsModel.setPin(this.mPinCode.get());
        addressDetailsModel.setStateGSTCode(this.stateGSTCode);
        return addressDetailsModel;
    }

    public List<String> getGSTStateNamesList() {
        String[] stringArray = getContext().getResources().getStringArray(R.array.pr_gst_states);
        String[] strArr = new String[stringArray.length];
        for (int i2 = 0; i2 < stringArray.length; i2++) {
            strArr[i2] = stringArray[i2].split("\\|", 2)[1];
        }
        return Arrays.asList(strArr);
    }

    private int getGSTStateIndex(String str) {
        String[] stringArray = getContext().getResources().getStringArray(R.array.pr_gst_states);
        for (int i2 = 0; i2 < stringArray.length; i2++) {
            if (stringArray[i2].contains(str)) {
                return i2;
            }
        }
        return 0;
    }
}
