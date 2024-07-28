package net.one97.paytm.upi.mandate.a;

import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.mandate.data.a;

public final /* synthetic */ class c {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f67032a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f67033b;

    static {
        int[] iArr = new int[a.b.values().length];
        f67032a = iArr;
        iArr[a.b.SUCCESS.ordinal()] = 1;
        f67032a[a.b.ERROR.ordinal()] = 2;
        f67032a[a.b.LOADING.ordinal()] = 3;
        int[] iArr2 = new int[UpiProfileDefaultBank.PAYMENT_MODE.values().length];
        f67033b = iArr2;
        iArr2[UpiProfileDefaultBank.PAYMENT_MODE.UPI.ordinal()] = 1;
        f67033b[UpiProfileDefaultBank.PAYMENT_MODE.IMPS.ordinal()] = 2;
    }
}
