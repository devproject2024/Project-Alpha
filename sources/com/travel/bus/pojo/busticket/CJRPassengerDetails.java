package com.travel.bus.pojo.busticket;

import com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRBusTravellerExtraDetailsFieldModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPassengerDetails implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private String idCardType;
    private String idCardValue;
    private boolean isCheckedOnBlock = false;
    private boolean isInsuranceEnabled = false;
    private boolean isLadiesSeat = false;
    private String mAddress = null;
    private int mConcessionDiscount;
    private String mConcessionId;
    private String mConcessionType = null;
    private String mEmail = null;
    private String mGender = null;
    private String mIdName = null;
    private CJRInsuranceDetail mInsuranceDetailObj;
    private boolean mIsFirstPassenger = false;
    private boolean mIsPrimary = false;
    private String mPassengerName = null;
    private int mPassengerage;
    private String mSeatNumber = null;
    private String mTitle = null;
    private CJRBusTravellerExtraDetailsFieldModel travellerExtraDetailsFieldModel;

    public String getIdCardType() {
        return this.idCardType;
    }

    public void setIdCardType(String str) {
        this.idCardType = str;
    }

    public String getIdCardValue() {
        return this.idCardValue;
    }

    public void setIdCardValue(String str) {
        this.idCardValue = str;
    }

    public String getmConcessionId() {
        return this.mConcessionId;
    }

    public void setmConcessionId(String str) {
        this.mConcessionId = str;
    }

    public String getmConcessionType() {
        return this.mConcessionType;
    }

    public void setmConcessionType(String str) {
        this.mConcessionType = str;
    }

    public String getPassengerName() {
        return this.mPassengerName;
    }

    public void setPassengerName(String str) {
        this.mPassengerName = str;
    }

    public int getPassengerage() {
        return this.mPassengerage;
    }

    public void setPassengerage(int i2) {
        this.mPassengerage = i2;
    }

    public String getSeatNumber() {
        return this.mSeatNumber;
    }

    public void setSeatNumber(String str) {
        this.mSeatNumber = str;
    }

    public String getGender() {
        return this.mGender;
    }

    public void setGender(String str) {
        this.mGender = str;
    }

    public String getmTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public boolean getIsPrimary() {
        return this.mIsPrimary;
    }

    public void setIsPrimary(boolean z) {
        this.mIsPrimary = z;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public void setEmail(String str) {
        this.mEmail = str;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public String getIdName() {
        return this.mIdName;
    }

    public void setIsFirstPassenger(boolean z) {
        this.mIsFirstPassenger = z;
    }

    public boolean isLadiesSeat() {
        return this.isLadiesSeat;
    }

    public void setIsLadiesSeat(boolean z) {
        this.isLadiesSeat = z;
    }

    public boolean isInsuranceEnabled() {
        return this.isInsuranceEnabled;
    }

    public void setInsuranceEnabled(boolean z) {
        this.isInsuranceEnabled = z;
    }

    public CJRInsuranceDetail getInsuranceDetailObj() {
        return this.mInsuranceDetailObj;
    }

    public void setInsuranceDetailObj(CJRInsuranceDetail cJRInsuranceDetail) {
        this.mInsuranceDetailObj = cJRInsuranceDetail;
    }

    public boolean isCheckedOnBlock() {
        return this.isCheckedOnBlock;
    }

    public void setCheckedOnBlock(boolean z) {
        this.isCheckedOnBlock = z;
    }

    public CJRBusTravellerExtraDetailsFieldModel getTravellerExtraDetailsFieldModel() {
        return this.travellerExtraDetailsFieldModel;
    }

    public void setTravellerExtraDetailsFieldModel(CJRBusTravellerExtraDetailsFieldModel cJRBusTravellerExtraDetailsFieldModel) {
        this.travellerExtraDetailsFieldModel = cJRBusTravellerExtraDetailsFieldModel;
    }
}
