package com.paytm.android.chat.bean.jsonbean;

import com.paytm.android.chat.data.models.users.payments.UserPaymentDataModel;

public class UsersInfoJsonBean {
    private String bannerImageUrl;
    private boolean canFollow;
    private String customerCreationDate;
    private String customerCreationText;
    private String firstName;
    private String imageUrl;
    private boolean isKyc;
    private KycInfo kycInfo;
    private String lastName;
    private String pfImageUrl;
    private String pfName;
    private boolean pfuser;
    private String phoneNumber;
    private String registerAccount;
    private String type;
    private UserPaymentDataModel userPaymentData;

    public void setUserPaymentDataModel(UserPaymentDataModel userPaymentDataModel) {
        this.userPaymentData = userPaymentDataModel;
    }

    public UserPaymentDataModel getUserPaymentDataModel() {
        return this.userPaymentData;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getBannerImageUrl() {
        return this.bannerImageUrl;
    }

    public void setBannerImageUrl(String str) {
        this.bannerImageUrl = str;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public boolean isCanFollow() {
        return this.canFollow;
    }

    public void setCanFollow(boolean z) {
        this.canFollow = z;
    }

    public String getPfName() {
        return this.pfName;
    }

    public void setPfName(String str) {
        this.pfName = str;
    }

    public String getPfImageUrl() {
        return this.pfImageUrl;
    }

    public void setPfImageUrl(String str) {
        this.pfImageUrl = str;
    }

    public boolean isPfuser() {
        return this.pfuser;
    }

    public void setPfuser(boolean z) {
        this.pfuser = z;
    }

    public String getCustomerCreationDate() {
        return this.customerCreationDate;
    }

    public String getCustomerCreationText() {
        return this.customerCreationText;
    }

    public String getRegisterAccount() {
        return this.registerAccount;
    }

    public void setRegisterAccount(String str) {
        this.registerAccount = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public boolean isKyc() {
        return this.isKyc;
    }

    public void setKyc(boolean z) {
        this.isKyc = z;
    }

    public KycInfo getKycInfo() {
        return this.kycInfo;
    }

    public void setKycInfo(KycInfo kycInfo2) {
        this.kycInfo = kycInfo2;
    }
}
