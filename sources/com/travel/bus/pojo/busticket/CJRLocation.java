package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRLocation implements Comparable<CJRLocation>, IJRDataModel {
    private static final long serialVersionUID = 1;
    private boolean filterSelected;
    @b(a = "landmark")
    private String landmark;
    @b(a = "reporting_datetime")
    private String mBoardingDate;
    private String mDistance;
    @b(a = "is_popular")
    private boolean mIsPopular;
    private boolean mIsSelected;
    @b(a = "lat")
    private String mLatitude;
    @b(a = "address")
    private String mLocationAddress;
    @b(a = "name")
    private String mLocationName;
    @b(a = "lng")
    private String mLongitude;
    @b(a = "priority")
    private int mPriority;
    @b(a = "provider_location_id")
    private String mProviderLocationId;
    private double mSelectedLatitude;
    private double mSelectedLongitude;
    @b(a = "status")
    private String mStatus;
    @b(a = "datetime")
    private String mTime;

    public String getmStatus() {
        return this.mStatus;
    }

    public void setmStatus(String str) {
        this.mStatus = str;
    }

    public boolean isFilterSelected() {
        return this.filterSelected;
    }

    public void setFilterSelected(boolean z) {
        this.filterSelected = z;
    }

    public String getLocationAddress() {
        return this.mLocationAddress;
    }

    public String getDistance() {
        return this.mDistance;
    }

    public void setDistance(String str) {
        this.mDistance = str;
    }

    public double getSelectedLatitude() {
        return this.mSelectedLatitude;
    }

    public void setSelectedLatitude(double d2) {
        this.mSelectedLatitude = d2;
    }

    public double getSelectedLongitude() {
        return this.mSelectedLongitude;
    }

    public void setSelectedLongitude(double d2) {
        this.mSelectedLongitude = d2;
    }

    public boolean getIsSelected() {
        return this.mIsSelected;
    }

    public void setIsSelected(boolean z) {
        this.mIsSelected = z;
    }

    public String getLatitude() {
        return this.mLatitude;
    }

    public void setLatitude(String str) {
        this.mLatitude = str;
    }

    public String getLongitude() {
        return this.mLongitude;
    }

    public void setLongitude(String str) {
        this.mLongitude = str;
    }

    public String getLandmark() {
        return this.landmark;
    }

    public String getProviderLocationId() {
        return this.mProviderLocationId;
    }

    public String getLocationName() {
        return this.mLocationName;
    }

    public String getTime() {
        return this.mTime;
    }

    public void setProviderLocationId(String str) {
        this.mProviderLocationId = str;
    }

    public void setLocationName(String str) {
        this.mLocationName = str;
    }

    public void setTime(String str) {
        this.mTime = str;
    }

    public void setBoardingDate(String str) {
        this.mBoardingDate = str;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public boolean getIsPopular() {
        return this.mIsPopular;
    }

    public String toString() {
        return "CJRLocation{mProviderLocationId='" + this.mProviderLocationId + '\'' + ", mLocationName='" + this.mLocationName + '\'' + ", mTime='" + this.mTime + '\'' + ", mBoardingDate='" + this.mBoardingDate + '\'' + ", landmark='" + this.landmark + '\'' + ", mLatitude='" + this.mLatitude + '\'' + ", mLocationAddress='" + this.mLocationAddress + '\'' + ", mStatus='" + this.mStatus + '\'' + ", mPriority=" + this.mPriority + ", mIsPopular=" + this.mIsPopular + ", filterSelected=" + this.filterSelected + ", mSelectedLatitude=" + this.mSelectedLatitude + ", mSelectedLongitude=" + this.mSelectedLongitude + ", mDistance='" + this.mDistance + '\'' + ", mIsSelected=" + this.mIsSelected + ", mLongitude='" + this.mLongitude + '\'' + '}';
    }

    public boolean equals(Object obj) {
        return this.mLocationName.equalsIgnoreCase(((CJRLocation) obj).getLocationName());
    }

    public int compareTo(CJRLocation cJRLocation) {
        if (getDistance() == null) {
            return 0;
        }
        if (getDistance() == null || cJRLocation.getDistance() == null) {
            return -1;
        }
        return Double.compare(Double.parseDouble(getDistance()), Double.parseDouble(cJRLocation.getDistance()));
    }
}
