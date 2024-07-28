package com.travel.flight.pojo.flightticket;

import com.paytm.utility.q;
import com.travel.flight.pojo.flightticket.flighthomepage.CJRFlightHomepageRequestFilterResponse;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightTicketFilterItem implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private boolean isChanged;
    private boolean isInternational;
    private boolean isRoundTrip = false;
    private boolean isToggleChecked;
    private String mDisplayValue;
    private String mFilterValue;
    private String mFormattedTypeValue;
    private long mMaxPrice = -1;
    private long mMaxTime = -1;
    private float mMaxValue = -1.0f;
    private long mMinPrice = -1;
    private long mMinTime = -1;
    private float mMinValue = -1.0f;
    private String mTimeMaxValue;
    private String mTimeMinValue;
    private String mTitle;
    private String mType;
    private CJRFlightHomepageRequestFilterResponse.IJROnward stopOption;

    public boolean isInternational() {
        return this.isInternational;
    }

    public void setInternational(boolean z) {
        this.isInternational = z;
    }

    public boolean isRoundTrip() {
        return this.isRoundTrip;
    }

    public void setRoundTrip(boolean z) {
        this.isRoundTrip = z;
    }

    public String getFormattedTypeValue() {
        return this.mFormattedTypeValue;
    }

    public void setFormattedTypeValue(String str) {
        this.mFormattedTypeValue = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getDisplayValue() {
        return this.mDisplayValue;
    }

    public void setDisplayValue(String str) {
        this.mDisplayValue = str;
    }

    public String getFilterValue() {
        return this.mFilterValue;
    }

    public void setFilterValue(String str) {
        this.mFilterValue = str;
    }

    public boolean isToggleChecked() {
        return this.isToggleChecked;
    }

    public void setToggleChecked(boolean z) {
        this.isToggleChecked = z;
    }

    public float getMinvalue() {
        return this.mMinValue;
    }

    public void setMinvalue(float f2) {
        this.mMinValue = f2;
    }

    public float getMaxValue() {
        return this.mMaxValue;
    }

    public void setMaxValue(float f2) {
        this.mMaxValue = f2;
    }

    public String getTimeMinValue() {
        return this.mTimeMinValue;
    }

    public void setTimeMinValue(String str) {
        this.mTimeMinValue = str;
    }

    public String getTimeMaxValue() {
        return this.mTimeMaxValue;
    }

    public void setTimeMaxValue(String str) {
        this.mTimeMaxValue = str;
    }

    public long getmMinTime() {
        return this.mMinTime;
    }

    public void setmMinTime(long j) {
        this.mMinTime = j;
    }

    public long getmMaxTime() {
        return this.mMaxTime;
    }

    public void setmMaxTime(long j) {
        this.mMaxTime = j;
    }

    public long getMinPrice() {
        return this.mMinPrice;
    }

    public void setMinPrice(long j) {
        this.mMinPrice = j;
    }

    public long getMaxPrice() {
        return this.mMaxPrice;
    }

    public void setMaxPrice(long j) {
        this.mMaxPrice = j;
    }

    public boolean equals(Object obj) {
        try {
            CJRFlightTicketFilterItem cJRFlightTicketFilterItem = (CJRFlightTicketFilterItem) obj;
            if (getTitle() == null || cJRFlightTicketFilterItem.getTitle() == null || !getTitle().equalsIgnoreCase(cJRFlightTicketFilterItem.getTitle())) {
                return false;
            }
            if (getFilterValue() == null || cJRFlightTicketFilterItem.getFilterValue() == null) {
                if (getFilterValue() == null && cJRFlightTicketFilterItem.getFilterValue() == null) {
                    return true;
                }
                return false;
            } else if (getFilterValue().equalsIgnoreCase(cJRFlightTicketFilterItem.getFilterValue())) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return false;
        }
    }

    public CJRFlightHomepageRequestFilterResponse.IJROnward getStopOption() {
        return this.stopOption;
    }

    public void setStopOption(CJRFlightHomepageRequestFilterResponse.IJROnward iJROnward) {
        this.stopOption = iJROnward;
    }

    public boolean isChanged() {
        return this.isChanged;
    }

    public void setChanged(boolean z) {
        this.isChanged = z;
    }
}
