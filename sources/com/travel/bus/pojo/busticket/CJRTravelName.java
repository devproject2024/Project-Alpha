package com.travel.bus.pojo.busticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTravelName implements Comparable<CJRTravelName>, IJRDataModel {
    private static final long serialVersionUID = 1;
    private boolean isFilterSelected;
    private String mComputedTravelsName;
    public String mTravelsName;

    public String getTravelsName() {
        return this.mTravelsName;
    }

    public String getComputedTravelsName() {
        return this.mComputedTravelsName;
    }

    public void setTravelsName(String str) {
        this.mTravelsName = str;
    }

    public void setComputedTravelsName(String str) {
        this.mComputedTravelsName = str;
    }

    public boolean isFilterSelected() {
        return this.isFilterSelected;
    }

    public void setFilterSelected(boolean z) {
        this.isFilterSelected = z;
    }

    public boolean equals(Object obj) {
        try {
            return this.mComputedTravelsName.trim().equalsIgnoreCase(((CJRTravelName) obj).mComputedTravelsName.trim());
        } catch (Exception unused) {
            return false;
        }
    }

    public int compareTo(CJRTravelName cJRTravelName) {
        try {
            return this.mComputedTravelsName.compareToIgnoreCase(cJRTravelName.getComputedTravelsName());
        } catch (Exception unused) {
            return -1;
        }
    }
}
