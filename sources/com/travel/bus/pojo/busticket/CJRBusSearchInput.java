package com.travel.bus.pojo.busticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusSearchInput implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private boolean isDealApplicable = true;
    private int mCount = -1;
    private String mDate = null;
    private CJRBusOriginCityItem mDestination = null;
    private int mOrderBy = -1;
    private String mSortBy = null;
    private CJRBusOriginCityItem mSource = null;

    public CJRBusSearchInput() {
    }

    public CJRBusSearchInput(CJRBusSearchInput cJRBusSearchInput) {
        if (cJRBusSearchInput != null) {
            this.mSource = cJRBusSearchInput.getSource();
            this.mDestination = cJRBusSearchInput.getDestination();
            this.mDate = cJRBusSearchInput.getDate();
            this.mCount = cJRBusSearchInput.getCount();
            this.mSortBy = cJRBusSearchInput.getSortBy();
            this.mOrderBy = cJRBusSearchInput.getOrderBy();
        }
    }

    public CJRBusOriginCityItem getSource() {
        return this.mSource;
    }

    public CJRBusOriginCityItem getDestination() {
        return this.mDestination;
    }

    public String getDate() {
        return this.mDate;
    }

    public boolean isDealApplicable() {
        return this.isDealApplicable;
    }

    public int getCount() {
        return this.mCount;
    }

    public String getSortBy() {
        return this.mSortBy;
    }

    public int getOrderBy() {
        return this.mOrderBy;
    }

    public void setSource(CJRBusOriginCityItem cJRBusOriginCityItem) {
        this.mSource = cJRBusOriginCityItem;
    }

    public void setDestination(CJRBusOriginCityItem cJRBusOriginCityItem) {
        this.mDestination = cJRBusOriginCityItem;
    }

    public void setDate(String str) {
        this.mDate = str;
    }

    public void setCount(int i2) {
        this.mCount = i2;
    }

    public void setSortBy(String str) {
        this.mSortBy = str;
    }

    public void setOrderBy(int i2) {
        this.mOrderBy = i2;
    }
}
