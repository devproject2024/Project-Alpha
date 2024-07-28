package com.travel.booking.datamodel;

import java.util.List;

public final class HotelBookingInfo {
    private String hotelName;
    private List<String> roomTypes;
    private Integer stayDurationDays;

    public final String getHotelName() {
        return this.hotelName;
    }

    public final void setHotelName(String str) {
        this.hotelName = str;
    }

    public final Integer getStayDurationDays() {
        return this.stayDurationDays;
    }

    public final void setStayDurationDays(Integer num) {
        this.stayDurationDays = num;
    }

    public final List<String> getRoomTypes() {
        return this.roomTypes;
    }

    public final void setRoomTypes(List<String> list) {
        this.roomTypes = list;
    }

    public final String getNumberOfNights() {
        Integer num = this.stayDurationDays;
        String str = "";
        if (num == null) {
            return str;
        }
        int intValue = num.intValue();
        if (intValue > 0) {
            str = intValue < 2 ? " Night" : " Nights";
        }
        return String.valueOf(this.stayDurationDays) + str;
    }
}
