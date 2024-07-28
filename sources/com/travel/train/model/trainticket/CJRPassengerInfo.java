package com.travel.train.model.trainticket;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPassengerInfo extends IJRPaytmDataModel implements IJRDataModel {
    private String mAge;
    private boolean mBedRollChoice;
    private String mBerthPreference;
    private String mCategory;
    private String mCountryCode;
    private String mCountryName;
    private String mFullName;
    private int mId;
    private String mIdNumber;
    private String mIdentity;
    private boolean mIsBerthFlag;
    private boolean mIsSeniorCityZen;
    private String mMealPreference;
    private String mPassportNumber;
    private String mTIttle;

    public String getPassportNumber() {
        return this.mPassportNumber;
    }

    public void setPassportNumber(String str) {
        this.mPassportNumber = str;
    }

    public String getCountryCode() {
        return this.mCountryCode;
    }

    public void setCountryCode(String str) {
        this.mCountryCode = str;
    }

    public boolean isBedRollChoice() {
        return this.mBedRollChoice;
    }

    public void setBedRollChoice(boolean z) {
        this.mBedRollChoice = z;
    }

    public boolean isIsBerthFlag() {
        return this.mIsBerthFlag;
    }

    public void setIsBerthFlag(boolean z) {
        this.mIsBerthFlag = z;
    }

    public boolean getIsSeniorCityZen() {
        return this.mIsSeniorCityZen;
    }

    public void setIsSeniorCityZen(boolean z) {
        this.mIsSeniorCityZen = z;
    }

    public String getTIttle() {
        return this.mTIttle;
    }

    public void setTIttle(String str) {
        this.mTIttle = str;
    }

    public String getFullName() {
        return this.mFullName;
    }

    public void setFullName(String str) {
        this.mFullName = str;
    }

    public String getAge() {
        return this.mAge;
    }

    public void setAge(String str) {
        this.mAge = str;
    }

    public String getBerthPreference() {
        return this.mBerthPreference;
    }

    public void setBerthPreference(String str) {
        this.mBerthPreference = str;
    }

    public String getMealPreference() {
        return this.mMealPreference;
    }

    public void setMealPreference(String str) {
        this.mMealPreference = str;
    }

    public String getIdentity() {
        return this.mIdentity;
    }

    public void setIdentity(String str) {
        this.mIdentity = str;
    }

    public String getIdNumber() {
        return this.mIdNumber;
    }

    public void setIdNumber(String str) {
        this.mIdNumber = str;
    }

    public String getmCategory() {
        return this.mCategory;
    }

    public void setmCategory(String str) {
        this.mCategory = str;
    }

    public String getmCountryName() {
        return this.mCountryName;
    }

    public void setmCountryName(String str) {
        this.mCountryName = str;
    }
}
