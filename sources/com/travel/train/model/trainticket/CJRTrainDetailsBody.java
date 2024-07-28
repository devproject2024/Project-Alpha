package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainDetailsBody extends IJRPaytmDataModel implements IJRDataModel {
    private String boardingDate;
    private String boardingTime;
    @b(a = "covidInstructon")
    private ArrayList<String> covidInstructon;
    @b(a = "gst_enabled")
    private boolean gst_enabled;
    private String mAddressLine;
    private boolean mAutoUpgrade;
    @b(a = "berths")
    public ArrayList<CJRTravellerBerth> mBerth;
    @b(a = "boarding_details")
    private ArrayList<CJRBoardingStationDetails> mBoardingDetail;
    @b(a = "boarding_stations")
    public ArrayList<String> mBoardingStation;
    private String mCity;
    private String mCoachNumber;
    private String mEmailAddress;
    private String mFormattedBoardingStation;
    private boolean mIsAddressCapture;
    @b(a = "message")
    private CJRTrainTravellerMessage mMessage;
    private ArrayList<CJRPassengerInfo> mPassengerInfo;
    private String mPincode;
    private String mPostOffice;
    private String mReservationChoice;
    private int mReservationCode;
    private String mSelectedBoardingStation;
    private String mState;
    @b(a = "availability")
    private ArrayList<CJRTrainAvailability> mTrainAvailability;
    @b(a = "config")
    private CJRTrainConfig mTrainConfig;
    @b(a = "fare")
    private CJRTrainFare mTrainFare;
    @b(a = "trainName")
    private String mTrainName;
    @b(a = "preferences")
    private CJRTrainPreferences mTrainPreferences;
    private String mUserMobileNumber;
    private int miSelectedPosition;
    @b(a = "promotional_messages")
    private CJRTrainPromoMessageModel promoMessageModel;

    public CJRTrainTravellerMessage getMessage() {
        return this.mMessage;
    }

    public void setMessage(CJRTrainTravellerMessage cJRTrainTravellerMessage) {
        this.mMessage = cJRTrainTravellerMessage;
    }

    public CJRTrainPreferences getTrainPreferences() {
        return this.mTrainPreferences;
    }

    public void setTrainPreferences(CJRTrainPreferences cJRTrainPreferences) {
        this.mTrainPreferences = cJRTrainPreferences;
    }

    public CJRTrainFare getTrainFare() {
        return this.mTrainFare;
    }

    public CJRTrainConfig getTrainConfig() {
        return this.mTrainConfig;
    }

    public void setmTrainConfig(CJRTrainConfig cJRTrainConfig) {
        this.mTrainConfig = cJRTrainConfig;
    }

    public String getmTrainName() {
        return this.mTrainName;
    }

    public void setmTrainName(String str) {
        this.mTrainName = str;
    }

    public ArrayList<String> getBoardingStation() {
        return this.mBoardingStation;
    }

    public void setmBoardingStation(ArrayList<String> arrayList) {
        this.mBoardingStation = arrayList;
    }

    public ArrayList<CJRTravellerBerth> getBerth() {
        return this.mBerth;
    }

    public void setmBerth(ArrayList<CJRTravellerBerth> arrayList) {
        this.mBerth = arrayList;
    }

    public ArrayList<CJRBoardingStationDetails> getBoardingDetail() {
        return this.mBoardingDetail;
    }

    public void setBoardingDetail(ArrayList<CJRBoardingStationDetails> arrayList) {
        this.mBoardingDetail = arrayList;
    }

    public ArrayList<CJRTrainAvailability> getmTrainAvailability() {
        return this.mTrainAvailability;
    }

    public void setmTrainAvailability(ArrayList<CJRTrainAvailability> arrayList) {
        this.mTrainAvailability = arrayList;
    }

    public ArrayList<CJRPassengerInfo> getPassengerInfo() {
        return this.mPassengerInfo;
    }

    public void setPassengerInfo(ArrayList<CJRPassengerInfo> arrayList) {
        this.mPassengerInfo = arrayList;
    }

    public String getUserMobileNumber() {
        return this.mUserMobileNumber;
    }

    public void setUserMobileNumber(String str) {
        this.mUserMobileNumber = str;
    }

    public String getEmailAddress() {
        return this.mEmailAddress;
    }

    public void setEmailAddress(String str) {
        this.mEmailAddress = str;
    }

    public String getSelectedBoardingStation() {
        return this.mSelectedBoardingStation;
    }

    public void setSelectedBoardingStation(String str) {
        this.mSelectedBoardingStation = str;
    }

    public String getFormattedBoardingStation() {
        return this.mFormattedBoardingStation;
    }

    public void setFormattedBoardingStation(String str) {
        this.mFormattedBoardingStation = str;
    }

    public String getmAddressLine() {
        return this.mAddressLine;
    }

    public void setmAddressLine(String str) {
        this.mAddressLine = str;
    }

    public String getmPincode() {
        return this.mPincode;
    }

    public void setmPincode(String str) {
        this.mPincode = str;
    }

    public String getmState() {
        return this.mState;
    }

    public void setmState(String str) {
        this.mState = str;
    }

    public String getmCity() {
        return this.mCity;
    }

    public void setmCity(String str) {
        this.mCity = str;
    }

    public String getmPostOffice() {
        return this.mPostOffice;
    }

    public void setmPostOffice(String str) {
        this.mPostOffice = str;
    }

    public boolean ismIsAddressCapture() {
        return this.mIsAddressCapture;
    }

    public void setmIsAddressCapture(boolean z) {
        this.mIsAddressCapture = z;
    }

    public int getMiSelectedPosition() {
        return this.miSelectedPosition;
    }

    public void setMiSelectedPosition(int i2) {
        this.miSelectedPosition = i2;
    }

    public int getReservationCode() {
        return this.mReservationCode;
    }

    public void setReservationCode(int i2) {
        this.mReservationCode = i2;
    }

    public String getCoachNumber() {
        return this.mCoachNumber;
    }

    public void setCoachNumber(String str) {
        this.mCoachNumber = str;
    }

    public boolean getAutoUpgrade() {
        return this.mAutoUpgrade;
    }

    public void setAutoUpgrade(boolean z) {
        this.mAutoUpgrade = z;
    }

    public String getBoardingDate() {
        return this.boardingDate;
    }

    public void setBoardingDate(String str) {
        this.boardingDate = str;
    }

    public String getBoardingTime() {
        return this.boardingTime;
    }

    public void setBoardingTime(String str) {
        this.boardingTime = str;
    }

    public boolean isGst_enabled() {
        return this.gst_enabled;
    }

    public void setGst_enabled(boolean z) {
        this.gst_enabled = z;
    }

    public String getmReservationChoice() {
        return this.mReservationChoice;
    }

    public void setmReservationChoice(String str) {
        this.mReservationChoice = str;
    }

    public CJRTrainPromoMessageModel getPromoMessageModel() {
        return this.promoMessageModel;
    }

    public ArrayList<String> getCovidInstructon() {
        return this.covidInstructon;
    }
}
