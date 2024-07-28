package com.travel.booking.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.l;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

final class CJRTravelBookingModel$Companion$formatBookingInfo$2 extends l implements m<String, String, Date> {
    public static final CJRTravelBookingModel$Companion$formatBookingInfo$2 INSTANCE = new CJRTravelBookingModel$Companion$formatBookingInfo$2();

    CJRTravelBookingModel$Companion$formatBookingInfo$2() {
        super(2);
    }

    public final Date invoke(String str, String str2) {
        k.c(str2, "baseformat");
        Date parse = new SimpleDateFormat(str2).parse(str);
        k.a((Object) parse, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        return parse;
    }
}
