package com.paytm.business.merchantprofile.model;

import com.business.common_module.f.a;

public class EditDetailsModel extends a {
    public AddressDetailsModel addressDetailsModel;
    public boolean displayNameChangeVisibility;
    public boolean gstinChangeVisibility;
    public KycDetailsModel kycDetailsModel;
    public BasicDetailsModel mBasicDetailsModel;

    public AddressDetailsModel getAddressDetailsModel() {
        return this.addressDetailsModel;
    }

    public void setAddressDetailsModel(AddressDetailsModel addressDetailsModel2) {
        this.addressDetailsModel = addressDetailsModel2;
    }

    public BasicDetailsModel getmBasicDetailsModel() {
        return this.mBasicDetailsModel;
    }

    public void setmBasicDetailsModel(BasicDetailsModel basicDetailsModel) {
        this.mBasicDetailsModel = basicDetailsModel;
    }

    public KycDetailsModel getKycDetailsModel() {
        return this.kycDetailsModel;
    }

    public void setKycDetailsModel(KycDetailsModel kycDetailsModel2) {
        this.kycDetailsModel = kycDetailsModel2;
    }

    public boolean isDisplayNameChangeVisibility() {
        return this.displayNameChangeVisibility;
    }

    public void setDisplayNameChangeVisibility(boolean z) {
        this.displayNameChangeVisibility = z;
    }

    public boolean isGstinChangeVisibility() {
        return this.gstinChangeVisibility;
    }

    public void setGstinChangeVisibility(boolean z) {
        this.gstinChangeVisibility = z;
    }
}
