package net.one97.paytmflight.common.entity.hotels;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRHotelSearchInput implements IJRDataModel {
    private String mCheckInDate;
    private String mCheckOutDate;
    private String mFieldsEnteredDate;

    public String getCheckInDate() {
        return this.mCheckInDate;
    }

    public String getCheckOutDate() {
        return this.mCheckOutDate;
    }

    public void setCheckInDate(String str) {
        this.mCheckInDate = str;
    }

    public void setCheckOutDate(String str) {
        this.mCheckOutDate = str;
    }

    public void setFieldsEnteredDate(String str) {
        this.mFieldsEnteredDate = str;
    }

    public String getFieldsEnteredDate() {
        return this.mFieldsEnteredDate;
    }

    public CJRHotelSearchInput() {
    }

    public CJRHotelSearchInput(CJRHotelSearchInput cJRHotelSearchInput) {
        if (cJRHotelSearchInput != null) {
            this.mCheckInDate = cJRHotelSearchInput.getCheckInDate();
            this.mCheckOutDate = cJRHotelSearchInput.getCheckOutDate();
            this.mFieldsEnteredDate = cJRHotelSearchInput.getFieldsEnteredDate();
        }
    }
}
