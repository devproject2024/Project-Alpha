package com.travel.booking.model;

import android.content.Context;
import com.travel.booking.datamodel.BOOKING_TYPE;
import com.travel.booking.datamodel.BookingInfo;
import com.travel.booking.datamodel.CJRTravelBookingData;
import java.util.Date;
import java.util.List;
import kotlin.g.a.t;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.x;

final class CJRTravelBookingModel$Companion$formatAPIResponse$1 extends l implements t<BOOKING_TYPE, String, List<? extends BookingInfo>, String, String, String, x> {
    final /* synthetic */ Context $app;
    final /* synthetic */ List $formattedResponse;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CJRTravelBookingModel$Companion$formatAPIResponse$1(Context context, List list) {
        super(6);
        this.$app = context;
        this.$formattedResponse = list;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        invoke((BOOKING_TYPE) obj, (String) obj2, (List<BookingInfo>) (List) obj3, (String) obj4, (String) obj5, (String) obj6);
        return x.f47997a;
    }

    public final void invoke(BOOKING_TYPE booking_type, String str, List<BookingInfo> list, String str2, String str3, String str4) {
        k.c(booking_type, "bookingType");
        k.c(list, "list");
        k.c(str2, "noDataHeader");
        k.c(str3, "noDataSubHeader");
        k.c(str4, "url");
        CJRTravelBookingModel.Companion.setCurrentdate(new Date(System.currentTimeMillis()));
        CharSequence charSequence = str;
        if (!(charSequence == null || p.a(charSequence))) {
            for (BookingInfo access$formatBookingInfo : list) {
                CJRTravelBookingModel.Companion.formatBookingInfo(this.$app, access$formatBookingInfo, booking_type);
            }
            this.$formattedResponse.add(new CJRTravelBookingData(booking_type, str, list, str2, str3, str4));
        }
    }
}
