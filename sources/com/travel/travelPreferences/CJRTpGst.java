package com.travel.travelPreferences;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTpGst implements IJRDataModel {
    @b(a = "business_profile")
    private boolean businessProfile;
    @b(a = "company_address")
    private String companyAddress;
    @b(a = "company_name")
    private String companyName;
    @b(a = "company_contact")
    private String contactNumber;
    @b(a = "company_gst_email")
    private String gstEmail;
    @b(a = "gst_number")
    private String gstNumber;
    @b(a = "state_of_residence")
    private String stateOfResidence;

    public boolean getBusinessProfile() {
        return this.businessProfile;
    }

    public String getGstNumber() {
        return this.gstNumber;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getCompanyAddress() {
        return this.companyAddress;
    }

    public String getStateOfResidence() {
        return this.stateOfResidence;
    }

    public String getCompanyContactNumber() {
        return this.contactNumber;
    }

    public String getCompanyGstEmail() {
        return this.gstEmail;
    }
}
