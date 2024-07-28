package com.paytm.business.merchantprofile.model;

import android.net.Uri;
import com.business.common_module.f.a;
import com.google.gson.a.c;

public class EditGstinAddress extends a {
    public static final long serialVersionUID = 1;
    @c(a = "addressOnly")
    public boolean addressOnly;
    public String fileName;
    @c(a = "newBillingAddress")
    public AddressDetailsModel newBillingAddress;
    @c(a = "newGstin")
    public String newGstin;
    @c(a = "oldBillingAddress")
    public AddressDetailsModel oldBillingAddress;
    @c(a = "oldGstin")
    public String oldGstin;
    public String panNo;
    public String uriString;

    public String getOldGstin() {
        return this.oldGstin;
    }

    public void setOldGstin(String str) {
        this.oldGstin = str;
    }

    public String getNewGstin() {
        return this.newGstin;
    }

    public void setNewGstin(String str) {
        this.newGstin = str;
    }

    public AddressDetailsModel getOldBillingAddress() {
        return this.oldBillingAddress;
    }

    public void setOldBillingAddress(AddressDetailsModel addressDetailsModel) {
        this.oldBillingAddress = addressDetailsModel;
    }

    public AddressDetailsModel getNewBillingAddress() {
        return this.newBillingAddress;
    }

    public void setNewBillingAddress(AddressDetailsModel addressDetailsModel) {
        this.newBillingAddress = addressDetailsModel;
    }

    public boolean isAddressOnly() {
        return this.addressOnly;
    }

    public void setAddressOnly(boolean z) {
        this.addressOnly = z;
    }

    public Uri getUri() {
        String str = this.uriString;
        if (str != null) {
            return Uri.parse(str);
        }
        return null;
    }

    public void setUri(Uri uri) {
        this.uriString = uri != null ? uri.toString() : null;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public String getPanNo() {
        return this.panNo;
    }

    public void setPanNo(String str) {
        this.panNo = str;
    }
}
