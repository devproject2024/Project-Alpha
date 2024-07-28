package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class NomineeModel implements IJRDataModel {
    @b(a = "guardians")
    private ArrayList<NomineeModel> guardians;
    @b(a = "active")
    private String mActive;
    @b(a = "areaName")
    private String mAreaName;
    @b(a = "city")
    private String mCity;
    @b(a = "createDate")
    private long mCreateDate;
    @b(a = "createdBy")
    private String mCreatedBy;
    @b(a = "dob")
    private String mDob;
    @b(a = "docId")
    private String mDocId;
    @b(a = "email")
    private String mEmail;
    @b(a = "houseNo")
    private String mHouseNo;
    @b(a = "latitude")
    private String mLatitude;
    @b(a = "longitude")
    private String mLongitude;
    @b(a = "name")
    private String mName;
    @b(a = "nomineeId")
    private String mNomineeId;
    @b(a = "oauthId")
    private String mOauthId;
    @b(a = "percentage")
    private String mPercentage;
    @b(a = "pinCode")
    private String mPinCode;
    @b(a = "relationship")
    private String mRelationship;
    @b(a = "share")
    private int mShare;
    @b(a = "state")
    private String mState;
    @b(a = "streetName")
    private String mStreetName;
    @b(a = "updateDate")
    private long mUpdateDate;
    @b(a = "updatedBy")
    private String mUpdatedBy;
    @b(a = "userId")
    private String mUserId;

    public String getNomineeId() {
        return this.mNomineeId;
    }

    public String getOauthId() {
        return this.mOauthId;
    }

    public String getName() {
        return this.mName;
    }

    public String getDob() {
        return this.mDob;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public String getActive() {
        return this.mActive;
    }

    public String getRelationship() {
        return this.mRelationship;
    }

    public String getHouseNo() {
        return this.mHouseNo;
    }

    public String getStreetName() {
        return this.mStreetName;
    }

    public String getAreaName() {
        return this.mAreaName;
    }

    public String getPinCode() {
        return this.mPinCode;
    }

    public String getCity() {
        return this.mCity;
    }

    public String getState() {
        return this.mState;
    }

    public String getLatitude() {
        return this.mLatitude;
    }

    public String getLongitude() {
        return this.mLongitude;
    }

    public String getPercentage() {
        return this.mPercentage;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public int getShare() {
        return this.mShare;
    }

    public long getCreateDate() {
        return this.mCreateDate;
    }

    public long getUpdateDate() {
        return this.mUpdateDate;
    }

    public String getCreatedBy() {
        return this.mCreatedBy;
    }

    public String getUpdatedBy() {
        return this.mUpdatedBy;
    }

    public String getDocId() {
        return this.mDocId;
    }

    public ArrayList<NomineeModel> getGuardians() {
        return this.guardians;
    }

    public void setGuardians(ArrayList<NomineeModel> arrayList) {
        this.guardians = arrayList;
    }

    public void setNomineeId(String str) {
        this.mNomineeId = str;
    }

    public void setOauthId(String str) {
        this.mOauthId = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setDob(String str) {
        this.mDob = str;
    }

    public void setEmail(String str) {
        this.mEmail = str;
    }

    public void setActive(String str) {
        this.mActive = str;
    }

    public void setRelationship(String str) {
        this.mRelationship = str;
    }

    public void setHouseNo(String str) {
        this.mHouseNo = str;
    }

    public void setStreetName(String str) {
        this.mStreetName = str;
    }

    public void setAreaName(String str) {
        this.mAreaName = str;
    }

    public void setPinCode(String str) {
        this.mPinCode = str;
    }

    public void setCity(String str) {
        this.mCity = str;
    }

    public void setState(String str) {
        this.mState = str;
    }

    public void setLatitude(String str) {
        this.mLatitude = str;
    }

    public void setLongitude(String str) {
        this.mLongitude = str;
    }

    public void setPercentage(String str) {
        this.mPercentage = str;
    }
}
