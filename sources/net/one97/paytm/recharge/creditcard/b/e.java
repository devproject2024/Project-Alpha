package net.one97.paytm.recharge.creditcard.b;

import net.one97.paytm.recharge.model.v4.DataState;

public final /* synthetic */ class e {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f62457a;

    static {
        int[] iArr = new int[DataState.values().length];
        f62457a = iArr;
        iArr[DataState.LOADING.ordinal()] = 1;
        f62457a[DataState.SUCCESS.ordinal()] = 2;
        f62457a[DataState.ERROR.ordinal()] = 3;
    }
}
