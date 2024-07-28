package com.travel.bus.pojo.busticket;

import java.util.ArrayList;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusFilterContainer implements IJRDataModel {
    private static final long serialVersionUID = 1;
    protected ArrayList<CJRLocation> mBoardingLocations = null;
    protected ArrayList<CJRTravelName> mBusOperators = null;
    private CJRBusTicketFilters mBusTicketFilters;
    protected ArrayList<CJRLocation> mDroppingLocations = null;
    private Map<CJRLocation, Integer> mLocationCountMap;
    private ArrayList<String> operatorIdListNameList = null;

    public ArrayList<CJRLocation> getBoardingLocation() {
        if (this.mBoardingLocations == null) {
            this.mBoardingLocations = new ArrayList<>();
        }
        return new ArrayList<>(this.mBoardingLocations);
    }

    public ArrayList<CJRLocation> getDroppingLocations() {
        return new ArrayList<>(this.mDroppingLocations);
    }

    public ArrayList<CJRTravelName> getBusOperators() {
        return new ArrayList<>(this.mBusOperators);
    }

    public CJRBusTicketFilters getmBusTicketFilters() {
        return this.mBusTicketFilters;
    }

    public void setmBusTicketFilters(CJRBusTicketFilters cJRBusTicketFilters) {
        this.mBusTicketFilters = cJRBusTicketFilters;
    }

    public void setBoardingLocation(ArrayList<CJRLocation> arrayList) {
        this.mBoardingLocations = arrayList;
    }

    public void setDroppingLocations(ArrayList<CJRLocation> arrayList) {
        this.mDroppingLocations = arrayList;
    }

    public void setBusOperators(ArrayList<CJRTravelName> arrayList) {
        this.mBusOperators = arrayList;
    }

    public void setmLocationCountMap(Map<CJRLocation, Integer> map) {
        this.mLocationCountMap = map;
    }

    public Map<CJRLocation, Integer> getmLocationCountMap() {
        return this.mLocationCountMap;
    }

    public void setOperatorListName(ArrayList<String> arrayList) {
        this.operatorIdListNameList = arrayList;
    }
}
