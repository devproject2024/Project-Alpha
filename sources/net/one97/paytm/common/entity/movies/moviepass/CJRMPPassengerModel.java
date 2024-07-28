package net.one97.paytm.common.entity.movies.moviepass;

import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMPPassengerModel implements IJRDataModel {
    private String email;
    private String mobileNumber;
    private String name;

    public CJRMPPassengerModel(String str, String str2, String str3) {
        this.name = str;
        this.email = str2;
        this.mobileNumber = str3;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    public final void setMobileNumber(String str) {
        this.mobileNumber = str;
    }
}
