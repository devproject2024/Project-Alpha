package net.one97.paytm.recharge.creditcard.v4.c;

import net.one97.paytm.recharge.model.v4.DataState;

public final /* synthetic */ class d {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f62623a;

    static {
        int[] iArr = new int[DataState.values().length];
        f62623a = iArr;
        iArr[DataState.LOADING.ordinal()] = 1;
        f62623a[DataState.SUCCESS.ordinal()] = 2;
        f62623a[DataState.ERROR.ordinal()] = 3;
    }
}
