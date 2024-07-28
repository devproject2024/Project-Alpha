package net.one97.paytm.common.entity.amPark;

public class AmParkTravellerDetails {
    private String mCity;
    private String mEmailId;
    private String mFirstName;
    private String mLastName;
    private int mMobileNumber;
    private int mPinCode;

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

    public int getMobileNumber() {
        return this.mMobileNumber;
    }

    public void setMobileNumber(int i2) {
        this.mMobileNumber = i2;
    }

    public String getEmailId() {
        return this.mEmailId;
    }

    public void setEmailId(String str) {
        this.mEmailId = str;
    }

    public int getPinCode() {
        return this.mPinCode;
    }

    public void setmPinCode(int i2) {
        this.mPinCode = i2;
    }

    public String getCity() {
        return this.mCity;
    }

    public void setmCity(String str) {
        this.mCity = str;
    }
}
