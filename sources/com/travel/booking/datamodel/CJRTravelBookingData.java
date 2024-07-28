package com.travel.booking.datamodel;

import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRTravelBookingData {
    private final List<BookingInfo> bookingList;
    private final BOOKING_TYPE bookingType;
    private String headerText;
    private final String noDataHeader;
    private final String noDataSubHeader;
    private String url;

    public CJRTravelBookingData(BOOKING_TYPE booking_type, String str, List<BookingInfo> list, String str2, String str3, String str4) {
        k.c(booking_type, "bookingType");
        k.c(str2, "noDataHeader");
        k.c(str3, "noDataSubHeader");
        this.bookingType = booking_type;
        this.headerText = str;
        this.bookingList = list;
        this.noDataHeader = str2;
        this.noDataSubHeader = str3;
        this.url = str4;
    }

    public final BOOKING_TYPE getBookingType() {
        return this.bookingType;
    }

    public final String getHeaderText() {
        return this.headerText;
    }

    public final void setHeaderText(String str) {
        this.headerText = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRTravelBookingData(BOOKING_TYPE booking_type, String str, List list, String str2, String str3, String str4, int i2, g gVar) {
        this(booking_type, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : list, str2, str3, str4);
    }

    public final List<BookingInfo> getBookingList() {
        return this.bookingList;
    }

    public final String getNoDataHeader() {
        return this.noDataHeader;
    }

    public final String getNoDataSubHeader() {
        return this.noDataSubHeader;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final boolean isEmptyList() {
        List<BookingInfo> list = this.bookingList;
        return list == null || list.isEmpty();
    }
}
