package com.travel.train.model.trainticket;

import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainFilterModel implements IJRDataModel {
    HashMap<String, String> mSelectedArrivaList = new HashMap<>();
    HashMap<String, String> mSelectedDestinationList = new HashMap<>();
    HashMap<String, String> mSelectedFareClassList = new HashMap<>();
    HashMap<String, String> mSelectedSourceList = new HashMap<>();
    HashMap<String, String> mSelecteddepartureList = new HashMap<>();

    public HashMap<String, String> getmSelectedSourceList() {
        return this.mSelectedSourceList;
    }

    public void setmSelectedSourceList(HashMap<String, String> hashMap) {
        this.mSelectedSourceList = hashMap;
    }

    public HashMap<String, String> getmSelectedDestinationList() {
        return this.mSelectedDestinationList;
    }

    public void setmSelectedDestinationList(HashMap<String, String> hashMap) {
        this.mSelectedDestinationList = hashMap;
    }

    public HashMap<String, String> getmSelectedFareCalssesList() {
        return this.mSelectedFareClassList;
    }

    public void setmSelectedFareCalssesList(HashMap<String, String> hashMap) {
        this.mSelectedFareClassList = hashMap;
    }

    public HashMap<String, String> getmSelecteddepartureList() {
        return this.mSelecteddepartureList;
    }

    public void setmSelecteddepartureList(HashMap<String, String> hashMap) {
        this.mSelecteddepartureList = hashMap;
    }

    public HashMap<String, String> getmSelectedArrivaList() {
        return this.mSelectedArrivaList;
    }

    public void setmSelectedArrivaList(HashMap<String, String> hashMap) {
        this.mSelectedArrivaList = hashMap;
    }

    public void clearFilter() {
        this.mSelectedSourceList.clear();
        this.mSelectedDestinationList.clear();
        this.mSelectedFareClassList.clear();
        this.mSelecteddepartureList.clear();
        this.mSelectedArrivaList.clear();
    }

    public String toString() {
        return "CJRTrainFilterModel{mSelectedSourceList=" + this.mSelectedSourceList + ", mSelectedDestinationList=" + this.mSelectedDestinationList + ", mSelectedFareClassList=" + this.mSelectedFareClassList + ", mSelecteddepartureList=" + this.mSelecteddepartureList + ", mSelectedArrivaList=" + this.mSelectedArrivaList + '}';
    }
}
