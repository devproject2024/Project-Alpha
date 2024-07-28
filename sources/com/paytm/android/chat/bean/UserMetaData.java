package com.paytm.android.chat.bean;

public final class UserMetaData {
    private String addressString;
    private String locationString;
    private String logoUrl;
    private String name;
    private String paytmChannelId;
    private RegistrationStatus registrationStatus = RegistrationStatus.COMPLETE;
    private UserType userType = UserType.CUSTOMER;

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final UserType getUserType() {
        return this.userType;
    }

    public final void setUserType(UserType userType2) {
        this.userType = userType2;
    }

    public final String getLocationString() {
        return this.locationString;
    }

    public final void setLocationString(String str) {
        this.locationString = str;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public final String getAddressString() {
        return this.addressString;
    }

    public final void setAddressString(String str) {
        this.addressString = str;
    }

    public final String getPaytmChannelId() {
        return this.paytmChannelId;
    }

    public final void setPaytmChannelId(String str) {
        this.paytmChannelId = str;
    }

    public final RegistrationStatus getRegistrationStatus() {
        return this.registrationStatus;
    }

    public final void setRegistrationStatus(RegistrationStatus registrationStatus2) {
        this.registrationStatus = registrationStatus2;
    }
}
