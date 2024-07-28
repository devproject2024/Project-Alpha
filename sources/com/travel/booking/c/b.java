package com.travel.booking.c;

import com.travel.booking.datamodel.BOOKING_TYPE;

public final /* synthetic */ class b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f21476a;

    static {
        int[] iArr = new int[BOOKING_TYPE.values().length];
        f21476a = iArr;
        iArr[BOOKING_TYPE.BOOKING_TYPE_UPCOMING.ordinal()] = 1;
        f21476a[BOOKING_TYPE.BOOKING_TYPE_COMPLETED.ordinal()] = 2;
        f21476a[BOOKING_TYPE.BOOKING_TYPE_CANCELLED.ordinal()] = 3;
    }
}
