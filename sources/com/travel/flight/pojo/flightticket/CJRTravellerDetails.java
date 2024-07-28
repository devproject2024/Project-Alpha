package com.travel.flight.pojo.flightticket;

import com.travel.flight.pojo.flightticket.paxinfo.CJRDynamicPaxInfo;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytmflight.common.entity.travel.CJRDynamicValidation;

public class CJRTravellerDetails implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private CJRDynamicPaxInfo CJRPaxInfo;
    private String PassportCountryCode;
    private String birthCountryCode;
    private String mEmail = null;
    private String mFlyerFlightName;
    private String mLocalisedTravellerTitle = null;
    private String mMobileNumber = null;
    private String mTooltip;
    private int mTravellerCount = 0;
    private String mTravellerDOB = null;
    private String mTravellerFirstName = null;
    private String mTravellerLastName = null;
    private String mTravellerTitle = null;
    private String mTravellerType = null;
    private String mTravellerType_en = null;
    private String mflyerName;
    private String mflyerNameReturn;
    private String mflyerNumber;
    private String mflyerNumberReturn;
    private String nationalityCountryCode;
    private String passengerType = "";
    private boolean selected_from_drop_down;
    private List<CJRDynamicValidation> validations = new ArrayList();

    public void setMflyerNameReturn(String str) {
        this.mflyerNameReturn = str;
    }

    public String getMflyerNameReturn() {
        return this.mflyerNameReturn;
    }

    public void setMflyerNumberReturn(String str) {
        this.mflyerNumberReturn = str;
    }

    public String getMflyerNumberReturn() {
        return this.mflyerNumberReturn;
    }

    public String getFlyerFlightName() {
        return this.mFlyerFlightName;
    }

    public void setFlyerFlightName(String str) {
        this.mFlyerFlightName = str;
    }

    public String getMflyerName() {
        return this.mflyerName;
    }

    public void setMflyerName(String str) {
        this.mflyerName = str;
    }

    public String getTravellerTitle() {
        return this.mTravellerTitle;
    }

    public void setTravellerTitle(String str) {
        this.mTravellerTitle = str;
    }

    public String getTravellerFirstName() {
        return this.mTravellerFirstName;
    }

    public void setTravellerFirstName(String str) {
        this.mTravellerFirstName = str;
    }

    public String getTravellerLastName() {
        return this.mTravellerLastName;
    }

    public void setTravellerLastName(String str) {
        this.mTravellerLastName = str;
    }

    public String getTravellerDOB() {
        return this.mTravellerDOB;
    }

    public void setTravellerDOB(String str) {
        this.mTravellerDOB = str;
    }

    public String getTravellerType() {
        return this.mTravellerType;
    }

    public void setTravellerType(String str) {
        this.mTravellerType = str;
    }

    public int getTravellerCount() {
        return this.mTravellerCount;
    }

    public void setTravellerCount(int i2) {
        this.mTravellerCount = i2;
    }

    public String getMobileNumber() {
        return this.mMobileNumber;
    }

    public void setMobileNumber(String str) {
        this.mMobileNumber = str;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public void setEmail(String str) {
        this.mEmail = str;
    }

    public String getmTravellerType_en() {
        return this.mTravellerType_en;
    }

    public void setmTravellerType_en(String str) {
        this.mTravellerType_en = str;
    }

    public String getLocalisedTravellerTitle() {
        return this.mLocalisedTravellerTitle;
    }

    public void setLocalisedTravellerTitle(String str) {
        this.mLocalisedTravellerTitle = str;
    }

    public String getPassengerType() {
        return this.passengerType;
    }

    public void setPassengerType(String str) {
        this.passengerType = str;
    }

    public CJRDynamicPaxInfo getCJRPaxInfo() {
        return this.CJRPaxInfo;
    }

    public void setCJRPaxInfo(CJRDynamicPaxInfo cJRDynamicPaxInfo) {
        this.CJRPaxInfo = cJRDynamicPaxInfo;
    }

    public List<CJRDynamicValidation> getValidations() {
        return this.validations;
    }

    public void setValidations(List<CJRDynamicValidation> list) {
        this.validations = list;
    }

    public String getmTooltip() {
        return this.mTooltip;
    }

    public void setmTooltip(String str) {
        this.mTooltip = str;
    }

    public String getMflyerNumber() {
        return this.mflyerNumber;
    }

    public void setMflyerNumber(String str) {
        this.mflyerNumber = str;
    }

    public boolean isSelected_from_drop_down() {
        return this.selected_from_drop_down;
    }

    public void setSelected_from_drop_down(boolean z) {
        this.selected_from_drop_down = z;
    }

    public String getPassportCountryCode() {
        return this.PassportCountryCode;
    }

    public void setPassportCountryCode(String str) {
        this.PassportCountryCode = str;
    }

    public String getBirthCountryCode() {
        return this.birthCountryCode;
    }

    public void setBirthCountryCode(String str) {
        this.birthCountryCode = str;
    }

    public String getNationalityCountryCode() {
        return this.nationalityCountryCode;
    }

    public void setNationalityCountryCode(String str) {
        this.nationalityCountryCode = str;
    }
}
