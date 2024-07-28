package com.travel.train.model;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainSearchInput implements Cloneable, IJRDataModel {
    private static final long serialVersionUID = 1;
    private String mDate = null;
    private String mDestAirportName = null;
    private String mDestCityCode = null;
    private String mDestCityName = null;
    private String mDestKeyword = null;
    private int mDestRankPosition = -1;
    private String mGSTCity = null;
    private String mGSTFlat = null;
    private String mGSTINNumber = null;
    private String mGSTName = null;
    private String mGSTPinCode = null;
    private String mGSTState = null;
    private String mGSTStreet = null;
    private boolean mIsAllowed;
    private int mOrderBy = -1;
    private String mSortBy = null;
    private String mSourceAirPortName = null;
    private String mSourceCityCode = null;
    private String mSourceCityName = null;
    private String mSourceKeyword = null;
    private int mSourceRankPosition = -1;
    private String mWarningMessage;

    public String getWarningMessage() {
        return this.mWarningMessage;
    }

    public boolean isIsAllowed() {
        return this.mIsAllowed;
    }

    public void setIsAllowed(boolean z) {
        this.mIsAllowed = z;
    }

    public String getmSourceCityName() {
        return this.mSourceCityName;
    }

    public void setmSourceCityName(String str) {
        this.mSourceCityName = str;
    }

    public String getmDestCityName() {
        return this.mDestCityName;
    }

    public void setmDestCityName(String str) {
        this.mDestCityName = str;
    }

    public String getmDate() {
        return this.mDate;
    }

    public void setmDate(String str) {
        this.mDate = str;
    }

    public String getmSourceCityCode() {
        return this.mSourceCityCode;
    }

    public void setmSourceCityCode(String str) {
        this.mSourceCityCode = str;
    }

    public String getmDestCityCode() {
        return this.mDestCityCode;
    }

    public void setmDestCityCode(String str) {
        this.mDestCityCode = str;
    }

    public CJRTrainSearchInput() {
    }

    public CJRTrainSearchInput(CJRTrainSearchInput cJRTrainSearchInput) {
        if (cJRTrainSearchInput != null) {
            this.mDate = cJRTrainSearchInput.getmDate();
            this.mSortBy = cJRTrainSearchInput.getmSortBy();
            this.mOrderBy = cJRTrainSearchInput.getmOrderBy();
            this.mDestCityCode = cJRTrainSearchInput.getmDestCityCode();
            this.mSourceCityCode = cJRTrainSearchInput.getmSourceCityCode();
            this.mSourceCityName = cJRTrainSearchInput.getmSourceCityName();
            this.mDestCityName = cJRTrainSearchInput.getmDestCityName();
            this.mSourceAirPortName = cJRTrainSearchInput.getSourceAirPortName();
            this.mDestAirportName = cJRTrainSearchInput.getDestAirportName();
        }
    }

    public String getmSortBy() {
        return this.mSortBy;
    }

    public void setmSortBy(String str) {
        this.mSortBy = str;
    }

    public int getmOrderBy() {
        return this.mOrderBy;
    }

    public void setmOrderBy(int i2) {
        this.mOrderBy = i2;
    }

    public String getmSourceKeyword() {
        return this.mSourceKeyword;
    }

    public void setmSourceKeyword(String str) {
        this.mSourceKeyword = str;
    }

    public int getmSourceRankPosition() {
        return this.mSourceRankPosition;
    }

    public void setmSourceRankPosition(int i2) {
        this.mSourceRankPosition = i2;
    }

    public String getmDestKeyword() {
        return this.mDestKeyword;
    }

    public void setmDestKeyword(String str) {
        this.mDestKeyword = str;
    }

    public int getmDestRankPosition() {
        return this.mDestRankPosition;
    }

    public void setmDestRankPosition(int i2) {
        this.mDestRankPosition = i2;
    }

    public String getmGSTINNumber() {
        return this.mGSTINNumber;
    }

    public void setmGSTINNumber(String str) {
        this.mGSTINNumber = str;
    }

    public String getmGSTName() {
        return this.mGSTName;
    }

    public void setmGSTName(String str) {
        this.mGSTName = str;
    }

    public String getmGSTFlat() {
        return this.mGSTFlat;
    }

    public void setmGSTFlat(String str) {
        this.mGSTFlat = str;
    }

    public String getmGSTStreet() {
        return this.mGSTStreet;
    }

    public void setmGSTStreet(String str) {
        this.mGSTStreet = str;
    }

    public String getmGSTPinCode() {
        return this.mGSTPinCode;
    }

    public void setmGSTPinCode(String str) {
        this.mGSTPinCode = str;
    }

    public String getmGSTState() {
        return this.mGSTState;
    }

    public void setmGSTState(String str) {
        this.mGSTState = str;
    }

    public String getmGSTCity() {
        return this.mGSTCity;
    }

    public void setmGSTCity(String str) {
        this.mGSTCity = str;
    }

    public String getSourceAirPortName() {
        return this.mSourceAirPortName;
    }

    public void setSourceAirPortName(String str) {
        this.mSourceAirPortName = str;
    }

    public String getDestAirportName() {
        return this.mDestAirportName;
    }

    public void setDestAirportName(String str) {
        this.mDestAirportName = str;
    }

    public CJRTrainSearchInput clone() throws CloneNotSupportedException {
        return (CJRTrainSearchInput) super.clone();
    }
}
