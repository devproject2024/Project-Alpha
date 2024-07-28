package net.one97.paytm.contacts.utils;

import net.one97.paytm.contacts.utils.e;

public final /* synthetic */ class d {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f50260a;

    static {
        int[] iArr = new int[e.h.values().length];
        f50260a = iArr;
        iArr[e.h.BENEFICIARY_HEALTH_DONE.ordinal()] = 1;
        f50260a[e.h.NONE.ordinal()] = 2;
        f50260a[e.h.LOCAL_DB_SYNC_DONE.ordinal()] = 3;
        f50260a[e.h.TRANSFER_BEN_CALL_DONE.ordinal()] = 4;
        f50260a[e.h.CONTACT_UPLOAD_CALL_DONE.ordinal()] = 5;
        f50260a[e.h.CONTACT_DELETE_CALL_DONE.ordinal()] = 6;
        f50260a[e.h.GET_PHONE_BOOK_CALL_DONE.ordinal()] = 7;
        f50260a[e.h.ABORT.ordinal()] = 8;
    }
}
