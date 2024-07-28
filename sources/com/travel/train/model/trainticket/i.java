package com.travel.train.model.trainticket;

import java.io.Serializable;

public final class i implements Serializable {
    private static final long serialVersionUID = 1;
    private int mOrderBy;
    private String mOrderByFlight;
    private String mSortBy;
    private String mSortByFlight;
    private String mTitle;

    public final String getOrderByTrain() {
        return this.mOrderByFlight;
    }

    public final void setOrderByTrain(String str) {
        this.mOrderByFlight = str;
    }

    public final String getSortByTrain() {
        return this.mSortByFlight;
    }

    public final void setSortByTrain(String str) {
        this.mSortByFlight = str;
    }

    public final String getTitle() {
        return this.mTitle;
    }

    public final void setTitle(String str) {
        this.mTitle = str;
    }

    public final String getSortBy() {
        return this.mSortBy;
    }

    public final int getOrderBy() {
        return this.mOrderBy;
    }
}
