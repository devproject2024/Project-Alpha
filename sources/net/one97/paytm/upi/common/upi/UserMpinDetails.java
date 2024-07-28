package net.one97.paytm.upi.common.upi;

import net.one97.paytm.upi.common.UpiBaseDataModel;

public class UserMpinDetails implements UpiBaseDataModel {
    private String atmPin;
    private String cardDigits;
    private String expiryDate;
    private String mpin;
    private String newMpin;
    private String oldMpin;
    private String otp;

    public String getOldMpin() {
        return this.oldMpin;
    }

    public void setOldMpin(String str) {
        this.oldMpin = str;
    }

    public String getNewMpin() {
        return this.newMpin;
    }

    public void setNewMpin(String str) {
        this.newMpin = str;
    }

    public String getCardDigits() {
        return this.cardDigits;
    }

    public void setCardDigits(String str) {
        this.cardDigits = str;
    }

    public String getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(String str, String str2) {
        this.expiryDate = str + str2;
    }

    public void setExpiryDate(String str) {
        this.expiryDate = str;
    }

    public String getAtmPin() {
        return this.atmPin;
    }

    public void setAtmPin(String str) {
        this.atmPin = str;
    }

    public String getMpin() {
        return this.mpin;
    }

    public void setMpin(String str) {
        this.mpin = str;
    }

    public String getOtp() {
        return this.otp;
    }

    public void setOtp(String str) {
        this.otp = str;
    }
}
