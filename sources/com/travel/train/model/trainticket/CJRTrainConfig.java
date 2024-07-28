package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainConfig extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "captureAddress")
    private String captureAddress;
    @b(a = "bedRollFlagEnabled")
    private boolean mBedRollFlagEnabled;
    @b(a = "childBerthMandatory")
    private boolean mChildBerthMandatory;
    @b(a = "foodChoiceEnabled")
    private boolean mFoodChoiceEnables;
    @b(a = "foodDetails")
    private ArrayList<String> mFoodDetailList;
    @b(a = "idRequired")
    private boolean mIdRequired;
    @b(a = "maxChildAge")
    private int mMaxChildAge;
    @b(a = "maxInfants")
    private int mMaxInfant;
    @b(a = "maxNameLength")
    private int mMaxNameLength;
    @b(a = "maxPassengerAge")
    private int mMaxPassengerAge;
    @b(a = "maxPassengers")
    private int mMaxPassengers;
    @b(a = "minNameLength")
    private int mMinNameLength;
    @b(a = "minPassengerAge")
    private int mMinPassengerAge;
    @b(a = "seniorCitizenApplicable")
    private boolean mSeniorCitizenApplicable;
    @b(a = "srctznAge")
    private int mSeniorMenAge;
    @b(a = "srctnwAge")
    private int mSeniorWomenAge;
    @b(a = "validIdCardTypes")
    private ArrayList<String> mValidIdCardTypes;
    @b(a = "travelInsuranceFareMsg")
    private String mtravelInsuranceFareMsg;

    public String getMtravelInsuranceFareMsg() {
        return this.mtravelInsuranceFareMsg;
    }

    public boolean isChildBerthMandatory() {
        return this.mChildBerthMandatory;
    }

    public void setChildBerthMandatory(boolean z) {
        this.mChildBerthMandatory = z;
    }

    public boolean isSeniorCitizenApplicable() {
        return this.mSeniorCitizenApplicable;
    }

    public int getSeniorMenAge() {
        return this.mSeniorMenAge;
    }

    public int getSeniorWomenAge() {
        return this.mSeniorWomenAge;
    }

    public ArrayList<String> getValidIdCardTypes() {
        return this.mValidIdCardTypes;
    }

    public ArrayList<String> getFoodDetailList() {
        return this.mFoodDetailList;
    }

    public int getMinPassengerAge() {
        return this.mMinPassengerAge;
    }

    public int getMinNameLength() {
        return this.mMinNameLength;
    }

    public int getMaxPassengers() {
        return this.mMaxPassengers;
    }

    public int getMaxPassengerAge() {
        return this.mMaxPassengerAge;
    }

    public int getMaxNameLength() {
        return this.mMaxNameLength;
    }

    public int getMaxInfant() {
        return this.mMaxInfant;
    }

    public int getMaxChildAge() {
        return this.mMaxChildAge;
    }

    public boolean ismFoodChoiceEnables() {
        return this.mFoodChoiceEnables;
    }

    public void setmFoodChoiceEnables(boolean z) {
        this.mFoodChoiceEnables = z;
    }

    public boolean ismIdRequired() {
        return this.mIdRequired;
    }

    public void setmIdRequired(boolean z) {
        this.mIdRequired = z;
    }

    public boolean ismBedRollFlagEnabled() {
        return this.mBedRollFlagEnabled;
    }

    public void setmBedRollFlagEnabled(boolean z) {
        this.mBedRollFlagEnabled = z;
    }

    public String getCaptureAddress() {
        return this.captureAddress;
    }
}
