package net.one97.paytm.passbook.beans.userinfov2;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRUserDefaultInfo extends IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "countryCode")
    private String mCountryCode;
    @b(a = "customerCreationDate")
    private String mCustomerCreationDate;
    @b(a = "customerStatus")
    private String mCustomerStatus;
    @b(a = "displayName")
    private String mDisplayName;
    @b(a = "dob")
    private String mDob;
    @b(a = "email")
    private String mEmail;
    @b(a = "emailNotificationEnabled")
    private boolean mEmailNotificationEnabled;
    @b(a = "emailVerificationStatus")
    private boolean mEmailVerificationStatus;
    @b(a = "firstName")
    private String mFirstName;
    @b(a = "gender")
    private String mGender;
    @b(a = "isKyc")
    private boolean mIsKyc;
    @b(a = "lastName")
    private String mLastName;
    @b(a = "phone")
    private String mPhone;
    @b(a = "phoneVerificationStatus")
    private boolean mPhoneVerificationStatus;
    @b(a = "userPicture")
    private String mUserPicture;

    public String getEmail() {
        return this.mEmail;
    }

    public void setEmail(String str) {
        this.mEmail = str;
    }

    public String getPhone() {
        return this.mPhone;
    }

    public void setPhone(String str) {
        this.mPhone = str;
    }

    public String getCountryCode() {
        return this.mCountryCode;
    }

    public void setCountryCode(String str) {
        this.mCountryCode = str;
    }

    public String getFirstName() {
        return this.mFirstName;
    }

    public void setFirstName(String str) {
        this.mFirstName = str;
    }

    public String getLastName() {
        return this.mLastName;
    }

    public void setLastName(String str) {
        this.mLastName = str;
    }

    public String getGender() {
        return this.mGender;
    }

    public void setGender(String str) {
        this.mGender = str;
    }

    public String getDob() {
        return this.mDob;
    }

    public void setDob(String str) {
        this.mDob = str;
    }

    public boolean isKyc() {
        return this.mIsKyc;
    }

    public void setIsKyc(boolean z) {
        this.mIsKyc = z;
    }

    public boolean isEmailVerificationStatus() {
        return this.mEmailVerificationStatus;
    }

    public void setEmailVerificationStatus(boolean z) {
        this.mEmailVerificationStatus = z;
    }

    public boolean isPhoneVerificationStatus() {
        return this.mPhoneVerificationStatus;
    }

    public void setPhoneVerificationStatus(boolean z) {
        this.mPhoneVerificationStatus = z;
    }

    public String getCustomerStatus() {
        return this.mCustomerStatus;
    }

    public void setCustomerStatus(String str) {
        this.mCustomerStatus = str;
    }

    public String getCustomerCreationDate() {
        return this.mCustomerCreationDate;
    }

    public void setCustomerCreationDate(String str) {
        this.mCustomerCreationDate = str;
    }

    public boolean isEmailNotificationEnabled() {
        return this.mEmailNotificationEnabled;
    }

    public void setEmailNotificationEnabled(boolean z) {
        this.mEmailNotificationEnabled = z;
    }

    public String getUserPicture() {
        return this.mUserPicture;
    }

    public void setUserPicture(String str) {
        this.mUserPicture = str;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public void setDisplayName(String str) {
        this.mDisplayName = str;
    }
}
