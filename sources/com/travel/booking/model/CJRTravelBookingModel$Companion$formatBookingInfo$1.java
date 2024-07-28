package com.travel.booking.model;

import com.travel.booking.datamodel.BookingInfo;
import java.text.DateFormat;
import java.util.TimeZone;
import kotlin.g.a.q;
import kotlin.g.b.k;
import kotlin.g.b.l;

final class CJRTravelBookingModel$Companion$formatBookingInfo$1 extends l implements q<String, DateFormat, DateFormat, String> {
    final /* synthetic */ BookingInfo $bookingInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CJRTravelBookingModel$Companion$formatBookingInfo$1(BookingInfo bookingInfo) {
        super(3);
        this.$bookingInfo = bookingInfo;
    }

    public final String invoke(String str, DateFormat dateFormat, DateFormat dateFormat2) {
        k.c(dateFormat, "inputDateFormat");
        k.c(dateFormat2, "outputDateFormat");
        try {
            if (this.$bookingInfo.isHotelBooking()) {
                dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                dateFormat2.setTimeZone(TimeZone.getDefault());
            } else {
                dateFormat.setTimeZone(TimeZone.getDefault());
                dateFormat2.setTimeZone(TimeZone.getDefault());
            }
            return dateFormat2.format(dateFormat.parse(str));
        } catch (Exception unused) {
            return str;
        }
    }
}
