package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainUserFavourite extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "boarding_station")
    private String boardingStation;
    private String classFullName;
    @b(a = "class")
    private String className;
    @b(a = "destination_station")
    private String destinationStation;
    private String fareDetail;
    private String mArrivalDate;
    private String mAvailabilityStatus;
    private String mDepartureDate;
    private String mDepartureDateForQuickBook;
    @b(a = "infant_info")
    private ArrayList<CJRTrainInfantInfo> mInfantInfo;
    private String mStatusTime;
    @b(a = "pax_info")
    private List<CJRTrainQuickBookPassengerInfo> paxInfo;
    @b(a = "quota")
    private String quota;
    @b(a = "source_station")
    private String sourceStation;
    @b(a = "train_name")
    private String trainName;
    @b(a = "train_number")
    private String trainNumber;
    @b(a = "trip_id")
    private String tripId;

    public String getTrainNumber() {
        return this.trainNumber;
    }

    public String getTrainName() {
        return this.trainName;
    }

    public String getClassName() {
        return this.className;
    }

    public String getQuota() {
        return this.quota;
    }

    public List<CJRTrainQuickBookPassengerInfo> getPaxInfo() {
        return this.paxInfo;
    }

    public String getBoardingStation() {
        return this.boardingStation;
    }

    public String getSourceStation() {
        return this.sourceStation;
    }

    public String getDestinationStation() {
        return this.destinationStation;
    }

    public String getTripId() {
        return this.tripId;
    }

    public String getmDepartureDate() {
        return this.mDepartureDate;
    }

    public void setmDepartureDate(String str) {
        this.mDepartureDate = str;
    }

    public String getmArrivalDate() {
        return this.mArrivalDate;
    }

    public void setmArrivalDate(String str) {
        this.mArrivalDate = str;
    }

    public String getmAvailabilityStatus() {
        return this.mAvailabilityStatus;
    }

    public void setmAvailabilityStatus(String str) {
        this.mAvailabilityStatus = str;
    }

    public String getmStatusTime() {
        return this.mStatusTime;
    }

    public void setmStatusTime(String str) {
        this.mStatusTime = str;
    }

    public String getmDepartureDateForQuickBook() {
        return this.mDepartureDateForQuickBook;
    }

    public void setmDepartureDateForQuickBook(String str) {
        this.mDepartureDateForQuickBook = str;
    }

    public ArrayList<CJRTrainInfantInfo> getmInfantInfo() {
        return this.mInfantInfo;
    }

    public String getFareDetail() {
        return this.fareDetail;
    }

    public void setFareDetail(String str) {
        this.fareDetail = str;
    }

    public String getClassFullName() {
        return this.classFullName;
    }

    public void setClassFullName(String str) {
        this.classFullName = str;
    }
}
