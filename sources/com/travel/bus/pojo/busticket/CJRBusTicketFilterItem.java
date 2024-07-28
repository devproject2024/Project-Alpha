package com.travel.bus.pojo.busticket;

import com.paytm.utility.q;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusTicketFilterItem implements IJRDataModel {
    private static final String LOG_TAG = "CJRBusTicketFilterItem";
    private static final long serialVersionUID = 1;
    private e filterCategory;
    private boolean isBPDP;
    private boolean isToggleChecked;
    private String mAmenityId;
    private String mDisplayValue;
    private String mFilterValue;
    private float mMaxValue = -1.0f;
    private float mMinValue = -1.0f;
    private String mOperatorId;
    private String mOperatorTagId;
    private String mTimeMaxValue;
    private String mTimeMinValue;
    private String mTitle;
    private String mType;

    public String getOperatorTagId() {
        return this.mOperatorTagId;
    }

    public void setOperatorTagId(String str) {
        this.mOperatorTagId = str;
    }

    public String getmAmenityId() {
        return this.mAmenityId;
    }

    public void setmAmenityId(String str) {
        this.mAmenityId = str;
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

    public float getMaxValue() {
        return this.mMaxValue;
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

    public boolean equals(Object obj) {
        try {
            CJRBusTicketFilterItem cJRBusTicketFilterItem = (CJRBusTicketFilterItem) obj;
            if (getTitle() == null || cJRBusTicketFilterItem.getTitle() == null || !getTitle().equalsIgnoreCase(cJRBusTicketFilterItem.getTitle())) {
                return false;
            }
            if (getFilterValue() == null || cJRBusTicketFilterItem.getFilterValue() == null) {
                if (getFilterValue() == null && cJRBusTicketFilterItem.getFilterValue() == null) {
                    return true;
                }
                return false;
            } else if (getFilterValue().equalsIgnoreCase(cJRBusTicketFilterItem.getFilterValue())) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return false;
        }
    }

    public e getFilterCategory() {
        return this.filterCategory;
    }

    public void setFilterCategory(e eVar) {
        this.filterCategory = eVar;
    }

    public void setOperatorId(String str) {
        this.mOperatorId = str;
    }

    public boolean isBPDP() {
        return this.isBPDP;
    }

    public void setBPDP(boolean z) {
        this.isBPDP = z;
    }

    public String toString() {
        return "CJRBusTicketFilterItem{mTitle='" + this.mTitle + '\'' + ", mType='" + this.mType + '\'' + ", mDisplayValue='" + this.mDisplayValue + '\'' + ", mFilterValue='" + this.mFilterValue + '\'' + ", isToggleChecked=" + this.isToggleChecked + ", mMinValue=" + this.mMinValue + ", mMaxValue=" + this.mMaxValue + ", mTimeMinValue='" + this.mTimeMinValue + '\'' + ", mTimeMaxValue='" + this.mTimeMaxValue + '\'' + ", mAmenityId='" + this.mAmenityId + '\'' + ", mOperatorTagId='" + this.mOperatorTagId + '\'' + ", mOperatorId='" + this.mOperatorId + '\'' + ", isBPDP=" + this.isBPDP + ", filterCategory=" + this.filterCategory + '}';
    }
}
