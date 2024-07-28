package net.one97.paytm.moneytransfer.view.fragments;

import net.one97.paytm.moneytransfer.model.d;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;

public final /* synthetic */ class k {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f54505a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f54506b;

    static {
        int[] iArr = new int[UpiProfileDefaultBank.PAYMENT_MODE.values().length];
        f54505a = iArr;
        iArr[UpiProfileDefaultBank.PAYMENT_MODE.UPI.ordinal()] = 1;
        f54505a[UpiProfileDefaultBank.PAYMENT_MODE.IMPS.ordinal()] = 2;
        int[] iArr2 = new int[d.values().length];
        f54506b = iArr2;
        iArr2[d.LOADING.ordinal()] = 1;
        f54506b[d.SUCCESS.ordinal()] = 2;
        f54506b[d.ERROR.ordinal()] = 3;
        f54506b[d.ABORTED.ordinal()] = 4;
    }
}
