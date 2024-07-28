package com.paytm.business.merchantprofile.event;

import com.paytm.business.merchantprofile.model.GenerateOtpResponseModel;

public class OtpEnteredEvent {
    public String otp;
    public GenerateOtpResponseModel otpModel;
    public String otpType;
    public String otpValue;

    public OtpEnteredEvent(String str) {
        this.otp = str;
    }

    public String getOtp() {
        return this.otp;
    }

    public void setOtp(String str) {
        this.otp = str;
    }

    public String getOtpType() {
        return this.otpType;
    }

    public void setOtpType(String str) {
        this.otpType = str;
    }

    public String getOtpValue() {
        return this.otpValue;
    }

    public void setOtpValue(String str) {
        this.otpValue = str;
    }

    public GenerateOtpResponseModel getOtpModel() {
        return this.otpModel;
    }

    public void setOtpModel(GenerateOtpResponseModel generateOtpResponseModel) {
        this.otpModel = generateOtpResponseModel;
    }
}
