package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRUserInfo extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    private boolean isFirstMobileNumber = false;
    @b(a = "showVerificationPage")
    private boolean isShowVerificationPage;
    @b(a = "isSkipAllowed")
    private boolean isSkipAllowed;
    @b(a = "isUniqueEmail")
    private boolean isUniqueEmail;
    @b(a = "isUniqueMobile")
    private boolean isUniqueMobile;
    @b(a = "walletType")
    private String isUserPrime;
    @b(a = "isValidEmail")
    private boolean isValidEmail;
    @b(a = "isValidMobile")
    private boolean isValidMobile;
    @b(a = "created_at")
    private String mCreatedAt;
    @b(a = "customerAreacode")
    private String mCustomerAreaCode;
    @b(a = "customerIp")
    private String mCustomerIpCode;
    @b(a = "customerLastLoginDate")
    private String mCustomerLastLoginDate;
    @b(a = "customerSessionid")
    private String mCustomerSessionId;
    @b(a = "customerTermandConditon")
    private String mCustomerTermAndConditon;
    @b(a = "dateOfBirth")
    private String mDOB;
    @b(a = "displayName")
    private String mDisplayName;
    @b(a = "email")
    private String mEmail;
    @b(a = "firstName")
    private String mFirstName;
    @b(a = "gender")
    private String mGender;
    private int mHttpCode;
    @b(a = "id")
    private String mId;
    @b(a = "isConsent")
    private boolean mIsConsent;
    @b(a = "is_verified_email")
    private int mIsVerifiedEmail;
    @b(a = "is_verified_mobile")
    private int mIsVerifiedMobile;
    @b(a = "ivr_flag")
    private int mIvrFlag;
    @b(a = "lastName")
    private String mLastName;
    @b(a = "message")
    private String mMessage;
    @b(a = "mobile")
    private String mMobile;
    @b(a = "plustxt_id")
    private String mPlustxtId;
    @b(a = "responseCode")
    private String mResponseCode;
    @b(a = "sms_flag")
    private String mSmsFlag;
    @b(a = "status")
    private String mStatus;
    @b(a = "type")
    private String mType;
    @b(a = "username")
    private String mUserName;
    @b(a = "userPicture")
    private String mUserPicture;
    @b(a = "userSocialInfoList")
    private ArrayList<CJRUserSocialInfo> mUserSocialInfoList;

    public String getName() {
        return null;
    }

    public String getIsUserPrime() {
        return this.isUserPrime;
    }

    public ArrayList<CJRUserSocialInfo> getUserSocialInfoList() {
        return this.mUserSocialInfoList;
    }

    public boolean isSkipAllowed() {
        return this.isSkipAllowed;
    }

    public boolean isUniqueMobile() {
        return this.isUniqueMobile;
    }

    public boolean isValidMobile() {
        return this.isValidMobile;
    }

    public boolean isUniqueEmail() {
        return this.isUniqueEmail;
    }

    public boolean isValidEmail() {
        return this.isValidEmail;
    }

    public void setSkipAllowed(boolean z) {
        this.isSkipAllowed = z;
    }

    public void setUniqueMobile(boolean z) {
        this.isUniqueMobile = z;
    }

    public void setValidMobile(boolean z) {
        this.isValidMobile = z;
    }

    public void setUniqueEmail(boolean z) {
        this.isUniqueEmail = z;
    }

    public void setValidEmail(boolean z) {
        this.isValidEmail = z;
    }

    public boolean getIsConsent() {
        return this.mIsConsent;
    }

    public String getCustomerIpCode() {
        return this.mCustomerIpCode;
    }

    public String getCustomerAreaCode() {
        return this.mCustomerAreaCode;
    }

    public String getId() {
        return this.mId;
    }

    public String getType() {
        return this.mType;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String getFirstName() {
        return this.mFirstName;
    }

    public String getLastName() {
        return this.mLastName;
    }

    public String getGender() {
        return this.mGender;
    }

    public String getDOB() {
        return this.mDOB;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public String getMobile() {
        return this.mMobile;
    }

    public String getCreatedAt() {
        return this.mCreatedAt;
    }

    public String getCustomerLastLoginDate() {
        return this.mCustomerLastLoginDate;
    }

    public String getCustomerSessionId() {
        return this.mCustomerSessionId;
    }

    public String getCustomerTermAndConditon() {
        return this.mCustomerTermAndConditon;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public int getIsVerifiedEmail() {
        return this.mIsVerifiedEmail;
    }

    public int getIsVerifiedMobile() {
        return this.mIsVerifiedMobile;
    }

    public void setmIsVerifiedMobile(int i2) {
        this.mIsVerifiedMobile = i2;
    }

    public int getIvrFlag() {
        return this.mIvrFlag;
    }

    public String getSmsFlag() {
        return this.mSmsFlag;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setFirstName(String str) {
        this.mFirstName = str;
    }

    public void setLastName(String str) {
        this.mLastName = str;
    }

    public void setGender(String str) {
        this.mGender = str;
    }

    public void setEmail(String str) {
        this.mEmail = str;
    }

    public void setDOB(String str) {
        this.mDOB = str;
    }

    public void setMobile(String str) {
        this.mMobile = str;
    }

    public boolean isShowVerificationPage() {
        return this.isShowVerificationPage;
    }

    public void setHttpCode(int i2) {
        this.mHttpCode = i2;
    }

    public int getHttpCode() {
        return this.mHttpCode;
    }

    public boolean isUserUpdatedMobileNumber() {
        return this.isFirstMobileNumber;
    }

    public void setUserUpdatedMobileNumber(boolean z) {
        this.isFirstMobileNumber = z;
    }

    public String getUserPicture() {
        return this.mUserPicture;
    }

    public void setUserPicture(String str) {
        this.mUserPicture = str;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void setIsUserPrime(String str) {
        this.isUserPrime = str;
    }

    public void setIsVerifiedEmail(int i2) {
        this.mIsVerifiedEmail = i2;
    }

    public void setCreatedAt(String str) {
        this.mCreatedAt = str;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public void setDisplayName(String str) {
        this.mDisplayName = str;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRUserInfo cJRUserInfo = (CJRUserInfo) super.parseResponse(str, fVar);
        cJRUserInfo.setHttpCode(getNetworkResponse().statusCode);
        return cJRUserInfo;
    }
}
