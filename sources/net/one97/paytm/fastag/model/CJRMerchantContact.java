package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRMerchantContact extends IJRPaytmDataModel {
    @b(a = "cc_email")
    private String mCCEmail;
    @b(a = "cc_mobile")
    private String mCCMobile;
    @b(a = "email_id")
    private String mEmailId;
    @b(a = "id")
    private long mId;
    @b(a = "address")
    private ArrayList<CJRMerchantAddress> mMerchantAddresses = new ArrayList<>();
    @b(a = "mobile_no")
    private String mMobileNo;
    @b(a = "name")
    private String mName;

    public ArrayList<CJRMerchantAddress> getMerchantAddresses() {
        return this.mMerchantAddresses;
    }

    public String getEmailId() {
        return this.mEmailId;
    }

    public String getMobileNumber() {
        return this.mMobileNo;
    }

    public String getName() {
        return this.mName;
    }
}
