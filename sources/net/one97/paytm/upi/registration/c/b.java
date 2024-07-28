package net.one97.paytm.upi.registration.c;

import net.one97.paytm.upi.util.UpiConstants;

public final /* synthetic */ class b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f68533a;

    static {
        int[] iArr = new int[UpiConstants.UpiVpaValidationError.values().length];
        f68533a = iArr;
        iArr[UpiConstants.UpiVpaValidationError.MAX_LENGTH_BREACH.ordinal()] = 1;
        f68533a[UpiConstants.UpiVpaValidationError.INVALID_CHARS.ordinal()] = 2;
        f68533a[UpiConstants.UpiVpaValidationError.EMPTY_VPA.ordinal()] = 3;
        f68533a[UpiConstants.UpiVpaValidationError.ALPHANUMERIC_ERROR.ordinal()] = 4;
    }
}
